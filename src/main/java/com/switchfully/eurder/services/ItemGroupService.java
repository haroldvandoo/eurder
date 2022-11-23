package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.ItemGroup;
import com.switchfully.eurder.domain.dto.ItemGroupDto.CreateItemGroupDto;
import com.switchfully.eurder.domain.dto.ItemGroupDto.ItemGroupMapper;
import com.switchfully.eurder.exceptions.all.NonExistingItemIdException;
import com.switchfully.eurder.repositories.ItemGroupRepository;
import com.switchfully.eurder.repositories.ItemRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ItemGroupService {
    int OUT_OF_STOCK_DAYS = 7;
    int IN_STOCK_DAYS = 1;

    ItemRepository itemRepository;
    ItemGroupMapper itemGroupMapper;
    ItemGroupRepository itemGroupRepository;

    public ItemGroupService(ItemRepository itemRepository,  ItemGroupRepository itemGroupRepository) {
        this.itemRepository = itemRepository;
        this.itemGroupMapper = new ItemGroupMapper();
        this.itemGroupRepository = itemGroupRepository;
    }

    public LocalDate calculateShippingDate(CreateItemGroupDto createItemGroupDto) {
        if (itemRepository.findById(createItemGroupDto.getItemId()).orElseThrow().getAmount() - createItemGroupDto.getAmount() < 0) {
            return LocalDate.now().plusDays(OUT_OF_STOCK_DAYS);
        }
        return LocalDate.now().plusDays(IN_STOCK_DAYS);
    }

    public double createItemGroupList(List<CreateItemGroupDto> createItemGroupDtos, Long OrderId) {
        double totalPrice = 0;
        for (CreateItemGroupDto createItemGroupDto: createItemGroupDtos){
            validateItemId(createItemGroupDto);

            LocalDate shippingDate = calculateShippingDate(createItemGroupDto);
            double price = calculatePriceOfItemSum(createItemGroupDto);

            ItemGroup itemGroup = itemGroupMapper.createIGDtoIG(createItemGroupDto);
            itemGroup.setShippingDate(shippingDate);
            itemGroup.setPrice(price);
            itemGroup.setOrderId(OrderId);
            totalPrice += price;

            itemRepository.findById(createItemGroupDto.getItemId()).orElseThrow().substractAmount(createItemGroupDto.getAmount());

            itemGroupRepository.save(itemGroup);
            //return itemGroupMapper.itemGroupToDto(itemGroup);
        }
        return totalPrice;
    }

    private void validateItemId(CreateItemGroupDto createItemGroupDto) {
        if (itemRepository.findById(createItemGroupDto.getItemId()).orElseThrow() == null) {
            throw new NonExistingItemIdException();
        }
    }

    public double calculatePriceOfItemSum(CreateItemGroupDto createItemGroupDto) {
        double pricePerItem = itemRepository.findById(createItemGroupDto.getItemId()).orElseThrow().getPrice();
        return (createItemGroupDto.getAmount() * pricePerItem);
    }

    public double calculatePriceOfAllItems(List<CreateItemGroupDto> createItemGroupDtos) {
        double priceToReturn = 0;
        for (CreateItemGroupDto createItemGroupDto: createItemGroupDtos) {
            double singleItemGroupPrice = calculatePriceOfItemSum(createItemGroupDto);
            priceToReturn += singleItemGroupPrice;
        }
        return priceToReturn;
    }
}

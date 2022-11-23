package com.switchfully.eurder.domain.dto.ItemGroupDto;



public class CreateItemGroupDto {

    private Long itemId;
    private int amount;

    public CreateItemGroupDto(Long itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }
}

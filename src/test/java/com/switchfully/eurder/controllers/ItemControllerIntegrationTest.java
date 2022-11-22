package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.dto.itemdto.ItemDto;
import com.switchfully.eurder.repositories.ItemRepository;
import com.switchfully.eurder.services.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ItemController itemController;

    @Autowired
    private ItemService itemService;


    @Test
    void addItemToTheDatabaseAsRegisteredAdmin_HappyPath() {
        //given
        ItemDto itemDtoDummy = new ItemDto("1","chair", "scandinavian", 350, 12);
        Item item = new Item(itemDtoDummy.getName(), itemDtoDummy.getDescription(), itemDtoDummy.getPrice(), itemDtoDummy.getAmount());
        item.setId("1");
        //when
        ItemDto itemDto = itemController.addItemToTheDatabase("Basic MDI0NTY3ODkxMjA6cGFzc3dvcmQ=", itemDtoDummy);
        String id = itemDto.getId();
        //then
        assertTrue(itemService.getItemRepository().getItemDatabase().values().stream().filter(object -> object.getName().equals("chair")).findFirst().orElseThrow().getName().equals("chair"));
    }

}

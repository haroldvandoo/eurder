package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.dto.itemdto.ItemDto;
import com.switchfully.eurder.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ItemService itemService;
    //SecurityService securityService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
        //this.securityService = new SecurityService();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto addItemToTheDatabase(@RequestHeader String authorization, @RequestBody ItemDto itemDto) {
        log.info("created the following item: " + itemDto);
        //securityService.validateAuthorization(authorization, Feature.CREATE_ITEM);
        return itemService.addItem(itemDto);
    }

}

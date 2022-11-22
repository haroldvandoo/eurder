package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

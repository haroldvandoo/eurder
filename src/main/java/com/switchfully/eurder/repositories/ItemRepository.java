package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    int findAmountById(Long itemId);

}

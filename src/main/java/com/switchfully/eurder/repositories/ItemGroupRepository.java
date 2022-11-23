package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.ItemGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemGroupRepository extends JpaRepository<ItemGroup, Long> {

}

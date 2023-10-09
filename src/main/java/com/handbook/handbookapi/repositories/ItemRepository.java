package com.handbook.handbookapi.repositories;

import com.handbook.handbookapi.model.item.Item;
import com.handbook.handbookapi.utils.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, CustomQuerydslPredicateExecutor<Item> {
}

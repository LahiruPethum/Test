package com.SpringBootTest.test.repo;

import com.SpringBootTest.test.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Integer> {

}

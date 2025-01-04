package com.madurai.fishApp.Repository;

import com.madurai.fishApp.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer> {
}

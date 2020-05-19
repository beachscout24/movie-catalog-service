package com.bridgwater.repository;

import com.bridgwater.models.CatalogItem;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<CatalogItem, Integer> {
}

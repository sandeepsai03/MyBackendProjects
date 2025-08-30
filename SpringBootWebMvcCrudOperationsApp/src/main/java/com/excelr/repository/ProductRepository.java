package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.entity.Product;

///here Integer is primary key datatype
public interface ProductRepository extends JpaRepository<Product,Integer>{

}

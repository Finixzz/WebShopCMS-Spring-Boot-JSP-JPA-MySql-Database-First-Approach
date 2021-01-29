package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.domain.Category;

@Repository
@RequestScope
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}

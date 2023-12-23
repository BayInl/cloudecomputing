package org.cc.cloudecomputing.dao;

import org.cc.cloudecomputing.entity.Category;
import org.cc.cloudecomputing.entity.MultiPK.CategoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, CategoryPK> {
    Category findByMainAndDetail(String MainCategory, String SubCategory);
    List<Category> findAllByMain(String MainCategory);
    List<Category> findAllByDetail(String SubCategory);
    @Query(value = "select distinct main from category", nativeQuery = true)
    List<String> queryAllMains();

    List<Category> findAll();
}

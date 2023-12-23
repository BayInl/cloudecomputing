package org.cc.cloudecomputing.service.Impl;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.dao.CategoryDao;
import org.cc.cloudecomputing.entity.Category;
import org.cc.cloudecomputing.service.CategoryService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryDao categoryDao;
    @Override
    public Result<?> getCategories() {
        return Result.success(categoryDao.findAll());
    }

    @Override
    public Result<?> addCategory(String MainCategory, String SubCategory) {
        Category category = categoryDao.findByMainAndDetail(MainCategory, SubCategory);
        if (category != null) {
            return Result.error(400, "Category already exists");
        }
        category = new Category();
        category.setMain(MainCategory);
        category.setDetail(SubCategory);
        category=categoryDao.save(category);
        return Result.success("add category success",category);
    }

    @Override
    public Result<?> getMainCategories() {
        List<String> mainCategories = categoryDao.queryAllMains();
        if(mainCategories==null||mainCategories.isEmpty()){
            return Result.error(404,"No main category");
        }
        return Result.success("get main category success",mainCategories);
    }

    @Override
    public Result<?> getSubCategories(String MainCategory) {
        return null;
    }

    @Override
    public Result<?> deleteCategory(String MainCategory, String SubCategory) {
        return null;
    }

    @Override
    public Result<?> updateCategory(String MainCategory, String SubCategory, String newMainCategory, String newSubCategory) {
        return null;
    }
}

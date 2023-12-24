package org.cc.cloudecomputing.service.Impl;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.cc.cloudecomputing.dao.CategoryDao;
import org.cc.cloudecomputing.dao.GoodDao;
import org.cc.cloudecomputing.entity.Category;
import org.cc.cloudecomputing.service.CategoryService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryDao categoryDao;
    @Resource
    private GoodDao goodDao;

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
        List<Category> subCategories = categoryDao.findAllByMain(MainCategory);
        if(subCategories==null||subCategories.isEmpty()){
            return Result.error(404,"No sub category");
        }
        return Result.success("get sub category success",subCategories.stream().map(Category::getDetail).toList());
    }

    @Override
    public Result<?> deleteCategory(String MainCategory, String SubCategory) {
        Category category = categoryDao.findByMainAndDetail(MainCategory, SubCategory);
        if (category == null) {
            return Result.error(404, "Category not found");
        }
        categoryDao.delete(category);
        return Result.success("delete category success");
    }

    @Override
    @Transactional
    public Result<?> updateCategory(String MainCategory, String SubCategory, String newMainCategory, String newSubCategory) {
        Category category = categoryDao.findByMainAndDetail(MainCategory, SubCategory);
        if (category == null) {
            return Result.error(404, "Category not found");
        }
        category.setMain(newMainCategory);
        category.setDetail(newSubCategory);
        categoryDao.save(category);
        return Result.success("update category success");
    }
}

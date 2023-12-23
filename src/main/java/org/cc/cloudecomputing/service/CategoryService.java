package org.cc.cloudecomputing.service;

import org.cc.cloudecomputing.util.Result;

public interface CategoryService {
    Result<?> getCategories();
    Result<?> addCategory(String MainCategory, String SubCategory);
    Result<?> getMainCategories();

    Result<?> getSubCategories(String MainCategory);

    Result<?> deleteCategory(String MainCategory, String SubCategory);

    Result<?> updateCategory(String MainCategory, String SubCategory, String newMainCategory, String newSubCategory);

}

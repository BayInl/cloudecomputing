package org.cc.cloudecomputing.controller;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.service.CategoryService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("")
    public Result<?> getCategories() {
        return categoryService.getCategories();
    }

    @PutMapping("")
    public Result<?> addCategory(@RequestParam String MainCategory,@RequestParam String SubCategory) {
        return categoryService.addCategory(MainCategory, SubCategory);
    }
    @DeleteMapping("")
    public Result<?> deleteCategory(@RequestParam String MainCategory,@RequestParam String SubCategory) {
        return categoryService.deleteCategory(MainCategory, SubCategory);
    }
    @GetMapping("/sub")
    public Result<?> getSubCategories(@RequestParam String MainCategory) {
        return categoryService.getSubCategories(MainCategory);
    }
    @GetMapping("/main")
    public Result<?> getMainCategories() {
        return categoryService.getMainCategories();
    }
}

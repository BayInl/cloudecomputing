package org.cc.cloudecomputing.controller;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.service.CategoryService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/getCategories")
    public Result<?> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping("/addCategory")
    public Result<?> addCategory(@RequestParam String MainCategory,@RequestParam String SubCategory) {
        return categoryService.addCategory(MainCategory, SubCategory);
    }
}

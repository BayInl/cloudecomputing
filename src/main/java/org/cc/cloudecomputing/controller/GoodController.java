package org.cc.cloudecomputing.controller;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.service.GoodService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/goods")
public class GoodController {
    @Resource
    private GoodService goodService;
    @GetMapping("")
    public Result<?> getGoods(@RequestParam Integer uid){
        return goodService.getGoods(uid);
    }
    @GetMapping("/all")
    public Result<?> getAllGoods(){
        return goodService.getAllGoods();
    }
    @GetMapping("/main")
    public Result<?> getGoodsByMain(@RequestParam String main){
        return goodService.getGoodsByMain(main);
    }
    @GetMapping("/main/detail")
    public Result<?> getGoodsByMainAndDetail(@RequestParam String main,@RequestParam String detail){
        return goodService.getGoodsByMainAndDetail(main,detail);
    }
    @PutMapping("")
    public Result<?> addGood(@RequestParam String name, @RequestParam Integer uid, @RequestParam Integer sales, @RequestParam Integer stockpile, @RequestParam String price, @RequestParam String img, @RequestParam String main,@RequestParam String detail){
        return goodService.addGood(name,uid,sales,stockpile, new BigDecimal(price),img,main,detail);
    }
    @DeleteMapping("")
    public Result<?> deleteGood(@RequestParam String name){
        return goodService.deleteGood(name);
    }
}

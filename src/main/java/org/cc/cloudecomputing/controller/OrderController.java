package org.cc.cloudecomputing.controller;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.service.OrdersService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Resource
    private OrdersService orderService;

    @GetMapping("")
    public Result<?> getOrders(@RequestParam Integer uid){
        return orderService.getOrders(uid);
    }
    @GetMapping("/name")
    public Result<?> getOrdersByName(@RequestParam String name){
        return orderService.getOrdersByName(name);
    }
    @GetMapping("/uid/name/date")
    public Result<?> getOrdersByUidAndNameAndDate(@RequestParam Integer uid,@RequestParam String name,@RequestParam Date date){
        return orderService.getOrdersByUidAndNameAndDate(uid,name,date);
    }
    @PutMapping("")
    public Result<?> addOrders(@RequestParam Integer uid,@RequestParam String name,@RequestParam String date,@RequestParam Integer quantity){
        return orderService.addOrders(uid,name,null,quantity);
    }
}

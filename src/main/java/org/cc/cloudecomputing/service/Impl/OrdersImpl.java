package org.cc.cloudecomputing.service.Impl;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.dao.GoodDao;
import org.cc.cloudecomputing.dao.OrdersDao;
import org.cc.cloudecomputing.entity.Good;
import org.cc.cloudecomputing.entity.Orders;
import org.cc.cloudecomputing.service.OrdersService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrdersImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private GoodDao goodDao;

    @Override
    public Result<?> getOrders(Integer uid) {
        List<Orders> ordersList = ordersDao.findAllByUid(uid);
        return Result.success("Get orders successfully", ordersList);
    }

    @Override
    public Result<?> getOrdersByName(String name) {
        List<Orders> ordersList = ordersDao.findAllByName(name);
        return Result.success("Get orders successfully", ordersList);
    }

    @Override
    public Result<?> getOrdersByUidAndNameAndDate(Integer uid, String name, Date date) {
        List<Orders> ordersList = ordersDao.findAllByUidAndNameAndDate(uid, name, date);
        return Result.success("Get orders successfully", ordersList);
    }

    @Override
    public Result<?> addOrders(Integer uid, String name, Date date, Integer quantity) {
        if(date==null){
            // 获取当前时间
            date = new Date();
        }
        Good good=goodDao.findByName(name);
        if(good==null){
            return Result.error(400,"This good does not exist");
        }
        if(quantity>good.getStockpile()){
            return Result.error(400,"The stockpile is not enough");
        }
        var orderss=ordersDao.findAllByUidAndNameAndDate(uid,name,date);
        if(orderss==null|| orderss.isEmpty()){
            Orders orders = new Orders(uid, name, date, quantity);
            orders=ordersDao.save(orders);
            good.setStockpile(good.getStockpile()-quantity);
            goodDao.save(good);
            System.out.println(orders);
            return Result.success("Add orders successfully", orders);
        }else{
            return Result.error(400,"This order already exists");
        }
    }
}

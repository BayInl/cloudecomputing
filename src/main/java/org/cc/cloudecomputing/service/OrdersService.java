package org.cc.cloudecomputing.service;

import org.cc.cloudecomputing.util.Result;
import java.util.Date;
public interface OrdersService {
    Result<?> getOrders(Integer uid);
    Result<?> getOrdersByName(String name);
    Result<?> getOrdersByUidAndNameAndDate(Integer uid, String name, Date date);
    Result<?> addOrders(Integer uid, String name, Date date, Integer quantity);
}

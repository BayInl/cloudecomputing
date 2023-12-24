package org.cc.cloudecomputing.dao;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrdersDao extends JpaRepository<Orders,Integer> {
    List<Orders> findAllByUidAndNameAndDate(Integer uid, String name, Date date);

    List<Orders> findAllByUid(Integer uid);

    List<Orders> findAllByName(String name);



}

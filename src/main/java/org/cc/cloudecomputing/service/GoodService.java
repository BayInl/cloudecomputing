package org.cc.cloudecomputing.service;

import org.cc.cloudecomputing.dto.GoodDTO;
import org.cc.cloudecomputing.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface GoodService {
    Result<?> addGood(String name, Integer uid, Integer sales, Integer stockpile, BigDecimal price, String img, String main,String detail);
    Result<?> getGoods(Integer uid);
    Result<?> addGood(GoodDTO goodDTO);
    Result<?>getGoodsByMain(String main);
    Result<?>getGoodsByMainAndDetail(String main, String detail);
    Result<?>getAllGoods();
    Result<?>deleteGood(String name);
    Result<?>getGoodsSails(String name);
}

package org.cc.cloudecomputing.service.Impl;

import jakarta.annotation.Resource;
import org.cc.cloudecomputing.dao.CategoryDao;
import org.cc.cloudecomputing.dao.GoodDao;
import org.cc.cloudecomputing.dto.GoodDTO;
import org.cc.cloudecomputing.entity.Category;
import org.cc.cloudecomputing.entity.Good;
import org.cc.cloudecomputing.service.GoodService;
import org.cc.cloudecomputing.util.Result;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodDao goodDao;
    @Resource
    private CategoryDao categoryDao;
    @Override
    public Result<?> addGood(String name, Integer uid, Integer sales, Integer stockpile, BigDecimal price, String img, String main,String detail) {
        if (goodDao.findByName(name) != null) {
            return Result.error(400, "Good already exists");
        }
        if(price==null||price.compareTo(BigDecimal.ZERO) < 0){
            return Result.error(400, "Price must be positive");
        }
        if(stockpile==null||stockpile < 0){
            return Result.error(400, "Stockpile must be positive");
        }
        if(sales==null||sales<0){
            sales=0;
        }
        if(main==null|| main.isEmpty()){
            return Result.error(400, "Main category cannot be empty");
        }
        if(detail==null|| detail.isEmpty()){
            return Result.error(400, "Detail category cannot be empty");
        }
        Category category=categoryDao.findByMainAndDetail(main,detail);
        if(category==null){
            return Result.error(400, "Category does not exist");
        }

        Good good = new Good();
        good.setName(name);
        good.setUid(uid);
        good.setSales(sales);
        good.setStockpile(stockpile);
        good.setPrice(price);
        good.setImg(img);
        good.setMain(main);
        good.setDetail(detail);
        good=goodDao.save(good);
        return Result.success("Add good successfully",good);
    }

    @Override
    public Result<?> getGoods(Integer uid) {
        if(uid==null){
            return Result.error(400, "Uid cannot be empty");
        }

        List<Good> goods=goodDao.findAllByUid(uid);
        return Result.success("Get goods successfully",goods);
    }

    @Override
    public Result<?> addGood(GoodDTO goodDTO) {
        return addGood(goodDTO.getName(),goodDTO.getUid(),goodDTO.getSales(),goodDTO.getStockpile(),goodDTO.getPrice(),goodDTO.getImg(),goodDTO.getMain(),goodDTO.getDetail());
    }

    @Override
    public Result<?> getGoodsByMain(String main) {
        List<Good> goods=goodDao.findAllByMain(main);
        return Result.success("Get goods successfully",goods);
    }

    @Override
    public Result<?> getGoodsByMainAndDetail(String main, String detail) {
        List<Good> goods=goodDao.findAllByMainAndDetail(main,detail);
        return Result.success("Get goods successfully",goods);
    }

    @Override
    public Result<?> getAllGoods() {
        List<Good> goods=goodDao.findAll();
        return Result.success("Get goods successfully",goods);
    }

    @Override
    public Result<?> deleteGood(String name) {
        Good good=goodDao.findByName(name);
        if(good==null){
            return Result.error(400, "Good does not exist");
        }
        goodDao.delete(good);
        return Result.success("Delete good successfully");
    }
}

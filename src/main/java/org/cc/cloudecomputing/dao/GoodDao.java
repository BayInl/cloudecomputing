package org.cc.cloudecomputing.dao;

import org.cc.cloudecomputing.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodDao extends JpaRepository<Good,String > {
    Good findByName(String name);
    List<Good> findAllByUid(Integer uid);

    List<Good> findAllByMain(String main);

    List<Good> findAllByMainAndDetail(String main, String detail);

    List<Good> findAll();

}

package com.example.bvs.repository;

import com.example.bvs.dao.RouterDao;
import com.example.bvs.entity.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RouterRepository {

    @Autowired
    private RouterDao dao;

    public Router getRouterAccount(String consumer) {
        return dao.findOneByConsumerName(consumer);
    }

}
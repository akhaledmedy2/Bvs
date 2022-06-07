package com.example.bvs.repository;

import com.example.bvs.dao.RouterDao;
import com.example.bvs.dto.RouterCreateDto;
import com.example.bvs.entity.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class RouterRepository {

    @Autowired
    private RouterDao dao;

    private static AtomicReference<Long> currentTime = new AtomicReference<>(System.currentTimeMillis());

    public Router createRouter(String accountName) {
        long globalAccountId = currentTime.accumulateAndGet(System.currentTimeMillis(), (prev, next) ->
                next > prev ? next : prev + 1);
        Router router = new Router();
        router.setAccountId(globalAccountId);
        router.setAccountName(accountName);
        router.setCreationDate(new Date());
        router.setUpdateDate(new Date());
        dao.save(router);
        return router;
    }

    public Router getRouterAccount(long accountId) {
        return dao.findOneByAccountId(accountId);
    }

}
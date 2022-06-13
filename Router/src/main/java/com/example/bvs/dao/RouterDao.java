package com.example.bvs.dao;

import com.example.bvs.entity.Router;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouterDao extends JpaRepository<Router,Long>{
    Router findOneByConsumerName(String consumer);
}
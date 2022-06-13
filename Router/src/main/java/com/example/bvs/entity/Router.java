package com.example.bvs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "router")
public class Router {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "queue_name")
    private String queueName;

    @Column(name = "consumer_name")
    private String consumerName;
}
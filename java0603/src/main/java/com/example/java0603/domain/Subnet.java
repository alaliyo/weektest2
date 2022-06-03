package com.example.java0603.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Getter
@NoArgsConstructor
@Entity
public class Subnet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String gateWay;

    @Column(nullable = false)
    private String subnet;

    public Subnet(RouteTable table) {
        this.gateWay = table.getGateWay();
        this.subnet = table.getGateWay();
    }

    public Subnet(InternetGateWay gateWay) {

    }

    }

}

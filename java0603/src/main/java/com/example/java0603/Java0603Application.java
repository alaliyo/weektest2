package com.example.java0603;

import com.example.java0603.domain.InternetGateWay;
import com.example.java0603.domain.RouteTable;
import com.example.java0603.domain.Subnet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java0603Application {

	public static void main(String[] args) {
		SpringApplication.run(Java0603Application.class, args);
	}
	Subnet subnet_a = new Subnet(1,"172.31.0.0/20","ap-northeast-2a");
	Subnet subnet_b = new Subnet(2,"172.31.16.0/20","ap-northeast-2b");
	Subnet subnet_c = new Subnet(3,"172.31.32.0/20","ap-northeast-2c");
	Subnet subnet_d = new Subnet(4,"172.31.48.0/20","ap-northeast-2d");

	GateWay internetGateWay = new InternetGateWay();
	//GateWay natGateWay = new NatGateWay(subnet_d); // infinity loop error
	GateWay natGateWay = new NatGateWay(subnet_a); // success
	RouteTable publicRouteTable = new RouteTable();
	RouteTable privateRouteTable = new RouteTable();

        publicRouteTable.setGateWay(internetGateWay);
        publicRouteTable.addSubnet(subnet_a);
        publicRouteTable.addSubnet(subnet_b);
        publicRouteTable.addSubnet(subnet_c);


        privateRouteTable.setGateWay(natGateWay);
        privateRouteTable.addSubnet(subnet_d);

        subnet_a.transfer("a send message!");
        subnet_d.transfer("d send message!");
}
}

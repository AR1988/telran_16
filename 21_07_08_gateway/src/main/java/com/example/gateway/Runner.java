package com.example.gateway;

import com.example.gateway.service.TcpOuterListener;
import com.example.gateway.service.UdpLoadBalancerListener;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

    private final UdpLoadBalancerListener udpLoadBalancerListener;
    private final TcpOuterListener tcpOuterListener;

    public Runner(UdpLoadBalancerListener udpLoadBalancerListener, TcpOuterListener tcpOuterListener) {
        this.udpLoadBalancerListener = udpLoadBalancerListener;
        this.tcpOuterListener = tcpOuterListener;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        tcpOuterListener.run();
        udpLoadBalancerListener.run();
    }
}

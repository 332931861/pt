/*
package com.haha.pt.config;


import org.apache.log4j.Logger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class ESConfig {
    private static final Logger LOGGER = Logger.getLogger(ESConfig.class);




    */
/**
     * elk集群地址
     *//*

    @Value("${es.ip}")
    private String ip;

    */
/**
     * 端口
     *//*

    @Value("${es.port}")
    private String port;

    */
/**
     * 集群名称
     *//*

    @Value("${es.cluster.name}")
    private String clusterName;

    */
/**
     * 连接池
     *//*

    @Value("${es.pool}")
    private String pool;

    */
/**
     * Bean name default  函数名字
     *
     * @return
     *//*

    @Bean(name = "transportClient")
    public TransportClient transportClient() {

        TransportClient transportClient = null;
        try {
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("cluster.name", clusterName) //集群名字
                    .put("client.transport.sniff", true)//增加嗅探机制，找到ES集群
                    .put("thread_pool.search.size", Integer.parseInt(pool))//增加线程池个数，暂时设为5
                    .build();
            //配置信息Settings自定义
            transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(ip), Integer.valueOf(port));
            transportClient.addTransportAddresses(transportAddress);
        } catch (Exception e) {
            LOGGER.error("elasticsearch TransportClient create error!!", e);
        }
        return transportClient;
    }


}
*/

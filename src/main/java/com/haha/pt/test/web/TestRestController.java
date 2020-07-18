package com.haha.pt.test.web;

import com.haha.pt.test.entity.Teacher;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;

@Controller
@RequestMapping("/testRest")
public class TestRestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        Map params = new HashMap();
        Teacher teacher = new Teacher();
        teacher.setName("zsdfasdf");
        params.put("name","zs");
        params.put("teacher1",teacher);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json; charset=UTF-8");
        HttpEntity entity = new HttpEntity<>(params, headers);
        String url = "http://localhost:8081/pt/test/tea?name={name}";
        System.out.println("to data service url:" + url);
        ResponseEntity<List<Teacher>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Teacher>>() {
        }, params);
        return "responseEntity.getBody().toString()";

    }


    public static void main(String[] args) {
        ExecutorService executorService = newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(10);
        try {

            for (int i = 0; i < 10; i++) {
                int finalI = i;
                executorService.execute(new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        Thread.sleep(2000);
                        System.out.print(new Date());
                        System.out.println(Thread.currentThread().getId()+"正在运行1"+"||    i值为"+String.valueOf(finalI));
                        latch.countDown();
                    }
                });
            }
            latch.await();
            System.out.println(Thread.currentThread().getId()+"正在运行2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getId()+"正在运行结束");
            executorService.shutdown();
        }
    }


}

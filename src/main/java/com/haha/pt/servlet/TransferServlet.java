package com.haha.pt.servlet;

import com.haha.pt.entity.Result;
import com.haha.pt.factory.BeanFactory;
import com.haha.pt.factory.ProxyFactory;
import com.haha.pt.service.TransferService;
import com.haha.pt.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "transferServlet",urlPatterns = "/transferServlet")
public class TransferServlet extends HttpServlet {

    private ProxyFactory proxyFactory = (ProxyFactory) BeanFactory.getBean("proxyFactory");
    private TransferService transferService = (TransferService) proxyFactory.getJdkProxy(BeanFactory.getBean("transferService")) ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fromCardNo = req.getParameter("fromCardNo");
        String toCardNo = req.getParameter("toCardNo");
        String moneyStr = req.getParameter("money");
        int money = Integer.parseInt(moneyStr);
        Result result =new Result();

        try {

            // 2. 调用service层方法
            transferService.transfer(fromCardNo,toCardNo,money);
            result.setStatus("200");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("201");
            result.setMessage(e.toString());
        }



        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(JsonUtils.object2Json(result));

    }
}

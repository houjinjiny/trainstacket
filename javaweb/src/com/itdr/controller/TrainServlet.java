package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.TrainService;
import com.itdr.service.impl.TrainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backed/train/*")
public class TrainServlet extends HttpServlet {
    private TrainService trainService=new TrainServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");
        switch (split[split.length-1]){
            //查询所有车次
            case "getall":
                getAllTrain(request,response);
                break;
                //查询指定车次
            case "fuzzysearch":
                fuzzySearch(request,response);
                break;
            case "todelete":
                toDelete(request,response);
                break;
            case "addtrains":
                addTrains(request,response);
                break;
        }
    }

    //查询所有车次
    private void getAllTrain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allTrain=trainService.getAllTrain();
        request.setAttribute("trainlist",allTrain);
        request.getRequestDispatcher("/WEB-INF/train.jsp").forward(request,response);
    }
    //查询指定车次
    private void fuzzySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key=request.getParameter("key");
        ResponseCode allTrain=trainService.fuzzySearch(key);
        request.setAttribute("trainlist",allTrain);
        request.getRequestDispatcher("/WEB-INF/train.jsp").forward(request,response);
    }
    //删除车次
    private void toDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        ResponseCode alltrain=trainService.toDelete(id);
        response.getWriter().write(alltrain.getData().toString());
    }
    //添加车次
    private void addTrains(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String train_number=request.getParameter("train_number");
        String train_type=request.getParameter("train_type");
        String start_station=request.getParameter("start_station");
        String last_station=request.getParameter("last_station");
        String start_time=request.getParameter("start_time");
        String last_time=request.getParameter("last_time");
        String seat_type=request.getParameter("seat_type");
        String price=request.getParameter("price");
        String inventory=request.getParameter("inventory");
        ResponseCode addtrains=trainService.addTrains(train_number,train_type,start_station,last_station,start_time,last_time,seat_type,price,inventory);
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
    }

}

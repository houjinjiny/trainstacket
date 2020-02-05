<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/1/31
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加车次</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .bottom #left{
            width: 15%;
            height: 100%;
            float: left;
            background-color: #F1F3F4;
            text-align: center;
        }
        #right{
            margin-top: -20px;
            width: 85%;
            height: 100%;
            float: right;
        }
        form{
            text-align: center;
            width: 100%;
            height: 100%;
            font-size: 18px;
        }
        form span{
            display: inline-block;
            width: 80px;
            text-align: justify;
        }
        input{
            height: 30px;
            margin-top: 30px;
        }
    </style>
</head>
<body>
<div class="wk">
    <div class="top">
        <jsp:include page="top.jsp"></jsp:include>
    </div>
    <div class="bottom">
        <div id="left">
            <jsp:include page="left.jsp"></jsp:include>
        </div>
        <div id="right">
            <form action="/backed/train/addtrains" method="post">
                <span>车次</span><input type="text" placeholder="车次" name="train_number"><br>
                <span>火车类型</span><input type="text" placeholder="火车类型" name="train_type"><br>
                <span>始发站</span><input type="text" placeholder="始发站" name="start_station"><br>
                <span>终点站</span><input type="text" placeholder="终点站" name="last_station"><br>
                <span>发车时间</span><input type="datetime-local" placeholder="发车时间" name="start_time"><br>
                <span>到达时间</span><input type="datetime-local" placeholder="到达时间" name="last_time"><br>
                <span>座位类型</span><input type="text" placeholder="座位类型" name="seat_type"><br>
                <span>票价</span><input type="text" placeholder="票价" name="price"><br>
                <span>剩余票数</span><input type="text" placeholder="剩余票数" name="inventory"><br>
                <input type="submit" value="添加">
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/1/31
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
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
        #right form{
            height: 50px;
            width: 100%;
            line-height: 50px;
            text-align: center;
            font-size: 18px;
        }
        #right form input{
            height: 30px;
        }
        #put1{
            width: 50px;
        }
        table{
            border-collapse: collapse;
            margin-top: 10px;
            margin-left: 10px;
            margin-right: 20px;
        }
        tr{
            width: 100%;
            height: 30px;
            text-align: center;
        }
        td{
            font-size: 14px;
        }
        td,th{
            width: 8.2%;
            border:1px solid black;
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
            <form method="post" action="/backed/train/fuzzysearch">
                车次：<input type="text" placeholder="车次" name="key">
                <input type="submit" value="查询" id="put1">
            </form>
            <c:if test="${not empty trainlist.data}">
                <table>
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>车次</th>
                            <th>火车类型</th>
                            <th>始发站</th>
                            <th>终点站</th>
                            <th>发车时间</th>
                            <th>到达时间</th>
                            <th>座位类型</th>
                            <th>票价</th>
                            <th>剩余票数</th>
                            <th>操作</th>
                        </tr>
                    </thead>

                    <c:forEach items="${trainlist.data}" var="t">
                        <tbody>
                            <tr>
                                <td>${t.id}</td>
                                <td>${t.train_number}</td>
                                <td>${t.train_type}</td>
                                <td>${t.start_station}</td>
                                <td>${t.last_station}</td>
                                <td>${t.start_time}</td>
                                <td>${t.last_time}</td>
                                <td>${t.seat_type}</td>
                                <td>${t.price}</td>
                                <td>${t.inventory}</td>
                                <td>
                                    <button>修改</button>
                                    <button onclick="toDelete(this)">删除</button>
                                </td>
                            </tr>
                        </tbody>

                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty trainlist.data}">
                没有更多的商品
            </c:if>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    function toDelete(but) {
        var id=$(but).parent().parent().children().first().text();
        $.post(
            "/backed/train/todelete",
            {"id":id},
            function (data) {
                $(but).parent().parent().hide();
                alert("删除成功")
            }
        )
    }
</script>
</html>

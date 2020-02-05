<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/1/18
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .wk{
            background-color: #F1F3F4;
        }
        .one{
            margin-top: 30px;
        }
        .one a{
            color: #151515;
            text-decoration: none;
        }
        h3{
            color: #151515;
            margin-bottom: 30px;
        }
        #of{
            position: relative;
        }
        #tf{
            position: relative;
        }
        .image1{
            width: 25px;
            height: 25px;
            position: absolute;
            top: 0px;
            right: 20px;
        }
        .image1 img{
            width: 100%;
            height: 100%;
        }
        #off{
            margin-top: -25px;
            margin-left: 27px;
            background-color: #F6F7F7;
        }
        #off div{
            color: #151515;
            margin-bottom: 10px;
        }
        #tff{
            margin-top: -25px;
            margin-left: 27px;
            background-color: #F6F7F7;
        }
        #tff div{
            color: #151515;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="wk">
    <div class="one">
        <div id="of" onclick="show('of')">
            <h3>车次管理</h3>
            <div class="image1">
                <img src="/images/left/2.png" id="offimages1">
            </div>
        </div>
        <div style="display: none" id="off">
            <div><a href="/backed/train/getall">车次查询</a></div>
            <div><a href="/backed/index/addtrains">车次添加</a></div>
        </div>
    </div>
    <div class="two">
        <div id="tf" onclick="show('tf')">
            <h3>订单管理</h3>
            <div class="image1">
                <img src="/images/left/2.png" id="tffimages1">
            </div>
        </div>
        <div style="display: none" id="tff">
            <div>查看订单</div>
            <div>预定订单</div>
            <div>退票订单</div>
        </div>
    </div>
    <div>
        <h3><a>会员管理</a></h3>
    </div>
</div>
</body>
<script src="../../js/jquery-3.3.1.js"></script>
<script>
    function show(c) {
        if(document.getElementById(c+"f").style.display=='none'){
            document.getElementById(c+"f").style.display='block';
            document.getElementById(c+"f"+"images1").src='/images/left/1.png';
        }else{
            document.getElementById(c+"f").style.display='none';
            document.getElementById(c+"f"+"images1").src='/images/left/2.png';
        }
    }
</script>
</html>

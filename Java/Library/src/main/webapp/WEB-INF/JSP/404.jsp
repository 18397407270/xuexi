<%--
  Created by IntelliJ IDEA.
  User: hzh
  Date: 2020/12/22
  Time: 18:26:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>404</title>
    <style>
        ::-moz-selection{
            background: aliceblue;
            text-shadow: none;
        }

        ::selection {
            background: #b3d4fc;
            text-shadow: none;
        }

        html {
            padding: 30px 10px;
            font-size: 20px;
            line-height: 1.4;
            /*color: #737373;
            background: #f0f0f0;*/
            /*
            -webkit-text-size-adjust: 100%可以禁止字体变化
            */
            -webkit-text-size-adjust: 100%;
            -ms-text-size-adjust: 100%;
        }
        h1 span {
            color: #bbb;
        }

        body {
            max-width: 500px;
            _width: 500px;
            padding: 30px 20px 50px;
            border: 1px solid #b3b3b3;
            border-radius: 4px;
            margin: 0 auto;
            box-shadow: 0 1px 10px #a7a7a7, inset 0 1px 0 #fff;
            background: #fcfcfc;
        }

        .container {
            max-width: 380px;
            _width: 380px;
            margin: 16% auto;
            text-align: center;
        }




    </style>
</head>
<body>
<div class="container">
    <h1>404 Not Found <span>:(</span></h1>
    <p>对不起,您访问的页面不存在</p>
    <p>请输入正确的地址</p>
    <p><em id="num">3</em>秒后,自动跳转到上一页</p>
    <%--
    定义自动跳转功能
    --%>
    <script>
        var i = 3;
        function back() {
            if(i==0){
                //返回上一个页面
                window.history.back();
            }else{
                document.getElementById("num").innerText = i--;
                setTimeout("back()",1000);
            }
        }
        back();
    </script>
</div>
</body>
</html>

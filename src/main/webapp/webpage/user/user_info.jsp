<%@ include file="/webpage/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctxStatic}/js/jquery-3.2.1.js"></script>
    <script src="${ctxStatic}/js/bootstrap.min.js"></script>
    <title>Kidding › <c:if test="${!empty userInfo}">${userInfo.username}</c:if><c:if test="${!empty errorInfo}">会员未找到</c:if></title>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="/webpage/include/header.jsp"%>

<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <a href="${ctx }/">Kidding</a> › ${userInfo.username}
        </div>

        <div class="panel-body">
            <c:if test="${!empty userInfo}">
            <form class="form-horizontal" role="form">
                <div style="margin-left: 17%">
                    <img width="60px" height="60px" src="${ctxStatic}/${userInfo.avatar}" class="img-rounded">
                </div><br/>
                <div class="form-group">
                    <label class="col-sm-2 control-label">uid</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.id}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.username}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.email}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">注册时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.localCreateTime}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">积分</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${userInfo.credit}</p>
                    </div>
                </div>
            </form>
            </c:if>
            <c:if test="${!empty errorInfo}">
                会员未找到!
            </c:if>
        </div>
    </div>
</div>

<!-- 引入侧边栏文件 -->
<%@ include file="/webpage/include/side.jsp"%>

<!-- 引入footer文件 -->
<%@ include file="/webpage/include/footer.jsp"%>

</body>
</html>
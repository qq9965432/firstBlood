<%@ include file="/webpage/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctxStatic}/js/jquery-3.2.1.js"></script>
    <script src="${ctxStatic}/js/bootstrap.min.js"></script>
    <title>${topic.title} - Kidding </title>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="/webpage/include/header.jsp"%>
<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        <div>
            <div class="panel-heading" style="background-color: white">
                <a href="${ctx}/">Kidding</a> › 主题
            </div>
            <h3>${topic.title}</h3><br/>
            <div>
                <a href="${ctx}/member/${topic.user.username}"><span ><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;
                <small class="text-muted">${topic.localCreateTime}&nbsp;&nbsp;&nbsp;+08:00</small>&nbsp;&nbsp;
                <small class="text-muted">${topic.click}次点击</small>
            </div>
        </div>

        <div style="float: right;margin-top: -100px" >
            <img width="50px" height="50px" src="${ctxStatic}${topic.user.avatar}" class="img-rounded">
        </div>
    </div>

    <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                ${topic.content}
            </li>
    </ul>
</div>

<c:if test="${!empty replies}">
<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        <span>
                ${fn:length(replies)} 回复  |  直到 <c:forEach items="${replies}" var="reply" varStatus="status">

<c:if test="${status.last}">
    ${reply.localCreateTime}
    </c:if>
    </c:forEach>
    </span>
    </div>

    <ul class="list-group" style="width: 100%">
        <!-- 遍历评论 -->
        <c:forEach items="${replies}" var="reply">
        <li class="list-group-item">
            <div style="height: 50px">
                <div style="float: left;width: 6%;margin-bottom: 5px">
                    <img width="50px" height="50px" src="${reply.user.avatar} " class="img-rounded">
                </div>
                <div style="width: 89%;float: left">
                    <a href="${ctx}/member/${reply.user.username}"><strong>${reply.user.username}</strong></a>&nbsp;&nbsp;
                    <small class="text-muted">${reply.localCreateTime}</small>
                    <br/>
                    <div>
                        <p>${reply.content}</p>
                    </div>
                </div>
            </div>
        </li>
        </c:forEach>

    </ul>
</div>
</c:if>

<c:if test="${!empty user}">

<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        添加一条新回复
    </div>
    <div class="panel-body">
        <div class="form-group">
            <form action="${ctx}/reply/add" method="post">
                <input type="hidden" name="topicId" value="${topic.id}">
                <input type="hidden" name="replyUserId" value="${user.id}">
                <textarea class="form-control" rows="3" name="content" required="required"></textarea><br/>
            <input type="submit" class="btn btn-default btn-sm" value="回复">
            </form>
        </div>

    </div>
</div>
</c:if>

</div>
<!-- 引入侧边栏文件 -->
<%@ include file="/webpage/include/side.jsp"%>

<!-- 引入footer文件 -->
<%@ include file="/webpage/include/footer.jsp"%>

</body>
</html>
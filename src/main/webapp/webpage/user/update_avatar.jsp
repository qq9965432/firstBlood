<%@ include file="/webpage/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctxStatic}/js/jquery-3.2.1.js"></script>
    <script src="${ctxStatic}/js/bootstrap.min.js"></script>
    <title>Kidding ›头像上传</title>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="/webpage/include/header.jsp"%>

<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <a href="${ctx }/">Kidding</a> › 设置 ›头像上传
        </div>

        <div class="panel-body">

            <form  action="${ctx }/settings/avatar/update" enctype="multipart/form-data" method="post" class="form-horizontal" role="form">
                <div style="margin-left: 17%">
                    <img width="60px" height="60px" src="${ctxStatic}/${user.avatar}" class="img-rounded">
                    <input type="file"  name="avatar" accept="image/png,image/jpeg,image/jpg" >
                    <br/>
                    <input class="btn btn-default" type="submit" value="上传头像">
                </div>
            </form>

        </div>

    </div>



</div>

<!-- 引入侧边栏文件 -->
<%@ include file="/webpage/include/side.jsp"%>

<!-- 引入footer文件 -->
<%@ include file="/webpage/include/footer.jsp"%>

</body>
</html>
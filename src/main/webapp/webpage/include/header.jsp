<%@ include file="/webpage/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <nav class="navbar navbar-default" role="navigation" style="background-color: white">
        <div class="container-fluid" style="margin-left: 10%">
            <div class="navbar-header">
                <a class="navbar-brand" href="${ctx}/">Kidding</a>
            </div>
            <div>

                <!--向左对齐-->
                <ul class="nav navbar-nav navbar-left">
                    <li <c:if test="${tab.tabNameEn == 'tech'}">
                            class="active" </c:if>><a href="${ctx}/tab/tech">技术</a>
                    </li>
                    <li <c:if test="${tab.tabNameEn == 'play'}">class="active"
                        </c:if>><a href="${ctx}/tab/play">好玩</a></li>
                    <li <c:if test="${tab.tabNameEn == 'creative'}">class="active"
                        </c:if>><a href="${ctx}/tab">创意</a></li>
                    <li <c:if test="${tab.tabNameEn == 'jobs'}">class="active"
                         </c:if>><a href="${ctx}/tab/jobs">工作</a></li>
                    <li <c:if test="${tab.tabNameEn == 'deals'}">class="active"
                        </c:if>><a href="${ctx}/tab/deals">交易</a></li>

                </ul>

                <c:if test="${empty userId}">
                <!--未登陆-->
                 <ul class="nav navbar-nav navbar-right">
                       <li>
                           <p class="navbar-text"><a href="${ctx}/signin">登录</a></p>
                       </li>
                       <li>
                               <p class="navbar-text"><a href="${ctx}/signup">注册</a></p>
                       </li>
                 </ul>
                </c:if>
            <c:if test="${!empty userId}">
                   <!--已登陆-->
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <p class="navbar-text"><a href="${ctx }/">首页</a></p>
                    </li>
                    <li>
                        <p class="navbar-text"><a href="${ctx }/member/${sessionScope.username}">${sessionScope.username}</a></p>
                    </li>
                    <li>
                        <p class="navbar-text"><a href="${ctx }/settings">设置</a></p>
                    </li>
                    <li>
                        <p class="navbar-text"><a href="javascript:signout_confirm();">登出</a></p>
                    </li>
                </ul>
            </c:if>
            </div>
        </div>
    </nav>


</header>
<script>
    function signout_confirm()
    {
        var r=confirm("确定退出?")
        if (r==true)
        {
            window.location.href="${ctx}/signout";
        }
        else
        {

        }
    }
</script>
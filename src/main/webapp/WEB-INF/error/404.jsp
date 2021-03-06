<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="error-page">
    <head>
        <title>404 error page | 正和岛-中国商界第一高端人脉与网络社交平台</title>
        <%@ include file="../views/inc-meta.jsp" %>
        <%@ include file="../views/inc-link.jsp" %>

        <!-- Bootstrap Error Page -->
        <link rel="stylesheet" media="screen" href="<%=request.getContextPath()%>/resources/css/bootstrap-error-page.css">

    </head>
    <body>
        <%@ include file="../views/inc-header.jsp"%>

        <!-- content -->
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="col-lg-12">
                    <div class="centering text-center">
                        <div class="text-center">
                            <h2 class="without-margin">Don't worry. It's <span class="text-success"><big>404</big></span> error only.</h2>
                            <h4 class="text-success">Page not found</h4>
                        </div>
                        <!-- 
                        <div class="text-center">
                            <h3><small>Choose an option below</small></h3>
                        </div>
                        <hr>
                        <ul class="pager">
                            <li><a href="about.html">&larr; About</a></li>
                            <li><a href="dashboard.html">Dashboard</a></li>
                            <li><a href="ui-and-interface.html">UI & Interface</a></li>
                            <li><a href="error-pages.html">Other error pages &rarr;</a></li>
                        </ul>
                         -->
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

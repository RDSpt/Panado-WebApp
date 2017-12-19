<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>O Panadão - ${title}</title>

    <link href="${css}/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.css" rel="stylesheet">
    <!-- Theme CSS -->
    <link href="${css}/slate-theme.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${css}/modern-business.css" rel="stylesheet">


    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}';
    </script>
</head>

<body>
<%--NAVIGATION--%>
<div class="wrapper">
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="${contextRoot}/home">O Panadão</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                    data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </nav>
    <%--MESSAGE--%>
    <div class="container" style="margin-top: 50px;">
        <br>
        <c:if test="${not empty message}">
            <div class="row">
                <div class="offset-md-2 col-md-8">
                    <div class="alert alert-danger text-center">
                            ${message}
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${not empty logout}">
            <div class="row">
                <div class="offset-md-2 col-md-8">
                    <div class="alert alert-success text-center">
                            ${logout}
                    </div>
                </div>
            </div>
        </c:if>
        <%--FORM--%>
        <div class="row">
            <div class="col-xs-12 col-md-12">
                <div class="offset-md-2 col-md-8">
                    <div class="card">
                        <div class="card-header card-title text-center">
                            <h4>Registar</h4>
                        </div>
                        <form action="${contextRoot}/login" method="POST" class="form-horizontal"
                              id="loginForm">
                            <div class="card-body">

                                <!-- FORM Elements -->


                                <div class="form-group row">
                                    <label class="control-label col-md-4" for="username">E-mail: </label>
                                    <div class="col-md-8">
                                        <input type="text" name="username" id="username" class="form-control"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="control-label col-md-4" for="password">Password: </label>
                                    <div class="col-md-8">
                                        <input type="password" name="password" id="password" class="form-control"/>
                                    </div>
                                </div>

                            </div>
                            <!-- Submit -->
                            <div class="col-md-12 card-footer">
                                <!-- This name is important -->
                                <div class="row form-group">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="submit" value="Entrar" class="btn btn-primary"/>
                                    <%-- <button type="submit" class="btn btn-primary"><i class='fa fa-sign-in fa-lg'
                                                                                      aria-hidden='true'></i> Entrar
                                     </button>--%>
                                </div>
                                <div class="row">
                                    <span>
                                    Novo Utilizador - <h6><a
                                            href="${contextRoot}/register"> Registe-se aqui</a></h6></span>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Footer -->
    <%@ include file="shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.bundle.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap4.js"></script>
    <script src="${js}/bootbox.min.js"></script>
    <script src="${js}/jquery.validate.js"></script>
    <script src="${js}/myapp.js"></script>
</div>
</body>

</html>
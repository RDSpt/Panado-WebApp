<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class=" container-fluid">
        <a class="navbar-brand" href="${contextRoot}/home">O Panadão</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav navbar-default">
                <li class="nav-item" id="produtos">
                    <a class="nav-link" href="${contextRoot}/produtos/">Produtos</a>
                </li>
                <li class="nav-item" id="sobrenos">
                    <a class="nav-link" href="${contextRoot}/sobrenos">Sobre Nós</a>
                </li>

                <li class="nav-item" id="contactos">
                    <a class="nav-link" href="${contextRoot}/contactos">Contactos</a>
                </li>
                <security:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item" id="manageProducts">
                        <a class="nav-link" href="${contextRoot}/gerir/produtos">Gerir Produtos</a>
                    </li>
                </security:authorize>
            </ul>
            <ul class="nav navbar-nav navbar-right ml-auto">
                <security:authorize access="isAnonymous()">
                    <li class="nav-item" id="register">
                        <a class="nav-link" href="${contextRoot}/register">Registar</a>
                    </li>
                    <li class="nav-item" id="login">
                        <a class="nav-link" href="${contextRoot}/login">Login</a>
                    </li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li class="dropdown">

                        <a href="javascript:void(0)" class="btn btn-default dropdown-toggle" id="dropdownMenu1"
                           data-toggle="dropdown">${userModel.fullName} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <security:authorize access="hasAuthority('CUSTOMER')">
                                <li><a href="${contextRoot}/cart"><i class="fa fa-shopping-cart fa-lg"
                                                                     aria-hidden="true"></i><span
                                        class="badge">${userModel.cart.cartLine}</span> ${userModel.cart.total}
                                    €</a>
                                </li>
                                <li class="dropdown-divider" role="separator"></li>
                            </security:authorize>
                            <li><a href="${contextRoot}/perform-logout">Logout</a></li>
                        </ul>
                    </li>
                </security:authorize>
            </ul>
        </div>
    </div>
</nav>
<script>
    window.userRole = '${userModel.role}';
</script>
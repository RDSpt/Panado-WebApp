<%--<script src="https://use.fontawesome.com/c560c025cf.js"></script>--%>
<div class="container" style="margin-top: 60px;">
<c:if test="${not empty message}">
    <div class="alert alert-info">
        <h3 class="text-center">${message}</h3>
    </div>
</c:if>
<c:choose>
    <c:when test="${not empty cartLines}">


        <div class="card shopping-cart">
            <div class="card-header bg-dark text-light">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                Shipping cart
                <a href="${contextRoot}/produtos/" class="btn btn-outline-info btn-sm pull-right">Continuar a ver</a>
                <div class="clearfix"></div>
            </div>
            <div class="card-body">
                <c:forEach items="${cartLines}" var="cartLine">
                    <!-- PRODUCT -->
                    <div class="row">
                        <div class="col-12 col-sm-12 col-md-2 text-center">
                            <img class="img-responsive" src="${images}/produtos/${cartLine.product.code}.jpg"
                                 alt="${cartLine.product.name}" width="100"
                                 height="100">
                        </div>
                        <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                            <h4 class="product-name"><strong>${cartLine.product.name}</strong></h4>
                            <h4>
                                <small>${cartLine.product.description}</small>
                            </h4>
                        </div>
                        <c:if test="${cartLine.available == false}">
                            <strong class="unavailable">Não disponivel</strong>
                        </c:if>
                        <div class="col-12 col-sm-12 col-md-4 text-sm-center  text-md-right">
                            <div class="row">
                                <label class="col-form-label" for="count_${cartLine.id}">${cartLine.product.price} €
                                    <span class="text-muted"> &times; </span>
                                </label>
                                <div class="col-4">
                                    <input type="number"
                                           id="count_${cartLine.id}"
                                           class="form-control text-center"
                                           value="${cartLine.productCount}"
                                           min="1" max="99">
                                </div>
                            </div>
                            <div class="row text-center offset-4">
                                <button type="button" name="refreshCart" value="${cartLine.id}"
                                        class="btn btn-outline-info btn-xs">
                                    <i class="fa fa-refresh" aria-hidden="true"></i>
                                </button>
                                <a href ="${contextRoot}/cart/${cartLine.id}/delete" type="button" class="btn btn-outline-danger btn-xs">
                                    <i class="fa fa-trash" aria-hidden="true"></i>
                                </a>
                            </div>
                            <div class="row">
                                <h6>Total:<strong>${cartLine.total} €</strong></h6>
                            </div>
                        </div>
                    </div>


                    <hr>
                    <!-- END PRODUCT -->
                </c:forEach>


                    <%--<div class="pull-right">
                        <a href="" class="btn btn-outline-secondary pull-right">
                            Update shopping cart
                        </a>
                    </div>--%>
            </div>
            <div class="card-footer">
                <div class="coupon col-md-5 col-sm-5 no-padding-left pull-left">
                    <div class="row">
                        <div class="col-6">
                            <input type="text" class="form-control" placeholder="Código de Desconto">
                        </div>
                        <div class="col-6">
                            <input type="submit" class="btn btn-default" value="Usar Desconto">
                        </div>
                    </div>
                </div>
                <div class="pull-right" style="margin: 10px">
                    <a href="${contextRoot}/cart/encomendar" class="btn btn-success pull-right">Encomendar</a>
                    <div class="pull-right" style="margin: 5px">
                        Total: <b>${userModel.cart.total} €</b>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="jumbotron">
            <div class="text-center">
                <h1> Vazio</h1>
            </div>
        </div>
    </c:otherwise>
</c:choose>
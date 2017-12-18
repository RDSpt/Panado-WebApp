<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--springform library--%>

<div class="container" style="margin-top: 50px;">
    <br>
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <c:if test="${not empty message}">
                <div class="alert alert-success alert-dismissible">
                    <p> ${message} </p>
                    <button type="button" class="close" data-dismiss="alert">&nbsp;&nbsp;&nbsp;&times;</button>
                </div>
            </c:if>
            <c:if test="${not empty messageFail}">
                <div class="alert alert-danger alert-dismissible">
                    <p> ${messageFail} </p>
                    <button type="button" class="close" data-dismiss="alert">&nbsp;&nbsp;&nbsp;&times;</button>
                </div>
            </c:if>
        </div>

        <div class="offset-md-2 col-md-8">
            <div class="card">
                <div class="card-header card-title text-center">
                    <h4>${title}</h4>
                </div>
                <form:form class="form-horizontal" modelAttribute="product"
                           action="${contextRoot}/gerir/adicionarProdutos"
                           method="POST" enctype="multipart/form-data">
                <div class="card-body">
                    <div class="form-group row">
                        <label class="col-form-label col-md-4" for="name">Nome do Produto:</label>
                        <div class="col-md-8">
                            <form:input type="text" path="name" id="name" placeholder="Nome do Produto"
                                        class="form-control"/>
                            <form:errors path="name" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-form-label col-md-4" for="description">Descriçao do Produto:</label>
                        <div class="col-md-8">
                            <form:textarea rows="4" path="description" id="description"
                                           placeholder="Descriçao do Produto" class="form-control"/>
                            <form:errors path="description" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-form-label col-md-4" for="price">Preço:</label>
                        <div class="col-md-8">
                            <form:input type="number" path="price" id="price" placeholder="Preço"
                                        class="form-control"/>
                            <form:errors path="price" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-form-label col-md-4" for="quantity">Quantidade:</label>
                        <div class="col-md-8">
                            <form:input type="number" path="quantity" id="quantity" placeholder="Quantidade"
                                        class="form-control" step="0.01"/>
                            <form:errors path="quantity" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-form-label col-md-4" for="file">Imagem:</label>
                        <div class="col-md-8">
                            <form:input type="file" path="file" id="file" class="form-control"/>
                            <form:errors path="file" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-form-label col-md-4" for="categoryId">Categoria:</label>
                        <div class="col-md-8">
                            <form:select class="form-control" id="categoryId"
                                         path="categoryId" items="${categories}" itemLabel="name"
                                         itemValue="id"/>
                            <form:errors path="categoryId" cssClass="help-block" element="em"/>

                        </div>
                    </div>
                </div>

                <div class="col-md-12 text-center card-footer">
                    <input type="submit" name="submit" id="submit" value="Submeter"
                           class="btn btn-primary"/>

                        <%--Hidden Fields--%>
                    <form:hidden path="id"/>
                    <form:hidden path="code"/>
                    <form:hidden path="active"/>
                    <form:hidden path="purchases"/>
                    <form:hidden path="views"/>
                </div>
            </div>
            </form:form>
        </div>
    </div>
</div>

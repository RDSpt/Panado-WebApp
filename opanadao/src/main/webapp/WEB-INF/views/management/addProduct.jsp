<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--springform library--%>

<div class="container">
    <br>
    <div class="row">

        <div class="col-xs-12 col-md-12">
            <c:if test="${not empty message}">
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&nbsp;&nbsp;&nbsp;&times;</button>
                    <p> ${message} </p>
                </div>
            </c:if>
            <c:if test="${not empty messageFail}">
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&nbsp;&nbsp;&nbsp;&times;</button>
                    <p> ${messageFail} </p>
                </div>
            </c:if>
        </div>

        <div class="offset-md-2 col-md-8">
            <div class="card">
                <div class="card-header card-title text-center">
                    <h4>Adicionar Produtos</h4>
                </div>
                <sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/gerir/adicionarProdutos"
                         method="POST" enctype="multipart/form-data">
                <div class="card-body">
                    <div class="form-group">
                        <label class="control-label col-md-4" for="name">Nome do Produto:</label>
                        <div class="offset-md-4 col-md-8">
                            <sf:input type="text" path="name" id="name" placeholder="Nome do Produto"
                                      class="form-control"/>
                            <sf:errors path="name" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4" for="description">Descriçao do Produto:</label>
                        <div class="offset-md-4 col-md-8">
                            <sf:textarea rows="4" path="description" id="description"
                                         placeholder="Descriçao do Produto" class="form-control"/>
                            <sf:errors path="description" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4" for="price">Preço:</label>
                        <div class="offset-md-4 col-md-8">
                            <sf:input type="number" path="price" id="price" placeholder="Preço"
                                      class="form-control"/>
                            <sf:errors path="price" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4" for="quantity">Quantidade:</label>
                        <div class="offset-md-4 col-md-8">
                            <sf:input type="number" path="quantity" id="quantity" placeholder="Quantidade"
                                      class="form-control"/>
                            <sf:errors path="quantity" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4" for="file">Imagem:</label>
                        <div class="offset-md-4 col-md-8">
                            <sf:input type="file" path="file" id="file" class="form-control"/>
                            <sf:errors path="file" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4" for="categoryId">Categoria:</label>
                        <div class="offset-md-4 col-md-8">
                            <sf:select class="form-control" id="categoryId"
                                       path="categoryId" items="${categories}" itemLabel="name"
                                       itemValue="id"/>
                            <sf:errors path="categoryId" cssClass="help-block" element="em"/>
                        </div>
                    </div>
                </div>

                <div class="col-md-12 text-center card-footer">
                    <input type="submit" name="submit" id="submit" value="Submeter"
                           class="btn btn-primary"/>

                        <%--Hidden Fields--%>
                    <sf:hidden path="id"/>
                    <sf:hidden path="code"/>
                    <sf:hidden path="active"/>
                    <sf:hidden path="purchases"/>
                    <sf:hidden path="views"/>
                </div>
            </div>
            </sf:form>
        </div>
    </div>
</div>

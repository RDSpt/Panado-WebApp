<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/flows-header.jsp" %>


<div class="container" style="margin-top: 60px;">
    <br>
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <div class="offset-md-2 col-md-8">
                <div class="card">
                    <div class="card-header card-title text-center">
                        <h4>Registar</h4>
                    </div>
                    <form:form class="form-horizontal" id="registerForm" method="post" modelAttribute="user">
                        <div class="card-body">

                            <!-- FORM Elements -->


                            <div class="form-group row">
                                <label class="control-label col-md-4" for="first_name">Nome: </label>
                                <div class="col-md-8">
                                    <form:input type="text" path="first_name" placeholder="Nome"
                                                class="form-control"/>
                                    <form:errors path="first_name" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="control-label col-md-4" for="last_name">Apelido: </label>
                                <div class="col-md-8">
                                    <form:input type="text" path="last_name" placeholder="Apelido"
                                                class="form-control"/>
                                    <form:errors path="last_name" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="control-label col-md-4" for="email">Email: </label>
                                <div class="col-md-8">
                                    <form:input type="text" path="email" placeholder="****@****"
                                                class="form-control"/>
                                    <form:errors path="email" cssClass="help-block errHighlight" element="em"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="control-label col-md-4" for="contact_number">Número: </label>
                                <div class="col-md-8">
                                    <form:input type="text" path="contact_number"
                                                placeholder="xxxxxxxxx" class="form-control"/>
                                    <form:errors path="contact_number" cssClass="help-block"
                                                 element="em"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="control-label col-md-4" for="password">Password: </label>
                                <div class="col-md-8">
                                    <form:input type="password" path="password" placeholder="Password"
                                                class="form-control"/>
                                    <form:errors path="password" cssClass="help-block" element="em"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="control-label col-md-4" for="confirmPassword">Confirme Password: </label>
                                <div class="col-md-8">
                                    <form:input type="password" path="confirmPassword" placeholder="Rescreva a Password"
                                                class="form-control"/>
                                    <form:errors path="confirmPassword" cssClass="help-block" element="em"/>
                                </div>
                            </div>
                        </div>
                        <!-- Submit -->
                        <div class="col-md-12 text-center card-footer">
                            <!-- This name is important -->
                            <button type="submit" name="_eventId_address"
                                    class="btn btn-primary">
                                <i class='fa fa-arrow-right fa-lg' aria-hidden='true'></i> Morada de Facturação
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="../shared/flows-footer.jsp" %>



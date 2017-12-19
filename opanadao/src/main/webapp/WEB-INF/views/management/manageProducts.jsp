<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
        </div>
        <h3>Products</h3>
        <hr>
    </div>
    <table id="adminProductsTable" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>&#160;</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Active</th>
            <th>Edit</th>
        </tr>
        </thead>
    </table>
</div>

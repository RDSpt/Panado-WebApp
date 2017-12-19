<div class="list-group">
    <hr>
    <a href="${contextRoot}/produtos/" class="list-group-item" id="a_todos">Todos</a>
    <c:forEach items="${categories}" var="category">
        <a href="${contextRoot}/produtos/${category.id}/" class="list-group-item" id = "a_${category.name}">${category.name}</a>
    </c:forEach>
</div>
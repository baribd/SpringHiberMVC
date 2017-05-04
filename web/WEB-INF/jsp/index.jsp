<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script>
            function deleteProduct(pid){
                if(confirm('Do you realy want to delete this product?')){
                    var url= 'delete/'+pid;
                    window.location.href=url;
                }
            }
        </script>
    </head>

    <body>
        <c:url var="action" value="/product/add"></c:url>
        <form:form method="post" action="${action}" commandName="product">
            <table>
                <c:if test="${!empty product.productName}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message code="label.productId"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id"/>
                    </td>
                </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="productName">
                            <spring:message code="label.productName"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="productName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="description">
                            <spring:message code="label.productDescription"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="description"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="price">
                            <spring:message code="label.price"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="price"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="qty">
                            <spring:message code="label.qty"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="qty"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${! empty product.productName}">
                            <input type="submit" value="<spring:message code="label.editproduct"/> "/>
                        </c:if>
                        <c:if test="${ empty product.productName}">
                            <input type="submit" value="<spring:message code="label.addProduct"/> "/>
                        </c:if>
                    </td>
                </tr>
            </table>
        </form:form>
        <h3> List of Product</h3>
        <c:if test="${! empty productList}">
            <table>
                <tr>
                    <td>Product Name</td>
                    <td>Description</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Action</td>
                </tr>
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td>${product.productName}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>${product.qty}</td>
                        <td><a href="/SpringHiberMVC/edit/${product.id}">Edit</a>
                            <a href="#" onclick="javascript:deleteProduct(${product.id})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </c:if>
    </body>
</html>

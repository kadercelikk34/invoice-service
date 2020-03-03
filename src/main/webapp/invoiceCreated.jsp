<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Yeni Fatura</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <h4 class="text-right"><a href="${contextPath}/dashboard">Fatura Listesine Geri Dön</a></h4>
    <form:form method="POST" action="${contextPath}/invoiceSave" modelAttribute="invoiceForm" class="form-signin">
        <h2 class="form-signin-heading">Yeni Fatura Oluştur</h2>
        <spring:bind path="amount">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="amount" class="form-control" placeholder="Fatura Tutarı"
                            autofocus="true"></form:input>
                <form:errors path="amount"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="productName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="productName" class="form-control" placeholder="Ürün Adı"
                            autofocus="true"></form:input>
                <form:errors path="productName"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="billingNo">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="billingNo" class="form-control" placeholder="Fatura NO"
                            autofocus="true"></form:input>
                <form:errors path="billingNo"></form:errors>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Kaydet</button>
    </form:form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <form:form method="POST" modelAttribute="invoiceForm" class="form-signin">
        <h2 class="form-signin-heading">Yeni Fatura Oluştur</h2>
        <spring:bind path="amount">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="amount" class="form-control" placeholder="Amount"
                            autofocus="true"></form:input>
                <form:errors path="amount"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="productName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="productName" class="form-control" placeholder="ProductName"
                            autofocus="true"></form:input>
                <form:errors path="productName"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="billingNo">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="billingNo" class="form-control" placeholder="BillingNo"
                            autofocus="true"></form:input>
                <form:errors path="billingNo"></form:errors>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
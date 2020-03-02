<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>

   <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">


    <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

    <!-- jQuery -->
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>

    <!-- DataTables -->
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

    <script type="text/javascript">
        $(function() {
            $("#invoiceList").dataTable();
        });
    </script>
</head>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Hoşgeldin ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Çıkış</a></h2>
        <h4 class="text-right"><a href="${contextPath}/invoice">Yeni Fatura Ekle</a></h4>
    </c:if>
    <h2>Fatura Listesi</h2>
    <c:if test="${!empty lists}">

    <table id="invoiceList" class="table table-striped table-bordered">
        <thead>
        <tr>
            <td>ID</td>
            <td>Fatura Tutarı</td>
            <td>Ürün Adı</td>
            <td>Fatura NO</td>
            <td>Fatura Durumu</td>
            <td>Kullanıcı Ad Soyad</td>
            <td>Kullanıcı Email</td>
            <td></td>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="invoice">
            <tr>
                <td><a href="${contextPath}/invoice/${invoice.id}"><c:out value="${invoice.id}" /></a></td>
                <td><c:out value="${invoice.amount}"/></td>
                <td><c:out value="${invoice.productName}"/></td>
                <td><c:out value="${invoice.billingNo}"/></td>
                <td><c:out value="${invoice.invoiceStatus}"/></td>
                <td><c:out value="${invoice.user.firstName}  ${invoice.user.lastName}"/></td>
                <td><c:out value="${invoice.user.username}"/></td>
                <td><a href="${contextPath}/invoice/${invoice.id}">Detay</a></td>

            </tr>
        </c:forEach>
        </tbody>
    </c:if>

</div>
</body>
</html>
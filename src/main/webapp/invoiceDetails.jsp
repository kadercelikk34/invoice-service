<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Fatura Detayı</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h2 class="form-signin-heading">Fatura Detayı</h2>
    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${invoice.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Fatura Tutarı</label>
        <div class="col-sm-10">${invoice.amount}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Ürün Adı</label>
        <div class="col-sm-10">${invoice.productName}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Fatura NO</label>
        <div class="col-sm-10">${invoice.billingNo}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Fatura Durumu</label>
        <div class="col-sm-10">${invoice.invoiceStatus}</div>
    </div>
    <br>
    <div class="form-group ${status.error ? 'has-error' : ''}">
        <h5 class="text-left"><a href="${contextPath}/dashboard">Fatura Listesine Geri Dön</a></h5>
        <h5 class="text-left"><a href="${contextPath}/invoice">Yeni Fatura Ekle</a></h5>
    </div>



</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
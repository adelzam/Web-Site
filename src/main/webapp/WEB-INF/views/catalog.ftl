<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Catalog</title>
</head>
<body class="body">
<div> <#include "template/components/headerTop.ftl"></div>
<div class="mainblock">
    <div class="leftmenu"> <#include "template/components/headerMenu.ftl"></div>
    <div align="left">
        Page = ${page}
        Limit = ${limit!"null"}

    <#list goods as good>
        <#if !limit?? || good_index < limit>
            <pre>
        ${good_index})
            ID: ${good.id}
            Название товара: ${good.name}
            ID категории: ${good.categoryId}
            цена: ${good.price?number}
            <a href="/cart/add/${good.id}">Потратить на это деньги</a>
        </pre>
        </#if>
    </#list>
    </div>
</div>
</body>
</html>
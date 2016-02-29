<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Корзина</title>
</head>
<body class="body">
<div> <#include "head.ftl" ></div>
<div class="mainblock">
    <div class="leftmenu"> <#include "leftmenu.ftl"></div>
    <div align="left">
        <br>
        Товары в корзине:
    <#list (Session.sessionCart![]) as good>
        <#if !limit?? || good_index < limit>
            <pre>
        ${good_index})
            ID: ${good.id}
            Название товара: ${good.name}
            ID категории: ${good.categoryId}
            цена: ${good.price?number}
        </pre>
        </#if>
    </#list>
    </div>
</div>
</body>
</html>
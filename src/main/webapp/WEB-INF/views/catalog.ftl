<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "mainTemplate.ftl">
<@mainTemplate title="Каталог товаров" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div align="left">
    Page = ${page}
    Limit = ${limit!"null"}
    <div align="center" style="margin-left: 135pt">

        <#list goods as good>
            <#if !limit?? || good_index < limit>
                <div class="goodblock">
            <pre>
        ${good_index})
            ID: ${good.id}
            Название товара: ${good.name}
            ID категории: ${good.categoryId}
            цена: ${good.price?number}
            <a href="/cart/add/${good.id}">Потратить на это деньги</a>
        </pre>
                </div>
            </#if>
        </#list>
    </div>
</#macro>
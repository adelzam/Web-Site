<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог товаров" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div align="left" class="catalog_blog">
    <div align="center" style="margin-left: 10pt">
        <#list goods as good>
            <#if !limit?? || good_index < limit>
                <div class="goodblock" style="margin-left: 30pt;">
                    <img src="../../../../resources/images/catalog-top.png" style="width: 210pt">
                    <div style="background-color:white; margin-top: -13pt">
            <pre>
        ${good_index})
            ID: ${good.id}
            Название товара: <a href="/goods/${good.id}" style="text-decoration: none">${good.name}</a>
            ID категории: ${good.category.id}
            цена: ${good.price?number}
            <a href="/cart/add/${good.id}">Потратить на это деньги</a>
        </pre>
                    </div>
                </div>
            </#if>
        </#list>
        <a href="/catalog/1"><img src="../../../resources/images/showmore.png"/></a>
    </div>
</#macro>
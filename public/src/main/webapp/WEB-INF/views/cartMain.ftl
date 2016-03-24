<#include "mainTemplate.ftl">
<@mainTemplate title="Главная" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
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
</#macro>
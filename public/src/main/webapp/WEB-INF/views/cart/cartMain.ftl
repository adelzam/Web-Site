<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Главная" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="feedback_main">
    Товары в корзине:
    <#list (Session.sessionCart![]) as good>
        <#if !limit?? || good_index < limit>
            <pre>
        ${good_index})
            ID: ${good.id}
            Название товара: ${good.name}
            цена: ${good.price?number}
                <a href="/cart/remote/${good_index}">Убрать из корзины</a>
        </pre>
        </#if>
    </#list>
</div>

</#macro>
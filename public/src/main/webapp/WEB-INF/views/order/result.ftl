<#-- @ftlvariable name="ordermun" type="java.lang.Long"-->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Главная" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="feedback_main" align="center">
    Спасибо за покупку!<br>
    Вам придет смс-оповещение, когда заказ будет говов<br>
    Номер вашего заказа: <br>
    <span style="color: darkred; font-size: 46px">004562${ordernum}</span><br>
    <a href="/catalog" style="text-decoration: none; color: midnightblue">>> перейти к новым покупкам <<</a>
</div>
</#macro>
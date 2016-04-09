<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Главная" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="feedback_main" align="center">
    Ваша корзина пуста<br>
    <a href="/catalog" style="text-decoration: none; color: midnightblue">>> перейти к покупкам <<</a>
</div>
</#macro>
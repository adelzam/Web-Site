<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Главная" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="feedback_main">
    Ваша корзина пуста<br>
    <a href="/catalog" style="text-decoration: none; color: black">>> перейти к покупкам <<</a>
</div>
</#macro>
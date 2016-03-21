<#include "mainTemplate.ftl">
<@mainTemplate title="Главная" styles=["css/style.css"] scripts=["js/jquery.cycle.all.min.js","js/script.js"]/>
<#macro m_body>
<div class="slider">
    <a href="/catalog/1"> <img src="../../resources/images/coffe2.jpg"></a>
    <a href="/catalog/2"> <img src="../../resources/images/coffe1.jpg"></a>

    <a href="/cart"> <img src="../../resources/images/coffe3.jpg"></a>
</div>
    <#include "template/components/topGoods.ftl" />
Конец строки
</#macro>
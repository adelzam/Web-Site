<#include "mainTemplate.ftl">
<@mainTemplate title="Каталог товаров" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="mainblock">
    <div align="left">
    ${message!"Сообщения нет!"}
    </div>
    <div align="center">
        <a href="/catalog/1"><img src="../../resources/images/Cat1.jpg"></a>
        <a href="/catalog/1" style="margin-top: 0pt"><img src="../../resources/images/Cat2.jpg"></a>
        <a href="/catalog/1"><img src="../../resources/images/Cat3.jpg"></a>
        <a href="/catalog/1"><img src="../../resources/images/Cat4.png"></a>
        <a href="/catalog/1"><img src="../../resources/images/Cat5.png"></a>
    </div>
    <#include "template/components/topGoods.ftl" />
</div>
</#macro>
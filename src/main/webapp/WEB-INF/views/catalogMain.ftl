<#include "template/mainTemplate.ftl">
<@mainTemplate title="Каталог товаров" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="mainblock">
    <div align="left">
    ${message!"Сообщения нет!"}
    </div>
    <div align="center">
        <div align="center" style="margin-left: 88pt">
            <img src="../../resources/images/Cart6.png" class="catalog_img" align="left">
            <img src="../../resources/images/Cat3.jpg" class="catalog_img" align="left">
        </div>
        <div  align="center" style="margin-left: 88pt">
            <a href="/catalog/1"><img src="../../resources/images/Cat2.jpg" class="catalog_img" align="left"></a>
            <a href="/catalog/1"><img src="../../resources/images/Cat4.png" class="catalog_img" align="left"></a>
        </div>
        <div  align="center" style="margin-left: 88pt">
            <a href="/catalog/1"><img src="../../resources/images/Cat1.jpg" class="catalog_img" align="left"></a>
            <a href="/catalog/1"><img src="../../resources/images/Cat5.png" class="catalog_img" align="left"></a>
        </div>
    </div>
    <#include "template/components/topGoods.ftl" />
</div>
</#macro>
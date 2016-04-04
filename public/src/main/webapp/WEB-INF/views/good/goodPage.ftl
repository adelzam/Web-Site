<#-- @ftlvariable name="good" type="com.springapp.mvc.common.GoodInfo" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог товаров" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div align="left" class="feedback_main" style="background-color: rgba(255, 245, 238, 0.8);height: 650pt">
    <div>
        <div style="letter-spacing: normal; margin-left: 40pt; margin-top: 10pt; font-size: 18px;">
            <a href="/catalog" style=" color: darkslateblue">Главная</a>/
            <a href="/catalog/${good.category.id}" style=" color: darkslateblue">${good.category.name}</a>
            /${good.name}
        </div>
        <div style="margin-left: 30pt; width: 350pt;margin-top: 10pt; float: left">
            <img src="${good.imageURL!"../../../resources/images/NoImageAvailable.jpg"}" align="middle"/>
        </div>
        <div style="width: 450pt; text-align: center; float: right; margin-right: 30pt; margin-top: 10pt">
            <span>${good.name}</span><br>
            <span style="color: darkred; font-size: 60px">${good.price}&#8381</span>
            <br><br><br>
            <div align="middle"><a href="/cart/add/${good.id}" class="rollover"></a></div>
        </div>
    </div>
    <div style="font-size: 24px; float: left; margin-top: 30pt">
        Дополнительная информация:<br>
        Бренд производителя:
        <br>${good.brand!"-"}<br>
        Страна происхождения:
        <br>${good.country!"-"}<br>
        Категория:
        <br>${good.category.name}<br>
    ${good.description!""}
    </div>
</div>
</#macro>
<#-- @ftlvariable name="good" type="com.springapp.mvc.common.GoodInfo" -->
<#-- @ftlvariable name="goodPath" type="java.util.List<com.springapp.mvc.common.CategoryInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Товар ${good.name}" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div align="left" class="feedback_main" style="background-color: rgba(255, 245, 238, 0.8);height: 670pt">
    <div>
        <div style="letter-spacing: normal; margin-left: 40pt; margin-top: 10pt; font-size: 18px;">
            <a href="/catalog" style=" color: darkslateblue">Главная</a>/
           <#list goodPath as gpath>
                <a href="/catalog/${gpath.id}" style=" color: darkslateblue">${gpath.name}</a>/
            </#list>
            ${good.name}
        </div>
        <div style="margin-left: 30pt; width: 350pt;margin-top: 10pt; float: left">
            <img src="../../../resources/images/catalog/${good.imageURL!"NoImageAvailable.jpg"}" align="middle"
                 style="width: 300pt"/>
        </div>
        <div style="width: 450pt; text-align: center; float: right; margin-right: 30pt; margin-top: 10pt">
            <span>${good.name}</span><br>
            <span style="color: darkred; font-size: 60px">${good.price}&#8381</span>
            <br><br><br>
            <div align="middle"><a href="/cart/add/${good.id}" class="rollover"></a></div>
        </div>
    </div>
    <div style="font-size: 24px; float: left; margin-top: 30pt">
        <div style="color: darkslateblue; text-align: left">Дополнительная информация:</div>
        <div style="color: darkslateblue; text-align: left">Бренд производителя:</div>
        <div style="font-size: 20pt; text-align: right">${good.brand!"-"}</div>
        <div style="color: darkslateblue; text-align: left">Страна происхождения:</div>
        <div style="font-size: 20pt; text-align: right">${good.country!"-"}</div>
        <div style="color: darkslateblue; text-align: left"> Категория:</div>
        <div style="font-size: 20pt; text-align: right">${good.category.name}</div>
        <div style="font-size: 20pt; text-align: right"> ${good.description!""}</div>
    </div>
</div>
</#macro>
<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="category" type="java.lang.String" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог товаров: ${category}" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div align="left" class="catalog_blog">
    <div align="center" style="margin-left: 10pt">
        <#list goods as good>
            <div class="goodblock" style="margin-left: 30pt;">
                <img src="../../../resources/images/catalog-top.png" style="width: 210pt">
                <div style="background-color:white; margin-top: -3pt; width: 210pt">
                    <a href="/goods/${good.id}"><img src="../../../resources/images/catalog/${good.imageURL!"NoImageAvailable.jpg"}"
                         style="width: 150pt; margin-top: 10pt"/></a>
                    <div align="center">
                        <a href="/goods/${good.id}" class="catalog_good_description">${good.name}</a><br>
                        <span class="catalog_good_description">${good.category.name}</span><br>
                            <span class="catalog_good_description" style="color: red">${good.price?number}
                                &#8381</span><br>
                        <a href="/cart/add/${good.id}" style="margin-left: -6pt"><img
                                src="../../../resources/images/buy.png" style="width: 100pt"></a>
                        <br><br>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</#macro>
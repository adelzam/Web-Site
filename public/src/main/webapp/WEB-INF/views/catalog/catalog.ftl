<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="brands" type="java.util.List<com.springapp.mvc.common.BrandInfo>" -->
<#-- @ftlvariable name="filters" type="java.util.List<com.springapp.mvc.common.FilterInfo>"-->
<#-- @ftlvariable name="category" type="com.springapp.mvc.common.CategoryInfo" -->
<#-- @ftlvariable name="banner" type="java.lang.String" -->

<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Каталог товаров: ${category.name}" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div align="center" class="catalog_blog">
    <div style="display: inline-block; width: 800pt;">
        <#if brands??>
            <#list brands as brand>
                <div class="brand_block_in_catalog">
                    <a href="/catalog/${category.id}/${brand.id}"> <img
                            src="../../../resources/images/catalog/${brand.imageURL!"NoImageAvailable.jpg"}"
                            class="brand_image_catalog"></a>
                    <br><span class="brand_good_description">${brand.name}</span>
                </div>
            </#list>
        </#if>
    </div>
    <#if !brands??>
        <#if filters??>
        <div align="center">
            <#list filters as filter>
                <a href="?order=${filter.name}&price=null&roast=null"><div class="filters">${filter.description}</div></a>
            </#list>
        </div>
        </#if>
        <#if banner??>
            <img src="../../../resources/images/catalog/${banner}" style="width: 800pt" align="center">
        </#if>
        <div align="center" class="good_block_in_catalog">
            <#list goods as good>
                <div class="goodblock" style="margin-left: 30pt;">
                    <img src="../../../resources/images/catalog-top.png" style="width: 210pt">
                    <div class="good_description_block">
                        <a href="/goods/${good.id}"><img
                                src="../../../resources/images/catalog/${good.imageURL!"NoImageAvailable.jpg"}"
                                class="good_image_catalog"/></a>
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
    </#if>
</div>
</#macro>
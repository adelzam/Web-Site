<#-- @ftlvariable name="goods" type="java.util.List<com.springapp.mvc.common.GoodInfo>" -->
<#-- @ftlvariable name="brands" type="java.util.List<com.springapp.mvc.common.BrandInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Страничка админа" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="catalog_blog" style="margin-bottom: 40pt; margin-top: 20pt">
    <br>
    <span class="admin_text">Управление списком товаров</span>
    <br>
    <a href="/admin/newgood" class="admin-add-button">
        <img src="../../../resources/images/plus.png" style="width: 20pt"><span class="admin-add-text"> Добавить новый товар</span>
    </a>
    <div class="scroll" align="center">
        <div class="admin_page_head">
            <div style="width: 30pt" class="admin_div">id</div>
            <div style="width: 80pt;" class="admin_div">Фото</div>
            <div style="width: 100pt;" class="admin_div">Название</div>
            <div style="width: 100pt;" class="admin_div">Бренд</div>
            <div style="width: 100pt;" class="admin_div">Страна</div>
            <div style="width: 150pt;" class="admin_div">Описание</div>
            <div style="width: 60pt;" class="admin_div">Цена</div>
            <div style="width: 100pt;" class="admin_div">Категория</div>
            <div style="width: 100pt;" class="admin_div">Прожарка</div>
            <div style="width: 60pt;" class="admin_div">Удалить</div>
        </div>
        <#list goods as good>
            <div class="admin_page_line">
                <div style="width: 30pt" class="admin_div2">${good.id!"-"}</div>
                <div style="width: 80pt;" class="admin_div2">
                    <img src="../../../resources/images/catalog/${good.imageURL!"NoImageAvailable.jpg"}"
                         style="width: 60pt; margin-left: 10pt; margin-top: 5pt">
                </div>
                <div style="width: 100pt;" class="admin_div2">${good.name!"-"}</div>
                <div style="width: 100pt;" class="admin_div2">${good.brand.name!"-"}</div>
                <div style="width: 100pt;" class="admin_div2">${good.country!"-"}</div>
                <div style="width: 150pt;" class="admin_div2">${good.description!"-"}</div>
                <div style="width: 60pt;" class="admin_div2">${good.price!"-"}</div>
                <div style="width: 100pt;" class="admin_div2">${good.category.name!"-"}</div>
                <div style="width: 100pt;" class="admin_div2">${good.roast!"-"}</div>
                <div style="width: 60pt;" class="admin_div2"><a href="/admin/deletegood/${good.id}"><br><img
                        src="../../../resources/images/delete.png" style="width: 16pt; margin-left: 12pt"></a></div>
            </div>
        </#list>
    </div>

    <br>
    <span class="admin_text">Управление списком бендов</span>
    <br>
    <a href="/admin/newbrand" class="admin-add-button" style="margin-left: 375pt">
        <img src="../../../resources/images/plus.png" style="width: 20pt"><span class="admin-add-text"> Добавить новый бренд</span>
    </a>
    <div class="scroll" align="center" style="width: 360pt; margin-left: 350pt">
        <div class="admin_page_head" style="width: 340pt">
            <div style="width: 30pt" class="admin_div">id</div>
            <div style="width: 80pt;" class="admin_div">Фото</div>
            <div style="width: 150pt;" class="admin_div">Название</div>
            <div style="width: 60pt;" class="admin_div">Удалить</div>
        </div>
        <#list brands as good>
            <div class="admin_page_line" style="width: 340pt">
                <div style="width: 30pt" class="admin_div2">${good.id!"-"}</div>
                <div style="width: 80pt;" class="admin_div2">
                    <img src="../../../resources/images/catalog/${good.imageURL!"NoImageAvailable.jpg"}"
                         style="width: 60pt; margin-left: 10pt; margin-top: 5pt">
                </div>
                <div style="width: 150pt;" class="admin_div2">${good.name!"-"}</div>
                <div style="width: 60pt;" class="admin_div2"><a href="/admin/deletebrand/${good.id}"><br><img
                        src="../../../resources/images/delete.png" style="width: 16pt; margin-left: 12pt"></a></div>
            </div>
        </#list>
    </div>
    <br>
    <br>
</div>
</#macro>
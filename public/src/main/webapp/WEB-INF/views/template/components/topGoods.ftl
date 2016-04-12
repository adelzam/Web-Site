<#-- @ftlvariable name="top" type="java.util.List<com.springapp.mvc.common.GoodInfo>"-->
<div style="margin-left: 135pt">
<#list top as good>
    <div class="goodblock">
        <img src="../../../../resources/images/catalog-top.png" style="width: 210pt; opacity: 0.9">
        <div style="background-color:white; margin-top: -3pt; height: 100%; opacity: 0.9" align="center"><a href="/goods/${good.id}"><img
                src="../../../resources/images/catalog/${good.imageURL!"NoImageAvailable.jpg"}"
                class="good_image_catalog" align="center"/></a>
            <div align="center">
                <a href="/goods/${good.id}" class="catalog_good_description">${good.name}</a><br>
                <span class="catalog_good_description">${good.category.name}</span><br>
                            <span class="catalog_good_description" style="color: red">${good.price?number}
                                &#8381</span><br>
                <a href="/cart/add/${good.id}" style="margin-left: -6pt"><img
                        src="../../../../resources/images/buy.png" style="width: 100pt"></a>
                <br><br>
            </div>
        </div>
    </div>
</#list>
</div>
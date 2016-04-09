<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Корзина" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="feedback_main">
    <p align="center" style="font-weight: 500">Товары в корзине</p>
    <div class="cart_head">
        <div style="width: 110pt" class="cart_div">Фото</div>
        <div style="width: 300pt;" class="cart_div">Название, артикул, описание</div>
        <div style="width: 120pt;" class="cart_div">Цена</div>
        <div style="width: 140pt;" class="cart_div">Кол-во</div>
        <div style="width: 120pt;" class="cart_div">Итого</div>
        <div style="width: 40pt;" class="cart_div"></div>
    </div>
    <#list (Session.sessionCart![]) as good>
        <#if !limit?? || good_index < limit>
            <div class="cart_line">
                <div style="width: 110pt" class="cart_div2"><a href="/goods/${good.goodInfo.id}"> <img
                        src="../../../resources/images/catalog/${good.goodInfo.imageURL!"NoImageAvailable.jpg"}"
                        style="width: 100pt; margin-left: 5pt; margin-top: 5pt"></a>
                </div>
                <div style="width: 300pt;" class="cart_div2"><br>${good.goodInfo.name}
                    <br>MK${good.goodInfo.id}0976${good.goodInfo.id}</div>
                <div style="width: 120pt;" class="cart_div2"><br>${good.goodInfo.price?number}&#8381</div>
                <div style="width: 140pt;" class="cart_div2"><br>
                    <div>
                        <a href="/cart/remote/${good_index}" style="text-decoration: none">
                            <img src="../../../resources/images/minus.png" style="width: 16pt">
                        </a>&#8194 ${good.number} &#8194<a href="/cart/add/${good.goodInfo.id}"
                                                           style="text-decoration: none">
                        <img src="../../../resources/images/plus.png" style="width: 16pt">
                    </a>
                    </div>
                </div>
                <div style="width: 120pt; color: red" class="cart_div2"><br>
                    <script>document.write(${good.number} *${good.goodInfo.price?number}
                    )</script>
                    &#8381
                </div>
                <div style="width: 40pt;" class="cart_div2"><a href="/cart/remotegood/${good_index}"><br><img
                        src="../../../resources/images/delete.png" style="width: 16pt; margin-left: 12pt"></a></div>
            </div>
        </#if>
    </#list>
    <br>
    <br>
    <div align="right" style="width: 830pt; margin-left: 15pt">
        <a href="/cart/clear"><img src="../../../resources/images/clearCart.png"></a>
        <a href="/order"><img src="../../../resources/images/createOrder.png"></a>
    </div>

</div>

</#macro>
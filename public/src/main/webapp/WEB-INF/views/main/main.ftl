<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Главная" styles=["css/style.css"] scripts=["js/jquery.cycle.all.min.js","js/script.js"]/>
<#macro m_body>
<!-- подключение библиотеки jQuery -->
<script src="../../../resources/js/jquery-2.2.2.min.js"></script>
<div align="center">
    <div class="slider">
        <a href="/catalog/5"> <img src="../../../resources/images/coffe2.jpg"></a>
        <a href="/catalog/1"> <img src="../../../resources/images/coffe1.jpg"></a>
        <a href="/catalog/1/3"> <img src="../../../resources/images/coffe3.jpg"></a>
    </div>
    <#include "../template/components/topGoods.ftl" />
</div>
</#macro>
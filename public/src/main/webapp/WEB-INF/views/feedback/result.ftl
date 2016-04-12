<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Обратная связь" styles=["css/style.css"] scripts=["js/script.js"] />
<#macro m_body>

<div class="feedback_main" align="center">
    <h1>Ваша заявка принятя! Ждите ответа!<br>
        Ваш звонок очень важен для нас!</h1>

    <a href="feedbackPage">Назад</a>
</div>
</#macro>
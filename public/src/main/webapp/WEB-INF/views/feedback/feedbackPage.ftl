<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Обратная связь" styles=["css/style.css"] scripts=["js/script.js"] />
<#macro m_body>
<div align="center" class="feedback_main">
    <div>
        <span style="font-weight: 500; letter-spacing: 18px">Свяжитесь с нами</span>
        <div style="margin-top: 20pt; margin-bottom: 30pt;">
            <div style="margin-bottom: 20pt;"><img src="../../../resources/images/address.png" style="width: 40pt;">&nbsp&nbsp&nbsp&nbsp<span
                    style="vertical-align: top">Roma - Via del Corso 330, 00186</span></div>
            <div style="margin-bottom: 20pt;"><img src="../../../resources/images/Phone.png" style="width: 40pt;">&nbsp&nbsp&nbsp&nbsp<span
                    style="vertical-align: top">+39 06 697 6361 / +39 329 7007709</span></div>
            <div style="margin-bottom: 20pt;"><img src="../../../resources/images/mail.png" style="width: 40pt;">&nbsp&nbsp&nbsp&nbsp<span
                    style="vertical-align: top">info@tangocoffee.com</span></div>
        </div>
        <div style="margin-top: 20pt;">
            <span style="font-weight: 500; letter-spacing: 18px">Мы в социальных сетях</span>
            <div style="margin-top: 20pt;">
                <a href="https://www.facebook.com"><img src="../../../resources/images/FB.png" style="margin-right: 40pt; width: 80pt"></a>
                <a href="https://vk.com"><img src="../../../resources/images/VK.png" style="margin-right: 40pt;width: 80pt"></a>
                <a href="https://twitter.com"><img src="../../../resources/images/TW.png" style="margin-right: 40pt;width: 80pt"></a>
                <a href="https://ok.ru"> <img src="../../../resources/images/OK.png" style="width: 80pt"></a>
            </div>
        </div>
    <div>
        <span style="font-weight: 500; letter-spacing: 18px">Обратная связь</span>
        <@form.form commandName="feedbackForm" action="/feedback" acceptCharset="UTF-8" method="post">
            <div>
                <div class="feedback_div">
                    <span>Имя<label>*</label></span>
                    <@form.input path="name" cssClass="feedback_input_form"/>
                    <@form.errors path="name" cssClass="form_error" /><br><br></div>
                <div class="feedback_div">
                    <span>Email<label>*</label></span>
                    <@form.input path="email" cssClass="feedback_input_form"/>
                    <@form.errors path="email" cssClass="form_error" /><br><br>
                </div>
                <div class="feedback_div">
                    <span>Тема обращения<label>*</label></span>
                    <@form.input path="sub" cssClass="feedback_input_form"/>
                    <@form.errors path="sub" cssClass="form_error" /><br><br>
                </div>
                <div class="feedback_div">
                    <span>Текст обращения<label>*</label></span>
                    <@form.textarea path="message" cssClass="feedback_input_form" cssStyle="height: 300px;"/>
                    <@form.errors path="message" cssClass="form_error" /><br><br>
                </div>
            </div>
            <div class="but__center"><input type="submit" value="Отправить &gt;&gt;"></div>
        </div>
        </@form.form>
    </div>
</#macro>
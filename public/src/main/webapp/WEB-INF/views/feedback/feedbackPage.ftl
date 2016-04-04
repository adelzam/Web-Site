<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Обратная связь" styles=["css/style.css"] scripts=["js/script.js"] />
<#macro m_body>
<div align="center" class="feedback_main">
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
            <div class="but__center"><input type="submit" value="Send message &gt;&gt;"></div>
        </div>
        </@form.form>
    </div>
</#macro>
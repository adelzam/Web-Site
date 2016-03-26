<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Обратная связь" styles=["css/style.css"] scripts=["js/script.js"] />
<#macro m_body>
<div class="men">
    <div class="container">
    <#--<#include "contactInfo.ftl">-->
    <div class="contact_form">
        <h2>Feedback</h2>
        <@form.form commandName="feedbackForm" action="/feedback" acceptCharset="UTF-8" method="post">
            <div class="col-md-6 to">
                <div>
                    <span>Name<label>*</label></span>
                    <@form.input path="name" />
                    <@form.errors path="name" cssStyle="color: red;" /></div>
                <div>
                    <span>Email<label>*</label></span>
                    <@form.input path="email" />
                    <@form.errors path="email" cssStyle="color: red;" />
                </div>
                <div>
                    <span>Subject<label>*</label></span>
                    <@form.input path="sub" />
                    <@form.errors path="sub" cssStyle="color: red;" />
                </div>
            </div>
            <div class="col-md-6 text">
                <div>
                    <span>Message<label>*</label></span>
                    <@form.textarea path="message" />
                    <@form.errors path="message" cssStyle="color: red;" />
                </div>
            </div>
            <div></div>
            <div class="but__center"><input type="submit" value="Send message &gt;&gt;"></div>
        </div>
        </@form.form>
    </div>
</div>
</#macro>
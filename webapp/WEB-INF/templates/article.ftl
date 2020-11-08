<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/>
<div style="display: flex">
    <@menu/>
    <div class="articleStyle">
        <img src="${userProfile.getImagePath()}" style="height:150px;width: 120px;padding-right: 20px"/>

        <div style="display: block">
        Author:${user.getLogin()}
        <br>
        Title:${article.getTitle()}
        <br>
        <br>
        <div class="articleText">
            ${article.getText()}
        </div>
    </div>
    </div>
</div>
</div>
</body>
</html>
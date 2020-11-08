<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/>
<div style="display: flex">
<@menu/>
    <div class="userProfileData">
    <img src="${icon}" width="160px" height="200px" style="margin: 20px;"/>
        <div class="userProfileTextData">
        <br>
        ${login}
        <br>
        <br>
        Number of published article: ${articlesCount}
            <br>
            <br>
            <@search_template/>
        </div>
    </div>
</div>
</body>
</html>
<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/>
<div style="display: flex">
    <@menu/>
    <div style="display: block">
        <#list articles as article>
            <div class="miniArticleStyle" >
                Author: ${login}
                <br>
                <a href="http://localhost:8081/myArticle/article?id=${article.getId()}">
                Title: "${article.getTitle()}"
                </a>
                <br>
                <a href="http://localhost:8081/myArticle/changeArticle?id=${article.getId()}">
                <button name = "changeButton" class="changeButtonStyle">
                    Change
                </button>
                </a>
                <div style="padding-left: 300px">
                Date: ${article.getDate()}
                </div>
             </div>
        <#else>
            <div class="notFound">
                You don't have any published articles
            </div>
        </#list>
    </div>
</div>
</body>
</html>
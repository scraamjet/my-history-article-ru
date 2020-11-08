<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/>
<div style="display: flex">
    <@menu/>
    <div style="display: block">
        <#list articles as article>
            <div class="miniArticleStyle" >
                Author: ${article.getUserLogin()}
                <br>
                <a href="http://localhost:8081/myArticle/article?id=${article.getId()}">
                    Title: "${article.getTitle()}"
                </a>
                <br>
                <br>
                <div style="padding-left: 400px">
                    Date: ${article.getDate()}
                </div>
            </div>
            <#else>
            <div class="notFound">
                No results were found for your search.
            </div>
        </#list>
    </div>

</div>
</body>
</html>
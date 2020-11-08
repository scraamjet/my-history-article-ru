<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/><div style="display: flex">
<@menu/>
    <form method="post" style="margin-left: 150px; margin-top: 50px;display: block">
        <input type="text" class="titleArea" name="title" placeholder="Insert the title of your article" value="${articleTitle}">
        <br>
        <br>
        <textarea class="textArea" name="text" placeholder="Your article...">
            ${articleText}
        </textarea>
        <br>
        <br>
        <div style="display: flex">
        <input type="submit" class="changeArticleSubmit" value="Change" name="change">
        <input type = "submit" class="deleteArticleSubmit" value="Delete" name="delete">
        </div>
    </form>

</div>
</div>
</body>
</html>
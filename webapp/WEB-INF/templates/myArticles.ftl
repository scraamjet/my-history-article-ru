<#ftl encoding="Windows-1251">
<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <meta charset="UTF-8">
    <title></title>

    <style>
        .MyHistoryArticleHeader{
            height: 45px;
            width: 1533px;
            margin-top: -10px;
            color: bisque;
            margin-right: -15px;
            margin-left: -15px;
            padding-left: 10px;
            font-size: 38px;
            font-family: Harrington,serif;
            background-color:indianred;
            display: flex;
        }

        .searchSubmit{
            height: 26px;
            width: 80px;
            background-color: wheat;
            color:indianred;
            font-size: 15px;
            border-radius: 20px;
        ]        }
        .HeaderInput{
            margin-left: 100px;
            height: 27px;
            width: 370px;
            border-radius: 10px;
            background-color: wheat;
            color: red;
            padding-left: 7px;
        }
        .searchForm{
            margin-top: -7px;
        }
        .functionalList{
            display: block;
            margin-left: 200px;
            margin-top: 20px;
        }
        .functionalListButton{
            display: flex;
            background-color: indianred;
            color: bisque;
            font-size: 20px;
            height: 30px;
            width: 200px;
            border: none;
            padding-top: 3px;
            padding-left: 55px;
            margin-top: 10px;
        }

        #userIcon{
            margin-left: 10px;
        }

        a{
            text-decoration: none;
        }
        .titleArea{
            width: 820px;
        }
        .textArea{
            width: 820px;
            height: 500px;
        }
        .addArticleSubmit{
            height: 28px;
            width: 80px;
            background-color: indianred;
            color:wheat;
            font-size: 15px;
            border-radius: 20px;
            margin-left: 680px;
        }
        .miniArticleStyle{
            padding-top: 5px;
            padding-left: 5px;
            display: block;
            height: 100px;
            width: 600px;
            background-color: indianred;
            color: wheat;
            font-size: 20px;
            margin-left: 150px;
            margin-top: 50px;
        }
    </style>
</head>
<body bgcolor="#ffe4c4">
<#if message?has_content>
    <p>${message}</p>
</#if>
<div style="display: flex">
    <div class="MyHistoryArticleHeader">
        MyHistoryArticle.ru
    </div>
</div>
<div style="display: flex">
    <div class="functionalList">
        <a href="http://localhost:8081/myArticle/profile" aria-hidden="true">
            <button class="functionalListButton" name="myProfile">
                My profile
            </button>
        </a>
        <button class="functionalListButton" name="myArticles">
            My articles
        </button>
        <button class="functionalListButton" name="news" style="padding-left:75px ">
            News
        </button>
        <button class="functionalListButton" name="news" style="padding-left: 67px">
            Options
        </button>
        <form method="post">
            <input type="submit" class="functionalListButton" style="padding-left: 10px" value="Exit" name="exit"/>
        </form>
    </div>
    <div style="display: block">
        <#list articles as article>
            <div class="miniArticleStyle" >
                Author: ${login}
                <br>
                <a href="http://localhost:8081/myArticle/article?id=${article.getId()}">
                Title: "${article.getTitle()}"
                </a>
                <br>
                Article average rate: ${article.getAverageRate()}
                <br>
                <div style="padding-left: 400px">
                Date: ${article.getDate()}
                </div>
             </div>
        </#list>
    </div>
</div>
</body>
</html>
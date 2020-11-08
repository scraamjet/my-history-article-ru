<#macro main>
    <#include "search-template.ftl"/>
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
                background-color: indianred;
                display: flex;
            }

            .searchSubmit{
                background-color: indianred;
                color:wheat;
                font-size: 20px;
                font-weight: bold;
                display: flex;
                border-radius: 20px;
                margin-bottom:20px;
                width: 230px;
                height: 35px
            }
            .formSearchSubmit{
                background-color: indianred;
                color:wheat;
                font-size: 20px;
                font-weight: bold;
                margin-left:85px;
                border-radius: 20px;
                margin-bottom:20px;
                width: 230px;
                height: 35px
            }
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
                margin-left: 170px;
                margin-top: 20px;
                background-color:wheat;
                padding: 15px;
                height: 220px;
                border-radius:20px;
                border: medium solid indianred;
            }
            .functionalListButton{
                display: flex;
                background-color: indianred;
                color: bisque;
                font-size: 20px;
                height: 30px;
                width: 200px;
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
                margin-left: 677px;
            }
            .changeArticleSubmit{
                height: 28px;
                width: 80px;
                background-color:cadetblue;
                color:wheat;
                font-size: 15px;
                border-radius: 20px;
                margin-left: 670px;
            }
            .deleteArticleSubmit{
                height: 28px;
                width: 80px;
                background-color: indianred;
                color:wheat;
                font-size: 15px;
                border-radius: 20px;
                margin-left: 3px;
            }
            .miniArticleStyle{
                padding-top: 5px;
                padding-left: 5px;
                border: medium solid indianred;
                display: block;
                border-radius: 20px;
                height: 130px;
                width: 600px;
                background-color: wheat;
                color: indianred;
                font-weight: bold;
                font-size: 20px;
                margin-left: 150px;
                margin-top: 50px;
            }
            .changeButtonStyle{
                width: 80px;
                height: 30px;
                margin-left: 500px;
                background:cadetblue;
                color: wheat;
                border-radius: 10px;
            }
            .optionalListButton{
                display: flex;
                background:cadetblue;
                color: wheat;
                border-radius: 10px;
                font-size: 20px;
                height: 30px;
                width: 350px;
                border: none;
                padding-top: 3px;
                text-align: center;
                margin-top: 10px;
            }
            .optionalFunctionalList{
                display: block;
                margin-left: 320px;
                margin-top: 50px;
                border: medium solid indianred;
                background-color: wheat;
                color: indianred;
                padding: 20px;
                border-radius:20px;
            }
            .titleSearchForm{
                background-color: wheat;
                color: indianred;
                border: medium solid indianred;
                margin-left: 350px;
                margin-top: 100px;
                height: 200px;
                width: 400px;
                border-radius: 20px;
            }
            .articleStyle{
                background: wheat;
                padding: 7px;
                width: 950px;
                display: flex;
                font-weight: bold;
                border-radius: 20px;
                margin-top: 30px;
                font-size: 20px;
                border: medium solid indianred;
                color: indianred;
                margin-left: 80px;
            }
            .changeAvatarForm{
                background-color: wheat;
                color: indianred;
                margin: auto;
                height: 150px;
                border-radius: 20px;
                border: medium solid indianred;
            }
            .userProfileData{
                margin-left: 130px;
                font-size: 30px;
                margin-top: 20px;
                display: flex;
                width: 630px;
                background-color: wheat;
                border-radius:20px ;
                border: medium solid indianred;
            }
            .userProfileTextData{
                font-size: 30px;
                margin-left: 20px;
                font-weight: bold;
                color: indianred;
                display: block;
            }
            .notFound{
                font-size: 35px;
                background-color: indianred;
                color: wheat;
                border-radius: 7px;
                margin-left: 280px;
                margin-top: 50px;
            }
            .loadIconButton{
                margin-left: 10px;
                background-color: indianred;
                color: wheat;
                border: medium solid indianred;
                border-radius: 20px;
                font-size: 15px;
                font-weight: bold;
            }
            .message{
                background-color: wheat;
                color:indianred;
                font-size: 18px;
                height: 35px;
                width: 1533px;
                margin-top: -10px;
                margin-left: -15px;
                padding-left: 10px;
            }
            body{
                background-image:url("drawable/background.jpg");
                background-size: cover;
            }
        </style>
    </head>
<body>
    <#if message?has_content>
        <div class="message">${message}</div>
    </#if>
    <div style="display: flex">
        <div class="MyHistoryArticleHeader">
            MyHistoryArticle.ru
        </div>
    </div>
</#macro>
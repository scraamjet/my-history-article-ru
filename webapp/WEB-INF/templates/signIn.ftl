<#ftl encoding="Windows-1251">
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
    <style>
        .MyHistoryArticleHeader{
            height: 45px;
            width: 1533px;
            margin-top: -10px;
            color: bisque;
            margin-left: -15px;
            padding-left: 10px;
            font-size: 38px;
            font-family: Harrington,serif;
            background-color:indianred;
        }
        .signInForm{
            margin-top: 230px;
            margin-left: 550px;
        }
        .logLabel{
            font-size: 24px;
            color:black;
            margin-left: 59px;
            margin-bottom: 7px;

        }
        .logPasInput{
            padding-left: 10px;
            height: 30px;
            width: 370px;
            border-radius: 10px;
        }
        .confirmSubmit{
            height: 50px;
            width: 370px;
            text-align: center;
            background-color: indianred;
            color:white;
            font-size: 22px;
            border-radius: 20px;
        }
        .signUpLink{
            margin-top: 10px;
            margin-left: 620px;
            font-size: 18px;
        }
    </style>
</head>
<body bgcolor="#ffe4c4">
<#if message?has_content>
    <p>${message}</p>
</#if>
<div class="MyHistoryArticleHeader">
    MyHistoryArticle
</div>
<form method="post" class = signInForm>
    <label class="logLabel">Have an account? Sign in!</label>
    <br>
    <input class = "logPasInput" type="text" name="login" placeholder="login"/>
    <br>
    <input class="logPasInput" type="password" name="password" placeholder="password"/>
    <br>
    <br>
    <input type="submit" class="confirmSubmit" value="Sign In"/>
</form>

<a class="signUpLink" href="http://localhost:8081/myArticle/signUp">
    Don't have an account? SignUp!
</a>

</body>
</html>
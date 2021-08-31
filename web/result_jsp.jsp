<%-- 
    Document   : result_jsp.jsp
    Created on : 30-Aug-2021, 05:55:57
    Author     : m.boopathi
--%>

<%@page import="myservlet.GetQuestions"%>
<%@page import="myservlet.Marks,dao.Dao,myservlet.UserDetails" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result</title>     

    <!-- Bootstrap stylesheet -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- font-awesome -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" integrity="undefined" crossorigin="anonymous">

    <script src="https://kit.fontawesome.com/6c7c7565ca.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/icheck-bootstrap/3.0.1/icheck-bootstrap.min.css">

    <!-- Local stylesheets -->
    <link rel="stylesheet" href="assets/css/style.css">

    

</head>

<body>


    <div class="container result">
        <div class="bgWhite">

            <div class="score text-center">
                <img src="./assets/images/result.png" alt="Result image" class="resultImage">
                <h2>Result</h2>
                <% 
                if(GetQuestions.count==10){
                    String check=request.getParameter("question");
                    System.out.println("correctAns-----"+GetQuestions.correctAns);
                    System.out.println("check-----"+check);
                    if(GetQuestions.correctAns.equals(check)){
                        Marks.marks++;
                        System.out.println("marks----"+Marks.marks);
                    }
                }
                Dao.saveUserEmailId(UserDetails.name, UserDetails.emailid, Marks.marks); 
                %>
                <h5>Hello <%=UserDetails.name%>, You scored</h5>
                <div class="points">
                    <span><%= Marks.marks%>/10</span>
                </div>
                <br>
                <a href="allScores.jsp" style="text-decoration: underline;"><p>To view all scores, click here.</p></a>
            </div>

        </div>
    </div>

    <!-- Footer -->
    <div class="container footer mb-4">
        <h5 class="text-center"> Online Assessment Platform </h5>
    </div>

    <!-- Javascript files  -->

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>

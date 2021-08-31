<%-- 
    Document   : allScores
    Created on : 31-Aug-2021, 19:50:14
    Author     : m.boopathi
--%>

<%@page import="myservlet.Marks,dao.Dao,myservlet.UserDetails,java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Assessment Platform | All Scores</title>     

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


    <div class="container allScores">
        <div class="row bgWhite">
            <div class="col-12 text-center">
                <h2>All Scores</h2>
            </div>
            <table>
                <tr>
                    <th>Serial No.</th>
                    <th>Name</th>
                    <th>Score</th>
                </tr>
                <%
                    ArrayList<String> arrList=Dao.fetchResults();
                    int count=1;
                    for(String s:arrList){
                        String[] arr=s.split(",");
                        out.println("<tr><td>"+count+"</td><td>"+arr[0]+"</td><td>"+arr[1]+"</td></tr>");
                        count++;
                    }
                %>    
            </table>
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

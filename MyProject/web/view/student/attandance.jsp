<%-- 
    Document   : attandance
    Created on : Oct 24, 2022, 5:27:27 PM
    Author     : Mr Thinh
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">

            <div class="row header" style="border-bottom: 1px solid">
                <div>
                    <h1>FPT University Academic Portal</h1>
                </div>
                <table >
                    <tbody>
                        <tr>
                            <td>
                                FAP mobile app (myFAP) is ready at
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="https://apps.apple.com/app/id1527723314">
                                    <img src="https://fap.fpt.edu.vn/images/app-store.svg" style="width: 120px; height: 40px" alt="apple store">
                                </a>
                            </td>
                            <td>
                                <a href="https://fap.fpt.edu.vn/images/play-store.svg">
                                    <img src="https://fap.fpt.edu.vn/images/play-store.svg" style="width: 120px; height: 40px" alt="google play">
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            

            <div class="row header">

                <div class="name-title" style="padding-top: 40px; font-weight: bold;">
                    <p style="font-size: 30px; text-align: center;">Activities for IOT1601(JPD123)</p>
                </div>
                
                <div>
                    <c:if test="${requestScope.students ne null}">
                    <table style="width: 100%; padding-right: 20px;">
                        <thead style="background-color: aquamarine; height: 100px;">
                            <tr>
                                <th style="border-top: 1px solid black; padding: auto;">IMAGE</th>-->
                                <th style="border-top: 1px solid black; padding: auto;">MEMBER</th>
                                <th style="border-top: 1px solid black; padding: auto;">CODE</th>
                                <th style="border-top: 1px solid black; padding: auto;">SURNAME</th>
                                <th style="border-top: 1px solid black; padding: auto;">MIDDLE NAME</th>
                                <th style="border-top: 1px solid black; padding: auto;">GIVEN NAME</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.students}" var="s">
                            <tr>
                                <td style="border-top: 1px solid black; padding: auto;">
                                <center>
                                    <img src="http://www.fao.org/fileadmin/templates/experts-feed-safety/images/profile-img03.jpg" alt="HE153140" style="height:146px;width:111px;border-width:0px;">
                                </center></td>
                                <td style="border-top: 1px solid black; padding: auto;">${s.stmember}</td>
                                <td style="border-top: 1px solid black; padding: auto;">${s.stid}</td>
                                <td style="border-top: 1px solid black; padding: auto;">${s.stsurname}</td>
                                <td style="border-top: 1px solid black; padding: auto;">${s.stmiddlename}</td>
                                <td style="border-top: 1px solid black; padding: auto;">${s.stgivenname}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                </div>
            </div>
        </div>
        
        <form action="attendance" method="POST">
            <input type="submit" value="Search" style="text-align: center"/>
        </form>  
        
        <br/>
        <br/>
        <div class="footer">
            <p><strong>Mọi góp ý, thắc mắc xin liên hệ:</strong>Phòng dịch vụ sinh viên: Email: dichvusinhvien@fe.edu.vn. Điện thoại: <strong>(024)7308.13.13</strong></p>
        </div>
    
    <script src="js/Jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>
</html>
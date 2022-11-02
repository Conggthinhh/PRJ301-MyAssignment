<%-- 
    Document   : attandance
    Created on : Oct 24, 2022, 5:25:38 PM
    Author     : Mr Thinh
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="helper" class="util.DateTimeHelper"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- CSS only -->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row col-md-12" style="border-bottom: 1px solid; padding: 10px;">
                <div class="col-md-6">
                    <h1>FPT University Academic Portal</h1>
                </div>
                <table class="col-md-6">
                    <tbody>
                        <tr>
                            <td style="padding-left: 200px;">
                                FAP mobile app (myFAP) is ready at
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-left: 200px;">
                                <a href="https://apps.apple.com/app/id1527723314">
                                    <img src="https://fap.fpt.edu.vn/images/app-store.svg" style="width: 120px; height: 40px" alt="apple store">
                                </a>
                            </td>
                            <td style="padding-right: 100px;">
                                <a href="https://fap.fpt.edu.vn/images/play-store.svg">
                                    <img src="https://fap.fpt.edu.vn/images/play-store.svg" style="width: 120px; height: 40px" alt="google play">
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>    
            </div>
            <div class="row col-md-12" style="padding: 10px 0px 10px 10px; background-color: #F5F5F5;">
                <p><a href="" style="font-size: 15px">Home</a> |
                    <a href="" style="font-size: 15px">Check Attendance</a></p>
            </div> 
            <br/>
            <br/>
            <h1 style="padding-left: 580px">Take Attendance</h1> <br/>
            <h2 style="padding-left: 600px">Group: ${requestScope.ses.group.name} </h2><br/>
            <div class="row header" style="padding-left: 50px">
                <h4 style="padding-left: 10px">Subject: ${requestScope.ses.group.subject.name}</h4><br/>
                <h4 style="padding-left: 10px">Room: ${requestScope.ses.room.name} </h4><br/>
                <h4 style="padding-left: 10px">Date: ${requestScope.ses.date} - Time Slot: ${requestScope.ses.timeslot.description}</h4><br/>
                <h4 style="padding-left: 10px">Attended: 
                    <c:if test="${requestScope.ses.attanded}">
                        <h4 style="color: green;">Yes</h4>
                    </c:if>
                    <c:if test="${!requestScope.ses.attanded}">
                        <h4 style="color: red;">No</h4>
                    </c:if></h4><br/>
            </div>
            <br/>
            <br/>
            <div class="col-md-12">
                <form action="attendance" method="POST">
                    <input type="hidden" name="sesid" value="${param.id}"/>
                    <table style =" width: 100%;">
                        <thead style="background-color: #6B90DA;">
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">No.</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Image</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Student ID</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Full Name</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Present</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Absent</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Description</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.ses.atts}" var="a" varStatus="loop">
                                <tr>
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px">${loop.index+1}</td>
                                    <td style="border: 1px solid ; padding: auto;">
                            <center>
                                <img src="http://www.fao.org/fileadmin/templates/experts-feed-safety/images/profile-img03.jpg" alt="HE153140" style="height:146px;width:111px;border-width:0px;">
                            </center></td>
                            <td style="height: 100px; border: 1px solid; padding-left: 20px">${a.student.member}
                                <input type="hidden" name="stdmember" value="${a.student.member}"/>
                            </td>
                            <td style="height: 100px; border: 1px solid; padding-left: 20px">${a.student.name}</td>
                            <td style="height: 100px; border: 1px solid; padding-left: 20px"><input type="radio"
                                                                                                    <c:if test="${a.present}">
                                                                                                        checked="checked"
                                                                                                    </c:if>
                                                                                                    name="present${a.student.id}" value="present" /></td>
                            <td style="height: 100px; border: 1px solid; padding-left: 20px"><input type="radio"
                                                                                                    <c:if test="${!a.present}">
                                                                                                        checked="checked"
                                                                                                    </c:if>
                                                                                                    name="present${a.student.id}" value="absent" /></td>
                            <td style="height: 150px; border: 1px solid; padding-left: 20px; width: 300px"><input type="text" name="description${a.student.id}" value="${a.description}" /></td>
                            </tr>   
                        </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                    <br/>
                    <input style="background-color: #6B90DA;" type="submit" value="Save"/>
                </form>
            </div>    
        </div>
    </div>
    <br/>
    <br/>
    <div class="footer" style="padding:10px; border-top: 1px solid;">
        <strong>Mọi góp ý, thắc mắc xin liên hệ: </strong>
        <p>Phòng dịch vụ sinh viên: Email: dichvusinhvien@fe.edu.vn. Điện thoại: (024)7308.13.13</p>
    </div>
</body>
</html>
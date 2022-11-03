<%-- 
    Document   : report
    Created on : Nov 3, 2022, 3:20:09 PM
    Author     : Mr Thinh
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a href="" style="font-size: 15px">Check Attendance</a>|
                    <a href="timetable?lid=${ses.lecturer.id}" style="font-size: 15px">Time Table</a>
                </p>
            </div> 
            <br/>
            <br/>
            <h1 style="padding-left: 580px">Attendance Report</h1> <br/>
            <h2 style="padding-left: 600px">Group: ${requestScope.ses.group.name} </h2><br/>
            <br/>
            <br/>
            <div class="col-md-12">
                <form action="report" method="GET">
                    <input type="hidden" name="sesid" value="${param.id}"/>
                    <table style =" width: 100%;">
                        <thead style="background-color: #6B90DA;">  
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Session ID</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Std ID</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Student Name</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Member ID</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Absent(%)</th>                          
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Date</th>
                        <th style="border: 1px solid; padding: 10px 0px 10px 20px;">Present</th>

                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.ses.atts}" var="a" varStatus="loop">
                                <tr>
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px">${a.session.id}</td>
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px">${a.student.id}
                                        <input type="hidden" name="stdid" value="${a.student.id}"/>
                                    </td>                                   
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px">${a.student.name}</td>
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px">${a.student.member}</td>
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px"></td>  
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px">${a.session.date}</td>                                                                
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px"><input type="text"
                                                                                                            <c:if test="${!a.present}">
                                                                                                                hidden="P"
                                                                                                            </c:if>         
                                                                                                            name="present${a.student.id}" value="P" />
                                    </td>    
                                </tr>   
                            </c:forEach>
                        </tbody>
                    </table>

                    <br/>
                    <br/>
                </form>
            </div> 
        </div>	 <!--Kết thúc container-fluid-->
        <br/>
        <br/>
        <div style="padding:10px; border-top: 1px solid;">
            <strong>More note / Chú thích thêm:</strong><br/>

        </div>
        <br/>
        <br/>
        <div class="footer" style="padding:10px; border-top: 1px solid;">
            <strong>Mọi góp ý, thắc mắc xin liên hệ: </strong>
            <p>Phòng dịch vụ sinh viên: Email: dichvusinhvien@fe.edu.vn. Điện thoại: (024)7308.13.13</p>
        </div>
    </body>
</html>
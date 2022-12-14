<%-- 
    Document   : timetable
    Created on : Oct 24, 2022, 5:26:46 PM
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
                    <a href="" style="font-size: 15px">View Schedule</a></p>
            </div> 
            <div class="row col-md-12" style="padding-top: 15px; border-bottom: 1px solid;">
                <p style="font-weight:bold; font-size: 15px;">Note :</p> 
                <P style="font-size: 10px;">C??c ho???t ?????ng trong b???ng d?????i kh??ng bao g???m ho???t ?????ng ngo???i kh??a, v?? d??? nh?? ho???t ?????ng c??u l???c b??? ...</P>
                <P style="font-size: 10px;">C??c ph??ng b???t ?????u b???ng AL thu???c t??a nh?? Alpha. VD: AL...</P>
                <P style="font-size: 10px;">C??c ph??ng b???t ?????u b???ng BE thu???c t??a nh?? Beta. VD: BE,..</P>
                <P style="font-size: 10px;">C??c ph??ng b???t ?????u b???ng G thu???c t??a nh?? Gamma. VD: G201,...</P>
                <P style="font-size: 10px;">C??c ph??ng t???p b???ng ?????u b???ng R thu???c khu v???c s??n t???p Vovinam.</P>
                <P style="font-size: 10px;">C??c ph??ng b???t ?????u b???ng DE thu???c t??a nh?? Delta. VD: DE,..</P>
                <P style="font-size: 10px;">Little UK (LUK) thu???c t???ng 5 t??a nh?? Delta</P>
            </div> 
            <div class="col-md-12">
                <br/>
                <h1 style="text-align: center;">Time Table For </h1>
                <h2 style="text-align: center;">Lecturer: ${requestScope.lecturer.name}</h2>
                <form action="timetable" method="GET">
                    <input type="hidden" name="lid" value="${param.lid}"/><br/>
                    From: <input type="date" name="from" value="${requestScope.from}"/>
                    To: <input type="date" name="to" value="${requestScope.to}"/>
                    <input type="submit" value="View" style="background-color: #6B90DA; "/> 
                </form>
            </div>       
            <br/>     
            <br/> 
            <div class="col-md-12" style="border: 2px solid">        
                <table style =" width: 100%;">
                    <thead style="background-color: #6B90DA;">
                        <tr>
                            <th></th>
                                <c:forEach items="${requestScope.dates}" var="d">
                                <th style="border: 1px solid; padding-left: 10px">${helper.getDayNameofWeek(d)}<br/>${d}</th>
                                </c:forEach>
                        </tr>     
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.slots}" var="slot">
                            <tr>
                                <td style="height: 100px; border: 1px solid; padding-left: 20px">${slot.description}</td>
                                <c:forEach items="${requestScope.dates}" var="d">
                                    <td style="height: 100px; border: 1px solid; padding-left: 20px"">
                                        <c:forEach items="${requestScope.sessions}" var="ses">
                                            <c:if test="${helper.compare(ses.date,d) eq 0 and (ses.timeslot.id eq slot.id)}">
                                                <a href="attendance?id=${ses.id}">${ses.group.name}-${ses.lecturer.name}</a>
                                                <br/>
                                                at ${ses.room.name}
                                                <c:if test="${ses.attanded}">
                                                    <p style="color: green">(Done)</p>
                                                </c:if>
                                                <c:if test="${!ses.attanded}">
                                                    <p style="color: red">(Not yet)</p>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>	 <!--K???t th??c container-fluid-->
        <br/>
        <br/>
        <div style="padding:10px; border-top: 1px solid;">
            <strong>More note / Ch?? th??ch th??m:</strong><br/>
            <font style="color: green">(Attended):</font>had attended this activity / ???? tham gia ho???t ?????ng n??y<br/>
            <font style="color: red">(Absent):</font> had NOT attended this activity / ???? v???ng m???t bu???i n??y<br/>
            <p>(-): no data was given / ch??a c?? d??? li???u</p>
        </div>
        <br/>
        <br/>
        <div class="footer" style="padding:10px; border-top: 1px solid;">
            <strong>M???i g??p ??, th???c m???c xin li??n h???: </strong>
            <p>Ph??ng d???ch v??? sinh vi??n: Email: dichvusinhvien@fe.edu.vn. ??i???n tho???i: (024)7308.13.13</p>
        </div>
    </body>
</html>

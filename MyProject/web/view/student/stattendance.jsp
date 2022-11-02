<%-- 
    Document   : stattendance
    Created on : Oct 24, 2022, 5:29:01 PM
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
                <c:if test="${requestScope.students ne null}">
                <div class="name-title" style="padding-top: 40px; font-weight: bold;">
                    Lecture: <input type="text">
                </div>
                </c:if>
                <div class="note-title" style="padding-left: 40px;">
                    <p style="font-weight:bold; font-size: 20px;">Note :</p> 
                    <P style="font-size: 15px;">Các hoạt động trong bảng dưới không bao gồm hoạt động ngoại khóa, ví dụ như hoạt động câu lạc bộ ...</P>
                    <P style="font-size: 15px;">Các phòng bắt đầu bằng AL thuộc tòa nhà Alpha. VD: AL...</P>
                    <P style="font-size: 15px;">Các phòng bắt đầu bằng BE thuộc tòa nhà Beta. VD: BE,..</P>
                    <P style="font-size: 15px;">Các phòng bắt đầu bằng G thuộc tòa nhà Gamma. VD: G201,...</P>
                    <P style="font-size: 15px;">Các phòng tập bằng đầu bằng R thuộc khu vực sân tập Vovinam.</P>
                    <P style="font-size: 15px;">Các phòng bắt đầu bằng DE thuộc tòa nhà Delta. VD: DE,..</P>
                    <P style="font-size: 15px;">Little UK (LUK) thuộc tầng 5 tòa nhà Delta</P>
                </div>
            </div> 

                <div class="row">

                <table class="table table-striped" style="width: 100%; padding-right: 20px; border-bottom: 1px solid black;">
                    <thead style="background-color: aquamarine; height: 100px; width: 200px">
                        <tr>
                            <th style="border: 1px solid black; padding: 0px 0px 5px 5px;">
                                <strong>Year</strong>
                                <select name="year" id="">
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                    <option selected="select" value="2022">2022</option>
                                    <option value="2023">2023</option>
                                </select>	
                                <br/><br/>                        
                                <strong>Week</strong>
                                <select name="week" id="">
                                    <option value="1">19/09 to 25/09</option>
                                    <option value="2">26/09 to 02/10</option>
                                    <option value="3">03/10 to 09/10</option>
                                    <option value="4">10/10 to 16/10</option>
                                    <option value="5">17/10 to 23/10</option>
                                    <option value="6">24/10 to 30/10</option>
                                    <option selected="select" value="7">31/10 to 06/11</option>
                                    <option value="8">07/11 to 13/11</option>
                                    <option value="9">14/11 to 20/11</option>
                                    <option value="10">21/11 to 27/11</option>
                                    <option value="11">28/11 to 04/12</option>
                                    <option value="12">05/12 to 11/12</option>
                                    <option value="13">12/12 to 18/12</option>
                                </select>
                            </th>
                            <th style="border: 1px solid black;">Mon</th>
                            <th style="border: 1px solid black;">Tue</th>
                            <th style="border: 1px solid black;">Wed</th>
                            <th style="border: 1px solid black;">Thu</th>
                            <th style="border: 1px solid black;">Fri</th>
                            <th style="border: 1px solid black;">Sat</th>
                            <th style="border: 1px solid black;">Sun</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="border: 1px solid black; height: 100px; width: 100px">Slot 1</td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black;height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black;height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black;height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black;height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black;height: 100px; width: 100px"></td>
                        </tr>
                        <tr>
                            <td style="border: 1px solid black; height: 100px; width: 100px"> Slot 2</td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">PRJ301</a><br/><p>at DE-416</p></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                        </tr>
                        <tr>
                            <td style="border: 1px solid black; height: 100px; width: 100px">Slot3</td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">JPD123</a><br/><p>at DE-416</p></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">PRJ301</a><br/><p>at DE-416</p></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">JPD123</a><br/><p>at DE-416</p></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">PRJ301</a><br/><p>at DE-416</p></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">JPD123</a><br/><p>at DE-416</p></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                        </tr>
                        <tr>
                            <td style="border: 1px solid black; height: 100px; width: 100px"> Slot 4</td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">JPD123</a><br/><p>at DE-204</p></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">JPD123</a><br/><p>at DE-204</p></td></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">JPD123</a><br/><p>at DE-204</p></td></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">PRJ301</a><br/><p>at DE-416</p></td>
                        </tr><tr>
                            <td style="border: 1px solid black; height: 100px; width: 100px"> Slot 5</td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">PRJ301</a><br/><p>at DE-416</p></td>
                        </tr><tr>
                            <td style="border: 1px solid black; height: 100px; width: 100px"> Slot 6</td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">SWE201c</a><br/><p>at BE-301</p></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"><a href="">PRJ301</a><br/><p>at DE-416</p></td>
                        </tr><tr>
                            <td style="border: 1px solid black; height: 100px; width: 100px"> Slot 7</td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                        </tr><tr>
                            <td style="border: 1px solid black; height: 100px; width: 100px"> Slot 8</td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                            <td style="border: 1px solid black; height: 100px; width: 100px"></td>
                        </tr>
                    </tbody>
                </table>
            </div>				
        </div>	
        
        <div class="footer">
            <p><strong>Mọi góp ý, thắc mắc xin liên hệ:</strong>Phòng dịch vụ sinh viên: Email: dichvusinhvien@fe.edu.vn. Điện thoại: <strong>(024)7308.13.13</strong></p>
        </div>
        <script src="js/Jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>
</html>

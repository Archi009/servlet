<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Ajax 연습페이지</h3>
<!-- 이름: <input type="text" name="name"><br>
나이: <input type="text" name="age"><br> -->

<table class="table">
    <tr>
        <th>회원ID</th>
        <td><input class="form-control" type="text" name="mid"></td>
    </tr>
    <tr>
        <th>비밀번호</th>
        <td><input class="form-control" type="text" name="mpw"></td>
    </tr>
    <tr>
        <th>회원이름</th>
        <td><input class="form-control" type="text" name="mname"></td>
    </tr>
    <tr >
        <td colspan="2" align="center"><button id="addMember" class="btn btn-success">등록</button></td>
    </tr>
</table>

<table class="table">
    <thead>
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>권한</th>
            <th>삭제</th>
        </tr>
    </thead>
    <tbody id="list">
        
    </tbody>
</table>

<!--  <script src="js/test.js"></script>-->
<script src="js/member.js"></script>
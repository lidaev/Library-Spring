<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lidiya
  Date: 13.03.2018
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Digital library</title>
</head>
<body>

<header>
    <h1>Welcome, ${username}!!!</h1>
</header>

<c:out value="${userbooks[0].getTitle()}" />


<div class="col-sm-12" id="header">
    <div class="col-sm-6"><p id="logo">Digital library</p></div>
    <div class="col-sm-1 col-sm-offset-5"><a href="index.jsp" id="logout_btn">Logout</a></div>
</div>
<div class="col-sm-6 col-sm-offset-1">
    <form class="form-inline" method="post" action="/readbook">
        <label>To read a book enter its number<input type="number" name="bookId"></label>
        <button type="submit" class="btn btn-default">Read!</button>
    </form>
</div>
<div class="col-sm-6" id="user_books">
    <table class="table">
        <h2>Your books</h2>
        <thead>
            <th>Title</th>
            <th>Author</th>
        </thead>
        <tbody>
        <c:forEach var="book" items="${userbooks}">
            <tr>
                <td>${book.getTitle()}</td>
                <td>${book.getAuthor()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="col-sm-6" id="all_books">
    <table class="table">
        <h2>All books</h2>
        <thead>
        <th>Book Number</th>
        <th>Title</th>
        <th>Author</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach var="book" items="${allbooks}">
            <tr>
                <td>${book.getId()}</td>
                <td>${book.getTitle()}</td>
                <td>${book.getAuthor()}</td>
                <td>action</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--<div class="col-sm-6">
    <table class="table">
        <% ResultSet bookRs = BookServiceImpl.getAllBooks();
            if (!bookRs.next()) {
                System.out.println("NO books");
        %>
        <p id="welcome">There are no books in our library :(</p>
        <%} else {%>
        <h2>Available Books</h2>
        <thead>
        <th>Number</th>
        <th>Title</th>
        <th>Author</th>
        </thead>
        <tbody>
        <%do {
        %>
        <TR>
            <TD><%=bookRs.getString(1)%></TD>
            <TD><%=bookRs.getString(2)%></TD>
            <TD><%=bookRs.getString(3)%></TD>
        </TR>
        <% } while (bookRs.next());} %>
        </tbody>
    </table>
</div>--%>
</body>
</html>

<%@page contentType="text/html;charset=UTF-8" language="java" %>
  <%@page isELIgnored="false" %>
    <!-- <%@page isELIgnored="false" %> is important -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <title>Customer</title>
          <meta charset="UTF-8" />
          <meta name="viewport" content="width=device-width, initial-scale=1" />
          <link href="https://bootswatch.com/5/quartz/bootstrap.min.css" rel="stylesheet" />
          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
          <script src="${pageContext.request.contextPath}/resources/js/alert.js"></script>
        </head>

        <body>
          <div class="container mt-4">
            <h1 class="display-4 text-center">
              <i class="fas fa-book-open text-primary"></i> <span class="text-primary">Customer</span> List
            </h1>
            <div class="card text-white bg-secondary mb-3" style="max-width: 100%;">
              <div class="card-body">
                <h3 class="card-title text-center text-info">Welcome</h3>
                <p class="card-text text-center">Webpage displays all customers.</p>
              </div>
            </div>
            <a href="<c:url value=" newCustomerForm" />">
            <button type="button" class="btn btn-primary">Add Customer</button>
            </a>
            <table class="table table-striped mt-4">
              <thead>
                <tr>
                  <th>Customer Name</th>
                  <th>Customer Email</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="entry" items="${customers}">
                  <!-- contruct an "update" link with customer id -->
                  <c:url var="updateLink" value="updateCustomer">
                    <c:param name="customerId" value="${entry.id}" />
                  </c:url>

                  <!-- contruct an "delete" link with customer id -->
                  <c:url var="deleteLink" value="deleteCustomer">
                    <c:param name="customerId" value="${entry.id}" />
                  </c:url>

                  <tr>
                    <td>
                      <c:out value="${entry.name}" />
                    </td>
                    <td>
                      <c:out value="${entry.email}" />
                    </td>
                    <td>
                      <a href="${updateLink}" class="btn btn-warning btn-sm delete"><i class="fas fa-edit"></i></a>
                      <a href="${deleteLink}" class="btn btn-danger btn-sm delete" onclick="return deleteAlert();"><i class="fas fa-trash"></i></a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </body>

        </html>

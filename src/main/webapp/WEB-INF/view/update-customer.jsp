<%@page contentType="text/html;charset=UTF-8" language="java" %>
  <%@page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <title>Update Customer</title>
          <meta charset="UTF-8" />
          <meta name="viewport" content="width=device-width, initial-scale=1" />
          <link href="https://bootswatch.com/5/quartz/bootstrap.min.css" rel="stylesheet" />
          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        </head>

        <body>
          <div class="container mt-4">
            <h1 class="display-4 text-center">
              <i class="fas fa-book-open text-primary"></i> <span class="text-primary">Customer </span>Management System
            </h1>
            <div class="card text-white bg-secondary mb-3" style="max-width: 100%;">
              <div class="card-body">
                <h3 class="card-title text-center text-info">Welcome</h3>
                <p class="card-text text-center">Quick example to update customer's content.</p>
              </div>
            </div>
            <h2>Update Customer</h2>
            <form:form method="POST" action="saveCustomer" modelAttribute="customer">

              <!-- need to associate this data with customer id -->
              <form:hidden path="id"/>

              <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name" cssClass="text-warning"/>
              </div>

              <div class="form-group mt-2">
                <form:label path="email">Email</form:label>
                <form:input path="email"  cssClass="form-control"/>
                <form:errors path="email" cssClass="text-warning"/>
              </div>
              <input type="submit" value="Update Customer" class="btn btn-primary btn-block text-center mt-2" />
            </form:form>
          </div>
        </body>

        </html>

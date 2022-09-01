<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Customer</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      href="https://bootswatch.com/5/quartz/bootstrap.min.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </head>
  <body>
    <div class="container mt-4">
      <h1 class="display-4 text-center">
        <i class="fas fa-book-open text-primary"></i> Customer<span
          class="text-primary"
        ></span
        > List
      </h1>
      <form id="customer-form">
        <div class="form-group">
          <label for="title">Name</label>
          <input type="text" id="title" class="form-control" />
        </div>
        <div class="form-group mt-2">
          <label for="email">Email</label>
          <input type="text" id="email" class="form-control" />
        </div>
        <input
          type="submit"
          value="Add Customer"
          class="btn btn-primary btn-block text-center mt-2"
        />
      </form>
      <table class="table table-striped table-responsive-md mt-5">
        <thead>
          <tr>
            <th>Customer Name</th>
            <th>Customer Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="entry" items="${customers}">
          <td><c:out value="${entry.name}"/></td>
          <td><c:out value="${entry.email}"/></td>
          <td><a href="#" class="btn btn-danger btn-sm delete">X</a></td>         
        </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>

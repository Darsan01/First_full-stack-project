<%@ include file="home.jsp" %>
<%@ page import="model.StudentModel" %>
<%@ page import="java.util.List" %>

<div class="container mt-5">
    <h1 class="mb-4">Registered Students</h1>
    <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<StudentModel> students = (List<StudentModel>) request.getAttribute("students");
                if (students != null && !students.isEmpty()) {
                    for (StudentModel student : students) {
            %>
            <tr>
                <td><%= student.getFirstName() %></td>
                <td><%= student.getLastName() %></td>
                <td>
                    <a href="#" class="btn btn-primary btn-sm mr-2" role="button"><i class="fas fa-edit"></i> Edit</a>
                    <a href="#" class="btn btn-danger btn-sm" role="button"><i class="fas fa-trash-alt"></i> Delete</a>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="3">No students found</td>
            </ tr>
            <% 
                }
            %>
        </tbody>
    </table>
</div>

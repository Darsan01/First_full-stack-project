package controller.servlets;


import java.io.IOException;

import java.time.LocalDate;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.DatabaseController;
import model.StudentModel;
import util.StringUtils;


/**
 * @author Sujan
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.REGISTER_SERVLET})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	DatabaseController dbController = new DatabaseController();


	public RegisterServlet() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter(StringUtils.USER_NAME);
		String firstName = request.getParameter(StringUtils.FIRST_NAME);
		String lastName = request.getParameter(StringUtils.LAST_NAME);
		String dobString = request.getParameter(StringUtils.BIRTHDAY);
		LocalDate dob = LocalDate.parse(dobString);
		String gender = request.getParameter(StringUtils.GENDER);
		String email = request.getParameter(StringUtils.EMAIL);
		String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
		String subject = request.getParameter(StringUtils.SUBJECT);
		String password = request.getParameter(StringUtils.PASSWORD);
		String retypePassword = request.getParameter(StringUtils.RETYPE_PASSWORD);


		StudentModel studentModel = new StudentModel(firstName, lastName, dob, gender, email, phoneNumber, subject,
				userName, password);
		
		



		int result = dbController.addStudent(studentModel);



		
		if (password.equals(retypePassword)) {
			switch (result) {
				case 1 -> {
					request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
				    response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
				}
				case 0 -> {
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.ERROR_REGISTER_MESSAGE);
				    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
				}
				case -1 -> {
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
				    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
				}
				case -2 -> {
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.USERNAME_ERROR_MESSAGE);
				    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
				}
				case -3 -> {
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.EMAIL_ERROR_MESSAGE);
				    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
				}
				case -4 -> {
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PHONE_NUMBER_ERROR_MESSAGE);
				    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
				}
				default -> {
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
				    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
				}
			}
		}
		else {
			request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PASSWORD_UNMATCHED_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		}
	}
}


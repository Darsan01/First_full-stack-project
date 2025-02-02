package util;


/**
 * @author prithivi
 */
public class StringUtils {


	// Start SQL Queries
	public static final String INSERT_STUDENT = "INSERT INTO student_info "
			+ "(user_name, first_name, last_name, dob, gender, email, phone_number, subject, password) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


	public static final String GET_LOGIN_STUDENT_INFO = "SELECT * FROM student_info WHERE user_name = ?";
	public static final String GET_USERNAME = "SELECT COUNT(*) FROM student_info WHERE user_name = ?";
	public static final String GET_PHONE = "SELECT COUNT(*) FROM student_info WHERE phone_number = ?";
	public static final String GET_EMAIL = "SELECT COUNT(*) FROM student_info WHERE email = ?";
	public static final String GET_ALL_STUDENTS = "SELECT * FROM student_info";
	// End SQL Queries


	// Start Parameter names
	public static final String USER_NAME = "user_name";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String BIRTHDAY = "birthday";
	public static final String GENDER = "gender";
	public static final String EMAIL = "email";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String SUBJECT = "subject";
	public static final String PASSWORD = "password";
	public static final String RETYPE_PASSWORD = "retypePassword";
	// End Parameter names


	// Start string messages 
	// Start register page messages
	public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered!";
	public static final String ERROR_REGISTER_MESSAGE = "Please correct the form data.";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
	public static final String USERNAME_ERROR_MESSAGE = "Username is already registered.";
	public static final String EMAIL_ERROR_MESSAGE = "Email is already registered.";
	public static final String PHONE_NUMBER_ERROR_MESSAGE = "Phone Number is already registered.";
	public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "Password not matched.";
	// End register page messages
	
	// Start login page message
	public static final String SUCCESS_LOGIN_MESSAGE = "Successfully LoggedIn!";
	public static final String ERROR_LOGIN_MESSAGE = "Either username or password is not correct!";
	// End login page message
	
	public static final String SUCCESS_MESSAGE = "successMessage";
	public static final String ERROR_MESSAGE = "errorMessage";
	// End string messages 


	// Start JSP Route
	public static final String LOGIN_PAGE = "/pages/login.jsp";
	public static final String REGISTER_PAGE = "/pages/register.jsp";
	public static final String WELCOME_PAGE = "/pages/welcome.jsp";
	// End JSP Route
	
	// Start Servlet Route
	public static final String REGISTER_SERVLET = "/RegisterServlet";
	public static final String LOGIN_SERVLET = "/LoginServlet";
	public static final String STUDENTS_SERVLET = "/StudentServlet";
	// End Servlet Route
}

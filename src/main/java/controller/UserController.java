package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.User;
import service.UserService;
import service.UserServiceImpl;

@WebServlet({ "/UserController", "/user/*" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private String destPage;

	private RequestDispatcher rdp;

	public UserService usv;

	public UserController() {
		super();
		usv = new UserServiceImpl();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("UserController start");
				
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String uri = request.getRequestURI();
		log.info(">>> uri >> {}", uri); // url >> /brd/register

		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>> path >> {}", path);
		
		//페이지 마다 기능
		switch(path){
		case "joinPage":
			log.info("joinPage");
			try {
				destPage="/member/join.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			break;
		
		case "join":
			log.info("join start");
			try {
				
				String id=request.getParameter("id");
				String pw=request.getParameter("password");
				String email=request.getParameter("email");
				String phone= request.getParameter("phone");
				
				User user = new User();
				user.setId(id);
				user.setPw(pw);
				user.setEmail(email);
				user.setPhone(phone);
				
				log.info("{}",user);
				
				int isOk= usv.join(user);
				
				if(isOk>0) {
					log.info("insert success");
					
				}else {
					log.info("insert fail");
				}
				
				destPage="/index.jsp?msg=joinSuccess";
				
			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		
		case "loginPage":
			destPage="/member/login.jsp";
			break;
		
		case "login":
			try {
				String id=request.getParameter("id");
				String pw=request.getParameter("password");
				
				User user=new User();
				user.setId(id);
				user.setPw(pw);
				
				log.info("{}",user);
				
				User loginUser= usv.login(user);
				
				log.info("{}",loginUser);
				
				if(loginUser != null) {
					log.info("{}login success",loginUser);
					HttpSession ses = request.getSession();
				
					
					ses.setAttribute("loginUser",loginUser);
					destPage="/";
					
				}else{
					destPage="/?msg=notUser";
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			break;
			
		case "logOut":
			
			try {
				HttpSession ses = request.getSession();
				
				User loginedUser = (User) ses.getAttribute("loginUser");
				
				log.info("ses ==> {}",loginedUser);
				
				int isOK = usv.lastLogin(loginedUser.getId());
				// 그냥 usv.lastLogin(loginedUser.getId()); 만 사용하는게 안되는 이유
				
				ses.removeAttribute("loginUser");
				
				ses.invalidate();
				
				destPage="/?msg=logOut";
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			break;
			
		case "modifyPage":
			try {
				HttpSession ses = request.getSession();
				
				User user = (User) ses.getAttribute("loginUser");
				
				request.setAttribute("user", user);
				
				destPage="/member/modify.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			break;
			
		case "update":
			try {
				String id = request.getParameter("id");
				String pw = request.getParameter("password");
				String email= request.getParameter("email");
				String phone= request.getParameter("phone");
				
				User user = new User();
				user.setId(id);
				user.setPw(pw);
				user.setEmail(email);
				user.setPhone(phone);
				
				int isOk = usv.update(user);
				
				if(isOk>0) {
					log.info("Update Success");
					HttpSession ses = request.getSession();
					
					ses.removeAttribute("loginUser");
					
					ses.invalidate();
					
					destPage="/?msg=updateSuccess";
				}
				else{
					log.info("Update Fail");
					destPage="/modify.jsp";
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			break;
			
		case "delete":
			try {
				HttpSession ses = request.getSession();
				
				User user = (User) ses.getAttribute("loginUser");
				
				String userId=user.getId();
				
				log.info(userId);
				
				int isOk= usv.delete(userId);
				
				if(isOk>0) {
					log.info("delete success");
					
					ses.removeAttribute("loginUser");
					
					ses.invalidate();
					
					destPage="/?msg=deleteSuccess";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			break;
		
		}
		
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}

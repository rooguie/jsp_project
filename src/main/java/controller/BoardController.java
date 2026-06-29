package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Board;
import domain.User;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet({ "/BoardController", "/brd/*" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	// 서블릿에 response 객체를 보내는 역할 객체
	private RequestDispatcher rdp;

	// 목적지 jsp
	private String destPage;

	// 서비스 연결(인터페이스 <-> 구현체)
	private BoardService bsv;

	public BoardController() {
		super();
		bsv = new BoardServiceImpl(); // 구현체와 연결

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get, post 담당
		log.info(">>> BoardController test");

		// request, response 인코딩 설정
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();
		log.info(">>> uri >> {}", uri); // url >> /brd/register

		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>> path >> {}", path);

		// 페이지마다 기능
		int isOk = 0;

		switch (path) {

		case "register":
			try {
				destPage = "/board/register.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		case "insert":

			try {
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String contents = request.getParameter("contents");

				Board board = new Board();
				board.setTitle(title);
				board.setWriter(writer);
				board.setContents(contents);

				isOk = bsv.insert(board);

				if (isOk > 0) {
					log.info("insert success");
				} else {
					log.info("insert fail");
				}

				destPage = "list";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			break;

		case "list":
			log.info("BoardController list");

			try {

				Board boardList = new Board();

				List<Board> list = bsv.getList(boardList);

				request.setAttribute("list", list);
				destPage = "/board/list.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			break;

		case "detail":
			log.info("BoardController detail");

			try {

				int bno = Integer.parseInt(request.getParameter("bno"));

				Board board = bsv.detail(bno);

				request.setAttribute("board",board);

				destPage = "/board/detail.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			break;
			
		case "modify":
			log.info("boardController modify");
			try {
				int bno =Integer.parseInt(request.getParameter("bno"));
				
				Board board=bsv.modify(bno);
				
				request.setAttribute("board",board);
				
				destPage="/board/modify.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			break;
			
		case "update":
			
			try {
				int bno =Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String contents= request.getParameter("contents");
				
				Board board = new Board();
				board.setBno(bno);
				board.setTitle(title);
				board.setWriter(writer);
				board.setContents(contents);
				
				isOk= bsv.update(board);
				
				if(isOk>0) {
					log.info("update success");
				}else{
					log.info("update fail");
				}
				
				destPage="detail?bno="+bno;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			break;
			
		case "delete":
			
			try {
				int bno =Integer.parseInt(request.getParameter("bno"));
				
				isOk = bsv.delete(bno);
				
				if(isOk>0) {
					log.info("delete success");
				}
				else{
					log.info("delete fail");
				}
				
				destPage="list";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			break;
			
		case "myList":
			try {
				HttpSession ses = request.getSession();
				User user = (User) ses.getAttribute("loginUser");
				
				String writer=user.getId();
				
				Board board = new Board();
				board.setWriter(writer);
				
				List<Board> myList = bsv.getMyList(board);
				
				log.info(">> myList >> {}",myList);
				
				request.setAttribute("list", myList);
				
				destPage="/board/myList.jsp";
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			break;
			
		}

		rdp = request.getRequestDispatcher(destPage);

		rdp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// method="GET" 처리
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// method="POST" 처리
		doGet(request, response);
	}

}

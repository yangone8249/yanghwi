package controller;

import java.io.IOException;
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

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private RequestDispatcher rdp;
    private MemberService msv;
    private int isOk;
    private String destPage;
    private MemberVO mvo;

    
    public MemberController() {
        msv = new MemberServiceImpl();
       
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=utf-8");
    	String uri = request.getRequestURI();
    	log.info(">>> uri : "+uri);
    	String path = uri.substring(uri.lastIndexOf("/")+1);
    	log.info(">>> path : "+path);
    	
    	switch (path) {
		case "insert":
			try {
				String id = request.getParameter("id");
				String password = request.getParameter("password");
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String email = request.getParameter("email");
				mvo = new MemberVO(id, password, name, age, email);
				
				msv.insert(mvo);
			} catch (Exception e) {
				log.info("insert error");
				e.printStackTrace();
			}

			
			destPage = "/";
			break;
		case "login":
			try {
				String id = request.getParameter("id");
				String password = request.getParameter("password");
				
				mvo = new MemberVO(id, password);
				
				mvo = msv.select(mvo);
				
				
				log.info("리턴 id : "+mvo.getId());
				log.info("로그인 시도한 id : "+id);
				
				if(mvo.getId().equals(id) && mvo.getPassword().equals(password)){
					log.info("계정일치");
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", mvo);
					ses.setMaxInactiveInterval(10*60); // 로그인 10분유지
					msv.update(mvo);
				}else {
					log.info("계정이 일치하지않습니다");
					request.setAttribute("loginCancle", 0);
				}
			}catch (Exception e) {
				log.info("login error");
				e.printStackTrace();
			}
			destPage = "/";
			break;
		case "logout":
			try {
				HttpSession ses = request.getSession();
				ses.invalidate();
				log.info("로그아웃 성공");
			} catch (Exception e) {
				log.info("logout error");
				e.printStackTrace();
			}
			
			destPage = "/";
			break;
		case "remove":
			try {
				String id = request.getParameter("id");
				msv.delete(id);
				log.info("계정삭제 성공");
				HttpSession ses = request.getSession();
				ses.invalidate();
			} catch (Exception e) {
				log.info("remove error");
				e.printStackTrace();
			}
			
			destPage = "/";
			break;
		case "list":
			try {
				List<MemberVO> list = msv.list();
				request.setAttribute("list", list);
				log.info("리스트 추출 성공");
			} catch (Exception e) {
				log.info("list error");
				e.printStackTrace();
			}
			destPage = "/member/MemberList.jsp";
			break;
		default:
			break;
		}
    	log.info(">>> destPage : "+destPage);
    	rdp = request.getRequestDispatcher(destPage);
    	rdp.forward(request, response);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		service(request, response);
	}

}
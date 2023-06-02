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


@WebServlet("/mem/*") // mem/* <= 하위경로 정보표시해야 진입가능하다. mem...으로 시작하는 모든 경로는 viewController로 오게된다.
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // log설정
	//private static final Logger log = LoggerFactory.getLogger(클래스명) <= 싱글톤 방식으로 
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp; 
	private MemberService msv;
	private int isOk;
	private String destPage;
	
    
    public MemberController() {
    	msv = new MemberServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// characterEncoding 설정 / contentType / uri
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri = request.getRequestURI();
		log.info(">>> uri : "+uri);
		// /mem/join : 요청에 대한 path만 남기기
		String path = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(">>> path : "+path);
		
		switch (path) {
		case "join":
			destPage = "/member/join.jsp"; //폴더명 - 파일명으로 주소 기재
			break;
		case "register":
			String id = request.getParameter("userId");
			String pw = request.getParameter("userPw");
			String email = request.getParameter("userEmail");
			int age = Integer.parseInt(request.getParameter("userAge"));
			
			MemberVO mvo = new MemberVO(id, pw, email, age);
			isOk = msv.register(mvo);
			log.info(">>> JOIN > "+ (isOk>0 ? "성공":"실패"));
			
			request.setAttribute("registerAlert", "성공");
			destPage = "/";
			break;
		case "login":
			log.info(">>> login Page 이동!");
			destPage="/member/login.jsp"; // member폴더안에있는 login.jsp폴더로 이동한다.
			break;
		case "login_auth":
			
			try {
				String id2 = request.getParameter("id");
				String pwd = request.getParameter("password");
				MemberVO mvo2 = new MemberVO(id2, pwd);
				// 해당 id, password가 db상에 있는지 체크 
				// 해당 객체(사용자)를 가져와서
				// 해당 객체(사용자)를 세션에 담기
				log.info(">>> login 요청"+mvo2);
				MemberVO loginMvo = msv.login(mvo2); //로그인 시도한 id, pw를 MemberVO 객체에 등록
				
				if (loginMvo != null) { //MemberVO 객체가 빈값이 아닐 시 if문 진입
					HttpSession ses = request.getSession(); // 세션가져오기, 연결된 세션이 없다면 새로 생성
					ses.setAttribute("ses", loginMvo); //"ses"변수명에 로그인 객체 대입
					ses.setMaxInactiveInterval(10*60);// 로그인 유지 시간(초단위)
					
				}else {
					request.setAttribute("msg_login", 0); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage="/";
			break;
		case "logout":
			try {
				// 로그아웃을 위해선 세션을 가져와야함. (연결된 세션)
				HttpSession ses = request.getSession(); //로그인 되어있던 세션 가져오기
				// 마지막 로그인 시간 기록
				MemberVO mvo2 = (MemberVO)ses.getAttribute("ses"); //일반 Object객체로 리턴되기때문에 MemberVO 객체로 형변환해줌.
				String id2 = mvo2.getId();
				log.info(">>>>>> login id : "+id2); 
				//로그인정보(id)를 주고 마지막 로그인 시간 기록(update)
				isOk = msv.lastLogin(id2); //
				log.info(">>> logout : "+(isOk>0 ? "성공":"실패"));
				ses.invalidate();// invalidate() : 권한해제 메서드
			} catch (Exception e) {
				
			}
			destPage = "/";
			break;
		case "modify":
			log.info(">>> modify Page 이동!");
			destPage="/member/modify.jsp";
			break;
		case "update":
			String id3 = request.getParameter("id");
			String password3 = request.getParameter("password");
			String email3 = request.getParameter("email");
			int age3 = Integer.parseInt(request.getParameter("age"));
			MemberVO mvo3 = new MemberVO(id3, password3, email3, age3);
			
			log.info(">>> update 요청"+mvo3);
			msv.update(mvo3);
			
			destPage="/";
			break;
		case "admin":
			log.info(">>> 관리자페이지 이동!");
			destPage = "/member/admin.jsp";
			break;
		case "list":
			log.info(">>> list Page 이동!");
			try {
				List<MemberVO> list = msv.list(); //ArrayList<MemberVO>에 
				request.setAttribute("list", list);
				destPage = "/member/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			break;
		case "remove":
			log.info(">>> remove 이동!");
			HttpSession ses = request.getSession();
			log.info("id값 : "+request.getParameter("id"));
			msv.remove(request.getParameter("id"));
			ses.invalidate();
			request.setAttribute("removeAlert", 0); 
			destPage="/";
			break;
		default:
			break;
		}
		
		
		rdp = request.getRequestDispatcher(destPage); //목적지 주소(destPage)를 rdp에 대입한다.
		rdp.forward(request, response); // destPage로 이동하면서 request와 response를 싣고 간다.
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}

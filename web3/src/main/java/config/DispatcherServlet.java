package config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardController;
import controller.UserController;
import model.BoardRepository;
import model.UserRepository;

/*
 * http://localhost:8080/web3/user/insert.do
 * http://localhost:8080/web3/user/findById.do
 * http://localhost:8080/web3/board/findAll.do
 * http://localhost:8080/web3/board/findById.do
 */

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getRequestURI().substring(1).split("/")[1];
		String action = req.getRequestURI().substring(1).split("/")[2].replace(".do", "");
		
		System.out.println("path : " + path);
		System.out.println("action : " + action);
		
		if (path.equals("user")) {
			Model model = new Model(req);
			UserRepository userRepository = new UserRepository();
			UserController userCon = new UserController(userRepository);
			if(action.equals("insert")) {
				String viewName = userCon.insert();
//				viewName = ViewResolver.generate(viewName);
//				req.getRequestDispatcher(viewName).forward(req, resp);				
				resp.setHeader("Content-type", "text/html; charset=utf-8");
				PrintWriter pw = resp.getWriter();
				pw.println(viewName);
			}                                                                                                                                                                                                                                                                                                                                                                                       
			else if(action.equals("findById")) {
				String viewName = userCon.findById(model);
				viewName = ViewResolver.generate(viewName);
				req.getRequestDispatcher(viewName).forward(req, resp);
			}
		}
		else if(path.equals("board")) {
			Model model = new Model(req);
			BoardRepository boardRepository = new BoardRepository();
			BoardController boardCon = new BoardController(boardRepository);
			if(action.equals("findAll")) {
				String viewName = boardCon.findAll(model);
				viewName = ViewResolver.generate(viewName);
				req.getRequestDispatcher(viewName).forward(req, resp);
			}                                                                                                                                                                                                                                                                                                                                                                                       
			else if(action.equals("findById")) {
				String viewName = boardCon.findById(model);
				viewName = ViewResolver.generate(viewName);
				req.getRequestDispatcher(viewName).forward(req, resp);
			}
		}
		
	}
}

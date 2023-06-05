package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.CustomerBean;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns={"/jp.co.aforce.servlets/login"})

public class Login extends HttpServlet{

	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException{
		PrintWriter out=response.getWriter();

		Page.header(out);

		String login=request.getParameter("login");
		String password=request.getParameter("password");
		CustomerDAO dao= new CustomerDAO();

		try {
			CustomerBean customer=dao.search(login,password);

			if(customer!=null) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("../jsp/login-out.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "IDもしくはパスワードが違います。");
				request.setAttribute("login", login);
				request.getRequestDispatcher("../jsp/login.jsp").forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.footer(out);
	}

}



























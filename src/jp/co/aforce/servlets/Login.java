package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Customer;
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

			Customer customer=dao.search(login,password);
//			String logId=customer.getLogin();
			String logid=request.getParameter("logid");

//			request.setAttribute("customer", customer);



			if(logid!=null) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("../jsp/login-out.jsp").forward(request, response);
			}else {
				out.println("<p>IDもしくはパスワードが違います</p>");
				out.println("<p>" + login + "</p>");

			}


		}catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.footer(out);
	}

}



























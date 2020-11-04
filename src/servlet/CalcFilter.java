package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalcFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String path = request.getServletPath();

		HttpSession session = request.getSession();
		Object p1 = session.getAttribute("input1");
		Object p2 = session.getAttribute("input2");
		PrintWriter out = response.getWriter();

		if ((("/add".equals(path)) || ("/sub".equals(path))
				|| ("/mul".equals(path)) || ("/div".equals(path)) || ("/per"
					.equals(path))) || (p1 != null && p2 != null)) {

			arg2.doFilter(request, response);

		}

		else {

			response.sendRedirect("http://localhost:8080/CalcWebApp");

			out.println("Sorry url is incorrect .");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

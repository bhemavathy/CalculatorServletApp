package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalWeb extends HttpServlet   {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final String addop = "/add";
		final String subop = "/sub";
		final String mulop = "/mul";
		final String divop = "/div";
		final String perop = "/per";

		String op = req.getServletPath();
		PrintWriter pw = resp.getWriter();
		String n1 = req.getParameter("input1");
		String n2 = req.getParameter("input2");

		pw.println("operand1" + " " + "=" + n1);
		pw.println("operand2" + " " + "=" + n2);

		switch (op) {
		case addop:
			pw.println("result = "
					+ (Integer.parseInt(n1) + Integer.parseInt(n2)));
			break;
		case subop:
			pw.println("result = "
					+ (Integer.parseInt(n1) - Integer.parseInt(n2)));
			break;
		case mulop:
			pw.println("result = "
					+ (Integer.parseInt(n1) * Integer.parseInt(n2)));
			break;
		case divop:
			if (Integer.parseInt(n2) == 0) {
				throw new RuntimeException("Cannot divide by zero");
			}
			pw.println("result = "
					+ (Integer.parseInt(n1) / Integer.parseInt(n2)));
			break;
		case perop:
			pw.println("result"
					+ ((Integer.parseInt(n1) * 100) / Integer.parseInt(n2)));
			break;
		default:
			pw.println("Please enter the correct operator");
			break;

		}

	}
}

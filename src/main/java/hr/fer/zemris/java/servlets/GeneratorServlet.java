package hr.fer.zemris.java.servlets;

import hr.fer.zemris.java.servlets.util.Utility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlets/generator")
public class GeneratorServlet extends HttpServlet {

	@Override
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> data = (List<String>) req.getServletContext().getAttribute("data");
		int rand = Utility.getRandomInt(0, data.size() - 1);

		req.getSession().setAttribute("word", data.get(rand));
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
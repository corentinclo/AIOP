package fr.polytech.todo.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.todo.Todo;
import fr.polytech.todo.TodoDAO;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/Todo")
public class TodoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
    private TodoDAO todoDao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Todo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		Todo todo = new Todo(name, desc);
		todoDao.create(todo);
		request.setAttribute("todos", todoDao.all());
		request.getRequestDispatcher("Todo.jsp").forward(request, response);
	}

}

package fr.polytech.todo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.polytech.todo.Todo;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/Todo")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static List<Todo> todos;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
        if (todos == null) {
        	todos = new ArrayList<Todo>();
        }
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
		Todo todo = new Todo(todos.size(), name, desc);
		todos.add(todo);
		request.setAttribute("todos", todos);
		request.getRequestDispatcher("Todo.jsp").forward(request, response);
	}

}

package com.cgdelgado.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgdelgado.dao.TaskDAO;
import com.cgdelgado.model.Task;

/**
 * Servlet implementation class TaskController
 */
@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskController() {
		super();		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opt = request.getParameter("opt");
		TaskDAO taskDAO; 
		List<Task> list;
		RequestDispatcher requestDispatcher;

		switch (opt) {
		
			case "create":
				System.out.println("CREAR TAREA");
				requestDispatcher = request.getRequestDispatcher("/view/create.jsp");
				requestDispatcher.forward(request, response);
				break;
				
			case "home":				
				requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
				break;
				
			case "show":
				
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("Vert TAREA " + id);
				taskDAO = new TaskDAO();
				Task t = new Task();
				
				try {
					t = taskDAO.findTask(id);
					System.out.println(t);
					request.setAttribute("task", t);
					requestDispatcher = request.getRequestDispatcher("/view/show.jsp");
					requestDispatcher.forward(request, response);
					
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
				break;
			
			case "delete":
				System.out.println("Borrar TAREA");
				taskDAO = new TaskDAO();	
				int idTask = Integer.parseInt(request.getParameter("id"));
				requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				try {
					taskDAO.delete(idTask);
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
				break;
				
			case "list":
				System.out.println("Listar tareas");
				taskDAO = new TaskDAO();				
	
				try {
					list = taskDAO.finAllTasks();
	
					for (Task task : list) {
						System.out.println(task);
					}
					request.setAttribute("taskList", list);
					requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
					requestDispatcher.forward(request, response);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	
				break;
			default:
				System.out.println("Listar tareas");
				taskDAO = new TaskDAO();				
	
				try {
					list = taskDAO.finAllTasks();
	
					for (Task task : list) {
						System.out.println(task);
					}
					request.setAttribute("taskList", list);
					requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
					requestDispatcher.forward(request, response);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opt = request.getParameter("opt");		
		RequestDispatcher requestDispatcher;
		TaskDAO taskDAO;
		Task task;
		
		switch (opt) {
			case "add":
				taskDAO = new TaskDAO();
				task = new Task();

				task.setName(request.getParameter("name"));
				task.setDescription(request.getParameter("description"));
				task.setStart(request.getParameter("start"));
				task.setEnd(request.getParameter("end"));
				task.setDone(0);

				try {
					taskDAO.save(task);
					System.out.println("tarea creada");
					requestDispatcher = request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			
			case "markTask":
				int id = Integer.parseInt(request.getParameter("id"));
				taskDAO = new TaskDAO();
				System.out.println(id);
				try {
					taskDAO.doTask(id);
					requestDispatcher = request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request, response);
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				break;
			default:
				requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
				requestDispatcher.forward(request, response);
				break;

		}

		// doGet(request, response);

	}

}

package com.cgdelgado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cgdelgado.connection.Conecction;
import com.cgdelgado.model.Task;

public class TaskDAO {

	private Connection connection;
	private PreparedStatement statement;
	private boolean statusOperation;

	// Save task to BD
	public boolean save(Task task) throws SQLException {

		String sql = null;
		statusOperation = false;
		connection = getDBConnection();

		try {
			// transaction about to begin
			connection.setAutoCommit(false);
			sql = "INSERT INTO tasks (id, name, description, start, end, done) VALUES(?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setString(4, task.getStart());
			statement.setString(5, task.getEnd());
			statement.setInt(6, task.getDone());

			statusOperation = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {

			connection.rollback();
			e.printStackTrace();
		}

		return statusOperation;
	}

	// edit task
	public boolean edit(Task task) throws SQLException {

		String sql = null;
		statusOperation = false;
		connection = getDBConnection();

		try {
			connection.setAutoCommit(false);
			sql = "UPDATE tasks SET name=?, description=?, start=?, end=?, done=? WHERE id =?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, task.getName());
			statement.setString(2, task.getDescription());
			statement.setString(3, task.getStart());
			statement.setString(4, task.getEnd());
			statement.setInt(5, task.getDone());
			statement.setInt(6, task.getId());

			statusOperation = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return statusOperation;
	}

	// delete task
	public boolean delete(int id) throws SQLException {
		
		String sql = null;
		statusOperation = false;
		connection = getDBConnection();

		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM tasks WHERE id =?";
			statement = connection.prepareStatement(sql);	
			statement.setInt(1, id);

			statusOperation = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return statusOperation;
	
	}

	// find all tasks
	public List<Task> finAllTasks() throws SQLException {
		
		ResultSet resultSet = null;
		List<Task> list = new ArrayList();
		String sql = null;
		statusOperation = false;
		connection = getDBConnection();
		
		try {
			sql = "SELECT * FROM tasks";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()){
				Task t = new Task();
				
				t.setId(resultSet.getInt(1));
				t.setName(resultSet.getString(2));
				t.setDescription(resultSet.getString(3));
				t.setStart(resultSet.getString(4));
				t.setEnd(resultSet.getString(5));
				t.setDone(resultSet.getInt(6));
				
				list.add(t);
				
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}		

		return list;
	}

	// find task by id
	public Task findTask(int id) throws SQLException {
		
		ResultSet resultSet = null;
		Task t = new Task();
		
		String sql = null;
		statusOperation = false;
		connection = getDBConnection();
		
		try {
			sql = "SELECT * FROM tasks WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();	
				
			if(resultSet.next()) {
				t.setId(resultSet.getInt(1));
				t.setName(resultSet.getString(2));
				t.setDescription(resultSet.getString(3));
				t.setStart(resultSet.getString(4));
				t.setEnd(resultSet.getString(5));
				t.setDone(resultSet.getInt(6));
			}
				
		} catch (Exception e) {			
			e.printStackTrace();
		}		

		return t;
	}
	
	// Mark task as done
	public boolean doTask(int id) throws SQLException {

		String sql = null;
		statusOperation = false;
		connection = getDBConnection();

		try {
			connection.setAutoCommit(false);
			sql = "UPDATE tasks SET done=? WHERE id =?";
			statement = connection.prepareStatement(sql);

			statement.setInt(1,1);
			statement.setInt(2, id);				

			statusOperation = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return statusOperation;
	}

	// get connection from database
	private Connection getDBConnection() throws SQLException {
		return Conecction.getBDConnection();
	}
}

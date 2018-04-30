package db.mysql;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import entity.Expense;
import entity.Expense.ExpenseBuilder;

public class MySQLConnection implements DBConnection{
	private Connection conn;

	public MySQLConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection(MySQLDBUtil.URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void saveExpense(Expense expense) {
		if (conn == null) {
			return;
		}
		try {
			// First, insert into items table
			String sql = "INSERT IGNORE INTO items VALUES (?,?,?)";
			//IGNORE has the same function as primary key(avoid deduplicate)
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, expense.getDate());
			statement.setString(2, Double.toString(expense.getValue()));
			statement.setString(3, expense.getReason());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public List<Expense> searchExpenses() {
		if (conn == null) {
			return null;
		}
		List<Expense> expenses = new ArrayList<>();
		try {
			String sql = "SELECT * FROM EXPENSE";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				ExpenseBuilder builder = new ExpenseBuilder();
				builder.setDate(rs.getString("Date"));
				builder.setValue(Double.parseDouble(rs.getString("Value")));
				builder.setReason(rs.getString("Reason"));
				expenses.add(builder.build());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return expenses;
	}
}

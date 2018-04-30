package db;

import java.util.List;
import entity.Expense;

public interface DBConnection {

	public void close();


	public List<Expense> searchExpenses();


	public void saveExpense(Expense expense);

	
}

package entity;

public class Expense {
	private String date;
	private double value;
	private String reason;
	private Expense(ExpenseBuilder eBuilder) {
		this.date = eBuilder.date;
		this.value = eBuilder.value;
		this.reason = eBuilder.reason;
	}
	public static class ExpenseBuilder {
		private String date;
		private double value;
		private String reason;
		public ExpenseBuilder setDate(String date) {
			this.date = date;
			return this;
		}
		public ExpenseBuilder setValue(double value) {
			this.value = value;
			return this;
		}
		public ExpenseBuilder setReason(String reason) {
			this.reason = reason;
			return this;
		}
		public Expense build() {
			return new Expense(this);
		}
		
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}

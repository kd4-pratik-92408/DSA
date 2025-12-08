package Question02;

public class Employee {
	private int ID;
	private String Name;
	private double Salary;
	
	public Employee(int id, String name, double salary) {
		ID = id;
		Name = name;
		Salary = salary;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return Name;
	}

	public double getSalary() {
		return Salary;
	}
	
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d Name: %s Salary: %f\n", ID, Name, Salary);
	}
}

package Question02;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList list = new LinkedList();
		
		int choice;
		do {
			System.out.println("------------- MENU -------------");
			System.out.println("0. Exit");
			System.out.println("1. Add Employee");
			System.out.println("2. Display Employees");
			System.out.println("3. Search Employee By Name");
			System.out.println("4. Delete Employee By ID");
			System.out.println("5. Update Salary");
			System.out.println("6. Sort By Salary");
			System.out.print("Enter Your Choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 0:
				choice = 0;
				break;
				
			case 1:
				System.out.print("Enter Employee ID: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Employee Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Employee Salary: ");
				double salary = scanner.nextDouble();
				list.add(new Employee(id, name, salary));
				break;
				
			case 2:
				list.display();
				break;
				
			case 3:
			    System.out.print("Enter Employee Name: ");
			    String search = scanner.nextLine();
			    Employee emp = list.searchByName(search);

			    if (emp == null) {
			        System.out.println("Employee Not Found!!!");
			    } else {
			        System.out.println("Employee Found: " + emp);
			    }
			    break;

			case 4:
				System.out.print("Enter Employee ID: ");
				int deleteID = scanner.nextInt();
				boolean delete = list.deleteByID(deleteID);
				if (delete == false) {
					System.out.println("Employee Not Found");
				} else {
					System.out.println("Employee Deleted Successfully.");
				}
				break;
				
			case 5:
				System.out.print("Enter Employee ID: ");
				int updateID = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter New Salary: ");
				double newSalary = scanner.nextDouble();
				boolean update = list.updateSalary(updateID, newSalary);
				if (update != false) {
					System.out.println("Employee Salary Updated Successfully.");
				}else {
					System.out.println("Employee Not Found.");
				}
				break;
				
			case 6:
				list.sortBySalary();
				System.out.println("Sorted By Salary.");
				break;
				
			default:
				System.out.println("Invalid Choice!!! Try Again");
				break;
			}
		} while (choice != 0);
		scanner.close();
	}
}

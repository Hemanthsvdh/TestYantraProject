package coim;

public class TestEmployee {
	public static void main(String[] args) {
		EmployeeDao dao=new EmployeeDao();
		
//		Employee employee=new Employee();
//		employee.setId(11);
//		employee.setName("tom");
//		employee.setNum(34567.00);
//		dao.saveEmployee(employee);
		dao.getEmployee(11);
	
	}

}

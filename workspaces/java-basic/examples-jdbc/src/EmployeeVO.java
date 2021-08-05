import java.util.Date;

/***************************************************
 * 
 * HR 계정의 Employees 테이블의 데이터를 저장하는 VO 클래스 
 * 
 * @author instructor
 *
 ***************************************************/
public class EmployeeVO {
	
	// Employees 테이블의 컬럼을 Field로 구현
	private int employeeNo;
	private String firstName;
	private String lastName;
	private String email;
	private Date hireDate;

	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return String.format("[%3d][%15s][%15s][%20s][%s]", 
							 employeeNo, firstName, lastName, email, hireDate);
	}
}

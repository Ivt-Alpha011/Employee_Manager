package tech.codehunt.logic;
import tech.codehunt.dto.EmployeeDTO;
import tech.codehunt.crud.Crud;
import java.util.Scanner;
public class Logic {
private final int INSERT_DATA=1;
private final int READ_DATA=2;
private final int UPDATE_DATA=3;
private final int DELETE_DATA=4;
private final int EXIT=5;
private static final int MAX_ATTEMPTS=3;
private String username;
private String password;
private String fullname;
private String address;
private int salary;
private Crud crud;
public Logic() {
	crud=new Crud();
}
public void doStart() {
	Scanner sc=new Scanner(System.in);
	int attempt=0;
	while(true) {
		System.out.println("\n============MENU=============");
		System.out.println("Press-1 : INSERT DATA");
		System.out.println("Press-2 : READ DATA");
		System.out.println("Press-3 : UPDATE DATA");
		System.out.println("Press-4 : DELETE DATA");
		System.out.println("Press-5 : EXIT\n");
		System.out.println("Enter Your Choice: ");
		int choice=0;
		try {
			choice=sc.nextInt();
			}
		catch(Exception e)
		{
		System.out.println("Invalid Input! Please take a number from 1 to 5.\n");
		sc.nextLine();
		attempt++;
		if(attempt>=MAX_ATTEMPTS) {
			System.out.println("You have reached the limit");
			sc.close();
			return;
		}
		continue;
		}
		if(choice<1|| choice>5)
		{
			System.out.println("Invalid Input! please take a value from1 to 5.\n");
			attempt++;
			if(attempt>=MAX_ATTEMPTS) {
				System.out.print("You have reached the limit");
				sc.close();
				return;
			}
		}
		switch(choice)
		{
		case INSERT_DATA:
			System.out.println("****************** INSERT DATA *****************");
			System.out.println("ENTER USERNAME");
			username=sc.next();
			System.out.println("ENTER PASSWORD");
			password=sc.next();
			sc.nextLine();
			System.out.println("ENTER FULLNAME");
			fullname=sc.nextLine();
			System.out.println("ENTER ADDRESS");
			address=sc.nextLine();
			System.out.println("ENTER SALARY");
			salary=sc.nextInt();
			EmployeeDTO employeeDTO= new EmployeeDTO(username,password,fullname,address,salary);
			crud.insert(employeeDTO);
			break;
		case READ_DATA:
			System.out.println("***************** READ DATA *******************");
			System.out.println("ENTER USERNAME");
			username=sc.next();
			System.out.println("ENTER PASSWORD");
			password=sc.next();
			crud.read(username,password);
			break;
		case UPDATE_DATA:
			System.out.println("***************** UPDATE DATA ******************");
			System.out.println("ENTER USERNAME");
			username=sc.next();
			System.out.println("ENTER SALARY");
			salary=sc.nextInt();
			crud.update(username,salary);
			break;
		case DELETE_DATA:
			System.out.println("ENTER USERNAME");
			username=sc.next();
			crud.delete(username);
			System.out.println("***************** DELETE DATA ******************");
			break;
		case EXIT:
			System.out.println("EXIT");
			sc.close();
			return;
		}
	}
}

}

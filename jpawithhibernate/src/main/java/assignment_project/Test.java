package assignment_project;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("ENTER 1 TO DISPLY ALL DATA");
	System.out.println("ENTER 2 TO DISPLY DATAILS BY ID");
     int a = sc.nextInt();
     if (a==1) {
    	 EmployeList emplist=new EmployeList();
    	 emplist.displayAllData(); 
    	 
     }
     if (a==2) {
    	 //UpdateData updateData=new UpdateData();
    	 System.out.println("ENTER 1 TO UPDATE");
    	 System.out.println("ENTER 2 TO DELETE");
    	int b=sc.nextInt();
    	
    	if (b==1) {
			System.out.println("enter the id");
			int dd=sc.nextInt();
			UpdateData byiData=new UpdateData();
			byiData.update(dd);	
					
		}

    	if (b==2) {
			System.out.println("enter the id");
			int d1=sc.nextInt();
			DeleteData byiData=new DeleteData();
			byiData.delete(d1);	
					
		}
    	if (b==3) {
			Insert insert=new Insert();
			insert.insertData(5, "pooja", 9600, "andra");
		}
    	}
    	 
     }


}

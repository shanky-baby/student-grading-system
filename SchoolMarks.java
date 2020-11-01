import java.util.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class SchoolMarks {
        
    String ID, username, password, student, admin, enroll, newOrCurrent;
    String s = ("student");
    String a = ("admin");
    String aUser = ("s43123");
    String aPass = ("-North2020/");
    String sUser = ("u321");
    String sPass = ("u321");
    String classEnroll = ("enroll");
    String checkMarks = ("check marks");
    
    boolean loop = true;
    
    double Maths, IT, Biology, Painting, History;
    double finalM, finalI, finalB, finalP, finalH, finalGrade;
    int unitCodeMath = 4483;
    int unitCodeIT = 4486;
    int unitCodeBiology = 4485;
    int unitCodePainting = 4487;
    int unitCodeHistory = 4488;
    int unitCodeEcology = 4489;
    int unitCodeAccounting = 8873;
    int unitCodeChief = 8872;
    int unitCodeSpanish = 8871;
    int feeMath, feeIT, feeBiology, feePainting, feeHistory, feeEcology, feeAccounting, feeChief, feeSpanish;
    int unitCode;
   
    
    Scanner in = new Scanner(System.in);
    
    public SchoolMarks() throws FileNotFoundException 
    {
        System.out.print("\u000c");
        
        viewStudentGrades();
        studentOrStaff();
        adminLoginCheck();
        studentLoginCheck();
        enterStudentMarks();
        checkOrAddMarks();
        enrollInClasses();
        checkStudentMarks();

    }
    
    public void studentOrStaff() throws FileNotFoundException //login as either student or staff
    {
       while (loop)
       {
            System.out.println("\nAre you a student or admin:");
            admin =in.nextLine();
            
            if (admin.equals(a)) {
                adminLoginCheck();
            }
            else if (admin.equals(s)) {
                studentLoginCheck();    
            }
            else if (!admin.equals(a) && !student.equals(s)) {
                System.out.println("Can only enter either admin or student");
            }
         
       }
    }
    
    public void adminLoginCheck() throws FileNotFoundException // check if admin login is correct 
    {
        while (loop)
        {
            System.out.println("\nPlease enter account:");
            username =in.nextLine();
      
            System.out.println("\nPlease enter password:");
            password =in.nextLine();
        
            if (username.equals(aUser) && password.equals(aPass)){
                System.out.println("Login successful!");
                checkOrAddMarks();
            } 
            else {
                System.out.println("Incorrect Account Try Again");
            }
        } 
    }
    
    public void checkOrAddMarks() throws FileNotFoundException
    {
        System.out.print("Do you want to add new student marks or check current student marks");
        newOrCurrent = in.nextLine();
        
        if (newOrCurrent.equals("new")) {
            enterStudentMarks();
        }
        else if (newOrCurrent.equals("current")) {
            viewStudentGrades();
        }
    }
    
    public void studentLoginCheck() throws FileNotFoundException // check if student login is correct 
    {
        while(loop)
        {
            System.out.println("\nPlease enter account:");
            ID =in.nextLine();
      
            System.out.println("\nPlease enter password:");
            password =in.nextLine();
        
            if (ID.equals(sUser) && password.equals(sPass)){
                System.out.println("Login successful!"); 
                System.out.println("Would you like to enroll or check marks");
            } 
            else {
                System.out.println("Incorrect Account Try Again");
            }
            enroll = in.nextLine();
            
            if (enroll.equals(classEnroll)) {
                enrollInClasses();
            }
            else if (enroll.equals(checkMarks)) {
                viewStudentGrades();
            }
            
        }  
    }
    
    public void enrollInClasses()
    {
        List <String> listA = new ArrayList<>();
        listA.add("Maths");
        listA.add("IT");
        listA.add("Biology");
        listA.add("Painting");
        listA.add("History");
        listA.add("Ecology");
        listA.add("Accounting");
        listA.add("Chief");
        listA.add("Spanish");
        
        List <String> listB = new ArrayList <> ();
        listB.add("$1200");
        listB.add("$1780");
        listB.add("$1780");
        listB.add("$1780");
        listB.add("$1200");
        listB.add("$1200");
        listB.add("$1200");
        listB.add("$1780");
        listB.add("$1200");
        
        System.out.println("What units would you like to enroll in (Choose 4): ");
        for (int i=0; i<4; i++){
            int unitCode = in.nextInt();
            System.out.println("Units you have enrolled in: " + unitCode);
        }
        if (unitCode ==(unitCodeMath)) 
        {
            
        }
    }
    
    public void viewStudentGrades() throws FileNotFoundException //read & view text file 
    {
        File file = new File("FileTest.txt");
        Scanner scan = new Scanner(file);
                        
        while(scan.hasNextLine()) {
            System.out.println(scan.nextLine());
                    
        }
    }
    
    public void checkStudentMarks()
    {
        
    }
    
    public void enterStudentMarks() // admin enters student marks 
    {
        System.out.println("\n Please enter students ID:");
        ID =in.nextLine();
            
        System.out.println("\n please enter Math marks:");
        Maths =in.nextDouble();
            
        System.out.println("\n please enter IT marks:");
        IT =in.nextDouble();
            
        System.out.println("\n please enter Biology marks:");
        Biology =in.nextDouble();
            
        System.out.println("\n please enter Painting marks:");
        Painting =in.nextDouble();
            
        System.out.println("\n please enter History marks:");
        History =in.nextDouble();
        
        double finalM = (Maths / 100 * 30);
        double finalI = (IT / 100 * 20);
        double finalB = (Biology / 100 * 20);
        double finalP = (Painting / 100 * 10);
        double finalH = (History / 100 * 20);
        double finalGrade = finalM + finalI + finalB + finalP + finalH;
        
        System.out.println("====================");
                  
        System.out.println("Student ID   : " + (ID));
        System.out.println("Maths Mark   : " + (Maths));
        System.out.println("IT Mark      : " + (IT));
        System.out.println("Biology Mark : " + (Biology));
        System.out.println("Painting Mark: " + (Painting));
        System.out.println("History Mark : " + (History));
        
        System.out.println("Final Marks  : " + Math.round(finalGrade * 10.0) / 10.0);
            
        if (finalGrade >= 85)
        { 
              System.out.println("Final Grade: HD");
        }
            else if (finalGrade >= 75)
            {
                  System.out.println("Final Grade: D");
            }   
            else if (finalGrade >= 65)
            {
                  System.out.println("Final Grade: C");
            }
            else if (finalGrade >= 50)
            {
                  System.out.println("Final Grade: P");
            }
            else if (finalGrade < 50)
            {
                  System.out.println("Final Grade: F");
            }
            else if (finalGrade <= 0)
            {
                  System.out.println("Final Grade: N/A");
            }
          
        if (Maths >= 90)
        {
              System.out.println("Student can attend maths contest.");
        }
        if (Biology >= 75)
        {
              System.out.println("Student can apply for the Ecology unit.");
        }
        if (IT >= 85)
        {
              System.out.println("Student can get a Microsoft certificate.");
        }
        if (Painting >= 85)
        {
              System.out.println("Student can display their productions on the school website.");
        }
        if (finalGrade < 50)
        {
              System.out.println("Student needs to enrol in this unit again next semester");
        }
        
        System.out.println("=====================");
        
        if (Maths <50 || Biology <50 || IT <50 || Painting <50 || History <50)
        {
            System.out.println("The student needs to enrol again in: ");
            System.out.println("");
        }
        if (Maths ==0 || Biology ==0 || IT ==0 || Painting ==0 || History ==0)
        {
            System.out.println("The student needs to explain their absences for: ");
            System.out.println("");
        }
        
        System.out.println("Please restart program to re-log in as student or admin");
       
        System.exit(0);
    }
}
 

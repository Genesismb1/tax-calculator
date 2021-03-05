/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classjavafiles;
import java.util.Scanner;
/**
 *
 * @author monikabhatt
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating a scanner object
        Scanner scan=new Scanner(System.in);
        // Prompting user to enter the filing status and the taxable income
        //by calling promptUser() and promptIncome() methods
        int filingStatus = promptUser(scan);
        float taxableIncome = promptIncome(scan);
        
        // Calling singleFiler(), marriedJointly(), marriedSeparately, and householdHead methods
        //when filingStatus= 0,1,2, and 3 respectively
        switch(filingStatus)
        {
            case 0:
                System.out.println("Your personal tax is: " + singleFiler(scan, taxableIncome));
     
            break;
            case 1:
               System.out.println("Your personal tax is: " + marriedJointly(scan, taxableIncome));
            break;
            case 2:
                System.out.println("Your personal tax is: " + marriedSeparately(scan, taxableIncome));
            break;
            case 3:
                System.out.println("Your personal tax is: " + householdHead(scan, taxableIncome));
            break;
        }
    }
    
    // Declaration of the promptUser method to allow user to enter the filingstatus
    
    static int promptUser(Scanner scan){
        int filingStatus = 0;
        char runLoop='y';
        
        System.out.println("Calculate your personal income tax below: \n");
        System.out.println("Enter your filing status:"); 
        System.out.println("0 - Single Filer");
        System.out.println("1 - Married Filing Jointly or Qualified Widow(er)");
        System.out.println("2 - Married Filing Separately");
        System.out.println("3 - Head of Household \n");
        
        //Handling exception that can arise when entering the value of filingStatus
        //Checking if the values fall between 0 to 3, if not let the user enter the value again
        do{
            try {
                filingStatus = scan.nextInt();
            
                if (filingStatus < 0 || filingStatus > 3) {
                    System.out.println("Enter values between 0 to 3");
                }
                else{
                    runLoop='n';
                }
            }
            catch (Exception e){
                System.out.println("Enter integer value");
                scan.next();
            }
        }
        while (runLoop=='y');
        
        return filingStatus;
    }
    
    // Declaring the promptIncome method to allow user to enter the value of taxableIncome
    
    static float promptIncome(Scanner scan)
    {
        float taxableIncome = 0;
        char runLoop = 'y';
        System.out.println("Enter the taxable income");
        
        //Handling exception that can arise when entering the value of taxableIncome
        //Checking if the value entered is below 0, if so, let the user enter the value again
        
        do{
            try {
                taxableIncome = scan.nextFloat();
                if (taxableIncome < 0) {
                    System.out.println("Enter a non-negative value");
                }
                else{
                    runLoop='n';
                }
                }
            catch (Exception e){
                System.out.println("Enter float value");
                scan.next();
            }
        }
        while (runLoop=='y');
        
        return taxableIncome;
    }
    
    //Declaring the singleFiler method which runs when filingStatus==0
    //calling the eqTwo, eqThree, eqFour, eqFive, and eqSix methods
    //when taxableIncome falls in the second, third, fourth, fifth or sixth slabs respectively
    
    static float singleFiler(Scanner scan, float taxableIncome){ 
        
        if ((taxableIncome >=0) && (taxableIncome <= 8350)){
            return (float) (0.1 * taxableIncome);
        }
        else if ((taxableIncome >=8351) && (taxableIncome <= 33950)){
            return eqTwo(8350, taxableIncome);
        }
        else if ((taxableIncome >=33951) && (taxableIncome <= 82250)){
            return eqThree(8350, 33950, taxableIncome);
        }
        else if ((taxableIncome >=82251) && (taxableIncome <= 171550)){
            return eqFour(8350, 33950, 82250, taxableIncome);
        }
        else if ((taxableIncome >=171551) && (taxableIncome <= 372950)){
            return eqFive(8350, 33950, 82250, 171550, taxableIncome);
        }
        else {
            return eqSix(8350, 33950, 82250, 171550, 372950, taxableIncome);
        }
    }
    
    //Declaring the marriedJointly method which runs when filingStatus==1
    //calling the eqTwo, eqThree, eqFour, eqFive, and eqSix methods
    //when taxableIncome falls in the second, third, fourth, fifth or sixth slabs respectively
    
    static float marriedJointly(Scanner scan, float taxableIncome){
        
        if ((taxableIncome >=0) && (taxableIncome <= 16700)){
                return (float) (0.1 * taxableIncome);
            }
            else if ((taxableIncome >=16701) && (taxableIncome <= 67900)){
                return eqTwo(16700, taxableIncome);
            }
            else if ((taxableIncome >=67901) && (taxableIncome <= 137050)){
                return eqThree(16700, 67900, taxableIncome);
            }
            else if ((taxableIncome >=137501) && (taxableIncome <= 208850)){
                return eqFour(16700, 67900, 137050, taxableIncome);
            }
            else if ((taxableIncome >=208851) && (taxableIncome <= 372950)){
                return eqFive(16700, 67900, 137050, 208850, taxableIncome);
            }
            else {
                return eqSix(16700, 67900, 137050, 208850, 372950, taxableIncome);
            }
    }
    
    //Declaring the marriedSeparately method which runs when filingStatus==2
    //calling the eqTwo, eqThree, eqFour, eqFive, and eqSix methods
    //when taxableIncome falls in the second, third, fourth, fifth or sixth slabs respectively
    
    static float marriedSeparately(Scanner scan, float taxableIncome){
        
        if ((taxableIncome >=0) && (taxableIncome <= 8350)){
            return (float) (0.1 * taxableIncome);
        }
        else if ((taxableIncome >=8351) && (taxableIncome <= 33950)){
            return eqTwo(8350, taxableIncome);
        }
        else if ((taxableIncome >=33951) && (taxableIncome <= 68525)){
            return eqThree(8350, 33950, taxableIncome);
        }
        else if ((taxableIncome >=68526) && (taxableIncome <= 104425)){
            return eqFour(8350, 33950, 68525, taxableIncome);
        }
        else if ((taxableIncome >=104426) && (taxableIncome <= 186475)){
            return eqFive(8350, 33950, 68525, 104425, taxableIncome);
        }
        else {
            return eqSix(8350, 33950, 68525, 104425, 186475, taxableIncome);
        }
    }
    
    //Declaring the householdHead method which runs when filingStatus==3
    //calling the eqTwo, eqThree, eqFour, eqFive, and eqSix methods
    //when taxableIncome falls in the second, third, fourth, fifth or sixth slabs respectively
    
    static float householdHead(Scanner scan, float taxableIncome){
        if ((taxableIncome >=0) && (taxableIncome <= 11950)){
            return (float) (0.1 * taxableIncome);
        }
        else if ((taxableIncome >= 11951) && (taxableIncome <= 45500)){
            return eqTwo(11950, taxableIncome);
        }
        else if ((taxableIncome >= 45501) && (taxableIncome <= 117450)){
            return eqThree(11950, 45500, taxableIncome);
        }
        else if ((taxableIncome >= 117451) && (taxableIncome <= 190200)){
            return eqFour(11950, 45500, 117450, taxableIncome);
        }
        else if ((taxableIncome >= 190201) && (taxableIncome <= 372950)){
            return eqFive(11950, 45500, 117450, 190200, taxableIncome);
        }
        else {
            return eqSix(11950, 45500, 117450, 190200, 372950, taxableIncome);
        }
    }
    
    //Declaring the eqTwo variable which runs an equation if taxableIncome falls on the second
    //slab of a corresponding filingStatus
    
    static float eqTwo(float slab1, float taxableIncome){
        return (float) ((0.1*slab1)+(0.15*(taxableIncome-slab1)));
    }
    
    //Declaring the eqThree variable which runs an equation if taxableIncome falls on the third
    //slab of a corresponding filingStatus
    
    static float eqThree(float slab1, float slab2, float taxableIncome){
        return (float) ((0.1*slab1)+(0.15*(slab2-slab1))+(0.25*(taxableIncome-slab2)));
            
    }
    
    //Declaring the eqFour variable which runs an equation if taxableIncome falls on the fourth
    //slab of a corresponding filingStatus
    
    static float eqFour(float slab1, float slab2, float slab3, float taxableIncome){
        return (float) ((0.1*slab1)+(0.15*(slab2-slab1))+(0.25*(slab3-slab2))+(0.28*(taxableIncome - slab3)));
    }
    
    //Declaring the eqFive variable which runs an equation if taxableIncome falls on the fifth
    //slab of a corresponding filingStatus
    
    static float eqFive (float slab1, float slab2, float slab3, float slab4, float taxableIncome){
        return (float) ((0.1*slab1)+(0.15*(slab2-slab1))+(0.25*(slab3-slab2))+(0.28*(slab4-slab3))+(0.33*(taxableIncome-slab4)));
    }
    
    //Declaring the eqSix variable which runs an equation if taxableIncome falls on the sixth
    //slab of a corresponding filingStatus
    
    static float eqSix(float slab1, float slab2, float slab3, float slab4, float slab5, float taxableIncome){
        return (float) ((0.1*slab1)+(0.15*(slab2-slab1))+(0.25*(slab3-slab2))+(0.28*(slab4-slab3))+(0.33*(slab5-slab4))+(.35*(taxableIncome-slab5)));
    }
        
}
 

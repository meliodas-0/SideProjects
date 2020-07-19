import java.lang.*;
import java.util.*;

class Email{

    private String firstName;
    private String lastName;
    private String department;
    private final String company = "sideprojects.com";
    private String password;
    private int passwordLength = 10;
    private String email;
    private int mailboxCapacity = 500;

    //Constructor

    Email(){
        //ask for first and last name
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the firstname: ");
        this.firstName = sc.next().toLowerCase();
        System.out.print("Enter the lastname: ");
        this.lastName = sc.next().toLowerCase();

        //ask for department

        System.out.print("Enter the department:\n 1 : Developer\n 2 : Accounting\n 3: Sales \n 4: other\n");
        int t = sc.nextInt();
        switch (t) {
            case 1:
                this.department = "dev";
                break;
            case 2:
                this.department = "acc";
                break;
            case 3:
                this.department = "sales";
                break; 
            default:
                this.department = "other";
        }

        //ask for password length

        System.out.print("Enter the password length: ");
        t = sc.nextInt();
        while(t<8 || t>63){
            System.out.print("sorry, length not acceptable. Please, enter the password length: ");
            t = sc.nextInt();
        }

        this.passwordLength = t;

        //generate email

        this.email = this.firstName + "." + this.lastName + "@" + this.department + "." + this.company;

        //generate password 

        genPassword();

        while(t != 0){

            System.out.println("Your password is : " + this.password + "\n press 1: change password\n 2: display name\n 3: display email\n 4: display mail capacity\n 0: quit");

            t = sc.nextInt();

            switch (t) {
                case 1:
                    //change password 
                    setPassword();
                    break;
                case 2:
                    System.out.println("Name : " + getName());
                    break;
                case 3:
                    System.out.println("Email : " + getEmail());
                    break;
                case 4: 
                    System.out.println("Mailbox Capacity: " + getMailboxCapacity() + "MB");
                    break;
            
                default:
                    break;
            }
        }

    }

    private void genPassword(){
        final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-+/?";
        String password = "";
        for(int i = 0; i<this.passwordLength; i++){
            password += abc.charAt((int)(Math.random() * abc.length()));
        }
        this.password = password;
    }

    //setter

    private void setPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length: ");
        int t = sc.nextInt();
        while(t<8 || t>63){
            System.out.print("sorry, length not acceptable. Please, enter the password length: ");
            t = sc.nextInt();
        }
        this.passwordLength = t;
        genPassword();
    }

    //getters

    private String getName(){
        return this.firstName + " " + this.lastName;
    }

    private String getEmail(){
        return this.email;
    }

    private int getMailboxCapacity(){
        return this.mailboxCapacity;
    }
}

class SideProjectLevel1{
    public static void main(String[] args) {
        Email email = new Email();
    }
}
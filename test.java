import java.util.ArrayList;
import java.util.Scanner;

public class test{
    public static void main(String []  args){

        room r1 = new room(121,1000,"luxury","one","clean","second","yes");
        room r2 = new room(122,1000,"luxury","one","clean","second","yes");
        room r3 = new room(123,1000,"luxury","one","clean","second","yes");

        //define arraylist..
        ArrayList<room> rLs1 = new ArrayList<>();
        ArrayList<room> rAvailable = new ArrayList<>();
        ArrayList<room> rBook = new ArrayList<>();
        rLs1.add(r1);
        rLs1.add(r2);
        rLs1.add(r3);


        //code to load available room arraylist..
        for(int i = 0 ; i< rLs1.size() ; i++){
            if(rLs1.get(i).getrAvailability()=="yes"){
                rAvailable.add(rLs1.get(i));
            }
        }

        Scanner input = new Scanner(System.in);
        int control;
        while(true){


            System.out.println("Press 1 to book the room : ");
            System.out.println("Press 2 to see available the room : ");
            System.out.println("Press 3 to Checkout from the room : ");
            System.out.println("Press 4 to see Booked rooms : ");
            System.out.println("Press 5 to exit the program : ");


            control = input.nextInt();

            if(control == 1){
                int rNumber;
                System.out.println("Enter the Room number you want to book : ");
                rNumber = input.nextInt();

                for(int i = 0 ; i< rLs1.size() ; i++){
                    if(rLs1.get(i).getrNumber()==rNumber){
                        rBook.add(rLs1.get(i));
                    }
                }

                for(int i = 0 ; i< rAvailable.size() ; i++){
                    if(rAvailable.get(i).getrNumber()==rNumber){
                        rAvailable.remove(i);  
                    }
                }
                    

            }
            else if(control == 2){
                for(int i = 0 ; i< rAvailable.size() ; i++){
                    rAvailable.get(i).show();
                }            
            }

            else if(control == 3){
                int rNumber;
                System.out.println("Enter the Room number you want to check out : ");
                rNumber = input.nextInt();

                for(int i = 0 ; i< rLs1.size() ; i++){
                    if(rLs1.get(i).getrNumber()==rNumber){
                        rAvailable.add(rLs1.get(i));
                    }
                }

                for(int i = 0 ; i< rBook.size() ; i++){
                    if(rBook.get(i).getrNumber()==rNumber){
                        rBook.remove(i);
                    }
                }

                

            }

            else if(control == 4){
                for(int i = 0 ; i< rBook.size() ; i++){
                    
                    rBook.get(i).show();
                } 
            }

            else if(control == 5){
                break;
            }

            else{
                System.out.println("Enter the right number.");
            }

        }





    }
}
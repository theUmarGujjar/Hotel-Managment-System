import java.util.ArrayList;
import java.util.Scanner;

public class booking{
    public static void main(String []  args){

        room r1 = new room(121,1000,"luxury","one","clean","second","yes");
        room r2 = new room(122,1000,"luxury","one","clean","second","yes");
        room r3 = new room(123,1000,"luxury","one","clean","second","yes");

        //define arraylist of room class..
        ArrayList<room> rLs1 = new ArrayList<>();
        ArrayList<room> rAvailable = new ArrayList<>();
        ArrayList<room> rBook = new ArrayList<>();
        rLs1.add(r1);
        rLs1.add(r2);
        rLs1.add(r3);

        //define arraylist of person class..
        ArrayList<PersonWhoBook> database = new ArrayList<>();
        ArrayList<PersonWhoBook> pBook = new ArrayList<>();



        //code to load available room arraylist..
        for(int i = 0 ; i< rLs1.size() ; i++){
            if(rLs1.get(i).getrAvailability()=="yes"){
                rAvailable.add(rLs1.get(i));
            }
        }

        Scanner input = new Scanner(System.in);
        int control;
        while(true){

            System.out.println();
            System.out.println("Press The Number Carefully : ");
            System.out.println();
            System.out.println("Press 1 to book the room : ");
            System.out.println("Press 2 to see available the room : ");
            System.out.println("Press 3 to Checkout from the room : ");
            System.out.println("Press 4 to see Booked rooms : ");
            System.out.println("Press 5 to update the booked details : ");
            System.out.println("Press 6 to exit the program : ");


            control = input.nextInt();

            if(control == 1){
                int rNumber;
                System.out.println("Enter the Room number you want to book : ");
                rNumber = input.nextInt();
                Boolean found = false;

                for(int i = 0 ; i< rAvailable.size() ; i++){
                    if(rAvailable.get(i).getrNumber()==rNumber){
                        rBook.add(rAvailable.get(i));
                        PersonWhoBook p = new PersonWhoBook(rNumber);
                        pBook.add(p);
                        found = true;
                    }
                }
                    if(!found){
                        System.out.println("That room is not available...");
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
                        pBook.remove(i);
                    }
                }

                

            }

            else if(control == 4){
                if(rBook.size()==0){
                    System.out.println("None of the room is booked");
                }
                for(int i = 0 ; i< rBook.size() ; i++){
                    System.out.println();
                    System.out.println("Detail of the "+ (i+1) + " # person");
                    System.out.println();
                    System.out.println("person who booked the room : "+ pBook.get(i).getName());
                    System.out.println("CNIC of that person : " + pBook.get(i).getCnic());
                    rBook.get(i).show();
                    System.out.println();
                    
                    while(true){
                        int number;
                        System.out.println("Press 1 to get details of that person : ");
                        System.out.println("Press 2 to go back : ");
                        number = input.nextInt();
                        
                        while(true){
                            if(number == 1){
                                pBook.get(i).displayData();
                                break;
                            }

                            else if(number == 2){
                                break;
                            }
                            else{
                                System.out.println(); 
                                System.out.println("Wrong Input...");
                                System.out.println();
                            }
                        }
                        break;

                    }
                } 
            }

            else if(control == 5){
                int num ;
                System.out.println("Press 1 to update the details by room number :");
                System.out.println("Press 2 to update the details by the person CNIC :");
                num = input.nextInt();
                input.nextLine();


                while(true){
                    if(num==1){
                        int roomN;
                        System.out.println("Enter the room number which details you want to update : ");
                        roomN = input.nextInt();

                        for(int i = 0 ; i<rBook.size() ; i++){
                            if(rBook.get(i).getrNumber() == roomN){
                                PersonWhoBook p = new PersonWhoBook(roomN);
                                pBook.set(i,p);
                            }
                        }
                        break;
                    }

                    //testing phase start...
                    else if(num ==2){
                        String updateCnic;
                        System.out.println("Enter the CNIC of the person whose details you want to update : ");
                        updateCnic = input.nextLine();
                        
                        Boolean found = false;
                        for(int i = 0 ; i < pBook.size() ; i++){
                            if(pBook.get(i).getCnic() == updateCnic){
                                int roomN = rBook.get(i).getrNumber();
                                PersonWhoBook p = new PersonWhoBook(roomN);
                                pBook.set(i,p);
                                found = true;

                            }

                            
                        }
                            if(!found){
                                System.out.println("NO DATA OF SUCH CNIC...");
                            }

                        
                        
                        break;

                    }
                    //testing phase end..

                    else{
                        System.out.println(); 
                        System.out.println("Wrong Input...");
                        System.out.println();
                    }
                }
            }


            else if(control == 6){
                break;
            }



            else{
                System.out.println("Enter the right number.");
            }

        }





    }
}
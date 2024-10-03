public class individual{
    public String name;
    private int cnic;
    private String gmail;
    private String phoneNumber;
    private String dob;
    
    authorization aut = new authorization();

    // constructors..
    individual(){
        System.out.println("Empty constructor run..");
    }

    individual(String name , int cnic , String phoneNumber , String gmail , String dob){
        setInfo(name , cnic , phoneNumber , gmail , dob);
        
    }

    public void setAuthorization(String userName , String passWord){
        aut.setAuthorization( userName , passWord);
    }

    public void setName(String name){
        this.name = name;
    } 

    public void setCnic(int cnic){
        this.cnic = cnic;
    }

    public void setGmail(String gmail){
        this.gmail = gmail;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setDob(String dob){
        this.dob = dob;
    }

    public void setInfo(String name , int cnic , String phoneNumber , String gmail , String dob){
        setName(name);
        setCnic(cnic);
        setPhoneNumber(phoneNumber);
        setGmail(gmail);
        setDob(dob);
    }


    public String getName(){
        return name;
    }

    public int getCnic (){
        return cnic;
    }

    public String getGmail(){
        return gmail;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getDob(){
        return dob;
    }

}
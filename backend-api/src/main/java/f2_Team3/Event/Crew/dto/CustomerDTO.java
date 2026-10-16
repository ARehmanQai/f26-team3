package f2_Team3.Event.Crew.dto;

public class CustomerDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public CustomerDTO(){

    }

    public CustomerDTO(String name, String email, String password, String phoneNumber){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassWord(){
        return password;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassWord(String password){
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


}
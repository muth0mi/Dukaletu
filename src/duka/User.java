package duka;


public class User {
    private int id  ;
    private String mEmail ;
    private String mPassword ;
    private String mUserType;


    public User(int id, String email, String password, String userType) {
        this.id = id;
        this.mEmail = email;
        this.mPassword = password;
        this.mUserType = userType;
    }


    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getEmail(){
        return this.mEmail;
    }
    
    public void setEmail(String mEmail){
        this.mEmail = mEmail;
    }
    
    public String getPassword(){
        return this.mPassword;
    }
    
    public void setPassword(String mPassword){
        this.mPassword = mPassword;
    }

    public String getmUserType() {
        return mUserType;
    }

    public void setUserType(String mUserType) {
        this.mUserType = mUserType;
    }
    
}

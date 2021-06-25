package main.com.company;

public class User {

    private String Id;

    private  String login;

    private String password;

    private  String PlaceOfBirth;

    private String PhoneNumber;

    public User () {}

    public User(String id, String login, String password, String placeOfBirth, String phoneNumber) {

        this.Id = id;
        this.login = login;
        this.password = password;
        PlaceOfBirth = placeOfBirth;
        PhoneNumber = phoneNumber;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlaceOfBirth() {
        return PlaceOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        PlaceOfBirth = placeOfBirth;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

}

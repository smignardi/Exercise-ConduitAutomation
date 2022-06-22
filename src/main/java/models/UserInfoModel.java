package models;

import com.github.javafaker.Faker;

public class UserInfoModel {

    private final String usernmae;
    private final String email;
    private final String password;

    public UserInfoModel() {
        var faker = new Faker();
        this.usernmae = faker.name().firstName();
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password(6,8,true,true,true);
    }

    public String getUsernmae() {
        return usernmae;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

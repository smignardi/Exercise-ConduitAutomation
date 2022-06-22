package signup;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.signup.SignUpPage;
import utilities.DataProviders;

import static utilities.DataProviders.WRONG_SIGN_UP_DATA_DP;

public class SignUpTests extends BaseTest {

    private SignUpPage signUpPage;

    @BeforeMethod
    public void setup(){
        commonFlows.goToSignUp();
    }

    @Test(dataProvider = WRONG_SIGN_UP_DATA_DP, dataProviderClass = DataProviders.class)
    public void signUpTest(String username, String email, String password,String errorMessage){
        signUpPage.fillSignUpForm(username,email,password);
        signUpPage.verifyErrorMessageText(errorMessage);
    }

    @Override
    protected void initPages() {
        signUpPage = new SignUpPage(driver);
    }
}

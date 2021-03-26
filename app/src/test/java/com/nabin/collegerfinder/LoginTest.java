package com.nabin.collegerfinder;

import com.nabin.collegerfinder.Bll.LoginBll;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoginTest {
    boolean expect = true;
    boolean actual = false;

    @Test
    public void login() {
        String username = "bharat123";
        String password = "bharat";

        LoginBll loginBLL = new LoginBll();

        if (loginBLL.checkUser(username, password)) {

            actual = true;
        }
        assertEquals(actual, expect);
    }
}

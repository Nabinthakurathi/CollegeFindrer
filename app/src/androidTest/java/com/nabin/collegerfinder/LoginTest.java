package com.nabin.collegerfinder;

import com.nabin.collegerfinder.Bll.LoginBll;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoginTest {
    @Test
    public void testLogin()
    {
        LoginBll loginBLL = new LoginBll();
        boolean result =  loginBLL.checkUser("nabin12", "nabin");
        assertEquals(true, result);
    }
}

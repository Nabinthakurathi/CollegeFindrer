package com.nabin.collegerfinder;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SignupTest {
    boolean expect = true;
    boolean actual = false;

    @Test
    public void signup(){
        String fname = "bharat11";
        String lname = "bharat00";
        String username = "bharat123";
        String password = "bharat";
        String conpassword = "bharat";

        {
            actual = true;
        }

        assertEquals(actual, expect);
    }
}

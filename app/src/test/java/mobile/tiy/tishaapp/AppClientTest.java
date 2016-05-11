package mobile.tiy.tishaapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tisha868 on 5/11/16.
 */
public class AppClientTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendMessage() throws Exception {
        AppClient client = new AppClient();
        String message = "Hei";
        String anotherMessage = "hey me to";
        String sentMessage1 = client.sendMessage(message);//expecting a string
        String sentMessage2 = client.sendMessage(anotherMessage);
        assertEquals(message, sentMessage1); //BEFORE *,* = is expected message. After the comma is what was returned.
      //  assertEquals(message, sentMessage2);
    }

}
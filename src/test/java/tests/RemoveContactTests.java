package tests;

import models.User;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    //before - login
    @BeforeMethod
    public void preCondition(){
        if (!app.getUser().isLogged()) {
            app.getUser().login(new User()
                    .withEmail("noa@gmail.com")
                    .withPassword("Nnoa12345$"));
        }
        //provider Contacts() ---->add3
        app.contact().providerOfContacts();
    }



    //removeOneContact - test1
    @Test
    public void removeOneContact(){
               app.contact().removeOneContact();
               //assert countStart - countEnd =====> 1
    }

   @Test
   public void removeOneContactCount(){
       Assert.assertEquals(app.contact().removeOneContactCount(),-1);
   }
    //Assert.assertEquals(app.contact().removeOneContactCount(),-1);
    // int count = app.contact().removeOneContactCount();
    //Assert.assertEquals(countEnd-countStart,1);
    //assert countStart - countEnd =====> 1


@Test
    public void removeAllContactsTest() {
        app.contact().removeAllContacts();
        Assert.assertTrue(app.contact().isContactsListIsEmpty());
    }}


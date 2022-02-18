package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

    @BeforeMethod
    public void preConditions(){
        if (!app.getUser().isLogged()) {
            app.getUser().login(new User()
                    .withEmail("noa@gmail.com")
                    .withPassword("Nnoa12345$"));
        }
    }
    @Test
    public void addNewContactSuccess(){
       // if(count >5){
        //remove all contact();
        // }
        int countStart = app.contact().countOfContacts();
        System.out.println(countStart);

        int index= (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println();

        // Contact contact = Contact.builder()
        // .name
        //.........
        // .build;
        Contact contact = new Contact()
                .withName("Zoa")
                .withLastName("Snow")
                .withPhone("1234567" + index)
                .withEmail("zoa"+index+ "@gmail.com")
                .withAddress("Haifa")
                .withDescription("friend");
        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();

        int countEnd = app.contact().countOfContacts();
        System.out.println("countEnd"+countEnd);
        app.contact().pause(2000);
        //Assert.assertTrue(isContactPageDisplayed());
       // if countStart-countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        //if list contact with name + phone
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));

    }


}

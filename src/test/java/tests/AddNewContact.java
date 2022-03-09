package tests;

import manager.MyDataProvider;
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


    @Test (invocationCount = 3) //(invocationCount = 4)
    public void addNewContactSuccess(){

        int countStart = app.contact().countOfContacts();
        logger.info("The test 'Add new contact starts with count of contact---->"+countStart );

        int index= (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println();

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
        logger.info("The test 'Add new contact' ends with count of contact in the end --->"+countEnd);

        app.contact().pause(2000);
        //Assert.assertTrue(isContactPageDisplayed());
       // if countStart-countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName())); //if list contact with name + phone
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));

    }

    @Test (dataProvider = "addContactValidDataCSV",dataProviderClass = MyDataProvider.class)
    public void addNewContactSuccessScv(Contact contact){

        int countStart = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' starts with count of contact---->"+countStart );
        logger.info("The test 'Add new contact' starts with data ---->" +contact.toString());

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();

        int countEnd = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' ends with count of contact in the end --->"+countEnd);

        app.contact().pause(2000);
        Assert.assertEquals(countEnd-countStart,1);
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName())); //if list contact with name + phone
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));

    }

    @Test (dataProvider = "dt")
    public void addNewContactSuccessNew(){

        int countStart = app.contact().countOfContacts();
        logger.info("The test 'Add new contact starts with count of contact---->"+countStart );

        int index= (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println();

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
        logger.info("The test 'Add new contact' ends with count of contact in the end --->"+countEnd);

        app.contact().pause(2000);
        //Assert.assertTrue(isContactPageDisplayed());
        // if countStart-countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName())); //if list contact with name + phone
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));

    }

}

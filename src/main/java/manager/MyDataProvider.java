package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
 public Iterator<Object[]> loginValidData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        return list.iterator();
    }

@DataProvider
    public Iterator<Object[]> ContactValidData(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"});
        list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"});
        list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"});
        return list.iterator();
}

    @DataProvider
    public Iterator<Object[]> addContactValidDataModel(){
        List<Object[]> list = new ArrayList<>();

       // list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"});
        //list.add(new Object[]{Contact.builder().name("").lasrName("").build()});
        list.add(new Object[]{new Contact().withName("").withLastName("").withPhone("").withEmail("").withAddress("").withDescription("")});
        list.add(new Object[]{new Contact().withName("").withLastName("").withPhone("").withEmail("").withAddress("").withDescription("")});
        list.add(new Object[]{new Contact().withName("").withLastName("").withPhone("").withEmail("").withAddress("").withDescription("")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactValidDataCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/nn.csv")));
        String line = reader.readLine();//Mona,Dow,3214598765,mona@gmail.com,Haifa,friend

//        while (line!=null){
//            String[]split = line.split(",");
//            list.add(new Object[]{ Contact.builder()
//                    .name(split[0])
//                .lastName(split[1])
//                .description(split[5])
//                .address(split[4])
//                .email(split[3])
//                .phone(split[2])
//                 .build()});
//            line= reader.readLine();
        //    }

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact()
                    .withName(split[0])
                    .withLastName(split[1])
                    .withPhone(split[2])
                    .withEmail(split[3])
                    .withAddress(split[4])
                    .withDescription(split[5])
            });
            line = reader.readLine();
        }
            return list.iterator();
        }

}



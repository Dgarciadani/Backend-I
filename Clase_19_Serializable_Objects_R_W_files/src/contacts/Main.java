package contacts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contacts> contactsArray = new ArrayList<>();

        Contacts contact1 = new Contacts("Pedro", "pepi@gmai.com", 1L);
        Contacts contact2 = new Contacts("Pablo", "Pablo@gmail.com", 2L);

        contactsArray.add(contact1);
        contactsArray.add(contact2);

        FileOutputStream fo = null;
        try{
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            oos.writeObject(contactsArray);

        }catch (Exception e) {
            System.out.println("Write Objet: ERROR, "+e.getMessage());
        }


        List<Contacts> contactsRead = new ArrayList<>();
        FileInputStream fis = null;

        try{
            fis = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            contactsRead = (ArrayList) ois.readObject();

        }catch (Exception e) {
            System.out.println("Read File: ERROR, " +e.getMessage());
        }finally{
            for (Contacts contacts : contactsRead){
                System.out.println("name: "+ contacts.getName()+"\n"+ "email: "+contacts.getMail()+"\n"+"phonenumber:" +contacts.getPhonenumber()+"\n--------------");
            }
        }


    }
}

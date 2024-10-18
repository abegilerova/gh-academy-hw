package java_hw.week3;

import java.util.ArrayList;
import java.util.Collections;

import java.util.*;

import static java.util.Collections.*;

public class ContactManagement {
    public ArrayList<Contacts> allContacts;
    public HashMap<String, String> phoneNumberByName;
    public Set<String> uniqueDomainNames;

    public ContactManagement (){
        allContacts = new ArrayList<>();
        phoneNumberByName = new HashMap<>();
        uniqueDomainNames = new HashSet<>();
    }


    public void addNewContact(Contacts contact){
        if(!allContacts.contains(contact)){
            allContacts.add(contact);
            phoneNumberByName.put(contact.name, contact.phoneNumber);
            String extractedDomain = contact.email.substring(contact.email.indexOf("@") + 1);
            uniqueDomainNames.add(extractedDomain);
        }
    }

    public void displayAllContacts(){
        for (Contacts contact : allContacts){
            System.out.println("name is " + contact.name);
            System.out.println("phone number is " + contact.phoneNumber);
            System.out.println("email is " + contact.email);
            System.out.println("total size is " + allContacts.size());
        }
    }

    public Contacts searchByName(String name){
        for (Contacts contact : allContacts){
            if (contact.name.equals(name)){
                System.out.println("found contact " + contact.name);
                return contact;
            }
        }
        return null;
    }

    public void displayAllContactsSorted(){
        //Collections.sort(allContacts);
        for (Contacts contact : allContacts){
            System.out.println("name is " + contact.name);
            System.out.println("phone number is " + contact.phoneNumber);
            System.out.println("email is " + contact.email);
            System.out.println("total size is " + allContacts.size());
        }
    }

    public boolean removeContact(Contacts contact){
        for (Contacts ct : allContacts){
            if (ct.name.equals(contact.name) && ct.email.equals(contact.email) && ct.phoneNumber.equals(contact.phoneNumber)){
                allContacts.remove(contact);
                return true;
            }
        }
        return false;
    }

    public String searchByNameReturnPhoneNumber(String name){
        if (phoneNumberByName.containsKey(name)){
            return phoneNumberByName.get(name);
        }
        return "Contact not found";
    }

    public void updatePhoneNumberExistingContact(String name, String phoneNumber){
        if (phoneNumberByName.containsKey(name)){
            phoneNumberByName.put(name, phoneNumber);
        }
    }

    public void displayUniqueDomainNames(){
        System.out.println("Unique domain names " + uniqueDomainNames);
    }

}

package java_hw.week3;

public class Main {
    public static void main(String[] args) {
        Contacts c1 = new Contacts("Aika", "5464643", "fsafa@gmail.com");
        Contacts c2 = new Contacts("Beka", "5464649", "fdddad@gmail.com");
        Contacts c3 = new Contacts("Aika", "5464643", "fsafa@gmail.com");


        ContactManagement cm = new ContactManagement();
        cm.addNewContact(c1);
        cm.addNewContact(c2);
        cm.addNewContact(c3);
        cm.addNewContact(c3);
        cm.displayAllContacts();

        cm.searchByName("Aika");

        cm.displayUniqueDomainNames();

    }
}

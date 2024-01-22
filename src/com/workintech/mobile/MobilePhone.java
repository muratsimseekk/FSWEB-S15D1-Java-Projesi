package com.workintech.mobile;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) == -1) {
            myContacts.add(contact);
            System.out.println(contact.getName() + " başarıyla eklendi.");
            return true;
        } else {
            System.out.println(contact.getName() + " zaten listede bulunuyor. Eklenemedi.");
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position >= 0) {
            myContacts.set(position, newContact);
            System.out.println(oldContact.getName() + " başarıyla güncellendi. Yeni bilgiler: " + newContact);
            return true;
        } else {
            System.out.println(oldContact.getName() + " listede bulunamadı. Güncelleme yapılamadı.");
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position >= 0) {
            myContacts.remove(position);
            System.out.println(contact.getName() + " başarıyla silindi.");
            return true;
        } else {
            System.out.println(contact.getName() + " listede bulunamadı. Silme işlemi yapılamadı.");
            return false;
        }
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        } else {
            return null;
        }
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}


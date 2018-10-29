package com.company;

public class ContactsManager {

    //fields
    Contact [] myFriends;
    int friendsCount;

    //Constructor
    ContactsManager(){
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
    }


    //Methods..
    void addContact(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    Contact searchContact(String searchName){
        for(int i = 0; i<friendsCount; i++){
            if(myFriends[i].name.equals(searchName)){
                return myFriends[i];
            }
        }
        return null;
    }

}

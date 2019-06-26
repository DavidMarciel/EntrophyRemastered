package com.example.marciel.entrophy.EntrophyClasses;

import java.util.ArrayList;

/**It stores the user clicks information, it is all the information the server would need
 *
 */
public class UserInput {

    ArrayList<UserClick> userClick;

    public UserInput() {
        this.userClick = new ArrayList<>();
    }

    public void addUserClick(UserClick userClick){
        this.userClick.add(userClick);
    }
}

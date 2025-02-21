package org.app.dicegame.Classes;

import java.util.Objects;

public class User {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private int bestScore;



    public User(String name, String lastName, String email,String password, int bestScore) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.bestScore = bestScore;
        this.email = email;
    }

    public User(String email,String password) {
        this.email = email;
        this.password = password;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

}

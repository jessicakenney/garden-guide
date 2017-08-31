package models;

import java.util.List;

/**
 * Created by Guest on 8/30/17.
 */
public class Garden {
    private int id;
    private String userName;
    private String gardenName;

    public Garden (String userName, String gardenName) {
        this.userName=userName;
        this.gardenName=gardenName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGardenName() {
        return gardenName;
    }

    public void setGardenName(String gardenName) {
        this.gardenName = gardenName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Garden garden = (Garden) o;

        if (id != garden.id) return false;
        if (!userName.equals(garden.userName)) return false;
        return gardenName.equals(garden.gardenName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userName.hashCode();
        result = 31 * result + gardenName.hashCode();
        return result;
    }
}


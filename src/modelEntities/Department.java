package modelEntities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable{
                                    //implementação so serializable para trafego em rede, e para conversão em bits

    private Integer ID;
    private String name;

    
    public Department() {
    }

    public Department(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }


    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Department)) {
            return false;
        }
        Department department = (Department) o;
        return Objects.equals(ID, department.ID);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
        return result;
    }




    @Override
    public String toString() {
        return "{" +
            " ID='" + getID() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}

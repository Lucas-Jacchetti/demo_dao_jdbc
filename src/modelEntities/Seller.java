package modelEntities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable{
    
    private Integer ID;
    private String name;
    private String email;
    private Date birthdate;
    private Double baseSalary;

    private Department department; //o seller tem um departamento
                                   //portanto  deve haevr uma ligação entre os objetos

    public Seller(){

    }   

    public Seller(Integer ID, String name, String email, Date birthdate, Double baseSalary, Department department) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.baseSalary = baseSalary;
        this.department = department;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Seller)) {
            return false;
        }
        Seller seller = (Seller) o;
        return Objects.equals(ID, seller.ID);
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
            ", email='" + getEmail() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", baseSalary='" + getBaseSalary() + "'" +
            ", department='" + getDepartment() + "'" +
            "}";
    }
    
}

package addressbook.model;

import java.util.Objects;

public class CustomerInfo {

    private int id;
    private String foreName, surname, address, contactNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    //Need to generate these for testing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInfo that = (CustomerInfo) o;
        return id == that.id &&
                Objects.equals(foreName, that.foreName) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(contactNumber, that.contactNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, foreName, surname, address, contactNumber);
    }
}

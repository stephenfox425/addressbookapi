package addressbook.model;

import java.util.Objects;

public class SanitisedCustomer {

    private int id;
    private String forename, surname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //need to override this for testing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanitisedCustomer that = (SanitisedCustomer) o;
        return id == that.id &&
                Objects.equals(forename, that.forename) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, forename, surname);
    }
}

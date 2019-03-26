package hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
// question 10:- Create a class Address for Author with instance variables streetNumber, location, State.

    private Integer streetNumber;
    private String location;
    private String State;

    public Address() {
    }

    public Address(Integer streetNumber, String location, String state) {
        this.streetNumber = streetNumber;
        this.location = location;
        State = state;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber=" + streetNumber +
                ", location='" + location + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}

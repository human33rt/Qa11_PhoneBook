package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
//@Builder

public class Contact {

    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;

    public Contact withName(String name) {
        this.name = name;
        return this;
    }

    public Contact withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact withEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact withAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

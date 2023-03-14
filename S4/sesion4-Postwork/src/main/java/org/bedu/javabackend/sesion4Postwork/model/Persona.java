package org.bedu.javabackend.sesion4Postwork.model;

public class Persona {
    private String name;
    private String phone;

    public Persona() {
    }

    public Persona(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Persona { \n" +
                "   nombre='" + name + '\'' + "\n" +
                "   telefono='" + phone + '\'' +
                "\n }";
    }
}

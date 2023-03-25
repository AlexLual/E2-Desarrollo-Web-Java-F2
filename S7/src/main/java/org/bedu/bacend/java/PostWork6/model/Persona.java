package org.bedu.bacend.java.PostWork6.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

    @NotBlank(message = "El nombre de la persona es un campo obligatorio.")
    private String nombre;

    @Pattern(regexp = "^(\\d{2,4}[- .]?){2}\\d{4}$", message = "El teléfono debe tener un formato de ##-####-####")
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nombre.equals(persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Persona o) {
        return this.nombre.compareTo(o.nombre);
    }
}

//La clase tiene dos variables miembro privadas: nombre y telefono, ambas de tipo String.
//La clase tiene dos constructores: uno sin argumentos y otro que toma un nombre y un telefono.
// También hay métodos get y set para acceder y modificar las variables miembro nombre y telefono.
//La clase tiene tres métodos anulados (override) de la clase Object. El método toString() devuelve una cadena
// que representa el objeto Persona, el método equals()
// se utiliza para comparar dos objetos Persona y el método hashCode() devuelve un código hash del objeto.
//La clase también implementa la interfaz Comparable, lo que significa que los objetos Persona pueden ser
// comparados y ordenados entre sí. La comparación se realiza en función del valor de nombre de cada objeto.

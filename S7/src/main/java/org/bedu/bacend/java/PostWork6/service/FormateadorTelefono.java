package org.bedu.bacend.java.PostWork6.service;

import org.springframework.stereotype.Service;

@Service
public class FormateadorTelefono {
    private static final String FORMATO_INICIAL_TELEFONO = "(\\d{2})(\\d{4})(\\d+)";
    private static final String FORMATO_FINAL_TELEFONO = "($1)-$2-$3";

    public String formatea(String telefono) {
        return String.valueOf(telefono).replaceFirst(FORMATO_INICIAL_TELEFONO, FORMATO_FINAL_TELEFONO);
    }
}


//Este es un código en Java que define una clase llamada FormateadorTelefono
// y un método llamado formatea. Esta clase es anotada con @Service, que es una clase utilizada
// para la inyección de dependencias de Spring.
//El método formatea acepta una cadena telefono como entrada y devuelve una nueva cadena
// que representa el número de teléfono con un formato específico. La clase tiene dos variables
// de cadena llamadas FORMATO_INICIAL_TELEFONO y FORMATO_FINAL_TELEFONO,
// que son patrones de expresiones regulares que se utilizan para buscar y reemplazar las partes
// del número de teléfono en un formato específico.
//En concreto, FORMATO_INICIAL_TELEFONO representa un número de teléfono en un formato de dos dígitos de área,
// seguido de cuatro dígitos del número y uno o más dígitos adicionales. FORMATO_FINAL_TELEFONO es una cadena
// de formato que usa el primer grupo de la expresión regular FORMATO_INICIAL_TELEFONO como los dos dígitos
// de área, el segundo grupo como los cuatro dígitos del número y el tercer grupo como los dígitos adicionales.
//El método formatea toma la cadena de entrada telefono y la convierte a una cadena utilizando el método
// valueOf de la clase String. Luego, usa el método replaceFirst de la cadena resultante para buscar
// el patrón FORMATO_INICIAL_TELEFONO en la cadena y reemplazarlo con la cadena de formato FORMATO_FINAL_TELEFONO.
// Esto dará como resultado una nueva cadena con el número de teléfono en el formato deseado.
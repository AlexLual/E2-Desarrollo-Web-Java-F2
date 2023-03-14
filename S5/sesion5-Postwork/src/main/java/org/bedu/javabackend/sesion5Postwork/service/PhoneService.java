package org.bedu.javabackend.sesion5Postwork.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PhoneService {

    private static final Pattern PATTERN_PHONE = Pattern.compile("^(\\d{2,4}[- .]?){2}\\d{4}$");

    public boolean isValido (String phone){
        return PATTERN_PHONE.matcher(phone).matches();
    }
    public String validarTelefono (String phone) throws IllegalAccessException {
        //Valida que el número de teléfono solo contenga caracteres válido: números
        if (!phone.matches("[0-9\\-\\s]+")) {
            throw new IllegalArgumentException("Número de teléfono no válido");
        }

        //Eliminar todos los caracteres que no sean numéricos
        String telefonoNumerico = phone.replaceAll("[^\\d]", "");

        //Valida que el número de teléfono contenga 10 dígitos
        if (telefonoNumerico.length() != 10) {
            throw new IllegalArgumentException("Número de teléfono no válido");
        }

        return telefonoNumerico;
    }
}

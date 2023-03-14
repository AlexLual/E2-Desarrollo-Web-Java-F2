package org.bedu.javabackend.sesion5Postwork.service;

import org.springframework.stereotype.Service;

@Service
public class FormatoService {

    public String darFormatoTelefonico(String phone) {
        //Da al número de teléfono un formato de (##)-####-####
        return String.format("(%s)-%s-%s", phone.substring(0, 2), phone.substring(2, 6), phone.substring(6, 10));
    }
}

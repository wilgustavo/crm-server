package com.crm.common.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8829334168411206102L;
    
    public NotFoundException(String mensaje) {
        super(mensaje);
    }

}

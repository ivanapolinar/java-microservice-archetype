package com.miempresa.servicio.api.model;

public class ApiResponse<T> {

    private T data;
    private Meta meta;

    public ApiResponse(T data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }
}

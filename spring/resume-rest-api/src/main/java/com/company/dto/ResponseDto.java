package com.company.dto;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter
@Setter
public class ResponseDto {

    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object obj;

    private ResponseDto() {
    }

    public static ResponseDto of(Object obj) {
        ResponseDto resp = new ResponseDto();
        resp.setObj(obj);
        return resp;
    }

    public static ResponseDto of(String errorMessage) {
        ResponseDto resp = new ResponseDto();
        resp.setErrorMessage(errorMessage);
        return resp;
    }

    public static ResponseDto of(Object obj, String successMessage) {
        ResponseDto resp = new ResponseDto();
        resp.setObj(obj);
        resp.setSuccessMessage(successMessage);
        return resp;
    }

    public static ResponseDto of(Object obj, Integer errorCode, String errorMessage) {
        ResponseDto resp = new ResponseDto();
        resp.setObj(obj);
        resp.setErrorCode(errorCode);
        resp.setErrorMessage(errorMessage);
        return resp;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", successMessage='" + successMessage + '\'' +
                ", obj=" + obj +
                '}';
    }

}
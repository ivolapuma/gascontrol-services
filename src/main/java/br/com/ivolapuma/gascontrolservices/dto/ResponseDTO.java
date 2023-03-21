package br.com.ivolapuma.gascontrolservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ResponseDTO<T> {

    private String message;
    private T object;

}

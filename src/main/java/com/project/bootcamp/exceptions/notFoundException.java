package com.project.bootcamp.exceptions;

import com.project.bootcamp.util.MessageUtil;

public class notFoundException extends RuntimeException{
    public notFoundException (){
        super(MessageUtil.NO_RECORDS_FOUND);

    }
}

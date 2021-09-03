package com.brad.minionizer.web;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.messaging.handler.annotation.MessageMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @MessageMapping("my_request")
    public String requestResponse(String something){
        System.out.println(something);
        return "Hello World";
    }
}

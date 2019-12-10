package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }
    // /lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "GoodBye, Spring!";
    }
    // /hello/hello
    //handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @PostMapping("hello")
//    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST},value = "hello")
    // /hello/hello
    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST},value = "hello")
    public String helloWithQueryParam(@RequestParam String name){

        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
//    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, "+ name +"!";
    }

    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST},value = "language")
    public String createMessage(@RequestParam String name, @RequestParam String language){
        if(language.equals("French")){
            return "Bonjour " + name;
        }else if(language.equals("English")){
            return "Hello " + name;
        }else if(language.equals("Spanish")){
            return "Hola "+ name;
        }else if(language.equals("Italian")){
            return "Ciao "+ name;
        }
            return "Namaste " + name;

    }
    // /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form method='post' action='language'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='french'> French </option>" +
                "<option value='English'> English </option>" +
                "<option value='hindi'> Hindi </option>" +
                "<option value='spanish'> Spanish </option>" +
                "<option value='italian'> Italian </option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}

package in.thilak.spring_restful_webservice.helloworld.controller;

import java.util.Locale;

import org.jboss.logging.Messages;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.thilak.spring_restful_webservice.helloworld.dao.HelloWorldBean;

@RestController
public class HelloWorldController {


    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello, World!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean/{name}/{id}")
    public HelloWorldBean helloWorldBean(@PathVariable String name,@PathVariable int id, 
    @RequestParam(value = "age", defaultValue = "0", required = true) int age) { 
    //@QueryParam(value = "city", defaultValue = "defaultCity") String city,) {
         System.out.println("age is : "+age);
        return new HelloWorldBean(name, id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-i18n")
    public String helloWorldi18() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}

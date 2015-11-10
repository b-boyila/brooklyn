package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ktagintsev on 30.10.15.
 */
@Controller
public class AuthorizationController {

    @RequestMapping(value = "/brooklyn**", method = RequestMethod.GET)
    public ModelAndView brooklynPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("brooklyn");

        return model;

    }

    @RequestMapping(value = "/emailDelivery**", method = RequestMethod.GET)
    public ModelAndView emailPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("email");

        return model;

    }

    @RequestMapping(value = "/smsDelivery**", method = RequestMethod.GET)
    public ModelAndView smsPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("sms");

        return model;

    }

    @RequestMapping(value = { "/", "/login**" }, method = RequestMethod.GET)
    public ModelAndView login(
             @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error","<div style=\"padding: 15px;margin-bottom: 20px;border: 1px solid transparent;border-radius: 4px;color: #a94442;background-color: #f2dede;border-color: #ebccd1;\">Неправильный логин или пароль!</div>");
        }

        model.setViewName("login");

        return model;

    }

}
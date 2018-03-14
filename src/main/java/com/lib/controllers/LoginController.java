package com.lib.controllers;

import com.lib.model.dao.interfaces.BookDAO;
import com.lib.model.pojo.User;
import com.lib.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@SessionAttributes("username")
public class LoginController {
    private static Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    private final UserService userService;
    private final BookDAO bookDAO;

    @Autowired
    public LoginController(UserService userService, BookDAO bookDAO) {
        this.userService = userService;
        this.bookDAO = bookDAO;

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    protected ModelAndView login(@ModelAttribute User user, ModelMap model) {
        LOGGER.info("Logging in");
        System.out.println("LOGGING");

        try {
            boolean isLogined = userService.authenticate(user.getName(), user.getPassword());

            if(isLogined){
                model.addAttribute("username", user.getName());
                return new ModelAndView("redirect:/getuserbooks", model);
            }
        }
        catch (Exception e) {

        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected ModelAndView logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        LOGGER.info("User has logged out");

        return new ModelAndView("redirect:/index.jsp");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    protected ModelAndView register(@ModelAttribute("newusername") String name,@ModelAttribute("password") String password, ModelMap model) {
        LOGGER.info("Registration");
        System.out.println("NAME AND PSW:" + name + password);

        try {
            boolean isRegistered = userService.register(name, password);

            if (isRegistered) {
                model.addAttribute("username", name);
                return new ModelAndView("redirect:/getuserbooks", model);
            }
        }
        catch (Exception e){
            LOGGER.warning("Error registering user: " + e.getMessage());
        }
        return new ModelAndView("redirect:/");
    }
}

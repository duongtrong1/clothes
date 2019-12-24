package com.smartosc.ecommerce.clothes.controller;

import com.smartosc.ecommerce.clothes.model.Role;
import com.smartosc.ecommerce.clothes.model.User;
import com.smartosc.ecommerce.clothes.model.UserRole;
import com.smartosc.ecommerce.clothes.service.UserService;
import com.smartosc.ecommerce.clothes.util.MailConstructor;
import com.smartosc.ecommerce.clothes.util.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private MailConstructor mailConstructor;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String newUserPost(HttpServletRequest request, @ModelAttribute("email") String userEmail, @ModelAttribute("username") String username, Model model) throws Exception {
        model.addAttribute ("classActiveNewAccount", true);
        model.addAttribute ("email", userEmail);
        model.addAttribute ("username", username);

        if (userService.findByUsername (username) != null) {
            model.addAttribute ("usernameExists", true);
            return "myAccount";
        }

        if (userService.findByEmail (userEmail) != null) {
            model.addAttribute ("emailExists", true);
            return "myAccount";
        }
        User user = new User ();
        user.setUsername (username);
        user.setEmail (userEmail);

        String password = SecurityUtility.randomPassword ();

        String encryptedPassword = SecurityUtility.passwordEncoder ().encode (password);
        user.setPassword (encryptedPassword);

        Role role = new Role ();
        role.setRoleId (1);
        role.setName ("ROLE_USER");
        Set<UserRole> userRoles = new HashSet<> ();
        userRoles.add (new UserRole (user, role));
        userService.createUser (user, userRoles);

        String token = UUID.randomUUID ().toString ();
        userService.createPasswordResetTokenForUser (user, token);

        String appUrl = "http://" + request.getServerName () + ":" + request.getServerPort () + request.getContextPath ();

        SimpleMailMessage email = mailConstructor.constructResetTokenEmail (appUrl, request.getLocale (), token, user, password);

        mailSender.send (email);

        model.addAttribute ("emailSent", "true");
        model.addAttribute ("orderList", user.getOrderList ());

        return "myAccount";
    }
}

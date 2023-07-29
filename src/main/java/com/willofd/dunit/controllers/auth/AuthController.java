package com.willofd.dunit.controllers.auth;

import com.willofd.dunit.config.AuthenticationCreator;
import com.willofd.dunit.entity.SimpleUser;
import com.willofd.dunit.services.impl.SimpleUserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Ivan Partola
 */

@Controller
@RequestMapping("auth")
public class AuthController {
    private final SimpleUserServiceImpl simpleUserService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationCreator auth;

    @Autowired
    public AuthController(SimpleUserServiceImpl simpleUserService, PasswordEncoder passwordEncoder, AuthenticationCreator auth) {
        this.simpleUserService = simpleUserService;
        this.passwordEncoder = passwordEncoder;
        this.auth = auth;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(new SimpleUser());
        return "auth/register";
    }

    @PostMapping("/register")
    public String newUser(@ModelAttribute SimpleUser simpleUser,
                           RedirectAttributes redirectAttributes) {
        if (simpleUserService.findUserByEmail(simpleUser.getEmail()).isPresent()) {
            redirectAttributes.addFlashAttribute("failure", "A user with this username or email already exists");
            return "auth/register";
        }

        simpleUser.setPassword(passwordEncoder.encode(simpleUser.getPassword()));
        simpleUserService.save(simpleUser);
        return "redirect:/auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/auth/login";
    }

}


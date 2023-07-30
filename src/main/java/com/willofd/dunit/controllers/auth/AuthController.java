package com.willofd.dunit.controllers.auth;

import com.willofd.dunit.entities.SimpleUser;
import com.willofd.dunit.services.AuthService;
import com.willofd.dunit.services.SimpleUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Ivan Partola
 */

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final SimpleUserService simpleUserService;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return authService.redirectIfLogged("redirect:/", "auth/login");
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(new SimpleUser());
        return authService.redirectIfLogged("redirect:/", "auth/register");
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


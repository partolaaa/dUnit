package com.willofd.dunit.controllers.general;

import com.willofd.dunit.services.AuthService;
import com.willofd.dunit.services.SimpleUserService;
import com.willofd.dunit.util.mappers.SimpleUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Ivan Partola
 */
@Controller
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;
    private final SimpleUserService simpleUserService;
    private final SimpleUserMapper simpleUserMapper;
    @GetMapping({"", "/"})
    public String mainPage(Model model) {
        String resultPage = authService.redirectIfLogged("global/marketplace", "global/welcome");
        if (resultPage.contains("marketplace")) {
            model.addAttribute("headerUserInfo", simpleUserMapper.simpleUserToHeaderDTO(simpleUserService.getCurrentUserFromSession().get()));
        }
        return resultPage;
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username,
                          Model model) {
        model.addAttribute("headerUserInfo", simpleUserMapper.simpleUserToHeaderDTO(simpleUserService.getCurrentUserFromSession().get()));
        model.addAttribute("user", simpleUserService.findUserByUsername(username).get());
        return "user/profile";
    }

    @GetMapping("/my-listings")
    public String listings(Model model) {
        model.addAttribute("headerUserInfo", simpleUserMapper.simpleUserToHeaderDTO(simpleUserService.getCurrentUserFromSession().get()));
        return "user/listings";
    }
}

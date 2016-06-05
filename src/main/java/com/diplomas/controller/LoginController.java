package com.diplomas.controller;

import com.diplomas.entity.User;
import com.diplomas.entity.UserRole;
import com.diplomas.repository.UserRepository;
import com.diplomas.repository.UserRolesRepository;
import com.diplomas.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") UserDTO dto, RedirectAttributes redirectAttributes) {
        if (!validEmail(dto)) {
            redirectAttributes.addAttribute("errorMessage", "Юзер з таким email вже є");
            return "redirect:/registration";
        }
        if (!validUserName(dto)) {
            redirectAttributes.addAttribute("errorMessage", "Юзер з таким ім'ям вже є");
            return "redirect:/registration";
        }
        if (!validPassword(dto)) {
            redirectAttributes.addAttribute("errorMessage", "Паролі не співпадають");
            return "redirect:/registration";
        }
        saveUser(dto);
        return "redirect:/login";
    }

    private void saveUser(UserDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setEnabled(1);
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        userRepository.save(user);
        UserRole role = new UserRole();
        role.setUserid(user.getUserid());
        role.setRole("ROLE_USER");
        userRolesRepository.save(role);
    }

    private boolean validPassword(UserDTO dto) {
        if (dto.getPassword().equals(dto.getRepeatPassword())) {
            return true;
        }
        return false;
    }

    private boolean validUserName(UserDTO dto) {
        User user = userRepository.findByUserName(dto.getUserName());
        if (user == null) {
            return true;
        }
        return false;
    }

    private boolean validEmail(UserDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            return true;
        }
        return false;
    }
}

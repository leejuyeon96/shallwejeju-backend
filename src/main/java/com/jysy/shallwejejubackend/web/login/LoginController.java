package com.jysy.shallwejejubackend.web.login;

import com.jysy.shallwejejubackend.domain.myUser.repository.MyUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping ("/api/Login")
    public String login(@RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            // 인증 성공 시 처리
            if (authentication.isAuthenticated()) {
                request.getSession().setAttribute("user", authentication.getPrincipal());
                //SecurityContext 객체를 세션에 담는 코드
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                context.setAuthentication(authentication);
                HttpSessionSecurityContextRepository repository = new HttpSessionSecurityContextRepository();
                repository.saveContext(context, request, response);
                return "Login successful";
            }
        } catch (AuthenticationException e) {
            // 인증 실패 시 처리
            return "Login failed: " + e.getMessage();
        }
        return "Login failed";
    }

//    @PostConstruct
//    void a() {
//        MyUser u = new MyUser();
//        u.setUserName("qwer");
//        u.setPwd(passwordEncoder.encode("0000"));
//        myUserRepository.save(u);
//    }
}

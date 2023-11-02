package com.ukream.aop;

import javax.servlet.http.HttpSession;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ukream.annotation.LoginCheck;
import com.ukream.error.exception.AuthenticationRequiredException;
import com.ukream.util.SessionUtil;

@Aspect
@Component
public class LoginCheckAspect {
    @Around("@annotation(com.ukream.annotation.LoginCheck) && @ annotation(loginCheck)")
    public void loginCheck(LoginCheck loginCheck) throws Throwable {
        HttpSession session =
        ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest()
            .getSession();
        
        Long id = 0L;
        String userType = loginCheck.type().toString();
        
        switch (userType) {
            case "ADMIN": {
                id = SessionUtil.getLoginAdminId(session);
                break;
            }
            case "USER": {
                id = SessionUtil.getLoginUserId(session);
                break;
            }
        }

        
        if (id == 0L) {
            throw new AuthenticationRequiredException("로그인을 해주세요.");
        }

    }

}
package com.junlon.web.portal.controller;

import com.junlon.facade.user.service.AdminQueryFacade;
import com.junlon.web.portal.base.BaseController;
import com.junlon.web.portal.base.BaseLogonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/28
 */

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

    @Autowired
    private AdminQueryFacade adminQueryFacade;

    @RequestMapping("/loginUI")
    public String loginUI(){
        return "loginUI";
    }
}

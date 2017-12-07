package com.junlon.web.portal.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/4
 */

@Component
public class BaseController extends HttpServlet {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    private static final String UTF_8 = "utf-8";

    private static final String GBK = "GBK";

    private static ThreadLocal<Map<String, Object>> outPutMsg = new ThreadLocal<Map<String, Object>>();

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    private Integer numPerPage;

    private Integer pageNum;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){

        this.request = request;

        this.response = response;

        this.session = request.getSession();

    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public static ThreadLocal<Map<String, Object>> getOutPutMsg() {
        return outPutMsg;
    }

    public static void setOutPutMsg(ThreadLocal<Map<String, Object>> outPutMsg) {
        BaseController.outPutMsg = outPutMsg;
    }

    public static Logger getLogger() {
        return logger;
    }

    public Integer getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(Integer numPerPage) {
        this.numPerPage = numPerPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}

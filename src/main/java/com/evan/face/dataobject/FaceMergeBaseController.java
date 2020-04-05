package com.evan.face.dataobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Evan
 * @Description: 封装人脸融合业务逻辑中需要用到的一些参数
 * @Date: Created in 22:23 2018/6/2
 * @Modified By:
 */


public class FaceMergeBaseController {
    /**
     *保存session
     */

   public Map session;
    /**
     * 用户的openId
     */

    public String openId;
    /**
     * 错误信息
     */
    public String errMsg;
    /**
     * json格式参数
     */
    public String jsonParam;

    public String callback;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    /**
     * 每次请求都会带上
     * @param jsonParam
     * @param callback
     * @param openId
     */
    //标注在方法上的@ModelAttribute说明方法是用于添加一个或多个属性到model上。
    // 这样的方法能接受与@RequestMapping标注相同的参数类型，只不过不能直接被映射到具体的请求上。
    @ModelAttribute
    public void setReqAndRes(Map session, String openId, String errMsg,
                             String jsonParam, String callback, HttpServletRequest request,
                             HttpServletResponse response) {
        this.session = session;
        this.openId = openId;
        this.errMsg = errMsg;
        this.jsonParam = jsonParam;
        this.callback = callback;
        this.request = request;
        this.response = response;
    }
    public Map getSession() {
        return session;
    }
    public void setSession(Map session) {
        this.session = session;
    }
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getErrMsg() {
        return errMsg;
    }
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public String getJsonParam() {
        return jsonParam;
    }
    public void setJsonParam(String jsonParam) {
        this.jsonParam = jsonParam;
    }
    public String getCallback() {
        return callback;
    }
    public void setCallback(String callback) {
        this.callback = callback;
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

    public String getRealPath(String path) {
        return request.getSession().getServletContext().getRealPath(path);

    }
}

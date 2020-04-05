package com.evan.face.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @Author: Evan
 * @Description: 响应类
 * @Date: Created in 22:43 2018/6/2
 * @Modified By:
 */


public class PrintUtil {
    public static void printXml(HttpServletResponse response,String result){
        try {
            response.setContentType("text/xml; charset=UTF-8");
            PrintWriter sos = response.getWriter();
            sos.write(result);
            sos.flush();
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 采用json 或 jsonp
     * @param callback
     * @param response
     * @param result
     */
    public static void printJson(String callback,HttpServletResponse response,String result){
        boolean jsonP = false;
        if (callback != null) {
            jsonP = true;
            response.setContentType("text/javascript;charset=utf-8");
        } else {
            response.setContentType("application/x-json;charset=utf-8");
        }

        try {
            Writer out = response.getWriter();
            if (jsonP) {
                out.write(callback + "(");
            }
            out.write(result.toString());
            if (jsonP) {
                out.write(");");
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static void printJson(HttpServletResponse response, String result){
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter sos = response.getWriter();
            sos.write(result);
            sos.flush();
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

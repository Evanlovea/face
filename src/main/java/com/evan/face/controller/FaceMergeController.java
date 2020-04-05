package com.evan.face.controller;

/**
 * @Author: Evan
 * @Description: 人脸融合业务逻辑实现
 * @Date: Created in 22:40 2018/6/2
 * @Modified By:
 */


import cn.xsshome.taip.ptu.TAipPtu;
import com.evan.face.constant.AIConstant;
import com.evan.face.dataobject.FaceMergeBaseController;
import com.evan.face.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.management.snmp.util.MibLogger;

import java.util.Iterator;
import java.util.logging.Logger;

/**
 * 人脸融合接口
 * url:localhost:8080/face/facemerge/uploadFM
 */
@Slf4j

@Controller
@RequestMapping(value="/face_merge")
@Scope("prototype")
public class FaceMergeController extends FaceMergeBaseController{

    /**
     * 人脸融合
     * @throws Exception
     */
    @RequestMapping(value="/uploadFM",method= RequestMethod.POST)
    /**
     * 对用户上传的图片进行处理
     */
    public void UploadBDANIMAL()throws Exception{
        TAipPtu aipPtu = new TAipPtu(AIConstant.QQ_AI_APPID,
                AIConstant.QQ_AI_APPKEY);
        String model = request.getParameter("model");

        log.info("model的值是===="+model);

        String result = "";
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest)this.request;
        Iterator iterator = mpRequest.getFileNames();
        log.info(iterator.toString());
        MultipartFile file = null;
        while (iterator.hasNext()) {
            file = mpRequest.getFile((String)iterator.next());
            /**
             * 如果上传的file不为空且size不为0
             * 进行人脸融合操作
             */
            if ((file != null) && (file.getSize() != 0L)){
                log.info("image不为空");
                byte[] image = file.getBytes();
                log.debug("image",image);
                /**
                 * 人脸融合结果
                 */
                String apiPtuResult = aipPtu.faceMerge(image,Integer.parseInt(model));
                log.info(apiPtuResult);
                /**
                 * 将返回的数据转换为json格式进行返回
                 */
                PrintUtil.printJson(this.response, apiPtuResult);
            } else {
                log.error("请检查上传文件是否正确");
                result = "{\"result\", \"FAIL\",\"msg\":\"服务器出现了一些问题\"}";
                PrintUtil.printJson(this.response, result);
            }
        }
    }
}

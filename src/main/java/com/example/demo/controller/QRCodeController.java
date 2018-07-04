package com.example.demo.controller;

import com.example.demo.utils.QRCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author qiumeng
 * @Package com.example.demo.controller
 * @Description:
 * @date 2018 2018/7/4 10:17
 */
@Controller
public class QRCodeController {

    /**
     * 获取二维码
     * text 必须用UTF8编码格式，x内容出现 & 符号时，请用 %26 代替,换行符使用 %0A
     */
    @RequestMapping("/qrcode_image.htm")
    public void qrcode_image(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value="text", defaultValue="")String text) throws IOException {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        BufferedImage image = QRCodeUtil.QRCodeCreate(text, 250, 250);

        ImageIO.write(image, "png",response.getOutputStream());
    }

}

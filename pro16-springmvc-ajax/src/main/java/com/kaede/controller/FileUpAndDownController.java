package com.kaede.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author kaede
 * @create 2022-07-29 15:36
 *
 * ResponseEntity：可以作为控制器方法的返回值，可以表示响应到浏览器的完整的响应报文
 *
 * 文件上传的要求：
 *      1）form表单的请求必须为post
 *      2）form表单必须设置属性enctype="multipart/form-data"
 */

/**
 * String realPath = servletContext.getRealPath("");
 * System.out.println(realPath);
 * D:\Code\SSM\pro16-springmvc-ajax\target\pro16-springmvc-ajax-1.0-SNAPSHOT\

 * String realPath = servletContext.getRealPath("/static/img");
 * realPath = realPath + File.separator + "名为希望的绝望.png";
 * D:\Code\SSM\pro16-springmvc-ajax\target\pro16-springmvc-ajax-1.0-SNAPSHOT\static\img\名为希望的绝望.png
 *
 * String realPath = servletContext.getRealPath("static/img");
 * realPath = realPath + File.separator + "名为希望的绝望.png";
 * D:\Code\SSM\pro16-springmvc-ajax\target\pro16-springmvc-ajax-1.0-SNAPSHOT\static\img\名为希望的绝望.png
 */

@Controller
public class FileUpAndDownController {
    @RequestMapping("/test/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("static/img");
        realPath = realPath + File.separator + "名为希望的绝望.png";
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组，is.available()获取输入流对应文件的字节数
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        //直接这样中文文件名会产生乱码，需要如下操作
        //headers.add("Content-Disposition", "attachment;filename=名为希望的绝望.png");
        headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode("名为希望的绝望.png","UTF-8"));
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/test/up")
    public String testUp(MultipartFile upFile, HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String fileName = upFile.getOriginalFilename();
        //获取上传的文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取UUID
        String uuid = UUID.randomUUID().toString();
        //拼接一个新的文件名，防止上传的文件重名（若同名，内容会被新的文件覆盖）
        fileName = uuid + suffixName;
        /**
         * 感觉上传时可以用uuid + 原文件名
         * 每个用户分别维护一个目录，目录名为用户id，用户自己的文件上传到自己的目录
         * 当需要展示给用户的时候，先把固定长度uuid前缀去掉，再直接展示或者通过后缀搜索展示给用户
         * 服务器内文件重名不行，展示给用户时可以文件重名
         */
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取当前工程下upFile目录的真实路径
        String upFilePath = servletContext.getRealPath("upFile");
        //创建upFilePath所对应的File对象
        File file = new File(upFilePath);
        //判断file所对应目录是否存在
        if(!file.exists()) {
            file.mkdir();
        }
        String finalPath = upFilePath + File.separator + fileName;
        //上传文件
        upFile.transferTo(new File(finalPath));
        return "success";
    }

}

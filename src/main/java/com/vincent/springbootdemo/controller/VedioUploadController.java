package com.vincent.springbootdemo.controller;

import com.vincent.springbootdemo.entity.SysUserInfo;
import com.vincent.springbootdemo.entity.VedioInfo;
import com.vincent.springbootdemo.service.VedioInfoService;
import com.vincent.springbootdemo.utils.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class VedioUploadController extends BaseController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private VedioInfoService vedioInfoService;

    @PostMapping(value = {"/fileupload"})
    public String fileupload(@RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes, MultipartHttpServletRequest request) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "文件为空! 请选择非空文件上传！");
            return "redirect:/uploadStatus";
        }
        try {
            // 获取文件并保存到指定文件夹中
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            String serverPath = request.getServletContext().getRealPath("");
            Path path = Paths.get(serverPath + filename);

            System.out.println("=========path:" + path);
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "您已成功上传 '" + filename + "', 该文件大小约为 " + bytes.length / 1024 + " KB.");

            SysUserInfo userinfo = (SysUserInfo) request.getSession().getAttribute("userinfo");
            VedioInfo info = new VedioInfo();
            //vedio_url,vedio_status,vedio_type,vedio_title,author_id,author_idea,main_image,create_time,update_time,user_good_thumbs,
            info.setVedioUrl(filename);
            info.setVedioTitle(filename.substring(0,filename.lastIndexOf(".")));
            info.setVedioType(1);
            info.setVedioStatus(1);
            info.setAuthorId(123);
            info.setAuthorIdea(userinfo.getUsername());
            info.setCreateTime(DateHelper.getCurrTimestamp());
            vedioInfoService.saveVedioInfo(info);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }
    /*
    ** 文件上传信息处理页面
     */
    @GetMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }

    @RequestMapping("/vedio")
    public String vedio() {
        return VIEW_VEDIO_PLAY;
    }

}

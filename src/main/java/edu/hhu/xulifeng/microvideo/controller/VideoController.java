package edu.hhu.xulifeng.microvideo.controller;

import edu.hhu.xulifeng.microvideo.pojo.Video;
import edu.hhu.xulifeng.microvideo.service.impl.VideoServiceImpl;
import edu.hhu.xulifeng.microvideo.util.ResponseResult;
import edu.hhu.xulifeng.microvideo.util.StringToDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author xulifeng
 * @since 2022-10-25
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoServiceImpl videoService;

    @Autowired
    Video video;

    @GetMapping("/videos")
    @ResponseBody
    public ResponseResult getAllVideos() {
        List<Video> result = videoService.getAllVideos();
        return ResponseResult.success("200", "success", result);
    }

    @GetMapping("/addPage")
    public String loadAddVideoPage() {
        return "admin/video/add";
    }

    @PostMapping("/addVideo")
    @ResponseBody
    public void addVideo(HttpServletResponse response,@RequestParam("videoPath") MultipartFile videoPath, @RequestParam("coverPath") MultipartFile coverPath, @RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("type") String type, @RequestParam("createTime") String createTime, @RequestParam("timeLength") String timeLength, @RequestParam("description") String description) throws Exception {
        //获取根目录
        String staticPath = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(staticPath);
        String videoUploadPath = "A:\\microVideo\\src\\main\\resources\\static\\video_upload" + File.separator + name + ".mp4";
        String coverUploadPath = "A:\\microVideo\\src\\main\\resources\\static\\cover_upload" + File.separator + name + ".png";
        File videoFile = new File(videoUploadPath);
        File coverFile = new File(coverUploadPath);

        video.setName(name);
        video.setAuthor(author);
        video.setType(type);
        video.setCreateTime(StringToDate.stringToDateTime(createTime));
        video.setTimeLength(Integer.parseInt(timeLength));
        video.setDescription(description);
        video.setVideoPath(videoUploadPath);
        video.setCoverPath(coverUploadPath);
        videoService.addVideo(video);
        // 操作媒体类型
        if (!videoFile.exists() || !coverFile.exists()) {
            videoFile.mkdirs();
            coverFile.mkdirs();
        }
        videoPath.transferTo(videoFile);
        coverPath.transferTo(coverFile);
        try {
            response.sendRedirect("http://localhost:8080/admin/adminIndexPage");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/addVideoProduction")
    @ResponseBody
    public ResponseResult addVideoProduction(@RequestParam("videoPath") MultipartFile videoPath, @RequestParam("coverPath") MultipartFile coverPath, @RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("type") String type, @RequestParam("createTime") String createTime, @RequestParam("timeLength") String timeLength, @RequestParam("description") String description) throws Exception {
        //获取根目录
        String staticPath = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(staticPath);
        String videoUploadPath = staticPath + "static\\video_upload\\" + File.separator + name + ".mp4";
        String coverUploadPath = staticPath + "static\\cover_upload\\" + File.separator + name + ".png";
        File videoFile = new File(videoUploadPath);
        File coverFile = new File(coverUploadPath);

        video.setName(name);
        video.setAuthor(author);
        video.setType(type);
        video.setCreateTime(StringToDate.stringToDateTime(createTime));
        video.setTimeLength(Integer.parseInt(timeLength));
        video.setDescription(description);
        video.setVideoPath(videoUploadPath);
        video.setCoverPath(coverUploadPath);
        videoService.addVideo(video);
        // 操作媒体类型
        if (!videoFile.exists() || !coverFile.exists()) {
            videoFile.mkdirs();
            coverFile.mkdirs();
        }
        videoPath.transferTo(videoFile);
        coverPath.transferTo(coverFile);
        return ResponseResult.success();
    }


}

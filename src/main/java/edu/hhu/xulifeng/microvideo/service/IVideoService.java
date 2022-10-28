package edu.hhu.xulifeng.microvideo.service;

import edu.hhu.xulifeng.microvideo.pojo.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.hhu.xulifeng.microvideo.util.ResponseResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-25
 */
public interface IVideoService extends IService<Video> {

    List<Video> getAllVideos();

    int addVideo(Video video);

    int deleteVideo(Integer id);

    List<Video> selectVideoByName(String videoName);
}

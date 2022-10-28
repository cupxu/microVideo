package edu.hhu.xulifeng.microvideo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.hhu.xulifeng.microvideo.pojo.Video;
import edu.hhu.xulifeng.microvideo.mapper.VideoMapper;
import edu.hhu.xulifeng.microvideo.service.IVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hhu.xulifeng.microvideo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-25
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Autowired
    VideoMapper mapper;

    @Override
    public List<Video> getAllVideos() {
        List<Video> result = mapper.selectList(null);
        return result;
    }


    @Override
    public int addVideo(Video video) {
       return mapper.insert(video);
    }

    @Override
    public int deleteVideo(Integer id) {
        return mapper.deleteById(id);
    }

    @Override
    public List<Video> selectVideoByName(String videoName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", videoName);
        return mapper.selectList(wrapper);
    }
}

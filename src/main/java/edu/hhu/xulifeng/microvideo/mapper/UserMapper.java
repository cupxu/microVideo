package edu.hhu.xulifeng.microvideo.mapper;

import edu.hhu.xulifeng.microvideo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 普通用户表 Mapper 接口
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-24
 */
@Component
public interface UserMapper extends BaseMapper<User> {

}

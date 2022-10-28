package edu.hhu.xulifeng.microvideo.service;

import edu.hhu.xulifeng.microvideo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 普通用户表 服务类
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-24
 */
public interface IUserService extends IService<User> {

    int userRegister(User user);

    boolean isExists(String account, String password);

    List<User> selectAllUsers();

    int deleteById(String id);

    User selectByAccount(String account);
}

package edu.hhu.xulifeng.microvideo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.hhu.xulifeng.microvideo.pojo.User;
import edu.hhu.xulifeng.microvideo.mapper.UserMapper;
import edu.hhu.xulifeng.microvideo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 普通用户表 服务实现类
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int userRegister(User user){
        return userMapper.insert(user);
    }

    @Override
    public boolean isExists(String account, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("account",account);
        wrapper.eq("password",password);
        if ( userMapper.selectOne(wrapper) != null){
            return true;
        }
        return false;
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public User selectByAccount(String account) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("account", account);
        return userMapper.selectOne(wrapper);
    }
}

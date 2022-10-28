package edu.hhu.xulifeng.microvideo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.hhu.xulifeng.microvideo.pojo.Admin;
import edu.hhu.xulifeng.microvideo.mapper.AdminMapper;
import edu.hhu.xulifeng.microvideo.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-24
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public boolean isExists(String account, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("account", account);
        wrapper.eq("password", password);
        return adminMapper.selectOne(wrapper) == null ? false : true;
    }
}

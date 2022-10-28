package edu.hhu.xulifeng.microvideo.service;

import edu.hhu.xulifeng.microvideo.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-24
 */
public interface IAdminService extends IService<Admin> {
    boolean isExists(String account, String password);
}

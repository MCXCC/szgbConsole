package org.szgb.console.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.szgb.console.sys.user.entity.SysUser;
import org.szgb.console.sys.user.mapper.SysUserMapper;
import org.szgb.core.utils.SpringContextUtil;

import java.util.List;

@Slf4j
@Component
public class UserUtil {

    static SysUserMapper sysUserMapper = SpringContextUtil.getBean(SysUserMapper.class);

    public static List<SysUser> getUsersByIds(String ids, String separator) {
        if (ids == null || ids.isEmpty()) {
            return null;
        }
        String[] split = ids.split(separator);
        return sysUserMapper.getByIdList(split);
    }

    public static String getIdsByUsers(List<SysUser> users, String separator) {
        StringBuffer sb = new StringBuffer();
        users.forEach(user -> {
            sb.append(user.getId()).append(separator);
        });
        return sb.toString();
    }
}

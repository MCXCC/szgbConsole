package org.example.clztoolsconsole.sys.user.service;

import lombok.extern.slf4j.Slf4j;
import org.example.clztoolsconsole.sys.user.entity.SysUser;
import org.example.clztoolsconsole.sys.user.mapper.SysUserMapper;
import org.example.clztoolsconsole.utils.Page;
import org.example.clztoolsconsole.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SysUserService {
    private final SysUserMapper sysUserMapper;

    @Autowired
    public SysUserService(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    public List<SysUser> findList(SysUser user) {
        List<SysUser> list = sysUserMapper.findList(user);
        log.info("findList:{}", list);
        return list;
    }

    public Page getCount() {
        Page page = new Page();
        page.setCount(sysUserMapper.getCount());
        return page;
    }

    public SysUser getToken(SysUser user) {
        String token = user.getToken();
        if (token != null) {
            // 已登录，放行
            SysUser sysUser = new SysUser();
            sysUser.setId(TokenUtils.getUid(token));
            sysUser = sysUserMapper.findById(sysUser);
            sysUser.setToken(token);
            return sysUser;
        }
        SysUser sysUser = sysUserMapper.getOfLogin(user);
        if (sysUser == null) {
            return null;
        } else {
            sysUser.setToken(TokenUtils.getToken((sysUser.getId())));
            return sysUser;
        }
    }

    public void addUser(SysUser user) {
        user.setCreatedBy(user.getUpdatedBy());
        sysUserMapper.addUser(user);
    }
}

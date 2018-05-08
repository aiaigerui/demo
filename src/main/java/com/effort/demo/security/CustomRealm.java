package com.effort.demo.security;

import com.effort.demo.model.Role;
import com.effort.demo.model.RolePermission;
import com.effort.demo.model.User;
import com.effort.demo.model.UserRole;
import com.effort.demo.service.*;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 添加角色
     *
     * @param roleIds
     * @param info
     */
    private void addRole(List<Long> roleIds, SimpleAuthorizationInfo info) {
        List<Role> roles = roleService.findBatchIds(roleIds);
        for (Role role : roles) {
            info.addStringPermission(role.getRoleName());
        }
    }

    /**
     * 添加权限
     *
     * @param roleIds
     * @param info
     * @return
     */
    private SimpleAuthorizationInfo addPermission(List<Long> roleIds, SimpleAuthorizationInfo info) {
        for (Long roleId : roleIds) {
            List<RolePermission> rPermissions = rolePermissionService.getByRoleId(roleId);
            for (RolePermission rp : rPermissions) {
                com.effort.demo.model.Permission permission = permissionService.selectById(rp.getId());
                info.addStringPermission(permission.getPermissionName());
            }
        }
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        if (StringUtils.isNotEmpty(username)) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            User user = userService.getUserByUserName(username);
            List<UserRole> userRoles = userRoleService.findByUserId(user.getId());
            List<Long> roleIds = Lists.newArrayList();
            for (UserRole userRole : userRoles) {
                roleIds.add(userRole.getRoleId());
            }
            addRole(roleIds, info);
            addPermission(roleIds, info);
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userService.getUserByUserName(username);

        if (Objects.nonNull(user)) {
            return new SimpleAuthenticationInfo(user, user.getPassWord(), getName());
        }
        return null;
    }

}

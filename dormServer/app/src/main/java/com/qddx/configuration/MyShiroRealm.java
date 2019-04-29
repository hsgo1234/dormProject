package com.qddx.configuration;

//import com.qddx.dao.UserInfoMapper;
//import com.qddx.domain.SysPermission;
//import com.qddx.domain.SysRole;
//import com.qddx.domain.UserInfo;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 身份校验核心类
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/16 14:29
 */
//public class MyShiroRealm extends AuthorizingRealm {
//    @Autowired
//    private UserInfoMapper userInfoMapper;
//
//    /**
//    * 认证信息（身份认证）
//    *
//    * @params token
//    * @return
//    */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws ArithmeticException{
//        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
//
//        //获取用户输入的账号
//        String username = (String) token.getPrincipal();
//        System.out.println(token.getCredentials());
//
//        //通过username从数据库中查找User对象
//        //实际项目中，这里可以根据实际情况做缓存，如果不做Shiro自己也是有时间间隔机制的，2分钟内不会重复执行该方法。
//        UserInfo userInfo = userInfoMapper.findByUsername(username);
//        System.out.println("------>>userInfo="+userInfo);
//        if (userInfo == null){
//            return null;
//        }
//
//        //交给AuthenticatingRealm使用CredentilsMatcher进行密码匹配，如果觉得人家的不好可以自己实现。
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                userInfo,
//                userInfo.getPassword(),
//                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt = username+salt
//                getName()
//        );
//        return authenticationInfo;
//    }
//
//    /**
//    * 此方法调用 hasRole.hasPermission 的时候才会进行回调。
//     * 权限信息（授权）
//     * 1、如果用户正常退出，缓存自动清空。
//     * 2、如果用户非正常退出，缓存自动清空。
//     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
//     * （需要手动编程实现，放在service里进行调用）
//     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例。调用clearCached方法。
//     * ：Authorization是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
//    *
//    * @params principals
//    * @return
//    */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        /*
//        当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
//        其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理。
//        这样的话，doGetAuthorzationInfo 就只会执行一次了，缓存过期之后会再次执行
//         */
//        System.out.println("权限配置-->>MyShiroRealm.doGetAuthorizationInfo()");
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        UserInfo userInfo = (UserInfo)principals.getPrimaryPrincipal();
//
//        for (SysRole role:userInfo.getRoleList()){
//            //设置角色
//            authorizationInfo.addRole(role.getRole());
//            for (SysPermission permission:role.getPermissions()){
//                //设置权限
//                authorizationInfo.addStringPermission(permission.getPermission());
//            }
//        }
//
//        return authorizationInfo;
//    }
//}

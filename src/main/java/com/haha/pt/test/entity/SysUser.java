package com.haha.pt.test.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
*/
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */

    private Long userId;

    /**
     * 用户名
     */

    private String username;

    /**
     * 密码
     */


    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */

    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;

    /**
     * 创建时间
     */
    private Date createTime;


}

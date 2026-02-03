package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * PDA/钥匙用户关联对象 pda_key_user
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
public class PdaKeyUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 关联的PDA/钥匙ID */
    @Excel(name = "关联的PDA钥匙ID")
    private Long keyId;

    /** 关联的用户ID */
    @Excel(name = "关联的用户ID")
    private Long userId;

    /** 用户名（冗余字段） */
    @Excel(name = "用户名")
    private String userName;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getKeyId()
    {
        return keyId;
    }

    public void setKeyId(Long keyId)
    {
        this.keyId = keyId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
}
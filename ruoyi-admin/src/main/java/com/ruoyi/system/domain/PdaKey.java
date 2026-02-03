package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * PDA/钥匙管理对象 pda_key
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
public class PdaKey extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** KEY值 */    
    @Excel(name = "KEY值")
    private String key;

    /** 类型（钥匙/PDA） */
    @Excel(name = "类型", readConverterExp = "钥=匙/PDA")
    private String type;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 所属公司 */
    @Excel(name = "所属公司")
    private String company;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }
}
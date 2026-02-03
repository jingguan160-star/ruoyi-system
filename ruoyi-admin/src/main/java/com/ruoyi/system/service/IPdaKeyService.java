package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PdaKey;

/**
 * PDA/钥匙管理Service接口
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
public interface IPdaKeyService 
{
    /**
     * 查询PDA/钥匙管理
     * 
     * @param id PDA/钥匙管理主键
     * @return PDA/钥匙管理
     */
    public PdaKey selectPdaKeyById(Long id);

    /**
     * 查询PDA/钥匙管理列表
     * 
     * @param pdaKey PDA/钥匙管理
     * @return PDA/钥匙管理集合
     */
    public List<PdaKey> selectPdaKeyList(PdaKey pdaKey);

    /**
     * 新增PDA/钥匙管理
     * 
     * @param pdaKey PDA/钥匙管理
     * @return 结果
     */
    public int insertPdaKey(PdaKey pdaKey);

    /**
     * 修改PDA/钥匙管理
     * 
     * @param pdaKey PDA/钥匙管理
     * @return 结果
     */
    public int updatePdaKey(PdaKey pdaKey);

    /**
     * 批量删除PDA/钥匙管理
     * 
     * @param ids 需要删除的PDA/钥匙管理主键集合
     * @return 结果
     */
    public int deletePdaKeyByIds(Long[] ids);

    /**
     * 删除PDA/钥匙管理信息
     *
     * @param id PDA/钥匙管理主键
     * @return 结果
     */
    public int deletePdaKeyById(Long id);

    /**
     * 校验KEY值是否唯一
     *
     * @param pdaKey PDA/钥匙管理
     * @return 结果
     */
    public boolean checkKeyUnique(PdaKey pdaKey);
}
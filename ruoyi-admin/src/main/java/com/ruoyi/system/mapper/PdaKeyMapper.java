package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PdaKey;

/**
 * PDA/钥匙管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
public interface PdaKeyMapper 
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
     * 删除PDA/钥匙管理
     * 
     * @param id PDA/钥匙管理主键
     * @return 结果
     */
    public int deletePdaKeyById(Long id);

    /**
     * 批量删除PDA/钥匙管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePdaKeyByIds(Long[] ids);

    /**
     * 根据KEY值查询PDA/钥匙管理
     *
     * @param key KEY值
     * @return PDA/钥匙管理
     */
    public PdaKey selectPdaKeyByKey(String key);

    /**
     * 检查KEY值是否存在
     *
     * @param key KEY值
     * @param id 排除的ID（用于修改时排除自身）
     * @return 结果
     */
    public int checkKeyUnique(String key, Long id);
}
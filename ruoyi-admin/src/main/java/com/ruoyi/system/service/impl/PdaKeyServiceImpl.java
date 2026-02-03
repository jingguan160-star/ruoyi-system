package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PdaKeyMapper;
import com.ruoyi.system.domain.PdaKey;
import com.ruoyi.system.service.IPdaKeyService;

/**
 * PDA/钥匙管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
@Service
public class PdaKeyServiceImpl implements IPdaKeyService 
{
    @Autowired
    private PdaKeyMapper pdaKeyMapper;

    /**
     * 查询PDA/钥匙管理
     * 
     * @param id PDA/钥匙管理主键
     * @return PDA/钥匙管理
     */
    @Override
    public PdaKey selectPdaKeyById(Long id)
    {
        return pdaKeyMapper.selectPdaKeyById(id);
    }

    /**
     * 查询PDA/钥匙管理列表
     * 
     * @param pdaKey PDA/钥匙管理
     * @return PDA/钥匙管理
     */
    @Override
    public List<PdaKey> selectPdaKeyList(PdaKey pdaKey)
    {
        return pdaKeyMapper.selectPdaKeyList(pdaKey);
    }

    /**
     * 新增PDA/钥匙管理
     * 
     * @param pdaKey PDA/钥匙管理
     * @return 结果
     */
    @Override
    public int insertPdaKey(PdaKey pdaKey)
    {
        return pdaKeyMapper.insertPdaKey(pdaKey);
    }

    /**
     * 修改PDA/钥匙管理
     * 
     * @param pdaKey PDA/钥匙管理
     * @return 结果
     */
    @Override
    public int updatePdaKey(PdaKey pdaKey)
    {
        return pdaKeyMapper.updatePdaKey(pdaKey);
    }

    /**
     * 批量删除PDA/钥匙管理
     * 
     * @param ids 需要删除的PDA/钥匙管理主键
     * @return 结果
     */
    @Override
    public int deletePdaKeyByIds(Long[] ids)
    {
        return pdaKeyMapper.deletePdaKeyByIds(ids);
    }

    /**
     * 删除PDA/钥匙管理信息
     *
     * @param id PDA/钥匙管理主键
     * @return 结果
     */
    @Override
    public int deletePdaKeyById(Long id)
    {
        return pdaKeyMapper.deletePdaKeyById(id);
    }

    /**
     * 校验KEY值是否唯一
     *
     * @param pdaKey PDA/钥匙管理
     * @return 结果
     */
    @Override
    public boolean checkKeyUnique(PdaKey pdaKey)
    {
        Long pdaKeyId = pdaKey.getId();
        PdaKey info = pdaKeyMapper.selectPdaKeyByKey(pdaKey.getKey());
        if (info == null)
        {
            return true;
        }
        return info.getId().equals(pdaKeyId);
    }
}
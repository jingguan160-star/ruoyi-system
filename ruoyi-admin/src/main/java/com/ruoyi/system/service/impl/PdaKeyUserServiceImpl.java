package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PdaKeyUserMapper;
import com.ruoyi.system.domain.PdaKeyUser;
import com.ruoyi.system.service.IPdaKeyUserService;

/**
 * PDA/钥匙用户关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
@Service
public class PdaKeyUserServiceImpl implements IPdaKeyUserService 
{
    @Autowired
    private PdaKeyUserMapper pdaKeyUserMapper;

    /**
     * 查询PDA/钥匙用户关联
     * 
     * @param id PDA/钥匙用户关联主键
     * @return PDA/钥匙用户关联
     */
    @Override
    public PdaKeyUser selectPdaKeyUserById(Long id)
    {
        return pdaKeyUserMapper.selectPdaKeyUserById(id);
    }

    /**
     * 查询PDA/钥匙用户关联列表
     * 
     * @param pdaKeyUser PDA/钥匙用户关联
     * @return PDA/钥匙用户关联
     */
    @Override
    public List<PdaKeyUser> selectPdaKeyUserList(PdaKeyUser pdaKeyUser)
    {
        return pdaKeyUserMapper.selectPdaKeyUserList(pdaKeyUser);
    }

    /**
     * 新增PDA/钥匙用户关联
     * 
     * @param pdaKeyUser PDA/钥匙用户关联
     * @return 结果
     */
    @Override
    public int insertPdaKeyUser(PdaKeyUser pdaKeyUser)
    {
        return pdaKeyUserMapper.insertPdaKeyUser(pdaKeyUser);
    }

    /**
     * 修改PDA/钥匙用户关联
     * 
     * @param pdaKeyUser PDA/钥匙用户关联
     * @return 结果
     */
    @Override
    public int updatePdaKeyUser(PdaKeyUser pdaKeyUser)
    {
        return pdaKeyUserMapper.updatePdaKeyUser(pdaKeyUser);
    }

    /**
     * 批量删除PDA/钥匙用户关联
     * 
     * @param ids 需要删除的PDA/钥匙用户关联主键
     * @return 结果
     */
    @Override
    public int deletePdaKeyUserByIds(Long[] ids)
    {
        return pdaKeyUserMapper.deletePdaKeyUserByIds(ids);
    }

    /**
     * 删除PDA/钥匙用户关联信息
     *
     * @param id PDA/钥匙用户关联主键
     * @return 结果
     */
    @Override
    public int deletePdaKeyUserById(Long id)
    {
        return pdaKeyUserMapper.deletePdaKeyUserById(id);
    }

    /**
     * 校验keyId和userId组合是否唯一
     *
     * @param pdaKeyUser PDA/钥匙用户关联
     * @return 结果
     */
    @Override
    public boolean checkKeyIdUserIdUnique(PdaKeyUser pdaKeyUser)
    {
        Long pdaKeyUserId = pdaKeyUser.getId();
        PdaKeyUser info = pdaKeyUserMapper.selectPdaKeyUserByKeyIdAndUserId(pdaKeyUser.getKeyId(), pdaKeyUser.getUserId());
        if (info == null)
        {
            return true;
        }
        return info.getId().equals(pdaKeyUserId);
    }
}
package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PdaKeyUser;

/**
 * PDA/钥匙用户关联Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
public interface PdaKeyUserMapper 
{
    /**
     * 查询PDA/钥匙用户关联
     * 
     * @param id PDA/钥匙用户关联主键
     * @return PDA/钥匙用户关联
     */
    public PdaKeyUser selectPdaKeyUserById(Long id);

    /**
     * 查询PDA/钥匙用户关联列表
     * 
     * @param pdaKeyUser PDA/钥匙用户关联
     * @return PDA/钥匙用户关联集合
     */
    public List<PdaKeyUser> selectPdaKeyUserList(PdaKeyUser pdaKeyUser);

    /**
     * 新增PDA/钥匙用户关联
     * 
     * @param pdaKeyUser PDA/钥匙用户关联
     * @return 结果
     */
    public int insertPdaKeyUser(PdaKeyUser pdaKeyUser);

    /**
     * 修改PDA/钥匙用户关联
     * 
     * @param pdaKeyUser PDA/钥匙用户关联
     * @return 结果
     */
    public int updatePdaKeyUser(PdaKeyUser pdaKeyUser);

    /**
     * 删除PDA/钥匙用户关联
     * 
     * @param id PDA/钥匙用户关联主键
     * @return 结果
     */
    public int deletePdaKeyUserById(Long id);

    /**
     * 批量删除PDA/钥匙用户关联
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePdaKeyUserByIds(Long[] ids);

    /**
     * 根据keyId和userId查询PDA/钥匙用户关联
     *
     * @param keyId 关联的PDA/钥匙ID
     * @param userId 关联的用户ID
     * @return PDA/钥匙用户关联
     */
    public PdaKeyUser selectPdaKeyUserByKeyIdAndUserId(Long keyId, Long userId);
}
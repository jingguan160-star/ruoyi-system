package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.PdaKeyUser;
import com.ruoyi.system.service.IPdaKeyUserService;

/**
 * PDA/钥匙用户关联Controller（页面 + 接口）
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
@Controller
@RequestMapping("/system/pdaKeyUser")
public class PdaKeyUserController extends BaseController
{
    private String prefix = "system/pdaKeyUser";

    @Autowired
    private IPdaKeyUserService pdaKeyUserService;

    /**
     * 进入PDA/钥匙用户关联页面
     */
    @RequiresPermissions("system:pdaKeyUser:view")
    @GetMapping()
    public String pdaKeyUser()
    {
        return prefix + "/pdaKeyUser";
    }

    /**
     * 查询PDA/钥匙用户关联列表（表格数据）
     */
    @RequiresPermissions("system:pdaKeyUser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PdaKeyUser pdaKeyUser)
    {
        startPage();
        List<PdaKeyUser> list = pdaKeyUserService.selectPdaKeyUserList(pdaKeyUser);
        return getDataTable(list);
    }

    /**
     * 导出PDA/钥匙用户关联列表
     */
    @RequiresPermissions("system:pdaKeyUser:export")
    @Log(title = "PDA钥匙用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PdaKeyUser pdaKeyUser)
    {
        List<PdaKeyUser> list = pdaKeyUserService.selectPdaKeyUserList(pdaKeyUser);
        ExcelUtil<PdaKeyUser> util = new ExcelUtil<PdaKeyUser>(PdaKeyUser.class);
        return util.exportExcel(list, "PDA钥匙用户数据");
    }

    /**
     * 新增PDA/钥匙用户关联页面
     */
    @RequiresPermissions("system:pdaKeyUser:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存PDA/钥匙用户关联
     */
    @RequiresPermissions("system:pdaKeyUser:add")
    @Log(title = "PDA/钥匙用户关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated PdaKeyUser pdaKeyUser)
    {
        if (!pdaKeyUserService.checkKeyIdUserIdUnique(pdaKeyUser))
        {
            return error("新增PDA/钥匙用户关联失败，该PDA/钥匙已分配给此用户");
        }
        pdaKeyUser.setCreateBy(getLoginName());
        return toAjax(pdaKeyUserService.insertPdaKeyUser(pdaKeyUser));
    }

    /**
     * 修改PDA/钥匙用户关联页面
     */
    @RequiresPermissions("system:pdaKeyUser:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("pdaKeyUser", pdaKeyUserService.selectPdaKeyUserById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存PDA/钥匙用户关联
     */
    @RequiresPermissions("system:pdaKeyUser:edit")
    @Log(title = "PDA/钥匙用户关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated PdaKeyUser pdaKeyUser)
    {
        if (!pdaKeyUserService.checkKeyIdUserIdUnique(pdaKeyUser))
        {
            return error("修改PDA/钥匙用户关联失败，该PDA/钥匙已分配给此用户");
        }
        pdaKeyUser.setUpdateBy(getLoginName());
        return toAjax(pdaKeyUserService.updatePdaKeyUser(pdaKeyUser));
    }

    /**
     * 删除PDA/钥匙用户关联
     */
    @RequiresPermissions("system:pdaKeyUser:remove")
    @Log(title = "PDA/钥匙用户关联", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long[] ids)
    {
        return toAjax(pdaKeyUserService.deletePdaKeyUserByIds(ids));
    }
}
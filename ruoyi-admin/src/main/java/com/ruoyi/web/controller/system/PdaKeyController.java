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
import com.ruoyi.system.domain.PdaKey;
import com.ruoyi.system.service.IPdaKeyService;

/**
 * PDA/钥匙管理Controller（页面 + 接口）
 * 
 * @author ruoyi
 * @date 2026-01-29
 */
@Controller
@RequestMapping("/system/pdaKey")
public class PdaKeyController extends BaseController
{
    private String prefix = "system/pdaKey";

    @Autowired
    private IPdaKeyService pdaKeyService;

    /**
     * 进入PDA/钥匙管理页面
     */
    @RequiresPermissions("system:pdaKey:view")
    @GetMapping()
    public String pdaKey()
    {
        return prefix + "/pdaKey";
    }

    /**
     * 查询PDA/钥匙管理列表（表格数据）
     */
    @RequiresPermissions("system:pdaKey:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PdaKey pdaKey)
    {
        startPage();
        List<PdaKey> list = pdaKeyService.selectPdaKeyList(pdaKey);
        return getDataTable(list);
    }

    /**
     * 导出PDA/钥匙管理列表
     */
    @RequiresPermissions("system:pdaKey:export")
    @Log(title = "PDA/钥匙管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PdaKey pdaKey)
    {
        List<PdaKey> list = pdaKeyService.selectPdaKeyList(pdaKey);
        ExcelUtil<PdaKey> util = new ExcelUtil<PdaKey>(PdaKey.class);
        return util.exportExcel(list, "PDA钥匙数据");
    }

    /**
     * 新增PDA/钥匙管理页面
     */
    @RequiresPermissions("system:pdaKey:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存PDA/钥匙管理
     */
    @RequiresPermissions("system:pdaKey:add")
    @Log(title = "PDA/钥匙管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated PdaKey pdaKey)
    {
        if (!pdaKeyService.checkKeyUnique(pdaKey))
        {
            return error("新增PDA/钥匙管理'" + pdaKey.getKey() + "'失败，KEY值已存在");
        }
        pdaKey.setCreateBy(getLoginName());
        return toAjax(pdaKeyService.insertPdaKey(pdaKey));
    }

    /**
     * 修改PDA/钥匙管理页面
     */
    @RequiresPermissions("system:pdaKey:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("pdaKey", pdaKeyService.selectPdaKeyById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存PDA/钥匙管理
     */
    @RequiresPermissions("system:pdaKey:edit")
    @Log(title = "PDA/钥匙管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated PdaKey pdaKey)
    {
        if (!pdaKeyService.checkKeyUnique(pdaKey))
        {
            return error("修改PDA/钥匙管理'" + pdaKey.getKey() + "'失败，KEY值已存在");
        }
        pdaKey.setUpdateBy(getLoginName());
        return toAjax(pdaKeyService.updatePdaKey(pdaKey));
    }

    /**
     * 删除PDA/钥匙管理
     */
    @RequiresPermissions("system:pdaKey:remove")
    @Log(title = "PDA/钥匙管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long[] ids)
    {
        return toAjax(pdaKeyService.deletePdaKeyByIds(ids));
    }
}
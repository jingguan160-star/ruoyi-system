package com.ruoyi.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 兼容直接访问模板文件路径的场景
 * 比如浏览器地址写成 /template/system/pdaKey/pdaKey.html
 * 这里帮你转发到正确的页面。
 */
@Controller
public class PdaKeyTemplateForwardController {

    /**
     * 兼容 PDA/钥匙管理列表页面
     */
    @GetMapping("/template/system/pdaKey/pdaKey.html")
    public String pdaKeyListPage() {
        // 返回 templates 目录下的 system/pdaKey/pdaKey.html
        return "system/pdaKey/pdaKey";
    }

    /**
     * 兼容 PDA/钥匙用户管理列表页面
     */
    @GetMapping("/template/system/pdaKeyUser/pdaKeyUser.html")
    public String pdaKeyUserListPage() {
        // 返回 templates 目录下的 system/pdaKeyUser/pdaKeyUser.html
        return "system/pdaKeyUser/pdaKeyUser";
    }
}


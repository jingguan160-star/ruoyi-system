-- ----------------------------
-- 将 PDA/钥匙管理、PDA/钥匙用户管理 归入「权限管理」目录下
-- 执行前请备份数据库。若库中已有「权限管理」一级目录，会直接使用该目录。
-- ----------------------------

-- 1) 若不存在「权限管理」一级目录，则新增（与系统管理/监控/工具并列）
INSERT INTO sys_menu (menu_name, parent_id, order_num, url, target, menu_type, visible, is_refresh, perms, icon, create_by, create_time, remark)
SELECT '权限管理', 0, 5, '#', '', 'M', '0', '1', '', 'fa fa-shield', 'admin', sysdate(), '权限管理目录'
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM sys_menu WHERE menu_name = '权限管理' AND parent_id = 0);

-- 2) 为管理员角色分配「权限管理」菜单（若尚未分配）
INSERT IGNORE INTO sys_role_menu (role_id, menu_id)
SELECT 1, menu_id FROM sys_menu WHERE menu_name = '权限管理' AND parent_id = 0;

-- 3) 将 PDA/钥匙管理、PDA/钥匙用户管理 的父菜单改为「权限管理」，并设置排序
UPDATE sys_menu
SET parent_id = (SELECT menu_id FROM (SELECT menu_id FROM sys_menu WHERE menu_name = '权限管理' AND parent_id = 0 LIMIT 1) t),
    order_num = CASE url WHEN '/system/pdaKey' THEN 1 WHEN '/system/pdaKeyUser' THEN 2 ELSE order_num END
WHERE url IN ('/system/pdaKey', '/system/pdaKeyUser') AND menu_type = 'C';

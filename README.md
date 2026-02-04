# PDA/钥匙 与 PDA/钥匙用户 模块 — 提交清单

本文档列出本次新增的两个功能涉及的所有代码文件，便于整理后提交（如 Git commit）。

---

## 一、涉及的文件列表（按层级）

### 1. 领域层 Domain
| 路径 |
|------|
| `ruoyi-admin/src/main/java/com/ruoyi/system/domain/PdaKey.java` |
| `ruoyi-admin/src/main/java/com/ruoyi/system/domain/PdaKeyUser.java` |

### 2. 数据访问层 Mapper
| 路径 |
|------|
| `ruoyi-admin/src/main/java/com/ruoyi/system/mapper/PdaKeyMapper.java` |
| `ruoyi-admin/src/main/java/com/ruoyi/system/mapper/PdaKeyUserMapper.java` |
| `ruoyi-admin/src/main/resources/mapper/system/PdaKeyMapper.xml` |
| `ruoyi-admin/src/main/resources/mapper/system/PdaKeyUserMapper.xml` |

### 3. 业务层 Service
| 路径 |
|------|
| `ruoyi-admin/src/main/java/com/ruoyi/system/service/IPdaKeyService.java` |
| `ruoyi-admin/src/main/java/com/ruoyi/system/service/impl/PdaKeyServiceImpl.java` |
| `ruoyi-admin/src/main/java/com/ruoyi/system/service/IPdaKeyUserService.java` |
| `ruoyi-admin/src/main/java/com/ruoyi/system/service/impl/PdaKeyUserServiceImpl.java` |

### 4. 控制层 Controller
| 路径 |
|------|
| `ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/PdaKeyController.java` |
| `ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/PdaKeyUserController.java` |
| `ruoyi-admin/src/main/java/com/ruoyi/web/controller/system/PdaKeyTemplateForwardController.java` |

### 5. 前端页面（Thymeleaf 模板）
| 路径 |
|------|
| `ruoyi-admin/src/main/resources/templates/system/pdaKey/pdaKey.html` |
| `ruoyi-admin/src/main/resources/templates/system/pdaKey/add.html` |
| `ruoyi-admin/src/main/resources/templates/system/pdaKey/edit.html` |
| `ruoyi-admin/src/main/resources/templates/system/pdaKeyUser/pdaKeyUser.html` |
| `ruoyi-admin/src/main/resources/templates/system/pdaKeyUser/add.html` |
| `ruoyi-admin/src/main/resources/templates/system/pdaKeyUser/edit.html` |

### 6. SQL 脚本（按需执行）
| 路径 | 说明 |
|------|------|
| `sql/pda_tables.sql` | 建表：`pda_key`、`pda_key_user` |
| `sql/menu_permission_pda.sql` | 菜单与权限：将两个模块挂到「权限管理」下（可选） |

---

## 二、提交方式

### 方式：一次提交两个模块
```text
feat: 新增 PDA/钥匙管理、PDA/钥匙用户管理 模块

- PDA/钥匙：列表分页、新增、修改、删除、导出 Excel
- PDA/钥匙用户：列表分页、新增、修改、删除
- 实体使用若依标准（无 MyBatis-Plus/Lombok）
- 兼容 /template/system/pdaKey/pdaKey.html 等路径转发
```


---

## 三、提交前自检

- [ ] 已执行 `sql/pda_tables.sql`（或等价建表），库中存在 `pda_key`、`pda_key_user`
- [ ] 需要菜单时执行 `sql/menu_permission_pda.sql`（会依赖「权限管理」父菜单）
- [ ] 不提交 `target/` 下编译产物（若用 Git，确认 .gitignore 含 `target/`）
- [ ] 工程能正常启动，访问 `/system/pdaKey`、`/system/pdaKeyUser` 可打开列表页

---

## 四、功能与接口速览

| 模块 | 页面入口 | 列表 | 新增 | 修改 | 删除 | 导出 |
|------|----------|------|------|------|------|------|
| PDA/钥匙管理 | `/system/pdaKey` | POST `/system/pdaKey/list` | GET/POST add | GET/POST edit | POST remove | POST export |
| PDA/钥匙用户管理 | `/system/pdaKeyUser` | POST `/system/pdaKeyUser/list` | GET/POST add | GET/POST edit | POST remove | — |

权限标识：`system:pdaKey:view/list/add/edit/remove/export`、`system:pdaKeyUser:view/list/add/edit/remove`。

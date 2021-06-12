package com.woniuxy.oneeyeticket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公司用户表
 * </p>
 *
 * @author Luo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TCompanyManager implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "company_manager_id", type = IdType.AUTO)
    private Integer companyManagerId;

    /**
     * 用户名
     */
    private String companyManagerName;

    /**
     * 密码
     */
    private String companyManagerPassword;

    /**
     * 属于哪一家公司
     */
    private Integer companyId;

    /**
     * 记录添加时间
     */
    private Date rawAddTime;

    /**
     * 记录更新时间
     */
    private Date rawUpdateTime;


}

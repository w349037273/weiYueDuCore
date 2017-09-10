package com.weiyuedu.core.module.portal.dto;

import java.util.List;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-09-07
 * 时间: 08:57
 */
public class EUDateGridResultDto {

    private Long total;
    private List<?> rows;

    public EUDateGridResultDto() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

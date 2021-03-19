package com.jl15988.utils.ECharts.dto;

import lombok.Data;

/**
 * 饼图数据
 *
 * @author jl15988
 * @date 2021/3/19 11:46
 **/
@Data
public class PieSeries {

    /**
     * 名称
     */
    private String name;

    /**
     * 数据
     */
    private Long value;
}

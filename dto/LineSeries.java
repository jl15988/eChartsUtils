package com.jl15988.utils.ECharts.dto;

import lombok.Data;

import java.util.ArrayList;

/**
 * 折线图数据
 *
 * @author jl15988
 * @date 2021/3/18 15:18
 **/
@Data
public class LineSeries {

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 数据
     */
    private ArrayList<Long> data;

    /**
     * 是否开启平滑
     */
    private Boolean smooth;

    public LineSeries(Boolean smooth) {
        this.type = "line";
        this.smooth = smooth;
    }
}

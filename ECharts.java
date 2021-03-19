package com.jl15988.utils.ECharts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jl15988.utils.ECharts.dto.LineSeries;
import com.jl15988.utils.ECharts.dto.PieSeries;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 图表信息
 *
 * @author jl15988
 * @date 2021/3/18 13:11
 **/
@Data
public class ECharts {

    /**
     * 标题
     */
    private Map<String, String> title;
    /**
     * 提示框
     */
    private Map<String, String> tooltip;

    /**
     * 图例组件
     */
    private Map<String, Object> legend;

    /**
     * 直角坐标系内绘图网格
     */
    private Map<String, Object> grid;

    /**
     * 工具栏
     */
    private Map<String, Object> toolbox;

    /**
     * 直角坐标系x轴
     */
    @JsonProperty("xAxis")
    private Map<String, Object> xAxis;

    /**
     * 直角坐标系y轴
     */
    @JsonProperty("yAxis")
    private Map<String, Object> yAxis;

    /**
     * 图表数据
     */
    private ArrayList<Object> series;

    /**
     * 设置标题
     *
     * @param text    标题内容
     * @param subtext 副标题内容
     * @param link    链接
     * @param left    标题位置
     * @author jl15988
     * @date 2021/3/18 13:17
     **/
    public void setTitle(String text, String subtext, String link, String left) {
        HashMap<String, String> map = new HashMap<>();
        map.put("text", text);
        if (subtext != null) {
            map.put("subtext", subtext);
        }
        if (link != null) {
            map.put("link", link);
        }
        if (left != null) {
            map.put("left", left);
        }
        this.title = map;
    }

    /**
     * 设置提示框
     *
     * @param trigger    触发类型 item-适用于饼图，axis-适用于柱状图和折线图，none-不触发
     * @param percentage 是否开启百分比
     * @author jl15988
     * @date 2021/3/18 13:34
     **/
    public void setTooltip(String trigger, Boolean percentage) {
        HashMap<String, String> map = new HashMap<>();
        map.put("trigger", trigger);
        if (percentage != null && percentage) {
            map.put("formatter", "{a} <br/>{b} : {c} ({d}%)");
        }
        this.tooltip = map;
    }

    /**
     * 设置图例组件
     *
     * @param data   名称组（非坐标系【没有axis属性】的图表不需要设置，如饼图）
     * @param orient 排列方式，horizontal-横向，vertical-竖向
     * @param left   位置
     * @author jl15988
     * @date 2021/3/18 13:36
     **/
    public void setLegend(ArrayList<String> data, String orient, String left) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", data);
        if (orient != null) {
            map.put("orient", orient);
        }
        if (left != null) {
            map.put("left", left);
        }
        this.legend = map;
    }

    /**
     * 设置直角坐标系内绘图网格
     *
     * @param top          上距离
     * @param left         左距离
     * @param right        右距离
     * @param bottom       下距离
     * @param containLabel 上下左右距离自身标准，false-只包含坐标轴，true-所有内容
     * @author jl15988
     * @date 2021/3/18 14:11
     **/
    public void setGrid(String top, String right, String bottom, String left, Boolean containLabel) {
        HashMap<String, Object> map = new HashMap<>();
        if (top != null) {
            map.put("top", top);
        }
        if (right != null) {
            map.put("right", right);
        }
        if (bottom != null) {
            map.put("bottom", bottom);
        }
        if (left != null) {
            map.put("left", left);
        }
        map.put("containLabel", containLabel);
        this.grid = map;
    }

    /**
     * 工具栏设置
     *
     * @param orient      排列方式，horizontal-横向，vertical-竖向
     * @param top         上距离
     * @param left        左距离
     * @param right       右距离
     * @param bottom      下距离
     * @param saveAsImage 是否显示下载图片
     * @param restore     是否显示还原
     * @param dataView    是否显示数据视图
     * @param dataZoom    是否显示缩放
     * @param magicType   图标类型切换，为null时不显示
     * @author jl15988
     * @date 2021/3/18 14:16
     **/
    public void setToolbox(String orient, String top, String right, String bottom, String left, Boolean saveAsImage, Boolean restore, Boolean dataView, Boolean dataZoom, ArrayList<String> magicType) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("orient", orient);
        if (top != null) {
            map.put("top", top);
        }
        if (right != null) {
            map.put("right", right);
        }
        if (bottom != null) {
            map.put("bottom", bottom);
        }
        if (left != null) {
            map.put("left", left);
        }
        HashMap<String, Object> feature = new HashMap<>();
        HashMap<String, Object> fun = new HashMap<>();
        if (saveAsImage) {
            feature.put("saveAsImage", fun);
        }
        if (restore) {
            feature.put("restore", fun);
        }
        if (dataView) {
            feature.put("dataView", fun);
        }
        if (dataZoom) {
            feature.put("dataZoom", fun);
        }
        if (dataZoom) {
            feature.put("dataZoom", fun);
        }
        if (magicType != null) {
            HashMap<String, Object> magicTypes = new HashMap<>();
            magicTypes.put("type", magicType);
            feature.put("magicType", magicTypes);
        }
        map.put("feature", feature);
        this.toolbox = map;
    }

    /**
     * 设置直角坐标系x轴
     *
     * @param data         内容
     * @param type         类型，value-数值轴，category-类目轴，time-时间轴，log-对数轴
     * @param name         名称
     * @param nameLocation 名称位置
     * @param boundaryGap  坐标轴两边留白策略
     * @author jl15988
     * @date 2021/3/18 14:36
     **/
    public void setXAxis(ArrayList<String> data, String type, String name, String nameLocation, Boolean boundaryGap) {
        HashMap<String, Object> map = new HashMap<>();
        if (data != null) {
            map.put("data", data);
        }
        map.put("type", type);
        if (name != null) {
            map.put("name", name);
        }
        if (nameLocation != null) {
            map.put("nameLocation", nameLocation);
        }
        if (boundaryGap != null) {
            map.put("boundaryGap", boundaryGap);
        }
        this.xAxis = map;
    }

    /**
     * 设置直角坐标系y轴
     *
     * @param data         内容
     * @param type         类型，value-数值轴，category-类目轴，time-时间轴，log-对数轴
     * @param name         名称
     * @param nameLocation 名称位置
     * @param boundaryGap  坐标轴两边留白策略
     * @author jl15988
     * @date 2021/3/18 14:36
     **/
    public void setYAxis(ArrayList<String> data, String type, String name, String nameLocation, String boundaryGap) {
        HashMap<String, Object> map = new HashMap<>();
        if (data != null) {
            map.put("data", data);
        }
        map.put("type", type);
        if (name != null) {
            map.put("name", name);
        }
        if (nameLocation != null) {
            map.put("nameLocation", nameLocation);
        }
        if (boundaryGap != null) {
            map.put("boundaryGap", boundaryGap);
        }
        this.yAxis = map;
    }

    /**
     * 设置折线图
     *
     * @param list 数据
     * @author jl15988
     * @date 2021/3/18 15:03
     **/
    public void setSeriesLine(ArrayList<LineSeries> list) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        this.series = arrayList;
    }

    /**
     * 设置饼图
     *
     * @param data       数据
     * @param name       名称
     * @param showShadow 是否展示阴影
     * @author jl15988
     * @date 2021/3/18 15:03
     **/
    public void setSeriesPie(ArrayList<PieSeries> data, String name, Boolean showShadow) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "pie");
        map.put("data", data);
        map.put("name", name);
        map.put("radius", "60%");
        if (showShadow) {
            HashMap<String, Object> emphasis = new HashMap<>();
            HashMap<String, Object> itemStyle = new HashMap<>();
            itemStyle.put("shadowBlur", 20);
            itemStyle.put("shadowOffsetX", 0);
            itemStyle.put("shadowColor", "rgba(0, 0, 0, 0.5)");
            emphasis.put("itemStyle", itemStyle);
            map.put("emphasis", emphasis);
        }
        ArrayList<Object> list = new ArrayList<>();
        list.add(map);
        this.series = list;
    }

    /**
     * 设置柱状图
     *
     * @param data           数据
     * @param name           提示框名称
     * @param showBackground 是否显示数据柱背景
     * @author jl15988
     * @date 2021/3/18 15:13
     **/
    public void setSeriesBar(ArrayList<Long> data, String name, Boolean showBackground) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "bar");
        map.put("data", data);
        map.put("name", name);
        map.put("showBackground", showBackground);
        if (showBackground) {
            HashMap<String, String> backgroundStyle = new HashMap<>();
            backgroundStyle.put("color", "rgba(180, 180, 180, 0.2)");
            map.put("backgroundStyle", backgroundStyle);
        }
        ArrayList<Object> list = new ArrayList<>();
        list.add(map);
        this.series = list;
    }

}

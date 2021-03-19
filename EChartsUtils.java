package com.jl15988.utils.ECharts;

import com.jl15988.utils.ECharts.dto.LineSeries;
import com.jl15988.utils.ECharts.dto.PieSeries;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jl15988
 * @date 2021/3/18 16:26
 **/
public class EChartsUtils {

    /**
     * 创建一个默认的折线图
     *
     * @author jl15988
     * @date 2021/3/18 16:59
     **/
    public static ECharts buildDefaultLine(Map<String, String> title, ArrayList<String> xAxis, String xAxisName, String yAxisName, ArrayList<Map<String, Object>> list, Boolean smooth) {
        ECharts eCharts = new ECharts();
        eCharts.setTitle(title.get(EChartsConstant.TITLE_TEXT), title.get(EChartsConstant.TITLE_SUB), title.get(EChartsConstant.TITLE_LINK), null);
        eCharts.setTooltip(EChartsConstant.TRIGGER_AXIS, null);
        eCharts.setGrid("80px", "54px", "6px", "6px", true);
        setDefaultToolbox(eCharts);
        eCharts.setXAxis(xAxis, EChartsConstant.AXIS_TYPE_CATEGORY, xAxisName, null, false);
        eCharts.setYAxis(null, EChartsConstant.AXIS_TYPE_VALUE, yAxisName, null, null);
        setLegendAndSeries(eCharts, list, smooth, "", null);
        return eCharts;
    }

    /**
     * 创建一个默认的饼图
     *
     * @author jl15988
     * @date 2021/3/19 9:01
     **/
    public static ECharts buildDefaultPie(Map<String, String> title, String name, ArrayList<Map<String, Object>> list) {
        ECharts eCharts = new ECharts();
        eCharts.setTitle(title.get(EChartsConstant.TITLE_TEXT), title.get(EChartsConstant.TITLE_SUB), title.get(EChartsConstant.TITLE_LINK), null);
        eCharts.setTooltip(EChartsConstant.TRIGGER_ITEM, true);
        eCharts.setToolbox(EChartsConstant.ORIENT_VERTICAL, null, "1px", null, null, true, false, true, false, null);
        HashMap<String, String> typeParam = new HashMap<>();
        typeParam.put("name", name);
        setLegendAndSeries(eCharts, list, null, EChartsConstant.TYPE_PIE, typeParam);
        return eCharts;
    }

    /**
     * 创建一个默认的柱状图
     *
     * @author jl15988
     * @date 2021/3/19 13:43
     **/
    public static ECharts buildDefaultBar(Map<String, String> title, ArrayList<String> xAxis, String xAxisName, String yAxisName, String name, ArrayList<Long> list) {
        ECharts eCharts = new ECharts();
        eCharts.setTitle(title.get(EChartsConstant.TITLE_TEXT), title.get(EChartsConstant.TITLE_SUB), title.get(EChartsConstant.TITLE_LINK), null);
        eCharts.setTooltip(EChartsConstant.TRIGGER_AXIS, false);
        eCharts.setGrid("80px", "54px", "6px", "6px", true);
        setDefaultToolbox(eCharts);
        eCharts.setXAxis(xAxis, EChartsConstant.AXIS_TYPE_CATEGORY, xAxisName, null, true);
        eCharts.setYAxis(null, EChartsConstant.AXIS_TYPE_VALUE, yAxisName, null, null);
        eCharts.setSeriesBar(list, name, true);
        return eCharts;
    }

    /**
     * 获取数据库数据全部名称
     *
     * @author jl15988
     * @date 2021/3/18 20:43
     **/
    public static ArrayList<String> getCommonNames(ArrayList<Map<String, Object>> listCommon) {
        // 获取全部的名称
        ArrayList<String> names = new ArrayList<>();
        listCommon.forEach(item -> {
            String name = (String) item.get("name");
            if (!names.contains(name)) {
                names.add(name);
            }
        });
        return names;
    }

    /**
     * 将常规数据库数值转为折线图需要的数据
     *
     * @author jl15988
     * @date 2021/3/18 16:54
     * @deprecated This method may reduce efficiency
     **/
    @Deprecated
    public static ArrayList<LineSeries> tranSeries(ArrayList<Map<String, Object>> listCommon, Boolean smooth) {
        ArrayList<LineSeries> list = new ArrayList<>();
        ArrayList<String> names = getCommonNames(listCommon);
        // 转换
        ArrayList<Map<String, Object>> lessSeries = new ArrayList<>();
        names.forEach(name -> {
            LineSeries lineSeries = new LineSeries(smooth);
            ArrayList<Long> arrayList = new ArrayList<>();
            listCommon.forEach(item -> {
                if (item.get("name").toString().equals(name)) {
                    arrayList.add(Long.parseLong(item.get("data").toString()));
                    lessSeries.add(item);
                }
            });
            lessSeries.removeAll(lessSeries);
            lineSeries.setName(name);
            lineSeries.setData(arrayList);
            list.add(lineSeries);
        });
        return list;
    }

    /**
     * 向ECharts中添加默认的Toolbox
     *
     * @author jl15988
     * @date 2021/3/19 13:26
     **/
    public static void setDefaultToolbox(ECharts eCharts) {
        ArrayList<String> magicType = new ArrayList<>();
        magicType.add(EChartsConstant.MAGIC_LINE);
        magicType.add(EChartsConstant.MAGIC_BAR);
        magicType.add(EChartsConstant.MAGIC_STACK);
        eCharts.setToolbox(EChartsConstant.ORIENT_VERTICAL, null, "1px", null, null, true, true, true, true, magicType);
    }

    /**
     * 向ECharts中添加Legend和Series
     *
     * @param eCharts
     * @param listCommon 常规数据
     * @param smooth     是否开启平滑（折线图）
     * @param type       图表类型
     * @param typeParam  图标所需的参数
     * @author jl15988
     * @date 2021/3/19 9:58
     **/
    private static void setLegendAndSeries(ECharts eCharts, ArrayList<Map<String, Object>> listCommon, Boolean smooth, String type, Map<String, String> typeParam) {
        // 保存名称
        ArrayList<String> names = new ArrayList<>();
        // 保存名称位置
        HashMap<String, Integer> seriesSeat = new HashMap<>();
        // 数据
        ArrayList<LineSeries> lineSeries = new ArrayList<>();
        ArrayList<PieSeries> pieSeries = new ArrayList<>();
        // 提取数据
        listCommon.forEach(item -> {
            String name = item.get("name").toString();
            Long data = Long.parseLong(item.get("data").toString());
            if (!names.contains(name)) {
                names.add(name);
                if (StringUtils.isBlank(type) || EChartsConstant.TYPE_LINE.equals(type)) {
                    LineSeries series = new LineSeries(smooth);
                    series.setName(name);
                    ArrayList<Long> list = new ArrayList<>();
                    list.add(data);
                    series.setData(list);
                    lineSeries.add(series);
                    seriesSeat.put(name, lineSeries.size() - 1);
                } else if (EChartsConstant.TYPE_PIE.equals(type)) {
                    PieSeries series = new PieSeries();
                    series.setName(name);
                    series.setValue(data);
                    pieSeries.add(series);
                    seriesSeat.put(name, pieSeries.size() - 1);
                }
            } else {
                Integer seat = seriesSeat.get(name);
                if (StringUtils.isBlank(type) || EChartsConstant.TYPE_LINE.equals(type)) {
                    LineSeries series = lineSeries.get(seat);
                    ArrayList<Long> list = series.getData();
                    list.add(data);
                    series.setData(list);
                } else if (EChartsConstant.TYPE_PIE.equals(type)) {
                    PieSeries series = pieSeries.get(seat);
                    Long value = series.getValue();
                    value += data;
                    series.setValue(value);
                }
            }
        });
        eCharts.setLegend(names, null, null);
        if (StringUtils.isBlank(type) || EChartsConstant.TYPE_LINE.equals(type)) {
            eCharts.setSeriesLine(lineSeries);
        } else if (EChartsConstant.TYPE_PIE.equals(type)) {
            eCharts.setSeriesPie(pieSeries, typeParam.get("name").toString(), true);
        }
    }
}

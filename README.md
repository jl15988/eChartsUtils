# eChartsUtils

这是一个为了实现ECharts图表常规使用而设计的工具类（仅支持折线图，饼图，柱状图），该工具类能够帮助我们实现一般场景的图表数据格式化

## 1. getCommonNames()

| 参数       | 类型                               | 说明       |
| ---------- | ---------------------------------- | ---------- |
| listCommon | ArrayList\<Map\<String, Object\>\> | 常规的数据 |

该方法是从常规格式中获取全部数据名称

## 2. tranSeries()【Deprecated】

| 参数       | 类型                               | 说明                   |
| ---------- | ---------------------------------- | ---------------------- |
| listCommon | ArrayList\<Map\<String, Object\>\> | 数据库获取的数据       |
| smooth     | Boolean                            | 是否开启平滑（折线图） |

该方法实现了数据库数据格式转为ECharts中series所需格式，常规数据库获取的数据格式为：

```json
[
    {
        name: '名称1',
        data: 10
    },
    {
        name: '名称1',
        data: 20
    },
    {
        name: '名称2',
        data: 8
    },
    {
        name: '名称2',
        data: 16
    }
]
```

通过该方法能够将格式转换为以下格式：

```json
[
    {
        name: '名称1',
        data: [10, 20]
    },
    {
        name: '名称2',
        data: [8, 16]
    }
]
```

## 3. setDefaultToolbox()

| 参数    | 类型    | 说明                |
| ------- | ------- | ------------------- |
| eCharts | ECharts | 这是一个ECharts实体 |

该方法作用是向ECharts中添加默认的Toolbox属性

## 4. buildDefaultLine()

| 参数      | 类型                               | 说明                                 |
| --------- | ---------------------------------- | ------------------------------------ |
| title     | Map\<String, String\>              | 标题，包含标题内容，副标题，链接地址 |
| xAxis     | ArrayLis\<String\>                 | x轴栏目                              |
| xAxisName | String                             | x轴名称                              |
| yAxisName | String                             | y轴名称                              |
| list      | ArrayList\<Map\<String, Object\>\> | 图表数据                             |
| smooth    | Boolean                            | 是否开启平滑                         |

该方法创建了一个默认的折线图数据格式。你只需要将必须的属性进行设置，就能生成折线图所需的数据格式

## 5. buildDefaultPie()

| 参数  | 类型                               | 说明                                 |
| ----- | ---------------------------------- | ------------------------------------ |
| title | Map\<String, String\>              | 标题，包含标题内容，副标题，链接地址 |
| name  | String                             | 提示框中数据的名称                   |
| list  | ArrayList\<Map\<String, Object\>\> | 图表数据                             |

该方法创建了一个默认的饼图数据格式。你只需要将必须的属性进行设置，就能生成饼图所需的数据格式

## 6. buildDefaultBar()

| 参数      | 类型                  | 说明                                 |
| --------- | --------------------- | ------------------------------------ |
| title     | Map\<String, String\> | 标题，包含标题内容，副标题，链接地址 |
| xAxis     | ArrayLis\<String\>    | x轴栏目                              |
| xAxisName | String                | x轴名称                              |
| yAxisName | String                | y轴名称                              |
| name      | String                | 提示框中数据的名称                   |
| list      | ArrayList\<Long\>     | 图表数据                             |

该方法创建了一个默认的柱状图数据格式。你只需要将必须的属性进行设置，就能生成柱状图所需的数据格式
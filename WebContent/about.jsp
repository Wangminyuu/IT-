<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>美食城</title>
    <link rel="stylesheet" href="../../../pro2/default.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta name="author" content="www.cssmoban.com" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="default.css">


    <style type="text/css">
        html, body {
            margin: 0;
            padding: 0;
        }

        .iw_poi_title {
            color: #CC5522;
            font-size: 14px;
            font-weight: bold;
            overflow: hidden;
            padding-right: 13px;
            white-space: nowrap
        }

        .iw_poi_content {
            font: 12px arial, sans-serif;
            overflow: visible;
            padding-top: 4px;
            white-space: -moz-pre-wrap;
            word-wrap: break-word
        }

    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>

</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<main>
    <div class="main-head">
        <p><span>关于我们</span></p>
    </div>
</main>
<div class="main-all-width">
    <div class="main-about-body">
        <div><img src="images/about1.jpg"></div>
        <div><img src="images/about2.jpg"></div>
    </div>
    <div class="main-about-footer">
        <p class="chinese">公司致力于帮助传统行业实现在互联网时代的转型升级。力求通过严谨标准的操作、细致贴心的服务，坚持不懈的创新为消费者带来从味觉、嗅觉、视觉上的全新消费体验...</p>
        <p class="english">The company is committed to help the traditional industries to achieve the transformation and
            upgrading in the Internet age. At present, the scope of business includes: e-commerce platform development,
            technical support, technology transfer, operation and maintenance, technical services, big data, cloud
            computing, etc..</p>
    </div>
</div>

<main>
    <div class="main-head">
        <p><span>我们提供</span></p>
    </div>
    <div class="main-we-provide">
        <ul>
            <li><span><img src="images/lunch.png" alt=""></span>
                <h2>中餐</h2>
            </li>
            <li><span><img src="images/dinner.png" alt=""></span>
                <h2>晚餐</h2>
            </li>
            <li><span><img src="images/coffee.png" alt=""></span>
                <h2>甜品/咖啡</h2>
            </li>
        </ul>
    </div>
</main>


<main>
    <div class="main-head">
        <p><span>联系我们</span></p>
    </div>
</main>

<div class="main-all-width">
    <div class="main-about-body main-padding">
        <div class="main-about-map" style="width: 800px ;height: 300px">
            <div style="border:#ccc solid 1px;" id="dituContent"></div>
        </div>
    </div>
</div>



<jsp:include page="/footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap() {
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }

    //创建地图函数：
    function createMap() {
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(118.007401,36.816021);//定义一个中心点坐标
        map.centerAndZoom(point, 18);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }

    //地图事件设置函数：
    function setMapEvent() {
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }

    //地图控件添加函数：
    function addMapControl() {
        //向地图中添加缩放控件
        var ctrl_nav = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_LEFT, type: BMAP_NAVIGATION_CONTROL_LARGE});
        map.addControl(ctrl_nav);

    }

    //标注点数组
    var markerArr = [{
        title: "山东理工大学",
        content: "我的备注",
        point: "118.007401|36.816021",
        isOpen: 0,
        icon: {w: 21, h: 21, l: 0, t: 0, x: 6, lb: 5}
    }
    ];
    //创建marker
    function addMarker() {
        for (var i = 0; i < markerArr.length; i++) {
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0, p1);
            var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point, {icon: iconImg});
            var iw = createInfoWindow(i);
            var label = new BMap.Label(json.title, {"offset": new BMap.Size(json.icon.lb - json.icon.x + 10, -20)});
            marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                borderColor: "#808080",
                color: "#333",
                cursor: "pointer"
            });

            (function () {
                var index = i;
                var _iw = createInfoWindow(i);
                var _marker = marker;
                _marker.addEventListener("click", function () {
                    this.openInfoWindow(_iw);
                });
                _iw.addEventListener("open", function () {
                    _marker.getLabel().hide();
                })
                _iw.addEventListener("close", function () {
                    _marker.getLabel().show();
                })
                label.addEventListener("click", function () {
                    _marker.openInfoWindow(_iw);
                })
                if (!!json.isOpen) {
                    label.hide();
                    _marker.openInfoWindow(_iw);
                }
            })()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i) {
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>" + json.content + "</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json) {
        var icon = new BMap.Icon("images/position.png", new BMap.Size(json.w, json.h), {
            imageOffset: new BMap.Size(-json.l, -json.t),
            infoWindowOffset: new BMap.Size(json.lb + 5, 1),
            offset: new BMap.Size(json.x, json.h)
        })
        return icon;
    }

    initMap();//创建和初始化地图
</script>

<script src="lib/jquery/jquery.js"></script>
<script src="lib/bootstrap/bootstrap.js"></script>
<script src="js/main.js"></script>
</html>
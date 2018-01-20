<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>微阅读,分享知识,传播知识</title>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/css/weiyuedu.css"/>
    <link rel="stylesheet" href="${request.contextPath}/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="${request.contextPath}/css/nongting.css" type="text/css"/>
</head>
<!--标题栏logo-->
<link rel="shortcut icon" href="${request.contextPath}/images/icons/favicon.jpg"/>
<!--加载css、js文件-->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" media="screen"/>
<link rel="stylesheet" href="${request.contextPath}/css/base.css" media="screen"/>
</head>
<#--消息提示样式-->
<style>
    .modal {
        position: fixed;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        z-index: 1040;
        display: none;
        overflow: hidden;
        -webkit-overflow-scrolling: touch;
        outline: 0
    }

    .modal-alert-info {
        padding: 30px;
        text-align: center;
        font-size: 14px;
        background-color: #fff
    }

    .modal-alert {
        position: fixed;
        right: auto;
        bottom: auto;
        width: 300px;
        left: 50%;
        margin-left: -150px;
        top: 50%;
        margin-top: -30px;
        z-index: 9999;
        background-color: #fff;
        border: 1px solid #999;
        border: 1px solid rgba(0, 0, 0, .2);
        outline: 0;
        -webkit-background-clip: padding-box;
        background-clip: padding-box;
        -webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, .5);
        box-shadow: 0 3px 9px rgba(0, 0, 0, .5)
    }

    .radius {
        border-radius: 6px
    }
</style>
<body>
<!--头部-->
<div class="nav-top">
    <div class="container">
        <nav id="navbar" class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">菜单</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand text-hide" href="${request.contextPath}/" title="微阅读,分享知识、传播知识！">微阅读</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${request.contextPath}/" title="前往 首页">首页</a>
                    </li>
                    <li>
                        <a href="${request.contextPath}/yunyingmiao" target="_blank" title="前往 运营喵">运营喵</a>
                    </li>
                    <li>
                        <a href="${request.contextPath}/chanpinwang" target="_blank" title="前往 产品汪">产品汪</a>
                    </li>
                    <li>
                        <a class="visible-md visible-lg" href="${request.contextPath}/chengxuyuan" target="_blank"
                           title="前往 程序猿">程序猿</a>
                    </li>
                    <li>
                        <a class="visible-md visible-lg" href="javascript:void(0);" style="color: grey">敬请期待</a>
                    </li>
                    <div class="zySearch" id="zySearch" style="display: inline;left: 295px;"></div>
                </ul>
        </nav>
    </div>
</div>


<div class="content y-row">

<#--<div class="cloud-banner" style="background: url('${request.contextPath}/images/others/null.png') center no-repeat;">-->
<#--</div>-->
    <span class="icon-info"></span>
    <div class="tip email">
        <span class="icon-info"></span>
        <span class="tip-title">&nbsp&nbsp&nbsp&nbsp&nbsp很抱歉!没有找到您想要的电子书,为了更好的体验,您可以进行以下操作：</span>
        <div style="clear:both"></div>
        <div class="tip-content">
            <p>1. 通知小编,ta会使出蛮荒之力在1-2日内上传电子书！</p>
            <p>2. 加QQ群,直接联系小编帮我找书。</p>
        </div>
        <a class="y-btn-blue bind-btn" id="news" href="javascript:void(0)"
           style="text-decoration: none;box-shadow: 0px 8px 16px rgb(159, 160, 150);border-radius:2px;">立即通知他</a>
        &nbsp;&nbsp;
        <a href="javascript:void(0)" onMouseOut="hideImg()" onmouseover="showImg()"
           style="text-decoration:none;box-shadow: 0px 8px 16px rgb(159, 160, 150);border-radius:2px;"
           class="y-btn-blue bind-btn" id="xuanfu">
            立即加QQ群
        </a>
        <div id="wxImg"
             style="display:none;width:200px;back-ground:#f00;position:absolute;overflow:hidden;border-radius:2px;margin-left: 215px;margin-top: 10px">
            <img style="width: 200px" src="../images/others/qq.png">
        </div>
        <div id="modal-alert" class="modal modal-alert radius" style="display:none;">
            <div class="modal-alert-info">
                <img src="../images/icons/right.png"/>&nbsp;&nbsp;已通知到小编啦！请等待..
            </div>
        </div>
    </div>
</div>


<script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<#--搜索-->
<script type="text/javascript" src="${request.contextPath}/js/zySearch.js"></script>
<script type="text/javascript">
    $("#zySearch").zySearch({
        "width": "355",
        "height": "33",
        "parentClass": "pageTitle",
        "callback": function (keyword) {
            if (keyword){
                window.open("${request.contextPath}/query?q=" + keyword);
            }
        }
    });


</script>

<script type="text/javascript">
    function showImg() {
        document.getElementById("wxImg").style.display = 'block';
    }
    function hideImg() {
        document.getElementById("wxImg").style.display = 'none';
    }
</script>

<script type="text/javascript">

    $("#news").click(modalalertdemo);
    function modalalertdemo() {
        $("#modal-alert").fadeIn(300);
        $("#modal-alert").delay(2000).fadeOut(300);

        //todo 请求
        $.get("${request.contextPath}/book/booklack", {key: '${key}'}, function (data) {
            if (data) {
                $("#news").unbind('click').css("background", "#a9aaab").html("已发送通知");
            }else {

            }
        })
    }
</script>


</body>
</html>
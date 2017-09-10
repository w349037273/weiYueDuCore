<html>
<head>
    <meta charset="utf-8">
    <title>微阅读,随时随地珍惜好时光</title>

    <link rel="stylesheet" href="../css/moco.min.css" type="text/css"/>
    <style type="text/css">.moco-modal-info {
        font-size: 14px;
        line-height: 20px;
    }
    </style>
    <script type="text/javascript" src="../js/helium.js" onload="helium.init()" async></script>
    <script type="text/javascript">var OP_CONFIG = {
        "module": "index",
        "page": "index",
        "userout": 0,
        "usercaution": null
    };
    OP_CONFIG.isLogin = 0;
    var isLogin = 0;
    var _msg_unread = 0;
    var _not_unread = 0;
    var _cartFlag = 0;
    var seajsTimestamp = "v=201708141502";</script>
    <link rel="stylesheet"
          href="../css/coding.imooc.com.css"
          type="text/css"/>
</head>
<!--标题栏logo-->
<link rel="shortcut icon" href="../images/favicon.png"/>
<!--加载css、js文件-->
<link rel="stylesheet" href="../css/bootstrap.min.css" media="screen"/>
<link rel="stylesheet" href="../css/base.css" media="screen"/>
</head>
<body>

<!--首页bar-->
<div class="nav-top">
    <div class="container">
        <nav id="navbar" class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">导航菜单</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand text-hide" href="/" title="悦旅行 - 享生活，乐于行！">微阅读</a></div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/collection/10000/" title="前往 探美食">首页</a></li>
                    <li>
                        <a href="/collection/10001/" title="前往 城里逛">运营喵</a></li>
                    <li>
                        <a href="/collection/10002/" title="前往 趣城外">产品汪</a></li>
                    <li>
                        <a class="visible-md visible-lg" href="http://www.yuelvxing.com/zine/weekl../" target="_blank"
                           title="前往 城市周刊">程序猿</a></li>
                    <li>
                        <a href="http://www.yuelvxing.com/fm/" class="visible-md visible-lg" target="_blank"
                           title="前往 旅行FM">敬请期待</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">

                    <li>
                        <button type="button" class="btn btn-default navbar-btn" data-toggle="modal"
                                data-target="#myModal" title="登录悦旅行"><a href="index.ftl">登录</a>
                        </button>
                    </li>
                    <li>
                        <button id="btn_register" type="button" class="btn btn-primary navbar-btn" title="注册成为悦旅行会员">
                            注册
                        </button>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>


<div class="bannerbar bannerbar-carousel visible-md visible-lg">
    <div id="carouselbar" class="carousel slide">
        <ol class="carousel-indicators">
            <li data-target="#carouselbar" data-slide-to="0" class="active"></li>
            <li data-target="#carouselbar" data-slide-to="1"></li>
            <li data-target="#carouselbar" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <div style="background-image:url('../images/guangzhou-74.jpg')">
                    <a href="http://www.yuelvxing.com/zine/vol074/" class="text-hide" title="吃货爱旅行 —— 广州">周刊：广州</a>
                </div>
            </div>
            <div class="item">
                <div style="background-image:url('../images/b0.jpg')">
                    <a href="/post/5027/" class="text-hide" title="悦旅行旧貌换新颜">悦旅行旧貌换新颜</a>
                </div>
            </div>
            <div class="item">
                <div style="background-image:url('../images/guangzhou-74.jpg')">
                    <a href="http://www.yuelvxing.com/zine/vol074/" class="text-hide" title="吃货爱旅行 —— 广州">周刊：广州</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!--课程列表-->
<div class="w index-main">
    <!-- 类别 -->
    <div>
        <!-- 类别 end -->
        <div class="screening-box clearfix">
            <div class="screening-time l">
                    <span>
                        <a href="/" class="on">默认排序</a>
                    </span>
                    <span>
                        <a href="/?sort=2">最新</a>
                    </span>
                    <span>
                        <a href="/?sort=1">销量</a>
                    </span>
                    <span>
                        <a href="/?sort=3">评价数</a>
                    </span>
            </div>
            <!-- 判断登录 && 并且购买过实战课程 --></div>
        <div class="index-list-wrap">
            <div class="shizhan-course-list clearfix">
                <!-- 前4个课程追加渠道统计链接 -->
                <div class="shizhan-course-wrap l">
                    <a href="/class/135.html">
                        <div class="shizhan-course-box">
                            <!-- 学习进度 -->
                            <div class="box">
                                <div class="img-box">
                                    <img class="shizhan-course-img" alt="PHP开发高可用高安全App后端"
                                         src="http://szimg.mukewang.com/59ae66b2000110fa05400300-360-202.jpg"></div>
                                <div class="shizhan-intro-box">
                                    <p class="shizan-name" title="PHP开发高可用高安全App后端">PHP开发高可用高安全App后端</p>
                                    <p class="shizan-desc" title="让你能轻轻松松开发一个安全可靠高效的多终端APP后台系统">
                                        让你能轻轻松松开发一个安全可靠高效的多终端APP后台系统</p>
                                    <div class="shizhan-info-bottom">
                                        <div class="bottom-box clearfix">
                                            <div class="evaluation-box l">
                                                <div class="shizhan-info">
                                                    <span>中级</span>
                                                    <i>·</i>
                                                    <span>22人学习</span></div>
                                                <div class="stars">
                                                    <i class="sz-star on"></i>
                                                    <i class="sz-star on"></i>
                                                    <i class="sz-star on"></i>
                                                    <i class="sz-star on"></i>
                                                    <i class="sz-star on"></i>
                                                </div>
                                                <div class="evaluation-desc-box clearfix">
                                                    <i class="trangle"></i>
                                                    <div class="left-box l">
                                                        <p>综合评分</p>
                                                        <p class="big-text">10.00</p>
                                                        <p>3人评价</p>
                                                    </div>
                                                    <div class="right-box l">
                                                        <p>内容实用
                                                            <span>10.0</span></p>
                                                        <p>通俗易懂
                                                            <span>10.0</span></p>
                                                        <p>逻辑清晰
                                                            <span>10.0</span></p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="r">
                                                <!-- 有促销价 -->
                                                <!-- 没有促销价 -->
                                                <p class="shizhan-price"></p>
                                                <p class="shizhan-course-price">￥266.00</p></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <#--分页-->
            <div class="page">
                <span class="disabled_page">首页</span>
                <span class="disabled_page">上一页</span>
                <a href="javascript:void(0)" class="active">1</a>
                <a href="/?sort=0&unlearn=0&page=2">2</a>
                <a href="/?sort=0&unlearn=0&page=3">3</a>
                <a href="/?sort=0&unlearn=0&page=2">下一页</a>
                <a href="/?sort=0&unlearn=0&page=3">尾页</a></div>
        </div>
</div>
<!-- 课程列表end -->
<div id="footer">
    <div class="waper">
        <div class="footerwaper clearfix">
            <div class="followus r">
                <a class="followus-weixin" href="javascript:;" target="_blank" title="微信">
                    <div class="flw-weixin-box"></div>
                </a>
                <a class="followus-weibo" href="http://weibo.com/u/3306361973" target="_blank" title="新浪微博"></a>
                <a class="followus-qzone" href="http://user.qzone.qq.com/1059809142/" target="_blank" title="QQ空间"></a>
            </div>
            <div class="footer_intro l">
                <div class="footer_link">
                    <ul>
                        <li>
                            <a href="http://www.imooc.com/" target="_blank">网站首页</a></li>
                        <li>
                            <a href="http://www.imooc.com/about/cooperate" target="_blank" title="企业合作">企业合作</a></li>
                        <li>
                            <a href="http://www.imooc.com/about/job" target="_blank">人才招聘</a></li>
                        <li>
                            <a href="http://www.imooc.com/about/contact" target="_blank">联系我们</a></li>
                        <li>
                            <a href="http://www.imooc.com/about/recruit" target="_blank">讲师招募</a></li>
                        <li>
                            <a href="http://coding.imooc.com/user/faq" target="_blank">常见问题</a></li>
                        <li>
                            <a href="http://www.imooc.com/user/feedback" target="_blank">意见反馈</a></li>
                        <li>
                            <a href="http://daxue.imooc.com/" target="_blank">慕课大学</a></li>
                        <li>
                            <a href="http://www.imooc.com/about/friendly" target="_blank">友情链接</a></li>
                        <!-- <li><a href="http://www.imooc.com/about/us" target="_blank">关于我们</a></li> --></ul>
                </div>
                <p>Copyright © 2017 imooc.com All Rights Reserved | 京ICP备 13046642号-2</p>
            </div>
        </div>
    </div>
</div>
<#--<script type="text/javascript" src="//moco.imooc.com/static/monitor/error.js"></script>-->
<#--<script src="/passport/static/scripts/ssologin.js?v=2.0"></script>-->
<#--<script type="text/javascript" src="/static/module/common/js/common.js?v=201708141502"></script>-->
<#--<script type="text/javascript" src="//www.imooc.com/static/moco/v1.0/dist/js/moco.min.js"></script>-->
<#--<script type="text/javascript" src="/static/lib/stellar/jquery.stellar.min.js"></script>-->
<#--<script data-entry="index/index">requirejs(['index/index']);</script>-->
<!--<script type='text/javascript'>
$.stellar();
(function(m, ei, q, i, a, j, s) {
m[a] = m[a] || function() {
(m[a].a = m[a].a || []).push(arguments)
};
j = ei.createElement(q),
s = ei.getElementsByTagName(q)[0];
j.async = true;
j.charset = 'UTF-8';
j.src = i + '?v=' + new Date().getUTCDate();
s.parentNode.insertBefore(j, s);
})(window, document, 'script', '//eco-api.meiqia.com/dist/meiqia.js', '_MEIQIA');
_MEIQIA('entId', 7772);
</script>-->
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/open-connect.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">$(function () {
    $('#btn_register').click(function () {
        window.location.href = '/account/register/';
    });
});</script>

<script>var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "../js/hm.js";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
<!-- 幻灯片 -->
<script>$('#carouselbar').carousel({
    interval: 5000
});</script>

<script type="text/javascript" src="../js/interaction.js" charset="UTF-8"></script>
</body>

</html>
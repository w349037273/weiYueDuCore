<html>
<head>
    <meta charset="utf-8">
    <title>${book.bookName}-微阅读</title>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/css/weiyuedu.css"/>
</head>
<!--标题栏logo-->
<link rel="shortcut icon" href="${request.contextPath}/images/icons/favicon.jpg"/>
<!--加载css、js文件-->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" media="screen"/>
<link rel="stylesheet" href="${request.contextPath}/css/base.css" media="screen"/>
</head>
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
                    <div class="zySearch" id="zySearch" style="display: inline"></div>
                </ul>
        </nav>
    </div>
</div>


<!--想看这本书-->
<div class="w index-main">
    <div>
        <div class="index-list-wrap">
            <div class="shizhan-course-list clearfix">
                <div class="shizhan-course-wrap l">
                    <div class="shizhan-course-box">
                        <div class="box">
                            <div class="img-box">
                                <img class="shizhan-course-img"
                                     src=${book.bgPicture}></div>
                            <div class="shizhan-intro-box">
                                <p class="shizan-name" title=${book.bookName}>${book.bookName}</p>
                                <p class="shizan-desc" title=${book.bookDesc}>
                                ${book.bookDesc}</p>
                                <div class="shizhan-info-bottom">
                                    <div class="bottom-box clearfix">
                                        <div class="evaluation-box l">
                                            <div class="shizhan-info">
                                                <span>${book.author}</span>
                                            </div>
                                        </div>
                                        <div class="evaluation-box l" style="float: right">
                                            <div class="shizhan-info">
                                                <a href="${book.downloadUrl}"
                                                   style="font-size: 14px;color: #60A0FA;text-decoration:none;font-weight: bold">立即下载</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            <#--新增扫码-->
                <div class="banner-item" style="
                        display: block;
                        width: 567px;
                        height: 316px;
                        border-radius: 8px;
                        background-size: cover;
                        margin:16px;
                        float: right;
                        box-shadow: 0px 8px 16px rgba(7, 17, 27, 0.1);
                        background-image: url(${request.contextPath}/images/saoma/zanshang.jpg)">
                </div>
            </div>
        </div>
        <script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="${request.contextPath}/js/open-connect.js" type="text/javascript" charset="UTF-8"></script>
        <script type="text/javascript">$(function () {
            $('#btn_register').click(function () {
                window.location.href = '${request.contextPath}/account/register/';
            });
        });</script>

        <script>var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "${request.contextPath}/js/hm.js";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();</script>


</body>

</html>
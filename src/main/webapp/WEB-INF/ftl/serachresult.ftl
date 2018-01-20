<html>
<head>
    <meta charset="utf-8">
    <title>搜索-微阅读</title>
    <link type="text/css" rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${request.contextPath}/css/style.css" type="text/css" />
</head>
<!--标题栏logo-->
<link rel="shortcut icon" href="${request.contextPath}/images/icons/favicon.jpg"/>
<!--加载css、js文件-->
<link rel="stylesheet" href="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" media="screen"/>
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
                        <a href="${request.contextPath}/chanpinwang"  target="_blank" title="前往 产品汪">产品汪</a>
                    </li>
                    <li>
                        <a class="visible-md visible-lg" href="${request.contextPath}/chengxuyuan" target="_blank"
                           title="前往 程序猿">程序猿</a>
                    </li>
                    <li>
                        <a  class="visible-md visible-lg" href="javascript:void(0);" style="color: grey">敬请期待</a>
                    </li>
                    <div class="zySearch" id="zySearch" style="display: inline;left: 295px;"></div>
                </ul>
        </nav>
    </div>
</div>



<!--课程列表-->
<div class="w index-main">
    <div>
        <div class="screening-box clearfix">
            <div class="screening-time l">
                <span><a class="on" style="color: red">搜索结果:</a></span>
            </div>
        </div>
        <div class="index-list-wrap">
            <div class="shizhan-course-list clearfix">
            <#list books as book>

                <div class="shizhan-course-wrap l">
                    <a href="${request.contextPath}/select/bookdesc/${book.id}" style="text-decoration : none;">
                        <div class="shizhan-course-box">
                            <!-- 学习进度 -->
                            <div class="box">
                                <div class="img-box">
                                    <img class="shizhan-course-img" src=${book.bgPicture}></div>
                                <div class="shizhan-intro-box">
                                    <p class="shizan-name" >${book.bookName}</p>
                                    <p class="shizan-desc" title=${book.bookDesc}>
                                    ${book.bookDesc}</p>
                                    <div class="shizhan-info-bottom">
                                        <div class="bottom-box clearfix">
                                            <div class="evaluation-box l">
                                                <div class="shizhan-info">
                                                    <span>${book.author}</span></div>
                                            </div>
                                            <div class="r">
                                                <p class="shizhan-price"></p>
                                                <#--<p class="shizhan-course-price">￥266.00</p>-->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </#list>
            </div>
            <div class="nodata" style="text-align: center;font-size: small;color: grey" ></div>
        </div>
    </div>
</div>
<script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<#--搜索-->
<script type="text/javascript" src="${request.contextPath}/js/zySearch.js"></script>
<script type="text/javascript">
    $("#zySearch").zySearch({
        "width":"355",
        "height":"33",
        "parentClass":"pageTitle",
        "callback":function(keyword){
//            console.info("搜索的关键字");
            if (keyword){
                window.open("${request.contextPath}/query?q=" + encodeURI(keyword));
            }
        }
    });
</script>






























<#--<script type="text/javascript" src="${request.contextPath}/js/interaction.js" charset="UTF-8"></script>-->
</body>

</html>
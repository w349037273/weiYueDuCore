<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>微阅读,分享知识,传播知识</title>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/css/weiyuedu.css"/>
    <link rel="stylesheet" href="${request.contextPath}/css/style.css" type="text/css"/>
</head>
<!--标题栏logo-->
<link rel="shortcut icon" href="${request.contextPath}/images/icons/favicon.jpg"/>
<!--加载css、js文件-->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" media="screen"/>
<link rel="stylesheet" href="${request.contextPath}/css/base.css" media="screen"/>
</head>
<body>
<center>
    <!--头部-->

    <div class="nav-top">
        <div class="container">
            <nav id="navbar" class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target=".navbar-ex1-collapse">
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


    <!--首页banner-->
    <div id="main">

        <div class="bgfff banner-box">
            <div class="g-banner pr">
                <div class="g-banner-content">
                    <div class="g-banner-box">
                        <div class="bannerbar bannerbar-carousel visible-md visible-lg">
                            <div id="carouselbar" class="carousel slide">
                                <ol class="carousel-indicators">
                                    <li data-target="#carouselbar" data-slide-to="0" class="active"></li>
                                    <li data-target="#carouselbar" data-slide-to="1"></li>
                                    <li data-target="#carouselbar" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <div style="background-image:url('${request.contextPath}/images/banners/banner2.gif')">
                                            <a href="${request.contextPath}/chanpinwang" class="text-hide">产品汪</a>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div style="background-image:url('${request.contextPath}/images/banners/banner1.gif')">
                                            <a href="${request.contextPath}/yunyingmiao" class="text-hide">运营喵</a>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div style="background-image:url('${request.contextPath}/images/banners/banner3.gif')">
                                            <a href="${request.contextPath}/chengxuyuan" class="text-hide">程序猿</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--课程-->
    <div class="w index-main">
        <div>
        <#--精选书单-->
            <div class="screening-box clearfix">
                <div class="screening-time l">
                    <img src="${request.contextPath}/images/icons/recommend.png">
                    <span><p class="on" style="font-size: 12px;color:#999;">精选书单</p></span>
                </div>
            </div>
            <div class="bg000">

            <#list booklistses as booklist>
                <div class='course-card-container'>
                    <a target="_blank" class='course-card' style="text-decoration: none;hover{color: #a47e3c;}"
                       href="${request.contextPath}/bookListDesc?bookListId=${booklist.id}"
                       data-track="xshk-1-1">
                        <div class='course-card-top hashadow'>
                            <img class="course-banner"
                                 src="${booklist.bgPicture}">
                        </div>
                        <div class='course-card-content'>
                            <h3 class='course-card-name'>${booklist.title}</h3>
                        </div>
                    </a>
                </div>
            </#list>
            </div>


        <#--好书推荐-->
            <div class="screening-box clearfix" style="float: left">
                <div class="screening-time l">
                    <img src="${request.contextPath}/images/icons/hot.png">
                    <span><p class="on" style="font-size: 12px;color:#999;">好书为您推荐</p></span>
                </div>
            </div>

            <div class="index-list-wrap">
                <div class="shizhan-course-list clearfix">
                <#--ajax请求在此处添加数据-->
                </div>
                <div class="nodata" style="text-align: center;font-size: small;color: grey"></div>
            </div>
            <div id="progressBar" class="progressBar" style="display: none;">
                <img src="${request.contextPath}/images/loading.gif">
            </div>
        </div>
    </div>

<#--加载js文件-->
    <script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- 轮播控制 -->
    <script>$('#carouselbar').carousel({
        interval: 3000
    });</script>

<#--滚动加载数据-->
    <script type="text/javascript">
        var gPageSize = 24;
        var j = 0; //设置当前页数，全局变量
        var totalpage = 6; //总页数，防止超过总页数继续滚动
        $(function () {
            //初始化加载第一页数据
            getData(0);
            //根据页数读取数据
            function getData(pagenumber) {
                j++;//页码自动增加，保证下次调用时为新的一页。
                $.get("${request.contextPath}/select/books", {pageNum: j, pageSize: gPageSize}, function (data) {
                    if (data) {
                        insertDiv(data.data.rows);
                    }
                })
            }

            //生成数据html，append到div中
            function insertDiv(json) {
                var $mainDiv = $(".shizhan-course-list");
                var html = '';
                for (var i = 0; i < json.length; i++) {
                    //设置展示数据
                    html += '<div class="shizhan-course-wrap l">';
                    html += '<a href=\"${request.contextPath}/select/bookdesc/' + json[i].id + '\" target=\"_blank\" style=\"text-decoration : none;\">';
                    html += '<div class=\"shizhan-course-box\">';
                    html += '<div class=\"box\">';
                    html += '<div class=\"img-box\">';
                    html += '<img class=\"shizhan-course-img\" src=' + json[i].bgPicture + '></div>';
                    html += '<div class=\"shizhan-intro-box\">';
                    html += '<p class=\"shizan-name\" title=' + json[i].bookName + '>' + json[i].bookName + '</p>';
                    html += '<p class=\"shizan-desc\" title=' + json[i].bookDesc + '>' + json[i].bookDesc + '</p>';
                    html += '<div class=\"shizhan-info-bottom\">';
                    html += '<div class=\"bottom-box clearfix\">';
                    html += '<div class=\"evaluation-box l\">';
                    html += '<div class=\"shizhan-info\">' + '<span>' + json[i].author + '</span></div>';
                    html += '</div>';
                    html += '<div class=\"r\">';
                    html += '<p class=\"shizhan-price\"></p>';
//                        html += '<p class=\"shizhan-course-price\">'+'￥'+json[i].price+'</p>';
                    html += '</div>';
                    html += '</div>';
                    html += '</div>';
                    html += '</div>';
                    html += '</div>';
                    html += '</div>';
                    html += '</a>';
                    html += '</div>';
                }
                $mainDiv.prepend(html);
            }

            function showEmpty() {
                $(".nodata").show().html("亲,已经没有了!");
            }

            //定义鼠标滚动事件
            $(window).scroll(function () {

                if (j < totalpage) {
                    //第一个方案
                    var pageH = $(document).height();//文档高度
                    var winH = $(window).height(); //页面可视区域高度
                    var srollPos = $(window).scrollTop(); //滚动条距顶部距离(页面超出窗口的高度)
                    var totalheight = winH + srollPos;
                    if ((pageH - 50) <= totalheight) {//判读是否快到达底部
                        //显示加载提示
                        $("#background,#progressBar").show();

                        getData(j);//异步加载数据
                        //清空加载提示
                        $("#background,#progressBar").hide();
                    }
                } else {
                    showEmpty();
                }
            });
        });
    </script>


<#--搜索-->
    <script type="text/javascript" src="${request.contextPath}/js/zySearch.js"></script>
    <script type="text/javascript">
        $("#zySearch").zySearch({
            "width": "355",
            "height": "33",
            "parentClass": "pageTitle",
            "callback": function (keyword) {
                if (keyword){
                    window.open("${request.contextPath}/query?q=" + encodeURI(keyword));
                }
            }
        });
    </script>


</center>

</body>

</html>


<style type="text/css">@charset "UTF-8";
/*body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, button, textarea, p, blockquote, th, td {*/
/*margin: 0;*/
/*padding: 0*/
/*}*/

body {
    background: #fff;
    color: #5e5e5e;
    font: 14px/2em Microsoft YaHei, SimSun, Arial
}

:link, :visited, ins {
    text-decoration: none
}

a:link, a:visited {
    color: #5e5e5e
}

a:hover {
    color: #c9394a
}

a:active {
    color: #666
}

.pr {
    position: relative
}

a:link, a:visited, body, html {
    color: #14191e
}

body, html {
    font: 14px/1.5 "PingFang SC", "微软雅黑", "Microsoft YaHei", Helvetica, "Helvetica Neue", Tahoma, Arial, sans-serif
}

a, button, input {
    outline: 0
}

body .bk, div {
    background-size: cover
}

.banner-box {
    display: block;
    margin-bottom: 48px;
    padding-top: 32px
}

/*#main > .bgfff {*/
/*box-shadow: 0 2px 8px 0 rgba(7, 17, 27, .06)*/
/*}*/

/*.bgfff {*/
/*background-color: #fff !important*/
/*}*/
.g-banner {
    background-color: #93999f;
    box-shadow: 0 12px 24px 0 rgba(7, 17, 27, .2)
}

.g-banner {
    position: relative;
    height: 444px;
    overflow: hidden;
    width: 1152px;
    margin: auto;
    background-color: #fff;
    border-radius: 8px
}

.g-banner .g-banner-content {
    position: relative;
    float: left;
    width: 1152px
}

.g-banner .g-banner-content .g-banner-box {
    position: relative;
    height: 444px
}

<
style >

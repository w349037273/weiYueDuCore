<html>
<head>
    <meta charset="utf-8">
    <title>程序猿-微阅读</title>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/css/weiyuedu.css"/>
    <link rel="stylesheet" href="${request.contextPath}/css/style.css" type="text/css" />
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
                <img src="${request.contextPath}/images/icons/monkey.png">
                <span><a class="on">程序猿</a></span>
            </div>
        </div>
        <div class="index-list-wrap">
            <div class="shizhan-course-list clearfix">
            </div>
            <div class="nodata" style="text-align: center;font-size: small;color: grey" ></div>
        </div>
    </div>
</div>

<script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<#--滚动加载数据-->
<script type="text/javascript">
    var gPageSize = 5;
    var i = 1; //设置当前页数，全局变量
    var winH = $(window).height(); //页面可视区域高度
    var totalpage = 6; //总页数，防止超过总页数继续滚动
    $(function () {
        //初始化加载第一页数据
        getData(0);
        //根据页数读取数据
        function getData(pagenumber) {
            i++;//页码自动增加，保证下次调用时为新的一页。
            $.get("${request.contextPath}/select/booksbycategory", { categoryId:2,pageNum: i,pageSize:gPageSize}, function (data) {
                if (data) {
                    insertDiv(data.data.rows);
                }
            })
        }
        //生成数据html，append到div中
        function insertDiv(json){
            var $mainDiv = $(".shizhan-course-list");
            var html = '';
            for (var i = 0; i < json.length; i++) {
                //设置展示数据
                html += '<div class="shizhan-course-wrap l">';
                html += '<a href=\"/select/bookdesc/'+json[i].id+'\" style=\"text-decoration : none;\">';
                html += '<div class=\"shizhan-course-box\">';
                html += '<div class=\"box\">';
                html += '<div class=\"img-box\">';
                html += '<img class=\"shizhan-course-img\" src='+json[i].bgPicture+'></div>';
                html += '<div class=\"shizhan-intro-box\">';
                html += '<p class=\"shizan-name\" title='+json[i].bookName+'>'+json[i].bookName+'</p>';
                html += '<p class=\"shizan-desc\" title='+json[i].bookDesc+'>'+json[i].bookDesc+'</p>';
                html += '<div class=\"shizhan-info-bottom\">';
                html += '<div class=\"bottom-box clearfix\">';
                html += '<div class=\"evaluation-box l\">';
                html += '<div class=\"shizhan-info\">'+'<span>'+json[i].author+'</span></div>';
                html += '</div>';
                html += '<div class=\"r\">';
                html += '<p class=\"shizhan-price\"></p>';
//                html += '<p class=\"shizhan-course-price\">'+'￥'+json[i].price+'</p>';
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
            $(".nodata").show().html("已经没有了哦!");
        }
        //定义鼠标滚动事件
        $(window).scroll(function () {
            if (i<totalpage){
                var pageH = $(document.body).height();
                var scrollT = $(window).scrollTop(); //滚动条top
                var aa = (pageH - winH - scrollT) / winH;
                if (aa < 0.02) {//0.02是个参数
                    alert('可视区域:'+winH+','+'文档高度:'+pageH+','+'滚动条高度:'+scrollT+','+'比例:'+aa);
                    getData(i);
                }
            }else{
                showEmpty();
            }
        });



    });
</script>


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
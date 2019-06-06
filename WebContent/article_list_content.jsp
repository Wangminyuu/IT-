<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <script src="lib/jquery/jquery.js"></script>
    <script src="lib/bootstrap/bootstrap.js"></script>
    <script src="/lib/clipboard/clipboard.min.js"></script>
    <script src="js/main.js"></script>
</head>
<jsp:include page="/header.jsp"></jsp:include>
   
<main>
    <div>
        <div class="main-head">
            <p><span>美食资讯</span></p>
        </div>
    </div>

    <div class="article-list-banner"><img src="images/foodnews1.jpg"></div>

</main>
<main>
    <div class="article-content-box">
        <header class="article-content-header">一大波餐饮大咖正在分享经营经验，你需要的都在这里！</header>
        <div class="share">
            <span>分享到:</span>
            <div class="bdsharebuttonbox sharebox">
                <a href="javascript:void(0);" class="copy-url-btn" data-clipboard-action="copy" data-clipboard-target="#current-url"><div id="current-url" style="width:0px;height:0px;overflow:hidden;"></div>复制网址</a>
                <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信">微信</a>
                <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博">新浪微博</a>
                <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间">QQ空间</a>
                <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博">腾讯微博</a>
                <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网">人人网</a>
            </div>
        </div>
        <article class="article-content">
            <p>大多数老餐饮人都有一种感觉，那就是近几年像原来那样按部就班地赚钱好像越来越难了，行业里的“套路”越来越深。行业竞争加剧互联网大军侵袭，用工、店租、材料成本飞涨，市场的蓝海早已消失。大的餐饮经营企业紧跟潮流进行变革，小的企业盈利难度加大。那么，接下来，怎样才能在迅速变革的餐饮行业找到自己的位置?</p>
            <p>事实上，餐饮行业是国民经济的重要组成部分。改革开放以来，随着国民经济的持续快速发展，城乡居民收入不断增加，人民生活水平断提高，我国餐饮业发展非常迅速，市场潜力较大，发展前景广阔。但同样随着社会的不断进步，“变化”必将成为未来的常态，只有在不断的“变化”中根据自身实际情况找到不变的优势，才能以长久立足。</p>
            <p>目前，有一波职业餐饮人做客直播互动栏目《餐言餐语》，自剖自己多年的成功之路，从各个品类餐厅的经营理念出发，与餐饮同仁深入交流各品类餐厅的管理方法和经营小窍门。获得了广大餐饮人的关注，纷纷来到餐饮咖取经回家。</p>
        </article>
        <footer class="article-footer-btn">
         
        </footer>
    </div>
</main>


<jsp:include page="/footer.jsp"></jsp:include>

<script>
    var clipBoardContent="";
    clipBoardContent += this.location.href;
    $('#current-url').html(clipBoardContent);

    // button的class的值
    var clipboard = new Clipboard('.copy-url-btn');
    clipboard.on('success', function(e) {
        alert('复制成功');
    });

    clipboard.on('error', function(e) {
        alert('复制失败，请手动进行复制');
    });
</script>
<script>




    window._bd_share_config = {
    "common": {
        "bdSnsKey": {},
        "bdText": "",
        "bdMini": "2",
        "bdPic": "",
        "bdStyle": "0",
        "bdSize": "16"
    }, "share": {}
};
with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/header.jsp"></jsp:include>
<main>
    <div>
        <div class="main-head">
            <p><span>美食资讯</span></p>
        </div>
    </div>

    <div class="article-list-banner"><img src="images/foodnews1.jpg"></div>
    <ul class="article-list">
        <li>
            <div class="article-date">
                <strong>06</strong>
                <p>2018-06-01</p>

            </div>
            <div class="article-info">
                <a href="article_list_content.jsp">
                    <h3>一大波餐饮大咖正在分享经营经验，你需要的都在这里！</h3>
                    <p>意大利面的千变万化堪比万花筒,据说种类高达500余种,让以面食为傲的大中国也有些为之惊叹。作为出去吃饭一定要主食的中国人,吃西餐时点一份意面,不光可以填饱肚子,而且也不会失了格调儿。那些可爱的意面不仅拥有挺直的粉型,还有螺丝型、弯管型、蝴蝶型、空心型、贝壳型,林林总总,以漂亮的姿态诱惑着男士、女士们的少男少女心,吃出了柔情蜜意。</p>
                </a>
            </div>
        </li>

        <li>
            <div class="article-date">
                <strong>06</strong>
                <p>2018-06-01</p>
            </div>
            <div class="article-info">
                <a href="article_list_content.jsp">
                    <h3>一大波餐饮大咖正在分享经营经验，你需要的都在这里！</h3>
                    <p>自从韩国进口品牌圃美多进入中国后,“意面控”们在家也可以吃着美味儿的意大利面,享受纯正西餐厅的格调。尤其是有宝贝的妈妈们,可以让营养、味美、造型可爱的意面改善孩子的小餐桌,更加丰富多彩。圃美多蕃茄肉酱意大利面,孩子们一定会喜欢。鲜艳的红酱粘稠着,混合了嫩嫩的猪肉粒,入口酸甜鲜香。酱料中还暗藏胡萝卜、洋葱,给孩子们补充丰富的营养。</p>
                </a>
            </div>
        </li>
        <li>
            <div class="article-date">
                <strong>06</strong>
                <p>2018-06-01</p>
            </div>
            <div class="article-info">
                <a href="article_list_content.jsp">
                    <h3>一大波餐饮大咖正在分享经营经验，你需要的都在这里！</h3>
                    <p>意面白酱的口味独特,赢得了一部分“意面控”的喜爱,这也是圃美多奶油培根意大利面热销的原因之一。杜兰小麦紧实嚼劲的口感,搭配车大、高达、蓝波三种奶酪,形成层次感鲜明的奶香丰盈味蕾,再配以红肉培根,怎能不让人食指大动。</p>
                </a>
            </div>
        </li>
      
    </ul>
    <section class="article-btn">
        <span class="article-prev-btn"></span>
        <span class="article-next-btn"></span>
    </section>
    <nav aria-label="Page navigation" class="article-page">
        <ul class="pagination">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
        </ul>
    </nav>
</main>

<jsp:include page="/footer.jsp"></jsp:include>



</body>

<script src="lib/jquery/jquery.js"></script>
<script src="lib/bootstrap/bootstrap.js"></script>
<script src="js/main.js"></script>
</html>
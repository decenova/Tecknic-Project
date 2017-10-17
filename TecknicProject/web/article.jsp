<%-- 
    Document   : article
    Created on : 15-Oct-2017, 10:28:30
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknic | Tin tức công nghệ mỗi ngày</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="mainstyle.css">
        <link rel="stylesheet" href="indexStyle.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <script src="jquery.min.js" type="application/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
        <script src="UIControll.js" type="application/javascript"></script>
    </head>
    <body>
        <s:include value="header.jsp"></s:include>
            <div class="main selfclear fixPadingTop">
                <div class="postContaint">
                    <div class="postTran">
                        <div class="postInfoTran fixPadding selfclear">
                            <div class="avatar">
                                <%-- cho avatar của thằng viết bài vào đây --%>
                                <img src="img/avartar01.jpg">
                            </div>
                            <div class="info">
                                <%-- cho tên của thằng viết bài vào đây --%>
                                <a><span class="poster">Trẩu Ăn Tre</span></a>
                                <br/>
                                <%-- cho ngày đăng bài của thằng viết bài vào đây --%>
                                <span class="datepost">12:30 12/3/2017</span>
                            </div>
                        </div>
                        <div class="postImage">
                            <%-- cho ảnh bài viết --%>
                            <img src="img/cover02.jpg">
                        </div>
                        <div class="postTitle fixPadding widthNarrow">
                            <%-- cho tiêu đề của bài vào đây --%>
                            <p>Child of light: The dark of Luis V sẽ ra mắt vào tháng 11</p>
                        </div>
                        <div class="postBody fixPadding widthNarrow">
                            <%-- cho nội dung vào giữa thẻ div này, dung el epression chứ dừng đùng struts--%>
                            <p>
                                Nhắc tới Ubisoft, chúng ta thường nghĩ tới nhiều tựa game lớn và thuộc thể loại hành động như
                                Assassin's Creed, Splinter Cell hay Far Cry. Tuy nhiên hãng game Pháp cũng thể hiện họ hoàn toàn đủ
                                năng lực để tạo ra các sản phẩm nhẹ nhàng nhưng đầy chất lượng, nổi bật như series Rayman hay gần
                                đây là Child of Light - tựa game nhập vai kết hợp platform.<br/>
                                Câu chuyện trong Child of Light xoay quanh Aurora - nhân vật lấy cảm hứng từ công chúa ngủ trong
                                rừng của truyện cổ Grimm. Khi tỉnh dậy, Aurora thấy mình đang ở trong xứ sở thần tiên mang tên
                                Lemuria, nơi đang rơi vào tình trạng u tối, lạnh lẽo bởi lý do Mặt Trời, Mặt Trăng cùng các vì sao
                                đã bị đánh cắp bởi nữ hoàng Black Queen, và nhiệm vụ của Aurora giống như trong các câu chuyện cổ
                                tích khác là lên đường tìm lại sự bình yên cho thế giới.<br/>
                                <br/>
                                <img src="img/post01.jpg">
                                <br/>
                                Child of Light mang màu sắc của các game JRPG, đặc biệt là nhiều nét tương đồng với Final Fantasy.
                                Khi bạn cần phải tính toán cẩn thận để tối ưu thời gian ra đòn, làm chậm đòn đánh của đối phương để
                                giành chiến thắng.<br/>
                                <br/>
                                <img src="img/post02.jpg">
                                <br/>
                                Đồng hành với Aurora có một người bạn đom đóm nhỏ bé, giúp bạn thu thập các vật phẩm trên bản đồ.
                                Anh bạn này giúp đỡ nhân vật chính của chúng ta trong những câu đố và hỗ trợ cô trong chiến đấu bằng
                                việc làm chói mắt kẻ thù khiến cho đối thủ chậm lại để ra đòn muộn cũng như giúp hồi máu đồng đội.
                                Game cũng sử dụng hình thức tăng cấp nhân vật nhằm tăng điểm vào bảng skill, có hơn 200 kĩ năng để
                                các bạn có thể khám phá. Ngoài ra game cũng có hệ thống craft đồ khá đa dạng bằng việc sử dụng các
                                viên ngọc nhỏ để kết hợp với các đặc tính khác nhau.<br/>

                                Phát triển trên nền UbiArt Framework - engine cho phép các nhà làm game có thể đưa chính những bức
                                concept art đẹp mắt vào sử dụng trong trò chơi, Child of Light nhanh chóng thể hiện được tính nghệ
                                thuật của nó trong con mắt người chơi. Khung cảnh màu sắc kết hợp cùng những đoạn phim cắt cảnh mang
                                đậm màu sắc thần tiên như truyện cổ tích.<br/>
                                <br/>
                                <img src="img/post03.jpg">
                                <br/>
                                Có thể nói ngoài đồ họa tuyệt vời thì Child of Light cũng mang đến một nền âm thanh cuốn hút. Nhạc
                                nền du dương của trò chơi sẽ thỉnh thoảng vang lên để dẫn dắt bạn vào từng phần của câu truyện, và
                                chất lượng của chúng thì phải nói là rất tuyệt: nhẹ nhàng, đầm ấm và du dương. Các hiệu ứng khác như
                                tiếng sấm sét khi trời mưa, tiếng bước chân của người khổng lồ, tiếng âm thanh lúc chiến đấu... tất
                                cả hòa trộn vào với nhau nhịp nhàng, có lúc dồn dập, có lúc lại nhẹ nhàng trầm lắng khiến người chơi
                                bị cuốn theo lúc nào không biết.<br/>

                                Có thể nói Child of Light là một tựa game rất đáng chơi. Phiêu lưu cùng Aurora bạn sẽ nhanh chóng bị
                                cuốn theo cốt truyện, mong muốn khám phá toàn bộ những gì trò chơi mang lại. Chỉ với 15 USD đổi lại
                                hơn 10 giờ chơi đầy hấp dẫn, khó có thể đòi hỏi gì hơn ở một tựa game tuyệt vời như Child of
                                Light.<br/>
                            </p>
                        </div>
                        <hr/>
                        <div class="postControl fixPadding widthNarrow">
                            <%-- số lượt view và số lượt bình luận --%>
                            <span><i class="fa fa-eye"></i> 12000</span>
                            <span><i class="fa fa-comment-o"></i> 12</span>
                        </div>
                        <hr>
                        <s:if test="%{#session.ROLE != null}">
                        <%-- chỗ comment của người dùng --%>
                        <div class="commentContain fixPadding widthNarrow">
                            <div class="comment">
                                <div class="commentInfo">
                                    <div class="avatar">
                                        <%-- cho avatar của user đang đọc bài viết --%>
                                        <img src="img/avartar01.jpg">
                                    </div>
                                    <div class="info">
                                        <%-- cho tên user đang đọc bài viết --%>
                                        <a><span class="poster">Trẩu Ăn Tre</span></a>
                                        <br/>
                                        <span class="datepost"></span>
                                    </div>
                                </div>
                                <form>
                                    <div class="commentContent">
                                        <%-- nhúng texteditor --%>
                                        <textarea name="txtComment" rows="4"></textarea>
                                        <button class="button buttonPrimary"><i class="fa fa-send"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        </s:if>
                        <s:else>
                            <div class="fixPadding widthNarrow">
                                <p>Hãy <a href="login.jsp">đăng nhập</a> để có thể bình luận cùng mọi người!</p>
                            </div>
                        </s:else>
                        <hr>
                        
                        <%-- chỗ xem comment của người khác --%>
                        <div class="commentContain fixPadding widthNarrow">
                            <div class="comment">
                                <div class="commentInfo">
                                    <div class="avatar">
                                        <%-- avatar của thằng comment cái này --%>
                                        <img src="img/avartar01.jpg">
                                    </div>
                                    <div class="info">
                                        <%-- tên của thằng comment cái này --%>
                                        <a><span class="poster">Trẩu Ăn Tre</span></a>
                                        <br/>
                                        <%-- thời gian của comment --%>
                                        <span class="datepost">12:30 12/3/2017</span>
                                    </div>
                                </div>
                                <div class="commentContent">
                                    <%-- Nội dung comment --%>
                                    <p>Helo moi nguoi</p>
                                </div>
                                    <%-- số thứ tự nếu cần hoặc số commentId --%>
                                <div class="commentIndex">#1</div>
                                <hr/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <s:include value="footer.jsp"></s:include>
    </body>
</html>

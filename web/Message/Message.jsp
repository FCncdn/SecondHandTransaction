<%--
  Created by IntelliJ IDEA.
  User: fcncd
  Date: 2018/11/28
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="UserManagement.User" %>
<%@ page import="MessageManagement.Dialogue" %>
<%@ page import="MessageManagement.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentUserBean" class="bean.UserBean" scope="session" />
<%! User currentUser; %>
<%! String currentDialogueListId = ""; %>
<%
    currentUser = new User(currentUserBean.getUsername());
    currentUserBean.setDialogueArrayList(currentUser);
    String enter = request.getParameter("enter");
    if (enter.equals("messageBox")){
        currentDialogueListId = "0";
    }else if (enter.equals("itemDetail")){

    }
%>
<html>
<head>

    <meta charset="utf-8" />

    <title>我的消息</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />

    <meta content="Coderthemes" name="author" />

    <meta http-equiv="X-UA-Compatible" content="IE=edge" />

    <link rel="stylesheet" href="../stylesheets/style.css">

    <!-- App favicon -->

    <link rel="shortcut icon" href="../assets/images/favicon.ico">



    <!-- App css -->

    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

    <link href="../assets/css/icons.css" rel="stylesheet" type="text/css" />

    <link href="../assets/css/style.css" rel="stylesheet" type="text/css" />



    <script src="../assets/js/modernizr.min.js"></script>

    <!-- Sweet Alert css -->

</head>
<body>
    <!-- Navigation Bar-->

    <header id="topnav">

        <div class="topbar-main">

            <div class="container-fluid">

                <!-- Logo container-->

                <div class="logo">

                    <a href="/main.jsp" class="logo">

                        <span class="logo-large"><i class="mdi mdi-cart-outline"></i> 头大校内二手交易</span>

                    </a>

                </div>

                <!-- End Logo container-->



                <!-- 右侧下拉框 -->
                <div class="menu-extras topbar-custom">

                    <ul class="list-unstyled topbar-right-menu float-right mb-0">

                        <li class="menu-item">
                            <!-- Mobile menu toggle-->
                            <a class="navbar-toggle nav-link">
                                <div class="lines">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </div>
                            </a>
                            <!-- End mobile menu toggle-->
                        </li>

                        <!-- 消息下拉框 -->
                        <li class="dropdown notification-list">
                            <a class="nav-link dropdown-toggle arrow-none waves-effect" data-toggle="dropdown" href="#" role="button"
                               aria-haspopup="false" aria-expanded="false">
                                <i class="fi-speech-bubble noti-icon"></i>
                                <span class="badge badge-danger badge-pill noti-icon-badge">6</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h6 class="m-0"><span class="float-right"><a href="" class="text-dark"><small>清除</small></a> </span>消息</h6>
                                </div>

                                <div class="slimscroll" style="max-height: 230px;">
                                    <!-- item-->
                                    <a href="/users/message" class="dropdown-item notify-item">
                                        <div class="notify-icon"><img src="assets/images/users/avatar-2.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                        <p class="notify-details">Cristina Pride</p>
                                        <p class="text-muted font-13 mb-0 user-msg">Hi, How are you? What about our next meeting</p>
                                    </a>

                                    <!-- item-->
                                    <a href="/users/message" class="dropdown-item notify-item">
                                        <div class="notify-icon"><img src="assets/images/users/avatar-3.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                        <p class="notify-details">Sam Garret</p>
                                        <p class="text-muted font-13 mb-0 user-msg">Yeah everything is fine</p>
                                    </a>

                                    <!-- item-->
                                    <a href="/users/message" class="dropdown-item notify-item">
                                        <div class="notify-icon"><img src="assets/images/users/avatar-4.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                        <p class="notify-details">Karen Robinson</p>
                                        <p class="text-muted font-13 mb-0 user-msg">Wow that's great</p>
                                    </a>

                                    <!-- item-->
                                    <a href="/users/message" class="dropdown-item notify-item">
                                        <div class="notify-icon"><img src="assets/images/users/avatar-5.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                        <p class="notify-details">Sherry Marshall</p>
                                        <p class="text-muted font-13 mb-0 user-msg">Hi, How are you? What about our next meeting</p>
                                    </a>

                                    <!-- item-->
                                    <a href="/users/message" class="dropdown-item notify-item">
                                        <div class="notify-icon"><img src="assets/images/users/avatar-6.jpg" class="img-fluid rounded-circle" alt="" /> </div>
                                        <p class="notify-details">Shawn Millard</p>
                                        <p class="text-muted font-13 mb-0 user-msg">Yeah everything is fine</p>
                                    </a>
                                </div>

                                <!-- All-->
                                <a href="/Message/Message.jsp" class="dropdown-item text-center text-primary notify-item notify-all">
                                    所有消息 <i class="fi-arrow-right"></i>
                                </a>

                            </div>
                        </li>

                        <!-- 个人信息下拉框 -->
                        <li class="dropdown notification-list">
                            <a class="nav-link dropdown-toggle waves-effect nav-user" data-toggle="dropdown" href="#" role="button"
                               aria-haspopup="false" aria-expanded="false">
                                <img src="/images/lzn.jpg" alt="user" class="rounded-circle"> <span class="ml-1 pro-user-name"><%= currentUser.getUsername()%> <i class="mdi mdi-chevron-down"></i> </span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h6 class="text-overflow m-0">Welcome !</h6>
                                </div>

                                <!-- item-->
                                <a href="#" class="dropdown-item notify-item">
                                    <i class="fi-head"></i> <span>我的主页</span>
                                </a>

                                <!-- item-->
                                <a href="#" class="dropdown-item notify-item">
                                    <i class="fi-file-subtract"></i> <span>我发布的</span>
                                </a>

                                <!-- item-->
                                <a href="#" class="dropdown-item notify-item">
                                    <i class="fi-outbox"></i> <span>我卖出的</span>
                                </a>

                                <!-- item-->
                                <a href="#" class="dropdown-item notify-item">
                                    <i class="fi-inbox"></i> <span>我买到的</span>
                                </a>

                                <!-- item-->
                                <a href="${pageContext.request.contextPath}/UserServlet?method=tologin"
                                   class="dropdown-item notify-item">
                                    <i class="fi-power"></i> <span>注销</span>
                                </a>

                            </div>
                        </li>

                    </ul>

                </div>
                <!-- end menu-extras -->



                <div class="clearfix"></div>



            </div> <!-- end container -->

        </div>

        <!-- end topbar-main -->

        <div class="navbar-custom">

            <div class="container-fluid">

                <div id="navigation">

                    <!-- Navigation Menu-->

                    <form action="">

                        <ul class="navigation-menu p-2">

                            <li style="width: 25%;">

                                <input class="form-control" type="text" placeholder="搜索你想要的东西">

                            </li>

                            <li>

                                <button type="submit" class="btn btn-light waves-effect waves-primary"  style="zoom: 0.95;margin-bottom: 2px;" > <i class="fa fa-search m-r-5"></i> <span>搜索</span> </button>

                            </li>

                        </ul>

                    </form>

                    <!-- End navigation menu -->

                </div> <!-- end #navigation -->

            </div> <!-- end container -->

        </div> <!-- end navbar-custom -->

    </header>

    <!-- End Navigation Bar-->


    <div class="wrapper">

        <div class="container-fluid">

            <div class="row mt-4">
                <%! int messageCount; %>
                <%! int currentDialogueID; %>
                <!-- 根据用户在联系人列表点击的联系人确定当前对话框的ID -->
                <%
                    Dialogue currentDialogue = new Dialogue();
                    ArrayList<Message> currentMessageList = new ArrayList<Message>();
                    String currentContent = null;
                    //获取当前的dialogueID
                    currentDialogue = currentUserBean.getDialogueArrayList().get(Integer.parseInt(currentDialogueListId));
                    currentMessageList = currentDialogue.getMessageArrayList();
                    messageCount = currentDialogue.getMessageArrayList().size();
                    String contanct = currentDialogue.getReceiver();
                    currentDialogueID = Integer.parseInt(currentDialogue.getDialogueId());
                %>
                <%
                    session.setAttribute("sender",currentUser.getUsername());
                    session.setAttribute("receiver",contanct);
                    session.setAttribute("dialogueID",currentDialogueID);
                %>
                <!-- 联系人列表 -->
                <div class="col-4">

                    <div class="card-box" id="contact-frame">

                        <h4 class="header-title m-b-30">消息列表 (<%= currentUserBean.getDialogueArrayList().size()%>)</h4>

                        <div class="contacts-list" id="contact-box" style="overflow-y: scroll;">

                            <!-- 缺少联系人逻辑 添加、删除等-->

                            <div class="media m-b-20 contacts active">

                                <div class="d-flex mr-3">

                                    <a href="#"> <img class="media-object rounded-circle thumb-sm" alt="64x64" src="../images/lzn.jpg"> </a>

                                </div>

                                <div class="media-body">

                                    <h5 class="mt-0"><%= contanct%></h5>

                                    <p class="font-13 text-muted mb-0">

                                        ’这里是消息内容‘

                                    </p>

                                </div>

                            </div>



                        </div>

                    </div>

                </div><!-- end col -->

                <!-- 对话框 -->

                <div class="col-8">

                    <div class="card-box task-detail" id="message-frame" style="position: relative;">

                        <!-- 对话框标题栏 -->
                        <div class="media mt-0 m-b-30" style="border-bottom: 1px solid black;padding-bottom: 1rem;">

                            <img class="d-flex mr-3 rounded-circle" alt="64x64" src="../images/lzn.jpg" style="width: 48px; height: 48px;">

                            <div class="media-body">

                                <h5 class="media-heading mb-0 mt-0"><%= contanct%></h5>

                            </div>

                        </div>

                        <!-- 对话框 -->
                        <div style="overflow-y: scroll;" id="message-box">

                            <% for (int i = 0; i < messageCount; i++){%>
                                <% currentContent = currentMessageList.get(i).getContent(); %>
                                <% if (currentMessageList.get(i).getSender().equals(currentUser.getUsername())) {%>
                                    <% if (currentMessageList.get(i).getMessageType().equals("notification")){%>
                                        <div class="mesg-item message-self">
                                            <p class="font-13 message-content" style="max-width: 80%;">
                                                <%= "你" + currentContent + "请耐心等待商家回复~" %>
                                            </p>
                                        </div>
                                    <% } else {%>
                                        <!-- 用户自己发送的消息 -->
                                        <div class="mesg-item message-self">

                                            <div class="mr-3 ml-3">

                                                <img class="rounded-circle thumb-sm" alt="64x64" src="../images/lzn.jpg">

                                            </div>

                                            <p class="font-13 message-content" style="max-width: 80%;">

                                                <%= currentContent %>

                                            </p>

                                        </div>
                                    <% } %>
                                <% } else { %>
                                    <% if (currentMessageList.get(i).getMessageType().equals("notification")){%>
                                        <div class="mesg-item message-self">
                                            <p class="font-13 message-content" style="max-width: 80%;">
                                                <%= "我" + currentContent + "请尽快回复哦~"%>
                                            </p>
                                        </div>
                                    <% } else {%>
                                        <!-- 对方发送的消息 -->
                                        <div class="mesg-item message-contacts">

                                            <div class="mr-3 ml-3">

                                                <img class="rounded-circle thumb-sm" alt="64x64" src="../images/lzn.jpg">

                                            </div>

                                            <p class="font-13 message-content" style="max-width: 80%;">

                                                <%= currentContent %>

                                            </p>

                                        </div>
                                    <% } %>
                                <% } %>
                            <%}%>

                        </div>

                        <!-- 发送框 -->
                        <div class="text-right mt-4" style="position: absolute;bottom: 5px;right: 40px; width: 90%;">
                            <form method="post" action="/sendMessageServlet?type=normalDialogue">
                                <input type="text" name="MessageContent" id="MessageContent" class="form-control" style="zoom: 0.7;">

                                <input type="submit" value="发送" class="btn btn-primary btn-sm mt-1" style="zoom: 0.8;">
                            </form>

                        </div>


                    </div>

                </div><!-- end col -->

            </div>

        </div> <!-- end container -->

    </div>

    <!-- end wrapper -->


    <!-- Footer -->

    <footer class="footer">

        <div class="container">

            <div class="row">

                <div class="col-12 text-center">

                    这里是页脚

                </div>

            </div>

        </div>

    </footer>

    <!-- End Footer -->


    <!-- jQuery  -->

    <script src="../assets/js/jquery.min.js"></script>

    <script src="../assets/js/popper.min.js"></script>

    <script src="../assets/js/bootstrap.min.js"></script>

    <script src="../assets/js/waves.js"></script>

    <script src="../assets/js/jquery.slimscroll.js"></script>

    <!-- App js -->

    <script src="../assets/js/jquery.core.js"></script>

    <script src="../assets/js/jquery.app.js"></script>

    <!-- getVerificationCode -->

    <script src="../javascripts/verificationCode.js"></script>

    <!-- Sweet Alert Js  -->

    <script src="../plugins/sweet-alert/sweetalert2.min.js"></script>

    <script src="../assets/pages/jquery.sweet-alert.init.js"></script>

    <script src="../assets/js/modernizr.min.js"></script>


    <script>


        setTimeout(function(){
            $('#message-frame').height($(document).height() * 0.7);
            $('#message-box').height($('#message-box').parent().height() * 0.71);
            $('#contact-frame').height($(document).height() * 0.7);
            $('#contact-box').height($('#contact-box').parent().height() * 0.71);
        }, 200)



        window.onbeforeunload = function () {



        }

        $('.contacts').click(function () {

            $(this).addClass("active");

            $(this).siblings().removeClass("active");

        })

    </script>


</body>
</html>

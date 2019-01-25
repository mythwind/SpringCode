<%--
  Created by IntelliJ IDEA.
  User: mythwind
  Date: 2019/01/25
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link href="video/video-js/video-js.css" rel="stylesheet" type="text/css">
    <script src="video/video-js/video.js"></script>
    <script>
        videojs.options.flash.swf = "video/video-js/video-js.swf";
    </script>

    <style type="text/css">body {background:#333333;position: relative;}</style>
</head>
<body>

<video id="example_video_1" class="video-js" controls preload="none" width="640" height="264" poster="http://vjs.zencdn.net/v/oceans.png" data-setup="{}">
    <source src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4">
    <source src="http://vjs.zencdn.net/v/oceans.webm" type="video/webm">
    <source src="http://vjs.zencdn.net/v/oceans.ogv" type="video/ogg">
    <track kind="captions" src="../shared/example-captions.vtt" srclang="en" label="English">
    <track kind="subtitles" src="../shared/example-captions.vtt" srclang="en" label="English">
    <p class="vjs-no-js">To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a></p>
</video>

<%--
<!--视频播放器-->
<div class="play_panel">

    <!-- 视频播放 -->
    <div class="zyNewVideo_main">
        <div class="zvideo_index t5o">
            <div class="zvideo">
                <video id="myVideo" width="100%" height="100%">
                    <source src="" type='video/mp4'/>
                    <p class="vjs-no-js">无法运行，请执行js权限</p>
                </video>
                <div class="loading-video"><a href="javascript:void(0)"></a></div>
                <div class="vip big-play-button"><a href="javascript:void(0)"></a></div>
                <div class="ordinary big-play-button">
                    <div class="ad">
                        <span class="off"></span>
                        <a href="/course/ruby-px/" target="_blank">
                            <img src="/uploads/"/>
                        </a>
                    </div>
                    <a href="javascript:void(0)"></a>
                </div>
                <div class="videoStopMeg textC">

                    <div style="height: 110px;margin-top: -55px;">
                        <p class="font14 VSMbtn"><a class="VSMbtn1"><i></i>重新观看</a><a class="VSMbtn2">下一节</a></p>
                    </div>

                </div>
                <div class="video-header" style="display: none">
                    <h1 class="video-name">1.课程介绍</h1>

                    <div class="view-port">
                        <a class="Small" href="javascript:void(0)">50%</a>
                        <a class="Normal" href="javascript:void(0)">75%</a>
                        <a class="Big" href="javascript:void(0)">100%</a>
                    </div>
                    <div class="out-full">
                        <a href="javascript:void(0)">退出全屏</a>
                    </div>
                </div>
                <div class="control-bar">
                    <div class="progressBar">
                        <div class="current_time"></div>
                        <span class="slider"></span>
                        <div class="timeBar"><span></span></div>
                        <div class="bufferBar"></div>
                        <div class="hover-time">00:00:00</div>
                    </div>
                    <div class="play-control"><span class="control-text playing" title="播放">Play</span></div>
                    <div class="play-next-control"><span class="control-text play-next" title="下一节">Next</span></div>
                    <div class="progressTime">
                        <span class="current">00:00</span>
                        <i>/</i>
                        <span class="duration">00:00</span>
                    </div>
                    <div class="full-screen"><span></span></div>
                    <div class="volume">
                        <span></span>
                        <div class="volume-bar">
                            <div class="volume-size">
                                <div class="volume-level"></div>
                                <div class="volume-dot">
                                    <div class="volume-prompt">40%</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="play-rate">
                        <div class="play-rate-menu">
                            <ul>
                                <li>2x</li>
                                <li>1.5x</li>
                                <li>1.25x</li>
                                <li class="on">1x</li>
                            </ul>
                        </div>
                        <span>1x</span>
                    </div>
                </div>

            </div>
            <div class="bottom-module">
                <span class="title">1.课程介绍</span>
                <div class="fr">
                    <div class="share">
                        <i></i><span>分享</span>
                        <div class="jiathis_style">
                            <a class="jiathis_button_cqq"></a>
                            <a class="jiathis_button_qzone"></a>
                            <a class="jiathis_button_tsina"></a>
                        </div>
                    </div>
                    <div class="down-load">
                        <i></i><span>离线学习</span>
                        <div class="weixin-box"><em></em><p>下载APP离线观看</p></div>
                    </div>
                </div>
            </div>
        </div>
    </div>



</div>--%>

</body>
</html>

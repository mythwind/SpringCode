package com.vincent.springbootdemo.utils;

import com.vincent.springbootdemo.FFmpegException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mythwind
 * @Date: 2019/02/20 15:18
 * @Description:视频转码工具
 */
public class FfmpegMediaHelper {
    protected static Logger logger = LoggerFactory.getLogger(FfmpegMediaHelper.class);

    String inputPath = "D:\\temp\\videoori\\Warcraft3_End.avi";
    String outputPath = "D:\\temp\\wangss\\Warcraft3_End.mp4";

    public static void main(String[] args) {
        String inputPath = "D:\\temp\\videoori\\Warcraft3_End.avi";
        String outputPath = "D:\\temp\\wangss\\Warcraft3_End.mp4";
        Resource resource = new ClassPathResource("ffmpeg/ffmpeg.exe");
        try {
            String ffmpegpath = resource.getFile().getAbsolutePath();
            ffmpeg(ffmpegpath, inputPath, outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean ffmpeg(String inputPath, String outputPath) {
        // 先获取当前项目路径，在获得源文件、目标文件、转换器的路径
        File diretory = new File("");
        String currPath = diretory.getAbsolutePath();
        try {
            //int type = checkContentType(inputPath + "\\sintel.wmv");
            int type = checkContentType(inputPath);

            System.out.println("直接转成mp4格式");
            //status = processMp4(inputPath);// 直接转成mp4格式
            Resource resource = new ClassPathResource("ffmpeg/ffmpeg.exe");
            String ffmpegpath = resource.getFile().getAbsolutePath();

            boolean status = processFLV(ffmpegpath, inputPath, outputPath);
            System.out.println(status);
            return status;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getPath出错");
        }
        return false;
    }

    private static boolean process(List command) throws FFmpegException {
        try {
            if (null == command || command.size() ==0)
                return false;
            Process videoProcess = new ProcessBuilder(command).redirectErrorStream(true).start();
            new PrintStream(videoProcess.getErrorStream()).start();
            new PrintStream(videoProcess.getInputStream()).start();
            int exitcode = videoProcess.waitFor();
            if (exitcode == 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FFmpegException("file uploadfailed",e);
        }
    }
    public static Boolean ffmpeg(String ffmpegPath, String inputPath, String outputPath) throws FFmpegException {
        if (!checkFile(inputPath)) {
            throw new FFmpegException("文件格式不合法");
        }
        int type = checkContentType(inputPath);
        List<String> command = getFfmpegCommand(type, ffmpegPath, inputPath, outputPath);
        if (null != command &&command.size() > 0) {
            return process(command);
        }
        return false;
    }

    /**
     * 视频转码flv
     *
     * @param ffmpegPath   转码工具的存放路径
     * @param upFilePath   用于指定要转换格式的文件,要截图的视频源文件
     * @param codcFilePath 格式转换后的的文件保存路径
     * @return
     * @throws Exception
     */
    public static boolean processFLV(String ffmpegPath, String upFilePath, String codcFilePath) {
        // 创建一个List集合来保存转换视频文件为flv格式的命令
        List<String> convert = new ArrayList<String>();
        convert.add(ffmpegPath); // 添加转换工具路径
        convert.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
        convert.add(upFilePath); // 添加要转换格式的视频文件的路径
        convert.add("-ab");
        convert.add("56");
        convert.add("-ar");
        convert.add("22050");
        convert.add("-q:a");
        convert.add("8");
        convert.add("-r");
        convert.add("15");
        convert.add("-s");
        convert.add("600*500");
        /*
        * convert.add("-qscale"); // 指定转换的质量
        * convert.add("6");
        * convert.add("-ab"); // 设置音频码率
        * convert.add("64");
        * convert.add("-ac"); // 设置声道数
        * convert.add("2");
        * convert.add("-ar"); // 设置声音的采样频率
        * convert.add("22050");
        * convert.add("-r"); // 设置帧频
        * convert.add("24");
        * convert.add("-y"); // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
        */
        convert.add(codcFilePath);
        try {
            Process videoProcess = new ProcessBuilder(convert).redirectErrorStream(true).start();
            new PrintStream(videoProcess.getInputStream()).start();
            videoProcess.waitFor();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 先用mencoder转换为avi(ffmpeg能解析的)格式
     *
     * @param mencoderPath 转码工具的存放路径
     * @param upFilePath   用于指定要转换格式的文件,要截图的视频源文件
     * @param codcAviPath 格式转换后的的文件保存路径
     * @return
     * @throws Exception
     */
    public String processAVI(String mencoderPath, String upFilePath, String codcAviPath) {
        boolean flag = false;
        List<String> commend = new ArrayList<String>();
        commend.add(mencoderPath);
        commend.add(upFilePath);
        commend.add("-oac");
        commend.add("mp3lame");
        commend.add("-lameopts");
        commend.add("preset=64");
        commend.add("-lavcopts");
        commend.add("acodec=mp3:abitrate=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=600");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add(codcAviPath);
        try {
            // 预处理进程
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.redirectErrorStream(true);
            // 进程信息输出到控制台
            Process p = builder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();// 直到上面的命令执行完，才向下执行
            return codcAviPath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> getFfmpegCommand(int type, String ffmpegPath, String oldfilepath, String outputPath)throws FFmpegException {
        List<String> command = new ArrayList<String>();
        if (type == 1) {
            command.add(ffmpegPath);
            command.add("-i");
            command.add(oldfilepath);
            command.add("-c:v");
            command.add("libx264");
            command.add("-x264opts");
            command.add("force-cfr=1");
            command.add("-c:a");
            command.add("mp2");
            command.add("-b:a");
            command.add("256k");
            command.add("-vsync");
            command.add("cfr");
            command.add("-f");
            command.add("mpegts");
            command.add(outputPath);
        } else if(type==0){
            command.add(ffmpegPath);
            command.add("-i");
            command.add(oldfilepath);
            command.add("-c:v");
            command.add("libx264");
            command.add("-x264opts");
            command.add("force-cfr=1");
            command.add("-vsync");
            command.add("cfr");
            command.add("-vf");
            command.add("idet,yadif=deint=interlaced");
            command.add("-filter_complex");
            command.add("aresample=async=1000");
            command.add("-c:a");
            command.add("libmp3lame");
            command.add("-b:a");
            command.add("192k");
            command.add("-pix_fmt");
            command.add("yuv420p");
            command.add("-f");
            command.add("mpegts");
            command.add(outputPath);
        }else{
            throw new FFmpegException("不支持当前上传的文件格式");
        }
        return command;
    }

    public static void processFfmpegCodeFormat(String ffmpegPath) {
        List<String> commend = new ArrayList<String>();
        commend.add(ffmpegPath);
        commend.add("-formats");
        BufferedReader buf = null; // 保存ffmpeg的输出结果流
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.redirectErrorStream(true);
            Process p= builder.start();
            buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = buf.readLine()) != null) {
                sb.append(line + "\n");
                continue;
            }
            p.waitFor();//这里线程阻塞，将等待外部转换进程运行成功运行结束后，才往下执行
            logger.info("【系统支持的视频编码】" + sb.toString());
        } catch (Exception e) {
            logger.error("获取失败 !");
        }
    }
    /**
     * ffmpeg将其他格式转换成FLV格式文件（未指定其他任何参数）
     * ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
     * @param srcVideoPath 视频文件(原)
     * @param tarVideoPath 视频文件(新)
     * @return
     */
    public static boolean processFfmpegOther(String ffmpegPath, String srcVideoPath,String tarVideoPath) {
        if (!checkFile(srcVideoPath)) {
            logger.error("【" + srcVideoPath + "】  不存在 !");
            return false;
        }
        List<String> commend = new java.util.ArrayList<String>();
        commend.add(ffmpegPath);
        commend.add( "-y");
        commend.add( "-i");
        commend.add(srcVideoPath);
        commend.add(tarVideoPath);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process process = builder.start();
            doWaitFor(process);
            process.destroy();
            if (!checkFile(tarVideoPath)) {
                logger.info(tarVideoPath + " is not exit! processFfmpegOther 转换不成功 !");
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.error("【" + srcVideoPath + "】processFfmpegOther 转换不成功 !");
            return false;
        }
    }

    /**
     * 等待进程处理
     * @param p
     * @return
     */
    public static int doWaitFor(Process p) {
        InputStream in = null;
        InputStream err = null;
        int exitValue = -1; // returned to caller when p is finished
        try {
            in = p.getInputStream();
            err = p.getErrorStream();
            boolean finished = false; // Set to true when p is finished
            while (!finished) {
                try {
                    while (in.available() > 0) {
                        Character c = new Character((char) in.read());
                    }
                    while (err.available() > 0) {
                        Character c = new Character((char) err.read());
                    }
                    exitValue = p.exitValue();
                    finished = true;
                } catch (IllegalThreadStateException e) {
                    Thread.currentThread();
                    Thread.sleep(500);
                }
            }
        } catch (Exception e) {
            logger.error("doWaitFor();: unexpected exception - "  + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (err != null) {
                    err.close();
                }
            } catch (IOException e) {
                logger.error("等待进程处理错误");
            }
        }
        return exitValue;
    }

    private static boolean checkFile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }

    /**
     * 判断文件的类型，从而调用不同的解析工具
     * @return filePath
     */
    private static int checkContentType(String filePath) {
        String type = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length())  .toLowerCase();
        System.out.println("=======checkContentType=====type:" + type);
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi") || type.equals("mpg") || type.equals("wmv")
                || type.equals("3gp") || type.equals("mov") || type.equals("mp4")
                || type.equals("asf") || type.equals("asx") || type.equals("flv")) {
            return 0;
        } else if (type.equals("wmv9") || type.equals("rm") || type.equals("rmvb")) {
            // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
            // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
            return 1;
        } else if (type.equals("swf")) {
            return 2;
        }
        return 9;
    }


    static class PrintStream extends Thread {
        java.io.InputStream __is = null;
        public PrintStream(java.io.InputStream is) {
            __is = is;
        }
        public void run() {
            try {
                while (this != null) {
                    int _ch = __is.read();
                    if (_ch != -1)
                        System.out.print((char) _ch);
                    else
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

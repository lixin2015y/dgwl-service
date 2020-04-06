package com.dgwl.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HadoopFileUtil {


    public static void uploadFileHdfs() throws IOException {
        //1 创建连接
        Configuration conf = new Configuration();
        //2 连接端口
        conf.set("fs.defaultFS", "hdfs://39.97.109.70:8020");
        conf.set("dfs.replication", "3");
        //3 获取连接对象
        FileSystem fs = FileSystem.get(conf);
        //本地文件上传到 hdfs
        fs.copyFromLocalFile(new Path("/tmp/cancelpayment/20191201.txt"), new Path("/test/lixin/cancelpayment"));
        fs.close();
    }


    public static void DeleteHDFSFile(String file) throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(file), conf);
        Path path = new Path(file);
//        conf.set("fs.defaultFS", "hdfs://39.97.109.70:8020");
        //查看fs的delete API可以看到三个方法。deleteonExit实在退出JVM时删除，下面的方法是在指定为目录是递归删除
        fs.delete(path, true);
        fs.close();
    }

    public static void main(String[] args) throws IOException {
        DeleteHDFSFile("hdfs://39.97.109.70:9000/test/lixin/cancelpayment/aaa.txt");
    }


    public static void WriteToHDFS(String file, List<String> lines) throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(file), conf,"hadoop");
        Path path = new Path(file);
        FSDataOutputStream out = fs.create(path);   //创建文件

        //两个方法都用于文件写入，好像一般多使用后者
        //out.writeBytes(words);
        lines.stream().forEach(line -> {
            try {
                out.write(line.getBytes("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        out.close();
        //如果是要从输入流中写入，或是从一个文件写到另一个文件（此时用输入流打开已有内容的文件）
        //可以使用如下IOUtils.copyBytes方法。
        //FSDataInputStream in = fs.open(new Path(args[0]));
        //IOUtils.copyBytes(in, out, 4096, true)        //4096为一次复制块大小，true表示复制完成后关闭流
    }


    public static String getLine(Map map, String[] key) {
        StringBuilder line = new StringBuilder();
        Arrays.stream(key).forEach((v) -> {
            line.append(map.containsKey(v) ? map.get(v).toString() + "|" : "|");
        });
        return line.toString() + "\n";
    }

}

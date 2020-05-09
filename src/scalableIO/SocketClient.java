package scalableIO;


import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class SocketClient {
    // 搭建客户端
    public static void main(String[] args) throws IOException {
        try {
            InetSocketAddress endpoint = new InetSocketAddress("127.0.0.1" , 9004);

            // 1、创建客户端Socket，指定服务器地址和端口
            // Socket socket=new Socket("127.0.0.1",5200);
            Socket socket = new Socket();//"127.0.0.1", 9004
            //设置发送逗留时间2秒 //中断后未传输数据可传输的时间（秒）,defalut false
            //socket.setSoLinger(true, 2);
            //设置InputStream上调用 read()阻塞超时时间2秒
            //socket.setSoTimeout(2000);

           //对于Socket和SeverSocket如果需要指定缓冲区大小，必须在连接之前完成缓冲区的设定。
           //设置socket发包缓冲为32k；
            socket.setSendBufferSize(32*1024);
            //设置socket底层接收缓冲为32k
            socket.setReceiveBufferSize(20);
            //关闭Nagle算法.立即发包
            socket.setTcpNoDelay(true);
           

            socket.connect(endpoint);

            System.out.println("客户端启动成功");
            // 2、获取输出流，向服务器端发送信息
            // 向本机的52000端口发出客户请求
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 由系统标准输入设备构造BufferedReader对象
            //PrintWriter write = new PrintWriter(socket.getOutputStream());
            BufferedOutputStream write = new BufferedOutputStream(socket.getOutputStream());
            // 由Socket对象得到输出流，并构造PrintWriter对象
            //3、获取输入流，并读取服务器端的响应信息
            //        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 由Socket对象得到输入流，并构造相应的BufferedReader对象



           byte[] buffer = new byte[1024];
           BufferedInputStream in = new BufferedInputStream(new FileInputStream("g://tokens.txt"));
           int length = 0;
           while ((length=in.read(buffer))>0)
           {
               write.write(buffer,0,length);
               write.flush();
           }


            String readline;
            readline = br.readLine(); // 从系统标准输入读入一字符串
            while (!readline.equals("end")) {
                // 若从标准输入读入的字符串为 "end"则停止循环
                //write.println(readline);
                // 将从系统标准输入读入的字符串输出到Server
                write.flush();
                // 刷新输出流，使Server马上收到该字符串
                System.out.println("Client:" + readline);
                // 在系统标准输出上打印读入的字符串
                //              System.out.println("Server:" + in.readLine());
                // 从Server读入一字符串，并打印到标准输出上
                readline = br.readLine(); // 从系统标准输入读入一字符串
            } // 继续循环



            //4、关闭资源
            write.close(); // 关闭Socket输出流
             in.close(); // 关闭Socket输入流
            socket.close(); // 关闭Socket
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);// 出错，打印出错信息
        }
    }

}
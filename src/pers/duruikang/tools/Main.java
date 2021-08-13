package pers.duruikang.tools;

import java.io.IOException;

/**
 * @author 杜瑞康
 *2020年8月15日
 */
public class Main {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TXTtoJPG in = new TXTtoJPG();//编码类，用于将输入的txt编码到图片的像素
		JPGtoTXT ou = new JPGtoTXT();//解码类，用于将输入的png解码为原来的txt
		try {
			in.Do("E:/input.txt","E:/my.png");//第一个参数：输入txt文件的路径
											  //第二个参数：输出png文件的路径
			System.out.println("编码完成");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.err.println("编码输入文件路径错误");
			e.printStackTrace();
		}
		
//		try {
//			ou.Do("E:/my.png","E:/output.txt");//第一个参数：输入png文件的路径
//											   //第二个参数：输出txt文件的路径
//			System.out.println("解码完成");
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			System.err.println("解码输入文件路径错误");
//			e.printStackTrace();
//		}
	}
}
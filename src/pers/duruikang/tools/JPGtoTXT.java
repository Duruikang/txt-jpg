package pers.duruikang.tools;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author 杜瑞康
 *2020年8月15日
 */
public class JPGtoTXT {
	/*
	 * 1080*960
	 * 
	 */
	final int width = 1080;
	final int height = 960;
	int i=0;//width
	int j=0;//height
	
	
	public void Do(String png_path,String txt_path) throws IOException {
		BufferedImage src = ImageIO.read(new File(png_path));
		StringBuffer sb = new StringBuffer();
		File f;
		FileWriter fw;
		BufferedWriter bw;
		int unicode = 0;
		for(i=0;i<width;i++) {
			for(j=0;j<height;j++) {
				unicode = this.getcode(src);
				if(unicode == 0) {
					break;
				}
				char letter = (char)unicode;//对数字进行char的强制类型转换即可得到对应字符
				sb.append(letter);
			}
		}
		f = new File(txt_path);
		fw = new FileWriter(f);
		bw = new BufferedWriter(fw);
		bw.write(sb.toString());
		bw.close();
	}
	public int getcode(BufferedImage src) {
		int pixel = src.getRGB(i,j);
		int []rgb = new int[4];
		int ans;
		//依次提取RGB中的Alhpa,Red,Green,Blue分量
		rgb[0] = (pixel & 0xff000000)>>24;//屏蔽低位，并移位到最低位,前两个分量其实用不到
	    rgb[1] = (pixel & 0xff0000) >> 16;
	    rgb[2] = (pixel & 0xff00) >> 8;
	    rgb[3] = (pixel & 0xff);
	    ans = (rgb[2]<<8|rgb[3]);
		return ans;
	}
}

package pers.duruikang.tools;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author 杜瑞康
 *2020年8月15日
 */
public class TXTtoJPG {
	/*
	 * 1080*960
	 * 
	 */
	
	final int width = 1080;
	final int height = 960;
	int i=0;//width
	int j=0;//height
	
	
	public void Do(String txt_path,String png_path) throws IOException{
		//BufferedImage src = ImageIO.read(new File("e:\\my.png"));
		BufferedImage src = new BufferedImage(width ,height,2);
		String line;
		FileReader fr;
		int gb;
		BufferedReader br = null;
		try {
			fr = new FileReader(txt_path);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			System.err.println("FileNotFound");
		}
		line = br.readLine();
		while(line!=null) {
			for(int k=0;k<line.length();k++){
				gb = Integer.parseInt(IntToHex.tenToSix(Integer.toHexString(line.charAt(k))));
				this.setRGB(src, 255, (gb&0xFF00)>>8, gb&0xFF, 255);//参数分别为：R,G,B,Alpha
			}
			line = br.readLine();
		}
		ImageIO.write(src, "PNG", new File(png_path));
	}
	public void setRGB(BufferedImage src,int R,int G,int B,int alpha) {
		src.setRGB(i, j,((alpha<<24)|((R)<<16)|(G<<8)|(B)));
		j++;
		if(j==height) {
			j=0;
			i++;
		}
		if(i>=width) {
			System.err.println("像素不够");
		}
	}
}

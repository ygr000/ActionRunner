package utils;

import javax.imageio.ImageIO;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Location:utils
 * @Auth:ygr
 * @DATE:2020/8/4 14:24
 * <p>
 * .                ,]++++++++]`
 * .              ]++o**=++++++++\`
 * .          ,+++++++o\]**[*=++++\
 * .         ++++++++++++++++oo++++^
 * .        =+++++++++++++++++++++++
 * .       =+/`,++o++oo++++++++++++++\
 * .        + +\++\****\++=+++++++\++++
 * .           \\ \\//`*]o+++++oo/ /+++`
 * .           ,+`   [\++++++[`,[+\=+++^
 * .           +`        ++]]++    ,++^
 * .          =+         \`         +[
 * .           +`         ,+`
 * .            +`  ]/+++++\/+
 * .             =+]=^
 * .            *,[[
 */
public class Picture2Strings {
static String[] grepChar=new String[]{"M","$","#","N","H","Q","O","C","?","7",">","!",":","–",";","."," "};
static String[] grepCharRev;
static{
    grepCharRev=new String[grepChar.length];
    int length=grepChar.length;
    for(int i=0;i<length;i++){
        grepCharRev[i]=grepChar[length-i-1];
    }
}
/*public static List<String> run(String imagePath) {
    int r;
    int g;
    int b;
    int minx = 0;
    int miny = 0;
     int charWidth=Integer.parseInt(ReadProperties.getValue("charWidth"));
     int charHeight = Integer.parseInt(ReadProperties.getValue("charHeight"));;
     List<String> list=new ArrayList<>();
    try {
        File file = new File(imagePath);
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();//图片宽度
        int height = image.getHeight();//图片高度
        int wx=(width/charWidth)+1;
        int hx=(height/charHeight)+1;

        for (int j = miny; j < height; j=j+(hx)) {

            StringBuffer sb=new StringBuffer();
            for (int i = minx; i < width; i=i+(wx)) {


                int pixel = image.getRGB(i, j);
                r = (pixel & 0xff0000) >> 16;
                g = (pixel & 0xff00) >> 8;
                b = (pixel & 0xff);
                float gray=r * 0.3f + g * 0.59f + b * 0.11f;

                if (gray < 15) {
                    sb.append(grepChar[0]);
                } else if (15 <= gray && gray < 30) {
                    sb.append(grepChar[1]);
                }else if (30 <= gray && gray < 45) {
                    sb.append(grepChar[2]);
                } else if (45 <= gray && gray < 60) {
                    sb.append(grepChar[3]);
                }else if (60 <= gray && gray < 75) {
                    sb.append(grepChar[4]);
                } else if (75 <= gray && gray < 90) {
                    sb.append(grepChar[5]);
                } else if (90 <= gray && gray < 105) {
                    sb.append(grepChar[6]);
                }else if (105 <= gray && gray < 120) {
                    sb.append(grepChar[7]);
                }else if (120 <= gray && gray < 135) {
                    sb.append(grepChar[8]);
                }else if (135 <= gray && gray < 150) {
                    sb.append(grepChar[9]);
                }else if (150 <= gray && gray < 165) {
                    sb.append(grepChar[10]);
                }else if (165 <= gray && gray < 180) {
                    sb.append(grepChar[11]);
                }else if (180 <= gray && gray < 195) {
                    sb.append(grepChar[12]);
                }else if (195 <= gray && gray < 210) {
                    sb.append(grepChar[13]);
                }else if (210 <= gray && gray < 235) {
                    sb.append(grepChar[14]);
                }else if (235 <= gray && gray < 250) {
                    sb.append(grepChar[15]);
                }else{
                    sb.append(grepChar[16]);
                }
            }
            System.out.println(sb.toString());
            list.add(sb.toString());
        }


    } catch (IOException e) {
        e.printStackTrace();
    }

    // convert2Txt("d:/xxx.txt",list);
    return list;
}*/
public static List<String> run(String imagePath) {
    int r;
    int g;
    int b;
    int minx = 0;
    int miny = 0;
    int charWidth=Integer.parseInt(ReadProperties.getValue("charWidth"));
    int charHeight = Integer.parseInt(ReadProperties.getValue("charHeight"));;
    List<String> list=new ArrayList<>();
    try {
        File file = new File(imagePath);
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();//图片宽度
        int height = image.getHeight();//图片高度
        int wx=(width/charWidth)+1;
        int hx=(height/charHeight)+1;
        StringBuffer sb=new StringBuffer();
        String[] grepChar;
        String midu=ReadProperties.getValue("midu");
        if(midu.equals("b2s")){
            grepChar=Picture2Strings.grepChar;
        }else{
            grepChar=Picture2Strings.grepCharRev;
        }
        for (int j = miny; j < height; j=j+(hx)) {


            for (int i = minx; i < width; i=i+(wx)) {


                int pixel = image.getRGB(i, j);
                r = (pixel & 0xff0000) >> 16;
                g = (pixel & 0xff00) >> 8;
                b = (pixel & 0xff);
                float gray=r * 0.3f + g * 0.59f + b * 0.11f;

                if (gray < 15) {
                    sb.append(grepChar[0]);
                } else if (15 <= gray && gray < 30) {
                    sb.append(grepChar[1]);
                }else if (30 <= gray && gray < 45) {
                    sb.append(grepChar[2]);
                } else if (45 <= gray && gray < 60) {
                    sb.append(grepChar[3]);
                }else if (60 <= gray && gray < 75) {
                    sb.append(grepChar[4]);
                } else if (75 <= gray && gray < 90) {
                    sb.append(grepChar[5]);
                } else if (90 <= gray && gray < 105) {
                    sb.append(grepChar[6]);
                }else if (105 <= gray && gray < 120) {
                    sb.append(grepChar[7]);
                }else if (120 <= gray && gray < 135) {
                    sb.append(grepChar[8]);
                }else if (135 <= gray && gray < 150) {
                    sb.append(grepChar[9]);
                }else if (150 <= gray && gray < 165) {
                    sb.append(grepChar[10]);
                }else if (165 <= gray && gray < 180) {
                    sb.append(grepChar[11]);
                }else if (180 <= gray && gray < 195) {
                    sb.append(grepChar[12]);
                }else if (195 <= gray && gray < 210) {
                    sb.append(grepChar[13]);
                }else if (210 <= gray && gray < 235) {
                    sb.append(grepChar[14]);
                }else if (235 <= gray && gray < 250) {
                    sb.append(grepChar[15]);
                }else{
                    sb.append(grepChar[16]);
                }
            }
            list.add(sb.toString());
            sb.append("\r\n");
        }
        for (int i = list.size(); i <= charHeight; i++) {
            sb.append("\r\n");
        }
        System.out.println(sb.toString());

    } catch (IOException e) {
        e.printStackTrace();
    }

    // convert2Txt("d:/xxx.txt",list);
    return list;
}
    public static void convert2Txt(String path,List<String> list){
        File file =new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        try ( FileWriter fileWriter=new FileWriter(file)){

            for(String s:list){
                fileWriter.write(s);
                fileWriter.write("\r\n");
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Picture2Strings.run("d:/tupian/xx.jpg");
    }
}

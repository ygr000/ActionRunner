package utils;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Location:utils
 * @Auth:ygr
 * @DATE:2020/7/6 17:54
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
public class ReadProperties {
   private static Properties properties = new Properties();
    static {
        try {
            //读取配置文件
            InputStream is = ReadProperties.class.getClassLoader().getResourceAsStream("dev.properties");
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public  static String getValue(String key){
        String value=properties.getProperty(key);
        return value;
    }
    public  static void setValue(String key,String value){
        properties.setProperty(key,value);
    }
    public static void main(String[] args) {
        String parentPath="d:/tupian/shuaishou";
        File parentFile=new File(parentPath);
        if(parentFile.isDirectory()){
            String[] names= parentFile.list();
            StringBuffer sb=new StringBuffer();
            for(String name:names){
                if(name.lastIndexOf(".png")>=0||name.lastIndexOf(".jpg")>=0||name.lastIndexOf(".jpeg")>=0) {
                    sb.append(parentPath).append("/").append(name).append(";");
                }
            }
            if(sb.length()>0){
                sb.substring(0,sb.length()-1);
            }
            System.out.println(sb.toString());        }
    }
}

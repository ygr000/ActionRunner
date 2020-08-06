import utils.Picture2Strings;
import utils.ReadProperties;

import java.io.*;
import java.util.List;

/**
 * @Location:PACKAGE_NAME
 * @Auth:ygr
 * @DATE:2020/8/4 11:38
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
public class mainAction {
    public static void main(String[] args) {
        if(args!=null&&args.length>0){
            ReadProperties.setValue("parentPath",args[0]);
            ReadProperties.setValue("stopMs",args[1]);
            ReadProperties.setValue("midu",args[2]);
         //   System.out.println("图片路径："+ReadProperties.getValue("parentPath")+"  "+"停止时间"+ReadProperties.getValue("stopMs"));
        }
        setPathAndMs();
        NoClearMv();
    }

    public static void setPathAndMs(){
        String parentPath=ReadProperties.getValue("parentPath");
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
            ReadProperties.setValue("picturePaths",sb.toString());
        }
    }
    /**
     * 通过判断是否满足屏幕高度进行填充
     */

    public static void NoClearMv(){
        String paths= ReadProperties.getValue("picturePaths");
        Integer charHeight= Integer.parseInt(ReadProperties.getValue("charHeight"));
        String path[]=paths.split(";");
        var index=0;

        for(int i=0;i<=charHeight-1;i++){

            System.out.println(" "+i+"  "+(i<path.length?path[i]:0));
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                List<String> list = Picture2Strings.run(path[index++]);
//                for (int i = list.size(); i <= charHeight; i++) {
//                    System.out.println(" " + i);
//                }
                if (index == path.length) {
                    index = 0;
                }
                Thread.sleep(Long.parseLong(ReadProperties.getValue("stopMs")));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 通过clear的形式清屏
     * */
    public static void clearMv(){
        Runtime runtime = Runtime.getRuntime();
        String envirment= ReadProperties.getValue("envirment");
        String paths= ReadProperties.getValue("picturePaths");
        String path[]=paths.split(";");
        String[] cmd = new String[]{"sh", "-c", "clear"};
        if(envirment.equals("linux")){

        }else{
            cmd = new String[]{"cmd", "/c", "cls"};
        }
        var index=0;
        while (true)
            try {
                Process process= runtime.exec(cmd);
                process.waitFor();
                InputStream inputStream = process.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);
                InputStream errorStream = process.getErrorStream();
                InputStreamReader esr = new InputStreamReader(errorStream);

                BufferedReader nomalReader = new BufferedReader(isr);
                BufferedReader errorReader = new BufferedReader(esr);
                String line = null;
                while ((line = nomalReader.readLine()) != null) {
                    System.out.println(new String(line.getBytes(),"GBK"));;
                }
                while ((line = errorReader .readLine()) != null) {
                    System.err.println(line);;
                }

                List<String> list=Picture2Strings.run(path[index++]);
                if(index==path.length){
                    index=0;
                }
                Thread.sleep(Long.parseLong(ReadProperties.getValue("stopMs")));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}




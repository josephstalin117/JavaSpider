package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stalin on 12/12/2014.
 */
public class Spider {

    /*
     * 获取网页内容
     */
    public String getHtmlContent(String htmlurl) throws IOException {
        URL url;
        String temp;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(htmlurl);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream(), "utf-8"));// 读取网页全部内容
            while ((temp = in.readLine()) != null) {
                sb.append(temp);
            }
            in.close();
        } catch (final MalformedURLException me) {
            System.out.println("wrong url format");
            me.getMessage();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /*
     * 获取Rectno号列表
     */
    public String[] getListRectno(String s) {
        String rectno = "";
        String regex = "id=\"hiddenrectno\" value=\"(.*?)\" />";
        rectno = regexTools(s, regex, 25, 5);
        String[] rectnoStringList = rectno.split(",");
        return rectnoStringList;
    }

    /*
     * 获取新闻标题列表
     */
    public String[] getListTitle(String s) {
        String title = "";
        String regex = "id=\"hiddentitle\" value=\"(.*?)。\" />";
        // get the real number
        title = regexTools(s, regex, 24, 6);
        String[] titleList = title.split("。");
        return titleList;
    }

    /*
     * 获取新闻内容
     */
    public String getContent(String s) {
        String content = "";
        String regex = "id=\"hidden\" value=\"(.*?)\" />";
        content = regexTools(s, regex, 19, 4);
        return content;
    }

    /*
     * 获取新闻标题
     */
    public String getTitle(String s) {
        String regex = "id=\"hiddentitle\" value=\"(.*?)\" />";
        String title = regexTools(s, regex, 24, 4);
        return title;
    }

    /*
     * 获取列表内容
     */
    public TreeMap<String, String> getListMap(String[] rectno, String[] title) {

        TreeMap<String, String> tm = new TreeMap<String, String>();

        try {
            if (rectno.length == title.length) {

                for (int i = 0; i < rectno.length; i++) {
                    tm.put(rectno[i], title[i]);
                }
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            System.out.print("news' length is not compare to titles' length");
        }

        return tm;
    }

    /*
     * 获取当前首页期数
     */
    public String getLatest(String s) {
        String regex = "<img src=\"picture/(.*?).jpg\"";
        String Lastest = regexTools(s, regex, 22, 7);
        return Lastest;
    }

    /*
     * 正则工具
     *
     * @content 需要解析的内容
     *
     * @regex 正则表达式
     *
     * @begin 需要分隔的前字符
     *
     * @end 需要分隔的后字符
     */
    private static String regexTools(String content, String regex, int begin,
                                     int end) {
        String s = "";
        Pattern pa = Pattern.compile(regex);
        Matcher ma = pa.matcher(content);
        try {
            if (ma.find()) {
                s = ma.group();
                s = s.substring(begin, s.length() - end);
                return s;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.print("no content");
        }
        return null;
    }

    private static String replaceTools(String content, String regex) {
        String s = content.replace(content, "");
        return s;
    }
}

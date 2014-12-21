package tools;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class SpiderTest {

    Spider s;
    String c = "";

    String[] t;
    String[] l;

    @Before
    public void setUp() throws Exception {
        s = new Spider();
    }

    /**
     * 获得相关的网站内容
     */
    @Test
    public void testGetHtmlContent() {
        try {
            c = s.getHtmlContent("http://xb.sdibt.edu.cn/search.aspx?id=2&keyword=35");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        assertNotNull(c);
    }

    /**
     * 获取编号列表
     */
    @Test
    public void testGetListRectno() {
        try {
            c = s.getHtmlContent("http://xb.sdibt.edu.cn/search.aspx?id=2&keyword=35");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        l = s.getListRectno(c);
//        for (int i = 0; i < l.length; i++) {
//            System.out.println(l[i]);
//        }
        assertNotNull(l);
    }

    /**
     * 获取题目编号
     */
    @Test
    public void testGetListTitle() {
        try {
            c = s.getHtmlContent("http://xb.sdibt.edu.cn/search.aspx?id=2&keyword=35");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        t = s.getListTitle(c);
//        for (int i = 0; i < t.length; i++) {
//            System.out.println(t[i]);
//        }
        assertNotNull(t);
    }

    /**
     * 获取内容
     */
    @Test
    public void testGetContent() {
        try {
            c = s.getHtmlContent("http://xb.sdibt.edu.cn/contentpage.aspx?rectno=2013370101");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String w = "";
        w = s.getContent(c);
        System.out.println(w);
    }

    @Test
    public void testGetTitle() {
        try {
            c = s.getHtmlContent("http://xb.sdibt.edu.cn/contentpage.aspx?rectno=2013370103");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String t = "";
        t = s.getTitle(c);
        assertEquals("盛国军率团结束对美国纽约理工大学访问", t);
    }

    @Test
    public void testGetListMap() {
        try {
            c = s.getHtmlContent("http://xb.sdibt.edu.cn/search.aspx?id=2&keyword=35");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] l = s.getListRectno(c);

        // 获取题目列表
        String[] t = s.getListTitle(c);
        TreeMap tm = new TreeMap();
        tm = s.getListMap(l, t);
        assertNotNull(tm);
        // 使用Iterator遍历HashMap
//        Iterator it = tm.keySet().iterator();
//        while (it.hasNext()) {
//            String key = (String) it.next();
//            System.out.println("key:" + key + "  value:" + tm.get(key));
//        }
    }

    @Test
    public void testGetLatest() {
        try {
            c = s.getHtmlContent("http://xb.sdibt.edu.cn/");

        } catch (IOException e) {
            e.printStackTrace();
        }
        String l = "";
        l = s.getLatest(c);
        assertEquals(l, "37");
    }

}

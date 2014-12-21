package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class NewsDaoImplTest {

    NewsDaoImpl ndi;

    @Before
    public void setUp() throws Exception {
        ndi = new NewsDaoImpl();
    }

    /**
     * Test getAllNewsRectnoByIssue
     */
    @Test
    public void testGetAllNewsRectnoByIssue() {
        ArrayList<News> a = new ArrayList<News>();
        a = ndi.getAllNewsRectnoByIssue("36");
        Iterator<News> iter = a.iterator();
        while (iter.hasNext()) {
            News item = iter.next();
        }
    }

    /**
     * Test getNewsByRestno
     */
    @Test
    public void testGetNewsByRestno() {
        News nw = ndi.getNewsByRestno("2013370101");
        assertEquals("3562名学生喜获国家奖助学金", nw.getTitle());
    }

    /**
     * Test getAllNewsRectnoByAuthor
     */
    @Test
    public void testGetNewsByAuthor() {
        ArrayList<News> a = new ArrayList<News>();
        a = ndi.getNewsByAuthor("李");

        Iterator<News> iter = a.iterator();
        while (iter.hasNext()) {
            News item = iter.next();
        }
    }

    /**
     * Test getAllNewsRectnoByTitle
     */
    @Test
    public void testGetNewsByTitle() {
        ArrayList<News> a = new ArrayList<News>();
        a = ndi.getNewsByTitle("3562名学生喜获国家奖助学金");
        assertNotNull(a);
    }

    /**
     * 测试最新的新闻
     */
    @Test
    public void testGetLatestNews() {
        ArrayList<News> a = new ArrayList<News>();
        a = ndi.getLatestNews();

        Iterator<News> iter = a.iterator();
        while (iter.hasNext()) {
            News item = iter.next();
        }
    }

}

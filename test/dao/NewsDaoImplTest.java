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
//            System.out.println(item.toString());
        }
    }

    /**
     * Test return null of getAllNewsRectnoByIssue
     */
    @Test
    public void testGetAllNewsRectnoByIssueNull() {
        ArrayList<News> a = new ArrayList<News>();
        a = ndi.getAllNewsRectnoByIssue("0");
        assertNull(a);
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
        a = ndi.getNewsByAuthor("宁");
        Iterator<News> iter = a.iterator();
        while (iter.hasNext()) {
            News item = iter.next();
//            System.out.println(item.toString());
        }
    }

    /**
     * Test return null getAllNewsRectnoByAuthor
     */
    @Test
    public void testGetNewsByAuthorNull() {
        ArrayList<News> a = new ArrayList<News>();
        a = ndi.getNewsByAuthor("hehe");
        assertNull(a);
    }

    /**
     * Test getAllNewsRectnoByTitle
     */
    @Test
    public void testGetNewsByTitle() {
        ArrayList<News> a = new ArrayList<News>();
        a = ndi.getNewsByTitle("好");
        assertNotNull(a);
    }

    /**
     * Test the Null getAllNewsRectnoByTitle
     */
    @Test
    public void testGetNewsByTitleNull() {
        ArrayList<News> a = new ArrayList<News>();
        a = ndi.getNewsByTitle("hehe");
        assertNull(a);
    }


    /**
     * test the latest News
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

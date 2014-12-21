package tools;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UrlCuterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetArticleUrl() {
		assertEquals(
				"http://xb.sdibt.edu.cn/contentpage.aspx?rectno=2013370103",
				UrlCuter.getInstance().getArticleUrl("2013370103"));
	}

	@Test
	public void testGetTitleListUrl() {
		assertEquals("http://xb.sdibt.edu.cn/search.aspx?id=0&keyword=li",
				UrlCuter.getInstance().getTitleListUrl("li"));
	}

	@Test
	public void testGetAuthorList() {
		assertEquals("http://xb.sdibt.edu.cn/search.aspx?id=1&keyword=宁",
				UrlCuter.getInstance().getAuthorList("宁"));
	}

	@Test
	public void testGetIssueListUrl() {
		assertEquals("http://xb.sdibt.edu.cn/search.aspx?id=2&keyword=36",
				UrlCuter.getInstance().getIssueListUrl("36"));
	}

	@Test
	public void testGetHomePage() {
		assertEquals("http://xb.sdibt.edu.cn/", UrlCuter.getInstance()
				.getHomePage());
	}

}

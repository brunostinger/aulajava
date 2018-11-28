package com.web.commons.teste;

import org.junit.Test;

import com.web.commons.SuperUtil;

import junit.framework.Assert;

public class SuperUtilTeste {

	@SuppressWarnings("deprecation")
	@Test
	public void escapeHTMLTest() {
		
		String escapedHTML=SuperUtil.escapeHTML("<script> alert(1); </script>");
		String expected="&lt;script&gt; alert(1); &lt;/script&gt;";
		Assert.assertEquals(expected, escapedHTML);
	}
}

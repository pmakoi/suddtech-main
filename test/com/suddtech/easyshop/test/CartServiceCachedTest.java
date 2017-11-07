package com.suddtech.easyshop.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suddtech.easyshop.dto.Item;
import com.suddtech.easyshop.service.CartService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/testContext.xml" })

public class CartServiceCachedTest {
	 @Autowired
	    private CartService cartService;

	    /**
	     * This is NOT unit test but rather an integration suite that proves that
	     * our business logic works as expected using actual db and all the wiring.
	     */
	    @Test
	    public void testCartCRUDOperationsIntegrationTest() throws Exception {

	        List<Item> items;

	        // Check empty initially
	        items = cartService.getItemsInCart(1L);

	        assertNotNull(items);
	        assertTrue(items.isEmpty());

	        // Add one item and check contents of cart
	        cartService.addToCart(1L, "ABC");
	        items = cartService.getItemsInCart(1L);

	        assertNotNull(items);
	        assertFalse(items.isEmpty());
	        assertEquals(1, items.size());
	        assertEquals("ABC", items.get(0).getArticleNo());
	        assertEquals(new BigDecimal(1).compareTo(items.get(0).getQuantity()), 0);

	        // Add same item and check contents of cart
	        cartService.addToCart(1L, "ABC");
	        items = cartService.getItemsInCart(1L);

	        assertNotNull(items);
	        assertFalse(items.isEmpty());
	        assertEquals(1, items.size());
	        assertEquals("ABC", items.get(0).getArticleNo());
	        assertEquals(new BigDecimal(2).compareTo(items.get(0).getQuantity()), 0);

	        // Add another item and check contents of cart
	        cartService.addToCart(1L, "DEF");
	        items = cartService.getItemsInCart(1L);

	        assertNotNull(items);
	        assertFalse(items.isEmpty());
	        assertEquals(2, items.size());
	        // we re-map the items in list to have deterministic assertions
	        final Map<String, Item> byArticle = new HashMap<String, Item>();
	        for (final Item item : items) {
	            byArticle.put(item.getArticleNo(), item);
	        }
	        // deterministic assertions by article no
	        assertTrue(byArticle.containsKey("ABC"));
	        assertEquals(new BigDecimal(2).compareTo(byArticle.get("ABC").getQuantity()), 0);
	        assertTrue(byArticle.containsKey("DEF"));
	        assertEquals(new BigDecimal(1).compareTo(byArticle.get("DEF").getQuantity()), 0);

	        // Remove one item
	        cartService.removeFromCart(1L, "DEF");
	        items = cartService.getItemsInCart(1L);

	        assertNotNull(items);
	        assertFalse(items.isEmpty());
	        assertEquals(1, items.size());
	        assertEquals("ABC", items.get(0).getArticleNo());
	        assertEquals(new BigDecimal(2).compareTo(items.get(0).getQuantity()), 0);

	        // Remove last item
	        cartService.removeFromCart(1L, "ABC");
	        items = cartService.getItemsInCart(1L);

	        assertNotNull(items);
	        assertTrue(items.isEmpty());

	    }

	    /**
	     * Since we already established that the CRUD works assertions in this test are specific
	     * to making sure that we get the cached list back, so we do not need to check individual elements.
	     *
	     * @throws Exception
	     */
	    @Test
	    public void testCachingIsWorking() throws Exception {

	        // Check empty initially
	        List<Item> items1st = cartService.getItemsInCart(2L);
	        assertEquals(0, items1st.size());

	        // add cart item
	        cartService.addToCart(2L, "ABC");
	        List<Item> items2nd = cartService.getItemsInCart(2L);
	        assertEquals(1, items2nd.size());

	        // now we can ask for the cart contents again and assert that is it same instance of list
	        List<Item> items3rd = cartService.getItemsInCart(2L);
	        assertSame(items3rd, items2nd);

	        // we expect that adding items will evict cache
	        cartService.addToCart(2L, "ABC");
	        List<Item> items4th = cartService.getItemsInCart(2L);
	        assertEquals(1, items4th.size());
	        // but these list should be different now
	        assertNotSame(items2nd, items4th);

	        // now check the cart contents again which should be cached object from 4th call
	        List<Item> items5th = cartService.getItemsInCart(2L);
	        assertSame(items4th, items5th);

	        // make sure that after adding to a different cart we still have cached version of list for 2L
	        cartService.addToCart(1L, "ABC");
	        List<Item> items6th = cartService.getItemsInCart(2L);
	        assertSame(items4th, items6th);


	    }

}

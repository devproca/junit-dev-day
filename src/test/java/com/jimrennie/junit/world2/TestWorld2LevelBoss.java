package com.jimrennie.junit.world2;

import com.jimrennie.junit.world2.boss.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 2.boss
 *
 * {@link ShoppingCart} needs some tests!!
 *
 * Without modifying any classes outside this class write tests specified below on the {@link ShoppingCart} class.
 */
@ExtendWith(MockitoExtension.class)
class TestWorld2LevelBoss {

	@Mock
	private AuditTrail auditTrail;
	@Mock
	private PriceProvider priceProvider;
	@InjectMocks
	private ShoppingCart shoppingCart;
	/**
	 * 2.boss.1
	 *
	 * Test that the {@link ShoppingCart#addItem(String)} correctly fetches and passes the correct itemName from
	 * the {@link PriceProvider}.
	 */
	@Test
	void testAddItem_oneItemAdded_ExpectPriceProviderToProvideExpectedPrice() {
		String itemName = "potato";
		when(priceProvider.getPrice(any())).thenReturn(5D);

		shoppingCart.addItem(itemName);

		verify(priceProvider).getPrice("potato");
		assertEquals(5D, shoppingCart.getPriceTotal(itemName));
	}

	/**
	 * 2.boss.2
	 *
	 * Test that all added items are returned by {@link ShoppingCart#getItemNames()}
	 */
	@Test
	void testGetItemNames_TwoItemsAdded_ExpectBothReturned() {
		shoppingCart
				.addItem("banana")
				.addItem("pajama");

		Set<String> itemNames = shoppingCart.getItemNames();

		assertIterableEquals(Set.of("banana", "pajama"), itemNames);
	}

	/**
	 * 2.boss.3
	 *
	 * Test that the {@link ShoppingCart#getPriceTotal()} returns the correct amount when multiple items
	 */
	@Test
	void testGetPriceTotal_TwoItemsWithDifferentPrices_ExpectTotalToBeCorrect() {
		when(priceProvider.getPrice(any())).thenReturn(3D).thenReturn(2D);
		shoppingCart
				.addItem("one sock")
				.addItem("hat");

		double total = shoppingCart.getPriceTotal();

		assertEquals(5D, total);
	}

	/**
	 * 2.boss.4
	 *
	 * Test that when {@link ShoppingCart#addItem(String)} is called, {@link AuditTrail#audit(AuditType)} is called with
	 * {@link AuditType#ADD}
	 */
	@Test
	void testAddItem_OneItem_ExpectAuditTrailToBeCalled() {
		shoppingCart.addItem("bacon pancakes");

		verify(auditTrail).audit(AuditType.ADD);
	}

}

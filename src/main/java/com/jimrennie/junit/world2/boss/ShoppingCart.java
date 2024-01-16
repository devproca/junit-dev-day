package com.jimrennie.junit.world2.boss;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCart {

	private final PriceProvider priceProvider;
	private final AuditTrail auditTrail;
	private final List<Item> items = new ArrayList<>();

	public ShoppingCart(PriceProvider priceProvider, AuditTrail auditTrail) {
		this.priceProvider = priceProvider;
		this.auditTrail = auditTrail;
	}

	public ShoppingCart addItem(String itemName) {
		auditTrail.audit(AuditType.ADD);

		double price = priceProvider.getPrice(itemName);
		items.add(new Item(itemName, price));
		return this;
	}

	public Set<String> getItemNames() {
		auditTrail.audit(AuditType.LIST);

		return items
				.stream()
				.map(Item::name)
				.collect(Collectors.toUnmodifiableSet());
	}

	public double getPriceTotal(String itemName) {
		auditTrail.audit(AuditType.SUM);

		return items
				.stream()
				.filter(item -> itemName.equals(item.name()))
				.mapToDouble(Item::price)
				.sum();
	}

	public double getPriceTotal() {
		auditTrail.audit(AuditType.SUM);

		return items
				.stream()
				.mapToDouble(Item::price)
				.sum();
	}

	private record Item(String name, double price) {
	}

}

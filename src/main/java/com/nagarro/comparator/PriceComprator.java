package com.nagarro.comparator;

import java.util.Comparator;
import com.nagarro.entities.Cloth;

public class PriceComprator implements Comparator<Cloth> {
	@Override
	public int compare(Cloth o1, Cloth o2) {
		return (int) (o1.getPrice() - o2.getPrice());// inc
	}
}

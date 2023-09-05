package com.nagarro.comparator;

import java.util.Comparator;

import com.nagarro.entities.Cloth;

public class RatingComparator implements Comparator<Cloth> {
	@Override
	public int compare(Cloth o1, Cloth o2) {
		return (int) (o2.getRating() - o2.getRating());// dec
	}
}

package com.manit.krungsri.savestateapp.bus;

import com.squareup.otto.Bus;

public class BusProvider {
	private static Bus BUS = new Bus();
	
	public static Bus getInstance() {
		return BUS;
	}
}

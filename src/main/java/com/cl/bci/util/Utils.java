package com.cl.bci.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String dateFormat() {

		Date dt = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

		return sdf.format(dt);

	}

}

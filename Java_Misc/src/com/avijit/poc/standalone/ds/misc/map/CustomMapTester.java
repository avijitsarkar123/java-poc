package com.avijit.poc.standalone.ds.misc.map;


public class CustomMapTester {
	public static void main(String[] args) {
		
		CustomMap<Integer, String> indianNobelLaureates = new CustomMap<Integer, String>();
		indianNobelLaureates.put(1902, "Ronald Ross");
		indianNobelLaureates.put(1907, "Rudyard Kipling");
		indianNobelLaureates.put(1913, "Rabindranath Tagore");
		indianNobelLaureates.put(1930, "C.V. Raman");
		indianNobelLaureates.put(1968, "Har Gobind Khorana");
		indianNobelLaureates.put(1979, "Mother Teresa");
		indianNobelLaureates.put(1983, "Subrahmanyan Chandrasekhar");
		indianNobelLaureates.put(1998, "Amartya Sen");
		indianNobelLaureates.put(2001, "VS Naipaul");
		indianNobelLaureates.put(2009, "Venkatraman Ramakrishnan");
	 
		System.out.println(indianNobelLaureates);
	 
		System.out.println("Get the winner for 2009 : " + indianNobelLaureates.get(2009));
		System.out.println("Get the winner for 1968 : " + indianNobelLaureates.get(1968));
		System.out.println("Get the winner for 2016 : " + indianNobelLaureates.get(2016));
	}
}

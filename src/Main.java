
public class Main {

	public static void main(String[] args) {

		printBonusDatesBetween(2010, 2015);
		System.out.println("***");
		printBonusDatesBetween(9999, 999);
	}

	static void printBonusDatesBetween(int fromYear, int toYear) {

		if (fromYear < 1 || toYear > 9999 || toYear <= fromYear) {
			System.out.println("Check years: \nfirst year must be more than 0; \nlast year must be not more than 9999;"
					+ " \nand first year must be smaller than last year");
		} else {

			for (int i = fromYear; i < toYear; i++) {
				int firstPart = i / 100;
				int secondPart = i % 100;
				if (mirror(firstPart) > 31 || mirror(secondPart) > 12) {
					continue;
				}
				if (mirror(firstPart) > 30 && thirtyDayMonth(mirror(secondPart))) {
					continue;
				}
				if (mirror(firstPart) > 28 && mirror(secondPart) == 2) {
					continue;
				}

				System.out.printf("%02d%02d-%02d-%02d", firstPart, secondPart, mirror(secondPart), mirror(firstPart));
				System.out.println();
			}
		}
	}

	static boolean thirtyDayMonth(int month) {
		return month == 4 || month == 6 || month == 9 || month == 11;
	}

	static int mirror(int part) {
		int firstPart = part / 10;
		int secondPart = part % 10;

		return secondPart * 10 + firstPart;
	}

}

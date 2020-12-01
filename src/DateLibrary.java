/*
 * Patrick Hourican | pjh4as
 * 
 * CS 2110 - HW 2 Part A
 */

public class DateLibrary {

	public static boolean isValidDateFormat(String date) {
		
		if((date.substring(4,5).equals("-")) && (date.substring(7,8).equals("-")) && (date.length() == 10)) {
			// If the date given has hyphens in the required spaces, the try catch block is executed, if not false is returned.
			try{
				/* 
				 *  The try, catch block attempts to convert the substring of the year, month, and day to a int using parseint
				 *  If all of the try statements work, the statement returns true. 
				 *  If any of the statements throw an error as a NumberFormatException, the catch block 
				 *  catches the error and returns false.
				 */
				Integer.parseInt(date.substring(0,4));
				Integer.parseInt(date.substring(5, 7));
				Integer.parseInt(date.substring(8,10));

				return true;
			} 
			catch(NumberFormatException e) {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public static int getYear(String date) {
		
		if(isValidDateFormat(date)) {
			// If the format of the date is valid (from isValidDateFormat) further code is executed, if not -1 is returned.
			
			int year = Integer.parseInt(date.substring(0,4)); // The substring of the date that holds the year is converted to an integer using parseInt and stored as int year.

			if(year >= 0001 && year <= 9999) {
				// If the year is between the values of 0001 and 9999, it is valid and in bounds, returning the year.
				return year;
			}
			else {
				// If the value for year is not in the given bounds, -1 is returned.
				return -1;
			}
		}
		else {
			return -1;
		}
	}

	public static int getMonth(String date) {
	
		if(isValidDateFormat(date)) {
			// If the format of the date is valid (from isValidDateFormat) further code is executed, if not -1 is returned.
			
			int month = Integer.parseInt(date.substring(5, 7)); // The substring of the date that holds the month is converted to an integer using parseInt and stored as int month.

			if(month >= 01 && month <= 12) {
				// If the month is between the value 01 and 12, inclusive, the month is valid and returned.
				return month;
			}
			else {
				// If the month is outside of the bounds of 1 and 12, -1 is returned.
				return -1;
			}
		}
		else {
			return -1;
		}
	}

	public static int getDay(String date) {
		
		/*
		 * Checks for valid date format of the string date, then converts the date to an int.
		 * Next making sure the day is between the viable day values of 1 and 31, inclusive, then returns 
		 * the day if valid, otherwise returns -1.
		 */
		
		if(isValidDateFormat(date)) {
			// If the format of the date is valid (from isValidDateFormat) further code is executed, if not -1 is returned.

			int day = Integer.parseInt(date.substring(8,10)); // The substring of the date that holds the day is converted to an integer using parseInt and stored as int day.

			if(day >= 1 && day <= 31) {
				// If the day is between the value 01 and 31, inclusive, the day is valid and returned.
				return day;
			}
			else {
				// If the day is outside of the bounds of 1 and 31, -1 is returned.
				return -1;
			}
		}
		else {
			return -1;
		}
	}

	public static boolean isLeapYear(int year) {

		/*
		 * Checks if the given year is divisible by 4, 100 and 400 or just 4 to be a leap year.
		 * If all viable conditions are met, true is returned
		 */
		
		if(year % 4 == 0) {
			// If the year is divisible by 4, next if is executed, otherwise, false is returned.
			if(year % 100 == 0) {
				// If the year is divisible by 4 and 100, the next if statement is executed, otherwise true is returned.
				if(year % 400 == 0) {
					// If the year is divisible by 4, 100 and 400, true is returned.
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

	public static boolean isValidDate(String date) {
		
		/*
		 * Checks for a valid day through getDay().
		 * Checks is the amount of days in each corresponding month are valid.
		 * Checks if the value for day in February is valid depending on if it is a leap year.
		 */

		if(isValidDateFormat(date)) {
			
			if(getDay(date) == -1) {
				// If getDay() catches an invalid date returning -1, false is returned.
				return false;
			}
			
			if((getMonth(date) == 1 | (getMonth(date) == 3) | getMonth(date) == 5 | getMonth(date) == 7 | getMonth(date) == 8 | getMonth(date) == 10 | getMonth(date) == 12) && (getDay(date) <= 31)) {
				// If the month is a month with 31 days, and has a day of 31 and under, true is returned.
				return true;
			}
			else {
				if(((getMonth(date) == 4) | (getMonth(date) == 6) | getMonth(date) == 9 | getMonth(date) == 11 ) && (getDay(date) <= 30)) {
					// If the month is a month with 30 days, and has a day of 30 and under, true is returned.
					return true;
				}
				else {
					if(getMonth(date) == 2) {
						// If the month is February further statements must be run to check for leap year instances.
						if((isLeapYear(getYear(date))) && getDay(date) <= 29) {
							// If the year is a leap year and the day is 29 or under, true is returned.
							return true;
						}
						else {
							if(getDay(date) <= 28) {
								// If the year is not a leap year and the day of February is 28 or under, true is returned.
								return true;
							}
							else {
								return false;
							}
						}
					}
					else {
						return false;
					}
				}
			}
			
		}
		return false;

	}

	public static int compare(String date1, String date2) {
		
		/*
		 * If date1 comes before date2 a positive number is returned, a negative number is returned otherwise.
		 */
		if(isValidDate(date1) && isValidDate(date2)) {
			return date1.compareTo(date2);
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("isValidDateFormat()");
		
		System.out.println(isValidDateFormat("1234-45-78")); // method returns true
		System.out.println(isValidDateFormat("1111-111-11")); // method returns false, middle value has 3 characters.
		
		System.out.println(" ");
		System.out.println("getYear()");
		
		System.out.println(getYear("2020-01-26")); // method returns the year "2020"
		System.out.println(getYear("10000-01-01")); // method returns -1, as the year is not a valid year.
		
		System.out.println(" ");
		System.out.println("getMonth()");
		
		System.out.println(getMonth("2020-01-01")); // method returns 1 for the month.
		System.out.println(getMonth("2020-13-01")); // method returns -1, as the month is  not valid.
		
		System.out.println(" ");
		System.out.println("getDay()");
		
		System.out.println(getDay("2020-01-12")); // method returns 12 for day.
		System.out.println(getDay("2020-01-32")); // method returns -1, as the day value is not valid.
		
		System.out.println(" ");
		System.out.println("isLeapYear()");
		
		System.out.println(isLeapYear(2020)); // method returns false, 2020 is not a leap year.
		System.out.println(isLeapYear(2400)); // method returns true, 2400 is a leap year.
		
		System.out.println(" ");
		System.out.println("isValidDate()");
		
		System.out.println(isValidDate("2400-02-29")); // method returns true, as 2400 is a leap year and can therefore have 29 days in February.
		System.out.println(isValidDate("2020-01-32")); // method returns false, as there cannot be 32 days, caught by getDay().
		
		System.out.println(" ");
		System.out.println("compare()");
		
		System.out.println(compare("2020-01-01", "2020-01-32")); // method returns a negative number, date 2 comes after date 1.
		System.out.println(compare("2020-01-02", "2020-01-02")); // method returns a positive number, date 1 comes before date 2.
	}

}
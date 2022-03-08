package sales.demo;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alejandro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String REGEX = "\\p{Punct}";
		// create a pattern
		Pattern pattern = Pattern.compile(REGEX);

		String str = "9th day";
		String charToAdd = null;

		// get a matcher object
		Matcher matcher = pattern.matcher(str);

		String delimiters = "\\s+|,\\,s+";

		// Splitting the string based on space and reverse each part
		// and then join
		String result = Arrays.asList(str.split(delimiters)).stream().map(s -> new StringBuilder(s).reverse())
				.collect(Collectors.joining(" "));

		
		

		result = result.replaceAll(REGEX, "");

		while (matcher.find()) {
			// Prints the start index of the match.

			if (matcher.start() == result.length()) {

				charToAdd = (String) str.subSequence(matcher.start(), result.length() + 1);

				result = result.concat(charToAdd);
			} else {

				charToAdd = (String) str.subSequence(matcher.start(), matcher.start() + 2);

				result = result.substring(0, matcher.start()) + charToAdd + result.substring(matcher.start() + 1);

			}

		}
		System.out.println("Resultado: " + result);

	}

}

package snakecamel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SnakeCamelUtil {

	public static String snakeToCamelcase(String snake_case) {
		if(snake_case.contains("＿")){
			String rex="＿";
			Pattern p = Pattern.compile(rex);
			Matcher m = p.matcher(snake_case);
			String result = m.replaceAll("_");
			snake_case=result;
			
		}
		if(snake_case.charAt(0)=='_'){
			snake_case=snake_case.substring(1,snake_case.length()-1);
			
		}
		
	    String[] words = snake_case.split("_");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length ; i++) {
			sb.append(capitalize(words[i]));
		  
		}
		return new String(sb);
		
		
	}
	 
	public static String camelToSnakecase(String camelcase) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < camelcase.length(); i++) {
			char c = camelcase.charAt(i);
			
			if (Character.isUpperCase(c)) {
			
				if (sb.length() > 0) {
					sb.append("_");
				}
				sb.append(Character.toLowerCase(c));
			
			}else{
				sb.append(c);
			}
		}
		
		return new String(sb);
	}
	
	static String capitalize(String s) {
		char first = s.charAt(0);
		char upperFirst = Character.toUpperCase(first);
		String rest = s.substring(1);
		return upperFirst + rest;
	}

	static String uncapitalize(String s) {
		char first = s.charAt(0);
		char lowerFirst = Character.toLowerCase(first);
		String rest = s.substring(1);
		return lowerFirst + rest;
	}
	
}

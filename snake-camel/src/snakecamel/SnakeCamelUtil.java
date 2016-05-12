package snakecamel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SnakeCamelUtil {

	public static String snakeToCamelcase(String snake_case) {//小文字を大文字に
		if(snake_case.contains("＿")){//全角あり
			String rex="＿";
			Pattern p = Pattern.compile(rex);
			Matcher m = p.matcher(snake_case);
			String result = m.replaceAll("_");
			snake_case=result;
			//System.out.println("全角が入っていた時"+snake_case);
		}
		if(snake_case.charAt(0)=='_'){//最初に_がある
			snake_case=snake_case.substring(1,snake_case.length()-1);
			//System.out.println("一番目を取り除く"+snake_case);
		}
		
	    String[] words = snake_case.split("_");
		//System.out.println(words[0]);
		//System.out.println(words[1]);
		//System.out.println(words[2]);
		//System.out.println(words.length);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length ; i++) {
			sb.append(capitalize(words[i]));
		    //System.out.println(sb);
		}
		return new String(sb);
		
		
	}
	 
	public static String camelToSnakecase(String camelcase) {//大文字を小文字に
		StringBuilder sb = new StringBuilder();
		
		//int j = 0;
		
		for (int i = 0; i < camelcase.length(); i++) {
			char c = camelcase.charAt(i);
			
			if (Character.isUpperCase(c)) {//大文字だったら
				
				//char c = camelcase.charAt(i);
				//System.out.println("Character.toLowerCase(c)は"+c);
				//sb.append(camelcase.substring(j, i));
				
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
	
	static String capitalize(String s) {//小文字を大文字に
		char first = s.charAt(0);
		char upperFirst = Character.toUpperCase(first);
		String rest = s.substring(1);
		return upperFirst + rest;
	}

	static String uncapitalize(String s) {//大文字を小文字に
		char first = s.charAt(0);
		char lowerFirst = Character.toLowerCase(first);
		String rest = s.substring(1);
		return lowerFirst + rest;
	}
	
}

package dev.paie.util;

import org.springframework.stereotype.Service;

@Service
public class URLBuilder {
	
	public static String build(String typeBase, String localhost, String nomBase){

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(typeBase);
		stringBuilder.append("://localhost:");
		stringBuilder.append(localhost);
		stringBuilder.append("/");
		stringBuilder.append(nomBase);
		stringBuilder.append("?useSSL=false");

		return stringBuilder.toString();

	}
}

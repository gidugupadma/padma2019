package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("changes in padma.g920");
		System.out.println("demo application for profiles in spring boot");
		
	}
   
	
	@Profile("dev")
	@Bean
	public String devApp(){
		System.out.println("ur in dev environment");
		System.out.println("ur in dev environment");
		return "I will be available in profile dev please check the environment first while deploying code";
	}
	
	
	@Profile("qa")
	@Bean
	public String qaApp(){
		System.out.println("ur in qa environment");
		return "I will be available in profile QA";
	}
}

package com.example.demo;

import java.io.*;
import java.util.*;

public class Test {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("C:/Users/Lenovo/Desktop/Padma CTS/parser.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String dataString = "";
		String st;
		Map<String, String> dataListBin1 = new HashMap<String, String>();
		Map<String, String> dataListBin2 = new HashMap<String, String>();
		while ((st = br.readLine()) != null) {
			if (!st.equals("")) {
				dataString = st;
			}
		}
		String[] arr = dataString.split(" Current bin");
		String sttt1 = arr[1];
		String sttt2 = arr[2];

		String[] arrb1 = sttt1.split("\\\\r\\\\n");
		String[] arrb2 = sttt2.split("\\\\r\\\\n");
		
		for (String stt : arrb1) {
			if (!stt.isEmpty() && !stt.equals("")) {
				String[] stslip = stt.split("\\|");
				// System.out.println(stslip.length);
				if (stslip.length == 3) {
					String key = stslip[1].trim();
					String value = stslip[2].trim();
					//System.out.println(key + "        " + value);
					if (key.equalsIgnoreCase("Parameter")
							&& value.equalsIgnoreCase("Value"))
						break;
					switch (key) {
					case "RxPkts":
						dataListBin1.put("RxPkts", value);
						break;
					case "RxDropPkts":
						dataListBin1.put("RxDropPkts", value);
						break;
					case "TxCrcErrorPkts":
						dataListBin1.put("TxCrcErrorPkts", value);
						break;
					}
				}// end length
			}//end of if
		}//end of Bin1
		
		for (String stt : arrb2) {
			if (!stt.isEmpty() && !stt.equals("")) {
				String[] stslip = stt.split("\\|");
				// System.out.println(stslip.length);
				if (stslip.length == 3) {
					String key = stslip[1].trim();
					String value = stslip[2].trim();
					//System.out.println(key + "        " + value);
					if (key.equalsIgnoreCase("Parameter")
							&& value.equalsIgnoreCase("Value"))
						break;
					switch (key) {
					case "RxPkts":
						dataListBin2.put("RxPkts", value);
						break;
					case "RxDropPkts":
						dataListBin2.put("RxDropPkts", value);
						break;
					case "TxCrcErrorPkts":
						dataListBin2.put("TxCrcErrorPkts", value);
						break;
					}
				}// end length
			}//end of if
		}//end of Bin1
		
		System.out.println(dataListBin1);
		System.out.println(dataListBin2);
	}
	
}


package Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Batch {
	private static String[] results;
	private static String result;
	private static HashMap<Integer, List<String>> records = new HashMap<Integer, List<String>>();
	
	public Batch(String[] parameter, String path) {
		
		
		String cmd = "cmd /c perl "+ path;
		/*for(int i=0; i<parameter.length; i++) {
			cmd += " \""+parameter[i]+"\"";
		}*/
		
		System.out.println(cmd);
		Runtime runtime = Runtime.getRuntime();
		try {
			Process pr = runtime.exec(cmd);
			readOutput(pr.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*File file = new File(path+perl+".bat");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//System.out.println(file.getPath()+"\n"+parameter);
	}
	
	private static void readOutput(InputStream in) {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String s = null;
		int id = 1;
		try {
			while((s = br.readLine()) != null) {
				List<String> columns = new ArrayList<String>();
				columns.add(s);
				records.put(id, columns);
				
				result = s;
				System.out.println(s);
				id++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getResult() {
		return this.result;
	}
	
	public HashMap<Integer, List<String>> getRecords() {
		return records;
	}
	
	public static void main(String[] args) {
		Batch bat = new Batch(null, "D:\\git\\ipa-test-perl\\db.pl");
	}
}

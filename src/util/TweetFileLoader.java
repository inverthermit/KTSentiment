package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class TweetFileLoader {
	public HashMap<String,String> sentenceMap;
	public HashMap<String,String> sentimentMap;
	public TweetFileLoader(String sentenceFile, String sentimentFile){
		sentenceMap = new HashMap<String,String>();
		sentimentMap = new HashMap<String,String>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(sentenceFile));
			while(br.ready()){
				String line=br.readLine();
				sentenceMap.put(line.split("\t")[0],line.split("\t")[1]);
			}
			br.close();
		}
		catch(Exception ee){
			ee.printStackTrace();
			
		}
		try{
			BufferedReader br = new BufferedReader(new FileReader(sentimentFile));
			while(br.ready()){
				String line=br.readLine();
				sentimentMap.put(line.split("\t")[0],line.split("\t")[1]);
			}
			br.close();
		}
		catch(Exception ee){
			ee.printStackTrace();
			
		}
	}
	

}

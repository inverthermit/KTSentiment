package feature;

import java.util.*;

import util.ArffLoader;
import util.TweetFileLoader;
import util.Util;
import config.Config;

public class Main {

	public static void main(String[] args) throws Exception {
		runCommon();
		//generateDic();
		//selectFeatures();
	}
	
	public static void generateDic(){

		FeatureSelection fs=new FeatureSelection();
		fs.generateDicAll(Config.inputTrainTwetter);
	}
	public static void selectFeatures(){
		FeatureSelection fs=new FeatureSelection();
		try {
			fs.selectFeatures(ArffLoader.getFilteredData(Config.testFile));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void runCommon() throws Exception{
		long start = System.currentTimeMillis();
		TweetFileLoader tfl=new TweetFileLoader(Config.inputTestTwetter, Config.inputTestTwetterLabel);
		for (Map.Entry<String, String> entry : tfl.sentenceMap.entrySet()) {
		    String id = entry.getKey();
		    String sentence = entry.getValue();
		    String sentiment = tfl.sentimentMap.get(id);
    		Process pro=new Process();
		    String result = pro.processSentenceTraining(sentence,id,sentiment);
		    //System.out.println(sentence+id+sentiment);
		    Util.append2File(Config.arffOutPath, result);
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("Time(millisec):"+time);
	}
	
}

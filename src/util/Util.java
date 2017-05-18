package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import config.Config;

public class Util {
	public static void append2File(String path,String content) throws IOException{
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
	    String filePath = absolutePath.
	    	     substring(0,absolutePath.lastIndexOf(File.separator));
	    new File(filePath).mkdirs();
		file.createNewFile(); // if file already exists will do nothing
		BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
		if(content!=null){
			bw.write(content);
			bw.newLine();
		}
		bw.close();
		
	}
	
	public static String[] splitWords(String sentence){
		sentence=sentence.toLowerCase();
		String[] ls = sentence.split("([^a-zA-Z']+)'*\\1*");
		return ls;
	}
	
	public static boolean contianArray(String[] arr,String str){
		for(String temp:arr){
			if(temp.equals(str)){
				return true;
			}
		}
		return false;
	}
	
	public static void trainEval(Classifier classifier){
		try{
			Instances trainData=ArffLoader.getFilteredData(Config.trainFile);
			 Instances testData=ArffLoader.getFilteredData(Config.testFile);
			 
			 classifier.buildClassifier(trainData);
		      Evaluation eval = new Evaluation(testData);
		      eval.evaluateModel(classifier,testData);
		      
		      System.out.println(eval.toSummaryString("\n Results \n=====\n",true));
		      System.out.println(eval.fMeasure(1)+" "+eval.precision(1)+" "+eval.recall(1)+" "); 
		}
		catch(Exception ee){
			ee.printStackTrace();
		}
	}
}

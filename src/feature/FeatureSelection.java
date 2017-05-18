package feature;

import config.Config;
import weka.attributeSelection.*;
import weka.core.*;

import java.io.*;
import java.util.HashSet;

import util.*;

public class FeatureSelection {

	public void selectFeatures(Instances inputData) {
		Instances data = inputData; // from somewhere
		AttributeSelection attsel = new AttributeSelection(); // package
																// weka.attributeSelection!
		CfsSubsetEval eval = new CfsSubsetEval();
		String[] options = new String[2];
		 options[0] = "-P";                                    // "range"
		 options[1] = "200";                                     // first attribute
		try {
			eval.setOptions(options);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GreedyStepwise search = new GreedyStepwise();
		search.setSearchBackwards(true);
		attsel.setEvaluator(eval);
		attsel.setSearch(search);
		try{
			attsel.SelectAttributes(data);
			// obtain the attribute indices that were selected
			int[] indices = attsel.selectedAttributes();
			System.out.println(Utils.arrayToString(indices));
		}
		catch(Exception ee){
			ee.printStackTrace();
		}
	}
	
	public void generateDicAll(String filePath){
		try{
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			HashSet<String> hs= new HashSet<String>();
			DicLoader dl = new DicLoader(Config.engDic);
			dl.loadDic();
			while(br.ready()){
				String line=br.readLine().split("	")[1];
				String[] split= Util.splitWords(line);
				for(String word:split){
					hs.add(word);
				}
			}
			br.close();
			StringBuffer sb= new StringBuffer();
			for (String s : hs) {
				if(Util.contianArray(dl.DIC, s)){
					//System.out.println(s);
				    sb.append(s);
				    sb.append("\r\n");
				}
			}
			Util.append2File(Config.DicAll, sb.toString());
			System.out.println("Number of words:"+hs.size());
		}
		catch(Exception ee){
			ee.printStackTrace();
			
		}
	}
}

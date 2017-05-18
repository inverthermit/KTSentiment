package feature;

import util.DicLoader;
import util.Util;
import config.Config;

public class Process {

	public Process() {

	}

	public String processSentenceTraining(String sentence, String id,
			String sentiment) {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		DicLoader dl = new DicLoader(Config.DicAll);
		dl.loadDic();
		// 4.Sentence assign to dic and return a 0101010 list
		// System.out.println(dl.DIC);
		int[] arr = new int[dl.DIC.length];
		for (int i = 0; i < dl.DIC.length; i++) {
			sb.append(',');
			if (Util.contianArray(Util.splitWords(sentence), dl.DIC[i])) {
				arr[i] ++;
			}
			sb.append(arr[i]);
		}
		// 1.Add sentiment result to result
		sb.append(',');
		sb.append(sentiment);
		// 5.return data string
		return sb.toString();
	}

}

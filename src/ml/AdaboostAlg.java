package ml;

import util.Util;
import weka.classifiers.meta.AdaBoostM1;

public class AdaboostAlg implements MLAlgorithm{

	@Override
	public void trainEvaluate(){
		AdaBoostM1 classifier = new AdaBoostM1();
		Util.trainEval(classifier);
	}

}

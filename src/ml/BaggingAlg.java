package ml;

import util.Util;
import weka.classifiers.meta.Bagging;

public class BaggingAlg implements MLAlgorithm{

	@Override
	public void trainEvaluate(){
		Bagging classifier = new Bagging();
		Util.trainEval(classifier);
	}

}

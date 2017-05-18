package ml;

import util.Util;
import weka.classifiers.functions.Logistic;

public class LogisticRegressionAlg  implements MLAlgorithm{

	@Override
	public void trainEvaluate(){
		Logistic classifier = new Logistic();
		Util.trainEval(classifier);
	}

}

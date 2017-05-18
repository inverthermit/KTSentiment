package ml;

import util.Util;
import weka.classifiers.bayes.NaiveBayes;

public class NaiveBayesAlg  implements MLAlgorithm{

	@Override
	public void trainEvaluate(){
		NaiveBayes classifier = new NaiveBayes();
		Util.trainEval(classifier);
	}

}

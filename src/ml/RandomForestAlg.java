package ml;

import util.Util;
import weka.classifiers.trees.RandomForest;

public class RandomForestAlg  implements MLAlgorithm{

	@Override
	public void trainEvaluate(){
		RandomForest classifier = new RandomForest();
		Util.trainEval(classifier);
	}

}

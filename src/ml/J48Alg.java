package ml;

import util.*;
import weka.classifiers.trees.J48;


public class J48Alg implements MLAlgorithm{
	@Override
	public void trainEvaluate(){
		J48 classifier = new J48();
		Util.trainEval(classifier);

	}

}

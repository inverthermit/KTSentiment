package util;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class ArffLoader {
	public static Instances getFilteredData(String filePath) throws Exception{
		 DataSource source = new DataSource(filePath);
		 Instances data = source.getDataSet();
		 // setting class attribute if the data format does not provide this information
		 // For example, the XRFF format saves the class attribute information as well
		 if (data.classIndex() == -1)
		   data.setClassIndex(data.numAttributes() - 1);
		 String[] options = new String[2];
		 options[0] = "-R";                                    // "range"
		 options[1] = "1";                                     // first attribute
		 Remove remove = new Remove();                         // new instance of filter
		 remove.setOptions(options);                           // set options
		 remove.setInputFormat(data);                          // inform filter about dataset **AFTER** setting options
		 Instances newData = Filter.useFilter(data, remove);   // apply filter
		 //System.out.println(newData);
		 return newData;
	}

}

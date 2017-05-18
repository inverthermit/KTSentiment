package util;
import java.io.*;
import java.nio.file.*;
public class DicLoader {
	public static String[] DIC;
	private String filename;
	public DicLoader(String filename){
		this.filename = filename;
	}
	
	public void loadDic(){
		if(DIC!=null){
			return;
		}
		try{
			long lineCount = Files.lines(Paths.get(filename)).count();
			DIC=new String[(int) lineCount];
			BufferedReader br = new BufferedReader(new FileReader(filename));
			int count=0;
			while(br.ready()){
				String str = br.readLine();
				DIC[count]=str;
				count++;
			}
			br.close();
		}
		catch(Exception ee){
			ee.printStackTrace();
		}
	}

}

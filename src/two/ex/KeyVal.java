
package two.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


class KeyVal {
	
	class KeyAndVal {
		private String key;
		private String value;
		
		KeyAndVal(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public void setKey(String key) {
			this.key = key;
		}
		
		public String getKey() {
			return key;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	
	int flagCount = 0;
	private int tableSize;	
	//private ArrayList<ArrayList<String>> mainArrayList = new ArrayList<ArrayList<String>>();
	private ArrayList<String> subArrayList1 = new ArrayList<String>();
	private ArrayList<String> subArrayList2 = new ArrayList<String>();
	private ArrayList<String> subArrayList3 = new ArrayList<String>();
	
	private ArrayList<String> keys1 = new ArrayList<String>();
	private ArrayList<String> keys2 = new ArrayList<String>();
	private ArrayList<String> keys3 = new ArrayList<String>();
	
	private ArrayList<String> values1 = new ArrayList<String>();
	private ArrayList<String> values2 = new ArrayList<String>();
	private ArrayList<String> values3 = new ArrayList<String>();
	

	public KeyVal(int tableSize) {
		this.tableSize = tableSize;
	}

	public void insert(String key, String value, String fileName) throws IOException {

    	int rowLoc = 0, colLoc = 0;
    	int flag1 = 0, flag2 = 0, flag3 = 0;
    	FileWriter fstream;
		fstream = new FileWriter(fileName, false);	
		BufferedWriter bw = new BufferedWriter(fstream);
		
		System.out.println("Sub1: " + subArrayList1.size());
		System.out.println("Sub2: " + subArrayList2.size());
		System.out.println("Sub3: " + subArrayList3.size());
    	
    	Scanner reader = new Scanner(System.in);
    	do {
    		System.out.println("\n\nSelect Location: ");
    		
    		do {
				System.out.println("Please enter a valid Row value: ");
			    while (!reader.hasNextInt()) {
			        System.out.println("Oops! That's not a valid number!");
			        System.out.println("Please enter a valid row value: ");
			        reader.next(); 
			    }
			    rowLoc = reader.nextInt();
			} while ((rowLoc < 0) || (rowLoc >= tableSize));
    		
    		
    		if (subArrayList1.size() == 0 && rowLoc == 0) {
    			System.out.println("Column value will be 0 at row " + rowLoc + ".");
    			colLoc = 0;
    		} else if (subArrayList2.size() == 0 && rowLoc == 1) {
    			System.out.println("Column value will be 0 at row " + rowLoc + ".");
    			colLoc = 0;
    		} else if (subArrayList3.size() == 0 && rowLoc == 2) {
    			System.out.println("Column value will be 0 at row " + rowLoc + ".");
    			colLoc = 0;
    		} else {
    			do {
    				System.out.println("Please enter a valid Column value: ");
    			    while (!reader.hasNextInt()) {
    			        System.out.println("Oops! That's not a valid number!");
    			        System.out.println("Please enter a valid column value: ");
    			        reader.next(); 
    			    }
    			    colLoc = reader.nextInt();
    			    
    			} while ((colLoc < 0) || (colLoc > subArrayList1.size() && colLoc > subArrayList2.size() && colLoc > subArrayList3.size()) || rowLoc >= tableSize || colLoc >= tableSize);
    		}

    	} while (rowLoc < 0 || colLoc < 0); 	
    	
    	if (rowLoc == 0 && colLoc < subArrayList1.size()) {
    		flag1 = 1;
    	} else if (rowLoc == 1 && colLoc < subArrayList2.size()) {
    		flag2 = 1;
    	} else if (rowLoc == 2 && colLoc < subArrayList3.size()) {
    		flag3 = 1;
    	}
    		
		KeyAndVal entry = new KeyAndVal(key, value);

		if (rowLoc == 0) {	
			if (flag1 == 1) {
				subArrayList1.set(colLoc, "(" + entry.getKey() +","+ entry.getValue() + ") ");
			} else {
				subArrayList1.add(colLoc, "(" + entry.getKey() +","+ entry.getValue() + ") ");
			}
    		keys1.add(entry.getKey());
    		values1.add(entry.getValue());
//    			mainArrayList.add(subArrayList1);
		} else if (rowLoc == 1) {
			if (flag2 == 1) {
				subArrayList2.set(colLoc, "(" + entry.getKey() +","+ entry.getValue() + ") ");
			} else {
				subArrayList2.add(colLoc, "(" + entry.getKey() +","+ entry.getValue() + ") ");
			}
    		keys2.add(entry.getKey());
    		values2.add(entry.getValue());
//    			mainArrayList.add(subArrayList2);
		} else if (rowLoc == 2) {
			if (flag3 == 1) {
				subArrayList3.set(colLoc, "(" + entry.getKey() +","+ entry.getValue() + ") ");
			} else {
				subArrayList3.add(colLoc, "(" + entry.getKey() +","+ entry.getValue() + ") ");
			}
    		keys3.add(entry.getKey());
    		values3.add(entry.getValue());
//    			mainArrayList.add(subArrayList3);
		}
		
		flag1 = 0;  flag2 = 0;  flag3 = 0;	

		for (int i=0; i<subArrayList1.size(); i++) {
			bw.write(subArrayList1.get(i));
		}
		bw.newLine();
		
		for (int i=0; i<subArrayList2.size(); i++) {
			bw.write(subArrayList2.get(i));
		}
		bw.newLine();
		
		for (int i=0; i<subArrayList3.size(); i++) {
			bw.write(subArrayList3.get(i));
		}
		bw.newLine();
		
	    bw.flush();
	    bw.close();

    }
	
	public void forSearch(ArrayList<String> key, ArrayList<String> val, int occurkey, int occurval, String searchStr, int var) {
		for (int i=0; i<key.size(); i++) { 
			for (int x = -1; (x = key.get(i).indexOf(searchStr, x)) != -1; x++) {
				occurkey++;
			}
			for (int x = -1; (x = val.get(i).indexOf(searchStr, x)) != -1; x++) {
				occurval++;
			}
			if (key.get(i).contains(searchStr)) {
				System.out.println("(" + var + "," + i + ") with " + occurkey + " instance(s) of " + key.get(i) + " on key");
			} 
			if (val.get(i).contains(searchStr)) {
				System.out.println("(" + var + "," + i + ") with " + occurval + " instance(s) of " + val.get(i) + " on key");
			} 
			occurkey = 0;
			occurval = 0;
		}
	}

	
	public void search(String searchStr) {
		
		int occurKey1 = 0, occurKey2 = 0, occurKey3 = 0,
			occurVal1 = 0, occurVal2 = 0, occurVal3 = 0;
		
		forSearch(keys1, values1, occurKey1, occurVal1, searchStr, 0);
		forSearch(keys2, values2, occurKey2, occurVal2, searchStr, 1);
		forSearch(keys3, values3, occurKey3, occurVal3, searchStr, 2);

	}
	
	public void firstReadOp(Scanner s, ArrayList<String> list, int c, ArrayList<String> subArray, ArrayList<String> keys, ArrayList<String> values) {
		while (s.hasNext()){
			list.add(s.next());

    	    String beforeComma = list.get(c).substring(1, list.get(c).indexOf(","));
	    	String afterComma = list.get(c).substring(list.get(c).indexOf(",")+1, list.get(c).indexOf(")")); 
	    		
	    	KeyAndVal entry = new KeyAndVal(beforeComma, afterComma);

	    	subArray.add(c, "(" + entry.getKey() +","+ entry.getValue() + ") ");
	    	keys.add(entry.getKey());
	        values.add(entry.getValue());
	    	c++;
    	}
	}
	
	public String firstRead(String filePath) throws IOException {
		
		StringBuilder contentBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
	    String sCurrentLine;
	    ArrayList<String> list1 = new ArrayList<String>();
	    ArrayList<String> list2 = new ArrayList<String>();
	    ArrayList<String> list3 = new ArrayList<String>();
	    int count = 0;
	    while ((sCurrentLine = br.readLine()) != null) {  
	    	
	    	Scanner s = new Scanner(new String(sCurrentLine));
	    	
	    	if (count == 0) {
	    		int c1 = 0;
	    		firstReadOp(s, list1, c1, subArrayList1, keys1, values1);
	    	} else if (count == 1) {
	    		int c2 = 0;
	    		firstReadOp(s, list2, c2, subArrayList2, keys2, values2);
	    	} else if (count == 2) {
	    		int c3 = 0;
	    		firstReadOp(s, list3, c3, subArrayList3, keys3, values3);
	    	}
	    	
	    	s.close();
	    	
	        contentBuilder.append(sCurrentLine).append("\n");
	        count++;
	    }
	    br.close();
	    return contentBuilder.toString();
        
	}


	public String readerOutput(String filePath) throws IOException {
		
		StringBuilder contentBuilder = new StringBuilder();
    	BufferedReader br = new BufferedReader(new FileReader(filePath));
        String sCurrentLine;
        ArrayList<String> list = new ArrayList<String>();
        while ((sCurrentLine = br.readLine()) != null) {    
        	Scanner s = new Scanner(new String(sCurrentLine));
        	while (s.hasNext()){
        	    list.add(s.next());
        	}
        	s.close();
            contentBuilder.append(sCurrentLine).append("\n");
        }
        br.close();
        return contentBuilder.toString();
	}
	
	
	public void resetAll(String filePath) throws FileNotFoundException {
		subArrayList1.clear(); keys1.clear(); values1.clear();
		subArrayList2.clear(); keys2.clear(); values2.clear();
		subArrayList3.clear(); keys3.clear(); values3.clear();
		PrintWriter writer = new PrintWriter(filePath);
		writer.print("");
		writer.close();
	}
	
}


import java.util.*;

class Main {
  public static void main(String[] args) {
    
    HashMap map = new HashMap();
    Scanner scan1 = new Scanner(System.in);
    List<Integer> keyTrack = new ArrayList<Integer>();

    
    while(true){
      System.out.println("Enter value (-1 to stop): ");
      int add = scan1.nextInt();
      scan1.nextLine();
      if(add < 0){
    	  break;
      }
      if(map.containsKey(add)){
        map.put(add, (int)(map.get(add)) + 1);
      } else {
        map.put(add, 1);
        keyTrack.add(add);
      }
    }
    
    sort(keyTrack);
    int maxVal = 0;;
    for(int idx : keyTrack) {
    	if((int)map.get(idx) > maxVal) {
    		maxVal = (int)map.get(idx);
    	}
    }
    
    String graph = "";
    System.out.println("\n\n");
    int dom = keyTrack.get(keyTrack.size() - 1);
    
    for(int rend = maxVal; rend > 0; rend--) {
    	
    	if(rend%5 == 0) {
    		
    		graph += String.format("%-4d", rend);
    		
    	} else {
    		graph += "    ";
    	}
    	
    	for(int idx = 0; idx <= dom; idx++) {
    		
    		if(map.containsKey(idx) && (int)map.get(idx) >= rend) {
    			
    			graph += "* ";
    		} else {
    			
    			graph += "  ";
    		}
    		
    	}
    	graph += "\n";
    	
    }
    
    
    for(int lbl = 0; lbl <= Math.floor(Math.log10(dom)); lbl++) {
    	
    	int disp = 0;
    	graph += "    ";
    	for(int idx = 0; idx <= dom; idx++) {
    		
    		if(idx%Math.pow(10, lbl) == 0) {
    			graph += disp%10;
    			graph += " ";
    			disp++;
    		} else {
    			graph += "  ";
    		}
    		
    	}
    	graph += "\n";
    }
    
    System.out.println(graph);
    System.out.println("Press any key to exit...");
    scan1.nextLine();
  }
  
  private static void sort(List<Integer> arr) {
	  
	  for(int idx = 1; idx < arr.size(); idx++) {
		  int key = arr.get(idx);
		  int pos = idx;
		  
		  while(pos > 0 && arr.get(pos - 1) > key) {
			  arr.set(pos, arr.get(pos - 1));
			  pos--;
		  }
		  arr.set(pos, key);
	  }
	  
  }
}
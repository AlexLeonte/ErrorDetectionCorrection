
public class HammingCode {

	
	
	public static  String getGeneratedCode(String input){
		
		int i = 0;
		StringBuilder str = new StringBuilder(input);
		int parityCount = 1;
		int rang = 0;
		int parityCheckActive = 0;
		
		
		for(i = 0 ;i<str.length(); i++){
			if( (parityCount & -parityCount) == parityCount){	
					str.insert(i, 'P');
			}
			parityCount++;				
		}
		
		parityCount = 0;
		
		System.out.println(str.toString() + " " + str.length()); 
		
		//----------------------------------------------------------------------------
		int countForParity = 0;
		for(i = 0 ; i< str.length(); i++){
			if(str.charAt(i) == 'P'){
				parityCount = (int) Math.pow(2, countForParity++);
				rang = 2 * parityCount;
				parityCheckActive = 0;
				for(int j = i ; j< str.length(); j++ ){
					if(rang > parityCount){
						if(str.charAt(j) == '1'){
							parityCheckActive++;
						}
					}
					rang--;
					if(rang == 0 ){
						rang = 2 * parityCount;
					}	
				}
				if(parityCheckActive % 2 == 0){
					str.setCharAt(i, '0');     //even
				}else{
					str.setCharAt(i, '1'); 		//odd 
				}		
			}
		}
		
		
		System.out.println(str.toString() + " " + str.length()); 

			
		
		
		 return str.toString();

	}
}

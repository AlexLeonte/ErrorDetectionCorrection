
public class ApplicationController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HammingCode hc = new HammingCode();
		
		
		System.out.println("enter input");
		
		String inputText= "1010101";
		System.out.println(inputText);
		String parityText = hc.getGeneratedCode(inputText);
		System.out.println("codul generate - bit parity:" + parityText );
		
	}

}

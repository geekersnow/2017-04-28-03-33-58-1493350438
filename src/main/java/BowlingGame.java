/**
 * 
 * @author susan
 *
 */
public class BowlingGame {

	public String bowlingCode;
	private String[] bowlingString;	

	public BowlingGame() {
		super();
	}
	
	public BowlingGame(String bowlingCode) {
		this.bowlingCode = bowlingCode;
	}
	
	//use the spilt() change String to a String[]
	private String[] spiltBowlingCode(String bowlingCode){
		bowlingCode = bowlingCode.replace("-","0");
		bowlingString = bowlingCode.split("\\|");
		return this.bowlingString;	
	}
	
	//change String[] to a char[]
	private char[] coverToChar(String[] bowlingString){
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0;i< bowlingString.length;i++){
    		sb.append(bowlingString[i]); 
    		}
    	String newstr = sb.toString();    	
    	char[] frame = new char[newstr.length()*2];
    	frame = newstr.toCharArray();
    	return frame;
	}
	
	//count the sum
	private int conutScore(char[] frame){
		int  sum = 0;
    	int[] num = new int[frame.length];
    	for(int i = 0;i< frame.length;i++){
    		if (Character.isDigit(frame[i]))
    		{
    			num[i] = Character.getNumericValue(frame[i]);    			
    		}
    		else
    		{
    			num[i] = 10;
    		}
		}
    	
    	//judge the 11th frame
    	int L = frame.length;
    	if(!bowlingCode.endsWith("||")){    		
    		String[] bowling = bowlingCode.split("\\|\\|");
    		L -= bowling[1].length();
    	}
    	
    	for (int i = 0; i < L; i++) {
			{
				switch (frame[i]) {
				case '/':
					num[i - 1] = 0;
					sum += num[i + 1];
					break;
				case 'X':
					sum += num[i + 1] + num[i + 2];
					break;
				default:
					break;
			
				}
			}

		}
    	
    	for(int i = 0;i< L;i++){
    		sum = sum + num[i];
    	}
    	
		return sum;
	}

	/**
	 * 
	 * @param bowlingCode
	 * @return sum
	 */
	public int getBowlingScore(String bowlingCode)
	{
		String[] bowlingString = spiltBowlingCode(bowlingCode);
		char[] conChar = coverToChar(bowlingString);
		return conutScore(conChar);	
	}
	
}

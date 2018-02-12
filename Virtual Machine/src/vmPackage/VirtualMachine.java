//CSCI 4200 - SubLC3 VM Assignment - Matthew Johnston
package vmPackage;

//Imports
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class VirtualMachine{
	static String[] memory = new String[500];
	public static void main(String[] args) throws IOException{
		//Variables
		Scanner file = new Scanner(new File("src\\vmPackage\\mySubLC3.txt"));
		Scanner file2 = new Scanner(new File("src\\vmPackage\\mySubLC3.txt"));
		Scanner scan = new Scanner(System.in);
		String fileLine, startOfFile, source1, source2 = "";
		String destination = "";
		int pC = 0;
		int sIndex1 = 0; 
		int sIndex2 = 0;
		int sInt1 = 0;
		int sInt2 = 0;

		//Main code body
		while(file.hasNextLine()){
			fileLine = file.nextLine();
			startOfFile = file2.next();
			
			switch(file.next()){
				case ";":
					break;
				//Operational instructions
				case "ADD":
					pC++;
					destination = file.next();
					if(!isNumber(destination)){
						memory[pC] = destination;
						pC++;
						source1 = file.next();
						source2 = file.next();

						if(!isNumber(source1)){
							sIndex1 = search(source1);
							sInt1 = Integer.parseInt(memory[sIndex1+1]);
						}else{
							sInt1 = Integer.parseInt(source1);
						}

						if(!isNumber(source2)){
							sIndex2 = search(source2);
							sInt2 = Integer.parseInt(memory[sIndex2+1]);
						}else{
							sInt2 = Integer.parseInt(source2);
						}

						memory[pC] = Integer.toString(sInt1 + sInt2);
						pC++;
					}else{
						System.out.println("ERROR: Destination is not a variable.");
					}
					break;
				case "SUB":
					pC++;
					destination = file.next();
					if(!isNumber(destination)){
						memory[pC] = destination;
						pC++;
						source1 = file.next();
						source2 = file.next();

						if(!isNumber(source1)){
							sIndex1 = search(source1);
							sInt1 = Integer.parseInt(memory[sIndex1+1]);
						}else{
							sInt1 = Integer.parseInt(source1);
						}

						if(!isNumber(source2)){
							sIndex2 = search(source2);
							sInt2 = Integer.parseInt(memory[sIndex2+1]);
						}else{
							sInt2 = Integer.parseInt(source2);
						}

						memory[pC] = Integer.toString(sInt1 - sInt2);
						pC++;
					}else{
						System.out.println("ERROR: Destination is not a variable.");
					}
					break;
				case "MUL":
					pC++;
					destination = file.next();
					if(!isNumber(destination)){
						memory[pC] = destination;
						pC++;
						source1 = file.next();
						source2 = file.next();

						if(!isNumber(source1)){
							sIndex1 = search(source1);
							sInt1 = Integer.parseInt(memory[sIndex1+1]);
						}else{
							sInt1 = Integer.parseInt(source1);
						}

						if(!isNumber(source2)){
							sIndex2 = search(source2);
							sInt2 = Integer.parseInt(memory[sIndex2+1]);
						}else{
							sInt2 = Integer.parseInt(source2);
						}

						memory[pC] = Integer.toString(sInt1 * sInt2);
						pC++;
					}else{
						System.out.println("ERROR: Destination is not a variable.");
					}
					break;
				case "DIV":
					pC++;
					destination = file.next();
					if(!isNumber(destination)){
						memory[pC] = destination;
						pC++;
						source1 = file.next();
						source2 = file.next();

						if(!isNumber(source1)){
							sIndex1 = search(source1);
							sInt1 = Integer.parseInt(memory[sIndex1+1]);
						}else{
							sInt1 = Integer.parseInt(source1);
						}

						if(!isNumber(source2)){
							sIndex2 = search(source2);
							sInt2 = Integer.parseInt(memory[sIndex2+1]);
						}else{
							sInt2 = Integer.parseInt(source2);
						}

						memory[pC] = Integer.toString(sInt1 / sInt2);
						pC++;
					}else{
						System.out.println("ERROR: Destination is not a variable.");
					}
					break;
				case "IN":
					pC++;
					System.out.println("Please enter an integer: ");
					sInt1 = scan.nextInt();
					source1 = file.next();
					memory[pC] = source1;
					pC++;
					memory[pC] = Integer.toString(sInt1);
					pC++;
					break;
				case "OUT":
					source1 = file.next();
					if(isNumber(source1)){
						System.out.println(Integer.parseInt(source1));
					}else if(search(source1) == (-1)){
						destination = source1;
						source1 = file.next();
						while(!source1.contains("\"")){
							destination = destination + " " + source1;
							source1 = file.next();
						}
						destination = destination + " " + source1;
					}else{
						sIndex1 = search(source1);
						sInt1 = Integer.parseInt(memory[sIndex1+1]);
						System.out.println(sInt1);
					}
					pC++;
					break;
				//Data movement instructions
				case "STO":
					pC++;
					memory[pC] = file.next();
					pC++;
					memory[pC] = file.next();
					pC++;
					break;
				//Control instructions
				case "BRn":
					source1 = file.next();
					if(isNumber(source1)){
						sInt1 = Integer.parseInt(source1);
						source1 = file.next();
						source2 = "";
						if((sInt1 <= (-1))){
							while(!source1.equals(source2)){
								source2 = file.next();
							}
						}
					}
					pC++;
					break;
				case "BRz":
					source1 = file.next();
					if(isNumber(source1)){
						sInt1 = Integer.parseInt(source1);
						source1 = file.next();
						source2 = "";
						if((sInt1 == 0)){
							while(!source1.equals(source2)){
								source2 = file.next();
							}
						}
					}
					pC++;
					break;
				case "BRp":
					source1 = file.next();
					if(isNumber(source1)){
						sInt1 = Integer.parseInt(source1);
						source1 = file.next();
						source2 = "";
						if((sInt1 >= (1))){
							while(!source1.equals(source2)){
								source2 = file.next();
							}
						}
					}
					pC++;
					break;
				case "BRzp":
					source1 = file.next();
					if(isNumber(source1)){
						sInt1 = Integer.parseInt(source1);
						source1 = file.next();
						source2 = "";
						if((sInt1 >= (0))){
							while(!source1.equals(source2)){
								source2 = file.next();
							}
						}
					}
					pC++;
					break;
				case "BRzn":
					source1 = file.next();
					if(isNumber(source1)){
						sInt1 = Integer.parseInt(source1);
						source1 = file.next();
						source2 = "";
						if((sInt1 <= (0))){
							while(!source1.equals(source2)){
								source2 = file.next();
							}
						}
					}
					pC++;
					break;
				case "JMP":
					source1 = file.next();
					source2 = file2.next();
					while(!source1.equals(source2)){
						source2 = file2.next();
					}
					pC++;
					break;
				case "HALT":
					System.out.println("End of program.");
					break;
				default:
					break;
			}
		}
	}

	private static boolean isNumber(String in){
	    try{
	        Integer.parseInt(in);
	    }catch (NumberFormatException ex){
	        return false;
	    }
	    return true;
    }

    private static int search(String target){
    	for(int i = 0; i < 499; i++){
    		String t = memory[i];
    		if(target.equals(t)){
    			return i;
    		}
    	}
    	return -1;
    }
}
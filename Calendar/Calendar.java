/**
 * This program will generate calendar of any given year
 * Developed by Utkrisht Sinha
 */
 
import java.util.Scanner;
public class Calendar {
	
	static int[] monthKey = {0,3,3,6,1,4,6,2,5,0,3,5};				//Assigning keys to months for calculation
	static String[] months = 										//Just creating a months array you will soon know why
		{"January","February","March","April","May","June","July",
		"August","September","October","November","December"};
	static int centuryTable[] = {0,5,3,1};							//Assigning keys to century for calculation
	
	//Methods for checking leap year
	
	static boolean isLeapYear(int yyyy){
		if(yyyy%4==0){
			if(yyyy%100!=0){
				return true;
			}
			if(yyyy%100==0&&yyyy%400==0){
				return true;
			}
		}
		return false;
	}
	
	//Method for calculating days in a month
	
	static int days(int mm, int yyyy){
		if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12){
			return 31;
		}else if(mm==4||mm==6||mm==9||mm==11){
			return 30;
		}else if(mm==2 && isLeapYear(yyyy)){
			return 29;
		}else{
			return 28;
		}
	}
	
	//Method for calculating day value
	
	public static int calculateDay(int dd, int mm, int yyyy){
		int YY = yyyy/100;
		int n1 = (dd + monthKey[mm-1])%7;
		int yy = yyyy%100;
		int n2 = (yy%28) + (yy/4) + centuryTable[YY%4];
		if((mm==1||mm==2)&&isLeapYear(yyyy)){
			n2-=1;
		}
		int res = (n1+n2+6)%7;
		return res;
	}
	
	//Method for generating Calendar
	
	public static void generateCalendar(int yyyy){
		for(int j=0;j<12;j++){
			System.out.println(months[j]+"\n");
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			for(int i=0;i<calculateDay(1,j+1,yyyy);i++){
				System.out.print("\t");
			}
			for(int i=0;i<days(j+1,yyyy);i++){
				if(calculateDay(i+1,j+1,yyyy)==0 && i!=0){
					System.out.println();
				}
				System.out.print((i+1)+"\t");
			}
			System.out.println("\n");
		}
	}
	
	//Main method
	
	public static void main(String[] args){
		int yyyy = 1;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter any year : ");
		yyyy = in.nextInt();
		System.out.println(yyyy);
		generateCalendar(yyyy);
		in.close();
	}

}

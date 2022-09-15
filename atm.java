import java.util.Scanner;

class user {
	String name;
	int id ;
	int password ;
	int balance;

	void set_inf(String n,int l, int p,int b){
	name = n;
	id = l;
	password = p;
	balance = b;
	}

	void deposite(int amount){
		balance += amount;
	}
	void printbalance() {
		System.out.println(balance);
	}
	void withdraw(int amount){	
		if (balance > amount) balance -= amount;
		else System.out.println("your brok hh");
	}
}

class ATM {

	// declaretion a scanner
	static Scanner Scanner = new Scanner(System.in);


	static void helpPrint(){
		System.out.println();
		System.out.println("-------------helo------------");
		System.out.println("this is the comond you can do");
		System.out.println("      For view help    :-->0");
		System.out.println("      For withdraw     :-->1");
		System.out.println("      For deposite     :-->2");
		System.out.println("      For view balance :-->3");
		System.out.println("      For quite        :-->4");
	}

	static user compte_verifiecation(int id , int pass,user user_array []){

		for( user user_inf : user_array){
			if (user_inf != null && id == user_inf.id)
				if (pass == user_inf.password)
					return user_inf;
			}
		return null ;
	}


	static user login(user compts[]){

		boolean verification ;
		user user_found;

		do{
			System.out.println("hi for do any trasaction pls enter your info:");
			System.out.print("Login_info:");
			int id = Scanner.nextInt();
			System.out.print("password :");
			int password = Scanner.nextInt();
			// recher for user if no user found null will return 
			user_found = compte_verifiecation(id,password,compts);
			verification = ( user_found != null )? true : false;
			if(verification) System.out.println("login seccse");  
			else System.out.println("rong info :( reenter again :)");

		}while(!verification);
		return user_found;
	}

//rod method main --->> login method we 3aytelha fi west method main o5ra
	public static void main (String args[]){

		//the next 7 line is a temp base donner
		user compts [] = new user[3];
		user hedi = new user();
		user sinda = new user();
		hedi.set_inf("hedi",0001,2245,10_035_454);
		sinda.set_inf("sinda",0002,2185,8_055_454);
		compts[0]=hedi;
		compts[1]=sinda;//chouf kifeh tebedelha bi baze de donner

		//this this the user after enter there info
		user user_Login = login(compts);

		//declaration of command "varible to starege the commend of the user 
		byte command;

		do{
			System.out.print("how we can help you :(0 for help)\n>>>>>");
			command = Scanner.nextByte();
			switch ( command) {
			case 0:{
				helpPrint();
				break;
			}	
			case 1 : {
				System.out.println("how much you need to withdraw");
				user_Login.withdraw(Scanner.nextInt());
				break;
			}
			case 2 : {
				System.out.println("how much you need to deposite");
				user_Login.deposite(Scanner.nextInt());
				break;
			}
			case 3 : {
				user_Login.printbalance();
				break;
			}
			case 4 : {
				System.out.println("byye :)");
				break;
			}
			default : System.out.println("you choise do not existe");

			}
		}while(command != 4);


	}
}
/*	-9e3ad bech te7ot line 87 to 92 te7othom fi loop 
	-tezidhom condition bech to5rij mil atm
	-switch 3ala comend ili bech ya5tarha utulisateur
*/

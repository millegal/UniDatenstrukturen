package mb;

import java.util.Scanner;

public class start {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.print("Welche Collection Testen? [0] = List, [1] = Stack" );
		int ch = reader.nextInt();
		switch(ch){
		case 0:
			System.out.println("List");
			break;
		case 1:
			System.out.println("Stack");
			break;
			
		}
		
		List myList = new List();
		Stack stack = new Stack(20);
		Queue queue = new Queue(5);
		int n;
		do{
			n = nextInput(reader);		
			if(n < 0)
				break;
			Pos currentPosition = myList.front();
			Int tmpValue = new Int();
			tmpValue.value = n;	
			myList = myList.insert(currentPosition, tmpValue);
			stack.Push(tmpValue);
			stack.Print();
			queue.enqueue(tmpValue);
			queue.print();
			myList.print();
		}while(true);
		System.out.println("Sie haben folgende Liste eingegeben:\n");
		myList.print();
		
		System.out.print("Möchten Sie eine Zahl löschen? (J/N) ");
		char o  = reader.next().toLowerCase().charAt(0);

		if(o == 'j'){
			delNumber(reader, myList);
			do{
				System.out.print("Noch eine Zahl löschen (J/N)? ");
				o  = reader.next().toLowerCase().charAt(0);
				if(o== 'n')
					break;
				delNumber(reader, myList);
			}while(true);
		}
		
		
		System.out.println("Ihre Liste:\n");
		myList.print();
		
		reader.close();
		System.out.println("End Program");

	}
	
	private static int nextInput(Scanner reader){

		System.out.print("Bitte geben Sie eine Zahl ein: ");
		int n = reader.nextInt();
		System.out.println("Sie haben " + n + " eingegeben");
		
		return n;
	}
	
	private static void delNumber(Scanner reader, List myList){
		System.out.print("Welche Zahl löschen? ");
		int m = reader.nextInt();

		Pos q = myList.find(new ElemTest(){
			public boolean check(Elem le){
				boolean check = (((Int)le).value) == m;
				return check;
			}
		});
		if(q != null)
		myList.delete(q);
		else{
			System.out.println("Fehler, Wert nicht vorhanden.");
		}
		myList.print();
	}
}

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		IntArrayList b = new IntArrayList();
		
		System.out.println("First, we add to both arrays the following sequence : 5,13,23,71");
		a.add(5);
		b.add(5);
		a.add(13);
		b.add(13);
		a.add(23);
		b.add(23);
		a.add(71);
		b.add(71);
		System.out.print("Real ArrayList "+a.toString() + " --- ");
		System.out.println("My IntArrayList "+b.toString());
		System.out.println("");
		
		System.out.println("Then, we add 10 to both with the add(int value) method:");
		a.add(10);
		b.add(10);
		System.out.print("Real ArrayList "+a.toString() + " --- ");
		System.out.println("My IntArrayList "+b.toString());
		System.out.println("");
		
		System.out.println("Then, we add 15 at position 1 to both with the add(int i,int value) method:");
		a.add(1,15);
		b.add(1,15);
		System.out.print("Real ArrayList "+a.toString() + " --- ");
		System.out.println("My IntArrayList "+b.toString());
		System.out.println("");
		
		System.out.println("Then, we get value at index 3 from both with the get(int i) method:");
		System.out.print("Real ArrayList "+a.get(3) + " --- ");
		System.out.println("My IntArrayList "+b.get(3));
		System.out.println("");
		
		System.out.println("Then, we set 859 at position 5 to both with the set(int i,int value) method:");
		a.set(5,859);
		b.set(5,859);
		System.out.print("Real ArrayList "+a.toString() + " --- ");
		System.out.println("My IntArrayList "+b.toString());
		System.out.println("");
		
		System.out.println("Then, we remove the value at index 1 with the remove(int i) method:");
		a.remove(1);
		b.remove(1);
		System.out.print("Real ArrayList "+a.toString() + " --- ");
		System.out.println("My IntArrayList "+b.toString());
		System.out.println("");
		
		System.out.println("Then, we display the current size of the array with the size() method:");
		System.out.print("Real ArrayList "+a.size() + " --- ");
		System.out.println("My IntArrayList "+b.size());
		System.out.println("");
		
		System.out.println("Now, we will see some performance test on each arrays, processing 50000 times the add() method :");
		
		IntArrayList d = new IntArrayList();
		IntArrayList c = new IntArrayList(50000);
		ArrayList<Integer> f =  new ArrayList<Integer>();
		ArrayList<Integer> g =  new ArrayList<Integer>(50000);
		
	
		long time = System.currentTimeMillis();
		
		for(int i=0;i<50000;i++){
			d.add(345);
		}
		long time2 = System.currentTimeMillis() - time;
		System.out.println("IntArrayList process without initial capacity took : "+ time2);
		
		time = System.currentTimeMillis();
		for(int i=0;i<50000;i++){
			c.add(345);
		}
		time2 = System.currentTimeMillis() - time;
		System.out.println("IntArrayList process with initial capacity took : "+ time2);
		
		time = System.currentTimeMillis();
		for(int i=0;i<50000;i++){
			f.add(345);
		}
		time2 = System.currentTimeMillis() - time;
		System.out.println("Real ArrayList without initial capacity took : "+ time2);
		
		time = System.currentTimeMillis();
		for(int i=0;i<50000;i++){
			g.add(345);
		}
		time2 = System.currentTimeMillis() - time;
		System.out.println("Real ArrayList with initial capacity took : "+ time2);
	}

}

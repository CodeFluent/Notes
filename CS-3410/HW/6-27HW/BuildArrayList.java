/*

	Soooo, the TA sent us this file as a helper to build the ArrayList. We were also sent a link to the original Java source code.

	But otherwise this is basically the homework assignment...

	Yeah that's good communication I guess.

*/


import java.util.Arrays;


public class BuildArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);

		System.out.println("size: "+list.size());
		System.out.println("get 10th element: "+list.get(10));

		list.printArray();
	}

}

class MyArrayList{

	Object[] storage;
	int size;

	MyArrayList(){
		storage = new Object[10];
		System.out.println(storage.length);
	}

	public void add(Object obj){
		checkCapacity(size+1);
		storage[size++] = obj;
	}

	private void checkCapacity(int capacity) {
		int oldCapacity = storage.length;
		if(capacity>oldCapacity)
		{
			storage = Arrays.copyOf(storage, storage.length*2);
			System.out.println("capacity doubled. new capacity: "+storage.length);
		}
		else{
			System.out.println("capacity: "+capacity + " oldCapacity: "+oldCapacity);
		}
	}

	public void printArray(){
		for(int i=0; i<storage.length;i++)
		{
			System.out.println(storage[i]);
		}
	}

	public int size()
	{
		return size;
	}

	public Object get(int index){
	        if(index < size){
	            return storage[index];
	        } else {
	            throw new ArrayIndexOutOfBoundsException();
	        }
	    }
}

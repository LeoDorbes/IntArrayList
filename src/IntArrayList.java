/*
 * 
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

 
/**
 * IntArrayList intends to work like the ArrayList but in a way that is specific
 * to Integers and more efficient than ArrayList.
 * 
 * @author Léo Dorbes
 * @version 1.0 10 Nov, 2015.
 */
public class IntArrayList {

	/** The array growing value. */
	private static int arrayGrowingValue = 1;
	
	/** The int array. */
	private int[] intArray;

	/** The array size. */
	private int arraySize = 0;
	
	/** The array capacity. */
	private int arrayCapacity = 0;

	/**
	 * Constructor for a new empty IntArrayList.
	 */
	public IntArrayList() {
		intArray = new int[0];
		arraySize = 0;
		arrayCapacity = 0;
	}

	/**
	 * Constructor for a new empty IntArrayList, with an initial size.
	 *
	 * @param initialCapacity            initial size of the IntArrayList.
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public IntArrayList(int initialCapacity) throws IllegalArgumentException {

		try {
			intArray = new int[initialCapacity];
		} catch (NegativeArraySizeException e) {
			throw new IllegalArgumentException();
		}
		arrayCapacity = initialCapacity;

	}

	/**
	 * This method returns the value stored at the position given in parameters.
	 *
	 * @param i
	 *            The index to look for in the array.
	 * @return The value of the specified element
	 * @throws IndexOutOfBoundsException
	 *             If the given index is out of bound of the current array.
	 */
	public int get(int i) throws IndexOutOfBoundsException {

		if (i < 0 || i >= arraySize){
			throw new IndexOutOfBoundsException();
		}
		return intArray[i];

	}

	/**
	 * This method insert the value given in parameters at the end of the
	 * IntArrayList, increasing the size of the array by 1.
	 *
	 * @param value
	 *            The specific value to insert into the IntArrayList.
	 */
	public void add(int value) {
		if (arraySize == arrayCapacity) {
			updateArraysSizes(intArray.length + arrayGrowingValue);
		}
		intArray[arraySize] = value;
		arraySize++;

	}

	/**
	 * This method insert the given value at the given position in the
	 * IntArrayList, increasing the size of the array by 1.
	 *
	 * @param i            The position where to insert the value.
	 * @param value            The specific value to insert into the IntArrayList.
	 * @throws IndexOutOfBoundsException             If the given index is out of bound of the current array.
	 */
	public void add(int i, int value) throws IndexOutOfBoundsException {
		if (i < 0 || i > arraySize) {
			throw new IndexOutOfBoundsException();
		}
		if (arraySize == arrayCapacity) {
			updateArraysSizes(intArray.length + arrayGrowingValue);
		}
		arraySize++;
		int temp;
		for (int j = 0; j < arraySize; j++) {
			if (j >= i) {
				temp = intArray[j];
				intArray[j] = value;
				value = temp;
			}
		}
	}

	/**
	 * This method changes the current value at the given position in the
	 * IntArrayList with the given value.
	 *
	 * @param i            The index of the value to replace.
	 * @param value            The replacing value.
	 * @throws IndexOutOfBoundsException             If the given index is out of bound of the current array.
	 */
	public void set(int i, int value) throws IndexOutOfBoundsException {
		if (i < 0 || i >= arraySize) {
			throw new IndexOutOfBoundsException();
		}
		intArray[i] = value;
	}

	/**
	 * This method removes the current value at the given position in the
	 * IntArrayList, decreasing the size of the array by 1.
	 * .
	 * 
	 * @param i
	 *            The index of the value to delete.
	 * @throws IndexOutOfBoundsException
	 *             If the given index is out of bound of the current array.
	 */
	public void remove(int i) throws IndexOutOfBoundsException {

		if (i < 0 || i >= arraySize) {
			throw new IndexOutOfBoundsException();
		}
		arraySize--;
		for (int j = 0; j < arraySize; j++) {
			if (j >= i) {
				intArray[j] = intArray[j + 1];
			}
		}

	}

	/**
	 * This method returns the current size of the IntArrayList.
	 * 
	 * @return The size of the current IntArrayList.
	 */
	public int size() {
		return arraySize;
	}

	/**
	 * Returns a string representation of this collection. The string
	 * representation consists of a list of the Array's int in the
	 * order they are returned by its iterator, enclosed in square brackets
	 * ("[]"). Adjacent elements are separated by the characters ", " (comma and
	 * space).
	 * 
	 * @return A string representation of this collection.
	 */
	public String toString() {
		String s = "[";
		for (int i = 0; i < arraySize; i++) {
			if (i != 0)
				s = s + " ";
			s = s + intArray[i];
			if (i != arraySize - 1)
				s = s + ",";
		}
		s = s + "]";
		return s;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element). The returned array will be "safe"
	 * in that no references to it are maintained by this list. (In other words,
	 * this method must allocate a new array). The caller is thus free to modify
	 * the returned array.
	 * 
	 * @return An array of int containing all of the elements in this list in proper sequence.
	 */
	public int[] toArray() {
		return Arrays.copyOf(intArray, arraySize - 1);
	}

	/**
	 * Update arrays sizes.
	 *
	 * @param newValue the new value
	 */
	private void updateArraysSizes(int newValue) {
		if (arrayCapacity != 0) {
			intArray = Arrays.copyOf(intArray, newValue);
		} else {
			intArray = new int[newValue];

		}

		arrayCapacity = newValue;
	}

}

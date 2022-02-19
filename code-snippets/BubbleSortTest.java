import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class BubbleSortTest {
	
	private final BubbleSort bubbleSort = new BubbleSort();
	
	@Test
	public void testPath1() {
		int[] testData = new int[] {5};
		bubbleSort.bubbleSort(testData);
		assertArrayEquals(new int[] {5}, testData);
	}
	
	@Test
	public void testPath3() {
		int[] testData = new int[] {5, 8};
		bubbleSort.bubbleSort(testData);
		assertArrayEquals(new int[] {5, 8}, testData);
	}
	
	@Test
	public void testPath4() {
		int[] testData = new int[] {8, 5};
		bubbleSort.bubbleSort(testData);
		assertArrayEquals(new int[] {5, 8}, testData);
	}
}

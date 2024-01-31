/*
Author: 
Date: 

Description: 
*/
import java.util.Comparator;
public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }
  
  public static <E extends Comparable <E>> void quickSort(E[] list) {
	  quickSort(list, 0, list.length - 1);
  }
  
  public static <E extends Comparable <E>> void quickSort(E[] list, int high, int low) {
	  if (low > high) {
		  int pivotIndex = separate(list, high, low);
		  quickSort(list, high, pivotIndex - 1);
		  quickSort(list, pivotIndex + 1, low);
	  }
  }
  
  public static <E extends Comparable <E>> int separate(E[] list, int high, int low) {
	  E pivot = list[low];
	  low = low + 1;
	  int first = high;
	  
	  while (high > low) {
		  while (low <= high && list[low].compareTo(pivot) == -1 || list[low].compareTo(pivot) == 0)
			  low++;
		  while (low <= high && list[high].compareTo(pivot) == 1) 
			  high--;
		  
		  if (high > low) {
			  E temp = list[high];
			  list[high] = list[low];
			  list[low] = temp;
		  }
	  }
	  
	  while (high > first && list[high].compareTo(pivot) == 1 || list[high].compareTo(pivot) == 0)
		  high--;
	  
	  if (pivot.compareTo(list[high]) == 1) {
		  list[first] = list[high];
		  list[high] = pivot;
		  return high;
	  }
	  else
		  return first;
  }
  
  public static <E> void quickSort (E[] list, Comparator<? super E> comparator) {
	  
  }
  
}
/*
Author: 
Date: 

Description: 
*/
import java.util.Comparator;
import java.util.Iterator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    System.out.println("Before: ");
    for (int i = 0; i < list1.length; i++)
        System.out.println(list1[i].getArea() + " ");
    selectionSort(list1, new GeometricObjectComparator());
    System.out.println("After: ");
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");
  }
  
  public static <E> void selectionSort(E[] list, Comparator<? super E> Comparator) {
	  for (int i = 0; i < list.length; ) {
		  if ((i + 1) < list.length && Comparator.compare(list[i], list[i + 1]) == 1) {
			  E temp = list[i];
			  list[i] = list[i + 1];
			  list[i + 1] = temp;
			  i = 0;
		  }
		  else
			  i++;
	  }
	  
	  
  }
}
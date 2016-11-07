/*
“collisions”. Dit wil zeggen dat de HashMap lookUp verder moet zoeken naar het juiste object. Veel collisions kunnen performance doen dalen, maar werkt wel altijd juist
*/


// COMPARABLE INTERFACE bevat 1 methode
/*
- Returns negatief getal, 0 of positief getal	
- Negatief : als this object kleiner is dan o
- 0 als ze gelijk zijn (gebaseerd op .equals methode)
- Positief : als this object groter is dan o
*/
public interface Comparable<T>
{
	public int compareTo(T o);
}

///////////////////////////////////////////////////////////////////////////

// BUBBLESORT
/*
1. Loop door de te sorteren rij van n elementen en vergelijk elk element met het volgende. Verwissel beide als ze in de verkeerde volgorde staan. Schuif dan een stapje op.
2. Loop opnieuw door de rij, maar ga nu door tot het voorlaatste element, omdat het laatste element het grootste in de rij was.
3. Nog een keer, maar negeer dan de twee laatste elementen.
4. Ga zo door tot de hele reeks gesorteerd is.
*/
public int[] bubbleSort (int invoer[]) {
	int i, j, tijdelijk;
	for (j = 0; j < invoer.length; j++) {
		//Voer het volgende n keer uit:
		for (i = 1; i < invoer.length - j; i++) {
			//Elke iteratie een element vroeger stoppen met bubbelen
			//Het "laatste" getal is reeds het grootste
			if (invoer[i-1] > invoer[i]) {
				//Swap indien verkeerde volgorde tussen 2 elementen
				tijdelijk = invoer[i];
				invoer[i] = invoer[i-1];
				invoer[i-1] = tijdelijk;
			}
		}
	}
	return invoer;
}

//BUBBLESORT MET MEER COMMENTAAR
/*
- c ((n-1) + (n-2) + ... + 1) + k + c1(n-1) 
- (n-1) + (n-2) + ... + 1 = n(n-1)/2 
- Dus onze functie wordt  c n*(n-1)/2 + k + c1(n-1) = 1/2c (n2-n) + c1(n-1) + k
- De complexiteit is dus  O(n²).
- Inefficient
- Ter illustratie van sorteeralgoritmes
*/
public int[] bubbleSort(int invoer[]) {
	int i, j , tijdelijk;
	//Definieer een constante k voor de declaratie van i,j,tijdelijk en
	//eenmalige initialisaties van i,j
	for (j = 0; j < invoer.length; j++) {
		//De buitenste loop wordt n-1 keer uitgevoerd
		//Loopconditie checken is constante c1
		for (i = 1; i < invoer.length - j; i++) {
			//De eerste iteratie zijn er n-1 swaps, dan n-2, n-3,..., 1
			if (invoer [i-1] > invoer[i]) {
				//Gebruik een constante c voor de vergelijking
				//Swap en verhogen van i
				tijdelijk = invoer[i];
				invoer[i] = invoer[i-1];
				invoer[i-1] = tijdelijk;
			}
		}
	}
	return invoer;
}

///////////////////////////////////////////////////////////////////////////

//SELECTION SORT
/*
1. Zoek de kleinste waarde in de lijst.
2. Verwissel het met de “eerste” waarde in de lijst.
3. Herhaal de bovenstaande stappen met de rest van de lijst.
*/

/*
- Selection sort heeft (N– 1) + (N– 2) + ... + 1 + 0 ~ N²/ 2 vergelijkingen en N swaps.
- Tijdscomplexiteit T(N)=O(N²)
*/

/*
- O(1) extra space
- O(n2) comparisons 
- T(N)=O(N²)
- O(n) swaps 
- S(N)=O(N)
- Niet adaptief
- Goed voor systemen die weinig geheugen hebben.
*/
for (int i = 0; i < array.length; i++) {
	int minIndex = i;
	for (int j = i + 1; j < array.length; j++) {
		if (array[j] < array[minIndex]) {
			minIndex = j;
		}
	}
	int temp = array[i];
	array[i] = array[minIndex];
	array[minIndex] = temp;
}

///////////////////////////////////////////////////////////////////////////

//INSERTION SORT
/*
- Zoals het sorteren van kaarten in je hand
- Zet de 2de kaart tov kaart 1 op de juiste plaats.
- Kijk naar de volgende kaart en zet deze in de reeds gesorteerde rij links op de juiste plaats
- Doe dit tot het einde van de reeks
*/

/*
- Complexiteit average case
  T(N) = O(N²)
*/

/*
- Eigenschappen :
	1. Simpel algoritme
	2. Efficient voor zeer kleine data sets
	3. Stabiel (verandert relatieve volgorde niet van gelijke waardes)
	4. O(1) extra geheugen nodig
*/

public class MyInsertionSort {
	public static void main(String a[]){
		int[] arr1 = {10,34,2,56,7,67,88,42};
		int[] arr2 = doInsertionSort(arr1);
		for(int i:arr2){
			System.out.print(i);
			System.out.print(", ");
		}
	}
	public static int[] doInsertionSort(int[] input){
		int temp;
		for(int i = 1; i < input.length; i++) {
			for(int j = i; j > 0; j--){
				if(input[j] < input[j-1]){
					temp = input[j];
					input[j] = input[j-];
					input[j-] = temp;
				}
			}
		}
		return input;
	}
}

///////////////////////////////////////////////////////////////////////////

//QUICK SORT
/*
- VERDEEL EN HEERS
- Selecteer een element uit de reeks. Dit wordt het pivot element. Bv middelste element van de reeks.
- Alle elementen kleiner dan de pivot worden in 1 reeks geplaatste, andere in een andere reeks.
- Herhaal dit recursief
*/

/*
https://www.youtube.com/watch?v=RaW6o0hCG4g

- Complexiteit: 
	* T(N) = O(n logn)
	* Worst case O(n²) , reeds gesorteerde reeks
	
- Eigenschappen:
	* Niet stabiel algoritme
	* In place algoritme
	* Makkelijk te combineren met andere sorteer algoritmes
*/

private void quickSort(int lowerIndex, int higherIndex) {
	int i = lowerIndex;
	int j = higherIndex;
	//Calculate pivot number, I am taking pivot as middle index number
	int pivot = array[lowerIndex+(higherIndex - lowerIndex)/2];
	//Devide into two arrays
	while (i < j) {
		/**
		 * In each iteration, we will identify a number from left side which
		 * is greater then the pivot value, and also we will identify a number
		 * from right side which is less then the pivot value
		 * Once the search is done, then we exchange both numbers
		 */
		 while (array[i] < pivot) {
			 i++;
		 }
		 while (array[j] > pivot) {
			 j--;
		 }
		 if (i <= j) {
			 exchangeNumbers(i, j);
			 //Move index to next poistion on both sides
			 i++;
			 j--;
		 }
	}
	//Call quickSort() method recursively
	if (lowerIndex < j)
		quickSort(lowerIndex, j);
	if (i < higherIndex)
		quickSort(i, higherIndex);
}
private void exchangeNumbers(int i, int j){
	int temp = array[i]
	array[i] = array[j]
	array[j] = temp;
}
///////////////////////////////////////////////////////////////////////////

//MERGE SORT
/*
https://www.youtube.com/watch?v=EeQ8pwjQxTM

- Complexiteit: 
	* T(N) = O(n logn) in elk geval

- Eigenschappen:
	* Stabiel algoritme
	* Veel extra geheugen nodig
*/

public static Comparable[] mergeSort(Comparable[] list)
{
	//If list is empty; no need to do anything
	if (list.length <= 1){
		return list;
	}
	
	//Split the array in half in two parts
	Comparable[] first = new Comparable[list.length / 2];
	Comparable[] second = new Comparable[list.length - first.length];
	System.arraycopy(list, 0, first, 0, first.length);
	System.arraycopy(list, first.length, second, 0, second.length);
	
	//Sort each half recursively
	mergeSort(first);
	mergeSort(second);
	
	//Merge both halves together, overwriting to original array
	merge(rist, second, list);
	return list;
}

///////////////////////////////////////////////////////////////////////////

//Binary search

/*
- Invoer is een gesorteerde lijst
- Niet in volgorde afzoeken:
	1. Start in het midden van de lijst
	2. Elimineer helft van de lijst, behoud juiste helft
	3. Herhaal tot element gevonden is
- Recursief 
- Verdeel en heers principe
- Steeds de lijst in de helft delen
- Tijdscomplexiteit
	* O(log n)
*/

public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key){
	if(start < end){
		int med = start + (end - start) / 2;
		if (key < sortedArray[mid]){
			return recursiveBinarySearch(sortedArray, start, mid, key);
		} else if (key > sortedArray[mid]){
			return recursiveBinarySearch(sortedArray, mid+1, end, key);
		}else{
			return mid;
		}
	}
	return -(start + 1);
}






















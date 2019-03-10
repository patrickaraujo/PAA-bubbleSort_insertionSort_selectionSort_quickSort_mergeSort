package ordenacao;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class OrdenacaoTests {

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array.length-1; j++)
				if (array[j] > array[j + 1]){
					int aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
	}
	
	public static void insertionSort(int[] array) {
		int eleito, j;
		for(int i = 1; i < array.length; i++){
			eleito = array[i];
			j = i - 1;

			while((j >= 0 && array[j] > eleito)){
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = eleito;
		}
	}
	
	public static void selectionSort (int array[]){
		for(int i = 0; i < (array.length - 1); i++){
			int min = i;
			for(int j = i + 1; j < array.length; j++)
				if(array[j] < array[min])
					min = j;
			int aux = array[i];
			array[i] = array[min];
			array[min] = aux;
		}
	}
	
	private static void quickSort(int[] array, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(array, inicio, fim);
			quickSort(array, inicio, posicaoPivo - 1);
			quickSort(array, posicaoPivo + 1, fim);
		}
	}

	private static int separar(int[] array, int inicio, int fim) {
		int pivo = array[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (array[i] <= pivo)
				i++;
			else if (pivo < array[f])
				f--;
			else {
				int troca = array[i];
				array[i] = array[f];
				array[f] = troca;
				i++;
				f--;
			}
		}
		array[inicio] = array[f];
		array[f] = pivo;
		return f;
	}
	
	public static void Juntar(int vetor[], int ini, int meio, int fim, int vetAux[]) {
	    int esq = ini;
	    int dir = meio;
	    for (int i = ini; i < fim; ++i) {
	        if ((esq < meio) && ((dir >= fim) || (vetor[esq] < vetor[dir]))) {
	            vetAux[i] = vetor[esq];
	            ++esq;
	        }
	        else {
	            vetAux[i] = vetor[dir];
	            ++dir;
	        }
	    }
	    //copiando o vetor de volta
	    for (int i = ini; i < fim; ++i) {
	        vetor[i] = vetAux[i];
	    }
	}

	public static void mergeSort(int vetor[], int inicio, int fim, int vetorAux[]) {
	    if (!((fim - inicio) < 2)){
			int meio = ((inicio + fim)/2);
			mergeSort(vetor, inicio, meio, vetorAux);
			mergeSort(vetor, meio, fim, vetorAux);
			Juntar(vetor, inicio, meio, fim, vetorAux);
		}
	}

	public static void mergeSort(int array[]) { //função que o usuario realmente chama
	    //criando vetor auxiliar
	    int vetorAux[] = new int[array.length];
	    mergeSort(array, 0, array.length, vetorAux);
	}
	
	public static int [] gerarNums(int n){
		int array[]= new int[n];
		for(int i=0;i<n;i++)
			array[i]=(int)(Math.random()*100);	//	Porque Math.random gera double e só aceita inteiro
		return array;
	}
	
	public static void printArray(int array[]) {
        // Mostra o vetor "array" na tela
        for (int i = 0; i < array.length; i++) {
            if (i == (array.length) - 2) {
                System.out.print("Posição " + i + ": (" + array[i] + ") e ");
            } else if (!(i == (array.length) - 1)) {
                System.out.print("Posição " + i + ": (" + array[i] + "), ");
            } else {
                System.out.print("Posição " + i + ": (" + array[i] + ")");
            }
        }
        System.out.println();
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int array[]= gerarNums(10000);	// 10000
		
		System.out.println("Vetor nao ordenado");
		printArray(array);
		
		long tempoInicial = 0;
		
		
		System.out.println("\nEscolha um algoritmo de ordenação:\n1.\tBubble sort;\n2.\tInsertion sort;\n3.\tSelection sort;\n4.\tQuick sort;\n5.\tMerge sort;\nOutro valor.\tTerminar execução.");
		Scanner entrada = new Scanner(System.in);
		//entrada.nextLine();
		int operacao = entrada.nextInt();
		switch(operacao){
			case 1:
				System.out.println("\nBubble sort\n");
				tempoInicial = System.currentTimeMillis();
				bubbleSort(array);
				break;
			case 2:
				System.out.println("\nInsertion sort\n");
				tempoInicial = System.currentTimeMillis();
				insertionSort(array);
				break;
			case 3:
				System.out.println("\nSelection sort\n");
               	tempoInicial = System.currentTimeMillis();
               	selectionSort(array);
               	break;
             case 4:
               	System.out.println("\nQuick sort\n");
               	tempoInicial = System.currentTimeMillis();
               	quickSort(array, 0, array.length-1);
               	break;
             case 5:
               	System.out.println("\nMerge sort\n");
               	tempoInicial = System.currentTimeMillis();
               	mergeSort(array);
               	break;
             default:
            	 System.out.println("Fim da execução");
		}
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("\nVetor ordenado");
		printArray(array);

		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
		
	}

}

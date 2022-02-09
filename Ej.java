import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Ej {

    public static void main(String[] args){
        Ej Prueba = new Ej();
    }

        //Arreglo
        static int NUMERO = 50;
        Scanner leer = new Scanner(System.in);
        int [] Arreglo =  new int[NUMERO];
        int [] Arreglo2;
        int PasosBusqueda = 0;
        int PasosIngreso = 0;
    public Ej(){
        Llenar();
        System.out.println("Ejercicio Laboratorio");
        int Select;
        do {
            System.out.println("1. Buscar Dato");
            System.out.println("2. Ingresar Dato");  
            System.out.println("3. Ver Arreglo");  
            System.out.println("4. Salir");  
            
            Select = leer.nextInt();

            switch(Select){
                
                case 1:
                    System.out.println("Ingrese el dato a buscar");
                    int Ingreso = leer.nextInt();
                    Arreglo2 = Arreglo;
                    binarySearch(Arreglo,Ingreso);
                    System.out.println("Pasos realizados: " + PasosBusqueda);
                    PasosBusqueda = 0;
                    Arreglo = Arreglo2;
                break;
                case 2:
                    System.out.println("Ingrese el dato a ingresar");
                    int Buscar = leer.nextInt();
                    PasosIngreso = push(Buscar);
                    System.out.println("Pasos realizados: " + PasosIngreso);
                    PasosIngreso = 0;
                    break;
                case 3:
                    Mostrar();
                break;
                default:
                System.out.println("Error");
            }
        } while (Select != 4);
    }

    public int binarySearch(int[] Arr,int NumeroB){
        int size = Arr.length;
        int Mitad = size/2;
        if(Arreglo[Mitad] == NumeroB){
            System.out.println("Encontrado");
            System.out.println("Posicion: " + Mitad);
            PasosBusqueda ++;
        }
        else if(size == 1){
            System.out.println("Numero no encontrado");
        }
        else if(Arr[Mitad] > NumeroB){
            PasosBusqueda++;
            Arreglo = Arrays.copyOfRange(Arr,0,Mitad);
            Mostrar();
            binarySearch(Arrays.copyOfRange(Arr, 0, Mitad), NumeroB);
        }
        else if(Arr[Mitad] < NumeroB){
            PasosBusqueda++;
            Arreglo = Arrays.copyOfRange(Arr, Mitad+1,size);
            Mostrar();
            binarySearch(Arrays.copyOfRange(Arr, Mitad + 1,size), NumeroB);
        }
        return PasosBusqueda;
        
    }

    public int push(int valor){
        int Numero;
        int Numero2;
        for(int i=0;i<Arreglo.length;i++){
            if(Arreglo[i] > valor){
                Numero = Arreglo[i];
                Arreglo[i] = valor;
                for(int x =i+1;x<Arreglo.length;x++){
                    Numero2 = Arreglo[x];;
                    Arreglo[x] = Numero;
                    Numero = Numero2;
                    PasosIngreso++;
                }
                break;
            }
            PasosIngreso++;
        }
        return PasosIngreso;

    }

    public void Llenar(){
        java.util.Random r = new java.util.Random();
        for(int i=0;i<Arreglo.length;i++){
            Arreglo[i] = r.nextInt(100);
        }
        Arrays.sort(Arreglo);
        

    }

    public void Mostrar(){
        for(int i=0;i<Arreglo.length;i++){
            System.out.print(Arreglo[i] + "--");;
        }
        System.out.println("\n");
    }

}
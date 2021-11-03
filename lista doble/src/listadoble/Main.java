package listadoble;
import java.io.*;


class nodo
{
    int dato;
    nodo sig;
    nodo ant;
    nodo(int valor){
        this.dato = valor;
    }
}

class lista
{
    nodo L,aux,aux2;

    void insertar(int numero)
    {
        if (L == null) {
            L = new nodo(numero);
        }else{
            aux = L;
            while (aux.sig != null)
                aux= aux.sig;
            aux.sig = new nodo(numero);
            aux2 = aux;
            aux = aux.sig;
            aux.ant = aux2;
        }
    }
    
    void buscar(int valor){
        aux=L;
        while(aux.sig!=null || aux.dato != valor){
            aux=aux.sig;
        }
        if (aux.dato == valor){
            System.out.println(valor + " Existe dentro de la lista");
        }else{
            System.out.println("valor no encontrado en la lista");
        }
    }
    
    void eliminar(int valor){
        aux=L;
        nodo aux2 = null;
        while(aux.sig!=null || aux.dato != valor){
            aux2=aux;
            aux=aux.sig;
        }
        if (aux.dato == valor){
            if (aux.ant == null) {
                L = L.sig;
                L.ant = null;
            }else if(aux.sig == null){
                aux = aux.ant;
                aux.sig = null; // eliminacion del ultimo.
            }else{
                nodo aux3 = aux.sig;
                aux2.sig = aux3; 
                aux3.ant = aux2;
            }
            System.out.println(valor + " Eliminado de la lista");
        }else{
            System.out.println("valor no encontrado en la lista");
        }
    }
   void sumar(){
       aux = L;
       int sum=0;
       while (aux.sig != null){
           sum+=aux.dato;
           aux=aux.sig;
       }
       System.out.println("La suma de todos los elementos de la lista es: " + sum);
   }
}


public class Main {


    public static void main(String[] args) throws IOException
    {
       InputStreamReader sr=new InputStreamReader(System.in);
       BufferedReader br=new BufferedReader(sr);
       lista ls=new lista();
       String op="S";
       do
       {
           System.out.println("Suministre el numero Digito a Digito");
           ls.insertar(Integer.parseInt(br.readLine()));
           System.out.println("Otro Numero? (s/n)");
           op=br.readLine();
       }
       while (op.equals("S") || op.equals("s"));
            ls.sumar();
    }
}


package lista.simple;
import java.io.*;

class nodo{
    int dato;
    nodo sig;
}

class Lista{
    nodo L;
    nodo aux;
    
    Lista(){
        L = null;
    }
    
    void insertar(int pdato){
        nodo nuevo = new nodo();
        nuevo.dato=pdato;
        nuevo.sig=null;
        if (L==null)
            L=nuevo;
        else {
        aux=L;
        while (aux.sig!=null)
            aux=aux.sig;
        aux.sig=nuevo;
        }
    }
    void mostrar(){
        aux=L;
        String dato="";
        while (aux!=null)
        {
            dato+=aux.dato+",";
            aux=aux.sig;
        }
        dato+=".";
        System.out.print("L--->"+dato);
    }
    void eliminar(int valor){
        aux=L;
        nodo aux2 = null;
        while(aux.sig!=null || aux.dato != valor){
            aux2=aux;
            aux=aux.sig;
        }
        if (aux.dato == valor){
            if (aux == L && aux.dato == valor){
                L = L.sig;
            }else{
                aux2.sig = aux.sig;
            }
            System.out.println(valor + " Eliminado de la lista");
        }else{
            System.out.println("valor no encontrado en la lista");
        }
    }
    void buscar(int valor){
        aux=L;
        if(aux!=null){
            while (aux.sig!=null || aux.dato != valor)
                aux= aux.sig;
            if (aux.dato == valor){
                System.out.println(valor + " Existe dentro de la lista");
            }else{
                System.out.println("valor no encontrado en la lista");
            }
        }
    }
}

class lector{
    BufferedReader br;
    lector(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    String leer() throws IOException{
        return br.readLine();
    }
}

public class ListaSimple {
    public static void main(String[] args) throws IOException{
       lector br = new lector();
       Lista ls=new Lista();
       char op='S';
       while (op!='n'){
           System.out.print("numero a enlistar: ");
           ls.insertar(Integer.parseInt(br.leer()));
           System.out.print("otro numero?");
           op=br.leer().charAt(0);
       }
       // System.out.println("introduzca valor a eliminar");
       // int valor = Integer.parseInt(br.readLine());
       //ls.eliminar(valor);
       ls.mostrar();
    }
}

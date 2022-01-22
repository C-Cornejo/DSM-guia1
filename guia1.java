
import java.util.Scanner;
import java.util.ArrayList;

 class Main
{
  /*
   Desarrollo de los ejercicios complementarios de guia 1
  */  
    public static void  main(String[] args)
    {   
       
      
        Scanner entrada = new Scanner(System.in);
        String continuar;
      do{
        continuar = "s";
        int opcion = 0;
        Ejercicio1 ej1 = new Ejercicio1();
        Ejercicio2 ej2 = new Ejercicio2();
        Ejercicio3 ej3 = new Ejercicio3();
        Ejercicio4 ej4 = new Ejercicio4();


          System.out.println("Desarrollo de guia 1");
          System.out.println("seleccione una opcion");
          System.out.println("1 - Ejercicio 1");
          System.out.println("2 - Ejercicio 2");
          System.out.println("3 - Ejercicio 3");
          System.out.println("4 - Ejercicio 4");
          System.out.println("5 - Salir");

        opcion = Integer.parseInt(entrada.nextLine());
        switch(opcion)
        {
          case 1:
            ej1.principal(entrada);
            break;
          case 2:
            ej2.principal(entrada);
            break;
            case 3:
            ej3.principal(entrada);
            break;
          case 4:
           ej4.principal(entrada);
           break;
          case 5:
           continuar ="n";
          
           break;
          default:
            opcion = 0;
            System.out.println("Seleccione una opcion valida");
            break;
        }
        if(continuar != "n")
        {
          System.out.println("Desea continuar? s/n");
          continuar = entrada.nextLine();
        }
       
      }
      while(continuar.equals("s"));
      
       System.out.println("Adios...");
    }


}// fin class main

class Ejercicio1{

  public void principal(Scanner teclado)
  {
          double num1,num2;
      boolean bandera = false;
       double resultado = 0;

    //teclado = new Scanner(System.in);
    System.out.println("Ingrese el primer numero");
    num1 = Double.parseDouble(teclado.nextLine());;

    System.out.println("Ingrese el segundo numero");
    num2 = Double.parseDouble(teclado.nextLine());
 

     resultado = num1 % num2;
    if (resultado == 0)
    {
      bandera = true;
    }

    if(bandera)
    {
      System.out.printf("Los numeros %.2f y %.2f son divisibles entre si %n",num1,num2);
    }
    else
    {
      System.out.printf("Los numeros %.2f y %.2f NO son divisibles entre si %n",num1,num2);
    }
  }
}


  class Ejercicio2
{
   public void principal(Scanner teclado)
  {
      System.out.println("Ejercicio 2");
      System.out.println("Ingrese notas de 10 alumnos");
      double[] notas = new double[10];
      for(int i=0;i<10;i++)
      {
         System.out.println("Ingrese nota para el alumno "+(i+1));
         notas[i] = Double.parseDouble(teclado.nextLine());
      }
      int menores=0,mayores=0;
     
      for(int i=0;i<10;i++)
      {
        if(notas[i]<7)
        {
          menores += 1;
        }else
        {
          mayores += 1;
        }
      }
    System.out.println("La cantidad de alumnos con notas menores a 7 es: "+menores);
    System.out.println("La cantiad de alumnos con notas mayores o iguales a 7 es: "+mayores);
      
  }
}

  class Ejercicio3
{
   public void principal(Scanner teclado)
  {
      String continuar = "";
      System.out.println("Ejercicio 3");
      System.out.println("Ingrese al menos 1 numeros");
      ArrayList<Integer> numeros = new ArrayList<Integer>();
      do
      {
        System.out.println("Ingrese un numero entero");
        numeros.add(Integer.parseInt(teclado.nextLine()));

        System.out.println("Desea continuar agregando numeros? s/n");
        continuar = teclado.nextLine();
      }while(continuar.equals("s"));
      

      int pares = 0, impares = 0;

      for(int actual: numeros)
      {
         if((actual % 2) == 0)
         {
           pares += 1;
         }
         else
         {
           impares += 1;
         }
      }
    System.out.println("El numero de pares es: "+pares);
    System.out.println("El numero de impares es: "+impares);

  }
}// fin ejercicio 3

class Ejercicio4{

  class Coordenada
  {
    private int x;
    private int y;
    private String cuadrante;

    public String getCuadrante() {
      return cuadrante;
    }
    public Coordenada(){}
    public Coordenada(int equis,int ye)
    {
      x = equis;
      y = ye;
      calcularUbicacion();
    }

    public void calcularUbicacion()
    {
        if(x == 0 || y == 0)
        {
          cuadrante = "Esta coordenada esta sobre un eje.";
        }
       if(x > 0)
       {
          if(y > 0){
            cuadrante = "primero";
          }
          if(y < 0)
          {
            cuadrante = "cuarto";
          }
       }
       if(x < 0){
         if(y > 0){
            cuadrante = "segundo";
          }
          if(y < 0){
            cuadrante = "tercero";
          }
       }   
    }
  }

public void principal(Scanner teclado)
  {
    int cantidad = 0;
    ArrayList<Coordenada> puntos = new ArrayList<Coordenada>();
    System.out.println("Ejercicio 4"); 
    System.out.println("Identificacion de puntos en el plano");
    System.out.println("Cuantos puntos quiere evaluar?");
    cantidad = Integer.parseInt(teclado.nextLine());
    
    for(int i=0;i<cantidad;i++)
    {
        System.out.println("Ingrese el punto numero "+(i+1) + " como x,y");
        puntos.add(ordenar(teclado.nextLine()));

    }
    int primero = 0,segundo = 0,tercero = 0,cuarto = 0;
    for(Coordenada actual: puntos)
    {
      if(actual.getCuadrante().equals("primero")){
        primero += 1;
      }
      if(actual.getCuadrante().equals("segundo")){
        segundo += 1;
      }
      if(actual.getCuadrante().equals("tercero")){
        tercero += 1;
      }
      if(actual.getCuadrante().equals("cuarto")){
        cuarto += 1;
      }
    }

    System.out.println("Los puntos que pertenecen al primer plano son:"+primero);
    System.out.println("Los puntos que pertenecen al segundo plano son:"+segundo);
    System.out.println("Los puntos que pertenecen al tercer plano son:"+tercero);
    System.out.println("Los puntos que pertenecen al cuarto plano son:"+cuarto);



}
 public Coordenada ordenar(String entrada)
    {
        String[] cadena = entrada.split(",");
        //Se deberia validar que se ingresen solo dos valores
        Coordenada c = new Coordenada(Integer.parseInt(cadena[0]),Integer.parseInt(cadena[1]));
        System.out.println(c.getCuadrante());
        return c;
    }

}
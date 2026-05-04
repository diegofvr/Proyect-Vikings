package bucles;

public class buclesWhile {
public static void main(String[]args){

  int saldo = 60;
  while (saldo > 0){
      saldo = saldo -10;
      System.out.println("Retirando 10$. Tienes de saldo: " + saldo);
  }
    System.out.println("Sin saldo");


  String[] invitados = {"Ana","Pedro","Luis","Sara"};
  int i = 0;

  while (i <invitados.length ){
      System.out.println("¿Es "+ invitados[i] + " el que buscamos?");
      if (invitados[i].equals("Luis")){
          System.out.println("Encontramos a Luis en la posicion :" + i);
      }
      i++;
  }


  int contador = 10;
  while (contador > 0 ){

      System.out.println("Despegue en " + contador);
      contador --;
  }
  System.out.println("¡IGNICION!");

  int tabla = 10;
  int j = 1;

  while (j <= 10){
      System.out.println(tabla + " * " + j + " = " + (tabla * j));
      j++;
  }

  int[] numeros = {10, 20, 30, 40, 50};
  int k = 0;

  while (k < numeros.length){
      System.out.println("El doble de " + numeros[k] + " es de " + (numeros[k] * 2)  );
      k++;

  }

  double[] preciosCarritos = {19.99, 5.50, 10.00,120.00};
  int n = 0;
  double total = 0;

  while(n < preciosCarritos.length){
      total = total + preciosCarritos[n];
      n++;
      }
  System.out.println("El total es: $" + total);



  int[] idsAutorizados = {101,102,105,110,120};
  int m = 0;
  int idABuscar = 99;
  boolean accesoConcedido = false;

  while (m < idsAutorizados.length){
      if (idsAutorizados[m] == idABuscar){
          accesoConcedido = true;
      }
      m++;
  }
  if (accesoConcedido){
      System.out.println("Bienvenido, el ID es valido");
  }else{
      System.out.println("Acceso denegado");
  }

  double[] inventario = {20.0, 65.0, 8.0, 52.0, 12.0};
  int b = 0;
  double totalConDescuento = 0;

  while(b < inventario.length){
      if (inventario[b] > 50){
          totalConDescuento = totalConDescuento + (inventario[b] -10);
      }else{
          totalConDescuento = totalConDescuento + inventario[b];
      }
      b++;
  }
  System.out.println("Su total es: $" + totalConDescuento);

    double[] notas = {8.5, 4.0, 7.2, 5.5, 9.0, 3.0};
    int s = 0;
    int aprobados = 0;
    int reprobados = 0;
    double sumaTotal = 0;

    while(s < notas.length){
        sumaTotal = sumaTotal + notas[s];
        if(notas[s] >= 6.0){
            aprobados++;
        }else{
           reprobados++;
        }
        s++;
    }
    double promedio = sumaTotal / notas.length;

    System.out.println("La cantidad de aprobados son: " + aprobados );
    System.out.println( "La cantidad de reprobados son: " + reprobados);
    System.out.println( "El promedio es: " + promedio);


    int[] existencias = {15, 0, 8, 30, 0, 5, 12, 0};
    int v = 0;
    int estantesVacios = 0;
    int totalProductos = 0;
    int stockAlto = 0;


    while(v < existencias.length) {
        // 1. Sumar al total SIEMPRE (No depende de ningún if)
        totalProductos = totalProductos + existencias[v];

        // 2. Misión: Contar vacíos
        if (existencias[v] == 0) {
            estantesVacios++;
        }

        // 3. Misión: Contar Stock Alto (Pusiste > 20, el reto decía 20 o más, sería >= 20)
        if (existencias[v] >= 20) {
            stockAlto++;
        }

        v++; // El motor que nunca debe faltar
    }

    System.out.println("La cantidad de estantes vacios son: " + estantesVacios );
    System.out.println( "Total productos en tienda :" + totalProductos);
    System.out.println( "Total productos con Stock alto :" + stockAlto);



    int[] ids = {101, -5, 102, 103, -1, 104, -8};
    int p = 0;
    int errores = 0;

    while(p < ids.length){
        if(ids[p] < 0){

            errores++;
            System.out.println("Error detectado en la posición: " + p);
        }
        p++;
    }
    System.out.println("La cantidad de numeros en negativo son: " + errores);




    int[] pesos = {80, 120, 150, 70, 110, 90};
    int l = 0;
    int sumaPesos = 0;

    while (l < pesos.length){
        sumaPesos = sumaPesos + (pesos[l]);
        if (sumaPesos > 500){
            System.out.println("¡CUIDADO! capacidad superada por " + (sumaPesos -500));

        }
        l++;
    }
    System.out.println("Peso total: " + sumaPesos);

    String[] productos3 = {"Teclados", "Mouse", "Monitores", "Cables HDMI", "Webcams"};
    int[] stock5 = {12, 3, 0, 15, 2};

    int o = 0;
    int contadorCriticos = 0; // Mejor nombre para no confundirnos

    while (o < productos3.length) {
        if (stock5[o] == 0) {
            System.out.println("❌ AGOTADO: " + productos3[o]);
            contadorCriticos = contadorCriticos + 1; // Sumamos 1 al contador
        }
        else if (stock5[o] < 5) {
            System.out.println("⚠️ ALERTA (Bajo stock): " + productos3[o]);
            contadorCriticos = contadorCriticos + 1; // Sumamos 1 al contador
        }
        else {
            System.out.println("✅ DISPONIBLE: " + productos3[o]);
        }

        o++;
    }

    System.out.println("-------------------------------------------");
    System.out.println("Resumen: Tienes " + contadorCriticos + " productos en estado crítico.");


    String[] clientes5 = {"Juan", "Maria", "Pedro", "Ana", "Luis", "Carla"};
    String[] membresias = {"Normal", "VIP", "Normal", "VIP", "VIP", "Normal"};

    int w = 0;

    while (w < clientes5.length) {
         if (membresias[w].equals("VIP")) {
             System.out.println("Cliente " + clientes5[w] + " tiene el 20%  de descuento ");
         }else {
             System.out.println("Cliente " + clientes5[w] + " no tiene descuento" );
         }
        w++;
    }


}
}


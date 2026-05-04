package arrays;

public class ejerciciosArrays {
    public static void main (String[]args){


        String[] productos = {"Laptop", "Mouse","Teclado", "Monitor"};

        for (int i = 0; i < 4; i++){
            if (productos[i].equals("Mouse")) {
                System.out.println("El producto esta con el 50% de descuento: " + productos[i]);
            }else{
                System.out.println("Producto: " + productos[i]);
            }
        }


        String[] nombres = {"Teclado","Mouse","Monitor"};
        double[] precios = {25.0,15.0,180.0};

        for (int i = 0; i < 3; i ++){
            if (nombres[i].equals("Monitor")){
                System.out.println("El monitor cuesta: $" + precios[i]);
            }else{
                System.out.println("Producto: " + nombres[i]);
            }
        }

        String[]  colores ={"Rojo","Azul","Verde"};

        for (int i = 0; i < 3;i++ ){// aca estamos insertanto el ( i + 1) //
            System.out.println("Color " + ( i + 1) + ": " + colores[i]);
        }

        double[] precios1 = {10.50,20.0,30.50};

        for (int i = 0; i < 3; i++){
            System.out.println("Precio producto #" + (i + 1) + ": " + precios1[i]);
        }

        double[] gastos = {10.50, 20.0, 30.50, 45.0, 5.0}; // Nota que ahora hay 5 elementos

// .length contará automáticamente que hay 5
        for (int i = 0; i < gastos.length; i++) {
            System.out.println("Gasto #" + (i + 1) + ": $" + gastos[i]);
        }

        double[] precios2 = {120.0, 45.0, 800.0, 15.0, 300.0};

        for (int i = 0; i < precios2.length; i++ ){
            if (precios2[i] >= 200.0){
                System.out.println("Producto premiun");
            }else {
                System.out.println("Producto accesible");
            }
            System.out.println("Precio producto #" + (i + 1) + " :$" + precios2[i]);
        }


        int[] inventario = {10, 2, 8, 1, 15};
        String[] productos1 = {"Laptop", "Mouse", "Teclado", "Monitor", "Cables"};

        for (int i = 0; i < inventario.length; i++ ){
            if (inventario[i] < 5){
                System.out.println("ALERTA: El producto " + productos1[i] + " está por agotarse (Quedan " + inventario[i] + ")");
            }else{
                System.out.println("Producto: " + productos1
                        [i] + " tiene stock suficiente (" + inventario[i] + ")");
            }
        }







    }
}

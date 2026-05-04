package bucles;

public class variablesEjercicios {
    public static void main(String[]args) {

        int a = 5;
        int b = 10;
        int aux; // El vaso vacío

        aux = a; // Guardamos el 5 en aux
        a = b;   // Ahora 'a' vale 10
        b = aux; // Ahora 'b' vale el 5 que guardamos en aux


        int num1 = 20;
        int num2 = 8;

        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multi: " + (num1 * num2));
        System.out.println("Divi: " + (num1 / num2)); // Dará 2 por ser división entera

        int num = 1;


        // 4. Positivo, Negativo o Cero
        if (num > 0) {
            System.out.println("Positivo");
        } else if (num < 0) {
            System.out.println("Negativo");
        } else {
            System.out.println("Es cero");
        }

        int edad = 28;

// 5. Mayor de edad
        if (edad >= 18) {
            System.out.println("Puede ingresar");
        } else {
            System.out.println("No puede ingresar");
        }


        double precioCereal = 4.50;
        int cantidadCereal = 3;

        double precioLeche = 1.20;
        int cantidadLeche = 2;

        double saldoInicial = 50.00;
        double tasaIVA = 0.10; // 10%

        // 2. Cálculo del subtotal
        double subtotal = (precioCereal * cantidadCereal) + (precioLeche * cantidadLeche);

        // 3. Cálculo del impuesto (IVA)
        double impuesto = subtotal * tasaIVA;

        // 4. Cálculo del total final
        double totalFinal = subtotal + impuesto;

        // 5. Cálculo del saldo restante
        double saldoRestante = saldoInicial - totalFinal;

        // Impresión de resultados con mensajes claros
        System.out.println("--- RECIBO DE COMPRA ---");
        System.out.println("Subtotal de productos: $" + subtotal);
        System.out.println("Impuesto (IVA 10%): $" + impuesto);
        System.out.println("Total a pagar: $" + totalFinal);
        System.out.println("------------------------");
        System.out.println("Saldo inicial: $" + saldoInicial);
        System.out.println("Saldo restante en tarjeta: $" + saldoRestante);


        int edadi = 18;
        double dinero = 19.5;

        if (edadi < 18) {
            System.out.println("Accedo denegado: Menor de edad");
        } else if (dinero < 20) {
            System.out.println("Acceso denegado: Dinero insuficiente");
        } else {
            System.out.println("¡Bienvenido al club! Disfruta la noche");
        }


        int nivelDeGasolina = 19;

        if (nivelDeGasolina == 100) {
            System.out.println("Tanque lleno");
        } else if (nivelDeGasolina > 20) {
            System.out.println("Suficiente");
        } else if (nivelDeGasolina > 1) {
            System.out.println("¡ALERTA!");
        } else if (nivelDeGasolina == 0) {
            System.out.println("¡Detenido!");
        }


        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Producto #5 roto - Saltando");
            } else {
                System.out.println("Enviando producto # " + i);
            }
        }


        double consumoTotal = 85;
        int personas = 3;

        double impuesto1 = consumoTotal * 0.08; // valor del impuesto //

        double propina = consumoTotal * 0.15; // valor de la propina //

        double totalCuenta = consumoTotal + propina + impuesto1;


        double cadaUnoDebePagar = totalCuenta / 3;


        // Impresión de resultados con mensajes claros
        System.out.println("--- RECIBO DE COMPRA ---");
        System.out.println("Impuesto (IVA 8%): $" + impuesto1);
        System.out.println("Total a pagar: $" + totalCuenta);
        System.out.println("------------------------");
        System.out.println("Cuenta divida en 3: $" + cadaUnoDebePagar);

        double tarifaBase = 2.50;
        double precioPorKilometro = 1.50;
        int kilometrosRecorridos = 12;

// 1. Calculamos el costo base del viaje
        double costoDeViaje = tarifaBase + (kilometrosRecorridos * precioPorKilometro);

// 2. Por defecto, el total es el costo de viaje
        double totalFinal2 = costoDeViaje;

// 3. Solo si es caro, le sumamos el recargo
        if (costoDeViaje > 20) {
            totalFinal2 = costoDeViaje + 3.0; // Sobrescribimos el total
            System.out.println("Se aplicó un recargo de servicio de $3.00");
        }

// 4. Imprimimos el resultado final afuera para que sirva para ambos casos
        System.out.println("Costo base: $" + costoDeViaje);
        System.out.println("TOTAL FINAL A PAGAR: $" + totalFinal2);


    }

    }
package bucles;

public class Variables {
    public static void main(String[] args) {


        for (int i = 1; i <= 10; i++){//aca estoy sumando//
            System.out.println("Resultado : "+ i);
        }


        for (int i = 20; i >= 1; i--){ // aca estoy restando //
            System.out.println("Resultado : "+ i);
        }



        for (int i = 1; i <= 50; i++){ // aca si no estoy mal estoy mirando los numeros pares//
            if (i % 2 == 0){
                System.out.println("Resultado : "+ i);
            }
        }

        int suma = 0;
        for (int i =1; i <= 100; i++){
            suma += i;
        }
        System.out.println("El resultado total es: "+ suma);

        int tabla = 7;
        for (int i = 1; i <= 10; i++){
            System.out.println(tabla + " * " + i + " = " + (tabla * i));
        }
        int contador = 0;

        for (int i = 1; i <= 100; i++){
            if (i % 2 != 0){
                contador++;
                }
            }
        System.out.println("Estos son los numeros: "+ contador);


        for (int i = 10;i >= 1; i--){ // esto es para una cuenta regresiva//
            System.out.println("Despegue en :" + i);
        }
        System.out.println("Despegue");


        for (int i = 1; i <= 3; i++){ // asi es para anidar for//
            System.out.println("Esta es la serie :" + i);
            for (int j = 1; j <= 5; j++){
                System.out.println("Sentadilla  # " + j);
            }
        }


        int totalDeSentadillas = 0;

        for (int i = 1; i <= 3; i++){ // asi es para anidar for//
            System.out.println("Esta es la serie :" + i);
            for (int j = 1; j <= 5; j++){
                totalDeSentadillas++;
                System.out.println("Sentadilla  # " + j);
            }
        }
        System.out.println("Gran total de sentadillas  :" + totalDeSentadillas );

        for (int i = 1; i <= 10; i++){ // esto es para ir conociendo el if y else
            if (i == 1){
                System.out.println("Inicio del conteo :" + i);
            } else if (i == 10) {
                System.out.println("Fin del conteo :" + i);

            }else{
                System.out.println("Numero :" + i);

        }
        }

        for (int i = 1; i <= 10; i++){
            if (i == 6){
                System.out.println(i + ": Eres el ganador ");
            }if (i % 2 == 0){
                System.out.println(i + ": Pasa a la ventanilla A ");
            }else{
                System.out.println(i + ": Pasa a la ventanilla B ");
            }

        }


        String nombre = "Diego";
        int edad = 28;
        double altura = 1.75;

        System.out.println("Nombre = " + nombre + "/ Edad = " + edad + "/ Altura = " + altura);











        }
        

    }






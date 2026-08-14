import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> conceptos=new ArrayList<>();
        ArrayList<String> categorias=new ArrayList<>();
        ArrayList<Double> montos =new ArrayList<>();
        Scanner entrada=new Scanner(System.in);

        System.out.println("\n Gestor semanal de gastos");

        registrarGasto(conceptos, categorias, montos,entrada);
    }

    public static void registrarGasto(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            Scanner entrada){

        String[] listaCategorias={"Alimentos","Transporte","Materiales escolares", "Entretenimiento", "Otros"};
        String concepto;
        int catNumber;
        double monto;

        //Introduce el gasto
        System.out.print("\n Introduce tu gasto: ");
        concepto=entrada.nextLine();
        //Ciclo para pedir y validar categoría correspondiente al gasto que debe estar entre 0 y 4
        do {
            System.out.println("Elije la categoría correspondiente a tu gasto");
            int i=0;
            for(String categoria:listaCategorias)
            {
                System.out.println("\t "+i+")"+categoria);
                i++;
            }
            System.out.print("Introduce el número de categoría: ");
            catNumber=entrada.nextInt();

            if (catNumber<0 || catNumber>4){
                System.out.println("Las categorías disponibles están entre 0 y 4");
            }
        } while (catNumber<0 || catNumber>4);

        //Ciclo para pedir y validar el monto del gasto que debe ser mayor que cero
        do {
            System.out.print("Introduce el monto: ");
            monto = entrada.nextDouble();
            if (monto<=0)
            {
                System.out.println("El monto del gasto debe ser mayor a 0");
            }
        }while (monto<=0);

        //agregar los datos introducidos a los ArrayList correspondientes
        conceptos.add(concepto);
        categorias.add(listaCategorias[catNumber]);
        montos.add(monto);

    }



}

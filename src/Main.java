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
        registrarGasto(conceptos, categorias, montos,entrada);
        mostrarGastos(conceptos, categorias, montos);
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
            catNumber=Integer.parseInt(entrada.nextLine());

            if (catNumber<0 || catNumber>4){
                System.out.println("Las categorías disponibles están entre 0 y 4");
            }
        } while (catNumber<0 || catNumber>4);

        //Ciclo para pedir y validar el monto del gasto que debe ser mayor que cero
        do {
            System.out.print("Introduce el monto: ");
            monto = Double.parseDouble(entrada.nextLine());
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

    public static void mostrarGastos(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos)
    {
        System.out.println("GASTOS REGISTRADOS ");
        for (int i=0;i<conceptos.size();i++){
            System.out.print(conceptos.get(i)+"\t|"+ categorias.get(i)+"\t|"+montos.get(i)+"\n");
        }
    }

    public static double calcularTotal(ArrayList<Double> montos){
        Double total=0.0;
        if (!montos.isEmpty()){
            for (Double monto:montos)
            {
                total+=monto;
            }

        }
        return total;
    }

    public static int obtenerPosicionGastoMayor(ArrayList<Double> montos) {
        int indexGastoMayor=-1;
        Double montoMayor = 0.0;

        if (!montos.isEmpty()) {
            for (int i = 0; i < montos.size(); i++) {
                if (montos.get(i) > montoMayor) {
                    montoMayor = montos.get(i);
;                    indexGastoMayor = i;
                }
            }
        }
        return indexGastoMayor;
    }

    public static double calcularTotalPorCategoria (ArrayList<String> categorias,
                                                    ArrayList<Double> montos,
                                                    String categoriaBuscada) {
        double flagMonto=-1;
        if (!categorias.isEmpty()){
            for (int i=0;i<categorias.size();i++){
                if(categorias.get(i).equals(categoriaBuscada)){
                    return montos.get(i);
                }
            }
        }
        return flagMonto;
    }

    public static void mostrarResumen(
                                    ArrayList<String> conceptos,
                                    ArrayList<String> categorias,
                                    ArrayList<Double> montos
                                    ) {

        if (!conceptos.isEmpty())
        {   int numeroGastos=0;
            Double gastoTotal=0.0;
            Double promedio=0.0;
            int indiceMayor=obtenerPosicionGastoMayor(montos);

            numeroGastos=conceptos.size();
            gastoTotal=calcularTotal(montos);
            System.out.println("\nRESUMEN SEMANAL\n");
            System.out.println("Número de gastos: "+numeroGastos);
            System.out.println("Gasto total"+gastoTotal);
            System.out.println("Promedio por gasto"+gastoTotal/numeroGastos);
            System.out.println("Gasto mayor: "+conceptos.get(indiceMayor)+" , "+ montos.get(indiceMayor));
        } else {
            System.out.println("No hay gastos registrados en la semana");
        }

    }
}

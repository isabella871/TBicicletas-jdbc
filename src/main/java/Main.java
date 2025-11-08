import java.util.Scanner;

import model.Bicicletas;
import model.Ventas;
import repository.BicisRepository;
import repository.VentasRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("- - - - - M E N Ú - - - - - \n 1. Menú bicicletas \n 2. Menú ventas \n 3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuBici();
                    break;

                case 2:
                    menuVentas();
                    break;
            
                default:
                System.out.println("La opción no se encuentra en el mneú, intente nuevamente");
                    break;
            }
        }while (opcion != 3); 
            scanner.close();
    }



    public static void menuBici(){
        Scanner scanner = new Scanner(System.in);
        BicisRepository bicisRepository = new BicisRepository();
        int mBici;

        do{
            System.err.println("- - - - - Menú Bicicletas - - - - - \n 1. Agregar Bicicletas \n 2. Listar Bicicletas \n 3. Actualizar Datos Bicicletas \n 4. Eliminar Datos Bicicletas \n 5. Salir y dirijirse al menú principal");
            System.out.print("Seleccione una opción: ");
            mBici = scanner.nextInt();

            switch (mBici) {
                case 1:
                    System.out.print("\n ----- INGRESAR DATOS ----- \n Ingrese el modelo: ");
                    String modelo = scanner.next();

                    System.out.print("Ingrese el precio: ");
                    Integer precio = scanner.nextInt();

                    System.out.print("Ingrese el stock: ");
                    Integer stock = scanner.nextInt();

                    Bicicletas bici = new Bicicletas(modelo, precio, stock);
                    bicisRepository.agregarBici(bici);
                    break;

                case 2:
                    System.out.println("\n Lista Bicicletas");
                    bicisRepository.listarBici();
                    break;

                case 3:
                    System.out.println("\n ------- ACTUALIZAR DATOS ------");
                    System.out.print("Ingrese el id:");
                    Integer id = scanner.nextInt();

                    System.out.print("Ingrese el nuevo modelo: ");
                    String mModelo = scanner.nextLine();
                    scanner.next();

                    System.out.print("Ingrese el nuevo precio: ");
                    Integer mPrecio = scanner.nextInt();

                    System.out.print("Ingrese el nuevo stock: ");
                    Integer mStock = scanner.nextInt();

                    Bicicletas editarBici = new Bicicletas(id, mModelo, mPrecio, mStock);
                    editarBici.setId(id);
                    bicisRepository.actualizarBici(editarBici);
                    break;

                case 4:
                    System.out.println("\n ------ ELIMINAR DATOS ------");
                    System.out.print("Ingrese el id: ");
                    Integer idBD = scanner.nextInt();

                    Bicicletas eliminarB = new Bicicletas(idBD);
                    eliminarB.setId(idBD);
                    bicisRepository.eliminarDatos(eliminarB);
                    break;

                default: System.out.println(". . . saliendo . . .");
                    break;
            }
        }while (mBici != 5);
        scanner.close();
    }


    public static void menuVentas(){
        Scanner scanner = new Scanner(System.in);
        VentasRepository ventasRepository = new VentasRepository();
        int vMenu;
        
        do{
            System.out.println("- - - - - - Menú Ventas - - - - - \n 1. Agregar Venta \n 2. Listar Ventas \n 3. Eliminar Venta \n 4. Salir del menú ");
            System.out.print("Seleccione una opción: ");
            vMenu = scanner.nextInt();

            switch (vMenu) {
                case 1:
                    System.out.print("- - - - - - Agregar datos - - - - - - \n Ingrese el id de la bicicleta: ");
                    Integer idBici = scanner.nextInt();

                    System.out.print("Ingrese la cantidad: ");
                    Integer cantidad = scanner.nextInt();

                    System.out.print("Ingrese la fecha (yyyy-MM-dd): ");
                    String fecha = scanner.next();

                    Ventas aVenta = new Ventas(idBici, cantidad, fecha);
                    ventasRepository.agregarVenta(aVenta);
                    break;

                case 2: 
                    System.out.println("- - - - - - - LISTA DE VENTAS - - - - - -");
                    ventasRepository.listarVentas();
                    break;

                case 3:
                    System.out.println("\n ------ ELIMINAR DATOS ------");
                    System.out.print("Ingrese el id: ");
                    Integer idventa = scanner.nextInt();

                    Ventas dVentas = new Ventas(idventa);
                    dVentas.setId(idventa);
                    ventasRepository.eliminarVenta(dVentas);
                    break;
            
                default: System.out.println(". . . . saliendo . . . .");
                    break;
            }
        }while (vMenu !=4);
        scanner.close();
    }
}

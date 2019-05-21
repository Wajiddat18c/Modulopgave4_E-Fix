package dat18c.modulopgave.efix.logic;
import java.util.ArrayList;
import java.util.Scanner;
public class RepairBlanket {

    public static void main(String[] args) {
        repair();
    }

    public static void repair() {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> item = new ArrayList<String>();
        ArrayList<String> information = new ArrayList<String>();
        boolean isnumber;

        System.out.println("Generel information om problemet:");
        String info = scan.nextLine();
        item.add(info);

        System.out.println("Årgang: ");
        String aargang = scan.nextLine();
        item.add(aargang);

        System.out.println("Model:");
        String model = scan.nextLine();
        item.add(model);

        System.out.println("Serie nummer:");
        String serieNummer = scan.nextLine();
        item.add(serieNummer);

        System.out.println("Operativ System:");
        String operativSystem = scan.nextLine();
        item.add(operativSystem);

        System.out.println("Password(Hvis der password):");
        String password = scan.nextLine();
        item.add(password);

        System.out.println("Fulde navn:");
        String navn = scan.nextLine();
        information.add(navn);

        System.out.println("Fulde Adresse:");
        String adresse = scan.nextLine();
        information.add(adresse);

        System.out.println("Telefon Nummer:");
        String nummer = scan.nextLine();
        information.add(nummer);

        System.out.println("Email:");
        String email = scan.nextLine();
        information.add(email);

        System.out.println("Dato");
        String dato = scan.nextLine();
        information.add(dato);


        System.out.println("Beskrivelse");
        for (String str : item) {
            System.out.println("Info: " + str);

        }

        System.out.println("KontaktOplysninger");
        for (String inf : information) {
            System.out.println("Oplysninger: " + inf);

        }
    }

}

package dat18c.modulopgave.efix.logic;

import java.util.HashMap;
import java.util.Scanner;

public class PriceCalculator {
    public static void main(String[] args) {
        calculatePhonePrice();
    }


    public static void calculatePhonePrice(){
        String cond = "Tast 1: Bad\nTast 2: Decent \nTast 3: Good";
        HashMap<String, Integer> phone = new HashMap<String, Integer>();
        phone.put("Iphone X", 6000);
        phone.put("Samsung S9", 5600);
        phone.put("Huawei P20", 4000);
        phone.put("Iphone 4", 1200);

        int bad = 8;
        int decent = 3;
        double good = 1.5;

        Scanner scan = new Scanner(System.in);

        System.out.println("Vælg din mobil du vil sælge: \n" +
                "Tast 1: Iphone x \n" +
                "Tast 2: Samsung S9\n" +
                "Tast 3: Huawei P20\n" +
                "Tast 4: Iphone 4");
        int tal = scan.nextInt();
        switch (tal) {
            case 1:
                System.out.println("Du valgte Iphone X\nVælg din smartphones condition");
                System.out.println(cond);
                int pick = scan.nextInt();
                if (pick == 1) {
                    int a = phone.get("Iphone X") / bad;
                    System.out.println("Buy value:" + a);
                }else if(pick == 2){
                    int a = phone.get("Iphone X") / decent;
                    System.out.println("Buy value:" + a);
                }else if (pick == 3){
                    int a = (int) (phone.get("Iphone X") / good);
                    System.out.println("Buy value:" + a);
                }
                break;
            case 2:
                System.out.println("Du valgte Samsung S9\nVælg din smartphones condition");
                System.out.println(cond);
                pick = scan.nextInt();
                if (pick == 1) {
                    int a = phone.get("Samsung S9") / bad;
                    System.out.println("Buy value:" + a);
                }else if(pick == 2){
                    int a = phone.get("Samsung S9") / decent;
                    System.out.println("Buy value:" + a);
                }else if (pick == 3){
                    int a = (int) (phone.get("Samsung S9") / good);
                    System.out.println("Buy value:" + a);
                }
                break;

            case 3:
                System.out.println("Du valgte Huawei P20\nVælg din smartphones condition");
                System.out.println(cond);
                pick = scan.nextInt();
                if (pick == 1) {
                    int a = phone.get("Huawei P20") / bad;
                    System.out.println("Buy value:" +a);
                }else if(pick == 2){
                    int a = phone.get("Huawei P20") / decent;
                    System.out.println("Buy value:" + a);
                }else if (pick == 3){
                    int a = (int) (phone.get("Huawei P20") / good);
                    System.out.println("Buy value:" + a);
                }
                break;

            case 4:
                System.out.println("Du valgte Iphone 4\nVælg din smartphones condition");
                System.out.println(cond);
                pick = scan.nextInt();
                if (pick == 1) {
                    int a = phone.get("Iphone 4") / bad;
                    System.out.println("Buy value:" + a);
                }else if(pick == 2){
                    int a = phone.get("Iphone 4") / decent;
                    System.out.println("Buy value:" + a);
                }else if (pick == 3){
                    int a = (int) (phone.get("Iphone 4") / good);
                    System.out.println("Buy value:" + a);
                }
                break;

            default:
                System.out.println("Wrong input!");
        }

    }
}

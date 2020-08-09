
import java.lang.Math;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main(String[] args) {
        instructions();

    }
    public static void introduction(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
    public static void amount(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        System.out.print("> ");
        int cups = input.nextInt();
        int water = 200 * cups;
        int milk = 50 * cups;
        int beans = 15 * cups;
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + "g of coffee beans");
    }
    public static void supplies(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        System.out.print("> ");
        int waterS = input.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        System.out.print("> ");
        int milkS = input.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        System.out.print("> ");
        int beansS = input.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        System.out.print("> ");
        int coffeeR = input.nextInt();
        int coffeeA = Math.min(waterS/200,Math.min(milkS/50,beansS/15));
        int coffeePlus = coffeeA - coffeeR;
        if (coffeeA == coffeeR){
            System.out.println("Yes, I can make that amount of coffee.");
        }else if (coffeeA > coffeeR){
            System.out.println("Yes, I can make that amount of coffee (and even "+ coffeePlus +" more than that)");
        }else {
            System.out.println("No, I can make only " + coffeeA + " cup(s) of coffee");
        }
    }
    public static void instructions() {
        Scanner input = new Scanner(System.in);
        int water = 400, milk = 540, beans = 120, cups = 9, money = 550;
        String action = "";
        boolean notEqualExit = true;
        while (notEqualExit == true){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = input.next();
            if (action.equals("exit")){
                notEqualExit = false;
            }
            System.out.println(" ");
            switch(action){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String which = input.next();
                    switch(which){
                        case "1":
                            int waterR = 250, milkR = 0, beansR = 16, cupsR = 1, moneyR = 4;
                            if(water >= waterR && beans >= beansR && cups >= cupsR) {
                                System.out.println("I have enough resources, making you coffee!");
                                water -= waterR;
                                beans -= beansR;
                                money += moneyR;
                                cups -= cupsR;
                            } else {
                                if (water < waterR){
                                    System.out.println("Sorry, not enough water!");
                                }else if (beans < beansR){
                                    System.out.println("Sorry, not enough beans!");
                                }else {
                                    System.out.println("Sorry, not enough cups!");
                                }
                            }
                            break;
                        case "2":
                            waterR = 350; milkR = 75; beansR = 20; cupsR = 1; moneyR = 7;
                            if(water >= waterR && milk >= milkR && beans >= beansR && cups >= cupsR) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= waterR;
                                milk -= milkR;
                                beans -= beansR;
                                money += moneyR;
                                cups -= cupsR;
                            } else {
                                if (water < waterR){
                                    System.out.println("Sorry, not enough water!");
                                }else if (milk < milkR) {
                                    System.out.println("Sorry, not enough milk!");
                                }else if (beans < beansR){
                                    System.out.println("Sorry, not enough beans!");
                                }else {
                                    System.out.println("Sorry, not enough cups!");
                                }
                            }
                            break;
                        case "3":
                            waterR = 200; milkR = 100; beansR = 12; cupsR = 1; moneyR = 6;
                            if(water >= waterR && milk >= milkR && beans >= beansR && cups >= cupsR) {
                                System.out.println("I have enough resources, making you coffee!");
                                water -= waterR;
                                milk -= milkR;
                                beans -= beansR;
                                money += moneyR;
                                cups -= cupsR;
                            } else {
                                if (water < waterR){
                                    System.out.println("Sorry, not enough water!");
                                }else if (milk < milkR) {
                                    System.out.println("Sorry, not enough milk!");
                                }else if (beans < beansR){
                                    System.out.println("Sorry, not enough beans!");
                                }else {
                                    System.out.println("Sorry, not enough cups!");
                                }
                            }
                            break;
                        case "back":
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");

                    int waterAdd = input.nextInt();
                    water += waterAdd;
                    System.out.println("Write how many ml of milk do you want to add: ");

                    int milkAdd = input.nextInt();
                    milk += milkAdd;
                    System.out.println("Write how many grams of coffee beans do you want to add: ");

                    int beansAdd = input.nextInt();
                    beans += beansAdd;
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");

                    int cupsAdd = input.nextInt();
                    cups += cupsAdd;
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    machineHas(water, milk, beans, cups, money);
                    break;
                case "exit":
                    break;
            }
            System.out.println(" ");
        }
    }
    public static void machineHas(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        if (money > 0){
            System.out.println("$" + money + " of money");
        } else {
            System.out.println(money + " of money");
        }
    }
}
import java.util.Objects;
import java.util.Scanner;
public class HeistStoryRunner {
    public static void main(String[] args) {
        String muscle="";
        String robber;
        String planner;
        Scanner s = new Scanner(System.in);
        System.out.println("Option 1: \"robber\"- this person will be the one to enter a bank and steal the money\n" + "Option 2: \"planner\"- This person will plan the heist\n" + "Option 3: \"muscle\"- This person will intimidate the guards \n" + "Option 4: \"random\"- enter shuffle and the program will randomly pick for you ");
        System.out.println("Welcome to my heist story! Pick the role you want by entering the name that is in quotations:).\nHave fun!");
        String outcomes = s.nextLine();
        while (!outcomes.equals("robber") && !outcomes.equals("planner") && !outcomes.equals("random") && !outcomes.equals("muscle")) {
            System.out.println("only enter robber,planner, muscle, or random!");
            outcomes = s.nextLine();
        }
        HeistStory user = new HeistStory(outcomes);
        if (outcomes.equals("robber") || outcomes.equals("random")) {
            System.out.println(user.role(outcomes));
            robber = s.nextLine();
            while (!robber.equals("gun") && !robber.equals("machete")) {
                System.out.println("Come on dude! BE serious. gun or machete");
                robber = s.nextLine();
            }
            if(robber.equals("machete")){
                System.out.println(user.gunOrMach(robber));
                System.out.println(user.toString());
            } else {
                System.out.println(user.gunOrMach(robber));
                robber = s.nextLine();
                while (!robber.equals("yes") && !robber.equals("no")) {
                    System.out.println("Come one how you misspell yes and no. yes or no?");
                    robber = s.nextLine();
                }
                System.out.println(user.choiceHostage(robber));
                robber = s.nextLine();
                while (!robber.equals("yes") && !robber.equals("no")) {
                    System.out.println("yes or no please!");
                    robber = s.nextLine();
                }
                System.out.println(user.directionOption(robber));
                robber = s.nextLine();
                while (!robber.equals("left") && !robber.equals("right") && !robber.equals("straight")) {
                    System.out.println("Try again! left, right, or straight!");
                    robber = s.nextLine();
                }
                System.out.println(user.caught(robber));
                robber = s.nextLine();
                while (!robber.equals("yes") && !robber.equals("no") && !robber.equals("stay") && !robber.equals("country") && !robber.equals("hide") && !robber.equals("steal")) {
                    System.out.println("Bro try again!");
                    robber = s.nextLine();
                }
                System.out.println(user.choiceForFuture(robber));
                System.out.println(user.toString());
            }}
        if (Objects.equals(outcomes, "planner") || Objects.equals(outcomes, "random")) {
            System.out.println(user.role(outcomes));
            planner = s.nextLine();
            while (!planner.equals("bank") && !planner.equals("museum") && !planner.equals("rich person")) {
                System.out.println("Who we robbing? bank, museum, or rich person!");
                planner = s.nextLine();
            }
            System.out.println(user.planPlace(planner));
            planner = s.nextLine();
            while (!planner.equals("15,000") && !planner.equals("22,500") && !planner.equals("paintings") && !planner.equals("fossils") && !planner.equals("artifacts") && !planner.equals("jewelry") && !planner.equals("shoes") && !planner.equals("clothing")) {
                System.out.println("Try again!");
                planner = s.nextLine();
            }
            System.out.println(user.handleMoney(planner));
            planner = s.nextLine();
            while (!planner.equals("friends") && !planner.equals("sell") && !planner.equals("spread") && !planner.equals("invest") && !planner.equals("thrift") && !planner.equals("jewelry") && !planner.equals("black market")) {
                System.out.println("Try again! We almost done");
                planner = s.nextLine();
            }
            System.out.println(user.spend(planner));
            planner = s.nextLine();
            while (!planner.equals("house") && !planner.equals("safe") && !planner.equals("business") && !planner.equals("fossils") && !planner.equals("pawn shop") && !planner.equals("friends") && !planner.equals("street") && !planner.equals("robber") && !planner.equals("planner") && !planner.equals("muscle") && !planner.equals("foreign museum") && !planner.equals("thrift") && !planner.equals("money") && !planner.equals("trade")) {
                System.out.println("Last choice!");
                planner = s.nextLine();
            }
            System.out.println(user.finalDecision(planner));
            System.out.println(user.toString());
        }
        if (Objects.equals(outcomes, "muscle") || Objects.equals(outcomes, "random")) {
                System.out.println(user.role(muscle));
                muscle = s.nextLine();
                while (!muscle.equals("guards") && !muscle.equals("manager")) {
                    System.out.println("guards or manager! bad spelling");
                    muscle = s.nextLine();
                }
                if(muscle.equals("manager")){
                    System.out.println(user.firstKillChoice(muscle));
                    System.out.println(user.toString());
                } else{
                System.out.println(user.firstKillChoice(muscle));
                muscle = s.nextLine();
                while (!muscle.equals("punch") && !muscle.equals("stab")) {
                    System.out.println("punch or stab! Every choice matters!");
                    muscle = s.nextLine();
                }
                System.out.println(user.punchOrStab(muscle));
                muscle = s.nextLine();
                while (!muscle.equals("shoot")&&!muscle.equals("fight")){
                    System.out.println("You got this! shoot or fight?");
                    muscle=s.nextLine();
                }
                System.out.println(user.wifeOrBoxer(muscle));
                muscle=s.nextLine();
                while (!muscle.equals("yes")&&!muscle.equals("no")&&!muscle.equals("hide")&&!muscle.equals("steal")&&!muscle.equals("stay")&&!muscle.equals("country")){
                    System.out.println("Pay attention! Try again!");
                    muscle=s.nextLine();
                }
                System.out.println(user.finalKill(muscle));
                System.out.println(user.toString());

            }

    }
}}



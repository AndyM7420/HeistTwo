import java.awt.*;
import java.util.Objects;
import java.util.Scanner;
public class HeistStoryRunner {
    public static void main(String[] args) {
        String muscle="";
        String save="";
        String robber="";
        String planner;
        Scanner s = new Scanner(System.in);
        System.out.println("Option 1: \"robber\"- this person will be the one to enter a bank and steal the money\n" + "Option 2: \"planner\"- This person will plan the heist\n" + "Option 3: \"muscle\"- This person will intimidate the guards \n" + "Option 4: \"random\"- enter shuffle and the program will randomly pick for you ");
        System.out.println("Welcome to my heist story! Pick the role you want by entering the name that is in quotations:).\nHave fun!");
        String outcomes = s.nextLine();
        save=outcomes;
        HeistStory user = new HeistStory(outcomes);
        while (!outcomes.equals("die")){
        while (user.checkWord(outcomes)) {
            if (Objects.equals(outcomes, "robber") || Objects.equals(outcomes, "random")) {
                while (!save.equals("Wrong spelling. enter role again")||!outcomes.equals("die")) {
                    System.out.println(user.role(outcomes));
                    save = user.role(outcomes);
                    robber = s.nextLine();
                    System.out.println(user.gunOrMach(robber));
                    robber = s.nextLine();
                    save = user.gunOrMach(robber);
                    System.out.println(user.choiceHostage(robber));
                    robber = s.nextLine();
                    save = user.choiceHostage(robber);
                    System.out.println(user.directionOption(robber));
                    robber = s.nextLine();
                    save = user.directionOption(robber);
                    System.out.println(user.caught(robber));
                    robber = s.nextLine();
                    save = user.caught(robber);
                    System.out.println(user.choiceForFuture(robber));
                    save="Wrong spelling.enter role again";
                    outcomes = "die";
                    System.out.println(user.toString());
                    break;
                }
                outcomes="die";
                outcomes = s.nextLine();
                user.newInput(outcomes);
            }
                if (Objects.equals(outcomes, "planner") || Objects.equals(outcomes, "random")) {
                    while (!save.equals("Wrong spelling. enter role again")) {
                    System.out.println(user.role(outcomes));
                    save=user.role(outcomes);
                    planner = s.nextLine();
                    System.out.println(user.planPlace(planner));
                    planner = s.nextLine();
                    save=user.planPlace(planner);
                    System.out.println(user.handleMoney(planner));
                    save=user.handleMoney(planner);
                    planner= s.nextLine();
                    System.out.println(user.spend(planner));
                    save=user.spend(planner);
                    System.out.println(user.finalDecision(planner));
                        save="Wrong spelling.enter role again";
                        outcomes = "die";
                        System.out.println(user.toString());
                        break;
                }
                    outcomes = s.nextLine();
                    user.newInput(outcomes);}
            if (Objects.equals(outcomes, "muscle") || Objects.equals(outcomes, "random")) {
                while (!save.equals("Wrong spelling. enter role again")) {
                    System.out.println(user.role(muscle));
                    muscle = s.nextLine();
                    save = user.role(muscle);
                    System.out.println(user.firstKillChoice(muscle));
                    muscle = s.nextLine();
                    save = user.firstKillChoice(muscle);
                    System.out.println(user.punchOrStab(muscle));
                    muscle = s.nextLine();
                    save = user.punchOrStab(muscle);
                    System.out.println(user.wifeOrBoxer(muscle));

                }
                outcomes = s.nextLine();
                user.newInput(outcomes);
            }

        }
            save="Wrong spelling.enter role again";
            outcomes = "die";
        System.out.println("try again! Enter desired role");
        outcomes = s.nextLine();
        user.newInput(outcomes);
    }
        System.out.println(user.toString());
}}

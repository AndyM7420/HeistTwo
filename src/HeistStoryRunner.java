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
                    System.out.println(user.MoG(robber));
                    robber = s.nextLine();
                    save = user.MoG(robber);
                    System.out.println(user.choiceGun(robber));
                    robber = s.nextLine();
                    save = user.choiceGun(robber);
                    System.out.println(user.killOption(robber));
                    robber = s.nextLine();
                    save = user.killOption(robber);
                    System.out.println(user.directions(robber));
                    robber = s.nextLine();
                    save = user.killOption(robber);
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
                    planner = s.nextLine();
                    System.out.println(user.planPlace(planner));
                    planner = s.nextLine();
                    System.out.println(user.sneak(planner));
                    planner= s.nextLine();
                    System.out.println(user.spend(planner));
                    System.out.println(user.finalDecision(planner));
                }
                    outcomes = s.nextLine();
                    user.newInput(outcomes);}
            if (Objects.equals(outcomes, "muscle") || Objects.equals(outcomes, "random")) {
                while (!save.equals("Wrong spelling. enter role again")) {
                    System.out.println(user.role(muscle));
                    muscle = s.nextLine();
                    save = user.role(muscle);
                    System.out.println(user.GoM(muscle));
                    muscle = s.nextLine();
                    save = user.GoM(muscle);
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

import java.util.Objects;

public class HeistStory {
      String outcome;
    int count;
    String wife;
    String directions;
    int choice;
    public HeistStory(String outcome) {
        this.outcome=outcome;
    }
    public String role(String hello){
        if ("random".equals(this.outcome)) {
            choice = 4;
            random(choice);
        }
        if ("robber".equals(this.outcome)) {
            choice = 1;
            return robber();
        } else if ("planner".equals(outcome)) {
            choice = 2;
            return planner();
        } else if ("muscle".equals(outcome)) {
            choice = 3;
            return theMuscle();
        }
        return hello;
    }
    public String decisions(String decision){
        if ("random".equals(this.outcome)) {
            choice = 4;
            random(choice);
        }
        if ("robber".equals(this.outcome)) {
            choice = 1;
            return robber();
        } else if ("planner".equals(outcome)) {
            choice = 2;
            return planner();
        } else if ("muscle".equals(outcome)) {
            choice = 3;
            return theMuscle();
        }
        return decision;
    }

    private void random(int random){
        int four;
        if(random==4){
            four=(int)(Math.random()*3)+1;
            if(four==1){
                outcome="robber";
            } else if (four==2) {
                outcome="planner";
            } else if (four==3) {
                outcome="muscle";
            }
        }
    }
    public String theMuscle(){
        String second="muscle";
        String tasks;
        if(second.equals(outcome)){
            count++;
            tasks= "You picked the muscle. you will go to the place with the robber. Will you take out the \"guards\" or the \"manager\"?";
        }  else {
            tasks="Wrong spelling. enter role again";
        }
        return tasks;
    }
    public String firstKillChoice(String person){
        String law;
        if(Objects.equals(person,"manager")){
            law="The guards take you out. Guess you should've taken out the guards first.";
            return law;
        } else  if(Objects.equals(person,"guards")){
            law="you have gotten rid of the guards. You see a hostage move. Do you \"punch\" him or \"stab\" him?";
        } else {
            law="Wrong spelling. enter role again";
        }
        return law;
    }
    public String punchOrStab(String stab){
        String punchOStab;
        count++;
        if(Objects.equals(stab,"stab")){
            punchOStab="You stab him and he bleeds to death. Their wife was present do you kill her swell?.\n(input yes or no)";
        } else if(Objects.equals(stab,"punch")){
            punchOStab="You punch him but it turns out he is a professional kick-boxer.\nHe f*cks you up till you are almost dead. Do you \"shoot\" him or \"fight\" him off?";

        } else {
            punchOStab="Wrong spelling. enter role again";
        }
        return punchOStab;
    }
    public String wifeOrBoxer(String wife){
        this.wife=wife;
        count++;
        String wifeOrBoxer;
        if(Objects.equals(wife,"yes")){
            wifeOrBoxer="BOOM! Wife is also dead. Her sister was also present.\nDo you kill her too?(input yes or no)";
        } else if(Objects.equals(wife,"no")){
            wifeOrBoxer="Alr Wife is kept alive but the guys brother is here too.\nDo you kill him?(input yes or no)";
        } else if(Objects.equals(wife,"shoot")){
            wifeOrBoxer="LFG!He dies and you left bruised but fine\nAnother bystander calls you weak. Do you kill him?(input yes or no)";
        } else if(Objects.equals(wife,"fight")){
            wifeOrBoxer="UH OH. The boxer overpowers. Thankfully the robber stabs him.Now you can choose to \"finish\"him off or \"save\" him?";
        } else{
            wifeOrBoxer="Wrong spelling. enter role again";
        }
        return wifeOrBoxer;
    }
    public String finalKill(String ultimateKill) {
        String muscleDown = "";
        if (wife.equals("shoot")) {
            count++;
            if (ultimateKill.equals("yes")) {
                muscleDown = "You kill him and all the bystanders go silent\nYou have done you're job.\nThanks for your insight!";

            } else if (ultimateKill.equals("no")) {
                muscleDown = "The guy is unharmed but you kill another bystander to show off\nthe muscle has done their job";
            }
        } else if (wife.equals("yes")) {
            count++;
            if (ultimateKill.equals("yes")) {
                muscleDown = "The sister is dead and everyone cries\nYou have done your job!";
            } else if (ultimateKill.equals("no")) {
                muscleDown = "The sister is kept alive but no one dares say anything\nCongrats on a job well done!";

            }
        } else if (wife.equals("no")) {
            count++;
            if (ultimateKill.equals("yes")) {
                muscleDown = "The guys brother is dead.\nIf caught, everyone will testify in court\nYou're job is done!";
            } else if (ultimateKill.equals("no")) {
                muscleDown = "The guys brother is kept alive\nYou have done everything the muscle should";

            }
        } else if (wife.equals("fight")) {
            count++;
            if (ultimateKill.equals("finish")) {
                muscleDown = "you finish him off and the robber claps for you\nYou're job is done";
            }

            if (ultimateKill.equals("save")) {
                muscleDown="you save the guy and he provides you his money to live\nyou're job is done!";
            }
        }
        return muscleDown;
    }
    //planner decisions
    public String planner(){
        String second="planner";
        String task;
        if(second.equals(outcome)){
            count++;
            task= "You picked the hardest task. You will plan the task. Where do you want to rob?\n\"bank\", \"museum\", \"rich person\"";
        } else {
            task="Wrong spelling. enter role again";
        }
        return task;
    }
    public String planPlace(String which){
        count++;
        String decide;
        if(Objects.equals(which, "bank")){
            decide="Bet. We will rob a bank. Now you have to decide how much money from the bank you want?\n\"15,000\" or \"22,500\" or \"3,750\"";
        } else if(Objects.equals(which,"museum")){
            decide="Bet. We will rob a gas station. Now you have to decide what you want from the museum\npaintings, fossils, or artifacts";

        } else if(Objects.equals(which,"rich person")){
            decide="Bet. We will rob a rich person\nNow you must decide what do you want  in the rich person's house\njewelry, shoes, or clothing ";

        } else {
            decide="Wrong spelling. enter role again";
        }
        return decide;
    }
    public String handleMoney(String sneaky){
        count++;
        outcome=sneaky;
        String now;
        if(Objects.equals(sneaky, "jewelry")||Objects.equals(sneaky,"shoes")|| Objects.equals(sneaky,"clothing")){
            now="You've decided on "+sneaky+" Will you keep it among you're \"friends\" or \"sell\" it?";
        } else if(Objects.equals(sneaky, "15,000")||Objects.equals(sneaky,"22,500")|| Objects.equals(sneaky,"3,750")){
            now="You've decided on "+sneaky+" Will you \"spread\" the money three ways or \"invest\"?";
        } else if(Objects.equals(sneaky, "fossils")||Objects.equals(sneaky,"paintings")|| Objects.equals(sneaky,"artifacts")){
            now="You've decided on "+sneaky+" Will you \"thrift\" the item or sell it on the \"black market?\"";
        } else {
            now="Wrong spelling. enter role again";
        }
        return now;
    }
    public String spend(String affect){
        count++;
        String decision;
        if(Objects.equals(affect,"friends")){
            decision="You will keep the "+outcome+" with you're friends."+"\n"+"Where will we store the "+outcome+"?\nYou're \"house\", a \"safe\", or in a money laundry \"business\"";
        } else if(Objects.equals(affect,"sell")){
            decision="Where will we sell the "+outcome+"  \nIn a \"pawn shop\", to our \"friends\", or d*mb*ss in the \"street\"?";
        } else if(Objects.equals(affect,"spread")){
            decision="We will split the money evenly\nHowever, one of us needs to hold it for a bit. The \"robber\", \"planner\", or \"muscle\"?";
        } else if(Objects.equals(affect,"invest")){
            decision="Will we use the "+outcome+" for dr*gs, weapons, or food?";
        } else if(Objects.equals(affect,"thrift")){
            decision="We will thrift the "+outcome+" to another \"foreign museum\" or to a regular \"thrift\" store?";
        } else if(Objects.equals(affect,"black market")){
            decision="Will we sell it for a specific amount of \"money\" or \"trade\" it for resources?";
        } else {
            decision="Wrong spelling. enter role again";
        }
        return decision;
    }
    public String finalDecision(String finalD){
        count++;
        String ultimate;
        if(finalD.equals("house")||finalD.equals("safe")||finalD.equals("business")){
            ultimate="Alright We have decided to store it in a "+finalD+"\nYou're work is done!";
        } else if(finalD.equals("pawn shop")||finalD.equals("friends")||finalD.equals("street")) {
            ultimate="We will sell it to "+finalD+"\nThanks for the hard work. U are done planning.";
        } else if(finalD.equals("robber")||finalD.equals("planner")||finalD.equals("muscle")){
            if(finalD.equals("robber")){
                ultimate="Correct. You're the smartest and should hold it"+"\nYou are done planning!";
            } else {
                ultimate="Alright we will give it to the "+finalD+"\nEven though it makes sense for the planner to get it.\nThanks for planning the heist";

            }
        } else if(finalD.equals("foreign museum")||(finalD.equals("thrift"))){
            ultimate="Alright. We will thrift it\nThanks for the planning";
        } else if(finalD.equals("money")||finalD.equals("trade")) {
            ultimate="Smart for selling it in the black market.\nThank you for choosing "+ finalD+"\nThe planner is done";
        } else {
            ultimate="Wrong spelling. enter role again";
        }
        return ultimate;
    }
    //ROBBER DECISIONS
    private String robber(){
        String first = "robber";
        if(Objects.equals(first, outcome)){
            count++;
            return "You and your friends are in the car. As you are ready to leave, you can choose between a \"machete\" or a \"gun\". Which one do you pick?";

        } else {
            return "Wrong spelling. enter role again";
        }
    }
    public String gunOrMach(String which){
        count++;
        String MoG;
        if(which.equals("gun")){
            MoG= "Gun it is! Now you enter the bank and yell \"Everybody Down!\"\nYou can use the gun to hold a hostage. Do you want to hold a hostage";
        } else if(which.equals("machete")){
            MoG= "machete is it! Now you enter the bank and yell Freeze! Suddenly someone grabs the machete and you DIE! ";
        } else {
            MoG="Wrong spelling. enter role again";
        }
        return MoG;
    }
    public String choiceHostage(String choice){
        count++;
        String noOrYes;
        if(choice.equals("yes")) {
            noOrYes="Alright. You have now taken a hostage captive. The banker has negotiated with you get the code to the vault\nYou grab all the money\nYou can chose to kill all the people and escape. yes or No?";
        } else if(choice.equals("no")){
            noOrYes="Alright. You will not take a hostage. The banker thinks you're not intimidating enough\nHe calls the police and you go to prison";
        } else {
            noOrYes= "Wrong spelling. enter role again";
        }
        return noOrYes;
    }
    public String directionOption(String kill){
        count++;
        String toBeKilled;
        if(kill.equals("yes")){
            toBeKilled="You have killed all the people and will now escape with everyone's money\nthe cops are approaching as you jump into the vehicle. Do you tell the driver to go \"left\",\"right\", or \"straight\"?";

        } else if(kill.equals("no")) {
            toBeKilled="You will leave without killing anyone and escape\nLittle do you know a bystander had a phone and was calling the police\nthe cops are approaching as you jump into the vehicle. Do you tell the driver to go \"left\",\"right\", or \"straight\"?";
        } else {
            toBeKilled="Wrong spelling. enter role again";
        }
        return toBeKilled;
    }
    public String caught(String direct){
        count++;
        directions=direct;
        String leftSRight;
        leftSRight = switch (direct) {
            case "left" ->
                    "Driver goes left which leads to the nearest police station. All of you are arrested but will later get to negotiate.\nYou are now being interrogated. Do you take full blame as the main accomplice?(input yes or no)";
            case "straight" ->
                    "Driver goes straight but ends up killing a bunch of bystanders. This leads to more cops on your trail\nYou stumble upon a gas station. Do you hide out there or steal another car(input hide or steal)";
            case "right" -> "Driver goes right and starts to lose the cops\nYou find you're safe house and stay for three hours? Do you want to \"stay\" inside longer or go out and try to go another \"country\".";
            default -> "";
        };
        return leftSRight;
    }
    public String choiceForFuture(String choice){
        count++;
        String future="";
        if(directions.equals("left")){
            if(choice.equals("yes")){
                future="The cops now will take you to trial. You will be sentenced to 10 years in prison.\nHowever once out you're friends have left some money for you and plan to rob another place";
            }
            if(choice.equals("no")){
                future="The cops will take all of you to trial. All of you besides the driver are sentenced to 10+ years. Once out all of you have separated and become poor.";
            }
        } else if(directions.equals("straight")){
            if(choice.equals("hide")){
                future="The cops found you and have sentenced all of you to 10+ years.";
            }
            if(choice.equals("steal")){
                future="You find another car and continue to be on the lamb for years.\nYou find a place to stay and all of you're friends go their separate ways.";
            }
        } else if(directions.equals("right")){
            if(choice.equals("stay")){
                future="the cops have found you because you were a lazy pig.";
            }
            if(choice.equals("country")){
                future="the cops never find you but you and your friends plan another heist.\nThis country has better police and you are found.";
            }
        } else {
            future="Wrong spelling. enter role again";
        }
        return future;
    }

    public String toString() {
        return "End of Story.\nYou've made "+count+" decisions.";
    }}

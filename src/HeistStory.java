import java.util.Objects;

/**
 * The person class represents the user's role based on what they input. This person has an initial outcome, every decision has a count,
 * and each method has a different output such as wife and directions
 */
public class HeistStory {
    String outcome;
    double numDecisions;
    String wife;
    String directions;
    int choice;

    /**
     * Constructor for the HeistStory class. This sets the instance outcome to the given parameters
     * @param outcome represents the role chosen by the user
     */
    public HeistStory(String outcome) {

        this.outcome=outcome;
        numDecisions=0;
        wife="";
        directions="";
        choice=0;
    }

    /**
     * The role method will set each role to a numeric value from 1-4.
     * Once the if statement checks which role chosen, it will call the needed method
     *
     * @return returns a method based on which role outcome is
     */
    public String role(){
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
        return "hi";
    }

    /**
     * random void method will help for the option of random. This will use Math.Random to pick a random role
     * for the user. Once the role is chosen it will set outcome to whichever role is chosen.
     * This is void as there is no return value needed
     * @param random represents the number 4 as that is the number designated for the choice random
     */
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

    /**
     * theMuscle method starts the first prompt for the role of the muscle. It starts the muscle's story and then asks a different question
     * @return the string tasks is updated to the desired print statement to avoid using system.out.println
     *
     */
    public String theMuscle(){
        String second="muscle";
        String tasks;
        if(second.equals(outcome)){
            numDecisions++;
            tasks= "You picked the muscle. you will go to the place with the robber. Will you take out the \"guards\" or the \"manager\"?";
        }  else {
            tasks="Wrong spelling. enter role again";
        }
        return tasks;
    }

    /**
     * The firstKillChoice method will continue the muscle story and either stops the story based on the option picked or
     * continue the story with another prompt
     * @param person string represents the user input of the choice asked based on the previous theMuscle method.
     *               This string is then checked by an if statement is it equals 1 of the 2 options
     * @return string law which is updated based on what option out of the two did the user pick
     */
    public String firstKillChoice(String person){
        String law;
        numDecisions++;
        if(Objects.equals(person, "manager")){
            law="The guards take you out. Guess you should've taken out the guards first.";
            return law;
        } else  if(Objects.equals(person,"guards")){
            law="you have gotten rid of the guards. You see a hostage move. Do you \"punch\" him or \"stab\" him?";
        } else {
            law="The guards take you out. Guess you should've taken out the guards first.";
        }
        return law;
    }

    /**
     * The punchOrStab method continues the prompt from the previous method and will continue the story either way but
     * the prompts is different based on the option chosen
     * @param stab string represents the user input to chose from stab or punch. The input is checked, and then
     *             it will output a different prompt
     * @return punchOStab string which is updated with a different prompt based on the parameter stab.
     */
    public String punchOrStab(String stab){
        String punchOStab;
        numDecisions++;
        if(Objects.equals(stab,"stab")){
            punchOStab="You stab him and he bleeds to death. Their wife was present do you kill her swell?.\n(input yes or no)";
        } else if(Objects.equals(stab,"punch")){
            punchOStab="You punch him but it turns out he is a professional kick-boxer.\nHe f*cks you up till you are almost dead. Do you \"shoot\" him or \"fight\" him off?";

        } else {
            punchOStab="Wrong spelling. enter role again";
        }
        return punchOStab;
    }

    /**
     * The wifeOrBoxer method follows the previous method in which the user chose to either target the wife or kick-boxer. This method continues the story
     * @param wife string which represents the user answer for the previous method. It is then checked what it is equal to and then return a variable with a new prompt
     * @return wifeOrBoxer string. This string hold the prompt that continues the story with a new decision
     */
    public String wifeOrBoxer(String wife){
        this.wife=wife;
        numDecisions++;
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

    /**
     * The method finalKill is the final method for the story of the Muscle. This handles the most logic as it relies on not one but two different methods. This method uses
     * the instance wife to know which of the two decisions from wifeOrBoxer did the user pick and then continues the story
     * @param ultimateKill is the user input for this decision. It also relies on the other previous method
     * @return String muscleDown which is set as "" but then updated if it fits one of the answer choices
     */
    public String finalKill(String ultimateKill) {
        String muscleDown="";
        if (wife.equals("shoot")) {
            numDecisions++;
            if (ultimateKill.equals("yes")) {
                muscleDown = "You kill him and all the bystanders go silent\nYou have done you're job.\nThanks for your insight!";

            } else if (ultimateKill.equals("no")) {
                muscleDown = "The guy is unharmed but you kill another bystander to show off\nthe muscle has done their job";
            }
        } else if (wife.equals("yes")) {
            numDecisions++;
            if (ultimateKill.equals("yes")) {
                muscleDown = "The sister is dead and everyone cries\nYou have done your job!";
            } else if (ultimateKill.equals("no")) {
                muscleDown = "The sister is kept alive but no one dares say anything\nCongrats on a job well done!";

            }
        } else if (wife.equals("no")) {
            numDecisions++;
            if (ultimateKill.equals("yes")) {
                muscleDown = "The guys brother is dead.\nIf caught, everyone will testify in court\nYou're job is done!";
            } else if (ultimateKill.equals("no")) {
                muscleDown = "The guys brother is kept alive\nYou have done everything the muscle should";

            }
        } else if (wife.equals("fight")) {
            numDecisions++;
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
    /** no parameter method that simply start the prompts of the planner role
     *
     * @return task which simply returns the first planner prompt if outcome equals planner. Otherwise, it prints wrong spelling.
     */
    public String planner(){
        String second="planner";
        String task;
        if(second.equals(outcome)){
            numDecisions++;
            task= "You picked the hardest task. You will plan the task. Where do you want to rob?\n\"bank\", \"museum\", \"rich person\"";
        } else {
            task="Wrong spelling. enter role again";
        }
        return task;
    }

    /**planPlace method continues the first prompt by prompting the user to decide what they want to steal in the given location
     *
     * @param which String that is the place the user choose to plan to rob
     * @return String decide which is assigned a different prompt based on the three options given to the user
     */
    public String planPlace(String which){
        numDecisions++;
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

    /**handleMoney method continues the story by stating how we want to take care of the object/s picked by the user in the previous method.
     *
     * @param sneaky is the user input of the amount of stuff that the user wants from the desired robbing place
     * @return String handle which the method checks which of the 9 choices they picked and then displays the next question by setting handle to that specific statement
     */
    public String handleMoney(String sneaky){
        numDecisions++;
        outcome=sneaky;
        String handle;
        if(Objects.equals(sneaky, "jewelry")||Objects.equals(sneaky,"shoes")|| Objects.equals(sneaky,"clothing")){
            handle="You've decided on "+sneaky+" Will you keep it among you're \"friends\" or \"sell\" it?";
        } else if(Objects.equals(sneaky, "15,000")||Objects.equals(sneaky,"22,500")|| Objects.equals(sneaky,"3,750")){
            handle="You've decided on "+sneaky+" Will you \"spread\" the money three ways or \"invest\"?";
        } else if(Objects.equals(sneaky, "fossils")||Objects.equals(sneaky,"paintings")|| Objects.equals(sneaky,"artifacts")){
            handle="You've decided on "+sneaky+" Will you \"thrift\" the item or sell it on the \"black market?\"";
        } else {
            handle="Wrong spelling. enter role again";
        }
        return handle;
    }

    /**spend method is what the user wants to proceed on spending/saving the money
     *
     * @param affect String which is vital to know the user's choice of the previous method which affects this method
     * @return decision string that is changed based on the user input
     */
    public String spend(String affect){
        numDecisions++;
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

    /**finalDecision ends the planner story and displays the final prompt for the user
     *
     * @param finalD string which is used to represent the ultimate decision that the user has decided on that will affect the end of the story
     * @return ultimate string which displays the final print statement
     */
    public String finalDecision(String finalD){
        numDecisions++;
        String ultimate;
        if(finalD.equals("house")||finalD.equals("safe")||finalD.equals("business")){
            ultimate="Alright We have decided to store it in a "+finalD+"\nYou're work is done!";
        } else if(finalD.equals("pawn shop")||finalD.equals("friends")||finalD.equals("street")) {
            ultimate="We will sell it to "+finalD+"\nThanks for the hard work. U are done planning.";
        } else if(finalD.equals("robber")||finalD.equals("planner")||finalD.equals("muscle")){
            if(finalD.equals("planner")){
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

    /**robber method with no parameter that simply checks the desired user role and then starts the prompt of the robber role
     *
     * @return a direct statement that prompts the user to decide on something to continues the story
     */
    private String robber(){
        String first = "robber";
        if(Objects.equals(first, outcome)){
            numDecisions++;
            return "You and your friends are in the car. As you are ready to leave, you can choose between a \"machete\" or a \"gun\". Which one do you pick?";

        } else {
            return "Wrong spelling. enter role again";
        }
    }

    /**
     *gunOrMach method which answers the first robber question and directs the story based on that choice
     * @param which string which builds on the first robber question by asking the user another question
     * @return MoG string which is updated in the method with an if statement that checks which of the two options did the user pick
     */
    public String gunOrMach(String which){
        numDecisions++;
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

    /**
     * choiceHostage method which prompts the user to show the affect of whether to kill a hostage. This adds more on to the story
     * @param choice string which contains the users choice of killing a hostage or not. Once this is checked it will ask a separate question
     *               based on which statement is true
     * @return noOrYes string which will update based on the if statement
     */
    public String choiceHostage(String choice){
        numDecisions++;
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

    /**
     * directionOption method which displays the driving option that the robber must pick
     * @param kill string which represents the users decision to kill/not kill everyone
     * @return toBeKilled which returns a different prompt seperate to what the string kill is set to
     */
    public String directionOption(String kill){
        numDecisions++;
        String toBeKilled;
        if(Objects.equals(kill, "yes")){
            toBeKilled="You have killed all the people and will now escape with everyone's money\nthe cops are approaching as you jump into the vehicle. Do you tell the driver to go \"left\",\"right\", or \"straight\"?";

        } else if(Objects.equals(kill, "no")) {
            toBeKilled="You will leave without killing anyone and escape\nLittle do you know a bystander had a phone and was calling the police\nthe cops are approaching as you jump into the vehicle. Do you tell the driver to go \"left\",\"right\", or \"straight\"?";
        } else {
            toBeKilled="Wrong spelling. enter role again";
        }
        return toBeKilled;
    }

    /**
     * caught method which returns the last question for the robber story that will end the story
     * @param direct string which represents the user input that answers the previous prompted question
     * @return leftsRight string which is updated using switch that checks if parameter direct is equal to either left, straight, or right
     */
    public String caught(String direct){
        numDecisions++;
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

    /**
     * choiceForFuture method is the final part of the robber story that will show the future of the whole group of robbers
     * @param choice string which the user input of the very last question that the user must answer to show the end of the story
     * @return future string which is used to represent the prompt given based on which direction given and describes the future of the robber group.
     */
    public String choiceForFuture(String choice){
        numDecisions++;
        String futurerobber="";
        if(directions.equals("left")){
            if(choice.equals("yes")){
                futurerobber="The cops now will take you to trial. You will be sentenced to 10 years in prison.\nHowever once out you're friends have left some money for you and plan to rob another place";
            }
            if(choice.equals("no")){
                futurerobber="The cops will take all of you to trial. All of you besides the driver are sentenced to 10+ years. Once out all of you have separated and become poor.";
            }
        } else if(directions.equals("straight")){
            if(choice.equals("hide")){
                futurerobber="The cops found you and have sentenced all of you to 10+ years.";
            }
            if(choice.equals("steal")){
                futurerobber="You find another car and continue to be on the lamb for years.\nYou find a place to stay and all of you're friends go their separate ways.";
            }
        } else if(directions.equals("right")){
            if(choice.equals("stay")){
                futurerobber="the cops have found you because you were a lazy pig.";
            }
            if(choice.equals("country")){
                futurerobber="the cops never find you but you and your friends plan another heist.\nThis country has better police and you are found.";
            }
        } else {
            futurerobber="Wrong spelling. enter role again";
        }
        return futurerobber;
    }

    /**
     * toString method is used to count the amount of decisions the user has done
     * @return a print statement telling the user that the story is done.
     * It also outputs the amount of decisions made
     */
    public String toString() {
        return "End of Story.\nYou've made "+numDecisions+" decisions.";
    }}

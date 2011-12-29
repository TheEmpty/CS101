package edu.bridgeport.evilgeniusarmy;
import java.util.Scanner;

/**
 * What handles the flow of the nodes
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class Game {
    /**
     * Scanner from constructor
     */
    private Scanner input;
    /**
     * Where the "player" is in the game
     */
    private Node currentNode;
    /**
     * When creating a game, where do we start from?
     */
    private Node firstNode;
    /**
     * Where should we output our data? Default to System.out
     */
    private java.io.PrintStream output = System.out;
    
    /**
     * Create a game that needs a Scanner
     */
    public Game(){
        seedData();
    }
    
    /**
     * Create a game that reads input from a Scanner
     * @param newInput 
     */
    public Game(Scanner newInput){
        input = newInput;
        seedData();
    }
    
    /**
     * Set a new input source
     */
    public boolean setScanner(Scanner newScanner){
        input = newScanner;
        return true;
    }
    
    /**
     * Set the output if not System.out
     */
    public boolean setOutput(java.io.PrintStream newOut){
        output = newOut;
        return true;
    }
    
    /**
     * The main loop of the game. Loops until currentNode is null.
     * When currentNode is null, it means we've reached the end.
     * @throws Exception Scanner not attached
     */
    public void gameLoop() throws Exception {
        if(input == null){
            throw new Exception("Please attach a scanner to this game object before use");
        }
                
        currentNode = firstNode;
        
        while(currentNode != null){
            while(currentNode instanceof QuestionNode){
                askQuestion();
            }

            while(currentNode instanceof ConclusionNode){
                displayAnswer();
            }
        }
    }
    
    private void outputln(String string){
        output.println(string);
    }
    
    private void output(String string){
        output.print(string);
    }
    
    /**
     * Ask question, get answer, move to next node.
     */
    private void askQuestion(){
        QuestionNode node = (QuestionNode) currentNode;
        
        outputln(node.buildQuestion());
        outputln("");
        
        outputln("Answer (1 or 2): ");
        while(!input.hasNextInt() && input.hasNext("^[0-2]\\s*$")){
            outputln("Please answer 1 or 2");
            output("Answer (1 or 2): ");
            input.nextLine();
        }
        // save answer
        int answer = input.nextInt();
        // move pointer to end of input
        input.nextLine();
        // Add a clear line
        outputln("");
        
        if(answer == 1){
            currentNode = node.getPositiveNode();
        } else {
            currentNode = node.getNegativeNode();
        }
    }
    
    /**
     * Outputs the an ConclusionNode and then moves to the next node (may be null).
     */
    private void displayAnswer(){
        outputln(currentNode.getText());
        outputln(""); // clear line
        // Some answers redirect to other answers as well
        currentNode = currentNode.getNextNode();
    }
    
    /**
     * Seeds game nodes and links the flow. Adds color in terminals that support it.
     */
    private void seedData(){
        // Sneaking in black foreground here
        String blackfg = "\033[30m";
        String underline = "\033[4m";
        String green   = "\033[1;42m" + blackfg;
        String cyan    = "\033[1;46m" + blackfg;
        String magneta = "\033[1;45m" + blackfg;
        String yellow  = "\033[1;43m" + blackfg;
        String reset   = "\033[0m";
        
        // col 1
        QuestionNode humanNode = new QuestionNode(cyan + "Are you human?" + reset, "yes", "no");
        firstNode = humanNode;
        
        QuestionNode resNode = new QuestionNode(yellow + "Do you resemble a human?" + reset, "yes","no");
        humanNode.setNegativeNode(resNode);
        
        ConclusionNode coder = new ConclusionNode(green + "Stick to coding. It's your destiny." + reset);
        resNode.setNegativeNode(coder);
        
        // col 2
        QuestionNode polit = new QuestionNode(green + "Are you a politician?" + reset, "yes","no");
        resNode.setPositiveNode(polit);
        
        // col 3
        QuestionNode parents = new QuestionNode(magneta + "Would you sell your parental unit(s) into slavery?" + reset, "yes", "no");
        polit.setNegativeNode(parents);
        ConclusionNode lier = new ConclusionNode(green + "Oh, you're a politician alright..." + reset);
        parents.setPositiveNode(lier);
        
        // col 3.5
        QuestionNode mbaNode = new QuestionNode(magneta + "Do you covet or have have a M.B.A?" + reset, "yes","no");
        humanNode.setPositiveNode(mbaNode);
        
        QuestionNode evil1 = new QuestionNode(yellow + "Who is more evil, Dr. Doom or Barney?" + reset, "Barney", "Dr. Doom");
        mbaNode.setNegativeNode(evil1);
        
        // col 4
        QuestionNode market = new QuestionNode(magneta + "Are you fluent in market speak?" + reset, "yes", "no");
        mbaNode.setPositiveNode(market);
        
        QuestionNode enstrength = new QuestionNode(magneta + "Does this fluency \"enstrengthen your stakeholdership\"" + reset, "yes", "no");
        market.setPositiveNode(enstrength);
        
        QuestionNode angered = new QuestionNode(yellow + "You have angered your overlord, what do you do?" + reset, "run", "beg");
        evil1.setPositiveNode(angered);
        enstrength.setNegativeNode(angered);
        market.setNegativeNode(angered);
        
        QuestionNode evil2 = new QuestionNode(yellow + "Who is more evil, Dr. Doom or Dr. Laura?" + reset, "Dr. Laura", "Dr. Doom");
        evil1.setNegativeNode(evil2);
        
        QuestionNode dell = new QuestionNode(yellow + "Would you serve the Dell guy?" + reset, "yes", "no");
        parents.setNegativeNode(dell);
        
        QuestionNode lunch = new QuestionNode(yellow + "For lunch?" + reset, "yes", "no");
        dell.setNegativeNode(lunch);
        
        // col 5
        ConclusionNode genius = new ConclusionNode(underline + "You're an obvious threat" + reset + " to greater evil and will be treated as such.");
        enstrength.setPositiveNode(genius);
        
        ConclusionNode lieutenant = new ConclusionNode("You obviously have no life, you obsequious little worm, you'll make a great " + underline + "lieutenant" + reset + ".");
        angered.setPositiveNode(lieutenant);
        evil2.setPositiveNode(lieutenant);
        lunch.setPositiveNode(lieutenant);
        
        ConclusionNode minion = new ConclusionNode("You have the intellect of dirt, you'll make a good " + underline + "minion" + reset + ".");
        evil2.setNegativeNode(minion);
        dell.setPositiveNode(minion);
        angered.setNegativeNode(minion);
        
        ConclusionNode food = new ConclusionNode("Well done. You'll make an exemplary " + underline + "food animal" + reset + ".");
        polit.setPositiveNode(food);
        lier.setNextNode(food);
        lunch.setNegativeNode(food);
        genius.setNextNode(food);
    }
}

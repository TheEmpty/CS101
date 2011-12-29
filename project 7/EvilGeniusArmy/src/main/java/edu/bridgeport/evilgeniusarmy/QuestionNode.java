package edu.bridgeport.evilgeniusarmy;

/**
 * A node for storing a question that has two available answers,
 * each answer can have its own "next node".
 */
public class QuestionNode extends Node {
    /**
     * What is the positive answer? ex: yes
     */
    private String positiveAnswer;
    /**
     * And the negative answer?
     */
    private String negativeAnswer;
    /**
     * Negative answer node
     */
    private Node negativeNode;
    /**
     * System breakline, commonly \n on *nix or \r on Windows
     */
    private static final String  breakline = System.getProperty("line.separator");
    
    public QuestionNode(){    }
    
    public QuestionNode(String newQuestion, String newPositive, String newNegative){
        setQuestion(newQuestion);
        setPositiveAnswer(newPositive);
        setNegativeAnswer(newNegative);
    }
    
    public QuestionNode(String newQuestion, String newPositive, String newNegative, Node positive, Node negative){
        setQuestion(newQuestion);
        setPositiveAnswer(newPositive);
        setNegativeAnswer(newNegative);
        
        setPositiveNode(positive);
        setNegativeNode(negative);
    }
    
    /**
     * Display the question
     * @return formatted String
     */
    public String buildQuestion(){
        String construction =
                getQuestion() + breakline +
                "1: " + positiveAnswer + breakline +
                "2: " + negativeAnswer;
        return construction;
    }
    
    @Override
    public boolean hasNextNode(){
        return (getPositiveNode() != null) || (negativeNode != null);
    }
    
    public boolean hasNextNodes(){
        return (getPositiveNode() == null) || (negativeNode == null);
    }
    
    public String getQuestion(){
        return getText();
    }
    
    public boolean setQuestion(String newQuestion){
        return setText(newQuestion);
    }
    
    public boolean setPositiveAnswer(String newPositive){
        positiveAnswer = newPositive;
        return true;
    }
    
    public boolean setNegativeAnswer(String newNegative){
        negativeAnswer = newNegative;
        return true;
    }
    
    public Node getPositiveNode(){
        return getNextNode();
    }
    
    public boolean setPositiveNode(Node positive){
        setNextNode(positive);
        return true;
    }
    
    public Node getNegativeNode(){
        return negativeNode;
    }
    
    public boolean setNegativeNode(Node negative){
        negativeNode = negative;
        return true;
    }
}

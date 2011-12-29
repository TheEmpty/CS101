package edu.bridgeport.evilgeniusarmy;

/**
 * A String value node class
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class Node {
    /**
     * Text/value of the node.
     */
    private String text;
    /**
     * The next node in the list.
     */
    private Node nextNode;
    
    public Node() {   }
    
    public Node(String newText){
        setText(newText);
    }
    
    public Node(String newText, Node newNode){
        setText(newText);
        setNextNode(newNode);
    }
    
    public boolean setText(String newText){
        text = newText;
        return true;
    }
    
    public boolean setNextNode(Node newNode){
        nextNode = newNode;
        return true;
    }
    
    public boolean hasNextNode(){
        return nextNode != null;
    }
    
    public String getText(){
        return text;
    }
    
    public Node getNextNode(){
        return nextNode;
    }
    
    @Override
    public String toString(){
        return getText();
    }
}

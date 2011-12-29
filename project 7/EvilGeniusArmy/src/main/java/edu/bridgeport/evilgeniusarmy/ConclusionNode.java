package edu.bridgeport.evilgeniusarmy;

/**
 * A node subclass for answers, used with "instanceof"
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
public class ConclusionNode extends Node {
    
    /**
     * Default constructor
     */
    public ConclusionNode() {   }
    
    /**
     * Constructor that sets a text
     * @param newText The text
     */
    public ConclusionNode(String newText){
        setText(newText);
    }
    
    /**
     * Constructor that has a text and next node
     * @param newText The text
     * @param newNode The next node
     */
    public ConclusionNode(String newText, Node newNode){
        setText(newText);
        setNextNode(newNode);
    }
    
    @Override
    public boolean setNextNode(Node newNode) {
        return super.setNextNode(newNode);
    }
    
    @Override
    public boolean setText(String newText) {
        return super.setText(newText);
    }
}

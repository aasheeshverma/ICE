/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ice;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author ak
 */
public class LangKeywords {
    String[] javaKeywords = {"abstract","do","import","public","throws","boolean","double","instanceof","return","transient","break","else","int","short","try","byte","extends","interface","static","void","case","final","long","strictfp","volatile","catch","finally","native","super","while","char","float","new","switch","class","for","package","synchronized","continue","if","private","this","default","implements","protected","const","goto","null","true","false"};
    String[] cKeywords = {"auto","enum","restrict","unsigned","break","extern","return","void","case","float","short","volatile","char","for","signed","while","const","goto","sizeof","_Bool","continue","if","static","_Complex","default","inline","struct","_Imaginary","do","int","switch","double","long","typedef","else","register","union"};
    String[] cppKeywords = {"and","double","not","this","and_eq","dynamic_cast","not_eq","throw","asm","else","operator","true","auto","enum","or","try","bitand","explicit","or_eq","typedef","bitor","export","private","typeid","bool","extern","protected","typename","break","false","public","union","case","float","register","unsigned","catch","for","reinterpret_cast","using","char","friend","return","virtual","class","goto","short","void","compl","if","signed","volatile","const","inline","sizeof","wchar_t","const_cast","int","static","while","continue","long","static_cast","xor","default","mutable","struct","xor_eq","delete,","namespace","switch","do","new","template"};
    
    void highlight(JTextPane tp,String lang){
        textPane=tp;
        text=textPane.getText();
        len=textPane.getDocument().getLength();
        switch (lang) {
            case "C":       cHighlight();       break;
            case "Cpp":     cppHighlight();     break;
            case "Java":    javaHighlight();    break;
        }
    }
    
    void cHighlight(){
        Color defaultcolor=Color.BLACK;
        Color mainColor=defaultcolor;
        
        StyleContext sc=StyleContext.getDefaultStyleContext();
        AttributeSet aset=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,defaultcolor);
        textPane.getStyledDocument().setCharacterAttributes(0,len,aset,true);   //remove all highlights
        
        flag=0;
        for(int i=0;i<len;i++){
            char ch=text.charAt(i);
            aset=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,mainColor);
            textPane.getStyledDocument().setCharacterAttributes(i,i,aset,true); //current color-check below if it changes
            
            if(mainColor!=defaultcolor){
                if(ch=='\n'){
                    if(flag==0){    //flag to check " /*-*/ " type comments
                        mainColor=defaultcolor;
                        continue;
                    }
                }
                if(ch=='"'){
                    if(mainColor==color10){ //if one " already exists before it
                        mainColor=defaultcolor;
                        continue;   //keep its previous color
                    }
                    if(mainColor!=color2)  mainColor=color10;  //if a comment is not before it
                }
                else if(ch=='/'){
                    if(mainColor==color2 && flag==1 && (i-1)>0 && text.charAt(i-1)=='*'){
                        mainColor=defaultcolor;     //if (/*- */) pair completes
                        flag=0;
                        continue;
                    }
                    if(!(mainColor==color2 || mainColor==color10))  //if it is not a part of comment or statement
                        mainColor=defaultcolor; //ex-  " int/ "
                }
                else if(ch=='*'){
                }
                //check if a keyword is changed to normal word
            }
            else{
                if(ch=='/'){
                    if((i-1)>=0 && text.charAt(i-1)=='/'){
                        mainColor=color2;
                        aset=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,mainColor);
                        textPane.getStyledDocument().setCharacterAttributes(i-1,i-1,aset,true);//color previous '/'
                    }
                }
                else if(ch=='"')    mainColor=color10;  // statements "  "
                else if(ch=='*' && text.charAt(i-1)=='/'){
                    mainColor=color2;
                    aset=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,mainColor);
                    textPane.getStyledDocument().setCharacterAttributes(i-1,i-1,aset,true);//color previous '/'
                    flag=1;
                }
            }
            aset=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,mainColor);
            textPane.getStyledDocument().setCharacterAttributes(i,i,aset,true);
        }
    }
    int flag=0;//flag to check " /*-*/ " type comments
    
    void cppHighlight(){
        Color defaultcolor=Color.BLACK;
        StyleContext sc=StyleContext.getDefaultStyleContext();
        AttributeSet aset=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,Color.green);
        textPane.getStyledDocument().setCharacterAttributes(0,textPane.getDocument().getLength(),aset,true);
    }
    
    void javaHighlight(){
        Color defaultcolor=Color.BLACK;
        StyleContext sc=StyleContext.getDefaultStyleContext();
        AttributeSet aset=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,Color.cyan);
        textPane.getStyledDocument().setCharacterAttributes(0,textPane.getDocument().getLength(),aset,true);
    }
    JTextPane textPane;
    String text;
    int len;
    Color color1=Color.BLACK;
    Color color2=Color.BLUE;
    Color color3=Color.CYAN;
    Color color4=Color.DARK_GRAY;
    Color color5=Color.GRAY;
    Color color6=Color.GREEN;
    Color color7=Color.LIGHT_GRAY;
    Color color8=Color.MAGENTA;
    Color color9=Color.ORANGE;
    Color color10=Color.PINK;
    Color color11=Color.RED;
    Color color12=Color.WHITE;
    Color color13=Color.YELLOW;
}
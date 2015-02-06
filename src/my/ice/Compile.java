/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ak
 */
public class Compile {
    
    public Compile(String sourcePath,String selectedLanguage){
        this.sourcePath=sourcePath;
        this.selectedLanguage=selectedLanguage;
    }
    public Compile(String sourcePath,String inputPath,String CLA,String selectedLanguage){
        this.sourcePath=sourcePath;
        this.inputPath=inputPath;
        this.CLA=CLA;
        this.selectedLanguage=selectedLanguage;
    }
    
    public String compile(){
        
        BufferedReader stdOut=null;
        String line="";
        flag=0;     //flag sets if there is an exception(file not compiled)
        compileErrorString="";
        try {
            //COMPILATION ERRORS
            Process p1=Runtime.getRuntime().exec(getCompileCommand());
            stdOut = new BufferedReader(new InputStreamReader(p1.getErrorStream()));
            while ( (line = stdOut.readLine()) != null)
                compileErrorString+=line+'\n';
            stdOut.close();
            if( !(compileErrorString.contains("error") || compileErrorString.contains("exit status") || compileErrorString.contains("invalid flag") || compileErrorString.contains("Error")) )//DO IT FOR JAVA ALSO
                compileErrorString+="\n!!! FILE COMPILED SUCCESSFULLY !!!\n\n";
            
        } catch (IOException ex) {
            Logger.getLogger(Compile.class.getName()).log(Level.SEVERE, null, ex);
            flag=1;
            compileErrorString="error - unknown exception\n";
        }
        return compileErrorString;
    }
    public String runError(){
        
        BufferedReader stdOut=null,stdOut1;
        String line="";
        runErrorString="";runOutputString="";timeString="";
        try {
            if( !(compileErrorString.contains("error") || compileErrorString.contains("exit status") || compileErrorString.contains("invalid flag") || compileErrorString.contains("Error"))  && flag==0){//FOR JAVA ALSO
                //RUNTIME ERRORS
                String[] cmd={"/bin/bash","-c",getRunCommand()};
                Process p2=Runtime.getRuntime().exec(cmd);
                stdOut = new BufferedReader(new InputStreamReader(p2.getErrorStream()));
                stdOut1 = new BufferedReader(new InputStreamReader(p2.getInputStream()));     
                
                //CHECK IF NO RUNTIME ERRORS---WARNINGS ALLOWED----TIME IS SAVED IN STDERROR
                //OUTPUT
                //if i write errorstream then errors in printing--ICE hangs
                while ( (line = stdOut1.readLine()) != null)
                    runOutputString+=line+'\n'; 
                stdOut1.close();
                
                while ( (line = stdOut.readLine()) != null){
                    if( (line.startsWith("real") || line.startsWith("user") || line.startsWith("sys")) && line.endsWith("s") )
                        timeString+=line+'\n';
                    else
                        runErrorString+=line+'\n';
                }
                stdOut.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Compile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return runErrorString;
    }
    public String runOutput(){
        return runOutputString;
    }
    
    public String getTime(){
        return timeString;
    }
    private String getCompileCommand(){
        switch (selectedLanguage) {
            case "C":
                return ("gcc "+sourcePath+" -lm");
            case "C++":
                return ("g++ "+sourcePath+" -lm");
            case "Java":
                return ("javac "+sourcePath);
        }
        return "";
    }
    private String getRunCommand(){
        if(!inputPath.equals(""))
            inputPath=" <"+inputPath;//all language might not follow that
        switch (selectedLanguage) {
            case "C":
                return ("time ./a.out "+CLA+inputPath);
            case "C++":
                return ("time ./a.out "+CLA+inputPath);
            case "Java":
                int i,l=sourcePath.lastIndexOf('/'),r=sourcePath.lastIndexOf(".java");
                String s1=sourcePath.substring(0,l),s2=sourcePath.substring(l+1,r);
                return ("time java "+"-cp "+s1+" "+s2+" "+CLA+inputPath);//error here
        }
        return "";
    }
    
    String sourcePath="",inputPath="",CLA,timeString="",selectedLanguage;
    String compileErrorString="",runErrorString="",runOutputString="";
    int flag;
}
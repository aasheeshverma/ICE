/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ice;

/**
 *
 * @author ak
 */
public class Readme {
    String aboutMessage="\n\t\tTHE MELTING ICE\t\t\n"+
            "version 1.0.0\n"+
            "\n\n"+
            "Created by : \n\n"+
            "Aasheesh Verma\n"+
            "(MNNIT Allahabad)"
            ;
    
    String readmeMessage="REQUIREMENTS --\n" +
"\n" +
"1)	ubuntu(or other linux distro)\n" +
"2)	java developement kit(jdk 7)\n" +
"3)	gcc compiler\n" +
"4)	g++ compiler\n" +
"5)	javac compiler\n" +
"NOTE-(I have tested it in ubuntu 12.04 with jdk 7, but it should work on most linux distros)\n" +
"\n" +
"\n" +
"FEATURES THAT HAVE BEEN PROVIDED --\n" +
"\n" +
"1)	integration of text editor & console\n" +
"(everything in a single window, no wastage of time in switchings).\n" +
"2)	one click language selection\n" +
"3)	one click input file generation\n" +
"4)	one click output file generation\n" +
"5)	command line arguments\n" +
"6)	one click use of templates\n" +
"7)	automatic indentation\n" +
"8)	knowledge of \"time elapsed\" in execution of code\n" +
"9)	give inputs manually or use an input file\n" +
"10)	edit multiple files in different tabs\n" +
"\n" +
"\n" +
"FEATURES THAT ARE TO BE ADDED --\n" +
"\n" +
"1)	syntax highlighting and coloring according to language selected\n" +
"2)	line numbers in each file(text area)\n" +
"3)	find,replace etc. options in menubar\n" +
"4)	font selection, highlight current line & matching brackets\n" +
"5)	text wrapping, tab width and autosave file features\n" +
"6)	make console dynamic (dynamic flushing of ouput stream)\n" +
"7)	implement threads in console and editor frames.\n" +
"8)	Pop-up to save file on \"close\" and \"exit\".\n" +
"9)	Resizing of Editor and Console frames.\n" +
"10)	WINDOWS version of software.\n" +
"\n" +
"\n" +
"HOW TO USE --\n" +
"\n" +
"BEFORE RUNNING-\n" +
"1)	enable execution property of ICE.jar(Right-click on ICE.jar -> properties -> permissions -> allow executing file as program)\n" +
"2)	select default openwith application(Right-click on ICE.jar -> properties -> openwith -> Now select \"openJDK java runtime\" as default application\n" +
"3)	Now open the application\n" +
"4)	To run the project from the command line, go to the ICE folder and type the following:\n" +
"		java -jar ICE.jar\n" +
"\n" +
"AFTER RUNNING-\n" +
"1)	To create a new file press ctrl+N\n" +
"2)	To open an existing file press ctrl+O\n" +
"3)	Select language from language panel\n" +
"4)	\"Compile\" is not necessary, if you press \"run manually\" or \"run using file\",\n" +
"then file will be compiled automatically (and then executed).\n" +
"5)	you have 2 options to run a file, a--\"Browse\" input file to choose input file and then use \"run using file\",\n" +
"or b--type input(if any) in Console directly and use \"run manually\".\n" +
"6)	\"Create i/p file\" will open a default file and its path will be selected in input file field below.\n" +
"7)	\"Create op file\" is to \n" +
"8)	if you want to use Command Line Arguments then type them directly in CLA field(put space between every argument).\n" +
"9)	\"Templates\" opens a folder(selected by you) in which you keep your codes & templates which you often use\n" +
"(and so you can select those files in one click).\n" +
"10)	To select that folder \"browse\" template folder from the toolbar below(by default it is \\home\\user).\n" +
"\n" +
"\n" +
"PRECAUTIONS --\n" +
"\n" +
"1)	When you press run button, the file which is selected now...will be executed.\n" +
"so always select the tab of source file you want to execute(not any other tab). \n" +
"2)	Never execute a file which is having an infinite loop...Software will hang.\n" +
"3)	Never open files other than .txt, .c , .cpp & .java...Software may hang\n" +
"(mostly if file size is too large to read).\n" +
"4)	Before using \"run using file\" button, choose an input file using \"browse\" button of toolbar.\n" +
"5)	Use \"Create op file\" only after a file has been executed successfuly.\n" +
"\n" +
"NOTE - in case the software hangs...open terminal and type \"xkill\" and press enter.\n" +
"	using this tool, you can forcibly terminate the software.\n" +
"\n" +
"\n" +
"\n" +
"";
    public String getReadmeMessage(){
        return readmeMessage;
    }
    public String getAboutMessage(){
        return aboutMessage;
    }
}

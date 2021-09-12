import java.util.*;
/******************************************************************************
 *  Team Name: NWENT
 *  Partners: Connor Hoffman, Nick Martinez, Will Gibb
 *	Date: 9/11/2021   
 *
 * This is the main file of the project, which runs the keyboard emulator
 *  
 ******************************************************************************/
public class KeyBoard {

    public static void main(String[] args) {
    	List<keyboardKey>list=new ArrayList<keyboardKey>();
    	
    	String keys= "qwertyuiopazsxdcfvgbhnjm"; 
    	
    	for(int i=0;i<keys.length();i++) {
    		list.add(new keyboardKey(440 * Math.pow(1.06, i+1-24)));
    	}
    	StdDraw.picture(.5,.5,"keyboard.png");
    	play(keys,list);
    }
    
    public static void play(String keys,List<keyboardKey>list) {
    	while(true) {
    		if(StdDraw.hasNextKeyTyped()) {
    			char key=StdDraw.nextKeyTyped();
    			if(keys.contains(""+key)) {
    				int j=keys.indexOf(key);
        			list.get(j).pluck();
        			if(key == 'a') {
        				StdDraw.picture(.5,.5,"keyboardA.png");
        			}
        			if(key == 's') {
        				StdDraw.picture(.5,.5,"keyboardS.png");
        			}
        			if(key == 'd') {
        				StdDraw.picture(.5,.5,"keyboardD.png");
        			}
        			if(key == 'f') {
        				StdDraw.picture(.5,.5,"keyboardF.png");
        			}
        			if(key == 'g') {
        				StdDraw.picture(.5,.5,"keyboardG.png");
        			}
        			if(key == 'h') {
        				StdDraw.picture(.5,.5,"keyboardH.png");
        			}
        			if(key == 'j') {
        				StdDraw.picture(.5,.5,"keyboardJ.png");
        			}
        			if(key == 'z') {
        				StdDraw.picture(.5,.5,"keyboardZ.png");
        			}
        			if(key == 'x') {
        				StdDraw.picture(.5,.5,"keyboardX.png");
        			}
        			if(key == 'c') {
        				StdDraw.picture(.5,.5,"keyboardC.png");
        			}
        			if(key == 'v') {
        				StdDraw.picture(.5,.5,"keyboardV.png");
        			}
        			if(key == 'b') {
        				StdDraw.picture(.5,.5,"keyboardB.png");
        			}
        			if(key == 'n') {
        				StdDraw.picture(.5,.5,"keyboardN.png");
        			}
        			if(key == 'm') {
        				StdDraw.picture(.5,.5,"keyboardM.png");
        			}
        			if(key == 'q') {
        				StdDraw.picture(.5,.5,"keyboardQ.png");
        			}
        			if(key == 'w') {
        				StdDraw.picture(.5,.5,"keyboardW.png");
        			}
        			if(key == 'e') {
        				StdDraw.picture(.5,.5,"keyboardE.png");
        			}
        			if(key == 'r') {
        				StdDraw.picture(.5,.5,"keyboardR.png");
        			}
        			if(key == 't') {
        				StdDraw.picture(.5,.5,"keyboardT.png");
        			}
        			if(key == 'y') {
        				StdDraw.picture(.5,.5,"keyboardY.png");
        			}
        			if(key == 'u') {
        				StdDraw.picture(.5,.5,"keyboardU.png");
        			}
        			if(key == 'i') {
        				StdDraw.picture(.5,.5,"keyboardI.png");
        			}
        			if(key == 'o') {
        				StdDraw.picture(.5,.5,"keyboardO.png");
        			}
        			if(key == 'p') {
        				StdDraw.picture(.5,.5,"keyboardP.png");
        			}
    			}
    			else {
    				StdDraw.picture(.5, .5, "keyboardinv.png");
    			}
    		}
    		
    		double sample=0;
    		for(keyboardKey gs:list) {
    			sample+=gs.sample();
    		}
    		StdAudio.play(sample);
    		
    		for(keyboardKey gs:list) {
    			gs.tic();
    		}
    	}
    }

}
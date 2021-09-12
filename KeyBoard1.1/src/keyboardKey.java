/******************************************************************************
 *  Team Name: NWENT
 *  Partner Names: Connor Hoffman, Nick Martinez, Will Gibb
 *  Date: 9/11/2021    
 * 
 * Description: Simulates the sound when keys are pressed on the keyboard while the game is running.
 *  
 *
 ******************************************************************************/

public class keyboardKey {

    // creates a keyboard key of the specified frequency,
    // using sampling rate of 44,100
	ringBuffer Rb;
    public keyboardKey(double frequency) { 
    	int times =(int)(44100/frequency);
        Rb=new ringBuffer(times);
        for(int i=0;i<times;i++) {
        	Rb.enqueue(0);
        }
    }

    // creates a keyboard key whose size and initial values are given by
    // the specified array
    public keyboardKey(double[] init) {
    	Rb=new ringBuffer(init.length);
    	for(double u:init) {
    		Rb.enqueue(u);
    	}
    }

    // returns the number of samples in the ring buffer
    public int length() {
        return Rb.size();
    }

    // hits a key on the keyboard (by replacing the buffer with white noise)
    public void pluck() {
    	int x=Rb.size();
        for(int i=0;i<x;i++) {
        	Rb.dequeue();
        }
        for(int j=0;j<x;j++) {
        	Rb.enqueue(Math.random()-0.5);        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
    	double u=Rb.peek();
    	Rb.dequeue();
        Rb.enqueue(((u+Rb.peek())/2)*.994);
    }

    // returns the current sample
    public double sample() {
    	return Rb.peek();
    }


    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        keyboardKey key1=new keyboardKey(420);
        double[] d={420,69,666};
        keyboardKey key2= new keyboardKey(d);
        key1.pluck();
        key2.pluck();
        System.out.println(key1.sample());
        System.out.println(key2.sample());
    }

}

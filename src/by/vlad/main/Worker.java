package by.vlad.main;

public class Worker {

	private static final int INITIAL_SPEED = 1;
	private static final int SPEED_AFTER_ROTATE = -1;
	private static final String COMMAND_AHEAD = "A";
	private static final String COMMAND_ROTATE = "R";
	private static final int INITIAL_POSITION = 0;
	
	private static String commands;
	private static String path;
	private static int currentPosition;
	private static int speed;
	private static int count;
	
	public static void calcBestPath(int block) {
		
		commands = "";
		path = "" + INITIAL_POSITION;
		currentPosition = INITIAL_POSITION;
		speed = INITIAL_SPEED;
		count = 0;
		
		while (currentPosition != block) {
			
			//turn around if the block is in the other side
			if((block < currentPosition) && (speed > 0)) {
				commandR();
			} else if((block > currentPosition) && (speed < 0)){
				commandR();
			}
			
			//go until the nextPosition is no more than block
			while(((speed > 0) && ((currentPosition + speed ) <  block)) || ((speed < 0) && ((currentPosition + speed) >  block))) {
				commandA();
			}
			
			//if nextPosition equals block take a step and break
			if((currentPosition + speed) == block) {
				commandA();
				break;
			}
			
			if(((currentPosition  + speed / 2) == block) && (speed == 4 || speed == -4)) {
				blockOfcommandRAR_A(block);
				break;
			}
			
			if(((block - currentPosition) % 2 == 0) && ((currentPosition + speed) > block) && ((currentPosition + speed / 2) > block)
					&& (((block -currentPosition) / 2) % 2 != 0)) {
				blockOfcommandRAR_A(block);
				break;
			} else if(((block - currentPosition) % 2 == 0) && ((currentPosition + speed) < block) && ((currentPosition + speed / 2) < block)
					&& (((block -currentPosition) / 2) % 2 != 0)) {
				blockOfcommandRAR_A(block);
				break;
			}
			
			//check to make the next step or turn around
			if(speed > 0) {
				if((currentPosition + speed / 2) > block) {
					commandR();
					commandR();
				}else {
					commandA();			
				}
			}else {
				if((currentPosition + speed / 2) < block) {
					commandR();
					commandR();
				}else {
					commandA();
				}
			}
		}
		System.out.println("========================================");
		System.out.println("Block: " + block + "\n" + "Num of steps: " + count + "\n" + "List of commands: " + commands
				+ "\n" + "Way: " + path);
	}
	
	private static void commandA() {
		currentPosition += speed;
		speed *= 2;
		
		commands += COMMAND_AHEAD;
		count++;
		path += "->" + currentPosition;
	}
	
	private static void commandR() {
		if(speed > 0) {
			speed = SPEED_AFTER_ROTATE;
		}else {
			speed = INITIAL_SPEED;
		}
		commands += COMMAND_ROTATE;
		count++;
		path += "->" + currentPosition;
	}
	
	private static void blockOfcommandRAR_A(int block){
		commandR();
		commandA();
		commandR();
		while((currentPosition + speed ) !=  block) {
			commandA();
		}
		commandA();
	}
}

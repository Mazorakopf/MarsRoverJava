package by.vlad.main;

public class Worker {

	private static final int INITIAL_SPEED = 1;
	private static final int SPEED_AFTER_ROTATE = -1;
	private static final String COMMAND_AHEAD = "A";
	private static final String COMMAND_ROTATE = "R";
	private static final int INITIAL_POSITION = 0;
	
	public static void calcBestPath(int block) {
		String commands = "";
		String path = "" + INITIAL_POSITION;
		int currentPosition = INITIAL_POSITION;
		int speed = INITIAL_SPEED;
		int count = 0;

		while (currentPosition != block) {
			
			//turn around if the block is in the other side
			if((block < currentPosition) && (speed > 0)) {
				speed = SPEED_AFTER_ROTATE;
				
				commands += COMMAND_ROTATE;
				count++;
				path += "->" + currentPosition;
			} else if((block > currentPosition) && (speed < 0)){
				speed = INITIAL_SPEED;
				
				commands += COMMAND_ROTATE;
				count++;
				path += "->" + currentPosition;
			}
			
			//go until the nextPosition is no more than block
			while(((speed > 0) && ((currentPosition + speed ) <  block)) || ((speed < 0) && ((currentPosition + speed) >  block))) {
				currentPosition += speed;
				speed *= 2;
				
				commands += COMMAND_AHEAD;
				count++;
				path += "->" + currentPosition;
			}
			
			//if nextPosition equals block take a step and break
			if((currentPosition + speed) == block) {
				currentPosition += speed;
				speed *=2;
				
				commands += COMMAND_AHEAD;
				count++;
				path += "->" + currentPosition;
				break;
			}
			
			//check to make the next step or turn around
			if(speed > 0) {
				if((currentPosition + speed/2) >= block) {
					speed = INITIAL_SPEED;
					
					count += 2;
					commands += COMMAND_ROTATE + COMMAND_ROTATE;
					path += "->" + currentPosition + "->" + currentPosition;
				}else {
					currentPosition += speed;
					
					commands += COMMAND_AHEAD;
					count++;
					path += "->" + currentPosition;			
				}
			}else {
				if((currentPosition + speed/2) <= block) {
					speed = SPEED_AFTER_ROTATE;
					
					count += 2;
					commands += COMMAND_ROTATE + COMMAND_ROTATE;
					path += "->" + currentPosition + "->" + currentPosition;
				}else {
					currentPosition += speed;
					
					commands += COMMAND_AHEAD;
					count++;
					path += "->" + currentPosition;
				}
			}
		}
		System.out.println("========================================");
		System.out.println("Block: " + block + "\n" + "Num of steps: " + count + "\n" + "List of commands: " + commands
				+ "\n" + "Way: " + path);
	}
}

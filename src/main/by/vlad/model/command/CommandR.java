package by.vlad.model.command;

import by.vlad.model.entity.MarsRover;

public class CommandR implements Command{
	
	@Override
	public void perform(MarsRover rover) {
		rover.setSpeed((rover.getSpeed() > 0) ? -1 : 1);
	}
}
package by.vlad.model.command;

import by.vlad.model.entity.MarsRover;

public class CommandA implements Command{

	@Override
	public void perform(MarsRover rover) {
		rover.setPosition(rover.getPosition() + rover.getSpeed());
		rover.setSpeed(rover.getSpeed()*2);
	}
}

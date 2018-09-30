package by.vlad.model.command;

import by.vlad.model.entity.MarsRover;

public interface Command {

	public void perform(MarsRover rover);
}

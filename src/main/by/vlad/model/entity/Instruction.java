package by.vlad.model.entity;

import by.vlad.model.command.*;

public class Instruction {

	private static final String COMMAND_A = "A";
	private static final String COMMAND_R = "R";

	private int count;
	private String commands;
	private String way;

	public Instruction() {
		count = 0;
		commands = "";
		way = "0";
	}

	public Instruction(int position, MarsRover rover) {
		this();
		init(position, rover);
	}

	public int getCount() {
		return count;
	}

	public String getCommands() {
		return commands;
	}

	public String getWay() {
		return way;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commands == null) ? 0 : commands.hashCode());
		result = prime * result + count;
		result = prime * result + ((way == null) ? 0 : way.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instruction other = (Instruction) obj;
		if (commands == null) {
			if (other.commands != null)
				return false;
		} else if (!commands.equals(other.commands))
			return false;
		if (count != other.count)
			return false;
		if (way == null) {
			if (other.way != null)
				return false;
		} else if (!way.equals(other.way))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instruction:\nNum of moves = " + count + "\nCommands = " + commands + "\nWay = " + way;
	}

	private void init(int position, MarsRover rover) {

		while (position != rover.getPosition()) {

			while (position > rover.getPosition()) {
				rover.execute(new CommandA());
				recordData(COMMAND_A, rover);
			}

			if (position != rover.getPosition()) {
				rover.execute(new CommandR());
				recordData(COMMAND_R, rover);
			} else {
				break;
			}

			while (position < rover.getPosition()) {
				rover.execute(new CommandA());
				recordData(COMMAND_A, rover);
			}

			if (position != rover.getPosition()) {
				rover.execute(new CommandR());
				recordData(COMMAND_R, rover);
			} else {
				break;
			}
		}
	}

	private void recordData(String command, MarsRover rover) {
		count++;
		commands += command;
		way += "->" + rover.getPosition();
	}
}

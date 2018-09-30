package by.vlad.model.entity;

import by.vlad.model.command.Command;

public class MarsRover {
	
	private int speed;
	private int position;
	
	public MarsRover() {
		speed = 1;
		position = 0;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getPosition() {
		return position;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void execute(Command command) {
		command.perform(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + position;
		result = prime * result + speed;
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
		MarsRover other = (MarsRover) obj;
		if (position != other.position)
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MarsRover [speed=" + speed + ", position=" + position + "]";
	}
}

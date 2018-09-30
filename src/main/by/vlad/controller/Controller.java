package by.vlad.controller;

import by.vlad.model.entity.Instruction;
import by.vlad.model.entity.MarsRover;
import by.vlad.view.View;

public class Controller {

	public static void main(String[] args) {
		MarsRover rover = new MarsRover();

		View.print(rover.toString());
		
		Instruction inst = new Instruction(6, rover);
		
		View.print(inst.toString(), rover.toString());
	}

}

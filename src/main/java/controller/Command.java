package controller;

import java.util.Arrays;
import java.util.function.Consumer;

public enum Command {
	ORDER(1, ChickenController::order, false),
	PAY(2, ChickenController::pay, false),
	EXIT(3, chickenController -> {}, true);

	private final int number;
	private final Consumer<ChickenController> consumer;
	private final boolean isExit;

	Command(int number, Consumer<ChickenController> consumer, boolean isExit) {
		this.number = number;
		this.consumer = consumer;
		this.isExit = isExit;
	}

	public static Command findByNumber(int number) {
		return Arrays.stream(values())
			.filter(command -> command.number == number)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("값에 해당하는 명령이 없습니다."));
	}

	public boolean execute(ChickenController chickenController) {
		consumer.accept(chickenController);
		return isExit;
	}
}

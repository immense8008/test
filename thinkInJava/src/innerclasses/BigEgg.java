package innerclasses;

//: innerclasses/BigEgg.java
//An inner class cannot be overriden like a method.
import static util.Print.print;

class Egg {
	private Yolk y;

	protected class Yolk {
		public Yolk() {
			print("Egg.Yolk()");
		}
	}

	public Egg() {
		print("New Egg()");
		y = new Yolk();
	}
}

public class BigEgg extends Egg {
	public class Yolk {
		public Yolk() {
			print("BigEgg.Yolk()");
		}
	}

	public static void main(String[] args) {
		BigEgg big = new BigEgg();
		Yolk bYolk = big.new Yolk();
	}
} /* Output:
New Egg()
Egg.Yolk()
*///:~

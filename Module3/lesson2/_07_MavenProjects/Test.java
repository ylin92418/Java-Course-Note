public class Test{

	public static main(Srting[] args) {

		Operation op = new Operation(3,2);
		Clock clock = new Clock();
		Instant before = clock.instant();
		op.add()
		Instant after = clocl.instant();

		Duration duration = Duration.between(before, after);
		System.out.println(duration.toString());
	}

	public class Profiler{
		Operation op;

		public Profiler(Operation op) {
			this.op = op;
		}

		public Duration profile(){
			
		}

	}


	public Operation {
		int a;
		int b;
		public Operation(int a, int b) {
			this.a = a;
			this.b = b;
		}

		int add() {
			return a + b;
		}

		int substract() {
			return a - b;
		}


	}

}

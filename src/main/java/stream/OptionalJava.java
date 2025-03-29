package stream;

import java.util.Optional;

public class OptionalJava {
	public static void main(String[] args) {
		// Creating Optionals
		Optional<String> optionalWithValue = Optional.of("Hello");
		Optional<String> optionalWithNullableValue = Optional.ofNullable("World");
		Optional<String> emptyOptional = Optional.empty();

		// Checking Presence
		System.out.println("Optional with value is present: " + optionalWithValue.isPresent()); // true
		System.out.println("Empty optional is present: " + emptyOptional.isPresent()); // false

		// Accessing Values (Safely)
		optionalWithValue.ifPresent(value -> {
			System.out.println("Value: " + value);

		}
		); // Prints "Value: Hello"

		emptyOptional.ifPresent(value -> {
			System.out.println("emptyOptional value before assignment: " + value);

		}
		); // Prints "Value: Hello"
		
		String valueOrElse = emptyOptional.orElse("Default Value");
		System.out.println("Value or else: " + valueOrElse); // Prints "Default Value"

		String valueOrElseGet = emptyOptional.orElseGet(() -> "Lazy Default");
		System.out.println("Value or else get: " + valueOrElseGet); // Prints "Lazy Default" (executed only if empty)

		// Null Handling and Mapping
		String nullString = null;
		Optional<String> optionalNull = Optional.ofNullable(nullString);

		Optional<Integer> mappedValue = optionalWithValue.map(String::length);
		System.out.println("Mapped length: " + mappedValue.orElse(-1)); // Prints 5

		Optional<Integer> mappedNull = optionalNull.map(String::length); // does not throw null pointer exception!
		System.out.println("Mapped null: " + mappedNull.orElse(-1)); // Prints -1

		// FlatMap (for nested Optionals)
		Optional<String> nestedOptional = Optional.of("Outer");
		Optional<Optional<String>> doubleOptional = nestedOptional.map(s -> Optional.of(s + " Inner"));

		Optional<String> flattenedOptional = nestedOptional.flatMap(s -> Optional.of(s + " Inner"));
		System.out.println("Flattened: " + flattenedOptional.orElse("Nothing")); // Prints Outer Inner

		// Handling nulls directly
		String possibleNull = getPossibleNull();
		Optional<String> fromPossibleNull = Optional.ofNullable(possibleNull);

		if (fromPossibleNull.isPresent()) {
			System.out.println("Value from possible null: " + fromPossibleNull.get());
		} else {
			System.out.println("Possible null was null");
		}
	}

	public static String getPossibleNull() {
		// Simulating a method that might return null
		if (Math.random() < 0.5) {
			return "Some Value";
		} else {
			return null;
		}
	}
}

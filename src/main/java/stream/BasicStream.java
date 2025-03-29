package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStream {

	static List<String> lines;

	static Stream<String> result;

	public static void init() {
		lines = Arrays.asList("spring", "node", "mkyong");
	}

	public static void filterPerson() {

		List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
				new Person("lawrence", 40));

		Person result1 = persons.stream().filter((p) -> "jack".equals(p.getName()) && 50 == p.getAge()).findAny()
				.orElse(null);

		System.out.println("Person exist --->" + (result1 != null));
	}

	public static void replace() {

		List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
				new Person("lawrence", 40));
		// p.equals("agent") ? "manager" : p.equals("manager") ? "agent" : p
		
        List<String> collect = persons.stream().map(x -> x.getName()).collect(Collectors.toList());

	}

	public static void forEach() {

		List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
				new Person("lawrence", 40));

		persons.stream().forEach(p ->

		{
			System.out.println("p age-->" + p.getAge());
			if (p.getAge() == 30) {
				System.out.println("match");
			}
		});
	}

	public static void filter() {

		System.out.println("\nfilter");

		init();

		result = lines.stream().filter(str -> !"mkyong".equals(str));

		result.forEach(System.out::println); // output : spring, node
	}

	public static void findAny() {

		System.out.println("\nfindAny");

		init();

		Optional<String> result = lines.stream().filter(str -> "mkyong".equals(str)).findAny();

		System.out.println("result is present -->" + result.isPresent());

	}

	public static void findFirst() {

		System.out.println("\nfindAny");

		init();

		Optional<String> result = lines.stream().filter(str -> "mkyong".equals(str)).findFirst();

		System.out.println("result is present -->" + result.isPresent());

	}
	
	public static void contains() {

		System.out.println("\ncontains");

		init();
		boolean isCOntains = lines.contains("mkyong");

		System.out.println("result is contains -->" + isCOntains);

	}

	public static void main(String[] args) {
		// filter();
		 findAny();
		// contains();
		// filterPerson();
		// forEach();
	}
}

package day8n9;

import java.util.*;
import java.util.stream.Collectors;



public class CopyOfDemoBookCaseStudyProblem {

	public static void main(String[] args) {

		List<Book> allBooks = loadAllBooks();
		List<Book> booksMoreThen400Pages = allBooks.stream()
				.filter(b -> b.getPages() > 400)
				.collect(Collectors.toList());
		System.out.println("Books with more than 400 pages: " + booksMoreThen400Pages);
		// 2. Find all books that are java books and more than 400 pages
		List<Book> javaBooksMoreThan400Pages = allBooks.stream()
				.filter(b -> b.getSubject() == Subject.JAVA && b.getPages() > 400)
				.collect(Collectors.toList());
		System.out.println("Java books with more than 400 pages: " + javaBooksMoreThan400Pages);

		// 3. Top three longest books
		List<Book> topThreeLongestBooks = allBooks.stream()
				.sorted(Comparator.comparingInt(Book::getPages).reversed())
				.limit(3)
				.collect(Collectors.toList());
		System.out.println("Top three longest books: " + topThreeLongestBooks);

		// 4. From the fourth to the last longest books
		List<Book> fourthToLastBooks = allBooks.stream()
				.sorted(Comparator.comparingInt(Book::getPages).reversed())
				.skip(3)
				.collect(Collectors.toList());
		System.out.println("Books from fourth to the last: " + fourthToLastBooks);

		// 5. Get all publishing years
		List<Integer> publishingYears = allBooks.stream()
				.map(Book::getYear)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Publishing years: " + publishingYears);

		// 6. Get all authors' names who have written a book
		List<String> allAuthorNames = allBooks.stream()
				.flatMap(b -> b.getAuthors().stream())
				.map(Author::getName)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Authors' names: " + allAuthorNames);

		// Get all origin countries of the authors
		List<String> allOriginCountries = allBooks.stream()
				.flatMap(b -> b.getAuthors().stream())
				.map(Author::getCountry)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Authors' origin countries: " + allOriginCountries);

		// Most recent published book
		Optional<Book> mostRecentBook = allBooks.stream()
				.max(Comparator.comparingInt(Book::getYear));
		System.out.println("Most recent book: " + mostRecentBook.orElse(null));

		// Check if all books are written by more than one author
		boolean allBooksByMultipleAuthors = allBooks.stream()
				.allMatch(b -> b.getAuthors().size() > 1);
		System.out.println("All books written by more than one author: " + allBooksByMultipleAuthors);

		// Find one book written by more than one author
		Optional<Book> bookByMultipleAuthors = allBooks.stream()
				.filter(b -> b.getAuthors().size() > 1)
				.findAny();
		System.out.println("One book by multiple authors: " + bookByMultipleAuthors.orElse(null));

		// Total number of pages published
		int totalPages = allBooks.stream()
				.mapToInt(Book::getPages)
				.sum();
		System.out.println("Total pages published: " + totalPages);

		// Longest book's number of pages
		int longestBookPages = allBooks.stream()
				.mapToInt(Book::getPages)
				.max()
				.orElse(0);
		System.out.println("Pages in the longest book: " + longestBookPages);

		// Average number of pages of the books
		double averagePages = allBooks.stream()
				.mapToInt(Book::getPages)
				.average()
				.orElse(0.0);
		System.out.println("Average pages: " + averagePages);

		// Titles of all books
		List<String> bookTitles = allBooks.stream()
				.map(Book::getTitle)
				.collect(Collectors.toList());
		System.out.println("Book titles: " + bookTitles);

		// Book with the highest number of authors
		Optional<Book> bookWithMostAuthors = allBooks.stream()
				.max(Comparator.comparingInt(b -> b.getAuthors().size()));
		System.out.println("Book with most authors: " + bookWithMostAuthors.orElse(null));

		// Map of books per year
		Map<Integer, List<Book>> booksPerYear = allBooks.stream()
				.collect(Collectors.groupingBy(Book::getYear));
		System.out.println("Books per year: " + booksPerYear);

		// Count how many books are published per year
		Map<Integer, Long> bookCountPerYear = allBooks.stream()
				.collect(Collectors.groupingBy(Book::getYear, Collectors.counting()));
		System.out.println("Book count per year: " + bookCountPerYear);
	}

	private static List<Book> loadAllBooks() {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors1 = Arrays.asList(new Author("raj", "gupta", "in"),
				new Author("ekta", "gupta", "in"));

		List<Author> authors2 = Arrays.asList(new Author("raj", "gupta", "in"));

		List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
				new Author("keshav", "gupta", "us"));

		books.add(new Book("java", authors1, 400, Subject.JAVA, 2000, "1213"));
		books.add(new Book("python", authors2, 479, Subject.JAVA, 2007, "1218"));
		books.add(new Book("Mgt", authors3, 600, Subject.DOT_NET, 2000, "1293"));

		return books;
	}

}

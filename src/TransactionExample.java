import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionExample {
    public static void main(String[] args) {
        // Sample data: list of transactions
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, 100.0, "credit", "A"),
                new Transaction(2, 200.0, "debit", "B"),
                new Transaction(3, 300.0, "credit", "C"),
                new Transaction(4, 400.0, "debit", "D"),
                new Transaction(5, 500.0, "credit", "E")
        );




        Map<Integer, Transaction> trxWithId = transactions.stream().collect(Collectors.toMap(Transaction::getId, Function.identity()));
        System.out.println(trxWithId.get(1));
        // Problem: Find the total amount of 'credit' transactions
        double totalCreditAmount = transactions.stream()
                .filter(transaction -> transaction.getType().equals("credit"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        /*
         Given a list of transactions,
         each represented by a Transaction object with attributes like id, amount, and type,
         write a Java program to find the total amount of transactions of a specific type.
         Print the total amount of 'credit' transactions
        */


        String names[] = {"sammed", "sumit", "kunal", "suraj"};

        System.out.println(Arrays.stream(names).filter(name -> name.charAt(0) == 's').collect(Collectors.toList()));

        Stream<String> s = Stream.of(names);
        List<String> upperCase = s.map(String::toUpperCase).toList();
        System.out.println(upperCase);

        System.out.println("Total amount of 'credit' transactions: " + totalCreditAmount);
    }
}

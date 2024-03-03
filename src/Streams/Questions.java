package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Questions {

    public static void main(String[] args) {
        List<Transaction> allTransactions = new ArrayList<>();
        allTransactions.add(new Transaction(1, 100.0, "credit", "John"));
        allTransactions.add(new Transaction(2, 200.0, "debit", "Alice"));
        allTransactions.add(new Transaction(3, 150.0, "credit", "John"));
        allTransactions.add(new Transaction(4, 300.0, "credit", "Alice"));
        allTransactions.add(new Transaction(5, 250.0, "debit", "John"));


        // 1
        // Filter Transactions by Type: Given a list of transactions,
        // filter out all transactions of a specific type (e.g., "credit").
        List<Transaction> filterTransactions = allTransactions.stream().
                filter(t -> t.getType() == "credit").
                collect(Collectors.toList());

        // System.out.println(filterTransactions);

        // 2
        // Find Total Amount of Transactions: Calculate the total amount of all transactions in the list.
        long totalTransactions = allTransactions.stream().count();
        // System.out.println(totalTransactions);

        // 3
        // Find Highest Transaction Amount: Find the transaction with the highest amount in the list.
        Optional<Transaction> high = allTransactions.stream().max(Comparator.comparing(Transaction::getAmount));
        // System.out.println(high);

        // 4
        // Group Transactions by Type: Group transactions by their type (e.g., "credit" or "debit").
        // using collectors inbuilt functionality
        Map<String, List<Transaction>> grpByType = allTransactions.stream().collect(Collectors.groupingBy(Transaction::getType));
        // System.out.println(grpByType);

        // 5
        // Find Average Transaction Amount by Type: Calculate the average transaction amount for each type of transaction.
        // Map<String, Integer> avgAmtByType = allTransactions.stream()

        // 6
        // Find Transactions by Name
        List<Transaction> findByName = allTransactions.stream().filter(t -> t.getName() == "John").collect(Collectors.toList());
        // System.out.println(findByName);

        // 7
        // Count Transaction by there type
        Map<String, Long> cntByType = allTransactions.stream().collect(Collectors.groupingBy(Transaction:: getType, Collectors.counting()));
        System.out.println(cntByType);
//      In this code:
//      We use the groupingBy() collector to group transactions by their type.
//      Inside the groupingBy() collector, we use the counting() collector to count the number of transactions in each group.

        // 8
        // Check if Any Transaction Exceeds a Threshold
        List<Transaction> trxWithHighThreshold = allTransactions.stream().filter(t -> t.getAmount() > 120).toList();
        // System.out.println(trxWithHighThreshold);

        // 9
        // sort by amount
        List<Transaction> sortByAmount = allTransactions.stream().sorted(Comparator.comparing(Transaction::getAmount)).toList();
        //System.out.println(sortByAmount);

        // 10
        // Total amount by name
        Map<String, Double> totalByName = allTransactions.stream().collect(Collectors.groupingBy(Transaction:: getName, Collectors.summingDouble(value -> value.getAmount())));
        System.out.println(totalByName);
    }
}

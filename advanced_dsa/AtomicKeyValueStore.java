package advanced_dsa;
import java.util.*;

public class AtomicKeyValueStore {
    Map<String, String> store = new HashMap<>();
    List<String> ans = new ArrayList<>();
    /**
     * SET my_key original_value
     * BEGIN
     * SET my_key second_value
     * SET another_key another_value
     * RETURN my_key
     * BEGIN
     * SET my_key third_value
     * RETURN my_key
     * RETURN another_key
     * COMMIT
     * SET my_key fourth_value
     * ROLLBACK
     * RETURN my_key
     * 
     * @param operations
     * @return
     */
    public List<String> keyValueStore(List<String> operations) {
        Stack<Transaction> stack = new Stack<>();
        for (String operation: operations) {
            String[] opList = operation.split("\s");
            String op = opList[0];
            if (op.equals("BEGIN")) {
                Transaction transaction = new Transaction(store);
                stack.push(transaction);
            } else if (op.equals("COMMIT")) {
                // Invalid input
                if (stack.isEmpty()) {
                    return null;
                }
                Transaction transaction2Commit = stack.pop();
                for (String op2Execute: transaction2Commit.transactionOps) {
                    execute(op2Execute);
                }
            } else if (op.equals("ROLLBACK")) {
                if (stack.isEmpty()) {
                    return null;
                }
                // restore map
                Transaction transaction2Rollback = stack.pop();
                restoreOnSnapshot(transaction2Rollback.snapshot);
            } else {
                if (!stack.isEmpty()) {
                    Transaction topTransaction = stack.peek();
                    topTransaction.transactionOps.add(operation);
                } else {
                    // No transaction -> normal execution
                    execute(operation);
                }
            }
        }
        return ans;
    }

    private void restoreOnSnapshot(Map<String, String> snapshot) {
        store = new HashMap<>();
        for (String key: snapshot.keySet()) {
            store.put(key, snapshot.get(key));
        }
    }

    private void execute(String operation) {
        String[] opList = operation.split("\s");
        String op = opList[0];
        if (op.equals("SET")) {
            String key = opList[1], value = opList[2];
            store.put(key, value);
        } else if (op.equals("RETURN")) {
            String key = opList[1];
            ans.add(store.getOrDefault(key, ""));
        }
    }
}

class Transaction {
    List<String> transactionOps;
    Map<String, String> snapshot;

    public Transaction(Map<String, String> store) {
        transactionOps = new ArrayList<>();
        snapshot = new HashMap<>();
        for (String key: store.keySet()) {
            snapshot.put(key, store.get(key));
        }
    }
}

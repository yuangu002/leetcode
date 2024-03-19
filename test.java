import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import advanced_dsa.AtomicKeyValueStore;

public class Test {

    /**
     * SET my_key original_value
     * BEGIN
     * SET my_key second_value
     * SET another_key another_value
     * RETURN my_key
     * BEGIN
     * SET my_key third_value
     * SET another_key second_another_value
     * RETURN my_key
     * RETURN another_key
     * COMMIT
     * SET my_key fourth_value
     * ROLLBACK
     * RETURN my_key
     * RETURN another_key
     */
    public static void main(String[] args){
        List<String> input = new ArrayList<String>(Arrays.asList(
                "SET my_key original_value",
                "BEGIN",
                "SET my_key second_value",
                "SET another_key another_value",
                "RETURN my_key",
                "BEGIN",
                "SET my_key third_value",
                "SET another_key second_another_value",
                "RETURN my_key",
                "RETURN another_key",
                "COMMIT",
                "SET my_key fourth_value",
                "ROLLBACK",
                "RETURN my_key",
                "RETURN another_key")
        );
        AtomicKeyValueStore store = new AtomicKeyValueStore();
        List<String> output = store.keyValueStore(input);
        for (String s: output) {
            System.out.println(s);
        }
    }
}
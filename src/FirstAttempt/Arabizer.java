package FirstAttempt;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by aunk05 on 15/01/17 as an exercise.
 *
 * The task is to convert a String of any valid representation of a number in Roman Numerals -
 * characters M, D, C, L, X, V, I subject to the various precedence and antecedence rules -
 * into the corresponding int value.
 *
 * Before we do any testing, let alone coding, there is some insight we need to achieve ... now,
 * what might that be ...
 *
 * Well, today I learned that a foreach preserves order, which is something of which I had not
 * previously been sure.
 *
 * This solution does not test that the input is valid, but you didn't ask for that, right? OTOH you DID
 * ask that it should actually print out the result and it doesn't do that either, but that's just manual
 * labour.
 *
 * By default, the values of each Roman 'digit' are summed left to right according to the values in the map.
 * However, when a character is encountered which maps to an int value higher than the previous, this is interpreted
 * as a 'mistake' having been made - the previous was really a subtrahend to the current and not an addend to the
 * total. Hence, after the current value has been added, the previous must be subtracted twice - once to correct the
 * mistake, and again to decrease the current value.
 *
 */
class Arabizer {

    int convert(String roman) {

        Map<Character, Integer> values = new HashMap<>();

        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);

        int result = 0;
        int temp = 0, next;
        char[] r = roman.toCharArray();
        for (char c : r) {
            next = values.get(c);
            if (next > temp) {
                result += next;
                result -= 2 * temp;
            } else result += next;
            temp = next;
        }
        return result;
    }

}

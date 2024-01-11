/**
 * Take an oldArray and remove every second element from the oldArray. Always
 * keep the
 * first element and start removing with the next element.
 * 
 * Example:
 * ["Keep", "Remove", "Keep", "Remove", "Keep", ...] --> ["Keep", "Keep",
 * "Keep", ...]
 * 
 * None of the arrays will be empty, so you don't have to worry about that!
 */
public class RemovingElements {

    public static Object[] removeEveryOther(Object[] oldArray) {
        int arrayLength = oldArray.length;
        Object[] newArray;

        if (arrayLength % 2 == 0) {
            newArray = new Object[arrayLength / 2];
        } else {
            newArray = new Object[(arrayLength / 2) + 1];
        }

        for (int i = 0; i < newArray.length; i++) { // recorro el newArray
            for (int j = 0; j < oldArray.length; j++) { // recorro oldArray
                if (j % 2 == 0) {
                    newArray[i] = oldArray[j];
                } else {
                    i++;
                }
            }

        }

        return newArray;
    }

    public static void main(String[] args) {
        Object[] originalArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        Object[] newArray = new Object[originalArray.length / 2];
        newArray = removeEveryOther(originalArray);
        for (Object object : newArray) {
            System.out.println(object);

        }

    }

}
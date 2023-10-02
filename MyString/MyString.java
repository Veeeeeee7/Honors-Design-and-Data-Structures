
import java.util.ArrayList;

public class MyString {

    private char[] chars;

    // Constructs a new empty MyString
    // O(1)
    public MyString() {
        chars = new char[0];
    }

    // Constructs a new MyString by COPYING
    // the chars from the given array;
    // if the chars in that array later change,
    // the MyString should not be affected
    // this.chars should be IMMUTABLE
    // O(n)
    public MyString(char[] chars) {
        this.chars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            this.chars[i] = chars[i];
        }
    }

    // Prints the contents of MyString to System.out
    // O(n)
    public void print() {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }

    // For all methods below without comments: see
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
    // for explanations of what the parameters
    // mean and what they should return

    // O(1)
    public int length() {
        return chars.length;
    }

    // O(n)
    public MyString substring(int from, int to) {
        char[] newStr = new char[to - from];
        for (int i = from; i < to; i++) {
            newStr[i - from] = chars[i];
        }
        return new MyString(newStr);
    }

    // O(n)
    public MyString substring(int from) {
        return substring(from, chars.length);
    }

    // O(n)
    public int indexOf(char ch) {
        return indexOf(ch, 0);
    }

    // O(n)
    public int indexOf(char ch, int fromindex) {
        for (int i = fromindex; i < chars.length; i++) {
            if (chars[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    // O(n)
    private int hash(char[] chars, int MOD) {
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += ((chars[i] - 'a') * Math.pow(26, i)) % MOD;
        }
        return sum;
    }

    // O(n^2) O(nm)
    public int indexOf(MyString str) {
        if (str.length() > chars.length) {
            return -1;
        }

        str.toLowerCase();
        int hash = hash(str.chars, 1000000007);
        for (int i = 0; i < chars.length - str.length() + 1; i++) {
            MyString sub = substring(i, i + str.length());
            sub.toLowerCase();
            if (hash(sub.chars, 1000000007) == hash) {
                if (sub.equals(str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // O(n^2) O(nm)
    public int indexOf(MyString str, int fromindex) {
        if (str.length() > chars.length) {
            return -1;
        }

        str.toLowerCase();
        int hash = hash(str.chars, 1000000007);
        for (int i = fromindex; i < chars.length - str.length() + 1; i++) {
            MyString sub = substring(i, i + str.length());
            sub.toLowerCase();
            if (hash(sub.chars, 1000000007) == hash) {
                if (sub.equals(str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Creates a new MyString with all instances of the char before
    // replaced with the char after
    // O(n)
    public MyString replace(char before, char after) {
        char[] newStr = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == before) {
                newStr[i] = after;
            } else {
                newStr[i] = chars[i];
            }
        }
        return new MyString(newStr);
    }

    // Creates a new MyString with all instances of the substring before
    // replaced with the substring after
    // O(n^2)
    public MyString replace(MyString before, MyString after) {
        MyString[] split = splitWithSpace(before);
        MyString newStr = new MyString();
        for (int i = 0; i < split.length - 1; i++) {
            newStr = newStr.add(split[i]);
            newStr = newStr.add(after);
        }
        newStr = newStr.add(split[split.length - 1]);
        return newStr;
    }

    // O(nm)
    public boolean contains(MyString str) {
        return indexOf(str) > -1;
    }

    // O(1)
    public char charAt(int index) {
        return chars[index];
    }

    // Returns an array of MyStrings containing the different substrings
    // of this MyString, divided by the divider
    // E.g.: if MyString were "the brown fox" and divider were " ",
    // this would return ["the", "brown", "fox"]
    // O(n^2)
    public MyString[] split(MyString divider) {
        ArrayList<MyString> strList = new ArrayList<MyString>();
        int index = 0;
        while (index < chars.length && indexOf(divider, index) > -1) {
            int endIndex = indexOf(divider, index);
            if (index != endIndex) {
                strList.add(substring(index, endIndex));
            }
            index = endIndex + divider.length();
        }
        strList.add(substring(index));

        return strList.toArray(new MyString[strList.size()]);
    }

    // O(n^2)
    private MyString[] splitWithSpace(MyString divider) {
        ArrayList<MyString> strList = new ArrayList<MyString>();
        int index = 0;
        while (index < chars.length && indexOf(divider, index) > -1) {
            int endIndex = indexOf(divider, index);
            strList.add(substring(index, endIndex));
            index = endIndex + divider.length();
        }
        strList.add(substring(index));

        return strList.toArray(new MyString[strList.size()]);
    }

    // O(n)
    public MyString trim() {
        int front = 0;
        while (chars[front] == ' ') {
            front++;
        }

        int back = chars.length - 1;
        while (chars[back] == ' ') {
            back--;
        }

        char[] newStr = new char[chars.length - front - (chars.length - 1 - back)];
        for (int i = front; i <= back; i++) {
            newStr[i - front] = chars[i];
        }

        return new MyString(newStr);
    }

    // Returns a new MyString where the only chars changed are chars from A-Z,
    // which are changed to a-z
    // O(n)
    public MyString toLowerCase() {
        char[] newStr = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                newStr[i] = (char) (chars[i] + 32);
            } else {
                newStr[i] = chars[i];
            }
        }
        return new MyString(newStr);
    }

    // Returns a new MyString where the only chars changed are chars from a-z,
    // which are changed to A-Z
    // O(n)
    public MyString toUpperCase() {
        char[] newStr = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                newStr[i] = (char) (chars[i] - 32);
            } else {
                newStr[i] = chars[i];
            }
        }
        return new MyString(newStr);
    }

    // Returns a new MyString that is this MyString concatenated together
    // with the other MyString
    // O(n)
    public MyString add(MyString other) {
        char[] newStr = new char[chars.length + other.length()];
        for (int i = 0; i < chars.length; i++) {
            newStr[i] = chars[i];
        }
        for (int i = 0; i < other.length(); i++) {
            newStr[i + chars.length] = other.charAt(i);
        }
        return new MyString(newStr);
    }

    // O(n)
    public MyString add(char c) {
        char[] newStr = new char[chars.length + 1];
        for (int i = 0; i < chars.length; i++) {
            newStr[i] = chars[i];
        }
        newStr[chars.length] = c;
        return new MyString(newStr);
    }

    // If the MyString represents an integer, positive or negative,
    // returns the int that it represents
    // If the MyString is NOT an integer, throws a NumberFormatException
    // O(n)
    public int convertToInt() {
        int num = 0;
        int sign = chars[0] == '-' ? 1 : 0;
        for (int i = sign; i < chars.length; i++) {
            if (chars[i] > '0' && chars[i] < '9') {
                num = num * 10 + (chars[i] - '0');
            } else {
                throw new NumberFormatException();
            }
        }
        return sign == 1 ? -num : num;
    }

    // O(n)
    public boolean equals(MyString other) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // O(n)
    public int compareTo(MyString other) {
        int length = chars.length < other.length() ? chars.length : other.length();
        for (int i = 0; i < length; i++) {
            if (chars[i] != other.charAt(i)) {
                return chars[i] - other.charAt(i);
            }
        }
        if (chars.length != other.length()) {
            return chars.length - other.length();
        }
        return 0;
    }

    // capitalize capitalizes the first letter of this MyString
    // If the first letter of this MyString is a lower-case
    // letter a-z, this returns a new MyString that is the same
    // EXCEPT that the first letter is now capitalized.
    // O(n)
    public MyString capitalize() {
        MyString str = new MyString(chars);
        str.trim();
        char[] letter = new char[1];
        letter[0] = str.charAt(0);
        MyString capital = new MyString(letter);
        capital = capital.toUpperCase();
        return capital.add(str.substring(1));
    }

    // isSentence checks whether or not this MyString is a valid sentence
    //
    // A "sentence" is defined as a MyString with the format:
    // 1) It may begin with any number of spaces (including 0 spaces)
    // 2) It ends with a period ('.') or question mark ('?')
    // 3) It has any number of "words" in between, each separated
    // from each other by a single space. The "words" do not need
    // to be actual words, and can even include punctuation.
    // 4) The first word in the sentence is capitalized.
    // Returns true if this MyString is a sentence and false otherwise
    //
    // Precondition: No input will have more than one ' ' in a row
    // O(n^2)
    public boolean isSentence() {
        MyString sentence = new MyString(chars).trim();
        char[] space = { ' ' };
        MyString empty = new MyString(space);
        if (sentence.charAt(sentence.length() - 1) != '.' && sentence.charAt(sentence.length() - 1) != '?') {
            return false;
        }
        if (sentence.charAt(0) < 'A' || sentence.charAt(0) > 'Z') {
            return false;
        }
        MyString[] temp = sentence.split(empty);
        for (int k = 0; k < temp.length; k++) {
            if (temp[k].equals(empty)) {
                return false;
            }
        }
        return true;
    }

    // getWords returns an array of MyStrings
    //
    // If this MyString is a valid sentence, getWords() will return the "words"
    // in this MyString, all lower-case
    //
    // For example, given the MyString contents: "Hey, where's the 'any' key?"
    // then this should return an array with the MyStrings:
    // ["hey,", "where's", "the", "'any'", "key"]
    //
    // If this MyString is NOT a valid sentence, this will return an empty MyString
    // array
    //
    // Precondition: The only punctuation to remove at the end of a sentence are '.'
    // and '?'
    // O(n^2)
    public MyString[] getWords() {
        if (!isSentence()) {
            return new MyString[0];
        }
        MyString sentence = new MyString(chars).trim();
        char[] space = { ' ' };
        MyString divider = new MyString(space);
        MyString[] temp = sentence.split(divider);
        temp[temp.length - 1] = temp[temp.length - 1].substring(0, temp[temp.length - 1].length() - 1);
        for (int k = 0; k < temp.length; k++) {
            temp[k] = temp[k].toLowerCase();
        }
        return temp;
    }

    // reverseSentence reverses this MyString if it's a valid sentence
    //
    // If this is a sentence, this method should return a new MyString with
    // the following changes:
    // 1) The words are in reverse order
    // 2) The first word is capitalized, and the original first word is no longer
    // capitalized
    // 3) The punctuation that ended the sentence still ends the new sentence
    // 4) Any leading and trailing spaces are gone
    // For example: if this MyString is the sentence: " Where's the 'any' key?"
    // then reverseSentence() should return the MyString: "Key 'any' the where's?"
    // O(n^2)
    public MyString reverseSentence() {
        if (!isSentence()) {
            return new MyString();
        }

        char punctuation = chars[chars.length - 1];
        MyString sentence = new MyString(chars).trim();
        char[] space = { ' ' };
        MyString[] temp = sentence.getWords();
        MyString reverse = new MyString();
        for (int i = temp.length - 1; i >= 0; i--) {
            reverse = reverse.add(temp[i]);
            reverse = reverse.add(new MyString(space));
        }
        reverse = reverse.capitalize();
        reverse = reverse.trim();
        reverse = reverse.add(punctuation);

        return reverse;

    }
}

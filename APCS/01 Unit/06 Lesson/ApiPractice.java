import java.util.List;

public class ApiPractice {
 /**
  * Finds the hypotenuse of a right triangle given sides a and b.
  * @param a Length of side a.
  * @param b Length of side b.
  * @return Length of hypotenuse.
  */
 public static double hypotenuse(double a, double b) {
  /* Add code here. Fix placeholder return statement. */
  return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
 }
 
 /**
  * Returns the greater of two values. If the values are exactly the same,
  * it returns one of them.
  * @param a First value.
  * @param b Second value.
  * @return Largest value.
  */
 public static double max(double a, double b) {
  /* Add code here. Fix placeholder return statement. */
    if(a > b)
    {
        return a;
    }
    else
    {
        return b;
    }
}
 
 /**
  * Returns the smaller of two values. If the values are exactly the same,
  * it returns one of them.
  * @param a First value.
  * @param b Second value.
  * @return Smallest value.
  */
 public static double min(double a, double b) {
  /* Add code here. Fix placeholder return statement. */
    if(a < b)
    {
        return a;
    }
    else
    {
        return b;
    }
}

 /**
  * Returns the lexicographically greater of two strings. If the values are
  * exactly the same, it returns one of them.
  * @param a First string.
  * @param b Second string.
  * @return Lexicographically greatest string.
  */
 public static String max(String a, String b) {
  /* Add code here. Fix placeholder return statement. */
    if(a.compareTo(b) > 0)
    {
        return a;
    }
    else if(a.compareTo(b) < 0)
    {
        return b;
    }
    else
    {
        return a;
    }
}
 
 /**
  * Returns the lexicographically lesser of two strings. If the values are
  * exactly the same, it returns one of them.
  * @param a First string.
  * @param b Second string.
  * @return Lexicographically lesser string.
  */
 public static String min(String a, String b) {
  /* Add code here. Fix placeholder return statement. */
    if(a.compareTo(b) > 0)
    {
        return b;
    }
    else if(a.compareTo(b) < 0)
    {
        return a;
    }
    else
    {
        return a;
    }
}
 
 /**
  * Compares two strings to see if they contain the same text.
  * @param a First string.
  * @param b Second string.
  * @return <code>true</code> if the strings contain the same text,
  * <code>false</code> otherwise.
  */
 public static boolean isSameText(String a, String b) {
  /* Add code here. Fix placeholder return statement. */
    if(a.equals(b))
    {
        return true;
    }
    else
    {
        return false;
    }
}
 
 /**
  * Returns the longest string (the string with the greatest number of
  * characters) out of three strings. If two or more strings have the same
  * number of characters, it returns the first one.
  * @param a First string.
  * @param b Second string.
  * @param c Third string.
  * @return String with the fewest characters.
  */
 public static String getLongestString(String a, String b, String c) {
  /* Add code here. Fix placeholder return statement. */
    String[] strings = {a, b, c};
    int longest = Integer.MIN_VALUE;
    String out = new String("");
    
    for(String s: strings)
    {
        if(s.length() > longest)
        {
            longest = s.length();
            out = s;
        }
    }
    
    return out;
}
 
 /**
  * Returns the shortest string (the string with the lowest number of 
  * characters) from a list of strings. If two or more strings have the
  * same number of characters, it returns the first one.
  * 
  * If the incoming list is <code>null</code> or contains zero strings, 
  * this method returns <code>null</code>.
  * 
  * @param list List of incoming strings.
  * @return String with the fewest characters.
  */
 public static String getShortestString(List<String> list) {
  /* Add code here. Fix placeholder return statement. */
    int shortest = Integer.MAX_VALUE;
    String out = new String("");
    if(list.isEmpty() == true)
    {
        return null;
    }
    
    for(String s: list)
    {
        if(s.length() < shortest)
        {
            shortest = s.length();
            out = s;
        }
    }
    
    return out;
}
 
 /**
  * Returns a substring of the incoming string that contains all of the 
  * characters leading up to, but not including, the comma found
  * in the string.
  * @param s A string with a comma somewhere inside of it.
  * @return The substring leading up to the comma.
  */
 public static String getStringBeforeComma(String s) {
  /* Add code here. Fix placeholder return statement. */
  return s.substring(0, s.indexOf(","));
 }
 
 /**
  * Returns a substring of the incoming string that contains all of the 
  * characters after the comma found inside the string.
  * @param s A string with a comma somewhere inside of it.
  * @return The substring after the comma.
  */
 public static String getStringAfterComma(String s) {
  /* Add code here. Fix placeholder return statement. */
  return s.substring(s.indexOf(",")+1, s.length());
 }
}

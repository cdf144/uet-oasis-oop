package DSA;

import java.util.ArrayList;

public class MathExpression {
    static ArrayList<String> parseEx(String exp) {
        ArrayList<String> lstEle = new ArrayList<String>();
        int num = 0; boolean hasNum = false;
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ' ') continue;
            else if (ch == '+' || ch == '-'
                    || ch == '(' || ch == ')' ) {
                if (hasNum) lstEle.add(Integer.toString(num));
                lstEle.add(String.valueOf(ch));
                hasNum = false;
                num = 0;
            } else {
                hasNum = true;
                num = 10*num + Character.getNumericValue(ch);
            }
        }
        if (hasNum) lstEle.add(Integer.toString(num));
        return lstEle;
    }

  public static int calculate(String exp) {
      ArrayList<String> lstEle = parseEx(exp);
      return calculate(lstEle, 0, lstEle.size()-1);
  }

  public static int findOpenIndex_slow(ArrayList<String> lstEle, int lo, int hi) {
    int cnt = 1;
    for (int i = hi; i >= lo; i--) {
      if (")".equals(lstEle.get(i))) {
        cnt++;
      } else if ("(".equals(lstEle.get(i))) {
        cnt--;
        if (cnt == 0) return i;
      }
    }
    return -1;
  }

  public static int calculate(ArrayList<String> lstEle, int lo, int hi) {
    if (lo > hi) return 0;
    if (lo == hi) return Integer.parseInt(lstEle.get(lo));

    if (")".equals(lstEle.get(hi))) {
      int openIdx = findOpenIndex_slow(lstEle, lo, hi-1);
      //int openIdx = findOpenIndex(lstEle, hi);
      if (openIdx == -1) return 0;
      int lastValue = calculate(lstEle, openIdx+1, hi-1);
      if (openIdx > lo) {
        if ("+".equals(lstEle.get(openIdx-1))) {
          return calculate(lstEle, lo, openIdx-2) + lastValue;
        } else { // "-"
          return calculate(lstEle, lo, openIdx-2) - lastValue;
        }
      } else {
        return lastValue;
      }
    } else {
      int lastValue = Integer.parseInt(lstEle.get(hi));
      if ("+".equals(lstEle.get(hi-1))) {
        return calculate(lstEle, lo, hi-2) + lastValue;
      } else { // "-"
        return calculate(lstEle, lo, hi-2) - lastValue;
      }
    }
  }

  public static void main(String [] args) {
    System.out.println("Math Expression");
    ArrayList<String> lstExp = new ArrayList<String>();
    lstExp.add("100");
    lstExp.add("-100");
    lstExp.add("+100");
    lstExp.add("(100)");
    lstExp.add("1+10");
    lstExp.add("-(1-10)");
    lstExp.add("1-10+2");
    lstExp.add("(10+2)-(5-6) + 300");
    lstExp.add("-10-(2-(5-6)) + 300");
    lstExp.add("((300-10)-(2-(5-6)))");
    lstExp.add("(((10+2)-(5-6)) + 300)");
    for (String exp: lstExp) {
      System.out.println(exp + " = " + calculate(exp));
    }
  }
}



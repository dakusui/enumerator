package com.github.dakusui.combinatoradix;

import java.util.ArrayList;
import java.util.List;

public enum Utils {
  ;

  public static long nPk(long n, long k) {
    long ret = 1;
    for (long i = n; i > n - k; i--) {
      if (i > Long.MAX_VALUE / ret) {
        throw new IllegalArgumentException(String.format("Overflow. Too big numbers are used %sP%s: %d * %d", n, k, ret, i));
      }
      ret *= i;
    }
    return ret;
  }

  public static long nHk(int n, int k) {
    return nCk(n + k - 1, k);
  }

  public static long nCk(long n, long k) {
    long ret = 1;
    long j = 1;
    for (long i = n; i > n - k; i--) {
      if (i > Long.MAX_VALUE / ret) {
        throw new IllegalArgumentException(String.format("Overflow. Too big numbers are used %sC%s: %d * %d", n, k, ret, i));
      }
      ret *= i;
      ret /= j;
      j++;
    }
    return ret;
  }

  public static void checkArgument(boolean b, String message, Object... args) {
    if (!b)
      throw new IllegalArgumentException(String.format(message, args));
  }

  static int[] chop(int[] in) {
    int[] arr = new int[in.length - 1];
    System.arraycopy(in, 0, arr, 0, arr.length);
    return arr;
  }

  static int sumAll(int[] values) {
    int ret = 0;
    for (int each : values)
      ret += each;
    return ret;
  }

  static <T> List<T> arrayList(List<T> items) {
    if (items instanceof ArrayList) {
      return items;
    }
    return new ArrayList<T>(items);
  }
}

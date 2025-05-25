package me.nidalone.uniplatform.utils;

import java.util.Locale;

public class SlugUtil {
  public static String toSlug(String input) {
    return input.strip().replaceAll(" ", "-").toLowerCase(Locale.ENGLISH);
  }
}

// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.engine.lexicon;

import java.util.regex.Pattern;

public class Literal {
  private static final String BOOLEAN_TRUE = "true";
  private static final String BOOLEAN_FALSE = "false";
  private static final String NULL_VALUE = "null";

  private static final Pattern INTEGER_PATTERN = Pattern.compile("^\\-?[0-9]+$");
  private static final Pattern LONG_PATTERN = Pattern.compile("^\\-?[0-9]+[Ll]?$");
  private static final Pattern FLOAT_PATTERN =
      Pattern.compile("^\\-?[0-9]+([fF]|(\\.(([0-9]+[fF])|[fF])))?$");
  private static final Pattern DOUBLE_PATTERN_ONE =
      Pattern.compile("^\\-?[0-9]+(\\.[0-9]+)?(\\.?[eE]\\-?[0-9]+)$");
  private static final Pattern DOUBLE_PATTERN_TWO =
      Pattern.compile("^\\-?\\d*\\.\\d+$|^\\d+\\.\\d*$");

  public static boolean isBooleanLiteral(String str) {
    return str.equals(BOOLEAN_TRUE) || str.equals(BOOLEAN_FALSE);
  }

  public static boolean isIntegerLiteral(String str) {
    return INTEGER_PATTERN.matcher(str).matches();
  }

  public static boolean isLongLiteral(String str) {
    return LONG_PATTERN.matcher(str).matches();
  }

  public static boolean isFloatLiteral(String str) {
    return INTEGER_PATTERN.matcher(str).matches() || FLOAT_PATTERN.matcher(str).matches();
  }

  public static boolean isDoubleLiteral(String str) {
    return isFloatLiteral(str)
        || DOUBLE_PATTERN_ONE.matcher(str).matches()
        || DOUBLE_PATTERN_TWO.matcher(str).matches();
  }

  public static boolean isNullLiteral(String str) {
    return str.equals(NULL_VALUE);
  }

  public static boolean isLiteral(String str) {
    return isBooleanLiteral(str)
        || isIntegerLiteral(str)
        || isLongLiteral(str)
        || isFloatLiteral(str)
        || isDoubleLiteral(str)
        || isNullLiteral(str);
  }
}

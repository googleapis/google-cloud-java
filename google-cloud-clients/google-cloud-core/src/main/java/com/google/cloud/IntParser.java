/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud;

import com.google.common.base.Preconditions;

/**
 * Util class for fast parsing of integer values. This is used by {@link Date#parseDate(String)} and
 * {@link Timestamp#parseTimestamp(String)}. These parse methods are used internally by Google
 * client libraries to parse text values returned by services, and these parse methods should be as
 * efficient as possible.
 */
class IntParser {

  private static final int[] POWERS_OF_10 =
      {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

  /** Parses an int from the given input between the specified begin and end. */
  static int parseInt(String input, int begin, int end) {
    Preconditions.checkNotNull(input);
    Preconditions.checkArgument(end - begin <= 10, "Max input length is 10");
    Preconditions.checkArgument(end >= begin, "End must be greater or equal to begin");
    Preconditions.checkArgument(begin >= 0, "Begin must be >= 0");
    Preconditions.checkArgument(end <= input.length(), "End must be <= input.length()");
    int res = 0;
    for (int index = begin; index < end; index++) {
      res += parseDigit(input.charAt(index), input) * POWERS_OF_10[end - index - 1];
    }
    return res;
  }

  private static int parseDigit(char c, String input) {
    if (c == '0') {
      return 0;
    } else if (c == '1') {
      return 1;
    } else if (c == '2') {
      return 2;
    } else if (c == '3') {
      return 3;
    } else if (c == '4') {
      return 4;
    } else if (c == '5') {
      return 5;
    } else if (c == '6') {
      return 6;
    } else if (c == '7') {
      return 7;
    } else if (c == '8') {
      return 8;
    } else if (c == '9') {
      return 9;
    } else {
      throw new NumberFormatException("Not a digit: " + c);
    }
  }

}

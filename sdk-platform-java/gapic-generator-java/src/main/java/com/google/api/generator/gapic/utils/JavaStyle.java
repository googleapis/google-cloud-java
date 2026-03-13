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

package com.google.api.generator.gapic.utils;

import com.google.api.generator.engine.lexicon.Keyword;
import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;
import java.util.stream.IntStream;

public class JavaStyle {
  private static final String UNDERSCORE = "_";

  public static String toLowerCamelCase(String s) {
    if (Strings.isNullOrEmpty(s)) {
      return s;
    }

    s = s.replace('-', '_');

    if (s.indexOf(UNDERSCORE) >= 0) {
      s = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, s);
    }

    String name =
        capitalizeLettersAfterDigits(
            String.format("%s%s", s.substring(0, 1).toLowerCase(), s.substring(1)));

    // Some APIs use legit java keywords as method names. Both protobuf and gGRPC add an underscore
    // in generated stubs to resolve name conflict, so we need to do the same.
    return Keyword.escapeKeyword(name);
  }

  public static String toUpperCamelCase(String s) {
    if (Strings.isNullOrEmpty(s)) {
      return s;
    }

    s = s.replace('-', '_');

    if (s.indexOf(UNDERSCORE) >= 0) {
      s = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, s);
    }
    return capitalizeLettersAfterDigits(
        String.format("%s%s", s.substring(0, 1).toUpperCase(), s.substring(1)));
  }

  public static String toUpperSnakeCase(String s) {
    String result = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, toUpperCamelCase(s));
    return result;
  }

  private static String capitalizeLettersAfterDigits(String s) {
    return IntStream.range(0, s.length())
        .collect(
            StringBuilder::new,
            (sb, i) ->
                sb.append(
                    i > 0 && Character.isDigit(s.charAt(i - 1))
                        ? Character.toUpperCase(s.charAt(i))
                        : s.charAt(i)),
            StringBuilder::append)
        .toString();
  }
}

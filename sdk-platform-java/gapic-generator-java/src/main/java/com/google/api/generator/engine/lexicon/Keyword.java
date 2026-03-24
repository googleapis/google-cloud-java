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

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

public class Keyword {
  // This is a valid field for all objects, so handle particular keyword differently.
  private static final String CLASS_KEYWORD = "class";

  private static final ImmutableList<String> KEYWORDS =
      ImmutableList.of(
          "abstract",
          "continue",
          "for",
          "new",
          "switch",
          "assert",
          "default",
          "if",
          "package",
          "synchronized",
          "boolean",
          "do",
          "goto",
          "private",
          "this",
          "break",
          "double",
          "implements",
          "protected",
          "throw",
          "byte",
          "else",
          "import",
          "public",
          "throws",
          "case",
          "enum",
          "instanceof",
          "return",
          "transient",
          "catch",
          "extends",
          "int",
          "short",
          "try",
          "char",
          "final",
          "interface",
          "static",
          "void",
          "finally",
          "long",
          "strictfp",
          "volatile",
          "const",
          "float",
          "native",
          "super",
          "while");
  private static final String ESCAPE_CHAR = "_";

  public static boolean isKeyword(String s) {
    return s.equals(CLASS_KEYWORD) || KEYWORDS.contains(s);
  }

  public static String unescapeKeyword(String str) {
    if (Strings.isNullOrEmpty(str)) {
      return str;
    }
    if (!str.endsWith(ESCAPE_CHAR)) {
      return str;
    }
    String strWithoutEscapeChar = str.substring(0, str.lastIndexOf(ESCAPE_CHAR));
    return isKeyword(strWithoutEscapeChar) ? strWithoutEscapeChar : str;
  }

  public static String escapeKeyword(String str) {
    return Keyword.isKeyword(str) ? str + ESCAPE_CHAR : str;
  }

  public static boolean isInvalidFieldName(String s) {
    return KEYWORDS.contains(s);
  }
}

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

package com.google.api.generator.gapic.composer.samplecode;

import com.google.common.annotations.VisibleForTesting;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SampleBodyJavaFormatter {
  private SampleBodyJavaFormatter() {}

  private static final Formatter FORMATTER = new Formatter();
  private static final String FAKE_CLASS_TITLE = "public class FakeClass { void fakeMethod() {\n";
  private static final String FAKE_CLASS_CLOSE = "}}";

  /**
   * This method is used to format sample code string.
   *
   * @param sampleCode A string is composed by statements.
   * @return String Formatted sample code string based on google java style.
   */
  public static String format(String sampleCode) {
    final StringBuffer buffer = new StringBuffer();
    // Wrap the sample code inside a class for composing a valid Java source code.
    // Because we utilized google-java-format to reformat the codes.
    buffer.append(FAKE_CLASS_TITLE);
    buffer.append(sampleCode);
    buffer.append(FAKE_CLASS_CLOSE);

    String formattedString = null;
    try {
      formattedString = FORMATTER.formatSource(buffer.toString());
    } catch (FormatterException e) {
      throw new FormatException(
          String.format("The sample code should be string where is composed by statements; %s", e));
    }
    // Extract formatted sample code by
    // 1. Removing the first and last two lines.
    // 2. Delete the first 4 space for each line.
    // 3. Trim the last new empty line.
    Pattern pattern = Pattern.compile("(^([^\n]*\n){2})|(([^\n]*\n){2}$)");
    Matcher matcher = pattern.matcher(formattedString);
    formattedString = matcher.replaceAll("");

    pattern = Pattern.compile("(?m)^ {4}");
    matcher = pattern.matcher(formattedString);
    formattedString = matcher.replaceAll("");

    return formattedString.trim();
  }

  @VisibleForTesting
  protected static class FormatException extends RuntimeException {
    public FormatException(String errorMessage) {
      super(errorMessage);
    }
  }
}

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

package com.google.api.generator.engine.writer;

import com.google.common.annotations.VisibleForTesting;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

public final class JavaFormatter {

  private static final Formatter FORMATTER = new Formatter();

  private JavaFormatter() {}

  public static String format(String sourceString) {
    try {
      return FORMATTER.formatSource(sourceString);
    } catch (FormatterException e) {
      throw new FormatException(String.format("The input resource can not be parsed %s", e));
    }
  }

  @VisibleForTesting
  protected static class FormatException extends RuntimeException {
    public FormatException(String errorMessage) {
      super(errorMessage);
    }
  }
}

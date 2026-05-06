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

package com.google.api.generator.engine.escaper;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

public class MetacharEscaper extends Escaper {
  private static final MetacharEscaper SINGLETON = new MetacharEscaper();

  // Handle escape characters (https://docs.oracle.com/javase/tutorial/java/data/characters.html)
  // for the comments here, else JavaFormmater cannot properly format the string comment.
  // `"` and `'` are overlooked because the comments will not be surrounded by `"` or `'`.
  private static final Escaper charEscaper =
      Escapers.builder()
          .addEscape('\t', "\\t")
          .addEscape('\b', "\\b")
          .addEscape('\r', "\\r")
          .addEscape('\f', "\\f")
          .addEscape('\\', "\\\\")
          .build();

  private MetacharEscaper() {}

  @Override
  public String escape(String sourceString) {
    return charEscaper.escape(sourceString);
  }

  public static String process(String source) {
    return SINGLETON.escape(source);
  }
}

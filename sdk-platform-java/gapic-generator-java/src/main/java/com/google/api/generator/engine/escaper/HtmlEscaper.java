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

public class HtmlEscaper extends Escaper {
  private static final HtmlEscaper SINGLETON = new HtmlEscaper();

  // Based on the observation of the generated java files, we escape the following
  // five characters by html escaper. We do not directly use guava HtmlEscapers here because
  // it only escapes`<>&\"'` as specified by HTML 4.01.
  private static final Escaper charEscaper =
      Escapers.builder()
          .addEscape('<', "&lt;")
          .addEscape('>', "&gt;")
          .addEscape('&', "&amp;")
          .addEscape('*', "&#42;")
          .addEscape('@', "{@literal @}")
          .build();

  private HtmlEscaper() {}

  @Override
  public String escape(String sourceString) {
    return charEscaper.escape(sourceString);
  }

  public static String process(String source) {
    return SINGLETON.escape(source);
  }
}

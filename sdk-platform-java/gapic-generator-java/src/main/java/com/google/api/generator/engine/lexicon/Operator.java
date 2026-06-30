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

// TODO(miraleung): Add logical representations for each operator so we can use them in expression
// parsing.
public class Operator {
  private static final Pattern OPERATOR_PATTERN =
      Pattern.compile("[\\+\\-\\*\\/%\\=\\!\\&\\|<>\\?\\:\\^]");

  public static boolean containsOperator(String str) {
    return OPERATOR_PATTERN.matcher(str).find();
  }
}

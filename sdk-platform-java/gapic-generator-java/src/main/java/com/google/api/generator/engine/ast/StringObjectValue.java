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

package com.google.api.generator.engine.ast;

import com.google.auto.value.AutoValue;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

@AutoValue
public abstract class StringObjectValue implements ObjectValue {
  @Override
  public abstract String value();

  @Override
  public TypeNode type() {
    return TypeNode.STRING;
  }

  public static Builder builder() {
    return new AutoValue_StringObjectValue.Builder();
  }

  public static StringObjectValue withValue(String value) {
    return builder().setValue(value).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setValue(String value);

    // Private accessors.
    abstract String value();

    public abstract StringObjectValue autoBuild();

    public StringObjectValue build() {
      // `\"` is added to the escaped string value for interpreting it correctly in file.
      String value = String.format("\"%s\"", StringValueEscaper.escaper.escape(value()));
      setValue(value);
      return autoBuild();
    }
  }

  private static class StringValueEscaper extends Escaper {
    private static final Escaper escaper =
        Escapers.builder()
            .addEscape('\t', "\\t")
            .addEscape('\b', "\\b")
            .addEscape('\n', "\\n")
            .addEscape('\r', "\\r")
            .addEscape('\f', "\\f")
            .addEscape('"', "\\\"")
            .addEscape('\\', "\\\\")
            .build();

    private StringValueEscaper() {}

    @Override
    public String escape(String sourceString) {
      return escaper.escape(sourceString);
    }
  }
}

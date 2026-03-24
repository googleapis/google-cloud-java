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

import com.google.api.generator.engine.escaper.MetacharEscaper;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LineComment implements Comment {
  @Override
  public abstract String comment();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_LineComment.Builder();
  }

  public static LineComment withComment(String comment) {
    return LineComment.builder().setComment(comment).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setComment(String comment);

    // Private accessor.
    abstract String comment();

    public abstract LineComment autoBuild();

    public LineComment build() {
      setComment(MetacharEscaper.process(comment()));
      return autoBuild();
    }
  }
}

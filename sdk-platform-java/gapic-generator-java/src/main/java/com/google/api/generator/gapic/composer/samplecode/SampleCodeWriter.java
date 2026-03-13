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

import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.Sample;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.List;

public final class SampleCodeWriter {

  public static String writeInlineSample(List<Statement> statements) {
    return write(SampleComposer.composeInlineSample(statements));
  }

  public static String writeExecutableSample(Sample sample, String packkage) {
    return write(SampleComposer.composeExecutableSample(sample, packkage));
  }

  @VisibleForTesting
  public static String write(Statement... statement) {
    return write(Arrays.asList(statement));
  }

  @VisibleForTesting
  public static String write(List<Statement> statements) {
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    for (Statement statement : statements) {
      statement.accept(visitor);
    }
    String formattedSampleCode = SampleBodyJavaFormatter.format(visitor.write());
    // Escape character "@" in the markdown code block <pre>{@code...} tags.
    return formattedSampleCode.replaceAll("@", "{@literal @}");
  }

  @VisibleForTesting
  public static String write(ClassDefinition classDefinition) {
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    classDefinition.accept(visitor);
    return visitor.write();
  }

  @VisibleForTesting
  public static String write(Expr expr) {
    return write(ExprStatement.withExpr(expr));
  }
}

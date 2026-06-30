// Copyright 2026 Google LLC
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

package com.google.api.generator.gapic.composer;

import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.LineComment;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import java.util.Arrays;

public class LibraryVersionClassComposer {
  private static final LibraryVersionClassComposer INSTANCE = new LibraryVersionClassComposer();

  private LibraryVersionClassComposer() {}

  public static LibraryVersionClassComposer instance() {
    return INSTANCE;
  }

  public GapicClass generate(GapicContext context, Service service) {
    String packageName = service.pakkage() + ".stub";
    String className = "Version";

    String artifact = context.artifact();
    String artifactId = artifact;
    if (artifact != null && artifact.contains(":")) {
      artifactId = artifact.split(":")[1];
    }

    VariableExpr versionVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.STRING).setName("VERSION").build());
    AssignmentExpr versionAssignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(
                versionVarExpr.toBuilder()
                    .setIsDecl(true)
                    .setScope(ScopeNode.LOCAL)
                    .setIsStatic(true)
                    .setIsFinal(true)
                    .build())
            .setValueExpr(ValueExpr.withValue(StringObjectValue.withValue("0.0.0-SNAPSHOT")))
            .build();

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(packageName)
            .setAnnotations(
                Arrays.asList(
                    AnnotationNode.builder()
                        .setType(
                            TypeNode.withReference(
                                ConcreteReference.withClazz(com.google.api.core.InternalApi.class)))
                        .setDescription("For internal use only")
                        .build()))
            .setScope(ScopeNode.LOCAL)
            .setIsFinal(true)
            .setName(className)
            .setStatements(
                Arrays.asList(
                    CommentStatement.withComment(
                        LineComment.withComment(
                            String.format("{x-version-update-start:%s:current}", artifactId))),
                    ExprStatement.withExpr(versionAssignmentExpr),
                    CommentStatement.withComment(
                        LineComment.withComment("{x-version-update-end}"))))
            .build();

    return GapicClass.create(GapicClass.Kind.MAIN, classDef);
  }
}

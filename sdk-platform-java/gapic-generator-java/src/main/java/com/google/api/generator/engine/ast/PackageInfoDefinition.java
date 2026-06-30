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
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class PackageInfoDefinition implements AstNode {
  public abstract String pakkage();

  public abstract ImmutableList<CommentStatement> fileHeader();

  public abstract ImmutableList<CommentStatement> headerCommentStatements();

  public abstract ImmutableList<AnnotationNode> annotations();

  public abstract Builder toBuilder();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_PackageInfoDefinition.Builder()
        .setFileHeader(Collections.emptyList())
        .setHeaderCommentStatements(Collections.emptyList())
        .setAnnotations(Collections.emptyList());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setPakkage(String pakkage);

    public Builder setFileHeader(CommentStatement... headerComments) {
      return setFileHeader(Arrays.asList(headerComments));
    }

    public abstract Builder setFileHeader(List<CommentStatement> fileHeader);

    public Builder setHeaderCommentStatements(CommentStatement... comments) {
      return setHeaderCommentStatements(Arrays.asList(comments));
    }

    public abstract Builder setHeaderCommentStatements(
        List<CommentStatement> headerCommentStatements);

    public Builder setAnnotations(AnnotationNode... annotations) {
      return setAnnotations(Arrays.asList(annotations));
    }

    public abstract Builder setAnnotations(List<AnnotationNode> annotations);

    abstract PackageInfoDefinition autoBuild();

    public PackageInfoDefinition build() {
      PackageInfoDefinition packageInfo = autoBuild();
      String contextInfo = String.format("package info for %s", packageInfo.pakkage());
      NodeValidator.checkNoNullElements(packageInfo.fileHeader(), "file header", contextInfo);
      NodeValidator.checkNoNullElements(
          packageInfo.headerCommentStatements(), "header comments", contextInfo);
      NodeValidator.checkNoNullElements(packageInfo.annotations(), "annotations", contextInfo);
      return packageInfo;
    }
  }
}

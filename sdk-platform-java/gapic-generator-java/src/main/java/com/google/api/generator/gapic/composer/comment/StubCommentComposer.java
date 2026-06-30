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

package com.google.api.generator.gapic.composer.comment;

import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.JavaDocComment;
import java.util.Arrays;
import java.util.List;

public class StubCommentComposer {
  private static final String STUB_CLASS_HEADER_SUMMARY_PATTERN =
      "Base stub class for the %s service API.";
  private static final String TRANSPORT_CALLABLE_FACTORY_CLASS_HEADER_SUMMARY_PATTERN =
      "%s callable factory implementation for the %s service API.";
  private static final String TRANSPORT_STUB_CLASS_HEADER_SUMMARY_PATTERN =
      "%s stub implementation for the %s service API.";

  private static final String ADVANCED_USAGE_DESCRIPTION = "This class is for advanced usage.";
  private static final String ADVANCED_USAGE_API_REFLECTION_DESCRIPTION =
      "This class is for advanced usage and reflects the underlying API directly.";

  private final String transportPrefix;

  public StubCommentComposer(String transportPrefix) {
    this.transportPrefix = transportPrefix;
  }

  public List<CommentStatement> createTransportServiceStubClassHeaderComments(
      String serviceName, boolean isDeprecated) {
    JavaDocComment.Builder javaDocBuilder = JavaDocComment.builder();
    if (isDeprecated) {
      javaDocBuilder = javaDocBuilder.setDeprecated(CommentComposer.DEPRECATED_CLASS_STRING);
    }
    return Arrays.asList(
        CommentComposer.AUTO_GENERATED_CLASS_COMMENT,
        CommentStatement.withComment(
            javaDocBuilder
                .addComment(
                    String.format(
                        TRANSPORT_STUB_CLASS_HEADER_SUMMARY_PATTERN, transportPrefix, serviceName))
                .addParagraph(ADVANCED_USAGE_API_REFLECTION_DESCRIPTION)
                .build()));
  }

  public List<CommentStatement> createTransportServiceCallableFactoryClassHeaderComments(
      String serviceName, boolean isDeprecated) {
    JavaDocComment.Builder javaDocBuilder = JavaDocComment.builder();
    if (isDeprecated) {
      javaDocBuilder = javaDocBuilder.setDeprecated(CommentComposer.DEPRECATED_CLASS_STRING);
    }
    return Arrays.asList(
        CommentComposer.AUTO_GENERATED_CLASS_COMMENT,
        CommentStatement.withComment(
            javaDocBuilder
                .addComment(
                    String.format(
                        TRANSPORT_CALLABLE_FACTORY_CLASS_HEADER_SUMMARY_PATTERN,
                        transportPrefix,
                        serviceName))
                .addParagraph(ADVANCED_USAGE_DESCRIPTION)
                .build()));
  }

  public static List<CommentStatement> createServiceStubClassHeaderComments(
      String serviceName, boolean isDeprecated) {
    JavaDocComment.Builder javaDocBuilder = JavaDocComment.builder();
    if (isDeprecated) {
      javaDocBuilder = javaDocBuilder.setDeprecated(CommentComposer.DEPRECATED_CLASS_STRING);
    }

    return Arrays.asList(
        CommentComposer.AUTO_GENERATED_CLASS_COMMENT,
        CommentStatement.withComment(
            javaDocBuilder
                .addComment(String.format(STUB_CLASS_HEADER_SUMMARY_PATTERN, serviceName))
                .addParagraph(ADVANCED_USAGE_API_REFLECTION_DESCRIPTION)
                .build()));
  }
}

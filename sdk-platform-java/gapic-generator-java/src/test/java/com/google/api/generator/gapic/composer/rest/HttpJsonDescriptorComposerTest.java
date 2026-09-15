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

package com.google.api.generator.gapic.composer.rest;

import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.HttpBindings;
import com.google.api.generator.gapic.model.HttpBindings.HttpBinding;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.protoloader.RestTestProtoLoader;
import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class HttpJsonDescriptorComposerTest {

  private static final String RESUMABLE_UPLOAD_PREFIX = "/resumable/upload";
  private static final String TEST_PATH = "/v1/foo";

  @Test
  void prependPathPrefix_nullPrefix_returnsOriginalPath() {
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix(TEST_PATH, null)).isEqualTo(TEST_PATH);
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix("v1/foo", null)).isEqualTo("v1/foo");
  }

  @Test
  void prependPathPrefix_barePrefix_normalizesSlashes() {
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix("v1/foo", "resumable/upload"))
        .isEqualTo("/resumable/upload/v1/foo");
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix(TEST_PATH, "resumable/upload"))
        .isEqualTo("/resumable/upload/v1/foo");
  }

  @Test
  void prependPathPrefix_slashWrappedPrefix_normalizesSlashes() {
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix("v1/foo", "/resumable/upload/"))
        .isEqualTo("/resumable/upload/v1/foo");
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix(TEST_PATH, "/resumable/upload/"))
        .isEqualTo("/resumable/upload/v1/foo");
  }

  @Test
  void prependPathPrefix_leadingSlashOnlyPrefix_normalizesSlashes() {
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix("v1/foo", RESUMABLE_UPLOAD_PREFIX))
        .isEqualTo("/resumable/upload/v1/foo");
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix(TEST_PATH, RESUMABLE_UPLOAD_PREFIX))
        .isEqualTo("/resumable/upload/v1/foo");
  }

  @Test
  void prependPathPrefix_trailingSlashOnlyPrefix_normalizesSlashes() {
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix("v1/foo", "resumable/upload/"))
        .isEqualTo("/resumable/upload/v1/foo");
    assertThat(HttpJsonDescriptorComposer.prependPathPrefix(TEST_PATH, "resumable/upload/"))
        .isEqualTo("/resumable/upload/v1/foo");
  }

  @Test
  void getRequestFormatterExpr_withPathPrefix_prependsPrefix() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);
    Method uploadMethod =
        service.methods().stream().filter(Method::isResumableUpload).findFirst().get();

    List<Expr> exprs =
        HttpJsonDescriptorComposer.getRequestFormatterExpr(
            uploadMethod, context.restNumericEnumsEnabled(), RESUMABLE_UPLOAD_PREFIX);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    for (Expr expr : exprs) {
      expr.accept(visitor);
    }
    String code = visitor.write();
    assertThat(code).contains("/resumable/upload/v1beta1/files:upload");
  }

  @Test
  void getRequestFormatterExpr_withAdditionalPaths_prependsPrefix() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);
    Method uploadMethod =
        service.methods().stream().filter(Method::isResumableUpload).findFirst().get();

    HttpBindings bindingsWithAdditional =
        HttpBindings.builder()
            .setHttpVerb(uploadMethod.httpBindings().httpVerb())
            .setPattern(uploadMethod.httpBindings().pattern())
            .setAdditionalPatterns(Arrays.asList("/v1beta1/files:additionalUpload"))
            .setPathParameters(uploadMethod.httpBindings().pathParameters())
            .setQueryParameters(uploadMethod.httpBindings().queryParameters())
            .setBodyParameters(uploadMethod.httpBindings().bodyParameters())
            .setIsAsteriskBody(uploadMethod.httpBindings().isAsteriskBody())
            .build();
    Method methodWithAdditional =
        uploadMethod.toBuilder().setHttpBindings(bindingsWithAdditional).build();

    List<Expr> exprs =
        HttpJsonDescriptorComposer.getRequestFormatterExpr(
            methodWithAdditional, context.restNumericEnumsEnabled(), RESUMABLE_UPLOAD_PREFIX);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    for (Expr expr : exprs) {
      expr.accept(visitor);
    }
    String code = visitor.write();
    assertThat(code).contains("/resumable/upload/v1beta1/files:upload");
    assertThat(code).contains("setAdditionalPaths");
    assertThat(code).contains("/resumable/upload/v1beta1/files:additionalUpload");
  }

  @Test
  void getHttpMethodTypeExpr_returnsCorrectVerb() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);
    Method uploadMethod =
        service.methods().stream().filter(Method::isResumableUpload).findFirst().get();

    List<Expr> exprs = HttpJsonDescriptorComposer.getHttpMethodTypeExpr(uploadMethod);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    for (Expr expr : exprs) {
      expr.accept(visitor);
    }
    assertThat(visitor.write()).contains("\"POST\"");
  }

  @Test
  void getMethodTypeExpr_unaryAndServerStreaming() {
    GapicContext context = RestTestProtoLoader.instance().parseEcho();
    Service service = context.services().get(0);
    Method echoMethod =
        service.methods().stream().filter(m -> m.name().equals("Echo")).findFirst().get();
    Method expandMethod =
        service.methods().stream().filter(m -> m.name().equals("Expand")).findFirst().get();

    List<Expr> unaryExprs = HttpJsonDescriptorComposer.getMethodTypeExpr(echoMethod);
    JavaWriterVisitor unaryVisitor = new JavaWriterVisitor();
    for (Expr expr : unaryExprs) {
      expr.accept(unaryVisitor);
    }
    assertThat(unaryVisitor.write()).contains("MethodType.UNARY");

    List<Expr> streamExprs = HttpJsonDescriptorComposer.getMethodTypeExpr(expandMethod);
    JavaWriterVisitor streamVisitor = new JavaWriterVisitor();
    for (Expr expr : streamExprs) {
      expr.accept(streamVisitor);
    }
    assertThat(streamVisitor.write()).contains("MethodType.SERVER_STREAMING");
  }

  @Test
  void setResponseParserExpr_containsDefaultInstanceAndRegistry() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);
    Method uploadMethod =
        service.methods().stream().filter(Method::isResumableUpload).findFirst().get();

    List<Expr> exprs = HttpJsonDescriptorComposer.setResponseParserExpr(uploadMethod);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    for (Expr expr : exprs) {
      expr.accept(visitor);
    }
    String code = visitor.write();
    assertThat(code).contains("getDefaultInstance()");
    assertThat(code).contains("setDefaultTypeRegistry(typeRegistry)");
  }

  @Test
  void getBindingFieldMethodName_allCases() {
    Field repeatedField =
        Field.builder().setName("values").setIsRepeated(true).setType(TypeNode.STRING).build();
    HttpBinding repeatedBinding =
        HttpBinding.builder().setField(repeatedField).setName("values").build();
    assertThat(
            HttpJsonDescriptorComposer.getBindingFieldMethodName(repeatedBinding, 1, 0, "Values"))
        .isEqualTo("getValuesList");

    Field enumField =
        Field.builder().setName("enumVal").setIsEnum(true).setType(TypeNode.OBJECT).build();
    HttpBinding enumBinding = HttpBinding.builder().setField(enumField).setName("enumVal").build();
    assertThat(HttpJsonDescriptorComposer.getBindingFieldMethodName(enumBinding, 1, 0, "EnumVal"))
        .isEqualTo("getEnumValValue");

    Field regularField = Field.builder().setName("regularVal").setType(TypeNode.STRING).build();
    HttpBinding regularBinding =
        HttpBinding.builder().setField(regularField).setName("regularVal").build();
    assertThat(
            HttpJsonDescriptorComposer.getBindingFieldMethodName(regularBinding, 1, 0, "RegularVal"))
        .isEqualTo("getRegularVal");

    assertThat(
            HttpJsonDescriptorComposer.getBindingFieldMethodName(regularBinding, 3, 1, "RegularVal"))
        .isEqualTo("getRegularVal");
  }
}

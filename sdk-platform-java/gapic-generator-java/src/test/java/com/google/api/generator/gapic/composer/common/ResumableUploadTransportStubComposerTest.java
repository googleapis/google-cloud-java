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

package com.google.api.generator.gapic.composer.common;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.composer.grpc.GrpcServiceStubClassComposer;
import com.google.api.generator.gapic.composer.rest.HttpJsonServiceStubClassComposer;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.protoloader.GrpcTestProtoLoader;
import com.google.api.generator.test.protoloader.RestTestProtoLoader;
import org.junit.jupiter.api.Test;

class ResumableUploadTransportStubComposerTest {

  @Test
  void generateGrpcServiceStubClass_resumableUploadDelegation() {
    GapicContext context = GrpcTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);

    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, service);
    assertThat(clazz.kind()).isEqualTo(Kind.STUB);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify key imports
    assertThat(code).contains("import com.google.api.gax.grpc.GrpcStatusCode;");
    assertThat(code).contains("import com.google.api.gax.httpjson.HttpJsonCallContext;");
    assertThat(code).contains("import com.google.api.gax.rpc.FailedPreconditionException;");
    assertThat(code).contains("import com.google.api.gax.rpc.ResumableUploadCallable;");
    assertThat(code).contains("import io.grpc.Status;");

    // Verify class declaration and nullable stub field
    assertThat(code)
        .contains("public class GrpcResumableUploadServiceStub extends ResumableUploadServiceStub");
    assertThat(code)
        .contains(
            "private final @Nullable HttpJsonResumableUploadServiceResumableUploadStub"
                + " resumableUploadStub;");

    // Verify constructor credentials check
    assertThat(code).contains("if (clientContext.getCredentials() != null) {");
    assertThat(code).contains("ClientContext httpJsonClientContext =");
    assertThat(code).contains(".setCredentials(clientContext.getCredentials())");
    assertThat(code).contains(".setEndpoint(settings.getEndpoint())");
    assertThat(code).contains(".setExecutor(clientContext.getExecutor())");
    assertThat(code).contains(".setDefaultCallContext(HttpJsonCallContext.createDefault())");
    assertThat(code).contains("this.resumableUploadStub =");
    assertThat(code)
        .contains(
            "HttpJsonResumableUploadServiceResumableUploadStub.create(httpJsonClientContext,"
                + " settings);");
    assertThat(code).contains("} else {");
    assertThat(code).contains("this.resumableUploadStub = null;");

    // Verify callable getter throwing FailedPreconditionException when resumableUploadStub == null
    assertThat(code)
        .contains(
            "public ResumableUploadCallable<UploadMediaRequest, UploadMediaResponse>"
                + " uploadMediaCallable() {");
    assertThat(code).contains("if (resumableUploadStub == null) {");
    assertThat(code).contains("throw new FailedPreconditionException(");
    assertThat(code)
        .contains("\"Resumable uploads execute over HTTP/REST and require credentials.");
    assertThat(code).contains("GrpcStatusCode.of(Status.Code.FAILED_PRECONDITION)");
    assertThat(code).contains("return resumableUploadStub.uploadMediaCallable();");

    // Verify close() cleans up resumableUploadStub
    assertThat(code).contains("backgroundResources.close();");
    assertThat(code).contains("if (resumableUploadStub != null) {");
    assertThat(code).contains("resumableUploadStub.close();");
  }

  @Test
  void generateHttpJsonServiceStubClass_resumableUploadDelegation() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);

    GapicClass clazz = HttpJsonServiceStubClassComposer.instance().generate(context, service);
    assertThat(clazz.kind()).isEqualTo(Kind.STUB);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify class declaration and non-null stub field
    assertThat(code)
        .contains(
            "public class HttpJsonResumableUploadServiceStub extends ResumableUploadServiceStub");
    assertThat(code)
        .contains(
            "private final HttpJsonResumableUploadServiceResumableUploadStub resumableUploadStub;");
    assertThat(code)
        .doesNotContain(
            "private final @Nullable HttpJsonResumableUploadServiceResumableUploadStub"
                + " resumableUploadStub;");

    // Verify REST constructor directly creates the upload stub
    assertThat(code).contains("this.resumableUploadStub =");
    assertThat(code)
        .contains(
            "HttpJsonResumableUploadServiceResumableUploadStub.create(clientContext, settings);");

    // Verify callable getter delegates directly
    assertThat(code)
        .contains(
            "public ResumableUploadCallable<UploadMediaRequest, UploadMediaResponse>"
                + " uploadMediaCallable() {");
    assertThat(code).contains("return resumableUploadStub.uploadMediaCallable();");

    // Verify close() cleans up resumableUploadStub directly without redundant null check
    assertThat(code).contains("backgroundResources.close();");
    assertThat(code).contains("resumableUploadStub.close();");
    assertThat(code).doesNotContain("if (resumableUploadStub != null) {");
  }

  @Test
  void generateGrpcServiceStubClass_serviceWithoutResumableUpload_noUploadStub() {
    GapicContext context = GrpcTestProtoLoader.instance().parseShowcaseEcho();
    Service service = context.services().get(0);

    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, service);
    assertThat(clazz.kind()).isEqualTo(Kind.STUB);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    assertThat(code).doesNotContain("resumableUploadStub");
    assertThat(code).doesNotContain("HttpJsonCallContext");
    assertThat(code).doesNotContain("FailedPreconditionException");
  }

  @Test
  void generateHttpJsonServiceStubClass_serviceWithoutResumableUpload_noUploadStub() {
    GapicContext context = RestTestProtoLoader.instance().parseCompliance();
    Service service = context.services().get(0);

    GapicClass clazz = HttpJsonServiceStubClassComposer.instance().generate(context, service);
    assertThat(clazz.kind()).isEqualTo(Kind.STUB);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    assertThat(code).doesNotContain("resumableUploadStub");
  }
}

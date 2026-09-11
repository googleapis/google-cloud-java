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

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.composer.grpc.ServiceClientTestClassComposer;
import com.google.api.generator.gapic.composer.rest.ServiceClientClassComposer;
import com.google.api.generator.gapic.composer.rest.ServiceStubClassComposer;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.protoloader.RestTestProtoLoader;
import com.google.protobuf.Empty;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ResumableUploadServiceClientComposerTest {

  @Test
  void generateServiceStub_resumableUploadCallable() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);

    GapicClass clazz = ServiceStubClassComposer.instance().generate(context, service);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify import of ResumableUploadCallable
    assertThat(code).contains("import com.google.api.gax.rpc.ResumableUploadCallable;");

    // Verify abstract callable getter on stub
    assertThat(code)
        .contains(
            "public ResumableUploadCallable<UploadMediaRequest, UploadMediaResponse>"
                + " uploadMediaCallable() {\n"
                + "    throw new UnsupportedOperationException(\"Not implemented:"
                + " uploadMediaCallable()\");\n"
                + "  }");
  }

  @Test
  void generateServiceClient_resumableUploadCallableAndConvenienceMethod() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);

    GapicClass clazz = ServiceClientClassComposer.instance().generate(context, service);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify imports
    assertThat(code).contains("import com.google.api.gax.rpc.ApiExceptions;");
    assertThat(code).contains("import com.google.api.gax.rpc.ResumableUploadCallable;");
    assertThat(code).contains("import java.io.InputStream;");

    // Verify callable getter on client delegating to stub
    assertThat(code)
        .contains(
            "public final ResumableUploadCallable<UploadMediaRequest, UploadMediaResponse>\n"
                + "      uploadMediaCallable() {\n"
                + "    return stub.uploadMediaCallable();\n"
                + "  }");

    // Verify synchronous convenience method calling ApiExceptions.callAndTranslateApiException
    assertThat(code)
        .contains(
            "public final UploadMediaResponse uploadMedia(UploadMediaRequest request, InputStream"
                + " payload) {\n"
                + "    return ApiExceptions.callAndTranslateApiException(\n"
                + "        uploadMediaCallable().futureCall(request, payload, null));\n"
                + "  }");

    // Verify method variants (flattened methods) are suppressed
    assertThat(code).doesNotContain("uploadMedia(String");

    // Verify Javadoc warning on methods
    assertThat(code)
        .contains(
            "Call context overrides (such as withTimeout, withRetrySettings, or credentials)");
    assertThat(code).contains("to the start request (session initiation)");
    assertThat(code).contains("Per-chunk PUT calls rely on the configured timeout");
    assertThat(code).contains("retry settings from ResumableUploadCallSettings.");

    // Verify @param request and @param payload in Javadoc
    assertThat(code).contains("@param request The request object");
    assertThat(code).contains("@param payload The payload data stream to upload.");
  }

  @Test
  void generateServiceClientTest_resumableUploadTest() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);

    GapicClass clazz = ServiceClientTestClassComposer.instance().generate(context, service);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify test placeholder for resumable upload method
    assertThat(code).contains("public void uploadMediaTest() throws Exception");
    assertThat(code)
        .contains(
            "@Ignore(\n"
                + "      \"Requires live HTTP/REST server supporting resumable upload protocol;"
                + " tested in integration tests.\")");
    assertThat(code).contains("The uploadMedia() method requires a live HTTP/REST server");
    assertThat(code).contains("protocol and is tested in integration tests.");

    // Verify no exception test is generated
    assertThat(code).doesNotContain("uploadMediaExceptionTest");
  }

  @Test
  void generateServiceClient_resumableUploadVoidReturn() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);
    TypeNode emptyType = TypeNode.withReference(ConcreteReference.withClazz(Empty.class));
    Method emptyOutputMethod =
        service.methods().get(0).toBuilder().setOutputType(emptyType).build();
    Service emptyOutputService =
        service.toBuilder().setMethods(Arrays.asList(emptyOutputMethod)).build();

    GapicClass clazz = ServiceClientClassComposer.instance().generate(context, emptyOutputService);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    assertThat(code)
        .contains(
            "public final void uploadMedia(UploadMediaRequest request, InputStream payload) {\n"
                + "    ApiExceptions.callAndTranslateApiException(\n"
                + "        uploadMediaCallable().futureCall(request, payload, null));\n"
                + "  }");
  }
}

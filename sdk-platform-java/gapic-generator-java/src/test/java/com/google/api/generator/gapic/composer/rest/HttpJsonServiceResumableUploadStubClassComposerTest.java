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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.composer.Composer;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.protoloader.RestTestProtoLoader;
import java.util.List;
import org.junit.jupiter.api.Test;

class HttpJsonServiceResumableUploadStubClassComposerTest {

  @Test
  void generate_resumableUploadService_astValidation() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);

    GapicClass clazz =
        HttpJsonServiceResumableUploadStubClassComposer.instance().generate(context, service);
    assertThat(clazz.kind()).isEqualTo(Kind.STUB);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify key imports
    assertThat(code).contains("import com.google.api.core.InternalApi;");
    assertThat(code).contains("import com.google.api.gax.core.BackgroundResource;");
    assertThat(code).contains("import com.google.api.gax.core.BackgroundResourceAggregation;");
    assertThat(code).contains("import com.google.api.gax.httpjson.ApiMethodDescriptor;");
    assertThat(code).contains("import com.google.api.gax.httpjson.HttpJsonCallSettings;");
    assertThat(code).contains("import com.google.api.gax.httpjson.HttpJsonCallableFactory;");
    assertThat(code).contains("import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;");
    assertThat(code).contains("import com.google.api.gax.httpjson.ProtoMessageResponseParser;");
    assertThat(code).contains("import com.google.api.gax.rpc.ClientContext;");
    assertThat(code).contains("import com.google.api.gax.rpc.ResumableUploadCallable;");
    assertThat(code).contains("import com.google.protobuf.TypeRegistry;");
    assertThat(code).contains("import com.google.showcase.v1beta1.UploadMediaRequest;");
    assertThat(code).contains("import com.google.showcase.v1beta1.UploadMediaResponse;");

    // Verify class annotations and declaration
    assertThat(code).contains("@InternalApi");
    assertThat(code).contains("@Generated(\"by gapic-generator-java\")");
    assertThat(code).contains("@NullMarked");
    assertThat(code)
        .contains(
            "public class HttpJsonResumableUploadServiceResumableUploadStub implements"
                + " BackgroundResource");

    // Verify static typeRegistry field
    assertThat(code)
        .contains(
            "private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();");

    // Verify static method descriptor with resumable/upload path prefix
    assertThat(code).contains("ApiMethodDescriptor<UploadMediaRequest, UploadMediaResponse>");
    assertThat(code).contains("uploadMediaMethodDescriptor =");
    assertThat(code)
        .contains(
            ".setFullMethodName(\"google.showcase.v1beta1.ResumableUploadService/UploadMedia\")");
    assertThat(code).contains(".setHttpMethod(\"POST\")");
    assertThat(code).contains(".setType(ApiMethodDescriptor.MethodType.UNARY)");
    assertThat(code).contains(".setPath(");
    assertThat(code).contains("\"/resumable/upload/v1beta1/files:upload\"");
    assertThat(code).contains(".setRequestBodyExtractor(");
    assertThat(code).contains(".setResponseParser(");

    // Verify class members
    assertThat(code).contains("private final BackgroundResource backgroundResources;");
    assertThat(code).contains("ResumableUploadCallable<UploadMediaRequest, UploadMediaResponse>");
    assertThat(code).contains("uploadMediaCallable;");

    // Verify static create factory
    assertThat(code)
        .contains("public static HttpJsonResumableUploadServiceResumableUploadStub create(");
    assertThat(code)
        .contains("ClientContext clientContext, ResumableUploadServiceStubSettings settings");
    assertThat(code)
        .contains(
            "return new HttpJsonResumableUploadServiceResumableUploadStub(clientContext,"
                + " settings);");

    // Verify constructor
    assertThat(code).contains("protected HttpJsonResumableUploadServiceResumableUploadStub(");
    assertThat(code)
        .contains(
            "HttpJsonCallSettings<UploadMediaRequest, UploadMediaResponse>"
                + " uploadMediaTransportSettings =");
    assertThat(code).contains("HttpJsonCallableFactory.createResumableUploadCallable(");
    assertThat(code)
        .contains("uploadMediaTransportSettings, settings.uploadMediaSettings(), clientContext);");
    assertThat(code)
        .contains("new BackgroundResourceAggregation(clientContext.getBackgroundResources());");

    // Verify callable getter
    assertThat(code)
        .contains(
            "public ResumableUploadCallable<UploadMediaRequest, UploadMediaResponse>"
                + " uploadMediaCallable() {");
    assertThat(code).contains("return uploadMediaCallable;");

    // Verify getMethodDescriptors
    assertThat(code).contains("@InternalApi");
    assertThat(code).contains("public static List<ApiMethodDescriptor> getMethodDescriptors() {");
    assertThat(code).contains("methodDescriptors.add(uploadMediaMethodDescriptor);");

    // Verify BackgroundResource delegation methods
    assertThat(code).contains("public final void close() {");
    assertThat(code).contains("backgroundResources.close();");
    assertThat(code).contains("public void shutdown() {");
    assertThat(code).contains("backgroundResources.shutdown();");
    assertThat(code).contains("public boolean isShutdown() {");
    assertThat(code).contains("return backgroundResources.isShutdown();");
    assertThat(code).contains("public boolean isTerminated() {");
    assertThat(code).contains("return backgroundResources.isTerminated();");
    assertThat(code).contains("public void shutdownNow() {");
    assertThat(code).contains("backgroundResources.shutdownNow();");
    assertThat(code).contains("public boolean awaitTermination(long duration, TimeUnit unit)");
    assertThat(code).contains("return backgroundResources.awaitTermination(duration, unit);");
  }

  @Test
  void generate_serviceWithoutResumableUpload_returnsNonGeneratedClass() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseEcho();
    Service echoService = context.services().get(0);

    GapicClass clazz =
        HttpJsonServiceResumableUploadStubClassComposer.instance().generate(context, echoService);
    assertThat(clazz.kind()).isEqualTo(GapicClass.Kind.NON_GENERATED);
  }

  @Test
  void composer_generateStubClasses_registersUploadStubWhenResumableUploadPresent() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    List<GapicClass> stubClasses = Composer.generateStubClasses(context);
    assertThat(
            stubClasses.stream()
                .anyMatch(
                    c ->
                        c.classDefinition()
                            .classIdentifier()
                            .name()
                            .equals("HttpJsonResumableUploadServiceResumableUploadStub")))
        .isTrue();
  }
}

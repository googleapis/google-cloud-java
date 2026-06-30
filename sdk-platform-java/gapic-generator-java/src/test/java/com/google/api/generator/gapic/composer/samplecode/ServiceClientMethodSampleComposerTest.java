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

import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.model.LongrunningOperation;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.protoparser.Parser;
import com.google.api.generator.test.utils.LineFormatter;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.showcase.v1beta1.EchoOuterClass;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ServiceClientMethodSampleComposerTest {
  private static final String SHOWCASE_PACKAGE_NAME = "com.google.showcase.v1beta1";
  private static final String LRO_PACKAGE_NAME = "com.google.longrunning";
  private static final String PROTO_PACKAGE_NAME = "com.google.protobuf";
  private static final String PAGINATED_FIELD_NAME = "page_size";

  @Test
  void valid_composeDefaultSample_isPagedMethod() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("PagedExpandRequest")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("PagedExpandResponse")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    Method method =
        Method.builder()
            .setName("PagedExpand")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setMethodSignatures(Collections.emptyList())
            .setPageSizeFieldName(PAGINATED_FIELD_NAME)
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setMethods(Arrays.asList(method))
            .setOverriddenName("Echo")
            .build();
    String results =
        writeStatements(
            ServiceClientMethodSampleComposer.composeCanonicalSample(
                method, clientType, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  PagedExpandRequest request =\n",
            "      PagedExpandRequest.newBuilder()\n",
            "          .setContent(\"content951530617\")\n",
            "          .setPageSize(883849137)\n",
            "          .setPageToken(\"pageToken873572522\")\n",
            "          .build();\n",
            "  for (EchoResponse element : echoClient.pagedExpand(request).iterateAll()) {\n",
            "    // doThingsWith(element);\n",
            "  }\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void invalid_composeDefaultSample_isPagedMethod() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("NotExistRequest")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("PagedExpandResponse")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    Method method =
        Method.builder()
            .setName("PagedExpand")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setMethodSignatures(Collections.emptyList())
            .setPageSizeFieldName(PAGINATED_FIELD_NAME)
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setMethods(Arrays.asList(method))
            .setOverriddenName("Echo")
            .build();
    Assert.assertThrows(
        NullPointerException.class,
        () ->
            ServiceClientMethodSampleComposer.composeCanonicalSample(
                method, clientType, resourceNames, messageTypes, service));
  }

  @Test
  void valid_composeDefaultSample_hasLroMethodWithReturnResponse() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("WaitRequest")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder().setName("Operation").setPakkage(LRO_PACKAGE_NAME).build());
    TypeNode responseType =
        TypeNode.withReference(
            VaporReference.builder().setName("Empty").setPakkage(PROTO_PACKAGE_NAME).build());
    TypeNode metadataType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("WaitMetadata")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    LongrunningOperation lro =
        LongrunningOperation.builder()
            .setResponseType(responseType)
            .setMetadataType(metadataType)
            .build();
    Method method =
        Method.builder()
            .setName("Wait")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setMethodSignatures(Collections.emptyList())
            .setLro(lro)
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setMethods(Arrays.asList(method))
            .setOverriddenName("Echo")
            .build();
    String results =
        writeStatements(
            ServiceClientMethodSampleComposer.composeCanonicalSample(
                method, clientType, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  WaitRequest request = WaitRequest.newBuilder().build();\n",
            "  echoClient.waitAsync(request).get();\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void valid_composeDefaultSample_hasLroMethodWithReturnVoid() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("WaitRequest")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder().setName("Operation").setPakkage(LRO_PACKAGE_NAME).build());
    TypeNode responseType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("WaitResponse")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode metadataType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("WaitMetadata")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    LongrunningOperation lro =
        LongrunningOperation.builder()
            .setResponseType(responseType)
            .setMetadataType(metadataType)
            .build();
    Method method =
        Method.builder()
            .setName("Wait")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setMethodSignatures(Collections.emptyList())
            .setLro(lro)
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setMethods(Arrays.asList(method))
            .setOverriddenName("Echo")
            .build();
    String results =
        writeStatements(
            ServiceClientMethodSampleComposer.composeCanonicalSample(
                method, clientType, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  WaitRequest request = WaitRequest.newBuilder().build();\n",
            "  WaitResponse response = echoClient.waitAsync(request).get();\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void valid_composeDefaultSample_pureUnaryReturnVoid() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoRequest")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder().setName("Empty").setPakkage(PROTO_PACKAGE_NAME).build());
    Method method =
        Method.builder()
            .setName("Echo")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setMethodSignatures(Collections.emptyList())
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setMethods(Arrays.asList(method))
            .setOverriddenName("Echo")
            .build();
    String results =
        writeStatements(
            ServiceClientMethodSampleComposer.composeCanonicalSample(
                method, clientType, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  EchoRequest request =\n",
            "      EchoRequest.newBuilder()\n",
            "          .setName(FoobarName.ofProjectFoobarName(\"[PROJECT]\","
                + " \"[FOOBAR]\").toString())\n",
            "          .setParent(FoobarName.ofProjectFoobarName(\"[PROJECT]\","
                + " \"[FOOBAR]\").toString())\n",
            "          .setSeverity(Severity.forNumber(0))\n",
            "          .setFoobar(Foobar.newBuilder().build())\n",
            "          .build();\n",
            "  echoClient.echo(request);\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void valid_composeDefaultSample_pureUnaryReturnResponse() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoRequest")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoResponse")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    Method method =
        Method.builder()
            .setName("Echo")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setMethodSignatures(Collections.emptyList())
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setMethods(Arrays.asList(method))
            .setOverriddenName("Echo")
            .build();
    String results =
        writeStatements(
            ServiceClientMethodSampleComposer.composeCanonicalSample(
                method, clientType, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  EchoRequest request =\n",
            "      EchoRequest.newBuilder()\n",
            "          .setName(FoobarName.ofProjectFoobarName(\"[PROJECT]\","
                + " \"[FOOBAR]\").toString())\n",
            "          .setParent(FoobarName.ofProjectFoobarName(\"[PROJECT]\","
                + " \"[FOOBAR]\").toString())\n",
            "          .setSeverity(Severity.forNumber(0))\n",
            "          .setFoobar(Foobar.newBuilder().build())\n",
            "          .build();\n",
            "  EchoResponse response = echoClient.echo(request);\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  private String writeStatements(Sample sample) {
    return SampleCodeWriter.write(sample.body());
  }
}

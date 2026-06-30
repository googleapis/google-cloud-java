// Copyright 2022 Google LLC
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

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.LongrunningOperation;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.MethodArgument;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.protoparser.Parser;
import com.google.api.generator.test.utils.LineFormatter;
import com.google.protobuf.Descriptors;
import com.google.selective.generate.v1beta1.SelectiveApiGenerationOuterClass;
import com.google.showcase.v1beta1.EchoOuterClass;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ServiceClientHeaderSampleComposerTest {
  private static final String SHOWCASE_PACKAGE_NAME = "com.google.showcase.v1beta1";
  private static final String SELECTIVE_API_PACKAGE_NAME = "com.google.selective.generate.v1beta1";
  private static final String LRO_PACKAGE_NAME = "com.google.longrunning";
  private static final String PROTO_PACKAGE_NAME = "com.google.protobuf";
  private static final String PAGINATED_FIELD_NAME = "page_size";
  private static final Service TEST_SERVICE =
      Service.builder()
          .setName("Echo")
          .setDefaultHost("localhost:7469")
          .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
          .setPakkage(SHOWCASE_PACKAGE_NAME)
          .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
          .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
          .setOverriddenName("Echo")
          .build();

  /*Testing composeClassHeaderSample*/
  @Test
  void composeClassHeaderSample_unaryRpc() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            echoFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);
    Service echoProtoService = services.get(0);
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    Sample sample =
        ServiceClientHeaderSampleComposer.composeClassHeaderSample(
            echoProtoService, clientType, resourceNames, messageTypes);
    String results = writeStatements(sample);
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  EchoResponse response = echoClient.echo();\n",
            "}");
    Assert.assertEquals(expected, results);
  }

  @Test
  void composeClassHeaderSample_firstMethodIsNotUnaryRpc() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
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
    TypeNode ttlTypeNode =
        TypeNode.withReference(
            VaporReference.builder().setName("Duration").setPakkage(PROTO_PACKAGE_NAME).build());
    MethodArgument ttl =
        MethodArgument.builder()
            .setName("ttl")
            .setType(ttlTypeNode)
            .setField(
                Field.builder()
                    .setName("ttl")
                    .setType(ttlTypeNode)
                    .setIsMessage(true)
                    .setIsContainedInOneof(true)
                    .build())
            .build();
    Method method =
        Method.builder()
            .setName("Wait")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setLro(lro)
            .setMethodSignatures(Arrays.asList(Arrays.asList(ttl)))
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeClassHeaderSample(
                service, clientType, resourceNames, messageTypes));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  Duration ttl = Duration.newBuilder().build();\n",
            "  WaitResponse response = echoClient.waitAsync(ttl).get();\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void composeClassHeaderSample_firstMethodHasNoSignatures() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
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
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeClassHeaderSample(
                service, clientType, resourceNames, messageTypes));
    System.out.println("results:  " + results);
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
    System.out.println("results:  " + expected);
    Assert.assertEquals(results, expected);
  }

  @Test
  void composeClassHeaderSample_firstMethodIsStream() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("ExpandRequest")
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
            .setName("Expand")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setStream(Method.Stream.SERVER)
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeClassHeaderSample(
                service, clientType, resourceNames, messageTypes));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  ExpandRequest request =\n",
            "      ExpandRequest.newBuilder().setContent(\"content951530617\").setInfo(\"info3237038\").build();\n",
            "  ServerStream<EchoResponse> stream = echoClient.expandCallable().call(request);\n",
            "  for (EchoResponse response : stream) {\n",
            "    // Do something when a response is received.\n",
            "  }\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void composeClassHeaderSample_firstMethodIsInternal() {
    Descriptors.FileDescriptor selectiveApiGenerationFileDescriptor =
        SelectiveApiGenerationOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames =
        Parser.parseResourceNames(selectiveApiGenerationFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(selectiveApiGenerationFileDescriptor);
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoRequest")
                .setPakkage(SELECTIVE_API_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoResponse")
                .setPakkage(SELECTIVE_API_PACKAGE_NAME)
                .build());
    Method internalMethod =
        Method.builder()
            .setName("ChatShouldGenerateAsInternal")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setIsInternalApi(true)
            .build();
    Method publicMethod =
        Method.builder()
            .setName("ChatShouldGenerateAsUsual")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setIsInternalApi(false)
            .build();
    Service service =
        Service.builder()
            .setName("EchoServiceShouldGeneratePartialUsual")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SELECTIVE_API_PACKAGE_NAME)
            .setProtoPakkage(SELECTIVE_API_PACKAGE_NAME)
            .setOriginalJavaPackage(SELECTIVE_API_PACKAGE_NAME)
            .setOverriddenName("EchoServiceShouldGeneratePartialUsual")
            .setMethods(Arrays.asList(internalMethod, publicMethod))
            .build();
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoServiceSelectiveApiClient")
                .setPakkage(SELECTIVE_API_PACKAGE_NAME)
                .build());
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeClassHeaderSample(
                service, clientType, resourceNames, messageTypes));
    String expected =
        LineFormatter.lines(
            "try (EchoServiceSelectiveApiClient echoServiceSelectiveApiClient =\n"
                + "    EchoServiceSelectiveApiClient.create()) {\n"
                + "  EchoRequest request =\n"
                + "      EchoRequest.newBuilder()\n"
                + "          .setName(FoobarName.of(\"[PROJECT]\", \"[FOOBAR]\").toString())\n"
                + "          .setParent(\n"
                + "              FoobarbazName.ofProjectFoobarbazName(\"[PROJECT]\", \"[FOOBARBAZ]\").toString())\n"
                + "          .setFoobar(Foobar.newBuilder().build())\n"
                + "          .build();\n"
                + "  EchoResponse response = echoServiceSelectiveApiClient.chatShouldGenerateAsUsual(request);\n"
                + "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void composeClassHeaderSample_allMethodsAreInternal() {
    Descriptors.FileDescriptor selectiveApiGenerationFileDescriptor =
        SelectiveApiGenerationOuterClass.getDescriptor();
    Map<String, ResourceName> resourceNames =
        Parser.parseResourceNames(selectiveApiGenerationFileDescriptor);
    Map<String, Message> messageTypes = Parser.parseMessages(selectiveApiGenerationFileDescriptor);
    TypeNode inputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoRequest")
                .setPakkage(SELECTIVE_API_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoResponse")
                .setPakkage(SELECTIVE_API_PACKAGE_NAME)
                .build());
    Method internalMethod1 =
        Method.builder()
            .setName("ChatShouldGenerateAsInternal")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setIsInternalApi(true)
            .build();
    Method internalMethod2 =
        Method.builder()
            .setName("EchoShouldGenerateAsInternal")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setIsInternalApi(true)
            .build();
    Service service =
        Service.builder()
            .setName("EchoServiceShouldGeneratePartialUsual")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SELECTIVE_API_PACKAGE_NAME)
            .setProtoPakkage(SELECTIVE_API_PACKAGE_NAME)
            .setOriginalJavaPackage(SELECTIVE_API_PACKAGE_NAME)
            .setOverriddenName("EchoServiceShouldGeneratePartialUsual")
            .setMethods(Arrays.asList(internalMethod1, internalMethod2))
            .build();
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoServiceSelectiveApiClient")
                .setPakkage(SELECTIVE_API_PACKAGE_NAME)
                .build());
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeClassHeaderSample(
                service, clientType, resourceNames, messageTypes));
    String expected =
        LineFormatter.lines(
            "try (EchoServiceSelectiveApiClient echoServiceSelectiveApiClient =\n"
                + "    EchoServiceSelectiveApiClient.create()) {}");
    Assert.assertEquals(expected, results);
  }

  /*Testing composeSetCredentialsSample*/
  @Test
  void composeSetCredentialsSample() {
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode settingsType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoSettings")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeSetCredentialsSample(
                clientType, settingsType, TEST_SERVICE));
    String expected =
        LineFormatter.lines(
            "EchoSettings echoSettings =\n",
            "    EchoSettings.newBuilder()\n",
            "        .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))\n",
            "        .build();\n",
            "EchoClient echoClient = EchoClient.create(echoSettings);");
    Assert.assertEquals(expected, results);
  }

  /*Testing composeSetEndpointSample*/
  @Test
  void composeSetEndpointSample() {
    TypeNode clientType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoClient")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode settingsType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoSettings")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeSetEndpointSample(
                clientType, settingsType, TEST_SERVICE));
    String expected =
        LineFormatter.lines(
            "EchoSettings echoSettings ="
                + " EchoSettings.newBuilder().setEndpoint(myEndpoint).build();\n",
            "EchoClient echoClient = EchoClient.create(echoSettings);");
    Assert.assertEquals(expected, results);
  }

  /*Testing composeShowcaseMethodSample*/
  @Test
  void valid_composeShowcaseMethodSample_pagedRpcWithMultipleMethodArguments() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
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
                .setName("ListContentRequest")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("ListContentResponse")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode resourceNameType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(ConcreteReference.withClazz(String.class))
                .build());
    List<MethodArgument> arguments =
        Arrays.asList(
            MethodArgument.builder()
                .setName("resourceName")
                .setType(resourceNameType)
                .setField(
                    Field.builder()
                        .setName("resourceName")
                        .setType(resourceNameType)
                        .setIsRepeated(true)
                        .build())
                .build(),
            MethodArgument.builder()
                .setName("filter")
                .setType(TypeNode.STRING)
                .setField(Field.builder().setName("filter").setType(TypeNode.STRING).build())
                .build());
    Method method =
        Method.builder()
            .setName("ListContent")
            .setMethodSignatures(Arrays.asList(arguments))
            .setInputType(inputType)
            .setOutputType(outputType)
            .setPageSizeFieldName(PAGINATED_FIELD_NAME)
            .build();
    Reference repeatedResponseReference =
        VaporReference.builder().setName("Content").setPakkage(SHOWCASE_PACKAGE_NAME).build();
    Field repeatedField =
        Field.builder()
            .setName("responses")
            .setType(
                TypeNode.withReference(
                    ConcreteReference.builder()
                        .setClazz(List.class)
                        .setGenerics(repeatedResponseReference)
                        .build()))
            .setIsMessage(true)
            .setIsRepeated(true)
            .build();
    Field nextPagedTokenField =
        Field.builder().setName("next_page_token").setType(TypeNode.STRING).build();
    Message listContentResponseMessage =
        Message.builder()
            .setName("ListContentResponse")
            .setFullProtoName("google.showcase.v1beta1.ListContentResponse")
            .setType(outputType)
            .setFields(Arrays.asList(repeatedField, nextPagedTokenField))
            .build();
    messageTypes.put("com.google.showcase.v1beta1.ListContentResponse", listContentResponseMessage);
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();

    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeShowcaseMethodSample(
                method, clientType, arguments, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  List<String> resourceName = new ArrayList<>();\n",
            "  String filter = \"filter-1274492040\";\n",
            "  for (Content element : echoClient.listContent(resourceName, filter).iterateAll())"
                + " {\n",
            "    // doThingsWith(element);\n",
            "  }\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void valid_composeShowcaseMethodSample_pagedRpcWithNoMethodArguments() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
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
                .setName("ListContentRequest")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    TypeNode outputType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("ListContentResponse")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    List<MethodArgument> arguments = Collections.emptyList();
    Method method =
        Method.builder()
            .setName("ListContent")
            .setMethodSignatures(Arrays.asList(arguments))
            .setInputType(inputType)
            .setOutputType(outputType)
            .setPageSizeFieldName(PAGINATED_FIELD_NAME)
            .build();
    Reference repeatedResponseReference =
        VaporReference.builder().setName("Content").setPakkage(SHOWCASE_PACKAGE_NAME).build();
    Field repeatedField =
        Field.builder()
            .setName("responses")
            .setType(
                TypeNode.withReference(
                    ConcreteReference.builder()
                        .setClazz(List.class)
                        .setGenerics(repeatedResponseReference)
                        .build()))
            .setIsMessage(true)
            .setIsRepeated(true)
            .build();
    Field nextPagedTokenField =
        Field.builder().setName("next_page_token").setType(TypeNode.STRING).build();
    Message listContentResponseMessage =
        Message.builder()
            .setName("ListContentResponse")
            .setFullProtoName("google.showcase.v1beta1.ListContentResponse")
            .setType(outputType)
            .setFields(Arrays.asList(repeatedField, nextPagedTokenField))
            .build();
    messageTypes.put("com.google.showcase.v1beta1.ListContentResponse", listContentResponseMessage);
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();

    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeShowcaseMethodSample(
                method, clientType, arguments, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  for (Content element : echoClient.listContent().iterateAll()) {\n",
            "    // doThingsWith(element);\n",
            "  }\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void invalid_composeShowcaseMethodSample_noMatchedRepeatedResponseTypeInPagedMethod() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
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
                .setName("PagedResponse")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    List<MethodArgument> methodArguments = Collections.emptyList();
    Method method =
        Method.builder()
            .setName("simplePagedMethod")
            .setMethodSignatures(Arrays.asList(methodArguments))
            .setInputType(inputType)
            .setOutputType(outputType)
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
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();
    Assert.assertThrows(
        NullPointerException.class,
        () ->
            ServiceClientHeaderSampleComposer.composeShowcaseMethodSample(
                method, clientType, methodArguments, resourceNames, messageTypes, service));
  }

  @Test
  void invalid_composeShowcaseMethodSample_noRepeatedResponseTypeInPagedMethod() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
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
                .setName("PagedResponse")
                .setPakkage(SHOWCASE_PACKAGE_NAME)
                .build());
    List<MethodArgument> methodArguments = Collections.emptyList();
    Method method =
        Method.builder()
            .setName("simplePagedMethod")
            .setMethodSignatures(Arrays.asList(methodArguments))
            .setInputType(inputType)
            .setOutputType(outputType)
            .setPageSizeFieldName(PAGINATED_FIELD_NAME)
            .build();
    Field responseField =
        Field.builder()
            .setName("response")
            .setType(
                TypeNode.withReference(
                    ConcreteReference.builder()
                        .setClazz(List.class)
                        .setGenerics(ConcreteReference.withClazz(String.class))
                        .build()))
            .setIsMessage(true)
            .setIsRepeated(false)
            .build();
    Field nextPageToken =
        Field.builder().setName("next_page_token").setType(TypeNode.STRING).build();
    Message noRepeatedFieldMessage =
        Message.builder()
            .setName("PagedResponse")
            .setFullProtoName("google.showcase.v1beta1.PagedResponse")
            .setType(outputType)
            .setFields(Arrays.asList(responseField, nextPageToken))
            .build();
    messageTypes.put("PagedResponse", noRepeatedFieldMessage);
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();
    Assert.assertThrows(
        NullPointerException.class,
        () ->
            ServiceClientHeaderSampleComposer.composeShowcaseMethodSample(
                method, clientType, methodArguments, resourceNames, messageTypes, service));
  }

  @Test
  void valid_composeShowcaseMethodSample_lroUnaryRpcWithNoMethodArgument() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
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
            .setLro(lro)
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
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeShowcaseMethodSample(
                method, clientType, Collections.emptyList(), resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  WaitResponse response = echoClient.waitAsync().get();\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void valid_composeShowcaseMethodSample_lroRpcWithReturnResponseType() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
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
    TypeNode ttlTypeNode =
        TypeNode.withReference(
            VaporReference.builder().setName("Duration").setPakkage(PROTO_PACKAGE_NAME).build());
    MethodArgument ttl =
        MethodArgument.builder()
            .setName("ttl")
            .setType(ttlTypeNode)
            .setField(
                Field.builder()
                    .setName("ttl")
                    .setType(ttlTypeNode)
                    .setIsMessage(true)
                    .setIsContainedInOneof(true)
                    .build())
            .build();
    List<MethodArgument> arguments = Arrays.asList(ttl);
    Method method =
        Method.builder()
            .setName("Wait")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setLro(lro)
            .setMethodSignatures(Arrays.asList(arguments))
            .build();

    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeShowcaseMethodSample(
                method, clientType, arguments, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  Duration ttl = Duration.newBuilder().build();\n",
            "  WaitResponse response = echoClient.waitAsync(ttl).get();\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  @Test
  void valid_composeShowcaseMethodSample_lroRpcWithReturnVoid() {
    Descriptors.FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
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
    TypeNode ttlTypeNode =
        TypeNode.withReference(
            VaporReference.builder().setName("Duration").setPakkage(PROTO_PACKAGE_NAME).build());
    MethodArgument ttl =
        MethodArgument.builder()
            .setName("ttl")
            .setType(ttlTypeNode)
            .setField(
                Field.builder()
                    .setName("ttl")
                    .setType(ttlTypeNode)
                    .setIsMessage(true)
                    .setIsContainedInOneof(true)
                    .build())
            .build();
    List<MethodArgument> arguments = Arrays.asList(ttl);
    Method method =
        Method.builder()
            .setName("Wait")
            .setInputType(inputType)
            .setOutputType(outputType)
            .setLro(lro)
            .setMethodSignatures(Arrays.asList(arguments))
            .build();
    Service service =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setOverriddenName("Echo")
            .setMethods(Arrays.asList(method))
            .build();
    String results =
        writeStatements(
            ServiceClientHeaderSampleComposer.composeShowcaseMethodSample(
                method, clientType, arguments, resourceNames, messageTypes, service));
    String expected =
        LineFormatter.lines(
            "try (EchoClient echoClient = EchoClient.create()) {\n",
            "  Duration ttl = Duration.newBuilder().build();\n",
            "  echoClient.waitAsync(ttl).get();\n",
            "}");
    Assert.assertEquals(results, expected);
  }

  private String writeStatements(Sample sample) {
    return SampleCodeWriter.write(sample.body());
  }
}

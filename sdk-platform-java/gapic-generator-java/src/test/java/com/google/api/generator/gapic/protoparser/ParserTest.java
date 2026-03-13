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

package com.google.api.generator.gapic.protoparser;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.ClientLibrarySettings;
import com.google.api.CommonLanguageSettings;
import com.google.api.FieldInfo.Format;
import com.google.api.JavaSettings;
import com.google.api.MethodSettings;
import com.google.api.Publishing;
import com.google.api.PythonSettings;
import com.google.api.SelectiveGapicGeneration;
import com.google.api.Service;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.MethodArgument;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.ResourceReference;
import com.google.api.generator.gapic.model.Transport;
import com.google.api.generator.gapic.protoparser.Parser.SelectiveGapicType;
import com.google.api.version.test.ApiVersionTestingOuterClass;
import com.google.auto.populate.field.AutoPopulateFieldTestingOuterClass;
import com.google.bookshop.v1beta1.BookshopProto;
import com.google.cloud.bigquery.v2.JobProto;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest;
import com.google.selective.generate.v1beta1.SelectiveApiGenerationOuterClass;
import com.google.showcase.v1beta1.EchoOuterClass;
import com.google.showcase.v1beta1.TestingOuterClass;
import com.google.testgapic.v1beta1.LockerProto;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParserTest {
  private static final String ECHO_PACKAGE = "com.google.showcase.v1beta1";
  // TODO(miraleung): Backfill with more tests (e.g. field, message, methods) for Parser.java.
  private ServiceDescriptor echoService;
  private FileDescriptor echoFileDescriptor;

  private static final String YAML_DIRECTORY = "src/test/resources/";

  private Optional<com.google.api.Service> serviceYamlProtoOpt;

  @BeforeEach
  void setUp() {
    echoFileDescriptor = EchoOuterClass.getDescriptor();
    echoService = echoFileDescriptor.getServices().get(0);
    String yamlFilename = "echo_v1beta1.yaml";
    Path yamlPath = Paths.get(YAML_DIRECTORY, yamlFilename);
    serviceYamlProtoOpt = ServiceYamlParser.parse(yamlPath.toString());
    assertEquals("Echo", echoService.getName());
  }

  @Test
  void parseMessages_basic() {
    // TODO(miraleung): Add more tests for oneofs and other message-parsing edge cases.
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);

    Message echoRequestMessage = messageTypes.get("com.google.showcase.v1beta1.EchoRequest");
    Field echoRequestNameField = echoRequestMessage.fieldMap().get("name");
    assertTrue(echoRequestNameField.hasResourceReference());

    String echoResponseName = "EchoResponse";
    Field echoResponseContentField =
        Field.builder().setName("content").setType(TypeNode.STRING).build();
    Field echoResponseSeverityField =
        Field.builder()
            .setName("severity")
            .setType(
                TypeNode.withReference(
                    VaporReference.builder().setName("Severity").setPakkage(ECHO_PACKAGE).build()))
            .setIsEnum(true)
            .build();
    TypeNode echoResponseType =
        TypeNode.withReference(
            VaporReference.builder().setName(echoResponseName).setPakkage(ECHO_PACKAGE).build());

    Message echoResponseMessage =
        Message.builder()
            .setType(echoResponseType)
            .setName(echoResponseName)
            .setFullProtoName("google.showcase.v1beta1." + echoResponseName)
            .setFields(Arrays.asList(echoResponseContentField, echoResponseSeverityField))
            .build();

    assertEquals(
        echoResponseMessage, messageTypes.get("com.google.showcase.v1beta1." + echoResponseName));
  }

  @Test
  void parseMessages_fieldNameConflicts() {
    FileDescriptor bookshopFileDescriptor = BookshopProto.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(bookshopFileDescriptor);
    Message requestMessage = messageTypes.get("com.google.bookshop.v1beta1.GetBookRequest");
    // Check that field names have been changed.
    assertThat(requestMessage.fieldMap()).containsKey("books_count1");
    assertThat(requestMessage.fieldMap()).containsKey("books_list2");
    assertThat(requestMessage.fieldMap()).containsKey("books3");
  }

  @Test
  void parseMethods_basic() {
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Method> methods =
        Parser.parseMethods(
            echoService,
            ECHO_PACKAGE,
            ECHO_PACKAGE,
            messageTypes,
            resourceNames,
            Optional.empty(),
            serviceYamlProtoOpt,
            outputResourceNames,
            Transport.GRPC);

    assertEquals(11, methods.size());

    // Methods should appear in the same order as in the protobuf file.
    Method echoMethod = methods.get(0);
    assertEquals(echoMethod.name(), "Echo");
    assertEquals(echoMethod.stream(), Method.Stream.NONE);
    assertEquals(false, echoMethod.hasAutoPopulatedFields());

    // Detailed method signature parsing tests are in a separate unit test.
    List<List<MethodArgument>> methodSignatures = echoMethod.methodSignatures();
    assertEquals(8, methodSignatures.size());

    Method expandMethod = methods.get(1);
    assertEquals("Expand", expandMethod.name());
    assertEquals(
        TypeNode.withReference(
            VaporReference.builder().setName("ExpandRequest").setPakkage(ECHO_PACKAGE).build()),
        expandMethod.inputType());
    assertEquals(
        TypeNode.withReference(
            VaporReference.builder().setName("EchoResponse").setPakkage(ECHO_PACKAGE).build()),
        expandMethod.outputType());
    assertEquals(Method.Stream.SERVER, expandMethod.stream());
    assertEquals(1, expandMethod.methodSignatures().size());
    assertMethodArgumentEquals(
        "content",
        TypeNode.STRING,
        ImmutableList.of(),
        expandMethod.methodSignatures().get(0).get(0));
    assertMethodArgumentEquals(
        "error",
        TypeNode.withReference(createStatusReference()),
        ImmutableList.of(),
        expandMethod.methodSignatures().get(0).get(1));
    assertEquals(false, expandMethod.hasAutoPopulatedFields());

    Method collectMethod = methods.get(2);
    assertEquals("Collect", collectMethod.name());
    assertEquals(Method.Stream.CLIENT, collectMethod.stream());
    assertEquals(false, collectMethod.hasAutoPopulatedFields());

    Method chatMethod = methods.get(3);
    assertEquals("Chat", chatMethod.name());
    assertEquals(Method.Stream.BIDI, chatMethod.stream());
    assertEquals(false, chatMethod.hasAutoPopulatedFields());
  }

  @Test
  void parseMethods_basicLro() {
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Method> methods =
        Parser.parseMethods(
            echoService,
            ECHO_PACKAGE,
            ECHO_PACKAGE,
            messageTypes,
            resourceNames,
            Optional.empty(),
            Optional.empty(),
            outputResourceNames,
            Transport.GRPC);

    assertEquals(11, methods.size());

    // Methods should appear in the same order as in the protobuf file.
    Method waitMethod = methods.get(7);
    assertEquals("Wait", waitMethod.name());
    assertTrue(waitMethod.hasLro());
    TypeNode waitResponseType = messageTypes.get("com.google.showcase.v1beta1.WaitResponse").type();
    TypeNode waitMetadataType = messageTypes.get("com.google.showcase.v1beta1.WaitMetadata").type();
    assertThat(waitMethod.lro().responseType()).isEqualTo(waitResponseType);
    assertThat(waitMethod.lro().metadataType()).isEqualTo(waitMetadataType);
  }

  @Test
  void parseLro_missingResponseType() {
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    MethodDescriptor waitMethodDescriptor = echoService.getMethods().get(7);
    assertEquals("Wait", waitMethodDescriptor.getName());
    messageTypes.remove("com.google.showcase.v1beta1.WaitResponse");
    assertThrows(
        NullPointerException.class, () -> Parser.parseLro("", waitMethodDescriptor, messageTypes));
  }

  @Test
  void parseLro_missingMetadataType() {
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    MethodDescriptor waitMethodDescriptor = echoService.getMethods().get(7);
    assertEquals("Wait", waitMethodDescriptor.getName());
    messageTypes.remove("com.google.showcase.v1beta1.WaitMetadata");
    assertThrows(
        NullPointerException.class, () -> Parser.parseLro("", waitMethodDescriptor, messageTypes));
  }

  @Test
  void parseMethodSignatures_empty() {
    // TODO(miraleung): Move this to MethodSignatureParserTest.
    MethodDescriptor methodDescriptor = echoService.getMethods().get(5);
    assertEquals("PagedExpand", methodDescriptor.getName());
    TypeNode inputType = TypeParser.parseType(methodDescriptor.getInputType());
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();

    assertThat(
            MethodSignatureParser.parseMethodSignatures(
                methodDescriptor,
                ECHO_PACKAGE,
                inputType,
                messageTypes,
                resourceNames,
                outputResourceNames))
        .isEmpty();
  }

  @Test
  void parseMethodSignatures_validArgstAndEmptyString() {
    // TODO(miraleung): Move this to MethodSignatureParserTest.
    MethodDescriptor methodDescriptor = echoService.getMethods().get(0);
    assertEquals("Echo", methodDescriptor.getName());
    TypeNode inputType = TypeParser.parseType(methodDescriptor.getInputType());
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();

    List<List<MethodArgument>> methodArgs =
        MethodSignatureParser.parseMethodSignatures(
            methodDescriptor,
            ECHO_PACKAGE,
            inputType,
            messageTypes,
            resourceNames,
            outputResourceNames);
    assertEquals(Collections.emptyList(), methodArgs.get(0));
    assertEquals(1, methodArgs.get(1).size());
    assertEquals("parent", methodArgs.get(1).get(0).name());
  }

  @Test
  void parseMethodSignatures_basic() {
    MethodDescriptor echoMethodDescriptor = echoService.getMethods().get(0);
    TypeNode inputType = TypeParser.parseType(echoMethodDescriptor.getInputType());
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();

    List<List<MethodArgument>> methodSignatures =
        MethodSignatureParser.parseMethodSignatures(
            echoMethodDescriptor,
            ECHO_PACKAGE,
            inputType,
            messageTypes,
            resourceNames,
            outputResourceNames);
    assertEquals(8, methodSignatures.size());

    // Signature contents: [].
    List<MethodArgument> methodArgs = methodSignatures.get(0);
    assertEquals(Collections.emptyList(), methodArgs);

    // Signature contents: ["parent"].
    methodArgs = methodSignatures.get(1);
    assertEquals(1, methodArgs.size());
    MethodArgument argument = methodArgs.get(0);
    TypeNode resourceNameType =
        TypeNode.withReference(
            ConcreteReference.withClazz(com.google.api.resourcenames.ResourceName.class));
    assertMethodArgumentEquals("parent", resourceNameType, ImmutableList.of(), argument);

    // Signature contents: ["error"].
    methodArgs = methodSignatures.get(2);
    assertEquals(1, methodArgs.size());
    argument = methodArgs.get(0);
    assertMethodArgumentEquals(
        "error", TypeNode.withReference(createStatusReference()), ImmutableList.of(), argument);

    // Signature contents: ["name"], resource helper variant.
    methodArgs = methodSignatures.get(3);
    assertEquals(1, methodArgs.size());
    argument = methodArgs.get(0);
    TypeNode foobarNameType =
        TypeNode.withReference(
            VaporReference.builder().setName("FoobarName").setPakkage(ECHO_PACKAGE).build());
    assertMethodArgumentEquals("name", foobarNameType, ImmutableList.of(), argument);

    // Signature contents: ["content"].
    methodArgs = methodSignatures.get(4);
    assertEquals(1, methodArgs.size());
    argument = methodArgs.get(0);
    assertMethodArgumentEquals("content", TypeNode.STRING, ImmutableList.of(), argument);

    // Signature contents: ["name"], String variant.
    methodArgs = methodSignatures.get(5);
    assertEquals(1, methodArgs.size());
    argument = methodArgs.get(0);
    assertMethodArgumentEquals("name", TypeNode.STRING, ImmutableList.of(), argument);

    // Signature contents: ["parent"], String variant.
    methodArgs = methodSignatures.get(6);
    assertEquals(1, methodArgs.size());
    argument = methodArgs.get(0);
    assertMethodArgumentEquals("parent", TypeNode.STRING, ImmutableList.of(), argument);

    // Signature contents: ["content", "severity"].
    methodArgs = methodSignatures.get(7);
    assertEquals(2, methodArgs.size());
    argument = methodArgs.get(0);
    assertMethodArgumentEquals("content", TypeNode.STRING, ImmutableList.of(), argument);
    argument = methodArgs.get(1);
    assertMethodArgumentEquals(
        "severity",
        TypeNode.withReference(
            VaporReference.builder().setName("Severity").setPakkage(ECHO_PACKAGE).build()),
        ImmutableList.of(),
        argument);
  }

  @Test
  void parsePageSizeFieldName_basic() {
    MethodDescriptor methodDescriptor = echoService.getMethods().get(5);
    assertEquals("PagedExpand", methodDescriptor.getName());
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    String pageSizeFieldName =
        Parser.parsePageSizeFieldName(methodDescriptor, messageTypes, Transport.GRPC);
    assertEquals("page_size", pageSizeFieldName);
  }

  @Test
  void parsePageSizeFieldName_grpcLegacy() {
    MethodDescriptor methodDescriptor = echoService.getMethods().get(10);
    assertEquals("PagedExpandLegacy", methodDescriptor.getName());
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    String pageSizeFieldName =
        Parser.parsePageSizeFieldName(methodDescriptor, messageTypes, Transport.GRPC);
    assertNull(pageSizeFieldName);
  }

  @Test
  void parsePageSizeFieldName_restLegacy() {
    MethodDescriptor methodDescriptor = echoService.getMethods().get(10);
    assertEquals("PagedExpandLegacy", methodDescriptor.getName());
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    String pageSizeFieldName =
        Parser.parsePageSizeFieldName(methodDescriptor, messageTypes, Transport.REST);
    assertEquals("max_results", pageSizeFieldName);
  }

  @Test
  void parsePageSizeFieldName_bigqueryLegacy() {
    FileDescriptor bqJobFileDescriptor = JobProto.getDescriptor();
    ServiceDescriptor jobService = bqJobFileDescriptor.getServices().get(0);
    MethodDescriptor deleteJobMethodDescriptor = jobService.getMethods().get(0);
    assertEquals("DeleteJob", deleteJobMethodDescriptor.getName());
    MethodDescriptor listJobsMethodDescriptor = jobService.getMethods().get(1);
    assertEquals("ListJobs", listJobsMethodDescriptor.getName());
    Map<String, Message> messageTypes = Parser.parseMessages(bqJobFileDescriptor);
    String pageSizeFieldName =
        Parser.parsePageSizeFieldName(listJobsMethodDescriptor, messageTypes, Transport.GRPC);
    assertEquals("max_results", pageSizeFieldName);
  }

  @Test
  void parseMessagesAndResourceNames_update() {
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(lockerServiceFileDescriptor);

    Message documentMessage = messageTypes.get("com.google.testgapic.v1beta1.Document");
    assertFalse(documentMessage.hasResource());
    Message folderMessage = messageTypes.get("com.google.testgapic.v1beta1.Folder");
    assertFalse(folderMessage.hasResource());

    Map<String, ResourceName> resourceNames =
        ResourceNameParser.parseResourceNames(lockerServiceFileDescriptor);
    messageTypes = Parser.updateResourceNamesInMessages(messageTypes, resourceNames.values());

    documentMessage = messageTypes.get("com.google.testgapic.v1beta1.Document");
    assertTrue(documentMessage.hasResource());
    folderMessage = messageTypes.get("com.google.testgapic.v1beta1.Folder");
    assertFalse(folderMessage.hasResource());
  }

  @Test
  void parseMessages_fieldsHaveResourceReferences() {
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(lockerServiceFileDescriptor);

    // Child type.
    Message message = messageTypes.get("com.google.testgapic.v1beta1.CreateFolderRequest");
    Field field = message.fieldMap().get("parent");
    assertTrue(field.hasResourceReference());
    ResourceReference resourceReference = field.resourceReference();
    assertEquals(
        "cloudresourcemanager.googleapis.com/Folder", resourceReference.resourceTypeString());
    assertTrue(resourceReference.isChildType());

    // Type.
    message = messageTypes.get("com.google.testgapic.v1beta1.GetFolderRequest");
    field = message.fieldMap().get("name");
    assertTrue(field.hasResourceReference());
    resourceReference = field.resourceReference();
    assertEquals(
        "cloudresourcemanager.googleapis.com/Folder", resourceReference.resourceTypeString());
    assertFalse(resourceReference.isChildType());

    // Non-RPC-specific message.
    message = messageTypes.get("com.google.testgapic.v1beta1.Folder");
    field = message.fieldMap().get("name");
    assertTrue(field.hasResourceReference());
    resourceReference = field.resourceReference();
    assertEquals(
        "cloudresourcemanager.googleapis.com/Folder", resourceReference.resourceTypeString());
    assertFalse(resourceReference.isChildType());

    // No explicit resource_reference annotation on the field, and the resource annotation is in the
    // message.
    message = messageTypes.get("com.google.testgapic.v1beta1.Document");
    field = message.fieldMap().get("name");
    assertTrue(field.hasResourceReference());
    resourceReference = field.resourceReference();
    assertEquals("testgapic.googleapis.com/Document", resourceReference.resourceTypeString());
    assertFalse(resourceReference.isChildType());
  }

  @Test
  void parseFields_mapType() {
    FileDescriptor testingFileDescriptor = TestingOuterClass.getDescriptor();
    ServiceDescriptor testingService = testingFileDescriptor.getServices().get(0);
    assertEquals(testingService.getName(), "Testing");

    Map<String, Message> messageTypes = Parser.parseMessages(testingFileDescriptor);
    Message message = messageTypes.get("com.google.showcase.v1beta1.Session");
    Field field = message.fieldMap().get("session_ids_to_descriptor");
    assertEquals(
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Map.class)
                .setGenerics(
                    Arrays.asList(TypeNode.INT_OBJECT.reference(), TypeNode.STRING.reference()))
                .build()),
        field.type());
  }

  @Test
  void parseFields_autoPopulated() {
    Map<String, Message> messageTypes =
        Parser.parseMessages(AutoPopulateFieldTestingOuterClass.getDescriptor());
    Message message =
        messageTypes.get("com.google.auto.populate.field.AutoPopulateFieldTestingEchoRequest");
    Field field = message.fieldMap().get("request_id");
    assertEquals(false, field.isRequired());
    assertEquals(Format.UUID4, field.fieldInfoFormat());
    field = message.fieldMap().get("second_request_id");
    assertEquals(false, field.isRequired());
    assertEquals(Format.UUID4, field.fieldInfoFormat());
    field = message.fieldMap().get("third_request_id");
    assertEquals(false, field.isRequired());
    assertEquals(Format.UUID4, field.fieldInfoFormat());
    field = message.fieldMap().get("fourth_request_id");
    assertEquals(false, field.isRequired());
    assertEquals(Format.IPV4_OR_IPV6, field.fieldInfoFormat());
    field = message.fieldMap().get("fifth_request_id");
    assertEquals(false, field.isRequired());
    assertEquals(Format.UUID4, field.fieldInfoFormat());
    field = message.fieldMap().get("sixth_request_id");
    assertEquals(true, field.isRequired());
    assertEquals(Format.UUID4, field.fieldInfoFormat());

    message =
        messageTypes.get("com.google.auto.populate.field.AutoPopulateFieldTestingExpandRequest");
    field = message.fieldMap().get("request_id");
    assertEquals(false, field.isRequired());
    assertEquals(Format.UUID4, field.fieldInfoFormat());
  }

  @Test
  void parseAutoPopulatedMethodsAndFields_exists() {
    String yamlFilename = "auto_populate_field_testing.yaml";
    Path yamlPath = Paths.get(YAML_DIRECTORY, yamlFilename);
    Map<String, List<String>> autoPopulatedMethodsWithFields =
        Parser.parseAutoPopulatedMethodsAndFields(ServiceYamlParser.parse(yamlPath.toString()));

    assertEquals(
        true,
        autoPopulatedMethodsWithFields.containsKey(
            "google.auto.populate.field.AutoPopulateFieldTesting.AutoPopulateFieldTestingEcho"));
    assertEquals(
        Arrays.asList(
            "request_id",
            "second_request_id",
            "third_request_id",
            "fourth_request_id",
            "non_existent_field"),
        autoPopulatedMethodsWithFields.get(
            "google.auto.populate.field.AutoPopulateFieldTesting.AutoPopulateFieldTestingEcho"));
  }

  @Test
  void parseAutoPopulatedMethodsAndFields_doesNotExist() {
    String yamlFilename = "logging.yaml";
    Path yamlPath = Paths.get(YAML_DIRECTORY, yamlFilename);
    Optional<Service> serviceYamlProtoOpt_Null = ServiceYamlParser.parse(yamlPath.toString());

    Map<String, List<String>> autoPopulatedMethodsWithFields =
        Parser.parseAutoPopulatedMethodsAndFields(serviceYamlProtoOpt_Null);
    assertEquals(true, autoPopulatedMethodsWithFields.isEmpty());
  }

  @Test
  void parseAutoPopulatedMethodsAndFields_returnsEmptyMapIfServiceYamlIsNull() {
    assertEquals(true, Parser.parseAutoPopulatedMethodsAndFields(Optional.empty()).isEmpty());
  }

  @Test
  void parseAutoPopulatedMethodsAndFields_returnsMapOfMethodsAndAutoPopulatedFields() {
    MethodSettings testMethodSettings =
        MethodSettings.newBuilder()
            .setSelector("test_method")
            .addAutoPopulatedFields("test_field")
            .addAutoPopulatedFields("test_field_2")
            .build();
    MethodSettings testMethodSettings2 =
        MethodSettings.newBuilder()
            .setSelector("test_method_2")
            .addAutoPopulatedFields("test_field_3")
            .build();
    MethodSettings testMethodSettings3 =
        MethodSettings.newBuilder().setSelector("test_method_3").build();
    Publishing testPublishing =
        Publishing.newBuilder()
            .addMethodSettings(testMethodSettings)
            .addMethodSettings(testMethodSettings2)
            .addMethodSettings(testMethodSettings3)
            .build();
    Optional<Service> testService =
        Optional.of(Service.newBuilder().setPublishing(testPublishing).build());
    Truth.assertThat(Parser.parseAutoPopulatedMethodsAndFields(testService).get("test_method"))
        .containsExactly("test_field", "test_field_2");
    Truth.assertThat(Parser.parseAutoPopulatedMethodsAndFields(testService).get("test_method_2"))
        .containsExactly("test_field_3");
    Truth.assertThat(Parser.parseAutoPopulatedMethodsAndFields(testService).get("test_method_3"))
        .isEmpty();
    Truth.assertThat(
            Parser.parseAutoPopulatedMethodsAndFields(testService).containsKey("test_method_4"))
        .isEqualTo(false);
  }

  @Test
  void hasMethodSettings_shouldReturnFalseIfServiceYamlDoesNotExist() {
    assertEquals(false, Parser.hasMethodSettings(Optional.empty()));
  }

  @Test
  void hasMethodSettings_shouldReturnFalseIfServiceYamlDoesNotHavePublishing() {
    assertEquals(false, Parser.hasMethodSettings(Optional.of(Service.newBuilder().build())));
  }

  @Test
  void hasMethodSettings_shouldReturnTrueIfServiceYamlHasNonEmptyMethodSettings() {
    MethodSettings testMethodSettings =
        MethodSettings.newBuilder().setSelector("test_method").build();
    Publishing testPublishing =
        Publishing.newBuilder().addMethodSettings(testMethodSettings).build();
    assertEquals(
        true,
        Parser.hasMethodSettings(
            Optional.of(Service.newBuilder().setPublishing(testPublishing).build())));
  }

  @Test
  void parseResourceNames_inputTypeHasReferenceNotInMethodSignature() {
    FileDescriptor testingFileDescriptor = TestingOuterClass.getDescriptor();
    ServiceDescriptor testingService = testingFileDescriptor.getServices().get(0);
    assertEquals(testingService.getName(), "Testing");

    Map<String, Message> messageTypes = Parser.parseMessages(testingFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(testingFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    Parser.parseService(
        testingFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);

    assertEquals(2, outputResourceNames.size());

    ResourceName resname = resourceNames.get("showcase.googleapis.com/Session");
    assertThat(outputResourceNames).contains(resname);

    resname = resourceNames.get("showcase.googleapis.com/Test");
    assertThat(outputResourceNames).contains(resname);
  }

  @Test
  void sanitizeDefaultHost_basic() {
    String defaultHost = "localhost:1234";
    assertEquals(defaultHost, Parser.sanitizeDefaultHost(defaultHost));

    defaultHost = "logging.googleapis.com";
    assertEquals(String.format("%s:443", defaultHost), Parser.sanitizeDefaultHost(defaultHost));
  }

  @Test
  void parseNestedProtoTypeName() {
    assertEquals("MutateJobMetadata", Parser.parseNestedProtoTypeName("MutateJobMetadata"));
    assertEquals(
        "MutateJob.MutateJobMetadata",
        Parser.parseNestedProtoTypeName("MutateJob.MutateJobMetadata"));
    assertEquals(
        "MutateJob.MutateJobMetadata",
        Parser.parseNestedProtoTypeName(
            "google.ads.googleads.v3.resources.MutateJob.MutateJobMetadata"));
  }

  @Test
  void testParse_noServices_returnsEmptyGapicContext() {
    GapicContext result = Parser.parse(CodeGeneratorRequest.newBuilder().build());
    assertEquals(GapicContext.EMPTY, result);
  }

  @Test
  void testParseServiceJavaPackage_emptyRequest_noop() {
    assertThat(Parser.parseServiceJavaPackage(CodeGeneratorRequest.newBuilder().build())).isEmpty();
  }

  @Test
  void parseServiceApiVersionTest() {
    FileDescriptor apiVersionFileDescriptor = ApiVersionTestingOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(apiVersionFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(apiVersionFileDescriptor);
    List<com.google.api.generator.gapic.model.Service> services =
        Parser.parseService(
            apiVersionFileDescriptor,
            messageTypes,
            resourceNames,
            Optional.empty(),
            new HashSet<>());
    com.google.api.generator.gapic.model.Service parsedEchoService = services.get(0);

    assertEquals("EchoWithVersion", parsedEchoService.overriddenName());
    assertTrue(parsedEchoService.hasApiVersion());
    assertEquals("fake_version", parsedEchoService.apiVersion());
  }

  @Test
  void parseServiceWithoutApiVersionTest() {
    FileDescriptor apiVersionFileDescriptor = ApiVersionTestingOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(apiVersionFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(apiVersionFileDescriptor);
    List<com.google.api.generator.gapic.model.Service> services =
        Parser.parseService(
            apiVersionFileDescriptor,
            messageTypes,
            resourceNames,
            Optional.empty(),
            new HashSet<>());
    com.google.api.generator.gapic.model.Service parsedEchoWithoutVersionService = services.get(1);

    assertNull(parsedEchoWithoutVersionService.apiVersion());
    assertFalse(parsedEchoWithoutVersionService.hasApiVersion());
    assertEquals("EchoWithoutVersion", parsedEchoWithoutVersionService.overriddenName());
  }

  @Test
  void parseServiceWithEmptyApiVersionTest() {
    FileDescriptor apiVersionFileDescriptor = ApiVersionTestingOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(apiVersionFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(apiVersionFileDescriptor);
    List<com.google.api.generator.gapic.model.Service> services =
        Parser.parseService(
            apiVersionFileDescriptor,
            messageTypes,
            resourceNames,
            Optional.empty(),
            new HashSet<>());
    com.google.api.generator.gapic.model.Service parsedEchoWithEmptyVersionService =
        services.get(2);

    assertEquals("EchoWithEmptyVersion", parsedEchoWithEmptyVersionService.overriddenName());
    assertEquals("", parsedEchoWithEmptyVersionService.apiVersion());
    assertFalse(parsedEchoWithEmptyVersionService.hasApiVersion());
  }

  @Test
  void testServiceWithoutApiVersionParsed() {
    FileDescriptor bookshopFileDescriptor = BookshopProto.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(bookshopFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(bookshopFileDescriptor);
    List<com.google.api.generator.gapic.model.Service> services =
        Parser.parseService(
            bookshopFileDescriptor, messageTypes, resourceNames, Optional.empty(), new HashSet<>());
    com.google.api.generator.gapic.model.Service parsedBookshopService = services.get(0);
    assertNull(parsedBookshopService.apiVersion());
  }

  @Test
  void parseServiceWithNoMethodsTest() {
    FileDescriptor fileDescriptor =
        com.google.api.service.without.methods.test.ServiceWithNoMethodsOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(fileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(fileDescriptor);
    List<com.google.api.generator.gapic.model.Service> services =
        Parser.parseService(
            fileDescriptor, messageTypes, resourceNames, Optional.empty(), new HashSet<>());
    assertEquals(1, services.size());
    assertEquals("EchoWithMethods", services.get(0).overriddenName());
  }

  @Test
  void selectiveGenerationTest_shouldExcludeUnusedResourceNames() {
    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(fileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(fileDescriptor);

    String serviceYamlFilename = "selective_api_generation_v1beta1.yaml";
    String testFilesDirectory = "src/test/resources/";
    Path serviceYamlPath = Paths.get(testFilesDirectory, serviceYamlFilename);
    Optional<com.google.api.Service> serviceYamlOpt =
        ServiceYamlParser.parse(serviceYamlPath.toString());
    Assert.assertTrue(serviceYamlOpt.isPresent());

    Set<ResourceName> helperResourceNames = new HashSet<>();
    Parser.parseService(
        fileDescriptor, messageTypes, resourceNames, serviceYamlOpt, helperResourceNames);
    // resource Name Foobarbaz is not present
    assertEquals(2, helperResourceNames.size());
    assertTrue(
        helperResourceNames.stream()
            .map(ResourceName::variableName)
            .collect(Collectors.toSet())
            .containsAll(ImmutableList.of("foobar", "anythingGoes")));
  }

  @Test
  void selectiveGenerationTest_shouldGenerateOnlySelectiveMethodsWithGenerateOmittedFalse() {
    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(fileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(fileDescriptor);

    // test with service yaml file to show usage of this feature, test itself
    // can be done without this file and build a Service object from code.
    String serviceYamlFilename = "selective_api_generation_v1beta1.yaml";
    String testFilesDirectory = "src/test/resources/";
    Path serviceYamlPath = Paths.get(testFilesDirectory, serviceYamlFilename);
    Optional<com.google.api.Service> serviceYamlOpt =
        ServiceYamlParser.parse(serviceYamlPath.toString());
    Assert.assertTrue(serviceYamlOpt.isPresent());

    List<com.google.api.generator.gapic.model.Service> services =
        Parser.parseService(
            fileDescriptor, messageTypes, resourceNames, serviceYamlOpt, new HashSet<>());
    assertEquals(1, services.size());
    assertEquals("EchoServiceShouldGeneratePartialUsual", services.get(0).overriddenName());
    assertEquals(3, services.get(0).methods().size());
    for (Method method : services.get(0).methods()) {
      assertTrue(method.name().contains("ShouldGenerate"));
      assertFalse(method.isInternalApi());
    }
  }

  @Test
  void selectiveGenerationTest_shouldGenerateOmittedAsInternalWithGenerateOmittedTrue() {
    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(fileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(fileDescriptor);

    // test with service yaml file to show usage of this feature, test itself
    // can be done without this file and build a Service object from code.
    String serviceYamlFilename = "selective_api_generation_generate_omitted_v1beta1.yaml";
    String testFilesDirectory = "src/test/resources/";
    Path serviceYamlPath = Paths.get(testFilesDirectory, serviceYamlFilename);
    Optional<com.google.api.Service> serviceYamlOpt =
        ServiceYamlParser.parse(serviceYamlPath.toString());
    Assert.assertTrue(serviceYamlOpt.isPresent());

    List<com.google.api.generator.gapic.model.Service> services =
        Parser.parseService(
            fileDescriptor, messageTypes, resourceNames, serviceYamlOpt, new HashSet<>());

    assertEquals(3, services.size());
    // Tests a service with public methods only.
    assertEquals("EchoServiceShouldGenerateAllAsUsual", services.get(0).overriddenName());
    assertEquals(3, services.get(0).methods().size());
    for (Method method : services.get(0).methods()) {
      assertFalse(method.isInternalApi());
    }

    // Tests a service with partial public methods and partial internal methods.
    assertEquals("EchoServiceShouldGeneratePartialUsual", services.get(1).overriddenName());
    assertEquals(5, services.get(1).methods().size());
    for (Method method : services.get(1).methods()) {
      if (method.name().contains("ShouldGenerateAsUsual")) {
        assertFalse(method.isInternalApi());
      } else {
        assertTrue(method.isInternalApi());
      }
    }
    // Tests a service with internal methods only.
    assertEquals("EchoServiceShouldGenerateAllInternal", services.get(2).overriddenName());
    assertEquals(2, services.get(2).methods().size());
    for (Method method : services.get(2).methods()) {
      assertTrue(method.isInternalApi());
    }
  }

  @Test
  void selectiveGenerationTest_shouldGenerateAsPublicIfNoPublishingSectionInServiceYaml() {
    Service service =
        Service.newBuilder()
            .setTitle("Selective generation testing with no publishing section")
            .build();
    Publishing publishing = service.getPublishing();
    Assert.assertEquals(0, publishing.getLibrarySettingsCount());

    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    List<MethodDescriptor> methods = fileDescriptor.getServices().get(0).getMethods();
    String protoPackage = "google.selective.generate.v1beta1";

    assertEquals(
        Parser.getMethodSelectiveGapicType(methods.get(0), Optional.of(service), protoPackage),
        SelectiveGapicType.PUBLIC);
  }

  @Test
  void selectiveGenerationTest_shouldGenerateAsPublicWhenProtoPackageMismatch() {
    String protoPackage = "google.selective.generate.v1beta1";

    // situation where service yaml has different version stated
    ClientLibrarySettings clientLibrarySettings =
        ClientLibrarySettings.newBuilder().setVersion("google.selective.generate.v1").build();
    Publishing publishing =
        Publishing.newBuilder().addLibrarySettings(clientLibrarySettings).build();
    Service service =
        Service.newBuilder()
            .setTitle(
                "Selective generation test when proto package "
                    + "does not match library_settings version from service yaml")
            .setPublishing(publishing)
            .build();

    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    List<MethodDescriptor> methods = fileDescriptor.getServices().get(0).getMethods();

    assertEquals(
        Parser.getMethodSelectiveGapicType(methods.get(0), Optional.of(service), protoPackage),
        SelectiveGapicType.PUBLIC);
  }

  @Test
  void selectiveGenerationTest_shouldGenerateAsPublicIfNoJavaSectionInServiceYaml() {
    String protoPackage = "google.selective.generate.v1beta1";

    // situation where service yaml has other language settings but no
    // java settings in library_settings.
    ClientLibrarySettings clientLibrarySettings =
        ClientLibrarySettings.newBuilder()
            .setVersion(protoPackage)
            .setPythonSettings(PythonSettings.newBuilder().build())
            .build();
    Publishing publishing =
        Publishing.newBuilder().addLibrarySettings(clientLibrarySettings).build();
    Service service =
        Service.newBuilder()
            .setTitle(
                "Selective generation test when no java section in "
                    + "library_settings from service yaml")
            .setPublishing(publishing)
            .build();

    Assert.assertEquals(1, publishing.getLibrarySettingsCount());

    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    List<MethodDescriptor> methods = fileDescriptor.getServices().get(0).getMethods();

    assertEquals(
        Parser.getMethodSelectiveGapicType(methods.get(0), Optional.of(service), protoPackage),
        SelectiveGapicType.PUBLIC);
  }

  @Test
  void selectiveGenerationTest_shouldGenerateAsPublicIfMethodInList() {
    String protoPackage = "google.selective.generate.v1beta1";
    String methodsAllowList =
        "google.selective.generate.v1beta1.EchoServiceShouldGeneratePartialUsual.EchoShouldGenerateAsUsual";
    Service service =
        createServiceWithSelectiveGapicConfiguration(protoPackage, methodsAllowList, true);

    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    // methodToGenerate from fileDescriptor:
    // google.selective.generate.v1beta1.EchoServiceShouldGeneratePartialUsual.EchoShouldGenerateAsUsual
    MethodDescriptor methodToGenerate = fileDescriptor.getServices().get(1).getMethods().get(0);

    assertEquals(
        Parser.getMethodSelectiveGapicType(methodToGenerate, Optional.of(service), protoPackage),
        SelectiveGapicType.PUBLIC);
  }

  @Test
  void selectiveGenerationTest_shouldGenerateAsInternalIfMethodNotInListWithGenerateOmittedTrue() {
    String protoPackage = "google.selective.generate.v1beta1";
    String methodsAllowList =
        "google.selective.generate.v1beta1.EchoServiceShouldGeneratePartialUsual.EchoShouldGenerateAsUsual";
    Service service =
        createServiceWithSelectiveGapicConfiguration(protoPackage, methodsAllowList, true);

    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    // methodToGenerate from fileDescriptor:
    // google.selective.generate.v1beta1.EchoServiceShouldGeneratePartialUsual.ChatShouldGenerateAsInternal
    MethodDescriptor methodToGenerate = fileDescriptor.getServices().get(1).getMethods().get(3);

    assertEquals(
        Parser.getMethodSelectiveGapicType(methodToGenerate, Optional.of(service), protoPackage),
        SelectiveGapicType.INTERNAL);
  }

  @Test
  void selectiveGenerationTest_shouldGenerateAsHiddenIfMethodNotInListWithGenerateOmittedFalse() {
    String protoPackage = "google.selective.generate.v1beta1";
    String methodsAllowList =
        "google.selective.generate.v1beta1.EchoServiceShouldGeneratePartialUsual.EchoShouldGenerateAsUsual";
    Service service =
        createServiceWithSelectiveGapicConfiguration(protoPackage, methodsAllowList, false);

    FileDescriptor fileDescriptor = SelectiveApiGenerationOuterClass.getDescriptor();
    // methodToGenerate from fileDescriptor:
    // google.selective.generate.v1beta1.EchoServiceShouldGeneratePartialUsual.ChatShouldGenerateAsInternal
    MethodDescriptor methodToGenerate = fileDescriptor.getServices().get(1).getMethods().get(3);

    assertEquals(
        Parser.getMethodSelectiveGapicType(methodToGenerate, Optional.of(service), protoPackage),
        SelectiveGapicType.HIDDEN);
  }

  private void assertMethodArgumentEquals(
      String name, TypeNode type, List<TypeNode> nestedFields, MethodArgument argument) {
    assertEquals(name, argument.name());
    assertEquals(type, argument.type());
    assertEquals(nestedFields, argument.nestedFields());
  }

  private static Reference createStatusReference() {
    return VaporReference.builder().setName("Status").setPakkage("com.google.rpc").build();
  }

  private static Service createServiceWithSelectiveGapicConfiguration(
      String protoPackage, String methodsAllowList, boolean generateOmittedAsInternal) {
    // Create a service with method allow-list and generateOmittedAsInternal flag.
    JavaSettings java_settings =
        JavaSettings.newBuilder()
            .setLibraryPackage("com.google.foobar.v1")
            .putServiceClassNames("com.google.foo.v1.BarService", "BazService")
            .setCommon(
                CommonLanguageSettings.newBuilder()
                    .setSelectiveGapicGeneration(
                        SelectiveGapicGeneration.newBuilder()
                            .addMethods(methodsAllowList)
                            .setGenerateOmittedAsInternal(generateOmittedAsInternal)))
            .build();
    ClientLibrarySettings clientLibrarySettings =
        ClientLibrarySettings.newBuilder()
            .setVersion(protoPackage)
            .setJavaSettings(java_settings)
            .build();
    Publishing publishing =
        Publishing.newBuilder().addLibrarySettings(clientLibrarySettings).build();
    Service service =
        Service.newBuilder()
            .setTitle("Selective generation test")
            .setPublishing(publishing)
            .build();
    return service;
  }
}

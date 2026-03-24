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

package com.google.api.generator.gapic.composer.resourcename;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.protoparser.Parser;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.framework.GoldenFileWriter;
import com.google.api.generator.test.protoloader.TestProtoLoader;
import com.google.logging.v2.LogEntryProto;
import com.google.logging.v2.LoggingConfigProto;
import com.google.logging.v2.LoggingMetricsProto;
import com.google.logging.v2.LoggingProto;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.EmptyProto;
import com.google.showcase.v1beta1.EchoOuterClass;
import com.google.showcase.v1beta1.TestingOuterClass;
import com.google.test.collisions.CollisionsOuterClass;
import google.cloud.CommonResources;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResourceNameHelperClassComposerTest {

  private final String COLLIDING_RESOURCE_NAME_KEY = "config.googleapis.com/Resource";

  private ServiceDescriptor echoService;
  private FileDescriptor echoFileDescriptor;

  @BeforeEach
  void setUp() {
    echoFileDescriptor = EchoOuterClass.getDescriptor();
    echoService = echoFileDescriptor.getServices().get(0);
    assertEquals(echoService.getName(), "Echo");
  }

  @Test
  void getTokenSet_basic() {
    List<String> patterns =
        Arrays.asList(
            "projects/{project}/agent/sessions/{session}",
            "projects/{project}/agent/environments/{environment}/users/{user}/sessions/{session}");
    List<List<String>> tokenHierarchies = ResourceNameTokenizer.parseTokenHierarchy(patterns);

    Set<String> tokenSet = ResourceNameHelperClassComposer.getTokenSet(tokenHierarchies);
    assertEquals(
        tokenSet,
        Stream.of("project", "session", "environment", "user").collect(Collectors.toSet()));
  }

  @Test
  void concatToUpperSnakeCaseName_basic() {
    assertEquals(
        "PROJECT_LOCATION_AUTOSCALING_POLICY",
        ResourceNameHelperClassComposer.concatToUpperSnakeCaseName(
            Arrays.asList("project", "location", "autoscaling_policy")));
  }

  @Test
  void concatToUpperCamelCaseName_basic() {
    assertEquals(
        "ProjectLocationAutoscalingPolicy",
        ResourceNameHelperClassComposer.concatToUpperCamelCaseName(
            Arrays.asList("project", "location", "autoscaling_policy")));
  }

  @Test
  void generateResourceNameClass_echoFoobarMultiplePatterns() {
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    Parser.parseService(
        echoFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);

    ResourceName foobarResname = resourceNames.get("showcase.googleapis.com/Foobar");
    assertThat(outputResourceNames).contains(foobarResname);

    GapicClass clazz =
        ResourceNameHelperClassComposer.instance()
            .generate(foobarResname, TestProtoLoader.instance().parseShowcaseEcho());

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(this.getClass(), "FoobarName.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(GoldenFileWriter.getGoldenDir(this.getClass()), "FoobarName.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void generateResourceNameClass_loggingOnePatternMultipleVariables() {
    FileDescriptor serviceFileDescriptor = LoggingConfigProto.getDescriptor();
    ServiceDescriptor serviceDescriptor = serviceFileDescriptor.getServices().get(0);
    assertEquals(serviceDescriptor.getName(), "ConfigServiceV2");

    List<FileDescriptor> protoFiles =
        Arrays.asList(
            serviceFileDescriptor,
            LoggingProto.getDescriptor(),
            LogEntryProto.getDescriptor(),
            LoggingConfigProto.getDescriptor(),
            LoggingMetricsProto.getDescriptor());

    Map<String, ResourceName> resourceNames = new HashMap<>();
    Map<String, Message> messageTypes = new HashMap<>();
    for (FileDescriptor fileDescriptor : protoFiles) {
      resourceNames.putAll(Parser.parseResourceNames(fileDescriptor));
      messageTypes.putAll(Parser.parseMessages(fileDescriptor));
    }

    // Additional resource names.
    FileDescriptor commonResourcesFileDescriptor = CommonResources.getDescriptor();
    resourceNames.putAll(Parser.parseResourceNames(commonResourcesFileDescriptor));

    // Additional dependency found in LoggingService.DeleteLink LRO
    // (google.longrunning.operation_info).response_type. Necessary for
    // complete parsing of the descriptors.
    FileDescriptor emptyFileDescriptor = EmptyProto.getDescriptor();
    messageTypes.putAll(Parser.parseMessages(emptyFileDescriptor));

    Set<ResourceName> outputResourceNames = new HashSet<>();
    Parser.parseService(
        serviceFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);

    ResourceName billingAccountLocationResname =
        resourceNames.get("logging.googleapis.com/BillingAccountLocation");
    assertThat(outputResourceNames).contains(billingAccountLocationResname);

    GapicClass clazz =
        ResourceNameHelperClassComposer.instance()
            .generate(billingAccountLocationResname, TestProtoLoader.instance().parseLogging());

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(
        this.getClass(), "BillingAccountLocationName.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(
            GoldenFileWriter.getGoldenDir(this.getClass()), "BillingAccountLocationName.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void generateResourceNameClass_testingSessionOnePattern() {
    FileDescriptor testingFileDescriptor = TestingOuterClass.getDescriptor();
    ServiceDescriptor testingService = testingFileDescriptor.getServices().get(0);
    assertEquals(testingService.getName(), "Testing");

    Map<String, Message> messageTypes = Parser.parseMessages(testingFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(testingFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    Parser.parseService(
        testingFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);

    ResourceName sessionResname = resourceNames.get("showcase.googleapis.com/Session");
    assertThat(outputResourceNames).contains(sessionResname);

    GapicClass clazz =
        ResourceNameHelperClassComposer.instance()
            .generate(sessionResname, TestProtoLoader.instance().parseShowcaseTesting());

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(this.getClass(), "SessionName.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(GoldenFileWriter.getGoldenDir(this.getClass()), "SessionName.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void generateResourceNameClass_testingBlueprintPatternWithNonSlashSeparator() {
    FileDescriptor testingFileDescriptor = TestingOuterClass.getDescriptor();
    ServiceDescriptor testingService = testingFileDescriptor.getServices().get(0);
    assertEquals(testingService.getName(), "Testing");

    Map<String, Message> messageTypes = Parser.parseMessages(testingFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(testingFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    Parser.parseService(
        testingFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);

    ResourceName testResname = resourceNames.get("showcase.googleapis.com/Test");
    assertThat(outputResourceNames).contains(testResname);

    GapicClass clazz =
        ResourceNameHelperClassComposer.instance()
            .generate(testResname, TestProtoLoader.instance().parseShowcaseTesting());

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(this.getClass(), "TestName.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(GoldenFileWriter.getGoldenDir(this.getClass()), "TestName.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void generateResourceNameClass_childSingleton() {
    ResourceName agentResname =
        ResourceName.builder()
            .setVariableName("agent")
            .setPakkage("com.google.cloud.dialogflow.v2beta1")
            .setResourceTypeString("dialogflow.googleapis.com/Agent")
            .setPatterns(
                Arrays.asList(
                    "projects/{project}/locations/{location}/agent", "projects/{project}/agent"))
            .setParentMessageName("Agent")
            .setDescription("This is a description")
            .build();

    GapicContext irrelevantContext = TestProtoLoader.instance().parseShowcaseEcho();
    GapicClass clazz =
        ResourceNameHelperClassComposer.instance().generate(agentResname, irrelevantContext);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(this.getClass(), "AgentName.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(GoldenFileWriter.getGoldenDir(this.getClass()), "AgentName.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void generateResourceNameClass_resourceNameCollisionIsAvoided() {
    ResourceName collidingResourceName =
        Parser.parseResourceNames(CollisionsOuterClass.getDescriptor())
            .get(COLLIDING_RESOURCE_NAME_KEY);

    GapicContext irrelevantContext = TestProtoLoader.instance().parseShowcaseEcho();
    GapicClass clazz =
        ResourceNameHelperClassComposer.instance()
            .generate(collidingResourceName, irrelevantContext);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(
        this.getClass(), "CollisionResourceName.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(GoldenFileWriter.getGoldenDir(this.getClass()), "CollisionResourceName.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());

    assertEquals(1, clazz.classDefinition().implementsTypes().size());
    assertTrue(clazz.classDefinition().implementsTypes().get(0).reference().useFullName());
    assertEquals(
        clazz.classDefinition().classIdentifier().name(),
        clazz.classDefinition().implementsTypes().get(0).reference().name());
  }
}

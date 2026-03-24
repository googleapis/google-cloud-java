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

package com.google.api.generator.gapic.composer.common;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.StatusCode;
import com.google.api.generator.engine.ast.BlockStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.composer.grpc.GrpcContext;
import com.google.api.generator.gapic.model.GapicBatchingSettings;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicServiceConfig;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.protoparser.BatchingSettingsConfigParser;
import com.google.api.generator.gapic.protoparser.Parser;
import com.google.api.generator.gapic.protoparser.ServiceConfigParser;
import com.google.api.generator.test.protoloader.TestProtoLoader;
import com.google.api.generator.test.utils.LineFormatter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.showcase.v1beta1.EchoOuterClass;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RetrySettingsComposerTest {
  private static final VariableExpr RETRY_PARAM_DEFINITIONS_VAR_EXPR =
      createRetryParamDefinitionsVarExpr();
  private static final VariableExpr RETRY_CODES_DEFINITIONS_VAR_EXPR =
      createRetryableCodesDefinitionsVarExpr();

  private JavaWriterVisitor writerVisitor;

  @BeforeEach
  void setUp() {
    writerVisitor = new JavaWriterVisitor();
  }

  @Test
  void paramDefinitionsBlock_noConfigsFound() {
    GapicContext context = TestProtoLoader.instance().parseShowcaseEcho();
    Service service = context.services().get(0);

    String jsonFilename = "retrying_grpc_service_config.json";
    Path jsonPath = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> serviceConfigOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertTrue(serviceConfigOpt.isPresent());
    GapicServiceConfig serviceConfig = serviceConfigOpt.get();

    BlockStatement paramDefinitionsBlock =
        RetrySettingsComposer.createRetryParamDefinitionsBlock(
            service, serviceConfig, RETRY_PARAM_DEFINITIONS_VAR_EXPR);

    paramDefinitionsBlock.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "static {\n",
            "ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();\n",
            "RetrySettings settings = null;\n",
            "settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();\n",
            "definitions.put(\"no_retry_params\", settings);\n",
            "RETRY_PARAM_DEFINITIONS = definitions.build();\n",
            "}\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void paramDefinitionsBlock_basic() {
    GapicContext context = TestProtoLoader.instance().parseShowcaseEcho();
    Service service = context.services().get(0);

    String jsonFilename = "showcase_grpc_service_config.json";
    Path jsonPath = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> serviceConfigOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertTrue(serviceConfigOpt.isPresent());
    GapicServiceConfig serviceConfig = serviceConfigOpt.get();

    BlockStatement paramDefinitionsBlock =
        RetrySettingsComposer.createRetryParamDefinitionsBlock(
            service, serviceConfig, RETRY_PARAM_DEFINITIONS_VAR_EXPR);

    paramDefinitionsBlock.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "static {\n",
            "ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();\n",
            "RetrySettings settings = null;\n",
            "settings ="
                + " RetrySettings.newBuilder().setInitialRetryDelayDuration("
                + "Duration.ofMillis(100L)).setRetryDelayMultiplier(2.0)"
                + ".setMaxRetryDelayDuration(Duration.ofMillis(3000L))"
                + ".setInitialRpcTimeoutDuration(Duration.ofMillis(10000L))"
                + ".setRpcTimeoutMultiplier(1.0)"
                + ".setMaxRpcTimeoutDuration(Duration.ofMillis(10000L))"
                + ".setTotalTimeoutDuration(Duration.ofMillis(10000L)).build();\n",
            "definitions.put(\"retry_policy_1_params\", settings);\n",
            "settings ="
                + " RetrySettings.newBuilder()"
                + ".setInitialRpcTimeoutDuration(Duration.ofMillis(5000L))"
                + ".setRpcTimeoutMultiplier(1.0)"
                + ".setMaxRpcTimeoutDuration(Duration.ofMillis(5000L))"
                + ".setTotalTimeoutDuration(Duration.ofMillis(5000L)).build();\n",
            "definitions.put(\"no_retry_0_params\", settings);\n",
            "RETRY_PARAM_DEFINITIONS = definitions.build();\n",
            "}\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void codesDefinitionsBlock_noConfigsFound() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            echoFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);
    assertEquals(1, services.size());

    Service service = services.get(0);

    String jsonFilename = "retrying_grpc_service_config.json";
    Path jsonPath = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> serviceConfigOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertTrue(serviceConfigOpt.isPresent());
    GapicServiceConfig serviceConfig = serviceConfigOpt.get();

    BlockStatement paramDefinitionsBlock =
        RetrySettingsComposer.createRetryCodesDefinitionsBlock(
            service, serviceConfig, RETRY_CODES_DEFINITIONS_VAR_EXPR);

    paramDefinitionsBlock.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "static {\n",
            "ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions ="
                + " ImmutableMap.builder();\n",
            "definitions.put(\"no_retry_codes\","
                + " ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));\n",
            "RETRYABLE_CODE_DEFINITIONS = definitions.build();\n",
            "}\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void codesDefinitionsBlock_basic() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            echoFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);
    assertEquals(1, services.size());

    Service service = services.get(0);

    String jsonFilename = "showcase_grpc_service_config.json";
    Path jsonPath = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> serviceConfigOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertTrue(serviceConfigOpt.isPresent());
    GapicServiceConfig serviceConfig = serviceConfigOpt.get();

    BlockStatement paramDefinitionsBlock =
        RetrySettingsComposer.createRetryCodesDefinitionsBlock(
            service, serviceConfig, RETRY_CODES_DEFINITIONS_VAR_EXPR);

    paramDefinitionsBlock.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "static {\n",
            "ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions ="
                + " ImmutableMap.builder();\n",
            "definitions.put(\"retry_policy_1_codes\","
                + " ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE,"
                + " StatusCode.Code.UNKNOWN)));\n",
            "definitions.put(\"no_retry_0_codes\","
                + " ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));\n",
            "RETRYABLE_CODE_DEFINITIONS = definitions.build();\n",
            "}\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void simpleBuilderExpr_basic() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            echoFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);
    assertEquals(1, services.size());

    Service service = services.get(0);

    String jsonFilename = "showcase_grpc_service_config.json";
    Path jsonPath = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> serviceConfigOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertTrue(serviceConfigOpt.isPresent());
    GapicServiceConfig serviceConfig = serviceConfigOpt.get();

    // Regular method.
    Method echoMethod = findMethod(service, "Echo");
    assertThat(echoMethod).isNotNull();

    VariableExpr builderVarExpr = createBuilderVarExpr(service);
    Expr builderExpr =
        RetrySettingsComposer.createSimpleBuilderSettingsExpr(
            service,
            serviceConfig,
            echoMethod,
            builderVarExpr,
            RETRY_CODES_DEFINITIONS_VAR_EXPR,
            RETRY_PARAM_DEFINITIONS_VAR_EXPR);
    builderExpr.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "builder.echoSettings()"
                + ".setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get(\"retry_policy_1_codes\"))"
                + ".setRetrySettings(RETRY_PARAM_DEFINITIONS.get(\"retry_policy_1_params\"))");
    assertEquals(expected, writerVisitor.write());

    // Server-streaming method.
    Method expandMethod = findMethod(service, "Expand");
    assertThat(expandMethod).isNotNull();
    builderExpr =
        RetrySettingsComposer.createSimpleBuilderSettingsExpr(
            service,
            serviceConfig,
            expandMethod,
            builderVarExpr,
            RETRY_CODES_DEFINITIONS_VAR_EXPR,
            RETRY_PARAM_DEFINITIONS_VAR_EXPR);
    writerVisitor.clear();
    builderExpr.accept(writerVisitor);
    expected =
        LineFormatter.lines(
            "builder.expandSettings()"
                + ".setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get(\"retry_policy_1_codes\"))"
                + ".setRetrySettings(RETRY_PARAM_DEFINITIONS.get(\"retry_policy_1_params\"))");
    assertEquals(expected, writerVisitor.write());

    // LRO method.
    Method waitMethod = findMethod(service, "Wait");
    assertThat(waitMethod).isNotNull();
    builderExpr =
        RetrySettingsComposer.createSimpleBuilderSettingsExpr(
            service,
            serviceConfig,
            waitMethod,
            builderVarExpr,
            RETRY_CODES_DEFINITIONS_VAR_EXPR,
            RETRY_PARAM_DEFINITIONS_VAR_EXPR);
    writerVisitor.clear();
    builderExpr.accept(writerVisitor);
    expected =
        LineFormatter.lines(
            "builder.waitSettings()"
                + ".setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get(\"no_retry_0_codes\"))"
                + ".setRetrySettings(RETRY_PARAM_DEFINITIONS.get(\"no_retry_0_params\"))");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void lroBuilderExpr() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            echoFileDescriptor, messageTypes, resourceNames, Optional.empty(), outputResourceNames);
    assertEquals(1, services.size());

    Service service = services.get(0);

    String jsonFilename = "showcase_grpc_service_config.json";
    Path jsonPath = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> serviceConfigOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertTrue(serviceConfigOpt.isPresent());
    GapicServiceConfig serviceConfig = serviceConfigOpt.get();

    // LRO method.
    Method waitMethod = findMethod(service, "Wait");
    assertThat(waitMethod).isNotNull();

    VariableExpr builderVarExpr = createBuilderVarExpr(service);
    Expr builderExpr =
        RetrySettingsComposer.createLroSettingsBuilderExpr(
            service,
            serviceConfig,
            waitMethod,
            builderVarExpr,
            RETRY_CODES_DEFINITIONS_VAR_EXPR,
            RETRY_PARAM_DEFINITIONS_VAR_EXPR,
            GrpcContext.instance().operationResponseTransformerType(),
            GrpcContext.instance().operationMetadataTransformerType());
    builderExpr.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "builder.waitOperationSettings()"
                + ".setInitialCallSettings(UnaryCallSettings.<WaitRequest,"
                + " OperationSnapshot>newUnaryCallSettingsBuilder()"
                + ".setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get(\"no_retry_0_codes\"))"
                + ".setRetrySettings(RETRY_PARAM_DEFINITIONS.get(\"no_retry_0_params\")).build())"
                + ".setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create("
                + "WaitResponse.class))"
                + ".setMetadataTransformer(ProtoOperationTransformers.MetadataTransformer.create("
                + "WaitMetadata.class)).setPollingAlgorithm(OperationTimedPollAlgorithm.create("
                + "RetrySettings.newBuilder().setInitialRetryDelayDuration(Duration.ofMillis(5000L))"
                + ".setRetryDelayMultiplier(1.5).setMaxRetryDelayDuration(Duration.ofMillis(45000L))"
                + ".setInitialRpcTimeoutDuration(Duration.ZERO).setRpcTimeoutMultiplier(1.0)"
                + ".setMaxRpcTimeoutDuration(Duration.ZERO).setTotalTimeoutDuration(Duration.ofMillis(300000L))"
                + ".build()))");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void batchingSettings_minimalFlowControlSettings() {
    String filename = "pubsub_gapic.yaml";
    Path path = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), filename);
    Optional<List<GapicBatchingSettings>> batchingSettingsOpt =
        BatchingSettingsConfigParser.parse(Optional.of(path.toString()));
    assertTrue(batchingSettingsOpt.isPresent());

    String jsonFilename = "pubsub_grpc_service_config.json";
    Path jsonPath = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> configOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertTrue(configOpt.isPresent());
    GapicServiceConfig config = configOpt.get();
    config.setBatchingSettings(batchingSettingsOpt);

    GapicContext context = TestProtoLoader.instance().parsePubSubPublisher();
    Service service = context.services().get(0);
    assertEquals("Publisher", service.name());

    VariableExpr builderVarExpr = createBuilderVarExpr(service);
    String methodSettingsName = "publishSettings";
    GapicBatchingSettings batchingSettings =
        GapicBatchingSettings.builder()
            .setProtoPakkage("com.google.pubsub.v1")
            .setServiceName("Publishing")
            .setMethodName("Publish")
            .setElementCountThreshold(100)
            .setRequestByteThreshold(1048576)
            .setDelayThresholdMillis(10)
            .setBatchedFieldName("messages")
            .setDiscriminatorFieldNames(Arrays.asList("topic"))
            .setSubresponseFieldName("message_ids")
            .build();

    Expr builderExpr =
        RetrySettingsComposer.createBatchingBuilderSettingsExpr(
            methodSettingsName, batchingSettings, builderVarExpr);
    builderExpr.accept(writerVisitor);
    String expected =
        "builder"
            + ".publishSettings()"
            + ".setBatchingSettings("
            + "BatchingSettings.newBuilder()"
            + ".setElementCountThreshold(100L)"
            + ".setRequestByteThreshold(1048576L)"
            + ".setDelayThresholdDuration(Duration.ofMillis(10L))"
            + ".setFlowControlSettings("
            + "FlowControlSettings.newBuilder()"
            + ".setLimitExceededBehavior(FlowController.LimitExceededBehavior.Ignore)"
            + ".build())"
            + ".build())";
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void batchingSettings_fullFlowControlSettings() {
    String filename = "logging_gapic.yaml";
    Path path = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), filename);
    Optional<List<GapicBatchingSettings>> batchingSettingsOpt =
        BatchingSettingsConfigParser.parse(Optional.of(path.toString()));
    assertTrue(batchingSettingsOpt.isPresent());

    String jsonFilename = "logging_grpc_service_config.json";
    Path jsonPath = Paths.get(TestProtoLoader.instance().getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> configOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertTrue(configOpt.isPresent());
    GapicServiceConfig config = configOpt.get();
    config.setBatchingSettings(batchingSettingsOpt);

    GapicContext context = TestProtoLoader.instance().parseLogging();
    Service service = context.services().get(0);
    assertEquals("LoggingServiceV2", service.name());

    VariableExpr builderVarExpr = createBuilderVarExpr(service);
    String methodSettingsName = "writeLogEntriesSettings";
    GapicBatchingSettings batchingSettings =
        GapicBatchingSettings.builder()
            .setProtoPakkage("com.google.logging.v2")
            .setServiceName("LoggingServiceV2")
            .setMethodName("WriteLogEntries")
            .setElementCountThreshold(1000)
            .setRequestByteThreshold(1048576)
            .setDelayThresholdMillis(50)
            .setFlowControlElementLimit(100000)
            .setFlowControlByteLimit(10485760)
            .setFlowControlLimitExceededBehavior(
                GapicBatchingSettings.FlowControlLimitExceededBehavior.THROW_EXCEPTION)
            .setBatchedFieldName("entries")
            .setDiscriminatorFieldNames(Arrays.asList("log_name", "resource", "labels"))
            .build();

    Expr builderExpr =
        RetrySettingsComposer.createBatchingBuilderSettingsExpr(
            methodSettingsName, batchingSettings, builderVarExpr);
    builderExpr.accept(writerVisitor);
    String expected =
        "builder"
            + ".writeLogEntriesSettings()"
            + ".setBatchingSettings("
            + "BatchingSettings.newBuilder()"
            + ".setElementCountThreshold(1000L)"
            + ".setRequestByteThreshold(1048576L)"
            + ".setDelayThresholdDuration(Duration.ofMillis(50L))"
            + ".setFlowControlSettings("
            + "FlowControlSettings.newBuilder()"
            + ".setMaxOutstandingElementCount(100000L)"
            + ".setMaxOutstandingRequestBytes(10485760L)"
            + ".setLimitExceededBehavior(FlowController.LimitExceededBehavior.ThrowException)"
            + ".build())"
            + ".build())";
    assertEquals(expected, writerVisitor.write());
  }

  private static Method findMethod(Service service, String methodName) {
    for (Method m : service.methods()) {
      if (m.name().equals(methodName)) {
        return m;
      }
    }
    return null;
  }

  private static VariableExpr createBuilderVarExpr(Service service) {
    TypeNode builderType =
        TypeNode.withReference(
            VaporReference.builder()
                .setPakkage(String.format("%s.stub", service.pakkage()))
                .setName("Builder")
                .build());
    return VariableExpr.withVariable(
        Variable.builder().setType(builderType).setName("builder").build());
  }

  private static VariableExpr createRetryableCodesDefinitionsVarExpr() {
    TypeNode immutableSetType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableSet.class)
                .setGenerics(Arrays.asList(ConcreteReference.withClazz(StatusCode.Code.class)))
                .build());
    TypeNode varType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableMap.class)
                .setGenerics(
                    Arrays.asList(TypeNode.STRING, immutableSetType).stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());
    return VariableExpr.withVariable(
        Variable.builder().setType(varType).setName("RETRYABLE_CODE_DEFINITIONS").build());
  }

  private static VariableExpr createRetryParamDefinitionsVarExpr() {
    TypeNode retrySettingsType =
        TypeNode.withReference(
            VaporReference.builder()
                .setPakkage("com.google.api.gax.retrying")
                .setName("RetrySettings")
                .build());
    TypeNode varType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableMap.class)
                .setGenerics(
                    Arrays.asList(TypeNode.STRING, retrySettingsType).stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());
    return VariableExpr.withVariable(
        Variable.builder().setType(varType).setName("RETRY_PARAM_DEFINITIONS").build());
  }
}

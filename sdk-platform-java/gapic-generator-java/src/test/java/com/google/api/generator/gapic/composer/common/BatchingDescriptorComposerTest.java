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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.GapicBatchingSettings;
import com.google.api.generator.gapic.model.GapicServiceConfig;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.protoparser.BatchingSettingsConfigParser;
import com.google.api.generator.gapic.protoparser.Parser;
import com.google.api.generator.gapic.protoparser.ServiceConfigParser;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.framework.GoldenFileWriter;
import com.google.api.generator.test.protoloader.TestProtoLoader;
import com.google.logging.v2.LogEntryProto;
import com.google.logging.v2.LoggingConfigProto;
import com.google.logging.v2.LoggingMetricsProto;
import com.google.logging.v2.LoggingProto;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.pubsub.v1.PubsubProto;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BatchingDescriptorComposerTest {
  private JavaWriterVisitor writerVisitor;

  @BeforeEach
  void setUp() {
    writerVisitor = new JavaWriterVisitor();
  }

  @Test
  void batchingDescriptor_hasSubresponseField() {
    FileDescriptor serviceFileDescriptor = PubsubProto.getDescriptor();
    FileDescriptor commonResourcesFileDescriptor = CommonResources.getDescriptor();
    ServiceDescriptor serviceDescriptor = serviceFileDescriptor.getServices().get(0);
    assertEquals("Publisher", serviceDescriptor.getName());

    Map<String, ResourceName> resourceNames = new HashMap<>();
    resourceNames.putAll(Parser.parseResourceNames(serviceFileDescriptor));
    resourceNames.putAll(Parser.parseResourceNames(commonResourcesFileDescriptor));

    Map<String, Message> messageTypes = Parser.parseMessages(serviceFileDescriptor);

    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            serviceFileDescriptor,
            messageTypes,
            resourceNames,
            Optional.empty(),
            outputResourceNames);

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

    Service service = services.get(0);
    assertEquals("Publisher", service.name());
    Method method = findMethod(service, "Publish");

    GapicBatchingSettings batchingSetting = batchingSettingsOpt.get().get(0);
    assertEquals("Publish", batchingSetting.methodName());
    Expr batchingDescriptorExpr =
        BatchingDescriptorComposer.createBatchingDescriptorFieldDeclExpr(
            method, batchingSetting, messageTypes);

    batchingDescriptorExpr.accept(writerVisitor);
    GoldenFileWriter.saveCodegenToFile(
        this.getClass(), "BatchingDescriptorComposerTestSubresponse.golden", writerVisitor.write());
    Path goldenFilePath =
        Paths.get(
            GoldenFileWriter.getGoldenDir(this.getClass()),
            "BatchingDescriptorComposerTestSubresponse.golden");
    Assert.assertCodeEquals(goldenFilePath, writerVisitor.write());
  }

  @Test
  void batchingDescriptor_noSubresponseField() {
    FileDescriptor serviceFileDescriptor = LoggingProto.getDescriptor();
    ServiceDescriptor serviceDescriptor = serviceFileDescriptor.getServices().get(0);
    assertEquals(serviceDescriptor.getName(), "LoggingServiceV2");

    List<FileDescriptor> protoFiles =
        Arrays.asList(
            serviceFileDescriptor,
            LogEntryProto.getDescriptor(),
            LoggingConfigProto.getDescriptor(),
            LoggingMetricsProto.getDescriptor());

    Map<String, ResourceName> resourceNames = new HashMap<>();
    Map<String, Message> messageTypes = new HashMap<>();
    for (FileDescriptor fileDescriptor : protoFiles) {
      resourceNames.putAll(Parser.parseResourceNames(fileDescriptor));
      messageTypes.putAll(Parser.parseMessages(fileDescriptor));
    }

    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            serviceFileDescriptor,
            messageTypes,
            resourceNames,
            Optional.empty(),
            outputResourceNames);

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

    Service service = services.get(0);
    assertEquals("LoggingServiceV2", service.name());
    Method method = findMethod(service, "WriteLogEntries");

    GapicBatchingSettings batchingSetting = batchingSettingsOpt.get().get(0);
    assertEquals("WriteLogEntries", batchingSetting.methodName());
    Expr batchingDescriptorExpr =
        BatchingDescriptorComposer.createBatchingDescriptorFieldDeclExpr(
            method, batchingSetting, messageTypes);

    batchingDescriptorExpr.accept(writerVisitor);
    GoldenFileWriter.saveCodegenToFile(
        this.getClass(),
        "BatchingDescriptorComposerTestNoSubresponse.golden",
        writerVisitor.write());
    Path goldenFilePath =
        Paths.get(
            GoldenFileWriter.getGoldenDir(this.getClass()),
            "BatchingDescriptorComposerTestNoSubresponse.golden");
    Assert.assertCodeEquals(goldenFilePath, writerVisitor.write());
  }

  private static Method findMethod(Service service, String methodName) {
    return service.methods().stream()
        .filter(m -> m.name().equals(methodName))
        .findFirst()
        .orElse(null);
  }
}

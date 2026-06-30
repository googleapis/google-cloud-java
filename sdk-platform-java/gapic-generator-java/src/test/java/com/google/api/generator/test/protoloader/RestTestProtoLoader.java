// Copyright 2021 Google LLC
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

package com.google.api.generator.test.protoloader;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicServiceConfig;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.model.Transport;
import com.google.api.generator.gapic.protoparser.Parser;
import com.google.api.generator.gapic.protoparser.ServiceConfigParser;
import com.google.api.generator.gapic.protoparser.ServiceYamlParser;
import com.google.api.version.test.ApiVersionTestingOuterClass;
import com.google.longrunning.OperationsProto;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.StructProto;
import com.google.showcase.v1beta1.ComplianceOuterClass;
import com.google.showcase.v1beta1.EchoOuterClass;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class RestTestProtoLoader extends TestProtoLoader {
  private static final RestTestProtoLoader INSTANCE = new RestTestProtoLoader();

  protected RestTestProtoLoader() {
    super(Transport.REST, "src/test/resources/");
  }

  public static RestTestProtoLoader instance() {
    return INSTANCE;
  }

  public GapicContext parseCompliance() {
    FileDescriptor complianceFileDescriptor = ComplianceOuterClass.getDescriptor();
    ServiceDescriptor complianceServiceDescriptor = complianceFileDescriptor.getServices().get(0);
    assertThat(complianceServiceDescriptor.getName()).isEqualTo("Compliance");

    Map<String, Message> messageTypes = Parser.parseMessages(complianceFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(complianceFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            complianceFileDescriptor,
            messageTypes,
            resourceNames,
            Optional.empty(),
            outputResourceNames);

    String jsonFilename = "showcase_grpc_service_config.json";
    Path jsonPath = Paths.get(getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> configOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertThat(configOpt.isPresent()).isTrue();
    GapicServiceConfig config = configOpt.get();

    return GapicContext.builder()
        .setMessages(messageTypes)
        .setResourceNames(resourceNames)
        .setServices(services)
        .setServiceConfig(config)
        .setHelperResourceNames(outputResourceNames)
        .setTransport(getTransport())
        .setRestNumericEnumsEnabled(true)
        .build();
  }

  public GapicContext parseEcho() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    ServiceDescriptor echoServiceDescriptor = echoFileDescriptor.getServices().get(0);
    assertThat(echoServiceDescriptor.getName()).isEqualTo("Echo");

    String serviceYamlFileName = "echo_v1beta1.yaml";
    Path serviceYamlPath = Paths.get(getTestFilesDirectory(), serviceYamlFileName);
    Optional<com.google.api.Service> serviceYamlOpt =
        ServiceYamlParser.parse(serviceYamlPath.toString());
    assertThat(serviceYamlOpt.isPresent()).isTrue();
    com.google.api.Service service = serviceYamlOpt.get();

    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    messageTypes.putAll(Parser.parseMessages(OperationsProto.getDescriptor()));
    messageTypes.putAll(Parser.parseMessages(StructProto.getDescriptor()));
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(echoFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            echoFileDescriptor, messageTypes, resourceNames, serviceYamlOpt, outputResourceNames);

    String jsonFilename = "showcase_grpc_service_config.json";
    Path jsonPath = Paths.get(getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> configOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertThat(configOpt.isPresent()).isTrue();
    GapicServiceConfig config = configOpt.get();

    return GapicContext.builder()
        .setMessages(messageTypes)
        .setResourceNames(resourceNames)
        .setServices(services)
        .setServiceConfig(config)
        .setServiceYamlProto(service)
        .setHelperResourceNames(outputResourceNames)
        .setTransport(getTransport())
        .setRestNumericEnumsEnabled(true)
        .build();
  }

  public GapicContext parseApiVersionTesting() {
    FileDescriptor testingFileDescriptor = ApiVersionTestingOuterClass.getDescriptor();
    ServiceDescriptor testingService = testingFileDescriptor.getServices().get(0);
    assertEquals(testingService.getName(), "EchoWithVersion");

    Map<String, Message> messageTypes = Parser.parseMessages(testingFileDescriptor);
    Map<String, ResourceName> resourceNames = Parser.parseResourceNames(testingFileDescriptor);
    Set<ResourceName> outputResourceNames = new HashSet<>();
    List<Service> services =
        Parser.parseService(
            testingFileDescriptor,
            messageTypes,
            resourceNames,
            Optional.empty(),
            outputResourceNames);

    String jsonFilename = "showcase_grpc_service_config.json";
    Path jsonPath = Paths.get(getTestFilesDirectory(), jsonFilename);
    Optional<GapicServiceConfig> configOpt = ServiceConfigParser.parse(jsonPath.toString());
    assertThat(configOpt.isPresent()).isTrue();
    GapicServiceConfig config = configOpt.get();

    return GapicContext.builder()
        .setMessages(messageTypes)
        .setResourceNames(resourceNames)
        .setServices(services)
        .setServiceConfig(config)
        .setHelperResourceNames(outputResourceNames)
        .setTransport(getTransport())
        .setRestNumericEnumsEnabled(true)
        .build();
  }
}

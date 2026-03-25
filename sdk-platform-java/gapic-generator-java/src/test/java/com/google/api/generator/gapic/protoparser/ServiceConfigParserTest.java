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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import io.grpc.serviceconfig.MethodConfig;
import io.grpc.serviceconfig.ServiceConfig;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ServiceConfigParserTest {

  private static final String JSON_DIRECTORY = "src/test/resources/";
  private static final double EPSILON = 1e-4;

  @Test
  void parseServiceConfig_basic() {
    String jsonFilename = "retrying_grpc_service_config.json";
    Path jsonPath = Paths.get(JSON_DIRECTORY, jsonFilename);
    Optional<ServiceConfig> configOpt = ServiceConfigParser.parseFile(jsonPath.toString());
    assertTrue(configOpt.isPresent());

    ServiceConfig config = configOpt.get();
    assertEquals(1, config.getMethodConfigList().size());

    MethodConfig methodConfig = config.getMethodConfigList().get(0);
    assertEquals(1, methodConfig.getNameList().size());

    MethodConfig.Name name = methodConfig.getNameList().get(0);
    assertEquals("helloworld.Greeter", name.getService());
    assertEquals("SayHello", name.getMethod());

    MethodConfig.RetryPolicy retryPolicy = methodConfig.getRetryPolicy();
    assertEquals(5, retryPolicy.getMaxAttempts());
    assertEquals(500, Durations.toMillis(retryPolicy.getInitialBackoff()));
    assertEquals(30000, Durations.toMillis(retryPolicy.getMaxBackoff()));
    assertEquals(2.0, retryPolicy.getBackoffMultiplier(), EPSILON);

    assertEquals(1, retryPolicy.getRetryableStatusCodesList().size());
    assertEquals(Code.UNAVAILABLE, retryPolicy.getRetryableStatusCodesList().get(0));
  }

  @Test
  void parseServiceConfig_showcase() {
    String jsonFilename = "showcase_grpc_service_config.json";
    Path jsonPath = Paths.get(JSON_DIRECTORY, jsonFilename);
    Optional<ServiceConfig> configOpt = ServiceConfigParser.parseFile(jsonPath.toString());
    assertTrue(configOpt.isPresent());

    ServiceConfig config = configOpt.get();
    assertEquals(3, config.getMethodConfigList().size());

    MethodConfig methodConfig = config.getMethodConfigList().get(0);
    assertEquals(2, methodConfig.getNameList().size());
    assertTrue(methodConfig.getNameList().get(0).getMethod().isEmpty());
    assertEquals(5000, Durations.toMillis(methodConfig.getTimeout()));

    methodConfig = config.getMethodConfigList().get(1);
    assertEquals(9, methodConfig.getNameList().size());
  }

  @Test
  void parseBadServiceConfig_missingFile() {
    String jsonFilename = "does_not_exist_grpc_service_config.json";
    Path jsonPath = Paths.get(JSON_DIRECTORY, jsonFilename);
    Optional<ServiceConfig> configOpt = ServiceConfigParser.parseFile(jsonPath.toString());
    assertFalse(configOpt.isPresent());
  }

  @Test
  void parseBadServiceConfig_malformedJson() {
    String jsonFilename = "malformed_grpc_service_config.json";
    Path jsonPath = Paths.get(JSON_DIRECTORY, jsonFilename);
    Optional<ServiceConfig> configOpt = ServiceConfigParser.parseFile(jsonPath.toString());
    assertFalse(configOpt.isPresent());
  }

  @Test
  void parseBadServiceConfig_badProtoFields() {
    String jsonFilename = "bad_proto_fields_grpc_service_config.json";
    Path jsonPath = Paths.get(JSON_DIRECTORY, jsonFilename);
    Optional<ServiceConfig> configOpt = ServiceConfigParser.parseFile(jsonPath.toString());
    assertFalse(configOpt.isPresent());
  }

  @Test
  void parseBadServiceConfig_nullOrEmptyPath() {
    Optional<ServiceConfig> configOpt = ServiceConfigParser.parseFile(null);
    assertFalse(configOpt.isPresent());

    configOpt = ServiceConfigParser.parseFile("");
    assertFalse(configOpt.isPresent());
  }
}

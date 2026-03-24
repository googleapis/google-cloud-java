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

import com.google.api.generator.gapic.model.GapicBatchingSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

public class BatchingSettingsConfigParser {
  private static String LIMIT_EXCEEDED_BEHAVIOR_THROW_EXCEPTION_YAML_VALUE = "THROW_EXCEPTION";
  private static String LIMIT_EXCEEDED_BEHAVIOR_BLOCK_YAML_VALUE = "BLOCK";

  private static String YAML_KEY_INTERFACES = "interfaces";
  private static String YAML_KEY_NAME = "name";
  private static String YAML_KEY_METHODS = "methods";
  private static String YAML_KEY_BATCHING = "batching";
  private static String YAML_KEY_THRESHOLDS = "thresholds";
  private static String YAML_KEY_DESCRIPTOR = "batch_descriptor";

  private static String YAML_KEY_BATCHING_ELEMENT_COUNT_THRESHOLD = "element_count_threshold";
  private static String YAML_KEY_BATCHING_DELAY_THRESHOLD_MILLIS = "delay_threshold_millis";
  private static String YAML_KEY_BATCHING_REQUEST_BYTE_THRESHOLD = "request_byte_threshold";
  private static String YAML_KEY_BATCHING_FLOW_CONTROL_ELEMENT_LIMIT = "flow_control_element_limit";
  private static String YAML_KEY_BATCHING_FLOW_CONTROL_BYTE_LIMIT = "flow_control_byte_limit";
  private static String YAML_KEY_BATCHING_FLOW_CONTROL_LIMIT_EXCEEDED_BEHAVIOR =
      "flow_control_limit_exceeded_behavior";

  private static String YAML_KEY_DESCRIPTOR_BATCHED_FIELD = "batched_field";
  private static String YAML_KEY_DESCRIPTOR_DISCRIMINATOR_FIELD = "discriminator_fields";
  private static String YAML_KEY_DESCRIPTOR_SUBRESPONSE_FIELD = "subresponse_field";

  public static Optional<List<GapicBatchingSettings>> parse(
      Optional<String> gapicYamlConfigFilePathOpt) {
    return gapicYamlConfigFilePathOpt.isPresent()
        ? parse(gapicYamlConfigFilePathOpt.get())
        : Optional.empty();
  }

  @VisibleForTesting
  static Optional<List<GapicBatchingSettings>> parse(String gapicYamlConfigFilePath) {
    if (Strings.isNullOrEmpty(gapicYamlConfigFilePath)
        || !(new File(gapicYamlConfigFilePath)).exists()) {
      return Optional.empty();
    }

    String fileContents = null;

    try {
      fileContents =
          new String(
              Files.readAllBytes(Paths.get(gapicYamlConfigFilePath)), StandardCharsets.UTF_8);
    } catch (IOException e) {
      return Optional.empty();
    }

    Yaml yaml = new Yaml(new SafeConstructor(new LoaderOptions()));
    Map<String, Object> yamlMap = yaml.load(fileContents);
    return parseFromMap(yamlMap);
  }

  private static Optional<List<GapicBatchingSettings>> parseFromMap(Map<String, Object> yamlMap) {
    if (!yamlMap.containsKey(YAML_KEY_INTERFACES)) {
      return Optional.empty();
    }

    List<GapicBatchingSettings> settings = new ArrayList<>();
    for (Map<String, Object> serviceYamlConfig :
        (List<Map<String, Object>>) yamlMap.get(YAML_KEY_INTERFACES)) {
      if (!serviceYamlConfig.containsKey(YAML_KEY_METHODS)) {
        continue;
      }
      for (Map<String, Object> methodYamlConfig :
          (List<Map<String, Object>>) serviceYamlConfig.get(YAML_KEY_METHODS)) {
        if (!methodYamlConfig.containsKey(YAML_KEY_BATCHING)) {
          continue;
        }
        Map<String, Object> batchingOuterYamlConfig =
            (Map<String, Object>) methodYamlConfig.get(YAML_KEY_BATCHING);
        if (!batchingOuterYamlConfig.containsKey(YAML_KEY_THRESHOLDS)) {
          continue;
        }
        Preconditions.checkState(
            batchingOuterYamlConfig.containsKey(YAML_KEY_DESCRIPTOR),
            String.format(
                "%s key expected but not found for method %s",
                YAML_KEY_DESCRIPTOR, methodYamlConfig.get(YAML_KEY_NAME)));

        // Parse the threshold values first.
        Map<String, Object> batchingYamlConfig =
            (Map<String, Object>) batchingOuterYamlConfig.get(YAML_KEY_THRESHOLDS);
        Preconditions.checkState(
            batchingYamlConfig.containsKey(YAML_KEY_BATCHING_ELEMENT_COUNT_THRESHOLD)
                && batchingYamlConfig.containsKey(YAML_KEY_BATCHING_REQUEST_BYTE_THRESHOLD)
                && batchingYamlConfig.containsKey(YAML_KEY_BATCHING_DELAY_THRESHOLD_MILLIS),
            String.format(
                "Batching YAML config is missing one of %s, %s, or %s fields",
                YAML_KEY_BATCHING_ELEMENT_COUNT_THRESHOLD,
                YAML_KEY_BATCHING_REQUEST_BYTE_THRESHOLD,
                YAML_KEY_BATCHING_DELAY_THRESHOLD_MILLIS));

        String interfaceName = (String) serviceYamlConfig.get(YAML_KEY_NAME);
        int lastDotIndex = interfaceName.lastIndexOf(".");
        String protoPakkage = interfaceName.substring(0, lastDotIndex);
        String serviceName = interfaceName.substring(lastDotIndex + 1);
        String methodName = (String) methodYamlConfig.get(YAML_KEY_NAME);
        GapicBatchingSettings.Builder settingsBuilder =
            GapicBatchingSettings.builder()
                .setProtoPakkage(protoPakkage)
                .setServiceName(serviceName)
                .setMethodName(methodName)
                .setElementCountThreshold(
                    (Integer) batchingYamlConfig.get(YAML_KEY_BATCHING_ELEMENT_COUNT_THRESHOLD))
                .setRequestByteThreshold(
                    (Integer) batchingYamlConfig.get(YAML_KEY_BATCHING_REQUEST_BYTE_THRESHOLD))
                .setDelayThresholdMillis(
                    (Integer) batchingYamlConfig.get(YAML_KEY_BATCHING_DELAY_THRESHOLD_MILLIS));

        if (batchingYamlConfig.containsKey(YAML_KEY_BATCHING_FLOW_CONTROL_ELEMENT_LIMIT)) {
          settingsBuilder.setFlowControlElementLimit(
              (Integer) batchingYamlConfig.get(YAML_KEY_BATCHING_FLOW_CONTROL_ELEMENT_LIMIT));
        }
        if (batchingYamlConfig.containsKey(YAML_KEY_BATCHING_FLOW_CONTROL_BYTE_LIMIT)) {
          settingsBuilder.setFlowControlByteLimit(
              (Integer) batchingYamlConfig.get(YAML_KEY_BATCHING_FLOW_CONTROL_BYTE_LIMIT));
        }
        if (batchingYamlConfig.containsKey(
            YAML_KEY_BATCHING_FLOW_CONTROL_LIMIT_EXCEEDED_BEHAVIOR)) {
          String behaviorYamlValue =
              (String)
                  batchingYamlConfig.get(YAML_KEY_BATCHING_FLOW_CONTROL_LIMIT_EXCEEDED_BEHAVIOR);
          GapicBatchingSettings.FlowControlLimitExceededBehavior behaviorSetting =
              GapicBatchingSettings.FlowControlLimitExceededBehavior.IGNORE;
          // IGNORE or UNSET_BEHAVIOR YAML values map to FlowControlLimitExceededBehavior.IGNOER.
          if (behaviorYamlValue.equals(LIMIT_EXCEEDED_BEHAVIOR_THROW_EXCEPTION_YAML_VALUE)) {
            behaviorSetting =
                GapicBatchingSettings.FlowControlLimitExceededBehavior.THROW_EXCEPTION;
          } else if (behaviorYamlValue.equals(LIMIT_EXCEEDED_BEHAVIOR_BLOCK_YAML_VALUE)) {
            behaviorSetting = GapicBatchingSettings.FlowControlLimitExceededBehavior.BLOCK;
          }
          settingsBuilder.setFlowControlLimitExceededBehavior(behaviorSetting);
        }

        // Parse the descriptor values.
        Map<String, Object> descriptorYamlConfig =
            (Map<String, Object>) batchingOuterYamlConfig.get(YAML_KEY_DESCRIPTOR);
        Preconditions.checkState(
            descriptorYamlConfig.containsKey(YAML_KEY_DESCRIPTOR_BATCHED_FIELD)
                && descriptorYamlConfig.containsKey(YAML_KEY_DESCRIPTOR_DISCRIMINATOR_FIELD),
            String.format(
                "Batching descriptor YAML config is missing one of %s or %s fields",
                YAML_KEY_DESCRIPTOR_BATCHED_FIELD, YAML_KEY_DESCRIPTOR_DISCRIMINATOR_FIELD));

        settingsBuilder.setBatchedFieldName(
            (String) descriptorYamlConfig.get(YAML_KEY_DESCRIPTOR_BATCHED_FIELD));
        settingsBuilder.setDiscriminatorFieldNames(
            (List<String>) descriptorYamlConfig.get(YAML_KEY_DESCRIPTOR_DISCRIMINATOR_FIELD));

        if (descriptorYamlConfig.containsKey(YAML_KEY_DESCRIPTOR_SUBRESPONSE_FIELD)) {
          settingsBuilder.setSubresponseFieldName(
              (String) descriptorYamlConfig.get(YAML_KEY_DESCRIPTOR_SUBRESPONSE_FIELD));
        }

        settings.add(settingsBuilder.build());
      }
    }

    return settings.isEmpty() ? Optional.empty() : Optional.of(settings);
  }
}

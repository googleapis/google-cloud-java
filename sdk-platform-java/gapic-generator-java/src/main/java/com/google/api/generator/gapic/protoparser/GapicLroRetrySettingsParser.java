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

import com.google.api.generator.gapic.model.GapicLroRetrySettings;
import com.google.common.annotations.VisibleForTesting;
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

public class GapicLroRetrySettingsParser {
  private static final String YAML_KEY_INTERFACES = "interfaces";
  private static final String YAML_KEY_NAME = "name";
  private static final String YAML_KEY_METHODS = "methods";
  private static final String YAML_KEY_LONG_RUNNING = "long_running";

  private static final String YAML_KEY_INITIAL_POLL_DELAY_MILLIS = "initial_poll_delay_millis";
  private static final String YAML_KEY_POLL_DELAY_MULTIPLIER = "poll_delay_multiplier";
  private static final String YAML_KEY_MAX_POLL_DELAY_MILLIS = "max_poll_delay_millis";
  private static final String YAML_KEY_TOTAL_POLL_TIMEOUT_MILLIS = "total_poll_timeout_millis";

  public static Optional<List<GapicLroRetrySettings>> parse(
      Optional<String> gapicYamlConfigFilePathOpt) {
    return gapicYamlConfigFilePathOpt.isPresent()
        ? parse(gapicYamlConfigFilePathOpt.get())
        : Optional.empty();
  }

  @VisibleForTesting
  static Optional<List<GapicLroRetrySettings>> parse(String gapicYamlConfigFilePath) {
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

  private static Optional<List<GapicLroRetrySettings>> parseFromMap(Map<String, Object> yamlMap) {
    if (!yamlMap.containsKey(YAML_KEY_INTERFACES)) {
      return Optional.empty();
    }

    List<GapicLroRetrySettings> settings = new ArrayList<>();
    for (Map<String, Object> serviceYamlConfig :
        (List<Map<String, Object>>) yamlMap.get(YAML_KEY_INTERFACES)) {
      if (!serviceYamlConfig.containsKey(YAML_KEY_METHODS)) {
        continue;
      }
      for (Map<String, Object> methodYamlConfig :
          (List<Map<String, Object>>) serviceYamlConfig.get(YAML_KEY_METHODS)) {
        if (!methodYamlConfig.containsKey(YAML_KEY_LONG_RUNNING)) {
          continue;
        }

        Map<String, Object> lroRetrySettingsYamlConfig =
            (Map<String, Object>) methodYamlConfig.get(YAML_KEY_LONG_RUNNING);
        if (!lroRetrySettingsYamlConfig.containsKey(YAML_KEY_INITIAL_POLL_DELAY_MILLIS)
            || !lroRetrySettingsYamlConfig.containsKey(YAML_KEY_POLL_DELAY_MULTIPLIER)
            || !lroRetrySettingsYamlConfig.containsKey(YAML_KEY_MAX_POLL_DELAY_MILLIS)
            || !lroRetrySettingsYamlConfig.containsKey(YAML_KEY_TOTAL_POLL_TIMEOUT_MILLIS)) {
          continue;
        }

        String interfaceName = (String) serviceYamlConfig.get(YAML_KEY_NAME);
        int lastDotIndex = interfaceName.lastIndexOf(".");
        String protoPakkage = interfaceName.substring(0, lastDotIndex);
        String serviceName = interfaceName.substring(lastDotIndex + 1);
        String methodName = (String) methodYamlConfig.get(YAML_KEY_NAME);

        GapicLroRetrySettings.Builder lroRetrySettingsBuilder =
            GapicLroRetrySettings.builder()
                .setProtoPakkage(protoPakkage)
                .setServiceName(serviceName)
                .setMethodName(methodName)
                .setInitialPollDelayMillis(
                    (Integer) lroRetrySettingsYamlConfig.get(YAML_KEY_INITIAL_POLL_DELAY_MILLIS))
                .setMaxPollDelayMillis(
                    (Integer) lroRetrySettingsYamlConfig.get(YAML_KEY_MAX_POLL_DELAY_MILLIS))
                .setTotalPollTimeoutMillis(
                    (Integer) lroRetrySettingsYamlConfig.get(YAML_KEY_TOTAL_POLL_TIMEOUT_MILLIS));

        // Workaround for snakeyaml's automatic type inference. When given a value like "1",
        // snakeyaml interprets this as an integer, whereas a value like "1.5" is interpreted as
        // a double.
        Object pollDelayMultObj = lroRetrySettingsYamlConfig.get(YAML_KEY_POLL_DELAY_MULTIPLIER);
        if (pollDelayMultObj instanceof Integer) {
          lroRetrySettingsBuilder =
              lroRetrySettingsBuilder.setPollDelayMultiplier((Integer) pollDelayMultObj);
        } else if (pollDelayMultObj instanceof Double) {
          lroRetrySettingsBuilder =
              lroRetrySettingsBuilder.setPollDelayMultiplier((Double) pollDelayMultObj);
        }
        settings.add(lroRetrySettingsBuilder.build());
      }
    }
    return settings.isEmpty() ? Optional.empty() : Optional.of(settings);
  }
}

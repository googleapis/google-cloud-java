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

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

public class ServiceYamlParser {
  public static Optional<com.google.api.Service> parse(String serviceYamlFilePath) {
    if (Strings.isNullOrEmpty(serviceYamlFilePath) || !(new File(serviceYamlFilePath)).exists()) {
      return Optional.empty();
    }

    String fileContents = null;
    try {
      fileContents =
          new String(Files.readAllBytes(Paths.get(serviceYamlFilePath)), StandardCharsets.UTF_8);
    } catch (IOException e) {
      return Optional.empty();
    }

    Yaml yaml = new Yaml(new SafeConstructor(new LoaderOptions()));
    Map<String, Object> yamlMap = yaml.load(fileContents);
    Gson gson = new GsonBuilder().setPrettyPrinting().setLenient().create();
    String jsonString = gson.toJson(yamlMap, LinkedHashMap.class);
    // Use the full name instead of an import, to avoid reader confusion with this and
    // model.Service.
    com.google.api.Service.Builder serviceBuilder = com.google.api.Service.newBuilder();
    try {
      JsonFormat.parser().ignoringUnknownFields().merge(jsonString, serviceBuilder);
    } catch (InvalidProtocolBufferException e) {
      return Optional.empty();
    }
    return Optional.of(serviceBuilder.build());
  }
}

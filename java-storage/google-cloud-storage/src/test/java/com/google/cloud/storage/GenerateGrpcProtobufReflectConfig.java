/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class GenerateGrpcProtobufReflectConfig {

  public static void main(String[] args) throws IOException {
    try (ScanResult scanResult =
        new ClassGraph().enableAllInfo().acceptPackages("io.grpc").scan()) {
      String json =
          Stream.of(
                  Stream.of(
                      "{\n"
                          + "    \"name\":\"org.apache.commons.logging.LogFactory\",\n"
                          + "    \"allDeclaredFields\":true,\n"
                          + "    \"allDeclaredMethods\":true,\n"
                          + "    \"allDeclaredConstructors\": true\n"
                          + "  }",
                      "{\n"
                          + "    \"name\":\"org.apache.commons.logging.impl.Jdk14Logger\",\n"
                          + "    \"methods\":[{\"name\":\"<init>\",\"parameterTypes\":[\"java.lang.String\"]"
                          + " }]\n"
                          + "  }",
                      "{\n"
                          + "    \"name\":\"org.apache.commons.logging.impl.LogFactoryImpl\",\n"
                          + "    \"allDeclaredFields\":true,\n"
                          + "    \"allDeclaredMethods\":true,\n"
                          + "    \"methods\":[{\"name\":\"<init>\",\"parameterTypes\":[] }]\n"
                          + "  }"),
                  Stream.of(
                          scanResult.getSubclasses(AbstractMessage.class).stream(),
                          scanResult.getSubclasses(AbstractMessage.Builder.class).stream(),
                          scanResult
                              .getAllEnums()
                              .filter(ci -> ci.implementsInterface(ProtocolMessageEnum.class))
                              .stream())
                      .flatMap(s -> s)
                      .map(ClassInfo::getName)
                      .sorted()
                      .map(
                          name ->
                              String.format(
                                  Locale.US,
                                  "{ \"name\": \"%s\", \"queryAllDeclaredConstructors\": true,"
                                      + " \"queryAllPublicConstructors\": true,"
                                      + " \"queryAllDeclaredMethods\": true, \"allPublicMethods\":"
                                      + " true, \"allDeclaredClasses\": true, \"allPublicClasses\":"
                                      + " true }",
                                  name)))
              .flatMap(s -> s)
              .collect(Collectors.joining(",\n  ", "[\n  ", "\n]\n"));
      String workingDirectory = System.getProperty("user.dir"); // should be google-cloud-storage
      String testResourcesPath = "src/test/resources";
      String reflectConfigResourcePath =
          "META-INF/native-image/com/google/cloud/storage/reflect-config.json";
      Path path = Paths.get(workingDirectory, testResourcesPath, reflectConfigResourcePath);
      System.err.println("Writing reflect-config.json at path: " + path);
      Files.write(path, json.getBytes(StandardCharsets.UTF_8));
    }
  }
}

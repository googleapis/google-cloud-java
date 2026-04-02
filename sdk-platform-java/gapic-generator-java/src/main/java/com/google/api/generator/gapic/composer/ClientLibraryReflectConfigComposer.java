// Copyright 2023 Google LLC
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

package com.google.api.generator.gapic.composer;

import com.google.api.client.util.Preconditions;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.ReflectConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClientLibraryReflectConfigComposer {
  private ClientLibraryReflectConfigComposer() {} // Disallow instance creation

  public static List<ReflectConfig> generateReflectConfig(GapicContext context) {
    List<String> allConfigs = new ArrayList<>();
    context
        .messages()
        .forEach(
            (fullyQualifiedClassName, msg) ->
                allConfigs.addAll(calculateReflectConfigList(fullyQualifiedClassName, msg)));

    List<String> duplicates = calculateDuplicates(allConfigs);
    Preconditions.checkState(
        duplicates.isEmpty(), "Duplicate binary name entries found: %s", duplicates);

    return allConfigs.stream()
        .sorted()
        .map(ReflectConfig::new)
        .collect(ImmutableList.toImmutableList());
  }

  /**
   * List the binary names of all classes in the Message that should have a reflect-config entry.
   *
   * <p>Note: Each reflect-config 'name' entry must be the "binary name" of a class to prevent
   * ClassNotFoundException warnings during the native-image build.
   *
   * <p>Binary names (ex: `foo.Bar$Baz`) are guaranteed to be unique within a jar. By contrast,
   * fully qualified class names (ex: `foo.Bar.Baz`) are only unique if standard Java package naming
   * conventions are followed. A class `Baz` in package `foo.Bar` would have the same fully
   * qualified class name as a nested class `Baz` in the class `Bar` in package `foo`.
   *
   * <p>See also the Java Language Specification @ 13.1.1 and 13.1.2 for specifics on the binary
   * name format.
   */
  @VisibleForTesting
  static List<String> calculateReflectConfigList(String fullyQualifiedClassName, Message message) {
    final String binaryName = convertToBinaryName(fullyQualifiedClassName);

    List<String> list = new ArrayList<>();
    list.add(binaryName);
    for (String nestedEnum : message.nestedEnums()) {
      list.add(binaryName + "$" + nestedEnum);
    }
    if (!message.isEnum()) {
      list.add(binaryName + "$Builder");
    }
    return list;
  }

  /**
   * Replace '.' with '$' in fully qualified class names once the classes become nested.
   *
   * <p>For example, the fully qualified class name `com.google.foo.Bar.Baz.Car` becomes the binary
   * name `com.google.foo.Bar$Baz$Car`.
   *
   * <p>This conversion works only when following standard Java naming conventions that packages
   * always start with a lowercase letter, and classes always start with an uppercase letter.
   */
  @VisibleForTesting
  static String convertToBinaryName(String fullyQualifiedClassName) {
    StringBuilder result = new StringBuilder();
    boolean isNested = false;
    for (String s : fullyQualifiedClassName.split("\\.")) {
      if (result.length() != 0) {
        result.append(isNested ? "$" : ".");
      }
      result.append(s);
      if (Character.isUpperCase(s.charAt(0))) {
        isNested = true;
      }
    }
    return result.toString();
  }

  @VisibleForTesting
  static List<String> calculateDuplicates(List<String> allConfigs) {
    List<String> duplicates = new ArrayList<>(allConfigs);
    new HashSet<>(allConfigs).forEach(duplicates::remove);
    return duplicates;
  }
}

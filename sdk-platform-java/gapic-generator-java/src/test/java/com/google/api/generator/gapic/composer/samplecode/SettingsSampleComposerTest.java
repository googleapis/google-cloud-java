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

package com.google.api.generator.gapic.composer.samplecode;

import static org.junit.Assert.assertEquals;

import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.test.utils.LineFormatter;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class SettingsSampleComposerTest {
  @Test
  void composeSettingsSample_noMethods() {
    TypeNode classType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoSettings")
                .setPakkage("com.google.showcase.v1beta1")
                .build());
    Optional<String> results =
        writeSample(
            SettingsSampleComposer.composeSettingsSample(
                Optional.empty(), "EchoSettings", classType));
    assertEquals(results, Optional.empty());
  }

  @Test
  void composeSettingsSample_serviceSettingsClass() {
    TypeNode classType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoSettings")
                .setPakkage("com.google.showcase.v1beta1")
                .build());
    Optional<String> results =
        writeSample(
            SettingsSampleComposer.composeSettingsSample(
                Optional.of("Echo"), "EchoSettings", classType));
    String expected =
        LineFormatter.lines(
            "EchoSettings.Builder echoSettingsBuilder = EchoSettings.newBuilder();\n",
            "echoSettingsBuilder\n",
            "    .echoSettings()\n",
            "    .setRetrySettings(\n",
            "        echoSettingsBuilder\n",
            "            .echoSettings()\n",
            "            .getRetrySettings()\n",
            "            .toBuilder()\n",
            "            .setInitialRetryDelayDuration(Duration.ofSeconds(1))\n",
            "            .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))\n",
            "            .setMaxAttempts(5)\n",
            "            .setMaxRetryDelayDuration(Duration.ofSeconds(30))\n",
            "            .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))\n",
            "            .setRetryDelayMultiplier(1.3)\n",
            "            .setRpcTimeoutMultiplier(1.5)\n",
            "            .setTotalTimeoutDuration(Duration.ofSeconds(300))\n",
            "            .build());\n",
            "EchoSettings echoSettings = echoSettingsBuilder.build();");
    assertEquals(results.get(), expected);
  }

  @Test
  void composeSettingsSample_serviceStubClass() {
    TypeNode classType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("EchoStubSettings")
                .setPakkage("com.google.showcase.v1beta1")
                .build());
    Optional<String> results =
        writeSample(
            SettingsSampleComposer.composeSettingsSample(
                Optional.of("Echo"), "EchoSettings", classType));
    String expected =
        LineFormatter.lines(
            "EchoStubSettings.Builder echoSettingsBuilder = EchoStubSettings.newBuilder();\n",
            "echoSettingsBuilder\n",
            "    .echoSettings()\n",
            "    .setRetrySettings(\n",
            "        echoSettingsBuilder\n",
            "            .echoSettings()\n",
            "            .getRetrySettings()\n",
            "            .toBuilder()\n",
            "            .setInitialRetryDelayDuration(Duration.ofSeconds(1))\n",
            "            .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))\n",
            "            .setMaxAttempts(5)\n",
            "            .setMaxRetryDelayDuration(Duration.ofSeconds(30))\n",
            "            .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))\n",
            "            .setRetryDelayMultiplier(1.3)\n",
            "            .setRpcTimeoutMultiplier(1.5)\n",
            "            .setTotalTimeoutDuration(Duration.ofSeconds(300))\n",
            "            .build());\n",
            "EchoStubSettings echoSettings = echoSettingsBuilder.build();");
    assertEquals(results.get(), expected);
  }

  @Test
  void composeSettingsSample_serviceSettingsClass_LroMethod() {
    TypeNode classType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("WaitSettings")
                .setPakkage("com.google.showcase.v1beta1")
                .build());
    Optional<String> results =
        writeSample(
            SettingsSampleComposer.composeLroSettingsSample(
                Optional.of("Wait"), "WaitSettings", classType));
    String expected =
        LineFormatter.lines(
            "WaitSettings.Builder waitSettingsBuilder = WaitSettings.newBuilder();\n",
            "TimedRetryAlgorithm timedRetryAlgorithm =\n",
            "    OperationalTimedPollAlgorithm.create(\n",
            "        RetrySettings.newBuilder()\n",
            "            .setInitialRetryDelayDuration(Duration.ofMillis(500))\n",
            "            .setRetryDelayMultiplier(1.5)\n",
            "            .setMaxRetryDelayDuration(Duration.ofMillis(5000))\n",
            "            .setTotalTimeoutDuration(Duration.ofHours(24))\n",
            "            .build());\n",
            "waitSettingsBuilder\n",
            "    .createClusterOperationSettings()\n",
            "    .setPollingAlgorithm(timedRetryAlgorithm)\n",
            "    .build();");
    assertEquals(expected, results.get());
  }

  @Test
  void composeSettingsSample_serviceStubClass_LroMethod() {
    TypeNode classType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("WaitStubSettings")
                .setPakkage("com.google.showcase.v1beta1")
                .build());
    Optional<String> results =
        writeSample(
            SettingsSampleComposer.composeLroSettingsSample(
                Optional.of("Wait"), "WaitSettings", classType));
    String expected =
        LineFormatter.lines(
            "WaitStubSettings.Builder waitSettingsBuilder = WaitStubSettings.newBuilder();\n",
            "TimedRetryAlgorithm timedRetryAlgorithm =\n",
            "    OperationalTimedPollAlgorithm.create(\n",
            "        RetrySettings.newBuilder()\n",
            "            .setInitialRetryDelayDuration(Duration.ofMillis(500))\n",
            "            .setRetryDelayMultiplier(1.5)\n",
            "            .setMaxRetryDelayDuration(Duration.ofMillis(5000))\n",
            "            .setTotalTimeoutDuration(Duration.ofHours(24))\n",
            "            .build());\n",
            "waitSettingsBuilder\n",
            "    .createClusterOperationSettings()\n",
            "    .setPollingAlgorithm(timedRetryAlgorithm)\n",
            "    .build();");
    assertEquals(results.get(), expected);
  }

  private Optional<String> writeSample(Optional<Sample> sample) {
    if (sample.isPresent()) {
      return Optional.of(SampleCodeWriter.write(sample.get().body()));
    }
    return Optional.empty();
  }
}

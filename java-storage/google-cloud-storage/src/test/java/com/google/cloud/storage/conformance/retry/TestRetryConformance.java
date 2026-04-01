/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage.conformance.retry;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertNotNull;

import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.conformance.storage.v1.InstructionList;
import com.google.cloud.conformance.storage.v1.Method;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.common.base.Joiner;
import com.google.common.io.ByteStreams;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * An individual resolved test case correlating config from {@link
 * com.google.cloud.conformance.storage.v1.RetryTest}s: the specific rpc method being tested, the
 * instructions and the corresponding mapping id.
 *
 * <p>Generates some unique values for use in parallel test execution such as bucket names, object
 * names, etc.
 */
@Immutable
final class TestRetryConformance {
  static final String BASE_ID;

  static {
    Instant now = Clock.systemUTC().instant();
    DateTimeFormatter formatter =
        DateTimeFormatter.ISO_LOCAL_TIME.withZone(ZoneId.from(ZoneOffset.UTC));
    BASE_ID = formatter.format(now).replaceAll("[:]", "").substring(0, 6);
  }

  private static final int _512KiB = 512 * 1024;
  private static final int _8MiB = 8 * 1024 * 1024;

  private final Transport transport;
  private final String projectId;
  private final String bucketName;
  private final String bucketName2;
  private final String userProject;
  private final String objectName;
  private final String topicName;

  private final Supplier<byte[]> lazyHelloWorldUtf8Bytes;
  private final Supplier<Path> helloWorldFilePath;
  private final ServiceAccountCredentials serviceAccountCredentials;

  private final String host;

  private final int scenarioId;
  private final Method method;
  private final InstructionList instruction;
  private final boolean preconditionsProvided;
  private final boolean expectSuccess;
  private final int mappingId;

  TestRetryConformance(
      Transport transport,
      String projectId,
      String host,
      int scenarioId,
      Method method,
      InstructionList instruction,
      boolean preconditionsProvided,
      boolean expectSuccess) {
    this(
        transport,
        projectId,
        host,
        scenarioId,
        method,
        instruction,
        preconditionsProvided,
        expectSuccess,
        0);
  }

  TestRetryConformance(
      Transport transport,
      String projectId,
      String host,
      int scenarioId,
      Method method,
      InstructionList instruction,
      boolean preconditionsProvided,
      boolean expectSuccess,
      int mappingId) {
    this.transport = transport;
    this.projectId = projectId;
    this.host = host;
    this.scenarioId = scenarioId;
    this.method = requireNonNull(method, "method must be non null");
    this.instruction = requireNonNull(instruction, "instruction must be non null");
    this.preconditionsProvided = preconditionsProvided;
    this.expectSuccess = expectSuccess;
    this.mappingId = mappingId;
    String instructionsString =
        this.instruction.getInstructionsList().stream()
            .map(s -> s.replace("return-", ""))
            .collect(Collectors.joining("_"));
    char transportTag = transport.name().toLowerCase().charAt(0);
    this.bucketName =
        String.format(
            Locale.US,
            "%s_s%03d-%s-m%03d_bkt1_%s",
            BASE_ID,
            scenarioId,
            instructionsString.toLowerCase(),
            mappingId,
            transportTag);
    this.bucketName2 =
        String.format(
            Locale.US,
            "%s_s%03d-%s-m%03d_bkt2_%s",
            BASE_ID,
            scenarioId,
            instructionsString.toLowerCase(),
            mappingId,
            transportTag);
    this.userProject =
        String.format(
            Locale.US,
            "%s_s%03d-%s-m%03d_prj1_%s",
            BASE_ID,
            scenarioId,
            instructionsString.toLowerCase(),
            mappingId,
            transportTag);
    this.objectName =
        String.format(
            Locale.US,
            "%s_s%03d-%s-m%03d_obj1_%s",
            BASE_ID,
            scenarioId,
            instructionsString.toLowerCase(),
            mappingId,
            transportTag);
    this.topicName =
        String.format(
            Locale.US,
            "%s_s%03d-%s-m%03d_top1_%s",
            BASE_ID,
            scenarioId,
            instructionsString.toLowerCase(),
            mappingId,
            transportTag);
    // define a lazy supplier for bytes.
    this.lazyHelloWorldUtf8Bytes =
        () -> genBytes(this.method, this.instruction.getInstructionsList());
    this.helloWorldFilePath =
        resolvePathForResource(objectName, method, this.instruction.getInstructionsList());
    this.serviceAccountCredentials = resolveServiceAccountCredentials();
  }

  public String getProjectId() {
    return projectId;
  }

  public String getHost() {
    return host;
  }

  public String getBucketName() {
    return bucketName;
  }

  public String getBucketName2() {
    return bucketName2;
  }

  public String getUserProject() {
    return userProject;
  }

  public String getObjectName() {
    return objectName;
  }

  public byte[] getHelloWorldUtf8Bytes() {
    return lazyHelloWorldUtf8Bytes.get();
  }

  public Path getHelloWorldFilePath() {
    return helloWorldFilePath.get();
  }

  public int getScenarioId() {
    return scenarioId;
  }

  public Method getMethod() {
    return method;
  }

  public InstructionList getInstruction() {
    return instruction;
  }

  public boolean isPreconditionsProvided() {
    return preconditionsProvided;
  }

  public boolean isExpectSuccess() {
    return expectSuccess;
  }

  public int getMappingId() {
    return mappingId;
  }

  public ServiceAccountSigner getServiceAccountSigner() {
    return serviceAccountCredentials;
  }

  public String getTestName() {
    String instructionsDesc = Joiner.on("_").join(instruction.getInstructionsList());
    return String.format(
        Locale.US,
        "TestRetryConformance/%s-%d-[%s]-%s-%d",
        transport.name().toLowerCase(),
        scenarioId,
        instructionsDesc,
        method.getName(),
        mappingId);
  }

  public Transport getTransport() {
    return transport;
  }

  @Override
  public String toString() {
    return getTestName();
  }

  public static Predicate<TestRetryConformance> transportIs(Transport transport) {
    return trc -> trc.getTransport() == transport;
  }

  private static Supplier<Path> resolvePathForResource(
      String objectName, Method method, List<String> instructionList) {
    return () -> {
      try {
        File tempFile = File.createTempFile(objectName, "");
        tempFile.deleteOnExit();

        byte[] bytes = genBytes(method, instructionList);
        try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            FileOutputStream out = new FileOutputStream(tempFile)) {
          long copy = ByteStreams.copy(in, out);
          assertThat(copy).isEqualTo(bytes.length);
        }

        return tempFile.toPath();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    };
  }

  private static ServiceAccountCredentials resolveServiceAccountCredentials() {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    InputStream inputStream =
        cl.getResourceAsStream(
            "com/google/cloud/conformance/storage/v1/test_service_account.not-a-test.json");
    assertNotNull(inputStream);
    try {
      return ServiceAccountCredentials.fromStream(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String getTopicName() {
    return topicName;
  }

  private static byte[] genBytes(Method method, List<String> instructionsList) {
    // Not all tests need data for an object, though some tests - resumable upload - needs
    // more than 8MiB.
    // We want to avoid allocating 8.1MiB for each test unnecessarily, especially since we
    // instantiate all permuted test cases. ~1000 * 8.1MiB ~~ > 8GiB.
    switch (method.getName()) {
      case "storage.objects.insert":
        boolean after8m = instructionsList.stream().anyMatch(s -> s.endsWith("after-8192K"));
        if (after8m) {
          return DataGenerator.base64Characters().genBytes(_8MiB * 2 + _512KiB);
        } else {
          return DataGenerator.base64Characters().genBytes(_512KiB);
        }
      case "storage.objects.get":
        return DataGenerator.base64Characters().genBytes(_512KiB);
      default:
        return "Hello, World!".getBytes(StandardCharsets.UTF_8);
    }
  }
}

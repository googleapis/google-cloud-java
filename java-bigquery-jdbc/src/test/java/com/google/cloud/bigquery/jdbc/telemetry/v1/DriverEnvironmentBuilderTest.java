/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class DriverEnvironmentBuilderTest {

  @Test
  public void testBuildDriverEnvironment() {
    DriverEnvironment env = DriverEnvironmentBuilder.build("1.2.0-SNAPSHOT");
    assertNotNull(env);
    assertEquals("google-bigquery-jdbc", env.getDriverName());
    assertEquals("1.2", env.getDriverVersion());
    assertEquals("java", env.getClientLanguage());
    assertNotNull(env.getClientLanguageVersion());
    assertNotNull(env.getOsType());
    assertNotNull(env.getOsVersion());
    assertNotNull(env.getTelemetryTag());
  }

  @Test
  public void testSanitizeVersion() {
    assertEquals("1.2", DriverEnvironmentBuilder.sanitizeVersion("1.2.0-SNAPSHOT"));
    assertEquals("2.5", DriverEnvironmentBuilder.sanitizeVersion("2.5"));
    assertEquals("0.0", DriverEnvironmentBuilder.sanitizeVersion(null));
    assertEquals("0.0", DriverEnvironmentBuilder.sanitizeVersion("   "));
    assertEquals("single", DriverEnvironmentBuilder.sanitizeVersion("single"));
  }

  @Test
  public void testGetMajorJavaVersion() {
    assertEquals("8", DriverEnvironmentBuilder.getMajorJavaVersion("1.8.0_292"));
    assertEquals("11", DriverEnvironmentBuilder.getMajorJavaVersion("11.0.12"));
    assertEquals("17", DriverEnvironmentBuilder.getMajorJavaVersion("17.0.1"));
    assertEquals("21", DriverEnvironmentBuilder.getMajorJavaVersion("21"));
    assertEquals("unknown", DriverEnvironmentBuilder.getMajorJavaVersion(null));
    assertEquals("unknown", DriverEnvironmentBuilder.getMajorJavaVersion("   "));
  }

  @Test
  public void testDetectOsType() {
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_WINDOWS,
        DriverEnvironmentBuilder.detectOsType("Windows 11"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_MACOS, DriverEnvironmentBuilder.detectOsType("Mac OS X"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_MACOS, DriverEnvironmentBuilder.detectOsType("Darwin"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_LINUX, DriverEnvironmentBuilder.detectOsType("Linux"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_SOLARIS, DriverEnvironmentBuilder.detectOsType("Solaris"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_FREEBSD, DriverEnvironmentBuilder.detectOsType("FreeBSD"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_OPENBSD, DriverEnvironmentBuilder.detectOsType("OpenBSD"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_NETBSD, DriverEnvironmentBuilder.detectOsType("NetBSD"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_AIX, DriverEnvironmentBuilder.detectOsType("AIX"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_UNKNOWN,
        DriverEnvironmentBuilder.detectOsType("UnknownOS"));
    assertEquals(
        DriverEnvironment.OsType.OS_TYPE_UNKNOWN, DriverEnvironmentBuilder.detectOsType(null));
  }

  @Test
  public void testGetMajorOsVersion() {
    assertEquals("10", DriverEnvironmentBuilder.getMajorOsVersion("10.0"));
    assertEquals("6", DriverEnvironmentBuilder.getMajorOsVersion("6.1.0"));
    assertEquals("5", DriverEnvironmentBuilder.getMajorOsVersion("5"));
    assertEquals("unknown", DriverEnvironmentBuilder.getMajorOsVersion(null));
    assertEquals("unknown", DriverEnvironmentBuilder.getMajorOsVersion("  "));
  }

  @Test
  public void testGetOrCreateTelemetryTag_CreateNew(@TempDir Path tempDir) {
    Path tagFile = tempDir.resolve("telemetry-tag");
    String tag = DriverEnvironmentBuilder.getOrCreateTelemetryTag(tagFile);

    assertNotNull(tag);
    assertTrue(Files.exists(tagFile));
    // Verify it is a valid UUID
    assertEquals(tag, UUID.fromString(tag).toString());
  }

  @Test
  public void testGetOrCreateTelemetryTag_ReadExisting(@TempDir Path tempDir) throws IOException {
    Path tagFile = tempDir.resolve("telemetry-tag");
    String existingUuid = UUID.randomUUID().toString();
    Files.write(tagFile, existingUuid.getBytes(StandardCharsets.UTF_8));

    String tag = DriverEnvironmentBuilder.getOrCreateTelemetryTag(tagFile);
    assertEquals(existingUuid, tag);
  }

  @Test
  public void testGetOrCreateTelemetryTag_RegenerateOnCorruptedFile(@TempDir Path tempDir)
      throws IOException {
    Path tagFile = tempDir.resolve("telemetry-tag");
    String corruptedContent = "not-a-valid-uuid";
    Files.write(tagFile, corruptedContent.getBytes(StandardCharsets.UTF_8));

    String newTag = DriverEnvironmentBuilder.getOrCreateTelemetryTag(tagFile);

    assertNotNull(newTag);
    assertNotEquals(corruptedContent, newTag);
    assertEquals(newTag, UUID.fromString(newTag).toString());
    // Verify file on disk was overwritten with new valid UUID
    String fileOnDisk = new String(Files.readAllBytes(tagFile), StandardCharsets.UTF_8).trim();
    assertEquals(newTag, fileOnDisk);
  }
}

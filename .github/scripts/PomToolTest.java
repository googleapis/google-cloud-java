// Copyright 2026 Google LLC
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

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Self-contained unit tests for {@link PomTool}. Can be run directly with {@code java
 * .github/scripts/PomToolTest.java}.
 */
public final class PomToolTest {

  private static final String SAMPLE_POM =
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
          + "<!-- Copyright 2026 Google LLC -->\n"
          + "<project xmlns=\"http://maven.apache.org/POM/4.0.0\">\n"
          + "  <modelVersion>4.0.0</modelVersion>\n"
          + "  <groupId>com.google.cloud</groupId>\n"
          + "  <artifactId>google-cloud-sample</artifactId>\n"
          + "  <version>1.0.0-SNAPSHOT</version>\n"
          + "  <properties>\n"
          + "    <google-cloud-shared-dependencies.version>3.1.0</google-cloud-shared-dependencies.version>\n"
          + "  </properties>\n"
          + "  <dependencies>\n"
          + "    <dependency>\n"
          + "      <groupId>com.google.cloud</groupId>\n"
          + "      <artifactId>google-cloud-shared-config</artifactId>\n"
          + "      <version>0.10.0</version>\n"
          + "    </dependency>\n"
          + "    <dependency>\n"
          + "      <groupId>com.google.guava</groupId>\n"
          + "      <artifactId>guava</artifactId>\n"
          + "    </dependency>\n"
          + "  </dependencies>\n"
          + "</project>\n";

  private static final String CHILD_POM_INHERITING_VERSION =
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
          + "<project xmlns=\"http://maven.apache.org/POM/4.0.0\">\n"
          + "  <modelVersion>4.0.0</modelVersion>\n"
          + "  <parent>\n"
          + "    <groupId>com.google.cloud</groupId>\n"
          + "    <artifactId>parent-pom</artifactId>\n"
          + "    <version>2.5.0</version>\n"
          + "  </parent>\n"
          + "  <artifactId>child-module</artifactId>\n"
          + "</project>\n";

  public static void main(String[] args) throws Exception {
    System.out.println("Running PomTool tests...");
    testGetProjectVersion();
    testInheritedParentVersion();
    testSetProjectVersion();
    testSetDependencyVersion();
    testSetPropertyVersion();
    testHasVersionedDependency();
    System.out.println("All PomTool tests passed successfully!");
  }

  private static void testGetProjectVersion() throws Exception {
    Path tempDir = Files.createTempDirectory("pomtool-test");
    File pomFile = tempDir.resolve("pom.xml").toFile();
    Files.writeString(pomFile.toPath(), SAMPLE_POM);

    String version = PomTool.getProjectVersion(pomFile);
    assertEquals("1.0.0-SNAPSHOT", version, "testGetProjectVersion");
  }

  private static void testInheritedParentVersion() throws Exception {
    Path tempDir = Files.createTempDirectory("pomtool-test");
    File pomFile = tempDir.resolve("pom.xml").toFile();
    Files.writeString(pomFile.toPath(), CHILD_POM_INHERITING_VERSION);

    String version = PomTool.getProjectVersion(pomFile);
    assertEquals("2.5.0", version, "testInheritedParentVersion");
  }

  private static void testSetProjectVersion() throws Exception {
    Path tempDir = Files.createTempDirectory("pomtool-test");
    File pomFile = tempDir.resolve("pom.xml").toFile();
    Files.writeString(pomFile.toPath(), SAMPLE_POM);

    PomTool.setProjectVersion(pomFile, "2.0.0");
    String updated = PomTool.getProjectVersion(pomFile);
    assertEquals("2.0.0", updated, "testSetProjectVersion");
  }

  private static void testSetDependencyVersion() throws Exception {
    Path tempDir = Files.createTempDirectory("pomtool-test");
    File pomFile = tempDir.resolve("pom.xml").toFile();
    Files.writeString(pomFile.toPath(), SAMPLE_POM);

    PomTool.setDependencyVersion(pomFile, "google-cloud-shared-config", "0.20.0");
    String content = Files.readString(pomFile.toPath());
    if (!content.contains("<version>0.20.0</version>")) {
      throw new AssertionError(
          "Expected <version>0.20.0</version> in pom.xml, but got:\n" + content);
    }
  }

  private static void testSetPropertyVersion() throws Exception {
    Path tempDir = Files.createTempDirectory("pomtool-test");
    File pomFile = tempDir.resolve("pom.xml").toFile();
    Files.writeString(pomFile.toPath(), SAMPLE_POM);

    PomTool.setPropertyVersion(pomFile, "google-cloud-shared-dependencies.version", "4.0.0");
    String content = Files.readString(pomFile.toPath());
    if (!content.contains(
        "<google-cloud-shared-dependencies.version>4.0.0</google-cloud-shared-dependencies.version>")) {
      throw new AssertionError("Expected updated property in pom.xml, but got:\n" + content);
    }
  }

  private static void testHasVersionedDependency() throws Exception {
    Path tempDir = Files.createTempDirectory("pomtool-test");
    File pomFile = tempDir.resolve("pom.xml").toFile();
    Files.writeString(pomFile.toPath(), SAMPLE_POM);

    if (!PomTool.hasVersionedDependency(pomFile, "google-cloud-shared-config")) {
      throw new AssertionError(
          "Expected hasVersionedDependency=true for google-cloud-shared-config");
    }
    if (PomTool.hasVersionedDependency(pomFile, "guava")) {
      throw new AssertionError("Expected hasVersionedDependency=false for unversioned guava");
    }
    if (PomTool.hasVersionedDependency(pomFile, "non-existent")) {
      throw new AssertionError("Expected hasVersionedDependency=false for non-existent dependency");
    }
  }

  private static void assertEquals(String expected, String actual, String testName) {
    if (!expected.equals(actual)) {
      throw new AssertionError(
          testName + " failed: expected [" + expected + "] but got [" + actual + "]");
    }
  }
}

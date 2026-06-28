/*
 * Copyright 2026 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.cloud.tools.opensource.dependencies.MavenRepositoryException;
import com.google.common.base.Verify;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.eclipse.aether.artifact.Artifact;

/**
 * Creates a Maven project that uses the specified BOM at the specified directory. This class reads
 * the following system properties:
 *
 * <ul>
 *   <li>outputPath: the path to the directory to create the Maven project
 *   <li>bomPath: the path to the BOM
 * </ul>
 */
public class CreateBomCanaryProject {

  public static void main(String[] arguments) throws Exception {
    String outputPathProperty = System.getProperty("outputPath");
    checkNotNull(outputPathProperty, "System property outputPath should not be null");
    Path outputProjectDirectory = Paths.get(outputPathProperty);
    String bomPathProperty = System.getProperty("bomPath");
    checkNotNull(bomPathProperty, "System property bomPath should not be null");
    Path bomPath = Paths.get(bomPathProperty);

    Bom bom;
    try {
      bom = Bom.readBom(bomPath);
    } catch (MavenRepositoryException exception) {
      throw new IOException(
          "Could not read the BOM: "
              + bomPath
              + ". Please ensure all artifacts in the BOM are available in Maven Central or local"
              + " Maven repository.",
          exception);
    }

    String pomTemplate = readPomTemplate();

    String dependencyManagementSection = calculateDependencyManagementSection(bom);
    String dependenciesSection = calculateDependenciesSection(bom);

    String replacedContent =
        pomTemplate
            .replace("DEPENDENCY_MANAGEMENT", dependencyManagementSection)
            .replace("DEPENDENCIES", dependenciesSection);

    Path pomToWrite = outputProjectDirectory.resolve("pom.xml");
    Files.write(pomToWrite, replacedContent.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    System.out.println("Wrote " + pomToWrite);
  }

  /** Returns the pom.xml template content. */
  private static String readPomTemplate() throws IOException {
    try (InputStream inputStream =
        CreateBomCanaryProject.class.getClassLoader().getResourceAsStream("template.pom.xml")) {
      Verify.verifyNotNull(inputStream);
      return new String(
          com.google.common.io.ByteStreams.toByteArray(inputStream),
          java.nio.charset.StandardCharsets.UTF_8);
    }
  }

  /** Returns the dependencyManagement section to import {@code bom}. */
  private static String calculateDependencyManagementSection(Bom bom) {
    String[] coordinatesElements = bom.getCoordinates().split(":");
    Verify.verify(coordinatesElements.length == 3);
    String groupId = coordinatesElements[0];
    String artifactId = coordinatesElements[1];
    String version = coordinatesElements[2];

    StringBuilder builder = new StringBuilder();
    builder.append("  <dependencyManagement>\n");
    builder.append("    <dependencies>\n");
    builder.append("      <dependency>\n");
    builder.append("        <groupId>").append(groupId).append("</groupId>\n");
    builder.append("        <artifactId>").append(artifactId).append("</artifactId>\n");
    builder.append("        <version>").append(version).append("</version>\n");
    builder.append("        <type>pom</type>\n");
    builder.append("        <scope>import</scope>\n");
    builder.append("      </dependency>\n");
    builder.append("    </dependencies>\n");
    builder.append("  </dependencyManagement>\n");
    return builder.toString();
  }

  /** Returns the "dependencies" section that would declare all artifacts appear in {@code bom}. */
  private static String calculateDependenciesSection(Bom bom) {
    StringBuilder builder = new StringBuilder();
    builder.append("  <dependencies>\n");

    for (Artifact managedDependency : bom.getManagedDependencies()) {
      Map<String, String> properties = managedDependency.getProperties();
      String classifier = managedDependency.getClassifier();
      if ("tests".equals(classifier)) {
        // Tests classifier artifacts are not for customers
        continue;
      }
      String type = properties.get("type");
      if ("pom".equals(type)) {
        // Some artifacts have :pom" type, such as io.grpc:protoc-gen-grpc-java
        // and com.google.api-client:google-api-client-assembly. We are only interested
        // in "jar" artifacts.
        continue;
      }

      // Skipping grpc-android, grpc-binder and grpc-cronet as they are not used by Google Cloud
      // Client Libraries for Java. Checking for availability of these unused artifacts on Maven
      // Central has caused BOM validation check to fail in the past. See
      // https://github.com/googleapis/sdk-platform-java/pull/1989#issuecomment-1724039670
      if ("grpc-android".equals(managedDependency.getArtifactId())
          || "grpc-binder".equals(managedDependency.getArtifactId())
          || "grpc-cronet".equals(managedDependency.getArtifactId())) {
        continue;
      }

      builder.append("    <dependency>\n");
      builder
          .append("      <groupId>")
          .append(managedDependency.getGroupId())
          .append("</groupId>\n");
      builder
          .append("      <artifactId>")
          .append(managedDependency.getArtifactId())
          .append("</artifactId>\n");
      builder.append("    </dependency>\n");
    }
    builder.append("  </dependencies>\n");

    return builder.toString();
  }
}

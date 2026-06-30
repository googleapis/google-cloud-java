/*
 * Copyright 2022 Google LLC.
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

import static org.junit.Assert.assertTrue;

import com.google.cloud.tools.opensource.classpath.ClassPathBuilder;
import com.google.cloud.tools.opensource.classpath.ClassPathEntry;
import com.google.cloud.tools.opensource.classpath.ClassPathResult;
import com.google.cloud.tools.opensource.classpath.DependencyMediation;
import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.cloud.tools.opensource.dependencies.DependencyPath;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.aether.artifact.Artifact;
import org.junit.Test;

/**
 * Test to ensure that certain artifacts in the dependency tree of each entry of the shared
 * dependencies BOM have the same version.
 */
public class DependencyConvergenceTest {

  @Test
  public void testGrpcConvergence() throws Exception {
    // There were cases where the gRPC version set in the shared dependencies BOM and the gRPC
    // version declared in gax-grpc's dependency broke the build of downstream projects. Two
    // artifacts were using version range to specify exact gRPC versions.
    // https://github.com/googleapis/java-shared-dependencies/pull/595
    Bom bom = Bom.readBom(Paths.get("../pom.xml"));
    assertConvergence(
        bom,
        "io.grpc",
        "grpc-netty-shaded",
        ImmutableSet.of(
            // Because OpenCensus's gRPC version does not use version range notation, it does not
            // break downstream build
            "opencensus-exporter-trace-stackdriver",
            "opencensus-exporter-stats-stackdriver",
            // Because grpc-gcp's gRPC version does not use version range notation, it does not
            // break downstream build
            "grpc-gcp",
            // Because native-image-support's gRPC dependency is provided scope, it does not bring
            // inconsistent gRPC artifacts to users' class paths.
            "native-image-support"));
  }

  /**
   * Asserts the artifact specified at {@code groupId} and {@code artifactId} have the same version
   * across the dependency trees of the managed dependencies of {@code bom}.
   *
   * <p>Use {@code excludingArtifactIds} to ignore certain artifacts.
   */
  private void assertConvergence(
      Bom bom, String groupId, String artifactId, Set<String> excludingArtifactIds)
      throws Exception {
    ImmutableList<Artifact> managedDependencies = bom.getManagedDependencies();

    Set<DependencyPath> foundPaths = new HashSet<>();
    Set<String> foundVersions = new HashSet<>();
    for (Artifact managedDependency : managedDependencies) {
      if (excludingArtifactIds.contains(managedDependency.getArtifactId())) {
        continue;
      }

      ClassPathBuilder classPathBuilder = new ClassPathBuilder();
      ClassPathResult result =
          classPathBuilder.resolve(
              ImmutableList.of(managedDependency), false, DependencyMediation.MAVEN);
      ImmutableList<ClassPathEntry> classPath = result.getClassPath();
      for (ClassPathEntry entry : classPath) {
        Artifact artifact = entry.getArtifact();
        if (artifactId.equals(artifact.getArtifactId()) && groupId.equals(artifact.getGroupId())) {
          ImmutableList<DependencyPath> dependencyPaths = result.getDependencyPaths(entry);
          foundPaths.add(dependencyPaths.get(0));
          foundVersions.add(artifact.getVersion());
        }
      }
    }

    assertTrue(
        "There should be at least one version in the graph but empty; "
            + "please check the assertion is using correct groupID and artifactID.",
        foundVersions.size() >= 1);

    // Duplicate versions found in the dependency trees
    assertTrue(
        "The version for "
            + groupId
            + ":"
            + artifactId
            + " should be one but there are multiple of them: "
            + Joiner.on(", ").join(foundPaths),
        foundVersions.size() <= 1);
  }
}

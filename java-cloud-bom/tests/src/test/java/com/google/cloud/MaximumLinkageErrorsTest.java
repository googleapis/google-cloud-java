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

import com.google.cloud.tools.opensource.classpath.ClassPathBuilder;
import com.google.cloud.tools.opensource.classpath.ClassPathEntry;
import com.google.cloud.tools.opensource.classpath.ClassPathResult;
import com.google.cloud.tools.opensource.classpath.DependencyMediation;
import com.google.cloud.tools.opensource.classpath.LinkageChecker;
import com.google.cloud.tools.opensource.classpath.LinkageProblem;
import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.cloud.tools.opensource.dependencies.DependencyGraphBuilder;
import com.google.cloud.tools.opensource.dependencies.MavenRepositoryException;
import com.google.cloud.tools.opensource.dependencies.RepositoryUtility;
import com.google.cloud.tools.opensource.dependencies.UnresolvableArtifactProblem;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.eclipse.aether.RepositoryException;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.version.InvalidVersionSpecificationException;
import org.junit.Assert;
import org.junit.Test;

public class MaximumLinkageErrorsTest {

  @Test
  public void testForNewLinkageErrors()
      throws IOException, MavenRepositoryException, RepositoryException {
    // Not using RepositoryUtility.findLatestCoordinates, which may return a snapshot version
    String version = findLatestNonSnapshotVersion();
    String baselineCoordinates = "com.google.cloud:libraries-bom:" + version;
    Bom baseline = Bom.readBom(baselineCoordinates);

    Path bomFile = Paths.get("../libraries-bom/pom.xml");
    Bom bom = Bom.readBom(bomFile);

    ImmutableSet<LinkageProblem> oldProblems = createLinkageChecker(baseline).findLinkageProblems();
    LinkageChecker checker = createLinkageChecker(bom);
    ImmutableSet<LinkageProblem> currentProblems = checker.findLinkageProblems();

    // This only tests for newly missing methods, not new invocations of
    // previously missing methods.
    Set<LinkageProblem> newProblems = Sets.difference(currentProblems, oldProblems);

    // Appengine-api-1.0-sdk is known to contain linkage errors because it shades dependencies
    // https://github.com/GoogleCloudPlatform/cloud-opensource-java/issues/441
    newProblems =
        newProblems.stream()
            .filter(problem -> !hasLinkageProblemFromArtifactId(problem, "appengine-api-1.0-sdk"))
            .filter(problem -> isFirstPartyArtifact(problem))
            .collect(Collectors.toSet());

    // Check that no new linkage errors have been introduced since the baseline
    StringBuilder message = new StringBuilder("Baseline BOM: " + baselineCoordinates + "\n");
    if (!newProblems.isEmpty()) {
      message.append("Newly introduced problems:\n");
      message.append(LinkageProblem.formatLinkageProblems(newProblems, null));
      Assert.fail(message.toString());
    }
  }

  private LinkageChecker createLinkageChecker(Bom bom)
      throws InvalidVersionSpecificationException, IOException {
    ImmutableList<Artifact> managedDependencies = bom.getManagedDependencies();
    List<Artifact> filteredManagedDependencies =
        managedDependencies.stream()
            .filter(artifact -> !"tests".equals(artifact.getClassifier()))
            .collect(Collectors.toList());
    DependencyGraphBuilder graphBuilder =
        new DependencyGraphBuilder(
            ImmutableList.of(
                "https://repo1.maven.org/maven2/",
                "https://google.oss.sonatype.org/content/repositories/snapshots/",
                "https://maven.google.com/"));
    ClassPathBuilder classPathBuilder = new ClassPathBuilder(graphBuilder);

    // full: false to avoid fetching optional dependencies.
    ClassPathResult classPathResult =
        classPathBuilder.resolve(filteredManagedDependencies, false, DependencyMediation.MAVEN);
    ImmutableList<ClassPathEntry> classpath = classPathResult.getClassPath();
    ImmutableList<UnresolvableArtifactProblem> artifactProblems =
        classPathResult.getArtifactProblems();
    List<UnresolvableArtifactProblem> realProblems =
        artifactProblems.stream()
            .filter(
                problem -> {
                  Artifact artifact = problem.getArtifact();
                  if ("com.google.android.google-play-services".equals(artifact.getGroupId())
                      && "google-play-services".equals(artifact.getArtifactId())) {
                    return false; // Ignore legacy provided dependency which is not public
                  }
                  return true;
                })
            .collect(Collectors.toList());
    if (!realProblems.isEmpty()) {
      throw new IOException("Could not resolve artifacts: " + realProblems);
    }
    List<ClassPathEntry> artifactsInBom = classpath.subList(0, filteredManagedDependencies.size());
    ImmutableSet<ClassPathEntry> entryPoints = ImmutableSet.copyOf(artifactsInBom);
    return LinkageChecker.create(classpath, entryPoints, ImmutableList.of(), null);
  }

  private boolean hasLinkageProblemFromArtifactId(LinkageProblem problem, String artifactId) {
    ClassPathEntry sourceClassPathEntry = problem.getSourceClass().getClassPathEntry();
    Artifact sourceArtifact = sourceClassPathEntry.getArtifact();
    return artifactId.equals(sourceArtifact.getArtifactId());
  }

  /**
   * Returns true if the linkage problem originates from a first-party runtime artifact.
   *
   * <p>This filter is necessary to ignore false positive linkage errors that originate inside
   * third-party dependencies (e.g., jackson-module-scala which fails due to missing Scala runtimes
   * on the classpath) or build-time tools (like gapic-generator-java which uses Java 9+ bytecode
   * that is invalid against Java 8 runtimes).
   *
   * <p>Since client libraries are pure Java libraries and do not expose these language bindings or
   * build-time tools at runtime, those warnings can be safely ignored to prevent false positive
   * build failures when core dependencies are upgraded.
   */
  private boolean isFirstPartyArtifact(LinkageProblem problem) {
    ClassPathEntry sourceClassPathEntry = problem.getSourceClass().getClassPathEntry();
    Artifact sourceArtifact = sourceClassPathEntry.getArtifact();
    String groupId = sourceArtifact.getGroupId();
    String artifactId = sourceArtifact.getArtifactId();
    if (groupId.equals("com.google.cloud")) {
      return true;
    }
    if (groupId.equals("com.google.api") && !artifactId.equals("gapic-generator-java")) {
      return true;
    }
    return false;
  }

  private String findLatestNonSnapshotVersion() throws MavenRepositoryException {
    ImmutableList<String> versions =
        RepositoryUtility.findVersions(
            RepositoryUtility.newRepositorySystem(), "com.google.cloud", "libraries-bom");
    ImmutableList<String> versionsLatestFirst = versions.reverse();
    Optional<String> highestNonsnapshotVersion =
        versionsLatestFirst.stream().filter(version -> !version.contains("SNAPSHOT")).findFirst();
    if (!highestNonsnapshotVersion.isPresent()) {
      Assert.fail("Could not find non-snapshot version of the BOM");
    }
    return highestNonsnapshotVersion.get();
  }
}

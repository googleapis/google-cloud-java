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
import com.google.cloud.tools.opensource.dependencies.Artifacts;
import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.cloud.tools.opensource.dependencies.DependencyPath;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Verify;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.util.version.GenericVersionScheme;
import org.eclipse.aether.version.InvalidVersionSpecificationException;
import org.eclipse.aether.version.Version;
import org.eclipse.aether.version.VersionScheme;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class BomContentTest {
  private static VersionScheme versionScheme = new GenericVersionScheme();

  // List of Maven dependency scopes that are visible to library users. For example "provided" scope
  // dependencies do not appear in users' class path.
  private static final ImmutableList<String> dependencyScopesVisibleToUsers =
      ImmutableList.of("compile", "runtime");

  @Test
  public void testLibrariesBom() throws Exception {
    Path bomPath = Paths.get("..", "libraries-bom", "pom.xml").toAbsolutePath();
    checkBom(bomPath);
  }

  @Ignore(
      "Our release process hasn't achieved the complete convergence yet. "
          + "See https://github.com/googleapis/java-cloud-bom/issues/5757")
  @Test
  public void testLibrariesBOMCloudClientConvergence() throws Exception {
    Path bomPath = Paths.get("..", "libraries-bom", "pom.xml").toAbsolutePath();
    assertDependencyConvergenceWithinCloudJavaLibraries(Bom.readBom(bomPath));
  }

  private void checkBom(Path bomPath) throws Exception {
    Bom bom = Bom.readBom(bomPath);
    List<Artifact> artifacts = bom.getManagedDependencies();
    for (Artifact artifact : artifacts) {
      if (artifact.getVersion().contains("SNAPSHOT")) {
        continue;
      }
      // If the artifact is built locally (e.g. during a release PR), it will be in the local
      // .m2 cache. We can skip checking Maven Central for these local artifacts since they
      // are not yet published.
      if (existsLocally(artifact)) {
        continue;
      }
      assertReachable(buildMavenCentralUrl(artifact));
    }

    assertNoDowngradeRule(bom);
    assertUniqueClasses(artifacts);
    assertBomIsImported(bom);
  }

  /**
   * Ensures that the content of the libraries BOM exist in Maven Central. This check should run in
   * every pull request, not just release pull requests.
   */
  @Test
  public void testLibrariesBomReachable() throws Exception {
    Path bomPath = Paths.get("..", "libraries-bom", "pom.xml").toAbsolutePath();
    checkBomReachable(bomPath);
  }

  @VisibleForTesting
  static void checkBomReachable(Path bomPath) throws Exception {
    Bom bom = Bom.readBom(bomPath);
    List<Artifact> artifacts = bom.getManagedDependencies();

    StringBuilder errors = new StringBuilder();
    for (Artifact artifact : artifacts) {
      if (artifact.getVersion().contains("SNAPSHOT")) {
        continue;
      }
      // If the artifact is built locally (e.g. during a release PR), it will be in the local
      // .m2 cache. We can skip checking Maven Central for these local artifacts since they
      // are not yet published.
      if (existsLocally(artifact)) {
        continue;
      }
      try {
        assertReachable(buildMavenCentralUrl(artifact));
      } catch (IOException ex) {
        errors.append(ex.getMessage() + "\n");
      }
    }
    if (errors.length() != 0) {
      throw new IOException(errors.toString());
    }
  }

  private static String buildMavenCentralUrl(Artifact artifact) {
    // Due to a maven caching issue, accessing an artifact using the directory link (e.g
    // https://repo1.maven.org/maven2/com/google/cloud/google-cloud-bigtable/2.23.2)
    // results in a `404 Not Found` error even if the artifact is published but using a
    // nested file within the directory works (e.g.
    // https://repo1.maven.org/maven2/com/google/cloud/google-cloud-bigtable/2.23.2/google-cloud-bigtable-2.23.2.pom)
    return "https://repo1.maven.org/maven2/"
        + artifact.getGroupId().replace('.', '/')
        + "/"
        + artifact.getArtifactId()
        + "/"
        + artifact.getVersion()
        + "/"
        + artifact.getArtifactId()
        + "-"
        + artifact.getVersion()
        + ".pom";
  }

  /**
   * Checks if the artifact exists in the local Maven repository cache. This is used as a
   * fallback/bypass for reachability checks during release PRs.
   */
  private static boolean existsLocally(Artifact artifact) {
    String localRepository = System.getProperty("maven.repo.local");
    if (localRepository == null) {
      // Standard default location for Maven local repository.
      localRepository = System.getProperty("user.home") + "/.m2/repository";
    }
    Path localPath =
        Paths.get(
            localRepository,
            artifact.getGroupId().replace('.', '/'),
            artifact.getArtifactId(),
            artifact.getVersion(),
            artifact.getArtifactId() + "-" + artifact.getVersion() + ".pom");
    return Files.exists(localPath);
  }

  /** Asserts that the BOM only provides JARs which contains unique class names to the classpath. */
  private static void assertUniqueClasses(List<Artifact> allArtifacts)
      throws InvalidVersionSpecificationException, IOException {

    StringBuilder errorMessageBuilder = new StringBuilder();

    ClassPathBuilder classPathBuilder = new ClassPathBuilder();
    ClassPathResult result =
        classPathBuilder.resolve(allArtifacts, false, DependencyMediation.MAVEN);

    // A Map of every class name to its artifact ID.
    HashMap<String, String> fullClasspathMap = new HashMap<>();

    for (ClassPathEntry classPathEntry : result.getClassPath()) {
      Artifact currentArtifact = classPathEntry.getArtifact();

      if (!currentArtifact.getGroupId().contains("google")
          || currentArtifact.getGroupId().contains("com.google.android")
          || currentArtifact.getGroupId().contains("com.google.cloud.bigtable")
          || currentArtifact.getGroupId().equals("com.google.code.findbugs")
          || currentArtifact.getGroupId().equals("com.google.auto.value")
          || currentArtifact.getArtifactId().startsWith("proto-")
          || currentArtifact.getArtifactId().equals("protobuf-javalite")
          || currentArtifact.getArtifactId().equals("appengine-testing")) {
        // Skip libraries that produce false positives.
        // See: https://github.com/GoogleCloudPlatform/cloud-opensource-java/issues/2226
        continue;
      }

      if (currentArtifact.getGroupId().equals("com.google.api")
          && currentArtifact.getArtifactId().equals("gapic-generator-java")) {
        // Skip gapic-generator-java artifact, which is part of gapic-generator-java-bom
        // but not intended to be client library user-facing. It has copied classes of its
        // dependencies in it.
        continue;
      }

      String artifactCoordinates = Artifacts.toCoordinates(currentArtifact);

      for (String className : classPathEntry.getFileNames()) {
        if (className.contains("javax.annotation")
            || className.contains("$")
            || className.endsWith("package-info")
            || className.endsWith("module-info")
            || className.equals("com.google.cloud.location.LocationsGrpc")
            || className.equals("com.google.gwt.core.client.UnsafeNativeLong")) {
          // Ignore annotations, nested classes, module-info and package-info files.
          // Ignore LocationsGrpc classes which are duplicated in generated grpc libraries.
          // Ignore GWT's UnsafeNativeLong, which appear in om.google.gwt:gwt-dev:2.9.0 and
          // com.google.jsinterop:base:1.0.0.
          continue;
        }

        String previousArtifact = fullClasspathMap.get(className);

        if (previousArtifact != null) {
          String msg =
              String.format(
                  "Duplicate class %s found in classpath. Found in artifacts %s and %s.\n",
                  className, previousArtifact, artifactCoordinates);
          errorMessageBuilder.append(msg);
        } else {
          fullClasspathMap.put(className, artifactCoordinates);
        }
      }
    }

    String error = errorMessageBuilder.toString();
    Assert.assertTrue(
        "Failing test due to duplicate classes found on classpath:\n" + error, error.isEmpty());
  }

  private static void assertReachable(String url) throws IOException {
    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
    connection.setRequestMethod("HEAD");
    int responseCode = connection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
      throw new IOException("Received 404 response from invalid artifact " + url);
    }
    Assert.assertEquals(
        "Could not reach " + url, HttpURLConnection.HTTP_OK, connection.getResponseCode());
  }

  /**
   * Asserts that the members of the {@code bom} satisfy the no-downgrade rule. This rule means that
   * the members have the highest versions among the dependencies of them. If there's a violation,
   * users of the BOM would see our BOM downgrading certain dependencies. Downgrading a dependency
   * is bad practice in general because newer versions have more features (classes and methods).
   *
   * <p>For example, if google-http-client 1.40.1 is in the BOM, then no other libraries in the BOM
   * depend on the higher version of the google-http-client.
   *
   * @param bom the BOM to assert with this no-downgrade rule.
   */
  private static void assertNoDowngradeRule(Bom bom) throws InvalidVersionSpecificationException {
    List<String> violations = new ArrayList<>();
    Map<String, Artifact> bomArtifacts = new HashMap<>();
    for (Artifact artifact : bom.getManagedDependencies()) {
      bomArtifacts.put(Artifacts.makeKey(artifact), artifact);
    }

    for (Artifact artifact : bom.getManagedDependencies()) {
      violations.addAll(findNoDowngradeViolation(bomArtifacts, artifact));
    }

    String violationMessage = Joiner.on("\n").join(violations);
    Assert.assertTrue(violationMessage, violations.isEmpty());
  }

  /**
   * Returns messages describing the violation of the no-downgrade rule by {@code artifact} against
   * the BOM containing {@code bomArtifacts}. An empty list if there is no violations.
   */
  private static ImmutableList<String> findNoDowngradeViolation(
      Map<String, Artifact> bomArtifacts, Artifact artifact)
      throws InvalidVersionSpecificationException {
    ImmutableList.Builder<String> violations = ImmutableList.builder();

    ClassPathBuilder classPathBuilder = new ClassPathBuilder();
    ClassPathResult result =
        classPathBuilder.resolve(ImmutableList.of(artifact), false, DependencyMediation.MAVEN);
    for (ClassPathEntry entry : result.getClassPath()) {
      Artifact transitiveDependency = entry.getArtifact();
      String key = Artifacts.makeKey(transitiveDependency);
      Artifact bomArtifact = bomArtifacts.get(key);
      if (bomArtifact == null) {
        // transitiveDependency is not part of the BOM
        continue;
      }

      Version versionInBom = versionScheme.parseVersion(bomArtifact.getVersion());
      Version versionInTransitiveDependency =
          versionScheme.parseVersion(transitiveDependency.getVersion());

      if (versionInTransitiveDependency.compareTo(versionInBom) <= 0) {
        // When versionInTransitiveDependency is less than or equal to versionInBom, it satisfies
        // the no-downgrade rule.
        continue;
      }

      // Filter by scopes that are invisible to library users
      ImmutableList<DependencyPath> dependencyPaths = result.getDependencyPaths(entry);
      Verify.verify(
          !dependencyPaths.isEmpty(),
          "The class path entry should have at least one dependency path from the root");
      boolean dependencyVisibleToUsers = false;
      for (DependencyPath dependencyPath : dependencyPaths) {
        int length = dependencyPath.size();
        // As the root element is an empty node, the last element is at "length - 2".
        Dependency dependency = dependencyPath.getDependency(length - 2);
        if (dependencyScopesVisibleToUsers.contains(dependency.getScope())) {
          dependencyVisibleToUsers = true;
          break;
        }
      }
      if (!dependencyVisibleToUsers) {
        // For provided-scope dependencies, we don't have to worry about them because they don't
        // appear in library users' class path. For example, appengine-api-1.0-sdk are used via
        // provided scope.
        continue;
      }

      // A violation of the no-downgrade rule is found.
      violations.add(
          artifact
              + " has a transitive dependency "
              + transitiveDependency
              + ". This is higher version than "
              + bomArtifact
              + " in the BOM. Example dependency path: "
              + dependencyPaths.get(0));
    }
    return violations.build();
  }

  private void assertBomIsImported(Bom bom) {
    // BOMs must be declared as "import" type. Otherwise, the BOM users would see
    // "google-cloud-XXX-bom" as an artifact declared in the BOM, not the content of it.
    for (Artifact artifact : bom.getManagedDependencies()) {
      String artifactId = artifact.getArtifactId();
      Assert.assertFalse(
          artifactId + " must be declared with import type", artifactId.endsWith("-bom"));
    }
  }

  /**
   * Asserts that the Cloud Java client libraries in the BOM depend on the exact versions of other
   * Cloud Java client libraries.
   *
   * <p>For example, it's a violation when
   *
   * <ul>
   *   <li>google-cloud-spanner-jdbc 2.5.11 and
   *   <li>google-cloud-spanner 6.19.0
   * </ul>
   *
   * <p>are included in a BOM and the former depends on google-cloud-spanner 6.18.0.
   *
   * <p>Note that dependency-convergence check (dependencyConvergence enforcer rule) does not help
   * this case because these are managed dependencies, making the versions falsely converged.
   */
  @VisibleForTesting
  static void assertDependencyConvergenceWithinCloudJavaLibraries(Bom bom)
      throws InvalidVersionSpecificationException {
    Map<String, Artifact> bomArtifacts = new HashMap<>();
    for (Artifact artifact : bom.getManagedDependencies()) {
      if (artifact.getArtifactId().startsWith("google-cloud")) {
        bomArtifacts.put(Artifacts.makeKey(artifact), artifact);
      }
    }

    ClassPathBuilder classPathBuilder = new ClassPathBuilder();

    List<String> errorMessages = new ArrayList<>();
    for (Artifact managedDependency : bom.getManagedDependencies()) {
      ClassPathResult result =
          classPathBuilder.resolve(
              ImmutableList.of(managedDependency), false, DependencyMediation.MAVEN);

      for (ClassPathEntry classPathEntry : result.getClassPath()) {
        // Found direct dependency
        Artifact dependency = classPathEntry.getArtifact();
        if (!dependency.getArtifactId().startsWith("google-cloud-")) {
          continue;
        }

        ImmutableList<DependencyPath> dependencyPaths = result.getDependencyPaths(classPathEntry);
        for (DependencyPath dependencyPath : dependencyPaths) {
          if (dependencyPath.size() != 2) {
            // Not checking direct dependency because non-direct dependencies cannot be controlled
            // by the library (the one in `classPathEntry`) itself.
            break;
          }

          // Direct dependency found
          String key = Artifacts.makeKey(dependency);
          if (bomArtifacts.containsKey(key)) {
            Artifact expectedArtifact = bomArtifacts.get(key);
            String expectedVersion = expectedArtifact.getVersion();

            if (!expectedVersion.equals(dependency.getVersion())) {
              errorMessages.add(
                  "Managed dependency "
                      + managedDependency
                      + " has dependency "
                      + dependency
                      + ", which should be "
                      + expectedVersion
                      + " (the version in the BOM)");
            }
          }
        }
      }
    }

    if (!errorMessages.isEmpty()) {
      errorMessages.add(
          "\nThis means we are about to release an SDK ("
              + bom.getCoordinates()
              + ") and we did not test these combinations. "
              + "Please update the dependencies of the libraries above and release them.");
      Assert.fail(Joiner.on(". ").join(errorMessages));
    }
  }
}

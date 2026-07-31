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

package com.google.cloud.tools.opensource.cloudbomdashboard;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.cloud.tools.opensource.dependencies.DependencyGraph;
import com.google.cloud.tools.opensource.dependencies.DependencyGraphBuilder;
import com.google.cloud.tools.opensource.dependencies.MavenRepositoryException;
import com.google.cloud.tools.opensource.dependencies.RepositoryUtility;
import com.google.cloud.tools.opensource.dependencies.Update;
import com.google.cloud.tools.opensource.dependencies.VersionComparator;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multimap;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateHashModel;
import freemarker.template.Version;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import org.apache.commons.cli.ParseException;
import org.apache.maven.artifact.versioning.ComparableVersion;
import org.eclipse.aether.RepositoryException;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;

public class DashboardMain {

  public static final String basePath = "https://repo1.maven.org/maven2";
  public static final String TEST_NAME_UPPER_BOUND = "Upper Bounds";
  public static final String TEST_NAME_DEPENDENCY_CONVERGENCE = "Dependency Convergence";

  private static final Configuration freemarkerConfiguration = configureFreemarker();

  private static final DependencyGraphBuilder dependencyGraphBuilder = new DependencyGraphBuilder();

  private static final List<String> bomVersions = new ArrayList<>();

  /**
   * Generates a code hygiene dashboard for a BOM. This tool takes a path to pom.xml of the BOM as
   * an argument or Maven coordinates to a BOM.
   *
   * <p>Generated dashboard is at {@code target/$groupId/$artifactId/$version/index.html}, where
   * each value is from BOM coordinates except {@code $version} is "snapshot" if the BOM has
   * snapshot version.
   */
  public static void main(String[] arguments)
      throws IOException,
          TemplateException,
          RepositoryException,
          URISyntaxException,
          ParseException,
          MavenRepositoryException {
    DashboardArguments dashboardArguments = DashboardArguments.readCommandLine(arguments);

    // If looking to edit the dashboard structure, see DashboardMain#generateDashboard.
    if (dashboardArguments.hasVersionlessCoordinates()) {
      generateAllVersions(dashboardArguments.getVersionlessCoordinates());
      return;
    }

    Bom bom;
    if (dashboardArguments.hasFile()) {
      Path bomFile = dashboardArguments.getBomFile();
      checkArgument(
          Files.isRegularFile(bomFile), "The input BOM %s is not a regular file", bomFile);
      checkArgument(Files.isReadable(bomFile), "The input BOM %s is not readable", bomFile);
      bom = Bom.readBom(bomFile);
    } else {
      bom = Bom.readBom(dashboardArguments.getBomCoordinates());
    }

    if (dashboardArguments.getReport()) {
      if (!report(bom, System.out)) {
        throw new RuntimeException("Failed to converge dependencies");
      }
    } else {
      generate(bom);
    }

    if (dashboardArguments.getOutputFile() != null) {
      Path relativePath = dashboardArguments.getOutputFile();
      Files.createDirectories(relativePath.getParent());
      File file = new File(String.valueOf(relativePath));
      try (OutputStream outputStream = new FileOutputStream(file)) {
        if (!report(bom, outputStream)) {
          throw new RuntimeException("Failed to converge dependencies");
        }
      }
    }
  }

  private static void generateAllVersions(String versionlessCoordinates)
      throws IOException,
          TemplateException,
          RepositoryException,
          URISyntaxException,
          MavenRepositoryException {
    List<String> elements = Splitter.on(':').splitToList(versionlessCoordinates);
    checkArgument(
        elements.size() == 2,
        "The versionless coordinates should have one colon character: " + versionlessCoordinates);
    String groupId = elements.get(0);
    String artifactId = elements.get(1);

    RepositorySystem repositorySystem = RepositoryUtility.newRepositorySystem();
    ImmutableList<String> versions =
        RepositoryUtility.findVersions(repositorySystem, groupId, artifactId);
    for (String version : versions) {
      if (version.contains("alpha")) {
        continue;
      }
      bomVersions.add(version);
    }

    // Reverse the ordering, placing higher versions first
    VersionComparator comparator = new VersionComparator();
    Collections.sort(bomVersions, (b1, b2) -> comparator.compare(b2, b1));

    bomVersions.add(VersionData.ALL_VERSIONS_NAME);
    for (String version : bomVersions) {
      // We generate the 'All Versions' page after all other pages, since other pages
      // are used to collect data for the 'All Versions' page.
      if (!VersionData.ALL_VERSIONS_NAME.equals(version)) {
        generate(Bom.readBom(String.format("%s:%s:%s", groupId, artifactId, version)));
      }
    }
    generateAllVersionsDashboard();
  }

  private static Path generate(Bom bom) throws IOException, TemplateException, URISyntaxException {
    ArtifactCache cache = buildCache(bom);
    Path output = generateHtml(bom, cache);

    return output;
  }

  private static ArtifactCache buildCache(Bom bom) {
    List<Artifact> managedDependencies = new ArrayList<>();
    for (Artifact artifact : bom.getManagedDependencies()) {
      // All dependencies with google-cloud-shared-dependencies must have group ID
      // "com.google.cloud". google-cloud-core and bigtable-emulator are unique
      // in that they do not require google-cloud-shared-dependencies.
      // google-cloud-firestore-admin is a module of google-cloud-firestore
      if ("com.google.cloud".equals(artifact.getGroupId())
          && !artifact.getArtifactId().contains("google-cloud-core")
          && !artifact.getArtifactId().contains("google-cloud-bigtable-emulator")
          && !artifact.getArtifactId().contains("proto-google-cloud-firestore-bundle-v1")
          && !artifact.getArtifactId().contains("google-cloud-firestore-admin")) {
        managedDependencies.add(artifact);
      }
    }

    return loadArtifactInfo(managedDependencies);
  }

  private static boolean report(Bom bom, OutputStream outputStream) throws IOException {
    ArtifactCache cache = buildCache(bom);
    Map<Artifact, ArtifactInfo> infoMap = cache.getInfoMap();
    String cloudBomVersion =
        bom.getCoordinates().substring(bom.getCoordinates().lastIndexOf(":") + 1);

    Set<Artifact> artifactsData = infoMap.keySet();
    VersionData.addData(cloudBomVersion, artifactsData);

    Map<String, Object> templateData = VersionData.createTemplateData(cloudBomVersion);
    Map<String, String> sharedDependencyVersions =
        (Map<String, String>) templateData.get("sharedDependenciesVersion");
    Map<String, String> currentVersions = (Map<String, String>) templateData.get("currentVersion");
    Multimap<String, String> sharedDepsToLibraries = ArrayListMultimap.create();
    ImmutableSortedSet.Builder<ComparableVersion> sharedDepsVersionsBuilder =
        ImmutableSortedSet.reverseOrder();

    for (Map.Entry<String, String> entry : sharedDependencyVersions.entrySet()) {
      if (!entry.getValue().isEmpty()) {
        sharedDepsToLibraries.put(entry.getValue(), entry.getKey());
        sharedDepsVersionsBuilder.add(new ComparableVersion(entry.getValue()));
      }
    }

    SortedSet<ComparableVersion> sharedDepsVersions = sharedDepsVersionsBuilder.build();
    if (sharedDepsVersions.size() == 1) {
      outputStream.write("Shared dependencies converge \\o/\n".getBytes());
      return true;
    }

    // Find the largest shared dependency version
    ComparableVersion largest = null;
    StringBuilder outputString = new StringBuilder();
    for (ComparableVersion version : sharedDepsVersions) {
      if (largest == null) {
        largest = version;
        outputString.append("Greatest shared-dependencies version: ").append(version.toString());
      } else {
        Collection<String> artifacts = sharedDepsToLibraries.get(version.toString());
        outputString.append("\n-----------------------");
        outputString.append(
            "\nFound "
                + artifacts.size()
                + " artifacts with shared dependencies version: "
                + version.toString());

        for (String artifactKey : artifacts) {
          String artifactVersion = currentVersions.get(artifactKey);
          String artifact = artifactKey.split(":")[0];
          outputString.append("\n- " + artifact + ":" + artifactVersion);
        }
      }
      outputStream.write(outputString.toString().getBytes());
    }
    return false;
  }

  private static Path outputDirectory(String groupId, String artifactId, String version) {
    String versionPathElement = version.contains("-SNAPSHOT") ? "snapshot" : version;
    return Paths.get("target", groupId, artifactId, versionPathElement);
  }

  private static Path generateHtml(Bom bom, ArtifactCache cache)
      throws IOException, TemplateException, URISyntaxException {

    Artifact bomArtifact = new DefaultArtifact(bom.getCoordinates());

    Path relativePath =
        outputDirectory(
            bomArtifact.getGroupId(), bomArtifact.getArtifactId(), bomArtifact.getVersion());

    Path output = Files.createDirectories(relativePath);

    copyResource(output, "css/dashboard.css");
    copyResource(output, "js/dashboard.js");

    List<ArtifactResults> table = generateReports(cache);
    generateDashboard(output, table, cache, bom);

    return output;
  }

  /**
   * @throws IOException if we fail to copy the resources to output
   * @throws URISyntaxException if resourceName produces a URL with a bad URI
   * @throws IllegalArgumentException if resourceName produces an invalid URL
   */
  private static void copyResource(Path output, String resourceName)
      throws IOException, URISyntaxException {
    ClassLoader classLoader = DashboardMain.class.getClassLoader();
    URL resource = classLoader.getResource(resourceName);
    if (resource == null) {
      throw new IllegalArgumentException();
    }
    Path input = Paths.get(resource.toURI()).toAbsolutePath();
    Path copy = output.resolve(input.getFileName());
    if (!Files.exists(copy)) {
      Files.copy(input, copy);
    }
  }

  @VisibleForTesting
  static Configuration configureFreemarker() {
    Configuration configuration = new Configuration(new Version("2.3.28"));
    configuration.setDefaultEncoding("UTF-8");
    configuration.setClassForTemplateLoading(DashboardMain.class, "/");
    return configuration;
  }

  @VisibleForTesting
  static List<ArtifactResults> generateReports(ArtifactCache cache) {

    Map<Artifact, ArtifactInfo> artifacts = cache.getInfoMap();
    List<ArtifactResults> table = new ArrayList<>();
    for (Entry<Artifact, ArtifactInfo> entry : artifacts.entrySet()) {
      ArtifactInfo info = entry.getValue();
      if (info.getException() != null) {
        ArtifactResults unavailable = new ArtifactResults(entry.getKey());
        unavailable.setExceptionMessage(info.getException().getMessage());
        table.add(unavailable);
      } else {
        Artifact artifact = entry.getKey();
        ArtifactResults results = generateArtifactReport(artifact, entry.getValue());
        table.add(results);
      }
    }
    return table;
  }

  /** This is the only method that queries the Maven repository. */
  private static ArtifactCache loadArtifactInfo(List<Artifact> artifacts) {
    Map<Artifact, ArtifactInfo> infoMap = new LinkedHashMap<>();
    List<DependencyGraph> globalDependencies = new ArrayList<>();

    for (Artifact artifact : artifacts) {
      DependencyGraph completeDependencies =
          dependencyGraphBuilder.buildFullDependencyGraph(ImmutableList.of(artifact));
      globalDependencies.add(completeDependencies);

      // picks versions according to Maven rules
      DependencyGraph transitiveDependencies =
          dependencyGraphBuilder.buildMavenDependencyGraph(new Dependency(artifact, "compile"));

      ArtifactInfo info = new ArtifactInfo(completeDependencies, transitiveDependencies);
      infoMap.put(artifact, info);
    }

    ArtifactCache cache = new ArtifactCache();
    cache.setInfoMap(infoMap);
    cache.setGlobalDependencies(globalDependencies);

    return cache;
  }

  private static ArtifactResults generateArtifactReport(
      Artifact artifact, ArtifactInfo artifactInfo) {
    // includes all versions
    DependencyGraph graph = artifactInfo.getCompleteDependencies();
    List<Update> convergenceIssues = graph.findUpdates();

    // picks versions according to Maven rules
    DependencyGraph transitiveDependencies = artifactInfo.getTransitiveDependencies();

    Map<Artifact, Artifact> upperBoundFailures =
        findUpperBoundsFailures(graph.getHighestVersionMap(), transitiveDependencies);
    ArtifactResults results = new ArtifactResults(artifact);
    results.addResult(TEST_NAME_UPPER_BOUND, upperBoundFailures.size());
    results.addResult(TEST_NAME_DEPENDENCY_CONVERGENCE, convergenceIssues.size());
    return results;
  }

  private static Map<Artifact, Artifact> findUpperBoundsFailures(
      Map<String, String> expectedVersionMap, DependencyGraph transitiveDependencies) {

    Map<String, String> actualVersionMap = transitiveDependencies.getHighestVersionMap();

    VersionComparator comparator = new VersionComparator();

    Map<Artifact, Artifact> upperBoundFailures = new LinkedHashMap<>();

    for (String id : expectedVersionMap.keySet()) {
      String expectedVersion = expectedVersionMap.get(id);
      String actualVersion = actualVersionMap.get(id);
      // Check that the actual version is not null because it is
      // possible for dependencies to appear or disappear from the tree
      // depending on which version of another dependency is loaded.
      // In both cases, no action is needed.
      if (actualVersion != null && comparator.compare(actualVersion, expectedVersion) < 0) {
        // Maven did not choose highest version
        DefaultArtifact lower = new DefaultArtifact(id + ":" + actualVersion);
        DefaultArtifact upper = new DefaultArtifact(id + ":" + expectedVersion);
        upperBoundFailures.put(lower, upper);
      }
    }
    return upperBoundFailures;
  }

  /**
   * Generates the complete All Versions dashboard using all data previously passed in by other
   * dashboards upon creation. (See DashboardMain#generateDashboard())
   */
  static void generateAllVersionsDashboard()
      throws IOException, TemplateException, URISyntaxException {
    String[] bomVersionsArray = bomVersions.toArray(new String[bomVersions.size()]);
    Map<String, Object> templateData = VersionData.createTemplateData(bomVersionsArray);
    templateData.put("coordinates", VersionData.ALL_VERSIONS_NAME);
    templateData.put("table", new ArrayList<>());
    templateData.put("dependencyGraphs", new ArrayList<>());

    Path relativePath =
        outputDirectory("com.google.cloud", "google-cloud-bom", VersionData.ALL_VERSIONS_NAME);
    Path output = Files.createDirectories(relativePath);

    copyResource(output, "css/dashboard.css");
    copyResource(output, "js/dashboard.js");

    // Accessing static methods from Freemarker template
    // https://freemarker.apache.org/docs/pgui_misc_beanwrapper.html#autoid_60
    DefaultObjectWrapper wrapper =
        new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28).build();
    TemplateHashModel staticModels = wrapper.getStaticModels();
    templateData.put("dashboardMain", staticModels.get(DashboardMain.class.getName()));
    templateData.put("bomVersions", bomVersions);
    File dashboardFile = output.resolve("index.html").toFile();
    try (Writer out =
        new OutputStreamWriter(new FileOutputStream(dashboardFile), StandardCharsets.UTF_8)) {
      Template dashboard =
          DashboardMain.freemarkerConfiguration.getTemplate("/templates/index.ftl");
      dashboard.process(templateData, out);
    }
  }

  @VisibleForTesting
  static void generateDashboard(
      Path output, List<ArtifactResults> table, ArtifactCache cache, Bom bom)
      throws IOException, TemplateException {

    Map<Artifact, ArtifactInfo> infoMap = cache.getInfoMap();
    String cloudBomVersion =
        bom.getCoordinates().substring(bom.getCoordinates().lastIndexOf(":") + 1);

    Set<Artifact> artifactsData = infoMap.keySet();
    VersionData.addData(cloudBomVersion, artifactsData);

    Map<String, Object> templateData = VersionData.createTemplateData(cloudBomVersion);

    templateData.put("table", table);
    templateData.put("coordinates", bom.getCoordinates());
    templateData.put("dependencyGraphs", cache.getGlobalDependencies());

    // Accessing static methods from Freemarker template
    // https://freemarker.apache.org/docs/pgui_misc_beanwrapper.html#autoid_60
    DefaultObjectWrapper wrapper =
        new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28).build();
    TemplateHashModel staticModels = wrapper.getStaticModels();
    templateData.put("dashboardMain", staticModels.get(DashboardMain.class.getName()));
    templateData.put("bomVersions", bomVersions);
    File dashboardFile = output.resolve("index.html").toFile();
    try (Writer out =
        new OutputStreamWriter(new FileOutputStream(dashboardFile), StandardCharsets.UTF_8)) {
      Template dashboard =
          DashboardMain.freemarkerConfiguration.getTemplate("/templates/index.ftl");
      dashboard.process(templateData, out);
    }
  }

  /**
   * Returns the number of rows in {@code table} that show unavailable ({@code null} result) or some
   * failures for {@code columnName}.
   */
  public static long countFailures(List<ArtifactResults> table, String columnName) {
    return table.stream()
        .filter(row -> row.getResult(columnName) == null || row.getFailureCount(columnName) > 0)
        .count();
  }
}

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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.google.cloud.tools.opensource.dependencies.Artifacts;
import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.cloud.tools.opensource.dependencies.MavenRepositoryException;
import com.google.cloud.tools.opensource.dependencies.RepositoryUtility;
import com.google.cloud.tools.opensource.dependencies.VersionComparator;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.Streams;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.Charsets;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.resolution.ArtifactDescriptorException;

/** Tool to generate the changes in the content of the BOM since the previous release. */
public class ReleaseNoteGeneration {

  private static final RepositorySystem repositorySystem = RepositoryUtility.newRepositorySystem();
  private static final VersionComparator versionComparator = new VersionComparator();
  private static final Splitter dotSplitter = Splitter.on(".");
  private static final String cloudLibraryArtifactPrefix = "com.google.cloud:google-cloud-";
  private static final String RELEASE_NOTE_FILE_NAME = "release_note.md";
  private static final String GOOGLEAPIS_ORG = "googleapis";

  private static final ImmutableSet<String> splitRepositoryLibraryNames =
      ImmutableSet.of("bigtable", "firestore", "pubsub", "pubsublite");

  private static boolean clientLibraryFilter(String coordinates) {
    if (coordinates.contains("google-cloud-core")) {
      // Google Cloud Core is reported in core Google library section as this is not meant to be
      // used by customers directly.
      return false;
    }
    if (coordinates.startsWith(cloudLibraryArtifactPrefix)) {
      return true;
    }
    if (coordinates.startsWith("com.google.cloud:google-")) {
      // google-iam-admin has special group ID because it's not just for Cloud
      return true;
    }
    // proto- and grpc- artifacts are not meant to be used by the customers directly.
    return false;
  }

  /** Generates release note of specified Libraries BOM version to file "release_note.md". */
  public static void main(String[] arguments)
      throws ArtifactDescriptorException,
          MavenRepositoryException,
          IOException,
          InterruptedException {

    String librariesBomVersion = System.getProperty("libraries-bom.version");
    if (librariesBomVersion == null) {
      System.out.println(
          "Please provide Libraries BOM version. For example," + "-Dlibraries-bom.version=26.2.0");
      System.exit(1);
    }

    String googleCloudJavaVersion = System.getProperty("google-cloud-java.version");
    if (googleCloudJavaVersion == null) {
      System.out.println(
          "Please provide google-cloud-java version. For example,"
              + "-Dgoogle-cloud-java.version=1.1.0");
      System.exit(1);
    }

    Bom bom = Bom.readBom("com.google.cloud:libraries-bom:" + librariesBomVersion);

    ReleaseNoteGeneration generation = new ReleaseNoteGeneration();
    String report = generation.generateReport(bom, googleCloudJavaVersion);

    Files.asCharSink(new File(RELEASE_NOTE_FILE_NAME), Charsets.UTF_8).write(report);
    System.out.println("Wrote " + RELEASE_NOTE_FILE_NAME);
  }

  @VisibleForTesting final StringBuilder report = new StringBuilder();

  @VisibleForTesting
  ReleaseNoteGeneration() {}

  @VisibleForTesting
  String generateReport(Bom bom, String googleCloudJavaVersion)
      throws MavenRepositoryException,
          ArtifactDescriptorException,
          IOException,
          InterruptedException {
    Bom previousBom = previousBom(bom);

    DefaultArtifact bomArtifact = new DefaultArtifact(bom.getCoordinates());
    report.append("GCP Libraries BOM " + bomArtifact.getVersion() + "\n\n");

    reportCloudClientBomDifference(previousBom, bom, googleCloudJavaVersion);
    report.append("\n");
    printKeyCoreLibraryDependencies(bom);
    report.append("\n");
    printApiReferenceLink();

    report.append("\n\n");
    return report.toString();
  }

  private void printKeyCoreLibraryDependencies(Bom bom) {
    Map<String, String> versionlessCoordinatesToVersion = createVersionLessCoordinatesToKey(bom);
    report.append("# Core Library Dependencies\n");
    report.append("These client libraries are built with the following Java libraries:\n");
    report
        .append("- Guava: ")
        .append(versionlessCoordinatesToVersion.get("com.google.guava:guava"))
        .append("\n");
    report
        .append("- Protobuf Java: ")
        .append(versionlessCoordinatesToVersion.get("com.google.protobuf:protobuf-java"))
        .append("\n");
    report
        .append("- Google Auth Library: ")
        .append(
            versionlessCoordinatesToVersion.get("com.google.auth:google-auth-library-credentials"))
        .append("\n");
    report
        .append("- Google API Client: ")
        .append(versionlessCoordinatesToVersion.get("com.google.api-client:google-api-client"))
        .append("\n");
    report
        .append("- gRPC: ")
        .append(versionlessCoordinatesToVersion.get("io.grpc:grpc-api"))
        .append("\n");
    report
        .append("- GAX: ")
        .append(versionlessCoordinatesToVersion.get("com.google.api:gax"))
        .append("\n");
    report
        .append("- Google Cloud Core: ")
        .append(versionlessCoordinatesToVersion.get("com.google.cloud:google-cloud-core"))
        .append("\n")
        .append("\n");
    report
        .append(
            "If you encounter compatibility issues with protobuf-java 4.x, please update your codebase and dependencies to ensure compatibility.")
        .append("\n");
  }

  private void printApiReferenceLink() {
    report.append("# API Reference\n");
    report.append(
        "You can find the API references of the SDK in [Java Cloud Client Libraries]"
            + "(https://cloud.google.com/java/docs/reference)\n");
  }

  /**
   * Returns the BOM that was released prior to the {@code bom}, asking Maven repositories for
   * available versions.
   */
  @VisibleForTesting
  static Bom previousBom(Bom bom) throws MavenRepositoryException, ArtifactDescriptorException {
    String coordinates = bom.getCoordinates();
    DefaultArtifact inputCoordinates = new DefaultArtifact(coordinates);
    DefaultArtifact bomArtifact =
        new DefaultArtifact(
            inputCoordinates.getGroupId(),
            inputCoordinates.getArtifactId(),
            "pom",
            inputCoordinates.getVersion());

    // The highest version comes last.
    ImmutableList<String> versions =
        RepositoryUtility.findVersions(
            repositorySystem, bomArtifact.getGroupId(), bomArtifact.getArtifactId());

    Verify.verify(
        !versions.isEmpty(),
        "The versions returned empty. "
            + "Please check the coordinates (groupId: %s, artifactId: %s)",
        bomArtifact.getGroupId(),
        bomArtifact.getArtifactId());

    String previousVersionCandidate = versions.get(0);
    for (String version : versions) {
      if (versionComparator.compare(version, bomArtifact.getVersion()) >= 0) {
        break;
      }
      if (version.contains("-SNAPSHOT")) {
        // Ignore the artifacts from local Maven repository
        continue;
      }
      previousVersionCandidate = version;
    }

    return Bom.readBom(bomArtifact.setVersion(previousVersionCandidate).toString());
  }

  /** Returns a map from versionless coordinates to versions for a {@code bom}. */
  @VisibleForTesting
  static ImmutableMap<String, String> createVersionLessCoordinatesToKey(Bom bom) {
    Map<String, String> versionLessCoordinatesToVersion = new HashMap<>();
    List<Artifact> managedDependencies = new ArrayList(bom.getManagedDependencies());

    // Sort alphabetical order based on the Maven coordinates
    managedDependencies.sort(
        (artifact1, artifact2) -> artifact1.toString().compareTo(artifact2.toString()));
    for (Artifact managedDependency : managedDependencies) {
      String versionlessCoordinates = Artifacts.makeKey(managedDependency);
      versionLessCoordinatesToVersion.put(versionlessCoordinates, managedDependency.getVersion());
    }
    return ImmutableMap.copyOf(versionLessCoordinatesToVersion);
  }

  private void reportCloudClientBomDifference(Bom oldBom, Bom newBom, String googleCloudJavaVersion)
      throws MavenRepositoryException, IOException, InterruptedException {
    Map<String, String> versionlessCoordinatesToVersionOld =
        createVersionLessCoordinatesToKey(oldBom);
    Map<String, String> versionlessCoordinatesToVersionNew =
        createVersionLessCoordinatesToKey(newBom);

    ImmutableSet<String> cloudLibrariesVersionlessCoordinatesInNew =
        versionlessCoordinatesToVersionNew.keySet().stream()
            .filter(ReleaseNoteGeneration::clientLibraryFilter)
            .collect(ImmutableSet.toImmutableSet());
    ImmutableSet<String> cloudLibrariesVersionlessCoordinatesInOld =
        versionlessCoordinatesToVersionOld.keySet().stream()
            .filter(ReleaseNoteGeneration::clientLibraryFilter)
            .collect(ImmutableSet.toImmutableSet());

    SetView<String> artifactsOnlyInNew =
        Sets.difference(
            cloudLibrariesVersionlessCoordinatesInNew, cloudLibrariesVersionlessCoordinatesInOld);

    String oldBomVersion = Splitter.on(':').splitToList(oldBom.getCoordinates()).get(3);
    report
        .append("Here are the differences from the previous version (")
        .append(oldBomVersion)
        .append(")\n\n");

    if (!artifactsOnlyInNew.isEmpty()) {
      report.append("# New Addition\n");
      for (String versionlessCoordinates : artifactsOnlyInNew) {
        report.append(
            "- "
                + versionlessCoordinates
                + ":"
                + versionlessCoordinatesToVersionNew.get(versionlessCoordinates)
                + "\n");
      }
      report.append("\n");
    }

    report.append("The group ID of the following artifacts is `com.google.cloud`.\n\n");
    SetView<String> artifactsInBothBoms =
        Sets.intersection(
            cloudLibrariesVersionlessCoordinatesInNew, cloudLibrariesVersionlessCoordinatesInOld);

    List<String> majorVersionBumpVersionlessCoordinates = new ArrayList<>();
    List<String> minorVersionBumpVersionlessCoordinates = new ArrayList<>();
    List<String> patchVersionBumpVersionlessCoordinates = new ArrayList<>();
    for (String versionlessCoordinates : artifactsInBothBoms) {
      String previousVersion = versionlessCoordinatesToVersionOld.get(versionlessCoordinates);
      String currentVersion = versionlessCoordinatesToVersionNew.get(versionlessCoordinates);

      if (isMajorVersionBump(previousVersion, currentVersion)) {
        majorVersionBumpVersionlessCoordinates.add(versionlessCoordinates);
      } else if (isMinorVersionBump(previousVersion, currentVersion)) {
        minorVersionBumpVersionlessCoordinates.add(versionlessCoordinates);
      } else if (isPatchVersionBump(previousVersion, currentVersion)) {
        patchVersionBumpVersionlessCoordinates.add(versionlessCoordinates);
      }
    }

    report.append("# Notable Changes\n\n");
    reportClientLibrariesNotableChangeLogs(
        minorVersionBumpVersionlessCoordinates,
        versionlessCoordinatesToVersionOld,
        versionlessCoordinatesToVersionNew,
        googleCloudJavaVersion);

    report.append("# Version Upgrades\n\n");
    if (!majorVersionBumpVersionlessCoordinates.isEmpty()) {
      report.append("## Major Version Upgrades\n");
      reportClientLibraryVersionDifference(
          majorVersionBumpVersionlessCoordinates,
          versionlessCoordinatesToVersionOld,
          versionlessCoordinatesToVersionNew,
          googleCloudJavaVersion);
    }

    if (!minorVersionBumpVersionlessCoordinates.isEmpty()) {
      report.append("## Minor Version Upgrades\n");
      reportClientLibraryVersionDifference(
          minorVersionBumpVersionlessCoordinates,
          versionlessCoordinatesToVersionOld,
          versionlessCoordinatesToVersionNew,
          googleCloudJavaVersion);
    }

    if (!patchVersionBumpVersionlessCoordinates.isEmpty()) {
      report.append("## Patch Version Upgrades\n");
      reportClientLibraryVersionDifference(
          patchVersionBumpVersionlessCoordinates,
          versionlessCoordinatesToVersionOld,
          versionlessCoordinatesToVersionNew,
          googleCloudJavaVersion);
    }

    SetView<String> artifactsOnlyInOld =
        Sets.difference(
            cloudLibrariesVersionlessCoordinatesInOld, cloudLibrariesVersionlessCoordinatesInNew);

    if (!artifactsOnlyInOld.isEmpty()) {
      report.append("# Removed artifacts\n");
      for (String versionlessCoordinates : artifactsOnlyInOld) {
        report.append(
            "- "
                + versionlessCoordinates
                + " (prev:"
                + versionlessCoordinatesToVersionOld.get(versionlessCoordinates)
                + ")\n");
      }
    }
  }

  /**
   * Writes the version differences of the libraries to {@code report}. In the output, one line
   * consists of a markdown bullet point item showing the versions since the previous release with
   * the link to the release note. Example: {@code - google-cloud-billing:2.6.0 (prev:2.5.0; Release
   * Notes:
   * [v2.6.0](https://github.com/googleapis/google-cloud-java/releases/tag/google-cloud-billing-v2.6.0))}
   */
  @VisibleForTesting
  void reportClientLibraryVersionDifference(
      Iterable<String> artifactsInBothBoms,
      Map<String, String> versionlessCoordinatesToVersionOld,
      Map<String, String> versionlessCoordinatesToVersionNew,
      String googleCloudJavaVersion)
      throws MavenRepositoryException {

    for (String versionlessCoordinates : artifactsInBothBoms) {
      StringBuilder line = new StringBuilder("- ");

      String previousVersion = versionlessCoordinatesToVersionOld.get(versionlessCoordinates);
      String currentVersion = versionlessCoordinatesToVersionNew.get(versionlessCoordinates);

      List<String> groupIdAndArtifactId = Splitter.on(":").splitToList(versionlessCoordinates);
      Verify.verify(
          groupIdAndArtifactId.size() == 2,
          "Versionless coordinates should have 2 elements separated by ':'");
      String groupId = groupIdAndArtifactId.get(0);
      String artifactId = groupIdAndArtifactId.get(1);
      line.append(
          ("com.google.cloud".equals(groupId) ? artifactId : versionlessCoordinates)
              + ":"
              + currentVersion
              + " (prev:"
              + previousVersion
              + "; Release Notes: ");

      ImmutableList<String> versionsForReleaseNotes =
          clientLibraryReleaseNoteVersions(versionlessCoordinates, previousVersion, currentVersion);

      String libraryName = null;
      if (artifactId.contains("google-cloud-")) {
        libraryName = artifactId.replace("google-cloud-", "");
      } else if (artifactId.contains("google-")) {
        // Case of google-iam-admin
        libraryName = artifactId.replace("google-", "");
      }

      List<String> links = new ArrayList<>();
      for (String versionForReleaseNotes : versionsForReleaseNotes) {
        String[] versionAndQualifier = versionForReleaseNotes.split("-");
        String version = versionAndQualifier[0];
        String releaseUrl =
            splitRepositoryLibraryNames.contains(libraryName)
                ? releaseUrlForSplitRepo(libraryName, version)
                : releaseUrlForMonorepo(libraryName, googleCloudJavaVersion);
        links.add(String.format("[v%s](%s)", versionForReleaseNotes, releaseUrl));
      }
      line.append(Joiner.on(", ").join(links)).append(")");

      report.append(line).append("\n");
    }
  }

  private static String releaseUrlForSplitRepo(String libraryName, String version) {
    return String.format(
        "https://github.com/googleapis/java-%s/releases/tag/v%s", libraryName, version);
  }

  private static String releaseUrlForMonorepo(String libraryName, String version) {
    // libraryName is unused for the monorepo release note as of Dec 2022
    return String.format(
        "https://github.com/googleapis/google-cloud-java/releases/tag/v%s", version);
  }

  /**
   * Returns the versions to link release notes of individual client libraries. The list includes
   * the {@code currentVersion} but not including {@code previousVersion}.
   */
  private static ImmutableList<String> clientLibraryReleaseNoteVersions(
      String versionlessCoordinates, String previousVersion, String currentVersion)
      throws MavenRepositoryException {
    DefaultArtifact artifact = new DefaultArtifact(versionlessCoordinates + ":" + currentVersion);

    // The highest versions come last.
    ImmutableList<String> versions =
        RepositoryUtility.findVersions(
            repositorySystem, artifact.getGroupId(), artifact.getArtifactId());

    Verify.verify(
        !versions.isEmpty(),
        "The versions returned empty. "
            + "Please check the coordinates (groupId: %s, artifactId: %s)",
        artifact.getGroupId(),
        artifact.getArtifactId());

    ImmutableList.Builder<String> releaseNoteVersions = ImmutableList.builder();

    for (String version : versions) {
      if (version.contains("-SNAPSHOT")) {
        continue;
      }
      // The compare method returns negative if the first argument is less than the second.
      if (versionComparator.compare(previousVersion, version) < 0
          && versionComparator.compare(version, currentVersion) <= 0) {
        releaseNoteVersions.add(version);
      }
    }
    return releaseNoteVersions.build();
  }

  @VisibleForTesting
  static boolean isMajorVersionBump(String previousVersion, String currentVersion) {
    List<String> previousVersionElements = dotSplitter.splitToList(previousVersion);
    List<String> currentVersionElements = dotSplitter.splitToList(currentVersion);
    return !previousVersionElements.get(0).equals(currentVersionElements.get(0));
  }

  @VisibleForTesting
  static boolean isMinorVersionBump(String previousVersion, String currentVersion) {
    List<String> previousVersionElements = dotSplitter.splitToList(previousVersion);
    List<String> currentVersionElements = dotSplitter.splitToList(currentVersion);
    return previousVersionElements.get(0).equals(currentVersionElements.get(0))
        && !previousVersionElements.get(1).equals(currentVersionElements.get(1));
  }

  @VisibleForTesting
  static boolean isPatchVersionBump(String previousVersion, String currentVersion) {
    List<String> previousVersionElements = dotSplitter.splitToList(previousVersion);
    List<String> currentVersionElements = dotSplitter.splitToList(currentVersion);
    return previousVersionElements.get(0).equals(currentVersionElements.get(0))
        && previousVersionElements.get(1).equals(currentVersionElements.get(1))
        && !previousVersionElements.get(2).equals(currentVersionElements.get(2));
  }

  /**
   * Writes user-relevant changelogs for the set of client libraries ({@code artifactsInBothBoms}).
   *
   * <p>The user-relevant changelogs include bug fixes and new features.
   *
   * <p>The old versions are stored in {@code versionlessCoordinatesToVersionOld} and the new
   * versions are in {@code versionlessCoordinatesToVersionNew}. This method fetches the changelogs
   * in between the two versions, not including the old version.
   */
  @VisibleForTesting
  void reportClientLibrariesNotableChangeLogs(
      Iterable<String> artifactsInBothBoms,
      Map<String, String> versionlessCoordinatesToVersionOld,
      Map<String, String> versionlessCoordinatesToVersionNew,
      String googleCloudJavaVersion)
      throws IOException, InterruptedException {

    ImmutableList<String> sortedVersionlessCoordinates =
        Streams.stream(artifactsInBothBoms).sorted().collect(toImmutableList());

    for (String versionlessCoordinates : sortedVersionlessCoordinates) {
      List<String> coordinates = Splitter.on(":").splitToList(versionlessCoordinates);
      String artifactId = coordinates.get(1);
      String previousVersion = versionlessCoordinatesToVersionOld.get(versionlessCoordinates);
      String currentVersion = versionlessCoordinatesToVersionNew.get(versionlessCoordinates);
      Optional<String> matchingSplitRepoName =
          splitRepositoryLibraryNames.stream()
              .map(libraryName -> artifactId.endsWith(libraryName) ? "java-" + libraryName : null)
              .filter(Objects::nonNull)
              .findFirst();
      matchingSplitRepoName.ifPresent(
          splitRepoName -> {
            try {
              ImmutableList<String> versionsForReleaseNotes =
                  clientLibraryReleaseNoteVersions(
                      versionlessCoordinates, previousVersion, currentVersion);
              String changelog =
                  fetchClientLibraryNotableChangeLog(splitRepoName, versionsForReleaseNotes);
              if (!changelog.isEmpty()) {
                // Only print library name when there are notable changes
                report
                    .append("## ")
                    .append(artifactId)
                    .append(" ")
                    .append(currentVersion)
                    .append(" (prev: ")
                    .append(previousVersion)
                    .append(")");
                report.append(changelog).append("\n");
              }
            } catch (MavenRepositoryException | IOException | InterruptedException ex) {
              throw new VerifyException(
                  "Couldn't write notable changelog for "
                      + versionlessCoordinates
                      + "'s versions between "
                      + previousVersion
                      + " and "
                      + currentVersion,
                  ex);
            }
          });
    }

    report.append("## Other libraries\n\n");
    String changelog =
        fetchClientLibraryNotableChangeLog(
            "google-cloud-java", ImmutableList.of(googleCloudJavaVersion));
    report.append(changelog).append("\n");
  }

  /**
   * Writes the user-relevant changelog for the {@code versions} of the artifact from the {@code
   * repository}.
   */
  @VisibleForTesting
  static String fetchClientLibraryNotableChangeLog(String repository, Iterable<String> versions)
      throws IOException, InterruptedException {
    StringBuilder relevantChangelog = new StringBuilder();

    for (String version : versions) {
      String rawReleaseNote = fetchReleaseNote(GOOGLEAPIS_ORG, repository, "v" + version);
      relevantChangelog.append(filterOnlyRelevantChangelog(rawReleaseNote));
    }

    return relevantChangelog.toString();
  }

  static final Pattern featuresSectionPattern =
      Pattern.compile("### Features\n(.+?)###", Pattern.MULTILINE | Pattern.DOTALL);
  static final Pattern bugFixSectionPattern =
      Pattern.compile("### Bug Fixes\n(.+?)###", Pattern.MULTILINE | Pattern.DOTALL);
  static final String irrelevantFeaturePattern = "(?m)^.+(Next release from main branch|deps:).+\n";

  @VisibleForTesting
  static String filterOnlyRelevantChangelog(String changelog) {
    StringBuilder relevantChangelog = new StringBuilder();
    Matcher newFeatureMatcher = featuresSectionPattern.matcher(changelog);
    Matcher bugFixMatcher = bugFixSectionPattern.matcher(changelog);

    for (Matcher matcher : ImmutableList.of(newFeatureMatcher, bugFixMatcher)) {
      if (matcher.find()) {
        String matchedSection = matcher.group(1);
        String matchedSectionIrrelevantRemoved =
            matchedSection.replaceAll(irrelevantFeaturePattern, "");
        relevantChangelog.append(matchedSectionIrrelevantRemoved);
      }
    }

    return relevantChangelog
        .toString()
        // Remove empty lines
        .replaceAll("(?m)^\n$", "")
        .replaceAll("(?m)^\\* ", "- ");
  }

  /**
   * Returns the release note content of the release of {@code tag} of {@code owner}/ {@code
   * repository}.
   */
  @VisibleForTesting
  static String fetchReleaseNote(String owner, String repository, String tag)
      throws IOException, InterruptedException {
    // gh release --repo googleapis/java-storage view v2.16.0

    ProcessBuilder builder =
        new ProcessBuilder("gh", "release", "--repo", owner + "/" + repository, "view", tag);
    builder.redirectErrorStream(true);
    Process process = builder.start();
    String output =
        new String(
            process.getInputStream().readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
    boolean finished = process.waitFor(1, TimeUnit.MINUTES);
    Verify.verify(finished, "The process timed out");
    Verify.verify(0 == process.exitValue(), "The command failed: %s", output);
    return output;
  }
}

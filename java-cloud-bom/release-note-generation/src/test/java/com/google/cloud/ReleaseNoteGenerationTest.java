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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import org.junit.Test;

public class ReleaseNoteGenerationTest {
  // Uses the released BOM, not the one in this repository, to avoid unnecessarily updating the
  // assertions.
  static final String LIBRARIES_BOM_COORDINATES = "com.google.cloud:libraries-bom:26.1.5";

  @Test
  public void testPreviousBom() throws Exception {
    Bom bom = Bom.readBom(LIBRARIES_BOM_COORDINATES);
    Bom previousBom = ReleaseNoteGeneration.previousBom(bom);
    Truth.assertThat(previousBom.getCoordinates())
        .isEqualTo("com.google.cloud:libraries-bom:pom:26.1.4");
  }

  @Test
  public void testCreateVersionLessCoordinatesToKey() throws Exception {
    Bom bom = Bom.readBom(LIBRARIES_BOM_COORDINATES);
    ImmutableMap<String, String> versionLessCoordinatesToKey =
        ReleaseNoteGeneration.createVersionLessCoordinatesToKey(bom);

    // google-cloud-apigee-registry represents the libraries from google-cloud-java
    // google-cloud-bigtable represents the libraries from handwritten repositories
    Truth.assertThat(versionLessCoordinatesToKey)
        .containsAtLeast(
            "com.google.cloud:google-cloud-apigee-registry", "0.6.0",
            "com.google.cloud:google-cloud-bigtable", "2.16.0");
  }

  @Test
  public void testIsMajorVersionBump() {
    assertTrue(ReleaseNoteGeneration.isMajorVersionBump("1.2.3", "2.0.1"));
    assertFalse(ReleaseNoteGeneration.isMajorVersionBump("2.2.3", "2.3.1"));
  }

  @Test
  public void testIsMinorVersionBump() {
    assertTrue(ReleaseNoteGeneration.isMinorVersionBump("1.2.3", "1.3.0"));
    assertFalse(ReleaseNoteGeneration.isMinorVersionBump("1.2.3", "1.2.5"));
    assertFalse(ReleaseNoteGeneration.isMinorVersionBump("1.2.3", "2.2.3"));
  }

  @Test
  public void testIsPatchVersionBump() {
    assertTrue(ReleaseNoteGeneration.isPatchVersionBump("1.2.3", "1.2.5"));
    assertFalse(ReleaseNoteGeneration.isPatchVersionBump("1.2.3", "1.2.3"));
    assertFalse(ReleaseNoteGeneration.isPatchVersionBump("1.2.3", "2.2.3"));
    assertFalse(ReleaseNoteGeneration.isPatchVersionBump("1.2.3", "1.3.3"));
  }

  @Test
  public void testPrintClientLibraryVersionDifference() throws Exception {
    ReleaseNoteGeneration generation = new ReleaseNoteGeneration();
    generation.reportClientLibraryVersionDifference(
        ImmutableList.of(
            "com.google.cloud:google-cloud-redis", "com.google.cloud:google-cloud-logging"),
        ImmutableMap.of(
            "com.google.cloud:google-cloud-redis",
            "2.8.0",
            "com.google.cloud:google-cloud-logging",
            "3.12.0"),
        ImmutableMap.of(
            "com.google.cloud:google-cloud-redis",
            "2.9.0",
            "com.google.cloud:google-cloud-logging",
            "3.13.1"),
        "1.1.0");

    String report = generation.report.toString();
    Truth.assertThat(report)
        .contains(
            "- google-cloud-redis:2.9.0 (prev:2.8.0; Release Notes: "
                + "[v2.9.0](https://github.com/googleapis/google-cloud-java/releases/tag/v1.1.0))");
    Truth.assertThat(report)
        .contains(
            "- google-cloud-logging:3.13.1 (prev:3.12.0; Release Notes: "
                + "[v3.12.1](https://github.com/googleapis/google-cloud-java/releases/tag/v1.1.0), "
                + "[v3.13.0](https://github.com/googleapis/google-cloud-java/releases/tag/v1.1.0), "
                + "[v3.13.1](https://github.com/googleapis/google-cloud-java/releases/tag/v1.1.0))");
  }

  @Test
  public void testReportClientLibrariesNotableChangeLogs() throws Exception {}

  @Test
  public void testFetchClientLibraryNotableChangeLog() throws Exception {
    String notableChangelog =
        ReleaseNoteGeneration.fetchClientLibraryNotableChangeLog(
            "java-storage", ImmutableList.of("2.16.0", "2.15.1"));

    // A new feature in 2.16.0
    Truth.assertThat(notableChangelog)
        .contains("- Added a new retention_duration field of Duration type");

    // A bug fix in 2.15.1
    Truth.assertThat(notableChangelog).contains("- Disable REGAPIC transport in storage v2");

    // A dependency update in 2.16.0. A dependency update is not notable.
    Truth.assertThat(notableChangelog).doesNotContain("native-maven-plugin");

    Truth.assertThat(notableChangelog).doesNotContainMatch("^$");
  }

  @Test
  public void testFilterOnlyRelevantChangelog_splitRepo() throws Exception {
    String rawChangelog =
        "### Features\n"
            + "\n"
            + "* Add {Compose,Rewrite,StartResumableWrite}Request.object_checksums and"
            + " Bucket.RetentionPolicy.retention_duration"
            + " ([#1790](https://github.com/googleapis/java-storage/issues/1790))"
            + " ([31c1b18](https://github.com/googleapis/java-storage/commit/31c1b18acc3c118e39eb613a82ee292f3e246b8f))\n"
            + "* Added a new retention_duration field of Duration type"
            + " ([31c1b18](https://github.com/googleapis/java-storage/commit/31c1b18acc3c118e39eb613a82ee292f3e246b8f))\n"
            + "* Next release from main branch is 1.122.0\n"
            + "\n"
            + "\n"
            + "### Bug Fixes\n"
            + "\n"
            + "* Removed WriteObject routing annotations"
            + " ([31c1b18](https://github.com/googleapis/java-storage/commit/31c1b18acc3c118e39eb613a82ee292f3e246b8f))\n"
            + "* Disable REGAPIC transport in storage v2\n"
            + "* **deps:** update dependency com.google.apis:google-api-services-dns to"
            + " v1-rev20221110-2.0.0\n"
            + "\n"
            + "\n"
            + "### Documentation";
    String notableChangelog = ReleaseNoteGeneration.filterOnlyRelevantChangelog(rawChangelog);
    // A new feature in 2.16.0
    Truth.assertThat(notableChangelog)
        .contains("- Added a new retention_duration field of Duration type");

    // A bug fix in 2.15.1
    Truth.assertThat(notableChangelog).contains("- Disable REGAPIC transport in storage v2");

    // A dependency update in 2.16.0. A dependency update is not notable.
    Truth.assertThat(notableChangelog).doesNotContain("native-maven-plugin");

    // The forced minor version upgrade is irrelevant to customer
    Truth.assertThat(notableChangelog).doesNotContain("1.122.0");

    Truth.assertThat(notableChangelog).doesNotContainMatch("^$");
    // The list item is replaced with "- "
    Truth.assertThat(notableChangelog).doesNotContainMatch("^\\* ");

    // Dependency changes, even if it's noted in bug fixes section, shouldn't appear here.
    Truth.assertThat(notableChangelog).doesNotContainMatch("deps:");
  }

  @Test
  public void testFetchReleaseNote() throws Exception {
    String storageReleaseNote2_16_0 =
        ReleaseNoteGeneration.fetchReleaseNote("googleapis", "java-storage", "v2.16.0");
    Truth.assertThat(storageReleaseNote2_16_0)
        .contains(
            "* Add {Compose,Rewrite,StartResumableWrite}Request.object_checksums and"
                + " Bucket.RetentionPolicy.retention_duration"
                + " ([#1790](https://github.com/googleapis/java-storage/issues/1790)) "
                + "([31c1b18](https://github.com/googleapis/java-storage/commit/31c1b18acc3c118e39eb613a82ee292f3e246b8f))");
  }
}

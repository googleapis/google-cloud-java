/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.examples.securitycenter.snippets;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

import com.google.cloud.securitycenter.v1.Finding.State;
import com.google.cloud.securitycenter.v1.FindingName;
import com.google.cloud.securitycenter.v1.OrganizationName;
import com.google.cloud.securitycenter.v1.SourceName;
import com.google.protobuf.Value;
import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Duration;

/** Smoke tests for {@link com.google.cloud.examples.securitycenter.snippets.FindingSnippets} */
public class ITFindingSnippets {

  private static SourceName SOURCE_NAME;
  private static FindingName FINDING_NAME;

  @BeforeClass
  public static void setUp() throws IOException {
    SOURCE_NAME = SourceName.parse(SourceSnippets.createSource(getOrganizationId()).getName());
    FINDING_NAME =
        FindingName.parse(FindingSnippets.createFinding(SOURCE_NAME, "testfindingid").getName());
  }

  @Test
  public void testCreateFinding() throws IOException {
    assertNotNull(FindingSnippets.createFinding(SOURCE_NAME, "samplefindingid"));
  }

  @Test
  public void testCreateFindingWithSourceProperties() throws IOException {
    assertNotNull(FindingSnippets.createFindingWithSourceProperties(SOURCE_NAME));
  }

  @Test
  public void testUpdateFinding() throws IOException {
    Value stringValue = Value.newBuilder().setStringValue("value").build();
    assertTrue(
        FindingSnippets.updateFinding(FINDING_NAME)
            .getSourcePropertiesMap()
            .get("stringKey")
            .equals(stringValue));
  }

  @Test
  public void testUpdateFindingState() throws IOException {
    Value stringValue = Value.newBuilder().setStringValue("value").build();
    assertTrue(FindingSnippets.setFindingState(FINDING_NAME).getState().equals(State.INACTIVE));
  }

  @Test
  public void testListAllFindings() throws IOException {
    assertTrue(FindingSnippets.listAllFindings(getOrganizationId()).size() > 1);
  }

  @Test
  public void testListFilteredFindings() throws IOException {
    assertTrue(FindingSnippets.listFilteredFindings(SOURCE_NAME).size() > 0);
  }

  @Test
  public void testListFindingsAtTime() throws IOException {
    assertTrue(FindingSnippets.listFindingsAtTime(SOURCE_NAME).size() == 0);
  }

  @Test
  public void testTestIamPermissions() throws IOException {
    assertTrue(
        FindingSnippets.testIamPermissions(SOURCE_NAME)
            .getPermissions(0)
            .equals("securitycenter.findings.update"));
  }

  @Test
  public void testGroupFindings() throws IOException {
    assertTrue(FindingSnippets.groupFindings(getOrganizationId()).size() > 0);
  }

  @Test
  public void testGroupFindingsWithSource() throws IOException {
    assertTrue(FindingSnippets.groupFindingsWithSource(SOURCE_NAME).size() > 0);
  }

  @Test
  public void testGroupActiveFindingsWithSource() throws IOException {
    assertTrue(FindingSnippets.groupActiveFindingsWithSource(SOURCE_NAME).size() > 0);
  }

  @Test
  public void testGroupActiveFindingsWithSourceAtTime() throws IOException {
    assertEquals(0, FindingSnippets.groupActiveFindingsWithSourceAtTime(SOURCE_NAME).size());
  }

  @Test
  public void testGroupActiveFindingsWithSourceAndCompareDuration() throws IOException {
    assertTrue(
        FindingSnippets.groupActiveFindingsWithSourceAndCompareDuration(
                    SOURCE_NAME, Duration.ofDays(1))
                .size()
            > 0);
  }

  private static OrganizationName getOrganizationId() {
    return OrganizationName.of(System.getenv("GCLOUD_ORGANIZATION"));
  }
}

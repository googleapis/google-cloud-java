package com.google.cloud.examples.securitycenter.snippets;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

import com.google.cloud.securitycenter.v1.FindingName;
import com.google.cloud.securitycenter.v1.OrganizationName;
import com.google.cloud.securitycenter.v1.SourceName;
import com.google.protobuf.Value;
import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;

/** Smoke tests for {@link com.google.cloud.examples.securitycenter.snippets.FindingSnippets} */
public class ITFindingSnippets {

  private static SourceName SOURCE_NAME;
  private static FindingName FINDING_NAME;

  @BeforeClass
  public static void setUp() throws IOException {
    SOURCE_NAME = SourceName.parse(SourceSnippets.createSource(getOrganizationId()).getName());
    FINDING_NAME = FindingName.parse(FindingSnippets.createFinding(SOURCE_NAME, "testfindingid").getName());
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
    assertTrue(FindingSnippets.updateFinding(FINDING_NAME).getSourcePropertiesMap().get("stringKey").equals(stringValue));
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
    assertTrue(FindingSnippets.testIamPermissions(SOURCE_NAME).getPermissions(0).equals("securitycenter.findings.update"));
  }

  private static OrganizationName getOrganizationId() {
    return OrganizationName.of(System.getenv("GCLOUD_ORGANIZATION"));
  }

}

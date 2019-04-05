package com.google.cloud.examples.securitycenter.snippets;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import com.google.cloud.securitycenter.v1.Asset;
import com.google.cloud.securitycenter.v1.Finding;
import com.google.cloud.securitycenter.v1.OrganizationName;
import com.google.cloud.securitycenter.v1.SourceName;
import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSecurityMarkSnippets {

  private static Asset ASSET;
  private static SourceName SOURCE_NAME;
  private static Finding FINDING;

  @BeforeClass
  public static void setUp() throws IOException {
    ASSET = AssetSnippets.listAssets(getOrganizationId()).get(0).getAsset();
    SOURCE_NAME = SourceName.parse(SourceSnippets.createSource(getOrganizationId()).getName());
    FINDING = FindingSnippets.createFinding(SOURCE_NAME, "testfindingid");
  }

  @Test
  public void testAddToAsset() throws IOException {
    assertTrue(SecurityMarkSnippets.addToAsset(ASSET).getMarksOrThrow("key_a").equals("value_a"));
  }

  @Test
  public void testClearFromAsset() throws IOException {
    assertFalse(SecurityMarkSnippets.clearFromAsset(ASSET).containsMarks("key_a"));
  }

  @Test
  public void testDeleteAndUpdateMarks() throws IOException {
    assertTrue(SecurityMarkSnippets.deleteAndUpdateMarks(ASSET).getMarksOrThrow("key_a").equals("new_value_for_a"));
  }

  @Test
  public void testAddToFinding() throws IOException {
    assertTrue(SecurityMarkSnippets.addToFinding(FINDING).getMarksOrThrow("key_a").equals("value_a"));
  }

  @Test
  public void testListAssetsWithQueryMarks() throws IOException {
    assertTrue(SecurityMarkSnippets.listAssetsWithQueryMarks(getOrganizationId()).size() > 0);
  }

  @Test
  public void testListFindingsWithQueryMarks() throws IOException {
    assertTrue(SecurityMarkSnippets.listFindingsWithQueryMarks(SOURCE_NAME).size() > 0);
  }

  private static OrganizationName getOrganizationId() {
    return OrganizationName.of(System.getenv("GCLOUD_ORGANIZATION"));
  }

}

package com.google.cloud.examples.securitycenter.snippets;

import static junit.framework.TestCase.assertTrue;

import com.google.cloud.securitycenter.v1beta1.ListAssetsResponse.ListAssetsResult;
import com.google.cloud.securitycenter.v1beta1.SecurityCenterClient;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/** Smoke tests for {@link com.google.cloud.examples.securitycenter.snippets.AssetSnippets} */
public class ITAssetSnippets {

  static SecurityCenterClient client;
  static AssetSnippets snippets;

  public static final Instant NOTHING_INSTANCE =
      LocalDateTime.of(2019, 1, 1, 0, 0).toInstant(ZoneOffset.UTC);
  public static final Instant SOMETHING_INSTANCE =
      LocalDateTime.of(2019, 3, 14, 8, 0).toInstant(ZoneOffset.ofHours((-8)));

  @BeforeClass
  public static void beforeClass() throws IOException {
    client = SecurityCenterClient.create();
    snippets = new AssetSnippets(client, getOrganizationId());
  }

  @Test
  public void mainRuns() throws IOException {
    AssetSnippets.main(getOrganizationId());
  }

  @Test
  public void demosRun() throws IOException {
    snippets.demoListAssets();
    snippets.demoListAssetAndStatusChanges();
  }

  @Test
  public void testAllAssetsReturned() {
    assertTrue(0 < snippets.listAssets(null, null).size());
  }

  @Test
  public void testBeforeDateNoAssetsReturned() {
    assertTrue(snippets.listAssets(null, NOTHING_INSTANCE).isEmpty());
  }

  @Test
  public void testListAssetsNoFilterOrDate() {
    assertTrue(59 >= snippets.listAssets(null, null).size());
  }

  @Test
  public void testListAssetsWithFilterAndInstance() {
    assertTrue(
        3 >= snippets.listAssets(AssetSnippets.PROJECT_ASSET_FILTERS, SOMETHING_INSTANCE).size());
  }

  @Test
  public void testChangesReturnsValues() {
    ImmutableList<ListAssetsResult> result =
        snippets.listAssetAndStatusChanges(
            Duration.ofDays(3), AssetSnippets.PROJECT_ASSET_FILTERS, SOMETHING_INSTANCE);
    assertTrue("Result: " + result.toString(), result.toString().contains("ADDED"));
    assertTrue(3 >= result.size());
  }

  @AfterClass
  public static void tearDown() {
    client.close();
  }

  private static String getOrganizationId() {
    return System.getenv("GCLOUD_ORGANIZATION");
  }
}

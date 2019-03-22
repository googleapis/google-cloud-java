package com.google.cloud.examples.securitycenter.snippets;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import com.google.cloud.securitycenter.v1beta1.ListAssetsResponse.ListAssetsResult;
import com.google.cloud.securitycenter.v1beta1.ListAssetsResponse.ListAssetsResult.State;
import com.google.cloud.securitycenter.v1beta1.OrganizationName;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import org.junit.Test;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/** Smoke tests for {@link com.google.cloud.examples.securitycenter.snippets.AssetSnippets} */
public class ITAssetSnippets {

  private static final Instant NOTHING_INSTANCE =
      LocalDateTime.of(2019, 1, 1, 0, 0).toInstant(ZoneOffset.UTC);
  private static final Instant SOMETHING_INSTANCE =
      LocalDateTime.of(2019, 3, 14, 8, 0).toInstant(ZoneOffset.ofHours((-8)));

  @Test
  public void mainRuns() throws IOException {
    AssetSnippets.main(getOrganizationId().getOrganization());
  }

  @Test
  public void testBeforeDateNoAssetsReturned() {
    assertTrue(
        AssetSnippets.listAssetsAsOfYesterday(getOrganizationId(), NOTHING_INSTANCE).isEmpty());
  }

  @Test
  public void testListAssetsNoFilterOrDate() {
    assertTrue(59 >= AssetSnippets.listAssets(getOrganizationId()).size());
  }

  @Test
  public void testListAssetsWithFilterAndInstance() {
    assertTrue(
        3 >= AssetSnippets.listAssetsAsOfYesterday(getOrganizationId(), SOMETHING_INSTANCE).size());
  }

  @Test
  public void testChangesReturnsValues() {
    ImmutableList<ListAssetsResult> result =
        AssetSnippets.listAssetAndStatusChanges(
            getOrganizationId(), Duration.ofDays(3), SOMETHING_INSTANCE);
    assertTrue("Result: " + result.toString(), result.toString().contains("ADDED"));
    assertTrue(3 >= result.size());
    assertEquals(result.get(0).getState(), State.ADDED);
  }

  private static OrganizationName getOrganizationId() {
    return OrganizationName.of(System.getenv("GCLOUD_ORGANIZATION"));
  }
}

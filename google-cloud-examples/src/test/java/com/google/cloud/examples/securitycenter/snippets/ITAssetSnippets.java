/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.securitycenter.snippets;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import com.google.cloud.securitycenter.v1.GroupResult;
import com.google.cloud.securitycenter.v1.ListAssetsResponse.ListAssetsResult;
import com.google.cloud.securitycenter.v1.ListAssetsResponse.ListAssetsResult.StateChange;
import com.google.cloud.securitycenter.v1.OrganizationName;
import com.google.common.collect.ImmutableList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
    assertTrue(59 <= AssetSnippets.listAssets(getOrganizationId()).size());
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
    assertEquals(result.get(0).getStateChange(), StateChange.ADDED);
  }

  @Test
  public void testGroupAssets() {
    ImmutableList<GroupResult> results = AssetSnippets.groupAssets(getOrganizationId());
    assertTrue(results.size() > 0);
  }

  @Test
  public void testGroupAssetsWithFilter() {
    ImmutableList<GroupResult> results = AssetSnippets.groupAssetsWithFilter(getOrganizationId());
    assertTrue(results.size() > 0);
  }

  @Test
  public void testGroupAssetsWithCompareDuration() {
    ImmutableList<GroupResult> results =
        AssetSnippets.groupAssetsWithCompareDuration(
            getOrganizationId(), Duration.ofSeconds(86400));
    assertTrue(results.size() > 0);
  }

  @Test
  public void testRunAssetDiscovery() throws IOException {
    PrintStream oldStream = System.out;
    try {

      ByteArrayOutputStream capture = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(capture);
      System.setOut(out);
      AssetSnippets.runAssetDiscovery(getOrganizationId());

      out.flush();
      assertTrue(
          capture.toString(),
          capture.toString().equals("Asset discovery runs asynchronously.\n")
              || capture.toString().equals("Asset discovery run already in progress.\n"));
    } finally {
      System.setOut(oldStream);
    }
  }

  private static OrganizationName getOrganizationId() {
    return OrganizationName.of(System.getenv("GCLOUD_ORGANIZATION"));
  }
}

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

import com.google.cloud.securitycenter.v1beta1.ListAssetsRequest;
import com.google.cloud.securitycenter.v1beta1.ListAssetsResponse.ListAssetsResult;
import com.google.cloud.securitycenter.v1beta1.OrganizationName;
import com.google.cloud.securitycenter.v1beta1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.ListAssetsPagedResponse;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

/** Snippets for how to work with Assets in Cloud Security Command Center. */
public class AssetSnippets {
  private AssetSnippets() {}

  /**
   * Lists all assets for an organization.
   *
   * @param organizationName The organization to list assets for.
   */
  // [START list_all_assets]
  static ImmutableList<ListAssetsResult> listAssets(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to search for all assets in an organization.
      // OrganizationName organizationName = OrganizationName.of("123234324");
      ListAssetsRequest.Builder request =
          ListAssetsRequest.newBuilder().setParent(organizationName.toString());

      // Call the API.
      ListAssetsPagedResponse response = client.listAssets(request.build());

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them batches by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<ListAssetsResult> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("All assets:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END list_all_assets]

  /**
   * Lists all project assets for an organization.
   *
   * @param organizationName The organization to list assets for.
   */
  // [START list_assets_with_filter]
  static ImmutableList<ListAssetsResult> listAssetsWithFilter(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to search for all assets in an organization.
      // OrganizationName organizationName = OrganizationName.of("123234324");
      ListAssetsRequest request =
          ListAssetsRequest.newBuilder()
              .setParent(organizationName.toString())
              .setFilter(
                  "security_center_properties.resource_type=\"google.cloud.resourcemanager.Project\"")
              .build();

      // Call the API.
      ListAssetsPagedResponse response = client.listAssets(request);

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them batches by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<ListAssetsResult> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("Projects:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END list_assets_with_filter]

  /**
   * Lists all project assets for an organization at a given point in time.
   *
   * @param organizationName The organization to list assets for.
   * @param asOf The snapshot time to query for assets. If null defaults to one day ago.
   */
  // [START list_assets_as_of_time]
  static ImmutableList<ListAssetsResult> listAssetsAsOfYesterday(
      OrganizationName organizationName, Instant asOf) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to search for all assets in an organization.
      // OrganizationName organizationName = OrganizationName.of("123234324");

      // Initialize the builder with the organization and filter
      ListAssetsRequest.Builder request =
          ListAssetsRequest.newBuilder()
              .setParent(organizationName.toString())
              .setFilter(
                  "security_center_properties.resource_type=\"google.cloud.resourcemanager.Project\"");

      // Set read time to either the instant passed in or one day ago.
      asOf = MoreObjects.firstNonNull(asOf, Instant.now().minus(Duration.ofDays(1)));
      request.getReadTimeBuilder().setSeconds(asOf.getEpochSecond()).setNanos(asOf.getNano());

      // Call the API.
      ListAssetsPagedResponse response = client.listAssets(request.build());

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them batches by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<ListAssetsResult> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("Projects:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END list_assets_as_of_time]

  /**
   * Returns Assets and metadata about assets activity (e.g. added, removed, no change) between
   * between <code>asOf.minus(timespan)</code> and <code>asOf</code>.
   *
   * @param timeSpan The time-range to compare assets over.
   * @param asOf The instant in time to query for. If null, current time is assumed.
   */
  // [START list_asset_changes_status_changes]
  static ImmutableList<ListAssetsResult> listAssetAndStatusChanges(
      OrganizationName organizationName, Duration timeSpan, Instant asOf) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      // Start setting up a request for to search for all assets in an organization.
      // OrganizationName organizationName = OrganizationName.of("123234324");
      ListAssetsRequest.Builder request =
          ListAssetsRequest.newBuilder()
              .setParent(organizationName.toString())
              .setFilter(
                  "security_center_properties.resource_type=\"google.cloud.resourcemanager.Project\"");
      request
          .getCompareDurationBuilder()
          .setSeconds(timeSpan.getSeconds())
          .setNanos(timeSpan.getNano());

      // Set read time to either the instant passed in or now.
      asOf = MoreObjects.firstNonNull(asOf, Instant.now());
      request.getReadTimeBuilder().setSeconds(asOf.getEpochSecond()).setNanos(asOf.getNano());

      // Call the API.
      ListAssetsPagedResponse response = client.listAssets(request.build());

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them batches by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<ListAssetsResult> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("Projects:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END list_asset_changes_status_changes]

  public static void main(String... args) {
    String org_id = System.getenv("ORGANIZATION_ID");
    if (args.length > 0) {
      org_id = args[0];
    }

    Preconditions.checkNotNull(
        org_id,
        "Organization ID must either be set in the environment variable \"ORGANIZATION_ID\" or passed"
            + " as the first parameter to the program.");

    listAssetsWithFilter(OrganizationName.of(org_id));
  }
}

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

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.ResourceExhaustedException;
import com.google.cloud.securitycenter.v1.GroupAssetsRequest;
import com.google.cloud.securitycenter.v1.GroupResult;
import com.google.cloud.securitycenter.v1.ListAssetsRequest;
import com.google.cloud.securitycenter.v1.ListAssetsResponse.ListAssetsResult;
import com.google.cloud.securitycenter.v1.OrganizationName;
import com.google.cloud.securitycenter.v1.RunAssetDiscoveryResponse;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.SecurityCenterClient.GroupAssetsPagedResponse;
import com.google.cloud.securitycenter.v1.SecurityCenterClient.ListAssetsPagedResponse;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Empty;
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
  // [START securitycenter_list_all_assets]
  // [START list_all_assets]
  static ImmutableList<ListAssetsResult> listAssets(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to search for all assets in an organization.
      // OrganizationName organizationName = OrganizationName.of(/*organizationId=*/"123234324");
      ListAssetsRequest.Builder request =
          ListAssetsRequest.newBuilder().setParent(organizationName.toString());

      // Call the API.
      ListAssetsPagedResponse response = client.listAssets(request.build());

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them incrementally by returning
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
  // [END securitycenter_list_all_assets]

  /**
   * Lists all project assets for an organization.
   *
   * @param organizationName The organization to list assets for.
   */
  // [START securitycenter_list_assets_with_filter]
  // [START list_assets_with_filter]
  static ImmutableList<ListAssetsResult> listAssetsWithFilter(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to search for all assets in an organization.
      // OrganizationName organizationName = OrganizationName.of(/*organizationId=*/"123234324");
      ListAssetsRequest.Builder request =
          ListAssetsRequest.newBuilder()
              .setParent(organizationName.toString())
              .setFilter(
                  "security_center_properties.resource_type=\"google.cloud.resourcemanager.Project\"");

      // Call the API.
      ListAssetsPagedResponse response = client.listAssets(request.build());

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them incrementally by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<ListAssetsResult> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("Project assets:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END list_assets_with_filter]
  // [END securitycenter_list_assets_with_filter]

  /**
   * Lists all project assets for an organization at a given point in time.
   *
   * @param organizationName The organization to list assets for.
   * @param asOf The snapshot time to query for assets. If null defaults to one day ago.
   */
  // [START securitycenter_list_assets_at_time]
  // [START list_assets_as_of_time]
  static ImmutableList<ListAssetsResult> listAssetsAsOfYesterday(
      OrganizationName organizationName, Instant asOf) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to search for all assets in an organization.
      // OrganizationName organizationName = OrganizationName.of(/*organizationId=*/"123234324");

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
      // this can cause out of memory issues.  You can process them incrementally by returning
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
  // [END securitycenter_list_assets_at_time]

  /**
   * Returns Assets and metadata about assets activity (e.g. added, removed, no change) between
   * between <code>asOf.minus(timespan)</code> and <code>asOf</code>.
   *
   * @param timeSpan The time-range to compare assets over.
   * @param asOf The instant in time to query for. If null, current time is assumed.
   */
  // [START securitycenter_list_assets_and_changes]
  // [START list_asset_changes_status_changes]
  static ImmutableList<ListAssetsResult> listAssetAndStatusChanges(
      OrganizationName organizationName, Duration timeSpan, Instant asOf) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      // Start setting up a request for to search for all assets in an organization.
      // OrganizationName organizationName = OrganizationName.of(/*organizationId=*/"123234324");
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
      // this can cause out of memory issues.  You can process them incrementally by returning
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
  // [END securitycenter_list_assets_and_changes]

  /**
   * Groups all assets by their specified properties (e.g. type) for an organization.
   *
   * @param organizationName The organization to group assets for.
   */
  // [START securitycenter_group_all_assets]
  // [START group_all_assets]
  static ImmutableList<GroupResult> groupAssets(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to group all assets by type in an organization.
      // OrganizationName organizationName = OrganizationName.of("123234324");
      GroupAssetsRequest.Builder request =
          GroupAssetsRequest.newBuilder()
              .setGroupBy("security_center_properties.resource_type")
              .setParent(organizationName.toString());

      // Call the API.
      GroupAssetsPagedResponse response = client.groupAssets(request.build());

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them batches by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<GroupResult> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("All assets:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END group_all_assets]
  // [END securitycenter_group_all_assets]

  /**
   * Filters all assets by their specified properties and groups them by specified properties for an
   * organization.
   *
   * @param organizationName The organization to group assets for.
   */
  // [START securitycenter_group_all_assets_with_filter]
  // [START group_all_assets_with_filter]
  static ImmutableList<GroupResult> groupAssetsWithFilter(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to filter all assets by type and group them by project in an
      // organization.
      // OrganizationName organizationName = OrganizationName.of("123234324");
      GroupAssetsRequest.Builder request =
          GroupAssetsRequest.newBuilder()
              .setFilter(
                  "security_center_properties.resource_type=\"google.cloud.resourcemanager.Project\"")
              .setGroupBy("security_center_properties.resource_project")
              .setParent(organizationName.toString());

      // Call the API.
      GroupAssetsPagedResponse response = client.groupAssets(request.build());

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them batches by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<GroupResult> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("All assets:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END group_all_assets_with_filter]
  // [END securitycenter_group_all_assets_with_filter]

  /**
   * Groups all assets by their state_changes (ADDED/DELETED/ACTIVE) during a period of time for an
   * organization.
   *
   * @param organizationName The organization to group assets for.
   */
  // [START securitycenter_group_all_assets_with_compare_duration]
  // [START group_all_assets_with_compare_duration]
  static ImmutableList<GroupResult> groupAssetsWithCompareDuration(
      OrganizationName organizationName, Duration duration) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Start setting up a request for to group all assets during a period of time in an
      // organization.
      // OrganizationName organizationName = OrganizationName.of("123234324");
      GroupAssetsRequest.Builder request =
          GroupAssetsRequest.newBuilder()
              .setGroupBy("state_change")
              .setParent(organizationName.toString());
      request
          .getCompareDurationBuilder()
          .setSeconds(duration.getSeconds())
          .setNanos(duration.getNano());

      // Call the API.
      GroupAssetsPagedResponse response = client.groupAssets(request.build());

      // This creates one list for all assets.  If your organization has a large number of assets
      // this can cause out of memory issues.  You can process them batches by returning
      // the Iterable returned response.iterateAll() directly.
      ImmutableList<GroupResult> results = ImmutableList.copyOf(response.iterateAll());
      System.out.println("All assets:");
      System.out.println(results);
      return results;
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    }
  }
  // [END group_all_assets_with_compare_duration]
  // [END securitycenter_group_all_assets_with_compare_duration]

  // [START securitycenter_run_asset_discovery]
  // [START run_asset_discovery]
  static void runAssetDiscovery(OrganizationName organizationName) {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      // Call the API.  Note calls to runAssetDiscovery are throttled if too many requests
      // are made.
      OperationFuture<RunAssetDiscoveryResponse, Empty> result =
          client.runAssetDiscoveryAsync(organizationName);

      // Uncomment this line to wait for a certain amount of time for the asset discovery run
      // to complete.
      // result.get(130, TimeUnit.SECONDS);
      System.out.println("Asset discovery runs asynchronously.");
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create client.", e);
    } catch (ResourceExhaustedException e) {
      System.out.println("Asset discovery run already in progress.");
    }
  }
  // [END run_asset_discovery]
  // [END securitycenter_run_asset_discovery]

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

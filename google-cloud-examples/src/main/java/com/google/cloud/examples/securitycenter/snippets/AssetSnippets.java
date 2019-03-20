package com.google.cloud.examples.securitycenter.snippets;


import static com.google.cloud.ServiceOptions.getDefaultProjectId;

import com.google.cloud.securitycenter.v1beta1.ListAssetsRequest;
import com.google.cloud.securitycenter.v1beta1.ListAssetsResponse.ListAssetsResult;
import com.google.cloud.securitycenter.v1beta1.OrganizationName;
import com.google.cloud.securitycenter.v1beta1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1beta1.SecurityCenterClient.ListAssetsPagedResponse;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoUnit;

/**
 * Snippets for how to work with Assets in Cloud Security Command Center.
 */
public class AssetSnippets {

  private final SecurityCenterClient securityCenterClient;
  private final OrganizationName organizationName;

  /**
   * Filter that returns all projects in the organization
   */
  // [START asset_resource_project_filter]
  public static final String PROJECT_ASSET_FILTERS =
      "security_center_properties.resource_type=\"google.cloud.resourcemanager.Project\"";
  // [END asset_resource_project_filter]


  /**
   * Create a new AssetSnippets object.
   *
   * @param client The client to use for contacting the service.
   * @param organizationId The organization ID (this should be a numeric value, not the display name
   * of the organization).
   */
  public AssetSnippets(SecurityCenterClient client, String organizationId) {
    this.securityCenterClient = client;
    // [START name_from_id]
    this.organizationName = OrganizationName.of(organizationId);
    // [END name_from_id]
  }

  /**
   * Lists assets for an organization given meeting <code>filter</code> as of a specific instant in
   * time.
   *
   * @param filter The filter that assets must meet (e.g. {@link #PROJECT_ASSET_FILTERS}).  If null,
   * all assets in the organization are returned.
   * @param asOf The instant in time to query for.  If null, current time is assumed
   */

  // [TARGET list_assets]
  // [VARIABLE "filter"]
  // [VARIABLE "as_of"]
  // [START list_assets]
  public ImmutableList<ListAssetsResult> listAssets(String filter,
      Instant asOf) {
    ListAssetsRequest.Builder request =
        ListAssetsRequest.newBuilder().setParent(organizationName.toString());
    // Default for API is to return all assets.
    if (filter != null) {
      request.setFilter(filter);
    }
    // Limits assets returned to a particular point in time.
    if (asOf != null) {
      request.getReadTimeBuilder().setSeconds(asOf.getEpochSecond()).setNanos(asOf.getNano());
    }
    ListAssetsPagedResponse response = securityCenterClient.listAssets(request.build());

    // This creates one list for all assets.  If your organization has a large number of assets
    // this can cause out of memory issues.  You can process them batches by returning
    // the Iterable returned response.iterateAll() directly.
    return ImmutableList.copyOf(response.iterateAll());
  }
  // [END list_assets]

  /**
   * Run and print results from common queries.
   */
  void demoListAssets() {
    // [START demo_list_assets]
    // This takes care of formatting the resource name appropriately from the id..

    // Query for all currently existing assets
    System.out.println("All Assets: " + listAssets(null, null));
    // Query for all projects as of now.
    System.out.println("Project Assets (now): " + listAssets(
        PROJECT_ASSET_FILTERS, null));
    // Query for all projects as of a day ago.
    System.out.println("Project Assets (1 day ago): " + listAssets(
        PROJECT_ASSET_FILTERS,
        Instant.now().minus(Duration.ofDays(1))));
    // [END demo_list_assets]
  }

  /**
   * Returns Assets and metadata about assets activity (e.g. added, removed, no change) between
   * between
   * <code>asOf.minus(timespan)</code> and <code>asOf</code>.
   *
   * @param timeSpan The time-range to compare assets over.
   * @param filter The filter that assets must meet (e.g. {@link #PROJECT_ASSET_FILTERS}).  If null,
   * all assets in the organization are returned.
   * @param asOf The instant in time to query for.  If null, current time is assumed.
   */
  public ImmutableList<ListAssetsResult> listAssetAndStatusChanges(Duration timeSpan, String filter,
      Instant asOf) {
    // [START list_asset_changes]
    ListAssetsRequest.Builder request =
        ListAssetsRequest.newBuilder().setParent(organizationName.toString());
    request.getCompareDurationBuilder().setSeconds(timeSpan.getSeconds())
        .setNanos(timeSpan.getNano());
    //
    if (filter != null) {
      request.setFilter(filter);
    }
    // Limits assets returned to a particular point in time.
    if (asOf != null) {
      request.getReadTimeBuilder().setSeconds(asOf.getEpochSecond()).setNanos(asOf.getNano());
    }

    ListAssetsPagedResponse response = securityCenterClient.listAssets(request.build());

    // This creates one list for all assets.  If your organization has a large number of assets
    // this can cause out of memory issues.  You can process them batches by returning
    // the Iterable returned response.iterateAll() directly.
    return ImmutableList.copyOf(response.iterateAll());
    // [END list_asset_changes]
  }

  /**
   * Run and print demo outputs of different parameters for {@link #listAssetAndStatusChanges(Duration,
   * String, Instant)}.
   */
  void demoListAssetAndStatusChanges() {
    // [START demo_list_asset_changes]
    // List assets that are GCP Projects and their changes over the last day.
    System.out.println(listAssetAndStatusChanges(Duration.ofDays(1), PROJECT_ASSET_FILTERS, null));

    final LocalDateTime jan1 = LocalDateTime.of(2019, 1, 1, 0, 0);
    final LocalDateTime dec1 = LocalDateTime.of(2018, 12, 1, 0, 0);
    final Duration lastMonth = Duration.ofDays(ChronoUnit.DAYS.between(dec1, jan1));
    // Query for GCE instances with the name including "Debia" and there changes over between Dec 1, 2019 and Jan 1, 2019 .
    System.out.println(
        "Project Changes between (between Dec 2019 and Jan 2019): " + listAssetAndStatusChanges(
            lastMonth, /* filter (no filter applied) = */null,
            jan1.atZone(ZoneId.of("Europe/Paris")).toInstant()));
    // [END demo_list_asset_changes]
  }

  public static void main(String... args) throws IOException {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {
      String org_id = System.getenv("ORGANIZATION_ID");
      if (args.length > 0) {
        org_id = args[0];
      }
      if (org_id == null) {
        Preconditions.checkNotNull(org_id,
            "Organization ID must either be set in the environment variable \"ORGANIZATION_ID\" or passed"
                + " as the first parameter to the program.");
      }
      AssetSnippets snippets = new AssetSnippets(client, org_id);
      System.out.println("Project Assets:" + snippets.listAssets(PROJECT_ASSET_FILTERS, null));
      System.out.println("Project Assets (changes as of a day ago): " + snippets
          .listAssetAndStatusChanges(Duration.ofDays(1),
              PROJECT_ASSET_FILTERS, null));
    }
  }

}

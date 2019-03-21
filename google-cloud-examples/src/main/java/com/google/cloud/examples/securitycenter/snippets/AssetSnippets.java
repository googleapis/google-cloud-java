package com.google.cloud.examples.securitycenter.snippets;

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

/** Snippets for how to work with Assets in Cloud Security Command Center. */
public class AssetSnippets {

  private final SecurityCenterClient securityCenterClient;
  private final OrganizationName organizationName;

  /** Filter that returns all projects in the organization */
  // [START asset_resource_project_filter]
  public static final String PROJECT_ASSET_FILTERS =
      "security_center_properties.resource_type=\"google.cloud.resourcemanager.Project\"";
  // [END asset_resource_project_filter]

  /**
   * Create a new AssetSnippets object.
   *
   * @param client The client to use for contacting the service.
   * @param organizationId The organization ID (this should be a numeric value, not the display name
   *     of the organization).
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
   * @param filter The filter that assets must meet (e.g. {@link #PROJECT_ASSET_FILTERS}). If null,
   *     all assets in the organization are returned.
   * @param asOf The instant in time to query for. If null, current time is assumed
   */

  // [START list_assets]
  public ImmutableList<ListAssetsResult> listAssets(String filter, Instant asOf) {
    // Start setting up a request for to search for all assets in an organization.
    // OrganizationName organizationName = OrganizationName.of("123234324");
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

  /** Run and print results from common queries. */
  void demoListAssets() {

    // Query for all currently existing assets
    // [START demo_list_all_assets]
    System.out.println("All Assets: " + listAssets(null, null));
    // [END demo_list_all_assets]
    // Query for all projects as of now.
    // [START demo_list_assets_with_filter]
    System.out.println("Project Assets (now): " + listAssets(PROJECT_ASSET_FILTERS, null));
    // [END demo_list_assets_with_filter]
    // Query for all projects as of a day ago.
    // [START demo_list_assets_with_filter_and_time]
    System.out.println(
        "Project Assets (1 day ago): "
            + listAssets(PROJECT_ASSET_FILTERS, Instant.now().minus(Duration.ofDays(1))));
    // [END demo_list_assets_with_filter_and_time]
  }

  /**
   * Returns Assets and metadata about assets activity (e.g. added, removed, no change) between
   * between <code>asOf.minus(timespan)</code> and <code>asOf</code>.
   *
   * @param timeSpan The time-range to compare assets over.
   * @param filter The filter that assets must meet (e.g. {@link #PROJECT_ASSET_FILTERS}). If null,
   *     all assets in the organization are returned.
   * @param asOf The instant in time to query for. If null, current time is assumed.
   */
  // [START list_asset_changes]
  public ImmutableList<ListAssetsResult> listAssetAndStatusChanges(
      Duration timeSpan, String filter, Instant asOf) {

    // Start setting up a request for to search for all assets in an organization.
    // OrganizationName organizationName = OrganizationName.of("123234324");
    ListAssetsRequest.Builder request =
        ListAssetsRequest.newBuilder().setParent(organizationName.toString());
    request
        .getCompareDurationBuilder()
        .setSeconds(timeSpan.getSeconds())
        .setNanos(timeSpan.getNano());
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
  // [END list_asset_changes]

  /**
   * Run and print demo outputs of different parameters for {@link
   * #listAssetAndStatusChanges(Duration, String, Instant)}.
   */
  void demoListAssetAndStatusChanges() {
    // [START demo_list_asset_changes]
    final LocalDateTime march = LocalDateTime.of(2019, 3, 18, 0, 0);
    final LocalDateTime feb = LocalDateTime.of(2019, 2, 18, 0, 0);
    final Duration lastMonth = Duration.ofDays(ChronoUnit.DAYS.between(feb, march));
    // Query projects and their state changes over between February 18, 2019 and March 18, 2019.
    System.out.println(
        "Project Changes over a month: "
            + listAssetAndStatusChanges(
                lastMonth,
                PROJECT_ASSET_FILTERS,
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
        Preconditions.checkNotNull(
            org_id,
            "Organization ID must either be set in the environment variable \"ORGANIZATION_ID\" or passed"
                + " as the first parameter to the program.");
      }
      AssetSnippets snippets = new AssetSnippets(client, org_id);
      System.out.println("Project Assets:" + snippets.listAssets(PROJECT_ASSET_FILTERS, null));
      System.out.println(
          "Project Assets (changes as of a day ago): "
              + snippets.listAssetAndStatusChanges(
                  Duration.ofDays(1), PROJECT_ASSET_FILTERS, null));
    }
  }
}

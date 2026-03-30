/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListAspectTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntriesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListMetadataFeedsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListMetadataJobsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.LookupEntryLinksPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.SearchEntriesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.AspectType;
import com.google.cloud.dataplex.v1.CancelMetadataJobRequest;
import com.google.cloud.dataplex.v1.CreateAspectTypeRequest;
import com.google.cloud.dataplex.v1.CreateEntryGroupRequest;
import com.google.cloud.dataplex.v1.CreateEntryLinkRequest;
import com.google.cloud.dataplex.v1.CreateEntryRequest;
import com.google.cloud.dataplex.v1.CreateEntryTypeRequest;
import com.google.cloud.dataplex.v1.CreateMetadataFeedRequest;
import com.google.cloud.dataplex.v1.CreateMetadataJobRequest;
import com.google.cloud.dataplex.v1.DeleteAspectTypeRequest;
import com.google.cloud.dataplex.v1.DeleteEntryGroupRequest;
import com.google.cloud.dataplex.v1.DeleteEntryLinkRequest;
import com.google.cloud.dataplex.v1.DeleteEntryRequest;
import com.google.cloud.dataplex.v1.DeleteEntryTypeRequest;
import com.google.cloud.dataplex.v1.DeleteMetadataFeedRequest;
import com.google.cloud.dataplex.v1.Entry;
import com.google.cloud.dataplex.v1.EntryGroup;
import com.google.cloud.dataplex.v1.EntryLink;
import com.google.cloud.dataplex.v1.EntryType;
import com.google.cloud.dataplex.v1.GetAspectTypeRequest;
import com.google.cloud.dataplex.v1.GetEntryGroupRequest;
import com.google.cloud.dataplex.v1.GetEntryLinkRequest;
import com.google.cloud.dataplex.v1.GetEntryRequest;
import com.google.cloud.dataplex.v1.GetEntryTypeRequest;
import com.google.cloud.dataplex.v1.GetMetadataFeedRequest;
import com.google.cloud.dataplex.v1.GetMetadataJobRequest;
import com.google.cloud.dataplex.v1.ListAspectTypesRequest;
import com.google.cloud.dataplex.v1.ListAspectTypesResponse;
import com.google.cloud.dataplex.v1.ListEntriesRequest;
import com.google.cloud.dataplex.v1.ListEntriesResponse;
import com.google.cloud.dataplex.v1.ListEntryGroupsRequest;
import com.google.cloud.dataplex.v1.ListEntryGroupsResponse;
import com.google.cloud.dataplex.v1.ListEntryTypesRequest;
import com.google.cloud.dataplex.v1.ListEntryTypesResponse;
import com.google.cloud.dataplex.v1.ListMetadataFeedsRequest;
import com.google.cloud.dataplex.v1.ListMetadataFeedsResponse;
import com.google.cloud.dataplex.v1.ListMetadataJobsRequest;
import com.google.cloud.dataplex.v1.ListMetadataJobsResponse;
import com.google.cloud.dataplex.v1.LookupContextRequest;
import com.google.cloud.dataplex.v1.LookupContextResponse;
import com.google.cloud.dataplex.v1.LookupEntryLinksRequest;
import com.google.cloud.dataplex.v1.LookupEntryLinksResponse;
import com.google.cloud.dataplex.v1.LookupEntryRequest;
import com.google.cloud.dataplex.v1.MetadataFeed;
import com.google.cloud.dataplex.v1.MetadataJob;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.SearchEntriesRequest;
import com.google.cloud.dataplex.v1.SearchEntriesResponse;
import com.google.cloud.dataplex.v1.SearchEntriesResult;
import com.google.cloud.dataplex.v1.UpdateAspectTypeRequest;
import com.google.cloud.dataplex.v1.UpdateEntryGroupRequest;
import com.google.cloud.dataplex.v1.UpdateEntryLinkRequest;
import com.google.cloud.dataplex.v1.UpdateEntryRequest;
import com.google.cloud.dataplex.v1.UpdateEntryTypeRequest;
import com.google.cloud.dataplex.v1.UpdateMetadataFeedRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CatalogServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getEntryType:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CatalogServiceStubSettings.Builder catalogServiceSettingsBuilder =
 *     CatalogServiceStubSettings.newBuilder();
 * catalogServiceSettingsBuilder
 *     .getEntryTypeSettings()
 *     .setRetrySettings(
 *         catalogServiceSettingsBuilder
 *             .getEntryTypeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * CatalogServiceStubSettings catalogServiceSettings = catalogServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createEntryType:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CatalogServiceStubSettings.Builder catalogServiceSettingsBuilder =
 *     CatalogServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * catalogServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class CatalogServiceStubSettings extends StubSettings<CatalogServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/dataplex.read-write")
          .add("https://www.googleapis.com/auth/dataplex.readonly")
          .build();

  private final UnaryCallSettings<CreateEntryTypeRequest, Operation> createEntryTypeSettings;
  private final OperationCallSettings<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationSettings;
  private final UnaryCallSettings<UpdateEntryTypeRequest, Operation> updateEntryTypeSettings;
  private final OperationCallSettings<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationSettings;
  private final UnaryCallSettings<DeleteEntryTypeRequest, Operation> deleteEntryTypeSettings;
  private final OperationCallSettings<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationSettings;
  private final PagedCallSettings<
          ListEntryTypesRequest, ListEntryTypesResponse, ListEntryTypesPagedResponse>
      listEntryTypesSettings;
  private final UnaryCallSettings<GetEntryTypeRequest, EntryType> getEntryTypeSettings;
  private final UnaryCallSettings<CreateAspectTypeRequest, Operation> createAspectTypeSettings;
  private final OperationCallSettings<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationSettings;
  private final UnaryCallSettings<UpdateAspectTypeRequest, Operation> updateAspectTypeSettings;
  private final OperationCallSettings<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationSettings;
  private final UnaryCallSettings<DeleteAspectTypeRequest, Operation> deleteAspectTypeSettings;
  private final OperationCallSettings<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationSettings;
  private final PagedCallSettings<
          ListAspectTypesRequest, ListAspectTypesResponse, ListAspectTypesPagedResponse>
      listAspectTypesSettings;
  private final UnaryCallSettings<GetAspectTypeRequest, AspectType> getAspectTypeSettings;
  private final UnaryCallSettings<CreateEntryGroupRequest, Operation> createEntryGroupSettings;
  private final OperationCallSettings<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationSettings;
  private final UnaryCallSettings<UpdateEntryGroupRequest, Operation> updateEntryGroupSettings;
  private final OperationCallSettings<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationSettings;
  private final UnaryCallSettings<DeleteEntryGroupRequest, Operation> deleteEntryGroupSettings;
  private final OperationCallSettings<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationSettings;
  private final PagedCallSettings<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      listEntryGroupsSettings;
  private final UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings;
  private final UnaryCallSettings<CreateEntryRequest, Entry> createEntrySettings;
  private final UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings;
  private final UnaryCallSettings<DeleteEntryRequest, Entry> deleteEntrySettings;
  private final PagedCallSettings<ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      listEntriesSettings;
  private final UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings;
  private final UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings;
  private final PagedCallSettings<
          SearchEntriesRequest, SearchEntriesResponse, SearchEntriesPagedResponse>
      searchEntriesSettings;
  private final UnaryCallSettings<CreateMetadataJobRequest, Operation> createMetadataJobSettings;
  private final OperationCallSettings<CreateMetadataJobRequest, MetadataJob, OperationMetadata>
      createMetadataJobOperationSettings;
  private final UnaryCallSettings<GetMetadataJobRequest, MetadataJob> getMetadataJobSettings;
  private final PagedCallSettings<
          ListMetadataJobsRequest, ListMetadataJobsResponse, ListMetadataJobsPagedResponse>
      listMetadataJobsSettings;
  private final UnaryCallSettings<CancelMetadataJobRequest, Empty> cancelMetadataJobSettings;
  private final UnaryCallSettings<CreateEntryLinkRequest, EntryLink> createEntryLinkSettings;
  private final UnaryCallSettings<UpdateEntryLinkRequest, EntryLink> updateEntryLinkSettings;
  private final UnaryCallSettings<DeleteEntryLinkRequest, EntryLink> deleteEntryLinkSettings;
  private final PagedCallSettings<
          LookupEntryLinksRequest, LookupEntryLinksResponse, LookupEntryLinksPagedResponse>
      lookupEntryLinksSettings;
  private final UnaryCallSettings<LookupContextRequest, LookupContextResponse>
      lookupContextSettings;
  private final UnaryCallSettings<GetEntryLinkRequest, EntryLink> getEntryLinkSettings;
  private final UnaryCallSettings<CreateMetadataFeedRequest, Operation> createMetadataFeedSettings;
  private final OperationCallSettings<CreateMetadataFeedRequest, MetadataFeed, OperationMetadata>
      createMetadataFeedOperationSettings;
  private final UnaryCallSettings<GetMetadataFeedRequest, MetadataFeed> getMetadataFeedSettings;
  private final PagedCallSettings<
          ListMetadataFeedsRequest, ListMetadataFeedsResponse, ListMetadataFeedsPagedResponse>
      listMetadataFeedsSettings;
  private final UnaryCallSettings<DeleteMetadataFeedRequest, Operation> deleteMetadataFeedSettings;
  private final OperationCallSettings<DeleteMetadataFeedRequest, Empty, OperationMetadata>
      deleteMetadataFeedOperationSettings;
  private final UnaryCallSettings<UpdateMetadataFeedRequest, Operation> updateMetadataFeedSettings;
  private final OperationCallSettings<UpdateMetadataFeedRequest, MetadataFeed, OperationMetadata>
      updateMetadataFeedOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListEntryTypesRequest, ListEntryTypesResponse, EntryType>
      LIST_ENTRY_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntryTypesRequest, ListEntryTypesResponse, EntryType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntryTypesRequest injectToken(ListEntryTypesRequest payload, String token) {
              return ListEntryTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntryTypesRequest injectPageSize(
                ListEntryTypesRequest payload, int pageSize) {
              return ListEntryTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntryTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntryTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntryType> extractResources(ListEntryTypesResponse payload) {
              return payload.getEntryTypesList();
            }
          };

  private static final PagedListDescriptor<
          ListAspectTypesRequest, ListAspectTypesResponse, AspectType>
      LIST_ASPECT_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAspectTypesRequest, ListAspectTypesResponse, AspectType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAspectTypesRequest injectToken(
                ListAspectTypesRequest payload, String token) {
              return ListAspectTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAspectTypesRequest injectPageSize(
                ListAspectTypesRequest payload, int pageSize) {
              return ListAspectTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAspectTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAspectTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AspectType> extractResources(ListAspectTypesResponse payload) {
              return payload.getAspectTypesList();
            }
          };

  private static final PagedListDescriptor<
          ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup>
      LIST_ENTRY_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntryGroupsRequest injectToken(
                ListEntryGroupsRequest payload, String token) {
              return ListEntryGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntryGroupsRequest injectPageSize(
                ListEntryGroupsRequest payload, int pageSize) {
              return ListEntryGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntryGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntryGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntryGroup> extractResources(ListEntryGroupsResponse payload) {
              return payload.getEntryGroupsList();
            }
          };

  private static final PagedListDescriptor<ListEntriesRequest, ListEntriesResponse, Entry>
      LIST_ENTRIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntriesRequest, ListEntriesResponse, Entry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntriesRequest injectToken(ListEntriesRequest payload, String token) {
              return ListEntriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntriesRequest injectPageSize(ListEntriesRequest payload, int pageSize) {
              return ListEntriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entry> extractResources(ListEntriesResponse payload) {
              return payload.getEntriesList();
            }
          };

  private static final PagedListDescriptor<
          SearchEntriesRequest, SearchEntriesResponse, SearchEntriesResult>
      SEARCH_ENTRIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchEntriesRequest, SearchEntriesResponse, SearchEntriesResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchEntriesRequest injectToken(SearchEntriesRequest payload, String token) {
              return SearchEntriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchEntriesRequest injectPageSize(SearchEntriesRequest payload, int pageSize) {
              return SearchEntriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchEntriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchEntriesResult> extractResources(SearchEntriesResponse payload) {
              return payload.getResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListMetadataJobsRequest, ListMetadataJobsResponse, MetadataJob>
      LIST_METADATA_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMetadataJobsRequest, ListMetadataJobsResponse, MetadataJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMetadataJobsRequest injectToken(
                ListMetadataJobsRequest payload, String token) {
              return ListMetadataJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMetadataJobsRequest injectPageSize(
                ListMetadataJobsRequest payload, int pageSize) {
              return ListMetadataJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMetadataJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMetadataJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MetadataJob> extractResources(ListMetadataJobsResponse payload) {
              return payload.getMetadataJobsList();
            }
          };

  private static final PagedListDescriptor<
          LookupEntryLinksRequest, LookupEntryLinksResponse, EntryLink>
      LOOKUP_ENTRY_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<LookupEntryLinksRequest, LookupEntryLinksResponse, EntryLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public LookupEntryLinksRequest injectToken(
                LookupEntryLinksRequest payload, String token) {
              return LookupEntryLinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public LookupEntryLinksRequest injectPageSize(
                LookupEntryLinksRequest payload, int pageSize) {
              return LookupEntryLinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(LookupEntryLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(LookupEntryLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntryLink> extractResources(LookupEntryLinksResponse payload) {
              return payload.getEntryLinksList();
            }
          };

  private static final PagedListDescriptor<
          ListMetadataFeedsRequest, ListMetadataFeedsResponse, MetadataFeed>
      LIST_METADATA_FEEDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMetadataFeedsRequest, ListMetadataFeedsResponse, MetadataFeed>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMetadataFeedsRequest injectToken(
                ListMetadataFeedsRequest payload, String token) {
              return ListMetadataFeedsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMetadataFeedsRequest injectPageSize(
                ListMetadataFeedsRequest payload, int pageSize) {
              return ListMetadataFeedsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMetadataFeedsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMetadataFeedsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MetadataFeed> extractResources(ListMetadataFeedsResponse payload) {
              return payload.getMetadataFeedsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEntryTypesRequest, ListEntryTypesResponse, ListEntryTypesPagedResponse>
      LIST_ENTRY_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntryTypesRequest, ListEntryTypesResponse, ListEntryTypesPagedResponse>() {
            @Override
            public ApiFuture<ListEntryTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntryTypesRequest, ListEntryTypesResponse> callable,
                ListEntryTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListEntryTypesResponse> futureResponse) {
              PageContext<ListEntryTypesRequest, ListEntryTypesResponse, EntryType> pageContext =
                  PageContext.create(callable, LIST_ENTRY_TYPES_PAGE_STR_DESC, request, context);
              return ListEntryTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAspectTypesRequest, ListAspectTypesResponse, ListAspectTypesPagedResponse>
      LIST_ASPECT_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAspectTypesRequest, ListAspectTypesResponse, ListAspectTypesPagedResponse>() {
            @Override
            public ApiFuture<ListAspectTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAspectTypesRequest, ListAspectTypesResponse> callable,
                ListAspectTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListAspectTypesResponse> futureResponse) {
              PageContext<ListAspectTypesRequest, ListAspectTypesResponse, AspectType> pageContext =
                  PageContext.create(callable, LIST_ASPECT_TYPES_PAGE_STR_DESC, request, context);
              return ListAspectTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      LIST_ENTRY_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListEntryGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> callable,
                ListEntryGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListEntryGroupsResponse> futureResponse) {
              PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> pageContext =
                  PageContext.create(callable, LIST_ENTRY_GROUPS_PAGE_STR_DESC, request, context);
              return ListEntryGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      LIST_ENTRIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>() {
            @Override
            public ApiFuture<ListEntriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntriesRequest, ListEntriesResponse> callable,
                ListEntriesRequest request,
                ApiCallContext context,
                ApiFuture<ListEntriesResponse> futureResponse) {
              PageContext<ListEntriesRequest, ListEntriesResponse, Entry> pageContext =
                  PageContext.create(callable, LIST_ENTRIES_PAGE_STR_DESC, request, context);
              return ListEntriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchEntriesRequest, SearchEntriesResponse, SearchEntriesPagedResponse>
      SEARCH_ENTRIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchEntriesRequest, SearchEntriesResponse, SearchEntriesPagedResponse>() {
            @Override
            public ApiFuture<SearchEntriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchEntriesRequest, SearchEntriesResponse> callable,
                SearchEntriesRequest request,
                ApiCallContext context,
                ApiFuture<SearchEntriesResponse> futureResponse) {
              PageContext<SearchEntriesRequest, SearchEntriesResponse, SearchEntriesResult>
                  pageContext =
                      PageContext.create(callable, SEARCH_ENTRIES_PAGE_STR_DESC, request, context);
              return SearchEntriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMetadataJobsRequest, ListMetadataJobsResponse, ListMetadataJobsPagedResponse>
      LIST_METADATA_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMetadataJobsRequest, ListMetadataJobsResponse, ListMetadataJobsPagedResponse>() {
            @Override
            public ApiFuture<ListMetadataJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMetadataJobsRequest, ListMetadataJobsResponse> callable,
                ListMetadataJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListMetadataJobsResponse> futureResponse) {
              PageContext<ListMetadataJobsRequest, ListMetadataJobsResponse, MetadataJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_METADATA_JOBS_PAGE_STR_DESC, request, context);
              return ListMetadataJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          LookupEntryLinksRequest, LookupEntryLinksResponse, LookupEntryLinksPagedResponse>
      LOOKUP_ENTRY_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              LookupEntryLinksRequest, LookupEntryLinksResponse, LookupEntryLinksPagedResponse>() {
            @Override
            public ApiFuture<LookupEntryLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<LookupEntryLinksRequest, LookupEntryLinksResponse> callable,
                LookupEntryLinksRequest request,
                ApiCallContext context,
                ApiFuture<LookupEntryLinksResponse> futureResponse) {
              PageContext<LookupEntryLinksRequest, LookupEntryLinksResponse, EntryLink>
                  pageContext =
                      PageContext.create(
                          callable, LOOKUP_ENTRY_LINKS_PAGE_STR_DESC, request, context);
              return LookupEntryLinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMetadataFeedsRequest, ListMetadataFeedsResponse, ListMetadataFeedsPagedResponse>
      LIST_METADATA_FEEDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMetadataFeedsRequest,
              ListMetadataFeedsResponse,
              ListMetadataFeedsPagedResponse>() {
            @Override
            public ApiFuture<ListMetadataFeedsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMetadataFeedsRequest, ListMetadataFeedsResponse> callable,
                ListMetadataFeedsRequest request,
                ApiCallContext context,
                ApiFuture<ListMetadataFeedsResponse> futureResponse) {
              PageContext<ListMetadataFeedsRequest, ListMetadataFeedsResponse, MetadataFeed>
                  pageContext =
                      PageContext.create(
                          callable, LIST_METADATA_FEEDS_PAGE_STR_DESC, request, context);
              return ListMetadataFeedsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createEntryType. */
  public UnaryCallSettings<CreateEntryTypeRequest, Operation> createEntryTypeSettings() {
    return createEntryTypeSettings;
  }

  /** Returns the object with the settings used for calls to createEntryType. */
  public OperationCallSettings<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationSettings() {
    return createEntryTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEntryType. */
  public UnaryCallSettings<UpdateEntryTypeRequest, Operation> updateEntryTypeSettings() {
    return updateEntryTypeSettings;
  }

  /** Returns the object with the settings used for calls to updateEntryType. */
  public OperationCallSettings<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationSettings() {
    return updateEntryTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntryType. */
  public UnaryCallSettings<DeleteEntryTypeRequest, Operation> deleteEntryTypeSettings() {
    return deleteEntryTypeSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntryType. */
  public OperationCallSettings<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationSettings() {
    return deleteEntryTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEntryTypes. */
  public PagedCallSettings<
          ListEntryTypesRequest, ListEntryTypesResponse, ListEntryTypesPagedResponse>
      listEntryTypesSettings() {
    return listEntryTypesSettings;
  }

  /** Returns the object with the settings used for calls to getEntryType. */
  public UnaryCallSettings<GetEntryTypeRequest, EntryType> getEntryTypeSettings() {
    return getEntryTypeSettings;
  }

  /** Returns the object with the settings used for calls to createAspectType. */
  public UnaryCallSettings<CreateAspectTypeRequest, Operation> createAspectTypeSettings() {
    return createAspectTypeSettings;
  }

  /** Returns the object with the settings used for calls to createAspectType. */
  public OperationCallSettings<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationSettings() {
    return createAspectTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAspectType. */
  public UnaryCallSettings<UpdateAspectTypeRequest, Operation> updateAspectTypeSettings() {
    return updateAspectTypeSettings;
  }

  /** Returns the object with the settings used for calls to updateAspectType. */
  public OperationCallSettings<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationSettings() {
    return updateAspectTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAspectType. */
  public UnaryCallSettings<DeleteAspectTypeRequest, Operation> deleteAspectTypeSettings() {
    return deleteAspectTypeSettings;
  }

  /** Returns the object with the settings used for calls to deleteAspectType. */
  public OperationCallSettings<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationSettings() {
    return deleteAspectTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAspectTypes. */
  public PagedCallSettings<
          ListAspectTypesRequest, ListAspectTypesResponse, ListAspectTypesPagedResponse>
      listAspectTypesSettings() {
    return listAspectTypesSettings;
  }

  /** Returns the object with the settings used for calls to getAspectType. */
  public UnaryCallSettings<GetAspectTypeRequest, AspectType> getAspectTypeSettings() {
    return getAspectTypeSettings;
  }

  /** Returns the object with the settings used for calls to createEntryGroup. */
  public UnaryCallSettings<CreateEntryGroupRequest, Operation> createEntryGroupSettings() {
    return createEntryGroupSettings;
  }

  /** Returns the object with the settings used for calls to createEntryGroup. */
  public OperationCallSettings<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationSettings() {
    return createEntryGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEntryGroup. */
  public UnaryCallSettings<UpdateEntryGroupRequest, Operation> updateEntryGroupSettings() {
    return updateEntryGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateEntryGroup. */
  public OperationCallSettings<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationSettings() {
    return updateEntryGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntryGroup. */
  public UnaryCallSettings<DeleteEntryGroupRequest, Operation> deleteEntryGroupSettings() {
    return deleteEntryGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntryGroup. */
  public OperationCallSettings<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationSettings() {
    return deleteEntryGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEntryGroups. */
  public PagedCallSettings<
          ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
      listEntryGroupsSettings() {
    return listEntryGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getEntryGroup. */
  public UnaryCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
    return getEntryGroupSettings;
  }

  /** Returns the object with the settings used for calls to createEntry. */
  public UnaryCallSettings<CreateEntryRequest, Entry> createEntrySettings() {
    return createEntrySettings;
  }

  /** Returns the object with the settings used for calls to updateEntry. */
  public UnaryCallSettings<UpdateEntryRequest, Entry> updateEntrySettings() {
    return updateEntrySettings;
  }

  /** Returns the object with the settings used for calls to deleteEntry. */
  public UnaryCallSettings<DeleteEntryRequest, Entry> deleteEntrySettings() {
    return deleteEntrySettings;
  }

  /** Returns the object with the settings used for calls to listEntries. */
  public PagedCallSettings<ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
      listEntriesSettings() {
    return listEntriesSettings;
  }

  /** Returns the object with the settings used for calls to getEntry. */
  public UnaryCallSettings<GetEntryRequest, Entry> getEntrySettings() {
    return getEntrySettings;
  }

  /** Returns the object with the settings used for calls to lookupEntry. */
  public UnaryCallSettings<LookupEntryRequest, Entry> lookupEntrySettings() {
    return lookupEntrySettings;
  }

  /** Returns the object with the settings used for calls to searchEntries. */
  public PagedCallSettings<SearchEntriesRequest, SearchEntriesResponse, SearchEntriesPagedResponse>
      searchEntriesSettings() {
    return searchEntriesSettings;
  }

  /** Returns the object with the settings used for calls to createMetadataJob. */
  public UnaryCallSettings<CreateMetadataJobRequest, Operation> createMetadataJobSettings() {
    return createMetadataJobSettings;
  }

  /** Returns the object with the settings used for calls to createMetadataJob. */
  public OperationCallSettings<CreateMetadataJobRequest, MetadataJob, OperationMetadata>
      createMetadataJobOperationSettings() {
    return createMetadataJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to getMetadataJob. */
  public UnaryCallSettings<GetMetadataJobRequest, MetadataJob> getMetadataJobSettings() {
    return getMetadataJobSettings;
  }

  /** Returns the object with the settings used for calls to listMetadataJobs. */
  public PagedCallSettings<
          ListMetadataJobsRequest, ListMetadataJobsResponse, ListMetadataJobsPagedResponse>
      listMetadataJobsSettings() {
    return listMetadataJobsSettings;
  }

  /** Returns the object with the settings used for calls to cancelMetadataJob. */
  public UnaryCallSettings<CancelMetadataJobRequest, Empty> cancelMetadataJobSettings() {
    return cancelMetadataJobSettings;
  }

  /** Returns the object with the settings used for calls to createEntryLink. */
  public UnaryCallSettings<CreateEntryLinkRequest, EntryLink> createEntryLinkSettings() {
    return createEntryLinkSettings;
  }

  /** Returns the object with the settings used for calls to updateEntryLink. */
  public UnaryCallSettings<UpdateEntryLinkRequest, EntryLink> updateEntryLinkSettings() {
    return updateEntryLinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntryLink. */
  public UnaryCallSettings<DeleteEntryLinkRequest, EntryLink> deleteEntryLinkSettings() {
    return deleteEntryLinkSettings;
  }

  /** Returns the object with the settings used for calls to lookupEntryLinks. */
  public PagedCallSettings<
          LookupEntryLinksRequest, LookupEntryLinksResponse, LookupEntryLinksPagedResponse>
      lookupEntryLinksSettings() {
    return lookupEntryLinksSettings;
  }

  /** Returns the object with the settings used for calls to lookupContext. */
  public UnaryCallSettings<LookupContextRequest, LookupContextResponse> lookupContextSettings() {
    return lookupContextSettings;
  }

  /** Returns the object with the settings used for calls to getEntryLink. */
  public UnaryCallSettings<GetEntryLinkRequest, EntryLink> getEntryLinkSettings() {
    return getEntryLinkSettings;
  }

  /** Returns the object with the settings used for calls to createMetadataFeed. */
  public UnaryCallSettings<CreateMetadataFeedRequest, Operation> createMetadataFeedSettings() {
    return createMetadataFeedSettings;
  }

  /** Returns the object with the settings used for calls to createMetadataFeed. */
  public OperationCallSettings<CreateMetadataFeedRequest, MetadataFeed, OperationMetadata>
      createMetadataFeedOperationSettings() {
    return createMetadataFeedOperationSettings;
  }

  /** Returns the object with the settings used for calls to getMetadataFeed. */
  public UnaryCallSettings<GetMetadataFeedRequest, MetadataFeed> getMetadataFeedSettings() {
    return getMetadataFeedSettings;
  }

  /** Returns the object with the settings used for calls to listMetadataFeeds. */
  public PagedCallSettings<
          ListMetadataFeedsRequest, ListMetadataFeedsResponse, ListMetadataFeedsPagedResponse>
      listMetadataFeedsSettings() {
    return listMetadataFeedsSettings;
  }

  /** Returns the object with the settings used for calls to deleteMetadataFeed. */
  public UnaryCallSettings<DeleteMetadataFeedRequest, Operation> deleteMetadataFeedSettings() {
    return deleteMetadataFeedSettings;
  }

  /** Returns the object with the settings used for calls to deleteMetadataFeed. */
  public OperationCallSettings<DeleteMetadataFeedRequest, Empty, OperationMetadata>
      deleteMetadataFeedOperationSettings() {
    return deleteMetadataFeedOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMetadataFeed. */
  public UnaryCallSettings<UpdateMetadataFeedRequest, Operation> updateMetadataFeedSettings() {
    return updateMetadataFeedSettings;
  }

  /** Returns the object with the settings used for calls to updateMetadataFeed. */
  public OperationCallSettings<UpdateMetadataFeedRequest, MetadataFeed, OperationMetadata>
      updateMetadataFeedOperationSettings() {
    return updateMetadataFeedOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public CatalogServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCatalogServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCatalogServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dataplex";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "dataplex.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataplex.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CatalogServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CatalogServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CatalogServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CatalogServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createEntryTypeSettings = settingsBuilder.createEntryTypeSettings().build();
    createEntryTypeOperationSettings = settingsBuilder.createEntryTypeOperationSettings().build();
    updateEntryTypeSettings = settingsBuilder.updateEntryTypeSettings().build();
    updateEntryTypeOperationSettings = settingsBuilder.updateEntryTypeOperationSettings().build();
    deleteEntryTypeSettings = settingsBuilder.deleteEntryTypeSettings().build();
    deleteEntryTypeOperationSettings = settingsBuilder.deleteEntryTypeOperationSettings().build();
    listEntryTypesSettings = settingsBuilder.listEntryTypesSettings().build();
    getEntryTypeSettings = settingsBuilder.getEntryTypeSettings().build();
    createAspectTypeSettings = settingsBuilder.createAspectTypeSettings().build();
    createAspectTypeOperationSettings = settingsBuilder.createAspectTypeOperationSettings().build();
    updateAspectTypeSettings = settingsBuilder.updateAspectTypeSettings().build();
    updateAspectTypeOperationSettings = settingsBuilder.updateAspectTypeOperationSettings().build();
    deleteAspectTypeSettings = settingsBuilder.deleteAspectTypeSettings().build();
    deleteAspectTypeOperationSettings = settingsBuilder.deleteAspectTypeOperationSettings().build();
    listAspectTypesSettings = settingsBuilder.listAspectTypesSettings().build();
    getAspectTypeSettings = settingsBuilder.getAspectTypeSettings().build();
    createEntryGroupSettings = settingsBuilder.createEntryGroupSettings().build();
    createEntryGroupOperationSettings = settingsBuilder.createEntryGroupOperationSettings().build();
    updateEntryGroupSettings = settingsBuilder.updateEntryGroupSettings().build();
    updateEntryGroupOperationSettings = settingsBuilder.updateEntryGroupOperationSettings().build();
    deleteEntryGroupSettings = settingsBuilder.deleteEntryGroupSettings().build();
    deleteEntryGroupOperationSettings = settingsBuilder.deleteEntryGroupOperationSettings().build();
    listEntryGroupsSettings = settingsBuilder.listEntryGroupsSettings().build();
    getEntryGroupSettings = settingsBuilder.getEntryGroupSettings().build();
    createEntrySettings = settingsBuilder.createEntrySettings().build();
    updateEntrySettings = settingsBuilder.updateEntrySettings().build();
    deleteEntrySettings = settingsBuilder.deleteEntrySettings().build();
    listEntriesSettings = settingsBuilder.listEntriesSettings().build();
    getEntrySettings = settingsBuilder.getEntrySettings().build();
    lookupEntrySettings = settingsBuilder.lookupEntrySettings().build();
    searchEntriesSettings = settingsBuilder.searchEntriesSettings().build();
    createMetadataJobSettings = settingsBuilder.createMetadataJobSettings().build();
    createMetadataJobOperationSettings =
        settingsBuilder.createMetadataJobOperationSettings().build();
    getMetadataJobSettings = settingsBuilder.getMetadataJobSettings().build();
    listMetadataJobsSettings = settingsBuilder.listMetadataJobsSettings().build();
    cancelMetadataJobSettings = settingsBuilder.cancelMetadataJobSettings().build();
    createEntryLinkSettings = settingsBuilder.createEntryLinkSettings().build();
    updateEntryLinkSettings = settingsBuilder.updateEntryLinkSettings().build();
    deleteEntryLinkSettings = settingsBuilder.deleteEntryLinkSettings().build();
    lookupEntryLinksSettings = settingsBuilder.lookupEntryLinksSettings().build();
    lookupContextSettings = settingsBuilder.lookupContextSettings().build();
    getEntryLinkSettings = settingsBuilder.getEntryLinkSettings().build();
    createMetadataFeedSettings = settingsBuilder.createMetadataFeedSettings().build();
    createMetadataFeedOperationSettings =
        settingsBuilder.createMetadataFeedOperationSettings().build();
    getMetadataFeedSettings = settingsBuilder.getMetadataFeedSettings().build();
    listMetadataFeedsSettings = settingsBuilder.listMetadataFeedsSettings().build();
    deleteMetadataFeedSettings = settingsBuilder.deleteMetadataFeedSettings().build();
    deleteMetadataFeedOperationSettings =
        settingsBuilder.deleteMetadataFeedOperationSettings().build();
    updateMetadataFeedSettings = settingsBuilder.updateMetadataFeedSettings().build();
    updateMetadataFeedOperationSettings =
        settingsBuilder.updateMetadataFeedOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-dataplex")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for CatalogServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<CatalogServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateEntryTypeRequest, Operation>
        createEntryTypeSettings;
    private final OperationCallSettings.Builder<
            CreateEntryTypeRequest, EntryType, OperationMetadata>
        createEntryTypeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEntryTypeRequest, Operation>
        updateEntryTypeSettings;
    private final OperationCallSettings.Builder<
            UpdateEntryTypeRequest, EntryType, OperationMetadata>
        updateEntryTypeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEntryTypeRequest, Operation>
        deleteEntryTypeSettings;
    private final OperationCallSettings.Builder<DeleteEntryTypeRequest, Empty, OperationMetadata>
        deleteEntryTypeOperationSettings;
    private final PagedCallSettings.Builder<
            ListEntryTypesRequest, ListEntryTypesResponse, ListEntryTypesPagedResponse>
        listEntryTypesSettings;
    private final UnaryCallSettings.Builder<GetEntryTypeRequest, EntryType> getEntryTypeSettings;
    private final UnaryCallSettings.Builder<CreateAspectTypeRequest, Operation>
        createAspectTypeSettings;
    private final OperationCallSettings.Builder<
            CreateAspectTypeRequest, AspectType, OperationMetadata>
        createAspectTypeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAspectTypeRequest, Operation>
        updateAspectTypeSettings;
    private final OperationCallSettings.Builder<
            UpdateAspectTypeRequest, AspectType, OperationMetadata>
        updateAspectTypeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAspectTypeRequest, Operation>
        deleteAspectTypeSettings;
    private final OperationCallSettings.Builder<DeleteAspectTypeRequest, Empty, OperationMetadata>
        deleteAspectTypeOperationSettings;
    private final PagedCallSettings.Builder<
            ListAspectTypesRequest, ListAspectTypesResponse, ListAspectTypesPagedResponse>
        listAspectTypesSettings;
    private final UnaryCallSettings.Builder<GetAspectTypeRequest, AspectType> getAspectTypeSettings;
    private final UnaryCallSettings.Builder<CreateEntryGroupRequest, Operation>
        createEntryGroupSettings;
    private final OperationCallSettings.Builder<
            CreateEntryGroupRequest, EntryGroup, OperationMetadata>
        createEntryGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEntryGroupRequest, Operation>
        updateEntryGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
        updateEntryGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEntryGroupRequest, Operation>
        deleteEntryGroupSettings;
    private final OperationCallSettings.Builder<DeleteEntryGroupRequest, Empty, OperationMetadata>
        deleteEntryGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
        listEntryGroupsSettings;
    private final UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings;
    private final UnaryCallSettings.Builder<CreateEntryRequest, Entry> createEntrySettings;
    private final UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings;
    private final UnaryCallSettings.Builder<DeleteEntryRequest, Entry> deleteEntrySettings;
    private final PagedCallSettings.Builder<
            ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
        listEntriesSettings;
    private final UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings;
    private final UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings;
    private final PagedCallSettings.Builder<
            SearchEntriesRequest, SearchEntriesResponse, SearchEntriesPagedResponse>
        searchEntriesSettings;
    private final UnaryCallSettings.Builder<CreateMetadataJobRequest, Operation>
        createMetadataJobSettings;
    private final OperationCallSettings.Builder<
            CreateMetadataJobRequest, MetadataJob, OperationMetadata>
        createMetadataJobOperationSettings;
    private final UnaryCallSettings.Builder<GetMetadataJobRequest, MetadataJob>
        getMetadataJobSettings;
    private final PagedCallSettings.Builder<
            ListMetadataJobsRequest, ListMetadataJobsResponse, ListMetadataJobsPagedResponse>
        listMetadataJobsSettings;
    private final UnaryCallSettings.Builder<CancelMetadataJobRequest, Empty>
        cancelMetadataJobSettings;
    private final UnaryCallSettings.Builder<CreateEntryLinkRequest, EntryLink>
        createEntryLinkSettings;
    private final UnaryCallSettings.Builder<UpdateEntryLinkRequest, EntryLink>
        updateEntryLinkSettings;
    private final UnaryCallSettings.Builder<DeleteEntryLinkRequest, EntryLink>
        deleteEntryLinkSettings;
    private final PagedCallSettings.Builder<
            LookupEntryLinksRequest, LookupEntryLinksResponse, LookupEntryLinksPagedResponse>
        lookupEntryLinksSettings;
    private final UnaryCallSettings.Builder<LookupContextRequest, LookupContextResponse>
        lookupContextSettings;
    private final UnaryCallSettings.Builder<GetEntryLinkRequest, EntryLink> getEntryLinkSettings;
    private final UnaryCallSettings.Builder<CreateMetadataFeedRequest, Operation>
        createMetadataFeedSettings;
    private final OperationCallSettings.Builder<
            CreateMetadataFeedRequest, MetadataFeed, OperationMetadata>
        createMetadataFeedOperationSettings;
    private final UnaryCallSettings.Builder<GetMetadataFeedRequest, MetadataFeed>
        getMetadataFeedSettings;
    private final PagedCallSettings.Builder<
            ListMetadataFeedsRequest, ListMetadataFeedsResponse, ListMetadataFeedsPagedResponse>
        listMetadataFeedsSettings;
    private final UnaryCallSettings.Builder<DeleteMetadataFeedRequest, Operation>
        deleteMetadataFeedSettings;
    private final OperationCallSettings.Builder<DeleteMetadataFeedRequest, Empty, OperationMetadata>
        deleteMetadataFeedOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMetadataFeedRequest, Operation>
        updateMetadataFeedSettings;
    private final OperationCallSettings.Builder<
            UpdateMetadataFeedRequest, MetadataFeed, OperationMetadata>
        updateMetadataFeedOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_13_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_12_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.RESOURCE_EXHAUSTED)));
      definitions.put(
          "no_retry_11_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_10_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.RESOURCE_EXHAUSTED)));
      definitions.put(
          "retry_policy_9_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.RESOURCE_EXHAUSTED)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_13_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_12_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_11_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_10_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(20000L))
              .setTotalTimeoutDuration(Duration.ofMillis(20000L))
              .build();
      definitions.put("retry_policy_9_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createEntryTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntryTypeOperationSettings = OperationCallSettings.newBuilder();
      updateEntryTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntryTypeOperationSettings = OperationCallSettings.newBuilder();
      deleteEntryTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntryTypeOperationSettings = OperationCallSettings.newBuilder();
      listEntryTypesSettings = PagedCallSettings.newBuilder(LIST_ENTRY_TYPES_PAGE_STR_FACT);
      getEntryTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAspectTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAspectTypeOperationSettings = OperationCallSettings.newBuilder();
      updateAspectTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAspectTypeOperationSettings = OperationCallSettings.newBuilder();
      deleteAspectTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAspectTypeOperationSettings = OperationCallSettings.newBuilder();
      listAspectTypesSettings = PagedCallSettings.newBuilder(LIST_ASPECT_TYPES_PAGE_STR_FACT);
      getAspectTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntryGroupOperationSettings = OperationCallSettings.newBuilder();
      updateEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntryGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntryGroupOperationSettings = OperationCallSettings.newBuilder();
      listEntryGroupsSettings = PagedCallSettings.newBuilder(LIST_ENTRY_GROUPS_PAGE_STR_FACT);
      getEntryGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntriesSettings = PagedCallSettings.newBuilder(LIST_ENTRIES_PAGE_STR_FACT);
      getEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchEntriesSettings = PagedCallSettings.newBuilder(SEARCH_ENTRIES_PAGE_STR_FACT);
      createMetadataJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMetadataJobOperationSettings = OperationCallSettings.newBuilder();
      getMetadataJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMetadataJobsSettings = PagedCallSettings.newBuilder(LIST_METADATA_JOBS_PAGE_STR_FACT);
      cancelMetadataJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntryLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntryLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntryLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupEntryLinksSettings = PagedCallSettings.newBuilder(LOOKUP_ENTRY_LINKS_PAGE_STR_FACT);
      lookupContextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEntryLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMetadataFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMetadataFeedOperationSettings = OperationCallSettings.newBuilder();
      getMetadataFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMetadataFeedsSettings = PagedCallSettings.newBuilder(LIST_METADATA_FEEDS_PAGE_STR_FACT);
      deleteMetadataFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMetadataFeedOperationSettings = OperationCallSettings.newBuilder();
      updateMetadataFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMetadataFeedOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEntryTypeSettings,
              updateEntryTypeSettings,
              deleteEntryTypeSettings,
              listEntryTypesSettings,
              getEntryTypeSettings,
              createAspectTypeSettings,
              updateAspectTypeSettings,
              deleteAspectTypeSettings,
              listAspectTypesSettings,
              getAspectTypeSettings,
              createEntryGroupSettings,
              updateEntryGroupSettings,
              deleteEntryGroupSettings,
              listEntryGroupsSettings,
              getEntryGroupSettings,
              createEntrySettings,
              updateEntrySettings,
              deleteEntrySettings,
              listEntriesSettings,
              getEntrySettings,
              lookupEntrySettings,
              searchEntriesSettings,
              createMetadataJobSettings,
              getMetadataJobSettings,
              listMetadataJobsSettings,
              cancelMetadataJobSettings,
              createEntryLinkSettings,
              updateEntryLinkSettings,
              deleteEntryLinkSettings,
              lookupEntryLinksSettings,
              lookupContextSettings,
              getEntryLinkSettings,
              createMetadataFeedSettings,
              getMetadataFeedSettings,
              listMetadataFeedsSettings,
              deleteMetadataFeedSettings,
              updateMetadataFeedSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(CatalogServiceStubSettings settings) {
      super(settings);

      createEntryTypeSettings = settings.createEntryTypeSettings.toBuilder();
      createEntryTypeOperationSettings = settings.createEntryTypeOperationSettings.toBuilder();
      updateEntryTypeSettings = settings.updateEntryTypeSettings.toBuilder();
      updateEntryTypeOperationSettings = settings.updateEntryTypeOperationSettings.toBuilder();
      deleteEntryTypeSettings = settings.deleteEntryTypeSettings.toBuilder();
      deleteEntryTypeOperationSettings = settings.deleteEntryTypeOperationSettings.toBuilder();
      listEntryTypesSettings = settings.listEntryTypesSettings.toBuilder();
      getEntryTypeSettings = settings.getEntryTypeSettings.toBuilder();
      createAspectTypeSettings = settings.createAspectTypeSettings.toBuilder();
      createAspectTypeOperationSettings = settings.createAspectTypeOperationSettings.toBuilder();
      updateAspectTypeSettings = settings.updateAspectTypeSettings.toBuilder();
      updateAspectTypeOperationSettings = settings.updateAspectTypeOperationSettings.toBuilder();
      deleteAspectTypeSettings = settings.deleteAspectTypeSettings.toBuilder();
      deleteAspectTypeOperationSettings = settings.deleteAspectTypeOperationSettings.toBuilder();
      listAspectTypesSettings = settings.listAspectTypesSettings.toBuilder();
      getAspectTypeSettings = settings.getAspectTypeSettings.toBuilder();
      createEntryGroupSettings = settings.createEntryGroupSettings.toBuilder();
      createEntryGroupOperationSettings = settings.createEntryGroupOperationSettings.toBuilder();
      updateEntryGroupSettings = settings.updateEntryGroupSettings.toBuilder();
      updateEntryGroupOperationSettings = settings.updateEntryGroupOperationSettings.toBuilder();
      deleteEntryGroupSettings = settings.deleteEntryGroupSettings.toBuilder();
      deleteEntryGroupOperationSettings = settings.deleteEntryGroupOperationSettings.toBuilder();
      listEntryGroupsSettings = settings.listEntryGroupsSettings.toBuilder();
      getEntryGroupSettings = settings.getEntryGroupSettings.toBuilder();
      createEntrySettings = settings.createEntrySettings.toBuilder();
      updateEntrySettings = settings.updateEntrySettings.toBuilder();
      deleteEntrySettings = settings.deleteEntrySettings.toBuilder();
      listEntriesSettings = settings.listEntriesSettings.toBuilder();
      getEntrySettings = settings.getEntrySettings.toBuilder();
      lookupEntrySettings = settings.lookupEntrySettings.toBuilder();
      searchEntriesSettings = settings.searchEntriesSettings.toBuilder();
      createMetadataJobSettings = settings.createMetadataJobSettings.toBuilder();
      createMetadataJobOperationSettings = settings.createMetadataJobOperationSettings.toBuilder();
      getMetadataJobSettings = settings.getMetadataJobSettings.toBuilder();
      listMetadataJobsSettings = settings.listMetadataJobsSettings.toBuilder();
      cancelMetadataJobSettings = settings.cancelMetadataJobSettings.toBuilder();
      createEntryLinkSettings = settings.createEntryLinkSettings.toBuilder();
      updateEntryLinkSettings = settings.updateEntryLinkSettings.toBuilder();
      deleteEntryLinkSettings = settings.deleteEntryLinkSettings.toBuilder();
      lookupEntryLinksSettings = settings.lookupEntryLinksSettings.toBuilder();
      lookupContextSettings = settings.lookupContextSettings.toBuilder();
      getEntryLinkSettings = settings.getEntryLinkSettings.toBuilder();
      createMetadataFeedSettings = settings.createMetadataFeedSettings.toBuilder();
      createMetadataFeedOperationSettings =
          settings.createMetadataFeedOperationSettings.toBuilder();
      getMetadataFeedSettings = settings.getMetadataFeedSettings.toBuilder();
      listMetadataFeedsSettings = settings.listMetadataFeedsSettings.toBuilder();
      deleteMetadataFeedSettings = settings.deleteMetadataFeedSettings.toBuilder();
      deleteMetadataFeedOperationSettings =
          settings.deleteMetadataFeedOperationSettings.toBuilder();
      updateMetadataFeedSettings = settings.updateMetadataFeedSettings.toBuilder();
      updateMetadataFeedOperationSettings =
          settings.updateMetadataFeedOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEntryTypeSettings,
              updateEntryTypeSettings,
              deleteEntryTypeSettings,
              listEntryTypesSettings,
              getEntryTypeSettings,
              createAspectTypeSettings,
              updateAspectTypeSettings,
              deleteAspectTypeSettings,
              listAspectTypesSettings,
              getAspectTypeSettings,
              createEntryGroupSettings,
              updateEntryGroupSettings,
              deleteEntryGroupSettings,
              listEntryGroupsSettings,
              getEntryGroupSettings,
              createEntrySettings,
              updateEntrySettings,
              deleteEntrySettings,
              listEntriesSettings,
              getEntrySettings,
              lookupEntrySettings,
              searchEntriesSettings,
              createMetadataJobSettings,
              getMetadataJobSettings,
              listMetadataJobsSettings,
              cancelMetadataJobSettings,
              createEntryLinkSettings,
              updateEntryLinkSettings,
              deleteEntryLinkSettings,
              lookupEntryLinksSettings,
              lookupContextSettings,
              getEntryLinkSettings,
              createMetadataFeedSettings,
              getMetadataFeedSettings,
              listMetadataFeedsSettings,
              deleteMetadataFeedSettings,
              updateMetadataFeedSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createEntryTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .updateEntryTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .deleteEntryTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .listEntryTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

      builder
          .getEntryTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

      builder
          .createAspectTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .updateAspectTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .deleteAspectTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .listAspectTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

      builder
          .getAspectTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

      builder
          .createEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .updateEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .deleteEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"));

      builder
          .listEntryGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

      builder
          .getEntryGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

      builder
          .createEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .updateEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_10_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_10_params"));

      builder
          .deleteEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .listEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_9_params"));

      builder
          .getEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_9_params"));

      builder
          .lookupEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_9_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_9_params"));

      builder
          .searchEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_12_params"));

      builder
          .createMetadataJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMetadataJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMetadataJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cancelMetadataJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEntryLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateEntryLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteEntryLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .lookupEntryLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .lookupContextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getEntryLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMetadataFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMetadataFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMetadataFeedsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMetadataFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMetadataFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEntryTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEntryTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EntryType.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateEntryTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEntryTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EntryType.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteEntryTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEntryTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createAspectTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAspectTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AspectType.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateAspectTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAspectTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AspectType.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteAspectTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAspectTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createEntryGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEntryGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EntryGroup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateEntryGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEntryGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EntryGroup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteEntryGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEntryGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_13_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_13_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createMetadataJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMetadataJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MetadataJob.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createMetadataFeedOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMetadataFeedRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MetadataFeed.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteMetadataFeedOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMetadataFeedRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateMetadataFeedOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMetadataFeedRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MetadataFeed.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createEntryType. */
    public UnaryCallSettings.Builder<CreateEntryTypeRequest, Operation> createEntryTypeSettings() {
      return createEntryTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createEntryType. */
    public OperationCallSettings.Builder<CreateEntryTypeRequest, EntryType, OperationMetadata>
        createEntryTypeOperationSettings() {
      return createEntryTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntryType. */
    public UnaryCallSettings.Builder<UpdateEntryTypeRequest, Operation> updateEntryTypeSettings() {
      return updateEntryTypeSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntryType. */
    public OperationCallSettings.Builder<UpdateEntryTypeRequest, EntryType, OperationMetadata>
        updateEntryTypeOperationSettings() {
      return updateEntryTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntryType. */
    public UnaryCallSettings.Builder<DeleteEntryTypeRequest, Operation> deleteEntryTypeSettings() {
      return deleteEntryTypeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntryType. */
    public OperationCallSettings.Builder<DeleteEntryTypeRequest, Empty, OperationMetadata>
        deleteEntryTypeOperationSettings() {
      return deleteEntryTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEntryTypes. */
    public PagedCallSettings.Builder<
            ListEntryTypesRequest, ListEntryTypesResponse, ListEntryTypesPagedResponse>
        listEntryTypesSettings() {
      return listEntryTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getEntryType. */
    public UnaryCallSettings.Builder<GetEntryTypeRequest, EntryType> getEntryTypeSettings() {
      return getEntryTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createAspectType. */
    public UnaryCallSettings.Builder<CreateAspectTypeRequest, Operation>
        createAspectTypeSettings() {
      return createAspectTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createAspectType. */
    public OperationCallSettings.Builder<CreateAspectTypeRequest, AspectType, OperationMetadata>
        createAspectTypeOperationSettings() {
      return createAspectTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAspectType. */
    public UnaryCallSettings.Builder<UpdateAspectTypeRequest, Operation>
        updateAspectTypeSettings() {
      return updateAspectTypeSettings;
    }

    /** Returns the builder for the settings used for calls to updateAspectType. */
    public OperationCallSettings.Builder<UpdateAspectTypeRequest, AspectType, OperationMetadata>
        updateAspectTypeOperationSettings() {
      return updateAspectTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAspectType. */
    public UnaryCallSettings.Builder<DeleteAspectTypeRequest, Operation>
        deleteAspectTypeSettings() {
      return deleteAspectTypeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAspectType. */
    public OperationCallSettings.Builder<DeleteAspectTypeRequest, Empty, OperationMetadata>
        deleteAspectTypeOperationSettings() {
      return deleteAspectTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAspectTypes. */
    public PagedCallSettings.Builder<
            ListAspectTypesRequest, ListAspectTypesResponse, ListAspectTypesPagedResponse>
        listAspectTypesSettings() {
      return listAspectTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getAspectType. */
    public UnaryCallSettings.Builder<GetAspectTypeRequest, AspectType> getAspectTypeSettings() {
      return getAspectTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createEntryGroup. */
    public UnaryCallSettings.Builder<CreateEntryGroupRequest, Operation>
        createEntryGroupSettings() {
      return createEntryGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createEntryGroup. */
    public OperationCallSettings.Builder<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
        createEntryGroupOperationSettings() {
      return createEntryGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntryGroup. */
    public UnaryCallSettings.Builder<UpdateEntryGroupRequest, Operation>
        updateEntryGroupSettings() {
      return updateEntryGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntryGroup. */
    public OperationCallSettings.Builder<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
        updateEntryGroupOperationSettings() {
      return updateEntryGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntryGroup. */
    public UnaryCallSettings.Builder<DeleteEntryGroupRequest, Operation>
        deleteEntryGroupSettings() {
      return deleteEntryGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntryGroup. */
    public OperationCallSettings.Builder<DeleteEntryGroupRequest, Empty, OperationMetadata>
        deleteEntryGroupOperationSettings() {
      return deleteEntryGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEntryGroups. */
    public PagedCallSettings.Builder<
            ListEntryGroupsRequest, ListEntryGroupsResponse, ListEntryGroupsPagedResponse>
        listEntryGroupsSettings() {
      return listEntryGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getEntryGroup. */
    public UnaryCallSettings.Builder<GetEntryGroupRequest, EntryGroup> getEntryGroupSettings() {
      return getEntryGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createEntry. */
    public UnaryCallSettings.Builder<CreateEntryRequest, Entry> createEntrySettings() {
      return createEntrySettings;
    }

    /** Returns the builder for the settings used for calls to updateEntry. */
    public UnaryCallSettings.Builder<UpdateEntryRequest, Entry> updateEntrySettings() {
      return updateEntrySettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntry. */
    public UnaryCallSettings.Builder<DeleteEntryRequest, Entry> deleteEntrySettings() {
      return deleteEntrySettings;
    }

    /** Returns the builder for the settings used for calls to listEntries. */
    public PagedCallSettings.Builder<
            ListEntriesRequest, ListEntriesResponse, ListEntriesPagedResponse>
        listEntriesSettings() {
      return listEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to getEntry. */
    public UnaryCallSettings.Builder<GetEntryRequest, Entry> getEntrySettings() {
      return getEntrySettings;
    }

    /** Returns the builder for the settings used for calls to lookupEntry. */
    public UnaryCallSettings.Builder<LookupEntryRequest, Entry> lookupEntrySettings() {
      return lookupEntrySettings;
    }

    /** Returns the builder for the settings used for calls to searchEntries. */
    public PagedCallSettings.Builder<
            SearchEntriesRequest, SearchEntriesResponse, SearchEntriesPagedResponse>
        searchEntriesSettings() {
      return searchEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to createMetadataJob. */
    public UnaryCallSettings.Builder<CreateMetadataJobRequest, Operation>
        createMetadataJobSettings() {
      return createMetadataJobSettings;
    }

    /** Returns the builder for the settings used for calls to createMetadataJob. */
    public OperationCallSettings.Builder<CreateMetadataJobRequest, MetadataJob, OperationMetadata>
        createMetadataJobOperationSettings() {
      return createMetadataJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getMetadataJob. */
    public UnaryCallSettings.Builder<GetMetadataJobRequest, MetadataJob> getMetadataJobSettings() {
      return getMetadataJobSettings;
    }

    /** Returns the builder for the settings used for calls to listMetadataJobs. */
    public PagedCallSettings.Builder<
            ListMetadataJobsRequest, ListMetadataJobsResponse, ListMetadataJobsPagedResponse>
        listMetadataJobsSettings() {
      return listMetadataJobsSettings;
    }

    /** Returns the builder for the settings used for calls to cancelMetadataJob. */
    public UnaryCallSettings.Builder<CancelMetadataJobRequest, Empty> cancelMetadataJobSettings() {
      return cancelMetadataJobSettings;
    }

    /** Returns the builder for the settings used for calls to createEntryLink. */
    public UnaryCallSettings.Builder<CreateEntryLinkRequest, EntryLink> createEntryLinkSettings() {
      return createEntryLinkSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntryLink. */
    public UnaryCallSettings.Builder<UpdateEntryLinkRequest, EntryLink> updateEntryLinkSettings() {
      return updateEntryLinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntryLink. */
    public UnaryCallSettings.Builder<DeleteEntryLinkRequest, EntryLink> deleteEntryLinkSettings() {
      return deleteEntryLinkSettings;
    }

    /** Returns the builder for the settings used for calls to lookupEntryLinks. */
    public PagedCallSettings.Builder<
            LookupEntryLinksRequest, LookupEntryLinksResponse, LookupEntryLinksPagedResponse>
        lookupEntryLinksSettings() {
      return lookupEntryLinksSettings;
    }

    /** Returns the builder for the settings used for calls to lookupContext. */
    public UnaryCallSettings.Builder<LookupContextRequest, LookupContextResponse>
        lookupContextSettings() {
      return lookupContextSettings;
    }

    /** Returns the builder for the settings used for calls to getEntryLink. */
    public UnaryCallSettings.Builder<GetEntryLinkRequest, EntryLink> getEntryLinkSettings() {
      return getEntryLinkSettings;
    }

    /** Returns the builder for the settings used for calls to createMetadataFeed. */
    public UnaryCallSettings.Builder<CreateMetadataFeedRequest, Operation>
        createMetadataFeedSettings() {
      return createMetadataFeedSettings;
    }

    /** Returns the builder for the settings used for calls to createMetadataFeed. */
    public OperationCallSettings.Builder<CreateMetadataFeedRequest, MetadataFeed, OperationMetadata>
        createMetadataFeedOperationSettings() {
      return createMetadataFeedOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getMetadataFeed. */
    public UnaryCallSettings.Builder<GetMetadataFeedRequest, MetadataFeed>
        getMetadataFeedSettings() {
      return getMetadataFeedSettings;
    }

    /** Returns the builder for the settings used for calls to listMetadataFeeds. */
    public PagedCallSettings.Builder<
            ListMetadataFeedsRequest, ListMetadataFeedsResponse, ListMetadataFeedsPagedResponse>
        listMetadataFeedsSettings() {
      return listMetadataFeedsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMetadataFeed. */
    public UnaryCallSettings.Builder<DeleteMetadataFeedRequest, Operation>
        deleteMetadataFeedSettings() {
      return deleteMetadataFeedSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMetadataFeed. */
    public OperationCallSettings.Builder<DeleteMetadataFeedRequest, Empty, OperationMetadata>
        deleteMetadataFeedOperationSettings() {
      return deleteMetadataFeedOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMetadataFeed. */
    public UnaryCallSettings.Builder<UpdateMetadataFeedRequest, Operation>
        updateMetadataFeedSettings() {
      return updateMetadataFeedSettings;
    }

    /** Returns the builder for the settings used for calls to updateMetadataFeed. */
    public OperationCallSettings.Builder<UpdateMetadataFeedRequest, MetadataFeed, OperationMetadata>
        updateMetadataFeedOperationSettings() {
      return updateMetadataFeedOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public CatalogServiceStubSettings build() throws IOException {
      return new CatalogServiceStubSettings(this);
    }
  }
}

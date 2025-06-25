/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.configdelivery.v1beta.stub;

import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListFleetPackagesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListLocationsPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListReleasesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListResourceBundlesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListRolloutsPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListVariantsPagedResponse;

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
import com.google.cloud.configdelivery.v1beta.AbortRolloutRequest;
import com.google.cloud.configdelivery.v1beta.CreateFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.CreateReleaseRequest;
import com.google.cloud.configdelivery.v1beta.CreateResourceBundleRequest;
import com.google.cloud.configdelivery.v1beta.CreateVariantRequest;
import com.google.cloud.configdelivery.v1beta.DeleteFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.DeleteReleaseRequest;
import com.google.cloud.configdelivery.v1beta.DeleteResourceBundleRequest;
import com.google.cloud.configdelivery.v1beta.DeleteVariantRequest;
import com.google.cloud.configdelivery.v1beta.FleetPackage;
import com.google.cloud.configdelivery.v1beta.GetFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.GetReleaseRequest;
import com.google.cloud.configdelivery.v1beta.GetResourceBundleRequest;
import com.google.cloud.configdelivery.v1beta.GetRolloutRequest;
import com.google.cloud.configdelivery.v1beta.GetVariantRequest;
import com.google.cloud.configdelivery.v1beta.ListFleetPackagesRequest;
import com.google.cloud.configdelivery.v1beta.ListFleetPackagesResponse;
import com.google.cloud.configdelivery.v1beta.ListReleasesRequest;
import com.google.cloud.configdelivery.v1beta.ListReleasesResponse;
import com.google.cloud.configdelivery.v1beta.ListResourceBundlesRequest;
import com.google.cloud.configdelivery.v1beta.ListResourceBundlesResponse;
import com.google.cloud.configdelivery.v1beta.ListRolloutsRequest;
import com.google.cloud.configdelivery.v1beta.ListRolloutsResponse;
import com.google.cloud.configdelivery.v1beta.ListVariantsRequest;
import com.google.cloud.configdelivery.v1beta.ListVariantsResponse;
import com.google.cloud.configdelivery.v1beta.OperationMetadata;
import com.google.cloud.configdelivery.v1beta.Release;
import com.google.cloud.configdelivery.v1beta.ResourceBundle;
import com.google.cloud.configdelivery.v1beta.ResumeRolloutRequest;
import com.google.cloud.configdelivery.v1beta.Rollout;
import com.google.cloud.configdelivery.v1beta.SuspendRolloutRequest;
import com.google.cloud.configdelivery.v1beta.UpdateFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.UpdateReleaseRequest;
import com.google.cloud.configdelivery.v1beta.UpdateResourceBundleRequest;
import com.google.cloud.configdelivery.v1beta.UpdateVariantRequest;
import com.google.cloud.configdelivery.v1beta.Variant;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConfigDeliveryStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (configdelivery.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getResourceBundle:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigDeliveryStubSettings.Builder configDeliverySettingsBuilder =
 *     ConfigDeliveryStubSettings.newBuilder();
 * configDeliverySettingsBuilder
 *     .getResourceBundleSettings()
 *     .setRetrySettings(
 *         configDeliverySettingsBuilder
 *             .getResourceBundleSettings()
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
 * ConfigDeliveryStubSettings configDeliverySettings = configDeliverySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createResourceBundle:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigDeliveryStubSettings.Builder configDeliverySettingsBuilder =
 *     ConfigDeliveryStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * configDeliverySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConfigDeliveryStubSettings extends StubSettings<ConfigDeliveryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListResourceBundlesRequest, ListResourceBundlesResponse, ListResourceBundlesPagedResponse>
      listResourceBundlesSettings;
  private final UnaryCallSettings<GetResourceBundleRequest, ResourceBundle>
      getResourceBundleSettings;
  private final UnaryCallSettings<CreateResourceBundleRequest, Operation>
      createResourceBundleSettings;
  private final OperationCallSettings<
          CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationSettings;
  private final UnaryCallSettings<UpdateResourceBundleRequest, Operation>
      updateResourceBundleSettings;
  private final OperationCallSettings<
          UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationSettings;
  private final UnaryCallSettings<DeleteResourceBundleRequest, Operation>
      deleteResourceBundleSettings;
  private final OperationCallSettings<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationSettings;
  private final PagedCallSettings<
          ListFleetPackagesRequest, ListFleetPackagesResponse, ListFleetPackagesPagedResponse>
      listFleetPackagesSettings;
  private final UnaryCallSettings<GetFleetPackageRequest, FleetPackage> getFleetPackageSettings;
  private final UnaryCallSettings<CreateFleetPackageRequest, Operation> createFleetPackageSettings;
  private final OperationCallSettings<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationSettings;
  private final UnaryCallSettings<UpdateFleetPackageRequest, Operation> updateFleetPackageSettings;
  private final OperationCallSettings<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationSettings;
  private final UnaryCallSettings<DeleteFleetPackageRequest, Operation> deleteFleetPackageSettings;
  private final OperationCallSettings<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationSettings;
  private final PagedCallSettings<
          ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings;
  private final UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings;
  private final UnaryCallSettings<CreateReleaseRequest, Operation> createReleaseSettings;
  private final OperationCallSettings<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationSettings;
  private final UnaryCallSettings<UpdateReleaseRequest, Operation> updateReleaseSettings;
  private final OperationCallSettings<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationSettings;
  private final UnaryCallSettings<DeleteReleaseRequest, Operation> deleteReleaseSettings;
  private final OperationCallSettings<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationSettings;
  private final PagedCallSettings<
          ListVariantsRequest, ListVariantsResponse, ListVariantsPagedResponse>
      listVariantsSettings;
  private final UnaryCallSettings<GetVariantRequest, Variant> getVariantSettings;
  private final UnaryCallSettings<CreateVariantRequest, Operation> createVariantSettings;
  private final OperationCallSettings<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationSettings;
  private final UnaryCallSettings<UpdateVariantRequest, Operation> updateVariantSettings;
  private final OperationCallSettings<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationSettings;
  private final UnaryCallSettings<DeleteVariantRequest, Operation> deleteVariantSettings;
  private final OperationCallSettings<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationSettings;
  private final PagedCallSettings<
          ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings;
  private final UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings;
  private final UnaryCallSettings<SuspendRolloutRequest, Operation> suspendRolloutSettings;
  private final OperationCallSettings<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationSettings;
  private final UnaryCallSettings<ResumeRolloutRequest, Operation> resumeRolloutSettings;
  private final OperationCallSettings<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationSettings;
  private final UnaryCallSettings<AbortRolloutRequest, Operation> abortRolloutSettings;
  private final OperationCallSettings<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListResourceBundlesRequest, ListResourceBundlesResponse, ResourceBundle>
      LIST_RESOURCE_BUNDLES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListResourceBundlesRequest, ListResourceBundlesResponse, ResourceBundle>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListResourceBundlesRequest injectToken(
                ListResourceBundlesRequest payload, String token) {
              return ListResourceBundlesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListResourceBundlesRequest injectPageSize(
                ListResourceBundlesRequest payload, int pageSize) {
              return ListResourceBundlesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListResourceBundlesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListResourceBundlesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ResourceBundle> extractResources(ListResourceBundlesResponse payload) {
              return payload.getResourceBundlesList();
            }
          };

  private static final PagedListDescriptor<
          ListFleetPackagesRequest, ListFleetPackagesResponse, FleetPackage>
      LIST_FLEET_PACKAGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFleetPackagesRequest, ListFleetPackagesResponse, FleetPackage>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFleetPackagesRequest injectToken(
                ListFleetPackagesRequest payload, String token) {
              return ListFleetPackagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFleetPackagesRequest injectPageSize(
                ListFleetPackagesRequest payload, int pageSize) {
              return ListFleetPackagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFleetPackagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFleetPackagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FleetPackage> extractResources(ListFleetPackagesResponse payload) {
              return payload.getFleetPackagesList();
            }
          };

  private static final PagedListDescriptor<ListReleasesRequest, ListReleasesResponse, Release>
      LIST_RELEASES_PAGE_STR_DESC =
          new PagedListDescriptor<ListReleasesRequest, ListReleasesResponse, Release>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReleasesRequest injectToken(ListReleasesRequest payload, String token) {
              return ListReleasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReleasesRequest injectPageSize(ListReleasesRequest payload, int pageSize) {
              return ListReleasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReleasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReleasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Release> extractResources(ListReleasesResponse payload) {
              return payload.getReleasesList();
            }
          };

  private static final PagedListDescriptor<ListVariantsRequest, ListVariantsResponse, Variant>
      LIST_VARIANTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListVariantsRequest, ListVariantsResponse, Variant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVariantsRequest injectToken(ListVariantsRequest payload, String token) {
              return ListVariantsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVariantsRequest injectPageSize(ListVariantsRequest payload, int pageSize) {
              return ListVariantsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVariantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVariantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Variant> extractResources(ListVariantsResponse payload) {
              return payload.getVariantsList();
            }
          };

  private static final PagedListDescriptor<ListRolloutsRequest, ListRolloutsResponse, Rollout>
      LIST_ROLLOUTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRolloutsRequest, ListRolloutsResponse, Rollout>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRolloutsRequest injectToken(ListRolloutsRequest payload, String token) {
              return ListRolloutsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRolloutsRequest injectPageSize(ListRolloutsRequest payload, int pageSize) {
              return ListRolloutsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRolloutsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRolloutsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Rollout> extractResources(ListRolloutsResponse payload) {
              return payload.getRolloutsList();
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
          ListResourceBundlesRequest, ListResourceBundlesResponse, ListResourceBundlesPagedResponse>
      LIST_RESOURCE_BUNDLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListResourceBundlesRequest,
              ListResourceBundlesResponse,
              ListResourceBundlesPagedResponse>() {
            @Override
            public ApiFuture<ListResourceBundlesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesResponse> callable,
                ListResourceBundlesRequest request,
                ApiCallContext context,
                ApiFuture<ListResourceBundlesResponse> futureResponse) {
              PageContext<ListResourceBundlesRequest, ListResourceBundlesResponse, ResourceBundle>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RESOURCE_BUNDLES_PAGE_STR_DESC, request, context);
              return ListResourceBundlesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFleetPackagesRequest, ListFleetPackagesResponse, ListFleetPackagesPagedResponse>
      LIST_FLEET_PACKAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFleetPackagesRequest,
              ListFleetPackagesResponse,
              ListFleetPackagesPagedResponse>() {
            @Override
            public ApiFuture<ListFleetPackagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesResponse> callable,
                ListFleetPackagesRequest request,
                ApiCallContext context,
                ApiFuture<ListFleetPackagesResponse> futureResponse) {
              PageContext<ListFleetPackagesRequest, ListFleetPackagesResponse, FleetPackage>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FLEET_PACKAGES_PAGE_STR_DESC, request, context);
              return ListFleetPackagesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      LIST_RELEASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>() {
            @Override
            public ApiFuture<ListReleasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReleasesRequest, ListReleasesResponse> callable,
                ListReleasesRequest request,
                ApiCallContext context,
                ApiFuture<ListReleasesResponse> futureResponse) {
              PageContext<ListReleasesRequest, ListReleasesResponse, Release> pageContext =
                  PageContext.create(callable, LIST_RELEASES_PAGE_STR_DESC, request, context);
              return ListReleasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVariantsRequest, ListVariantsResponse, ListVariantsPagedResponse>
      LIST_VARIANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVariantsRequest, ListVariantsResponse, ListVariantsPagedResponse>() {
            @Override
            public ApiFuture<ListVariantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVariantsRequest, ListVariantsResponse> callable,
                ListVariantsRequest request,
                ApiCallContext context,
                ApiFuture<ListVariantsResponse> futureResponse) {
              PageContext<ListVariantsRequest, ListVariantsResponse, Variant> pageContext =
                  PageContext.create(callable, LIST_VARIANTS_PAGE_STR_DESC, request, context);
              return ListVariantsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      LIST_ROLLOUTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>() {
            @Override
            public ApiFuture<ListRolloutsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> callable,
                ListRolloutsRequest request,
                ApiCallContext context,
                ApiFuture<ListRolloutsResponse> futureResponse) {
              PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> pageContext =
                  PageContext.create(callable, LIST_ROLLOUTS_PAGE_STR_DESC, request, context);
              return ListRolloutsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listResourceBundles. */
  public PagedCallSettings<
          ListResourceBundlesRequest, ListResourceBundlesResponse, ListResourceBundlesPagedResponse>
      listResourceBundlesSettings() {
    return listResourceBundlesSettings;
  }

  /** Returns the object with the settings used for calls to getResourceBundle. */
  public UnaryCallSettings<GetResourceBundleRequest, ResourceBundle> getResourceBundleSettings() {
    return getResourceBundleSettings;
  }

  /** Returns the object with the settings used for calls to createResourceBundle. */
  public UnaryCallSettings<CreateResourceBundleRequest, Operation> createResourceBundleSettings() {
    return createResourceBundleSettings;
  }

  /** Returns the object with the settings used for calls to createResourceBundle. */
  public OperationCallSettings<CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationSettings() {
    return createResourceBundleOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateResourceBundle. */
  public UnaryCallSettings<UpdateResourceBundleRequest, Operation> updateResourceBundleSettings() {
    return updateResourceBundleSettings;
  }

  /** Returns the object with the settings used for calls to updateResourceBundle. */
  public OperationCallSettings<UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationSettings() {
    return updateResourceBundleOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteResourceBundle. */
  public UnaryCallSettings<DeleteResourceBundleRequest, Operation> deleteResourceBundleSettings() {
    return deleteResourceBundleSettings;
  }

  /** Returns the object with the settings used for calls to deleteResourceBundle. */
  public OperationCallSettings<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationSettings() {
    return deleteResourceBundleOperationSettings;
  }

  /** Returns the object with the settings used for calls to listFleetPackages. */
  public PagedCallSettings<
          ListFleetPackagesRequest, ListFleetPackagesResponse, ListFleetPackagesPagedResponse>
      listFleetPackagesSettings() {
    return listFleetPackagesSettings;
  }

  /** Returns the object with the settings used for calls to getFleetPackage. */
  public UnaryCallSettings<GetFleetPackageRequest, FleetPackage> getFleetPackageSettings() {
    return getFleetPackageSettings;
  }

  /** Returns the object with the settings used for calls to createFleetPackage. */
  public UnaryCallSettings<CreateFleetPackageRequest, Operation> createFleetPackageSettings() {
    return createFleetPackageSettings;
  }

  /** Returns the object with the settings used for calls to createFleetPackage. */
  public OperationCallSettings<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationSettings() {
    return createFleetPackageOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFleetPackage. */
  public UnaryCallSettings<UpdateFleetPackageRequest, Operation> updateFleetPackageSettings() {
    return updateFleetPackageSettings;
  }

  /** Returns the object with the settings used for calls to updateFleetPackage. */
  public OperationCallSettings<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationSettings() {
    return updateFleetPackageOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFleetPackage. */
  public UnaryCallSettings<DeleteFleetPackageRequest, Operation> deleteFleetPackageSettings() {
    return deleteFleetPackageSettings;
  }

  /** Returns the object with the settings used for calls to deleteFleetPackage. */
  public OperationCallSettings<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationSettings() {
    return deleteFleetPackageOperationSettings;
  }

  /** Returns the object with the settings used for calls to listReleases. */
  public PagedCallSettings<ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings() {
    return listReleasesSettings;
  }

  /** Returns the object with the settings used for calls to getRelease. */
  public UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings() {
    return getReleaseSettings;
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public UnaryCallSettings<CreateReleaseRequest, Operation> createReleaseSettings() {
    return createReleaseSettings;
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public OperationCallSettings<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationSettings() {
    return createReleaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateRelease. */
  public UnaryCallSettings<UpdateReleaseRequest, Operation> updateReleaseSettings() {
    return updateReleaseSettings;
  }

  /** Returns the object with the settings used for calls to updateRelease. */
  public OperationCallSettings<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationSettings() {
    return updateReleaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRelease. */
  public UnaryCallSettings<DeleteReleaseRequest, Operation> deleteReleaseSettings() {
    return deleteReleaseSettings;
  }

  /** Returns the object with the settings used for calls to deleteRelease. */
  public OperationCallSettings<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationSettings() {
    return deleteReleaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to listVariants. */
  public PagedCallSettings<ListVariantsRequest, ListVariantsResponse, ListVariantsPagedResponse>
      listVariantsSettings() {
    return listVariantsSettings;
  }

  /** Returns the object with the settings used for calls to getVariant. */
  public UnaryCallSettings<GetVariantRequest, Variant> getVariantSettings() {
    return getVariantSettings;
  }

  /** Returns the object with the settings used for calls to createVariant. */
  public UnaryCallSettings<CreateVariantRequest, Operation> createVariantSettings() {
    return createVariantSettings;
  }

  /** Returns the object with the settings used for calls to createVariant. */
  public OperationCallSettings<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationSettings() {
    return createVariantOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateVariant. */
  public UnaryCallSettings<UpdateVariantRequest, Operation> updateVariantSettings() {
    return updateVariantSettings;
  }

  /** Returns the object with the settings used for calls to updateVariant. */
  public OperationCallSettings<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationSettings() {
    return updateVariantOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteVariant. */
  public UnaryCallSettings<DeleteVariantRequest, Operation> deleteVariantSettings() {
    return deleteVariantSettings;
  }

  /** Returns the object with the settings used for calls to deleteVariant. */
  public OperationCallSettings<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationSettings() {
    return deleteVariantOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRollouts. */
  public PagedCallSettings<ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings() {
    return listRolloutsSettings;
  }

  /** Returns the object with the settings used for calls to getRollout. */
  public UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings() {
    return getRolloutSettings;
  }

  /** Returns the object with the settings used for calls to suspendRollout. */
  public UnaryCallSettings<SuspendRolloutRequest, Operation> suspendRolloutSettings() {
    return suspendRolloutSettings;
  }

  /** Returns the object with the settings used for calls to suspendRollout. */
  public OperationCallSettings<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationSettings() {
    return suspendRolloutOperationSettings;
  }

  /** Returns the object with the settings used for calls to resumeRollout. */
  public UnaryCallSettings<ResumeRolloutRequest, Operation> resumeRolloutSettings() {
    return resumeRolloutSettings;
  }

  /** Returns the object with the settings used for calls to resumeRollout. */
  public OperationCallSettings<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationSettings() {
    return resumeRolloutOperationSettings;
  }

  /** Returns the object with the settings used for calls to abortRollout. */
  public UnaryCallSettings<AbortRolloutRequest, Operation> abortRolloutSettings() {
    return abortRolloutSettings;
  }

  /** Returns the object with the settings used for calls to abortRollout. */
  public OperationCallSettings<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationSettings() {
    return abortRolloutOperationSettings;
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

  public ConfigDeliveryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConfigDeliveryStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonConfigDeliveryStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "configdelivery";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "configdelivery.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "configdelivery.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ConfigDeliveryStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConfigDeliveryStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConfigDeliveryStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ConfigDeliveryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listResourceBundlesSettings = settingsBuilder.listResourceBundlesSettings().build();
    getResourceBundleSettings = settingsBuilder.getResourceBundleSettings().build();
    createResourceBundleSettings = settingsBuilder.createResourceBundleSettings().build();
    createResourceBundleOperationSettings =
        settingsBuilder.createResourceBundleOperationSettings().build();
    updateResourceBundleSettings = settingsBuilder.updateResourceBundleSettings().build();
    updateResourceBundleOperationSettings =
        settingsBuilder.updateResourceBundleOperationSettings().build();
    deleteResourceBundleSettings = settingsBuilder.deleteResourceBundleSettings().build();
    deleteResourceBundleOperationSettings =
        settingsBuilder.deleteResourceBundleOperationSettings().build();
    listFleetPackagesSettings = settingsBuilder.listFleetPackagesSettings().build();
    getFleetPackageSettings = settingsBuilder.getFleetPackageSettings().build();
    createFleetPackageSettings = settingsBuilder.createFleetPackageSettings().build();
    createFleetPackageOperationSettings =
        settingsBuilder.createFleetPackageOperationSettings().build();
    updateFleetPackageSettings = settingsBuilder.updateFleetPackageSettings().build();
    updateFleetPackageOperationSettings =
        settingsBuilder.updateFleetPackageOperationSettings().build();
    deleteFleetPackageSettings = settingsBuilder.deleteFleetPackageSettings().build();
    deleteFleetPackageOperationSettings =
        settingsBuilder.deleteFleetPackageOperationSettings().build();
    listReleasesSettings = settingsBuilder.listReleasesSettings().build();
    getReleaseSettings = settingsBuilder.getReleaseSettings().build();
    createReleaseSettings = settingsBuilder.createReleaseSettings().build();
    createReleaseOperationSettings = settingsBuilder.createReleaseOperationSettings().build();
    updateReleaseSettings = settingsBuilder.updateReleaseSettings().build();
    updateReleaseOperationSettings = settingsBuilder.updateReleaseOperationSettings().build();
    deleteReleaseSettings = settingsBuilder.deleteReleaseSettings().build();
    deleteReleaseOperationSettings = settingsBuilder.deleteReleaseOperationSettings().build();
    listVariantsSettings = settingsBuilder.listVariantsSettings().build();
    getVariantSettings = settingsBuilder.getVariantSettings().build();
    createVariantSettings = settingsBuilder.createVariantSettings().build();
    createVariantOperationSettings = settingsBuilder.createVariantOperationSettings().build();
    updateVariantSettings = settingsBuilder.updateVariantSettings().build();
    updateVariantOperationSettings = settingsBuilder.updateVariantOperationSettings().build();
    deleteVariantSettings = settingsBuilder.deleteVariantSettings().build();
    deleteVariantOperationSettings = settingsBuilder.deleteVariantOperationSettings().build();
    listRolloutsSettings = settingsBuilder.listRolloutsSettings().build();
    getRolloutSettings = settingsBuilder.getRolloutSettings().build();
    suspendRolloutSettings = settingsBuilder.suspendRolloutSettings().build();
    suspendRolloutOperationSettings = settingsBuilder.suspendRolloutOperationSettings().build();
    resumeRolloutSettings = settingsBuilder.resumeRolloutSettings().build();
    resumeRolloutOperationSettings = settingsBuilder.resumeRolloutOperationSettings().build();
    abortRolloutSettings = settingsBuilder.abortRolloutSettings().build();
    abortRolloutOperationSettings = settingsBuilder.abortRolloutOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ConfigDeliveryStubSettings. */
  public static class Builder extends StubSettings.Builder<ConfigDeliveryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListResourceBundlesRequest,
            ListResourceBundlesResponse,
            ListResourceBundlesPagedResponse>
        listResourceBundlesSettings;
    private final UnaryCallSettings.Builder<GetResourceBundleRequest, ResourceBundle>
        getResourceBundleSettings;
    private final UnaryCallSettings.Builder<CreateResourceBundleRequest, Operation>
        createResourceBundleSettings;
    private final OperationCallSettings.Builder<
            CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
        createResourceBundleOperationSettings;
    private final UnaryCallSettings.Builder<UpdateResourceBundleRequest, Operation>
        updateResourceBundleSettings;
    private final OperationCallSettings.Builder<
            UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
        updateResourceBundleOperationSettings;
    private final UnaryCallSettings.Builder<DeleteResourceBundleRequest, Operation>
        deleteResourceBundleSettings;
    private final OperationCallSettings.Builder<
            DeleteResourceBundleRequest, Empty, OperationMetadata>
        deleteResourceBundleOperationSettings;
    private final PagedCallSettings.Builder<
            ListFleetPackagesRequest, ListFleetPackagesResponse, ListFleetPackagesPagedResponse>
        listFleetPackagesSettings;
    private final UnaryCallSettings.Builder<GetFleetPackageRequest, FleetPackage>
        getFleetPackageSettings;
    private final UnaryCallSettings.Builder<CreateFleetPackageRequest, Operation>
        createFleetPackageSettings;
    private final OperationCallSettings.Builder<
            CreateFleetPackageRequest, FleetPackage, OperationMetadata>
        createFleetPackageOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFleetPackageRequest, Operation>
        updateFleetPackageSettings;
    private final OperationCallSettings.Builder<
            UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
        updateFleetPackageOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFleetPackageRequest, Operation>
        deleteFleetPackageSettings;
    private final OperationCallSettings.Builder<DeleteFleetPackageRequest, Empty, OperationMetadata>
        deleteFleetPackageOperationSettings;
    private final PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings;
    private final UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings;
    private final UnaryCallSettings.Builder<CreateReleaseRequest, Operation> createReleaseSettings;
    private final OperationCallSettings.Builder<CreateReleaseRequest, Release, OperationMetadata>
        createReleaseOperationSettings;
    private final UnaryCallSettings.Builder<UpdateReleaseRequest, Operation> updateReleaseSettings;
    private final OperationCallSettings.Builder<UpdateReleaseRequest, Release, OperationMetadata>
        updateReleaseOperationSettings;
    private final UnaryCallSettings.Builder<DeleteReleaseRequest, Operation> deleteReleaseSettings;
    private final OperationCallSettings.Builder<DeleteReleaseRequest, Empty, OperationMetadata>
        deleteReleaseOperationSettings;
    private final PagedCallSettings.Builder<
            ListVariantsRequest, ListVariantsResponse, ListVariantsPagedResponse>
        listVariantsSettings;
    private final UnaryCallSettings.Builder<GetVariantRequest, Variant> getVariantSettings;
    private final UnaryCallSettings.Builder<CreateVariantRequest, Operation> createVariantSettings;
    private final OperationCallSettings.Builder<CreateVariantRequest, Variant, OperationMetadata>
        createVariantOperationSettings;
    private final UnaryCallSettings.Builder<UpdateVariantRequest, Operation> updateVariantSettings;
    private final OperationCallSettings.Builder<UpdateVariantRequest, Variant, OperationMetadata>
        updateVariantOperationSettings;
    private final UnaryCallSettings.Builder<DeleteVariantRequest, Operation> deleteVariantSettings;
    private final OperationCallSettings.Builder<DeleteVariantRequest, Empty, OperationMetadata>
        deleteVariantOperationSettings;
    private final PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings;
    private final UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings;
    private final UnaryCallSettings.Builder<SuspendRolloutRequest, Operation>
        suspendRolloutSettings;
    private final OperationCallSettings.Builder<SuspendRolloutRequest, Rollout, OperationMetadata>
        suspendRolloutOperationSettings;
    private final UnaryCallSettings.Builder<ResumeRolloutRequest, Operation> resumeRolloutSettings;
    private final OperationCallSettings.Builder<ResumeRolloutRequest, Rollout, OperationMetadata>
        resumeRolloutOperationSettings;
    private final UnaryCallSettings.Builder<AbortRolloutRequest, Operation> abortRolloutSettings;
    private final OperationCallSettings.Builder<AbortRolloutRequest, Rollout, OperationMetadata>
        abortRolloutOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
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
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listResourceBundlesSettings =
          PagedCallSettings.newBuilder(LIST_RESOURCE_BUNDLES_PAGE_STR_FACT);
      getResourceBundleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createResourceBundleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createResourceBundleOperationSettings = OperationCallSettings.newBuilder();
      updateResourceBundleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateResourceBundleOperationSettings = OperationCallSettings.newBuilder();
      deleteResourceBundleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteResourceBundleOperationSettings = OperationCallSettings.newBuilder();
      listFleetPackagesSettings = PagedCallSettings.newBuilder(LIST_FLEET_PACKAGES_PAGE_STR_FACT);
      getFleetPackageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFleetPackageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFleetPackageOperationSettings = OperationCallSettings.newBuilder();
      updateFleetPackageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFleetPackageOperationSettings = OperationCallSettings.newBuilder();
      deleteFleetPackageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFleetPackageOperationSettings = OperationCallSettings.newBuilder();
      listReleasesSettings = PagedCallSettings.newBuilder(LIST_RELEASES_PAGE_STR_FACT);
      getReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReleaseOperationSettings = OperationCallSettings.newBuilder();
      updateReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateReleaseOperationSettings = OperationCallSettings.newBuilder();
      deleteReleaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReleaseOperationSettings = OperationCallSettings.newBuilder();
      listVariantsSettings = PagedCallSettings.newBuilder(LIST_VARIANTS_PAGE_STR_FACT);
      getVariantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVariantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVariantOperationSettings = OperationCallSettings.newBuilder();
      updateVariantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVariantOperationSettings = OperationCallSettings.newBuilder();
      deleteVariantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVariantOperationSettings = OperationCallSettings.newBuilder();
      listRolloutsSettings = PagedCallSettings.newBuilder(LIST_ROLLOUTS_PAGE_STR_FACT);
      getRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suspendRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suspendRolloutOperationSettings = OperationCallSettings.newBuilder();
      resumeRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeRolloutOperationSettings = OperationCallSettings.newBuilder();
      abortRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      abortRolloutOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listResourceBundlesSettings,
              getResourceBundleSettings,
              createResourceBundleSettings,
              updateResourceBundleSettings,
              deleteResourceBundleSettings,
              listFleetPackagesSettings,
              getFleetPackageSettings,
              createFleetPackageSettings,
              updateFleetPackageSettings,
              deleteFleetPackageSettings,
              listReleasesSettings,
              getReleaseSettings,
              createReleaseSettings,
              updateReleaseSettings,
              deleteReleaseSettings,
              listVariantsSettings,
              getVariantSettings,
              createVariantSettings,
              updateVariantSettings,
              deleteVariantSettings,
              listRolloutsSettings,
              getRolloutSettings,
              suspendRolloutSettings,
              resumeRolloutSettings,
              abortRolloutSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ConfigDeliveryStubSettings settings) {
      super(settings);

      listResourceBundlesSettings = settings.listResourceBundlesSettings.toBuilder();
      getResourceBundleSettings = settings.getResourceBundleSettings.toBuilder();
      createResourceBundleSettings = settings.createResourceBundleSettings.toBuilder();
      createResourceBundleOperationSettings =
          settings.createResourceBundleOperationSettings.toBuilder();
      updateResourceBundleSettings = settings.updateResourceBundleSettings.toBuilder();
      updateResourceBundleOperationSettings =
          settings.updateResourceBundleOperationSettings.toBuilder();
      deleteResourceBundleSettings = settings.deleteResourceBundleSettings.toBuilder();
      deleteResourceBundleOperationSettings =
          settings.deleteResourceBundleOperationSettings.toBuilder();
      listFleetPackagesSettings = settings.listFleetPackagesSettings.toBuilder();
      getFleetPackageSettings = settings.getFleetPackageSettings.toBuilder();
      createFleetPackageSettings = settings.createFleetPackageSettings.toBuilder();
      createFleetPackageOperationSettings =
          settings.createFleetPackageOperationSettings.toBuilder();
      updateFleetPackageSettings = settings.updateFleetPackageSettings.toBuilder();
      updateFleetPackageOperationSettings =
          settings.updateFleetPackageOperationSettings.toBuilder();
      deleteFleetPackageSettings = settings.deleteFleetPackageSettings.toBuilder();
      deleteFleetPackageOperationSettings =
          settings.deleteFleetPackageOperationSettings.toBuilder();
      listReleasesSettings = settings.listReleasesSettings.toBuilder();
      getReleaseSettings = settings.getReleaseSettings.toBuilder();
      createReleaseSettings = settings.createReleaseSettings.toBuilder();
      createReleaseOperationSettings = settings.createReleaseOperationSettings.toBuilder();
      updateReleaseSettings = settings.updateReleaseSettings.toBuilder();
      updateReleaseOperationSettings = settings.updateReleaseOperationSettings.toBuilder();
      deleteReleaseSettings = settings.deleteReleaseSettings.toBuilder();
      deleteReleaseOperationSettings = settings.deleteReleaseOperationSettings.toBuilder();
      listVariantsSettings = settings.listVariantsSettings.toBuilder();
      getVariantSettings = settings.getVariantSettings.toBuilder();
      createVariantSettings = settings.createVariantSettings.toBuilder();
      createVariantOperationSettings = settings.createVariantOperationSettings.toBuilder();
      updateVariantSettings = settings.updateVariantSettings.toBuilder();
      updateVariantOperationSettings = settings.updateVariantOperationSettings.toBuilder();
      deleteVariantSettings = settings.deleteVariantSettings.toBuilder();
      deleteVariantOperationSettings = settings.deleteVariantOperationSettings.toBuilder();
      listRolloutsSettings = settings.listRolloutsSettings.toBuilder();
      getRolloutSettings = settings.getRolloutSettings.toBuilder();
      suspendRolloutSettings = settings.suspendRolloutSettings.toBuilder();
      suspendRolloutOperationSettings = settings.suspendRolloutOperationSettings.toBuilder();
      resumeRolloutSettings = settings.resumeRolloutSettings.toBuilder();
      resumeRolloutOperationSettings = settings.resumeRolloutOperationSettings.toBuilder();
      abortRolloutSettings = settings.abortRolloutSettings.toBuilder();
      abortRolloutOperationSettings = settings.abortRolloutOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listResourceBundlesSettings,
              getResourceBundleSettings,
              createResourceBundleSettings,
              updateResourceBundleSettings,
              deleteResourceBundleSettings,
              listFleetPackagesSettings,
              getFleetPackageSettings,
              createFleetPackageSettings,
              updateFleetPackageSettings,
              deleteFleetPackageSettings,
              listReleasesSettings,
              getReleaseSettings,
              createReleaseSettings,
              updateReleaseSettings,
              deleteReleaseSettings,
              listVariantsSettings,
              getVariantSettings,
              createVariantSettings,
              updateVariantSettings,
              deleteVariantSettings,
              listRolloutsSettings,
              getRolloutSettings,
              suspendRolloutSettings,
              resumeRolloutSettings,
              abortRolloutSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listResourceBundlesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getResourceBundleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createResourceBundleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateResourceBundleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteResourceBundleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listFleetPackagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFleetPackageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createFleetPackageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateFleetPackageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteFleetPackageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listReleasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteReleaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listVariantsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getVariantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createVariantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateVariantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteVariantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listRolloutsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .suspendRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resumeRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .abortRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createResourceBundleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateResourceBundleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ResourceBundle.class))
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
          .updateResourceBundleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateResourceBundleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ResourceBundle.class))
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
          .deleteResourceBundleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteResourceBundleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .createFleetPackageOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFleetPackageRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FleetPackage.class))
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
          .updateFleetPackageOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFleetPackageRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FleetPackage.class))
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
          .deleteFleetPackageOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFleetPackageRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .createReleaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateReleaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Release.class))
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
          .updateReleaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateReleaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Release.class))
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
          .deleteReleaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteReleaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .createVariantOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateVariantRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Variant.class))
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
          .updateVariantOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateVariantRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Variant.class))
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
          .deleteVariantOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteVariantRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .suspendRolloutOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SuspendRolloutRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Rollout.class))
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
          .resumeRolloutOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResumeRolloutRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Rollout.class))
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
          .abortRolloutOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AbortRolloutRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Rollout.class))
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

    /** Returns the builder for the settings used for calls to listResourceBundles. */
    public PagedCallSettings.Builder<
            ListResourceBundlesRequest,
            ListResourceBundlesResponse,
            ListResourceBundlesPagedResponse>
        listResourceBundlesSettings() {
      return listResourceBundlesSettings;
    }

    /** Returns the builder for the settings used for calls to getResourceBundle. */
    public UnaryCallSettings.Builder<GetResourceBundleRequest, ResourceBundle>
        getResourceBundleSettings() {
      return getResourceBundleSettings;
    }

    /** Returns the builder for the settings used for calls to createResourceBundle. */
    public UnaryCallSettings.Builder<CreateResourceBundleRequest, Operation>
        createResourceBundleSettings() {
      return createResourceBundleSettings;
    }

    /** Returns the builder for the settings used for calls to createResourceBundle. */
    public OperationCallSettings.Builder<
            CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
        createResourceBundleOperationSettings() {
      return createResourceBundleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateResourceBundle. */
    public UnaryCallSettings.Builder<UpdateResourceBundleRequest, Operation>
        updateResourceBundleSettings() {
      return updateResourceBundleSettings;
    }

    /** Returns the builder for the settings used for calls to updateResourceBundle. */
    public OperationCallSettings.Builder<
            UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
        updateResourceBundleOperationSettings() {
      return updateResourceBundleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteResourceBundle. */
    public UnaryCallSettings.Builder<DeleteResourceBundleRequest, Operation>
        deleteResourceBundleSettings() {
      return deleteResourceBundleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteResourceBundle. */
    public OperationCallSettings.Builder<DeleteResourceBundleRequest, Empty, OperationMetadata>
        deleteResourceBundleOperationSettings() {
      return deleteResourceBundleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listFleetPackages. */
    public PagedCallSettings.Builder<
            ListFleetPackagesRequest, ListFleetPackagesResponse, ListFleetPackagesPagedResponse>
        listFleetPackagesSettings() {
      return listFleetPackagesSettings;
    }

    /** Returns the builder for the settings used for calls to getFleetPackage. */
    public UnaryCallSettings.Builder<GetFleetPackageRequest, FleetPackage>
        getFleetPackageSettings() {
      return getFleetPackageSettings;
    }

    /** Returns the builder for the settings used for calls to createFleetPackage. */
    public UnaryCallSettings.Builder<CreateFleetPackageRequest, Operation>
        createFleetPackageSettings() {
      return createFleetPackageSettings;
    }

    /** Returns the builder for the settings used for calls to createFleetPackage. */
    public OperationCallSettings.Builder<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
        createFleetPackageOperationSettings() {
      return createFleetPackageOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFleetPackage. */
    public UnaryCallSettings.Builder<UpdateFleetPackageRequest, Operation>
        updateFleetPackageSettings() {
      return updateFleetPackageSettings;
    }

    /** Returns the builder for the settings used for calls to updateFleetPackage. */
    public OperationCallSettings.Builder<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
        updateFleetPackageOperationSettings() {
      return updateFleetPackageOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFleetPackage. */
    public UnaryCallSettings.Builder<DeleteFleetPackageRequest, Operation>
        deleteFleetPackageSettings() {
      return deleteFleetPackageSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFleetPackage. */
    public OperationCallSettings.Builder<DeleteFleetPackageRequest, Empty, OperationMetadata>
        deleteFleetPackageOperationSettings() {
      return deleteFleetPackageOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listReleases. */
    public PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings() {
      return listReleasesSettings;
    }

    /** Returns the builder for the settings used for calls to getRelease. */
    public UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings() {
      return getReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public UnaryCallSettings.Builder<CreateReleaseRequest, Operation> createReleaseSettings() {
      return createReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public OperationCallSettings.Builder<CreateReleaseRequest, Release, OperationMetadata>
        createReleaseOperationSettings() {
      return createReleaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateRelease. */
    public UnaryCallSettings.Builder<UpdateReleaseRequest, Operation> updateReleaseSettings() {
      return updateReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to updateRelease. */
    public OperationCallSettings.Builder<UpdateReleaseRequest, Release, OperationMetadata>
        updateReleaseOperationSettings() {
      return updateReleaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRelease. */
    public UnaryCallSettings.Builder<DeleteReleaseRequest, Operation> deleteReleaseSettings() {
      return deleteReleaseSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRelease. */
    public OperationCallSettings.Builder<DeleteReleaseRequest, Empty, OperationMetadata>
        deleteReleaseOperationSettings() {
      return deleteReleaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listVariants. */
    public PagedCallSettings.Builder<
            ListVariantsRequest, ListVariantsResponse, ListVariantsPagedResponse>
        listVariantsSettings() {
      return listVariantsSettings;
    }

    /** Returns the builder for the settings used for calls to getVariant. */
    public UnaryCallSettings.Builder<GetVariantRequest, Variant> getVariantSettings() {
      return getVariantSettings;
    }

    /** Returns the builder for the settings used for calls to createVariant. */
    public UnaryCallSettings.Builder<CreateVariantRequest, Operation> createVariantSettings() {
      return createVariantSettings;
    }

    /** Returns the builder for the settings used for calls to createVariant. */
    public OperationCallSettings.Builder<CreateVariantRequest, Variant, OperationMetadata>
        createVariantOperationSettings() {
      return createVariantOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateVariant. */
    public UnaryCallSettings.Builder<UpdateVariantRequest, Operation> updateVariantSettings() {
      return updateVariantSettings;
    }

    /** Returns the builder for the settings used for calls to updateVariant. */
    public OperationCallSettings.Builder<UpdateVariantRequest, Variant, OperationMetadata>
        updateVariantOperationSettings() {
      return updateVariantOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVariant. */
    public UnaryCallSettings.Builder<DeleteVariantRequest, Operation> deleteVariantSettings() {
      return deleteVariantSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVariant. */
    public OperationCallSettings.Builder<DeleteVariantRequest, Empty, OperationMetadata>
        deleteVariantOperationSettings() {
      return deleteVariantOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRollouts. */
    public PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings() {
      return listRolloutsSettings;
    }

    /** Returns the builder for the settings used for calls to getRollout. */
    public UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings() {
      return getRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to suspendRollout. */
    public UnaryCallSettings.Builder<SuspendRolloutRequest, Operation> suspendRolloutSettings() {
      return suspendRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to suspendRollout. */
    public OperationCallSettings.Builder<SuspendRolloutRequest, Rollout, OperationMetadata>
        suspendRolloutOperationSettings() {
      return suspendRolloutOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resumeRollout. */
    public UnaryCallSettings.Builder<ResumeRolloutRequest, Operation> resumeRolloutSettings() {
      return resumeRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to resumeRollout. */
    public OperationCallSettings.Builder<ResumeRolloutRequest, Rollout, OperationMetadata>
        resumeRolloutOperationSettings() {
      return resumeRolloutOperationSettings;
    }

    /** Returns the builder for the settings used for calls to abortRollout. */
    public UnaryCallSettings.Builder<AbortRolloutRequest, Operation> abortRolloutSettings() {
      return abortRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to abortRollout. */
    public OperationCallSettings.Builder<AbortRolloutRequest, Rollout, OperationMetadata>
        abortRolloutOperationSettings() {
      return abortRolloutOperationSettings;
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

    @Override
    public ConfigDeliveryStubSettings build() throws IOException {
      return new ConfigDeliveryStubSettings(this);
    }
  }
}

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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListAddressGroupReferencesPagedResponse;
import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListAddressGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.AddressGroup;
import com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.CreateAddressGroupRequest;
import com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest;
import com.google.cloud.networksecurity.v1.GetAddressGroupRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse;
import com.google.cloud.networksecurity.v1.ListAddressGroupsRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest;
import com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest;
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
 * Settings class to configure an instance of {@link AddressGroupServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
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
 * of getAddressGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AddressGroupServiceStubSettings.Builder addressGroupServiceSettingsBuilder =
 *     AddressGroupServiceStubSettings.newBuilder();
 * addressGroupServiceSettingsBuilder
 *     .getAddressGroupSettings()
 *     .setRetrySettings(
 *         addressGroupServiceSettingsBuilder
 *             .getAddressGroupSettings()
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
 * AddressGroupServiceStubSettings addressGroupServiceSettings =
 *     addressGroupServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createAddressGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AddressGroupServiceStubSettings.Builder addressGroupServiceSettingsBuilder =
 *     AddressGroupServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * addressGroupServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AddressGroupServiceStubSettings extends StubSettings<AddressGroupServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAddressGroupsRequest, ListAddressGroupsResponse, ListAddressGroupsPagedResponse>
      listAddressGroupsSettings;
  private final UnaryCallSettings<GetAddressGroupRequest, AddressGroup> getAddressGroupSettings;
  private final UnaryCallSettings<CreateAddressGroupRequest, Operation> createAddressGroupSettings;
  private final OperationCallSettings<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
      createAddressGroupOperationSettings;
  private final UnaryCallSettings<UpdateAddressGroupRequest, Operation> updateAddressGroupSettings;
  private final OperationCallSettings<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
      updateAddressGroupOperationSettings;
  private final UnaryCallSettings<AddAddressGroupItemsRequest, Operation>
      addAddressGroupItemsSettings;
  private final OperationCallSettings<AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      addAddressGroupItemsOperationSettings;
  private final UnaryCallSettings<RemoveAddressGroupItemsRequest, Operation>
      removeAddressGroupItemsSettings;
  private final OperationCallSettings<
          RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      removeAddressGroupItemsOperationSettings;
  private final UnaryCallSettings<CloneAddressGroupItemsRequest, Operation>
      cloneAddressGroupItemsSettings;
  private final OperationCallSettings<
          CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      cloneAddressGroupItemsOperationSettings;
  private final UnaryCallSettings<DeleteAddressGroupRequest, Operation> deleteAddressGroupSettings;
  private final OperationCallSettings<DeleteAddressGroupRequest, Empty, OperationMetadata>
      deleteAddressGroupOperationSettings;
  private final PagedCallSettings<
          ListAddressGroupReferencesRequest,
          ListAddressGroupReferencesResponse,
          ListAddressGroupReferencesPagedResponse>
      listAddressGroupReferencesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListAddressGroupsRequest, ListAddressGroupsResponse, AddressGroup>
      LIST_ADDRESS_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAddressGroupsRequest, ListAddressGroupsResponse, AddressGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAddressGroupsRequest injectToken(
                ListAddressGroupsRequest payload, String token) {
              return ListAddressGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAddressGroupsRequest injectPageSize(
                ListAddressGroupsRequest payload, int pageSize) {
              return ListAddressGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAddressGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAddressGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AddressGroup> extractResources(ListAddressGroupsResponse payload) {
              return payload.getAddressGroupsList();
            }
          };

  private static final PagedListDescriptor<
          ListAddressGroupReferencesRequest,
          ListAddressGroupReferencesResponse,
          ListAddressGroupReferencesResponse.AddressGroupReference>
      LIST_ADDRESS_GROUP_REFERENCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAddressGroupReferencesRequest,
              ListAddressGroupReferencesResponse,
              ListAddressGroupReferencesResponse.AddressGroupReference>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAddressGroupReferencesRequest injectToken(
                ListAddressGroupReferencesRequest payload, String token) {
              return ListAddressGroupReferencesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAddressGroupReferencesRequest injectPageSize(
                ListAddressGroupReferencesRequest payload, int pageSize) {
              return ListAddressGroupReferencesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAddressGroupReferencesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAddressGroupReferencesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ListAddressGroupReferencesResponse.AddressGroupReference>
                extractResources(ListAddressGroupReferencesResponse payload) {
              return payload.getAddressGroupReferencesList();
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
          ListAddressGroupsRequest, ListAddressGroupsResponse, ListAddressGroupsPagedResponse>
      LIST_ADDRESS_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAddressGroupsRequest,
              ListAddressGroupsResponse,
              ListAddressGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListAddressGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAddressGroupsRequest, ListAddressGroupsResponse> callable,
                ListAddressGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListAddressGroupsResponse> futureResponse) {
              PageContext<ListAddressGroupsRequest, ListAddressGroupsResponse, AddressGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ADDRESS_GROUPS_PAGE_STR_DESC, request, context);
              return ListAddressGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAddressGroupReferencesRequest,
          ListAddressGroupReferencesResponse,
          ListAddressGroupReferencesPagedResponse>
      LIST_ADDRESS_GROUP_REFERENCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAddressGroupReferencesRequest,
              ListAddressGroupReferencesResponse,
              ListAddressGroupReferencesPagedResponse>() {
            @Override
            public ApiFuture<ListAddressGroupReferencesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAddressGroupReferencesRequest, ListAddressGroupReferencesResponse>
                    callable,
                ListAddressGroupReferencesRequest request,
                ApiCallContext context,
                ApiFuture<ListAddressGroupReferencesResponse> futureResponse) {
              PageContext<
                      ListAddressGroupReferencesRequest,
                      ListAddressGroupReferencesResponse,
                      ListAddressGroupReferencesResponse.AddressGroupReference>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ADDRESS_GROUP_REFERENCES_PAGE_STR_DESC, request, context);
              return ListAddressGroupReferencesPagedResponse.createAsync(
                  pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listAddressGroups. */
  public PagedCallSettings<
          ListAddressGroupsRequest, ListAddressGroupsResponse, ListAddressGroupsPagedResponse>
      listAddressGroupsSettings() {
    return listAddressGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getAddressGroup. */
  public UnaryCallSettings<GetAddressGroupRequest, AddressGroup> getAddressGroupSettings() {
    return getAddressGroupSettings;
  }

  /** Returns the object with the settings used for calls to createAddressGroup. */
  public UnaryCallSettings<CreateAddressGroupRequest, Operation> createAddressGroupSettings() {
    return createAddressGroupSettings;
  }

  /** Returns the object with the settings used for calls to createAddressGroup. */
  public OperationCallSettings<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
      createAddressGroupOperationSettings() {
    return createAddressGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAddressGroup. */
  public UnaryCallSettings<UpdateAddressGroupRequest, Operation> updateAddressGroupSettings() {
    return updateAddressGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateAddressGroup. */
  public OperationCallSettings<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
      updateAddressGroupOperationSettings() {
    return updateAddressGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to addAddressGroupItems. */
  public UnaryCallSettings<AddAddressGroupItemsRequest, Operation> addAddressGroupItemsSettings() {
    return addAddressGroupItemsSettings;
  }

  /** Returns the object with the settings used for calls to addAddressGroupItems. */
  public OperationCallSettings<AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      addAddressGroupItemsOperationSettings() {
    return addAddressGroupItemsOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeAddressGroupItems. */
  public UnaryCallSettings<RemoveAddressGroupItemsRequest, Operation>
      removeAddressGroupItemsSettings() {
    return removeAddressGroupItemsSettings;
  }

  /** Returns the object with the settings used for calls to removeAddressGroupItems. */
  public OperationCallSettings<RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      removeAddressGroupItemsOperationSettings() {
    return removeAddressGroupItemsOperationSettings;
  }

  /** Returns the object with the settings used for calls to cloneAddressGroupItems. */
  public UnaryCallSettings<CloneAddressGroupItemsRequest, Operation>
      cloneAddressGroupItemsSettings() {
    return cloneAddressGroupItemsSettings;
  }

  /** Returns the object with the settings used for calls to cloneAddressGroupItems. */
  public OperationCallSettings<CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      cloneAddressGroupItemsOperationSettings() {
    return cloneAddressGroupItemsOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAddressGroup. */
  public UnaryCallSettings<DeleteAddressGroupRequest, Operation> deleteAddressGroupSettings() {
    return deleteAddressGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteAddressGroup. */
  public OperationCallSettings<DeleteAddressGroupRequest, Empty, OperationMetadata>
      deleteAddressGroupOperationSettings() {
    return deleteAddressGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAddressGroupReferences. */
  public PagedCallSettings<
          ListAddressGroupReferencesRequest,
          ListAddressGroupReferencesResponse,
          ListAddressGroupReferencesPagedResponse>
      listAddressGroupReferencesSettings() {
    return listAddressGroupReferencesSettings;
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

  public AddressGroupServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAddressGroupServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networksecurity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "networksecurity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networksecurity.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AddressGroupServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AddressGroupServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAddressGroupsSettings = settingsBuilder.listAddressGroupsSettings().build();
    getAddressGroupSettings = settingsBuilder.getAddressGroupSettings().build();
    createAddressGroupSettings = settingsBuilder.createAddressGroupSettings().build();
    createAddressGroupOperationSettings =
        settingsBuilder.createAddressGroupOperationSettings().build();
    updateAddressGroupSettings = settingsBuilder.updateAddressGroupSettings().build();
    updateAddressGroupOperationSettings =
        settingsBuilder.updateAddressGroupOperationSettings().build();
    addAddressGroupItemsSettings = settingsBuilder.addAddressGroupItemsSettings().build();
    addAddressGroupItemsOperationSettings =
        settingsBuilder.addAddressGroupItemsOperationSettings().build();
    removeAddressGroupItemsSettings = settingsBuilder.removeAddressGroupItemsSettings().build();
    removeAddressGroupItemsOperationSettings =
        settingsBuilder.removeAddressGroupItemsOperationSettings().build();
    cloneAddressGroupItemsSettings = settingsBuilder.cloneAddressGroupItemsSettings().build();
    cloneAddressGroupItemsOperationSettings =
        settingsBuilder.cloneAddressGroupItemsOperationSettings().build();
    deleteAddressGroupSettings = settingsBuilder.deleteAddressGroupSettings().build();
    deleteAddressGroupOperationSettings =
        settingsBuilder.deleteAddressGroupOperationSettings().build();
    listAddressGroupReferencesSettings =
        settingsBuilder.listAddressGroupReferencesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for AddressGroupServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AddressGroupServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAddressGroupsRequest, ListAddressGroupsResponse, ListAddressGroupsPagedResponse>
        listAddressGroupsSettings;
    private final UnaryCallSettings.Builder<GetAddressGroupRequest, AddressGroup>
        getAddressGroupSettings;
    private final UnaryCallSettings.Builder<CreateAddressGroupRequest, Operation>
        createAddressGroupSettings;
    private final OperationCallSettings.Builder<
            CreateAddressGroupRequest, AddressGroup, OperationMetadata>
        createAddressGroupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAddressGroupRequest, Operation>
        updateAddressGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
        updateAddressGroupOperationSettings;
    private final UnaryCallSettings.Builder<AddAddressGroupItemsRequest, Operation>
        addAddressGroupItemsSettings;
    private final OperationCallSettings.Builder<
            AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        addAddressGroupItemsOperationSettings;
    private final UnaryCallSettings.Builder<RemoveAddressGroupItemsRequest, Operation>
        removeAddressGroupItemsSettings;
    private final OperationCallSettings.Builder<
            RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        removeAddressGroupItemsOperationSettings;
    private final UnaryCallSettings.Builder<CloneAddressGroupItemsRequest, Operation>
        cloneAddressGroupItemsSettings;
    private final OperationCallSettings.Builder<
            CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        cloneAddressGroupItemsOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAddressGroupRequest, Operation>
        deleteAddressGroupSettings;
    private final OperationCallSettings.Builder<DeleteAddressGroupRequest, Empty, OperationMetadata>
        deleteAddressGroupOperationSettings;
    private final PagedCallSettings.Builder<
            ListAddressGroupReferencesRequest,
            ListAddressGroupReferencesResponse,
            ListAddressGroupReferencesPagedResponse>
        listAddressGroupReferencesSettings;
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
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listAddressGroupsSettings = PagedCallSettings.newBuilder(LIST_ADDRESS_GROUPS_PAGE_STR_FACT);
      getAddressGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAddressGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAddressGroupOperationSettings = OperationCallSettings.newBuilder();
      updateAddressGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAddressGroupOperationSettings = OperationCallSettings.newBuilder();
      addAddressGroupItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addAddressGroupItemsOperationSettings = OperationCallSettings.newBuilder();
      removeAddressGroupItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeAddressGroupItemsOperationSettings = OperationCallSettings.newBuilder();
      cloneAddressGroupItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cloneAddressGroupItemsOperationSettings = OperationCallSettings.newBuilder();
      deleteAddressGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAddressGroupOperationSettings = OperationCallSettings.newBuilder();
      listAddressGroupReferencesSettings =
          PagedCallSettings.newBuilder(LIST_ADDRESS_GROUP_REFERENCES_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAddressGroupsSettings,
              getAddressGroupSettings,
              createAddressGroupSettings,
              updateAddressGroupSettings,
              addAddressGroupItemsSettings,
              removeAddressGroupItemsSettings,
              cloneAddressGroupItemsSettings,
              deleteAddressGroupSettings,
              listAddressGroupReferencesSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AddressGroupServiceStubSettings settings) {
      super(settings);

      listAddressGroupsSettings = settings.listAddressGroupsSettings.toBuilder();
      getAddressGroupSettings = settings.getAddressGroupSettings.toBuilder();
      createAddressGroupSettings = settings.createAddressGroupSettings.toBuilder();
      createAddressGroupOperationSettings =
          settings.createAddressGroupOperationSettings.toBuilder();
      updateAddressGroupSettings = settings.updateAddressGroupSettings.toBuilder();
      updateAddressGroupOperationSettings =
          settings.updateAddressGroupOperationSettings.toBuilder();
      addAddressGroupItemsSettings = settings.addAddressGroupItemsSettings.toBuilder();
      addAddressGroupItemsOperationSettings =
          settings.addAddressGroupItemsOperationSettings.toBuilder();
      removeAddressGroupItemsSettings = settings.removeAddressGroupItemsSettings.toBuilder();
      removeAddressGroupItemsOperationSettings =
          settings.removeAddressGroupItemsOperationSettings.toBuilder();
      cloneAddressGroupItemsSettings = settings.cloneAddressGroupItemsSettings.toBuilder();
      cloneAddressGroupItemsOperationSettings =
          settings.cloneAddressGroupItemsOperationSettings.toBuilder();
      deleteAddressGroupSettings = settings.deleteAddressGroupSettings.toBuilder();
      deleteAddressGroupOperationSettings =
          settings.deleteAddressGroupOperationSettings.toBuilder();
      listAddressGroupReferencesSettings = settings.listAddressGroupReferencesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAddressGroupsSettings,
              getAddressGroupSettings,
              createAddressGroupSettings,
              updateAddressGroupSettings,
              addAddressGroupItemsSettings,
              removeAddressGroupItemsSettings,
              cloneAddressGroupItemsSettings,
              deleteAddressGroupSettings,
              listAddressGroupReferencesSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .listAddressGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAddressGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createAddressGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateAddressGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .addAddressGroupItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .removeAddressGroupItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cloneAddressGroupItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAddressGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAddressGroupReferencesSettings()
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
          .createAddressGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAddressGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AddressGroup.class))
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
          .updateAddressGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAddressGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AddressGroup.class))
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
          .addAddressGroupItemsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddAddressGroupItemsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AddressGroup.class))
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
          .removeAddressGroupItemsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveAddressGroupItemsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AddressGroup.class))
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
          .cloneAddressGroupItemsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CloneAddressGroupItemsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AddressGroup.class))
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
          .deleteAddressGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAddressGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listAddressGroups. */
    public PagedCallSettings.Builder<
            ListAddressGroupsRequest, ListAddressGroupsResponse, ListAddressGroupsPagedResponse>
        listAddressGroupsSettings() {
      return listAddressGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getAddressGroup. */
    public UnaryCallSettings.Builder<GetAddressGroupRequest, AddressGroup>
        getAddressGroupSettings() {
      return getAddressGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createAddressGroup. */
    public UnaryCallSettings.Builder<CreateAddressGroupRequest, Operation>
        createAddressGroupSettings() {
      return createAddressGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createAddressGroup. */
    public OperationCallSettings.Builder<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
        createAddressGroupOperationSettings() {
      return createAddressGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAddressGroup. */
    public UnaryCallSettings.Builder<UpdateAddressGroupRequest, Operation>
        updateAddressGroupSettings() {
      return updateAddressGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateAddressGroup. */
    public OperationCallSettings.Builder<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
        updateAddressGroupOperationSettings() {
      return updateAddressGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to addAddressGroupItems. */
    public UnaryCallSettings.Builder<AddAddressGroupItemsRequest, Operation>
        addAddressGroupItemsSettings() {
      return addAddressGroupItemsSettings;
    }

    /** Returns the builder for the settings used for calls to addAddressGroupItems. */
    public OperationCallSettings.Builder<
            AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        addAddressGroupItemsOperationSettings() {
      return addAddressGroupItemsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeAddressGroupItems. */
    public UnaryCallSettings.Builder<RemoveAddressGroupItemsRequest, Operation>
        removeAddressGroupItemsSettings() {
      return removeAddressGroupItemsSettings;
    }

    /** Returns the builder for the settings used for calls to removeAddressGroupItems. */
    public OperationCallSettings.Builder<
            RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        removeAddressGroupItemsOperationSettings() {
      return removeAddressGroupItemsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cloneAddressGroupItems. */
    public UnaryCallSettings.Builder<CloneAddressGroupItemsRequest, Operation>
        cloneAddressGroupItemsSettings() {
      return cloneAddressGroupItemsSettings;
    }

    /** Returns the builder for the settings used for calls to cloneAddressGroupItems. */
    public OperationCallSettings.Builder<
            CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        cloneAddressGroupItemsOperationSettings() {
      return cloneAddressGroupItemsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAddressGroup. */
    public UnaryCallSettings.Builder<DeleteAddressGroupRequest, Operation>
        deleteAddressGroupSettings() {
      return deleteAddressGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAddressGroup. */
    public OperationCallSettings.Builder<DeleteAddressGroupRequest, Empty, OperationMetadata>
        deleteAddressGroupOperationSettings() {
      return deleteAddressGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAddressGroupReferences. */
    public PagedCallSettings.Builder<
            ListAddressGroupReferencesRequest,
            ListAddressGroupReferencesResponse,
            ListAddressGroupReferencesPagedResponse>
        listAddressGroupReferencesSettings() {
      return listAddressGroupReferencesSettings;
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
    public AddressGroupServiceStubSettings build() throws IOException {
      return new AddressGroupServiceStubSettings(this);
    }
  }
}

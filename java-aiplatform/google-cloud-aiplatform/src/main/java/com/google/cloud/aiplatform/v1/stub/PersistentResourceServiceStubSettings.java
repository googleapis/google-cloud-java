/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.PersistentResourceServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.PersistentResourceServiceClient.ListPersistentResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
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
import com.google.cloud.aiplatform.v1.CreatePersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1.CreatePersistentResourceRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeletePersistentResourceRequest;
import com.google.cloud.aiplatform.v1.GetPersistentResourceRequest;
import com.google.cloud.aiplatform.v1.ListPersistentResourcesRequest;
import com.google.cloud.aiplatform.v1.ListPersistentResourcesResponse;
import com.google.cloud.aiplatform.v1.PersistentResource;
import com.google.cloud.aiplatform.v1.RebootPersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1.RebootPersistentResourceRequest;
import com.google.cloud.aiplatform.v1.UpdatePersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdatePersistentResourceRequest;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PersistentResourceServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPersistentResource to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PersistentResourceServiceStubSettings.Builder persistentResourceServiceSettingsBuilder =
 *     PersistentResourceServiceStubSettings.newBuilder();
 * persistentResourceServiceSettingsBuilder
 *     .getPersistentResourceSettings()
 *     .setRetrySettings(
 *         persistentResourceServiceSettingsBuilder
 *             .getPersistentResourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PersistentResourceServiceStubSettings persistentResourceServiceSettings =
 *     persistentResourceServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PersistentResourceServiceStubSettings
    extends StubSettings<PersistentResourceServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreatePersistentResourceRequest, Operation>
      createPersistentResourceSettings;
  private final OperationCallSettings<
          CreatePersistentResourceRequest,
          PersistentResource,
          CreatePersistentResourceOperationMetadata>
      createPersistentResourceOperationSettings;
  private final UnaryCallSettings<GetPersistentResourceRequest, PersistentResource>
      getPersistentResourceSettings;
  private final PagedCallSettings<
          ListPersistentResourcesRequest,
          ListPersistentResourcesResponse,
          ListPersistentResourcesPagedResponse>
      listPersistentResourcesSettings;
  private final UnaryCallSettings<DeletePersistentResourceRequest, Operation>
      deletePersistentResourceSettings;
  private final OperationCallSettings<
          DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
      deletePersistentResourceOperationSettings;
  private final UnaryCallSettings<UpdatePersistentResourceRequest, Operation>
      updatePersistentResourceSettings;
  private final OperationCallSettings<
          UpdatePersistentResourceRequest,
          PersistentResource,
          UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceOperationSettings;
  private final UnaryCallSettings<RebootPersistentResourceRequest, Operation>
      rebootPersistentResourceSettings;
  private final OperationCallSettings<
          RebootPersistentResourceRequest,
          PersistentResource,
          RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListPersistentResourcesRequest, ListPersistentResourcesResponse, PersistentResource>
      LIST_PERSISTENT_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPersistentResourcesRequest,
              ListPersistentResourcesResponse,
              PersistentResource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPersistentResourcesRequest injectToken(
                ListPersistentResourcesRequest payload, String token) {
              return ListPersistentResourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPersistentResourcesRequest injectPageSize(
                ListPersistentResourcesRequest payload, int pageSize) {
              return ListPersistentResourcesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPersistentResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPersistentResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PersistentResource> extractResources(
                ListPersistentResourcesResponse payload) {
              return payload.getPersistentResourcesList() == null
                  ? ImmutableList.<PersistentResource>of()
                  : payload.getPersistentResourcesList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPersistentResourcesRequest,
          ListPersistentResourcesResponse,
          ListPersistentResourcesPagedResponse>
      LIST_PERSISTENT_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPersistentResourcesRequest,
              ListPersistentResourcesResponse,
              ListPersistentResourcesPagedResponse>() {
            @Override
            public ApiFuture<ListPersistentResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesResponse>
                    callable,
                ListPersistentResourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListPersistentResourcesResponse> futureResponse) {
              PageContext<
                      ListPersistentResourcesRequest,
                      ListPersistentResourcesResponse,
                      PersistentResource>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PERSISTENT_RESOURCES_PAGE_STR_DESC, request, context);
              return ListPersistentResourcesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createPersistentResource. */
  public UnaryCallSettings<CreatePersistentResourceRequest, Operation>
      createPersistentResourceSettings() {
    return createPersistentResourceSettings;
  }

  /** Returns the object with the settings used for calls to createPersistentResource. */
  public OperationCallSettings<
          CreatePersistentResourceRequest,
          PersistentResource,
          CreatePersistentResourceOperationMetadata>
      createPersistentResourceOperationSettings() {
    return createPersistentResourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPersistentResource. */
  public UnaryCallSettings<GetPersistentResourceRequest, PersistentResource>
      getPersistentResourceSettings() {
    return getPersistentResourceSettings;
  }

  /** Returns the object with the settings used for calls to listPersistentResources. */
  public PagedCallSettings<
          ListPersistentResourcesRequest,
          ListPersistentResourcesResponse,
          ListPersistentResourcesPagedResponse>
      listPersistentResourcesSettings() {
    return listPersistentResourcesSettings;
  }

  /** Returns the object with the settings used for calls to deletePersistentResource. */
  public UnaryCallSettings<DeletePersistentResourceRequest, Operation>
      deletePersistentResourceSettings() {
    return deletePersistentResourceSettings;
  }

  /** Returns the object with the settings used for calls to deletePersistentResource. */
  public OperationCallSettings<DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
      deletePersistentResourceOperationSettings() {
    return deletePersistentResourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePersistentResource. */
  public UnaryCallSettings<UpdatePersistentResourceRequest, Operation>
      updatePersistentResourceSettings() {
    return updatePersistentResourceSettings;
  }

  /** Returns the object with the settings used for calls to updatePersistentResource. */
  public OperationCallSettings<
          UpdatePersistentResourceRequest,
          PersistentResource,
          UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceOperationSettings() {
    return updatePersistentResourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to rebootPersistentResource. */
  public UnaryCallSettings<RebootPersistentResourceRequest, Operation>
      rebootPersistentResourceSettings() {
    return rebootPersistentResourceSettings;
  }

  /** Returns the object with the settings used for calls to rebootPersistentResource. */
  public OperationCallSettings<
          RebootPersistentResourceRequest,
          PersistentResource,
          RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceOperationSettings() {
    return rebootPersistentResourceOperationSettings;
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

  public PersistentResourceServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPersistentResourceServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(PersistentResourceServiceStubSettings.class))
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

  protected PersistentResourceServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createPersistentResourceSettings = settingsBuilder.createPersistentResourceSettings().build();
    createPersistentResourceOperationSettings =
        settingsBuilder.createPersistentResourceOperationSettings().build();
    getPersistentResourceSettings = settingsBuilder.getPersistentResourceSettings().build();
    listPersistentResourcesSettings = settingsBuilder.listPersistentResourcesSettings().build();
    deletePersistentResourceSettings = settingsBuilder.deletePersistentResourceSettings().build();
    deletePersistentResourceOperationSettings =
        settingsBuilder.deletePersistentResourceOperationSettings().build();
    updatePersistentResourceSettings = settingsBuilder.updatePersistentResourceSettings().build();
    updatePersistentResourceOperationSettings =
        settingsBuilder.updatePersistentResourceOperationSettings().build();
    rebootPersistentResourceSettings = settingsBuilder.rebootPersistentResourceSettings().build();
    rebootPersistentResourceOperationSettings =
        settingsBuilder.rebootPersistentResourceOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for PersistentResourceServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<PersistentResourceServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreatePersistentResourceRequest, Operation>
        createPersistentResourceSettings;
    private final OperationCallSettings.Builder<
            CreatePersistentResourceRequest,
            PersistentResource,
            CreatePersistentResourceOperationMetadata>
        createPersistentResourceOperationSettings;
    private final UnaryCallSettings.Builder<GetPersistentResourceRequest, PersistentResource>
        getPersistentResourceSettings;
    private final PagedCallSettings.Builder<
            ListPersistentResourcesRequest,
            ListPersistentResourcesResponse,
            ListPersistentResourcesPagedResponse>
        listPersistentResourcesSettings;
    private final UnaryCallSettings.Builder<DeletePersistentResourceRequest, Operation>
        deletePersistentResourceSettings;
    private final OperationCallSettings.Builder<
            DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
        deletePersistentResourceOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePersistentResourceRequest, Operation>
        updatePersistentResourceSettings;
    private final OperationCallSettings.Builder<
            UpdatePersistentResourceRequest,
            PersistentResource,
            UpdatePersistentResourceOperationMetadata>
        updatePersistentResourceOperationSettings;
    private final UnaryCallSettings.Builder<RebootPersistentResourceRequest, Operation>
        rebootPersistentResourceSettings;
    private final OperationCallSettings.Builder<
            RebootPersistentResourceRequest,
            PersistentResource,
            RebootPersistentResourceOperationMetadata>
        rebootPersistentResourceOperationSettings;
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

      createPersistentResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPersistentResourceOperationSettings = OperationCallSettings.newBuilder();
      getPersistentResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPersistentResourcesSettings =
          PagedCallSettings.newBuilder(LIST_PERSISTENT_RESOURCES_PAGE_STR_FACT);
      deletePersistentResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePersistentResourceOperationSettings = OperationCallSettings.newBuilder();
      updatePersistentResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePersistentResourceOperationSettings = OperationCallSettings.newBuilder();
      rebootPersistentResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rebootPersistentResourceOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPersistentResourceSettings,
              getPersistentResourceSettings,
              listPersistentResourcesSettings,
              deletePersistentResourceSettings,
              updatePersistentResourceSettings,
              rebootPersistentResourceSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(PersistentResourceServiceStubSettings settings) {
      super(settings);

      createPersistentResourceSettings = settings.createPersistentResourceSettings.toBuilder();
      createPersistentResourceOperationSettings =
          settings.createPersistentResourceOperationSettings.toBuilder();
      getPersistentResourceSettings = settings.getPersistentResourceSettings.toBuilder();
      listPersistentResourcesSettings = settings.listPersistentResourcesSettings.toBuilder();
      deletePersistentResourceSettings = settings.deletePersistentResourceSettings.toBuilder();
      deletePersistentResourceOperationSettings =
          settings.deletePersistentResourceOperationSettings.toBuilder();
      updatePersistentResourceSettings = settings.updatePersistentResourceSettings.toBuilder();
      updatePersistentResourceOperationSettings =
          settings.updatePersistentResourceOperationSettings.toBuilder();
      rebootPersistentResourceSettings = settings.rebootPersistentResourceSettings.toBuilder();
      rebootPersistentResourceOperationSettings =
          settings.rebootPersistentResourceOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPersistentResourceSettings,
              getPersistentResourceSettings,
              listPersistentResourcesSettings,
              deletePersistentResourceSettings,
              updatePersistentResourceSettings,
              rebootPersistentResourceSettings,
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
          .createPersistentResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPersistentResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPersistentResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePersistentResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updatePersistentResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .rebootPersistentResourceSettings()
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
          .createPersistentResourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePersistentResourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PersistentResource.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreatePersistentResourceOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deletePersistentResourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePersistentResourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updatePersistentResourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePersistentResourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PersistentResource.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdatePersistentResourceOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .rebootPersistentResourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RebootPersistentResourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PersistentResource.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  RebootPersistentResourceOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to createPersistentResource. */
    public UnaryCallSettings.Builder<CreatePersistentResourceRequest, Operation>
        createPersistentResourceSettings() {
      return createPersistentResourceSettings;
    }

    /** Returns the builder for the settings used for calls to createPersistentResource. */
    public OperationCallSettings.Builder<
            CreatePersistentResourceRequest,
            PersistentResource,
            CreatePersistentResourceOperationMetadata>
        createPersistentResourceOperationSettings() {
      return createPersistentResourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPersistentResource. */
    public UnaryCallSettings.Builder<GetPersistentResourceRequest, PersistentResource>
        getPersistentResourceSettings() {
      return getPersistentResourceSettings;
    }

    /** Returns the builder for the settings used for calls to listPersistentResources. */
    public PagedCallSettings.Builder<
            ListPersistentResourcesRequest,
            ListPersistentResourcesResponse,
            ListPersistentResourcesPagedResponse>
        listPersistentResourcesSettings() {
      return listPersistentResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to deletePersistentResource. */
    public UnaryCallSettings.Builder<DeletePersistentResourceRequest, Operation>
        deletePersistentResourceSettings() {
      return deletePersistentResourceSettings;
    }

    /** Returns the builder for the settings used for calls to deletePersistentResource. */
    public OperationCallSettings.Builder<
            DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
        deletePersistentResourceOperationSettings() {
      return deletePersistentResourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePersistentResource. */
    public UnaryCallSettings.Builder<UpdatePersistentResourceRequest, Operation>
        updatePersistentResourceSettings() {
      return updatePersistentResourceSettings;
    }

    /** Returns the builder for the settings used for calls to updatePersistentResource. */
    public OperationCallSettings.Builder<
            UpdatePersistentResourceRequest,
            PersistentResource,
            UpdatePersistentResourceOperationMetadata>
        updatePersistentResourceOperationSettings() {
      return updatePersistentResourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to rebootPersistentResource. */
    public UnaryCallSettings.Builder<RebootPersistentResourceRequest, Operation>
        rebootPersistentResourceSettings() {
      return rebootPersistentResourceSettings;
    }

    /** Returns the builder for the settings used for calls to rebootPersistentResource. */
    public OperationCallSettings.Builder<
            RebootPersistentResourceRequest,
            PersistentResource,
            RebootPersistentResourceOperationMetadata>
        rebootPersistentResourceOperationSettings() {
      return rebootPersistentResourceOperationSettings;
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
    public PersistentResourceServiceStubSettings build() throws IOException {
      return new PersistentResourceServiceStubSettings(this);
    }
  }
}

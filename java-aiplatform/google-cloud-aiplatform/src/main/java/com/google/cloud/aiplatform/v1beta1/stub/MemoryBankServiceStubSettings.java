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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListMemoriesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.CreateMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.GetMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.Memory;
import com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest;
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
 * Settings class to configure an instance of {@link MemoryBankServiceStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getMemory:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MemoryBankServiceStubSettings.Builder memoryBankServiceSettingsBuilder =
 *     MemoryBankServiceStubSettings.newBuilder();
 * memoryBankServiceSettingsBuilder
 *     .getMemorySettings()
 *     .setRetrySettings(
 *         memoryBankServiceSettingsBuilder
 *             .getMemorySettings()
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
 * MemoryBankServiceStubSettings memoryBankServiceSettings =
 *     memoryBankServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createMemory:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MemoryBankServiceStubSettings.Builder memoryBankServiceSettingsBuilder =
 *     MemoryBankServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * memoryBankServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MemoryBankServiceStubSettings extends StubSettings<MemoryBankServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateMemoryRequest, Operation> createMemorySettings;
  private final OperationCallSettings<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
      createMemoryOperationSettings;
  private final UnaryCallSettings<GetMemoryRequest, Memory> getMemorySettings;
  private final UnaryCallSettings<UpdateMemoryRequest, Operation> updateMemorySettings;
  private final OperationCallSettings<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
      updateMemoryOperationSettings;
  private final PagedCallSettings<
          ListMemoriesRequest, ListMemoriesResponse, ListMemoriesPagedResponse>
      listMemoriesSettings;
  private final UnaryCallSettings<DeleteMemoryRequest, Operation> deleteMemorySettings;
  private final OperationCallSettings<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
      deleteMemoryOperationSettings;
  private final UnaryCallSettings<GenerateMemoriesRequest, Operation> generateMemoriesSettings;
  private final OperationCallSettings<
          GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesOperationSettings;
  private final UnaryCallSettings<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
      retrieveMemoriesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListMemoriesRequest, ListMemoriesResponse, Memory>
      LIST_MEMORIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListMemoriesRequest, ListMemoriesResponse, Memory>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMemoriesRequest injectToken(ListMemoriesRequest payload, String token) {
              return ListMemoriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMemoriesRequest injectPageSize(ListMemoriesRequest payload, int pageSize) {
              return ListMemoriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMemoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMemoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Memory> extractResources(ListMemoriesResponse payload) {
              return payload.getMemoriesList();
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
          ListMemoriesRequest, ListMemoriesResponse, ListMemoriesPagedResponse>
      LIST_MEMORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMemoriesRequest, ListMemoriesResponse, ListMemoriesPagedResponse>() {
            @Override
            public ApiFuture<ListMemoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMemoriesRequest, ListMemoriesResponse> callable,
                ListMemoriesRequest request,
                ApiCallContext context,
                ApiFuture<ListMemoriesResponse> futureResponse) {
              PageContext<ListMemoriesRequest, ListMemoriesResponse, Memory> pageContext =
                  PageContext.create(callable, LIST_MEMORIES_PAGE_STR_DESC, request, context);
              return ListMemoriesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createMemory. */
  public UnaryCallSettings<CreateMemoryRequest, Operation> createMemorySettings() {
    return createMemorySettings;
  }

  /** Returns the object with the settings used for calls to createMemory. */
  public OperationCallSettings<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
      createMemoryOperationSettings() {
    return createMemoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to getMemory. */
  public UnaryCallSettings<GetMemoryRequest, Memory> getMemorySettings() {
    return getMemorySettings;
  }

  /** Returns the object with the settings used for calls to updateMemory. */
  public UnaryCallSettings<UpdateMemoryRequest, Operation> updateMemorySettings() {
    return updateMemorySettings;
  }

  /** Returns the object with the settings used for calls to updateMemory. */
  public OperationCallSettings<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
      updateMemoryOperationSettings() {
    return updateMemoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMemories. */
  public PagedCallSettings<ListMemoriesRequest, ListMemoriesResponse, ListMemoriesPagedResponse>
      listMemoriesSettings() {
    return listMemoriesSettings;
  }

  /** Returns the object with the settings used for calls to deleteMemory. */
  public UnaryCallSettings<DeleteMemoryRequest, Operation> deleteMemorySettings() {
    return deleteMemorySettings;
  }

  /** Returns the object with the settings used for calls to deleteMemory. */
  public OperationCallSettings<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
      deleteMemoryOperationSettings() {
    return deleteMemoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateMemories. */
  public UnaryCallSettings<GenerateMemoriesRequest, Operation> generateMemoriesSettings() {
    return generateMemoriesSettings;
  }

  /** Returns the object with the settings used for calls to generateMemories. */
  public OperationCallSettings<
          GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesOperationSettings() {
    return generateMemoriesOperationSettings;
  }

  /** Returns the object with the settings used for calls to retrieveMemories. */
  public UnaryCallSettings<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
      retrieveMemoriesSettings() {
    return retrieveMemoriesSettings;
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

  public MemoryBankServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMemoryBankServiceStub.create(this);
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
  @ObsoleteApi("Use getEndpoint() instead")
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
            "gapic", GaxProperties.getLibraryVersion(MemoryBankServiceStubSettings.class))
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

  protected MemoryBankServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createMemorySettings = settingsBuilder.createMemorySettings().build();
    createMemoryOperationSettings = settingsBuilder.createMemoryOperationSettings().build();
    getMemorySettings = settingsBuilder.getMemorySettings().build();
    updateMemorySettings = settingsBuilder.updateMemorySettings().build();
    updateMemoryOperationSettings = settingsBuilder.updateMemoryOperationSettings().build();
    listMemoriesSettings = settingsBuilder.listMemoriesSettings().build();
    deleteMemorySettings = settingsBuilder.deleteMemorySettings().build();
    deleteMemoryOperationSettings = settingsBuilder.deleteMemoryOperationSettings().build();
    generateMemoriesSettings = settingsBuilder.generateMemoriesSettings().build();
    generateMemoriesOperationSettings = settingsBuilder.generateMemoriesOperationSettings().build();
    retrieveMemoriesSettings = settingsBuilder.retrieveMemoriesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for MemoryBankServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<MemoryBankServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateMemoryRequest, Operation> createMemorySettings;
    private final OperationCallSettings.Builder<
            CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
        createMemoryOperationSettings;
    private final UnaryCallSettings.Builder<GetMemoryRequest, Memory> getMemorySettings;
    private final UnaryCallSettings.Builder<UpdateMemoryRequest, Operation> updateMemorySettings;
    private final OperationCallSettings.Builder<
            UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
        updateMemoryOperationSettings;
    private final PagedCallSettings.Builder<
            ListMemoriesRequest, ListMemoriesResponse, ListMemoriesPagedResponse>
        listMemoriesSettings;
    private final UnaryCallSettings.Builder<DeleteMemoryRequest, Operation> deleteMemorySettings;
    private final OperationCallSettings.Builder<
            DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
        deleteMemoryOperationSettings;
    private final UnaryCallSettings.Builder<GenerateMemoriesRequest, Operation>
        generateMemoriesSettings;
    private final OperationCallSettings.Builder<
            GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
        generateMemoriesOperationSettings;
    private final UnaryCallSettings.Builder<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
        retrieveMemoriesSettings;
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

      createMemorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMemoryOperationSettings = OperationCallSettings.newBuilder();
      getMemorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMemorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMemoryOperationSettings = OperationCallSettings.newBuilder();
      listMemoriesSettings = PagedCallSettings.newBuilder(LIST_MEMORIES_PAGE_STR_FACT);
      deleteMemorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMemoryOperationSettings = OperationCallSettings.newBuilder();
      generateMemoriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateMemoriesOperationSettings = OperationCallSettings.newBuilder();
      retrieveMemoriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMemorySettings,
              getMemorySettings,
              updateMemorySettings,
              listMemoriesSettings,
              deleteMemorySettings,
              generateMemoriesSettings,
              retrieveMemoriesSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(MemoryBankServiceStubSettings settings) {
      super(settings);

      createMemorySettings = settings.createMemorySettings.toBuilder();
      createMemoryOperationSettings = settings.createMemoryOperationSettings.toBuilder();
      getMemorySettings = settings.getMemorySettings.toBuilder();
      updateMemorySettings = settings.updateMemorySettings.toBuilder();
      updateMemoryOperationSettings = settings.updateMemoryOperationSettings.toBuilder();
      listMemoriesSettings = settings.listMemoriesSettings.toBuilder();
      deleteMemorySettings = settings.deleteMemorySettings.toBuilder();
      deleteMemoryOperationSettings = settings.deleteMemoryOperationSettings.toBuilder();
      generateMemoriesSettings = settings.generateMemoriesSettings.toBuilder();
      generateMemoriesOperationSettings = settings.generateMemoriesOperationSettings.toBuilder();
      retrieveMemoriesSettings = settings.retrieveMemoriesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMemorySettings,
              getMemorySettings,
              updateMemorySettings,
              listMemoriesSettings,
              deleteMemorySettings,
              generateMemoriesSettings,
              retrieveMemoriesSettings,
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
          .createMemorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMemorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMemorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMemoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMemorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .generateMemoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveMemoriesSettings()
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
          .createMemoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMemoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Memory.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateMemoryOperationMetadata.class))
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
          .updateMemoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMemoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Memory.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateMemoryOperationMetadata.class))
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
          .deleteMemoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMemoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteMemoryOperationMetadata.class))
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
          .generateMemoriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GenerateMemoriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GenerateMemoriesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  GenerateMemoriesOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createMemory. */
    public UnaryCallSettings.Builder<CreateMemoryRequest, Operation> createMemorySettings() {
      return createMemorySettings;
    }

    /** Returns the builder for the settings used for calls to createMemory. */
    public OperationCallSettings.Builder<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
        createMemoryOperationSettings() {
      return createMemoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getMemory. */
    public UnaryCallSettings.Builder<GetMemoryRequest, Memory> getMemorySettings() {
      return getMemorySettings;
    }

    /** Returns the builder for the settings used for calls to updateMemory. */
    public UnaryCallSettings.Builder<UpdateMemoryRequest, Operation> updateMemorySettings() {
      return updateMemorySettings;
    }

    /** Returns the builder for the settings used for calls to updateMemory. */
    public OperationCallSettings.Builder<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
        updateMemoryOperationSettings() {
      return updateMemoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMemories. */
    public PagedCallSettings.Builder<
            ListMemoriesRequest, ListMemoriesResponse, ListMemoriesPagedResponse>
        listMemoriesSettings() {
      return listMemoriesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMemory. */
    public UnaryCallSettings.Builder<DeleteMemoryRequest, Operation> deleteMemorySettings() {
      return deleteMemorySettings;
    }

    /** Returns the builder for the settings used for calls to deleteMemory. */
    public OperationCallSettings.Builder<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
        deleteMemoryOperationSettings() {
      return deleteMemoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateMemories. */
    public UnaryCallSettings.Builder<GenerateMemoriesRequest, Operation>
        generateMemoriesSettings() {
      return generateMemoriesSettings;
    }

    /** Returns the builder for the settings used for calls to generateMemories. */
    public OperationCallSettings.Builder<
            GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
        generateMemoriesOperationSettings() {
      return generateMemoriesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to retrieveMemories. */
    public UnaryCallSettings.Builder<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
        retrieveMemoriesSettings() {
      return retrieveMemoriesSettings;
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
    public MemoryBankServiceStubSettings build() throws IOException {
      return new MemoryBankServiceStubSettings(this);
    }
  }
}

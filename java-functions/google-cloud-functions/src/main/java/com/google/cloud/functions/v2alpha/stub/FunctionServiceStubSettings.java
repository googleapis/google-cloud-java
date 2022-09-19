/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.functions.v2alpha.stub;

import static com.google.cloud.functions.v2alpha.FunctionServiceClient.ListFunctionsPagedResponse;
import static com.google.cloud.functions.v2alpha.FunctionServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.functions.v2alpha.CreateFunctionRequest;
import com.google.cloud.functions.v2alpha.DeleteFunctionRequest;
import com.google.cloud.functions.v2alpha.Function;
import com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest;
import com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse;
import com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest;
import com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse;
import com.google.cloud.functions.v2alpha.GetFunctionRequest;
import com.google.cloud.functions.v2alpha.ListFunctionsRequest;
import com.google.cloud.functions.v2alpha.ListFunctionsResponse;
import com.google.cloud.functions.v2alpha.ListRuntimesRequest;
import com.google.cloud.functions.v2alpha.ListRuntimesResponse;
import com.google.cloud.functions.v2alpha.OperationMetadata;
import com.google.cloud.functions.v2alpha.UpdateFunctionRequest;
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
 * Settings class to configure an instance of {@link FunctionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudfunctions.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFunction to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FunctionServiceStubSettings.Builder functionServiceSettingsBuilder =
 *     FunctionServiceStubSettings.newBuilder();
 * functionServiceSettingsBuilder
 *     .getFunctionSettings()
 *     .setRetrySettings(
 *         functionServiceSettingsBuilder.getFunctionSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FunctionServiceStubSettings functionServiceSettings = functionServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FunctionServiceStubSettings extends StubSettings<FunctionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetFunctionRequest, Function> getFunctionSettings;
  private final PagedCallSettings<
          ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
      listFunctionsSettings;
  private final UnaryCallSettings<CreateFunctionRequest, Operation> createFunctionSettings;
  private final OperationCallSettings<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationSettings;
  private final UnaryCallSettings<UpdateFunctionRequest, Operation> updateFunctionSettings;
  private final OperationCallSettings<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationSettings;
  private final UnaryCallSettings<DeleteFunctionRequest, Operation> deleteFunctionSettings;
  private final OperationCallSettings<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationSettings;
  private final UnaryCallSettings<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlSettings;
  private final UnaryCallSettings<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlSettings;
  private final UnaryCallSettings<ListRuntimesRequest, ListRuntimesResponse> listRuntimesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListFunctionsRequest, ListFunctionsResponse, Function>
      LIST_FUNCTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFunctionsRequest, ListFunctionsResponse, Function>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFunctionsRequest injectToken(ListFunctionsRequest payload, String token) {
              return ListFunctionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFunctionsRequest injectPageSize(ListFunctionsRequest payload, int pageSize) {
              return ListFunctionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFunctionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFunctionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Function> extractResources(ListFunctionsResponse payload) {
              return payload.getFunctionsList() == null
                  ? ImmutableList.<Function>of()
                  : payload.getFunctionsList();
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
          ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
      LIST_FUNCTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>() {
            @Override
            public ApiFuture<ListFunctionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> callable,
                ListFunctionsRequest request,
                ApiCallContext context,
                ApiFuture<ListFunctionsResponse> futureResponse) {
              PageContext<ListFunctionsRequest, ListFunctionsResponse, Function> pageContext =
                  PageContext.create(callable, LIST_FUNCTIONS_PAGE_STR_DESC, request, context);
              return ListFunctionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to getFunction. */
  public UnaryCallSettings<GetFunctionRequest, Function> getFunctionSettings() {
    return getFunctionSettings;
  }

  /** Returns the object with the settings used for calls to listFunctions. */
  public PagedCallSettings<ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
      listFunctionsSettings() {
    return listFunctionsSettings;
  }

  /** Returns the object with the settings used for calls to createFunction. */
  public UnaryCallSettings<CreateFunctionRequest, Operation> createFunctionSettings() {
    return createFunctionSettings;
  }

  /** Returns the object with the settings used for calls to createFunction. */
  public OperationCallSettings<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationSettings() {
    return createFunctionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFunction. */
  public UnaryCallSettings<UpdateFunctionRequest, Operation> updateFunctionSettings() {
    return updateFunctionSettings;
  }

  /** Returns the object with the settings used for calls to updateFunction. */
  public OperationCallSettings<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationSettings() {
    return updateFunctionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFunction. */
  public UnaryCallSettings<DeleteFunctionRequest, Operation> deleteFunctionSettings() {
    return deleteFunctionSettings;
  }

  /** Returns the object with the settings used for calls to deleteFunction. */
  public OperationCallSettings<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationSettings() {
    return deleteFunctionOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateUploadUrl. */
  public UnaryCallSettings<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlSettings() {
    return generateUploadUrlSettings;
  }

  /** Returns the object with the settings used for calls to generateDownloadUrl. */
  public UnaryCallSettings<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlSettings() {
    return generateDownloadUrlSettings;
  }

  /** Returns the object with the settings used for calls to listRuntimes. */
  public UnaryCallSettings<ListRuntimesRequest, ListRuntimesResponse> listRuntimesSettings() {
    return listRuntimesSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
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

  public FunctionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFunctionServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFunctionServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudfunctions.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudfunctions.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(FunctionServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(FunctionServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FunctionServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected FunctionServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getFunctionSettings = settingsBuilder.getFunctionSettings().build();
    listFunctionsSettings = settingsBuilder.listFunctionsSettings().build();
    createFunctionSettings = settingsBuilder.createFunctionSettings().build();
    createFunctionOperationSettings = settingsBuilder.createFunctionOperationSettings().build();
    updateFunctionSettings = settingsBuilder.updateFunctionSettings().build();
    updateFunctionOperationSettings = settingsBuilder.updateFunctionOperationSettings().build();
    deleteFunctionSettings = settingsBuilder.deleteFunctionSettings().build();
    deleteFunctionOperationSettings = settingsBuilder.deleteFunctionOperationSettings().build();
    generateUploadUrlSettings = settingsBuilder.generateUploadUrlSettings().build();
    generateDownloadUrlSettings = settingsBuilder.generateDownloadUrlSettings().build();
    listRuntimesSettings = settingsBuilder.listRuntimesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for FunctionServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<FunctionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetFunctionRequest, Function> getFunctionSettings;
    private final PagedCallSettings.Builder<
            ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
        listFunctionsSettings;
    private final UnaryCallSettings.Builder<CreateFunctionRequest, Operation>
        createFunctionSettings;
    private final OperationCallSettings.Builder<CreateFunctionRequest, Function, OperationMetadata>
        createFunctionOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFunctionRequest, Operation>
        updateFunctionSettings;
    private final OperationCallSettings.Builder<UpdateFunctionRequest, Function, OperationMetadata>
        updateFunctionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFunctionRequest, Operation>
        deleteFunctionSettings;
    private final OperationCallSettings.Builder<DeleteFunctionRequest, Empty, OperationMetadata>
        deleteFunctionOperationSettings;
    private final UnaryCallSettings.Builder<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
        generateUploadUrlSettings;
    private final UnaryCallSettings.Builder<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
        generateDownloadUrlSettings;
    private final UnaryCallSettings.Builder<ListRuntimesRequest, ListRuntimesResponse>
        listRuntimesSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
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

      getFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFunctionsSettings = PagedCallSettings.newBuilder(LIST_FUNCTIONS_PAGE_STR_FACT);
      createFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFunctionOperationSettings = OperationCallSettings.newBuilder();
      updateFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFunctionOperationSettings = OperationCallSettings.newBuilder();
      deleteFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFunctionOperationSettings = OperationCallSettings.newBuilder();
      generateUploadUrlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateDownloadUrlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRuntimesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getFunctionSettings,
              listFunctionsSettings,
              createFunctionSettings,
              updateFunctionSettings,
              deleteFunctionSettings,
              generateUploadUrlSettings,
              generateDownloadUrlSettings,
              listRuntimesSettings,
              listLocationsSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(FunctionServiceStubSettings settings) {
      super(settings);

      getFunctionSettings = settings.getFunctionSettings.toBuilder();
      listFunctionsSettings = settings.listFunctionsSettings.toBuilder();
      createFunctionSettings = settings.createFunctionSettings.toBuilder();
      createFunctionOperationSettings = settings.createFunctionOperationSettings.toBuilder();
      updateFunctionSettings = settings.updateFunctionSettings.toBuilder();
      updateFunctionOperationSettings = settings.updateFunctionOperationSettings.toBuilder();
      deleteFunctionSettings = settings.deleteFunctionSettings.toBuilder();
      deleteFunctionOperationSettings = settings.deleteFunctionOperationSettings.toBuilder();
      generateUploadUrlSettings = settings.generateUploadUrlSettings.toBuilder();
      generateDownloadUrlSettings = settings.generateDownloadUrlSettings.toBuilder();
      listRuntimesSettings = settings.listRuntimesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getFunctionSettings,
              listFunctionsSettings,
              createFunctionSettings,
              updateFunctionSettings,
              deleteFunctionSettings,
              generateUploadUrlSettings,
              generateDownloadUrlSettings,
              listRuntimesSettings,
              listLocationsSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .getFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listFunctionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .generateUploadUrlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .generateDownloadUrlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listRuntimesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
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
          .createFunctionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFunctionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Function.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateFunctionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFunctionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Function.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteFunctionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFunctionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to getFunction. */
    public UnaryCallSettings.Builder<GetFunctionRequest, Function> getFunctionSettings() {
      return getFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to listFunctions. */
    public PagedCallSettings.Builder<
            ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
        listFunctionsSettings() {
      return listFunctionsSettings;
    }

    /** Returns the builder for the settings used for calls to createFunction. */
    public UnaryCallSettings.Builder<CreateFunctionRequest, Operation> createFunctionSettings() {
      return createFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to createFunction. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateFunctionRequest, Function, OperationMetadata>
        createFunctionOperationSettings() {
      return createFunctionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFunction. */
    public UnaryCallSettings.Builder<UpdateFunctionRequest, Operation> updateFunctionSettings() {
      return updateFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to updateFunction. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateFunctionRequest, Function, OperationMetadata>
        updateFunctionOperationSettings() {
      return updateFunctionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFunction. */
    public UnaryCallSettings.Builder<DeleteFunctionRequest, Operation> deleteFunctionSettings() {
      return deleteFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFunction. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteFunctionRequest, Empty, OperationMetadata>
        deleteFunctionOperationSettings() {
      return deleteFunctionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateUploadUrl. */
    public UnaryCallSettings.Builder<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
        generateUploadUrlSettings() {
      return generateUploadUrlSettings;
    }

    /** Returns the builder for the settings used for calls to generateDownloadUrl. */
    public UnaryCallSettings.Builder<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
        generateDownloadUrlSettings() {
      return generateDownloadUrlSettings;
    }

    /** Returns the builder for the settings used for calls to listRuntimes. */
    public UnaryCallSettings.Builder<ListRuntimesRequest, ListRuntimesResponse>
        listRuntimesSettings() {
      return listRuntimesSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
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
    public FunctionServiceStubSettings build() throws IOException {
      return new FunctionServiceStubSettings(this);
    }
  }
}

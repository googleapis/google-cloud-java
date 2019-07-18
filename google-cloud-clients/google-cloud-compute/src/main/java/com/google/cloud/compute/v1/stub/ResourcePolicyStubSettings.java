/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ResourcePolicyClient.AggregatedListResourcePoliciesPagedResponse;
import static com.google.cloud.compute.v1.ResourcePolicyClient.ListResourcePoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListResourcePoliciesHttpRequest;
import com.google.cloud.compute.v1.DeleteResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.GetResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.InsertResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.ListResourcePoliciesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ResourcePoliciesScopedList;
import com.google.cloud.compute.v1.ResourcePolicy;
import com.google.cloud.compute.v1.ResourcePolicyAggregatedList;
import com.google.cloud.compute.v1.ResourcePolicyList;
import com.google.cloud.compute.v1.SetIamPolicyResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ResourcePolicyStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteResourcePolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * ResourcePolicyStubSettings.Builder resourcePolicySettingsBuilder =
 *     ResourcePolicyStubSettings.newBuilder();
 * resourcePolicySettingsBuilder.deleteResourcePolicySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ResourcePolicyStubSettings resourcePolicySettings = resourcePolicySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ResourcePolicyStubSettings extends StubSettings<ResourcePolicyStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final PagedCallSettings<
          AggregatedListResourcePoliciesHttpRequest,
          ResourcePolicyAggregatedList,
          AggregatedListResourcePoliciesPagedResponse>
      aggregatedListResourcePoliciesSettings;
  private final UnaryCallSettings<DeleteResourcePolicyHttpRequest, Operation>
      deleteResourcePolicySettings;
  private final UnaryCallSettings<GetResourcePolicyHttpRequest, ResourcePolicy>
      getResourcePolicySettings;
  private final UnaryCallSettings<GetIamPolicyResourcePolicyHttpRequest, Policy>
      getIamPolicyResourcePolicySettings;
  private final UnaryCallSettings<InsertResourcePolicyHttpRequest, Operation>
      insertResourcePolicySettings;
  private final PagedCallSettings<
          ListResourcePoliciesHttpRequest, ResourcePolicyList, ListResourcePoliciesPagedResponse>
      listResourcePoliciesSettings;
  private final UnaryCallSettings<SetIamPolicyResourcePolicyHttpRequest, Policy>
      setIamPolicyResourcePolicySettings;
  private final UnaryCallSettings<
          TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
      testIamPermissionsResourcePolicySettings;

  /** Returns the object with the settings used for calls to aggregatedListResourcePolicies. */
  public PagedCallSettings<
          AggregatedListResourcePoliciesHttpRequest,
          ResourcePolicyAggregatedList,
          AggregatedListResourcePoliciesPagedResponse>
      aggregatedListResourcePoliciesSettings() {
    return aggregatedListResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to deleteResourcePolicy. */
  public UnaryCallSettings<DeleteResourcePolicyHttpRequest, Operation>
      deleteResourcePolicySettings() {
    return deleteResourcePolicySettings;
  }

  /** Returns the object with the settings used for calls to getResourcePolicy. */
  public UnaryCallSettings<GetResourcePolicyHttpRequest, ResourcePolicy>
      getResourcePolicySettings() {
    return getResourcePolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicyResourcePolicy. */
  public UnaryCallSettings<GetIamPolicyResourcePolicyHttpRequest, Policy>
      getIamPolicyResourcePolicySettings() {
    return getIamPolicyResourcePolicySettings;
  }

  /** Returns the object with the settings used for calls to insertResourcePolicy. */
  public UnaryCallSettings<InsertResourcePolicyHttpRequest, Operation>
      insertResourcePolicySettings() {
    return insertResourcePolicySettings;
  }

  /** Returns the object with the settings used for calls to listResourcePolicies. */
  public PagedCallSettings<
          ListResourcePoliciesHttpRequest, ResourcePolicyList, ListResourcePoliciesPagedResponse>
      listResourcePoliciesSettings() {
    return listResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicyResourcePolicy. */
  public UnaryCallSettings<SetIamPolicyResourcePolicyHttpRequest, Policy>
      setIamPolicyResourcePolicySettings() {
    return setIamPolicyResourcePolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsResourcePolicy. */
  public UnaryCallSettings<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
      testIamPermissionsResourcePolicySettings() {
    return testIamPermissionsResourcePolicySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ResourcePolicyStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonResourcePolicyStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "https://www.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ResourcePolicyStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected ResourcePolicyStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListResourcePoliciesSettings =
        settingsBuilder.aggregatedListResourcePoliciesSettings().build();
    deleteResourcePolicySettings = settingsBuilder.deleteResourcePolicySettings().build();
    getResourcePolicySettings = settingsBuilder.getResourcePolicySettings().build();
    getIamPolicyResourcePolicySettings =
        settingsBuilder.getIamPolicyResourcePolicySettings().build();
    insertResourcePolicySettings = settingsBuilder.insertResourcePolicySettings().build();
    listResourcePoliciesSettings = settingsBuilder.listResourcePoliciesSettings().build();
    setIamPolicyResourcePolicySettings =
        settingsBuilder.setIamPolicyResourcePolicySettings().build();
    testIamPermissionsResourcePolicySettings =
        settingsBuilder.testIamPermissionsResourcePolicySettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListResourcePoliciesHttpRequest,
          ResourcePolicyAggregatedList,
          ResourcePoliciesScopedList>
      AGGREGATED_LIST_RESOURCE_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListResourcePoliciesHttpRequest,
              ResourcePolicyAggregatedList,
              ResourcePoliciesScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListResourcePoliciesHttpRequest injectToken(
                AggregatedListResourcePoliciesHttpRequest payload, String token) {
              return AggregatedListResourcePoliciesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListResourcePoliciesHttpRequest injectPageSize(
                AggregatedListResourcePoliciesHttpRequest payload, int pageSize) {
              return AggregatedListResourcePoliciesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListResourcePoliciesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ResourcePolicyAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ResourcePoliciesScopedList> extractResources(
                ResourcePolicyAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<ResourcePoliciesScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListResourcePoliciesHttpRequest, ResourcePolicyList, ResourcePolicy>
      LIST_RESOURCE_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListResourcePoliciesHttpRequest, ResourcePolicyList, ResourcePolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListResourcePoliciesHttpRequest injectToken(
                ListResourcePoliciesHttpRequest payload, String token) {
              return ListResourcePoliciesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListResourcePoliciesHttpRequest injectPageSize(
                ListResourcePoliciesHttpRequest payload, int pageSize) {
              return ListResourcePoliciesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListResourcePoliciesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ResourcePolicyList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ResourcePolicy> extractResources(ResourcePolicyList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<ResourcePolicy>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListResourcePoliciesHttpRequest,
          ResourcePolicyAggregatedList,
          AggregatedListResourcePoliciesPagedResponse>
      AGGREGATED_LIST_RESOURCE_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListResourcePoliciesHttpRequest,
              ResourcePolicyAggregatedList,
              AggregatedListResourcePoliciesPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListResourcePoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>
                    callable,
                AggregatedListResourcePoliciesHttpRequest request,
                ApiCallContext context,
                ApiFuture<ResourcePolicyAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListResourcePoliciesHttpRequest,
                      ResourcePolicyAggregatedList,
                      ResourcePoliciesScopedList>
                  pageContext =
                      PageContext.create(
                          callable,
                          AGGREGATED_LIST_RESOURCE_POLICIES_PAGE_STR_DESC,
                          request,
                          context);
              return AggregatedListResourcePoliciesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListResourcePoliciesHttpRequest, ResourcePolicyList, ListResourcePoliciesPagedResponse>
      LIST_RESOURCE_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListResourcePoliciesHttpRequest,
              ResourcePolicyList,
              ListResourcePoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListResourcePoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListResourcePoliciesHttpRequest, ResourcePolicyList> callable,
                ListResourcePoliciesHttpRequest request,
                ApiCallContext context,
                ApiFuture<ResourcePolicyList> futureResponse) {
              PageContext<ListResourcePoliciesHttpRequest, ResourcePolicyList, ResourcePolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RESOURCE_POLICIES_PAGE_STR_DESC, request, context);
              return ListResourcePoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ResourcePolicyStubSettings. */
  public static class Builder extends StubSettings.Builder<ResourcePolicyStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListResourcePoliciesHttpRequest,
            ResourcePolicyAggregatedList,
            AggregatedListResourcePoliciesPagedResponse>
        aggregatedListResourcePoliciesSettings;
    private final UnaryCallSettings.Builder<DeleteResourcePolicyHttpRequest, Operation>
        deleteResourcePolicySettings;
    private final UnaryCallSettings.Builder<GetResourcePolicyHttpRequest, ResourcePolicy>
        getResourcePolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyResourcePolicyHttpRequest, Policy>
        getIamPolicyResourcePolicySettings;
    private final UnaryCallSettings.Builder<InsertResourcePolicyHttpRequest, Operation>
        insertResourcePolicySettings;
    private final PagedCallSettings.Builder<
            ListResourcePoliciesHttpRequest, ResourcePolicyList, ListResourcePoliciesPagedResponse>
        listResourcePoliciesSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyResourcePolicyHttpRequest, Policy>
        setIamPolicyResourcePolicySettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
        testIamPermissionsResourcePolicySettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListResourcePoliciesSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_RESOURCE_POLICIES_PAGE_STR_FACT);

      deleteResourcePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getResourcePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicyResourcePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertResourcePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listResourcePoliciesSettings =
          PagedCallSettings.newBuilder(LIST_RESOURCE_POLICIES_PAGE_STR_FACT);

      setIamPolicyResourcePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsResourcePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListResourcePoliciesSettings,
              deleteResourcePolicySettings,
              getResourcePolicySettings,
              getIamPolicyResourcePolicySettings,
              insertResourcePolicySettings,
              listResourcePoliciesSettings,
              setIamPolicyResourcePolicySettings,
              testIamPermissionsResourcePolicySettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .aggregatedListResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteResourcePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getResourcePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicyResourcePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertResourcePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicyResourcePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsResourcePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ResourcePolicyStubSettings settings) {
      super(settings);

      aggregatedListResourcePoliciesSettings =
          settings.aggregatedListResourcePoliciesSettings.toBuilder();
      deleteResourcePolicySettings = settings.deleteResourcePolicySettings.toBuilder();
      getResourcePolicySettings = settings.getResourcePolicySettings.toBuilder();
      getIamPolicyResourcePolicySettings = settings.getIamPolicyResourcePolicySettings.toBuilder();
      insertResourcePolicySettings = settings.insertResourcePolicySettings.toBuilder();
      listResourcePoliciesSettings = settings.listResourcePoliciesSettings.toBuilder();
      setIamPolicyResourcePolicySettings = settings.setIamPolicyResourcePolicySettings.toBuilder();
      testIamPermissionsResourcePolicySettings =
          settings.testIamPermissionsResourcePolicySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListResourcePoliciesSettings,
              deleteResourcePolicySettings,
              getResourcePolicySettings,
              getIamPolicyResourcePolicySettings,
              insertResourcePolicySettings,
              listResourcePoliciesSettings,
              setIamPolicyResourcePolicySettings,
              testIamPermissionsResourcePolicySettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to aggregatedListResourcePolicies. */
    public PagedCallSettings.Builder<
            AggregatedListResourcePoliciesHttpRequest,
            ResourcePolicyAggregatedList,
            AggregatedListResourcePoliciesPagedResponse>
        aggregatedListResourcePoliciesSettings() {
      return aggregatedListResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteResourcePolicy. */
    public UnaryCallSettings.Builder<DeleteResourcePolicyHttpRequest, Operation>
        deleteResourcePolicySettings() {
      return deleteResourcePolicySettings;
    }

    /** Returns the builder for the settings used for calls to getResourcePolicy. */
    public UnaryCallSettings.Builder<GetResourcePolicyHttpRequest, ResourcePolicy>
        getResourcePolicySettings() {
      return getResourcePolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicyResourcePolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyResourcePolicyHttpRequest, Policy>
        getIamPolicyResourcePolicySettings() {
      return getIamPolicyResourcePolicySettings;
    }

    /** Returns the builder for the settings used for calls to insertResourcePolicy. */
    public UnaryCallSettings.Builder<InsertResourcePolicyHttpRequest, Operation>
        insertResourcePolicySettings() {
      return insertResourcePolicySettings;
    }

    /** Returns the builder for the settings used for calls to listResourcePolicies. */
    public PagedCallSettings.Builder<
            ListResourcePoliciesHttpRequest, ResourcePolicyList, ListResourcePoliciesPagedResponse>
        listResourcePoliciesSettings() {
      return listResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicyResourcePolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyResourcePolicyHttpRequest, Policy>
        setIamPolicyResourcePolicySettings() {
      return setIamPolicyResourcePolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsResourcePolicy. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
        testIamPermissionsResourcePolicySettings() {
      return testIamPermissionsResourcePolicySettings;
    }

    @Override
    public ResourcePolicyStubSettings build() throws IOException {
      return new ResourcePolicyStubSettings(this);
    }
  }
}

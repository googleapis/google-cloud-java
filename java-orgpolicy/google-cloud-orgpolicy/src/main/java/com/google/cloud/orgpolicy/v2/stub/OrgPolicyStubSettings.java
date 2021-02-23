/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.orgpolicy.v2.stub;

import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListConstraintsPagedResponse;
import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.orgpolicy.v2.Constraint;
import com.google.cloud.orgpolicy.v2.CreatePolicyRequest;
import com.google.cloud.orgpolicy.v2.DeletePolicyRequest;
import com.google.cloud.orgpolicy.v2.GetEffectivePolicyRequest;
import com.google.cloud.orgpolicy.v2.GetPolicyRequest;
import com.google.cloud.orgpolicy.v2.ListConstraintsRequest;
import com.google.cloud.orgpolicy.v2.ListConstraintsResponse;
import com.google.cloud.orgpolicy.v2.ListPoliciesRequest;
import com.google.cloud.orgpolicy.v2.ListPoliciesResponse;
import com.google.cloud.orgpolicy.v2.Policy;
import com.google.cloud.orgpolicy.v2.UpdatePolicyRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OrgPolicyStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (orgpolicy.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPolicy to 30 seconds:
 *
 * <pre>{@code
 * OrgPolicyStubSettings.Builder orgPolicySettingsBuilder = OrgPolicyStubSettings.newBuilder();
 * orgPolicySettingsBuilder
 *     .getPolicySettings()
 *     .setRetrySettings(
 *         orgPolicySettingsBuilder
 *             .getPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OrgPolicyStubSettings orgPolicySettings = orgPolicySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OrgPolicyStubSettings extends StubSettings<OrgPolicyStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListConstraintsRequest, ListConstraintsResponse, ListConstraintsPagedResponse>
      listConstraintsSettings;
  private final PagedCallSettings<
          ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      listPoliciesSettings;
  private final UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings;
  private final UnaryCallSettings<GetEffectivePolicyRequest, Policy> getEffectivePolicySettings;
  private final UnaryCallSettings<CreatePolicyRequest, Policy> createPolicySettings;
  private final UnaryCallSettings<UpdatePolicyRequest, Policy> updatePolicySettings;
  private final UnaryCallSettings<DeletePolicyRequest, Empty> deletePolicySettings;

  private static final PagedListDescriptor<
          ListConstraintsRequest, ListConstraintsResponse, Constraint>
      LIST_CONSTRAINTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListConstraintsRequest, ListConstraintsResponse, Constraint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConstraintsRequest injectToken(
                ListConstraintsRequest payload, String token) {
              return ListConstraintsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConstraintsRequest injectPageSize(
                ListConstraintsRequest payload, int pageSize) {
              return ListConstraintsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConstraintsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConstraintsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Constraint> extractResources(ListConstraintsResponse payload) {
              return payload.getConstraintsList() == null
                  ? ImmutableList.<Constraint>of()
                  : payload.getConstraintsList();
            }
          };

  private static final PagedListDescriptor<ListPoliciesRequest, ListPoliciesResponse, Policy>
      LIST_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListPoliciesRequest, ListPoliciesResponse, Policy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPoliciesRequest injectToken(ListPoliciesRequest payload, String token) {
              return ListPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPoliciesRequest injectPageSize(ListPoliciesRequest payload, int pageSize) {
              return ListPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Policy> extractResources(ListPoliciesResponse payload) {
              return payload.getPoliciesList() == null
                  ? ImmutableList.<Policy>of()
                  : payload.getPoliciesList();
            }
          };

  private static final PagedListResponseFactory<
          ListConstraintsRequest, ListConstraintsResponse, ListConstraintsPagedResponse>
      LIST_CONSTRAINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConstraintsRequest, ListConstraintsResponse, ListConstraintsPagedResponse>() {
            @Override
            public ApiFuture<ListConstraintsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConstraintsRequest, ListConstraintsResponse> callable,
                ListConstraintsRequest request,
                ApiCallContext context,
                ApiFuture<ListConstraintsResponse> futureResponse) {
              PageContext<ListConstraintsRequest, ListConstraintsResponse, Constraint> pageContext =
                  PageContext.create(callable, LIST_CONSTRAINTS_PAGE_STR_DESC, request, context);
              return ListConstraintsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      LIST_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> callable,
                ListPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListPoliciesResponse> futureResponse) {
              PageContext<ListPoliciesRequest, ListPoliciesResponse, Policy> pageContext =
                  PageContext.create(callable, LIST_POLICIES_PAGE_STR_DESC, request, context);
              return ListPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listConstraints. */
  public PagedCallSettings<
          ListConstraintsRequest, ListConstraintsResponse, ListConstraintsPagedResponse>
      listConstraintsSettings() {
    return listConstraintsSettings;
  }

  /** Returns the object with the settings used for calls to listPolicies. */
  public PagedCallSettings<ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      listPoliciesSettings() {
    return listPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getPolicy. */
  public UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings() {
    return getPolicySettings;
  }

  /** Returns the object with the settings used for calls to getEffectivePolicy. */
  public UnaryCallSettings<GetEffectivePolicyRequest, Policy> getEffectivePolicySettings() {
    return getEffectivePolicySettings;
  }

  /** Returns the object with the settings used for calls to createPolicy. */
  public UnaryCallSettings<CreatePolicyRequest, Policy> createPolicySettings() {
    return createPolicySettings;
  }

  /** Returns the object with the settings used for calls to updatePolicy. */
  public UnaryCallSettings<UpdatePolicyRequest, Policy> updatePolicySettings() {
    return updatePolicySettings;
  }

  /** Returns the object with the settings used for calls to deletePolicy. */
  public UnaryCallSettings<DeletePolicyRequest, Empty> deletePolicySettings() {
    return deletePolicySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public OrgPolicyStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOrgPolicyStub.create(this);
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
    return "orgpolicy.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(OrgPolicyStubSettings.class))
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

  protected OrgPolicyStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listConstraintsSettings = settingsBuilder.listConstraintsSettings().build();
    listPoliciesSettings = settingsBuilder.listPoliciesSettings().build();
    getPolicySettings = settingsBuilder.getPolicySettings().build();
    getEffectivePolicySettings = settingsBuilder.getEffectivePolicySettings().build();
    createPolicySettings = settingsBuilder.createPolicySettings().build();
    updatePolicySettings = settingsBuilder.updatePolicySettings().build();
    deletePolicySettings = settingsBuilder.deletePolicySettings().build();
  }

  /** Builder for OrgPolicyStubSettings. */
  public static class Builder extends StubSettings.Builder<OrgPolicyStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListConstraintsRequest, ListConstraintsResponse, ListConstraintsPagedResponse>
        listConstraintsSettings;
    private final PagedCallSettings.Builder<
            ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
        listPoliciesSettings;
    private final UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings;
    private final UnaryCallSettings.Builder<GetEffectivePolicyRequest, Policy>
        getEffectivePolicySettings;
    private final UnaryCallSettings.Builder<CreatePolicyRequest, Policy> createPolicySettings;
    private final UnaryCallSettings.Builder<UpdatePolicyRequest, Policy> updatePolicySettings;
    private final UnaryCallSettings.Builder<DeletePolicyRequest, Empty> deletePolicySettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listConstraintsSettings = PagedCallSettings.newBuilder(LIST_CONSTRAINTS_PAGE_STR_FACT);
      listPoliciesSettings = PagedCallSettings.newBuilder(LIST_POLICIES_PAGE_STR_FACT);
      getPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEffectivePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConstraintsSettings,
              listPoliciesSettings,
              getPolicySettings,
              getEffectivePolicySettings,
              createPolicySettings,
              updatePolicySettings,
              deletePolicySettings);
      initDefaults(this);
    }

    protected Builder(OrgPolicyStubSettings settings) {
      super(settings);

      listConstraintsSettings = settings.listConstraintsSettings.toBuilder();
      listPoliciesSettings = settings.listPoliciesSettings.toBuilder();
      getPolicySettings = settings.getPolicySettings.toBuilder();
      getEffectivePolicySettings = settings.getEffectivePolicySettings.toBuilder();
      createPolicySettings = settings.createPolicySettings.toBuilder();
      updatePolicySettings = settings.updatePolicySettings.toBuilder();
      deletePolicySettings = settings.deletePolicySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConstraintsSettings,
              listPoliciesSettings,
              getPolicySettings,
              getEffectivePolicySettings,
              createPolicySettings,
              updatePolicySettings,
              deletePolicySettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listConstraintsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEffectivePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to listConstraints. */
    public PagedCallSettings.Builder<
            ListConstraintsRequest, ListConstraintsResponse, ListConstraintsPagedResponse>
        listConstraintsSettings() {
      return listConstraintsSettings;
    }

    /** Returns the builder for the settings used for calls to listPolicies. */
    public PagedCallSettings.Builder<
            ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
        listPoliciesSettings() {
      return listPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getPolicy. */
    public UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings() {
      return getPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getEffectivePolicy. */
    public UnaryCallSettings.Builder<GetEffectivePolicyRequest, Policy>
        getEffectivePolicySettings() {
      return getEffectivePolicySettings;
    }

    /** Returns the builder for the settings used for calls to createPolicy. */
    public UnaryCallSettings.Builder<CreatePolicyRequest, Policy> createPolicySettings() {
      return createPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updatePolicy. */
    public UnaryCallSettings.Builder<UpdatePolicyRequest, Policy> updatePolicySettings() {
      return updatePolicySettings;
    }

    /** Returns the builder for the settings used for calls to deletePolicy. */
    public UnaryCallSettings.Builder<DeletePolicyRequest, Empty> deletePolicySettings() {
      return deletePolicySettings;
    }

    @Override
    public OrgPolicyStubSettings build() throws IOException {
      return new OrgPolicyStubSettings(this);
    }
  }
}

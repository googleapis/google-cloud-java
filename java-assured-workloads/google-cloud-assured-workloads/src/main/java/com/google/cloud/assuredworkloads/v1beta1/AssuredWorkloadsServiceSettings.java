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

package com.google.cloud.assuredworkloads.v1beta1;

import static com.google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsServiceClient.ListWorkloadsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.assuredworkloads.v1beta1.stub.AssuredWorkloadsServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AssuredWorkloadsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (assuredworkloads.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of updateWorkload to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AssuredWorkloadsServiceSettings.Builder assuredWorkloadsServiceSettingsBuilder =
 *     AssuredWorkloadsServiceSettings.newBuilder();
 * assuredWorkloadsServiceSettingsBuilder
 *     .updateWorkloadSettings()
 *     .setRetrySettings(
 *         assuredWorkloadsServiceSettingsBuilder
 *             .updateWorkloadSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AssuredWorkloadsServiceSettings assuredWorkloadsServiceSettings =
 *     assuredWorkloadsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AssuredWorkloadsServiceSettings
    extends ClientSettings<AssuredWorkloadsServiceSettings> {

  /** Returns the object with the settings used for calls to createWorkload. */
  public UnaryCallSettings<CreateWorkloadRequest, Operation> createWorkloadSettings() {
    return ((AssuredWorkloadsServiceStubSettings) getStubSettings()).createWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to createWorkload. */
  public OperationCallSettings<CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationSettings() {
    return ((AssuredWorkloadsServiceStubSettings) getStubSettings())
        .createWorkloadOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkload. */
  public UnaryCallSettings<UpdateWorkloadRequest, Workload> updateWorkloadSettings() {
    return ((AssuredWorkloadsServiceStubSettings) getStubSettings()).updateWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to restrictAllowedResources. */
  public UnaryCallSettings<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
      restrictAllowedResourcesSettings() {
    return ((AssuredWorkloadsServiceStubSettings) getStubSettings())
        .restrictAllowedResourcesSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkload. */
  public UnaryCallSettings<DeleteWorkloadRequest, Empty> deleteWorkloadSettings() {
    return ((AssuredWorkloadsServiceStubSettings) getStubSettings()).deleteWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to getWorkload. */
  public UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings() {
    return ((AssuredWorkloadsServiceStubSettings) getStubSettings()).getWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to analyzeWorkloadMove. */
  public UnaryCallSettings<AnalyzeWorkloadMoveRequest, AnalyzeWorkloadMoveResponse>
      analyzeWorkloadMoveSettings() {
    return ((AssuredWorkloadsServiceStubSettings) getStubSettings()).analyzeWorkloadMoveSettings();
  }

  /** Returns the object with the settings used for calls to listWorkloads. */
  public PagedCallSettings<ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings() {
    return ((AssuredWorkloadsServiceStubSettings) getStubSettings()).listWorkloadsSettings();
  }

  public static final AssuredWorkloadsServiceSettings create(
      AssuredWorkloadsServiceStubSettings stub) throws IOException {
    return new AssuredWorkloadsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AssuredWorkloadsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AssuredWorkloadsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AssuredWorkloadsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AssuredWorkloadsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AssuredWorkloadsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AssuredWorkloadsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AssuredWorkloadsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AssuredWorkloadsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected AssuredWorkloadsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AssuredWorkloadsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AssuredWorkloadsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AssuredWorkloadsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AssuredWorkloadsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AssuredWorkloadsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AssuredWorkloadsServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AssuredWorkloadsServiceStubSettings.newHttpJsonBuilder());
    }

    public AssuredWorkloadsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AssuredWorkloadsServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createWorkload. */
    public UnaryCallSettings.Builder<CreateWorkloadRequest, Operation> createWorkloadSettings() {
      return getStubSettingsBuilder().createWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkload. */
    public OperationCallSettings.Builder<
            CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
        createWorkloadOperationSettings() {
      return getStubSettingsBuilder().createWorkloadOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkload. */
    public UnaryCallSettings.Builder<UpdateWorkloadRequest, Workload> updateWorkloadSettings() {
      return getStubSettingsBuilder().updateWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to restrictAllowedResources. */
    public UnaryCallSettings.Builder<
            RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
        restrictAllowedResourcesSettings() {
      return getStubSettingsBuilder().restrictAllowedResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkload. */
    public UnaryCallSettings.Builder<DeleteWorkloadRequest, Empty> deleteWorkloadSettings() {
      return getStubSettingsBuilder().deleteWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkload. */
    public UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings() {
      return getStubSettingsBuilder().getWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeWorkloadMove. */
    public UnaryCallSettings.Builder<AnalyzeWorkloadMoveRequest, AnalyzeWorkloadMoveResponse>
        analyzeWorkloadMoveSettings() {
      return getStubSettingsBuilder().analyzeWorkloadMoveSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkloads. */
    public PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings() {
      return getStubSettingsBuilder().listWorkloadsSettings();
    }

    @Override
    public AssuredWorkloadsServiceSettings build() throws IOException {
      return new AssuredWorkloadsServiceSettings(this);
    }
  }
}

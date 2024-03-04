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

package com.google.cloud.securityposture.v1;

import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListLocationsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureDeploymentsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureRevisionsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureTemplatesPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPosturesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securityposture.v1.stub.SecurityPostureStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecurityPostureClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securityposture.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPosture to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityPostureSettings.Builder securityPostureSettingsBuilder =
 *     SecurityPostureSettings.newBuilder();
 * securityPostureSettingsBuilder
 *     .getPostureSettings()
 *     .setRetrySettings(
 *         securityPostureSettingsBuilder
 *             .getPostureSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityPostureSettings securityPostureSettings = securityPostureSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecurityPostureSettings extends ClientSettings<SecurityPostureSettings> {

  /** Returns the object with the settings used for calls to listPostures. */
  public PagedCallSettings<ListPosturesRequest, ListPosturesResponse, ListPosturesPagedResponse>
      listPosturesSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).listPosturesSettings();
  }

  /** Returns the object with the settings used for calls to listPostureRevisions. */
  public PagedCallSettings<
          ListPostureRevisionsRequest,
          ListPostureRevisionsResponse,
          ListPostureRevisionsPagedResponse>
      listPostureRevisionsSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).listPostureRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to getPosture. */
  public UnaryCallSettings<GetPostureRequest, Posture> getPostureSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).getPostureSettings();
  }

  /** Returns the object with the settings used for calls to createPosture. */
  public UnaryCallSettings<CreatePostureRequest, Operation> createPostureSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).createPostureSettings();
  }

  /** Returns the object with the settings used for calls to createPosture. */
  public OperationCallSettings<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).createPostureOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePosture. */
  public UnaryCallSettings<UpdatePostureRequest, Operation> updatePostureSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).updatePostureSettings();
  }

  /** Returns the object with the settings used for calls to updatePosture. */
  public OperationCallSettings<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).updatePostureOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePosture. */
  public UnaryCallSettings<DeletePostureRequest, Operation> deletePostureSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).deletePostureSettings();
  }

  /** Returns the object with the settings used for calls to deletePosture. */
  public OperationCallSettings<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).deletePostureOperationSettings();
  }

  /** Returns the object with the settings used for calls to extractPosture. */
  public UnaryCallSettings<ExtractPostureRequest, Operation> extractPostureSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).extractPostureSettings();
  }

  /** Returns the object with the settings used for calls to extractPosture. */
  public OperationCallSettings<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).extractPostureOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPostureDeployments. */
  public PagedCallSettings<
          ListPostureDeploymentsRequest,
          ListPostureDeploymentsResponse,
          ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).listPostureDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to getPostureDeployment. */
  public UnaryCallSettings<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).getPostureDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createPostureDeployment. */
  public UnaryCallSettings<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).createPostureDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createPostureDeployment. */
  public OperationCallSettings<CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationSettings() {
    return ((SecurityPostureStubSettings) getStubSettings())
        .createPostureDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePostureDeployment. */
  public UnaryCallSettings<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).updatePostureDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updatePostureDeployment. */
  public OperationCallSettings<UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationSettings() {
    return ((SecurityPostureStubSettings) getStubSettings())
        .updatePostureDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePostureDeployment. */
  public UnaryCallSettings<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).deletePostureDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deletePostureDeployment. */
  public OperationCallSettings<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationSettings() {
    return ((SecurityPostureStubSettings) getStubSettings())
        .deletePostureDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPostureTemplates. */
  public PagedCallSettings<
          ListPostureTemplatesRequest,
          ListPostureTemplatesResponse,
          ListPostureTemplatesPagedResponse>
      listPostureTemplatesSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).listPostureTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to getPostureTemplate. */
  public UnaryCallSettings<GetPostureTemplateRequest, PostureTemplate>
      getPostureTemplateSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).getPostureTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SecurityPostureStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final SecurityPostureSettings create(SecurityPostureStubSettings stub)
      throws IOException {
    return new SecurityPostureSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SecurityPostureStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SecurityPostureStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SecurityPostureStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SecurityPostureStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SecurityPostureStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SecurityPostureStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SecurityPostureStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecurityPostureStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SecurityPostureSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SecurityPostureSettings. */
  public static class Builder extends ClientSettings.Builder<SecurityPostureSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SecurityPostureStubSettings.newBuilder(clientContext));
    }

    protected Builder(SecurityPostureSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SecurityPostureStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SecurityPostureStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SecurityPostureStubSettings.newHttpJsonBuilder());
    }

    public SecurityPostureStubSettings.Builder getStubSettingsBuilder() {
      return ((SecurityPostureStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listPostures. */
    public PagedCallSettings.Builder<
            ListPosturesRequest, ListPosturesResponse, ListPosturesPagedResponse>
        listPosturesSettings() {
      return getStubSettingsBuilder().listPosturesSettings();
    }

    /** Returns the builder for the settings used for calls to listPostureRevisions. */
    public PagedCallSettings.Builder<
            ListPostureRevisionsRequest,
            ListPostureRevisionsResponse,
            ListPostureRevisionsPagedResponse>
        listPostureRevisionsSettings() {
      return getStubSettingsBuilder().listPostureRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to getPosture. */
    public UnaryCallSettings.Builder<GetPostureRequest, Posture> getPostureSettings() {
      return getStubSettingsBuilder().getPostureSettings();
    }

    /** Returns the builder for the settings used for calls to createPosture. */
    public UnaryCallSettings.Builder<CreatePostureRequest, Operation> createPostureSettings() {
      return getStubSettingsBuilder().createPostureSettings();
    }

    /** Returns the builder for the settings used for calls to createPosture. */
    public OperationCallSettings.Builder<CreatePostureRequest, Posture, OperationMetadata>
        createPostureOperationSettings() {
      return getStubSettingsBuilder().createPostureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePosture. */
    public UnaryCallSettings.Builder<UpdatePostureRequest, Operation> updatePostureSettings() {
      return getStubSettingsBuilder().updatePostureSettings();
    }

    /** Returns the builder for the settings used for calls to updatePosture. */
    public OperationCallSettings.Builder<UpdatePostureRequest, Posture, OperationMetadata>
        updatePostureOperationSettings() {
      return getStubSettingsBuilder().updatePostureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePosture. */
    public UnaryCallSettings.Builder<DeletePostureRequest, Operation> deletePostureSettings() {
      return getStubSettingsBuilder().deletePostureSettings();
    }

    /** Returns the builder for the settings used for calls to deletePosture. */
    public OperationCallSettings.Builder<DeletePostureRequest, Empty, OperationMetadata>
        deletePostureOperationSettings() {
      return getStubSettingsBuilder().deletePostureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to extractPosture. */
    public UnaryCallSettings.Builder<ExtractPostureRequest, Operation> extractPostureSettings() {
      return getStubSettingsBuilder().extractPostureSettings();
    }

    /** Returns the builder for the settings used for calls to extractPosture. */
    public OperationCallSettings.Builder<ExtractPostureRequest, Posture, OperationMetadata>
        extractPostureOperationSettings() {
      return getStubSettingsBuilder().extractPostureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listPostureDeployments. */
    public PagedCallSettings.Builder<
            ListPostureDeploymentsRequest,
            ListPostureDeploymentsResponse,
            ListPostureDeploymentsPagedResponse>
        listPostureDeploymentsSettings() {
      return getStubSettingsBuilder().listPostureDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to getPostureDeployment. */
    public UnaryCallSettings.Builder<GetPostureDeploymentRequest, PostureDeployment>
        getPostureDeploymentSettings() {
      return getStubSettingsBuilder().getPostureDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createPostureDeployment. */
    public UnaryCallSettings.Builder<CreatePostureDeploymentRequest, Operation>
        createPostureDeploymentSettings() {
      return getStubSettingsBuilder().createPostureDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createPostureDeployment. */
    public OperationCallSettings.Builder<
            CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
        createPostureDeploymentOperationSettings() {
      return getStubSettingsBuilder().createPostureDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePostureDeployment. */
    public UnaryCallSettings.Builder<UpdatePostureDeploymentRequest, Operation>
        updatePostureDeploymentSettings() {
      return getStubSettingsBuilder().updatePostureDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updatePostureDeployment. */
    public OperationCallSettings.Builder<
            UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
        updatePostureDeploymentOperationSettings() {
      return getStubSettingsBuilder().updatePostureDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePostureDeployment. */
    public UnaryCallSettings.Builder<DeletePostureDeploymentRequest, Operation>
        deletePostureDeploymentSettings() {
      return getStubSettingsBuilder().deletePostureDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deletePostureDeployment. */
    public OperationCallSettings.Builder<DeletePostureDeploymentRequest, Empty, OperationMetadata>
        deletePostureDeploymentOperationSettings() {
      return getStubSettingsBuilder().deletePostureDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listPostureTemplates. */
    public PagedCallSettings.Builder<
            ListPostureTemplatesRequest,
            ListPostureTemplatesResponse,
            ListPostureTemplatesPagedResponse>
        listPostureTemplatesSettings() {
      return getStubSettingsBuilder().listPostureTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to getPostureTemplate. */
    public UnaryCallSettings.Builder<GetPostureTemplateRequest, PostureTemplate>
        getPostureTemplateSettings() {
      return getStubSettingsBuilder().getPostureTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public SecurityPostureSettings build() throws IOException {
      return new SecurityPostureSettings(this);
    }
  }
}

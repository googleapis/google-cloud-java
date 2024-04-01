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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListNotebookRuntimeTemplatesPagedResponse;
import static com.google.cloud.aiplatform.v1.NotebookServiceClient.ListNotebookRuntimesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.aiplatform.v1.stub.NotebookServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NotebookServiceClient}.
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
 * <p>For example, to set the total timeout of getNotebookRuntimeTemplate to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NotebookServiceSettings.Builder notebookServiceSettingsBuilder =
 *     NotebookServiceSettings.newBuilder();
 * notebookServiceSettingsBuilder
 *     .getNotebookRuntimeTemplateSettings()
 *     .setRetrySettings(
 *         notebookServiceSettingsBuilder
 *             .getNotebookRuntimeTemplateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NotebookServiceSettings notebookServiceSettings = notebookServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NotebookServiceSettings extends ClientSettings<NotebookServiceSettings> {

  /** Returns the object with the settings used for calls to createNotebookRuntimeTemplate. */
  public UnaryCallSettings<CreateNotebookRuntimeTemplateRequest, Operation>
      createNotebookRuntimeTemplateSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .createNotebookRuntimeTemplateSettings();
  }

  /** Returns the object with the settings used for calls to createNotebookRuntimeTemplate. */
  public OperationCallSettings<
          CreateNotebookRuntimeTemplateRequest,
          NotebookRuntimeTemplate,
          CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .createNotebookRuntimeTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to getNotebookRuntimeTemplate. */
  public UnaryCallSettings<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
      getNotebookRuntimeTemplateSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).getNotebookRuntimeTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listNotebookRuntimeTemplates. */
  public PagedCallSettings<
          ListNotebookRuntimeTemplatesRequest,
          ListNotebookRuntimeTemplatesResponse,
          ListNotebookRuntimeTemplatesPagedResponse>
      listNotebookRuntimeTemplatesSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).listNotebookRuntimeTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to deleteNotebookRuntimeTemplate. */
  public UnaryCallSettings<DeleteNotebookRuntimeTemplateRequest, Operation>
      deleteNotebookRuntimeTemplateSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .deleteNotebookRuntimeTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteNotebookRuntimeTemplate. */
  public OperationCallSettings<DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeTemplateOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .deleteNotebookRuntimeTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to assignNotebookRuntime. */
  public UnaryCallSettings<AssignNotebookRuntimeRequest, Operation>
      assignNotebookRuntimeSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).assignNotebookRuntimeSettings();
  }

  /** Returns the object with the settings used for calls to assignNotebookRuntime. */
  public OperationCallSettings<
          AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .assignNotebookRuntimeOperationSettings();
  }

  /** Returns the object with the settings used for calls to getNotebookRuntime. */
  public UnaryCallSettings<GetNotebookRuntimeRequest, NotebookRuntime>
      getNotebookRuntimeSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).getNotebookRuntimeSettings();
  }

  /** Returns the object with the settings used for calls to listNotebookRuntimes. */
  public PagedCallSettings<
          ListNotebookRuntimesRequest,
          ListNotebookRuntimesResponse,
          ListNotebookRuntimesPagedResponse>
      listNotebookRuntimesSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).listNotebookRuntimesSettings();
  }

  /** Returns the object with the settings used for calls to deleteNotebookRuntime. */
  public UnaryCallSettings<DeleteNotebookRuntimeRequest, Operation>
      deleteNotebookRuntimeSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).deleteNotebookRuntimeSettings();
  }

  /** Returns the object with the settings used for calls to deleteNotebookRuntime. */
  public OperationCallSettings<DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .deleteNotebookRuntimeOperationSettings();
  }

  /** Returns the object with the settings used for calls to upgradeNotebookRuntime. */
  public UnaryCallSettings<UpgradeNotebookRuntimeRequest, Operation>
      upgradeNotebookRuntimeSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).upgradeNotebookRuntimeSettings();
  }

  /** Returns the object with the settings used for calls to upgradeNotebookRuntime. */
  public OperationCallSettings<
          UpgradeNotebookRuntimeRequest,
          UpgradeNotebookRuntimeResponse,
          UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .upgradeNotebookRuntimeOperationSettings();
  }

  /** Returns the object with the settings used for calls to startNotebookRuntime. */
  public UnaryCallSettings<StartNotebookRuntimeRequest, Operation> startNotebookRuntimeSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).startNotebookRuntimeSettings();
  }

  /** Returns the object with the settings used for calls to startNotebookRuntime. */
  public OperationCallSettings<
          StartNotebookRuntimeRequest,
          StartNotebookRuntimeResponse,
          StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .startNotebookRuntimeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final NotebookServiceSettings create(NotebookServiceStubSettings stub)
      throws IOException {
    return new NotebookServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NotebookServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NotebookServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NotebookServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NotebookServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NotebookServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NotebookServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NotebookServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NotebookServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NotebookServiceSettings. */
  public static class Builder extends ClientSettings.Builder<NotebookServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NotebookServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(NotebookServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NotebookServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NotebookServiceStubSettings.newBuilder());
    }

    public NotebookServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((NotebookServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createNotebookRuntimeTemplate. */
    public UnaryCallSettings.Builder<CreateNotebookRuntimeTemplateRequest, Operation>
        createNotebookRuntimeTemplateSettings() {
      return getStubSettingsBuilder().createNotebookRuntimeTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to createNotebookRuntimeTemplate. */
    public OperationCallSettings.Builder<
            CreateNotebookRuntimeTemplateRequest,
            NotebookRuntimeTemplate,
            CreateNotebookRuntimeTemplateOperationMetadata>
        createNotebookRuntimeTemplateOperationSettings() {
      return getStubSettingsBuilder().createNotebookRuntimeTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getNotebookRuntimeTemplate. */
    public UnaryCallSettings.Builder<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
        getNotebookRuntimeTemplateSettings() {
      return getStubSettingsBuilder().getNotebookRuntimeTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listNotebookRuntimeTemplates. */
    public PagedCallSettings.Builder<
            ListNotebookRuntimeTemplatesRequest,
            ListNotebookRuntimeTemplatesResponse,
            ListNotebookRuntimeTemplatesPagedResponse>
        listNotebookRuntimeTemplatesSettings() {
      return getStubSettingsBuilder().listNotebookRuntimeTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNotebookRuntimeTemplate. */
    public UnaryCallSettings.Builder<DeleteNotebookRuntimeTemplateRequest, Operation>
        deleteNotebookRuntimeTemplateSettings() {
      return getStubSettingsBuilder().deleteNotebookRuntimeTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNotebookRuntimeTemplate. */
    public OperationCallSettings.Builder<
            DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
        deleteNotebookRuntimeTemplateOperationSettings() {
      return getStubSettingsBuilder().deleteNotebookRuntimeTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to assignNotebookRuntime. */
    public UnaryCallSettings.Builder<AssignNotebookRuntimeRequest, Operation>
        assignNotebookRuntimeSettings() {
      return getStubSettingsBuilder().assignNotebookRuntimeSettings();
    }

    /** Returns the builder for the settings used for calls to assignNotebookRuntime. */
    public OperationCallSettings.Builder<
            AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
        assignNotebookRuntimeOperationSettings() {
      return getStubSettingsBuilder().assignNotebookRuntimeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getNotebookRuntime. */
    public UnaryCallSettings.Builder<GetNotebookRuntimeRequest, NotebookRuntime>
        getNotebookRuntimeSettings() {
      return getStubSettingsBuilder().getNotebookRuntimeSettings();
    }

    /** Returns the builder for the settings used for calls to listNotebookRuntimes. */
    public PagedCallSettings.Builder<
            ListNotebookRuntimesRequest,
            ListNotebookRuntimesResponse,
            ListNotebookRuntimesPagedResponse>
        listNotebookRuntimesSettings() {
      return getStubSettingsBuilder().listNotebookRuntimesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNotebookRuntime. */
    public UnaryCallSettings.Builder<DeleteNotebookRuntimeRequest, Operation>
        deleteNotebookRuntimeSettings() {
      return getStubSettingsBuilder().deleteNotebookRuntimeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteNotebookRuntime. */
    public OperationCallSettings.Builder<
            DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
        deleteNotebookRuntimeOperationSettings() {
      return getStubSettingsBuilder().deleteNotebookRuntimeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to upgradeNotebookRuntime. */
    public UnaryCallSettings.Builder<UpgradeNotebookRuntimeRequest, Operation>
        upgradeNotebookRuntimeSettings() {
      return getStubSettingsBuilder().upgradeNotebookRuntimeSettings();
    }

    /** Returns the builder for the settings used for calls to upgradeNotebookRuntime. */
    public OperationCallSettings.Builder<
            UpgradeNotebookRuntimeRequest,
            UpgradeNotebookRuntimeResponse,
            UpgradeNotebookRuntimeOperationMetadata>
        upgradeNotebookRuntimeOperationSettings() {
      return getStubSettingsBuilder().upgradeNotebookRuntimeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startNotebookRuntime. */
    public UnaryCallSettings.Builder<StartNotebookRuntimeRequest, Operation>
        startNotebookRuntimeSettings() {
      return getStubSettingsBuilder().startNotebookRuntimeSettings();
    }

    /** Returns the builder for the settings used for calls to startNotebookRuntime. */
    public OperationCallSettings.Builder<
            StartNotebookRuntimeRequest,
            StartNotebookRuntimeResponse,
            StartNotebookRuntimeOperationMetadata>
        startNotebookRuntimeOperationSettings() {
      return getStubSettingsBuilder().startNotebookRuntimeOperationSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public NotebookServiceSettings build() throws IOException {
      return new NotebookServiceSettings(this);
    }
  }
}

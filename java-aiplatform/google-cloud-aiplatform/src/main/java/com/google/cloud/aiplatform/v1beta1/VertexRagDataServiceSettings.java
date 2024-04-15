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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagCorporaPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagFilesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.aiplatform.v1beta1.stub.VertexRagDataServiceStubSettings;
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
 * Settings class to configure an instance of {@link VertexRagDataServiceClient}.
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
 * <p>For example, to set the total timeout of getRagCorpus to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VertexRagDataServiceSettings.Builder vertexRagDataServiceSettingsBuilder =
 *     VertexRagDataServiceSettings.newBuilder();
 * vertexRagDataServiceSettingsBuilder
 *     .getRagCorpusSettings()
 *     .setRetrySettings(
 *         vertexRagDataServiceSettingsBuilder
 *             .getRagCorpusSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VertexRagDataServiceSettings vertexRagDataServiceSettings =
 *     vertexRagDataServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VertexRagDataServiceSettings extends ClientSettings<VertexRagDataServiceSettings> {

  /** Returns the object with the settings used for calls to createRagCorpus. */
  public UnaryCallSettings<CreateRagCorpusRequest, Operation> createRagCorpusSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).createRagCorpusSettings();
  }

  /** Returns the object with the settings used for calls to createRagCorpus. */
  public OperationCallSettings<CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .createRagCorpusOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRagCorpus. */
  public UnaryCallSettings<GetRagCorpusRequest, RagCorpus> getRagCorpusSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getRagCorpusSettings();
  }

  /** Returns the object with the settings used for calls to listRagCorpora. */
  public PagedCallSettings<
          ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
      listRagCorporaSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).listRagCorporaSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagCorpus. */
  public UnaryCallSettings<DeleteRagCorpusRequest, Operation> deleteRagCorpusSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).deleteRagCorpusSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagCorpus. */
  public OperationCallSettings<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings())
        .deleteRagCorpusOperationSettings();
  }

  /** Returns the object with the settings used for calls to uploadRagFile. */
  public UnaryCallSettings<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).uploadRagFileSettings();
  }

  /** Returns the object with the settings used for calls to importRagFiles. */
  public UnaryCallSettings<ImportRagFilesRequest, Operation> importRagFilesSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).importRagFilesSettings();
  }

  /** Returns the object with the settings used for calls to importRagFiles. */
  public OperationCallSettings<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).importRagFilesOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRagFile. */
  public UnaryCallSettings<GetRagFileRequest, RagFile> getRagFileSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getRagFileSettings();
  }

  /** Returns the object with the settings used for calls to listRagFiles. */
  public PagedCallSettings<ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
      listRagFilesSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).listRagFilesSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagFile. */
  public UnaryCallSettings<DeleteRagFileRequest, Operation> deleteRagFileSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).deleteRagFileSettings();
  }

  /** Returns the object with the settings used for calls to deleteRagFile. */
  public OperationCallSettings<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).deleteRagFileOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((VertexRagDataServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final VertexRagDataServiceSettings create(VertexRagDataServiceStubSettings stub)
      throws IOException {
    return new VertexRagDataServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VertexRagDataServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VertexRagDataServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VertexRagDataServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VertexRagDataServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VertexRagDataServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VertexRagDataServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VertexRagDataServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VertexRagDataServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VertexRagDataServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<VertexRagDataServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VertexRagDataServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VertexRagDataServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VertexRagDataServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VertexRagDataServiceStubSettings.newBuilder());
    }

    public VertexRagDataServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VertexRagDataServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createRagCorpus. */
    public UnaryCallSettings.Builder<CreateRagCorpusRequest, Operation> createRagCorpusSettings() {
      return getStubSettingsBuilder().createRagCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to createRagCorpus. */
    public OperationCallSettings.Builder<
            CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
        createRagCorpusOperationSettings() {
      return getStubSettingsBuilder().createRagCorpusOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRagCorpus. */
    public UnaryCallSettings.Builder<GetRagCorpusRequest, RagCorpus> getRagCorpusSettings() {
      return getStubSettingsBuilder().getRagCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to listRagCorpora. */
    public PagedCallSettings.Builder<
            ListRagCorporaRequest, ListRagCorporaResponse, ListRagCorporaPagedResponse>
        listRagCorporaSettings() {
      return getStubSettingsBuilder().listRagCorporaSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagCorpus. */
    public UnaryCallSettings.Builder<DeleteRagCorpusRequest, Operation> deleteRagCorpusSettings() {
      return getStubSettingsBuilder().deleteRagCorpusSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagCorpus. */
    public OperationCallSettings.Builder<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
        deleteRagCorpusOperationSettings() {
      return getStubSettingsBuilder().deleteRagCorpusOperationSettings();
    }

    /** Returns the builder for the settings used for calls to uploadRagFile. */
    public UnaryCallSettings.Builder<UploadRagFileRequest, UploadRagFileResponse>
        uploadRagFileSettings() {
      return getStubSettingsBuilder().uploadRagFileSettings();
    }

    /** Returns the builder for the settings used for calls to importRagFiles. */
    public UnaryCallSettings.Builder<ImportRagFilesRequest, Operation> importRagFilesSettings() {
      return getStubSettingsBuilder().importRagFilesSettings();
    }

    /** Returns the builder for the settings used for calls to importRagFiles. */
    public OperationCallSettings.Builder<
            ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
        importRagFilesOperationSettings() {
      return getStubSettingsBuilder().importRagFilesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRagFile. */
    public UnaryCallSettings.Builder<GetRagFileRequest, RagFile> getRagFileSettings() {
      return getStubSettingsBuilder().getRagFileSettings();
    }

    /** Returns the builder for the settings used for calls to listRagFiles. */
    public PagedCallSettings.Builder<
            ListRagFilesRequest, ListRagFilesResponse, ListRagFilesPagedResponse>
        listRagFilesSettings() {
      return getStubSettingsBuilder().listRagFilesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagFile. */
    public UnaryCallSettings.Builder<DeleteRagFileRequest, Operation> deleteRagFileSettings() {
      return getStubSettingsBuilder().deleteRagFileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRagFile. */
    public OperationCallSettings.Builder<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
        deleteRagFileOperationSettings() {
      return getStubSettingsBuilder().deleteRagFileOperationSettings();
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
    public VertexRagDataServiceSettings build() throws IOException {
      return new VertexRagDataServiceSettings(this);
    }
  }
}

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
package com.google.cloud.firestore.v1;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.firestore.v1.stub.FirestoreAdminStubSettings;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link FirestoreAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (firestore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createIndex to 30 seconds:
 *
 * <pre>
 * <code>
 * FirestoreAdminSettings.Builder firestoreAdminSettingsBuilder =
 *     FirestoreAdminSettings.newBuilder();
 * firestoreAdminSettingsBuilder.createIndexSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * FirestoreAdminSettings firestoreAdminSettings = firestoreAdminSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class FirestoreAdminSettings extends ClientSettings<FirestoreAdminSettings> {
  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).createIndexSettings();
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).listIndexesSettings();
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).getIndexSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Empty> deleteIndexSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).deleteIndexSettings();
  }

  /** Returns the object with the settings used for calls to importDocuments. */
  public UnaryCallSettings<ImportDocumentsRequest, Operation> importDocumentsSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).importDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to exportDocuments. */
  public UnaryCallSettings<ExportDocumentsRequest, Operation> exportDocumentsSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).exportDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to getField. */
  public UnaryCallSettings<GetFieldRequest, Field> getFieldSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).getFieldSettings();
  }

  /** Returns the object with the settings used for calls to listFields. */
  public PagedCallSettings<ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
      listFieldsSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).listFieldsSettings();
  }

  /** Returns the object with the settings used for calls to updateField. */
  public UnaryCallSettings<UpdateFieldRequest, Operation> updateFieldSettings() {
    return ((FirestoreAdminStubSettings) getStubSettings()).updateFieldSettings();
  }

  public static final FirestoreAdminSettings create(FirestoreAdminStubSettings stub)
      throws IOException {
    return new FirestoreAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FirestoreAdminStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FirestoreAdminStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FirestoreAdminStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FirestoreAdminStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FirestoreAdminStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FirestoreAdminStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirestoreAdminStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FirestoreAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FirestoreAdminSettings. */
  public static class Builder extends ClientSettings.Builder<FirestoreAdminSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(FirestoreAdminStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(FirestoreAdminStubSettings.newBuilder());
    }

    protected Builder(FirestoreAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FirestoreAdminStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public FirestoreAdminStubSettings.Builder getStubSettingsBuilder() {
      return ((FirestoreAdminStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return getStubSettingsBuilder().createIndexSettings();
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return getStubSettingsBuilder().listIndexesSettings();
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getStubSettingsBuilder().getIndexSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Empty> deleteIndexSettings() {
      return getStubSettingsBuilder().deleteIndexSettings();
    }

    /** Returns the builder for the settings used for calls to importDocuments. */
    public UnaryCallSettings.Builder<ImportDocumentsRequest, Operation> importDocumentsSettings() {
      return getStubSettingsBuilder().importDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to exportDocuments. */
    public UnaryCallSettings.Builder<ExportDocumentsRequest, Operation> exportDocumentsSettings() {
      return getStubSettingsBuilder().exportDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to getField. */
    public UnaryCallSettings.Builder<GetFieldRequest, Field> getFieldSettings() {
      return getStubSettingsBuilder().getFieldSettings();
    }

    /** Returns the builder for the settings used for calls to listFields. */
    public PagedCallSettings.Builder<ListFieldsRequest, ListFieldsResponse, ListFieldsPagedResponse>
        listFieldsSettings() {
      return getStubSettingsBuilder().listFieldsSettings();
    }

    /** Returns the builder for the settings used for calls to updateField. */
    public UnaryCallSettings.Builder<UpdateFieldRequest, Operation> updateFieldSettings() {
      return getStubSettingsBuilder().updateFieldSettings();
    }

    @Override
    public FirestoreAdminSettings build() throws IOException {
      return new FirestoreAdminSettings(this);
    }
  }
}

/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.pubsub.v1;

import static com.google.cloud.pubsub.v1.SchemaServiceClient.ListSchemasPagedResponse;

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
import com.google.cloud.pubsub.v1.stub.SchemaServiceStubSettings;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.CreateSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRequest;
import com.google.pubsub.v1.GetSchemaRequest;
import com.google.pubsub.v1.ListSchemasRequest;
import com.google.pubsub.v1.ListSchemasResponse;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.ValidateMessageRequest;
import com.google.pubsub.v1.ValidateMessageResponse;
import com.google.pubsub.v1.ValidateSchemaRequest;
import com.google.pubsub.v1.ValidateSchemaResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SchemaServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (pubsub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSchema to 30 seconds:
 *
 * <pre>
 * <code>
 * SchemaServiceSettings.Builder schemaServiceSettingsBuilder =
 *     SchemaServiceSettings.newBuilder();
 * schemaServiceSettingsBuilder
 *     .createSchemaSettings()
 *     .setRetrySettings(
 *         schemaServiceSettingsBuilder.createSchemaSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SchemaServiceSettings schemaServiceSettings = schemaServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
public class SchemaServiceSettings extends ClientSettings<SchemaServiceSettings> {
  /** Returns the object with the settings used for calls to createSchema. */
  public UnaryCallSettings<CreateSchemaRequest, Schema> createSchemaSettings() {
    return ((SchemaServiceStubSettings) getStubSettings()).createSchemaSettings();
  }

  /** Returns the object with the settings used for calls to getSchema. */
  public UnaryCallSettings<GetSchemaRequest, Schema> getSchemaSettings() {
    return ((SchemaServiceStubSettings) getStubSettings()).getSchemaSettings();
  }

  /** Returns the object with the settings used for calls to listSchemas. */
  public PagedCallSettings<ListSchemasRequest, ListSchemasResponse, ListSchemasPagedResponse>
      listSchemasSettings() {
    return ((SchemaServiceStubSettings) getStubSettings()).listSchemasSettings();
  }

  /** Returns the object with the settings used for calls to deleteSchema. */
  public UnaryCallSettings<DeleteSchemaRequest, Empty> deleteSchemaSettings() {
    return ((SchemaServiceStubSettings) getStubSettings()).deleteSchemaSettings();
  }

  /** Returns the object with the settings used for calls to validateSchema. */
  public UnaryCallSettings<ValidateSchemaRequest, ValidateSchemaResponse> validateSchemaSettings() {
    return ((SchemaServiceStubSettings) getStubSettings()).validateSchemaSettings();
  }

  /** Returns the object with the settings used for calls to validateMessage. */
  public UnaryCallSettings<ValidateMessageRequest, ValidateMessageResponse>
      validateMessageSettings() {
    return ((SchemaServiceStubSettings) getStubSettings()).validateMessageSettings();
  }

  public static final SchemaServiceSettings create(SchemaServiceStubSettings stub)
      throws IOException {
    return new SchemaServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SchemaServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SchemaServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SchemaServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SchemaServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SchemaServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SchemaServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SchemaServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SchemaServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SchemaServiceSettings. */
  public static class Builder extends ClientSettings.Builder<SchemaServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(SchemaServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(SchemaServiceStubSettings.newBuilder());
    }

    protected Builder(SchemaServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SchemaServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public SchemaServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SchemaServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSchema. */
    public UnaryCallSettings.Builder<CreateSchemaRequest, Schema> createSchemaSettings() {
      return getStubSettingsBuilder().createSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to getSchema. */
    public UnaryCallSettings.Builder<GetSchemaRequest, Schema> getSchemaSettings() {
      return getStubSettingsBuilder().getSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to listSchemas. */
    public PagedCallSettings.Builder<
            ListSchemasRequest, ListSchemasResponse, ListSchemasPagedResponse>
        listSchemasSettings() {
      return getStubSettingsBuilder().listSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSchema. */
    public UnaryCallSettings.Builder<DeleteSchemaRequest, Empty> deleteSchemaSettings() {
      return getStubSettingsBuilder().deleteSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to validateSchema. */
    public UnaryCallSettings.Builder<ValidateSchemaRequest, ValidateSchemaResponse>
        validateSchemaSettings() {
      return getStubSettingsBuilder().validateSchemaSettings();
    }

    /** Returns the builder for the settings used for calls to validateMessage. */
    public UnaryCallSettings.Builder<ValidateMessageRequest, ValidateMessageResponse>
        validateMessageSettings() {
      return getStubSettingsBuilder().validateMessageSettings();
    }

    @Override
    public SchemaServiceSettings build() throws IOException {
      return new SchemaServiceSettings(this);
    }
  }
}

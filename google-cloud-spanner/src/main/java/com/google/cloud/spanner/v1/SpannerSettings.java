/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.spanner.v1;

import static com.google.cloud.spanner.v1.SpannerClient.ListSessionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.protobuf.Empty;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.DeleteSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ListSessionsRequest;
import com.google.spanner.v1.ListSessionsResponse;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SpannerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (spanner.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of createSession to 30 seconds:
 *
 * <pre>
 * <code>
 * SpannerSettings.Builder spannerSettingsBuilder =
 *     SpannerSettings.newBuilder();
 * spannerSettingsBuilder.createSessionSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SpannerSettings spannerSettings = spannerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SpannerSettings extends ClientSettings<SpannerSettings> {
  /** Returns the object with the settings used for calls to createSession. */
  public UnaryCallSettings<CreateSessionRequest, Session> createSessionSettings() {
    return ((SpannerStubSettings) getStubSettings()).createSessionSettings();
  }

  /** Returns the object with the settings used for calls to getSession. */
  public UnaryCallSettings<GetSessionRequest, Session> getSessionSettings() {
    return ((SpannerStubSettings) getStubSettings()).getSessionSettings();
  }

  /** Returns the object with the settings used for calls to listSessions. */
  public PagedCallSettings<ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings() {
    return ((SpannerStubSettings) getStubSettings()).listSessionsSettings();
  }

  /** Returns the object with the settings used for calls to deleteSession. */
  public UnaryCallSettings<DeleteSessionRequest, Empty> deleteSessionSettings() {
    return ((SpannerStubSettings) getStubSettings()).deleteSessionSettings();
  }

  /** Returns the object with the settings used for calls to executeSql. */
  public UnaryCallSettings<ExecuteSqlRequest, ResultSet> executeSqlSettings() {
    return ((SpannerStubSettings) getStubSettings()).executeSqlSettings();
  }

  /** Returns the object with the settings used for calls to executeStreamingSql. */
  public ServerStreamingCallSettings<ExecuteSqlRequest, PartialResultSet>
      executeStreamingSqlSettings() {
    return ((SpannerStubSettings) getStubSettings()).executeStreamingSqlSettings();
  }

  /** Returns the object with the settings used for calls to read. */
  public UnaryCallSettings<ReadRequest, ResultSet> readSettings() {
    return ((SpannerStubSettings) getStubSettings()).readSettings();
  }

  /** Returns the object with the settings used for calls to streamingRead. */
  public ServerStreamingCallSettings<ReadRequest, PartialResultSet> streamingReadSettings() {
    return ((SpannerStubSettings) getStubSettings()).streamingReadSettings();
  }

  /** Returns the object with the settings used for calls to beginTransaction. */
  public UnaryCallSettings<BeginTransactionRequest, Transaction> beginTransactionSettings() {
    return ((SpannerStubSettings) getStubSettings()).beginTransactionSettings();
  }

  /** Returns the object with the settings used for calls to commit. */
  public UnaryCallSettings<CommitRequest, CommitResponse> commitSettings() {
    return ((SpannerStubSettings) getStubSettings()).commitSettings();
  }

  /** Returns the object with the settings used for calls to rollback. */
  public UnaryCallSettings<RollbackRequest, Empty> rollbackSettings() {
    return ((SpannerStubSettings) getStubSettings()).rollbackSettings();
  }

  /** Returns the object with the settings used for calls to partitionQuery. */
  public UnaryCallSettings<PartitionQueryRequest, PartitionResponse> partitionQuerySettings() {
    return ((SpannerStubSettings) getStubSettings()).partitionQuerySettings();
  }

  /** Returns the object with the settings used for calls to partitionRead. */
  public UnaryCallSettings<PartitionReadRequest, PartitionResponse> partitionReadSettings() {
    return ((SpannerStubSettings) getStubSettings()).partitionReadSettings();
  }

  public static final SpannerSettings create(SpannerStubSettings stub) throws IOException {
    return new SpannerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SpannerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SpannerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SpannerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SpannerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SpannerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SpannerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SpannerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SpannerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SpannerSettings. */
  public static class Builder extends ClientSettings.Builder<SpannerSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(SpannerStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(SpannerStubSettings.newBuilder());
    }

    protected Builder(SpannerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SpannerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public SpannerStubSettings.Builder getStubSettingsBuilder() {
      return ((SpannerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSession. */
    public UnaryCallSettings.Builder<CreateSessionRequest, Session> createSessionSettings() {
      return getStubSettingsBuilder().createSessionSettings();
    }

    /** Returns the builder for the settings used for calls to getSession. */
    public UnaryCallSettings.Builder<GetSessionRequest, Session> getSessionSettings() {
      return getStubSettingsBuilder().getSessionSettings();
    }

    /** Returns the builder for the settings used for calls to listSessions. */
    public PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings() {
      return getStubSettingsBuilder().listSessionsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSession. */
    public UnaryCallSettings.Builder<DeleteSessionRequest, Empty> deleteSessionSettings() {
      return getStubSettingsBuilder().deleteSessionSettings();
    }

    /** Returns the builder for the settings used for calls to executeSql. */
    public UnaryCallSettings.Builder<ExecuteSqlRequest, ResultSet> executeSqlSettings() {
      return getStubSettingsBuilder().executeSqlSettings();
    }

    /** Returns the builder for the settings used for calls to executeStreamingSql. */
    public ServerStreamingCallSettings.Builder<ExecuteSqlRequest, PartialResultSet>
        executeStreamingSqlSettings() {
      return getStubSettingsBuilder().executeStreamingSqlSettings();
    }

    /** Returns the builder for the settings used for calls to read. */
    public UnaryCallSettings.Builder<ReadRequest, ResultSet> readSettings() {
      return getStubSettingsBuilder().readSettings();
    }

    /** Returns the builder for the settings used for calls to streamingRead. */
    public ServerStreamingCallSettings.Builder<ReadRequest, PartialResultSet>
        streamingReadSettings() {
      return getStubSettingsBuilder().streamingReadSettings();
    }

    /** Returns the builder for the settings used for calls to beginTransaction. */
    public UnaryCallSettings.Builder<BeginTransactionRequest, Transaction>
        beginTransactionSettings() {
      return getStubSettingsBuilder().beginTransactionSettings();
    }

    /** Returns the builder for the settings used for calls to commit. */
    public UnaryCallSettings.Builder<CommitRequest, CommitResponse> commitSettings() {
      return getStubSettingsBuilder().commitSettings();
    }

    /** Returns the builder for the settings used for calls to rollback. */
    public UnaryCallSettings.Builder<RollbackRequest, Empty> rollbackSettings() {
      return getStubSettingsBuilder().rollbackSettings();
    }

    /** Returns the builder for the settings used for calls to partitionQuery. */
    public UnaryCallSettings.Builder<PartitionQueryRequest, PartitionResponse>
        partitionQuerySettings() {
      return getStubSettingsBuilder().partitionQuerySettings();
    }

    /** Returns the builder for the settings used for calls to partitionRead. */
    public UnaryCallSettings.Builder<PartitionReadRequest, PartitionResponse>
        partitionReadSettings() {
      return getStubSettingsBuilder().partitionReadSettings();
    }

    @Override
    public SpannerSettings build() throws IOException {
      return new SpannerSettings(this);
    }
  }
}

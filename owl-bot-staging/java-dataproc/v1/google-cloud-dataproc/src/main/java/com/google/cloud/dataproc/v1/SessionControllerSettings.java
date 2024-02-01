/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.SessionControllerClient.ListSessionsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataproc.v1.stub.SessionControllerStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SessionControllerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataproc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getSession to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SessionControllerSettings.Builder sessionControllerSettingsBuilder =
 *     SessionControllerSettings.newBuilder();
 * sessionControllerSettingsBuilder
 *     .getSessionSettings()
 *     .setRetrySettings(
 *         sessionControllerSettingsBuilder
 *             .getSessionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SessionControllerSettings sessionControllerSettings = sessionControllerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SessionControllerSettings extends ClientSettings<SessionControllerSettings> {

  /** Returns the object with the settings used for calls to createSession. */
  public UnaryCallSettings<CreateSessionRequest, Operation> createSessionSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).createSessionSettings();
  }

  /** Returns the object with the settings used for calls to createSession. */
  public OperationCallSettings<CreateSessionRequest, Session, SessionOperationMetadata>
      createSessionOperationSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).createSessionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSession. */
  public UnaryCallSettings<GetSessionRequest, Session> getSessionSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).getSessionSettings();
  }

  /** Returns the object with the settings used for calls to listSessions. */
  public PagedCallSettings<ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).listSessionsSettings();
  }

  /** Returns the object with the settings used for calls to terminateSession. */
  public UnaryCallSettings<TerminateSessionRequest, Operation> terminateSessionSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).terminateSessionSettings();
  }

  /** Returns the object with the settings used for calls to terminateSession. */
  public OperationCallSettings<TerminateSessionRequest, Session, SessionOperationMetadata>
      terminateSessionOperationSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).terminateSessionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSession. */
  public UnaryCallSettings<DeleteSessionRequest, Operation> deleteSessionSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).deleteSessionSettings();
  }

  /** Returns the object with the settings used for calls to deleteSession. */
  public OperationCallSettings<DeleteSessionRequest, Session, SessionOperationMetadata>
      deleteSessionOperationSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).deleteSessionOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((SessionControllerStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((SessionControllerStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((SessionControllerStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final SessionControllerSettings create(SessionControllerStubSettings stub)
      throws IOException {
    return new SessionControllerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SessionControllerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SessionControllerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SessionControllerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SessionControllerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SessionControllerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SessionControllerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SessionControllerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SessionControllerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SessionControllerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SessionControllerSettings. */
  public static class Builder extends ClientSettings.Builder<SessionControllerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SessionControllerStubSettings.newBuilder(clientContext));
    }

    protected Builder(SessionControllerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SessionControllerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SessionControllerStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SessionControllerStubSettings.newHttpJsonBuilder());
    }

    public SessionControllerStubSettings.Builder getStubSettingsBuilder() {
      return ((SessionControllerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSession. */
    public UnaryCallSettings.Builder<CreateSessionRequest, Operation> createSessionSettings() {
      return getStubSettingsBuilder().createSessionSettings();
    }

    /** Returns the builder for the settings used for calls to createSession. */
    public OperationCallSettings.Builder<CreateSessionRequest, Session, SessionOperationMetadata>
        createSessionOperationSettings() {
      return getStubSettingsBuilder().createSessionOperationSettings();
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

    /** Returns the builder for the settings used for calls to terminateSession. */
    public UnaryCallSettings.Builder<TerminateSessionRequest, Operation>
        terminateSessionSettings() {
      return getStubSettingsBuilder().terminateSessionSettings();
    }

    /** Returns the builder for the settings used for calls to terminateSession. */
    public OperationCallSettings.Builder<TerminateSessionRequest, Session, SessionOperationMetadata>
        terminateSessionOperationSettings() {
      return getStubSettingsBuilder().terminateSessionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSession. */
    public UnaryCallSettings.Builder<DeleteSessionRequest, Operation> deleteSessionSettings() {
      return getStubSettingsBuilder().deleteSessionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSession. */
    public OperationCallSettings.Builder<DeleteSessionRequest, Session, SessionOperationMetadata>
        deleteSessionOperationSettings() {
      return getStubSettingsBuilder().deleteSessionOperationSettings();
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
    public SessionControllerSettings build() throws IOException {
      return new SessionControllerSettings(this);
    }
  }
}

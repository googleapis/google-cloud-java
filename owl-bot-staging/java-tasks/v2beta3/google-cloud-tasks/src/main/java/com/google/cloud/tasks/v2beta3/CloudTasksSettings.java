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

package com.google.cloud.tasks.v2beta3;

import static com.google.cloud.tasks.v2beta3.CloudTasksClient.ListQueuesPagedResponse;
import static com.google.cloud.tasks.v2beta3.CloudTasksClient.ListTasksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.tasks.v2beta3.stub.CloudTasksStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudTasksClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudtasks.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getQueue to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudTasksSettings.Builder cloudTasksSettingsBuilder = CloudTasksSettings.newBuilder();
 * cloudTasksSettingsBuilder
 *     .getQueueSettings()
 *     .setRetrySettings(
 *         cloudTasksSettingsBuilder
 *             .getQueueSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudTasksSettings cloudTasksSettings = cloudTasksSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudTasksSettings extends ClientSettings<CloudTasksSettings> {

  /** Returns the object with the settings used for calls to listQueues. */
  public PagedCallSettings<ListQueuesRequest, ListQueuesResponse, ListQueuesPagedResponse>
      listQueuesSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).listQueuesSettings();
  }

  /** Returns the object with the settings used for calls to getQueue. */
  public UnaryCallSettings<GetQueueRequest, Queue> getQueueSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).getQueueSettings();
  }

  /** Returns the object with the settings used for calls to createQueue. */
  public UnaryCallSettings<CreateQueueRequest, Queue> createQueueSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).createQueueSettings();
  }

  /** Returns the object with the settings used for calls to updateQueue. */
  public UnaryCallSettings<UpdateQueueRequest, Queue> updateQueueSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).updateQueueSettings();
  }

  /** Returns the object with the settings used for calls to deleteQueue. */
  public UnaryCallSettings<DeleteQueueRequest, Empty> deleteQueueSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).deleteQueueSettings();
  }

  /** Returns the object with the settings used for calls to purgeQueue. */
  public UnaryCallSettings<PurgeQueueRequest, Queue> purgeQueueSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).purgeQueueSettings();
  }

  /** Returns the object with the settings used for calls to pauseQueue. */
  public UnaryCallSettings<PauseQueueRequest, Queue> pauseQueueSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).pauseQueueSettings();
  }

  /** Returns the object with the settings used for calls to resumeQueue. */
  public UnaryCallSettings<ResumeQueueRequest, Queue> resumeQueueSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).resumeQueueSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((CloudTasksStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((CloudTasksStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to listTasks. */
  public PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).listTasksSettings();
  }

  /** Returns the object with the settings used for calls to getTask. */
  public UnaryCallSettings<GetTaskRequest, Task> getTaskSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).getTaskSettings();
  }

  /** Returns the object with the settings used for calls to createTask. */
  public UnaryCallSettings<CreateTaskRequest, Task> createTaskSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).createTaskSettings();
  }

  /** Returns the object with the settings used for calls to deleteTask. */
  public UnaryCallSettings<DeleteTaskRequest, Empty> deleteTaskSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).deleteTaskSettings();
  }

  /** Returns the object with the settings used for calls to runTask. */
  public UnaryCallSettings<RunTaskRequest, Task> runTaskSettings() {
    return ((CloudTasksStubSettings) getStubSettings()).runTaskSettings();
  }

  public static final CloudTasksSettings create(CloudTasksStubSettings stub) throws IOException {
    return new CloudTasksSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudTasksStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudTasksStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudTasksStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudTasksStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudTasksStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudTasksStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudTasksStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudTasksStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudTasksSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudTasksSettings. */
  public static class Builder extends ClientSettings.Builder<CloudTasksSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudTasksStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudTasksSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudTasksStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudTasksStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CloudTasksStubSettings.newHttpJsonBuilder());
    }

    public CloudTasksStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudTasksStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listQueues. */
    public PagedCallSettings.Builder<ListQueuesRequest, ListQueuesResponse, ListQueuesPagedResponse>
        listQueuesSettings() {
      return getStubSettingsBuilder().listQueuesSettings();
    }

    /** Returns the builder for the settings used for calls to getQueue. */
    public UnaryCallSettings.Builder<GetQueueRequest, Queue> getQueueSettings() {
      return getStubSettingsBuilder().getQueueSettings();
    }

    /** Returns the builder for the settings used for calls to createQueue. */
    public UnaryCallSettings.Builder<CreateQueueRequest, Queue> createQueueSettings() {
      return getStubSettingsBuilder().createQueueSettings();
    }

    /** Returns the builder for the settings used for calls to updateQueue. */
    public UnaryCallSettings.Builder<UpdateQueueRequest, Queue> updateQueueSettings() {
      return getStubSettingsBuilder().updateQueueSettings();
    }

    /** Returns the builder for the settings used for calls to deleteQueue. */
    public UnaryCallSettings.Builder<DeleteQueueRequest, Empty> deleteQueueSettings() {
      return getStubSettingsBuilder().deleteQueueSettings();
    }

    /** Returns the builder for the settings used for calls to purgeQueue. */
    public UnaryCallSettings.Builder<PurgeQueueRequest, Queue> purgeQueueSettings() {
      return getStubSettingsBuilder().purgeQueueSettings();
    }

    /** Returns the builder for the settings used for calls to pauseQueue. */
    public UnaryCallSettings.Builder<PauseQueueRequest, Queue> pauseQueueSettings() {
      return getStubSettingsBuilder().pauseQueueSettings();
    }

    /** Returns the builder for the settings used for calls to resumeQueue. */
    public UnaryCallSettings.Builder<ResumeQueueRequest, Queue> resumeQueueSettings() {
      return getStubSettingsBuilder().resumeQueueSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to listTasks. */
    public PagedCallSettings.Builder<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings() {
      return getStubSettingsBuilder().listTasksSettings();
    }

    /** Returns the builder for the settings used for calls to getTask. */
    public UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings() {
      return getStubSettingsBuilder().getTaskSettings();
    }

    /** Returns the builder for the settings used for calls to createTask. */
    public UnaryCallSettings.Builder<CreateTaskRequest, Task> createTaskSettings() {
      return getStubSettingsBuilder().createTaskSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTask. */
    public UnaryCallSettings.Builder<DeleteTaskRequest, Empty> deleteTaskSettings() {
      return getStubSettingsBuilder().deleteTaskSettings();
    }

    /** Returns the builder for the settings used for calls to runTask. */
    public UnaryCallSettings.Builder<RunTaskRequest, Task> runTaskSettings() {
      return getStubSettingsBuilder().runTaskSettings();
    }

    @Override
    public CloudTasksSettings build() throws IOException {
      return new CloudTasksSettings(this);
    }
  }
}

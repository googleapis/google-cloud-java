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

package com.google.cloud.functions.v2;

import static com.google.cloud.functions.v2.FunctionServiceClient.ListFunctionsPagedResponse;
import static com.google.cloud.functions.v2.FunctionServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.functions.v2.stub.FunctionServiceStubSettings;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
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
 * Settings class to configure an instance of {@link FunctionServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudfunctions.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFunction to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FunctionServiceSettings.Builder functionServiceSettingsBuilder =
 *     FunctionServiceSettings.newBuilder();
 * functionServiceSettingsBuilder
 *     .getFunctionSettings()
 *     .setRetrySettings(
 *         functionServiceSettingsBuilder.getFunctionSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FunctionServiceSettings functionServiceSettings = functionServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FunctionServiceSettings extends ClientSettings<FunctionServiceSettings> {

  /** Returns the object with the settings used for calls to getFunction. */
  public UnaryCallSettings<GetFunctionRequest, Function> getFunctionSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).getFunctionSettings();
  }

  /** Returns the object with the settings used for calls to listFunctions. */
  public PagedCallSettings<ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
      listFunctionsSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).listFunctionsSettings();
  }

  /** Returns the object with the settings used for calls to createFunction. */
  public UnaryCallSettings<CreateFunctionRequest, Operation> createFunctionSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).createFunctionSettings();
  }

  /** Returns the object with the settings used for calls to createFunction. */
  public OperationCallSettings<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).createFunctionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateFunction. */
  public UnaryCallSettings<UpdateFunctionRequest, Operation> updateFunctionSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).updateFunctionSettings();
  }

  /** Returns the object with the settings used for calls to updateFunction. */
  public OperationCallSettings<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).updateFunctionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFunction. */
  public UnaryCallSettings<DeleteFunctionRequest, Operation> deleteFunctionSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).deleteFunctionSettings();
  }

  /** Returns the object with the settings used for calls to deleteFunction. */
  public OperationCallSettings<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).deleteFunctionOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateUploadUrl. */
  public UnaryCallSettings<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).generateUploadUrlSettings();
  }

  /** Returns the object with the settings used for calls to generateDownloadUrl. */
  public UnaryCallSettings<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).generateDownloadUrlSettings();
  }

  /** Returns the object with the settings used for calls to listRuntimes. */
  public UnaryCallSettings<ListRuntimesRequest, ListRuntimesResponse> listRuntimesSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).listRuntimesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((FunctionServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final FunctionServiceSettings create(FunctionServiceStubSettings stub)
      throws IOException {
    return new FunctionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FunctionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FunctionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FunctionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FunctionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FunctionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return FunctionServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FunctionServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FunctionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FunctionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FunctionServiceSettings. */
  public static class Builder extends ClientSettings.Builder<FunctionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FunctionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(FunctionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FunctionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FunctionServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(FunctionServiceStubSettings.newHttpJsonBuilder());
    }

    public FunctionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((FunctionServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getFunction. */
    public UnaryCallSettings.Builder<GetFunctionRequest, Function> getFunctionSettings() {
      return getStubSettingsBuilder().getFunctionSettings();
    }

    /** Returns the builder for the settings used for calls to listFunctions. */
    public PagedCallSettings.Builder<
            ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
        listFunctionsSettings() {
      return getStubSettingsBuilder().listFunctionsSettings();
    }

    /** Returns the builder for the settings used for calls to createFunction. */
    public UnaryCallSettings.Builder<CreateFunctionRequest, Operation> createFunctionSettings() {
      return getStubSettingsBuilder().createFunctionSettings();
    }

    /** Returns the builder for the settings used for calls to createFunction. */
    public OperationCallSettings.Builder<CreateFunctionRequest, Function, OperationMetadata>
        createFunctionOperationSettings() {
      return getStubSettingsBuilder().createFunctionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFunction. */
    public UnaryCallSettings.Builder<UpdateFunctionRequest, Operation> updateFunctionSettings() {
      return getStubSettingsBuilder().updateFunctionSettings();
    }

    /** Returns the builder for the settings used for calls to updateFunction. */
    public OperationCallSettings.Builder<UpdateFunctionRequest, Function, OperationMetadata>
        updateFunctionOperationSettings() {
      return getStubSettingsBuilder().updateFunctionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFunction. */
    public UnaryCallSettings.Builder<DeleteFunctionRequest, Operation> deleteFunctionSettings() {
      return getStubSettingsBuilder().deleteFunctionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFunction. */
    public OperationCallSettings.Builder<DeleteFunctionRequest, Empty, OperationMetadata>
        deleteFunctionOperationSettings() {
      return getStubSettingsBuilder().deleteFunctionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateUploadUrl. */
    public UnaryCallSettings.Builder<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
        generateUploadUrlSettings() {
      return getStubSettingsBuilder().generateUploadUrlSettings();
    }

    /** Returns the builder for the settings used for calls to generateDownloadUrl. */
    public UnaryCallSettings.Builder<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
        generateDownloadUrlSettings() {
      return getStubSettingsBuilder().generateDownloadUrlSettings();
    }

    /** Returns the builder for the settings used for calls to listRuntimes. */
    public UnaryCallSettings.Builder<ListRuntimesRequest, ListRuntimesResponse>
        listRuntimesSettings() {
      return getStubSettingsBuilder().listRuntimesSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
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
    public FunctionServiceSettings build() throws IOException {
      return new FunctionServiceSettings(this);
    }
  }
}

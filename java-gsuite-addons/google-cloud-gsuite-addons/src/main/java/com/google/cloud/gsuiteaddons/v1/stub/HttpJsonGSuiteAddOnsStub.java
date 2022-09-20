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

package com.google.cloud.gsuiteaddons.v1.stub;

import static com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsClient.ListDeploymentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gsuiteaddons.v1.Authorization;
import com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.Deployment;
import com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest;
import com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest;
import com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.InstallStatus;
import com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest;
import com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse;
import com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GSuiteAddOns service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGSuiteAddOnsStub extends GSuiteAddOnsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAuthorizationRequest, Authorization>
      getAuthorizationMethodDescriptor =
          ApiMethodDescriptor.<GetAuthorizationRequest, Authorization>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/GetAuthorization")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAuthorizationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/authorization}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthorizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthorizationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Authorization>newBuilder()
                      .setDefaultInstance(Authorization.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDeploymentRequest, Deployment>
      createDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreateDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/CreateDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deploymentId", request.getDeploymentId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReplaceDeploymentRequest, Deployment>
      replaceDeploymentMethodDescriptor =
          ApiMethodDescriptor.<ReplaceDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/ReplaceDeployment")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReplaceDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{deployment.name=projects/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "deployment.name", request.getDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/GetDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          ApiMethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/ListDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDeploymentRequest, Empty>
      deleteDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeploymentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/DeleteDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InstallDeploymentRequest, Empty>
      installDeploymentMethodDescriptor =
          ApiMethodDescriptor.<InstallDeploymentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/InstallDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InstallDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/deployments/*}:install",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InstallDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InstallDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UninstallDeploymentRequest, Empty>
      uninstallDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UninstallDeploymentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/UninstallDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UninstallDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/deployments/*}:uninstall",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UninstallDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UninstallDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstallStatusRequest, InstallStatus>
      getInstallStatusMethodDescriptor =
          ApiMethodDescriptor.<GetInstallStatusRequest, InstallStatus>newBuilder()
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/GetInstallStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstallStatusRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/deployments/*/installStatus}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstallStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstallStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstallStatus>newBuilder()
                      .setDefaultInstance(InstallStatus.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable;
  private final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable;
  private final UnaryCallable<ReplaceDeploymentRequest, Deployment> replaceDeploymentCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable;
  private final UnaryCallable<InstallDeploymentRequest, Empty> installDeploymentCallable;
  private final UnaryCallable<UninstallDeploymentRequest, Empty> uninstallDeploymentCallable;
  private final UnaryCallable<GetInstallStatusRequest, InstallStatus> getInstallStatusCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGSuiteAddOnsStub create(GSuiteAddOnsStubSettings settings)
      throws IOException {
    return new HttpJsonGSuiteAddOnsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGSuiteAddOnsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGSuiteAddOnsStub(
        GSuiteAddOnsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGSuiteAddOnsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGSuiteAddOnsStub(
        GSuiteAddOnsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGSuiteAddOnsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonGSuiteAddOnsStub(GSuiteAddOnsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGSuiteAddOnsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGSuiteAddOnsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonGSuiteAddOnsStub(
      GSuiteAddOnsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAuthorizationRequest, Authorization> getAuthorizationTransportSettings =
        HttpJsonCallSettings.<GetAuthorizationRequest, Authorization>newBuilder()
            .setMethodDescriptor(getAuthorizationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateDeploymentRequest, Deployment> createDeploymentTransportSettings =
        HttpJsonCallSettings.<CreateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ReplaceDeploymentRequest, Deployment> replaceDeploymentTransportSettings =
        HttpJsonCallSettings.<ReplaceDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(replaceDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        HttpJsonCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            HttpJsonCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentTransportSettings =
        HttpJsonCallSettings.<DeleteDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InstallDeploymentRequest, Empty> installDeploymentTransportSettings =
        HttpJsonCallSettings.<InstallDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(installDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UninstallDeploymentRequest, Empty> uninstallDeploymentTransportSettings =
        HttpJsonCallSettings.<UninstallDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(uninstallDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetInstallStatusRequest, InstallStatus> getInstallStatusTransportSettings =
        HttpJsonCallSettings.<GetInstallStatusRequest, InstallStatus>newBuilder()
            .setMethodDescriptor(getInstallStatusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getAuthorizationCallable =
        callableFactory.createUnaryCallable(
            getAuthorizationTransportSettings, settings.getAuthorizationSettings(), clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.replaceDeploymentCallable =
        callableFactory.createUnaryCallable(
            replaceDeploymentTransportSettings,
            settings.replaceDeploymentSettings(),
            clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.deleteDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentTransportSettings, settings.deleteDeploymentSettings(), clientContext);
    this.installDeploymentCallable =
        callableFactory.createUnaryCallable(
            installDeploymentTransportSettings,
            settings.installDeploymentSettings(),
            clientContext);
    this.uninstallDeploymentCallable =
        callableFactory.createUnaryCallable(
            uninstallDeploymentTransportSettings,
            settings.uninstallDeploymentSettings(),
            clientContext);
    this.getInstallStatusCallable =
        callableFactory.createUnaryCallable(
            getInstallStatusTransportSettings, settings.getInstallStatusSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAuthorizationMethodDescriptor);
    methodDescriptors.add(createDeploymentMethodDescriptor);
    methodDescriptors.add(replaceDeploymentMethodDescriptor);
    methodDescriptors.add(getDeploymentMethodDescriptor);
    methodDescriptors.add(listDeploymentsMethodDescriptor);
    methodDescriptors.add(deleteDeploymentMethodDescriptor);
    methodDescriptors.add(installDeploymentMethodDescriptor);
    methodDescriptors.add(uninstallDeploymentMethodDescriptor);
    methodDescriptors.add(getInstallStatusMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable() {
    return getAuthorizationCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public UnaryCallable<ReplaceDeploymentRequest, Deployment> replaceDeploymentCallable() {
    return replaceDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return deleteDeploymentCallable;
  }

  @Override
  public UnaryCallable<InstallDeploymentRequest, Empty> installDeploymentCallable() {
    return installDeploymentCallable;
  }

  @Override
  public UnaryCallable<UninstallDeploymentRequest, Empty> uninstallDeploymentCallable() {
    return uninstallDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetInstallStatusRequest, InstallStatus> getInstallStatusCallable() {
    return getInstallStatusCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}

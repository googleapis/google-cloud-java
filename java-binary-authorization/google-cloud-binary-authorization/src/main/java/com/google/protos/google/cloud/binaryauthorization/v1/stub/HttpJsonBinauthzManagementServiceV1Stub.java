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

package com.google.protos.google.cloud.binaryauthorization.v1.stub;

import static com.google.protos.google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1Client.ListAttestorsPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.protos.google.cloud.binaryauthorization.v1.Resources;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the BinauthzManagementServiceV1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonBinauthzManagementServiceV1Stub extends BinauthzManagementServiceV1Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<Service.GetPolicyRequest, Resources.Policy>
      getPolicyMethodDescriptor =
          ApiMethodDescriptor.<Service.GetPolicyRequest, Resources.Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/GetPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<Service.GetPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/policy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.GetPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.GetPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Resources.Policy>newBuilder()
                      .setDefaultInstance(Resources.Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<Service.UpdatePolicyRequest, Resources.Policy>
      updatePolicyMethodDescriptor =
          ApiMethodDescriptor.<Service.UpdatePolicyRequest, Resources.Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/UpdatePolicy")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<Service.UpdatePolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{policy.name=projects/*/policy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.UpdatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "policy.name", request.getPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.UpdatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Resources.Policy>newBuilder()
                      .setDefaultInstance(Resources.Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<Service.CreateAttestorRequest, Resources.Attestor>
      createAttestorMethodDescriptor =
          ApiMethodDescriptor.<Service.CreateAttestorRequest, Resources.Attestor>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/CreateAttestor")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<Service.CreateAttestorRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/attestors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.CreateAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.CreateAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "attestorId", request.getAttestorId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("attestor", request.getAttestor(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Resources.Attestor>newBuilder()
                      .setDefaultInstance(Resources.Attestor.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<Service.GetAttestorRequest, Resources.Attestor>
      getAttestorMethodDescriptor =
          ApiMethodDescriptor.<Service.GetAttestorRequest, Resources.Attestor>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/GetAttestor")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<Service.GetAttestorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/attestors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.GetAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.GetAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Resources.Attestor>newBuilder()
                      .setDefaultInstance(Resources.Attestor.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<Service.UpdateAttestorRequest, Resources.Attestor>
      updateAttestorMethodDescriptor =
          ApiMethodDescriptor.<Service.UpdateAttestorRequest, Resources.Attestor>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/UpdateAttestor")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<Service.UpdateAttestorRequest>newBuilder()
                      .setPath(
                          "/v1/{attestor.name=projects/*/attestors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.UpdateAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "attestor.name", request.getAttestor().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.UpdateAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("attestor", request.getAttestor(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Resources.Attestor>newBuilder()
                      .setDefaultInstance(Resources.Attestor.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          Service.ListAttestorsRequest, Service.ListAttestorsResponse>
      listAttestorsMethodDescriptor =
          ApiMethodDescriptor
              .<Service.ListAttestorsRequest, Service.ListAttestorsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/ListAttestors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<Service.ListAttestorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/attestors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.ListAttestorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.ListAttestorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Service.ListAttestorsResponse>newBuilder()
                      .setDefaultInstance(Service.ListAttestorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<Service.DeleteAttestorRequest, Empty>
      deleteAttestorMethodDescriptor =
          ApiMethodDescriptor.<Service.DeleteAttestorRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/DeleteAttestor")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<Service.DeleteAttestorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/attestors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<Service.DeleteAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<Service.DeleteAttestorRequest> serializer =
                                ProtoRestSerializer.create();
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

  private final UnaryCallable<Service.GetPolicyRequest, Resources.Policy> getPolicyCallable;
  private final UnaryCallable<Service.UpdatePolicyRequest, Resources.Policy> updatePolicyCallable;
  private final UnaryCallable<Service.CreateAttestorRequest, Resources.Attestor>
      createAttestorCallable;
  private final UnaryCallable<Service.GetAttestorRequest, Resources.Attestor> getAttestorCallable;
  private final UnaryCallable<Service.UpdateAttestorRequest, Resources.Attestor>
      updateAttestorCallable;
  private final UnaryCallable<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
      listAttestorsCallable;
  private final UnaryCallable<Service.ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable;
  private final UnaryCallable<Service.DeleteAttestorRequest, Empty> deleteAttestorCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBinauthzManagementServiceV1Stub create(
      BinauthzManagementServiceV1StubSettings settings) throws IOException {
    return new HttpJsonBinauthzManagementServiceV1Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBinauthzManagementServiceV1Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBinauthzManagementServiceV1Stub(
        BinauthzManagementServiceV1StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBinauthzManagementServiceV1Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBinauthzManagementServiceV1Stub(
        BinauthzManagementServiceV1StubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBinauthzManagementServiceV1Stub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonBinauthzManagementServiceV1Stub(
      BinauthzManagementServiceV1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonBinauthzManagementServiceV1CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBinauthzManagementServiceV1Stub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonBinauthzManagementServiceV1Stub(
      BinauthzManagementServiceV1StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<Service.GetPolicyRequest, Resources.Policy> getPolicyTransportSettings =
        HttpJsonCallSettings.<Service.GetPolicyRequest, Resources.Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<Service.UpdatePolicyRequest, Resources.Policy>
        updatePolicyTransportSettings =
            HttpJsonCallSettings.<Service.UpdatePolicyRequest, Resources.Policy>newBuilder()
                .setMethodDescriptor(updatePolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<Service.CreateAttestorRequest, Resources.Attestor>
        createAttestorTransportSettings =
            HttpJsonCallSettings.<Service.CreateAttestorRequest, Resources.Attestor>newBuilder()
                .setMethodDescriptor(createAttestorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<Service.GetAttestorRequest, Resources.Attestor>
        getAttestorTransportSettings =
            HttpJsonCallSettings.<Service.GetAttestorRequest, Resources.Attestor>newBuilder()
                .setMethodDescriptor(getAttestorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<Service.UpdateAttestorRequest, Resources.Attestor>
        updateAttestorTransportSettings =
            HttpJsonCallSettings.<Service.UpdateAttestorRequest, Resources.Attestor>newBuilder()
                .setMethodDescriptor(updateAttestorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
        listAttestorsTransportSettings =
            HttpJsonCallSettings
                .<Service.ListAttestorsRequest, Service.ListAttestorsResponse>newBuilder()
                .setMethodDescriptor(listAttestorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<Service.DeleteAttestorRequest, Empty> deleteAttestorTransportSettings =
        HttpJsonCallSettings.<Service.DeleteAttestorRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAttestorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getPolicyCallable =
        callableFactory.createUnaryCallable(
            getPolicyTransportSettings, settings.getPolicySettings(), clientContext);
    this.updatePolicyCallable =
        callableFactory.createUnaryCallable(
            updatePolicyTransportSettings, settings.updatePolicySettings(), clientContext);
    this.createAttestorCallable =
        callableFactory.createUnaryCallable(
            createAttestorTransportSettings, settings.createAttestorSettings(), clientContext);
    this.getAttestorCallable =
        callableFactory.createUnaryCallable(
            getAttestorTransportSettings, settings.getAttestorSettings(), clientContext);
    this.updateAttestorCallable =
        callableFactory.createUnaryCallable(
            updateAttestorTransportSettings, settings.updateAttestorSettings(), clientContext);
    this.listAttestorsCallable =
        callableFactory.createUnaryCallable(
            listAttestorsTransportSettings, settings.listAttestorsSettings(), clientContext);
    this.listAttestorsPagedCallable =
        callableFactory.createPagedCallable(
            listAttestorsTransportSettings, settings.listAttestorsSettings(), clientContext);
    this.deleteAttestorCallable =
        callableFactory.createUnaryCallable(
            deleteAttestorTransportSettings, settings.deleteAttestorSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getPolicyMethodDescriptor);
    methodDescriptors.add(updatePolicyMethodDescriptor);
    methodDescriptors.add(createAttestorMethodDescriptor);
    methodDescriptors.add(getAttestorMethodDescriptor);
    methodDescriptors.add(updateAttestorMethodDescriptor);
    methodDescriptors.add(listAttestorsMethodDescriptor);
    methodDescriptors.add(deleteAttestorMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<Service.GetPolicyRequest, Resources.Policy> getPolicyCallable() {
    return getPolicyCallable;
  }

  @Override
  public UnaryCallable<Service.UpdatePolicyRequest, Resources.Policy> updatePolicyCallable() {
    return updatePolicyCallable;
  }

  @Override
  public UnaryCallable<Service.CreateAttestorRequest, Resources.Attestor> createAttestorCallable() {
    return createAttestorCallable;
  }

  @Override
  public UnaryCallable<Service.GetAttestorRequest, Resources.Attestor> getAttestorCallable() {
    return getAttestorCallable;
  }

  @Override
  public UnaryCallable<Service.UpdateAttestorRequest, Resources.Attestor> updateAttestorCallable() {
    return updateAttestorCallable;
  }

  @Override
  public UnaryCallable<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
      listAttestorsCallable() {
    return listAttestorsCallable;
  }

  @Override
  public UnaryCallable<Service.ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable() {
    return listAttestorsPagedCallable;
  }

  @Override
  public UnaryCallable<Service.DeleteAttestorRequest, Empty> deleteAttestorCallable() {
    return deleteAttestorCallable;
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

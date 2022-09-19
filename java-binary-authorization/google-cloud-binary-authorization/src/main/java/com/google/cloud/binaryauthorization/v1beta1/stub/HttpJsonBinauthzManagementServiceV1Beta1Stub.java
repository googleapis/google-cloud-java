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

package com.google.cloud.binaryauthorization.v1beta1.stub;

import static com.google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1Client.ListAttestorsPagedResponse;

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
import com.google.cloud.binaryauthorization.v1beta1.Attestor;
import com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest;
import com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest;
import com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse;
import com.google.cloud.binaryauthorization.v1beta1.Policy;
import com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest;
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
 * REST stub implementation for the BinauthzManagementServiceV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonBinauthzManagementServiceV1Beta1Stub
    extends BinauthzManagementServiceV1Beta1Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetPolicyRequest, Policy> getPolicyMethodDescriptor =
      ApiMethodDescriptor.<GetPolicyRequest, Policy>newBuilder()
          .setFullMethodName(
              "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/GetPolicy")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPolicyRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/policy}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPolicyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPolicyRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Policy>newBuilder()
                  .setDefaultInstance(Policy.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdatePolicyRequest, Policy>
      updatePolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdatePolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/UpdatePolicy")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{policy.name=projects/*/policy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "policy.name", request.getPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("policy", request.getPolicy(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAttestorRequest, Attestor>
      createAttestorMethodDescriptor =
          ApiMethodDescriptor.<CreateAttestorRequest, Attestor>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/CreateAttestor")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAttestorRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/attestors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAttestorRequest> serializer =
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
                  ProtoMessageResponseParser.<Attestor>newBuilder()
                      .setDefaultInstance(Attestor.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAttestorRequest, Attestor>
      getAttestorMethodDescriptor =
          ApiMethodDescriptor.<GetAttestorRequest, Attestor>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/GetAttestor")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAttestorRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/attestors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Attestor>newBuilder()
                      .setDefaultInstance(Attestor.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAttestorRequest, Attestor>
      updateAttestorMethodDescriptor =
          ApiMethodDescriptor.<UpdateAttestorRequest, Attestor>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/UpdateAttestor")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAttestorRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{attestor.name=projects/*/attestors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "attestor.name", request.getAttestor().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("attestor", request.getAttestor(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Attestor>newBuilder()
                      .setDefaultInstance(Attestor.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAttestorsRequest, ListAttestorsResponse>
      listAttestorsMethodDescriptor =
          ApiMethodDescriptor.<ListAttestorsRequest, ListAttestorsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/ListAttestors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAttestorsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/attestors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttestorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttestorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAttestorsResponse>newBuilder()
                      .setDefaultInstance(ListAttestorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAttestorRequest, Empty>
      deleteAttestorMethodDescriptor =
          ApiMethodDescriptor.<DeleteAttestorRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/DeleteAttestor")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAttestorRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/attestors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAttestorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAttestorRequest> serializer =
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

  private final UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable;
  private final UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable;
  private final UnaryCallable<CreateAttestorRequest, Attestor> createAttestorCallable;
  private final UnaryCallable<GetAttestorRequest, Attestor> getAttestorCallable;
  private final UnaryCallable<UpdateAttestorRequest, Attestor> updateAttestorCallable;
  private final UnaryCallable<ListAttestorsRequest, ListAttestorsResponse> listAttestorsCallable;
  private final UnaryCallable<ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable;
  private final UnaryCallable<DeleteAttestorRequest, Empty> deleteAttestorCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBinauthzManagementServiceV1Beta1Stub create(
      BinauthzManagementServiceV1Beta1StubSettings settings) throws IOException {
    return new HttpJsonBinauthzManagementServiceV1Beta1Stub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonBinauthzManagementServiceV1Beta1Stub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonBinauthzManagementServiceV1Beta1Stub(
        BinauthzManagementServiceV1Beta1StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBinauthzManagementServiceV1Beta1Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBinauthzManagementServiceV1Beta1Stub(
        BinauthzManagementServiceV1Beta1StubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBinauthzManagementServiceV1Beta1Stub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonBinauthzManagementServiceV1Beta1Stub(
      BinauthzManagementServiceV1Beta1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonBinauthzManagementServiceV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBinauthzManagementServiceV1Beta1Stub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonBinauthzManagementServiceV1Beta1Stub(
      BinauthzManagementServiceV1Beta1StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetPolicyRequest, Policy> getPolicyTransportSettings =
        HttpJsonCallSettings.<GetPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdatePolicyRequest, Policy> updatePolicyTransportSettings =
        HttpJsonCallSettings.<UpdatePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(updatePolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateAttestorRequest, Attestor> createAttestorTransportSettings =
        HttpJsonCallSettings.<CreateAttestorRequest, Attestor>newBuilder()
            .setMethodDescriptor(createAttestorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAttestorRequest, Attestor> getAttestorTransportSettings =
        HttpJsonCallSettings.<GetAttestorRequest, Attestor>newBuilder()
            .setMethodDescriptor(getAttestorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAttestorRequest, Attestor> updateAttestorTransportSettings =
        HttpJsonCallSettings.<UpdateAttestorRequest, Attestor>newBuilder()
            .setMethodDescriptor(updateAttestorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAttestorsRequest, ListAttestorsResponse>
        listAttestorsTransportSettings =
            HttpJsonCallSettings.<ListAttestorsRequest, ListAttestorsResponse>newBuilder()
                .setMethodDescriptor(listAttestorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAttestorRequest, Empty> deleteAttestorTransportSettings =
        HttpJsonCallSettings.<DeleteAttestorRequest, Empty>newBuilder()
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
  public UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    return getPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable() {
    return updatePolicyCallable;
  }

  @Override
  public UnaryCallable<CreateAttestorRequest, Attestor> createAttestorCallable() {
    return createAttestorCallable;
  }

  @Override
  public UnaryCallable<GetAttestorRequest, Attestor> getAttestorCallable() {
    return getAttestorCallable;
  }

  @Override
  public UnaryCallable<UpdateAttestorRequest, Attestor> updateAttestorCallable() {
    return updateAttestorCallable;
  }

  @Override
  public UnaryCallable<ListAttestorsRequest, ListAttestorsResponse> listAttestorsCallable() {
    return listAttestorsCallable;
  }

  @Override
  public UnaryCallable<ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable() {
    return listAttestorsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAttestorRequest, Empty> deleteAttestorCallable() {
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

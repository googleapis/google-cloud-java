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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagKeysClient.ListTagKeysPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagKeyRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest;
import com.google.cloud.resourcemanager.v3.GetTagKeyRequest;
import com.google.cloud.resourcemanager.v3.ListTagKeysRequest;
import com.google.cloud.resourcemanager.v3.ListTagKeysResponse;
import com.google.cloud.resourcemanager.v3.TagKey;
import com.google.cloud.resourcemanager.v3.UpdateTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the TagKeys service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTagKeysStub extends TagKeysStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(TagKey.getDescriptor())
          .add(UpdateTagKeyMetadata.getDescriptor())
          .add(CreateTagKeyMetadata.getDescriptor())
          .add(DeleteTagKeyMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListTagKeysRequest, ListTagKeysResponse>
      listTagKeysMethodDescriptor =
          ApiMethodDescriptor.<ListTagKeysRequest, ListTagKeysResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/ListTagKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTagKeysRequest>newBuilder()
                      .setPath(
                          "/v3/tagKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "parent", request.getParent());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTagKeysResponse>newBuilder()
                      .setDefaultInstance(ListTagKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTagKeyRequest, TagKey> getTagKeyMethodDescriptor =
      ApiMethodDescriptor.<GetTagKeyRequest, TagKey>newBuilder()
          .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/GetTagKey")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTagKeyRequest>newBuilder()
                  .setPath(
                      "/v3/{name=tagKeys/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTagKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTagKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<TagKey>newBuilder()
                  .setDefaultInstance(TagKey.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateTagKeyRequest, Operation>
      createTagKeyMethodDescriptor =
          ApiMethodDescriptor.<CreateTagKeyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/CreateTagKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTagKeyRequest>newBuilder()
                      .setPath(
                          "/v3/tagKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagKey", request.getTagKey(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTagKeyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateTagKeyRequest, Operation>
      updateTagKeyMethodDescriptor =
          ApiMethodDescriptor.<UpdateTagKeyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/UpdateTagKey")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTagKeyRequest>newBuilder()
                      .setPath(
                          "/v3/{tagKey.name=tagKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTagKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tagKey.name", request.getTagKey().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTagKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagKey", request.getTagKey(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateTagKeyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTagKeyRequest, Operation>
      deleteTagKeyMethodDescriptor =
          ApiMethodDescriptor.<DeleteTagKeyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/DeleteTagKey")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTagKeyRequest>newBuilder()
                      .setPath(
                          "/v3/{name=tagKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteTagKeyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=tagKeys/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=tagKeys/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=tagKeys/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListTagKeysRequest, ListTagKeysResponse> listTagKeysCallable;
  private final UnaryCallable<ListTagKeysRequest, ListTagKeysPagedResponse>
      listTagKeysPagedCallable;
  private final UnaryCallable<GetTagKeyRequest, TagKey> getTagKeyCallable;
  private final UnaryCallable<CreateTagKeyRequest, Operation> createTagKeyCallable;
  private final OperationCallable<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationCallable;
  private final UnaryCallable<UpdateTagKeyRequest, Operation> updateTagKeyCallable;
  private final OperationCallable<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationCallable;
  private final UnaryCallable<DeleteTagKeyRequest, Operation> deleteTagKeyCallable;
  private final OperationCallable<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTagKeysStub create(TagKeysStubSettings settings) throws IOException {
    return new HttpJsonTagKeysStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTagKeysStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonTagKeysStub(TagKeysStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTagKeysStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTagKeysStub(
        TagKeysStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTagKeysStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTagKeysStub(TagKeysStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTagKeysCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTagKeysStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTagKeysStub(
      TagKeysStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListTagKeysRequest, ListTagKeysResponse> listTagKeysTransportSettings =
        HttpJsonCallSettings.<ListTagKeysRequest, ListTagKeysResponse>newBuilder()
            .setMethodDescriptor(listTagKeysMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTagKeyRequest, TagKey> getTagKeyTransportSettings =
        HttpJsonCallSettings.<GetTagKeyRequest, TagKey>newBuilder()
            .setMethodDescriptor(getTagKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateTagKeyRequest, Operation> createTagKeyTransportSettings =
        HttpJsonCallSettings.<CreateTagKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(createTagKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTagKeyRequest, Operation> updateTagKeyTransportSettings =
        HttpJsonCallSettings.<UpdateTagKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTagKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTagKeyRequest, Operation> deleteTagKeyTransportSettings =
        HttpJsonCallSettings.<DeleteTagKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTagKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listTagKeysCallable =
        callableFactory.createUnaryCallable(
            listTagKeysTransportSettings, settings.listTagKeysSettings(), clientContext);
    this.listTagKeysPagedCallable =
        callableFactory.createPagedCallable(
            listTagKeysTransportSettings, settings.listTagKeysSettings(), clientContext);
    this.getTagKeyCallable =
        callableFactory.createUnaryCallable(
            getTagKeyTransportSettings, settings.getTagKeySettings(), clientContext);
    this.createTagKeyCallable =
        callableFactory.createUnaryCallable(
            createTagKeyTransportSettings, settings.createTagKeySettings(), clientContext);
    this.createTagKeyOperationCallable =
        callableFactory.createOperationCallable(
            createTagKeyTransportSettings,
            settings.createTagKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateTagKeyCallable =
        callableFactory.createUnaryCallable(
            updateTagKeyTransportSettings, settings.updateTagKeySettings(), clientContext);
    this.updateTagKeyOperationCallable =
        callableFactory.createOperationCallable(
            updateTagKeyTransportSettings,
            settings.updateTagKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTagKeyCallable =
        callableFactory.createUnaryCallable(
            deleteTagKeyTransportSettings, settings.deleteTagKeySettings(), clientContext);
    this.deleteTagKeyOperationCallable =
        callableFactory.createOperationCallable(
            deleteTagKeyTransportSettings,
            settings.deleteTagKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listTagKeysMethodDescriptor);
    methodDescriptors.add(getTagKeyMethodDescriptor);
    methodDescriptors.add(createTagKeyMethodDescriptor);
    methodDescriptors.add(updateTagKeyMethodDescriptor);
    methodDescriptors.add(deleteTagKeyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListTagKeysRequest, ListTagKeysResponse> listTagKeysCallable() {
    return listTagKeysCallable;
  }

  @Override
  public UnaryCallable<ListTagKeysRequest, ListTagKeysPagedResponse> listTagKeysPagedCallable() {
    return listTagKeysPagedCallable;
  }

  @Override
  public UnaryCallable<GetTagKeyRequest, TagKey> getTagKeyCallable() {
    return getTagKeyCallable;
  }

  @Override
  public UnaryCallable<CreateTagKeyRequest, Operation> createTagKeyCallable() {
    return createTagKeyCallable;
  }

  @Override
  public OperationCallable<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationCallable() {
    return createTagKeyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTagKeyRequest, Operation> updateTagKeyCallable() {
    return updateTagKeyCallable;
  }

  @Override
  public OperationCallable<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationCallable() {
    return updateTagKeyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTagKeyRequest, Operation> deleteTagKeyCallable() {
    return deleteTagKeyCallable;
  }

  @Override
  public OperationCallable<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationCallable() {
    return deleteTagKeyOperationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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

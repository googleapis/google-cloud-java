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

import static com.google.cloud.resourcemanager.v3.TagValuesClient.ListTagValuesPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagValueRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagValueMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagValueRequest;
import com.google.cloud.resourcemanager.v3.GetTagValueRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesResponse;
import com.google.cloud.resourcemanager.v3.TagValue;
import com.google.cloud.resourcemanager.v3.UpdateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagValueRequest;
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
 * REST stub implementation for the TagValues service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTagValuesStub extends TagValuesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(TagValue.getDescriptor())
          .add(CreateTagValueMetadata.getDescriptor())
          .add(UpdateTagValueMetadata.getDescriptor())
          .add(DeleteTagValueMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListTagValuesRequest, ListTagValuesResponse>
      listTagValuesMethodDescriptor =
          ApiMethodDescriptor.<ListTagValuesRequest, ListTagValuesResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/ListTagValues")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTagValuesRequest>newBuilder()
                      .setPath(
                          "/v3/tagValues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagValuesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagValuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTagValuesResponse>newBuilder()
                      .setDefaultInstance(ListTagValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTagValueRequest, TagValue>
      getTagValueMethodDescriptor =
          ApiMethodDescriptor.<GetTagValueRequest, TagValue>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/GetTagValue")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTagValueRequest>newBuilder()
                      .setPath(
                          "/v3/{name=tagValues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTagValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTagValueRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TagValue>newBuilder()
                      .setDefaultInstance(TagValue.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTagValueRequest, Operation>
      createTagValueMethodDescriptor =
          ApiMethodDescriptor.<CreateTagValueRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/CreateTagValue")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTagValueRequest>newBuilder()
                      .setPath(
                          "/v3/tagValues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagValueRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagValue", request.getTagValue(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTagValueRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateTagValueRequest, Operation>
      updateTagValueMethodDescriptor =
          ApiMethodDescriptor.<UpdateTagValueRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/UpdateTagValue")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTagValueRequest>newBuilder()
                      .setPath(
                          "/v3/{tagValue.name=tagValues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTagValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tagValue.name", request.getTagValue().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTagValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagValue", request.getTagValue(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateTagValueRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTagValueRequest, Operation>
      deleteTagValueMethodDescriptor =
          ApiMethodDescriptor.<DeleteTagValueRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/DeleteTagValue")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTagValueRequest>newBuilder()
                      .setPath(
                          "/v3/{name=tagValues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteTagValueRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=tagValues/*}:getIamPolicy",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
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
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=tagValues/*}:setIamPolicy",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
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
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v3/{resource=tagValues/*}:testIamPermissions",
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
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListTagValuesRequest, ListTagValuesResponse> listTagValuesCallable;
  private final UnaryCallable<ListTagValuesRequest, ListTagValuesPagedResponse>
      listTagValuesPagedCallable;
  private final UnaryCallable<GetTagValueRequest, TagValue> getTagValueCallable;
  private final UnaryCallable<CreateTagValueRequest, Operation> createTagValueCallable;
  private final OperationCallable<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationCallable;
  private final UnaryCallable<UpdateTagValueRequest, Operation> updateTagValueCallable;
  private final OperationCallable<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationCallable;
  private final UnaryCallable<DeleteTagValueRequest, Operation> deleteTagValueCallable;
  private final OperationCallable<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTagValuesStub create(TagValuesStubSettings settings)
      throws IOException {
    return new HttpJsonTagValuesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTagValuesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonTagValuesStub(
        TagValuesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTagValuesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTagValuesStub(
        TagValuesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTagValuesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTagValuesStub(TagValuesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTagValuesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTagValuesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTagValuesStub(
      TagValuesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListTagValuesRequest, ListTagValuesResponse>
        listTagValuesTransportSettings =
            HttpJsonCallSettings.<ListTagValuesRequest, ListTagValuesResponse>newBuilder()
                .setMethodDescriptor(listTagValuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetTagValueRequest, TagValue> getTagValueTransportSettings =
        HttpJsonCallSettings.<GetTagValueRequest, TagValue>newBuilder()
            .setMethodDescriptor(getTagValueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateTagValueRequest, Operation> createTagValueTransportSettings =
        HttpJsonCallSettings.<CreateTagValueRequest, Operation>newBuilder()
            .setMethodDescriptor(createTagValueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTagValueRequest, Operation> updateTagValueTransportSettings =
        HttpJsonCallSettings.<UpdateTagValueRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTagValueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTagValueRequest, Operation> deleteTagValueTransportSettings =
        HttpJsonCallSettings.<DeleteTagValueRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTagValueMethodDescriptor)
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

    this.listTagValuesCallable =
        callableFactory.createUnaryCallable(
            listTagValuesTransportSettings, settings.listTagValuesSettings(), clientContext);
    this.listTagValuesPagedCallable =
        callableFactory.createPagedCallable(
            listTagValuesTransportSettings, settings.listTagValuesSettings(), clientContext);
    this.getTagValueCallable =
        callableFactory.createUnaryCallable(
            getTagValueTransportSettings, settings.getTagValueSettings(), clientContext);
    this.createTagValueCallable =
        callableFactory.createUnaryCallable(
            createTagValueTransportSettings, settings.createTagValueSettings(), clientContext);
    this.createTagValueOperationCallable =
        callableFactory.createOperationCallable(
            createTagValueTransportSettings,
            settings.createTagValueOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateTagValueCallable =
        callableFactory.createUnaryCallable(
            updateTagValueTransportSettings, settings.updateTagValueSettings(), clientContext);
    this.updateTagValueOperationCallable =
        callableFactory.createOperationCallable(
            updateTagValueTransportSettings,
            settings.updateTagValueOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTagValueCallable =
        callableFactory.createUnaryCallable(
            deleteTagValueTransportSettings, settings.deleteTagValueSettings(), clientContext);
    this.deleteTagValueOperationCallable =
        callableFactory.createOperationCallable(
            deleteTagValueTransportSettings,
            settings.deleteTagValueOperationSettings(),
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
    methodDescriptors.add(listTagValuesMethodDescriptor);
    methodDescriptors.add(getTagValueMethodDescriptor);
    methodDescriptors.add(createTagValueMethodDescriptor);
    methodDescriptors.add(updateTagValueMethodDescriptor);
    methodDescriptors.add(deleteTagValueMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListTagValuesRequest, ListTagValuesResponse> listTagValuesCallable() {
    return listTagValuesCallable;
  }

  @Override
  public UnaryCallable<ListTagValuesRequest, ListTagValuesPagedResponse>
      listTagValuesPagedCallable() {
    return listTagValuesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTagValueRequest, TagValue> getTagValueCallable() {
    return getTagValueCallable;
  }

  @Override
  public UnaryCallable<CreateTagValueRequest, Operation> createTagValueCallable() {
    return createTagValueCallable;
  }

  @Override
  public OperationCallable<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationCallable() {
    return createTagValueOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTagValueRequest, Operation> updateTagValueCallable() {
    return updateTagValueCallable;
  }

  @Override
  public OperationCallable<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationCallable() {
    return updateTagValueOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTagValueRequest, Operation> deleteTagValueCallable() {
    return deleteTagValueCallable;
  }

  @Override
  public OperationCallable<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationCallable() {
    return deleteTagValueOperationCallable;
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

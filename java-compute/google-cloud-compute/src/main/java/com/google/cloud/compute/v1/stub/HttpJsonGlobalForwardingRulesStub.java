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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.GlobalForwardingRulesClient.ListPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleList;
import com.google.cloud.compute.v1.GetGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.InsertGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.ListGlobalForwardingRulesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.SetLabelsGlobalForwardingRuleRequest;
import com.google.cloud.compute.v1.SetTargetGlobalForwardingRuleRequest;
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
 * REST stub implementation for the GlobalForwardingRules service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGlobalForwardingRulesStub extends GlobalForwardingRulesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteGlobalForwardingRuleRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalForwardingRuleRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalForwardingRules/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlobalForwardingRuleRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/forwardingRules/{forwardingRule}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "forwardingRule", request.getForwardingRule());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
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
                  (DeleteGlobalForwardingRuleRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetGlobalForwardingRuleRequest, ForwardingRule>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalForwardingRuleRequest, ForwardingRule>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalForwardingRules/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalForwardingRuleRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/forwardingRules/{forwardingRule}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "forwardingRule", request.getForwardingRule());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ForwardingRule>newBuilder()
                      .setDefaultInstance(ForwardingRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertGlobalForwardingRuleRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalForwardingRuleRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalForwardingRules/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertGlobalForwardingRuleRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/forwardingRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "forwardingRuleResource",
                                      request.getForwardingRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertGlobalForwardingRuleRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListGlobalForwardingRulesRequest, ForwardingRuleList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalForwardingRulesRequest, ForwardingRuleList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalForwardingRules/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalForwardingRulesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/forwardingRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalForwardingRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalForwardingRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ForwardingRuleList>newBuilder()
                      .setDefaultInstance(ForwardingRuleList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchGlobalForwardingRuleRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchGlobalForwardingRuleRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalForwardingRules/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchGlobalForwardingRuleRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/forwardingRules/{forwardingRule}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "forwardingRule", request.getForwardingRule());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "forwardingRuleResource",
                                      request.getForwardingRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchGlobalForwardingRuleRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetLabelsGlobalForwardingRuleRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsGlobalForwardingRuleRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalForwardingRules/SetLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsGlobalForwardingRuleRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/forwardingRules/{resource}/setLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetLabelsRequestResource",
                                      request.getGlobalSetLabelsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetLabelsGlobalForwardingRuleRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetTargetGlobalForwardingRuleRequest, Operation>
      setTargetMethodDescriptor =
          ApiMethodDescriptor.<SetTargetGlobalForwardingRuleRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalForwardingRules/SetTarget")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetTargetGlobalForwardingRuleRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/forwardingRules/{forwardingRule}/setTarget",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetTargetGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "forwardingRule", request.getForwardingRule());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetTargetGlobalForwardingRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "targetReferenceResource",
                                      request.getTargetReferenceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetTargetGlobalForwardingRuleRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<DeleteGlobalForwardingRuleRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteGlobalForwardingRuleRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetGlobalForwardingRuleRequest, ForwardingRule> getCallable;
  private final UnaryCallable<InsertGlobalForwardingRuleRequest, Operation> insertCallable;
  private final OperationCallable<InsertGlobalForwardingRuleRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListGlobalForwardingRulesRequest, ForwardingRuleList> listCallable;
  private final UnaryCallable<ListGlobalForwardingRulesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchGlobalForwardingRuleRequest, Operation> patchCallable;
  private final OperationCallable<PatchGlobalForwardingRuleRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetLabelsGlobalForwardingRuleRequest, Operation> setLabelsCallable;
  private final OperationCallable<SetLabelsGlobalForwardingRuleRequest, Operation, Operation>
      setLabelsOperationCallable;
  private final UnaryCallable<SetTargetGlobalForwardingRuleRequest, Operation> setTargetCallable;
  private final OperationCallable<SetTargetGlobalForwardingRuleRequest, Operation, Operation>
      setTargetOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalForwardingRulesStub create(
      GlobalForwardingRulesStubSettings settings) throws IOException {
    return new HttpJsonGlobalForwardingRulesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalForwardingRulesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalForwardingRulesStub(
        GlobalForwardingRulesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalForwardingRulesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalForwardingRulesStub(
        GlobalForwardingRulesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalForwardingRulesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalForwardingRulesStub(
      GlobalForwardingRulesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGlobalForwardingRulesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalForwardingRulesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalForwardingRulesStub(
      GlobalForwardingRulesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteGlobalForwardingRuleRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteGlobalForwardingRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetGlobalForwardingRuleRequest, ForwardingRule> getTransportSettings =
        HttpJsonCallSettings.<GetGlobalForwardingRuleRequest, ForwardingRule>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertGlobalForwardingRuleRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertGlobalForwardingRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListGlobalForwardingRulesRequest, ForwardingRuleList>
        listTransportSettings =
            HttpJsonCallSettings.<ListGlobalForwardingRulesRequest, ForwardingRuleList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchGlobalForwardingRuleRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchGlobalForwardingRuleRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetLabelsGlobalForwardingRuleRequest, Operation>
        setLabelsTransportSettings =
            HttpJsonCallSettings.<SetLabelsGlobalForwardingRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(setLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetTargetGlobalForwardingRuleRequest, Operation>
        setTargetTransportSettings =
            HttpJsonCallSettings.<SetTargetGlobalForwardingRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(setTargetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.setLabelsOperationCallable =
        callableFactory.createOperationCallable(
            setLabelsTransportSettings,
            settings.setLabelsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setTargetCallable =
        callableFactory.createUnaryCallable(
            setTargetTransportSettings, settings.setTargetSettings(), clientContext);
    this.setTargetOperationCallable =
        callableFactory.createOperationCallable(
            setTargetTransportSettings,
            settings.setTargetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setLabelsMethodDescriptor);
    methodDescriptors.add(setTargetMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteGlobalForwardingRuleRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteGlobalForwardingRuleRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetGlobalForwardingRuleRequest, ForwardingRule> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertGlobalForwardingRuleRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertGlobalForwardingRuleRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListGlobalForwardingRulesRequest, ForwardingRuleList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListGlobalForwardingRulesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchGlobalForwardingRuleRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchGlobalForwardingRuleRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetLabelsGlobalForwardingRuleRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public OperationCallable<SetLabelsGlobalForwardingRuleRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return setLabelsOperationCallable;
  }

  @Override
  public UnaryCallable<SetTargetGlobalForwardingRuleRequest, Operation> setTargetCallable() {
    return setTargetCallable;
  }

  @Override
  public OperationCallable<SetTargetGlobalForwardingRuleRequest, Operation, Operation>
      setTargetOperationCallable() {
    return setTargetOperationCallable;
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

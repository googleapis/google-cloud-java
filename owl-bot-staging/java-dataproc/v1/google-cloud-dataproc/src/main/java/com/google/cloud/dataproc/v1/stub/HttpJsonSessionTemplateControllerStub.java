/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.SessionTemplateControllerClient.ListSessionTemplatesPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.CreateSessionTemplateRequest;
import com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest;
import com.google.cloud.dataproc.v1.GetSessionTemplateRequest;
import com.google.cloud.dataproc.v1.ListSessionTemplatesRequest;
import com.google.cloud.dataproc.v1.ListSessionTemplatesResponse;
import com.google.cloud.dataproc.v1.SessionTemplate;
import com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the SessionTemplateController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSessionTemplateControllerStub extends SessionTemplateControllerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateSessionTemplateRequest, SessionTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/CreateSessionTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSessionTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/sessionTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSessionTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSessionTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sessionTemplate", request.getSessionTemplate(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SessionTemplate>newBuilder()
                      .setDefaultInstance(SessionTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateSessionTemplateRequest, SessionTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/UpdateSessionTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSessionTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{sessionTemplate.name=projects/*/locations/*/sessionTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSessionTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "sessionTemplate.name",
                                request.getSessionTemplate().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSessionTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sessionTemplate", request.getSessionTemplate(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SessionTemplate>newBuilder()
                      .setDefaultInstance(SessionTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSessionTemplateRequest, SessionTemplate>
      getSessionTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetSessionTemplateRequest, SessionTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/GetSessionTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSessionTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sessionTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSessionTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSessionTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SessionTemplate>newBuilder()
                      .setDefaultInstance(SessionTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSessionTemplatesRequest, ListSessionTemplatesResponse>
      listSessionTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListSessionTemplatesRequest, ListSessionTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/ListSessionTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSessionTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/sessionTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSessionTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSessionTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSessionTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListSessionTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSessionTemplateRequest, Empty>
      deleteSessionTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteSessionTemplateRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/DeleteSessionTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSessionTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sessionTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSessionTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSessionTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/regions/*/clusters/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/regions/*/jobs/*}:setIamPolicy",
                          "/v1/{resource=projects/*/regions/*/operations/*}:setIamPolicy",
                          "/v1/{resource=projects/*/regions/*/workflowTemplates/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/workflowTemplates/*}:setIamPolicy",
                          "/v1/{resource=projects/*/regions/*/autoscalingPolicies/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/autoscalingPolicies/*}:setIamPolicy")
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

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/regions/*/clusters/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/regions/*/jobs/*}:getIamPolicy",
                          "/v1/{resource=projects/*/regions/*/operations/*}:getIamPolicy",
                          "/v1/{resource=projects/*/regions/*/workflowTemplates/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/workflowTemplates/*}:getIamPolicy",
                          "/v1/{resource=projects/*/regions/*/autoscalingPolicies/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/autoscalingPolicies/*}:getIamPolicy")
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/regions/*/clusters/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/regions/*/jobs/*}:testIamPermissions",
                          "/v1/{resource=projects/*/regions/*/operations/*}:testIamPermissions",
                          "/v1/{resource=projects/*/regions/*/workflowTemplates/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/workflowTemplates/*}:testIamPermissions",
                          "/v1/{resource=projects/*/regions/*/autoscalingPolicies/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/autoscalingPolicies/*}:testIamPermissions")
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

  private final UnaryCallable<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateCallable;
  private final UnaryCallable<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateCallable;
  private final UnaryCallable<GetSessionTemplateRequest, SessionTemplate>
      getSessionTemplateCallable;
  private final UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
      listSessionTemplatesCallable;
  private final UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesPagedResponse>
      listSessionTemplatesPagedCallable;
  private final UnaryCallable<DeleteSessionTemplateRequest, Empty> deleteSessionTemplateCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSessionTemplateControllerStub create(
      SessionTemplateControllerStubSettings settings) throws IOException {
    return new HttpJsonSessionTemplateControllerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSessionTemplateControllerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSessionTemplateControllerStub(
        SessionTemplateControllerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSessionTemplateControllerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSessionTemplateControllerStub(
        SessionTemplateControllerStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSessionTemplateControllerStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSessionTemplateControllerStub(
      SessionTemplateControllerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSessionTemplateControllerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSessionTemplateControllerStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSessionTemplateControllerStub(
      SessionTemplateControllerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSessionTemplateRequest, SessionTemplate>
        createSessionTemplateTransportSettings =
            HttpJsonCallSettings.<CreateSessionTemplateRequest, SessionTemplate>newBuilder()
                .setMethodDescriptor(createSessionTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSessionTemplateRequest, SessionTemplate>
        updateSessionTemplateTransportSettings =
            HttpJsonCallSettings.<UpdateSessionTemplateRequest, SessionTemplate>newBuilder()
                .setMethodDescriptor(updateSessionTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "session_template.name",
                          String.valueOf(request.getSessionTemplate().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSessionTemplateRequest, SessionTemplate>
        getSessionTemplateTransportSettings =
            HttpJsonCallSettings.<GetSessionTemplateRequest, SessionTemplate>newBuilder()
                .setMethodDescriptor(getSessionTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
        listSessionTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListSessionTemplatesRequest, ListSessionTemplatesResponse>newBuilder()
                .setMethodDescriptor(listSessionTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSessionTemplateRequest, Empty>
        deleteSessionTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteSessionTemplateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSessionTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createSessionTemplateCallable =
        callableFactory.createUnaryCallable(
            createSessionTemplateTransportSettings,
            settings.createSessionTemplateSettings(),
            clientContext);
    this.updateSessionTemplateCallable =
        callableFactory.createUnaryCallable(
            updateSessionTemplateTransportSettings,
            settings.updateSessionTemplateSettings(),
            clientContext);
    this.getSessionTemplateCallable =
        callableFactory.createUnaryCallable(
            getSessionTemplateTransportSettings,
            settings.getSessionTemplateSettings(),
            clientContext);
    this.listSessionTemplatesCallable =
        callableFactory.createUnaryCallable(
            listSessionTemplatesTransportSettings,
            settings.listSessionTemplatesSettings(),
            clientContext);
    this.listSessionTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listSessionTemplatesTransportSettings,
            settings.listSessionTemplatesSettings(),
            clientContext);
    this.deleteSessionTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteSessionTemplateTransportSettings,
            settings.deleteSessionTemplateSettings(),
            clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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
    methodDescriptors.add(createSessionTemplateMethodDescriptor);
    methodDescriptors.add(updateSessionTemplateMethodDescriptor);
    methodDescriptors.add(getSessionTemplateMethodDescriptor);
    methodDescriptors.add(listSessionTemplatesMethodDescriptor);
    methodDescriptors.add(deleteSessionTemplateMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateCallable() {
    return createSessionTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateCallable() {
    return updateSessionTemplateCallable;
  }

  @Override
  public UnaryCallable<GetSessionTemplateRequest, SessionTemplate> getSessionTemplateCallable() {
    return getSessionTemplateCallable;
  }

  @Override
  public UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
      listSessionTemplatesCallable() {
    return listSessionTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesPagedResponse>
      listSessionTemplatesPagedCallable() {
    return listSessionTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionTemplateRequest, Empty> deleteSessionTemplateCallable() {
    return deleteSessionTemplateCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
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

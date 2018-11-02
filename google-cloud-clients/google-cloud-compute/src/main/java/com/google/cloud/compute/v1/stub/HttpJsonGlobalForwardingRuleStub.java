/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.GlobalForwardingRuleClient.ListGlobalForwardingRulesPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMessageHttpRequestFormatter;
import com.google.api.gax.httpjson.ApiMessageHttpResponseParser;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.DeleteGlobalForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleList;
import com.google.cloud.compute.v1.GetGlobalForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.InsertGlobalForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.ListGlobalForwardingRulesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalForwardingRuleName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SetTargetGlobalForwardingRuleHttpRequest;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * HTTP stub implementation for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonGlobalForwardingRuleStub extends GlobalForwardingRuleStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteGlobalForwardingRuleHttpRequest, Operation>
      deleteGlobalForwardingRuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalForwardingRuleHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalForwardingRules.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteGlobalForwardingRuleHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/forwardingRules/{forwardingRule}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalForwardingRuleName.newFactory())
                      .setResourceNameField("forwardingRule")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetGlobalForwardingRuleHttpRequest, ForwardingRule>
      getGlobalForwardingRuleMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalForwardingRuleHttpRequest, ForwardingRule>newBuilder()
              .setFullMethodName("compute.globalForwardingRules.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetGlobalForwardingRuleHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/forwardingRules/{forwardingRule}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalForwardingRuleName.newFactory())
                      .setResourceNameField("forwardingRule")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ForwardingRule>newBuilder()
                      .setResponseInstance(ForwardingRule.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertGlobalForwardingRuleHttpRequest, Operation>
      insertGlobalForwardingRuleMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalForwardingRuleHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalForwardingRules.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertGlobalForwardingRuleHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/forwardingRules"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList>
      listGlobalForwardingRulesMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList>newBuilder()
              .setFullMethodName("compute.globalForwardingRules.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListGlobalForwardingRulesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/forwardingRules"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ForwardingRuleList>newBuilder()
                      .setResponseInstance(ForwardingRuleList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetTargetGlobalForwardingRuleHttpRequest, Operation>
      setTargetGlobalForwardingRuleMethodDescriptor =
          ApiMethodDescriptor.<SetTargetGlobalForwardingRuleHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalForwardingRules.setTarget")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetTargetGlobalForwardingRuleHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/forwardingRules/{forwardingRule}/setTarget"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalForwardingRuleName.newFactory())
                      .setResourceNameField("forwardingRule")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteGlobalForwardingRuleHttpRequest, Operation>
      deleteGlobalForwardingRuleCallable;
  private final UnaryCallable<GetGlobalForwardingRuleHttpRequest, ForwardingRule>
      getGlobalForwardingRuleCallable;
  private final UnaryCallable<InsertGlobalForwardingRuleHttpRequest, Operation>
      insertGlobalForwardingRuleCallable;
  private final UnaryCallable<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList>
      listGlobalForwardingRulesCallable;
  private final UnaryCallable<
          ListGlobalForwardingRulesHttpRequest, ListGlobalForwardingRulesPagedResponse>
      listGlobalForwardingRulesPagedCallable;
  private final UnaryCallable<SetTargetGlobalForwardingRuleHttpRequest, Operation>
      setTargetGlobalForwardingRuleCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalForwardingRuleStub create(
      GlobalForwardingRuleStubSettings settings) throws IOException {
    return new HttpJsonGlobalForwardingRuleStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalForwardingRuleStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalForwardingRuleStub(
        GlobalForwardingRuleStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalForwardingRuleStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalForwardingRuleStub(
        GlobalForwardingRuleStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalForwardingRuleStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalForwardingRuleStub(
      GlobalForwardingRuleStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGlobalForwardingRuleCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalForwardingRuleStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalForwardingRuleStub(
      GlobalForwardingRuleStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteGlobalForwardingRuleHttpRequest, Operation>
        deleteGlobalForwardingRuleTransportSettings =
            HttpJsonCallSettings.<DeleteGlobalForwardingRuleHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGlobalForwardingRuleMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetGlobalForwardingRuleHttpRequest, ForwardingRule>
        getGlobalForwardingRuleTransportSettings =
            HttpJsonCallSettings.<GetGlobalForwardingRuleHttpRequest, ForwardingRule>newBuilder()
                .setMethodDescriptor(getGlobalForwardingRuleMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertGlobalForwardingRuleHttpRequest, Operation>
        insertGlobalForwardingRuleTransportSettings =
            HttpJsonCallSettings.<InsertGlobalForwardingRuleHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertGlobalForwardingRuleMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList>
        listGlobalForwardingRulesTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList>newBuilder()
                .setMethodDescriptor(listGlobalForwardingRulesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetTargetGlobalForwardingRuleHttpRequest, Operation>
        setTargetGlobalForwardingRuleTransportSettings =
            HttpJsonCallSettings.<SetTargetGlobalForwardingRuleHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setTargetGlobalForwardingRuleMethodDescriptor)
                .build();

    this.deleteGlobalForwardingRuleCallable =
        callableFactory.createUnaryCallable(
            deleteGlobalForwardingRuleTransportSettings,
            settings.deleteGlobalForwardingRuleSettings(),
            clientContext);
    this.getGlobalForwardingRuleCallable =
        callableFactory.createUnaryCallable(
            getGlobalForwardingRuleTransportSettings,
            settings.getGlobalForwardingRuleSettings(),
            clientContext);
    this.insertGlobalForwardingRuleCallable =
        callableFactory.createUnaryCallable(
            insertGlobalForwardingRuleTransportSettings,
            settings.insertGlobalForwardingRuleSettings(),
            clientContext);
    this.listGlobalForwardingRulesCallable =
        callableFactory.createUnaryCallable(
            listGlobalForwardingRulesTransportSettings,
            settings.listGlobalForwardingRulesSettings(),
            clientContext);
    this.listGlobalForwardingRulesPagedCallable =
        callableFactory.createPagedCallable(
            listGlobalForwardingRulesTransportSettings,
            settings.listGlobalForwardingRulesSettings(),
            clientContext);
    this.setTargetGlobalForwardingRuleCallable =
        callableFactory.createUnaryCallable(
            setTargetGlobalForwardingRuleTransportSettings,
            settings.setTargetGlobalForwardingRuleSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteGlobalForwardingRuleHttpRequest, Operation>
      deleteGlobalForwardingRuleCallable() {
    return deleteGlobalForwardingRuleCallable;
  }

  @BetaApi
  public UnaryCallable<GetGlobalForwardingRuleHttpRequest, ForwardingRule>
      getGlobalForwardingRuleCallable() {
    return getGlobalForwardingRuleCallable;
  }

  @BetaApi
  public UnaryCallable<InsertGlobalForwardingRuleHttpRequest, Operation>
      insertGlobalForwardingRuleCallable() {
    return insertGlobalForwardingRuleCallable;
  }

  @BetaApi
  public UnaryCallable<ListGlobalForwardingRulesHttpRequest, ListGlobalForwardingRulesPagedResponse>
      listGlobalForwardingRulesPagedCallable() {
    return listGlobalForwardingRulesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListGlobalForwardingRulesHttpRequest, ForwardingRuleList>
      listGlobalForwardingRulesCallable() {
    return listGlobalForwardingRulesCallable;
  }

  @BetaApi
  public UnaryCallable<SetTargetGlobalForwardingRuleHttpRequest, Operation>
      setTargetGlobalForwardingRuleCallable() {
    return setTargetGlobalForwardingRuleCallable;
  }

  @Override
  public final void close() {
    shutdown();
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

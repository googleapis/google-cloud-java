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

import static com.google.cloud.compute.v1.SecurityPolicyClient.ListSecurityPoliciesPagedResponse;

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
import com.google.cloud.compute.v1.AddRuleSecurityPolicyHttpRequest;
import com.google.cloud.compute.v1.DeleteSecurityPolicyHttpRequest;
import com.google.cloud.compute.v1.GetRuleSecurityPolicyHttpRequest;
import com.google.cloud.compute.v1.GetSecurityPolicyHttpRequest;
import com.google.cloud.compute.v1.InsertSecurityPolicyHttpRequest;
import com.google.cloud.compute.v1.ListSecurityPoliciesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRuleSecurityPolicyHttpRequest;
import com.google.cloud.compute.v1.PatchSecurityPolicyHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalSecurityPolicyName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.RemoveRuleSecurityPolicyHttpRequest;
import com.google.cloud.compute.v1.SecurityPolicy;
import com.google.cloud.compute.v1.SecurityPolicyList;
import com.google.cloud.compute.v1.SecurityPolicyRule;
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
public class HttpJsonSecurityPolicyStub extends SecurityPolicyStub {
  @InternalApi
  public static final ApiMethodDescriptor<AddRuleSecurityPolicyHttpRequest, Operation>
      addRuleSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<AddRuleSecurityPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.securityPolicies.addRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AddRuleSecurityPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/securityPolicies/{securityPolicy}/addRule"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSecurityPolicyName.newFactory())
                      .setResourceNameField("securityPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteSecurityPolicyHttpRequest, Operation>
      deleteSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteSecurityPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.securityPolicies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteSecurityPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/securityPolicies/{securityPolicy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalSecurityPolicyName.newFactory())
                      .setResourceNameField("securityPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetSecurityPolicyHttpRequest, SecurityPolicy>
      getSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetSecurityPolicyHttpRequest, SecurityPolicy>newBuilder()
              .setFullMethodName("compute.securityPolicies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetSecurityPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/securityPolicies/{securityPolicy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSecurityPolicyName.newFactory())
                      .setResourceNameField("securityPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SecurityPolicy>newBuilder()
                      .setResponseInstance(SecurityPolicy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRuleSecurityPolicyHttpRequest, SecurityPolicyRule>
      getRuleSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetRuleSecurityPolicyHttpRequest, SecurityPolicyRule>newBuilder()
              .setFullMethodName("compute.securityPolicies.getRule")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRuleSecurityPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/securityPolicies/{securityPolicy}/getRule"))
                      .setQueryParams(Sets.<String>newHashSet("priority"))
                      .setResourceNameFactory(ProjectGlobalSecurityPolicyName.newFactory())
                      .setResourceNameField("securityPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SecurityPolicyRule>newBuilder()
                      .setResponseInstance(SecurityPolicyRule.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertSecurityPolicyHttpRequest, Operation>
      insertSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<InsertSecurityPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.securityPolicies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertSecurityPolicyHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/securityPolicies"))
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
  public static final ApiMethodDescriptor<ListSecurityPoliciesHttpRequest, SecurityPolicyList>
      listSecurityPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListSecurityPoliciesHttpRequest, SecurityPolicyList>newBuilder()
              .setFullMethodName("compute.securityPolicies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListSecurityPoliciesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/securityPolicies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SecurityPolicyList>newBuilder()
                      .setResponseInstance(SecurityPolicyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchSecurityPolicyHttpRequest, Operation>
      patchSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<PatchSecurityPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.securityPolicies.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchSecurityPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/securityPolicies/{securityPolicy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalSecurityPolicyName.newFactory())
                      .setResourceNameField("securityPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRuleSecurityPolicyHttpRequest, Operation>
      patchRuleSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<PatchRuleSecurityPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.securityPolicies.patchRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchRuleSecurityPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/securityPolicies/{securityPolicy}/patchRule"))
                      .setQueryParams(Sets.<String>newHashSet("priority"))
                      .setResourceNameFactory(ProjectGlobalSecurityPolicyName.newFactory())
                      .setResourceNameField("securityPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveRuleSecurityPolicyHttpRequest, Operation>
      removeRuleSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<RemoveRuleSecurityPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.securityPolicies.removeRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<RemoveRuleSecurityPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/securityPolicies/{securityPolicy}/removeRule"))
                      .setQueryParams(Sets.<String>newHashSet("priority"))
                      .setResourceNameFactory(ProjectGlobalSecurityPolicyName.newFactory())
                      .setResourceNameField("securityPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddRuleSecurityPolicyHttpRequest, Operation>
      addRuleSecurityPolicyCallable;
  private final UnaryCallable<DeleteSecurityPolicyHttpRequest, Operation>
      deleteSecurityPolicyCallable;
  private final UnaryCallable<GetSecurityPolicyHttpRequest, SecurityPolicy>
      getSecurityPolicyCallable;
  private final UnaryCallable<GetRuleSecurityPolicyHttpRequest, SecurityPolicyRule>
      getRuleSecurityPolicyCallable;
  private final UnaryCallable<InsertSecurityPolicyHttpRequest, Operation>
      insertSecurityPolicyCallable;
  private final UnaryCallable<ListSecurityPoliciesHttpRequest, SecurityPolicyList>
      listSecurityPoliciesCallable;
  private final UnaryCallable<ListSecurityPoliciesHttpRequest, ListSecurityPoliciesPagedResponse>
      listSecurityPoliciesPagedCallable;
  private final UnaryCallable<PatchSecurityPolicyHttpRequest, Operation>
      patchSecurityPolicyCallable;
  private final UnaryCallable<PatchRuleSecurityPolicyHttpRequest, Operation>
      patchRuleSecurityPolicyCallable;
  private final UnaryCallable<RemoveRuleSecurityPolicyHttpRequest, Operation>
      removeRuleSecurityPolicyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSecurityPolicyStub create(SecurityPolicyStubSettings settings)
      throws IOException {
    return new HttpJsonSecurityPolicyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSecurityPolicyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSecurityPolicyStub(
        SecurityPolicyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSecurityPolicyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSecurityPolicyStub(
        SecurityPolicyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSecurityPolicyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityPolicyStub(
      SecurityPolicyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSecurityPolicyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSecurityPolicyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityPolicyStub(
      SecurityPolicyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddRuleSecurityPolicyHttpRequest, Operation>
        addRuleSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<AddRuleSecurityPolicyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(addRuleSecurityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteSecurityPolicyHttpRequest, Operation>
        deleteSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteSecurityPolicyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSecurityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetSecurityPolicyHttpRequest, SecurityPolicy>
        getSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<GetSecurityPolicyHttpRequest, SecurityPolicy>newBuilder()
                .setMethodDescriptor(getSecurityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRuleSecurityPolicyHttpRequest, SecurityPolicyRule>
        getRuleSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<GetRuleSecurityPolicyHttpRequest, SecurityPolicyRule>newBuilder()
                .setMethodDescriptor(getRuleSecurityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertSecurityPolicyHttpRequest, Operation>
        insertSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<InsertSecurityPolicyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertSecurityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListSecurityPoliciesHttpRequest, SecurityPolicyList>
        listSecurityPoliciesTransportSettings =
            HttpJsonCallSettings.<ListSecurityPoliciesHttpRequest, SecurityPolicyList>newBuilder()
                .setMethodDescriptor(listSecurityPoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchSecurityPolicyHttpRequest, Operation>
        patchSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<PatchSecurityPolicyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchSecurityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRuleSecurityPolicyHttpRequest, Operation>
        patchRuleSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<PatchRuleSecurityPolicyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRuleSecurityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<RemoveRuleSecurityPolicyHttpRequest, Operation>
        removeRuleSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<RemoveRuleSecurityPolicyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(removeRuleSecurityPolicyMethodDescriptor)
                .build();

    this.addRuleSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            addRuleSecurityPolicyTransportSettings,
            settings.addRuleSecurityPolicySettings(),
            clientContext);
    this.deleteSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteSecurityPolicyTransportSettings,
            settings.deleteSecurityPolicySettings(),
            clientContext);
    this.getSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            getSecurityPolicyTransportSettings,
            settings.getSecurityPolicySettings(),
            clientContext);
    this.getRuleSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            getRuleSecurityPolicyTransportSettings,
            settings.getRuleSecurityPolicySettings(),
            clientContext);
    this.insertSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            insertSecurityPolicyTransportSettings,
            settings.insertSecurityPolicySettings(),
            clientContext);
    this.listSecurityPoliciesCallable =
        callableFactory.createUnaryCallable(
            listSecurityPoliciesTransportSettings,
            settings.listSecurityPoliciesSettings(),
            clientContext);
    this.listSecurityPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listSecurityPoliciesTransportSettings,
            settings.listSecurityPoliciesSettings(),
            clientContext);
    this.patchSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            patchSecurityPolicyTransportSettings,
            settings.patchSecurityPolicySettings(),
            clientContext);
    this.patchRuleSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            patchRuleSecurityPolicyTransportSettings,
            settings.patchRuleSecurityPolicySettings(),
            clientContext);
    this.removeRuleSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            removeRuleSecurityPolicyTransportSettings,
            settings.removeRuleSecurityPolicySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AddRuleSecurityPolicyHttpRequest, Operation>
      addRuleSecurityPolicyCallable() {
    return addRuleSecurityPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteSecurityPolicyHttpRequest, Operation> deleteSecurityPolicyCallable() {
    return deleteSecurityPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<GetSecurityPolicyHttpRequest, SecurityPolicy> getSecurityPolicyCallable() {
    return getSecurityPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<GetRuleSecurityPolicyHttpRequest, SecurityPolicyRule>
      getRuleSecurityPolicyCallable() {
    return getRuleSecurityPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertSecurityPolicyHttpRequest, Operation> insertSecurityPolicyCallable() {
    return insertSecurityPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<ListSecurityPoliciesHttpRequest, ListSecurityPoliciesPagedResponse>
      listSecurityPoliciesPagedCallable() {
    return listSecurityPoliciesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListSecurityPoliciesHttpRequest, SecurityPolicyList>
      listSecurityPoliciesCallable() {
    return listSecurityPoliciesCallable;
  }

  @BetaApi
  public UnaryCallable<PatchSecurityPolicyHttpRequest, Operation> patchSecurityPolicyCallable() {
    return patchSecurityPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<PatchRuleSecurityPolicyHttpRequest, Operation>
      patchRuleSecurityPolicyCallable() {
    return patchRuleSecurityPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<RemoveRuleSecurityPolicyHttpRequest, Operation>
      removeRuleSecurityPolicyCallable() {
    return removeRuleSecurityPolicyCallable;
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

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

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMessageHttpRequestFormatter;
import com.google.api.gax.httpjson.ApiMessageHttpResponseParser;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.AggregatedListForwardingRulesHttpRequest;
import com.google.cloud.compute.v1.DeleteForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleAggregatedList;
import static com.google.cloud.compute.v1.ForwardingRuleClient.AggregatedListForwardingRulesPagedResponse;
import static com.google.cloud.compute.v1.ForwardingRuleClient.ListForwardingRulesPagedResponse;
import com.google.cloud.compute.v1.ForwardingRuleList;
import com.google.cloud.compute.v1.ForwardingRuleSettings;
import com.google.cloud.compute.v1.ForwardingRulesScopedList;
import com.google.cloud.compute.v1.GetForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.InsertForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.ListForwardingRulesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionForwardingRuleName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.SetTargetForwardingRuleHttpRequest;
import com.google.cloud.compute.v1.TargetReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * HTTP callable factory implementation for compute.
 *
 * <p>This class is for advanced usage.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
public class HttpJsonForwardingRuleCallableFactory implements HttpJsonStubCallableFactory {
  @Override
  public <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUnaryCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      UnaryCallSettings<RequestT, ResponseT> callSettings,
      ClientContext clientContext) {
    return HttpJsonCallableFactory.createUnaryCallable(httpJsonCallSettings, callSettings, clientContext);
  }

  @Override
  public <RequestT, ResponseT, PagedListResponseT>
      UnaryCallable<RequestT, PagedListResponseT> createPagedCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      PagedCallSettings<RequestT, ResponseT, PagedListResponseT> pagedCallSettings,
      ClientContext clientContext) {
    return HttpJsonCallableFactory.createPagedCallable(httpJsonCallSettings, pagedCallSettings, clientContext);
  }

  @Override
  public <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createBatchingCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      BatchingCallSettings<RequestT, ResponseT> batchingCallSettings,
      ClientContext clientContext) {
    return HttpJsonCallableFactory.createBatchingCallable(httpJsonCallSettings, batchingCallSettings, clientContext);
  }
}
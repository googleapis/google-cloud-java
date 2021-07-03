/*
 * Copyright 2021 Google LLC
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

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.BulkInsertRegionInstanceRequest;
import com.google.cloud.compute.v1.Operation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionInstances service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionInstancesStub extends RegionInstancesStub {
  private static final ApiMethodDescriptor<BulkInsertRegionInstanceRequest, Operation>
      bulkInsertMethodDescriptor =
          ApiMethodDescriptor.<BulkInsertRegionInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstances/BulkInsert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkInsertRegionInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instances/bulkInsert",
                          new FieldsExtractor<
                              BulkInsertRegionInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                BulkInsertRegionInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<BulkInsertRegionInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              BulkInsertRegionInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                BulkInsertRegionInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<BulkInsertRegionInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<BulkInsertRegionInstanceRequest, String>() {
                            @Override
                            public String extract(BulkInsertRegionInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "bulkInsertInstanceResourceResource",
                                      request.getBulkInsertInstanceResourceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<BulkInsertRegionInstanceRequest, Operation> bulkInsertCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionInstancesStub create(RegionInstancesStubSettings settings)
      throws IOException {
    return new HttpJsonRegionInstancesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionInstancesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionInstancesStub(
        RegionInstancesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionInstancesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionInstancesStub(
        RegionInstancesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionInstancesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionInstancesStub(
      RegionInstancesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionInstancesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionInstancesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionInstancesStub(
      RegionInstancesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<BulkInsertRegionInstanceRequest, Operation> bulkInsertTransportSettings =
        HttpJsonCallSettings.<BulkInsertRegionInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(bulkInsertMethodDescriptor)
            .build();

    this.bulkInsertCallable =
        callableFactory.createUnaryCallable(
            bulkInsertTransportSettings, settings.bulkInsertSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(bulkInsertMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<BulkInsertRegionInstanceRequest, Operation> bulkInsertCallable() {
    return bulkInsertCallable;
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

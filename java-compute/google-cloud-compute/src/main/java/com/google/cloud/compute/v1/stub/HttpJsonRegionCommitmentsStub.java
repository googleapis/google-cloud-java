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

import static com.google.cloud.compute.v1.RegionCommitmentsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RegionCommitmentsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListRegionCommitmentsRequest;
import com.google.cloud.compute.v1.Commitment;
import com.google.cloud.compute.v1.CommitmentAggregatedList;
import com.google.cloud.compute.v1.CommitmentList;
import com.google.cloud.compute.v1.GetRegionCommitmentRequest;
import com.google.cloud.compute.v1.InsertRegionCommitmentRequest;
import com.google.cloud.compute.v1.ListRegionCommitmentsRequest;
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
 * REST stub implementation for the RegionCommitments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionCommitmentsStub extends RegionCommitmentsStub {
  private static final ApiMethodDescriptor<
          AggregatedListRegionCommitmentsRequest, CommitmentAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListRegionCommitmentsRequest, CommitmentAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCommitments/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListRegionCommitmentsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/commitments",
                          new FieldsExtractor<
                              AggregatedListRegionCommitmentsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListRegionCommitmentsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListRegionCommitmentsRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListRegionCommitmentsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListRegionCommitmentsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListRegionCommitmentsRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasIncludeAllScopes()) {
                                serializer.putQueryParam(
                                    fields, "includeAllScopes", request.getIncludeAllScopes());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AggregatedListRegionCommitmentsRequest, String>() {
                            @Override
                            public String extract(AggregatedListRegionCommitmentsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CommitmentAggregatedList>newBuilder()
                      .setDefaultInstance(CommitmentAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRegionCommitmentRequest, Commitment>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionCommitmentRequest, Commitment>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCommitments/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionCommitmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/commitments/{commitment}",
                          new FieldsExtractor<GetRegionCommitmentRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetRegionCommitmentRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionCommitmentRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "commitment", request.getCommitment());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionCommitmentRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionCommitmentRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionCommitmentRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionCommitmentRequest, String>() {
                            @Override
                            public String extract(GetRegionCommitmentRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Commitment>newBuilder()
                      .setDefaultInstance(Commitment.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRegionCommitmentRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionCommitmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCommitments/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionCommitmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/commitments",
                          new FieldsExtractor<
                              InsertRegionCommitmentRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionCommitmentRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionCommitmentRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionCommitmentRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionCommitmentRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionCommitmentRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionCommitmentRequest, String>() {
                            @Override
                            public String extract(InsertRegionCommitmentRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("commitmentResource", request.getCommitmentResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRegionCommitmentsRequest, CommitmentList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionCommitmentsRequest, CommitmentList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCommitments/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionCommitmentsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/commitments",
                          new FieldsExtractor<ListRegionCommitmentsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionCommitmentsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionCommitmentsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionCommitmentsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionCommitmentsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionCommitmentsRequest> serializer =
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
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListRegionCommitmentsRequest, String>() {
                            @Override
                            public String extract(ListRegionCommitmentsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CommitmentList>newBuilder()
                      .setDefaultInstance(CommitmentList.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AggregatedListRegionCommitmentsRequest, CommitmentAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListRegionCommitmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<GetRegionCommitmentRequest, Commitment> getCallable;
  private final UnaryCallable<InsertRegionCommitmentRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionCommitmentsRequest, CommitmentList> listCallable;
  private final UnaryCallable<ListRegionCommitmentsRequest, ListPagedResponse> listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionCommitmentsStub create(RegionCommitmentsStubSettings settings)
      throws IOException {
    return new HttpJsonRegionCommitmentsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionCommitmentsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionCommitmentsStub(
        RegionCommitmentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionCommitmentsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionCommitmentsStub(
        RegionCommitmentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionCommitmentsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionCommitmentsStub(
      RegionCommitmentsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionCommitmentsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionCommitmentsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionCommitmentsStub(
      RegionCommitmentsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListRegionCommitmentsRequest, CommitmentAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListRegionCommitmentsRequest, CommitmentAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionCommitmentRequest, Commitment> getTransportSettings =
        HttpJsonCallSettings.<GetRegionCommitmentRequest, Commitment>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionCommitmentRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionCommitmentRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionCommitmentsRequest, CommitmentList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionCommitmentsRequest, CommitmentList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();

    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListRegionCommitmentsRequest, CommitmentAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListRegionCommitmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<GetRegionCommitmentRequest, Commitment> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionCommitmentRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListRegionCommitmentsRequest, CommitmentList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionCommitmentsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
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

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

import static com.google.cloud.compute.v1.ReservationsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.ReservationsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListReservationsRequest;
import com.google.cloud.compute.v1.DeleteReservationRequest;
import com.google.cloud.compute.v1.GetIamPolicyReservationRequest;
import com.google.cloud.compute.v1.GetReservationRequest;
import com.google.cloud.compute.v1.InsertReservationRequest;
import com.google.cloud.compute.v1.ListReservationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.Reservation;
import com.google.cloud.compute.v1.ReservationAggregatedList;
import com.google.cloud.compute.v1.ReservationList;
import com.google.cloud.compute.v1.ResizeReservationRequest;
import com.google.cloud.compute.v1.SetIamPolicyReservationRequest;
import com.google.cloud.compute.v1.TestIamPermissionsReservationRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Reservations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonReservationsStub extends ReservationsStub {
  private static final ApiMethodDescriptor<
          AggregatedListReservationsRequest, ReservationAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListReservationsRequest, ReservationAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Reservations/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListReservationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/reservations",
                          new FieldsExtractor<
                              AggregatedListReservationsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListReservationsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListReservationsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListReservationsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListReservationsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListReservationsRequest> serializer =
                                  ProtoRestSerializer.create();
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
                          new FieldsExtractor<AggregatedListReservationsRequest, String>() {
                            @Override
                            public String extract(AggregatedListReservationsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReservationAggregatedList>newBuilder()
                      .setDefaultInstance(ReservationAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReservationRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteReservationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Reservations/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReservationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations/{reservation}",
                          new FieldsExtractor<DeleteReservationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteReservationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "reservation", request.getReservation());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteReservationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteReservationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteReservationRequest, String>() {
                            @Override
                            public String extract(DeleteReservationRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReservationRequest, Reservation> getMethodDescriptor =
      ApiMethodDescriptor.<GetReservationRequest, Reservation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Reservations/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetReservationRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/reservations/{reservation}",
                      new FieldsExtractor<GetReservationRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetReservationRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetReservationRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "reservation", request.getReservation());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetReservationRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetReservationRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetReservationRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetReservationRequest, String>() {
                        @Override
                        public String extract(GetReservationRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Reservation>newBuilder()
                  .setDefaultInstance(Reservation.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetIamPolicyReservationRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyReservationRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Reservations/GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyReservationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations/{resource}/getIamPolicy",
                          new FieldsExtractor<
                              GetIamPolicyReservationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicyReservationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyReservationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyReservationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasOptionsRequestedPolicyVersion()) {
                                serializer.putQueryParam(
                                    fields,
                                    "optionsRequestedPolicyVersion",
                                    request.getOptionsRequestedPolicyVersion());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetIamPolicyReservationRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyReservationRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertReservationRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertReservationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Reservations/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertReservationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations",
                          new FieldsExtractor<InsertReservationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertReservationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertReservationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertReservationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertReservationRequest, String>() {
                            @Override
                            public String extract(InsertReservationRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("reservationResource", request.getReservationResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReservationsRequest, ReservationList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListReservationsRequest, ReservationList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Reservations/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReservationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations",
                          new FieldsExtractor<ListReservationsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListReservationsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListReservationsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListReservationsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListReservationsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListReservationsRequest> serializer =
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
                          new FieldsExtractor<ListReservationsRequest, String>() {
                            @Override
                            public String extract(ListReservationsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReservationList>newBuilder()
                      .setDefaultInstance(ReservationList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResizeReservationRequest, Operation>
      resizeMethodDescriptor =
          ApiMethodDescriptor.<ResizeReservationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Reservations/Resize")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeReservationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations/{reservation}/resize",
                          new FieldsExtractor<ResizeReservationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ResizeReservationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ResizeReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "reservation", request.getReservation());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ResizeReservationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ResizeReservationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ResizeReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ResizeReservationRequest, String>() {
                            @Override
                            public String extract(ResizeReservationRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "reservationsResizeRequestResource",
                                      request.getReservationsResizeRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyReservationRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyReservationRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Reservations/SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyReservationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations/{resource}/setIamPolicy",
                          new FieldsExtractor<
                              SetIamPolicyReservationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicyReservationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyReservationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyReservationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyReservationRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyReservationRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "zoneSetPolicyRequestResource",
                                      request.getZoneSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsReservationRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsReservationRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Reservations/TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsReservationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/reservations/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsReservationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsReservationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsReservationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsReservationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsReservationRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsReservationRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsReservationRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AggregatedListReservationsRequest, ReservationAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListReservationsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteReservationRequest, Operation> deleteCallable;
  private final UnaryCallable<GetReservationRequest, Reservation> getCallable;
  private final UnaryCallable<GetIamPolicyReservationRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertReservationRequest, Operation> insertCallable;
  private final UnaryCallable<ListReservationsRequest, ReservationList> listCallable;
  private final UnaryCallable<ListReservationsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ResizeReservationRequest, Operation> resizeCallable;
  private final UnaryCallable<SetIamPolicyReservationRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsReservationRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReservationsStub create(ReservationsStubSettings settings)
      throws IOException {
    return new HttpJsonReservationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReservationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReservationsStub(
        ReservationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonReservationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReservationsStub(
        ReservationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReservationsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonReservationsStub(ReservationsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonReservationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReservationsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonReservationsStub(
      ReservationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListReservationsRequest, ReservationAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListReservationsRequest, ReservationAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteReservationRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteReservationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetReservationRequest, Reservation> getTransportSettings =
        HttpJsonCallSettings.<GetReservationRequest, Reservation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyReservationRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyReservationRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertReservationRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertReservationRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListReservationsRequest, ReservationList> listTransportSettings =
        HttpJsonCallSettings.<ListReservationsRequest, ReservationList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<ResizeReservationRequest, Operation> resizeTransportSettings =
        HttpJsonCallSettings.<ResizeReservationRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyReservationRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyReservationRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsReservationRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsReservationRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.resizeCallable =
        callableFactory.createUnaryCallable(
            resizeTransportSettings, settings.resizeSettings(), clientContext);
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
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(resizeMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListReservationsRequest, ReservationAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListReservationsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteReservationRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetReservationRequest, Reservation> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyReservationRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertReservationRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListReservationsRequest, ReservationList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListReservationsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<ResizeReservationRequest, Operation> resizeCallable() {
    return resizeCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyReservationRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsReservationRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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

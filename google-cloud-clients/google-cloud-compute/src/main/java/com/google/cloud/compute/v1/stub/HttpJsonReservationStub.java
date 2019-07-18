/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.ReservationClient.AggregatedListReservationsPagedResponse;
import static com.google.cloud.compute.v1.ReservationClient.ListReservationsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListReservationsHttpRequest;
import com.google.cloud.compute.v1.DeleteReservationHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyReservationHttpRequest;
import com.google.cloud.compute.v1.GetReservationHttpRequest;
import com.google.cloud.compute.v1.InsertReservationHttpRequest;
import com.google.cloud.compute.v1.ListReservationsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.ProjectZoneReservationName;
import com.google.cloud.compute.v1.ProjectZoneReservationResourceName;
import com.google.cloud.compute.v1.Reservation;
import com.google.cloud.compute.v1.ReservationAggregatedList;
import com.google.cloud.compute.v1.ReservationList;
import com.google.cloud.compute.v1.ResizeReservationHttpRequest;
import com.google.cloud.compute.v1.SetIamPolicyReservationHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsReservationHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
public class HttpJsonReservationStub extends ReservationStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListReservationsHttpRequest, ReservationAggregatedList>
      aggregatedListReservationsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListReservationsHttpRequest, ReservationAggregatedList>newBuilder()
              .setFullMethodName("compute.reservations.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListReservationsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/reservations"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ReservationAggregatedList>newBuilder()
                      .setResponseInstance(ReservationAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteReservationHttpRequest, Operation>
      deleteReservationMethodDescriptor =
          ApiMethodDescriptor.<DeleteReservationHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.reservations.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteReservationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/reservations/{reservation}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneReservationName.newFactory())
                      .setResourceNameField("reservation")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetReservationHttpRequest, Reservation>
      getReservationMethodDescriptor =
          ApiMethodDescriptor.<GetReservationHttpRequest, Reservation>newBuilder()
              .setFullMethodName("compute.reservations.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetReservationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/reservations/{reservation}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneReservationName.newFactory())
                      .setResourceNameField("reservation")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Reservation>newBuilder()
                      .setResponseInstance(Reservation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyReservationHttpRequest, Policy>
      getIamPolicyReservationMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyReservationHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.reservations.getIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetIamPolicyReservationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/reservations/{resource}/getIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneReservationResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertReservationHttpRequest, Operation>
      insertReservationMethodDescriptor =
          ApiMethodDescriptor.<InsertReservationHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.reservations.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertReservationHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/reservations"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListReservationsHttpRequest, ReservationList>
      listReservationsMethodDescriptor =
          ApiMethodDescriptor.<ListReservationsHttpRequest, ReservationList>newBuilder()
              .setFullMethodName("compute.reservations.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListReservationsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/reservations"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ReservationList>newBuilder()
                      .setResponseInstance(ReservationList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ResizeReservationHttpRequest, Operation>
      resizeReservationMethodDescriptor =
          ApiMethodDescriptor.<ResizeReservationHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.reservations.resize")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ResizeReservationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/reservations/{reservation}/resize"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneReservationName.newFactory())
                      .setResourceNameField("reservation")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyReservationHttpRequest, Policy>
      setIamPolicyReservationMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyReservationHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.reservations.setIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetIamPolicyReservationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/reservations/{resource}/setIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneReservationResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
      testIamPermissionsReservationMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.reservations.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsReservationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/reservations/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneReservationResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListReservationsHttpRequest, ReservationAggregatedList>
      aggregatedListReservationsCallable;
  private final UnaryCallable<
          AggregatedListReservationsHttpRequest, AggregatedListReservationsPagedResponse>
      aggregatedListReservationsPagedCallable;
  private final UnaryCallable<DeleteReservationHttpRequest, Operation> deleteReservationCallable;
  private final UnaryCallable<GetReservationHttpRequest, Reservation> getReservationCallable;
  private final UnaryCallable<GetIamPolicyReservationHttpRequest, Policy>
      getIamPolicyReservationCallable;
  private final UnaryCallable<InsertReservationHttpRequest, Operation> insertReservationCallable;
  private final UnaryCallable<ListReservationsHttpRequest, ReservationList>
      listReservationsCallable;
  private final UnaryCallable<ListReservationsHttpRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable;
  private final UnaryCallable<ResizeReservationHttpRequest, Operation> resizeReservationCallable;
  private final UnaryCallable<SetIamPolicyReservationHttpRequest, Policy>
      setIamPolicyReservationCallable;
  private final UnaryCallable<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
      testIamPermissionsReservationCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReservationStub create(ReservationStubSettings settings)
      throws IOException {
    return new HttpJsonReservationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReservationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReservationStub(ReservationStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonReservationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReservationStub(
        ReservationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReservationStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonReservationStub(ReservationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonReservationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReservationStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonReservationStub(
      ReservationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListReservationsHttpRequest, ReservationAggregatedList>
        aggregatedListReservationsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListReservationsHttpRequest, ReservationAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListReservationsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteReservationHttpRequest, Operation>
        deleteReservationTransportSettings =
            HttpJsonCallSettings.<DeleteReservationHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteReservationMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetReservationHttpRequest, Reservation> getReservationTransportSettings =
        HttpJsonCallSettings.<GetReservationHttpRequest, Reservation>newBuilder()
            .setMethodDescriptor(getReservationMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyReservationHttpRequest, Policy>
        getIamPolicyReservationTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyReservationHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyReservationMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertReservationHttpRequest, Operation>
        insertReservationTransportSettings =
            HttpJsonCallSettings.<InsertReservationHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertReservationMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListReservationsHttpRequest, ReservationList>
        listReservationsTransportSettings =
            HttpJsonCallSettings.<ListReservationsHttpRequest, ReservationList>newBuilder()
                .setMethodDescriptor(listReservationsMethodDescriptor)
                .build();
    HttpJsonCallSettings<ResizeReservationHttpRequest, Operation>
        resizeReservationTransportSettings =
            HttpJsonCallSettings.<ResizeReservationHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(resizeReservationMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetIamPolicyReservationHttpRequest, Policy>
        setIamPolicyReservationTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyReservationHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyReservationMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
        testIamPermissionsReservationTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsReservationMethodDescriptor)
                .build();

    this.aggregatedListReservationsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListReservationsTransportSettings,
            settings.aggregatedListReservationsSettings(),
            clientContext);
    this.aggregatedListReservationsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListReservationsTransportSettings,
            settings.aggregatedListReservationsSettings(),
            clientContext);
    this.deleteReservationCallable =
        callableFactory.createUnaryCallable(
            deleteReservationTransportSettings,
            settings.deleteReservationSettings(),
            clientContext);
    this.getReservationCallable =
        callableFactory.createUnaryCallable(
            getReservationTransportSettings, settings.getReservationSettings(), clientContext);
    this.getIamPolicyReservationCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyReservationTransportSettings,
            settings.getIamPolicyReservationSettings(),
            clientContext);
    this.insertReservationCallable =
        callableFactory.createUnaryCallable(
            insertReservationTransportSettings,
            settings.insertReservationSettings(),
            clientContext);
    this.listReservationsCallable =
        callableFactory.createUnaryCallable(
            listReservationsTransportSettings, settings.listReservationsSettings(), clientContext);
    this.listReservationsPagedCallable =
        callableFactory.createPagedCallable(
            listReservationsTransportSettings, settings.listReservationsSettings(), clientContext);
    this.resizeReservationCallable =
        callableFactory.createUnaryCallable(
            resizeReservationTransportSettings,
            settings.resizeReservationSettings(),
            clientContext);
    this.setIamPolicyReservationCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyReservationTransportSettings,
            settings.setIamPolicyReservationSettings(),
            clientContext);
    this.testIamPermissionsReservationCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsReservationTransportSettings,
            settings.testIamPermissionsReservationSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListReservationsHttpRequest, AggregatedListReservationsPagedResponse>
      aggregatedListReservationsPagedCallable() {
    return aggregatedListReservationsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListReservationsHttpRequest, ReservationAggregatedList>
      aggregatedListReservationsCallable() {
    return aggregatedListReservationsCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteReservationHttpRequest, Operation> deleteReservationCallable() {
    return deleteReservationCallable;
  }

  @BetaApi
  public UnaryCallable<GetReservationHttpRequest, Reservation> getReservationCallable() {
    return getReservationCallable;
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyReservationHttpRequest, Policy>
      getIamPolicyReservationCallable() {
    return getIamPolicyReservationCallable;
  }

  @BetaApi
  public UnaryCallable<InsertReservationHttpRequest, Operation> insertReservationCallable() {
    return insertReservationCallable;
  }

  @BetaApi
  public UnaryCallable<ListReservationsHttpRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable() {
    return listReservationsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListReservationsHttpRequest, ReservationList> listReservationsCallable() {
    return listReservationsCallable;
  }

  @BetaApi
  public UnaryCallable<ResizeReservationHttpRequest, Operation> resizeReservationCallable() {
    return resizeReservationCallable;
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyReservationHttpRequest, Policy>
      setIamPolicyReservationCallable() {
    return setIamPolicyReservationCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
      testIamPermissionsReservationCallable() {
    return testIamPermissionsReservationCallable;
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

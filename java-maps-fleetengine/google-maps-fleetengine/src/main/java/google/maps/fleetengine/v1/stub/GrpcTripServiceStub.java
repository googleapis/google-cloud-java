/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.v1.stub;

import static google.maps.fleetengine.v1.TripServiceClient.SearchTripsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import google.maps.fleetengine.v1.CreateTripRequest;
import google.maps.fleetengine.v1.GetTripRequest;
import google.maps.fleetengine.v1.ReportBillableTripRequest;
import google.maps.fleetengine.v1.SearchTripsRequest;
import google.maps.fleetengine.v1.SearchTripsResponse;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.UpdateTripRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TripService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTripServiceStub extends TripServiceStub {
  private static final MethodDescriptor<CreateTripRequest, Trip> createTripMethodDescriptor =
      MethodDescriptor.<CreateTripRequest, Trip>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("maps.fleetengine.v1.TripService/CreateTrip")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTripRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trip.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetTripRequest, Trip> getTripMethodDescriptor =
      MethodDescriptor.<GetTripRequest, Trip>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("maps.fleetengine.v1.TripService/GetTrip")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTripRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trip.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ReportBillableTripRequest, Empty>
      reportBillableTripMethodDescriptor =
          MethodDescriptor.<ReportBillableTripRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.TripService/ReportBillableTrip")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReportBillableTripRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchTripsRequest, SearchTripsResponse>
      searchTripsMethodDescriptor =
          MethodDescriptor.<SearchTripsRequest, SearchTripsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.TripService/SearchTrips")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchTripsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchTripsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTripRequest, Trip> updateTripMethodDescriptor =
      MethodDescriptor.<UpdateTripRequest, Trip>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("maps.fleetengine.v1.TripService/UpdateTrip")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTripRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trip.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateTripRequest, Trip> createTripCallable;
  private final UnaryCallable<GetTripRequest, Trip> getTripCallable;
  private final UnaryCallable<ReportBillableTripRequest, Empty> reportBillableTripCallable;
  private final UnaryCallable<SearchTripsRequest, SearchTripsResponse> searchTripsCallable;
  private final UnaryCallable<SearchTripsRequest, SearchTripsPagedResponse>
      searchTripsPagedCallable;
  private final UnaryCallable<UpdateTripRequest, Trip> updateTripCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_TRIP_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate GET_TRIP_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate REPORT_BILLABLE_TRIP_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate SEARCH_TRIPS_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate UPDATE_TRIP_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");

  public static final GrpcTripServiceStub create(TripServiceStubSettings settings)
      throws IOException {
    return new GrpcTripServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTripServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcTripServiceStub(TripServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTripServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTripServiceStub(
        TripServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTripServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTripServiceStub(TripServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTripServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTripServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTripServiceStub(
      TripServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateTripRequest, Trip> createTripTransportSettings =
        GrpcCallSettings.<CreateTripRequest, Trip>newBuilder()
            .setMethodDescriptor(createTripMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "provider_id", CREATE_TRIP_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTripRequest, Trip> getTripTransportSettings =
        GrpcCallSettings.<GetTripRequest, Trip>newBuilder()
            .setMethodDescriptor(getTripMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "provider_id", GET_TRIP_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReportBillableTripRequest, Empty> reportBillableTripTransportSettings =
        GrpcCallSettings.<ReportBillableTripRequest, Empty>newBuilder()
            .setMethodDescriptor(reportBillableTripMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      request.getName(), "provider_id", REPORT_BILLABLE_TRIP_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchTripsRequest, SearchTripsResponse> searchTripsTransportSettings =
        GrpcCallSettings.<SearchTripsRequest, SearchTripsResponse>newBuilder()
            .setMethodDescriptor(searchTripsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "provider_id", SEARCH_TRIPS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTripRequest, Trip> updateTripTransportSettings =
        GrpcCallSettings.<UpdateTripRequest, Trip>newBuilder()
            .setMethodDescriptor(updateTripMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "provider_id", UPDATE_TRIP_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();

    this.createTripCallable =
        callableFactory.createUnaryCallable(
            createTripTransportSettings, settings.createTripSettings(), clientContext);
    this.getTripCallable =
        callableFactory.createUnaryCallable(
            getTripTransportSettings, settings.getTripSettings(), clientContext);
    this.reportBillableTripCallable =
        callableFactory.createUnaryCallable(
            reportBillableTripTransportSettings,
            settings.reportBillableTripSettings(),
            clientContext);
    this.searchTripsCallable =
        callableFactory.createUnaryCallable(
            searchTripsTransportSettings, settings.searchTripsSettings(), clientContext);
    this.searchTripsPagedCallable =
        callableFactory.createPagedCallable(
            searchTripsTransportSettings, settings.searchTripsSettings(), clientContext);
    this.updateTripCallable =
        callableFactory.createUnaryCallable(
            updateTripTransportSettings, settings.updateTripSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateTripRequest, Trip> createTripCallable() {
    return createTripCallable;
  }

  @Override
  public UnaryCallable<GetTripRequest, Trip> getTripCallable() {
    return getTripCallable;
  }

  @Override
  public UnaryCallable<ReportBillableTripRequest, Empty> reportBillableTripCallable() {
    return reportBillableTripCallable;
  }

  @Override
  public UnaryCallable<SearchTripsRequest, SearchTripsResponse> searchTripsCallable() {
    return searchTripsCallable;
  }

  @Override
  public UnaryCallable<SearchTripsRequest, SearchTripsPagedResponse> searchTripsPagedCallable() {
    return searchTripsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateTripRequest, Trip> updateTripCallable() {
    return updateTripCallable;
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

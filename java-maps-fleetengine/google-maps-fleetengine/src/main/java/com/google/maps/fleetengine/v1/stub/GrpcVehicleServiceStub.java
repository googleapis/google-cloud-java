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

import static google.maps.fleetengine.v1.VehicleServiceClient.ListVehiclesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.longrunning.stub.GrpcOperationsStub;
import google.maps.fleetengine.v1.CreateVehicleRequest;
import google.maps.fleetengine.v1.GetVehicleRequest;
import google.maps.fleetengine.v1.ListVehiclesRequest;
import google.maps.fleetengine.v1.ListVehiclesResponse;
import google.maps.fleetengine.v1.SearchVehiclesRequest;
import google.maps.fleetengine.v1.SearchVehiclesResponse;
import google.maps.fleetengine.v1.UpdateVehicleAttributesRequest;
import google.maps.fleetengine.v1.UpdateVehicleAttributesResponse;
import google.maps.fleetengine.v1.UpdateVehicleLocationRequest;
import google.maps.fleetengine.v1.UpdateVehicleRequest;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.VehicleLocation;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the VehicleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcVehicleServiceStub extends VehicleServiceStub {
  private static final MethodDescriptor<CreateVehicleRequest, Vehicle>
      createVehicleMethodDescriptor =
          MethodDescriptor.<CreateVehicleRequest, Vehicle>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.VehicleService/CreateVehicle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Vehicle.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVehicleRequest, Vehicle> getVehicleMethodDescriptor =
      MethodDescriptor.<GetVehicleRequest, Vehicle>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("maps.fleetengine.v1.VehicleService/GetVehicle")
          .setRequestMarshaller(ProtoUtils.marshaller(GetVehicleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Vehicle.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateVehicleRequest, Vehicle>
      updateVehicleMethodDescriptor =
          MethodDescriptor.<UpdateVehicleRequest, Vehicle>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.VehicleService/UpdateVehicle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateVehicleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Vehicle.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateVehicleLocationRequest, VehicleLocation>
      updateVehicleLocationMethodDescriptor =
          MethodDescriptor.<UpdateVehicleLocationRequest, VehicleLocation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.VehicleService/UpdateVehicleLocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateVehicleLocationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VehicleLocation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
      updateVehicleAttributesMethodDescriptor =
          MethodDescriptor
              .<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.VehicleService/UpdateVehicleAttributes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateVehicleAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UpdateVehicleAttributesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVehiclesRequest, ListVehiclesResponse>
      listVehiclesMethodDescriptor =
          MethodDescriptor.<ListVehiclesRequest, ListVehiclesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.VehicleService/ListVehicles")
              .setRequestMarshaller(ProtoUtils.marshaller(ListVehiclesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVehiclesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchVehiclesRequest, SearchVehiclesResponse>
      searchVehiclesMethodDescriptor =
          MethodDescriptor.<SearchVehiclesRequest, SearchVehiclesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.VehicleService/SearchVehicles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchVehiclesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchVehiclesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchVehiclesRequest, SearchVehiclesResponse>
      searchFuzzedVehiclesMethodDescriptor =
          MethodDescriptor.<SearchVehiclesRequest, SearchVehiclesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("maps.fleetengine.v1.VehicleService/SearchFuzzedVehicles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchVehiclesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchVehiclesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateVehicleRequest, Vehicle> createVehicleCallable;
  private final UnaryCallable<GetVehicleRequest, Vehicle> getVehicleCallable;
  private final UnaryCallable<UpdateVehicleRequest, Vehicle> updateVehicleCallable;
  private final UnaryCallable<UpdateVehicleLocationRequest, VehicleLocation>
      updateVehicleLocationCallable;
  private final UnaryCallable<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
      updateVehicleAttributesCallable;
  private final UnaryCallable<ListVehiclesRequest, ListVehiclesResponse> listVehiclesCallable;
  private final UnaryCallable<ListVehiclesRequest, ListVehiclesPagedResponse>
      listVehiclesPagedCallable;
  private final UnaryCallable<SearchVehiclesRequest, SearchVehiclesResponse> searchVehiclesCallable;
  private final UnaryCallable<SearchVehiclesRequest, SearchVehiclesResponse>
      searchFuzzedVehiclesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate GET_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate UPDATE_VEHICLE_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate UPDATE_VEHICLE_LOCATION_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate UPDATE_VEHICLE_ATTRIBUTES_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate LIST_VEHICLES_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate SEARCH_VEHICLES_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");
  private static final PathTemplate SEARCH_FUZZED_VEHICLES_0_PATH_TEMPLATE =
      PathTemplate.create("{provider_id=providers/*}");

  public static final GrpcVehicleServiceStub create(VehicleServiceStubSettings settings)
      throws IOException {
    return new GrpcVehicleServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVehicleServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcVehicleServiceStub(
        VehicleServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVehicleServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVehicleServiceStub(
        VehicleServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVehicleServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVehicleServiceStub(VehicleServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcVehicleServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVehicleServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVehicleServiceStub(
      VehicleServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateVehicleRequest, Vehicle> createVehicleTransportSettings =
        GrpcCallSettings.<CreateVehicleRequest, Vehicle>newBuilder()
            .setMethodDescriptor(createVehicleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "provider_id", CREATE_VEHICLE_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetVehicleRequest, Vehicle> getVehicleTransportSettings =
        GrpcCallSettings.<GetVehicleRequest, Vehicle>newBuilder()
            .setMethodDescriptor(getVehicleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "provider_id", GET_VEHICLE_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateVehicleRequest, Vehicle> updateVehicleTransportSettings =
        GrpcCallSettings.<UpdateVehicleRequest, Vehicle>newBuilder()
            .setMethodDescriptor(updateVehicleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "provider_id", UPDATE_VEHICLE_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateVehicleLocationRequest, VehicleLocation>
        updateVehicleLocationTransportSettings =
            GrpcCallSettings.<UpdateVehicleLocationRequest, VehicleLocation>newBuilder()
                .setMethodDescriptor(updateVehicleLocationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(),
                          "provider_id",
                          UPDATE_VEHICLE_LOCATION_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
        updateVehicleAttributesTransportSettings =
            GrpcCallSettings
                .<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>newBuilder()
                .setMethodDescriptor(updateVehicleAttributesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(),
                          "provider_id",
                          UPDATE_VEHICLE_ATTRIBUTES_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListVehiclesRequest, ListVehiclesResponse> listVehiclesTransportSettings =
        GrpcCallSettings.<ListVehiclesRequest, ListVehiclesResponse>newBuilder()
            .setMethodDescriptor(listVehiclesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "provider_id", LIST_VEHICLES_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchVehiclesRequest, SearchVehiclesResponse>
        searchVehiclesTransportSettings =
            GrpcCallSettings.<SearchVehiclesRequest, SearchVehiclesResponse>newBuilder()
                .setMethodDescriptor(searchVehiclesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "provider_id", SEARCH_VEHICLES_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchVehiclesRequest, SearchVehiclesResponse>
        searchFuzzedVehiclesTransportSettings =
            GrpcCallSettings.<SearchVehiclesRequest, SearchVehiclesResponse>newBuilder()
                .setMethodDescriptor(searchFuzzedVehiclesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(),
                          "provider_id",
                          SEARCH_FUZZED_VEHICLES_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();

    this.createVehicleCallable =
        callableFactory.createUnaryCallable(
            createVehicleTransportSettings, settings.createVehicleSettings(), clientContext);
    this.getVehicleCallable =
        callableFactory.createUnaryCallable(
            getVehicleTransportSettings, settings.getVehicleSettings(), clientContext);
    this.updateVehicleCallable =
        callableFactory.createUnaryCallable(
            updateVehicleTransportSettings, settings.updateVehicleSettings(), clientContext);
    this.updateVehicleLocationCallable =
        callableFactory.createUnaryCallable(
            updateVehicleLocationTransportSettings,
            settings.updateVehicleLocationSettings(),
            clientContext);
    this.updateVehicleAttributesCallable =
        callableFactory.createUnaryCallable(
            updateVehicleAttributesTransportSettings,
            settings.updateVehicleAttributesSettings(),
            clientContext);
    this.listVehiclesCallable =
        callableFactory.createUnaryCallable(
            listVehiclesTransportSettings, settings.listVehiclesSettings(), clientContext);
    this.listVehiclesPagedCallable =
        callableFactory.createPagedCallable(
            listVehiclesTransportSettings, settings.listVehiclesSettings(), clientContext);
    this.searchVehiclesCallable =
        callableFactory.createUnaryCallable(
            searchVehiclesTransportSettings, settings.searchVehiclesSettings(), clientContext);
    this.searchFuzzedVehiclesCallable =
        callableFactory.createUnaryCallable(
            searchFuzzedVehiclesTransportSettings,
            settings.searchFuzzedVehiclesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateVehicleRequest, Vehicle> createVehicleCallable() {
    return createVehicleCallable;
  }

  @Override
  public UnaryCallable<GetVehicleRequest, Vehicle> getVehicleCallable() {
    return getVehicleCallable;
  }

  @Override
  public UnaryCallable<UpdateVehicleRequest, Vehicle> updateVehicleCallable() {
    return updateVehicleCallable;
  }

  @Override
  public UnaryCallable<UpdateVehicleLocationRequest, VehicleLocation>
      updateVehicleLocationCallable() {
    return updateVehicleLocationCallable;
  }

  @Override
  public UnaryCallable<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
      updateVehicleAttributesCallable() {
    return updateVehicleAttributesCallable;
  }

  @Override
  public UnaryCallable<ListVehiclesRequest, ListVehiclesResponse> listVehiclesCallable() {
    return listVehiclesCallable;
  }

  @Override
  public UnaryCallable<ListVehiclesRequest, ListVehiclesPagedResponse> listVehiclesPagedCallable() {
    return listVehiclesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchVehiclesRequest, SearchVehiclesResponse> searchVehiclesCallable() {
    return searchVehiclesCallable;
  }

  @Override
  public UnaryCallable<SearchVehiclesRequest, SearchVehiclesResponse>
      searchFuzzedVehiclesCallable() {
    return searchFuzzedVehiclesCallable;
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

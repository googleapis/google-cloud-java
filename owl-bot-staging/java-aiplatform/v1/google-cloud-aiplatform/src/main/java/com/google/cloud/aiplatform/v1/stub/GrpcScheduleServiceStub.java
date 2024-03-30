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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.ScheduleServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.ScheduleServiceClient.ListSchedulesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateScheduleRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeleteScheduleRequest;
import com.google.cloud.aiplatform.v1.GetScheduleRequest;
import com.google.cloud.aiplatform.v1.ListSchedulesRequest;
import com.google.cloud.aiplatform.v1.ListSchedulesResponse;
import com.google.cloud.aiplatform.v1.PauseScheduleRequest;
import com.google.cloud.aiplatform.v1.ResumeScheduleRequest;
import com.google.cloud.aiplatform.v1.Schedule;
import com.google.cloud.aiplatform.v1.UpdateScheduleRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ScheduleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcScheduleServiceStub extends ScheduleServiceStub {
  private static final MethodDescriptor<CreateScheduleRequest, Schedule>
      createScheduleMethodDescriptor =
          MethodDescriptor.<CreateScheduleRequest, Schedule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ScheduleService/CreateSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Schedule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteScheduleRequest, Operation>
      deleteScheduleMethodDescriptor =
          MethodDescriptor.<DeleteScheduleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ScheduleService/DeleteSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetScheduleRequest, Schedule> getScheduleMethodDescriptor =
      MethodDescriptor.<GetScheduleRequest, Schedule>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.ScheduleService/GetSchedule")
          .setRequestMarshaller(ProtoUtils.marshaller(GetScheduleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Schedule.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSchedulesRequest, ListSchedulesResponse>
      listSchedulesMethodDescriptor =
          MethodDescriptor.<ListSchedulesRequest, ListSchedulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ScheduleService/ListSchedules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSchedulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSchedulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PauseScheduleRequest, Empty> pauseScheduleMethodDescriptor =
      MethodDescriptor.<PauseScheduleRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.ScheduleService/PauseSchedule")
          .setRequestMarshaller(ProtoUtils.marshaller(PauseScheduleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ResumeScheduleRequest, Empty>
      resumeScheduleMethodDescriptor =
          MethodDescriptor.<ResumeScheduleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ScheduleService/ResumeSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResumeScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateScheduleRequest, Schedule>
      updateScheduleMethodDescriptor =
          MethodDescriptor.<UpdateScheduleRequest, Schedule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ScheduleService/UpdateSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Schedule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateScheduleRequest, Schedule> createScheduleCallable;
  private final UnaryCallable<DeleteScheduleRequest, Operation> deleteScheduleCallable;
  private final OperationCallable<DeleteScheduleRequest, Empty, DeleteOperationMetadata>
      deleteScheduleOperationCallable;
  private final UnaryCallable<GetScheduleRequest, Schedule> getScheduleCallable;
  private final UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> listSchedulesCallable;
  private final UnaryCallable<ListSchedulesRequest, ListSchedulesPagedResponse>
      listSchedulesPagedCallable;
  private final UnaryCallable<PauseScheduleRequest, Empty> pauseScheduleCallable;
  private final UnaryCallable<ResumeScheduleRequest, Empty> resumeScheduleCallable;
  private final UnaryCallable<UpdateScheduleRequest, Schedule> updateScheduleCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcScheduleServiceStub create(ScheduleServiceStubSettings settings)
      throws IOException {
    return new GrpcScheduleServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcScheduleServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcScheduleServiceStub(
        ScheduleServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcScheduleServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcScheduleServiceStub(
        ScheduleServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcScheduleServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcScheduleServiceStub(
      ScheduleServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcScheduleServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcScheduleServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcScheduleServiceStub(
      ScheduleServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateScheduleRequest, Schedule> createScheduleTransportSettings =
        GrpcCallSettings.<CreateScheduleRequest, Schedule>newBuilder()
            .setMethodDescriptor(createScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteScheduleRequest, Operation> deleteScheduleTransportSettings =
        GrpcCallSettings.<DeleteScheduleRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetScheduleRequest, Schedule> getScheduleTransportSettings =
        GrpcCallSettings.<GetScheduleRequest, Schedule>newBuilder()
            .setMethodDescriptor(getScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSchedulesRequest, ListSchedulesResponse> listSchedulesTransportSettings =
        GrpcCallSettings.<ListSchedulesRequest, ListSchedulesResponse>newBuilder()
            .setMethodDescriptor(listSchedulesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PauseScheduleRequest, Empty> pauseScheduleTransportSettings =
        GrpcCallSettings.<PauseScheduleRequest, Empty>newBuilder()
            .setMethodDescriptor(pauseScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResumeScheduleRequest, Empty> resumeScheduleTransportSettings =
        GrpcCallSettings.<ResumeScheduleRequest, Empty>newBuilder()
            .setMethodDescriptor(resumeScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateScheduleRequest, Schedule> updateScheduleTransportSettings =
        GrpcCallSettings.<UpdateScheduleRequest, Schedule>newBuilder()
            .setMethodDescriptor(updateScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("schedule.name", String.valueOf(request.getSchedule().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createScheduleCallable =
        callableFactory.createUnaryCallable(
            createScheduleTransportSettings, settings.createScheduleSettings(), clientContext);
    this.deleteScheduleCallable =
        callableFactory.createUnaryCallable(
            deleteScheduleTransportSettings, settings.deleteScheduleSettings(), clientContext);
    this.deleteScheduleOperationCallable =
        callableFactory.createOperationCallable(
            deleteScheduleTransportSettings,
            settings.deleteScheduleOperationSettings(),
            clientContext,
            operationsStub);
    this.getScheduleCallable =
        callableFactory.createUnaryCallable(
            getScheduleTransportSettings, settings.getScheduleSettings(), clientContext);
    this.listSchedulesCallable =
        callableFactory.createUnaryCallable(
            listSchedulesTransportSettings, settings.listSchedulesSettings(), clientContext);
    this.listSchedulesPagedCallable =
        callableFactory.createPagedCallable(
            listSchedulesTransportSettings, settings.listSchedulesSettings(), clientContext);
    this.pauseScheduleCallable =
        callableFactory.createUnaryCallable(
            pauseScheduleTransportSettings, settings.pauseScheduleSettings(), clientContext);
    this.resumeScheduleCallable =
        callableFactory.createUnaryCallable(
            resumeScheduleTransportSettings, settings.resumeScheduleSettings(), clientContext);
    this.updateScheduleCallable =
        callableFactory.createUnaryCallable(
            updateScheduleTransportSettings, settings.updateScheduleSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateScheduleRequest, Schedule> createScheduleCallable() {
    return createScheduleCallable;
  }

  @Override
  public UnaryCallable<DeleteScheduleRequest, Operation> deleteScheduleCallable() {
    return deleteScheduleCallable;
  }

  @Override
  public OperationCallable<DeleteScheduleRequest, Empty, DeleteOperationMetadata>
      deleteScheduleOperationCallable() {
    return deleteScheduleOperationCallable;
  }

  @Override
  public UnaryCallable<GetScheduleRequest, Schedule> getScheduleCallable() {
    return getScheduleCallable;
  }

  @Override
  public UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> listSchedulesCallable() {
    return listSchedulesCallable;
  }

  @Override
  public UnaryCallable<ListSchedulesRequest, ListSchedulesPagedResponse>
      listSchedulesPagedCallable() {
    return listSchedulesPagedCallable;
  }

  @Override
  public UnaryCallable<PauseScheduleRequest, Empty> pauseScheduleCallable() {
    return pauseScheduleCallable;
  }

  @Override
  public UnaryCallable<ResumeScheduleRequest, Empty> resumeScheduleCallable() {
    return resumeScheduleCallable;
  }

  @Override
  public UnaryCallable<UpdateScheduleRequest, Schedule> updateScheduleCallable() {
    return updateScheduleCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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

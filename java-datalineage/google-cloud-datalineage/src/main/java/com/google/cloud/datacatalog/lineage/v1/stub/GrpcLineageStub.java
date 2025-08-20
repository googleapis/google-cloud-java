/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.datacatalog.lineage.v1.stub;

import static com.google.cloud.datacatalog.lineage.v1.LineageClient.BatchSearchLinkProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListLineageEventsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListRunsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.SearchLinksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest;
import com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse;
import com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.CreateRunRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest;
import com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.GetProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.GetRunRequest;
import com.google.cloud.datacatalog.lineage.v1.LineageEvent;
import com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest;
import com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse;
import com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest;
import com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse;
import com.google.cloud.datacatalog.lineage.v1.ListRunsRequest;
import com.google.cloud.datacatalog.lineage.v1.ListRunsResponse;
import com.google.cloud.datacatalog.lineage.v1.OperationMetadata;
import com.google.cloud.datacatalog.lineage.v1.Process;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventRequest;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventResponse;
import com.google.cloud.datacatalog.lineage.v1.Run;
import com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest;
import com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse;
import com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Lineage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLineageStub extends LineageStub {
  private static final MethodDescriptor<
          ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventMethodDescriptor =
          MethodDescriptor
              .<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.lineage.v1.Lineage/ProcessOpenLineageRunEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProcessOpenLineageRunEventRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ProcessOpenLineageRunEventResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateProcessRequest, Process>
      createProcessMethodDescriptor =
          MethodDescriptor.<CreateProcessRequest, Process>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/CreateProcess")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Process.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateProcessRequest, Process>
      updateProcessMethodDescriptor =
          MethodDescriptor.<UpdateProcessRequest, Process>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/UpdateProcess")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Process.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetProcessRequest, Process> getProcessMethodDescriptor =
      MethodDescriptor.<GetProcessRequest, Process>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/GetProcess")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProcessRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Process.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListProcessesRequest, ListProcessesResponse>
      listProcessesMethodDescriptor =
          MethodDescriptor.<ListProcessesRequest, ListProcessesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/ListProcesses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProcessesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProcessesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteProcessRequest, Operation>
      deleteProcessMethodDescriptor =
          MethodDescriptor.<DeleteProcessRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/DeleteProcess")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateRunRequest, Run> createRunMethodDescriptor =
      MethodDescriptor.<CreateRunRequest, Run>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/CreateRun")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Run.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateRunRequest, Run> updateRunMethodDescriptor =
      MethodDescriptor.<UpdateRunRequest, Run>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/UpdateRun")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateRunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Run.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetRunRequest, Run> getRunMethodDescriptor =
      MethodDescriptor.<GetRunRequest, Run>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/GetRun")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Run.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListRunsRequest, ListRunsResponse>
      listRunsMethodDescriptor =
          MethodDescriptor.<ListRunsRequest, ListRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/ListRuns")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRunsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteRunRequest, Operation> deleteRunMethodDescriptor =
      MethodDescriptor.<DeleteRunRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/DeleteRun")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateLineageEventRequest, LineageEvent>
      createLineageEventMethodDescriptor =
          MethodDescriptor.<CreateLineageEventRequest, LineageEvent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/CreateLineageEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateLineageEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LineageEvent.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLineageEventRequest, LineageEvent>
      getLineageEventMethodDescriptor =
          MethodDescriptor.<GetLineageEventRequest, LineageEvent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/GetLineageEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLineageEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LineageEvent.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLineageEventsRequest, ListLineageEventsResponse>
      listLineageEventsMethodDescriptor =
          MethodDescriptor.<ListLineageEventsRequest, ListLineageEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/ListLineageEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLineageEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLineageEventsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteLineageEventRequest, Empty>
      deleteLineageEventMethodDescriptor =
          MethodDescriptor.<DeleteLineageEventRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/DeleteLineageEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteLineageEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchLinksRequest, SearchLinksResponse>
      searchLinksMethodDescriptor =
          MethodDescriptor.<SearchLinksRequest, SearchLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/SearchLinks")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchLinksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
      batchSearchLinkProcessesMethodDescriptor =
          MethodDescriptor
              .<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.lineage.v1.Lineage/BatchSearchLinkProcesses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchSearchLinkProcessesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchSearchLinkProcessesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventCallable;
  private final UnaryCallable<CreateProcessRequest, Process> createProcessCallable;
  private final UnaryCallable<UpdateProcessRequest, Process> updateProcessCallable;
  private final UnaryCallable<GetProcessRequest, Process> getProcessCallable;
  private final UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable;
  private final UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable;
  private final UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable;
  private final OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable;
  private final UnaryCallable<CreateRunRequest, Run> createRunCallable;
  private final UnaryCallable<UpdateRunRequest, Run> updateRunCallable;
  private final UnaryCallable<GetRunRequest, Run> getRunCallable;
  private final UnaryCallable<ListRunsRequest, ListRunsResponse> listRunsCallable;
  private final UnaryCallable<ListRunsRequest, ListRunsPagedResponse> listRunsPagedCallable;
  private final UnaryCallable<DeleteRunRequest, Operation> deleteRunCallable;
  private final OperationCallable<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationCallable;
  private final UnaryCallable<CreateLineageEventRequest, LineageEvent> createLineageEventCallable;
  private final UnaryCallable<GetLineageEventRequest, LineageEvent> getLineageEventCallable;
  private final UnaryCallable<ListLineageEventsRequest, ListLineageEventsResponse>
      listLineageEventsCallable;
  private final UnaryCallable<ListLineageEventsRequest, ListLineageEventsPagedResponse>
      listLineageEventsPagedCallable;
  private final UnaryCallable<DeleteLineageEventRequest, Empty> deleteLineageEventCallable;
  private final UnaryCallable<SearchLinksRequest, SearchLinksResponse> searchLinksCallable;
  private final UnaryCallable<SearchLinksRequest, SearchLinksPagedResponse>
      searchLinksPagedCallable;
  private final UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
      batchSearchLinkProcessesCallable;
  private final UnaryCallable<
          BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLineageStub create(LineageStubSettings settings) throws IOException {
    return new GrpcLineageStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLineageStub create(ClientContext clientContext) throws IOException {
    return new GrpcLineageStub(LineageStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLineageStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLineageStub(
        LineageStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLineageStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcLineageStub(LineageStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcLineageCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLineageStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcLineageStub(
      LineageStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
        processOpenLineageRunEventTransportSettings =
            GrpcCallSettings
                .<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>newBuilder()
                .setMethodDescriptor(processOpenLineageRunEventMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateProcessRequest, Process> createProcessTransportSettings =
        GrpcCallSettings.<CreateProcessRequest, Process>newBuilder()
            .setMethodDescriptor(createProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateProcessRequest, Process> updateProcessTransportSettings =
        GrpcCallSettings.<UpdateProcessRequest, Process>newBuilder()
            .setMethodDescriptor(updateProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("process.name", String.valueOf(request.getProcess().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetProcessRequest, Process> getProcessTransportSettings =
        GrpcCallSettings.<GetProcessRequest, Process>newBuilder()
            .setMethodDescriptor(getProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListProcessesRequest, ListProcessesResponse> listProcessesTransportSettings =
        GrpcCallSettings.<ListProcessesRequest, ListProcessesResponse>newBuilder()
            .setMethodDescriptor(listProcessesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteProcessRequest, Operation> deleteProcessTransportSettings =
        GrpcCallSettings.<DeleteProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateRunRequest, Run> createRunTransportSettings =
        GrpcCallSettings.<CreateRunRequest, Run>newBuilder()
            .setMethodDescriptor(createRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateRunRequest, Run> updateRunTransportSettings =
        GrpcCallSettings.<UpdateRunRequest, Run>newBuilder()
            .setMethodDescriptor(updateRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("run.name", String.valueOf(request.getRun().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRunRequest, Run> getRunTransportSettings =
        GrpcCallSettings.<GetRunRequest, Run>newBuilder()
            .setMethodDescriptor(getRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRunsRequest, ListRunsResponse> listRunsTransportSettings =
        GrpcCallSettings.<ListRunsRequest, ListRunsResponse>newBuilder()
            .setMethodDescriptor(listRunsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRunRequest, Operation> deleteRunTransportSettings =
        GrpcCallSettings.<DeleteRunRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateLineageEventRequest, LineageEvent> createLineageEventTransportSettings =
        GrpcCallSettings.<CreateLineageEventRequest, LineageEvent>newBuilder()
            .setMethodDescriptor(createLineageEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLineageEventRequest, LineageEvent> getLineageEventTransportSettings =
        GrpcCallSettings.<GetLineageEventRequest, LineageEvent>newBuilder()
            .setMethodDescriptor(getLineageEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLineageEventsRequest, ListLineageEventsResponse>
        listLineageEventsTransportSettings =
            GrpcCallSettings.<ListLineageEventsRequest, ListLineageEventsResponse>newBuilder()
                .setMethodDescriptor(listLineageEventsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteLineageEventRequest, Empty> deleteLineageEventTransportSettings =
        GrpcCallSettings.<DeleteLineageEventRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLineageEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchLinksRequest, SearchLinksResponse> searchLinksTransportSettings =
        GrpcCallSettings.<SearchLinksRequest, SearchLinksResponse>newBuilder()
            .setMethodDescriptor(searchLinksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
        batchSearchLinkProcessesTransportSettings =
            GrpcCallSettings
                .<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>newBuilder()
                .setMethodDescriptor(batchSearchLinkProcessesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.processOpenLineageRunEventCallable =
        callableFactory.createUnaryCallable(
            processOpenLineageRunEventTransportSettings,
            settings.processOpenLineageRunEventSettings(),
            clientContext);
    this.createProcessCallable =
        callableFactory.createUnaryCallable(
            createProcessTransportSettings, settings.createProcessSettings(), clientContext);
    this.updateProcessCallable =
        callableFactory.createUnaryCallable(
            updateProcessTransportSettings, settings.updateProcessSettings(), clientContext);
    this.getProcessCallable =
        callableFactory.createUnaryCallable(
            getProcessTransportSettings, settings.getProcessSettings(), clientContext);
    this.listProcessesCallable =
        callableFactory.createUnaryCallable(
            listProcessesTransportSettings, settings.listProcessesSettings(), clientContext);
    this.listProcessesPagedCallable =
        callableFactory.createPagedCallable(
            listProcessesTransportSettings, settings.listProcessesSettings(), clientContext);
    this.deleteProcessCallable =
        callableFactory.createUnaryCallable(
            deleteProcessTransportSettings, settings.deleteProcessSettings(), clientContext);
    this.deleteProcessOperationCallable =
        callableFactory.createOperationCallable(
            deleteProcessTransportSettings,
            settings.deleteProcessOperationSettings(),
            clientContext,
            operationsStub);
    this.createRunCallable =
        callableFactory.createUnaryCallable(
            createRunTransportSettings, settings.createRunSettings(), clientContext);
    this.updateRunCallable =
        callableFactory.createUnaryCallable(
            updateRunTransportSettings, settings.updateRunSettings(), clientContext);
    this.getRunCallable =
        callableFactory.createUnaryCallable(
            getRunTransportSettings, settings.getRunSettings(), clientContext);
    this.listRunsCallable =
        callableFactory.createUnaryCallable(
            listRunsTransportSettings, settings.listRunsSettings(), clientContext);
    this.listRunsPagedCallable =
        callableFactory.createPagedCallable(
            listRunsTransportSettings, settings.listRunsSettings(), clientContext);
    this.deleteRunCallable =
        callableFactory.createUnaryCallable(
            deleteRunTransportSettings, settings.deleteRunSettings(), clientContext);
    this.deleteRunOperationCallable =
        callableFactory.createOperationCallable(
            deleteRunTransportSettings,
            settings.deleteRunOperationSettings(),
            clientContext,
            operationsStub);
    this.createLineageEventCallable =
        callableFactory.createUnaryCallable(
            createLineageEventTransportSettings,
            settings.createLineageEventSettings(),
            clientContext);
    this.getLineageEventCallable =
        callableFactory.createUnaryCallable(
            getLineageEventTransportSettings, settings.getLineageEventSettings(), clientContext);
    this.listLineageEventsCallable =
        callableFactory.createUnaryCallable(
            listLineageEventsTransportSettings,
            settings.listLineageEventsSettings(),
            clientContext);
    this.listLineageEventsPagedCallable =
        callableFactory.createPagedCallable(
            listLineageEventsTransportSettings,
            settings.listLineageEventsSettings(),
            clientContext);
    this.deleteLineageEventCallable =
        callableFactory.createUnaryCallable(
            deleteLineageEventTransportSettings,
            settings.deleteLineageEventSettings(),
            clientContext);
    this.searchLinksCallable =
        callableFactory.createUnaryCallable(
            searchLinksTransportSettings, settings.searchLinksSettings(), clientContext);
    this.searchLinksPagedCallable =
        callableFactory.createPagedCallable(
            searchLinksTransportSettings, settings.searchLinksSettings(), clientContext);
    this.batchSearchLinkProcessesCallable =
        callableFactory.createUnaryCallable(
            batchSearchLinkProcessesTransportSettings,
            settings.batchSearchLinkProcessesSettings(),
            clientContext);
    this.batchSearchLinkProcessesPagedCallable =
        callableFactory.createPagedCallable(
            batchSearchLinkProcessesTransportSettings,
            settings.batchSearchLinkProcessesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventCallable() {
    return processOpenLineageRunEventCallable;
  }

  @Override
  public UnaryCallable<CreateProcessRequest, Process> createProcessCallable() {
    return createProcessCallable;
  }

  @Override
  public UnaryCallable<UpdateProcessRequest, Process> updateProcessCallable() {
    return updateProcessCallable;
  }

  @Override
  public UnaryCallable<GetProcessRequest, Process> getProcessCallable() {
    return getProcessCallable;
  }

  @Override
  public UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable() {
    return listProcessesCallable;
  }

  @Override
  public UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable() {
    return listProcessesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable() {
    return deleteProcessCallable;
  }

  @Override
  public OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable() {
    return deleteProcessOperationCallable;
  }

  @Override
  public UnaryCallable<CreateRunRequest, Run> createRunCallable() {
    return createRunCallable;
  }

  @Override
  public UnaryCallable<UpdateRunRequest, Run> updateRunCallable() {
    return updateRunCallable;
  }

  @Override
  public UnaryCallable<GetRunRequest, Run> getRunCallable() {
    return getRunCallable;
  }

  @Override
  public UnaryCallable<ListRunsRequest, ListRunsResponse> listRunsCallable() {
    return listRunsCallable;
  }

  @Override
  public UnaryCallable<ListRunsRequest, ListRunsPagedResponse> listRunsPagedCallable() {
    return listRunsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRunRequest, Operation> deleteRunCallable() {
    return deleteRunCallable;
  }

  @Override
  public OperationCallable<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationCallable() {
    return deleteRunOperationCallable;
  }

  @Override
  public UnaryCallable<CreateLineageEventRequest, LineageEvent> createLineageEventCallable() {
    return createLineageEventCallable;
  }

  @Override
  public UnaryCallable<GetLineageEventRequest, LineageEvent> getLineageEventCallable() {
    return getLineageEventCallable;
  }

  @Override
  public UnaryCallable<ListLineageEventsRequest, ListLineageEventsResponse>
      listLineageEventsCallable() {
    return listLineageEventsCallable;
  }

  @Override
  public UnaryCallable<ListLineageEventsRequest, ListLineageEventsPagedResponse>
      listLineageEventsPagedCallable() {
    return listLineageEventsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteLineageEventRequest, Empty> deleteLineageEventCallable() {
    return deleteLineageEventCallable;
  }

  @Override
  public UnaryCallable<SearchLinksRequest, SearchLinksResponse> searchLinksCallable() {
    return searchLinksCallable;
  }

  @Override
  public UnaryCallable<SearchLinksRequest, SearchLinksPagedResponse> searchLinksPagedCallable() {
    return searchLinksPagedCallable;
  }

  @Override
  public UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
      batchSearchLinkProcessesCallable() {
    return batchSearchLinkProcessesCallable;
  }

  @Override
  public UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesPagedCallable() {
    return batchSearchLinkProcessesPagedCallable;
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

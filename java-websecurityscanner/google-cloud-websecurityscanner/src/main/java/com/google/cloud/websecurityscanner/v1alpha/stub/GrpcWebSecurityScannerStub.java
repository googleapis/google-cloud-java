/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.websecurityscanner.v1alpha.stub;

import static com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerClient.ListCrawledUrlsPagedResponse;
import static com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerClient.ListFindingsPagedResponse;
import static com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerClient.ListScanConfigsPagedResponse;
import static com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerClient.ListScanRunsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest;
import com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest;
import com.google.cloud.websecurityscanner.v1alpha.Finding;
import com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest;
import com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest;
import com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ScanConfig;
import com.google.cloud.websecurityscanner.v1alpha.ScanRun;
import com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest;
import com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest;
import com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the WebSecurityScanner service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcWebSecurityScannerStub extends WebSecurityScannerStub {
  private static final MethodDescriptor<CreateScanConfigRequest, ScanConfig>
      createScanConfigMethodDescriptor =
          MethodDescriptor.<CreateScanConfigRequest, ScanConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/CreateScanConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateScanConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ScanConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteScanConfigRequest, Empty>
      deleteScanConfigMethodDescriptor =
          MethodDescriptor.<DeleteScanConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/DeleteScanConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteScanConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetScanConfigRequest, ScanConfig>
      getScanConfigMethodDescriptor =
          MethodDescriptor.<GetScanConfigRequest, ScanConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/GetScanConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetScanConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ScanConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListScanConfigsRequest, ListScanConfigsResponse>
      listScanConfigsMethodDescriptor =
          MethodDescriptor.<ListScanConfigsRequest, ListScanConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListScanConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListScanConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListScanConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateScanConfigRequest, ScanConfig>
      updateScanConfigMethodDescriptor =
          MethodDescriptor.<UpdateScanConfigRequest, ScanConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/UpdateScanConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateScanConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ScanConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartScanRunRequest, ScanRun> startScanRunMethodDescriptor =
      MethodDescriptor.<StartScanRunRequest, ScanRun>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/StartScanRun")
          .setRequestMarshaller(ProtoUtils.marshaller(StartScanRunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ScanRun.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetScanRunRequest, ScanRun> getScanRunMethodDescriptor =
      MethodDescriptor.<GetScanRunRequest, ScanRun>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/GetScanRun")
          .setRequestMarshaller(ProtoUtils.marshaller(GetScanRunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ScanRun.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListScanRunsRequest, ListScanRunsResponse>
      listScanRunsMethodDescriptor =
          MethodDescriptor.<ListScanRunsRequest, ListScanRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListScanRuns")
              .setRequestMarshaller(ProtoUtils.marshaller(ListScanRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListScanRunsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopScanRunRequest, ScanRun> stopScanRunMethodDescriptor =
      MethodDescriptor.<StopScanRunRequest, ScanRun>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/StopScanRun")
          .setRequestMarshaller(ProtoUtils.marshaller(StopScanRunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ScanRun.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListCrawledUrlsRequest, ListCrawledUrlsResponse>
      listCrawledUrlsMethodDescriptor =
          MethodDescriptor.<ListCrawledUrlsRequest, ListCrawledUrlsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListCrawledUrls")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCrawledUrlsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCrawledUrlsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFindingRequest, Finding> getFindingMethodDescriptor =
      MethodDescriptor.<GetFindingRequest, Finding>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/GetFinding")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFindingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListFindingsRequest, ListFindingsResponse>
      listFindingsMethodDescriptor =
          MethodDescriptor.<ListFindingsRequest, ListFindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListFindings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsMethodDescriptor =
          MethodDescriptor.<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListFindingTypeStats")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFindingTypeStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFindingTypeStatsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateScanConfigRequest, ScanConfig> createScanConfigCallable;
  private final UnaryCallable<DeleteScanConfigRequest, Empty> deleteScanConfigCallable;
  private final UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable;
  private final UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse>
      listScanConfigsCallable;
  private final UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable;
  private final UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable;
  private final UnaryCallable<StartScanRunRequest, ScanRun> startScanRunCallable;
  private final UnaryCallable<GetScanRunRequest, ScanRun> getScanRunCallable;
  private final UnaryCallable<ListScanRunsRequest, ListScanRunsResponse> listScanRunsCallable;
  private final UnaryCallable<ListScanRunsRequest, ListScanRunsPagedResponse>
      listScanRunsPagedCallable;
  private final UnaryCallable<StopScanRunRequest, ScanRun> stopScanRunCallable;
  private final UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsResponse>
      listCrawledUrlsCallable;
  private final UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsPagedResponse>
      listCrawledUrlsPagedCallable;
  private final UnaryCallable<GetFindingRequest, Finding> getFindingCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable;
  private final UnaryCallable<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWebSecurityScannerStub create(WebSecurityScannerStubSettings settings)
      throws IOException {
    return new GrpcWebSecurityScannerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWebSecurityScannerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcWebSecurityScannerStub(
        WebSecurityScannerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWebSecurityScannerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWebSecurityScannerStub(
        WebSecurityScannerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWebSecurityScannerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWebSecurityScannerStub(
      WebSecurityScannerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcWebSecurityScannerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWebSecurityScannerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWebSecurityScannerStub(
      WebSecurityScannerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateScanConfigRequest, ScanConfig> createScanConfigTransportSettings =
        GrpcCallSettings.<CreateScanConfigRequest, ScanConfig>newBuilder()
            .setMethodDescriptor(createScanConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateScanConfigRequest>() {
                  @Override
                  public Map<String, String> extract(CreateScanConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteScanConfigRequest, Empty> deleteScanConfigTransportSettings =
        GrpcCallSettings.<DeleteScanConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteScanConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteScanConfigRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteScanConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetScanConfigRequest, ScanConfig> getScanConfigTransportSettings =
        GrpcCallSettings.<GetScanConfigRequest, ScanConfig>newBuilder()
            .setMethodDescriptor(getScanConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetScanConfigRequest>() {
                  @Override
                  public Map<String, String> extract(GetScanConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListScanConfigsRequest, ListScanConfigsResponse>
        listScanConfigsTransportSettings =
            GrpcCallSettings.<ListScanConfigsRequest, ListScanConfigsResponse>newBuilder()
                .setMethodDescriptor(listScanConfigsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListScanConfigsRequest>() {
                      @Override
                      public Map<String, String> extract(ListScanConfigsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateScanConfigRequest, ScanConfig> updateScanConfigTransportSettings =
        GrpcCallSettings.<UpdateScanConfigRequest, ScanConfig>newBuilder()
            .setMethodDescriptor(updateScanConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateScanConfigRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateScanConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "scan_config.name", String.valueOf(request.getScanConfig().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<StartScanRunRequest, ScanRun> startScanRunTransportSettings =
        GrpcCallSettings.<StartScanRunRequest, ScanRun>newBuilder()
            .setMethodDescriptor(startScanRunMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<StartScanRunRequest>() {
                  @Override
                  public Map<String, String> extract(StartScanRunRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetScanRunRequest, ScanRun> getScanRunTransportSettings =
        GrpcCallSettings.<GetScanRunRequest, ScanRun>newBuilder()
            .setMethodDescriptor(getScanRunMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetScanRunRequest>() {
                  @Override
                  public Map<String, String> extract(GetScanRunRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListScanRunsRequest, ListScanRunsResponse> listScanRunsTransportSettings =
        GrpcCallSettings.<ListScanRunsRequest, ListScanRunsResponse>newBuilder()
            .setMethodDescriptor(listScanRunsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListScanRunsRequest>() {
                  @Override
                  public Map<String, String> extract(ListScanRunsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<StopScanRunRequest, ScanRun> stopScanRunTransportSettings =
        GrpcCallSettings.<StopScanRunRequest, ScanRun>newBuilder()
            .setMethodDescriptor(stopScanRunMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<StopScanRunRequest>() {
                  @Override
                  public Map<String, String> extract(StopScanRunRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListCrawledUrlsRequest, ListCrawledUrlsResponse>
        listCrawledUrlsTransportSettings =
            GrpcCallSettings.<ListCrawledUrlsRequest, ListCrawledUrlsResponse>newBuilder()
                .setMethodDescriptor(listCrawledUrlsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListCrawledUrlsRequest>() {
                      @Override
                      public Map<String, String> extract(ListCrawledUrlsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetFindingRequest, Finding> getFindingTransportSettings =
        GrpcCallSettings.<GetFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(getFindingMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetFindingRequest>() {
                  @Override
                  public Map<String, String> extract(GetFindingRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListFindingsRequest, ListFindingsResponse> listFindingsTransportSettings =
        GrpcCallSettings.<ListFindingsRequest, ListFindingsResponse>newBuilder()
            .setMethodDescriptor(listFindingsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListFindingsRequest>() {
                  @Override
                  public Map<String, String> extract(ListFindingsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
        listFindingTypeStatsTransportSettings =
            GrpcCallSettings.<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>newBuilder()
                .setMethodDescriptor(listFindingTypeStatsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListFindingTypeStatsRequest>() {
                      @Override
                      public Map<String, String> extract(ListFindingTypeStatsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.createScanConfigCallable =
        callableFactory.createUnaryCallable(
            createScanConfigTransportSettings, settings.createScanConfigSettings(), clientContext);
    this.deleteScanConfigCallable =
        callableFactory.createUnaryCallable(
            deleteScanConfigTransportSettings, settings.deleteScanConfigSettings(), clientContext);
    this.getScanConfigCallable =
        callableFactory.createUnaryCallable(
            getScanConfigTransportSettings, settings.getScanConfigSettings(), clientContext);
    this.listScanConfigsCallable =
        callableFactory.createUnaryCallable(
            listScanConfigsTransportSettings, settings.listScanConfigsSettings(), clientContext);
    this.listScanConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listScanConfigsTransportSettings, settings.listScanConfigsSettings(), clientContext);
    this.updateScanConfigCallable =
        callableFactory.createUnaryCallable(
            updateScanConfigTransportSettings, settings.updateScanConfigSettings(), clientContext);
    this.startScanRunCallable =
        callableFactory.createUnaryCallable(
            startScanRunTransportSettings, settings.startScanRunSettings(), clientContext);
    this.getScanRunCallable =
        callableFactory.createUnaryCallable(
            getScanRunTransportSettings, settings.getScanRunSettings(), clientContext);
    this.listScanRunsCallable =
        callableFactory.createUnaryCallable(
            listScanRunsTransportSettings, settings.listScanRunsSettings(), clientContext);
    this.listScanRunsPagedCallable =
        callableFactory.createPagedCallable(
            listScanRunsTransportSettings, settings.listScanRunsSettings(), clientContext);
    this.stopScanRunCallable =
        callableFactory.createUnaryCallable(
            stopScanRunTransportSettings, settings.stopScanRunSettings(), clientContext);
    this.listCrawledUrlsCallable =
        callableFactory.createUnaryCallable(
            listCrawledUrlsTransportSettings, settings.listCrawledUrlsSettings(), clientContext);
    this.listCrawledUrlsPagedCallable =
        callableFactory.createPagedCallable(
            listCrawledUrlsTransportSettings, settings.listCrawledUrlsSettings(), clientContext);
    this.getFindingCallable =
        callableFactory.createUnaryCallable(
            getFindingTransportSettings, settings.getFindingSettings(), clientContext);
    this.listFindingsCallable =
        callableFactory.createUnaryCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listFindingsPagedCallable =
        callableFactory.createPagedCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listFindingTypeStatsCallable =
        callableFactory.createUnaryCallable(
            listFindingTypeStatsTransportSettings,
            settings.listFindingTypeStatsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateScanConfigRequest, ScanConfig> createScanConfigCallable() {
    return createScanConfigCallable;
  }

  public UnaryCallable<DeleteScanConfigRequest, Empty> deleteScanConfigCallable() {
    return deleteScanConfigCallable;
  }

  public UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable() {
    return getScanConfigCallable;
  }

  public UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse> listScanConfigsCallable() {
    return listScanConfigsCallable;
  }

  public UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable() {
    return listScanConfigsPagedCallable;
  }

  public UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable() {
    return updateScanConfigCallable;
  }

  public UnaryCallable<StartScanRunRequest, ScanRun> startScanRunCallable() {
    return startScanRunCallable;
  }

  public UnaryCallable<GetScanRunRequest, ScanRun> getScanRunCallable() {
    return getScanRunCallable;
  }

  public UnaryCallable<ListScanRunsRequest, ListScanRunsResponse> listScanRunsCallable() {
    return listScanRunsCallable;
  }

  public UnaryCallable<ListScanRunsRequest, ListScanRunsPagedResponse> listScanRunsPagedCallable() {
    return listScanRunsPagedCallable;
  }

  public UnaryCallable<StopScanRunRequest, ScanRun> stopScanRunCallable() {
    return stopScanRunCallable;
  }

  public UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsResponse> listCrawledUrlsCallable() {
    return listCrawledUrlsCallable;
  }

  public UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsPagedResponse>
      listCrawledUrlsPagedCallable() {
    return listCrawledUrlsPagedCallable;
  }

  public UnaryCallable<GetFindingRequest, Finding> getFindingCallable() {
    return getFindingCallable;
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    return listFindingsCallable;
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    return listFindingsPagedCallable;
  }

  public UnaryCallable<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsCallable() {
    return listFindingTypeStatsCallable;
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

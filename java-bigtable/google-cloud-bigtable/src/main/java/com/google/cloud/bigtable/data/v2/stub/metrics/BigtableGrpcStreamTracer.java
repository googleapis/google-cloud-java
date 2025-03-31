/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsTracer.TransportAttrs;
import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import io.grpc.Status;

/**
 * Records the time a request is enqueued in a grpc channel queue. This a bridge between gRPC stream
 * tracing and Bigtable tracing. Its primary purpose is to measure the transition time between
 * asking gRPC to start an RPC and gRPC actually serializing that RPC.
 */
class BigtableGrpcStreamTracer extends ClientStreamTracer {
  private static final String GRPC_LB_LOCALITY_KEY = "grpc.lb.locality";
  private static final String GRPC_LB_BACKEND_SERVICE_KEY = "grpc.lb.backend_service";

  private final StreamInfo info;
  private final BigtableTracer tracer;
  private volatile String backendService = null;
  private volatile String locality = null;

  public BigtableGrpcStreamTracer(StreamInfo info, BigtableTracer tracer) {
    this.info = info;
    this.tracer = tracer;
  }

  @Override
  public void outboundMessageSent(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
    tracer.grpcMessageSent();
  }

  @Override
  public void addOptionalLabel(String key, String value) {
    switch (key) {
      case GRPC_LB_LOCALITY_KEY:
        this.locality = value;
        break;
      case GRPC_LB_BACKEND_SERVICE_KEY:
        this.backendService = value;
        break;
    }

    super.addOptionalLabel(key, value);
  }

  @Override
  public void streamClosed(Status status) {
    tracer.setTransportAttrs(TransportAttrs.create(locality, backendService));
    super.streamClosed(status);
  }

  static class Factory extends ClientStreamTracer.Factory {

    private final BigtableTracer tracer;

    Factory(BigtableTracer tracer) {
      this.tracer = tracer;
    }

    @Override
    public ClientStreamTracer newClientStreamTracer(
        ClientStreamTracer.StreamInfo info, Metadata headers) {
      return new BigtableGrpcStreamTracer(info, tracer);
    }
  }
}

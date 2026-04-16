/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.telemetry;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.opentelemetry.trace.TraceConfiguration;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Load test to verify gRPC channel load observability by sending traces to Cloud Trace.
 * This class has a main method and can be run standalone.
 */
public class GrpcChannelLoadSimulation {

  private static final Logger logger = Logger.getLogger(GrpcChannelLoadSimulation.class.getName());
  private static final String PROJECT_ID = "lawrence-test-project-2";
  private static final String DATABASE_ID = "test-datastore";
  private static final int NUM_REQUESTS = 120;
  private static final int CONCURRENCY = 20;

  public static void main(String[] args) throws Exception {
    logger.info("Starting gRPC Channel Load Simulation...");

    // 1. Initialize OpenTelemetry SDK with Cloud Trace Exporter
    TraceExporter traceExporter = TraceExporter.createWithConfiguration(
        TraceConfiguration.builder().setProjectId(PROJECT_ID).build());

    OpenTelemetrySdk openTelemetrySdk = OpenTelemetrySdk.builder()
        .setTracerProvider(
            SdkTracerProvider.builder()
                .addSpanProcessor(BatchSpanProcessor.builder(traceExporter).build())
                .setSampler(Sampler.alwaysOn())
                .build())
        .build();

    Tracer tracer = openTelemetrySdk.getTracer("load-test-tracer");

    // 2. Configure Datastore Options with pool size 1
    InstantiatingGrpcChannelProvider channelProvider = InstantiatingGrpcChannelProvider.newBuilder()
        .setPoolSize(1)
        .setChannelConfigurator(channelBuilder -> {
             io.opentelemetry.instrumentation.grpc.v1_6.GrpcTelemetry grpcTelemetry = io.opentelemetry.instrumentation.grpc.v1_6.GrpcTelemetry.create(openTelemetrySdk);
             return channelBuilder.intercept(
                 grpcTelemetry.newClientInterceptor(), new GrpcChannelLoadInterceptor());
        })
        .build();

    DatastoreOptions options = DatastoreOptions.newBuilder()
        .setProjectId(PROJECT_ID)
        .setDatabaseId(DATABASE_ID)
        .setChannelProvider(channelProvider)
        .setTransportOptions(com.google.cloud.grpc.GrpcTransportOptions.newBuilder().build())
        .setOpenTelemetryOptions(
            DatastoreOpenTelemetryOptions.newBuilder()
                .setOpenTelemetry(openTelemetrySdk)
                .setTracingEnabled(true)
                .build())
        .build();

    logger.info("Transport options class: " + options.getTransportOptions().getClass().getName());

    Datastore datastore = options.getService();
    String kind = "LoadTestKind";
    String keyName = "load-test-entity";

    // Ensure entity exists
    Key key = datastore.newKeyFactory().setKind(kind).newKey(keyName);
    Entity existing = datastore.get(key);
    if (existing == null) {
        datastore.put(Entity.newBuilder(key).set("test_data", "value").build());
    }

    // 3. Spawn multiple threads to send concurrent requests
    ExecutorService executor = Executors.newFixedThreadPool(CONCURRENCY);

    for (int i = 0; i < NUM_REQUESTS; i++) {
      final int requestId = i;
      executor.submit(() -> {
        Span span = tracer.spanBuilder("load-test-request-" + requestId).startSpan();
        try (Scope scope = span.makeCurrent()) {
          logger.info("Sending request " + requestId + ", current span: " + io.opentelemetry.api.trace.Span.current());
          datastore.get(key);
          logger.info("Received response for request " + requestId);
        } catch (Exception e) {
          logger.severe("Request " + requestId + " failed: " + e.getMessage());
          span.recordException(e);
        } finally {
          span.end();
        }
      });
    }

    executor.shutdown();
    if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
        logger.info("All requests completed.");
    } else {
        logger.warning("Executor did not terminate in time.");
    }

    // 4. Flush traces before exiting
    logger.info("Flushing traces...");
    openTelemetrySdk.getSdkTracerProvider().forceFlush().join(10, TimeUnit.SECONDS);
    logger.info("Simulation completed.");
  }
}

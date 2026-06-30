/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import com.google.api.MonitoredResource;
import com.google.cloud.MetadataConfig;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.spi.v1.SpannerRpcViews;
import io.opencensus.common.Duration;
import io.opencensus.common.Scope;
import io.opencensus.contrib.grpc.metrics.RpcViews;
import io.opencensus.contrib.zpages.ZPageHandlers;
import io.opencensus.exporter.stats.stackdriver.StackdriverStatsExporter;
import io.opencensus.exporter.trace.stackdriver.StackdriverExporter;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.samplers.Samplers;
import java.util.Arrays;

/**
 * This sample demonstrates how to enable opencensus tracing and stats in cloud spanner client.
 *
 * @deprecated The OpenCensus project is deprecated. Use OpenTelemetry to enable metrics and stats
 *     with cloud spanner client.
 *     <p>Note: This sample uses System.exit(0) to ensure clean termination because the
 *     ZPageHandlers HTTP server (localhost:8080/tracez) uses non-daemon threads and does not
 *     provide a public stop() method.
 */
public class TracingSample {

  private static final String SAMPLE_SPAN = "CloudSpannerSample";

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: TracingSample <instance_id> <database_id>");
      return;
    }
    SpannerOptions options = SpannerOptions.newBuilder().build();
    Spanner spanner = options.getService();

    // Installs a handler for /tracez page.
    ZPageHandlers.startHttpServerAndRegisterAll(8080);
    // Installs an exporter for stack driver traces.
    StackdriverExporter.createAndRegister();
    Tracing.getExportComponent()
        .getSampledSpanStore()
        .registerSpanNamesForCollection(Arrays.asList(SAMPLE_SPAN));

    // Installs an exporter for stack driver stats.
    MonitoredResource.Builder builder = MonitoredResource.newBuilder();
    if (MetadataConfig.getProjectId() != null) {
      builder.putLabels("project_id", options.getProjectId());
    }
    builder.setType("global");
    StackdriverStatsExporter.createAndRegisterWithProjectIdAndMonitoredResource(
        options.getProjectId(), Duration.create(60L, 0), builder.build());
    RpcViews.registerAllGrpcViews();
    // Capture GFE Latency and GFE Header missing count.
    SpannerRpcViews.registerGfeLatencyAndHeaderMissingCountViews();

    // Name of your instance & database.
    String instanceId = args[0];
    String databaseId = args[1];
    try {
      // Creates a database client
      DatabaseClient dbClient =
          spanner.getDatabaseClient(DatabaseId.of(options.getProjectId(), instanceId, databaseId));
      // Queries the database
      try (Scope ss =
          Tracing.getTracer()
              .spanBuilderWithExplicitParent(SAMPLE_SPAN, null)
              .setSampler(Samplers.alwaysSample())
              .startScopedSpan()) {
        ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of("SELECT 1"));

        System.out.println("\n\nResults:");
        // Prints the results
        while (resultSet.next()) {
          System.out.printf("%d\n\n", resultSet.getLong(0));
        }
      }
    } finally {
      // First, shutdown the stats/metrics exporters
      StackdriverStatsExporter.unregister();

      // Shutdown tracing components
      StackdriverExporter.unregister();
      Tracing.getExportComponent().shutdown();

      // Close the spanner client
      spanner.close();

      // Force immediate exit since ZPageHandlers.startHttpServerAndRegisterAll(8080)
      // starts a non-daemon HTTP server thread that cannot be stopped gracefully
      System.exit(0);
    }
  }
}

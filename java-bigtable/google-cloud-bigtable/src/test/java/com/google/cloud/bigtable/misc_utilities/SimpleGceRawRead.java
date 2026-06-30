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
package com.google.cloud.bigtable.misc_utilities;

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import io.grpc.ManagedChannel;
import io.grpc.alts.ComputeEngineChannelBuilder;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple utility to debug connection issues.
 *
 * <p>It enables verbose gRPC logging and does a simple read using a GCE channel builder.
 *
 * <pre>{@code
 * mvn install
 *
 * mvn test-compile exec:java \
 *   -pl google-cloud-bigtable \
 *   -Dexec.mainClass=com.google.cloud.bigtable.misc_utilities.SimpleGceRawRead \
 *   -Dexec.classpathScope=test \
 *   -Dbigtable.project=gcloud-devel \
 *   -Dbigtable.instance=google-cloud-bigtable \
 *   -Dbigtable.table=integration-tests \
 *   -Dbigtable.data-endpoint="bigtable.googleapis.com"
 * }</pre>
 */
public class SimpleGceRawRead {

  public static void main(String[] args) {
    configureLogging();

    String projectId = System.getProperty("bigtable.project", "gcloud-devel");
    String instanceId = System.getProperty("bigtable.instance", "google-cloud-bigtable");
    String tableId = System.getProperty("bigtable.table", "integration-tests");

    String endpoint = System.getProperty("bigtable.data-endpoint", "bigtable.googleapis.com");
    String tableName =
        String.format("projects/%s/instances/%s/tables/%s", projectId, instanceId, tableId);

    System.out.printf(">>>>>>>>> Trying to connect to: %s, to read %s%n%n%n", endpoint, tableName);

    ManagedChannel channel =
        ComputeEngineChannelBuilder.forAddress(endpoint, 443)
            .disableServiceConfigLookUp()
            .defaultServiceConfig(newServiceConfig())
            .build();
    try {
      BigtableGrpc.BigtableBlockingStub stub = BigtableGrpc.newBlockingStub(channel);

      Iterator<ReadRowsResponse> iter =
          stub.readRows(
              ReadRowsRequest.newBuilder().setTableName(tableName).setRowsLimit(1).build());
      System.out.printf("%n%n>>>>>>>>> Success Rows Read: %d%n%n", Lists.newArrayList(iter).size());
    } finally {
      channel.shutdown();
    }
  }

  /** Enable verbose gRPC logging */
  private static void configureLogging() {
    Logger.getLogger("io.grpc").setLevel(Level.ALL);
    Logger.getLogger("io.grpc.netty.shaded").setLevel(Level.ALL);

    ConsoleHandler stderr = new ConsoleHandler();
    stderr.setLevel(Level.ALL);

    Logger.getLogger("").addHandler(stderr);
  }

  private static Map<String, Object> newServiceConfig() {
    ImmutableMap<String, Object> pickFirstStrategy =
        ImmutableMap.<String, Object>of("pick_first", ImmutableMap.of());
    ImmutableMap<String, Object> childPolicy =
        ImmutableMap.<String, Object>of("childPolicy", ImmutableList.of(pickFirstStrategy));
    ImmutableMap<String, Object> grpcLbPolicy =
        ImmutableMap.<String, Object>of("grpclb", childPolicy);
    return ImmutableMap.<String, Object>of("loadBalancingConfig", ImmutableList.of(grpcLbPolicy));
  }
}

/*
 * Copyright 2021 Google LLC
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

package com.example.bigtable;

// [START bigtable_configure_connection_pool]

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import java.io.IOException;

public class ConfigureConnectionPool {

  public static void configureConnectionPool(String projectId, String instanceId) {
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";

    BigtableDataSettings.Builder settingsBuilder =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId);

    settingsBuilder
        .stubSettings()
        .setTransportChannelProvider(
            EnhancedBigtableStubSettings.defaultGrpcTransportProviderBuilder()
                .setPoolSize(10)
                .build());

    BigtableDataSettings settings = settingsBuilder.build();
    try (BigtableDataClient dataClient = BigtableDataClient.create(settings)) {
      InstantiatingGrpcChannelProvider provider =
          (InstantiatingGrpcChannelProvider)
              settings.getStubSettings().getTransportChannelProvider();

      int poolSize = provider.toBuilder().getPoolSize();

      System.out.println(String.format("Connected with pool size of %d", poolSize));
    } catch (IOException e) {
      System.out.println("Error during ConfigureConnectionPool: \n" + e.toString());
    }
  }
}

// [END bigtable_configure_connection_pool]

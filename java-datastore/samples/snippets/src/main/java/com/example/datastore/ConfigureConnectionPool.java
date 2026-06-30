/*
 * Copyright 2025 Google LLC
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

package com.example.datastore;

// [START datastore_configure_connection_pool]

import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.grpc.GrpcTransportOptions;

public class ConfigureConnectionPool {

  public static void main(String... args) throws Exception {
    InstantiatingGrpcChannelProvider channelProvider =
        DatastoreSettings.defaultGrpcTransportProviderBuilder()
            .setChannelPoolSettings(
                ChannelPoolSettings.builder()
                    .setInitialChannelCount(10)
                    .setMinChannelCount(5)
                    .setMaxChannelCount(200)
                    .build())
            .build();

    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder()
            .setProjectId("my-project")
            .setChannelProvider(channelProvider)
            .setTransportOptions(GrpcTransportOptions.newBuilder().build())
            .build();

    ChannelPoolSettings channelPoolSettings =
        ((InstantiatingGrpcChannelProvider) datastoreOptions.getTransportChannelProvider())
            .getChannelPoolSettings();

    System.out.printf(
        String.format(
            "Connected with pool with InitialChannelCount: %d, MinChannelCount: %d,"
                + " MaxChannelCount: %d",
            channelPoolSettings.getInitialChannelCount(),
            channelPoolSettings.getMinChannelCount(),
            channelPoolSettings.getMaxChannelCount()));
  }
}

// [END datastore_configure_connection_pool]

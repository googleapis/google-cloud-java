/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2;

import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import java.io.IOException;

/**
 * Client for reading from and writing to existing Bigtable tables.
 *
 * <p>This class provides the ability to make remote calls to the backing service. Sample code to
 * get started:
 *
 * <pre>{@code
 * InstanceName instanceName = InstanceName.of("[PROJECT]", "[INSTANCE]");
 * try (BigtableDataClient bigtableDataClient = BigtableDataClient.create(instanceName)) {
 *   // TODO: add example usage
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the bigtableDataClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>This class can be customized by passing in a custom instance of BigtableDataSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * BigtableDataSettings bigtableDataSettings =
 *     BigtableDataSettings.newBuilder()
 *         .setInstanceName(InstanceName.of("[PROJECT]", "[INSTANCE]"))
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * try(BigtableDataClient bigtableDataClient = BigtableDataClient.create(bigtableDataSettings)) {
 *   // ..
 * }
 * }</pre>
 *
 * To customize the endpoint:
 *
 * <pre>{@code
 * BigtableDataSettings bigtableDataSettings =
 *     BigtableDataSettings.newBuilder()
 *       .setInstanceName(InstanceName.of("[PROJECT]", "[INSTANCE]"))
 *       .setEndpoint(myEndpoint).build();
 * try(BigtableDataClient bigtableDataClient = BigtableDataClient.create(bigtableDataSettings)) {
 *   // ..
 * }
 * }</pre>
 */
public class BigtableDataClient implements AutoCloseable {
  private final EnhancedBigtableStub stub;

  /**
   * Constructs an instance of BigtableClient with default settings.
   *
   * @param instanceName The instance to connect to.
   * @return A new client.
   * @throws IOException If any.
   */
  public static BigtableDataClient create(InstanceName instanceName) throws IOException {
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilder().setInstanceName(instanceName).build();
    return create(settings);
  }

  /**
   * Constructs an instance of BigtableDataClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static BigtableDataClient create(BigtableDataSettings settings) throws IOException {
    EnhancedBigtableStub stub = EnhancedBigtableStub.create(settings.getTypedStubSettings());
    return new BigtableDataClient(stub);
  }

  @InternalApi("Visible for testing")
  BigtableDataClient(EnhancedBigtableStub stub) {
    this.stub = stub;
  }

  /** Close the clients and releases all associated resources. */
  @Override
  public void close() throws Exception {
    stub.close();
  }
}

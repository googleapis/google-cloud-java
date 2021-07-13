/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

/** Factory for {@link DatastoreEmulator}. */
public class DatastoreEmulatorFactory extends DatastoreFactory {

  /** Singleton factory instance. */
  private static final DatastoreEmulatorFactory INSTANCE = new DatastoreEmulatorFactory();

  public static DatastoreEmulatorFactory get() {
    return INSTANCE;
  }

  DatastoreEmulatorFactory() {}

  @Override
  public DatastoreEmulator create(DatastoreOptions options) throws IllegalArgumentException {
    return create(options, new DatastoreEmulatorOptions.Builder().build());
  }

  public DatastoreEmulator create(
      DatastoreOptions options, DatastoreEmulatorOptions localDevelopmentOptions) {
    RemoteRpc rpc = newRemoteRpc(options);
    return new DatastoreEmulator(rpc, options.getLocalHost(), localDevelopmentOptions);
  }
}

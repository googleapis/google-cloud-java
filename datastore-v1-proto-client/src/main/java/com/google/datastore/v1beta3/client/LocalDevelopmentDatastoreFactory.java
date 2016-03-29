/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
package com.google.datastore.v1beta3.client;

/**
 * Factory for {@link LocalDevelopmentDatastore}.
 */
public class LocalDevelopmentDatastoreFactory extends DatastoreFactory {

  /** Singleton factory instance. */
  private static final LocalDevelopmentDatastoreFactory INSTANCE =
      new LocalDevelopmentDatastoreFactory();

  public static LocalDevelopmentDatastoreFactory get() {
    return INSTANCE;
  }

  LocalDevelopmentDatastoreFactory() { }

  @Override
  public LocalDevelopmentDatastore create(DatastoreOptions options)
      throws IllegalArgumentException {
    return create(options, new LocalDevelopmentDatastoreOptions.Builder().build());
  }

  public LocalDevelopmentDatastore create(DatastoreOptions options,
      LocalDevelopmentDatastoreOptions localDevelopmentOptions) {
    RemoteRpc rpc = newRemoteRpc(options);
    return new LocalDevelopmentDatastore(rpc, options.getLocalHost(),
        localDevelopmentOptions);
  }
}

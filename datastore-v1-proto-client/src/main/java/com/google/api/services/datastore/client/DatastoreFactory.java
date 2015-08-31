/*
 * Copyright 2013 Google Inc. All Rights Reserved.
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
package com.google.api.services.datastore.client;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Client factory for {@link Datastore}.
 *
 */
public class DatastoreFactory extends BaseDatastoreFactory<Datastore>{
  /** Singleton factory instance. */
  private static final DatastoreFactory INSTANCE = new DatastoreFactory();
  
  /** API version. */
  public static final String VERSION = "v1beta2";

  public static DatastoreFactory get() {
    return INSTANCE;
  }

  /**
   * Provides access to a datastore using the provided options.  Logs
   * into the application using the credentials available via these
   * options.
   *
   * @throws IllegalArgumentException if the server or credentials weren't provided.
   */
  @Override
  public Datastore create(DatastoreOptions options) throws IllegalArgumentException {
    return new Datastore(newRemoteRpc(options));
  }

   /**
   * Build a valid datastore URL.
   */
  @Override
  protected String buildUrl(DatastoreOptions options, String overrideUrl) {
    try {
      if (options.getDataset() == null) {
        throw new IllegalArgumentException("datastore dataset not set in options");
      }
      String url;
      if (overrideUrl != null) {
        url = String.format("%s/datasets/%s", overrideUrl, options.getDataset());
      } else {
        url = String.format("%s/datastore/%s/datasets/%s",
            options.getHost(), VERSION, options.getDataset());
      }
      return new URI(url).toString();
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
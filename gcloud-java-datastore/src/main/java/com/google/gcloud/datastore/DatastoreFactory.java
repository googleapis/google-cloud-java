/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import com.google.gcloud.ServiceFactory;
import java.io.ObjectStreamException;

/**
 * A base class for Datastore factories.
 */
public abstract class DatastoreFactory implements ServiceFactory<Datastore, DatastoreOptions> {

  private static final long serialVersionUID = 5037190305022535983L;

  private static final DatastoreFactory INSTANCE = new DatastoreFactory() {

    private static final long serialVersionUID = 5893914895344559491L;

    @Override
    public Datastore get(DatastoreOptions options) {
      return new DatastoreImpl(options, this);
    }

    private Object readResolve() throws ObjectStreamException {
      return INSTANCE;
    }
  };

  /**
   * Returns the default factory instance.
   */
  public static DatastoreFactory instance() {
    return INSTANCE;
  }

  /**
   * Returns a {@code Datastore} service for the given options.
   */
  @Override
  public abstract Datastore get(DatastoreOptions options);
}

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

package com.google.gcloud.storage;

import com.google.gcloud.ServiceFactory;
import java.io.ObjectStreamException;

/**
 * A base class for Storage factories.
 */
public abstract class StorageFactory implements ServiceFactory<Storage, StorageOptions> {

  private static final long serialVersionUID = 1866883249985063753L;

  private static final StorageFactory INSTANCE = new StorageFactory() {

    private static final long serialVersionUID = -7985210081064222485L;

    @Override
    public Storage get(StorageOptions options) {
      return new StorageImpl(options, this);
    }

    private Object readResolve() throws ObjectStreamException {
      return INSTANCE;
    }
  };

  /**
   * Returns the default factory instance.
   */
  public static StorageFactory instance() {
    return INSTANCE;
  }

  /**
   * Returns a {@code Storage} service for the given options.
   */
  @Override
  public abstract Storage get(StorageOptions options);
}

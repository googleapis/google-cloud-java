/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.storage.StorageDataClient.FastOpenObjectReadSession;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.Objects;

final class BlobReadSessionAdapter implements BlobReadSession {

  @VisibleForTesting final ObjectReadSession session;
  private ObjectReadSessionStreamRead<?> fastOpenRead;
  private final ReadProjectionConfig<?> fastOpenConfig;

  BlobReadSessionAdapter(ObjectReadSession session) {
    this(session, null, null);
  }

  private BlobReadSessionAdapter(
      ObjectReadSession session,
      ObjectReadSessionStreamRead<?> fastOpenRead,
      ReadProjectionConfig<?> fastOpenConfig) {
    this.session = session;
    this.fastOpenRead = fastOpenRead;
    this.fastOpenConfig = fastOpenConfig;
  }

  @Override
  public BlobInfo getBlobInfo() {
    return Conversions.grpc().blobInfo().decode(session.getResource());
  }

  // ApiFutures type is erased, but that's okay. We're only decorating the errors. not changing
  // the return type.
  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public <Projection> Projection readAs(ReadProjectionConfig<Projection> config) {
    synchronized (this) {
      if (fastOpenRead != null && Objects.equals(config, fastOpenConfig)) {
        Projection projection = (Projection) fastOpenRead.project();
        fastOpenRead = null;
        if (projection instanceof ApiFuture) {
          ApiFuture apiFuture = (ApiFuture) projection;
          return (Projection) StorageException.coalesceAsync(apiFuture);
        }
        return projection;
      }
    }
    Projection projection = session.readAs(config);
    if (projection instanceof ApiFuture) {
      ApiFuture apiFuture = (ApiFuture) projection;
      return (Projection) StorageException.coalesceAsync(apiFuture);
    }
    return projection;
  }

  @Override
  public void close() throws IOException {
    session.close();
  }

  static ApiFuture<BlobReadSession> wrap(ApiFuture<ObjectReadSession> session) {
    return ApiFutures.transform(
        StorageException.coalesceAsync(session),
        BlobReadSessionAdapter::new,
        MoreExecutors.directExecutor());
  }

  static <Projection> ApiFuture<BlobReadSession> wrap(
      ApiFuture<FastOpenObjectReadSession<Projection>> session,
      ReadProjectionConfig<Projection> config) {
    return ApiFutures.transform(
        StorageException.coalesceAsync(session),
        fastOpen ->
            new BlobReadSessionAdapter(fastOpen.getSession(), fastOpen.getRead(), config),
        MoreExecutors.directExecutor());
  }
}

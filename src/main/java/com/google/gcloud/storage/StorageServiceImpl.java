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

import com.google.common.collect.Iterators;
import com.google.gcloud.BaseService;
import com.google.gcloud.spi.StorageRpc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

final class StorageServiceImpl extends BaseService<StorageServiceOptions> implements StorageService {

  private final StorageRpc storageRpc;

  StorageServiceImpl(StorageServiceOptions options) {
    super(options);
    storageRpc = options.storageRpc();
  }


  @Override
  public Bucket create(Bucket bucket) {
    try {
      return Bucket.fromPb(storageRpc.create(bucket.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob create(Blob blob, ByteBuffer content) {
    try {
      return Blob.fromPb(storageRpc.create(blob.toPb(), content));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Bucket get(Bucket bucket) {
    try {
      return Bucket.fromPb(storageRpc.get(bucket.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob get(Blob blob) {
    try {
      return Blob.fromPb(storageRpc.get(blob.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Iterator<Bucket> list() {
    try {
      return Iterators.transform(storageRpc.list(), Bucket.FROM_PB_FUNCTION);
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Iterator<Blob> list(Bucket bucket, ListOptions settings) {
    try {
      String delimiter = settings.recursive() ? options().pathDelimiter() : null;
      return Iterators.transform(
          storageRpc.list(bucket.name(), settings.prefix(), delimiter, settings.cursor(),
              settings.includeOlderVersions(), settings.maxResults()),
          Blob.FROM_PB_FUNCTION);
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Bucket update(Bucket bucket) {
    try {
      return Bucket.fromPb(storageRpc.patch(bucket.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob update(Blob blob) {
    try {
      return Blob.fromPb(storageRpc.patch(blob.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public void delete(Bucket bucket) {
    try {
      storageRpc.delete(bucket.toPb());
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public void delete(Blob blob) {
    try {
      storageRpc.delete(blob.toPb());
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob compose(Bucket bucket, Iterable<String> src, Blob dest) {
    try {
      return Blob.fromPb(storageRpc.compose(bucket.name(), src, dest.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob copy(Blob src, Blob dest) {
    try {
      return Blob.fromPb(storageRpc.copy(src.toPb(), dest.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public BlobReadChannel readFrom(Blob blob) {
    try {
      return storageRpc.reader(blob.toPb());
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public ObjectWriteChannel writeTo(Blob blob) {
    try {
      return storageRpc.writer(blob.toPb());
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }
}

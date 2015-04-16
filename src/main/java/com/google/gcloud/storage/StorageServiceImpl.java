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

    // todo: like Datastore distinct exception to retriable and non-retriable
    //       https://cloud.google.com/storage/docs/json_api/v1/status-codes
    // todo: Use retry helper on retriable failures

    // todo: consider options
    // todo: replace nulls with Value.asNull (per toPb)
  }

  @Override
  public Bucket create(Bucket bucket, BucketTargetOption... options) {
    try {
      return Bucket.fromPb(storageRpc.create(bucket.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob create(Blob blob, ByteBuffer content, BlobTargetOption... options) {
    try {
      return Blob.fromPb(storageRpc.create(blob.toPb(), content));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Bucket get(String bucket, BucketSourceOption... options) {
    try {
      return Bucket.fromPb(storageRpc.get(bucket));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob get(String bucket, String blob, BlobSourceOption... options) {
    try {
      return Blob.fromPb(storageRpc.get(bucket, blob));
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
  public Iterator<Blob> list(String bucket, ListOptions settings) {
    try {
      String delimiter = settings.recursive() ? options().pathDelimiter() : null;
      return Iterators.transform(
          storageRpc.list(bucket, settings.prefix(), delimiter, settings.cursor(),
              settings.includeOlderVersions(), settings.maxResults()),
          Blob.FROM_PB_FUNCTION);
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Bucket update(Bucket bucket, BucketTargetOption... options) {
    try {
      return Bucket.fromPb(storageRpc.patch(bucket.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob update(Blob blob, BlobTargetOption... options) {
    try {
      return Blob.fromPb(storageRpc.patch(blob.toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public void delete(Bucket bucket, BucketSourceOption... options) {
    try {
      storageRpc.delete(bucket.toPb());
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public void delete(Blob blob, BlobSourceOption... options) {
    try {
      storageRpc.delete(blob.toPb());
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public Blob compose(ComposeRequest composeRequest) {
    // todo: implement (consider having XXXRequest/XXXResponse for all SPI/Rpc requests
// try {

//
//      return Blob.fromPb(storageRpc.compose(composeRequest.sourceBucket(),
//          composeRequest.sourceBlobs(), composeRequest.target()));
//    } catch (IOException ex) {
//      throw new StorageServiceException(ex);
//    }
    throw new UnsupportedOperationException("bla");
  }

  @Override
  public Blob copy(CopyRequest copyRequest) {
    try {
      return Blob.fromPb(storageRpc.copy(copyRequest.source().toPb(), copyRequest.target().toPb()));
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public BlobReadChannel readFrom(Blob blob, BlobSourceOption... options) {
    try {
      return storageRpc.reader(blob.toPb());
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }

  @Override
  public BlobWriteChannel writeTo(Blob blob, BlobTargetOption... options) {
    try {
      return storageRpc.writer(blob.toPb());
    } catch (IOException ex) {
      throw new StorageServiceException(ex);
    }
  }
}

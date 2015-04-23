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

import static com.google.gcloud.RetryHelper.runWithRetries;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.gcloud.BaseService;
import com.google.gcloud.ExceptionHandler;
import com.google.gcloud.ExceptionHandler.Interceptor;
import com.google.gcloud.RetryParams;
import com.google.gcloud.spi.StorageRpc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

final class StorageServiceImpl extends BaseService<StorageServiceOptions> implements StorageService {

  private static final Interceptor EXCEPTION_HANDLER_INTERCEPTOR = new Interceptor() {

    private static final long serialVersionUID = -7758580330857881124L;

    @Override
    public RetryResult afterEval(Exception exception, RetryResult retryResult) {
      return null;
    }

    @Override
    public RetryResult beforeEval(Exception exception) {
      if (exception instanceof StorageServiceException) {
        boolean retriable = ((StorageServiceException) exception).retryable();
        return retriable ? Interceptor.RetryResult.RETRY : Interceptor.RetryResult.ABORT;
      }
      return null;
    }
  };
  private static final ExceptionHandler EXCEPTION_HANDLER = ExceptionHandler.builder()
      .abortOn(RuntimeException.class).interceptor(EXCEPTION_HANDLER_INTERCEPTOR).build();

  private final StorageRpc storageRpc;
  private final RetryParams retryParams;

  StorageServiceImpl(StorageServiceOptions options) {
    super(options);
    storageRpc = options.storageRpc();
    retryParams = MoreObjects.firstNonNull(options.retryParams(), RetryParams.noRetries());
    // todo: replace nulls with Value.asNull (per toPb)
  }

  @Override
  public Bucket create(Bucket bucket, BucketTargetOption... options) {
    Validator.checkBucketOptions(bucket, options);
    final com.google.api.services.storage.model.Bucket bucketPb = bucket.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return Bucket.fromPb(runWithRetries(
        new Callable<com.google.api.services.storage.model.Bucket>() {
          @Override
          public com.google.api.services.storage.model.Bucket call() {
            return storageRpc.create(bucketPb, optionsMap);
          }
        }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public Blob create(Blob blob, final byte[] content, BlobTargetOption... options) {
    Validator.checkBlobOptions(blob, options);
    final StorageObject blobPb = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.create(blobPb, content, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public Bucket get(Bucket bucket, BucketSourceOption... options) {
    Validator.checkBucketOptions(bucket, options);
    final com.google.api.services.storage.model.Bucket bucketPb = bucket.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return Bucket.fromPb(runWithRetries(
        new Callable<com.google.api.services.storage.model.Bucket>() {
          @Override
          public com.google.api.services.storage.model.Bucket call() {
            return storageRpc.get(bucketPb, optionsMap);
          }
        }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public Blob get(Blob blob, BlobSourceOption... options) {
    Validator.checkBlobOptions(blob, options);
    final StorageObject storedObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.get(storedObject, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public Iterator<Bucket> list() {
    return Iterators.transform(
        runWithRetries(new Callable<Iterator<com.google.api.services.storage.model.Bucket>>() {
          @Override
          public Iterator<com.google.api.services.storage.model.Bucket> call() {
            return storageRpc.list();
          }
        }, retryParams, EXCEPTION_HANDLER), Bucket.FROM_PB_FUNCTION);
  }

  @Override
  public Iterator<Blob> list(String bucket, ListOptions settings) {
    // todo implement paging (with retries) with if limit is not given or > X
    String delimiter = settings.recursive() ? options().pathDelimiter() : null;
    return Iterators.transform(
        storageRpc.list(bucket, settings.prefix(), delimiter, settings.cursor(),
            settings.includeOlderVersions(), settings.maxResults()), Blob.FROM_PB_FUNCTION);
  }

  @Override
  public Bucket update(Bucket bucket, BucketTargetOption... options) {
    Validator.checkBucketOptions(bucket, options);
    final com.google.api.services.storage.model.Bucket bucketPb = bucket.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return Bucket.fromPb(runWithRetries(
        new Callable<com.google.api.services.storage.model.Bucket>() {
          @Override
          public com.google.api.services.storage.model.Bucket call() {
            return storageRpc.patch(bucketPb, optionsMap);
          }
        }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public Blob update(Blob blob, BlobTargetOption... options) {
    Validator.checkBlobOptions(blob, options);
    final StorageObject storageObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.patch(storageObject, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public void delete(Bucket bucket, BucketSourceOption... options) {
    Validator.checkBucketOptions(bucket, options);
    final com.google.api.services.storage.model.Bucket bucketPb = bucket.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    runWithRetries(new Callable<Void>() {
      @Override
      public Void call() {
        storageRpc.delete(bucketPb, optionsMap);
        return null;
      }
    }, retryParams, EXCEPTION_HANDLER);
  }

  @Override
  public void delete(Blob blob, BlobSourceOption... options) {
    Validator.checkBlobOptions(blob, options);
    final StorageObject storageObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    runWithRetries(new Callable<Void>() {
      @Override
      public Void call() {
        storageRpc.delete(storageObject, optionsMap);
        return null;
      }
    }, retryParams, EXCEPTION_HANDLER);
  }

  @Override
  public Blob compose(final ComposeRequest composeRequest) {
    final List<StorageObject> sources =
        Lists.newArrayListWithCapacity(composeRequest.sourceBlobs().size());
    for (ComposeRequest.SourceBlob sourceBlob : composeRequest.sourceBlobs()) {
      sources.add(Blob.builder(composeRequest.sourceBucket(), sourceBlob.blob)
          .generation(sourceBlob.generation).build().toPb());
    }
    final StorageObject target = composeRequest.target().toPb();
    final Map<StorageRpc.Option, ?> targetOptions = optionMap(composeRequest.targetOptions());
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.compose(sources, target, targetOptions);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public Blob copy(CopyRequest copyRequest) {
    final StorageObject source = copyRequest.source().toPb();
    final Map<StorageRpc.Option, ?> sourceOptions = optionMap(copyRequest.sourceOptions());
    final StorageObject target = copyRequest.target().toPb();
    final Map<StorageRpc.Option, ?> targetOptions = optionMap(copyRequest.targetOptions());
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.copy(source, sourceOptions, target, targetOptions);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public byte[] load(Blob blob, BlobSourceOption... options) {
    Validator.checkBlobOptions(blob, options);
    final StorageObject storageObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return runWithRetries(new Callable<byte[]>() {
      @Override
      public byte[] call() {
        return storageRpc.load(storageObject, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER);
  }

  @Override
  public BlobReadChannel reader(Blob blob, BlobSourceOption... options) {
    Validator.checkBlobOptions(blob, options);
    // todo: Use retry helper on retriable failures
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return storageRpc.reader(blob.toPb(), optionsMap);
  }

  @Override
  public BlobWriteChannel writer(Blob blob, BlobTargetOption... options) {
    Validator.checkBlobOptions(blob, options);
    // todo: Use retry helper on retriable failures
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return storageRpc.writer(blob.toPb(), optionsMap);
  }

  private static Map<StorageRpc.Option, ?> optionMap(Iterable<? extends Option> options) {
    ImmutableMap.Builder<StorageRpc.Option, Object> mapBuider = ImmutableMap.builder();
    for (Option option : options) {
      mapBuider.put(option.rpcOption(), option.value());
    }
    return mapBuider.build();
  }

  private static Map<StorageRpc.Option, ?> optionMap(Option... options) {
    return optionMap(Arrays.asList(options));
  }
}

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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.gcloud.RetryHelper.runWithRetries;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gcloud.BaseService;
import com.google.gcloud.ExceptionHandler;
import com.google.gcloud.ExceptionHandler.Interceptor;
import com.google.gcloud.RetryParams;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpc.Tuple;

import java.io.Serializable;
import java.util.Arrays;
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
    final com.google.api.services.storage.model.Bucket bucketPb = bucket.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(bucket, options);
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
    final StorageObject blobPb = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.create(blobPb, content, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public Bucket get(Bucket bucket, BucketSourceOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = bucket.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(bucket, options);
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
    final StorageObject storedObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.get(storedObject, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public ListResult<Bucket> list(BucketListOption... options) {
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(null, null, options);
    Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> result = runWithRetries(
        new Callable<Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>>>() {
          @Override
          public Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> call() {
            return storageRpc.list(optionsMap);
          }
        }, retryParams, EXCEPTION_HANDLER);
    return new ListResult<>(result.x(), Iterables.transform(result.y(),
        new Function<com.google.api.services.storage.model.Bucket, Bucket>() {
          @Override
          public Bucket apply(com.google.api.services.storage.model.Bucket bucketPb) {
            return Bucket.fromPb(bucketPb);
          }
        }));
  }

  @Override
  public ListResult<Blob> list(final String bucket, BlobListOption... options) {
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(null, null, options);
    Tuple<String, Iterable<StorageObject>> result = runWithRetries(
        new Callable<Tuple<String, Iterable<StorageObject>>>() {
          @Override
          public Tuple<String, Iterable<StorageObject>> call() {
            return storageRpc.list(bucket, optionsMap);
          }
        }, retryParams, EXCEPTION_HANDLER);
    return new ListResult<>(result.x(), Iterables.transform(result.y(),
        new Function<StorageObject, Blob>() {
          @Override
          public Blob apply(StorageObject storageObject) {
            return Blob.fromPb(storageObject);
          }
        }));
  }

  @Override
  public Bucket update(Bucket bucket, BucketTargetOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = bucket.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(bucket, options);
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
    final StorageObject storageObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.patch(storageObject, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public boolean delete(Bucket bucket, BucketSourceOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = bucket.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(bucket, options);
    return runWithRetries(new Callable<Boolean>() {
      @Override
      public Boolean call() {
        return storageRpc.delete(bucketPb, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER);
  }

  @Override
  public boolean delete(Blob blob, BlobSourceOption... options) {
    final StorageObject storageObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return runWithRetries(new Callable<Boolean>() {
      @Override
      public Boolean call() {
        return storageRpc.delete(storageObject, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER);
  }

  @Override
  public Blob compose(final ComposeRequest composeRequest) {
    final List<StorageObject> sources =
        Lists.newArrayListWithCapacity(composeRequest.sourceBlobs().size());
    for (ComposeRequest.SourceBlob sourceBlob : composeRequest.sourceBlobs()) {
      sources.add(Blob.builder(composeRequest.target().bucket(), sourceBlob.name())
          .generation(sourceBlob.generation()).build().toPb());
    }
    final StorageObject target = composeRequest.target().toPb();
    final Map<StorageRpc.Option, ?> targetOptions = optionMap(composeRequest.target().generation(),
        composeRequest.target().metageneration(), composeRequest.targetOptions());
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
    copyRequest.sourceOptions();
    final Map<StorageRpc.Option, ?> sourceOptions = optionMap(copyRequest.source().generation(),
        copyRequest.source().metageneration(), copyRequest.sourceOptions(), true);
    final StorageObject target = copyRequest.target().toPb();
    final Map<StorageRpc.Option, ?> targetOptions = optionMap(copyRequest.target().generation(),
        copyRequest.target().metageneration(), copyRequest.targetOptions());
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.copy(source, sourceOptions, target, targetOptions);
      }
    }, retryParams, EXCEPTION_HANDLER));
  }

  @Override
  public byte[] load(Blob blob, BlobSourceOption... options) {
    final StorageObject storageObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return runWithRetries(new Callable<byte[]>() {
      @Override
      public byte[] call() {
        return storageRpc.load(storageObject, optionsMap);
      }
    }, retryParams, EXCEPTION_HANDLER);
  }

  @Override
  public BatchResponse apply(BatchRequest batchRequest) {
    List<Tuple<StorageObject, Map<StorageRpc.Option, ?>>> toDelete =
        Lists.newArrayListWithCapacity(batchRequest.toDelete().size());
    for (Map.Entry<Blob, BlobSourceOption[]> entry : batchRequest.toDelete().entrySet()) {
      Blob blob = entry.getKey();
      Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, entry.getValue());
      StorageObject storageObject = blob.toPb();
      toDelete.add(Tuple.<StorageObject, Map<StorageRpc.Option, ?>>of(storageObject, optionsMap));
    }
    List<Tuple<StorageObject, Map<StorageRpc.Option, ?>>> toUpdate =
        Lists.newArrayListWithCapacity(batchRequest.toUpdate().size());
    for (Map.Entry<Blob, BlobTargetOption[]> entry : batchRequest.toUpdate().entrySet()) {
      Blob blob = entry.getKey();
      Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, entry.getValue());
      toUpdate.add(Tuple.<StorageObject, Map<StorageRpc.Option, ?>>of(blob.toPb(), optionsMap));
    }
    List<Tuple<StorageObject, Map<StorageRpc.Option, ?>>> toGet =
        Lists.newArrayListWithCapacity(batchRequest.toGet().size());
    for (Map.Entry<Blob, BlobSourceOption[]> entry : batchRequest.toGet().entrySet()) {
      Blob blob = entry.getKey();
      Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, entry.getValue());
      toGet.add(Tuple.<StorageObject, Map<StorageRpc.Option, ?>>of(blob.toPb(), optionsMap));
    }
    StorageRpc.BatchResponse response =
        storageRpc.batch(new StorageRpc.BatchRequest(toDelete, toUpdate, toGet));
    List<BatchResponse.Result<Boolean>> deletes = transformBatchResult(
        toDelete, response.deletes, Functions.<Boolean>identity());
    List<BatchResponse.Result<Blob>> updates = transformBatchResult(
        toUpdate, response.updates, Blob.FROM_PB_FUNCTION);
    List<BatchResponse.Result<Blob>> gets = transformBatchResult(
        toGet, response.gets, Blob.FROM_PB_FUNCTION);
    return new BatchResponse(deletes, updates, gets);
  }

  private <I, O extends Serializable> List<BatchResponse.Result<O>> transformBatchResult(
      Iterable<Tuple<StorageObject, Map<StorageRpc.Option, ?>>> request,
      Map<StorageObject, Tuple<I, StorageServiceException>> results, Function<I, O> transform) {
    List<BatchResponse.Result<O>> response = Lists.newArrayListWithCapacity(results.size());
    for (Tuple<StorageObject, ?> tuple : request) {
      Tuple<I, StorageServiceException> result = results.get(tuple.x());
      if (result.x() != null) {
        response.add(new BatchResponse.Result<>(transform.apply(result.x())));
      } else {
        response.add(new BatchResponse.Result<O>(result.y()));
      }
    }
    return response;
  }

  @Override
  public BlobReadChannel reader(Blob blob, BlobSourceOption... options) {
    // todo: Use retry helper on retriable failures
    // todo: consider changing lower level api to handle segments
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return storageRpc.reader(blob.toPb(), optionsMap);
  }

  @Override
  public BlobWriteChannel writer(Blob blob, BlobTargetOption... options) {
    // todo: Use retry helper on retriable failures
    // todo: consider changing lower level api to handle segments
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return storageRpc.writer(blob.toPb(), optionsMap);
  }

  private Map<StorageRpc.Option, ?> optionMap(Long generation, Long metaGeneration,
      Iterable<? extends Option> options) {
    return optionMap(generation, metaGeneration, options, false);
  }

  private Map<StorageRpc.Option, ?> optionMap(Long generation, Long metaGeneration,
      Iterable<? extends Option> options, boolean useAsSource) {
    Map<StorageRpc.Option, Object> temp = Maps.newEnumMap(StorageRpc.Option.class);
    for (Option option : options) {
      Object prev = temp.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    Boolean value = (Boolean) temp.remove(StorageRpc.Option.DELIMITER);
    if (Boolean.TRUE.equals(value)) {
      temp.put(StorageRpc.Option.DELIMITER, options().pathDelimiter());
    }
    value = (Boolean) temp.remove(StorageRpc.Option.IF_GENERATION_MATCH);
    if (value != null) {
      checkArgument(generation != null, "missing generation value");
      if (value) {
        temp.put(useAsSource ? StorageRpc.Option.IF_SOURCE_GENERATION_MATCH
            : StorageRpc.Option.IF_GENERATION_MATCH, generation);
      } else {
        temp.put(useAsSource ? StorageRpc.Option.IF_SOURCE_GENERATION_NOT_MATCH
            : StorageRpc.Option.IF_GENERATION_NOT_MATCH, generation);
      }
    }
    value = (Boolean) temp.remove(StorageRpc.Option.IF_METAGENERATION_MATCH);
    if (value != null) {
      checkArgument(metaGeneration != null, "missing metaGeneration value");
      if (value) {
        temp.put(useAsSource ? StorageRpc.Option.IF_SOURCE_METAGENERATION_MATCH
            : StorageRpc.Option.IF_METAGENERATION_MATCH, metaGeneration);
      } else {
        temp.put(useAsSource ? StorageRpc.Option.IF_SOURCE_METAGENERATION_NOT_MATCH
            : StorageRpc.Option.IF_METAGENERATION_NOT_MATCH, metaGeneration);
      }
    }
    return ImmutableMap.copyOf(temp);
  }

  private Map<StorageRpc.Option, ?> optionMap(Long generation, Long metaGeneration,
      Option... options) {
    return optionMap(generation, metaGeneration, Arrays.asList(options));
  }

  private Map<StorageRpc.Option, ?> optionMap(Bucket bucket, Option... options) {
    return optionMap(null, bucket.metageneration(), options);
  }

  private Map<StorageRpc.Option, ?> optionMap(Blob blob, Option... options) {
    return optionMap(blob.generation(), blob.metageneration(), options);
  }
}

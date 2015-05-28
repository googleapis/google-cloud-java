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

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.gcloud.RetryHelper.runWithRetries;
import static com.google.gcloud.spi.StorageRpc.Option.DELIMITER;
import static com.google.gcloud.spi.StorageRpc.Option.IF_GENERATION_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_GENERATION_NOT_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_METAGENERATION_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_METAGENERATION_NOT_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_SOURCE_GENERATION_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_SOURCE_GENERATION_NOT_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_SOURCE_METAGENERATION_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_SOURCE_METAGENERATION_NOT_MATCH;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Ints;
import com.google.gcloud.AuthCredentials.ServiceAccountAuthCredentials;
import com.google.gcloud.BaseService;
import com.google.gcloud.ExceptionHandler;
import com.google.gcloud.ExceptionHandler.Interceptor;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpc.Tuple;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
  static final ExceptionHandler EXCEPTION_HANDLER = ExceptionHandler.builder()
      .abortOn(RuntimeException.class).interceptor(EXCEPTION_HANDLER_INTERCEPTOR).build();
  private static final byte[] EMPTY_BYTE_ARRAY = {};

  private final StorageRpc storageRpc;

  StorageServiceImpl(StorageServiceOptions options) {
    super(options);
    storageRpc = options.storageRpc();
    // todo: configure timeouts - https://developers.google.com/api-client-library/java/google-api-java-client/errors
    // todo: provide rewrite - https://cloud.google.com/storage/docs/json_api/v1/objects/rewrite
    // todo: check if we need to expose https://cloud.google.com/storage/docs/json_api/v1/bucketAccessControls/insert vs using bucket update/patch
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
        }, options().retryParams(), EXCEPTION_HANDLER));
  }

  @Override
  public Blob create(Blob blob, final byte[] content, BlobTargetOption... options) {
    final StorageObject blobPb = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.create(blobPb, firstNonNull(content, EMPTY_BYTE_ARRAY), optionsMap);
      }
    }, options().retryParams(), EXCEPTION_HANDLER));
  }

  @Override
  public Bucket get(String bucket, BucketSourceOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = Bucket.of(bucket).toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    com.google.api.services.storage.model.Bucket answer = runWithRetries(
        new Callable<com.google.api.services.storage.model.Bucket>() {
          @Override
          public com.google.api.services.storage.model.Bucket call() {
            try {
              return storageRpc.get(bucketPb, optionsMap);
            } catch (StorageServiceException ex) {
              if (ex.code() == HTTP_NOT_FOUND) {
                return null;
              }
              throw ex;
            }
          }
        }, options().retryParams(), EXCEPTION_HANDLER);
    return answer == null ? null : Bucket.fromPb(answer);
  }

  @Override
  public Blob get(String bucket, String blob, BlobSourceOption... options) {
    final StorageObject storedObject = Blob.of(bucket, blob).toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    StorageObject storageObject = runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        try {
          return storageRpc.get(storedObject, optionsMap);
        } catch (StorageServiceException ex) {
          if (ex.code() == HTTP_NOT_FOUND) {
            return null;
          }
          throw ex;
        }
      }
    }, options().retryParams(), EXCEPTION_HANDLER);
    return storageObject == null ? null : Blob.fromPb(storageObject);
  }

  private static abstract class BasePageFetcher<T extends Serializable>
      implements ListResult.NextPageFetcher<T> {

    private static final long serialVersionUID = 8236329004030295223L;
    protected final Map<StorageRpc.Option, ?> requestOptions;
    protected final StorageServiceOptions serviceOptions;

    BasePageFetcher(StorageServiceOptions serviceOptions, String cursor,
        Map<StorageRpc.Option, ?> optionMap) {
      this.serviceOptions = serviceOptions;
      ImmutableMap.Builder<StorageRpc.Option, Object> builder = ImmutableMap.builder();
      builder.put(StorageRpc.Option.PAGE_TOKEN, cursor);
      for (Map.Entry<StorageRpc.Option, ?> option : optionMap.entrySet()) {
        if (option.getKey() != StorageRpc.Option.PAGE_TOKEN) {
          builder.put(option.getKey(), option.getValue());
        }
      }
      this.requestOptions = builder.build();
    }
  }

  private static class BucketPageFetcher extends BasePageFetcher<Bucket> {

    private static final long serialVersionUID = -5490616010200159174L;

    BucketPageFetcher(StorageServiceOptions serviceOptions, String cursor,
        Map<StorageRpc.Option, ?> optionMap) {
      super(serviceOptions, cursor, optionMap);
    }

    @Override
    public ListResult<Bucket> nextPage() {
      return listBuckets(serviceOptions, requestOptions);
    }
  }

  private static class BlobPageFetcher extends BasePageFetcher<Blob> {

    private static final long serialVersionUID = -5490616010200159174L;
    private final String bucket;

    BlobPageFetcher(String bucket, StorageServiceOptions serviceOptions, String cursor,
        Map<StorageRpc.Option, ?> optionMap) {
      super(serviceOptions, cursor, optionMap);
      this.bucket = bucket;
    }

    @Override
    public ListResult<Blob> nextPage() {
      return listBlobs(bucket, serviceOptions, requestOptions);
    }
  }

  @Override
  public ListResult<Bucket> list(BucketListOption... options) {
    return listBuckets(options(), optionMap(options));
  }

  private static ListResult<Bucket> listBuckets(final StorageServiceOptions serviceOptions,
      final Map<StorageRpc.Option, ?> optionsMap) {
    Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> result = runWithRetries(
        new Callable<Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>>>() {
          @Override
          public Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> call() {
            return serviceOptions.storageRpc().list(optionsMap);
          }
        }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
    String cursor = result.x();
    return new ListResult<>(new BucketPageFetcher(serviceOptions, cursor, optionsMap), cursor,
        Iterables.transform(result.y(),
            new Function<com.google.api.services.storage.model.Bucket, Bucket>() {
              @Override
              public Bucket apply(com.google.api.services.storage.model.Bucket bucketPb) {
                return Bucket.fromPb(bucketPb);
              }
            }));
  }

  @Override
  public ListResult<Blob> list(final String bucket, BlobListOption... options) {
    return listBlobs(bucket, options(), optionMap(options));
  }

  private static ListResult<Blob> listBlobs(final String bucket,
      final StorageServiceOptions serviceOptions, final Map<StorageRpc.Option, ?> optionsMap) {
    Tuple<String, Iterable<StorageObject>> result = runWithRetries(
        new Callable<Tuple<String, Iterable<StorageObject>>>() {
          @Override
          public Tuple<String, Iterable<StorageObject>> call() {
            return serviceOptions.storageRpc().list(bucket, optionsMap);
          }
        }, serviceOptions.retryParams(), EXCEPTION_HANDLER);
    String cursor = result.x();
    return new ListResult<>(new BlobPageFetcher(bucket, serviceOptions, cursor, optionsMap), cursor,
        Iterables.transform(result.y(),
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
        }, options().retryParams(), EXCEPTION_HANDLER));
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
    }, options().retryParams(), EXCEPTION_HANDLER));
  }

  @Override
  public boolean delete(String bucket, BucketSourceOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = Bucket.of(bucket).toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return runWithRetries(new Callable<Boolean>() {
      @Override
      public Boolean call() {
        return storageRpc.delete(bucketPb, optionsMap);
      }
    }, options().retryParams(), EXCEPTION_HANDLER);
  }

  @Override
  public boolean delete(String bucket, String blob, BlobSourceOption... options) {
    final StorageObject storageObject = Blob.of(bucket, blob).toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return runWithRetries(new Callable<Boolean>() {
      @Override
      public Boolean call() {
        return storageRpc.delete(storageObject, optionsMap);
      }
    }, options().retryParams(), EXCEPTION_HANDLER);
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
    }, options().retryParams(), EXCEPTION_HANDLER));
  }

  @Override
  public Blob copy(CopyRequest copyRequest) {
    final StorageObject source =
        Blob.of(copyRequest.sourceBucket(), copyRequest.sourceBlob()).toPb();
    copyRequest.sourceOptions();
    final Map<StorageRpc.Option, ?> sourceOptions =
        optionMap(null, null, copyRequest.sourceOptions(), true);
    final StorageObject target = copyRequest.target().toPb();
    final Map<StorageRpc.Option, ?> targetOptions = optionMap(copyRequest.target().generation(),
        copyRequest.target().metageneration(), copyRequest.targetOptions());
    return Blob.fromPb(runWithRetries(new Callable<StorageObject>() {
      @Override
      public StorageObject call() {
        return storageRpc.copy(source, sourceOptions, target, targetOptions);
      }
    }, options().retryParams(), EXCEPTION_HANDLER));
  }

  @Override
  public byte[] load(String bucket, String blob, BlobSourceOption... options) {
    final StorageObject storageObject = Blob.of(bucket, blob).toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return runWithRetries(new Callable<byte[]>() {
      @Override
      public byte[] call() {
        return storageRpc.load(storageObject, optionsMap);
      }
    }, options().retryParams(), EXCEPTION_HANDLER);
  }

  @Override
  public BatchResponse apply(BatchRequest batchRequest) {
    List<Tuple<StorageObject, Map<StorageRpc.Option, ?>>> toDelete =
        Lists.newArrayListWithCapacity(batchRequest.toDelete().size());
    for (Map.Entry<Blob, Iterable<BlobSourceOption>> entry : batchRequest.toDelete().entrySet()) {
      Blob blob = entry.getKey();
      Map<StorageRpc.Option, ?> optionsMap =
          optionMap(blob.generation(), blob.metageneration(), entry.getValue());
      StorageObject storageObject = blob.toPb();
      toDelete.add(Tuple.<StorageObject, Map<StorageRpc.Option, ?>>of(storageObject, optionsMap));
    }
    List<Tuple<StorageObject, Map<StorageRpc.Option, ?>>> toUpdate =
        Lists.newArrayListWithCapacity(batchRequest.toUpdate().size());
    for (Map.Entry<Blob, Iterable<BlobTargetOption>> entry : batchRequest.toUpdate().entrySet()) {
      Blob blob = entry.getKey();
      Map<StorageRpc.Option, ?> optionsMap =
          optionMap(blob.generation(), blob.metageneration(), entry.getValue());
      toUpdate.add(Tuple.<StorageObject, Map<StorageRpc.Option, ?>>of(blob.toPb(), optionsMap));
    }
    List<Tuple<StorageObject, Map<StorageRpc.Option, ?>>> toGet =
        Lists.newArrayListWithCapacity(batchRequest.toGet().size());
    for (Map.Entry<Blob, Iterable<BlobSourceOption>> entry : batchRequest.toGet().entrySet()) {
      Blob blob = entry.getKey();
      Map<StorageRpc.Option, ?> optionsMap =
          optionMap(blob.generation(), blob.metageneration(), entry.getValue());
      toGet.add(Tuple.<StorageObject, Map<StorageRpc.Option, ?>>of(blob.toPb(), optionsMap));
    }
    StorageRpc.BatchResponse response =
        storageRpc.batch(new StorageRpc.BatchRequest(toDelete, toUpdate, toGet));
    List<BatchResponse.Result<Boolean>> deletes = transformBatchResult(
        toDelete, response.deletes, Functions.<Boolean>identity());
    List<BatchResponse.Result<Blob>> updates = transformBatchResult(
        toUpdate, response.updates, Blob.FROM_PB_FUNCTION);
    List<BatchResponse.Result<Blob>> gets = transformBatchResult(
        toGet, response.gets, Blob.FROM_PB_FUNCTION, HTTP_NOT_FOUND);
    return new BatchResponse(deletes, updates, gets);
  }

  private <I, O extends Serializable> List<BatchResponse.Result<O>> transformBatchResult(
      Iterable<Tuple<StorageObject, Map<StorageRpc.Option, ?>>> request,
      Map<StorageObject, Tuple<I, StorageServiceException>> results, Function<I, O> transform,
      int... nullOnErrorCodes) {
    Set nullOnErrorCodesSet = Sets.newHashSet(Ints.asList(nullOnErrorCodes));
    List<BatchResponse.Result<O>> response = Lists.newArrayListWithCapacity(results.size());
    for (Tuple<StorageObject, ?> tuple : request) {
      Tuple<I, StorageServiceException> result = results.get(tuple.x());
      if (result.x() != null) {
        response.add(BatchResponse.Result.of(transform.apply(result.x())));
      } else {
        StorageServiceException exception = result.y();
        if (nullOnErrorCodesSet.contains(exception.code())) {
          //noinspection unchecked
          response.add(BatchResponse.Result.<O>empty());
        } else {
          response.add(new BatchResponse.Result<O>(exception));
        }
      }
    }
    return response;
  }

  @Override
  public BlobReadChannel reader(String bucket, String blob, BlobSourceOption... options) {
    Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return new BlobReadChannelImpl(options(), Blob.of(bucket, blob), optionsMap);
  }

 @Override
  public BlobWriteChannel writer(Blob blob, BlobTargetOption... options) {
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return new BlobWriterChannelImpl(options(), blob, optionsMap);
  }

  @Override
  public URL signUrl(Blob blob, long expiration, SignUrlOption... options) {
    EnumMap<SignUrlOption.Option, Object> optionMap = Maps.newEnumMap(SignUrlOption.Option.class);
    for (SignUrlOption option : options) {
      optionMap.put(option.option(), option.value());
    }
    ServiceAccountAuthCredentials cred =
        (ServiceAccountAuthCredentials) optionMap.get(SignUrlOption.Option.SERVICE_ACCOUNT_CRED);
    if (cred == null) {
      checkArgument(options().authCredentials() instanceof ServiceAccountAuthCredentials,
          "Signing key was not provided and could not be derived");
      cred = (ServiceAccountAuthCredentials) this.options().authCredentials();
    }
    // construct signature data - see https://cloud.google.com/storage/docs/access-control#Signed-URLs
    StringBuilder stBuilder = new StringBuilder();
    if (optionMap.containsKey(SignUrlOption.Option.HTTP_METHOD)) {
      stBuilder.append(optionMap.get(SignUrlOption.Option.HTTP_METHOD));
    } else {
      stBuilder.append(HttpMethod.GET);
    }
    stBuilder.append('\n');
    if (firstNonNull((Boolean) optionMap.get(SignUrlOption.Option.MD5) , false)) {
      checkArgument(blob.md5() != null, "Blob is missing a value for md5");
      stBuilder.append(blob.md5());
    }
    stBuilder.append('\n');
    if (firstNonNull((Boolean) optionMap.get(SignUrlOption.Option.CONTENT_TYPE) , false)) {
      checkArgument(blob.contentType() != null, "Blob is missing a value for content-type");
      stBuilder.append(blob.contentType());
    }
    stBuilder.append('\n');
    stBuilder.append(expiration).append('\n').append('\n');
    StringBuilder path = new StringBuilder();
    if (!blob.bucket().startsWith("/")) {
      path.append('/');
    }
    path.append(blob.bucket());
    if (!blob.bucket().endsWith("/")) {
      path.append('/');
    }
    if (blob.name().startsWith("/")) {
      path.setLength(stBuilder.length() - 1);
    }
    path.append(blob.name());
    stBuilder.append(path);
    try {
      Signature signer = Signature.getInstance("SHA256withRSA");
      signer.initSign(cred.privateKey());
      signer.update(stBuilder.toString().getBytes("UTF-8"));
      String signature = BaseEncoding.base64Url().encode(signer.sign());
      // todo - use options().host() - after default is correct and value is past to RPC
      stBuilder = new StringBuilder("https://storage.googleapis.com").append(path);
      stBuilder.append("?GoogleAccessId=").append(cred.account());
      stBuilder.append("&Expires=").append(expiration);
      stBuilder.append("&Signature=").append(signature);
      return new URL(stBuilder.toString());
    } catch (MalformedURLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
      throw new IllegalStateException(e);
    } catch (SignatureException | InvalidKeyException e) {
      throw new IllegalArgumentException("Invalid service account private key");
    }
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
    Boolean value = (Boolean) temp.remove(DELIMITER);
    if (Boolean.TRUE.equals(value)) {
      temp.put(DELIMITER, options().pathDelimiter());
    }
    if (useAsSource) {
      addToOptionMap(IF_GENERATION_MATCH, IF_SOURCE_GENERATION_MATCH, generation, temp);
      addToOptionMap(IF_GENERATION_NOT_MATCH, IF_SOURCE_GENERATION_NOT_MATCH, generation, temp);
      addToOptionMap(IF_METAGENERATION_MATCH, IF_SOURCE_METAGENERATION_MATCH, metaGeneration, temp);
      addToOptionMap(IF_METAGENERATION_NOT_MATCH,
          IF_SOURCE_METAGENERATION_NOT_MATCH, metaGeneration, temp);
    } else {
      addToOptionMap(IF_GENERATION_MATCH, generation, temp);
      addToOptionMap(IF_GENERATION_NOT_MATCH, generation, temp);
      addToOptionMap(IF_METAGENERATION_MATCH, metaGeneration, temp);
      addToOptionMap(IF_METAGENERATION_NOT_MATCH, metaGeneration, temp);
    }
    return ImmutableMap.copyOf(temp);
  }

  private static <T> void addToOptionMap(StorageRpc.Option option, T defaultValue,
      Map<StorageRpc.Option, Object> map) {
    addToOptionMap(option, option, defaultValue, map);
  }

  private static <T> void addToOptionMap(StorageRpc.Option getOption, StorageRpc.Option putOption,
      T defaultValue, Map<StorageRpc.Option, Object> map) {
    if (map.containsKey(getOption)) {
      @SuppressWarnings("unchecked")
      T value = (T) map.remove(getOption);
      checkArgument(value != null || defaultValue != null,
          "Option " + getOption.value() + " is missing a value");
      value = firstNonNull(value, defaultValue);
      map.put(putOption, value);
    }
  }

  private Map<StorageRpc.Option, ?> optionMap(Option... options) {
    return optionMap(null, null, Arrays.asList(options));
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

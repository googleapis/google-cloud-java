/*
 * Copyright 2015 Google LLC
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

import static com.google.cloud.RetryHelper.runWithRetries;
import static com.google.cloud.storage.PolicyHelper.convertFromApiPolicy;
import static com.google.cloud.storage.PolicyHelper.convertToApiPolicy;
import static com.google.cloud.storage.SignedUrlEncodingHelper.Rfc3986UriEncode;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.DELIMITER;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.IF_GENERATION_MATCH;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.IF_GENERATION_NOT_MATCH;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.IF_METAGENERATION_MATCH;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.IF_METAGENERATION_NOT_MATCH;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.IF_SOURCE_GENERATION_MATCH;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.IF_SOURCE_GENERATION_NOT_MATCH;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.IF_SOURCE_METAGENERATION_MATCH;
import static com.google.cloud.storage.spi.v1.StorageRpc.Option.IF_SOURCE_METAGENERATION_NOT_MATCH;
import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.gax.paging.Page;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.auth.ServiceAccountSigner;
import com.google.cloud.BaseService;
import com.google.cloud.BatchResult;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.Policy;
import com.google.cloud.ReadChannel;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.Tuple;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteResponse;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Ints;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

final class StorageImpl extends BaseService<StorageOptions> implements Storage {

  private static final byte[] EMPTY_BYTE_ARRAY = {};
  private static final String EMPTY_BYTE_ARRAY_MD5 = "1B2M2Y8AsgTpgAmY7PhCfg==";
  private static final String EMPTY_BYTE_ARRAY_CRC32C = "AAAAAA==";
  private static final String PATH_DELIMITER = "/";
  /** Signed URLs are only supported through the GCS XML API endpoint. */
  private static final String STORAGE_XML_URI_SCHEME = "https";

  private static final String STORAGE_XML_URI_HOST_NAME = "storage.googleapis.com";

  private static final Function<Tuple<Storage, Boolean>, Boolean> DELETE_FUNCTION =
      new Function<Tuple<Storage, Boolean>, Boolean>() {
        @Override
        public Boolean apply(Tuple<Storage, Boolean> tuple) {
          return tuple.y();
        }
      };

  private final StorageRpc storageRpc;

  StorageImpl(StorageOptions options) {
    super(options);
    storageRpc = options.getStorageRpcV1();
  }

  @Override
  public Bucket create(BucketInfo bucketInfo, BucketTargetOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = bucketInfo.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(bucketInfo, options);
    try {
      return Bucket.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.storage.model.Bucket>() {
                @Override
                public com.google.api.services.storage.model.Bucket call() {
                  return storageRpc.create(bucketPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Blob create(BlobInfo blobInfo, BlobTargetOption... options) {
    BlobInfo updatedInfo =
        blobInfo
            .toBuilder()
            .setMd5(EMPTY_BYTE_ARRAY_MD5)
            .setCrc32c(EMPTY_BYTE_ARRAY_CRC32C)
            .build();
    return internalCreate(updatedInfo, EMPTY_BYTE_ARRAY, options);
  }

  @Override
  public Blob create(BlobInfo blobInfo, byte[] content, BlobTargetOption... options) {
    content = firstNonNull(content, EMPTY_BYTE_ARRAY);
    BlobInfo updatedInfo =
        blobInfo
            .toBuilder()
            .setMd5(BaseEncoding.base64().encode(Hashing.md5().hashBytes(content).asBytes()))
            .setCrc32c(
                BaseEncoding.base64()
                    .encode(Ints.toByteArray(Hashing.crc32c().hashBytes(content).asInt())))
            .build();
    return internalCreate(updatedInfo, content, options);
  }

  @Override
  public Blob create(
      BlobInfo blobInfo, byte[] content, int offset, int length, BlobTargetOption... options) {
    content = firstNonNull(content, EMPTY_BYTE_ARRAY);
    byte[] subContent = Arrays.copyOfRange(content, offset, offset + length);
    BlobInfo updatedInfo =
        blobInfo
            .toBuilder()
            .setMd5(BaseEncoding.base64().encode(Hashing.md5().hashBytes(subContent).asBytes()))
            .setCrc32c(
                BaseEncoding.base64()
                    .encode(Ints.toByteArray(Hashing.crc32c().hashBytes(subContent).asInt())))
            .build();
    return internalCreate(updatedInfo, subContent, options);
  }

  @Override
  @Deprecated
  public Blob create(BlobInfo blobInfo, InputStream content, BlobWriteOption... options) {
    Tuple<BlobInfo, BlobTargetOption[]> targetOptions = BlobTargetOption.convert(blobInfo, options);
    StorageObject blobPb = targetOptions.x().toPb();
    Map<StorageRpc.Option, ?> optionsMap = optionMap(targetOptions.x(), targetOptions.y());
    InputStream inputStreamParam =
        firstNonNull(content, new ByteArrayInputStream(EMPTY_BYTE_ARRAY));
    // retries are not safe when the input is an InputStream, so we can't retry.
    return Blob.fromPb(this, storageRpc.create(blobPb, inputStreamParam, optionsMap));
  }

  private Blob internalCreate(BlobInfo info, final byte[] content, BlobTargetOption... options) {
    Preconditions.checkNotNull(content);
    final StorageObject blobPb = info.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(info, options);
    try {
      return Blob.fromPb(
          this,
          runWithRetries(
              new Callable<StorageObject>() {
                @Override
                public StorageObject call() {
                  return storageRpc.create(blobPb, new ByteArrayInputStream(content), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Bucket get(String bucket, BucketGetOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = BucketInfo.of(bucket).toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    try {
      com.google.api.services.storage.model.Bucket answer =
          runWithRetries(
              new Callable<com.google.api.services.storage.model.Bucket>() {
                @Override
                public com.google.api.services.storage.model.Bucket call() {
                  return storageRpc.get(bucketPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : Bucket.fromPb(this, answer);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Blob get(String bucket, String blob, BlobGetOption... options) {
    return get(BlobId.of(bucket, blob), options);
  }

  @Override
  public Blob get(BlobId blob, BlobGetOption... options) {
    final StorageObject storedObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    try {
      StorageObject storageObject =
          runWithRetries(
              new Callable<StorageObject>() {
                @Override
                public StorageObject call() {
                  return storageRpc.get(storedObject, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return storageObject == null ? null : Blob.fromPb(this, storageObject);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Blob get(BlobId blob) {
    return get(blob, new BlobGetOption[0]);
  }

  private static class BucketPageFetcher implements NextPageFetcher<Bucket> {

    private static final long serialVersionUID = 5850406828803613729L;
    private final Map<StorageRpc.Option, ?> requestOptions;
    private final StorageOptions serviceOptions;

    BucketPageFetcher(
        StorageOptions serviceOptions, String cursor, Map<StorageRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(StorageRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
    }

    @Override
    public Page<Bucket> getNextPage() {
      return listBuckets(serviceOptions, requestOptions);
    }
  }

  private static class BlobPageFetcher implements NextPageFetcher<Blob> {

    private static final long serialVersionUID = 81807334445874098L;
    private final Map<StorageRpc.Option, ?> requestOptions;
    private final StorageOptions serviceOptions;
    private final String bucket;

    BlobPageFetcher(
        String bucket,
        StorageOptions serviceOptions,
        String cursor,
        Map<StorageRpc.Option, ?> optionMap) {
      this.requestOptions =
          PageImpl.nextRequestOptions(StorageRpc.Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.bucket = bucket;
    }

    @Override
    public Page<Blob> getNextPage() {
      return listBlobs(bucket, serviceOptions, requestOptions);
    }
  }

  private static class HmacKeyMetadataPageFetcher implements NextPageFetcher<HmacKeyMetadata> {

    private static final long serialVersionUID = 308012320541700881L;
    private final StorageOptions serviceOptions;
    private final Map<StorageRpc.Option, ?> options;

    HmacKeyMetadataPageFetcher(StorageOptions serviceOptions, Map<StorageRpc.Option, ?> options) {
      this.serviceOptions = serviceOptions;
      this.options = options;
    }

    @Override
    public Page<HmacKeyMetadata> getNextPage() {
      return listHmacKeys(serviceOptions, options);
    }
  }

  @Override
  public Page<Bucket> list(BucketListOption... options) {
    return listBuckets(getOptions(), optionMap(options));
  }

  @Override
  public Page<Blob> list(final String bucket, BlobListOption... options) {
    return listBlobs(bucket, getOptions(), optionMap(options));
  }

  private static Page<Bucket> listBuckets(
      final StorageOptions serviceOptions, final Map<StorageRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>> result =
          runWithRetries(
              new Callable<
                  Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>>>() {
                @Override
                public Tuple<String, Iterable<com.google.api.services.storage.model.Bucket>>
                    call() {
                  return serviceOptions.getStorageRpcV1().list(optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.x();
      Iterable<Bucket> buckets =
          result.y() == null
              ? ImmutableList.<Bucket>of()
              : Iterables.transform(
                  result.y(),
                  new Function<com.google.api.services.storage.model.Bucket, Bucket>() {
                    @Override
                    public Bucket apply(com.google.api.services.storage.model.Bucket bucketPb) {
                      return Bucket.fromPb(serviceOptions.getService(), bucketPb);
                    }
                  });
      return new PageImpl<>(
          new BucketPageFetcher(serviceOptions, cursor, optionsMap), cursor, buckets);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  private static Page<Blob> listBlobs(
      final String bucket,
      final StorageOptions serviceOptions,
      final Map<StorageRpc.Option, ?> optionsMap) {
    try {
      Tuple<String, Iterable<StorageObject>> result =
          runWithRetries(
              new Callable<Tuple<String, Iterable<StorageObject>>>() {
                @Override
                public Tuple<String, Iterable<StorageObject>> call() {
                  return serviceOptions.getStorageRpcV1().list(bucket, optionsMap);
                }
              },
              serviceOptions.getRetrySettings(),
              EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.x();
      Iterable<Blob> blobs =
          result.y() == null
              ? ImmutableList.<Blob>of()
              : Iterables.transform(
                  result.y(),
                  new Function<StorageObject, Blob>() {
                    @Override
                    public Blob apply(StorageObject storageObject) {
                      return Blob.fromPb(serviceOptions.getService(), storageObject);
                    }
                  });
      return new PageImpl<>(
          new BlobPageFetcher(bucket, serviceOptions, cursor, optionsMap), cursor, blobs);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Bucket update(BucketInfo bucketInfo, BucketTargetOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = bucketInfo.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(bucketInfo, options);
    try {
      return Bucket.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.storage.model.Bucket>() {
                @Override
                public com.google.api.services.storage.model.Bucket call() {
                  return storageRpc.patch(bucketPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Blob update(BlobInfo blobInfo, BlobTargetOption... options) {
    final StorageObject storageObject = blobInfo.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blobInfo, options);
    try {
      return Blob.fromPb(
          this,
          runWithRetries(
              new Callable<StorageObject>() {
                @Override
                public StorageObject call() {
                  return storageRpc.patch(storageObject, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Blob update(BlobInfo blobInfo) {
    return update(blobInfo, new BlobTargetOption[0]);
  }

  @Override
  public boolean delete(String bucket, BucketSourceOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = BucketInfo.of(bucket).toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return storageRpc.delete(bucketPb, optionsMap);
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public boolean delete(String bucket, String blob, BlobSourceOption... options) {
    return delete(BlobId.of(bucket, blob), options);
  }

  @Override
  public boolean delete(BlobId blob, BlobSourceOption... options) {
    final StorageObject storageObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return storageRpc.delete(storageObject, optionsMap);
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public boolean delete(BlobId blob) {
    return delete(blob, new BlobSourceOption[0]);
  }

  @Override
  public Blob compose(final ComposeRequest composeRequest) {
    final List<StorageObject> sources =
        Lists.newArrayListWithCapacity(composeRequest.getSourceBlobs().size());
    for (ComposeRequest.SourceBlob sourceBlob : composeRequest.getSourceBlobs()) {
      sources.add(
          BlobInfo.newBuilder(
                  BlobId.of(
                      composeRequest.getTarget().getBucket(),
                      sourceBlob.getName(),
                      sourceBlob.getGeneration()))
              .build()
              .toPb());
    }
    final StorageObject target = composeRequest.getTarget().toPb();
    final Map<StorageRpc.Option, ?> targetOptions =
        optionMap(
            composeRequest.getTarget().getGeneration(),
            composeRequest.getTarget().getMetageneration(),
            composeRequest.getTargetOptions());
    try {
      return Blob.fromPb(
          this,
          runWithRetries(
              new Callable<StorageObject>() {
                @Override
                public StorageObject call() {
                  return storageRpc.compose(sources, target, targetOptions);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public CopyWriter copy(final CopyRequest copyRequest) {
    final StorageObject source = copyRequest.getSource().toPb();
    final Map<StorageRpc.Option, ?> sourceOptions =
        optionMap(
            copyRequest.getSource().getGeneration(), null, copyRequest.getSourceOptions(), true);
    final StorageObject targetObject = copyRequest.getTarget().toPb();
    final Map<StorageRpc.Option, ?> targetOptions =
        optionMap(
            copyRequest.getTarget().getGeneration(),
            copyRequest.getTarget().getMetageneration(),
            copyRequest.getTargetOptions());
    try {
      RewriteResponse rewriteResponse =
          runWithRetries(
              new Callable<RewriteResponse>() {
                @Override
                public RewriteResponse call() {
                  return storageRpc.openRewrite(
                      new StorageRpc.RewriteRequest(
                          source,
                          sourceOptions,
                          copyRequest.overrideInfo(),
                          targetObject,
                          targetOptions,
                          copyRequest.getMegabytesCopiedPerChunk()));
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return new CopyWriter(getOptions(), rewriteResponse);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public byte[] readAllBytes(String bucket, String blob, BlobSourceOption... options) {
    return readAllBytes(BlobId.of(bucket, blob), options);
  }

  @Override
  public byte[] readAllBytes(BlobId blob, BlobSourceOption... options) {
    final StorageObject storageObject = blob.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    try {
      return runWithRetries(
          new Callable<byte[]>() {
            @Override
            public byte[] call() {
              return storageRpc.load(storageObject, optionsMap);
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public StorageBatch batch() {
    return new StorageBatch(this.getOptions());
  }

  @Override
  public ReadChannel reader(String bucket, String blob, BlobSourceOption... options) {
    Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
    return new BlobReadChannel(getOptions(), BlobId.of(bucket, blob), optionsMap);
  }

  @Override
  public ReadChannel reader(BlobId blob, BlobSourceOption... options) {
    Map<StorageRpc.Option, ?> optionsMap = optionMap(blob, options);
    return new BlobReadChannel(getOptions(), blob, optionsMap);
  }

  @Override
  public BlobWriteChannel writer(BlobInfo blobInfo, BlobWriteOption... options) {
    Tuple<BlobInfo, BlobTargetOption[]> targetOptions = BlobTargetOption.convert(blobInfo, options);
    return writer(targetOptions.x(), targetOptions.y());
  }

  @Override
  public BlobWriteChannel writer(URL signedURL) {
    return new BlobWriteChannel(getOptions(), signedURL);
  }

  private BlobWriteChannel writer(BlobInfo blobInfo, BlobTargetOption... options) {
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(blobInfo, options);
    return new BlobWriteChannel(getOptions(), blobInfo, optionsMap);
  }

  @Override
  public URL signUrl(BlobInfo blobInfo, long duration, TimeUnit unit, SignUrlOption... options) {
    EnumMap<SignUrlOption.Option, Object> optionMap = Maps.newEnumMap(SignUrlOption.Option.class);
    for (SignUrlOption option : options) {
      optionMap.put(option.getOption(), option.getValue());
    }

    boolean isV2 =
        getPreferredSignatureVersion(optionMap).equals(SignUrlOption.SignatureVersion.V2);
    boolean isV4 =
        getPreferredSignatureVersion(optionMap).equals(SignUrlOption.SignatureVersion.V4);

    ServiceAccountSigner credentials =
        (ServiceAccountSigner) optionMap.get(SignUrlOption.Option.SERVICE_ACCOUNT_CRED);
    if (credentials == null) {
      checkState(
          this.getOptions().getCredentials() instanceof ServiceAccountSigner,
          "Signing key was not provided and could not be derived");
      credentials = (ServiceAccountSigner) this.getOptions().getCredentials();
    }

    long expiration =
        isV4
            ? TimeUnit.SECONDS.convert(unit.toMillis(duration), TimeUnit.MILLISECONDS)
            : TimeUnit.SECONDS.convert(
                getOptions().getClock().millisTime() + unit.toMillis(duration),
                TimeUnit.MILLISECONDS);

    checkArgument(
        !(optionMap.containsKey(SignUrlOption.Option.VIRTUAL_HOSTED_STYLE)
            && optionMap.containsKey(SignUrlOption.Option.PATH_STYLE)),
        "Cannot specify both the VIRTUAL_HOSTED_STYLE and PATH_STYLE SignUrlOptions together.");

    String bucketName = slashlessBucketNameFromBlobInfo(blobInfo);
    String escapedBlobName = "";
    if (!Strings.isNullOrEmpty(blobInfo.getName())) {
      escapedBlobName = Rfc3986UriEncode(blobInfo.getName(), false);
    }

    boolean usePathStyle = shouldUsePathStyleForSignedUrl(optionMap);

    String storageXmlHostName =
        usePathStyle
            ? STORAGE_XML_URI_SCHEME + "://" + getBaseStorageHostName(optionMap)
            : STORAGE_XML_URI_SCHEME + "://" + bucketName + "." + getBaseStorageHostName(optionMap);

    String stPath =
        usePathStyle
            ? constructResourceUriPath(bucketName, escapedBlobName, optionMap)
            : constructResourceUriPath("", escapedBlobName, optionMap);

    URI path = URI.create(stPath);
    // For V2 signing, even if we don't specify the bucket in the URI path, we still need the
    // canonical resource string that we'll sign to include the bucket.
    URI pathForSigning =
        isV2 ? URI.create(constructResourceUriPath(bucketName, escapedBlobName, optionMap)) : path;

    try {
      SignatureInfo signatureInfo =
          buildSignatureInfo(
              optionMap, blobInfo, expiration, pathForSigning, credentials.getAccount());
      String unsignedPayload = signatureInfo.constructUnsignedPayload();
      byte[] signatureBytes = credentials.sign(unsignedPayload.getBytes(UTF_8));
      StringBuilder stBuilder = new StringBuilder();
      stBuilder.append(storageXmlHostName).append(path);

      if (isV4) {
        BaseEncoding encoding = BaseEncoding.base16().lowerCase();
        String signature = URLEncoder.encode(encoding.encode(signatureBytes), UTF_8.name());
        String v4QueryString = signatureInfo.constructV4QueryString();

        stBuilder.append('?');
        if (!Strings.isNullOrEmpty(v4QueryString)) {
          stBuilder.append(v4QueryString).append('&');
        }
        stBuilder.append("X-Goog-Signature=").append(signature);
      } else {
        BaseEncoding encoding = BaseEncoding.base64();
        String signature = URLEncoder.encode(encoding.encode(signatureBytes), UTF_8.name());
        String v2QueryString = signatureInfo.constructV2QueryString();

        stBuilder.append('?');
        if (!Strings.isNullOrEmpty(v2QueryString)) {
          stBuilder.append(v2QueryString).append('&');
        }
        stBuilder.append("GoogleAccessId=").append(credentials.getAccount());
        stBuilder.append("&Expires=").append(expiration);
        stBuilder.append("&Signature=").append(signature);
      }

      return new URL(stBuilder.toString());

    } catch (MalformedURLException | UnsupportedEncodingException ex) {
      throw new IllegalStateException(ex);
    }
  }

  private String constructResourceUriPath(
      String slashlessBucketName,
      String escapedBlobName,
      EnumMap<SignUrlOption.Option, Object> optionMap) {
    if (Strings.isNullOrEmpty(slashlessBucketName)) {
      if (Strings.isNullOrEmpty(escapedBlobName)) {
        return PATH_DELIMITER;
      }
      if (escapedBlobName.startsWith(PATH_DELIMITER)) {
        return escapedBlobName;
      }
      return PATH_DELIMITER + escapedBlobName;
    }

    StringBuilder pathBuilder = new StringBuilder();
    pathBuilder.append(PATH_DELIMITER).append(slashlessBucketName);
    if (Strings.isNullOrEmpty(escapedBlobName)) {
      boolean isV2 =
          getPreferredSignatureVersion(optionMap).equals(SignUrlOption.SignatureVersion.V2);
      // If using virtual-hosted style URLs with V2 signing, the path string for a bucket resource
      // must end with a forward slash.
      if (optionMap.containsKey(SignUrlOption.Option.VIRTUAL_HOSTED_STYLE) && isV2) {
        pathBuilder.append(PATH_DELIMITER);
      }
      return pathBuilder.toString();
    }
    if (!escapedBlobName.startsWith(PATH_DELIMITER)) {
      pathBuilder.append(PATH_DELIMITER);
    }
    pathBuilder.append(escapedBlobName);
    return pathBuilder.toString();
  }

  private SignUrlOption.SignatureVersion getPreferredSignatureVersion(
      EnumMap<SignUrlOption.Option, Object> optionMap) {
    // Check for an explicitly specified version in the map.
    for (SignUrlOption.SignatureVersion version : SignUrlOption.SignatureVersion.values()) {
      if (version.equals(optionMap.get(SignUrlOption.Option.SIGNATURE_VERSION))) {
        return version;
      }
    }
    // TODO(#6362): V2 is the default, and thus can be specified either explicitly or implicitly
    // Change this to V4 once we make it the default.
    return SignUrlOption.SignatureVersion.V2;
  }

  private boolean shouldUsePathStyleForSignedUrl(EnumMap<SignUrlOption.Option, Object> optionMap) {
    // TODO(#6362): If we decide to change the default style used to generate URLs, switch this
    // logic to return false unless PATH_STYLE was explicitly specified.
    if (optionMap.containsKey(SignUrlOption.Option.VIRTUAL_HOSTED_STYLE)) {
      return false;
    }
    return true;
  }

  /**
   * Builds signature info.
   *
   * @param optionMap the option map
   * @param blobInfo the blob info
   * @param expiration the expiration in seconds
   * @param path the resource URI
   * @param accountEmail the account email
   * @return signature info
   */
  private SignatureInfo buildSignatureInfo(
      Map<SignUrlOption.Option, Object> optionMap,
      BlobInfo blobInfo,
      long expiration,
      URI path,
      String accountEmail) {

    HttpMethod httpVerb =
        optionMap.containsKey(SignUrlOption.Option.HTTP_METHOD)
            ? (HttpMethod) optionMap.get(SignUrlOption.Option.HTTP_METHOD)
            : HttpMethod.GET;

    SignatureInfo.Builder signatureInfoBuilder =
        new SignatureInfo.Builder(httpVerb, expiration, path);

    if (firstNonNull((Boolean) optionMap.get(SignUrlOption.Option.MD5), false)) {
      checkArgument(blobInfo.getMd5() != null, "Blob is missing a value for md5");
      signatureInfoBuilder.setContentMd5(blobInfo.getMd5());
    }

    if (firstNonNull((Boolean) optionMap.get(SignUrlOption.Option.CONTENT_TYPE), false)) {
      checkArgument(blobInfo.getContentType() != null, "Blob is missing a value for content-type");
      signatureInfoBuilder.setContentType(blobInfo.getContentType());
    }

    signatureInfoBuilder.setSignatureVersion(
        (SignUrlOption.SignatureVersion) optionMap.get(SignUrlOption.Option.SIGNATURE_VERSION));

    signatureInfoBuilder.setAccountEmail(accountEmail);

    signatureInfoBuilder.setTimestamp(getOptions().getClock().millisTime());

    ImmutableMap.Builder<String, String> extHeadersBuilder =
        new ImmutableMap.Builder<String, String>();

    boolean isV4 =
        SignUrlOption.SignatureVersion.V4.equals(
            optionMap.get(SignUrlOption.Option.SIGNATURE_VERSION));
    if (isV4) { // We don't sign the host header for V2 signed URLs; only do this for V4.
      // Add the host here first, allowing it to be overridden in the EXT_HEADERS option below.
      if (optionMap.containsKey(SignUrlOption.Option.VIRTUAL_HOSTED_STYLE)) {
        extHeadersBuilder.put(
            "host",
            slashlessBucketNameFromBlobInfo(blobInfo) + "." + getBaseStorageHostName(optionMap));
      } else if (optionMap.containsKey(SignUrlOption.Option.HOST_NAME)) {
        extHeadersBuilder.put("host", getBaseStorageHostName(optionMap));
      }
    }

    if (optionMap.containsKey(SignUrlOption.Option.EXT_HEADERS)) {
      extHeadersBuilder.putAll(
          (Map<String, String>) optionMap.get(SignUrlOption.Option.EXT_HEADERS));
    }

    ImmutableMap.Builder<String, String> queryParamsBuilder =
        new ImmutableMap.Builder<String, String>();
    if (optionMap.containsKey(SignUrlOption.Option.QUERY_PARAMS)) {
      queryParamsBuilder.putAll(
          (Map<String, String>) optionMap.get(SignUrlOption.Option.QUERY_PARAMS));
    }

    return signatureInfoBuilder
        .setCanonicalizedExtensionHeaders((Map<String, String>) extHeadersBuilder.build())
        .setCanonicalizedQueryParams((Map<String, String>) queryParamsBuilder.build())
        .build();
  }

  private String slashlessBucketNameFromBlobInfo(BlobInfo blobInfo) {
    // The bucket name itself should never contain a forward slash. However, parts already existed
    // in the code to check for this, so we remove the forward slashes to be safe here.
    return CharMatcher.anyOf(PATH_DELIMITER).trimFrom(blobInfo.getBucket());
  }

  /** Returns the hostname used to send requests to Cloud Storage, e.g. "storage.googleapis.com". */
  private String getBaseStorageHostName(Map<SignUrlOption.Option, Object> optionMap) {
    String specifiedBaseHostName = (String) optionMap.get(SignUrlOption.Option.HOST_NAME);
    if (!Strings.isNullOrEmpty(specifiedBaseHostName)) {
      return specifiedBaseHostName.replaceFirst("http(s)?://", "");
    }
    return STORAGE_XML_URI_HOST_NAME;
  }

  @Override
  public List<Blob> get(BlobId... blobIds) {
    return get(Arrays.asList(blobIds));
  }

  @Override
  public List<Blob> get(Iterable<BlobId> blobIds) {
    StorageBatch batch = batch();
    final List<Blob> results = Lists.newArrayList();
    for (BlobId blob : blobIds) {
      batch
          .get(blob)
          .notify(
              new BatchResult.Callback<Blob, StorageException>() {
                @Override
                public void success(Blob result) {
                  results.add(result);
                }

                @Override
                public void error(StorageException exception) {
                  results.add(null);
                }
              });
    }
    batch.submit();
    return Collections.unmodifiableList(results);
  }

  @Override
  public List<Blob> update(BlobInfo... blobInfos) {
    return update(Arrays.asList(blobInfos));
  }

  @Override
  public List<Blob> update(Iterable<BlobInfo> blobInfos) {
    StorageBatch batch = batch();
    final List<Blob> results = Lists.newArrayList();
    for (BlobInfo blobInfo : blobInfos) {
      batch
          .update(blobInfo)
          .notify(
              new BatchResult.Callback<Blob, StorageException>() {
                @Override
                public void success(Blob result) {
                  results.add(result);
                }

                @Override
                public void error(StorageException exception) {
                  results.add(null);
                }
              });
    }
    batch.submit();
    return Collections.unmodifiableList(results);
  }

  @Override
  public List<Boolean> delete(BlobId... blobIds) {
    return delete(Arrays.asList(blobIds));
  }

  @Override
  public List<Boolean> delete(Iterable<BlobId> blobIds) {
    StorageBatch batch = batch();
    final List<Boolean> results = Lists.newArrayList();
    for (BlobId blob : blobIds) {
      batch
          .delete(blob)
          .notify(
              new BatchResult.Callback<Boolean, StorageException>() {
                @Override
                public void success(Boolean result) {
                  results.add(result);
                }

                @Override
                public void error(StorageException exception) {
                  results.add(Boolean.FALSE);
                }
              });
    }
    batch.submit();
    return Collections.unmodifiableList(results);
  }

  @Override
  public Acl getAcl(final String bucket, final Entity entity, BucketSourceOption... options) {
    try {
      final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
      BucketAccessControl answer =
          runWithRetries(
              new Callable<BucketAccessControl>() {
                @Override
                public BucketAccessControl call() {
                  return storageRpc.getAcl(bucket, entity.toPb(), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : Acl.fromPb(answer);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Acl getAcl(final String bucket, final Entity entity) {
    return getAcl(bucket, entity, new BucketSourceOption[0]);
  }

  @Override
  public boolean deleteAcl(
      final String bucket, final Entity entity, BucketSourceOption... options) {
    try {
      final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return storageRpc.deleteAcl(bucket, entity.toPb(), optionsMap);
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public boolean deleteAcl(final String bucket, final Entity entity) {
    return deleteAcl(bucket, entity, new BucketSourceOption[0]);
  }

  @Override
  public Acl createAcl(String bucket, Acl acl, BucketSourceOption... options) {
    final BucketAccessControl aclPb = acl.toBucketPb().setBucket(bucket);
    try {
      final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
      return Acl.fromPb(
          runWithRetries(
              new Callable<BucketAccessControl>() {
                @Override
                public BucketAccessControl call() {
                  return storageRpc.createAcl(aclPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Acl createAcl(String bucket, Acl acl) {
    return createAcl(bucket, acl, new BucketSourceOption[0]);
  }

  @Override
  public Acl updateAcl(String bucket, Acl acl, BucketSourceOption... options) {
    final BucketAccessControl aclPb = acl.toBucketPb().setBucket(bucket);
    try {
      final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
      return Acl.fromPb(
          runWithRetries(
              new Callable<BucketAccessControl>() {
                @Override
                public BucketAccessControl call() {
                  return storageRpc.patchAcl(aclPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Acl updateAcl(String bucket, Acl acl) {
    return updateAcl(bucket, acl, new BucketSourceOption[0]);
  }

  @Override
  public List<Acl> listAcls(final String bucket, BucketSourceOption... options) {
    try {
      final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
      List<BucketAccessControl> answer =
          runWithRetries(
              new Callable<List<BucketAccessControl>>() {
                @Override
                public List<BucketAccessControl> call() {
                  return storageRpc.listAcls(bucket, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return Lists.transform(answer, Acl.FROM_BUCKET_PB_FUNCTION);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public List<Acl> listAcls(final String bucket) {
    return listAcls(bucket, new BucketSourceOption[0]);
  }

  @Override
  public Acl getDefaultAcl(final String bucket, final Entity entity) {
    try {
      ObjectAccessControl answer =
          runWithRetries(
              new Callable<ObjectAccessControl>() {
                @Override
                public ObjectAccessControl call() {
                  return storageRpc.getDefaultAcl(bucket, entity.toPb());
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : Acl.fromPb(answer);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public boolean deleteDefaultAcl(final String bucket, final Entity entity) {
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return storageRpc.deleteDefaultAcl(bucket, entity.toPb());
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Acl createDefaultAcl(String bucket, Acl acl) {
    final ObjectAccessControl aclPb = acl.toObjectPb().setBucket(bucket);
    try {
      return Acl.fromPb(
          runWithRetries(
              new Callable<ObjectAccessControl>() {
                @Override
                public ObjectAccessControl call() {
                  return storageRpc.createDefaultAcl(aclPb);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Acl updateDefaultAcl(String bucket, Acl acl) {
    final ObjectAccessControl aclPb = acl.toObjectPb().setBucket(bucket);
    try {
      return Acl.fromPb(
          runWithRetries(
              new Callable<ObjectAccessControl>() {
                @Override
                public ObjectAccessControl call() {
                  return storageRpc.patchDefaultAcl(aclPb);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public List<Acl> listDefaultAcls(final String bucket) {
    try {
      List<ObjectAccessControl> answer =
          runWithRetries(
              new Callable<List<ObjectAccessControl>>() {
                @Override
                public List<ObjectAccessControl> call() {
                  return storageRpc.listDefaultAcls(bucket);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return Lists.transform(answer, Acl.FROM_OBJECT_PB_FUNCTION);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Acl getAcl(final BlobId blob, final Entity entity) {
    try {
      ObjectAccessControl answer =
          runWithRetries(
              new Callable<ObjectAccessControl>() {
                @Override
                public ObjectAccessControl call() {
                  return storageRpc.getAcl(
                      blob.getBucket(), blob.getName(), blob.getGeneration(), entity.toPb());
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : Acl.fromPb(answer);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public boolean deleteAcl(final BlobId blob, final Entity entity) {
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return storageRpc.deleteAcl(
                  blob.getBucket(), blob.getName(), blob.getGeneration(), entity.toPb());
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Acl createAcl(final BlobId blob, final Acl acl) {
    final ObjectAccessControl aclPb =
        acl.toObjectPb()
            .setBucket(blob.getBucket())
            .setObject(blob.getName())
            .setGeneration(blob.getGeneration());
    try {
      return Acl.fromPb(
          runWithRetries(
              new Callable<ObjectAccessControl>() {
                @Override
                public ObjectAccessControl call() {
                  return storageRpc.createAcl(aclPb);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Acl updateAcl(BlobId blob, Acl acl) {
    final ObjectAccessControl aclPb =
        acl.toObjectPb()
            .setBucket(blob.getBucket())
            .setObject(blob.getName())
            .setGeneration(blob.getGeneration());
    try {
      return Acl.fromPb(
          runWithRetries(
              new Callable<ObjectAccessControl>() {
                @Override
                public ObjectAccessControl call() {
                  return storageRpc.patchAcl(aclPb);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public List<Acl> listAcls(final BlobId blob) {
    try {
      List<ObjectAccessControl> answer =
          runWithRetries(
              new Callable<List<ObjectAccessControl>>() {
                @Override
                public List<ObjectAccessControl> call() {
                  return storageRpc.listAcls(
                      blob.getBucket(), blob.getName(), blob.getGeneration());
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return Lists.transform(answer, Acl.FROM_OBJECT_PB_FUNCTION);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  public HmacKey createHmacKey(
      final ServiceAccount serviceAccount, final CreateHmacKeyOption... options) {
    try {
      return HmacKey.fromPb(
          runWithRetries(
              new Callable<com.google.api.services.storage.model.HmacKey>() {
                @Override
                public com.google.api.services.storage.model.HmacKey call() {
                  return storageRpc.createHmacKey(serviceAccount.getEmail(), optionMap(options));
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Page<HmacKeyMetadata> listHmacKeys(ListHmacKeysOption... options) {
    return listHmacKeys(getOptions(), optionMap(options));
  }

  @Override
  public HmacKeyMetadata getHmacKey(final String accessId, final GetHmacKeyOption... options) {
    try {
      return HmacKeyMetadata.fromPb(
          runWithRetries(
              new Callable<com.google.api.services.storage.model.HmacKeyMetadata>() {
                @Override
                public com.google.api.services.storage.model.HmacKeyMetadata call() {
                  return storageRpc.getHmacKey(accessId, optionMap(options));
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  private HmacKeyMetadata updateHmacKey(
      final HmacKeyMetadata hmacKeyMetadata, final UpdateHmacKeyOption... options) {
    try {
      return HmacKeyMetadata.fromPb(
          runWithRetries(
              new Callable<com.google.api.services.storage.model.HmacKeyMetadata>() {
                @Override
                public com.google.api.services.storage.model.HmacKeyMetadata call() {
                  return storageRpc.updateHmacKey(hmacKeyMetadata.toPb(), optionMap(options));
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public HmacKeyMetadata updateHmacKeyState(
      final HmacKeyMetadata hmacKeyMetadata,
      final HmacKey.HmacKeyState state,
      final UpdateHmacKeyOption... options) {
    HmacKeyMetadata updatedMetadata =
        HmacKeyMetadata.newBuilder(hmacKeyMetadata.getServiceAccount())
            .setProjectId(hmacKeyMetadata.getProjectId())
            .setAccessId(hmacKeyMetadata.getAccessId())
            .setState(state)
            .build();
    return updateHmacKey(updatedMetadata, options);
  }

  @Override
  public void deleteHmacKey(final HmacKeyMetadata metadata, final DeleteHmacKeyOption... options) {
    try {
      runWithRetries(
          new Callable<Void>() {
            @Override
            public Void call() {
              storageRpc.deleteHmacKey(metadata.toPb(), optionMap(options));
              return null;
            }
          },
          getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  private static Page<HmacKeyMetadata> listHmacKeys(
      final StorageOptions serviceOptions, final Map<StorageRpc.Option, ?> options) {
    try {
      Tuple<String, Iterable<com.google.api.services.storage.model.HmacKeyMetadata>> result =
          runWithRetries(
              new Callable<
                  Tuple<
                      String, Iterable<com.google.api.services.storage.model.HmacKeyMetadata>>>() {
                @Override
                public Tuple<
                        String, Iterable<com.google.api.services.storage.model.HmacKeyMetadata>>
                    call() {
                  return serviceOptions.getStorageRpcV1().listHmacKeys(options);
                }
              },
              serviceOptions.getRetrySettings(),
              EXCEPTION_HANDLER,
              serviceOptions.getClock());
      String cursor = result.x();
      final Iterable<HmacKeyMetadata> metadata =
          result.y() == null
              ? ImmutableList.<HmacKeyMetadata>of()
              : Iterables.transform(
                  result.y(),
                  new Function<
                      com.google.api.services.storage.model.HmacKeyMetadata, HmacKeyMetadata>() {
                    @Override
                    public HmacKeyMetadata apply(
                        com.google.api.services.storage.model.HmacKeyMetadata metadataPb) {
                      return HmacKeyMetadata.fromPb(metadataPb);
                    }
                  });
      return new PageImpl<>(
          new HmacKeyMetadataPageFetcher(serviceOptions, options), cursor, metadata);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Policy getIamPolicy(final String bucket, BucketSourceOption... options) {
    try {
      final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
      return convertFromApiPolicy(
          runWithRetries(
              new Callable<com.google.api.services.storage.model.Policy>() {
                @Override
                public com.google.api.services.storage.model.Policy call() {
                  return storageRpc.getIamPolicy(bucket, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Policy setIamPolicy(
      final String bucket, final Policy policy, BucketSourceOption... options) {
    try {
      final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
      return convertFromApiPolicy(
          runWithRetries(
              new Callable<com.google.api.services.storage.model.Policy>() {
                @Override
                public com.google.api.services.storage.model.Policy call() {
                  return storageRpc.setIamPolicy(bucket, convertToApiPolicy(policy), optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public List<Boolean> testIamPermissions(
      final String bucket, final List<String> permissions, BucketSourceOption... options) {
    try {
      final Map<StorageRpc.Option, ?> optionsMap = optionMap(options);
      TestIamPermissionsResponse response =
          runWithRetries(
              new Callable<TestIamPermissionsResponse>() {
                @Override
                public TestIamPermissionsResponse call() {
                  return storageRpc.testIamPermissions(bucket, permissions, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      final Set<String> heldPermissions =
          response.getPermissions() != null
              ? ImmutableSet.copyOf(response.getPermissions())
              : ImmutableSet.<String>of();
      return Lists.transform(
          permissions,
          new Function<String, Boolean>() {
            @Override
            public Boolean apply(String permission) {
              return heldPermissions.contains(permission);
            }
          });
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public Bucket lockRetentionPolicy(BucketInfo bucketInfo, BucketTargetOption... options) {
    final com.google.api.services.storage.model.Bucket bucketPb = bucketInfo.toPb();
    final Map<StorageRpc.Option, ?> optionsMap = optionMap(bucketInfo, options);
    try {
      return Bucket.fromPb(
          this,
          runWithRetries(
              new Callable<com.google.api.services.storage.model.Bucket>() {
                @Override
                public com.google.api.services.storage.model.Bucket call() {
                  return storageRpc.lockRetentionPolicy(bucketPb, optionsMap);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public ServiceAccount getServiceAccount(final String projectId) {
    try {
      com.google.api.services.storage.model.ServiceAccount answer =
          runWithRetries(
              new Callable<com.google.api.services.storage.model.ServiceAccount>() {
                @Override
                public com.google.api.services.storage.model.ServiceAccount call() {
                  return storageRpc.getServiceAccount(projectId);
                }
              },
              getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              getOptions().getClock());
      return answer == null ? null : ServiceAccount.fromPb(answer);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  private static <T> void addToOptionMap(
      StorageRpc.Option option, T defaultValue, Map<StorageRpc.Option, Object> map) {
    addToOptionMap(option, option, defaultValue, map);
  }

  private static <T> void addToOptionMap(
      StorageRpc.Option getOption,
      StorageRpc.Option putOption,
      T defaultValue,
      Map<StorageRpc.Option, Object> map) {
    if (map.containsKey(getOption)) {
      @SuppressWarnings("unchecked")
      T value = (T) map.remove(getOption);
      checkArgument(
          value != null || defaultValue != null,
          "Option " + getOption.value() + " is missing a value");
      value = firstNonNull(value, defaultValue);
      map.put(putOption, value);
    }
  }

  private static Map<StorageRpc.Option, ?> optionMap(
      Long generation, Long metaGeneration, Iterable<? extends Option> options) {
    return optionMap(generation, metaGeneration, options, false);
  }

  private static Map<StorageRpc.Option, ?> optionMap(
      Long generation,
      Long metaGeneration,
      Iterable<? extends Option> options,
      boolean useAsSource) {
    Map<StorageRpc.Option, Object> temp = Maps.newEnumMap(StorageRpc.Option.class);
    for (Option option : options) {
      Object prev = temp.put(option.getRpcOption(), option.getValue());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    Boolean value = (Boolean) temp.remove(DELIMITER);
    if (Boolean.TRUE.equals(value)) {
      temp.put(DELIMITER, PATH_DELIMITER);
    }
    if (useAsSource) {
      addToOptionMap(IF_GENERATION_MATCH, IF_SOURCE_GENERATION_MATCH, generation, temp);
      addToOptionMap(IF_GENERATION_NOT_MATCH, IF_SOURCE_GENERATION_NOT_MATCH, generation, temp);
      addToOptionMap(IF_METAGENERATION_MATCH, IF_SOURCE_METAGENERATION_MATCH, metaGeneration, temp);
      addToOptionMap(
          IF_METAGENERATION_NOT_MATCH, IF_SOURCE_METAGENERATION_NOT_MATCH, metaGeneration, temp);
    } else {
      addToOptionMap(IF_GENERATION_MATCH, generation, temp);
      addToOptionMap(IF_GENERATION_NOT_MATCH, generation, temp);
      addToOptionMap(IF_METAGENERATION_MATCH, metaGeneration, temp);
      addToOptionMap(IF_METAGENERATION_NOT_MATCH, metaGeneration, temp);
    }
    return ImmutableMap.copyOf(temp);
  }

  private static Map<StorageRpc.Option, ?> optionMap(Option... options) {
    return optionMap(null, null, Arrays.asList(options));
  }

  private static Map<StorageRpc.Option, ?> optionMap(
      Long generation, Long metaGeneration, Option... options) {
    return optionMap(generation, metaGeneration, Arrays.asList(options));
  }

  private static Map<StorageRpc.Option, ?> optionMap(BucketInfo bucketInfo, Option... options) {
    return optionMap(null, bucketInfo.getMetageneration(), options);
  }

  static Map<StorageRpc.Option, ?> optionMap(BlobInfo blobInfo, Option... options) {
    return optionMap(blobInfo.getGeneration(), blobInfo.getMetageneration(), options);
  }

  static Map<StorageRpc.Option, ?> optionMap(BlobId blobId, Option... options) {
    return optionMap(blobId.getGeneration(), null, options);
  }
}

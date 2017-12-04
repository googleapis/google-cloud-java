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

package com.google.cloud.storage.spi.v1;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.util.IOUtils;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.Storage.Objects.Get;
import com.google.api.services.storage.Storage.Objects.Insert;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.Buckets;
import com.google.api.services.storage.model.ComposeRequest;
import com.google.api.services.storage.model.ComposeRequest.SourceObjects.ObjectPreconditions;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.cloud.BaseServiceException;
import com.google.cloud.Tuple;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.RestartableInputStream;
import com.google.cloud.storage.RetryableInputStreamContent;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;

public class HttpStorageRpc implements StorageRpc {

  public static final String DEFAULT_PROJECTION = "full";
  private static final String ENCRYPTION_KEY_PREFIX = "x-goog-encryption-";
  private static final String SOURCE_ENCRYPTION_KEY_PREFIX = "x-goog-copy-source-encryption-";
  private final StorageOptions options;
  private final Storage storage;

  private static final long MEGABYTE = 1024L * 1024L;

  public HttpStorageRpc(StorageOptions options) {
    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = transportOptions.getHttpTransportFactory().create();
    HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
    this.options = options;
    storage = new Storage.Builder(transport, new JacksonFactory(), initializer)
        .setRootUrl(options.getHost())
        .setApplicationName(options.getApplicationName())
        .build();
  }

  private class DefaultRpcBatch implements RpcBatch {

    // Batch size is limited as, due to some current service implementation details, the service
    // performs better if the batches are split for better distribution. See
    // https://github.com/GoogleCloudPlatform/google-cloud-java/pull/952#issuecomment-213466772 for
    // background.
    private static final int MAX_BATCH_SIZE = 100;

    private final Storage storage;
    private final LinkedList<BatchRequest> batches;
    private int currentBatchSize;

    private DefaultRpcBatch(Storage storage) {
      this.storage = storage;
      batches = new LinkedList<>();
      batches.add(storage.batch());
    }

    @Override
    public void addDelete(StorageObject storageObject, RpcBatch.Callback<Void> callback,
        Map<Option, ?> options) {
      try {
        if (currentBatchSize == MAX_BATCH_SIZE) {
          batches.add(storage.batch());
          currentBatchSize = 0;
        }
        deleteCall(storageObject, options).queue(batches.getLast(), toJsonCallback(callback));
        currentBatchSize++;
      } catch (IOException ex) {
        throw translate(ex);
      }
    }

    @Override
    public void addPatch(StorageObject storageObject, RpcBatch.Callback<StorageObject> callback,
        Map<Option, ?> options) {
      try {
        if (currentBatchSize == MAX_BATCH_SIZE) {
          batches.add(storage.batch());
          currentBatchSize = 0;
        }
        patchCall(storageObject, options).queue(batches.getLast(), toJsonCallback(callback));
        currentBatchSize++;
      } catch (IOException ex) {
        throw translate(ex);
      }
    }

    @Override
    public void addGet(StorageObject storageObject, RpcBatch.Callback<StorageObject> callback,
        Map<Option, ?> options) {
      try {
        if (currentBatchSize == MAX_BATCH_SIZE) {
          batches.add(storage.batch());
          currentBatchSize = 0;
        }
        getCall(storageObject, options).queue(batches.getLast(), toJsonCallback(callback));
        currentBatchSize++;
      } catch (IOException ex) {
        throw translate(ex);
      }
    }

    @Override
    public void submit() {
      try {
        for (BatchRequest batch : batches) {
          batch.execute();
        }
      } catch (IOException ex) {
        throw translate(ex);
      }
    }
  }

  private static <T> JsonBatchCallback<T> toJsonCallback(final RpcBatch.Callback<T> callback) {
    return new JsonBatchCallback<T>() {
      @Override
      public void onSuccess(T response, HttpHeaders httpHeaders) throws IOException {
        callback.onSuccess(response);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError, HttpHeaders httpHeaders)
          throws IOException {
        callback.onFailure(googleJsonError);
      }
    };
  }

  private static StorageException translate(IOException exception) {
    return new StorageException(exception);
  }

  private static StorageException translate(GoogleJsonError exception) {
    return new StorageException(exception);
  }

  private static void setEncryptionHeaders(HttpHeaders headers, String headerPrefix,
      Map<Option, ?> options) {
    String key = Option.CUSTOMER_SUPPLIED_KEY.getString(options);
    if (key != null) {
      BaseEncoding base64 = BaseEncoding.base64();
      HashFunction hashFunction = Hashing.sha256();
      headers.set(headerPrefix + "algorithm", "AES256");
      headers.set(headerPrefix + "key", key);
      headers.set(headerPrefix + "key-sha256",
          base64.encode(hashFunction.hashBytes(base64.decode(key)).asBytes()));
    }
  }

  @Override
  public Bucket create(Bucket bucket, Map<Option, ?> options) {
    try {
      return storage.buckets()
          .insert(this.options.getProjectId(), bucket)
          .setProjection(DEFAULT_PROJECTION)
          .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
          .setPredefinedDefaultObjectAcl(Option.PREDEFINED_DEFAULT_OBJECT_ACL.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public StorageObject create(StorageObject storageObject, final InputStream content,
      Map<Option, ?> options) {
    try {
      Storage.Objects.Insert insert = storage.objects()
          .insert(storageObject.getBucket(), storageObject,
              new InputStreamContent(storageObject.getContentType(), content));
      insert.getMediaHttpUploader().setDirectUploadEnabled(true);
      setEncryptionHeaders(insert.getRequestHeaders(), ENCRYPTION_KEY_PREFIX, options);
      return insert.setProjection(DEFAULT_PROJECTION)
          .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
          .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public StorageObject create(StorageObject storageObject, final RestartableInputStream content,
                              Map<Option, ?> options) {
    try {
      Storage.Objects.Insert insert = storage.objects()
              .insert(storageObject.getBucket(), storageObject,
                      new RetryableInputStreamContent(storageObject.getContentType(), content));
      insert.getMediaHttpUploader().setDirectUploadEnabled(true);
      setEncryptionHeaders(insert.getRequestHeaders(), ENCRYPTION_KEY_PREFIX, options);
      return insert.setProjection(DEFAULT_PROJECTION)
              .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
              .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
              .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
              .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
              .setUserProject(Option.USER_PROJECT.getString(options))
              .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Bucket>> list(Map<Option, ?> options) {
    try {
      Buckets buckets = storage.buckets()
          .list(this.options.getProjectId())
          .setProjection(DEFAULT_PROJECTION)
          .setPrefix(Option.PREFIX.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
      return Tuple.<String, Iterable<Bucket>>of(buckets.getNextPageToken(), buckets.getItems());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<StorageObject>> list(final String bucket, Map<Option, ?> options) {
    try {
      Objects objects = storage.objects()
          .list(bucket)
          .setProjection(DEFAULT_PROJECTION)
          .setVersions(Option.VERSIONS.getBoolean(options))
          .setDelimiter(Option.DELIMITER.getString(options))
          .setPrefix(Option.PREFIX.getString(options))
          .setMaxResults(Option.MAX_RESULTS.getLong(options))
          .setPageToken(Option.PAGE_TOKEN.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
      Iterable<StorageObject> storageObjects = Iterables.concat(
          firstNonNull(objects.getItems(), ImmutableList.<StorageObject>of()),
          objects.getPrefixes() != null
              ? Lists.transform(objects.getPrefixes(), objectFromPrefix(bucket))
              : ImmutableList.<StorageObject>of());
      return Tuple.of(objects.getNextPageToken(), storageObjects);
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private static Function<String, StorageObject> objectFromPrefix(final String bucket) {
    return new Function<String, StorageObject>() {
      @Override
      public StorageObject apply(String prefix) {
        return new StorageObject()
            .set("isDirectory", true)
            .setBucket(bucket)
            .setName(prefix)
            .setSize(BigInteger.ZERO);
      }
    };
  }

  @Override
  public Bucket get(Bucket bucket, Map<Option, ?> options) {
    try {
      return storage.buckets()
          .get(bucket.getName())
          .setProjection(DEFAULT_PROJECTION)
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setFields(Option.FIELDS.getString(options))
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  private Storage.Objects.Get getCall(StorageObject object, Map<Option, ?> options)
      throws IOException {
    return storage.objects()
        .get(object.getBucket(), object.getName())
        .setGeneration(object.getGeneration())
        .setProjection(DEFAULT_PROJECTION)
        .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
        .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
        .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
        .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
        .setFields(Option.FIELDS.getString(options))
        .setUserProject(Option.USER_PROJECT.getString(options));
  }

  @Override
  public StorageObject get(StorageObject object, Map<Option, ?> options) {
    try {
      return getCall(object, options).execute();
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public Bucket patch(Bucket bucket, Map<Option, ?> options) {
    try {
      return storage.buckets()
          .patch(bucket.getName(), bucket)
          .setProjection(DEFAULT_PROJECTION)
          .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
          .setPredefinedDefaultObjectAcl(Option.PREDEFINED_DEFAULT_OBJECT_ACL.getString(options))
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private Storage.Objects.Patch patchCall(StorageObject storageObject, Map<Option, ?> options)
      throws IOException {
    return storage.objects()
        .patch(storageObject.getBucket(), storageObject.getName(), storageObject)
        .setProjection(DEFAULT_PROJECTION)
        .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
        .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
        .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
        .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
        .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
        .setUserProject(Option.USER_PROJECT.getString(options));
  }

  @Override
  public StorageObject patch(StorageObject storageObject, Map<Option, ?> options) {
    try {
      return patchCall(storageObject, options).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public boolean delete(Bucket bucket, Map<Option, ?> options) {
    try {
      storage.buckets()
          .delete(bucket.getName())
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
      return true;
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  private Storage.Objects.Delete deleteCall(StorageObject blob, Map<Option, ?> options)
      throws IOException {
    return storage.objects()
        .delete(blob.getBucket(), blob.getName())
        .setGeneration(blob.getGeneration())
        .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
        .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
        .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
        .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
        .setUserProject(Option.USER_PROJECT.getString(options));
  }

  @Override
  public boolean delete(StorageObject blob, Map<Option, ?> options) {
    try {
      deleteCall(blob, options).execute();
      return true;
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public StorageObject compose(Iterable<StorageObject> sources, StorageObject target,
      Map<Option, ?> targetOptions) {
    ComposeRequest request = new ComposeRequest();
    request.setDestination(target);
    List<ComposeRequest.SourceObjects> sourceObjects = new ArrayList<>();
    for (StorageObject source : sources) {
      ComposeRequest.SourceObjects sourceObject = new ComposeRequest.SourceObjects();
      sourceObject.setName(source.getName());
      Long generation = source.getGeneration();
      if (generation != null) {
        sourceObject.setGeneration(generation);
        sourceObject.setObjectPreconditions(
            new ObjectPreconditions().setIfGenerationMatch(generation));
      }
      sourceObjects.add(sourceObject);
    }
    request.setSourceObjects(sourceObjects);
    try {
      return storage.objects()
          .compose(target.getBucket(), target.getName(), request)
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(targetOptions))
          .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(targetOptions))
          .setUserProject(Option.USER_PROJECT.getString(targetOptions))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public byte[] load(StorageObject from, Map<Option, ?> options) {
    try {
      Storage.Objects.Get getRequest = storage.objects()
          .get(from.getBucket(), from.getName())
          .setGeneration(from.getGeneration())
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
          .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
          .setUserProject(Option.USER_PROJECT.getString(options));
      setEncryptionHeaders(getRequest.getRequestHeaders(), ENCRYPTION_KEY_PREFIX, options);
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      getRequest.executeMedia().download(out);
      return out.toByteArray();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public RpcBatch createBatch() {
    return new DefaultRpcBatch(storage);
  }

  @Override
  public Tuple<String, byte[]> read(StorageObject from, Map<Option, ?> options, long position,
      int bytes) {
    try {
      Get req = storage.objects()
          .get(from.getBucket(), from.getName())
          .setGeneration(from.getGeneration())
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
          .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
          .setUserProject(Option.USER_PROJECT.getString(options));
      checkArgument(position >= 0, "Position should be non-negative, is %d", position);
      StringBuilder range = new StringBuilder();
      range.append("bytes=").append(position).append("-").append(position + bytes - 1);
      HttpHeaders requestHeaders = req.getRequestHeaders();
      requestHeaders.setRange(range.toString());
      setEncryptionHeaders(requestHeaders, ENCRYPTION_KEY_PREFIX, options);
      ByteArrayOutputStream output = new ByteArrayOutputStream(bytes);
      HttpResponse httpResponse = req.executeMedia();
      // todo(mziccard) remove when
      // https://github.com/GoogleCloudPlatform/google-cloud-java/issues/982 is fixed
      String contentEncoding = httpResponse.getContentEncoding();
      if (contentEncoding != null && contentEncoding.contains("gzip")) {
        try {
          Field responseField = httpResponse.getClass().getDeclaredField("response");
          responseField.setAccessible(true);
          LowLevelHttpResponse lowLevelHttpResponse =
              (LowLevelHttpResponse) responseField.get(httpResponse);
          IOUtils.copy(lowLevelHttpResponse.getContent(), output);
        } catch (IllegalAccessException|NoSuchFieldException ex) {
          throw new StorageException(
              BaseServiceException.UNKNOWN_CODE, "Error parsing gzip response", ex);
        }
      } else {
        httpResponse.download(output);
      }
      String etag = req.getLastResponseHeaders().getETag();
      return Tuple.of(etag, output.toByteArray());
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE) {
        return Tuple.of(null, new byte[0]);
      }
      throw serviceException;
    }
  }

  @Override
  public void write(String uploadId, byte[] toWrite, int toWriteOffset, long destOffset, int length,
      boolean last) {
    try {
      if (length == 0 && !last) {
        return;
      }
      GenericUrl url = new GenericUrl(uploadId);
      HttpRequest httpRequest = storage.getRequestFactory().buildPutRequest(url,
          new ByteArrayContent(null, toWrite, toWriteOffset, length));
      long limit = destOffset + length;
      StringBuilder range = new StringBuilder("bytes ");
      if (length == 0) {
        range.append('*');
      } else {
        range.append(destOffset).append('-').append(limit - 1);
      }
      range.append('/');
      if (last) {
        range.append(limit);
      } else {
        range.append('*');
      }
      httpRequest.getHeaders().setContentRange(range.toString());
      int code;
      String message;
      IOException exception = null;
      try {
        HttpResponse response = httpRequest.execute();
        code = response.getStatusCode();
        message = response.getStatusMessage();
      } catch (HttpResponseException ex) {
        exception = ex;
        code = ex.getStatusCode();
        message = ex.getStatusMessage();
      }
      if (!last && code != 308 || last && !(code == 200 || code == 201)) {
        if (exception != null) {
          throw exception;
        }
        GoogleJsonError error = new GoogleJsonError();
        error.setCode(code);
        error.setMessage(message);
        throw translate(error);
      }
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public String open(StorageObject object, Map<Option, ?> options) {
    try {
      Insert req = storage.objects().insert(object.getBucket(), object);
      GenericUrl url = req.buildHttpRequest().getUrl();
      String scheme = url.getScheme();
      String host = url.getHost();
      String path = "/upload" + url.getRawPath();
      url = new GenericUrl(scheme + "://" + host + path);
      url.set("uploadType", "resumable");
      url.set("name", object.getName());
      for (Option option : options.keySet()) {
        Object content = option.get(options);
        if (content != null) {
          url.set(option.value(), content.toString());
        }
      }
      JsonFactory jsonFactory = storage.getJsonFactory();
      HttpRequestFactory requestFactory = storage.getRequestFactory();
      HttpRequest httpRequest =
          requestFactory.buildPostRequest(url, new JsonHttpContent(jsonFactory, object));
      HttpHeaders requestHeaders = httpRequest.getHeaders();
      requestHeaders.set("X-Upload-Content-Type",
          firstNonNull(object.getContentType(), "application/octet-stream"));
      String key = Option.CUSTOMER_SUPPLIED_KEY.getString(options);
      if (key != null) {
        BaseEncoding base64 = BaseEncoding.base64();
        HashFunction hashFunction = Hashing.sha256();
        requestHeaders.set("x-goog-encryption-algorithm", "AES256");
        requestHeaders.set("x-goog-encryption-key", key);
        requestHeaders.set("x-goog-encryption-key-sha256",
            base64.encode(hashFunction.hashBytes(base64.decode(key)).asBytes()));
      }
      HttpResponse response = httpRequest.execute();
      if (response.getStatusCode() != 200) {
        GoogleJsonError error = new GoogleJsonError();
        error.setCode(response.getStatusCode());
        error.setMessage(response.getStatusMessage());
        throw translate(error);
      }
      return response.getHeaders().getLocation();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public RewriteResponse openRewrite(RewriteRequest rewriteRequest) {
    return rewrite(rewriteRequest, null);
  }

  @Override
  public RewriteResponse continueRewrite(RewriteResponse previousResponse) {
    return rewrite(previousResponse.rewriteRequest, previousResponse.rewriteToken);
  }

  private RewriteResponse rewrite(RewriteRequest req, String token) {
    try {
      String userProject = Option.USER_PROJECT.getString(req.sourceOptions);
      if (userProject == null) {
        userProject = Option.USER_PROJECT.getString(req.targetOptions);
      }

      Long maxBytesRewrittenPerCall = req.megabytesRewrittenPerCall != null
          ? req.megabytesRewrittenPerCall * MEGABYTE : null;
      Storage.Objects.Rewrite rewrite = storage.objects()
          .rewrite(req.source.getBucket(), req.source.getName(), req.target.getBucket(),
              req.target.getName(), req.overrideInfo ? req.target : null)
          .setSourceGeneration(req.source.getGeneration())
          .setRewriteToken(token)
          .setMaxBytesRewrittenPerCall(maxBytesRewrittenPerCall)
          .setProjection(DEFAULT_PROJECTION)
          .setIfSourceMetagenerationMatch(Option.IF_SOURCE_METAGENERATION_MATCH.getLong(req.sourceOptions))
          .setIfSourceMetagenerationNotMatch(
              Option.IF_SOURCE_METAGENERATION_NOT_MATCH.getLong(req.sourceOptions))
          .setIfSourceGenerationMatch(Option.IF_SOURCE_GENERATION_MATCH.getLong(req.sourceOptions))
          .setIfSourceGenerationNotMatch(Option.IF_SOURCE_GENERATION_NOT_MATCH.getLong(req.sourceOptions))
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(req.targetOptions))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(req.targetOptions))
          .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(req.targetOptions))
          .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(req.targetOptions))
          .setUserProject(userProject);
      HttpHeaders requestHeaders = rewrite.getRequestHeaders();
      setEncryptionHeaders(requestHeaders, SOURCE_ENCRYPTION_KEY_PREFIX, req.sourceOptions);
      setEncryptionHeaders(requestHeaders, ENCRYPTION_KEY_PREFIX, req.targetOptions);
      com.google.api.services.storage.model.RewriteResponse rewriteResponse = rewrite.execute();
      return new RewriteResponse(
          req,
          rewriteResponse.getResource(),
          rewriteResponse.getObjectSize().longValue(),
          rewriteResponse.getDone(),
          rewriteResponse.getRewriteToken(),
          rewriteResponse.getTotalBytesRewritten().longValue());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BucketAccessControl getAcl(String bucket, String entity, Map<Option, ?> options) {
    try {
      return storage.bucketAccessControls().get(bucket, entity)
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public boolean deleteAcl(String bucket, String entity, Map<Option, ?> options) {
    try {
      storage.bucketAccessControls().delete(bucket, entity)
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
      return true;
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public BucketAccessControl createAcl(BucketAccessControl acl, Map<Option, ?> options) {
    try {
      return storage.bucketAccessControls().insert(acl.getBucket(), acl)
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BucketAccessControl patchAcl(BucketAccessControl acl, Map<Option, ?> options) {
    try {
      return storage.bucketAccessControls()
          .patch(acl.getBucket(), acl.getEntity(), acl)
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public List<BucketAccessControl> listAcls(String bucket, Map<Option, ?> options) {
    try {
      return storage.bucketAccessControls().list(bucket)
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute().getItems();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public ObjectAccessControl getDefaultAcl(String bucket, String entity) {
    try {
      return storage.defaultObjectAccessControls().get(bucket, entity).execute();
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public boolean deleteDefaultAcl(String bucket, String entity) {
    try {
      storage.defaultObjectAccessControls().delete(bucket, entity).execute();
      return true;
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public ObjectAccessControl createDefaultAcl(ObjectAccessControl acl) {
    try {
      return storage.defaultObjectAccessControls().insert(acl.getBucket(), acl).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public ObjectAccessControl patchDefaultAcl(ObjectAccessControl acl) {
    try {
      return storage.defaultObjectAccessControls()
          .patch(acl.getBucket(), acl.getEntity(), acl)
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public List<ObjectAccessControl> listDefaultAcls(String bucket) {
    try {
      return storage.defaultObjectAccessControls().list(bucket).execute().getItems();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public ObjectAccessControl getAcl(String bucket, String object, Long generation, String entity) {
    try {
      return storage.objectAccessControls().get(bucket, object, entity)
          .setGeneration(generation)
          .execute();
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    }
  }

  @Override
  public boolean deleteAcl(String bucket, String object, Long generation, String entity) {
    try {
      storage.objectAccessControls().delete(bucket, object, entity)
          .setGeneration(generation)
          .execute();
      return true;
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public ObjectAccessControl createAcl(ObjectAccessControl acl) {
    try {
      return storage.objectAccessControls().insert(acl.getBucket(), acl.getObject(), acl)
          .setGeneration(acl.getGeneration())
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public ObjectAccessControl patchAcl(ObjectAccessControl acl) {
    try {
      return storage.objectAccessControls()
          .patch(acl.getBucket(), acl.getObject(), acl.getEntity(), acl)
          .setGeneration(acl.getGeneration())
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public List<ObjectAccessControl> listAcls(String bucket, String object, Long generation) {
    try {
      return storage.objectAccessControls().list(bucket, object)
          .setGeneration(generation)
          .execute().getItems();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }


  @Override
  public Policy getIamPolicy(String bucket, Map<Option, ?> options) {
    try {
      return storage.buckets().getIamPolicy(bucket)
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Policy setIamPolicy(String bucket, Policy policy, Map<Option, ?> options) {
    try {
      return storage.buckets().setIamPolicy(bucket, policy)
          .setUserProject(Option.USER_PROJECT.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public TestIamPermissionsResponse testIamPermissions(String bucket, List<String> permissions, Map<Option, ?> options) {
    try {
      return storage.buckets().testIamPermissions(bucket, permissions)
          .setUserProject(Option.USER_PROJECT.getString(options)).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }
}

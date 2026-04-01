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

package com.google.cloud.storage.spi.v1;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.Storage.BucketAccessControls;
import com.google.api.services.storage.Storage.Buckets;
import com.google.api.services.storage.Storage.Buckets.LockRetentionPolicy;
import com.google.api.services.storage.Storage.Buckets.SetIamPolicy;
import com.google.api.services.storage.Storage.Buckets.TestIamPermissions;
import com.google.api.services.storage.Storage.DefaultObjectAccessControls;
import com.google.api.services.storage.Storage.Notifications;
import com.google.api.services.storage.Storage.ObjectAccessControls;
import com.google.api.services.storage.Storage.Objects.Compose;
import com.google.api.services.storage.Storage.Objects.Delete;
import com.google.api.services.storage.Storage.Objects.Get;
import com.google.api.services.storage.Storage.Objects.Insert;
import com.google.api.services.storage.Storage.Objects.Move;
import com.google.api.services.storage.Storage.Objects.Patch;
import com.google.api.services.storage.Storage.Projects;
import com.google.api.services.storage.Storage.Projects.HmacKeys;
import com.google.api.services.storage.Storage.Projects.HmacKeys.Create;
import com.google.api.services.storage.Storage.Projects.HmacKeys.Update;
import com.google.api.services.storage.StorageRequest;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.Bucket.RetentionPolicy;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.ComposeRequest;
import com.google.api.services.storage.model.ComposeRequest.SourceObjects.ObjectPreconditions;
import com.google.api.services.storage.model.HmacKey;
import com.google.api.services.storage.model.HmacKeyMetadata;
import com.google.api.services.storage.model.HmacKeysMetadata;
import com.google.api.services.storage.model.Notification;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.ServiceAccount;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.cloud.Tuple;
import com.google.cloud.http.CensusHttpModule;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;

public class HttpStorageRpc implements StorageRpc {
  public static final String DEFAULT_PROJECTION = "full";
  public static final String NO_ACL_PROJECTION = "noAcl";
  private static final String ENCRYPTION_KEY_PREFIX = "x-goog-encryption-";
  private static final String SOURCE_ENCRYPTION_KEY_PREFIX = "x-goog-copy-source-encryption-";

  // declare this HttpStatus code here as it's not included in java.net.HttpURLConnection
  private static final int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
  private static final boolean IS_RECORD_EVENTS = true;
  private static final String X_GOOG_GCS_IDEMPOTENCY_TOKEN = "x-goog-gcs-idempotency-token";

  private final StorageOptions options;
  private final Storage storage;
  private final Tracer tracer = Tracing.getTracer();
  private final HttpRequestInitializer batchRequestInitializer;

  private static final long MEGABYTE = 1024L * 1024L;
  private static final FileNameMap FILE_NAME_MAP = URLConnection.getFileNameMap();

  public HttpStorageRpc(StorageOptions options) {
    this(options, new JacksonFactory());
  }

  public HttpStorageRpc(StorageOptions options, JsonFactory jsonFactory) {
    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = transportOptions.getHttpTransportFactory().create();
    HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
    this.options = options;

    boolean isTm =
        Arrays.stream(Thread.currentThread().getStackTrace())
            .anyMatch(
                ste -> ste.getClassName().startsWith("com.google.cloud.storage.transfermanager"));
    String tm = isTm ? "gccl-gcs-cmd/tm" : null;

    // Open Census initialization
    String applicationName = options.getApplicationName();
    CensusHttpModule censusHttpModule = new CensusHttpModule(tracer, IS_RECORD_EVENTS);
    initializer = censusHttpModule.getHttpRequestInitializer(initializer);
    initializer = new InvocationIdInitializer(initializer, applicationName, tm);
    batchRequestInitializer = censusHttpModule.getHttpRequestInitializer(null);
    storage =
        new Storage.Builder(transport, jsonFactory, initializer)
            .setRootUrl(options.getHost())
            .setApplicationName(applicationName)
            .build();
  }

  public Storage getStorage() {
    return storage;
  }

  private static final class InvocationIdInitializer implements HttpRequestInitializer {
    @Nullable HttpRequestInitializer initializer;
    @Nullable private final String applicationName;
    @Nullable private final String tm;

    private InvocationIdInitializer(
        @Nullable HttpRequestInitializer initializer, @Nullable String applicationName, String tm) {
      this.initializer = initializer;
      this.applicationName = applicationName;
      this.tm = tm;
    }

    @Override
    public void initialize(HttpRequest request) throws IOException {
      checkNotNull(request);
      if (this.initializer != null) {
        this.initializer.initialize(request);
      }
      request.setInterceptor(
          new InvocationIdInterceptor(request.getInterceptor(), applicationName, tm));
    }
  }

  private static final class InvocationIdInterceptor implements HttpExecuteInterceptor {

    private static final Collector<CharSequence, ?, String> JOINER = Collectors.joining(" ");
    @Nullable private final HttpExecuteInterceptor interceptor;
    @Nullable private final String applicationName;

    @Nullable private final String tm;

    private InvocationIdInterceptor(
        @Nullable HttpExecuteInterceptor interceptor, @Nullable String applicationName, String tm) {
      this.interceptor = interceptor;
      this.applicationName = applicationName;
      this.tm = tm;
    }

    @Override
    public void intercept(HttpRequest request) throws IOException {
      checkNotNull(request);
      if (this.interceptor != null) {
        this.interceptor.intercept(request);
      }
      HttpRpcContext httpRpcContext = HttpRpcContext.getInstance();
      UUID invocationId = httpRpcContext.getInvocationId();
      final String signatureKey = "Signature="; // For V2 and V4 signedURLs
      final String builtURL = request.getUrl().build();
      if (invocationId != null && !builtURL.contains(signatureKey)) {
        HttpHeaders headers = request.getHeaders();
        String existing = (String) headers.get("x-goog-api-client");
        String invocationEntry = "gccl-invocation-id/" + invocationId;
        final String newValue =
            Stream.of(existing, invocationEntry, tm)
                .filter(java.util.Objects::nonNull)
                .collect(JOINER);
        headers.set("x-goog-api-client", newValue);
        headers.set(X_GOOG_GCS_IDEMPOTENCY_TOKEN, invocationId);

        String userAgent = headers.getUserAgent();
        if ((userAgent == null
            || userAgent.isEmpty()
            || (applicationName != null && !userAgent.contains(applicationName)))) {
          headers.setUserAgent(applicationName);
        }
      }
    }
  }

  private class DefaultRpcBatch implements RpcBatch {

    // Batch size is limited as, due to some current service implementation details, the service
    // performs better if the batches are split for better distribution. See
    // https://github.com/googleapis/google-cloud-java/pull/952#issuecomment-213466772 for
    // background.
    private static final int MAX_BATCH_SIZE = 100;

    private final Storage storage;
    private final LinkedList<BatchRequest> batches;
    private int currentBatchSize;

    private DefaultRpcBatch(Storage storage) {
      this.storage = storage;
      batches = new LinkedList<>();
      // add OpenCensus HttpRequestInitializer
      batches.add(storage.batch(batchRequestInitializer));
    }

    @Override
    public void addDelete(
        StorageObject storageObject, RpcBatch.Callback<Void> callback, Map<Option, ?> options) {
      try {
        if (currentBatchSize == MAX_BATCH_SIZE) {
          batches.add(storage.batch());
          currentBatchSize = 0;
        }
        Delete call = deleteCall(storageObject, options);
        addIdempotencyTokenToCall(call);
        call.queue(batches.getLast(), toJsonCallback(callback));
        currentBatchSize++;
      } catch (IOException ex) {
        throw translate(ex);
      }
    }

    @Override
    public void addPatch(
        StorageObject storageObject,
        RpcBatch.Callback<StorageObject> callback,
        Map<Option, ?> options) {
      try {
        if (currentBatchSize == MAX_BATCH_SIZE) {
          batches.add(storage.batch());
          currentBatchSize = 0;
        }
        Patch call = patchCall(storageObject, options);
        addIdempotencyTokenToCall(call);
        call.queue(batches.getLast(), toJsonCallback(callback));
        currentBatchSize++;
      } catch (IOException ex) {
        throw translate(ex);
      }
    }

    @Override
    public void addGet(
        StorageObject storageObject,
        RpcBatch.Callback<StorageObject> callback,
        Map<Option, ?> options) {
      try {
        if (currentBatchSize == MAX_BATCH_SIZE) {
          batches.add(storage.batch());
          currentBatchSize = 0;
        }
        Get call = getCall(storageObject, options);
        addIdempotencyTokenToCall(call);
        call.queue(batches.getLast(), toJsonCallback(callback));
        currentBatchSize++;
      } catch (IOException ex) {
        throw translate(ex);
      }
    }

    @Override
    public void submit() {
      Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_BATCH_SUBMIT);
      Scope scope = tracer.withSpan(span);
      try {
        span.putAttribute("batch size", AttributeValue.longAttributeValue(batches.size()));
        for (BatchRequest batch : batches) {
          // TODO(hailongwen@): instrument 'google-api-java-client' to further break down the span.
          // Here we only add a annotation to at least know how much time each batch takes.
          span.addAnnotation("Execute batch request");
          batch.setBatchUrl(
              new GenericUrl(String.format(Locale.US, "%s/batch/storage/v1", options.getHost())));
          batch.execute();
        }
      } catch (IOException ex) {
        span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
        throw translate(ex);
      } finally {
        scope.close();
        span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
      }
    }

    private void addIdempotencyTokenToCall(StorageRequest<?> call) {
      HttpRpcContext instance = HttpRpcContext.getInstance();
      call.getRequestHeaders().set(X_GOOG_GCS_IDEMPOTENCY_TOKEN, instance.newInvocationId());
      instance.clearInvocationId();
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
    return StorageException.translate(exception);
  }

  private static StorageException translate(GoogleJsonError exception) {
    return new StorageException(exception);
  }

  private static void setEncryptionHeaders(
      HttpHeaders headers, String headerPrefix, Map<Option, ?> options) {
    String key = Option.CUSTOMER_SUPPLIED_KEY.getString(options);
    if (key != null) {
      BaseEncoding base64 = BaseEncoding.base64();
      HashFunction hashFunction = Hashing.sha256();
      headers.set(headerPrefix + "algorithm", "AES256");
      headers.set(headerPrefix + "key", key);
      headers.set(
          headerPrefix + "key-sha256",
          base64.encode(hashFunction.hashBytes(base64.decode(key)).asBytes()));
    }
  }

  /** Helper method to start a span. */
  private Span startSpan(String spanName) {
    return tracer.spanBuilder(spanName).setRecordEvents(IS_RECORD_EVENTS).startSpan();
  }

  @Override
  public Bucket create(Bucket bucket, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_BUCKET);
    Scope scope = tracer.withSpan(span);
    try {
      Storage.Buckets.Insert insert =
          storage
              .buckets()
              .insert(this.options.getProjectId(), bucket)
              .setProjection(DEFAULT_PROJECTION)
              .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
              .setPredefinedDefaultObjectAcl(
                  Option.PREDEFINED_DEFAULT_OBJECT_ACL.getString(options))
              .setUserProject(Option.USER_PROJECT.getString(options))
              .setEnableObjectRetention(Option.ENABLE_OBJECT_RETENTION.getBoolean(options));
      setExtraHeaders(insert, options);
      return insert.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public StorageObject create(
      StorageObject storageObject, final InputStream content, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_OBJECT);
    Scope scope = tracer.withSpan(span);
    try {
      Storage.Objects.Insert insert =
          storage
              .objects()
              .insert(
                  storageObject.getBucket(),
                  storageObject,
                  new InputStreamContent(detectContentType(storageObject, options), content));
      insert.getMediaHttpUploader().setDirectUploadEnabled(true);
      Boolean disableGzipContent = Option.IF_DISABLE_GZIP_CONTENT.getBoolean(options);
      if (disableGzipContent != null) {
        insert.setDisableGZipContent(disableGzipContent);
      }
      setEncryptionHeaders(insert.getRequestHeaders(), ENCRYPTION_KEY_PREFIX, options);
      setExtraHeaders(insert, options);
      return insert
          .setProjection(DEFAULT_PROJECTION)
          .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
          .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
          .setUserProject(Option.USER_PROJECT.getString(options))
          .setKmsKeyName(Option.KMS_KEY_NAME.getString(options))
          .execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Tuple<String, Iterable<Bucket>> list(Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_BUCKETS);
    Scope scope = tracer.withSpan(span);
    try {
      Storage.Buckets.List list =
          storage
              .buckets()
              .list(this.options.getProjectId())
              .setProjection(DEFAULT_PROJECTION)
              .setPrefix(Option.PREFIX.getString(options))
              .setMaxResults(Option.MAX_RESULTS.getLong(options))
              .setPageToken(Option.PAGE_TOKEN.getString(options))
              .setReturnPartialSuccess(Option.RETURN_PARTIAL_SUCCESS.getBoolean(options))
              .setFields(Option.FIELDS.getString(options))
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(list, options);
      com.google.api.services.storage.model.Buckets bucketList = list.execute();
      Iterable<Bucket> buckets =
          Iterables.concat(
              firstNonNull(bucketList.getItems(), ImmutableList.<Bucket>of()),
              bucketList.getUnreachable() != null
                  ? Lists.transform(bucketList.getUnreachable(), createUnreachableBucket())
                  : ImmutableList.<Bucket>of());
      return Tuple.<String, Iterable<Bucket>>of(bucketList.getNextPageToken(), buckets);
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Tuple<String, Iterable<StorageObject>> list(final String bucket, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_OBJECTS);
    Scope scope = tracer.withSpan(span);
    try {
      Storage.Objects.List list =
          storage
              .objects()
              .list(bucket)
              .setProjection(DEFAULT_PROJECTION)
              .setVersions(Option.VERSIONS.getBoolean(options))
              .setDelimiter(Option.DELIMITER.getString(options))
              .setStartOffset(Option.START_OFF_SET.getString(options))
              .setEndOffset(Option.END_OFF_SET.getString(options))
              .setMatchGlob(Option.MATCH_GLOB.getString(options))
              .setPrefix(Option.PREFIX.getString(options))
              .setMaxResults(Option.MAX_RESULTS.getLong(options))
              .setPageToken(Option.PAGE_TOKEN.getString(options))
              .setFields(Option.FIELDS.getString(options))
              .setUserProject(Option.USER_PROJECT.getString(options))
              .setSoftDeleted(Option.SOFT_DELETED.getBoolean(options))
              .setIncludeFoldersAsPrefixes(Option.INCLUDE_FOLDERS_AS_PREFIXES.getBoolean(options))
              .setIncludeTrailingDelimiter(Option.INCLUDE_TRAILING_DELIMITER.getBoolean(options))
              .setFilter(Option.OBJECT_FILTER.getString(options));
      setExtraHeaders(list, options);
      Objects objects = list.execute();
      Iterable<StorageObject> storageObjects =
          Iterables.concat(
              firstNonNull(objects.getItems(), ImmutableList.<StorageObject>of()),
              objects.getPrefixes() != null
                  ? Lists.transform(objects.getPrefixes(), objectFromPrefix(bucket))
                  : ImmutableList.<StorageObject>of());
      return Tuple.of(objects.getNextPageToken(), storageObjects);
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  private static String detectContentType(StorageObject object, Map<Option, ?> options) {
    String contentType = object.getContentType();
    if (contentType != null) {
      return contentType;
    }

    if (Boolean.TRUE == Option.DETECT_CONTENT_TYPE.get(options)) {
      contentType = FILE_NAME_MAP.getContentTypeFor(object.getName().toLowerCase(Locale.US));
    }

    return firstNonNull(contentType, "application/octet-stream");
  }

  private static Function<String, Bucket> createUnreachableBucket() {
    return bucketName -> new Bucket().setName(bucketName).set("isUnreachable", "true");
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
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_BUCKET);
    Scope scope = tracer.withSpan(span);
    try {
      Storage.Buckets.Get get =
          storage
              .buckets()
              .get(bucket.getName())
              .setProjection(DEFAULT_PROJECTION)
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
              .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
              .setFields(Option.FIELDS.getString(options))
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(get, options);
      return get.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  private Storage.Objects.Get getCall(StorageObject object, Map<Option, ?> options)
      throws IOException {
    Storage.Objects.Get get = storage.objects().get(object.getBucket(), object.getName());
    setEncryptionHeaders(get.getRequestHeaders(), ENCRYPTION_KEY_PREFIX, options);
    setExtraHeaders(get, options);
    return get.setGeneration(object.getGeneration())
        .setProjection(DEFAULT_PROJECTION)
        .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
        .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
        .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
        .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
        .setFields(Option.FIELDS.getString(options))
        .setUserProject(Option.USER_PROJECT.getString(options))
        .setSoftDeleted(Option.SOFT_DELETED.getBoolean(options));
  }

  @Override
  public StorageObject get(StorageObject object, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_OBJECT);
    Scope scope = tracer.withSpan(span);
    try {
      return getCall(object, options).execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public StorageObject restore(StorageObject object, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_RESTORE_OBJECT);
    Scope scope = tracer.withSpan(span);
    try {
      Storage.Objects.Restore restore =
          storage.objects().restore(object.getBucket(), object.getName(), object.getGeneration());
      setExtraHeaders(restore, options);
      return restore
          .setProjection(DEFAULT_PROJECTION)
          .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
          .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
          .setCopySourceAcl(Option.COPY_SOURCE_ACL.getBoolean(options))
          .setUserProject(Option.USER_PROJECT.getString(options))
          .setFields(Option.FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Bucket patch(Bucket bucket, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_BUCKET);
    Scope scope = tracer.withSpan(span);
    try {
      RetentionPolicy retentionPolicy = bucket.getRetentionPolicy();
      if (retentionPolicy != null) {
        // according to https://cloud.google.com/storage/docs/json_api/v1/buckets both effectiveTime
        // and isLocked are output_only. If retentionPeriod is null, null out the whole
        // RetentionPolicy.
        if (retentionPolicy.getRetentionPeriod() == null) {
          // Using Data.nullOf here is important here so the null value is written into the request
          // json. The explicit null values tells the backend to remove the policy.
          bucket.setRetentionPolicy(Data.nullOf(RetentionPolicy.class));
        }
      }

      String projection = Option.PROJECTION.getString(options);
      if (bucket.getIamConfiguration() != null
          && bucket.getIamConfiguration().getBucketPolicyOnly() != null
          && bucket.getIamConfiguration().getBucketPolicyOnly().getEnabled() != null
          && bucket.getIamConfiguration().getBucketPolicyOnly().getEnabled()) {
        // If BucketPolicyOnly is enabled, patch calls will fail if ACL information is included in
        // the request
        bucket.setDefaultObjectAcl(null);
        bucket.setAcl(null);

        if (projection == null) {
          projection = NO_ACL_PROJECTION;
        }
      }
      Buckets.Patch patch =
          storage
              .buckets()
              .patch(bucket.getName(), bucket)
              .setProjection(projection == null ? DEFAULT_PROJECTION : projection)
              .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
              .setPredefinedDefaultObjectAcl(
                  Option.PREDEFINED_DEFAULT_OBJECT_ACL.getString(options))
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
              .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(patch, options);
      return patch.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  private Storage.Objects.Patch patchCall(StorageObject storageObject, Map<Option, ?> options)
      throws IOException {
    Storage.Objects.Patch patch =
        storage
            .objects()
            .patch(storageObject.getBucket(), storageObject.getName(), storageObject)
            .setProjection(DEFAULT_PROJECTION)
            .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
            .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
            .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
            .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
            .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
            .setOverrideUnlockedRetention(Option.OVERRIDE_UNLOCKED_RETENTION.getBoolean(options))
            .setUserProject(Option.USER_PROJECT.getString(options));
    setExtraHeaders(patch, options);
    return patch;
  }

  @Override
  public StorageObject patch(StorageObject storageObject, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_OBJECT);
    Scope scope = tracer.withSpan(span);
    try {
      return patchCall(storageObject, options).execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public boolean delete(Bucket bucket, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_BUCKET);
    Scope scope = tracer.withSpan(span);
    try {
      Buckets.Delete delete =
          storage
              .buckets()
              .delete(bucket.getName())
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
              .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(delete, options);
      delete.execute();
      return true;
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  private Storage.Objects.Delete deleteCall(StorageObject blob, Map<Option, ?> options)
      throws IOException {
    Storage.Objects.Delete delete =
        storage
            .objects()
            .delete(blob.getBucket(), blob.getName())
            .setGeneration(blob.getGeneration())
            .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
            .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
            .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
            .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
            .setUserProject(Option.USER_PROJECT.getString(options));
    setExtraHeaders(delete, options);
    return delete;
  }

  @Override
  public boolean delete(StorageObject blob, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_OBJECT);
    Scope scope = tracer.withSpan(span);
    try {
      deleteCall(blob, options).execute();
      return true;
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public StorageObject compose(
      Iterable<StorageObject> sources, StorageObject target, Map<Option, ?> targetOptions) {
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
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_COMPOSE);
    Scope scope = tracer.withSpan(span);
    try {
      Compose compose =
          storage
              .objects()
              .compose(target.getBucket(), target.getName(), request)
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(targetOptions))
              .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(targetOptions))
              .setUserProject(Option.USER_PROJECT.getString(targetOptions));
      setEncryptionHeaders(compose.getRequestHeaders(), ENCRYPTION_KEY_PREFIX, targetOptions);
      setExtraHeaders(compose, targetOptions);
      return compose.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public byte[] load(StorageObject from, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_LOAD);
    Scope scope = tracer.withSpan(span);
    try {
      Storage.Objects.Get getRequest =
          storage
              .objects()
              .get(from.getBucket(), from.getName())
              .setGeneration(from.getGeneration())
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
              .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
              .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
              .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
              .setUserProject(Option.USER_PROJECT.getString(options));
      setEncryptionHeaders(getRequest.getRequestHeaders(), ENCRYPTION_KEY_PREFIX, options);
      setExtraHeaders(getRequest, options);
      if (Option.RETURN_RAW_INPUT_STREAM.getBoolean(options) != null) {
        getRequest.setReturnRawInputStream(Option.RETURN_RAW_INPUT_STREAM.getBoolean(options));
      }
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      getRequest.executeMedia().download(out);
      return out.toByteArray();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public RpcBatch createBatch() {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_BATCH);
    Scope scope = tracer.withSpan(span);
    try {
      return new DefaultRpcBatch(storage);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  private Get createReadRequest(StorageObject from, Map<Option, ?> options) throws IOException {
    Get req =
        storage
            .objects()
            .get(from.getBucket(), from.getName())
            .setGeneration(from.getGeneration())
            .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
            .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
            .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
            .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
            .setUserProject(Option.USER_PROJECT.getString(options));
    setEncryptionHeaders(req.getRequestHeaders(), ENCRYPTION_KEY_PREFIX, options);
    setExtraHeaders(req, options);
    return req;
  }

  @Override
  public long read(
      StorageObject from, Map<Option, ?> options, long position, OutputStream outputStream) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_READ);
    Scope scope = tracer.withSpan(span);
    try {
      Get req = createReadRequest(from, options);
      Boolean shouldReturnRawInputStream = Option.RETURN_RAW_INPUT_STREAM.getBoolean(options);
      if (shouldReturnRawInputStream != null) {
        req.setReturnRawInputStream(shouldReturnRawInputStream);
      } else {
        req.setReturnRawInputStream(false);
      }

      if (position > 0) {
        req.getRequestHeaders().setRange(String.format(Locale.US, "bytes=%d-", position));
      }
      MediaHttpDownloader mediaHttpDownloader = req.getMediaHttpDownloader();
      mediaHttpDownloader.setDirectDownloadEnabled(true);
      req.executeMedia().download(outputStream);
      return mediaHttpDownloader.getNumBytesDownloaded();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == SC_REQUESTED_RANGE_NOT_SATISFIABLE) {
        return 0;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Tuple<String, byte[]> read(
      StorageObject from, Map<Option, ?> options, long position, int bytes) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_READ);
    Scope scope = tracer.withSpan(span);
    try {
      checkArgument(position >= 0, "Position should be non-negative, is " + position);
      Get req = createReadRequest(from, options);
      Boolean shouldReturnRawInputStream = Option.RETURN_RAW_INPUT_STREAM.getBoolean(options);
      if (shouldReturnRawInputStream != null) {
        req.setReturnRawInputStream(shouldReturnRawInputStream);
      } else {
        req.setReturnRawInputStream(true);
      }
      StringBuilder range = new StringBuilder();
      range.append("bytes=").append(position).append("-").append(position + bytes - 1);
      HttpHeaders requestHeaders = req.getRequestHeaders();
      requestHeaders.setRange(range.toString());
      ByteArrayOutputStream output = new ByteArrayOutputStream(bytes);
      req.executeMedia().download(output);
      String etag = req.getLastResponseHeaders().getETag();
      return Tuple.of(etag, output.toByteArray());
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = StorageException.translate(ex);
      if (serviceException.getCode() == SC_REQUESTED_RANGE_NOT_SATISFIABLE) {
        return Tuple.of(null, new byte[0]);
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public void write(
      String uploadId,
      byte[] toWrite,
      int toWriteOffset,
      long destOffset,
      int length,
      boolean last) {
    writeWithResponse(uploadId, toWrite, toWriteOffset, destOffset, length, last);
  }

  @Override
  public long getCurrentUploadOffset(String uploadId) {
    try {
      GenericUrl url = new GenericUrl(uploadId);
      HttpRequest httpRequest =
          storage.getRequestFactory().buildPutRequest(url, new EmptyContent());

      httpRequest.getHeaders().setContentRange("bytes */*");
      // Turn off automatic redirects.
      // HTTP 308 are returned if upload is incomplete.
      // See: https://cloud.google.com/storage/docs/performing-resumable-uploads
      httpRequest.setFollowRedirects(false);

      HttpResponse response = null;
      try {
        response = httpRequest.execute();
        int code = response.getStatusCode();
        if (HttpStatusCodes.isSuccess(code)) {
          // Upload completed successfully
          return -1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not sure what occurred. Here's debugging information:\n");
        sb.append("Response:\n").append(response.toString()).append("\n\n");
        throw new StorageException(0, sb.toString());
      } catch (HttpResponseException ex) {
        int code = ex.getStatusCode();
        if (code == 308) {
          if (ex.getHeaders().getRange() == null) {
            // No progress has been made.
            return 0;
          }
          // API returns last byte received offset
          String range = ex.getHeaders().getRange();
          // Return next byte offset by adding 1 to last byte received offset
          return Long.parseLong(range.substring(range.indexOf("-") + 1)) + 1;
        } else {
          // Something else occurred like a 5xx so translate and throw.
          throw translate(ex);
        }
      } finally {
        if (response != null) {
          response.disconnect();
        }
      }
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public StorageObject queryCompletedResumableUpload(String uploadId, long totalBytes) {
    try {
      GenericUrl url = new GenericUrl(uploadId);
      HttpRequest req = storage.getRequestFactory().buildPutRequest(url, new EmptyContent());
      req.getHeaders().setContentRange(String.format(Locale.US, "bytes */%s", totalBytes));
      req.setParser(storage.getObjectParser());
      HttpResponse response = req.execute();
      // If the response is 200
      if (response.getStatusCode() == 200) {
        return response.parseAs(StorageObject.class);
      } else {
        throw buildStorageException(response.getStatusCode(), response.getStatusMessage());
      }
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public StorageObject writeWithResponse(
      String uploadId,
      byte[] toWrite,
      int toWriteOffset,
      long destOffset,
      int length,
      boolean last) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_WRITE);
    Scope scope = tracer.withSpan(span);
    StorageObject updatedBlob = null;
    try {
      if (length == 0 && !last) {
        return updatedBlob;
      }
      GenericUrl url = new GenericUrl(uploadId);
      HttpRequest httpRequest =
          storage
              .getRequestFactory()
              .buildPutRequest(url, new ByteArrayContent(null, toWrite, toWriteOffset, length));
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
      if (last) {
        httpRequest.setParser(storage.getObjectParser());
      }
      int code;
      String message;
      IOException exception = null;
      HttpResponse response = null;
      try {
        response = httpRequest.execute();
        code = response.getStatusCode();
        message = response.getStatusMessage();
        String contentType = response.getContentType();
        if (last
            && (code == 200 || code == 201)
            && contentType != null
            && contentType.startsWith("application/json")) {
          updatedBlob = response.parseAs(StorageObject.class);
        }
      } catch (HttpResponseException ex) {
        exception = ex;
        code = ex.getStatusCode();
        message = ex.getStatusMessage();
      } finally {
        if (response != null) {
          response.disconnect();
        }
      }
      if (!last && code != 308 || last && !(code == 200 || code == 201)) {
        if (exception != null) {
          throw exception;
        }
        throw buildStorageException(code, message);
      }
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
    return updatedBlob;
  }

  @Override
  public String open(StorageObject object, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_OPEN);
    Scope scope = tracer.withSpan(span);
    try {
      String kmsKeyName = object.getKmsKeyName();
      if (kmsKeyName != null && kmsKeyName.contains("cryptoKeyVersions")) {
        object.setKmsKeyName(Data.nullOf(String.class));
      }
      Insert req =
          storage
              .objects()
              .insert(object.getBucket(), object)
              .setName(object.getName())
              .setProjection(Option.PROJECTION.getString(options))
              .setPredefinedAcl(Option.PREDEFINED_ACL.getString(options))
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(options))
              .setIfMetagenerationNotMatch(Option.IF_METAGENERATION_NOT_MATCH.getLong(options))
              .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(options))
              .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(options))
              .setUserProject(Option.USER_PROJECT.getString(options))
              .setKmsKeyName(Option.KMS_KEY_NAME.getString(options));
      GenericUrl url = req.buildHttpRequestUrl();
      url.setRawPath("/upload" + url.getRawPath());
      url.set("uploadType", "resumable");

      JsonFactory jsonFactory = storage.getJsonFactory();
      HttpRequestFactory requestFactory = storage.getRequestFactory();
      HttpRequest httpRequest =
          requestFactory.buildPostRequest(url, new JsonHttpContent(jsonFactory, object));
      HttpHeaders requestHeaders = httpRequest.getHeaders();
      requestHeaders.set("X-Upload-Content-Type", detectContentType(object, options));
      Long xUploadContentLength = Option.X_UPLOAD_CONTENT_LENGTH.getLong(options);
      if (xUploadContentLength != null) {
        requestHeaders.set("X-Upload-Content-Length", xUploadContentLength);
      }
      setEncryptionHeaders(requestHeaders, "x-goog-encryption-", options);
      setExtraHeaders(Option.EXTRA_HEADERS.get(options), requestHeaders);
      HttpResponse response = httpRequest.execute();
      if (response.getStatusCode() != 200) {
        throw buildStorageException(response.getStatusCode(), response.getStatusMessage());
      }
      String location = response.getHeaders().getLocation();
      response.disconnect();
      return location;
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public String open(String signedURL) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_OPEN);
    Scope scope = tracer.withSpan(span);
    try {
      GenericUrl url = new GenericUrl(signedURL);
      url.set("uploadType", "resumable");
      String bytesArrayParameters = "";
      byte[] bytesArray = new byte[bytesArrayParameters.length()];
      HttpRequestFactory requestFactory = storage.getRequestFactory();
      HttpRequest httpRequest =
          requestFactory.buildPostRequest(
              url, new ByteArrayContent("", bytesArray, 0, bytesArray.length));
      HttpHeaders requestHeaders = httpRequest.getHeaders();
      requestHeaders.set("X-Upload-Content-Type", "");
      requestHeaders.set("x-goog-resumable", "start");
      // Using the x-goog-api-client header causes a signature mismatch with signed URLs generated
      // outside the Java storage client
      requestHeaders.remove("x-goog-api-client");

      HttpResponse response = httpRequest.execute();
      if (response.getStatusCode() != 201) {
        throw buildStorageException(response.getStatusCode(), response.getStatusMessage());
      }
      String location = response.getHeaders().getLocation();
      response.disconnect();
      return location;
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public StorageObject moveObject(
      String bucket,
      String sourceObject,
      String destinationObject,
      Map<Option, ?> sourceOptions,
      Map<Option, ?> targetOptions) {

    String userProject = Option.USER_PROJECT.getString(sourceOptions);
    if (userProject == null) {
      userProject = Option.USER_PROJECT.getString(targetOptions);
    }
    try {
      Move move =
          storage
              .objects()
              .move(bucket, sourceObject, destinationObject)
              .setIfSourceMetagenerationMatch(
                  Option.IF_SOURCE_METAGENERATION_MATCH.getLong(sourceOptions))
              .setIfSourceMetagenerationNotMatch(
                  Option.IF_SOURCE_METAGENERATION_NOT_MATCH.getLong(sourceOptions))
              .setIfSourceGenerationMatch(Option.IF_SOURCE_GENERATION_MATCH.getLong(sourceOptions))
              .setIfSourceGenerationNotMatch(
                  Option.IF_SOURCE_GENERATION_NOT_MATCH.getLong(sourceOptions))
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(targetOptions))
              .setIfMetagenerationNotMatch(
                  Option.IF_METAGENERATION_NOT_MATCH.getLong(targetOptions))
              .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(targetOptions))
              .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(targetOptions))
              .setUserProject(userProject);
      return move.execute();
    } catch (IOException e) {
      throw translate(e);
    }
  }

  @Override
  public RewriteResponse openRewrite(RewriteRequest rewriteRequest) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_OPEN_REWRITE);
    Scope scope = tracer.withSpan(span);
    try {
      return rewrite(rewriteRequest, null);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public RewriteResponse continueRewrite(RewriteResponse previousResponse) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CONTINUE_REWRITE);
    Scope scope = tracer.withSpan(span);
    try {
      return rewrite(previousResponse.rewriteRequest, previousResponse.rewriteToken);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  private RewriteResponse rewrite(RewriteRequest req, String token) {
    try {
      String userProject = Option.USER_PROJECT.getString(req.sourceOptions);
      if (userProject == null) {
        userProject = Option.USER_PROJECT.getString(req.targetOptions);
      }

      Long maxBytesRewrittenPerCall =
          req.megabytesRewrittenPerCall != null ? req.megabytesRewrittenPerCall * MEGABYTE : null;
      StorageObject content = req.overrideInfo ? req.target : null;
      Storage.Objects.Rewrite rewrite =
          storage
              .objects()
              .rewrite(
                  req.source.getBucket(),
                  req.source.getName(),
                  req.target.getBucket(),
                  req.target.getName(),
                  content)
              .setSourceGeneration(req.source.getGeneration())
              .setRewriteToken(token)
              .setMaxBytesRewrittenPerCall(maxBytesRewrittenPerCall)
              .setProjection(DEFAULT_PROJECTION)
              .setIfSourceMetagenerationMatch(
                  Option.IF_SOURCE_METAGENERATION_MATCH.getLong(req.sourceOptions))
              .setIfSourceMetagenerationNotMatch(
                  Option.IF_SOURCE_METAGENERATION_NOT_MATCH.getLong(req.sourceOptions))
              .setIfSourceGenerationMatch(
                  Option.IF_SOURCE_GENERATION_MATCH.getLong(req.sourceOptions))
              .setIfSourceGenerationNotMatch(
                  Option.IF_SOURCE_GENERATION_NOT_MATCH.getLong(req.sourceOptions))
              .setIfMetagenerationMatch(Option.IF_METAGENERATION_MATCH.getLong(req.targetOptions))
              .setIfMetagenerationNotMatch(
                  Option.IF_METAGENERATION_NOT_MATCH.getLong(req.targetOptions))
              .setIfGenerationMatch(Option.IF_GENERATION_MATCH.getLong(req.targetOptions))
              .setIfGenerationNotMatch(Option.IF_GENERATION_NOT_MATCH.getLong(req.targetOptions))
              .setDestinationPredefinedAcl(Option.PREDEFINED_ACL.getString(req.targetOptions))
              .setUserProject(userProject)
              .setDestinationKmsKeyName(Option.KMS_KEY_NAME.getString(req.targetOptions));
      rewrite.setDisableGZipContent(content == null);
      HttpHeaders requestHeaders = rewrite.getRequestHeaders();
      setEncryptionHeaders(requestHeaders, SOURCE_ENCRYPTION_KEY_PREFIX, req.sourceOptions);
      setEncryptionHeaders(requestHeaders, ENCRYPTION_KEY_PREFIX, req.targetOptions);
      setExtraHeaders(rewrite, req.sourceOptions);
      setExtraHeaders(rewrite, req.targetOptions);
      com.google.api.services.storage.model.RewriteResponse rewriteResponse = rewrite.execute();
      return new RewriteResponse(
          req,
          rewriteResponse.getResource(),
          rewriteResponse.getObjectSize().longValue(),
          rewriteResponse.getDone(),
          rewriteResponse.getRewriteToken(),
          rewriteResponse.getTotalBytesRewritten().longValue());
    } catch (IOException ex) {
      tracer.getCurrentSpan().setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    }
  }

  @Override
  public BucketAccessControl getAcl(String bucket, String entity, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_BUCKET_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      BucketAccessControls.Get get =
          storage
              .bucketAccessControls()
              .get(bucket, entity)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(get, options);
      return get.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public boolean deleteAcl(String bucket, String entity, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_BUCKET_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      BucketAccessControls.Delete delete =
          storage
              .bucketAccessControls()
              .delete(bucket, entity)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(delete, options);
      delete.execute();
      return true;
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public BucketAccessControl createAcl(BucketAccessControl acl, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_BUCKET_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      BucketAccessControls.Insert insert =
          storage
              .bucketAccessControls()
              .insert(acl.getBucket(), acl)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(insert, options);
      return insert.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public BucketAccessControl patchAcl(BucketAccessControl acl, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_BUCKET_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      BucketAccessControls.Patch patch =
          storage
              .bucketAccessControls()
              .patch(acl.getBucket(), acl.getEntity(), acl)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(patch, options);
      return patch.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public List<BucketAccessControl> listAcls(String bucket, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_BUCKET_ACLS);
    Scope scope = tracer.withSpan(span);
    try {
      BucketAccessControls.List list =
          storage
              .bucketAccessControls()
              .list(bucket)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(list, options);
      return list.execute().getItems();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public ObjectAccessControl getDefaultAcl(String bucket, String entity) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_OBJECT_DEFAULT_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      DefaultObjectAccessControls.Get get =
          storage.defaultObjectAccessControls().get(bucket, entity);
      return get.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public boolean deleteDefaultAcl(String bucket, String entity) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_OBJECT_DEFAULT_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      DefaultObjectAccessControls.Delete delete =
          storage.defaultObjectAccessControls().delete(bucket, entity);
      delete.execute();
      return true;
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public ObjectAccessControl createDefaultAcl(ObjectAccessControl acl) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_OBJECT_DEFAULT_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      DefaultObjectAccessControls.Insert insert =
          storage.defaultObjectAccessControls().insert(acl.getBucket(), acl);
      return insert.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public ObjectAccessControl patchDefaultAcl(ObjectAccessControl acl) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_OBJECT_DEFAULT_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      DefaultObjectAccessControls.Patch patch =
          storage.defaultObjectAccessControls().patch(acl.getBucket(), acl.getEntity(), acl);
      return patch.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public List<ObjectAccessControl> listDefaultAcls(String bucket) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_OBJECT_DEFAULT_ACLS);
    Scope scope = tracer.withSpan(span);
    try {
      DefaultObjectAccessControls.List list = storage.defaultObjectAccessControls().list(bucket);
      return list.execute().getItems();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public ObjectAccessControl getAcl(String bucket, String object, Long generation, String entity) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_OBJECT_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      ObjectAccessControls.Get get =
          storage.objectAccessControls().get(bucket, object, entity).setGeneration(generation);
      return get.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public boolean deleteAcl(String bucket, String object, Long generation, String entity) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_OBJECT_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      ObjectAccessControls.Delete delete =
          storage.objectAccessControls().delete(bucket, object, entity).setGeneration(generation);
      delete.execute();
      return true;
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public ObjectAccessControl createAcl(ObjectAccessControl acl) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_OBJECT_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      ObjectAccessControls.Insert insert =
          storage
              .objectAccessControls()
              .insert(acl.getBucket(), acl.getObject(), acl)
              .setGeneration(acl.getGeneration());
      return insert.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public ObjectAccessControl patchAcl(ObjectAccessControl acl) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_OBJECT_ACL);
    Scope scope = tracer.withSpan(span);
    try {
      ObjectAccessControls.Patch patch =
          storage
              .objectAccessControls()
              .patch(acl.getBucket(), acl.getObject(), acl.getEntity(), acl)
              .setGeneration(acl.getGeneration());
      return patch.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public List<ObjectAccessControl> listAcls(String bucket, String object, Long generation) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_OBJECT_ACLS);
    Scope scope = tracer.withSpan(span);
    try {
      ObjectAccessControls.List list =
          storage.objectAccessControls().list(bucket, object).setGeneration(generation);
      return list.execute().getItems();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public HmacKey createHmacKey(String serviceAccountEmail, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_HMAC_KEY);
    Scope scope = tracer.withSpan(span);
    String projectId = Option.PROJECT_ID.getString(options);
    if (projectId == null) {
      projectId = this.options.getProjectId();
    }
    try {
      Create create =
          storage
              .projects()
              .hmacKeys()
              .create(projectId, serviceAccountEmail)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(create, options);
      return create.setDisableGZipContent(true).execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Tuple<String, Iterable<HmacKeyMetadata>> listHmacKeys(Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_HMAC_KEYS);
    Scope scope = tracer.withSpan(span);
    String projectId = Option.PROJECT_ID.getString(options);
    if (projectId == null) {
      projectId = this.options.getProjectId();
    }
    try {
      HmacKeys.List list =
          storage
              .projects()
              .hmacKeys()
              .list(projectId)
              .setServiceAccountEmail(Option.SERVICE_ACCOUNT_EMAIL.getString(options))
              .setPageToken(Option.PAGE_TOKEN.getString(options))
              .setMaxResults(Option.MAX_RESULTS.getLong(options))
              .setShowDeletedKeys(Option.SHOW_DELETED_KEYS.getBoolean(options))
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(list, options);
      HmacKeysMetadata hmacKeysMetadata = list.execute();
      return Tuple.<String, Iterable<HmacKeyMetadata>>of(
          hmacKeysMetadata.getNextPageToken(), hmacKeysMetadata.getItems());
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public HmacKeyMetadata getHmacKey(String accessId, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_HMAC_KEY);
    Scope scope = tracer.withSpan(span);
    String projectId = Option.PROJECT_ID.getString(options);
    if (projectId == null) {
      projectId = this.options.getProjectId();
    }
    try {
      HmacKeys.Get get =
          storage
              .projects()
              .hmacKeys()
              .get(projectId, accessId)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(get, options);
      return get.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public HmacKeyMetadata updateHmacKey(HmacKeyMetadata hmacKeyMetadata, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_UPDATE_HMAC_KEY);
    Scope scope = tracer.withSpan(span);
    String projectId = hmacKeyMetadata.getProjectId();
    if (projectId == null) {
      projectId = this.options.getProjectId();
    }
    try {
      Update update =
          storage
              .projects()
              .hmacKeys()
              .update(projectId, hmacKeyMetadata.getAccessId(), hmacKeyMetadata)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(update, options);
      return update.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public void deleteHmacKey(HmacKeyMetadata hmacKeyMetadata, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_HMAC_KEY);
    Scope scope = tracer.withSpan(span);
    String projectId = hmacKeyMetadata.getProjectId();
    if (projectId == null) {
      projectId = this.options.getProjectId();
    }
    try {
      HmacKeys.Delete delete =
          storage
              .projects()
              .hmacKeys()
              .delete(projectId, hmacKeyMetadata.getAccessId())
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(delete, options);
      delete.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Policy getIamPolicy(String bucket, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_BUCKET_IAM_POLICY);
    Scope scope = tracer.withSpan(span);
    try {
      Storage.Buckets.GetIamPolicy getIamPolicy =
          storage
              .buckets()
              .getIamPolicy(bucket)
              .setUserProject(Option.USER_PROJECT.getString(options));
      if (null != Option.REQUESTED_POLICY_VERSION.getLong(options)) {
        getIamPolicy.setOptionsRequestedPolicyVersion(
            Option.REQUESTED_POLICY_VERSION.getLong(options).intValue());
      }
      setExtraHeaders(getIamPolicy, options);
      return getIamPolicy.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Policy setIamPolicy(String bucket, Policy policy, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_SET_BUCKET_IAM_POLICY);
    Scope scope = tracer.withSpan(span);
    try {
      SetIamPolicy setIamPolicy =
          storage
              .buckets()
              .setIamPolicy(bucket, policy)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(setIamPolicy, options);
      return setIamPolicy.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public TestIamPermissionsResponse testIamPermissions(
      String bucket, List<String> permissions, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_TEST_BUCKET_IAM_PERMISSIONS);
    Scope scope = tracer.withSpan(span);
    try {
      TestIamPermissions testIamPermissions =
          storage
              .buckets()
              .testIamPermissions(bucket, permissions)
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(testIamPermissions, options);
      return testIamPermissions.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public boolean deleteNotification(String bucket, String notification) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_NOTIFICATION);
    Scope scope = tracer.withSpan(span);
    try {
      Notifications.Delete delete = storage.notifications().delete(bucket, notification);
      delete.execute();
      return true;
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return false;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public List<Notification> listNotifications(String bucket) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_NOTIFICATIONS);
    Scope scope = tracer.withSpan(span);
    try {
      Notifications.List list = storage.notifications().list(bucket);
      return list.execute().getItems();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Notification createNotification(String bucket, Notification notification) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_NOTIFICATION);
    Scope scope = tracer.withSpan(span);
    try {
      Notifications.Insert insert = storage.notifications().insert(bucket, notification);
      return insert.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public Notification getNotification(String bucket, String notification) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_NOTIFICATION);
    Scope scope = tracer.withSpan(span);
    try {
      Notifications.Get get = storage.notifications().get(bucket, notification);
      return get.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      StorageException serviceException = translate(ex);
      if (serviceException.getCode() == HTTP_NOT_FOUND) {
        return null;
      }
      throw serviceException;
    } finally {
      scope.close();
      span.end();
    }
  }

  @Override
  public Bucket lockRetentionPolicy(Bucket bucket, Map<Option, ?> options) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_LOCK_RETENTION_POLICY);
    Scope scope = tracer.withSpan(span);
    try {
      LockRetentionPolicy lockRetentionPolicy =
          storage
              .buckets()
              .lockRetentionPolicy(
                  bucket.getName(), Option.IF_METAGENERATION_MATCH.getLong(options))
              .setUserProject(Option.USER_PROJECT.getString(options));
      setExtraHeaders(lockRetentionPolicy, options);
      return lockRetentionPolicy.setDisableGZipContent(true).execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  @Override
  public ServiceAccount getServiceAccount(String projectId) {
    Span span = startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_SERVICE_ACCOUNT);
    Scope scope = tracer.withSpan(span);
    try {
      Projects.ServiceAccount.Get get = storage.projects().serviceAccount().get(projectId);
      return get.execute();
    } catch (IOException ex) {
      span.setStatus(Status.UNKNOWN.withDescription(ex.getMessage()));
      throw translate(ex);
    } finally {
      scope.close();
      span.end(HttpStorageRpcSpans.END_SPAN_OPTIONS);
    }
  }

  private static StorageException buildStorageException(int statusCode, String statusMessage) {
    GoogleJsonError error = new GoogleJsonError();
    error.setCode(statusCode);
    error.setMessage(statusMessage);
    return translate(error);
  }

  private static <Resource, Request extends StorageRequest<Resource>> void setExtraHeaders(
      Request req, Map<Option, ?> options) {
    ImmutableMap<String, String> extraHeaders = Option.EXTRA_HEADERS.get(options);
    HttpHeaders headers = req.getRequestHeaders();
    setExtraHeaders(extraHeaders, headers);
  }

  private static void setExtraHeaders(
      @Nullable ImmutableMap<String, String> extraHeaders, HttpHeaders headers) {
    if (extraHeaders != null) {
      for (Entry<String, String> e : extraHeaders.entrySet()) {
        String key = e.getKey();
        if (!headers.containsKey(key) || key.equals("authorization")) {
          headers.set(key, e.getValue());
        }
      }
    }
  }
}

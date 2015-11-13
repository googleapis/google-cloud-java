/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gcloud.spi;

import static com.google.gcloud.spi.StorageRpc.Option.DELIMITER;
import static com.google.gcloud.spi.StorageRpc.Option.FIELDS;
import static com.google.gcloud.spi.StorageRpc.Option.IF_GENERATION_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_GENERATION_NOT_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_METAGENERATION_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_METAGENERATION_NOT_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_SOURCE_GENERATION_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_SOURCE_GENERATION_NOT_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_SOURCE_METAGENERATION_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.IF_SOURCE_METAGENERATION_NOT_MATCH;
import static com.google.gcloud.spi.StorageRpc.Option.MAX_RESULTS;
import static com.google.gcloud.spi.StorageRpc.Option.PAGE_TOKEN;
import static com.google.gcloud.spi.StorageRpc.Option.PREDEFINED_ACL;
import static com.google.gcloud.spi.StorageRpc.Option.PREDEFINED_DEFAULT_OBJECT_ACL;
import static com.google.gcloud.spi.StorageRpc.Option.PREFIX;
import static com.google.gcloud.spi.StorageRpc.Option.VERSIONS;

import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
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
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.Storage.Objects.Get;
import com.google.api.services.storage.Storage.Objects.Insert;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.Buckets;
import com.google.api.services.storage.model.ComposeRequest;
import com.google.api.services.storage.model.ComposeRequest.SourceObjects.ObjectPreconditions;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.gcloud.storage.StorageException;
import com.google.gcloud.storage.StorageOptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultStorageRpc implements StorageRpc {

  public static final String DEFAULT_PROJECTION = "full";
  private final StorageOptions options;
  private final Storage storage;

  // see: https://cloud.google.com/storage/docs/concepts-techniques#practices
  private static final Set<Integer> RETRYABLE_CODES = ImmutableSet.of(504, 503, 502, 500, 429, 408);
  private static final long MEGABYTE = 1024L * 1024L;

  public DefaultStorageRpc(StorageOptions options) {
    HttpTransport transport = options.httpTransportFactory().create();
    HttpRequestInitializer initializer = options.httpRequestInitializer();
    this.options = options;
    storage = new Storage.Builder(transport, new JacksonFactory(), initializer)
        .setRootUrl(options.host())
        .setApplicationName(options.applicationName())
        .build();
  }

  private static StorageException translate(IOException exception) {
    StorageException translated;
    if (exception instanceof GoogleJsonResponseException) {
      translated = translate(((GoogleJsonResponseException) exception).getDetails());
    } else {
      translated = new StorageException(0, exception.getMessage(), false);
    }
    translated.initCause(exception);
    return translated;
  }

  private static StorageException translate(GoogleJsonError exception) {
    boolean retryable = RETRYABLE_CODES.contains(exception.getCode())
        || "InternalError".equals(exception.getMessage());
    return new StorageException(exception.getCode(), exception.getMessage(), retryable);
  }

  @Override
  public Bucket create(Bucket bucket, Map<Option, ?> options) throws StorageException {
    try {
      return storage.buckets()
          .insert(this.options.projectId(), bucket)
          .setProjection(DEFAULT_PROJECTION)
          .setPredefinedAcl(PREDEFINED_ACL.getString(options))
          .setPredefinedDefaultObjectAcl(PREDEFINED_DEFAULT_OBJECT_ACL.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public StorageObject create(StorageObject storageObject, final InputStream content,
      Map<Option, ?> options) throws StorageException {
    try {
      Storage.Objects.Insert insert = storage.objects()
          .insert(storageObject.getBucket(), storageObject,
              new InputStreamContent(storageObject.getContentType(), content));
      insert.getMediaHttpUploader().setDirectUploadEnabled(true);
      return insert.setProjection(DEFAULT_PROJECTION)
          .setPredefinedAcl(PREDEFINED_ACL.getString(options))
          .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setIfGenerationMatch(IF_GENERATION_MATCH.getLong(options))
          .setIfGenerationNotMatch(IF_GENERATION_NOT_MATCH.getLong(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<Bucket>> list(Map<Option, ?> options) {
    try {
      Buckets buckets = storage.buckets()
          .list(this.options.projectId())
          .setProjection(DEFAULT_PROJECTION)
          .setPrefix(PREFIX.getString(options))
          .setMaxResults(MAX_RESULTS.getLong(options))
          .setPageToken(PAGE_TOKEN.getString(options))
          .setFields(FIELDS.getString(options))
          .execute();
      return Tuple.<String, Iterable<Bucket>>of(buckets.getNextPageToken(), buckets.getItems());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Tuple<String, Iterable<StorageObject>> list(String bucket, Map<Option, ?> options) {
    try {
      Objects objects = storage.objects()
          .list(bucket)
          .setProjection(DEFAULT_PROJECTION)
          .setVersions(VERSIONS.getBoolean(options))
          .setDelimiter(DELIMITER.getString(options))
          .setPrefix(PREFIX.getString(options))
          .setMaxResults(MAX_RESULTS.getLong(options))
          .setPageToken(PAGE_TOKEN.getString(options))
          .setFields(FIELDS.getString(options))
          .execute();
      return Tuple.<String, Iterable<StorageObject>>of(
          objects.getNextPageToken(), objects.getItems());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public Bucket get(Bucket bucket, Map<Option, ?> options) {
    try {
      return storage.buckets()
          .get(bucket.getName())
          .setProjection(DEFAULT_PROJECTION)
          .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setFields(FIELDS.getString(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public StorageObject get(StorageObject object, Map<Option, ?> options) {
    try {
      return getRequest(object, options).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private Storage.Objects.Get getRequest(StorageObject object, Map<Option, ?> options)
      throws IOException {
    return storage.objects()
        .get(object.getBucket(), object.getName())
        .setGeneration(object.getGeneration())
        .setProjection(DEFAULT_PROJECTION)
        .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
        .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
        .setIfGenerationMatch(IF_GENERATION_MATCH.getLong(options))
        .setIfGenerationNotMatch(IF_GENERATION_NOT_MATCH.getLong(options))
        .setFields(FIELDS.getString(options));
  }

  @Override
  public Bucket patch(Bucket bucket, Map<Option, ?> options) {
    try {
      return storage.buckets()
          .patch(bucket.getName(), bucket)
          .setProjection(DEFAULT_PROJECTION)
          .setPredefinedAcl(PREDEFINED_ACL.getString(options))
          .setPredefinedDefaultObjectAcl(PREDEFINED_DEFAULT_OBJECT_ACL.getString(options))
          .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public StorageObject patch(StorageObject storageObject, Map<Option, ?> options) {
    try {
      return patchRequest(storageObject, options).execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  private Storage.Objects.Patch patchRequest(StorageObject storageObject, Map<Option, ?> options)
      throws IOException {
    return storage.objects()
        .patch(storageObject.getBucket(), storageObject.getName(), storageObject)
        .setProjection(DEFAULT_PROJECTION)
        .setPredefinedAcl(PREDEFINED_ACL.getString(options))
        .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
        .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
        .setIfGenerationMatch(IF_GENERATION_MATCH.getLong(options))
        .setIfGenerationNotMatch(IF_GENERATION_NOT_MATCH.getLong(options));
  }

  @Override
  public boolean delete(Bucket bucket, Map<Option, ?> options) {
    try {
      storage.buckets()
          .delete(bucket.getName())
          .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
          .execute();
      return true;
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.code() == 404) {
        return false;
      }
      throw serviceException;
    }
  }

  @Override
  public boolean delete(StorageObject blob, Map<Option, ?> options) {
    try {
      deleteRequest(blob, options).execute();
      return true;
    } catch (IOException ex) {
      StorageException serviceException = translate(ex);
      if (serviceException.code() == 404) {
        return false;
      }
      throw serviceException;
    }
  }

  private Storage.Objects.Delete deleteRequest(StorageObject blob, Map<Option, ?> options)
      throws IOException {
    return storage.objects()
        .delete(blob.getBucket(), blob.getName())
        .setGeneration(blob.getGeneration())
        .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
        .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
        .setIfGenerationMatch(IF_GENERATION_MATCH.getLong(options))
        .setIfGenerationNotMatch(IF_GENERATION_NOT_MATCH.getLong(options));
  }

  @Override
  public StorageObject compose(Iterable<StorageObject> sources, StorageObject target,
      Map<Option, ?> targetOptions) throws StorageException {
    ComposeRequest request = new ComposeRequest();
    if (target.getContentType() == null) {
      target.setContentType("application/octet-stream");
    }
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
          .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(targetOptions))
          .setIfGenerationMatch(IF_GENERATION_MATCH.getLong(targetOptions))
          .execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public byte[] load(StorageObject from, Map<Option, ?> options)
      throws StorageException {
    try {
      Storage.Objects.Get getRequest = storage.objects()
          .get(from.getBucket(), from.getName())
          .setGeneration(from.getGeneration())
          .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setIfGenerationMatch(IF_GENERATION_MATCH.getLong(options))
          .setIfGenerationNotMatch(IF_GENERATION_NOT_MATCH.getLong(options));
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      getRequest.getMediaHttpDownloader().setDirectDownloadEnabled(true);
      getRequest.executeMediaAndDownloadTo(out);
      return out.toByteArray();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BatchResponse batch(BatchRequest request) throws StorageException {
    com.google.api.client.googleapis.batch.BatchRequest batch = storage.batch();
    final Map<StorageObject, Tuple<Boolean, StorageException>> deletes =
        Maps.newConcurrentMap();
    final Map<StorageObject, Tuple<StorageObject, StorageException>> updates =
        Maps.newConcurrentMap();
    final Map<StorageObject, Tuple<StorageObject, StorageException>> gets =
        Maps.newConcurrentMap();
    try {
      for (final Tuple<StorageObject, Map<Option, ?>> tuple : request.toDelete) {
        deleteRequest(tuple.x(), tuple.y()).queue(batch, new JsonBatchCallback<Void>() {
          @Override
          public void onSuccess(Void ignore, HttpHeaders responseHeaders) {
            deletes.put(tuple.x(), Tuple.<Boolean, StorageException>of(Boolean.TRUE, null));
          }

          @Override
          public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) {
            deletes.put(tuple.x(), Tuple.<Boolean, StorageException>of(null, translate(e)));
          }
        });
      }
      for (final Tuple<StorageObject, Map<Option, ?>> tuple : request.toUpdate) {
        patchRequest(tuple.x(), tuple.y()).queue(batch, new JsonBatchCallback<StorageObject>() {
          @Override
          public void onSuccess(StorageObject storageObject, HttpHeaders responseHeaders) {
            updates.put(tuple.x(),
                Tuple.<StorageObject, StorageException>of(storageObject, null));
          }

          @Override
          public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) {
            updates.put(tuple.x(),
                Tuple.<StorageObject, StorageException>of(null, translate(e)));
          }
        });
      }
      for (final Tuple<StorageObject, Map<Option, ?>> tuple : request.toGet) {
        getRequest(tuple.x(), tuple.y()).queue(batch, new JsonBatchCallback<StorageObject>() {
          @Override
          public void onSuccess(StorageObject storageObject, HttpHeaders responseHeaders) {
            gets.put(tuple.x(),
                Tuple.<StorageObject, StorageException>of(storageObject, null));
          }

          @Override
          public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) {
            gets.put(tuple.x(),
                Tuple.<StorageObject, StorageException>of(null, translate(e)));
          }
        });
      }
      batch.execute();
    } catch (IOException ex) {
      throw translate(ex);
    }
    return new BatchResponse(deletes, updates, gets);
  }

  @Override
  public byte[] read(StorageObject from, Map<Option, ?> options, long position, int bytes)
      throws StorageException {
    try {
      Get req = storage.objects()
          .get(from.getBucket(), from.getName())
          .setGeneration(from.getGeneration())
          .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(options))
          .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(options))
          .setIfGenerationMatch(IF_GENERATION_MATCH.getLong(options))
          .setIfGenerationNotMatch(IF_GENERATION_NOT_MATCH.getLong(options));
      MediaHttpDownloader downloader = req.getMediaHttpDownloader();
      downloader.setContentRange(position, (int) position + bytes);
      downloader.setDirectDownloadEnabled(true);
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      req.executeMediaAndDownloadTo(output);
      return output.toByteArray();
    } catch (IOException ex) {
      throw translate(ex);
    }
  }

  @Override
  public void write(String uploadId, byte[] toWrite, int toWriteOffset, StorageObject dest,
      long destOffset, int length, boolean last) throws StorageException {
    try {
      GenericUrl url = new GenericUrl(uploadId);
      HttpRequest httpRequest = storage.getRequestFactory().buildPutRequest(url,
          new ByteArrayContent(null, toWrite, toWriteOffset, length));
      long limit = destOffset + length;
      StringBuilder range = new StringBuilder("bytes ");
      range.append(destOffset).append('-').append(limit - 1).append('/');
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
  public String open(StorageObject object, Map<Option, ?> options)
      throws StorageException {
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
      httpRequest.getHeaders().set("X-Upload-Content-Type",
          MoreObjects.firstNonNull(object.getContentType(), "application/octet-stream"));
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
  public RewriteResponse openRewrite(RewriteRequest rewriteRequest) throws StorageException {
    return rewrite(rewriteRequest, null);
  }

  @Override
  public RewriteResponse continueRewrite(RewriteResponse previousResponse) throws StorageException {
    return rewrite(previousResponse.rewriteRequest, previousResponse.rewriteToken);
  }

  private RewriteResponse rewrite(RewriteRequest req, String token) throws StorageException {
    try {
      Long maxBytesRewrittenPerCall = req.megabytesRewrittenPerCall != null
          ? req.megabytesRewrittenPerCall * MEGABYTE : null;
      com.google.api.services.storage.model.RewriteResponse rewriteReponse = storage.objects()
          .rewrite(req.source.getBucket(), req.source.getName(), req.target.getBucket(),
              req.target.getName(), req.target.getContentType() != null ? req.target : null)
          .setSourceGeneration(req.source.getGeneration())
          .setRewriteToken(token)
          .setMaxBytesRewrittenPerCall(maxBytesRewrittenPerCall)
          .setProjection(DEFAULT_PROJECTION)
          .setIfSourceMetagenerationMatch(IF_SOURCE_METAGENERATION_MATCH.getLong(req.sourceOptions))
          .setIfSourceMetagenerationNotMatch(
              IF_SOURCE_METAGENERATION_NOT_MATCH.getLong(req.sourceOptions))
          .setIfSourceGenerationMatch(IF_SOURCE_GENERATION_MATCH.getLong(req.sourceOptions))
          .setIfSourceGenerationNotMatch(IF_SOURCE_GENERATION_NOT_MATCH.getLong(req.sourceOptions))
          .setIfMetagenerationMatch(IF_METAGENERATION_MATCH.getLong(req.targetOptions))
          .setIfMetagenerationNotMatch(IF_METAGENERATION_NOT_MATCH.getLong(req.targetOptions))
          .setIfGenerationMatch(IF_GENERATION_MATCH.getLong(req.targetOptions))
          .setIfGenerationNotMatch(IF_GENERATION_NOT_MATCH.getLong(req.targetOptions))
          .execute();
      return new RewriteResponse(
          req,
          rewriteReponse.getResource(),
          rewriteReponse.getObjectSize().longValue(),
          rewriteReponse.getDone(),
          rewriteReponse.getRewriteToken(),
          rewriteReponse.getTotalBytesRewritten().longValue());
    } catch (IOException ex) {
      throw translate(ex);
    }
  }
}

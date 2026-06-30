/*
 * Copyright 2025 Google LLC
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

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.util.ObjectParser;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.services.storage.Storage;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.multipartupload.model.AbortMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.AbortMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsRequest;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsResponse;
import com.google.cloud.storage.multipartupload.model.ListPartsRequest;
import com.google.cloud.storage.multipartupload.model.ListPartsResponse;
import com.google.cloud.storage.multipartupload.model.UploadPartRequest;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.Nullable;

final class MultipartUploadHttpRequestManager {

  private final HttpRequestFactory requestFactory;
  private final ObjectParser objectParser;
  private final HeaderProvider headerProvider;
  private final URI uri;

  MultipartUploadHttpRequestManager(
      HttpRequestFactory requestFactory,
      ObjectParser objectParser,
      HeaderProvider headerProvider,
      URI uri) {
    this.requestFactory = requestFactory;
    this.objectParser = objectParser;
    this.headerProvider = headerProvider;
    this.uri = uri;
  }

  CreateMultipartUploadResponse sendCreateMultipartUploadRequest(
      CreateMultipartUploadRequest request) throws IOException {

    String createUri =
        UriTemplate.expand(
            uri.toString(),
            "{bucket}/{key}?uploads",
            ImmutableMap.of("bucket", request.bucket(), "key", request.key()),
            false);

    HttpRequest httpRequest =
        requestFactory.buildPostRequest(
            new GenericUrl(createUri), new ByteArrayContent(null, new byte[0]));
    httpRequest.getHeaders().putAll(headerProvider.getHeaders());
    addHeadersForCreateMultipartUpload(request, httpRequest.getHeaders());
    httpRequest.setParser(objectParser);
    httpRequest.setThrowExceptionOnExecuteError(true);
    return httpRequest.execute().parseAs(CreateMultipartUploadResponse.class);
  }

  ListPartsResponse sendListPartsRequest(ListPartsRequest request) throws IOException {

    ImmutableMap.Builder<String, Object> params =
        ImmutableMap.<String, Object>builder()
            .put("bucket", request.bucket())
            .put("key", request.key())
            .put("uploadId", request.uploadId());
    if (request.maxParts() != null) {
      params.put("max-parts", request.maxParts());
    }
    if (request.partNumberMarker() != null) {
      params.put("part-number-marker", request.partNumberMarker());
    }

    String listUri =
        UriTemplate.expand(
            uri.toString(),
            "{bucket}/{key}{?uploadId,max-parts,part-number-marker}",
            params.build(),
            false);
    HttpRequest httpRequest = requestFactory.buildGetRequest(new GenericUrl(listUri));
    httpRequest.getHeaders().putAll(headerProvider.getHeaders());
    if (request.userProject() != null) {
      httpRequest.getHeaders().put("x-goog-user-project", request.userProject());
    }
    httpRequest.setParser(objectParser);
    httpRequest.setThrowExceptionOnExecuteError(true);
    return httpRequest.execute().parseAs(ListPartsResponse.class);
  }

  ListMultipartUploadsResponse sendListMultipartUploadsRequest(ListMultipartUploadsRequest request)
      throws IOException {

    ImmutableMap.Builder<String, Object> params =
        ImmutableMap.<String, Object>builder().put("bucket", request.bucket());
    if (request.delimiter() != null) {
      params.put("delimiter", request.delimiter());
    }
    if (request.encodingType() != null) {
      params.put("encoding-type", request.encodingType());
    }
    if (request.keyMarker() != null) {
      params.put("key-marker", request.keyMarker());
    }
    if (request.maxUploads() != null) {
      params.put("max-uploads", request.maxUploads());
    }
    if (request.prefix() != null) {
      params.put("prefix", request.prefix());
    }
    if (request.uploadIdMarker() != null) {
      params.put("upload-id-marker", request.uploadIdMarker());
    }
    String listUri =
        UriTemplate.expand(
            uri.toString()
                + "{bucket}?uploads{&delimiter,encoding-type,key-marker,max-uploads,prefix,upload-id-marker}",
            params.build(),
            false);
    HttpRequest httpRequest = requestFactory.buildGetRequest(new GenericUrl(listUri));
    httpRequest.getHeaders().putAll(headerProvider.getHeaders());
    if (request.userProject() != null) {
      httpRequest.getHeaders().put("x-goog-user-project", request.userProject());
    }
    httpRequest.setParser(objectParser);
    httpRequest.setThrowExceptionOnExecuteError(true);
    return httpRequest.execute().parseAs(ListMultipartUploadsResponse.class);
  }

  AbortMultipartUploadResponse sendAbortMultipartUploadRequest(AbortMultipartUploadRequest request)
      throws IOException {

    String abortUri =
        UriTemplate.expand(
            uri.toString(),
            "{bucket}/{key}{?uploadId}",
            ImmutableMap.of(
                "bucket", request.bucket(), "key", request.key(), "uploadId", request.uploadId()),
            false);

    HttpRequest httpRequest = requestFactory.buildDeleteRequest(new GenericUrl(abortUri));
    httpRequest.getHeaders().putAll(headerProvider.getHeaders());
    if (request.userProject() != null) {
      httpRequest.getHeaders().put("x-goog-user-project", request.userProject());
    }
    httpRequest.setParser(objectParser);
    httpRequest.setThrowExceptionOnExecuteError(true);
    return httpRequest.execute().parseAs(AbortMultipartUploadResponse.class);
  }

  CompleteMultipartUploadResponse sendCompleteMultipartUploadRequest(
      CompleteMultipartUploadRequest request) throws IOException {
    String completeUri =
        UriTemplate.expand(
            uri.toString() + "{bucket}/{key}{?uploadId}",
            ImmutableMap.of(
                "bucket", request.bucket(), "key", request.key(), "uploadId", request.uploadId()),
            false);
    byte[] bytes = new XmlMapper().writeValueAsBytes(request.multipartUpload());
    HttpRequest httpRequest =
        requestFactory.buildPostRequest(
            new GenericUrl(completeUri), new ByteArrayContent("application/xml", bytes));
    httpRequest.getHeaders().putAll(headerProvider.getHeaders());
    if (request.userProject() != null) {
      httpRequest.getHeaders().put("x-goog-user-project", request.userProject());
    }
    @Nullable Crc32cLengthKnown crc32cValue = Hasher.defaultHasher().hash(ByteBuffer.wrap(bytes));
    addChecksumHeader(crc32cValue, httpRequest.getHeaders());
    httpRequest.setParser(objectParser);
    httpRequest.setThrowExceptionOnExecuteError(true);
    return ChecksumResponseParser.parseCompleteResponse(httpRequest.execute());
  }

  UploadPartResponse sendUploadPartRequest(
      UploadPartRequest request, RewindableContent rewindableContent) throws IOException {
    String uploadUri =
        UriTemplate.expand(
            uri.toString() + "{bucket}/{key}{?partNumber,uploadId}",
            ImmutableMap.of(
                "bucket",
                request.bucket(),
                "key",
                request.key(),
                "partNumber",
                request.partNumber(),
                "uploadId",
                request.uploadId()),
            false);
    HttpRequest httpRequest =
        requestFactory.buildPutRequest(new GenericUrl(uploadUri), rewindableContent);
    httpRequest.getHeaders().putAll(headerProvider.getHeaders());
    if (request.userProject() != null) {
      httpRequest.getHeaders().put("x-goog-user-project", request.userProject());
    }
    if (request.crc32c() != null) {
      addChecksumHeader(request.crc32c(), httpRequest.getHeaders());
    } else {
      addChecksumHeader(rewindableContent.getCrc32c(), httpRequest.getHeaders());
    }
    httpRequest.setThrowExceptionOnExecuteError(true);
    return ChecksumResponseParser.parseUploadResponse(httpRequest.execute());
  }

  @SuppressWarnings("DataFlowIssue")
  static MultipartUploadHttpRequestManager createFrom(HttpStorageOptions options) {
    Storage storage = options.getStorageRpcV1().getStorage();
    ImmutableMap.Builder<String, String> stableHeaders = ImmutableMap.<String, String>builder();
    // http-java-client will automatically add its value the user-agent
    if (!options
        .getMergedHeaderProvider(FixedHeaderProvider.create(ImmutableMap.of()))
        .getHeaders()
        .containsKey("User-Agent")) {
      stableHeaders.put("User-Agent", "gcloud-java/" + options.getLibraryVersion());
    }
    stableHeaders.put(
        "x-goog-api-client",
        String.format(
            "gl-java/%s gccl/%s %s/%s",
            GaxProperties.getJavaVersion(),
            options.getLibraryVersion(),
            formatName(StandardSystemProperty.OS_NAME.value()),
            formatSemver(StandardSystemProperty.OS_VERSION.value())));
    return new MultipartUploadHttpRequestManager(
        storage.getRequestFactory(),
        new XmlObjectParser(new XmlMapper()),
        options.getMergedHeaderProvider(FixedHeaderProvider.create(stableHeaders.build())),
        URI.create(ensureTrailingSlash(options.getHost())));
  }

  private static String ensureTrailingSlash(String host) {
    return host.endsWith("/") ? host : host + "/";
  }

  private void addChecksumHeader(@Nullable Crc32cLengthKnown crc32c, HttpHeaders headers) {
    if (crc32c != null) {
      addChecksumHeader(Utils.crc32cCodec.encode(crc32c.getValue()), headers);
    }
  }

  private void addChecksumHeader(@Nullable String crc32c, HttpHeaders headers) {
    if (crc32c != null) {
      headers.put("x-goog-hash", "crc32c=" + crc32c);
    }
  }

  private void addHeadersForCreateMultipartUpload(
      CreateMultipartUploadRequest request, HttpHeaders headers) {
    if (request.cannedAcl() != null) {
      headers.put("x-goog-acl", request.cannedAcl().getXmlEntry());
    }
    if (request.metadata() != null) {
      for (Map.Entry<String, String> entry : request.metadata().entrySet()) {
        if (entry.getKey() != null || entry.getValue() != null) {
          headers.put("x-goog-meta-" + urlEncode(entry.getKey()), urlEncode(entry.getValue()));
        }
      }
    }
    if (request.contentType() != null) {
      headers.put("Content-Type", request.contentType());
    }
    if (request.contentDisposition() != null) {
      headers.put("Content-Disposition", request.contentDisposition());
    }
    if (request.contentEncoding() != null) {
      headers.put("Content-Encoding", request.contentEncoding());
    }
    if (request.contentLanguage() != null) {
      headers.put("Content-Language", request.contentLanguage());
    }
    if (request.cacheControl() != null) {
      headers.put("Cache-Control", request.cacheControl());
    }
    if (request.storageClass() != null) {
      headers.put("x-goog-storage-class", request.storageClass().toString());
    }
    if (request.kmsKeyName() != null && !request.kmsKeyName().isEmpty()) {
      headers.put("x-goog-encryption-kms-key-name", request.kmsKeyName());
    }
    if (request.objectLockMode() != null) {
      headers.put("x-goog-object-lock-mode", request.objectLockMode().toString());
    }
    if (request.objectLockRetainUntilDate() != null) {
      headers.put(
          "x-goog-object-lock-retain-until-date",
          Utils.offsetDateTimeRfc3339Codec.encode(request.objectLockRetainUntilDate()));
    }
    if (request.customTime() != null) {
      headers.put(
          "x-goog-custom-time", Utils.offsetDateTimeRfc3339Codec.encode(request.customTime()));
    }
    if (request.userProject() != null) {
      headers.put("x-goog-user-project", request.userProject());
    }
  }

  private static String urlEncode(String value) {
    try {
      return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new StorageException(0, "Unable to load UTF-8 charset for encoding", e);
    }
  }

  /**
   * copied from
   * com.google.api.client.googleapis.services.AbstractGoogleClientRequest.ApiClientVersion#formatName(java.lang.String)
   */
  private static String formatName(String name) {
    // Only lowercase letters, digits, and "-" are allowed
    return name.toLowerCase().replaceAll("[^\\w-]", "-");
  }

  private static String formatSemver(String version) {
    return formatSemver(version, version);
  }

  /**
   * copied from
   * com.google.api.client.googleapis.services.AbstractGoogleClientRequest.ApiClientVersion#formatSemver(java.lang.String,
   * java.lang.String)
   */
  private static String formatSemver(String version, String defaultValue) {
    if (version == null) {
      return null;
    }

    // Take only the semver version: x.y.z-a_b_c -> x.y.z
    Matcher m = Pattern.compile("(\\d+\\.\\d+\\.\\d+).*").matcher(version);
    if (m.find()) {
      return m.group(1);
    } else {
      return defaultValue;
    }
  }
}

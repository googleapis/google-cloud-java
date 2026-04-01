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

import static com.google.common.truth.Truth.assertThat;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.junit.Assert.assertThrows;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.api.client.http.HttpResponseException;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.cloud.storage.FakeHttpServer.HttpRequestHandler;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.multipartupload.model.AbortMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.AbortMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.CompletedMultipartUpload;
import com.google.cloud.storage.multipartupload.model.CompletedPart;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsRequest;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsResponse;
import com.google.cloud.storage.multipartupload.model.ListPartsRequest;
import com.google.cloud.storage.multipartupload.model.ListPartsResponse;
import com.google.cloud.storage.multipartupload.model.MultipartUpload;
import com.google.cloud.storage.multipartupload.model.ObjectLockMode;
import com.google.cloud.storage.multipartupload.model.Part;
import com.google.cloud.storage.multipartupload.model.UploadPartRequest;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.hash.Hashing;
import io.grpc.netty.shaded.io.netty.buffer.ByteBuf;
import io.grpc.netty.shaded.io.netty.buffer.Unpooled;
import io.grpc.netty.shaded.io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.FullHttpRequest;
import io.grpc.netty.shaded.io.netty.handler.codec.http.FullHttpResponse;
import io.grpc.netty.shaded.io.netty.handler.codec.http.HttpResponseStatus;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
@ParallelFriendly
public final class ITMultipartUploadHttpRequestManagerTest {
  private static final XmlMapper xmlMapper;

  static {
    xmlMapper = new XmlMapper();
    xmlMapper.registerModule(new JavaTimeModule());
    xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    SimpleModule module = new SimpleModule();
    module.addSerializer(
        StorageClass.class,
        new JsonSerializer<StorageClass>() {
          @Override
          public void serialize(
              StorageClass value, JsonGenerator gen, SerializerProvider serializers)
              throws java.io.IOException {
            gen.writeString(value.toString());
          }
        });
    xmlMapper.registerModule(module);
  }

  @Rule public final TemporaryFolder temp = new TemporaryFolder();

  @Test
  public void sendCreateMultipartUploadRequest_success() throws Exception {
    HttpRequestHandler handler =
        req -> {
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .build();

      CreateMultipartUploadResponse response =
          multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);

      assertThat(response).isNotNull();
      assertThat(response.bucket()).isEqualTo("test-bucket");
      assertThat(response.key()).isEqualTo("test-key");
      assertThat(response.uploadId()).isEqualTo("test-upload-id");
    }
  }

  @Test
  public void createFrom_withExistingUserAgent() throws Exception {
    HttpRequestHandler handler =
        req -> {
          boolean hasCustom =
              req.headers().getAll("User-Agent").stream()
                  .anyMatch(agent -> agent.contains("my-custom-agent"));
          assertThat(hasCustom).isTrue();
          // check that it does not also contain the gcloud-java generated header
          boolean hasDefault =
              req.headers().getAll("User-Agent").stream()
                  .anyMatch(agent -> agent.contains("gcloud-java/"));
          assertThat(hasDefault).isFalse();

          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      HttpStorageOptions options =
          fakeHttpServer.getHttpStorageOptions().toBuilder()
              .setHeaderProvider(
                  FixedHeaderProvider.create(ImmutableMap.of("User-Agent", "my-custom-agent")))
              .build();

      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(options);
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void createFrom_withoutExistingUserAgent() throws Exception {
    HttpRequestHandler handler =
        req -> {
          boolean hasDefault =
              req.headers().getAll("User-Agent").stream()
                  .anyMatch(agent -> agent.startsWith("gcloud-java/"));
          assertThat(hasDefault).isTrue();

          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_error() throws Exception {
    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), HttpResponseStatus.BAD_REQUEST);
          resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .build();

      assertThrows(
          HttpResponseException.class,
          () -> multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request));
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withCannedAcl() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-acl")).isEqualTo("authenticated-read");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .cannedAcl(Storage.PredefinedAcl.AUTHENTICATED_READ)
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withMetadata() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-meta-key1")).isEqualTo("value1");
          assertThat(req.headers().get("x-goog-meta-key2")).isEqualTo("value2");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .metadata(ImmutableMap.of("key1", "value1", "key2", "value2"))
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withStorageClass() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-storage-class")).isEqualTo("ARCHIVE");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .storageClass(StorageClass.ARCHIVE)
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withKmsKeyName() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-encryption-kms-key-name"))
              .isEqualTo("projects/p/locations/l/keyRings/r/cryptoKeys/k");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .kmsKeyName("projects/p/locations/l/keyRings/r/cryptoKeys/k")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withObjectLockMode() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-object-lock-mode")).isEqualTo("GOVERNANCE");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .objectLockMode(ObjectLockMode.GOVERNANCE)
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withObjectLockRetainUntilDate() throws Exception {
    OffsetDateTime retainUtil = OffsetDateTime.of(2024, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    HttpRequestHandler handler =
        req -> {
          OffsetDateTime actual =
              Utils.offsetDateTimeRfc3339Codec.decode(
                  req.headers().get("x-goog-object-lock-retain-until-date"));
          assertThat(actual).isEqualTo(retainUtil);
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .objectLockRetainUntilDate(retainUtil)
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withCustomTime() throws Exception {
    OffsetDateTime customTime = OffsetDateTime.of(2024, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    HttpRequestHandler handler =
        req -> {
          OffsetDateTime actual =
              Utils.offsetDateTimeRfc3339Codec.decode(req.headers().get("x-goog-custom-time"));
          assertThat(actual).isEqualTo(customTime);
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .customTime(customTime)
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withContentDisposition() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("Content-Disposition"))
              .isEqualTo("attachment; filename=\"test.txt\"");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .contentDisposition("attachment; filename=\"test.txt\"")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withContentEncoding() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("Content-Encoding")).isEqualTo("gzip");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .contentEncoding("gzip")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withContentLanguage() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("Content-Language")).isEqualTo("en");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .contentLanguage("en")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withCacheControl() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("Cache-Control"))
              .isEqualTo("no-cache, no-store, max-age=0, must-revalidate");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .cacheControl("no-cache, no-store, max-age=0, must-revalidate")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withUserProject() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-user-project")).isEqualTo("test-project");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .userProject("test-project")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_withContentType() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().getAll("Content-Type")).containsExactly("audio/mp4");

          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("audio/mp4")
              .build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCreateMultipartUploadRequest_sendsContentLength() throws Exception {
    HttpRequestHandler handler =
        req -> {
          // See https://docs.cloud.google.com/storage/docs/xml-api/reference-headers#contentlength
          assertThat(req.headers().get("Content-Length")).isEqualTo("0");

          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder().bucket("test-bucket").key("test-key").build();

      multipartUploadHttpRequestManager.sendCreateMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendListPartsRequest_success() throws Exception {
    HttpRequestHandler handler =
        req -> {
          OffsetDateTime lastModified = OffsetDateTime.of(2024, 5, 8, 17, 50, 0, 0, ZoneOffset.UTC);
          ListPartsResponse listPartsResponse =
              ListPartsResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .partNumberMarker(0)
                  .nextPartNumberMarker(1)
                  .maxParts(1)
                  .truncated(false)
                  .parts(
                      Collections.singletonList(
                          Part.builder()
                              .partNumber(1)
                              .eTag("\"etag\"")
                              .size(123)
                              .lastModified(lastModified)
                              .build()))
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(listPartsResponse));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      ListPartsRequest request =
          ListPartsRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .maxParts(1)
              .partNumberMarker(0)
              .build();

      ListPartsResponse response = multipartUploadHttpRequestManager.sendListPartsRequest(request);

      assertThat(response).isNotNull();
      assertThat(response.bucket()).isEqualTo("test-bucket");
      assertThat(response.key()).isEqualTo("test-key");
      assertThat(response.uploadId()).isEqualTo("test-upload-id");
      assertThat(response.partNumberMarker()).isEqualTo(0);
      assertThat(response.nextPartNumberMarker()).isEqualTo(1);
      assertThat(response.maxParts()).isEqualTo(1);
      assertThat(response.truncated()).isFalse();
      assertThat(response.parts()).hasSize(1);
      Part part = response.parts().get(0);
      assertThat(part.partNumber()).isEqualTo(1);
      assertThat(part.eTag()).isEqualTo("\"etag\"");
      assertThat(part.size()).isEqualTo(123);
      assertThat(part.lastModified())
          .isEqualTo(OffsetDateTime.of(2024, 5, 8, 17, 50, 0, 0, ZoneOffset.UTC));
    }
  }

  @Test
  public void sendListPartsRequest_bucketNotFound() throws Exception {
    HttpRequestHandler handler =
        req ->
            new DefaultFullHttpResponse(
                req.protocolVersion(),
                HttpResponseStatus.NOT_FOUND,
                Unpooled.wrappedBuffer("Bucket not found".getBytes(StandardCharsets.UTF_8)));

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      ListPartsRequest request =
          ListPartsRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .build();

      assertThrows(
          HttpResponseException.class,
          () -> multipartUploadHttpRequestManager.sendListPartsRequest(request));
    }
  }

  @Test
  public void sendListPartsRequest_keyNotFound() throws Exception {
    HttpRequestHandler handler =
        req ->
            new DefaultFullHttpResponse(
                req.protocolVersion(),
                HttpResponseStatus.NOT_FOUND,
                Unpooled.wrappedBuffer("Key not found".getBytes(StandardCharsets.UTF_8)));

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      ListPartsRequest request =
          ListPartsRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .build();

      assertThrows(
          HttpResponseException.class,
          () -> multipartUploadHttpRequestManager.sendListPartsRequest(request));
    }
  }

  @Test
  public void sendListPartsRequest_badRequest() throws Exception {
    HttpRequestHandler handler =
        req ->
            new DefaultFullHttpResponse(
                req.protocolVersion(),
                HttpResponseStatus.BAD_REQUEST,
                Unpooled.wrappedBuffer("Invalid uploadId".getBytes(StandardCharsets.UTF_8)));

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      ListPartsRequest request =
          ListPartsRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("invalid-upload-id")
              .build();

      assertThrows(
          HttpResponseException.class,
          () -> multipartUploadHttpRequestManager.sendListPartsRequest(request));
    }
  }

  @Test
  public void sendListPartsRequest_errorResponse() throws Exception {
    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), HttpResponseStatus.BAD_REQUEST);
          resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      ListPartsRequest request =
          ListPartsRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .build();

      assertThrows(
          HttpResponseException.class,
          () -> multipartUploadHttpRequestManager.sendListPartsRequest(request));
    }
  }

  @Test
  public void sendListPartsRequest_withUserProject() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-user-project")).isEqualTo("test-project");
          ListPartsResponse listPartsResponse =
              ListPartsResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .maxParts(1)
                  .partNumberMarker(0)
                  .parts(ImmutableList.of())
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(listPartsResponse));
          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      ListPartsRequest request =
          ListPartsRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .userProject("test-project")
              .build();

      ListPartsResponse response = multipartUploadHttpRequestManager.sendListPartsRequest(request);

      assertThat(response).isNotNull();
      assertThat(response.bucket()).isEqualTo("test-bucket");
    }
  }

  @Test
  public void sendAbortMultipartUploadRequest_success() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.uri()).contains("?uploadId=test-upload-id");
          AbortMultipartUploadResponse response = new AbortMultipartUploadResponse();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      AbortMultipartUploadRequest request =
          AbortMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .build();

      AbortMultipartUploadResponse response =
          multipartUploadHttpRequestManager.sendAbortMultipartUploadRequest(request);

      assertThat(response).isNotNull();
    }
  }

  @Test
  public void sendAbortMultipartUploadRequest_error() throws Exception {
    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), HttpResponseStatus.BAD_REQUEST);
          resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      AbortMultipartUploadRequest request =
          AbortMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .build();

      assertThrows(
          HttpResponseException.class,
          () -> multipartUploadHttpRequestManager.sendAbortMultipartUploadRequest(request));
    }
  }

  @Test
  public void sendAbortMultipartUploadRequest_withUserProject() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-user-project")).isEqualTo("test-project");
          AbortMultipartUploadResponse response = new AbortMultipartUploadResponse();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));
          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      AbortMultipartUploadRequest request =
          AbortMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .userProject("test-project")
              .build();

      AbortMultipartUploadResponse response =
          multipartUploadHttpRequestManager.sendAbortMultipartUploadRequest(request);

      assertThat(response).isNotNull();
    }
  }

  @Test
  public void sendCompleteMultipartUploadRequest_success() throws Exception {
    HttpRequestHandler handler =
        req -> {
          CompleteMultipartUploadResponse response =
              CompleteMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .etag("\"test-etag\"")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CompleteMultipartUploadRequest request =
          CompleteMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .multipartUpload(
                  CompletedMultipartUpload.builder()
                      .parts(
                          ImmutableList.of(
                              CompletedPart.builder().partNumber(1).eTag("\"etag1\"").build(),
                              CompletedPart.builder().partNumber(2).eTag("\"etag2\"").build()))
                      .build())
              .build();

      CompleteMultipartUploadResponse response =
          multipartUploadHttpRequestManager.sendCompleteMultipartUploadRequest(request);

      assertThat(response).isNotNull();
      assertThat(response.bucket()).isEqualTo("test-bucket");
      assertThat(response.key()).isEqualTo("test-key");
      assertThat(response.etag()).isEqualTo("\"test-etag\"");
    }
  }

  @Test
  public void sendCompleteMultipartUploadRequest_error() throws Exception {
    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), HttpResponseStatus.BAD_REQUEST);
          resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CompleteMultipartUploadRequest request =
          CompleteMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .multipartUpload(
                  CompletedMultipartUpload.builder()
                      .parts(
                          ImmutableList.of(
                              CompletedPart.builder().partNumber(1).eTag("\"etag1\"").build(),
                              CompletedPart.builder().partNumber(2).eTag("\"etag2\"").build()))
                      .build())
              .build();

      assertThrows(
          HttpResponseException.class,
          () -> multipartUploadHttpRequestManager.sendCompleteMultipartUploadRequest(request));
    }
  }

  @Test
  public void sendCompleteMultipartUploadRequest_body() throws Exception {
    HttpRequestHandler handler =
        req -> {
          FullHttpRequest fullHttpRequest = (FullHttpRequest) req;
          ByteBuf content = fullHttpRequest.content();
          String body = content.toString(StandardCharsets.UTF_8);
          assertThat(body)
              .isEqualTo(
                  "<CompleteMultipartUpload><Part><PartNumber>1</PartNumber><ETag>\"etag1\"</ETag></Part><Part><PartNumber>2</PartNumber><ETag>\"etag2\"</ETag></Part></CompleteMultipartUpload>");
          CompleteMultipartUploadResponse response =
              CompleteMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .etag("\"test-etag\"")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CompleteMultipartUploadRequest request =
          CompleteMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .multipartUpload(
                  CompletedMultipartUpload.builder()
                      .parts(
                          ImmutableList.of(
                              CompletedPart.builder().partNumber(1).eTag("\"etag1\"").build(),
                              CompletedPart.builder().partNumber(2).eTag("\"etag2\"").build()))
                      .build())
              .build();

      multipartUploadHttpRequestManager.sendCompleteMultipartUploadRequest(request);
    }
  }

  @Test
  public void sendCompleteMultipartUploadRequest_withUserProject() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-user-project")).isEqualTo("test-project");
          CompleteMultipartUploadResponse response =
              CompleteMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .etag("\"test-etag\"")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CompleteMultipartUploadRequest request =
          CompleteMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .userProject("test-project")
              .multipartUpload(
                  CompletedMultipartUpload.builder()
                      .parts(
                          ImmutableList.of(
                              CompletedPart.builder().partNumber(1).eTag("\"etag1\"").build(),
                              CompletedPart.builder().partNumber(2).eTag("\"etag2\"").build()))
                      .build())
              .build();

      CompleteMultipartUploadResponse response =
          multipartUploadHttpRequestManager.sendCompleteMultipartUploadRequest(request);

      assertThat(response).isNotNull();
      assertThat(response.bucket()).isEqualTo("test-bucket");
      assertThat(response.key()).isEqualTo("test-key");
      assertThat(response.etag()).isEqualTo("\"test-etag\"");
    }
  }

  @Test
  public void sendUploadPartRequest_success() throws Exception {
    String etag = "\"af1ed31420542285653c803a34aa839a\"";
    String content = "hello world";
    byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);

    HttpRequestHandler handler =
        req -> {
          assertThat(req.uri()).contains("?partNumber=1&uploadId=test-upload-id");
          FullHttpRequest fullReq = (FullHttpRequest) req;
          ByteBuf requestContent = fullReq.content();
          byte[] receivedBytes = new byte[requestContent.readableBytes()];
          requestContent.readBytes(receivedBytes);
          assertThat(receivedBytes).isEqualTo(contentBytes);

          DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
          resp.headers().set("ETag", etag);
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      UploadPartRequest request =
          UploadPartRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .partNumber(1)
              .build();

      UploadPartResponse response =
          multipartUploadHttpRequestManager.sendUploadPartRequest(
              request, RewindableContent.of(ByteBuffer.wrap(contentBytes)));

      assertThat(response).isNotNull();
      assertThat(response.eTag()).isEqualTo(etag);
    }
  }

  @Test
  public void sendUploadPartRequest_withChecksums() throws Exception {
    String etag = "\"af1ed31420542285653c803a34aa839a\"";
    String content = "hello world";
    byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
    String md5 = Hashing.md5().hashBytes(contentBytes).toString();
    String crc32c = "yZRlqg==";

    HttpRequestHandler handler =
        req -> {
          assertThat(req.uri()).contains("?partNumber=1&uploadId=test-upload-id");
          assertThat(req.headers().get("x-goog-hash")).contains("crc32c=" + crc32c);
          FullHttpRequest fullReq = (FullHttpRequest) req;
          ByteBuf requestContent = fullReq.content();
          byte[] receivedBytes = new byte[requestContent.readableBytes()];
          requestContent.readBytes(receivedBytes);
          assertThat(receivedBytes).isEqualTo(contentBytes);

          DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
          resp.headers().set("ETag", etag);
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      UploadPartRequest request =
          UploadPartRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .partNumber(1)
              .build();

      UploadPartResponse response =
          multipartUploadHttpRequestManager.sendUploadPartRequest(
              request, RewindableContent.of(ByteBuffer.wrap(contentBytes)));

      assertThat(response).isNotNull();
      assertThat(response.eTag()).isEqualTo(etag);
    }
  }

  @Test
  public void sendUploadPartRequest_withCustomChecksum() throws Exception {
    String etag = "\"af1ed31420542285653c803a34aa839a\"";
    ChecksummedTestContent content =
        ChecksummedTestContent.of("hello world".getBytes(StandardCharsets.UTF_8));

    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-hash"))
              .isEqualTo("crc32c=" + content.getCrc32cBase64());
          FullHttpRequest fullReq = (FullHttpRequest) req;
          ByteBuf requestContent = fullReq.content();
          byte[] receivedBytes = new byte[requestContent.readableBytes()];
          requestContent.readBytes(receivedBytes);
          assertThat(receivedBytes).isEqualTo(content.getBytes());
          DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
          resp.headers().set("ETag", etag);
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      UploadPartRequest request =
          UploadPartRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .partNumber(1)
              .crc32c(content.getCrc32cBase64())
              .build();
      UploadPartResponse response =
          multipartUploadHttpRequestManager.sendUploadPartRequest(
              request, RewindableContent.of(content.asByteBuffer()));
      assertThat(response).isNotNull();
      assertThat(response.eTag()).isEqualTo(etag);
    }
  }

  @Test
  public void sendUploadPartRequest_withUserProject() throws Exception {
    String etag = "\"af1ed31420542285653c803a34aa839a\"";
    byte[] contentBytes = "hello world".getBytes(StandardCharsets.UTF_8);

    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-user-project")).isEqualTo("test-project");
          DefaultFullHttpResponse resp = new DefaultFullHttpResponse(req.protocolVersion(), OK);
          resp.headers().set("ETag", etag);
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      UploadPartRequest request =
          UploadPartRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .partNumber(1)
              .userProject("test-project")
              .build();

      UploadPartResponse response =
          multipartUploadHttpRequestManager.sendUploadPartRequest(
              request, RewindableContent.of(ByteBuffer.wrap(contentBytes)));

      assertThat(response).isNotNull();
      assertThat(response.eTag()).isEqualTo(etag);
    }
  }

  @Test
  public void sendUploadPartRequest_error() throws Exception {
    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), HttpResponseStatus.BAD_REQUEST);
          resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      UploadPartRequest request =
          UploadPartRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .uploadId("test-upload-id")
              .partNumber(1)
              .build();

      assertThrows(
          HttpResponseException.class,
          () ->
              multipartUploadHttpRequestManager.sendUploadPartRequest(
                  request, RewindableContent.empty()));
    }
  }

  @Test
  public void sendListMultipartUploadsRequest_success() throws Exception {
    HttpRequestHandler handler =
        req -> {
          ListMultipartUploadsResponse listMultipartUploadsResponse =
              ListMultipartUploadsResponse.builder()
                  .bucket("test-bucket")
                  .keyMarker("key-marker")
                  .uploadIdMarker("upload-id-marker")
                  .nextKeyMarker("next-key-marker")
                  .nextUploadIdMarker("next-upload-id-marker")
                  .maxUploads(1)
                  .truncated(false)
                  .uploads(
                      ImmutableList.of(
                          MultipartUpload.newBuilder()
                              .key("test-key")
                              .uploadId("test-upload-id")
                              .storageClass(StorageClass.STANDARD)
                              .initiated(
                                  OffsetDateTime.of(2025, 11, 11, 0, 0, 0, 0, ZoneOffset.UTC))
                              .build()))
                  .build();
          // Jackson fails to serialize ImmutableList without GuavaModule.
          // We use reflection to replace it with ArrayList for the test.
          forceSetUploads(listMultipartUploadsResponse, listMultipartUploadsResponse.uploads());

          ByteBuf buf =
              Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(listMultipartUploadsResponse));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);

          resp.headers().set("Content-Type", "application/xml; charset=utf-8");
          resp.headers().set("Content-Length", resp.content().readableBytes());
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());

      ListMultipartUploadsRequest request =
          ListMultipartUploadsRequest.builder()
              .bucket("test-bucket")
              .maxUploads(1)
              .keyMarker("key-marker")
              .uploadIdMarker("upload-id-marker")
              .build();

      ListMultipartUploadsResponse response =
          multipartUploadHttpRequestManager.sendListMultipartUploadsRequest(request);

      assertThat(response).isNotNull();
      assertThat(response.bucket()).isEqualTo("test-bucket");
      assertThat(response.uploads()).hasSize(1);

      MultipartUpload upload = response.uploads().get(0);
      assertThat(upload.key()).isEqualTo("test-key");
      assertThat(upload.storageClass()).isEqualTo(StorageClass.STANDARD);
      assertThat(upload.initiated())
          .isEqualTo(OffsetDateTime.of(2025, 11, 11, 0, 0, 0, 0, ZoneOffset.UTC));
    }
  }

  @Test
  public void sendListMultipartUploadsRequest_error() throws Exception {
    HttpRequestHandler handler =
        req -> {
          FullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), HttpResponseStatus.BAD_REQUEST);
          resp.headers().set(CONTENT_TYPE, "text/plain; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      ListMultipartUploadsRequest request =
          ListMultipartUploadsRequest.builder().bucket("test-bucket").build();

      assertThrows(
          HttpResponseException.class,
          () -> multipartUploadHttpRequestManager.sendListMultipartUploadsRequest(request));
    }
  }

  @Test
  public void sendListMultipartUploadsRequest_withUserProject() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.headers().get("x-goog-user-project")).isEqualTo("test-project");
          ListMultipartUploadsResponse listMultipartUploadsResponse =
              ListMultipartUploadsResponse.builder()
                  .bucket("test-bucket")
                  .keyMarker("key-marker")
                  .uploadIdMarker("upload-id-marker")
                  .nextKeyMarker("next-key-marker")
                  .nextUploadIdMarker("next-upload-id-marker")
                  .maxUploads(1)
                  .truncated(false)
                  .uploads(ImmutableList.of())
                  .build();
          // Jackson fails to serialize ImmutableList without GuavaModule.
          // We use reflection to replace it with ArrayList for the test.
          forceSetUploads(listMultipartUploadsResponse, listMultipartUploadsResponse.uploads());

          ByteBuf buf =
              Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(listMultipartUploadsResponse));

          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);

          resp.headers().set("Content-Type", "application/xml; charset=utf-8");
          resp.headers().set("Content-Length", resp.content().readableBytes());
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler)) {
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());

      ListMultipartUploadsRequest request =
          ListMultipartUploadsRequest.builder()
              .bucket("test-bucket")
              .maxUploads(1)
              .userProject("test-project")
              .build();

      ListMultipartUploadsResponse response =
          multipartUploadHttpRequestManager.sendListMultipartUploadsRequest(request);

      assertThat(response).isNotNull();
      assertThat(response.bucket()).isEqualTo("test-bucket");
    }
  }

  @Test
  public void hostWithoutTrailingSlash_urlConstructedCorrectly() throws Exception {
    HttpRequestHandler handler =
        req -> {
          assertThat(req.uri()).startsWith("/test-bucket/test-key");
          CreateMultipartUploadResponse response =
              CreateMultipartUploadResponse.builder()
                  .bucket("test-bucket")
                  .key("test-key")
                  .uploadId("test-upload-id")
                  .build();
          ByteBuf buf = Unpooled.wrappedBuffer(xmlMapper.writeValueAsBytes(response));
          DefaultFullHttpResponse resp =
              new DefaultFullHttpResponse(req.protocolVersion(), OK, buf);
          resp.headers().set(CONTENT_TYPE, "application/xml; charset=utf-8");
          return resp;
        };

    try (FakeHttpServer fakeHttpServer = FakeHttpServer.of(handler, false)) {
      MultipartUploadHttpRequestManager manager =
          MultipartUploadHttpRequestManager.createFrom(fakeHttpServer.getHttpStorageOptions());
      CreateMultipartUploadRequest request =
          CreateMultipartUploadRequest.builder()
              .bucket("test-bucket")
              .key("test-key")
              .contentType("application/octet-stream")
              .build();

      CreateMultipartUploadResponse response = manager.sendCreateMultipartUploadRequest(request);

      assertThat(response.bucket()).isEqualTo("test-bucket");
    }
  }

  private void forceSetUploads(
      ListMultipartUploadsResponse response, java.util.List<MultipartUpload> uploads) {
    try {
      java.lang.reflect.Field uploadsField =
          ListMultipartUploadsResponse.class.getDeclaredField("uploads");
      uploadsField.setAccessible(true);
      uploadsField.set(response, new java.util.ArrayList<>(uploads));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

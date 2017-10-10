/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.protobuf.ProtoHttpContent;
import com.google.api.client.util.IOUtils;
import com.google.common.base.Preconditions;
import com.google.protobuf.MessageLite;
import com.google.rpc.Code;
import com.google.rpc.Status;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/**
 * An RPC transport that sends protocol buffers over HTTP.
 *
 * <p>This class is thread-safe.
 */
class RemoteRpc {
  private static final Logger logger = Logger.getLogger(RemoteRpc.class.getName());

  /**
   * An input stream that wraps a {@link GZIPInputStream} and forces it to fully consume its
   * underlying {@link InputStream} before calling close() on it.
   *
   * @see <a>href="https://github.com/google/google-http-java-client/issues/367"</a>
   */
  static class GzipFixingInputStream extends InputStream {

    // How many extra read() calls we have made on the underlying stream.
    int callsToRead = 0;

    // Experimentally, it is only necessary to consume 1 extra byte. Consuming a bit more than that
    // should not affect performance, but we set an upper bound for safety.
    private static final int MAX_BYTES_TO_CONSUME = 100;

    private static final Field gzipUnderlyingInputStreamField = getGzipUnderlyingInputStreamField();

    private static Field getGzipUnderlyingInputStreamField() {
      try {
        // FilterInputStream is a superclass of GZIPInputStream and stores the underlying
        // InputStream.
        Field gzipInputStreamIsField = FilterInputStream.class.getDeclaredField("in");
        gzipInputStreamIsField.setAccessible(true);
        return gzipInputStreamIsField;
      } catch (Exception e) {
        logger.log(
            Level.INFO,
            "Failed to find field \"in\" in FilterInputStream. This"
                + " may prevent keep-alive from working correctly.",
            e);
        return null;
      }
    }

    public static InputStream maybeWrap(InputStream inputStream) {
      if (gzipUnderlyingInputStreamField != null && inputStream instanceof GZIPInputStream) {
        return new GzipFixingInputStream((GZIPInputStream) inputStream);
      }
      return inputStream;
    }

    private final GZIPInputStream gzipInputStream;

    private GzipFixingInputStream(GZIPInputStream gzipInputStream) {
      Preconditions.checkNotNull(gzipUnderlyingInputStreamField);
      this.gzipInputStream = gzipInputStream;
    }

    @Override
    public int read() throws IOException {
      return gzipInputStream.read();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
      return gzipInputStream.read(b, off, len);
    }

    @Override
    public void close() throws IOException {
      // If possible, finish consuming the underlying InputStream before closing it.
      if (gzipUnderlyingInputStreamField != null) {
        try {
          InputStream underlyingInputStream =
              (InputStream) gzipUnderlyingInputStreamField.get(gzipInputStream);
          boolean reachedEndOfStream = false;
          while (!reachedEndOfStream && callsToRead < MAX_BYTES_TO_CONSUME) {
            callsToRead++;
            if (underlyingInputStream.read() == -1) {
              reachedEndOfStream = true;
            }
          }
          if (!reachedEndOfStream) {
            logger.log(Level.FINER, "Gave up consuming underlying InputStream");
          }
        } catch (Exception e) {
          // If this fails for any reason, log and move on.
          logger.log(
              Level.FINER, "Failed to consume underlying InputStream from GZIPInputStream", e);
        }
      }
      gzipInputStream.close();
    }
  }

  private static final String API_FORMAT_VERSION_HEADER = "X-Goog-Api-Format-Version";
  private static final String API_FORMAT_VERSION = "2";

  private final HttpRequestFactory client;
  private final HttpRequestInitializer initializer;
  private final String url;
  private final AtomicInteger rpcCount = new AtomicInteger(0);

  RemoteRpc(HttpRequestFactory client, HttpRequestInitializer initializer, String url) {
    this.client = client;
    this.initializer = initializer;
    this.url = url;
    try {
      resolveURL("dummyRpc");
    } catch (Exception e) {
      throw new IllegalArgumentException(
          "Unable to construct RemoteRpc due to unsupported url: <" + url + ">", e);
    }
  }

  /**
   * Makes an RPC call using the client. Logs how long it took and any exceptions.
   *
   * NOTE: The request could be an InputStream too, but the http client will need to
   * find its length, which will require buffering it anyways.
   *
   * @throws DatastoreException if the RPC fails.
   */
  public InputStream call(String methodName, MessageLite request) throws DatastoreException {
    logger.fine("remote datastore call " + methodName);

    long startTime = System.currentTimeMillis();
    try {
      HttpResponse httpResponse;
      try {
        rpcCount.incrementAndGet();
        ProtoHttpContent payload = new ProtoHttpContent(request);
        HttpRequest httpRequest = client.buildPostRequest(resolveURL(methodName), payload);
        httpRequest.getHeaders().put(API_FORMAT_VERSION_HEADER, API_FORMAT_VERSION);
        // Don't throw an HTTPResponseException on error. It converts the response to a String and
        // throws away the original, whereas we need the raw bytes to parse it as a proto.
        httpRequest.setThrowExceptionOnExecuteError(false);
        // Datastore requests typically time out after 60s; set the read timeout to slightly longer
        // than that by default (can be overridden via the HttpRequestInitializer).
        httpRequest.setReadTimeout(65 * 1000);
        if (initializer != null) {
          initializer.initialize(httpRequest);
        }
        httpResponse = httpRequest.execute();
        if (!httpResponse.isSuccessStatusCode()) {
          throw makeException(url, methodName, httpResponse.getContent(),
              httpResponse.getContentType(), httpResponse.getContentCharset(), null,
              httpResponse.getStatusCode());
        }
        return GzipFixingInputStream.maybeWrap(httpResponse.getContent());
      } catch (SocketTimeoutException e) {
        throw makeException(url, methodName, Code.DEADLINE_EXCEEDED, "Deadline exceeded", e);
      } catch (IOException e) {
        throw makeException(url, methodName, Code.UNAVAILABLE, "I/O error", e);
      }
    } finally {
      long elapsedTime = System.currentTimeMillis() - startTime;
      logger.fine("remote datastore call " + methodName + " took " + elapsedTime + " ms");
    }
  }

  void resetRpcCount() {
    rpcCount.set(0);
  }

  int getRpcCount() {
    return rpcCount.get();
  }

  public String getUrl() {
    return url;
  }

  GenericUrl resolveURL(String path) {
    return new GenericUrl(url + ":" + path);
  }

  HttpRequestFactory getHttpRequestFactory() {
    return client;
  }

  public static DatastoreException makeException(String url, String methodName, Code code,
      String message, Throwable cause) {
    logger.fine("remote datastore call " + methodName + " against " + url  + " failed: " + message);
    return new DatastoreException(methodName, code, message, cause);
  }

  static DatastoreException makeException(String url, String methodName, InputStream content,
      String contentType, Charset contentCharset, Throwable cause, int httpStatusCode) {
    if (!contentType.equals("application/x-protobuf")) {
      String responseContent;
      try {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        IOUtils.copy(content, out);
        responseContent = out.toString(contentCharset.name());
      } catch (IOException e) {
        responseContent = "";
      }
      return makeException(url, methodName, Code.INTERNAL,
          String.format(
              "Non-protobuf error: %s. HTTP status code was %d.", responseContent, httpStatusCode),
          cause);
    }

    Status rpcStatus;
    try {
      rpcStatus = Status.parseFrom(content);
    } catch (IOException e) {
      return makeException(url, methodName, Code.INTERNAL,
          String.format(
              "Unable to parse Status protocol buffer: HTTP status code was %s.", httpStatusCode),
          e);
    }

    Code code = Code.valueOf(rpcStatus.getCode());
    if (code == null) {
      return makeException(url, methodName, Code.INTERNAL,
          String.format(
              "Invalid error code: %d. Message: %s.", rpcStatus.getCode(), rpcStatus.getMessage()),
          cause);
    } else if (code == Code.OK) {
      // We can end up here because there was no response body (and we successfully parsed an
      // empty Status message). This may happen for 401s in particular due to special handling
      // in low-level HTTP libraries.
      if (httpStatusCode == HttpStatusCodes.STATUS_CODE_UNAUTHORIZED) {
        return makeException(url, methodName, Code.UNAUTHENTICATED, "Unauthenticated.", cause);
      }
      return makeException(url, methodName, Code.INTERNAL,
          String.format("Unexpected OK error code with HTTP status code of %d. Message: %s.",
              httpStatusCode, rpcStatus.getMessage()),
          cause);
    }

    return makeException(url, methodName, code, rpcStatus.getMessage(), cause);
  }
}

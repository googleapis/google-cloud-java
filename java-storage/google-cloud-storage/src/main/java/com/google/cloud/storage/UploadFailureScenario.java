/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.storage.Utils.ifNonNull;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.BaseServiceException;
import com.google.cloud.storage.StorageException.IOExceptionCallable;
import com.google.common.io.CharStreams;
import com.google.protobuf.Message;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.WriteObjectRequest;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.annotation.ParametersAreNonnullByDefault;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

@ParametersAreNonnullByDefault
enum UploadFailureScenario {
  // TODO: send more bytes than are in the Content-Range header
  SCENARIO_0(BaseServiceException.UNKNOWN_CODE, null, "Unknown Error"),
  SCENARIO_0_1(BaseServiceException.UNKNOWN_CODE, null, "Response not application/json."),
  SCENARIO_1(
      BaseServiceException.UNKNOWN_CODE,
      "invalid",
      "Attempt to append to already finalized upload session."),
  SCENARIO_2(
      BaseServiceException.UNKNOWN_CODE,
      "invalid",
      "Attempt to finalize upload session with fewer bytes than the backend has received."),
  SCENARIO_3(
      BaseServiceException.UNKNOWN_CODE,
      "dataLoss",
      "Attempt to finalize upload session with more bytes than the backend has received."),
  SCENARIO_4(200, "ok", "Attempt to finalize an already finalized session with same object size"),
  SCENARIO_4_1(
      BaseServiceException.UNKNOWN_CODE,
      "dataLoss",
      "Finalized upload, but object size less than expected."),
  SCENARIO_4_2(
      BaseServiceException.UNKNOWN_CODE,
      "dataLoss",
      "Finalized upload, but object size greater than expected."),
  SCENARIO_5(
      BaseServiceException.UNKNOWN_CODE,
      "dataLoss",
      "Client side data loss detected. Attempt to append to a upload session with an offset"
          + " higher than the backend has"),
  SCENARIO_7(
      BaseServiceException.UNKNOWN_CODE,
      "dataLoss",
      "Client side data loss detected. Bytes acked is more than client sent."),

  SCENARIO_9(503, "backendNotConnected", "Ack less than bytes sent");

  private static final String PREFIX_I = "\t|< ";
  private static final String PREFIX_O = "\t|> ";
  private static final String PREFIX_X = "\t|  ";

  private static final Predicate<String> includedHeaders =
      matches("Content-Length")
          .or(matches("Content-Encoding"))
          .or(matches("Content-Range"))
          .or(matches("Content-Type"))
          .or(matches("Range"))
          .or(startsWith("X-Goog-Stored-"))
          .or(matches("X-Goog-GCS-Idempotency-Token"))
          .or(matches("X-Goog-Hash"))
          .or(matches("X-Goog-request-params"))
          .or(matches("X-GUploader-UploadID"));

  private static final Predicate<Map.Entry<String, ?>> includeHeader =
      e -> includedHeaders.test(e.getKey());

  private final int code;
  @Nullable private final String reason;
  private final String message;

  UploadFailureScenario(int code, @Nullable String reason, String message) {
    this.code = code;
    this.reason = reason;
    this.message = message;
  }

  String getMessage() {
    return message;
  }

  StorageException toStorageException(String uploadId, HttpResponse resp) {
    return toStorageException(
        uploadId, resp, null, () -> CharStreams.toString(new InputStreamReader(resp.getContent())));
  }

  StorageException toStorageException(
      String uploadId, @Nullable HttpResponse resp, @Nullable Throwable cause) {
    if (resp != null) {
      // an exception caused this, do not try to read the content from the response.
      return toStorageException(uploadId, resp, cause, () -> null);
    } else {
      return new StorageException(code, message, reason, cause);
    }
  }

  StorageException toStorageException(
      String uploadId,
      HttpResponse resp,
      @Nullable Throwable cause,
      IOExceptionCallable<@Nullable String> contentCallable) {
    return toStorageException(code, message, reason, uploadId, resp, cause, contentCallable);
  }

  <M extends Message> StorageException toStorageException(
      @NonNull List<M> reqs,
      @Nullable Message resp,
      @NonNull GrpcCallContext context,
      @Nullable Throwable cause) {
    return toStorageException(code, message, reason, reqs, resp, context, cause);
  }

  static StorageException toStorageException(
      HttpResponse response, HttpResponseException cause, String uploadId) {
    String statusMessage = cause.getStatusMessage();
    StorageException se =
        UploadFailureScenario.toStorageException(
            cause.getStatusCode(),
            String.format(
                Locale.US,
                "%d %s",
                cause.getStatusCode(),
                statusMessage == null ? "" : statusMessage),
            "",
            uploadId,
            response,
            cause,
            () -> null);
    return se;
  }

  static <M extends Message> StorageException toStorageException(
      int code,
      String message,
      @Nullable String reason,
      @NonNull List<M> reqs,
      @Nullable Message resp,
      @NonNull GrpcCallContext context,
      @Nullable Throwable cause) {
    final StringBuilder sb = new StringBuilder();
    sb.append(message);
    // request context
    Map<String, List<String>> extraHeaders = context.getExtraHeaders();
    recordHeadersTo(extraHeaders, PREFIX_O, sb);
    int length = reqs.size();
    if (length == 0) {
      sb.append("\n").append(PREFIX_O).append("[]");
    }
    for (int i = 0; i < length; i++) {
      if (i == 0) {
        sb.append("\n").append(PREFIX_O).append("[");
      } else {
        sb.append(",");
      }
      Message req = reqs.get(i);
      fmt(req, PREFIX_O, Indentation.T1, sb);
      sb.append("\n").append(PREFIX_O).append("\t}");
      if (i == length - 1) {
        sb.append("\n").append(PREFIX_O).append("]");
      }
    }

    sb.append("\n").append(PREFIX_X);

    // response context
    if (resp != null) {
      sb.append("\n").append(PREFIX_I).append(resp.getClass().getName()).append("{");
      fmt(resp, PREFIX_I, Indentation.T1, sb);
      sb.append("\n").append(PREFIX_I).append("}");
      sb.append("\n").append(PREFIX_X);
    }

    if (cause != null) {
      if (cause instanceof ApiException) {
        ApiException apiException = (ApiException) cause;
        Throwable cause1 = apiException.getCause();
        if (cause1 instanceof StatusRuntimeException) {
          StatusRuntimeException statusRuntimeException = (StatusRuntimeException) cause1;
          sb.append("\n").append(PREFIX_I).append(statusRuntimeException.getStatus());
          ifNonNull(
              statusRuntimeException.getTrailers(),
              t -> sb.append("\n").append(PREFIX_I).append(t));
        } else {
          sb.append("\n")
              .append(PREFIX_I)
              .append("code: ")
              .append(apiException.getStatusCode().toString());
          ifNonNull(
              apiException.getReason(),
              r -> sb.append("\n").append(PREFIX_I).append("reason: ").append(r));
          ifNonNull(
              apiException.getDomain(),
              d -> sb.append("\n").append(PREFIX_I).append("domain: ").append(d));
          ifNonNull(
              apiException.getErrorDetails(),
              e -> sb.append("\n").append(PREFIX_I).append("errorDetails: ").append(e));
        }
        sb.append("\n").append(PREFIX_X);
      }
    }
    StorageException se = new StorageException(code, sb.toString(), reason, cause);
    return se;
  }

  static StorageException toStorageException(
      int overrideCode,
      String message,
      @Nullable String reason,
      String uploadId,
      HttpResponse resp,
      @Nullable Throwable cause,
      IOExceptionCallable<@Nullable String> contentCallable) {
    Throwable suppress = null;
    StringBuilder sb = new StringBuilder();
    sb.append(message);
    // add request context
    sb.append("\n").append(PREFIX_O).append("PUT ").append(uploadId);
    recordHeaderTo(resp.getRequest().getHeaders(), PREFIX_O, sb);

    sb.append("\n").append(PREFIX_X);
    // add response context
    {
      int code = resp.getStatusCode();
      sb.append("\n").append(PREFIX_I).append("HTTP/1.1 ").append(code);
      if (resp.getStatusMessage() != null) {
        sb.append(" ").append(resp.getStatusMessage());
      }

      recordHeaderTo(resp.getHeaders(), PREFIX_I, sb);
      // try to include any body that we can handle
      if (isOk(code) || code == 503 || code == 400) {
        try {
          String content = contentCallable.call();
          if (content != null) {
            sb.append("\n").append(PREFIX_I);
            if (content.contains("\n") || content.contains("\r\n")) {
              sb.append("\n").append(PREFIX_I).append(content.replaceAll("\r?\n", "\n" + PREFIX_I));
            } else {
              sb.append("\n").append(PREFIX_I).append(content);
            }
          }
        } catch (IOException e) {
          // com.google.api.client.http.HttpResponseException.Builder.Builder
          // prints an exception which might occur while attempting to resolve the content
          // this can lose the context about the request it was for, instead we register it
          // as a suppressed exception
          suppress = new StorageException(0, "Error reading response content for diagnostics.", e);
        }
      }

      sb.append("\n").append(PREFIX_X);
    }
    StorageException storageException =
        new StorageException(overrideCode, sb.toString(), reason, cause);
    if (suppress != null) {
      storageException.addSuppressed(suppress);
    }
    return storageException;
  }

  static boolean isOk(int code) {
    return code == 200 || code == 201;
  }

  static boolean isContinue(int code) {
    return code == 308;
  }

  // The header names from HttpHeaders are lower cased, define some utility methods to create
  // predicates where we can specify values ignoring case
  private static Predicate<String> matches(String expected) {
    String lower = Utils.headerNameToLowerCase(expected);
    return lower::equals;
  }

  private static Predicate<String> startsWith(String prefix) {
    String lower = Utils.headerNameToLowerCase(prefix);
    return s -> s.startsWith(lower);
  }

  private static void recordHeaderTo(HttpHeaders h, String prefix, StringBuilder sb) {
    h.entrySet().stream().filter(includeHeader).forEach(writeHeaderValue(prefix, sb));
  }

  private static void recordHeadersTo(
      Map<String, List<String>> headers, String prefix, StringBuilder sb) {
    headers.entrySet().stream().filter(includeHeader).forEach(writeHeaderValue(prefix, sb));
  }

  private static <V> Consumer<Map.Entry<String, V>> writeHeaderValue(
      String prefix, StringBuilder sb) {
    return e -> {
      String key = e.getKey();
      String value = headerValueToString(e.getValue());
      sb.append("\n").append(prefix).append(key).append(": ").append(value);
    };
  }

  private static String headerValueToString(Object o) {
    if (o instanceof List) {
      List<?> l = (List<?>) o;
      if (l.size() == 1) {
        return l.get(0).toString();
      }
    }

    return o.toString();
  }

  private static void fmt(
      Message msg,
      @SuppressWarnings("SameParameterValue") String prefix,
      Indentation indentation,
      StringBuilder sb) {
    if (msg instanceof WriteObjectRequest) {
      WriteObjectRequest req = (WriteObjectRequest) msg;
      fmtWriteObjectRequest(req, prefix, indentation, sb);
    } else if (msg instanceof BidiWriteObjectRequest) {
      BidiWriteObjectRequest req = (BidiWriteObjectRequest) msg;
      fmtBidiWriteObjectRequest(req, prefix, indentation, sb);
    } else {
      String string = msg.toString();
      // drop the final new line before prefixing
      string = string.replaceAll("\n$", "");
      sb.append("\n")
          .append(prefix)
          .append(indentation)
          .append(string.replaceAll("\r?\n", "\n" + prefix + indentation.indentation));
    }
  }

  private static void fmtWriteObjectRequest(
      WriteObjectRequest req, String prefix, Indentation t1, StringBuilder sb) {
    Indentation t2 = t1.indent();
    Indentation t3 = t2.indent();
    sb.append("\n").append(prefix).append(t1).append(req.getClass().getName()).append("{");
    if (req.hasUploadId()) {
      sb.append("\n").append(prefix).append(t2).append("upload_id: ").append(req.getUploadId());
    }
    long writeOffset = req.getWriteOffset();
    if (req.hasChecksummedData()) {
      ChecksummedData checksummedData = req.getChecksummedData();
      sb.append("\n").append(prefix).append(t2);
      sb.append(
          String.format(
              Locale.US,
              "checksummed_data: {range: [%d:%d]",
              writeOffset,
              writeOffset + checksummedData.getContent().size()));
      if (checksummedData.hasCrc32C()) {
        sb.append(", crc32c: ").append(Integer.toUnsignedString(checksummedData.getCrc32C()));
      }
      sb.append("}");
    } else {
      sb.append("\n").append(prefix).append(t2).append("write_offset: ").append(writeOffset);
    }
    if (req.getFinishWrite()) {
      sb.append("\n").append(prefix).append(t2).append("finish_write: true");
    }
    if (req.hasObjectChecksums()) {
      ObjectChecksums objectChecksums = req.getObjectChecksums();
      sb.append("\n").append(prefix).append(t2).append("object_checksums: ").append("{");
      fmt(objectChecksums, prefix, t3, sb);
      sb.append("\n").append(prefix).append(t2).append("}");
    }
  }

  private static void fmtBidiWriteObjectRequest(
      BidiWriteObjectRequest req, String prefix, Indentation t1, StringBuilder sb) {
    Indentation t2 = t1.indent();
    Indentation t3 = t2.indent();
    sb.append("\n").append(prefix).append(t1).append(req.getClass().getName()).append("{");
    if (req.hasUploadId()) {
      sb.append("\n").append(prefix).append(t2).append("upload_id: ").append(req.getUploadId());
    }
    long writeOffset = req.getWriteOffset();
    if (req.hasChecksummedData()) {
      ChecksummedData checksummedData = req.getChecksummedData();
      sb.append("\n").append(prefix).append(t2);
      sb.append(
          String.format(
              Locale.US,
              "checksummed_data: {range: [%d:%d]",
              writeOffset,
              writeOffset + checksummedData.getContent().size()));
      if (checksummedData.hasCrc32C()) {
        sb.append(", crc32c: ").append(Integer.toUnsignedString(checksummedData.getCrc32C()));
      }
      sb.append("}");
    } else {
      sb.append("\n").append(prefix).append(t2).append("write_offset: ").append(writeOffset);
    }
    if (req.getFlush()) {
      sb.append("\n").append(prefix).append(t2).append("flush: true");
    }
    if (req.getStateLookup()) {
      sb.append("\n").append(prefix).append(t2).append("state_lookup: true");
    }
    if (req.getFinishWrite()) {
      sb.append("\n").append(prefix).append(t2).append("finish_write: true");
    }
    if (req.hasObjectChecksums()) {
      ObjectChecksums objectChecksums = req.getObjectChecksums();
      sb.append("\n").append(prefix).append(t2).append("object_checksums: ").append("{");
      fmt(objectChecksums, prefix, t3, sb);
      sb.append("\n").append(prefix).append(t2).append("}");
    }
  }

  enum Indentation {
    T1("\t"),
    T2("\t\t"),
    T3("\t\t\t"),
    T4("\t\t\t\t"),
    ;

    private final String indentation;

    Indentation(String indentation) {
      this.indentation = indentation;
    }

    Indentation indent() {
      int ordinal = ordinal();
      return values()[ordinal + 1];
    }

    @Override
    public String toString() {
      return indentation;
    }
  }
}

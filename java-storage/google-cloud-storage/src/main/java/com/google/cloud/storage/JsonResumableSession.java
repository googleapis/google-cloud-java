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

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.HttpContentRange.HasRange;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.spi.v1.HttpRpcContext;
import com.google.cloud.storage.spi.v1.HttpStorageRpc;
import io.opencensus.trace.EndSpanOptions;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.nullness.qual.Nullable;

final class JsonResumableSession {

  static final String SPAN_NAME_WRITE =
      String.format(Locale.US, "Sent.%s.write", HttpStorageRpc.class.getName());
  static final EndSpanOptions END_SPAN_OPTIONS =
      EndSpanOptions.builder().setSampleToLocalSpanStore(true).build();

  private final HttpClientContext context;
  private final RetrierWithAlg retrier;
  private final JsonResumableWrite resumableWrite;

  JsonResumableSession(
      HttpClientContext context, RetrierWithAlg retrier, JsonResumableWrite resumableWrite) {
    this.context = context;
    this.retrier = retrier;
    this.resumableWrite = resumableWrite;
  }

  /**
   * Not automatically retried. Usually called from within another retrying context. We don't yet
   * have the concept of nested retry handling.
   */
  ResumableOperationResult<@Nullable StorageObject> query() {
    return new JsonResumableSessionQueryTask(context, resumableWrite).call();
  }

  ResumableOperationResult<@Nullable StorageObject> put(
      RewindableContent content, HttpContentRange contentRange) {
    Crc32cValue<?> crc32cSoFar = resumableWrite.getCumulativeCrc32c();
    @Nullable Crc32cValue<?> nextCumulativeCrc32c =
        resumableWrite.getHasher().nullSafeConcat(crc32cSoFar, content.getCrc32c());
    @Nullable Crc32cValue<?> finalChecksum =
        contentRange.isFinalizing() ? nextCumulativeCrc32c : null;
    JsonResumableSessionPutTask task =
        new JsonResumableSessionPutTask(
            context, resumableWrite, content, contentRange, finalChecksum);
    HttpRpcContext httpRpcContext = HttpRpcContext.getInstance();
    try {
      httpRpcContext.newInvocationId();
      AtomicBoolean dirty = new AtomicBoolean(false);
      ResumableOperationResult<@Nullable StorageObject> result =
          retrier.run(
              () -> {
                if (dirty.getAndSet(true)) {
                  ResumableOperationResult<@Nullable StorageObject> query = query();
                  long persistedSize = query.getPersistedSize();
                  if (contentRange.endOffsetEquals(persistedSize) || query.getObject() != null) {
                    return query;
                  } else {
                    task.rewindTo(persistedSize);
                  }
                }
                return task.call();
              },
              Decoder.identity());

      if (nextCumulativeCrc32c != null) {
        long persistedSize = result.getPersistedSize();
        if (contentRange.endOffsetEquals(persistedSize) || result.getObject() != null) {
          resumableWrite.setCumulativeCrc32c(nextCumulativeCrc32c);
        } else if (contentRange instanceof HasRange) {
          ByteRangeSpec range = ((HasRange<?>) contentRange).range();
          content.rewindTo(0);
          long serverConsumedBytes = persistedSize - range.beginOffset();
          try (HashingGatheringByteChannel hashingChannel =
              new HashingGatheringByteChannel(serverConsumedBytes)) {
            StorageException.wrapIOException(() -> content.writeTo(hashingChannel));
            resumableWrite.setCumulativeCrc32c(
                resumableWrite.getHasher().nullSafeConcat(crc32cSoFar, hashingChannel.cumulative));
          }
        } else {
          throw new StorageException(
              0,
              String.format(
                  Locale.US,
                  "Result persistedSize (%d) did not match expected end of contentRange (%s) and"
                      + " contentRange does not have range to allow automatic recovery",
                  persistedSize,
                  contentRange));
        }
      }
      return result;
    } finally {
      httpRpcContext.clearInvocationId();
    }
  }

  private static final class HashingGatheringByteChannel implements GatheringByteChannel {
    private final long maxBytesToConsume;

    private Crc32cLengthKnown cumulative;

    private HashingGatheringByteChannel(long maxBytesToConsume) {
      this.maxBytesToConsume = maxBytesToConsume;
      this.cumulative = Crc32cValue.zero();
    }

    @Override
    public int write(ByteBuffer src) {
      return Math.toIntExact(write(new ByteBuffer[] {src}, 0, 1));
    }

    @Override
    public long write(ByteBuffer[] srcs) {
      return write(srcs, 0, srcs.length);
    }

    @Override
    public long write(ByteBuffer[] srcs, int offset, int length) {
      Crc32cLengthKnown cum = Crc32cValue.zero();
      for (int i = offset; i < length; i++) {
        long toConsume = maxBytesToConsume - cum.getLength();
        if (toConsume <= 0) {
          if (cum.getLength() == 0) {
            return -1;
          } else {
            break;
          }
        }

        ByteBuffer buf = srcs[i];
        if (buf.remaining() <= toConsume) {
          cum = cum.concat(Hasher.enabled().hash(buf));
        } else {
          ByteBuffer slice = buf.slice();
          int limit = Math.toIntExact(toConsume);
          slice.limit(limit);
          cum = cum.concat(Hasher.enabled().hash(slice));
          buf.position(buf.position() + limit);
        }
      }
      cumulative = cumulative.concat(cum);
      return cum.getLength();
    }

    @Override
    public boolean isOpen() {
      return true;
    }

    @Override
    public void close() {}
  }
}

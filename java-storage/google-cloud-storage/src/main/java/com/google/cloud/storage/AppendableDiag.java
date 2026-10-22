/*
 * Copyright 2026 Google LLC
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

import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DIAGNOSTIC ONLY (do not submit). Logs every message sent / received on appendable upload streams
 * so a CI run shows exactly where an upload waits.
 */
final class AppendableDiag {
  static final Logger LOG = LoggerFactory.getLogger("com.google.cloud.storage.DIAG");
  private static final AtomicLong IDS = new AtomicLong();

  private AppendableDiag() {}

  static long nextId() {
    return IDS.incrementAndGet();
  }

  /** Never throws: diagnostics must not change behavior (test stubs may not implement getters). */
  static Object safe(java.util.function.Supplier<?> s) {
    try {
      return s.get();
    } catch (Throwable t) {
      return "n/a";
    }
  }

  static String req(BidiWriteObjectRequest r) {
    StringBuilder sb = new StringBuilder();
    if (r.hasWriteObjectSpec()) {
      sb.append("spec=write(")
          .append(r.getWriteObjectSpec().getResource().getName())
          .append(", appendable=")
          .append(r.getWriteObjectSpec().getAppendable())
          .append(") ");
    } else if (r.hasAppendObjectSpec()) {
      sb.append("spec=append(")
          .append(r.getAppendObjectSpec().getObject())
          .append(", gen=")
          .append(r.getAppendObjectSpec().getGeneration())
          .append(", handle=")
          .append(r.getAppendObjectSpec().hasWriteHandle())
          .append(", routingToken=")
          .append(r.getAppendObjectSpec().hasRoutingToken())
          .append(") ");
    } else if (!r.getUploadId().isEmpty()) {
      sb.append("uploadId=").append(r.getUploadId()).append(' ');
    }
    sb.append("offset=").append(r.getWriteOffset());
    if (r.hasChecksummedData()) {
      sb.append(" data=").append(r.getChecksummedData().getContent().size());
    }
    sb.append(" flush=").append(r.getFlush());
    sb.append(" lookup=").append(r.getStateLookup());
    sb.append(" finish=").append(r.getFinishWrite());
    if (r.hasObjectChecksums()) {
      sb.append(" objectCrc32c=").append(r.getObjectChecksums().hasCrc32C());
    }
    return sb.toString();
  }

  static String resp(BidiWriteObjectResponse r) {
    StringBuilder sb = new StringBuilder();
    if (r.hasPersistedSize()) {
      sb.append("persistedSize=").append(r.getPersistedSize());
    }
    if (r.hasResource()) {
      sb.append("resource(size=")
          .append(r.getResource().getSize())
          .append(", gen=")
          .append(r.getResource().getGeneration())
          .append(", finalized=")
          .append(r.getResource().hasFinalizeTime())
          .append(")");
    }
    sb.append(" writeHandle=").append(r.hasWriteHandle());
    return sb.toString();
  }

  static String err(@Nullable Throwable t) {
    if (t == null) {
      return "null";
    }
    Status s = Status.fromThrowable(t);
    String msg = String.valueOf(t.getMessage());
    int nl = msg.indexOf('\n');
    if (nl > -1) {
      msg = msg.substring(0, nl);
    }
    return t.getClass().getSimpleName() + "(grpcStatus=" + s.getCode() + "): " + msg;
  }
}

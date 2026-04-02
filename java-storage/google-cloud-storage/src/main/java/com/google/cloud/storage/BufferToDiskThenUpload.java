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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.storage.RecoveryFileManager.RecoveryVolumeSinkFactory;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collector;
import javax.annotation.concurrent.Immutable;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;

/**
 * There are scenarios in which disk space is more plentiful than memory space. This new {@link
 * BlobWriteSessionConfig} allows augmenting an instance of storage to produce {@link
 * BlobWriteSession}s which will buffer to disk rather than holding things in memory.
 *
 * <p>Once the file on disk is closed, the entire file will then be uploaded to GCS.
 *
 * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
 * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
 * @see BlobWriteSessionConfigs#bufferToDiskThenUpload(Path)
 * @see BlobWriteSessionConfigs#bufferToDiskThenUpload(Collection)
 */
@Immutable
@BetaApi
@TransportCompatibility({Transport.GRPC, Transport.HTTP})
public final class BufferToDiskThenUpload extends BlobWriteSessionConfig
    implements BlobWriteSessionConfig.HttpCompatible, BlobWriteSessionConfig.GrpcCompatible {

  private static final long serialVersionUID = 9059242302276891867L;

  /**
   * non-final because of {@link java.io.Serializable}, however this field is effectively final as
   * it is immutable and there is not reference mutator method.
   */
  @MonotonicNonNull private transient ImmutableList<Path> paths;

  private final boolean includeLoggingSink;

  /** Used for {@link java.io.Serializable} */
  @MonotonicNonNull private volatile ArrayList<String> absolutePaths;

  @InternalApi
  BufferToDiskThenUpload(ImmutableList<Path> paths, boolean includeLoggingSink) throws IOException {
    this.paths = paths;
    this.includeLoggingSink = includeLoggingSink;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BufferToDiskThenUpload)) {
      return false;
    }
    BufferToDiskThenUpload that = (BufferToDiskThenUpload) o;
    return includeLoggingSink == that.includeLoggingSink
        && Objects.equals(paths, that.paths)
        && Objects.equals(absolutePaths, that.absolutePaths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paths, includeLoggingSink, absolutePaths);
  }

  @VisibleForTesting
  @InternalApi
  BufferToDiskThenUpload withIncludeLoggingSink() throws IOException {
    return new BufferToDiskThenUpload(paths, true);
  }

  @InternalApi
  @Override
  WriterFactory createFactory(Clock clock) throws IOException {
    Duration window = Duration.ofMinutes(10);
    RecoveryFileManager recoveryFileManager =
        RecoveryFileManager.of(paths, getRecoverVolumeSinkFactory(clock, window));
    ThroughputSink gcs = ThroughputSink.windowed(ThroughputMovingWindow.of(window), clock);
    gcs = includeLoggingSink ? ThroughputSink.tee(ThroughputSink.logged("gcs", clock), gcs) : gcs;
    return new Factory(recoveryFileManager, clock, gcs);
  }

  private RecoveryVolumeSinkFactory getRecoverVolumeSinkFactory(Clock clock, Duration window) {
    return path -> {
      ThroughputSink windowed = ThroughputSink.windowed(ThroughputMovingWindow.of(window), clock);
      if (includeLoggingSink) {
        return ThroughputSink.tee(
            ThroughputSink.logged(path.toAbsolutePath().toString(), clock), windowed);
      } else {
        return windowed;
      }
    };
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    if (absolutePaths == null) {
      synchronized (this) {
        if (absolutePaths == null) {
          absolutePaths =
              paths.stream()
                  .map(Path::toAbsolutePath)
                  .map(Path::toString)
                  .collect(
                      Collector.of(
                          ArrayList::new,
                          ArrayList::add,
                          (left, right) -> {
                            left.addAll(right);
                            return left;
                          }));
        }
      }
    }
    out.defaultWriteObject();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.paths = absolutePaths.stream().map(Paths::get).collect(ImmutableList.toImmutableList());
  }

  private static final class Factory implements WriterFactory {

    private final RecoveryFileManager recoveryFileManager;
    private final Clock clock;
    private final ThroughputSink gcs;

    private Factory(RecoveryFileManager recoveryFileManager, Clock clock, ThroughputSink gcs) {
      this.recoveryFileManager = recoveryFileManager;
      this.clock = clock;
      this.gcs = gcs;
    }

    @InternalApi
    @Override
    public WritableByteChannelSession<?, BlobInfo> writeSession(
        StorageInternal storage, BlobInfo info, Opts<ObjectTargetOpt> opts) {
      return new Factory.WriteToFileThenUpload(
          storage, info, opts, recoveryFileManager.newRecoveryFile(info));
    }

    private final class WriteToFileThenUpload
        implements WritableByteChannelSession<WritableByteChannel, BlobInfo> {

      private final StorageInternal storage;
      private final BlobInfo info;
      private final Opts<ObjectTargetOpt> opts;
      private final RecoveryFile rf;
      private final SettableApiFuture<BlobInfo> result;

      private WriteToFileThenUpload(
          StorageInternal storage, BlobInfo info, Opts<ObjectTargetOpt> opts, RecoveryFile rf) {
        this.info = info;
        this.opts = opts;
        this.rf = rf;
        this.storage = storage;
        this.result = SettableApiFuture.create();
      }

      @Override
      public ApiFuture<WritableByteChannel> openAsync() {
        try {
          ApiFuture<WritableByteChannel> f = ApiFutures.immediateFuture(rf.writer());
          return ApiFutures.transform(
              f, Factory.WriteToFileThenUpload.Flusher::new, MoreExecutors.directExecutor());
        } catch (IOException e) {
          throw StorageException.coalesce(e);
        }
      }

      @Override
      public ApiFuture<BlobInfo> getResult() {
        return result;
      }

      @SuppressWarnings("UnstableApiUsage")
      private final class Flusher implements WritableByteChannel {

        private final WritableByteChannel delegate;
        private final Hasher cumulativeCrc32c;
        private final ReentrantLock lock;

        private Flusher(WritableByteChannel delegate) {
          this.delegate = delegate;
          this.cumulativeCrc32c =
              opts.getHasher().initialValue() == null ? null : Hashing.crc32c().newHasher();
          this.lock = new ReentrantLock();
        }

        @Override
        public int write(ByteBuffer src) throws IOException {
          lock.lock();
          try {
            if (cumulativeCrc32c != null) {
              cumulativeCrc32c.putBytes(src.duplicate());
            }
            return delegate.write(src);
          } finally {
            lock.unlock();
          }
        }

        @Override
        public boolean isOpen() {
          lock.lock();
          try {
            return delegate.isOpen();
          } finally {
            lock.unlock();
          }
        }

        @Override
        public void close() throws IOException {
          lock.lock();
          try {

            delegate.close();
            try (RecoveryFile rf = Factory.WriteToFileThenUpload.this.rf) {
              Path path = rf.getPath();
              long size = Files.size(path);
              ThroughputSink.computeThroughput(
                  clock,
                  gcs,
                  size,
                  () -> {
                    BlobInfo pendingInfo = info;
                    Opts<ObjectTargetOpt> pendingOpts = opts;
                    if (cumulativeCrc32c != null) {
                      int hashCodeInt = cumulativeCrc32c.hash().asInt();
                      pendingInfo =
                          pendingInfo.toBuilder()
                              .clearMd5()
                              .clearCrc32c()
                              .setCrc32c(Utils.crc32cCodec.encode(hashCodeInt))
                              .build();
                      pendingOpts = opts.prepend(Opts.from(UnifiedOpts.crc32cMatch(hashCodeInt)));
                    }
                    BlobInfo blob = storage.internalCreateFrom(path, pendingInfo, pendingOpts);
                    result.set(blob);
                  });
            } catch (StorageException | IOException e) {
              result.setException(e);
              throw e;
            }
          } finally {
            lock.unlock();
          }
        }
      }
    }
  }
}

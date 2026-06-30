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
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.RecoveryFileManager.RecoveryVolumeSinkFactory;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.ThroughputSink.Record;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.storage.v2.ServiceConstants.Values;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collector;
import javax.annotation.concurrent.Immutable;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;

/**
 * There are scenarios in which disk space is more plentiful than memory space. This new {@link
 * BlobWriteSessionConfig} allows augmenting an instance of storage to produce {@link
 * BlobWriteSession}s which will buffer to disk rather than holding things in memory.
 *
 * <p>If we have disk available we can checkpoint the contents of an object to disk before
 * transmitting to GCS. The checkpointed data on disk allows arbitrary rewind in the case of failure
 * but allows the upload to happen as soon as the checkpoint ack is complete.
 *
 * <p>Due to the details of how Resumable Upload Sessions are implemented in the GCS gRPC API this
 * is possible. However, this approach will not work with the HTTP transports Resumable Upload
 * Session spec.
 *
 * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
 * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
 */
@Immutable
@BetaApi
@TransportCompatibility(Transport.GRPC)
public final class JournalingBlobWriteSessionConfig extends BlobWriteSessionConfig
    implements BlobWriteSessionConfig.GrpcCompatible {
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
  JournalingBlobWriteSessionConfig(ImmutableList<Path> paths, boolean includeLoggingSink) {
    this.paths = paths;
    this.includeLoggingSink = includeLoggingSink;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof JournalingBlobWriteSessionConfig)) {
      return false;
    }
    JournalingBlobWriteSessionConfig that = (JournalingBlobWriteSessionConfig) o;
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
  JournalingBlobWriteSessionConfig withIncludeLoggingSink() {
    return new JournalingBlobWriteSessionConfig(paths, true);
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
      if (storage instanceof GrpcStorageImpl) {
        GrpcStorageImpl grpcStorage = (GrpcStorageImpl) storage;
        RecoveryFile recoveryFile = recoveryFileManager.newRecoveryFile(info);
        GrpcCallContext grpcCallContext =
            opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
        ApiFuture<ResumableWrite> f =
            grpcStorage.startResumableWrite(
                grpcCallContext, grpcStorage.getWriteObjectRequest(info, opts), opts);
        ApiFuture<WriteCtx<ResumableWrite>> start =
            ApiFutures.transform(
                f, s -> WriteCtx.of(s, opts.getHasher()), MoreExecutors.directExecutor());

        ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write =
            grpcStorage.storageClient.writeObjectCallable().withDefaultCallContext(grpcCallContext);
        BufferedWritableByteChannelSession<WriteObjectResponse> session =
            ResumableMedia.gapic()
                .write()
                .byteChannel(write)
                .setHasher(opts.getHasher())
                .setByteStringStrategy(ByteStringStrategy.copy())
                .journaling()
                .withRetryConfig(
                    grpcStorage.retrier,
                    grpcStorage.retryAlgorithmManager.idempotent(),
                    grpcStorage.storageClient.queryWriteStatusCallable())
                .withBuffer(BufferHandle.allocate(Values.MAX_WRITE_CHUNK_BYTES_VALUE))
                .withRecoveryBuffer(BufferHandle.allocate(Values.MAX_WRITE_CHUNK_BYTES_VALUE))
                .withRecoveryFile(recoveryFile)
                .setStartAsync(start)
                .build();

        return new JournalingUpload<>(session, start);
      } else {
        return CrossTransportUtils.throwGrpcOnly(BlobWriteSessionConfigs.class, "journaling");
      }
    }

    private final class JournalingUpload<WBC extends WritableByteChannel>
        implements WritableByteChannelSession<WBC, BlobInfo> {

      private final WritableByteChannelSession<WBC, WriteObjectResponse> session;
      private final ApiFuture<WriteCtx<ResumableWrite>> start;
      private final Decoder<WriteObjectResponse, BlobInfo> decoder;

      public JournalingUpload(
          WritableByteChannelSession<WBC, WriteObjectResponse> session,
          ApiFuture<WriteCtx<ResumableWrite>> start) {
        this.session = session;
        this.start = start;
        this.decoder = Conversions.grpc().blobInfo().compose(WriteObjectResponse::getResource);
      }

      @Override
      public ApiFuture<WBC> openAsync() {
        // register a callback on the result future to record our throughput estimate
        Instant begin = clock.instant();
        ApiFutures.addCallback(
            session.getResult(),
            new ApiFutureCallback<WriteObjectResponse>() {
              @Override
              public void onFailure(Throwable t) {
                Instant end = clock.instant();
                // start MUST have completed in order for result to resolve, use the utility method
                // to take care of the checked exception handling
                WriteCtx<ResumableWrite> writeCtx =
                    ApiExceptions.callAndTranslateApiException(start);
                long totalSentBytes = writeCtx.getTotalSentBytes().get();
                gcs.recordThroughput(Record.of(totalSentBytes, begin, end, true));
              }

              @Override
              public void onSuccess(WriteObjectResponse result) {
                Instant end = clock.instant();
                long totalSentBytes = -1;
                if (result.hasResource()) {
                  totalSentBytes = result.getResource().getSize();
                } else if (result.hasPersistedSize()) {
                  totalSentBytes = result.getPersistedSize();
                }
                if (totalSentBytes > -1) {
                  gcs.recordThroughput(Record.of(totalSentBytes, begin, end, false));
                }
              }
            },
            MoreExecutors.directExecutor());
        return session.openAsync();
      }

      @Override
      public ApiFuture<BlobInfo> getResult() {
        return ApiFutures.transform(
            session.getResult(), decoder::decode, MoreExecutors.directExecutor());
      }
    }
  }
}

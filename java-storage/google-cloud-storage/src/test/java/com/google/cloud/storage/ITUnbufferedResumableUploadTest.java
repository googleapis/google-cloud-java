/*
 * Copyright 2024 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.ITUnbufferedResumableUploadTest.ObjectSizes;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.CrossRun.Exclude;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableList;
import com.google.storage.v2.Object;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import com.google.storage.v2.WriteObjectSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
@Parameterized(ObjectSizes.class)
public final class ITUnbufferedResumableUploadTest {

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Parameter public int objectSize;

  public static final class ObjectSizes implements ParametersProvider {

    @Override
    public ImmutableList<Integer> parameters() {
      return ImmutableList.of(256 * 1024, 2 * 1024 * 1024, 8 * 1024 * 1024);
    }
  }

  @Test
  @Exclude(transports = Transport.GRPC)
  public void json()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    UnbufferedWritableByteChannelSession<StorageObject> session = jsonSession();

    int additional = 13;
    long size = objectSize + additional;
    ByteBuffer b = DataGenerator.base64Characters().genByteBuffer(size);

    UnbufferedWritableByteChannel open = session.open();
    int written1 = open.write(b);
    assertThat(written1).isEqualTo(objectSize);
    assertThat(b.remaining()).isEqualTo(additional);

    // no bytes should be consumed if less than 256KiB
    int written2 = open.write(b);
    assertThat(written2).isEqualTo(0);
    assertThat(b.remaining()).isEqualTo(additional);

    int writtenAndClose = open.writeAndClose(b);
    assertThat(writtenAndClose).isEqualTo(additional);
    open.close();

    StorageObject storageObject = session.getResult().get(2, TimeUnit.SECONDS);
    assertThat(storageObject.getSize()).isEqualTo(BigInteger.valueOf(size));
  }

  @Test
  @Exclude(transports = Transport.HTTP)
  public void grpc() throws Exception {
    UnbufferedWritableByteChannelSession<WriteObjectResponse> session = grpcSession();

    int additional = 13;
    long size = objectSize + additional;
    ByteBuffer b = DataGenerator.base64Characters().genByteBuffer(size);

    UnbufferedWritableByteChannel open = session.open();
    int written1 = open.write(b);
    assertThat(written1).isEqualTo(objectSize);
    assertThat(b.remaining()).isEqualTo(additional);

    // no bytes should be consumed if less than 256KiB
    int written2 = open.write(b);
    assertThat(written2).isEqualTo(0);
    assertThat(b.remaining()).isEqualTo(additional);

    int writtenAndClose = open.writeAndClose(b);
    assertThat(writtenAndClose).isEqualTo(additional);
    open.close();
    WriteObjectResponse resp = session.getResult().get(2, TimeUnit.SECONDS);
    assertThat(resp.getResource().getSize()).isEqualTo(size);
  }

  @Test
  @Exclude(transports = Transport.GRPC)
  public void json_minFlush()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    UnbufferedWritableByteChannelSession<StorageObject> session = jsonSession();

    int additional = 13;
    long size = objectSize + additional;
    ByteBuffer b = DataGenerator.base64Characters().genByteBuffer(size);

    UnbufferedWritableByteChannel open = session.open();
    BufferHandle bufferHandle = BufferHandle.allocate(256 * 1024);
    MinFlushBufferedWritableByteChannel channel =
        new MinFlushBufferedWritableByteChannel(bufferHandle, open);
    int written1 = channel.write(b);
    assertThat(written1).isEqualTo(size);
    assertThat(bufferHandle.position()).isEqualTo(additional);

    channel.close();
    assertThat(bufferHandle.remaining()).isEqualTo(bufferHandle.capacity());

    StorageObject storageObject = session.getResult().get(2, TimeUnit.SECONDS);
    assertThat(storageObject.getSize()).isEqualTo(BigInteger.valueOf(size));
  }

  @Test
  @Exclude(transports = Transport.HTTP)
  public void grpc_minFlush() throws Exception {
    UnbufferedWritableByteChannelSession<WriteObjectResponse> session = grpcSession();

    int additional = 13;
    long size = objectSize + additional;
    ByteBuffer b = DataGenerator.base64Characters().genByteBuffer(size);

    UnbufferedWritableByteChannel open = session.open();
    BufferHandle bufferHandle = BufferHandle.allocate(256 * 1024);
    MinFlushBufferedWritableByteChannel channel =
        new MinFlushBufferedWritableByteChannel(bufferHandle, open);
    int written1 = channel.write(b);
    assertThat(written1).isEqualTo(size);
    assertThat(bufferHandle.position()).isEqualTo(additional);

    channel.close();
    assertThat(bufferHandle.remaining()).isEqualTo(bufferHandle.capacity());

    WriteObjectResponse resp = session.getResult().get(2, TimeUnit.SECONDS);
    assertThat(resp.getResource().getSize()).isEqualTo(size);
  }

  private UnbufferedWritableByteChannelSession<StorageObject> jsonSession() {
    BlobInfo blobInfo = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Opts<ObjectTargetOpt> opts = Opts.empty();
    final Map<StorageRpc.Option, ?> optionsMap = opts.getRpcOptions();
    BlobInfo.Builder builder = blobInfo.toBuilder().setMd5(null).setCrc32c(null);
    BlobInfo updated = opts.blobInfoMapper().apply(builder).build();

    StorageObject encode = Conversions.json().blobInfo().encode(updated);
    HttpStorageOptions options = (HttpStorageOptions) storage.getOptions();
    Retrier retrier = TestUtils.retrierFromStorageOptions(options);
    Supplier<String> uploadIdSupplier =
        ResumableMedia.startUploadForBlobInfo(
            options,
            updated,
            optionsMap,
            retrier.withAlg(
                StorageRetryStrategy.getUniformStorageRetryStrategy().getIdempotentHandler()));
    JsonResumableWrite jsonResumableWrite =
        JsonResumableWrite.of(encode, optionsMap, uploadIdSupplier.get(), 0);

    return ResumableMedia.http()
        .write()
        .byteChannel(HttpClientContext.from(options.getStorageRpcV1()))
        .resumable()
        .unbuffered()
        .setStartAsync(ApiFutures.immediateFuture(jsonResumableWrite))
        .build();
  }

  private UnbufferedWritableByteChannelSession<WriteObjectResponse> grpcSession() {
    BlobInfo blobInfo = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Opts<ObjectTargetOpt> opts = Opts.empty();
    BlobInfo.Builder builder = blobInfo.toBuilder().setMd5(null).setCrc32c(null);
    BlobInfo updated = opts.blobInfoMapper().apply(builder).build();

    Object object = Conversions.grpc().blobInfo().encode(updated);
    Object.Builder objectBuilder =
        object.toBuilder()
            // required if the data is changing
            .clearChecksums()
            // trimmed to shave payload size
            .clearGeneration()
            .clearMetageneration()
            .clearSize()
            .clearCreateTime()
            .clearUpdateTime();
    WriteObjectSpec.Builder specBuilder = WriteObjectSpec.newBuilder().setResource(objectBuilder);

    WriteObjectRequest.Builder requestBuilder =
        WriteObjectRequest.newBuilder().setWriteObjectSpec(specBuilder);

    WriteObjectRequest request = opts.writeObjectRequest().apply(requestBuilder).build();

    GrpcCallContext merge = Retrying.newCallContext();
    StorageClient storageClient = PackagePrivateMethodWorkarounds.maybeGetStorageClient(storage);
    assertThat(storageClient).isNotNull();
    ApiFuture<ResumableWrite> start =
        ResumableMedia.gapic()
            .write()
            .resumableWrite(
                storageClient.startResumableWriteCallable().withDefaultCallContext(merge),
                request,
                opts,
                RetrierWithAlg.attemptOnce());

    return ResumableMedia.gapic()
        .write()
        .byteChannel(storageClient.writeObjectCallable())
        .resumable()
        .unbuffered()
        .setStartAsync(start)
        .build();
  }
}

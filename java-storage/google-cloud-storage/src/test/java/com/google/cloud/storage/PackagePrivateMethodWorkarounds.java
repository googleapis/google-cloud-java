/*
 * Copyright 2021 Google LLC
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
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.OtelStorageDecorator.OtelDecoratedReadChannel;
import com.google.cloud.storage.OtelStorageDecorator.OtelDecoratedWriteChannel;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.MessageOrBuilder;
import com.google.storage.v2.StorageClient;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.annotation.Nullable;

/**
 * Several classes in the High Level Model for storage include package-local constructors and
 * methods. For conformance testing we don't want to exist in the com.google.cloud.storage package
 * to ensure we're interacting with the public api, however in a few select cases we need to change
 * the instance of {@link Storage} which an object holds on to. The utilities in this class allow us
 * to perform these operations.
 */
public final class PackagePrivateMethodWorkarounds {

  private PackagePrivateMethodWorkarounds() {}

  public static Bucket bucketCopyWithStorage(Bucket b, Storage s) {
    return b.asBucket(s);
  }

  public static Blob blobCopyWithStorage(Blob b, Storage s) {
    return b.asBlob(s);
  }

  public static Function<WriteChannel, Optional<BlobInfo>> maybeGetBlobInfoFunction() {
    return (w) -> {
      if (w instanceof OtelDecoratedWriteChannel) {
        OtelDecoratedWriteChannel odwc = (OtelDecoratedWriteChannel) w;
        w = odwc.delegate;
      }
      if (w instanceof BlobWriteChannelV2) {
        BlobWriteChannelV2 blobWriteChannel = (BlobWriteChannelV2) w;
        return Optional.ofNullable(blobWriteChannel.getResolvedObject())
            .map(Conversions.json().blobInfo()::decode);
      } else if (w instanceof GrpcBlobWriteChannel) {
        GrpcBlobWriteChannel grpcBlobWriteChannel = (GrpcBlobWriteChannel) w;
        return Optional.of(grpcBlobWriteChannel.getObject())
            .map(
                f -> {
                  try {
                    return f.get();
                  } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                  }
                });
      } else {
        return Optional.empty();
      }
    };
  }

  public static ApiFuture<BlobInfo> getBlobInfoFromReadChannelFunction(ReadChannel c) {
    if (c instanceof OtelDecoratedReadChannel) {
      OtelDecoratedReadChannel odrc = (OtelDecoratedReadChannel) c;
      c = odrc.reader;
    }
    if (c instanceof StorageReadChannel) {
      StorageReadChannel src = (StorageReadChannel) c;
      return src.getObject();
    }
    return ApiFutures.immediateFailedFuture(
        new IllegalStateException("Unsupported ReadChannel Type " + c.getClass().getName()));
  }

  @Nullable
  public static StorageClient maybeGetStorageClient(Storage s) {
    if (s instanceof GrpcStorageImpl) {
      return ((GrpcStorageImpl) s).storageClient;
    }
    // handle instances of AbstractStorageProxy
    Storage service = s.getOptions().getService();
    if (service instanceof OtelStorageDecorator) {
      OtelStorageDecorator osd = (OtelStorageDecorator) service;
      service = osd.delegate;
    }
    if (service instanceof GrpcStorageImpl) {
      return ((GrpcStorageImpl) service).storageClient;
    }
    return null;
  }

  @Nullable
  public static StorageDataClient maybeGetStorageDataClient(Storage s) {
    if (s instanceof GrpcStorageImpl) {
      return ((GrpcStorageImpl) s).storageDataClient;
    }
    // handle instances of AbstractStorageProxy
    Storage service = s.getOptions().getService();
    if (service instanceof OtelStorageDecorator) {
      OtelStorageDecorator osd = (OtelStorageDecorator) service;
      service = osd.delegate;
    }
    if (service instanceof GrpcStorageImpl) {
      return ((GrpcStorageImpl) service).storageDataClient;
    }
    return null;
  }

  public static <T> void ifNonNull(@Nullable T t, Consumer<T> c) {
    Utils.ifNonNull(t, c);
  }

  public static <T1, T2> void ifNonNull(@Nullable T1 t, Function<T1, T2> map, Consumer<T2> c) {
    Utils.ifNonNull(t, map, c);
  }

  public static BlobInfo noAcl(BlobInfo bi) {
    return bi.toBuilder().setOwner(null).setAcl(ImmutableList.of()).build();
  }

  public static String fmtProto(Object msg, Function<MessageOrBuilder, String> fmt) {
    return StorageV2ProtoUtils.fmtProtoWithFmt(msg, fmt::apply);
  }
}

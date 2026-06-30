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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.MetadataField.PartRange;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Clock;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import javax.annotation.concurrent.Immutable;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Immutable config builder to configure BlobWriteSession instances to perform Parallel Composite
 * Uploads.
 *
 * <p>Parallel Composite Uploads can yield higher throughput when uploading large objects. However,
 * there are some things which must be kept in mind when choosing to use this strategy.
 *
 * <ol>
 *   <li>Performing parallel composite uploads costs more money. <a
 *       href="https://cloud.google.com/storage/pricing#operations-by-class">Class A</a> operations
 *       are performed to create each part and to perform each compose. If a storage tier other than
 *       <a href="https://cloud.google.com/storage/docs/storage-classes"><code>STANDARD</code></a>
 *       is used, early deletion fees apply to deletion of the parts.
 *       <p>An illustrative example. Upload a 5GiB object using 64MiB as the max size per part. <br>
 *       <ol>
 *         <li>80 Parts will be created (Class A)
 *         <li>3 compose calls will be performed (Class A)
 *         <li>Delete 80 Parts along with 2 intermediary Compose objects (Free tier as long as
 *             {@code STANDARD} class)
 *       </ol>
 *       Once the parts and intermediary compose objects are deleted, there will be no storage
 *       charges related to those temporary objects.
 *   <li>The service account/credentials used to perform the parallel composite upload require <a
 *       href="https://cloud.google.com/storage/docs/access-control/iam-permissions#object_permissions">{@code
 *       storage.objects.delete}</a> in order to cleanup the temporary part and intermediary compose
 *       objects. <br>
 *       <i>To handle handle part and intermediary compose object deletion out of band</i> passing
 *       {@link PartCleanupStrategy#never()} to {@link
 *       ParallelCompositeUploadBlobWriteSessionConfig#withPartCleanupStrategy(PartCleanupStrategy)}
 *       will prevent automatic cleanup.
 *   <li>Please see the <a href="https://cloud.google.com/storage/docs/parallel-composite-uploads">
 *       Parallel composite uploads</a> documentation for a more in depth explanation of the
 *       limitations of Parallel composite uploads.
 *   <li>A failed upload can leave part and intermediary compose objects behind which will count as
 *       storage usage, and you will be billed for it. <br>
 *       By default if an upload fails, an attempt to cleanup the part and intermediary compose will
 *       be made. However if the program were to crash there is no means for the client to perform
 *       the cleanup. <br>
 *       Every part and intermediary compose object will be created with a name which ends in {@code
 *       .part}. An Object Lifecycle Management rule can be setup on your bucket to automatically
 *       cleanup objects with the suffix after some period of time. See <a
 *       href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a> for
 *       full details and a guide on how to setup a <a
 *       href="https://cloud.google.com/storage/docs/lifecycle#delete">Delete</a> rule with a <a
 *       href="https://cloud.google.com/storage/docs/lifecycle#matchesprefix-suffix">suffix
 *       match</a> condition.
 *   <li>Using parallel composite uploads are not a a one size fits all solution. They have very
 *       real overhead until uploading a large enough object. The inflection point is dependent upon
 *       many factors, and there is no one size fits all value. You will need to experiment with
 *       your deployment and workload to determine if parallel composite uploads are useful to you.
 * </ol>
 *
 * <p>In general if you object sizes are smaller than several hundred megabytes it is unlikely
 * parallel composite uploads will be beneficial to overall throughput.
 *
 * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
 * @see BlobWriteSessionConfigs#parallelCompositeUpload()
 * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
 * @see <a
 *     href="https://cloud.google.com/storage/docs/parallel-composite-uploads">https://cloud.google.com/storage/docs/parallel-composite-uploads</a>
 * @since 2.28.0 This new api is in preview and is subject to breaking changes.
 */
@Immutable
@BetaApi
@TransportCompatibility({Transport.GRPC, Transport.HTTP})
public final class ParallelCompositeUploadBlobWriteSessionConfig extends BlobWriteSessionConfig
    implements BlobWriteSessionConfig.HttpCompatible, BlobWriteSessionConfig.GrpcCompatible {

  private static final int MAX_PARTS_PER_COMPOSE = 32;
  private final int maxPartsPerCompose;
  private final ExecutorSupplier executorSupplier;
  private final BufferAllocationStrategy bufferAllocationStrategy;
  private final PartNamingStrategy partNamingStrategy;
  private final PartCleanupStrategy partCleanupStrategy;
  private final PartMetadataFieldDecorator partMetadataFieldDecorator;

  private ParallelCompositeUploadBlobWriteSessionConfig(
      int maxPartsPerCompose,
      ExecutorSupplier executorSupplier,
      BufferAllocationStrategy bufferAllocationStrategy,
      PartNamingStrategy partNamingStrategy,
      PartCleanupStrategy partCleanupStrategy,
      PartMetadataFieldDecorator partMetadataFieldDecorator) {
    this.maxPartsPerCompose = maxPartsPerCompose;
    this.executorSupplier = executorSupplier;
    this.bufferAllocationStrategy = bufferAllocationStrategy;
    this.partNamingStrategy = partNamingStrategy;
    this.partCleanupStrategy = partCleanupStrategy;
    this.partMetadataFieldDecorator = partMetadataFieldDecorator;
  }

  @InternalApi
  ParallelCompositeUploadBlobWriteSessionConfig withMaxPartsPerCompose(int maxPartsPerCompose) {
    checkArgument(
        2 <= maxPartsPerCompose && maxPartsPerCompose <= 32,
        "2 <= maxPartsPerCompose <= 32 (2 <= %s <= 32)",
        maxPartsPerCompose);
    return new ParallelCompositeUploadBlobWriteSessionConfig(
        maxPartsPerCompose,
        executorSupplier,
        bufferAllocationStrategy,
        partNamingStrategy,
        partCleanupStrategy,
        partMetadataFieldDecorator);
  }

  /**
   * Specify a specific executor supplier where work will be submitted when performing a parallel
   * composite upload.
   *
   * <p><i>Default: </i> {@link ExecutorSupplier#cachedPool()}
   *
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public ParallelCompositeUploadBlobWriteSessionConfig withExecutorSupplier(
      ExecutorSupplier executorSupplier) {
    checkNotNull(executorSupplier, "executorSupplier must be non null");
    return new ParallelCompositeUploadBlobWriteSessionConfig(
        maxPartsPerCompose,
        executorSupplier,
        bufferAllocationStrategy,
        partNamingStrategy,
        partCleanupStrategy,
        partMetadataFieldDecorator);
  }

  /**
   * Specify a specific buffering strategy which will dictate how buffers are allocated and used
   * when performing a parallel composite upload.
   *
   * <p><i>Default: </i> {@link BufferAllocationStrategy#simple(int)
   * BufferAllocationStrategy#simple(16MiB)}
   *
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public ParallelCompositeUploadBlobWriteSessionConfig withBufferAllocationStrategy(
      BufferAllocationStrategy bufferAllocationStrategy) {
    checkNotNull(bufferAllocationStrategy, "bufferAllocationStrategy must be non null");
    return new ParallelCompositeUploadBlobWriteSessionConfig(
        maxPartsPerCompose,
        executorSupplier,
        bufferAllocationStrategy,
        partNamingStrategy,
        partCleanupStrategy,
        partMetadataFieldDecorator);
  }

  /**
   * Specify a specific naming strategy which will dictate how individual part and intermediary
   * compose objects will be named when performing a parallel composite upload.
   *
   * <p><i>Default: </i> {@link PartNamingStrategy#noPrefix()}
   *
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public ParallelCompositeUploadBlobWriteSessionConfig withPartNamingStrategy(
      PartNamingStrategy partNamingStrategy) {
    checkNotNull(partNamingStrategy, "partNamingStrategy must be non null");
    return new ParallelCompositeUploadBlobWriteSessionConfig(
        maxPartsPerCompose,
        executorSupplier,
        bufferAllocationStrategy,
        partNamingStrategy,
        partCleanupStrategy,
        partMetadataFieldDecorator);
  }

  /**
   * Specify a specific cleanup strategy which will dictate what cleanup operations are performed
   * automatically when performing a parallel composite upload.
   *
   * <p><i>Default: </i> {@link PartCleanupStrategy#always()}
   *
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public ParallelCompositeUploadBlobWriteSessionConfig withPartCleanupStrategy(
      PartCleanupStrategy partCleanupStrategy) {
    checkNotNull(partCleanupStrategy, "partCleanupStrategy must be non null");
    return new ParallelCompositeUploadBlobWriteSessionConfig(
        maxPartsPerCompose,
        executorSupplier,
        bufferAllocationStrategy,
        partNamingStrategy,
        partCleanupStrategy,
        partMetadataFieldDecorator);
  }

  /**
   * Specify a Part Metadata Field decorator, this will manipulate the metadata associated with part
   * objects, the ultimate object metadata will remain unchanged.
   *
   * <p><i>Default: </i> {@link PartMetadataFieldDecorator#noOp()}
   *
   * @since 2.36.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public ParallelCompositeUploadBlobWriteSessionConfig withPartMetadataFieldDecorator(
      PartMetadataFieldDecorator partMetadataFieldDecorator) {
    checkNotNull(partMetadataFieldDecorator, "partMetadataFieldDecorator must be non null");
    return new ParallelCompositeUploadBlobWriteSessionConfig(
        maxPartsPerCompose,
        executorSupplier,
        bufferAllocationStrategy,
        partNamingStrategy,
        partCleanupStrategy,
        partMetadataFieldDecorator);
  }

  @BetaApi
  static ParallelCompositeUploadBlobWriteSessionConfig withDefaults() {
    return new ParallelCompositeUploadBlobWriteSessionConfig(
        MAX_PARTS_PER_COMPOSE,
        ExecutorSupplier.cachedPool(),
        BufferAllocationStrategy.simple(ByteSizeConstants._16MiB),
        PartNamingStrategy.noPrefix(),
        PartCleanupStrategy.always(),
        PartMetadataFieldDecorator.noOp());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ParallelCompositeUploadBlobWriteSessionConfig)) {
      return false;
    }
    ParallelCompositeUploadBlobWriteSessionConfig that =
        (ParallelCompositeUploadBlobWriteSessionConfig) o;
    return maxPartsPerCompose == that.maxPartsPerCompose
        && Objects.equals(executorSupplier, that.executorSupplier)
        && Objects.equals(bufferAllocationStrategy, that.bufferAllocationStrategy)
        && Objects.equals(partNamingStrategy, that.partNamingStrategy)
        && Objects.equals(partCleanupStrategy, that.partCleanupStrategy)
        && Objects.equals(partMetadataFieldDecorator, that.partMetadataFieldDecorator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        maxPartsPerCompose,
        executorSupplier,
        bufferAllocationStrategy,
        partNamingStrategy,
        partCleanupStrategy,
        partMetadataFieldDecorator);
  }

  @InternalApi
  @Override
  WriterFactory createFactory(Clock clock) throws IOException {
    Executor executor = executorSupplier.get();
    BufferHandlePool bufferHandlePool = bufferAllocationStrategy.get();
    PartMetadataFieldDecoratorInstance partMetadataFieldDecoratorInstance =
        partMetadataFieldDecorator.newInstance(clock);
    return new ParallelCompositeUploadWriterFactory(
        clock, executor, bufferHandlePool, partMetadataFieldDecoratorInstance);
  }

  /**
   * A strategy which dictates how buffers are to be used for individual parts. The chosen strategy
   * will apply to all instances of {@link BlobWriteSession} created from a single instance of
   * {@link Storage}.
   *
   * @see #withBufferAllocationStrategy(BufferAllocationStrategy)
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @Immutable
  public abstract static class BufferAllocationStrategy extends Factory<BufferHandlePool>
      implements Serializable {

    private BufferAllocationStrategy() {}

    /**
     * Create a buffer strategy which will rely upon standard garbage collection. Each buffer will
     * be used once and then garbage collected.
     *
     * @param capacity the number of bytes each buffer should be
     * @see #withBufferAllocationStrategy(BufferAllocationStrategy)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static BufferAllocationStrategy simple(int capacity) {
      checkArgument(capacity > 0, "bufferCapacity must be > 0");
      return new SimpleBufferAllocationStrategy(capacity);
    }

    /**
     * Create a buffer strategy which will have a fixed size pool of buffers. Each buffer will be
     * lazily allocated.
     *
     * @param bufferCount the number of buffers the pool will be
     * @param bufferCapacity the number of bytes each buffer should be
     * @see #withBufferAllocationStrategy(BufferAllocationStrategy)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static BufferAllocationStrategy fixedPool(int bufferCount, int bufferCapacity) {
      checkArgument(bufferCount > 0, "bufferCount must be > 0");
      checkArgument(bufferCapacity > 0, "bufferCapacity must be > 0");
      return new FixedPoolBufferAllocationStrategy(bufferCount, bufferCapacity);
    }

    private static class SimpleBufferAllocationStrategy extends BufferAllocationStrategy {
      private static final long serialVersionUID = 8884826090481043434L;

      private final int capacity;

      private SimpleBufferAllocationStrategy(int capacity) {
        this.capacity = capacity;
      }

      @Override
      BufferHandlePool get() {
        return BufferHandlePool.simple(capacity);
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof SimpleBufferAllocationStrategy)) {
          return false;
        }
        SimpleBufferAllocationStrategy that = (SimpleBufferAllocationStrategy) o;
        return capacity == that.capacity;
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(capacity);
      }
    }

    private static class FixedPoolBufferAllocationStrategy extends BufferAllocationStrategy {
      private static final long serialVersionUID = 3288902741819257066L;

      private final int bufferCount;
      private final int bufferCapacity;

      private FixedPoolBufferAllocationStrategy(int bufferCount, int bufferCapacity) {
        this.bufferCount = bufferCount;
        this.bufferCapacity = bufferCapacity;
      }

      @Override
      BufferHandlePool get() {
        return BufferHandlePool.fixedPool(bufferCount, bufferCapacity);
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof FixedPoolBufferAllocationStrategy)) {
          return false;
        }
        FixedPoolBufferAllocationStrategy that = (FixedPoolBufferAllocationStrategy) o;
        return bufferCount == that.bufferCount && bufferCapacity == that.bufferCapacity;
      }

      @Override
      public int hashCode() {
        return Objects.hash(bufferCount, bufferCapacity);
      }
    }
  }

  /**
   * Class which will be used to supply an Executor where work will be submitted when performing a
   * parallel composite upload.
   *
   * @see #withExecutorSupplier(ExecutorSupplier)
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @Immutable
  public abstract static class ExecutorSupplier extends Factory<Executor> implements Serializable {
    private static final AtomicInteger INSTANCE_COUNTER = new AtomicInteger(1);

    private ExecutorSupplier() {}

    /**
     * Create a cached thread pool for submitting work
     *
     * @see #withExecutorSupplier(ExecutorSupplier)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static ExecutorSupplier cachedPool() {
      return CachedSupplier.INSTANCE;
    }

    /**
     * Create a fixed size thread pool for submitting work
     *
     * @param poolSize the number of threads in the pool
     * @see #withExecutorSupplier(ExecutorSupplier)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static ExecutorSupplier fixedPool(int poolSize) {
      checkArgument(poolSize > 0, "poolSize must be > 0");
      return new FixedSupplier(poolSize);
    }

    /**
     * Wrap an existing executor instance which will be used for submitting work
     *
     * <p><b><i>Choosing to use this supplier type will make your instance of {@link StorageOptions}
     * unable to be serialized.</i></b>
     *
     * @param executor the executor to use
     * @see #withExecutorSupplier(ExecutorSupplier)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static ExecutorSupplier useExecutor(Executor executor) {
      requireNonNull(executor, "executor must be non null");
      return new SuppliedExecutorSupplier(executor);
    }

    @NonNull
    private static ThreadFactory newThreadFactory() {
      return new ThreadFactoryBuilder()
          .setDaemon(true)
          .setNameFormat("c.g.c:g-c-s:pcu-" + INSTANCE_COUNTER.getAndIncrement() + "-%d")
          .build();
    }

    private static class SuppliedExecutorSupplier extends ExecutorSupplier {

      private final Executor executor;

      public SuppliedExecutorSupplier(Executor executor) {
        this.executor = executor;
      }

      @Override
      Executor get() {
        return executor;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof SuppliedExecutorSupplier)) {
          return false;
        }
        SuppliedExecutorSupplier that = (SuppliedExecutorSupplier) o;
        return Objects.equals(executor, that.executor);
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(executor);
      }

      private void writeObject(ObjectOutputStream out) throws IOException {
        throw new java.io.InvalidClassException(this.getClass().getName() + "; Not serializable");
      }
    }

    private static class CachedSupplier extends ExecutorSupplier implements Serializable {
      private static final long serialVersionUID = 7768210719775319260L;
      private static final CachedSupplier INSTANCE = new CachedSupplier();

      @Override
      Executor get() {
        ThreadFactory threadFactory = newThreadFactory();
        return Executors.newCachedThreadPool(threadFactory);
      }

      /** prevent java serialization from using a new instance */
      private Object readResolve() {
        return INSTANCE;
      }
    }

    private static class FixedSupplier extends ExecutorSupplier implements Serializable {
      private static final long serialVersionUID = 7771825977551614347L;

      private final int poolSize;

      public FixedSupplier(int poolSize) {
        this.poolSize = poolSize;
      }

      @Override
      Executor get() {
        ThreadFactory threadFactory = newThreadFactory();
        return Executors.newFixedThreadPool(poolSize, threadFactory);
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof FixedSupplier)) {
          return false;
        }
        FixedSupplier that = (FixedSupplier) o;
        return poolSize == that.poolSize;
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(poolSize);
      }
    }
  }

  /**
   * A naming strategy which will be used to generate a name for a part or intermediary compose
   * object.
   *
   * @see #withPartNamingStrategy(PartNamingStrategy)
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @Immutable
  public abstract static class PartNamingStrategy implements Serializable {
    private static final long serialVersionUID = 8343436026774231869L;
    private static final String FIELD_SEPARATOR = ";";
    private static final Encoder B64 = Base64.getUrlEncoder().withoutPadding();
    private static final HashFunction OBJECT_NAME_HASH_FUNCTION = Hashing.goodFastHash(128);
    private final SecureRandom rand;

    @VisibleForTesting
    @InternalApi
    PartNamingStrategy(SecureRandom rand) {
      this.rand = rand;
    }

    String fmtName(String ultimateObjectName, PartRange partRange) {
      // generate 128 bits of random data
      byte[] bytes = new byte[16];
      rand.nextBytes(bytes);

      // encode it to base 64, yielding 22 characters
      String randomKey = B64.encodeToString(bytes);
      return fmtFields(randomKey, ultimateObjectName, partRange.encode());
    }

    abstract String fmtFields(String randomKey, String nameDigest, String partRange);

    /**
     * Default strategy in which no stable prefix is defined.
     *
     * <p>General format is
     *
     * <pre><code>
     *   {randomKeyDigest};{objectInfoDigest};{partIndex}.part
     * </code></pre>
     *
     * <p>{@code {objectInfoDigest}} will be fixed for an individual {@link BlobWriteSession}.
     *
     * <p><b><i>NOTE:</i></b>The way in which both {@code randomKeyDigest} and {@code
     * objectInfoDigest} are generated is undefined and subject to change at any time.
     *
     * @see #withPartNamingStrategy(PartNamingStrategy)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static PartNamingStrategy noPrefix() {
      SecureRandom rand = new SecureRandom();
      return new NoPrefix(rand);
    }

    /**
     * Strategy in which an explicit stable prefix is present on each part and intermediary compose
     * object.
     *
     * <p>General format is
     *
     * <pre><code>
     *   {prefixPattern}/{randomKeyDigest};{objectInfoDigest};{partIndex}.part
     * </code></pre>
     *
     * <p>{@code {objectInfoDigest}} will be fixed for an individual {@link BlobWriteSession}.
     *
     * <p><b><i>NOTE:</i></b>The way in which both {@code randomKeyDigest} and {@code
     * objectInfoDigest} are generated is undefined and subject to change at any time.
     *
     * <p>Care must be taken when choosing to specify a stable prefix as this can create hotspots in
     * the keyspace for object names. See <a
     * href="https://cloud.google.com/storage/docs/request-rate#naming-convention">Object Naming
     * Convention Guidelines</a> for more details.
     *
     * @see #withPartNamingStrategy(PartNamingStrategy)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static PartNamingStrategy prefix(String prefixPattern) {
      checkNotNull(prefixPattern, "prefixPattern must be non null");
      SecureRandom rand = new SecureRandom();
      return new WithPrefix(rand, prefixPattern);
    }

    /**
     * Strategy in which the end object name is the prefix included and is present on each part and
     * intermediary compose object.
     *
     * <p>General format is
     *
     * <pre><code>
     *   {objectName}-{randomKeyDigest};{objectInfoDigest};{partIndex}.part
     * </code></pre>
     *
     * <p>{@code {objectInfoDigest}} will be fixed for an individual {@link BlobWriteSession}.
     *
     * <p><b><i>NOTE:</i></b>The way in which both {@code randomKeyDigest} and {@code
     * objectInfoDigest} are generated is undefined and subject to change at any time.
     *
     * @see #withPartNamingStrategy(PartNamingStrategy)
     * @since 2.30.2 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static PartNamingStrategy useObjectNameAsPrefix() {
      return useObjectNameAsPrefix("");
    }

    private static PartNamingStrategy useObjectNameAsPrefix(String prefixPattern) {
      checkNotNull(prefixPattern, "prefixPattern must be non null");
      SecureRandom rand = new SecureRandom();
      return new WithObjectLevelPrefix(rand, prefixPattern);
    }

    static final class WithPrefix extends PartNamingStrategy {
      private static final long serialVersionUID = 5709330763161570411L;

      private final String prefix;

      private WithPrefix(SecureRandom rand, String prefix) {
        super(rand);
        this.prefix = prefix;
      }

      @Override
      protected String fmtFields(String randomKey, String ultimateObjectName, String partRange) {
        HashCode hashCode =
            OBJECT_NAME_HASH_FUNCTION.hashString(ultimateObjectName, StandardCharsets.UTF_8);
        String nameDigest = B64.encodeToString(hashCode.asBytes());
        return prefix
            + "/"
            + randomKey
            + FIELD_SEPARATOR
            + nameDigest
            + FIELD_SEPARATOR
            + partRange
            + ".part";
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof WithPrefix)) {
          return false;
        }
        WithPrefix that = (WithPrefix) o;
        return Objects.equals(prefix, that.prefix);
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(prefix);
      }
    }

    static final class WithObjectLevelPrefix extends PartNamingStrategy {

      private static final long serialVersionUID = 5157942020618764450L;
      private final String prefix;

      private WithObjectLevelPrefix(SecureRandom rand, String prefix) {
        super(rand);
        // If no prefix is specified we will create the part files under the same directory as the
        // ultimate object.
        this.prefix = prefix.isEmpty() ? prefix : prefix + "/";
      }

      @Override
      protected String fmtFields(String randomKey, String ultimateObjectName, String partRange) {
        HashCode hashCode =
            OBJECT_NAME_HASH_FUNCTION.hashString(ultimateObjectName, StandardCharsets.UTF_8);
        String nameDigest = B64.encodeToString(hashCode.asBytes());
        return prefix
            + ultimateObjectName
            + "-"
            + randomKey
            + FIELD_SEPARATOR
            + nameDigest
            + FIELD_SEPARATOR
            + partRange
            + ".part";
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof WithObjectLevelPrefix)) {
          return false;
        }
        WithObjectLevelPrefix that = (WithObjectLevelPrefix) o;
        return Objects.equals(prefix, that.prefix);
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(prefix);
      }
    }

    static final class NoPrefix extends PartNamingStrategy {
      private static final long serialVersionUID = 5202415556658566017L;

      public NoPrefix(SecureRandom rand) {
        super(rand);
      }

      @Override
      protected String fmtFields(String randomKey, String ultimateObjectName, String partRange) {
        HashCode hashCode =
            OBJECT_NAME_HASH_FUNCTION.hashString(ultimateObjectName, StandardCharsets.UTF_8);
        String nameDigest = B64.encodeToString(hashCode.asBytes());
        return randomKey
            + FIELD_SEPARATOR
            // todo: do we want to
            // include a hint where the object came from, similar to gcloud
            // https://cloud.google.com/storage/docs/parallel-composite-uploads#gcloud-pcu
            // + "com.google.cloud:google-cloud-storage"
            // + FIELD_SEPARATOR
            + nameDigest
            + FIELD_SEPARATOR
            + partRange
            + ".part";
      }
    }
  }

  /**
   * A Decorator which is used to manipulate metadata fields, specifically on the part objects
   * created in a Parallel Composite Upload
   *
   * @see #withPartMetadataFieldDecorator(PartMetadataFieldDecorator)
   * @since 2.36.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @Immutable
  public abstract static class PartMetadataFieldDecorator implements Serializable {

    abstract PartMetadataFieldDecoratorInstance newInstance(Clock clock);

    /**
     * A decorator that is used to manipulate the Custom Time Metadata field of part files. {@link
     * BlobInfo#getCustomTimeOffsetDateTime()}
     *
     * <p>When provided with a duration, a time in the future will be calculated for each part
     * object upon upload, this new value can be used in OLM rules to cleanup abandoned part files.
     *
     * <p>See [CustomTime OLM
     * documentation](https://cloud.google.com/storage/docs/lifecycle#dayssincecustomtime)
     *
     * @see #withPartMetadataFieldDecorator(PartMetadataFieldDecorator)
     * @since 2.36.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static PartMetadataFieldDecorator setCustomTimeInFuture(Duration timeInFuture) {
      checkNotNull(timeInFuture, "timeInFuture must not be null");
      return new CustomTimeInFuture(timeInFuture);
    }

    @BetaApi
    public static PartMetadataFieldDecorator noOp() {
      return NoOp.INSTANCE;
    }

    @BetaApi
    private static final class CustomTimeInFuture extends PartMetadataFieldDecorator {
      private static final long serialVersionUID = -6213742554954751892L;
      private final Duration duration;

      CustomTimeInFuture(Duration duration) {
        this.duration = duration;
      }

      @Override
      PartMetadataFieldDecoratorInstance newInstance(Clock clock) {
        return builder -> {
          OffsetDateTime futureTime =
              OffsetDateTime.from(
                  clock.instant().plus(duration).atZone(clock.getZone()).toOffsetDateTime());
          return builder.setCustomTimeOffsetDateTime(futureTime);
        };
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof CustomTimeInFuture)) {
          return false;
        }
        CustomTimeInFuture that = (CustomTimeInFuture) o;
        return Objects.equals(duration, that.duration);
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(duration);
      }
    }

    private static final class NoOp extends PartMetadataFieldDecorator {
      private static final long serialVersionUID = -4569486383992999205L;
      private static final NoOp INSTANCE = new NoOp();

      @Override
      PartMetadataFieldDecoratorInstance newInstance(Clock clock) {
        return builder -> builder;
      }

      /** prevent java serialization from using a new instance */
      private Object readResolve() {
        return INSTANCE;
      }
    }
  }

  /**
   * A cleanup strategy which will dictate what cleanup operations are performed automatically when
   * performing a parallel composite upload.
   *
   * @see #withPartCleanupStrategy(PartCleanupStrategy)
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @Immutable
  public static class PartCleanupStrategy implements Serializable {
    private static final long serialVersionUID = -1434253614347199051L;
    private final boolean deletePartsOnSuccess;
    private final boolean deleteAllOnError;

    private PartCleanupStrategy(boolean deletePartsOnSuccess, boolean deleteAllOnError) {
      this.deletePartsOnSuccess = deletePartsOnSuccess;
      this.deleteAllOnError = deleteAllOnError;
    }

    boolean isDeletePartsOnSuccess() {
      return deletePartsOnSuccess;
    }

    boolean isDeleteAllOnError() {
      return deleteAllOnError;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof PartCleanupStrategy)) {
        return false;
      }
      PartCleanupStrategy that = (PartCleanupStrategy) o;
      return deletePartsOnSuccess == that.deletePartsOnSuccess
          && deleteAllOnError == that.deleteAllOnError;
    }

    @Override
    public int hashCode() {
      return Objects.hash(deletePartsOnSuccess, deleteAllOnError);
    }

    /**
     * If an unrecoverable error is encountered, define whether to attempt to delete any objects
     * already uploaded.
     *
     * <p><i>Default:</i> {@code true}
     *
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    PartCleanupStrategy withDeleteAllOnError(boolean deleteAllOnError) {
      return new PartCleanupStrategy(deletePartsOnSuccess, deleteAllOnError);
    }

    /**
     * Cleanup strategy which will always attempt to clean up part and intermediary compose objects
     * either on success or on error.
     *
     * @see #withPartCleanupStrategy(PartCleanupStrategy)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static PartCleanupStrategy always() {
      return new PartCleanupStrategy(true, true);
    }

    /**
     * Cleanup strategy which will only attempt to clean up parts and intermediary compose objects
     * either on success.
     *
     * @see #withPartCleanupStrategy(PartCleanupStrategy)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static PartCleanupStrategy onlyOnSuccess() {
      return new PartCleanupStrategy(true, false);
    }

    /**
     * Cleanup strategy which will never attempt to clean up parts or intermediary compose objects
     * either on success or on error.
     *
     * @see #withPartCleanupStrategy(PartCleanupStrategy)
     * @since 2.28.0 This new api is in preview and is subject to breaking changes.
     */
    @BetaApi
    public static PartCleanupStrategy never() {
      return new PartCleanupStrategy(false, false);
    }
  }

  interface PartMetadataFieldDecoratorInstance extends UnaryOperator<BlobInfo.Builder> {}

  private abstract static class Factory<T> implements Serializable {
    private static final long serialVersionUID = 271806144227661056L;

    private Factory() {}

    abstract T get();
  }

  private class ParallelCompositeUploadWriterFactory implements WriterFactory {

    private final Clock clock;
    private final Executor executor;
    private final BufferHandlePool bufferHandlePool;
    private final PartMetadataFieldDecoratorInstance partMetadataFieldDecoratorInstance;

    private ParallelCompositeUploadWriterFactory(
        Clock clock,
        Executor executor,
        BufferHandlePool bufferHandlePool,
        PartMetadataFieldDecoratorInstance partMetadataFieldDecoratorInstance) {
      this.clock = clock;
      this.executor = executor;
      this.bufferHandlePool = bufferHandlePool;
      this.partMetadataFieldDecoratorInstance = partMetadataFieldDecoratorInstance;
    }

    @Override
    public WritableByteChannelSession<?, BlobInfo> writeSession(
        StorageInternal s, BlobInfo info, Opts<ObjectTargetOpt> opts) {
      // if crc32cMatch or md5Match were specified, they will already be in opts
      BlobInfo trimmed = info.toBuilder().clearCrc32c().clearMd5().build();
      return new PCUSession(s, trimmed, opts);
    }

    private final class PCUSession
        implements WritableByteChannelSession<BufferedWritableByteChannel, BlobInfo> {

      private final SettableApiFuture<BlobInfo> result;
      private final StorageInternal storageInternal;
      private final BlobInfo info;
      private final Opts<ObjectTargetOpt> opts;

      private PCUSession(
          StorageInternal storageInternal, BlobInfo info, Opts<ObjectTargetOpt> opts) {
        this.storageInternal = storageInternal;
        this.info = info;
        this.opts = opts;
        result = SettableApiFuture.create();
      }

      @Override
      public ApiFuture<BufferedWritableByteChannel> openAsync() {
        ParallelCompositeUploadWritableByteChannel channel =
            new ParallelCompositeUploadWritableByteChannel(
                bufferHandlePool,
                executor,
                partNamingStrategy,
                partCleanupStrategy,
                maxPartsPerCompose,
                partMetadataFieldDecoratorInstance,
                result,
                storageInternal,
                info,
                opts);
        return ApiFutures.immediateFuture(
            StorageByteChannels.writable().createSynchronized(channel));
      }

      @Override
      public ApiFuture<BlobInfo> getResult() {
        return result;
      }
    }
  }
}

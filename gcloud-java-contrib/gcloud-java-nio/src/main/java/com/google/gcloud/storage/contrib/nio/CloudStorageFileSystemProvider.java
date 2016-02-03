package com.google.gcloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.base.Suppliers.memoize;
import static com.google.gcloud.storage.contrib.nio.CloudStorageFileSystem.URI_SCHEME;
import static com.google.gcloud.storage.contrib.nio.CloudStorageUtil.buildFileOptions;
import static com.google.gcloud.storage.contrib.nio.CloudStorageUtil.checkBucket;
import static com.google.gcloud.storage.contrib.nio.CloudStorageUtil.checkNotNullArray;
import static com.google.gcloud.storage.contrib.nio.CloudStorageUtil.checkPath;
import static com.google.gcloud.storage.contrib.nio.CloudStorageUtil.copyFileOptions;
import static com.google.gcloud.storage.contrib.nio.CloudStorageUtil.stripPathFromUri;

import com.google.appengine.tools.cloudstorage.GcsFileMetadata;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsInputChannel;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.auto.service.AutoService;
import com.google.common.base.MoreObjects;
import com.google.common.base.Supplier;
import com.google.common.primitives.Ints;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/** Google Cloud Storage {@link FileSystemProvider} */
@ThreadSafe
@AutoService(FileSystemProvider.class)
public final class CloudStorageFileSystemProvider extends FileSystemProvider {

  private static final Supplier<GcsService> gcsServiceSupplier =
      memoize(new Supplier<GcsService>() {
        @Override
        public GcsService get() {
          return GcsServiceFactory.createGcsService();
        }});

  private final GcsService gcsService;

  /**
   * Default constructor which should only be called by Java SPI.
   *
   * @see java.nio.file.FileSystems#getFileSystem(URI)
   * @see CloudStorageFileSystem#forBucket(String)
   */
  public CloudStorageFileSystemProvider() {
    this(gcsServiceSupplier.get());
  }

  private CloudStorageFileSystemProvider(GcsService gcsService) {
    this.gcsService = checkNotNull(gcsService);
  }

  GcsService getGcsService() {
    return gcsService;
  }

  @Override
  public String getScheme() {
    return URI_SCHEME;
  }

  /** Returns cloud storage file system, provided a URI with no path, e.g. {@code gs://bucket} */
  @Override
  public CloudStorageFileSystem getFileSystem(URI uri) {
    return newFileSystem(uri, Collections.<String, Object>emptyMap());
  }

  /** Returns cloud storage file system, provided a URI with no path, e.g. {@code gs://bucket} */
  @Override
  public CloudStorageFileSystem newFileSystem(URI uri, Map<String, ?> env) {
    checkArgument(uri.getScheme().equalsIgnoreCase(URI_SCHEME),
        "Cloud Storage URIs must have '%s' scheme: %s", URI_SCHEME, uri);
    checkArgument(!isNullOrEmpty(uri.getHost()),
        "%s:// URIs must have a host: %s", URI_SCHEME, uri);
    checkArgument(uri.getPort() == -1
        && isNullOrEmpty(uri.getPath())
        && isNullOrEmpty(uri.getQuery())
        && isNullOrEmpty(uri.getFragment())
        && isNullOrEmpty(uri.getUserInfo()),
        "GCS FileSystem URIs mustn't have: port, userinfo, path, query, or fragment: %s", uri);
    checkBucket(uri.getHost());
    return new CloudStorageFileSystem(this, uri.getHost(), CloudStorageConfiguration.fromMap(env));
  }

  @Override
  public CloudStoragePath getPath(URI uri) {
    return CloudStoragePath.getPath(getFileSystem(stripPathFromUri(uri)), uri.getPath());
  }

  @Override
  public SeekableByteChannel newByteChannel(
      Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
    checkNotNull(path);
    checkNotNullArray(attrs);
    if (options.contains(StandardOpenOption.WRITE)) {
      // TODO(b/18997618): Make our OpenOptions implement FileAttribute. Also remove buffer option.
      return newWriteChannel(path, options);
    } else {
      return newReadChannel(path, options);
    }
  }

  private SeekableByteChannel newReadChannel(
      Path path, Set<? extends OpenOption> options) throws IOException {
    for (OpenOption option : options) {
      if (option instanceof StandardOpenOption) {
        switch ((StandardOpenOption) option) {
          case READ:
            // Default behavior.
            break;
          case SPARSE:
          case TRUNCATE_EXISTING:
            // Ignored by specification.
            break;
          case WRITE:
            throw new IllegalArgumentException("READ+WRITE not supported yet");
          case APPEND:
          case CREATE:
          case CREATE_NEW:
          case DELETE_ON_CLOSE:
          case DSYNC:
          case SYNC:
          default:
            throw new UnsupportedOperationException(option.toString());
        }
      } else {
        throw new UnsupportedOperationException(option.toString());
      }
    }
    CloudStoragePath cloudPath = checkPath(path);
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      throw new CloudStoragePseudoDirectoryException(cloudPath);
    }
    return CloudStorageReadChannel.create(gcsService, cloudPath.getGcsFilename(), 0);
  }

  private SeekableByteChannel newWriteChannel(
      Path path, Set<? extends OpenOption> options) throws IOException {
    boolean wantCreateNew = false;
    for (OpenOption option : options) {
      if (option instanceof StandardOpenOption) {
        switch ((StandardOpenOption) option) {
          case CREATE:
          case TRUNCATE_EXISTING:
          case WRITE:
            // Default behavior.
            break;
          case SPARSE:
            // Ignored by specification.
            break;
          case CREATE_NEW:
            wantCreateNew = true;
            break;
          case READ:
            throw new IllegalArgumentException("READ+WRITE not supported yet");
          case APPEND:
          case DELETE_ON_CLOSE:
          case DSYNC:
          case SYNC:
          default:
            throw new UnsupportedOperationException(option.toString());
        }
      } else if (option instanceof CloudStorageOption) {
        // These will be interpreted later.
      } else {
        throw new UnsupportedOperationException(option.toString());
      }
    }
    CloudStoragePath cloudPath = checkPath(path);
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      throw new CloudStoragePseudoDirectoryException(cloudPath);
    }
    if (wantCreateNew) {
      // XXX: Java's documentation says this should be atomic.
      if (gcsService.getMetadata(cloudPath.getGcsFilename()) != null) {
        throw new FileAlreadyExistsException(cloudPath.toString());
      }
    }
    GcsFilename file = cloudPath.getGcsFilename();
    GcsFileOptions fileOptions = buildFileOptions(new GcsFileOptions.Builder(), options.toArray());
    return new CloudStorageWriteChannel(gcsService.createOrReplace(file, fileOptions));
  }

  @Override
  public InputStream newInputStream(Path path, OpenOption... options) throws IOException {
    InputStream result = super.newInputStream(path, options);
    CloudStoragePath cloudPath = checkPath(path);
    int blockSize = cloudPath.getFileSystem().config().blockSize();
    for (OpenOption option : options) {
      if (option instanceof OptionBlockSize) {
        blockSize = ((OptionBlockSize) option).size();
      }
    }
    return new BufferedInputStream(result, blockSize);
  }

  @Override
  public final boolean deleteIfExists(Path path) throws IOException {
    CloudStoragePath cloudPath = checkPath(path);
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      throw new CloudStoragePseudoDirectoryException(cloudPath);
    }
    return gcsService.delete(cloudPath.getGcsFilename());
  }

  @Override
  public void delete(Path path) throws IOException {
    CloudStoragePath cloudPath = checkPath(path);
    if (!deleteIfExists(cloudPath)) {
      throw new NoSuchFileException(cloudPath.toString());
    }
  }

  @Override
  public void move(Path source, Path target, CopyOption... options) throws IOException {
    for (CopyOption option : options) {
      if (option == StandardCopyOption.ATOMIC_MOVE) {
        throw new AtomicMoveNotSupportedException(source.toString(), target.toString(),
            "Google Cloud Storage does not support atomic move operations.");
      }
    }
    copy(source, target, options);
    delete(source);
  }

  @Override
  public void copy(Path source, Path target, CopyOption... options) throws IOException {
    boolean wantCopyAttributes = false;
    boolean wantReplaceExisting = false;
    int blockSize = -1;
    for (CopyOption option : options) {
      if (option instanceof StandardCopyOption) {
        switch ((StandardCopyOption) option) {
          case COPY_ATTRIBUTES:
            wantCopyAttributes = true;
            break;
          case REPLACE_EXISTING:
            wantReplaceExisting = true;
            break;
          case ATOMIC_MOVE:
          default:
            throw new UnsupportedOperationException(option.toString());
        }
      } else if (option instanceof CloudStorageOption) {
        if (option instanceof OptionBlockSize) {
          blockSize = ((OptionBlockSize) option).size();
        }
        // The rest will be interpreted later.
      } else {
        throw new UnsupportedOperationException(option.toString());
      }
    }
    CloudStoragePath fromPath = checkPath(source);
    CloudStoragePath toPath = checkPath(target);

    blockSize = blockSize != -1 ? blockSize
        : Ints.max(fromPath.getFileSystem().config().blockSize(),
              toPath.getFileSystem().config().blockSize());
    if (fromPath.seemsLikeADirectory() && toPath.seemsLikeADirectory()) {
      if (fromPath.getFileSystem().config().usePseudoDirectories()
          && toPath.getFileSystem().config().usePseudoDirectories()) {
        // NOOP: This would normally create an empty directory.
        return;
      } else {
        checkArgument(!fromPath.getFileSystem().config().usePseudoDirectories()
            && !toPath.getFileSystem().config().usePseudoDirectories(),
            "File systems associated with paths don't agree on pseudo-directories.");
      }
    }
    if (fromPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      throw new CloudStoragePseudoDirectoryException(fromPath);
    }
    if (toPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      throw new CloudStoragePseudoDirectoryException(toPath);
    }
    GcsFilename from = fromPath.getGcsFilename();
    GcsFilename to = toPath.getGcsFilename();
    GcsFileMetadata metadata = gcsService.getMetadata(from);
    if (metadata == null) {
      throw new NoSuchFileException(source.toString());
    }
    if (fromPath.equals(toPath)) {
      return;
    }
    if (!wantReplaceExisting && gcsService.getMetadata(to) != null) {
      throw new FileAlreadyExistsException(target.toString());
    }
    GcsFileOptions.Builder builder = wantCopyAttributes
        ? copyFileOptions(metadata.getOptions())
        : new GcsFileOptions.Builder();
    GcsFileOptions fileOptions = buildFileOptions(builder, options);
    try (GcsInputChannel input = gcsService.openReadChannel(from, 0);
        GcsOutputChannel output = gcsService.createOrReplace(to, fileOptions)) {
      ByteBuffer block = ByteBuffer.allocate(blockSize);
      while (input.read(block) != -1) {
        block.flip();
        while (block.hasRemaining()) {
          output.write(block);
        }
        block.clear();
      }
    }
  }

  @Override
  public boolean isSameFile(Path path, Path path2) {
    return checkPath(path).equals(checkPath(path2));
  }

  /** Returns {@code false} */
  @Override
  public boolean isHidden(Path path) {
    checkPath(path);
    return false;
  }

  @Override
  public void checkAccess(Path path, AccessMode... modes) throws IOException {
    for (AccessMode mode : modes) {
      switch (mode) {
        case READ:
        case WRITE:
          break;
        case EXECUTE:
        default:
          throw new UnsupportedOperationException(mode.toString());
      }
    }
    CloudStoragePath cloudPath = checkPath(path);
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      return;
    }
    if (gcsService.getMetadata(cloudPath.getGcsFilename()) == null) {
      throw new NoSuchFileException(path.toString());
    }
  }

  @Override
  public <A extends BasicFileAttributes> A readAttributes(
      Path path, Class<A> type, LinkOption... options) throws IOException {
    CloudStoragePath cloudPath = checkPath(path);
    checkNotNull(type);
    checkNotNullArray(options);
    if (type != CloudStorageFileAttributes.class && type != BasicFileAttributes.class) {
      throw new UnsupportedOperationException(type.getSimpleName());
    }
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      @SuppressWarnings("unchecked")
      A result = (A) CloudStoragePseudoDirectoryAttributes.SINGLETON_INSTANCE;
      return result;
    }
    GcsFileMetadata metadata = gcsService.getMetadata(cloudPath.getGcsFilename());
    if (metadata == null) {
      throw new NoSuchFileException(path.toString());
    }
    @SuppressWarnings("unchecked")
    A result = (A) new CloudStorageObjectAttributes(metadata);
    return result;
  }

  @Override
  public <V extends FileAttributeView> V getFileAttributeView(
      Path path, Class<V> type, LinkOption... options) {
    CloudStoragePath cloudPath = checkPath(path);
    checkNotNull(type);
    checkNotNullArray(options);
    if (type != CloudStorageFileAttributeView.class && type != BasicFileAttributeView.class) {
      throw new UnsupportedOperationException(type.getSimpleName());
    }
    @SuppressWarnings("unchecked")
    V result = (V) new CloudStorageFileAttributeView(this, cloudPath);
    return result;
  }

  /** Does nothing since GCS uses fake directories. */
  @Override
  public void createDirectory(Path dir, FileAttribute<?>... attrs) {
    checkPath(dir);
    checkNotNullArray(attrs);
  }

  /** @throws UnsupportedOperationException */
  @Override
  public DirectoryStream<Path> newDirectoryStream(Path dir, Filter<? super Path> filter) {
    // TODO(b/18997618): Implement me.
    throw new UnsupportedOperationException();
  }

  /**
   * This feature is not supported. Please use {@link #readAttributes(Path, Class, LinkOption...)}
   *
   * @throws UnsupportedOperationException
   */
  @Override
  public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) {
    throw new UnsupportedOperationException();
  }

  /**
   * This feature is not supported, since Cloud Storage objects are immutable.
   *
   * @throws UnsupportedOperationException
   */
  @Override
  public void setAttribute(Path path, String attribute, Object value, LinkOption... options) {
    throw new CloudStorageObjectImmutableException();
  }

  /**
   * This feature is not supported.
   *
   * @throws UnsupportedOperationException
   */
  @Override
  public FileStore getFileStore(Path path) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean equals(@Nullable Object other) {
    return this == other
        || other instanceof CloudStorageFileSystemProvider
        && Objects.equals(gcsService, ((CloudStorageFileSystemProvider) other).gcsService);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gcsService);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("gcsService", gcsService)
        .toString();
  }
}

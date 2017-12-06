/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.auto.service.AutoService;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Throwables;
import com.google.common.collect.AbstractIterator;
import com.google.common.net.UrlEscapers;
import com.google.common.primitives.Ints;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.Files;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

/**
 * Google Cloud Storage {@link FileSystemProvider} implementation.
 *
 * <p><b>Note:</b> This class should never be used directly. This class is instantiated by the
 * service loader and called through a standardized API, e.g. {@link java.nio.file.Files}. However
 * the javadocs in this class serve as useful documentation for the behavior of the Google Cloud
 * Storage NIO library.
 */
@Singleton
@ThreadSafe
@AutoService(FileSystemProvider.class)
public final class CloudStorageFileSystemProvider extends FileSystemProvider {

  private Storage storage;
  private StorageOptions storageOptions;

  // used only when we create a new instance of CloudStorageFileSystemProvider.
  private static StorageOptions futureStorageOptions;

  private static class LazyPathIterator extends AbstractIterator<Path> {
    private final Iterator<Blob> blobIterator;
    private final Filter<? super Path> filter;
    private final CloudStorageFileSystem fileSystem;
    private final String prefix;

    LazyPathIterator(CloudStorageFileSystem fileSystem,
                     String prefix,
                     Iterator<Blob> blobIterator,
                     Filter<? super Path> filter) {
      this.prefix = prefix;
      this.blobIterator = blobIterator;
      this.filter = filter;
      this.fileSystem = fileSystem;
    }

    @Override
    protected Path computeNext() {
      while (blobIterator.hasNext()) {
        Path path = fileSystem.getPath(blobIterator.next().getName());
        try {
          if (path.toString().equals(prefix)) {
            // do not return ourselves, because that confuses recursive descents.
            continue;
          }
          if (filter.accept(path)) {
            return path;
          }
        } catch (IOException ex) {
          throw new DirectoryIteratorException(ex);
        }
      }
      return endOfData();
    }
  }

  /**
   * Sets options that are only used by the constructor.
   */
  @VisibleForTesting
  public static void setStorageOptions(@Nullable StorageOptions newStorageOptions) {
    futureStorageOptions = newStorageOptions;
  }

  /**
   * Changes the default configuration for every filesystem object created
   * from here on, including via SPI. If null then future filesystem objects
   * will have the factory default configuration.
   *
   * <p>If options are specified later then they override the defaults.
   * Methods that take a whole CloudStorageConfiguration (eg.
   * CloudStorageFileSystem.forBucket) will completely override the defaults.
   * Methods that take individual options (eg.
   * CloudStorageFileSystemProvier.newFileSystem) will override only these options;
   * the rest will be taken from the defaults specified here.
   *
   * <p>This is meant to be done only once, at the beginning of some main program,
   * in order to force all libraries to use some settings we like.
   *
   * <p>Libraries should never call this. If you're a library then, instead, create your own
   * filesystem object with the right configuration and pass it along.
   *
   * @param newDefault new default CloudStorageConfiguration
   */
  public static void setDefaultCloudStorageConfiguration(@Nullable CloudStorageConfiguration newDefault) {
    CloudStorageFileSystem.setDefaultCloudStorageConfiguration(newDefault);
  }

  /**
   * Default constructor which should only be called by Java SPI.
   *
   * @see java.nio.file.FileSystems#getFileSystem(URI)
   * @see CloudStorageFileSystem#forBucket(String)
   */
  public CloudStorageFileSystemProvider() {
    this(futureStorageOptions);
  }

  CloudStorageFileSystemProvider(@Nullable StorageOptions gcsStorageOptions) {
    this.storageOptions = gcsStorageOptions;
  }

  // Initialize this.storage, once. This may throw an exception if default authentication
  // credentials are not available (hence not doing it in the ctor).
  private void initStorage() {
    if (this.storage != null) {
      return;
    }
    if (storageOptions == null) {
      this.storage = StorageOptions.getDefaultInstance().getService();
    } else {
      this.storage = storageOptions.getService();
    }
  }

  @Override
  public String getScheme() {
    return CloudStorageFileSystem.URI_SCHEME;
  }

  /**
   * Returns Cloud Storage file system, provided a URI with no path, e.g. {@code gs://bucket}.
   */
  @Override
  public CloudStorageFileSystem getFileSystem(URI uri) {
    initStorage();
    return newFileSystem(uri, Collections.<String, Object>emptyMap());
  }

  /**
   * Returns Cloud Storage file system, provided a URI, e.g. {@code gs://bucket}.
   * The URI can include a path component (that will be ignored).
   *
   * @param uri bucket and current working directory, e.g. {@code gs://bucket}
   * @param env map of configuration options, whose keys correspond to the method names of
   *     {@link CloudStorageConfiguration.Builder}. However you are not allowed to set the working
   *     directory, as that should be provided in the {@code uri}
   * @throws IllegalArgumentException if {@code uri} specifies a port, user, query, or fragment, or
   *     if scheme is not {@value CloudStorageFileSystem#URI_SCHEME}
   */
  @Override
  public CloudStorageFileSystem newFileSystem(URI uri, Map<String, ?> env) {
    checkArgument(
        uri.getScheme().equalsIgnoreCase(CloudStorageFileSystem.URI_SCHEME),
        "Cloud Storage URIs must have '%s' scheme: %s",
        CloudStorageFileSystem.URI_SCHEME,
        uri);
    checkArgument(
        !isNullOrEmpty(uri.getHost()), "%s:// URIs must have a host: %s",
        CloudStorageFileSystem.URI_SCHEME, uri);
    checkArgument(
        uri.getPort() == -1
            && isNullOrEmpty(uri.getQuery())
            && isNullOrEmpty(uri.getFragment())
            && isNullOrEmpty(uri.getUserInfo()),
        "GCS FileSystem URIs mustn't have: port, userinfo, query, or fragment: %s",
        uri);
    CloudStorageUtil.checkBucket(uri.getHost());
    initStorage();
    return new CloudStorageFileSystem(
        this,
        uri.getHost(),
        CloudStorageConfiguration.fromMap(
            CloudStorageFileSystem.getDefaultCloudStorageConfiguration(), env));
  }

  @Override
  public CloudStoragePath getPath(URI uri) {
    initStorage();
    return CloudStoragePath.getPath(
        getFileSystem(CloudStorageUtil.stripPathFromUri(uri)), uri.getPath());
  }

  /** Convenience method: replaces spaces with "%20", builds a URI, and calls getPath(uri). */
  public CloudStoragePath getPath(String uriInStringForm) {
    String escaped = UrlEscapers.urlFragmentEscaper().escape(uriInStringForm);
    return getPath(URI.create(escaped));
  }

  @Override
  public SeekableByteChannel newByteChannel(
      Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
    checkNotNull(path);
    initStorage();
    CloudStorageUtil.checkNotNullArray(attrs);
    if (options.contains(StandardOpenOption.WRITE)) {
      // TODO: Make our OpenOptions implement FileAttribute. Also remove buffer option.
      return newWriteChannel(path, options);
    } else {
      return newReadChannel(path, options);
    }
  }

  private SeekableByteChannel newReadChannel(Path path, Set<? extends OpenOption> options)
      throws IOException {
    initStorage();
    int maxChannelReopens = CloudStorageUtil.getMaxChannelReopensFromPath(path);
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
      } else if (option instanceof OptionMaxChannelReopens) {
        maxChannelReopens = ((OptionMaxChannelReopens) option).maxChannelReopens();
      } else {
        throw new UnsupportedOperationException(option.toString());
      }
    }
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      throw new CloudStoragePseudoDirectoryException(cloudPath);
    }
    return CloudStorageReadChannel.create(storage, cloudPath.getBlobId(), 0, maxChannelReopens);
  }

  private SeekableByteChannel newWriteChannel(Path path, Set<? extends OpenOption> options)
      throws IOException {
    initStorage();
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      throw new CloudStoragePseudoDirectoryException(cloudPath);
    }
    BlobId file = cloudPath.getBlobId();
    BlobInfo.Builder infoBuilder = BlobInfo.newBuilder(file);
    List<Storage.BlobWriteOption> writeOptions = new ArrayList<>();
    List<Acl> acls = new ArrayList<>();

    HashMap<String, String> metas = new HashMap<>();
    for (OpenOption option : options) {
      if (option instanceof OptionMimeType) {
        infoBuilder.setContentType(((OptionMimeType) option).mimeType());
      } else if (option instanceof OptionCacheControl) {
        infoBuilder.setCacheControl(((OptionCacheControl) option).cacheControl());
      } else if (option instanceof OptionContentDisposition) {
        infoBuilder.setContentDisposition(((OptionContentDisposition) option).contentDisposition());
      } else if (option instanceof OptionContentEncoding) {
        infoBuilder.setContentEncoding(((OptionContentEncoding) option).contentEncoding());
      } else if (option instanceof OptionUserMetadata) {
        OptionUserMetadata opMeta = (OptionUserMetadata) option;
        metas.put(opMeta.key(), opMeta.value());
      } else if (option instanceof OptionAcl) {
        acls.add(((OptionAcl) option).acl());
      } else if (option instanceof OptionBlockSize) {
        // TODO: figure out how to plumb in block size.
      } else if (option instanceof StandardOpenOption) {
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
            writeOptions.add(Storage.BlobWriteOption.doesNotExist());
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
        // XXX: We need to interpret these later
      } else {
        throw new UnsupportedOperationException(option.toString());
      }
    }

    if (!metas.isEmpty()) {
      infoBuilder.setMetadata(metas);
    }
    if (!acls.isEmpty()) {
      infoBuilder.setAcl(acls);
    }

    try {
      return new CloudStorageWriteChannel(
          storage.writer(infoBuilder.build(),
              writeOptions.toArray(new Storage.BlobWriteOption[writeOptions.size()])));
    } catch (StorageException oops) {
      throw asIoException(oops);
    }
  }

  @Override
  public InputStream newInputStream(Path path, OpenOption... options) throws IOException {
    initStorage();
    InputStream result = super.newInputStream(path, options);
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    int blockSize = cloudPath.getFileSystem().config().blockSize();
    for (OpenOption option : options) {
      if (option instanceof OptionBlockSize) {
        blockSize = ((OptionBlockSize) option).size();
      }
    }
    return new BufferedInputStream(result, blockSize);
  }

  @Override
  public boolean deleteIfExists(Path path) throws IOException {
    initStorage();
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories()) {
      // if the "folder" is empty then we're fine, otherwise complain
      // that we cannot act on folders.
      try (DirectoryStream<Path> paths = Files.newDirectoryStream(path)) {
        if (!paths.iterator().hasNext()) {
          // "folder" isn't actually there in the first place, so: success!
          // (we must return true so delete doesn't freak out)
          return true;
        }
      }
      throw new CloudStoragePseudoDirectoryException(cloudPath);
    }

    final CloudStorageRetryHandler retryHandler = new CloudStorageRetryHandler(CloudStorageUtil.getMaxChannelReopensFromPath(path));
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        return storage.delete(cloudPath.getBlobId());
      } catch (StorageException exs) {
        // Will rethrow a StorageException if all retries/reopens are exhausted
        retryHandler.handleStorageException(exs);
        // we're being aggressive by retrying even on scenarios where we'd normally reopen.
      }
    }
  }

  @Override
  public void delete(Path path) throws IOException {
    initStorage();
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    if (!deleteIfExists(cloudPath)) {
      throw new NoSuchFileException(cloudPath.toString());
    }
  }

  @Override
  public void move(Path source, Path target, CopyOption... options) throws IOException {
    initStorage();
    for (CopyOption option : options) {
      if (option == StandardCopyOption.ATOMIC_MOVE) {
        throw new AtomicMoveNotSupportedException(
            source.toString(),
            target.toString(),
            "Google Cloud Storage does not support atomic move operations.");
      }
    }
    copy(source, target, options);
    delete(source);
  }

  @Override
  public void copy(Path source, Path target, CopyOption... options) throws IOException {
    initStorage();
    boolean wantCopyAttributes = false;
    boolean wantReplaceExisting = false;
    // true if the option was set manually (so we shouldn't copy the parent's)
    boolean overrideContentType = false;
    boolean overrideCacheControl = false;
    boolean overrideContentEncoding = false;
    boolean overrideContentDisposition = false;

    CloudStoragePath toPath = CloudStorageUtil.checkPath(target);
    BlobInfo.Builder tgtInfoBuilder = BlobInfo.newBuilder(toPath.getBlobId()).setContentType("");

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
        } else if (option instanceof OptionMimeType) {
          tgtInfoBuilder.setContentType(((OptionMimeType) option).mimeType());
          overrideContentType = true;
        } else if (option instanceof OptionCacheControl) {
          tgtInfoBuilder.setCacheControl(((OptionCacheControl) option).cacheControl());
          overrideCacheControl = true;
        } else if (option instanceof OptionContentEncoding) {
          tgtInfoBuilder.setContentEncoding(((OptionContentEncoding) option).contentEncoding());
          overrideContentEncoding = true;
        } else if (option instanceof OptionContentDisposition) {
          tgtInfoBuilder.setContentDisposition(
              ((OptionContentDisposition) option).contentDisposition());
          overrideContentDisposition = true;
        } else {
          throw new UnsupportedOperationException(option.toString());
        }
      } else {
        throw new UnsupportedOperationException(option.toString());
      }
    }

    CloudStoragePath fromPath = CloudStorageUtil.checkPath(source);

    blockSize =
        blockSize != -1
            ? blockSize
            : Ints.max(
                fromPath.getFileSystem().config().blockSize(),
                toPath.getFileSystem().config().blockSize());
    // TODO: actually use blockSize

    if (fromPath.seemsLikeADirectory() && toPath.seemsLikeADirectory()) {
      if (fromPath.getFileSystem().config().usePseudoDirectories()
          && toPath.getFileSystem().config().usePseudoDirectories()) {
        // NOOP: This would normally create an empty directory.
        return;
      } else {
        checkArgument(
            !fromPath.getFileSystem().config().usePseudoDirectories()
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

    final CloudStorageRetryHandler retryHandler = new CloudStorageRetryHandler(CloudStorageUtil.getMaxChannelReopensFromPath(source));
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        if ( wantCopyAttributes ) {
          BlobInfo blobInfo = storage.get(fromPath.getBlobId());
          if ( null == blobInfo ) {
            throw new NoSuchFileException(fromPath.toString());
          }
          if ( !overrideCacheControl ) {
            tgtInfoBuilder.setCacheControl(blobInfo.getCacheControl());
          }
          if ( !overrideContentType ) {
            tgtInfoBuilder.setContentType(blobInfo.getContentType());
          }
          if ( !overrideContentEncoding ) {
            tgtInfoBuilder.setContentEncoding(blobInfo.getContentEncoding());
          }
          if ( !overrideContentDisposition ) {
            tgtInfoBuilder.setContentDisposition(blobInfo.getContentDisposition());
          }
          tgtInfoBuilder.setAcl(blobInfo.getAcl());
          tgtInfoBuilder.setMetadata(blobInfo.getMetadata());
        }

        BlobInfo tgtInfo = tgtInfoBuilder.build();
        Storage.CopyRequest.Builder copyReqBuilder =
                Storage.CopyRequest.newBuilder().setSource(fromPath.getBlobId());
        if (wantReplaceExisting) {
          copyReqBuilder = copyReqBuilder.setTarget(tgtInfo);
        } else {
          copyReqBuilder = copyReqBuilder.setTarget(tgtInfo, Storage.BlobTargetOption.doesNotExist());
        }
        CopyWriter copyWriter = storage.copy(copyReqBuilder.build());
        copyWriter.getResult();
        break;
      } catch ( StorageException oops ) {
        try {
          // Will rethrow a StorageException if all retries/reopens are exhausted
          retryHandler.handleStorageException(oops);
          // we're being aggressive by retrying even on scenarios where we'd normally reopen.
        } catch (StorageException retriesExhaustedException) {
          throw asIoException(retriesExhaustedException);
        }
      }
    }
  }

  @Override
  public boolean isSameFile(Path path, Path path2) {
    return CloudStorageUtil.checkPath(path).equals(CloudStorageUtil.checkPath(path2));
  }

  /**
   * Always returns {@code false}, because Google Cloud Storage doesn't support hidden files.
   */
  @Override
  public boolean isHidden(Path path) {
    CloudStorageUtil.checkPath(path);
    return false;
  }

  @Override
  public void checkAccess(Path path, AccessMode... modes) throws IOException {
    initStorage();
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

    final CloudStorageRetryHandler retryHandler = new CloudStorageRetryHandler(CloudStorageUtil.getMaxChannelReopensFromPath(path));
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
        if ( cloudPath.seemsLikeADirectoryAndUsePseudoDirectories() ) {
          return;
        }
        if ( storage.get(cloudPath.getBlobId(), Storage.BlobGetOption.fields(Storage.BlobField.ID))
                == null ) {
          throw new NoSuchFileException(path.toString());
        }
        break;
      } catch (StorageException exs) {
        // Will rethrow a StorageException if all retries/reopens are exhausted
        retryHandler.handleStorageException(exs);
        // we're being aggressive by retrying even on scenarios where we'd normally reopen.
      }
    }
  }

  @Override
  public <A extends BasicFileAttributes> A readAttributes(
      Path path, Class<A> type, LinkOption... options) throws IOException {
    checkNotNull(type);
    CloudStorageUtil.checkNotNullArray(options);
    if (type != CloudStorageFileAttributes.class && type != BasicFileAttributes.class) {
      throw new UnsupportedOperationException(type.getSimpleName());
    }
    initStorage();

    final CloudStorageRetryHandler retryHandler = new CloudStorageRetryHandler(CloudStorageUtil.getMaxChannelReopensFromPath(path));
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
        if ( cloudPath.seemsLikeADirectoryAndUsePseudoDirectories() ) {
          @SuppressWarnings("unchecked")
          A result = (A) new CloudStoragePseudoDirectoryAttributes(cloudPath);
          return result;
        }
        BlobInfo blobInfo = storage.get(cloudPath.getBlobId());
        // null size indicate a file that we haven't closed yet, so GCS treats it as not there yet.
        if ( null == blobInfo || blobInfo.getSize() == null ) {
          throw new NoSuchFileException(
              "gs://" + cloudPath.getBlobId().getBucket() + "/" + cloudPath.getBlobId().getName());
        }
        CloudStorageObjectAttributes ret;
        ret = new CloudStorageObjectAttributes(blobInfo);
        @SuppressWarnings("unchecked")
        A result = (A) ret;
        return result;
      } catch (StorageException exs) {
        // Will rethrow a StorageException if all retries/reopens are exhausted
        retryHandler.handleStorageException(exs);
        // we're being aggressive by retrying even on scenarios where we'd normally reopen.
      }
    }
  }

  @Override
  public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) {
    // TODO(#811): Java 7 NIO defines at least eleven string attributes we'd want to support
    //             (eg. BasicFileAttributeView and PosixFileAttributeView), so rather than a partial
    //             implementation we rely on the other overload for now.
    throw new UnsupportedOperationException();
  }

  @Override
  public <V extends FileAttributeView> V getFileAttributeView(
      Path path, Class<V> type, LinkOption... options) {
    checkNotNull(type);
    CloudStorageUtil.checkNotNullArray(options);
    if (type != CloudStorageFileAttributeView.class && type != BasicFileAttributeView.class) {
      throw new UnsupportedOperationException(type.getSimpleName());
    }
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    @SuppressWarnings("unchecked")
    V result = (V) new CloudStorageFileAttributeView(storage, cloudPath);
    return result;
  }

  /**
   * Does nothing since Google Cloud Storage uses fake directories.
   */
  @Override
  public void createDirectory(Path dir, FileAttribute<?>... attrs) {
    CloudStorageUtil.checkPath(dir);
    CloudStorageUtil.checkNotNullArray(attrs);
  }

  @Override
  public DirectoryStream<Path> newDirectoryStream(Path dir, final Filter<? super Path> filter) {
    final CloudStoragePath cloudPath = CloudStorageUtil.checkPath(dir);
    checkNotNull(filter);
    initStorage();

    final CloudStorageRetryHandler retryHandler = new CloudStorageRetryHandler(CloudStorageUtil.getMaxChannelReopensFromPath(dir));
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        final String prefix = cloudPath.toRealPath().toString();
        final Iterator<Blob> blobIterator = storage.list(cloudPath.bucket(),
                Storage.BlobListOption.prefix(prefix), Storage.BlobListOption.currentDirectory(),
                Storage.BlobListOption.fields()).iterateAll().iterator();
        return new DirectoryStream<Path>() {
          @Override
          public Iterator<Path> iterator() {
            return new LazyPathIterator(cloudPath.getFileSystem(), prefix, blobIterator, filter);
          }

          @Override
          public void close() throws IOException {
            // Does nothing since there's nothing to close. Commenting this method to quiet codacy.
          }
        };
      } catch (StorageException exs) {
        // Will rethrow a StorageException if all retries/reopens are exhausted
        retryHandler.handleStorageException(exs);
        // we're being aggressive by retrying even on scenarios where we'd normally reopen.
      }
    }
  }

  /**
   * Throws {@link UnsupportedOperationException} because Cloud Storage objects are immutable.
   */
  @Override
  public void setAttribute(Path path, String attribute, Object value, LinkOption... options) {
    throw new CloudStorageObjectImmutableException();
  }

  /**
   * Throws {@link UnsupportedOperationException} because this feature hasn't been implemented yet.
   */
  @Override
  public FileStore getFileStore(Path path) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || other instanceof CloudStorageFileSystemProvider
            && Objects.equals(storage, ((CloudStorageFileSystemProvider) other).storage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storage);
  }

  @Override
  public String toString() {
    initStorage();
    return MoreObjects.toStringHelper(this).add("storage", storage).toString();
  }

  private IOException asIoException(StorageException oops) {
    // RPC API can only throw StorageException, but CloudStorageFileSystemProvider
    // can only throw IOException. Square peg, round hole.
    // TODO(#810): Research if other codes should be translated similarly.
    if (oops.getCode() == 404) {
      return new NoSuchFileException(oops.getReason());
    }

    Throwable cause = oops.getCause();
    try {
      if (cause instanceof FileAlreadyExistsException) {
        throw new FileAlreadyExistsException(((FileAlreadyExistsException) cause).getReason());
      }
      // fallback
      Throwables.propagateIfInstanceOf(oops.getCause(), IOException.class);
    } catch (IOException okEx) {
      return okEx;
    }
    return new IOException(oops.getMessage(), oops);
  }
}

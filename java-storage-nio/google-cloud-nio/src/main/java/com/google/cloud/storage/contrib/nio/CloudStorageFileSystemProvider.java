/*
 * Copyright 2016 Google LLC
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
import static java.nio.file.attribute.PosixFilePermission.GROUP_EXECUTE;
import static java.nio.file.attribute.PosixFilePermission.GROUP_READ;
import static java.nio.file.attribute.PosixFilePermission.GROUP_WRITE;
import static java.nio.file.attribute.PosixFilePermission.OWNER_EXECUTE;
import static java.nio.file.attribute.PosixFilePermission.OWNER_READ;
import static java.nio.file.attribute.PosixFilePermission.OWNER_WRITE;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.collect.AbstractIterator;
import com.google.common.net.UrlEscapers;
import com.google.common.primitives.Ints;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.channels.FileChannel;
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
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
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
public final class CloudStorageFileSystemProvider extends FileSystemProvider {

  private Storage storage;
  // if null, use StorageOptionsUtil.getDefaultInstance()
  private final @Nullable StorageOptions storageOptions;
  // if non-null, we pay via this project.
  private final @Nullable String userProject;

  // used only when we create a new instance of CloudStorageFileSystemProvider.
  private static StorageOptions futureStorageOptions = null;

  private static class LazyPathIterator extends AbstractIterator<Path> {
    private final Iterator<Blob> blobIterator;
    private final Filter<? super Path> filter;
    private final CloudStorageFileSystem fileSystem;
    private final String prefix;
    // whether to make the paths absolute before returning them.
    private final boolean absolutePaths;

    LazyPathIterator(
        CloudStorageFileSystem fileSystem,
        String prefix,
        Iterator<Blob> blobIterator,
        Filter<? super Path> filter,
        boolean absolutePaths) {
      this.prefix = prefix;
      this.blobIterator = blobIterator;
      this.filter = filter;
      this.fileSystem = fileSystem;
      this.absolutePaths = absolutePaths;
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
            if (absolutePaths) {
              return path.toAbsolutePath();
            }
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
   *
   * <p>Instead of calling this, when possible use CloudStorageFileSystem.forBucket and pass
   * StorageOptions as an argument.
   */
  @VisibleForTesting
  public static void setStorageOptions(@Nullable StorageOptions newStorageOptions) {
    futureStorageOptions = newStorageOptions;
  }

  /**
   * Changes the default configuration for every filesystem object created from here on, including
   * via SPI. If null then future filesystem objects will have the factory default configuration.
   *
   * <p>If options are specified later then they override the defaults. Methods that take a whole
   * CloudStorageConfiguration (eg. CloudStorageFileSystem.forBucket) will completely override the
   * defaults. Methods that take individual options (eg.
   * CloudStorageFileSystemProvier.newFileSystem) will override only these options; the rest will be
   * taken from the defaults specified here.
   *
   * <p>This is meant to be done only once, at the beginning of some main program, in order to force
   * all libraries to use some settings we like.
   *
   * <p>Libraries should never call this. If you're a library then, instead, create your own
   * filesystem object with the right configuration and pass it along.
   *
   * @param newDefault new default CloudStorageConfiguration
   */
  public static void setDefaultCloudStorageConfiguration(
      @Nullable CloudStorageConfiguration newDefault) {
    CloudStorageConfiguration.setUserSpecifiedDefault(newDefault);
  }

  /**
   * Default constructor which should only be called by Java SPI.
   *
   * @see java.nio.file.FileSystems#getFileSystem(URI)
   * @see CloudStorageFileSystem#forBucket(String)
   */
  public CloudStorageFileSystemProvider() {
    this(CloudStorageConfiguration.getUserSpecifiedDefault().userProject(), futureStorageOptions);
  }

  /**
   * Internal constructor to use the user-provided default config, and a given userProject setting.
   */
  CloudStorageFileSystemProvider(@Nullable String userProject) {
    this(userProject, futureStorageOptions);
  }

  /**
   * Internal constructor, fully configurable. Note that null options means to use the system
   * defaults (NOT the user-provided ones).
   */
  CloudStorageFileSystemProvider(
      @Nullable String userProject, @Nullable StorageOptions gcsStorageOptions) {
    this.storageOptions =
        gcsStorageOptions != null
            ? StorageOptionsUtil.mergeOptionsWithUserAgent(gcsStorageOptions)
            : null;
    this.userProject = userProject;
  }

  // Initialize this.storage, once. This may throw an exception if default authentication
  // credentials are not available (hence not doing it in the ctor).
  private void initStorage() {
    if (this.storage == null) {
      doInitStorage();
    }
  }

  @Override
  public String getScheme() {
    return CloudStorageFileSystem.URI_SCHEME;
  }

  /** Returns Cloud Storage file system, provided a URI with no path, e.g. {@code gs://bucket}. */
  @Override
  public CloudStorageFileSystem getFileSystem(URI uri) {
    initStorage();
    return newFileSystem(uri, Collections.<String, Object>emptyMap());
  }

  /**
   * Returns Cloud Storage file system, provided a URI, e.g. {@code gs://bucket}. The URI can
   * include a path component (that will be ignored).
   *
   * @param uri bucket and current working directory, e.g. {@code gs://bucket}
   * @param env map of configuration options, whose keys correspond to the method names of {@link
   *     CloudStorageConfiguration.Builder}. However you are not allowed to set the working
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
    // Bucket names may not be compatible with getHost(), see
    // https://github.com/googleapis/java-storage-nio/issues/1218
    // However, there may be existing code expecting the exception message to refer to the bucket
    // name as the "host".
    checkArgument(
        !isNullOrEmpty(uri.getAuthority()),
        "%s:// URIs must have a host: %s",
        CloudStorageFileSystem.URI_SCHEME,
        uri);
    checkArgument(
        uri.getPort() == -1
            && isNullOrEmpty(uri.getQuery())
            && isNullOrEmpty(uri.getFragment())
            && isNullOrEmpty(uri.getUserInfo()),
        "GCS FileSystem URIs mustn't have: port, userinfo, query, or fragment: %s",
        uri);
    CloudStorageUtil.checkBucket(uri.getAuthority());
    initStorage();
    return new CloudStorageFileSystem(
        this,
        uri.getAuthority(),
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

  /**
   * Open a file for reading or writing. To read receiver-pays buckets, specify the
   * BlobSourceOption.userProject option.
   *
   * @param path: the path to the file to open or create
   * @param options: options specifying how the file is opened, e.g. StandardOpenOption.WRITE or
   *     BlobSourceOption.userProject
   * @param attrs: (not supported, values will be ignored)
   * @return
   * @throws IOException
   */
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

  /**
   * Open a file for reading OR writing. The {@link FileChannel} that is returned will only allow
   * reads or writes depending on the {@link OpenOption}s that are specified. If any of the
   * following have been specified, the {@link FileChannel} will be write-only: {@link
   * StandardOpenOption#CREATE}
   *
   * <ul>
   *   <li>{@link StandardOpenOption#CREATE}
   *   <li>{@link StandardOpenOption#CREATE_NEW}
   *   <li>{@link StandardOpenOption#WRITE}
   *   <li>{@link StandardOpenOption#TRUNCATE_EXISTING}
   * </ul>
   *
   * In all other cases the {@link FileChannel} will be read-only.
   *
   * @param path The path to the file to open or create
   * @param options The options specifying how the file should be opened, and whether the {@link
   *     FileChannel} should be read-only or write-only.
   * @param attrs (not supported, the values will be ignored)
   * @throws IOException
   */
  @Override
  public FileChannel newFileChannel(
      Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
    checkNotNull(path);
    initStorage();
    CloudStorageUtil.checkNotNullArray(attrs);
    if (options.contains(StandardOpenOption.CREATE_NEW)) {
      Files.createFile(path, attrs);
    } else if (options.contains(StandardOpenOption.CREATE) && !Files.exists(path)) {
      Files.createFile(path, attrs);
    }
    if (options.contains(StandardOpenOption.WRITE)
        || options.contains(StandardOpenOption.CREATE)
        || options.contains(StandardOpenOption.CREATE_NEW)
        || options.contains(StandardOpenOption.TRUNCATE_EXISTING)) {
      return new CloudStorageWriteFileChannel(newWriteChannel(path, options));
    } else {
      return new CloudStorageReadFileChannel(newReadChannel(path, options));
    }
  }

  private SeekableByteChannel newReadChannel(Path path, Set<? extends OpenOption> options)
      throws IOException {
    initStorage();
    int maxChannelReopens = CloudStorageUtil.getMaxChannelReopensFromPath(path);
    List<BlobSourceOption> blobSourceOptions = new ArrayList<>();
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
      } else if (option instanceof BlobSourceOption) {
        blobSourceOptions.add((BlobSourceOption) option);
      } else {
        throw new UnsupportedOperationException(option.toString());
      }
    }
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    // passing false since we just want to check if it ends with /
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories(null)) {
      throw new CloudStoragePseudoDirectoryException(cloudPath);
    }
    return CloudStorageReadChannel.create(
        storage,
        cloudPath.getBlobId(),
        0,
        maxChannelReopens,
        cloudPath.getFileSystem().config(),
        userProject,
        blobSourceOptions.toArray(new BlobSourceOption[blobSourceOptions.size()]));
  }

  private SeekableByteChannel newWriteChannel(Path path, Set<? extends OpenOption> options)
      throws IOException {
    initStorage();
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    boolean allowSlash = options.contains(OptionAllowTrailingSlash.getInstance());
    if (!allowSlash && cloudPath.seemsLikeADirectoryAndUsePseudoDirectories(null)) {
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
    if (!isNullOrEmpty(userProject)) {
      writeOptions.add(Storage.BlobWriteOption.userProject(userProject));
    }

    if (!metas.isEmpty()) {
      infoBuilder.setMetadata(metas);
    }
    if (!acls.isEmpty()) {
      infoBuilder.setAcl(acls);
    }

    try {
      return new CloudStorageWriteChannel(
          storage.writer(
              infoBuilder.build(),
              writeOptions.toArray(new Storage.BlobWriteOption[writeOptions.size()])));
    } catch (StorageException oops) {
      throw asIoException(oops, false);
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
    if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories(storage)) {
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

    BlobId idWithGeneration = cloudPath.getBlobId();
    if (idWithGeneration.getGeneration() == null) {
      Storage.BlobGetOption[] options = new BlobGetOption[0];
      if (!isNullOrEmpty(userProject)) {
        options = new BlobGetOption[] {Storage.BlobGetOption.userProject(userProject)};
      }
      Blob blob = storage.get(idWithGeneration, options);
      if (blob == null) {
        // not found
        return false;
      }
      idWithGeneration = blob.getBlobId();
    }

    final CloudStorageRetryHandler retryHandler =
        new CloudStorageRetryHandler(cloudPath.getFileSystem().config());
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        if (isNullOrEmpty(userProject)) {
          return storage.delete(idWithGeneration, Storage.BlobSourceOption.generationMatch());
        } else {
          return storage.delete(
              idWithGeneration,
              Storage.BlobSourceOption.generationMatch(),
              Storage.BlobSourceOption.userProject(userProject));
        }
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

    boolean replaceExisting = false;
    boolean atomicMove = false;
    boolean hasCloudStorageOptions = false;
    for (CopyOption option : options) {
      if (option instanceof StandardCopyOption) {
        switch ((StandardCopyOption) option) {
          case COPY_ATTRIBUTES:
            // The Objects: move API copies attributes by default.
            break;
          case REPLACE_EXISTING:
            replaceExisting = true;
            break;
          case ATOMIC_MOVE:
            atomicMove = true;
            break;
          default:
            throw new UnsupportedOperationException(option.toString());
        }
      }
      hasCloudStorageOptions = option instanceof CloudStorageOption;
    }

    CloudStoragePath fromPath = CloudStorageUtil.checkPath(source);
    if (fromPath.seemsLikeADirectoryAndUsePseudoDirectories(null)) {
      throw new CloudStoragePseudoDirectoryException(fromPath);
    }
    CloudStoragePath toPath = CloudStorageUtil.checkPath(target);
    if (toPath.seemsLikeADirectoryAndUsePseudoDirectories(null)) {
      throw new CloudStoragePseudoDirectoryException(toPath);
    }
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
    boolean crossBucketMove = !fromPath.bucket().equals(toPath.bucket());
    if (atomicMove) {
      if (hasCloudStorageOptions) {
        throw new AtomicMoveNotSupportedException(
            source.toString(),
            target.toString(),
            "Cloud Storage does not support atomic move operations with CloudStorageOptions.");
      }
      if (crossBucketMove) {
        throw new AtomicMoveNotSupportedException(
            source.toString(),
            target.toString(),
            "Cloud Storage does not support atomic move operations between buckets.");
      }
    } else if (hasCloudStorageOptions || crossBucketMove) {
      // Fall back to copy and delete if atomic move is not possible.
      copy(source, target, options);
      delete(source);
      return;
    }

    Storage.MoveBlobRequest.Builder builder =
        Storage.MoveBlobRequest.newBuilder()
            .setSource(fromPath.getBlobId())
            .setTarget(toPath.getBlobId());
    if (!replaceExisting) {
      builder.setTargetOptions(BlobTargetOption.doesNotExist());
    }
    Storage.MoveBlobRequest request = builder.build();
    CloudStorageRetryHandler retryHandler =
        new CloudStorageRetryHandler(fromPath.getFileSystem().config());
    while (true) {
      try {
        storage.moveBlob(request);
        break;
      } catch (StorageException e) {
        try {
          retryHandler.handleStorageException(e);
        } catch (StorageException retriesExhaustedException) {
          throw asIoException(retriesExhaustedException, true);
        }
      }
    }
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
    // We refuse to use paths that end in '/'. If the user puts a folder name
    // but without the '/', they'll get whatever error GCS will return normally
    // (if any).
    if (fromPath.seemsLikeADirectoryAndUsePseudoDirectories(null)) {
      throw new CloudStoragePseudoDirectoryException(fromPath);
    }
    if (toPath.seemsLikeADirectoryAndUsePseudoDirectories(null)) {
      throw new CloudStoragePseudoDirectoryException(toPath);
    }

    final CloudStorageRetryHandler retryHandler =
        new CloudStorageRetryHandler(fromPath.getFileSystem().config());
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        if (wantCopyAttributes) {
          BlobInfo blobInfo;
          if (isNullOrEmpty(userProject)) {
            blobInfo = storage.get(fromPath.getBlobId());
          } else {
            blobInfo = storage.get(fromPath.getBlobId(), BlobGetOption.userProject(userProject));
          }
          if (null == blobInfo) {
            throw new NoSuchFileException(fromPath.toString());
          }
          if (!overrideCacheControl) {
            tgtInfoBuilder.setCacheControl(blobInfo.getCacheControl());
          }
          if (!overrideContentType) {
            tgtInfoBuilder.setContentType(blobInfo.getContentType());
          }
          if (!overrideContentEncoding) {
            tgtInfoBuilder.setContentEncoding(blobInfo.getContentEncoding());
          }
          if (!overrideContentDisposition) {
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
          copyReqBuilder =
              copyReqBuilder.setTarget(tgtInfo, Storage.BlobTargetOption.doesNotExist());
        }
        if (!isNullOrEmpty(fromPath.getFileSystem().config().userProject())) {
          copyReqBuilder =
              copyReqBuilder.setSourceOptions(
                  BlobSourceOption.userProject(fromPath.getFileSystem().config().userProject()));
        } else if (!isNullOrEmpty(toPath.getFileSystem().config().userProject())) {
          copyReqBuilder =
              copyReqBuilder.setSourceOptions(
                  BlobSourceOption.userProject(toPath.getFileSystem().config().userProject()));
        }
        CopyWriter copyWriter = storage.copy(copyReqBuilder.build());
        copyWriter.getResult();
        break;
      } catch (StorageException oops) {
        try {
          // Will rethrow a StorageException if all retries/reopens are exhausted
          retryHandler.handleStorageException(oops);
          // we're being aggressive by retrying even on scenarios where we'd normally reopen.
        } catch (StorageException retriesExhaustedException) {
          throw asIoException(retriesExhaustedException, true);
        }
      }
    }
  }

  @Override
  public boolean isSameFile(Path path, Path path2) {
    return CloudStorageUtil.checkPath(path).equals(CloudStorageUtil.checkPath(path2));
  }

  /** Always returns {@code false}, because Google Cloud Storage doesn't support hidden files. */
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

    final CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    final CloudStorageRetryHandler retryHandler =
        new CloudStorageRetryHandler(cloudPath.getFileSystem().config());
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        // Edge case is the root directory which triggers the storage.get to throw a
        // StorageException.
        if (cloudPath.normalize().equals(cloudPath.getRoot())) {
          return;
        }
        boolean nullId;
        if (isNullOrEmpty(userProject)) {
          nullId =
              storage.get(cloudPath.getBlobId(), Storage.BlobGetOption.fields(Storage.BlobField.ID))
                  == null;
        } else {
          nullId =
              storage.get(
                      cloudPath.getBlobId(),
                      Storage.BlobGetOption.fields(Storage.BlobField.ID),
                      Storage.BlobGetOption.userProject(userProject))
                  == null;
        }
        if (nullId) {
          if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories(storage)) {
            // there is no such file, but we're not signalling error because the
            // path is a pseudo-directory.
            return;
          }
          throw new NoSuchFileException(path.toString());
        }
        break;
      } catch (StorageException exs) {
        // Will rethrow a StorageException if all retries/reopens are exhausted
        retryHandler.handleStorageException(exs);
        // we're being aggressive by retrying even on scenarios where we'd normally reopen.
      } catch (IllegalArgumentException exs) {
        if (CloudStorageUtil.checkPath(path).seemsLikeADirectoryAndUsePseudoDirectories(storage)) {
          // there is no such file, but we're not signalling error because the
          // path is a pseudo-directory.
          return;
        }
        // Other cause for IAE, forward the exception.
        throw exs;
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

    final CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    final CloudStorageRetryHandler retryHandler =
        new CloudStorageRetryHandler(cloudPath.getFileSystem().config());
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        BlobInfo blobInfo = null;
        try {
          BlobId blobId = cloudPath.getBlobId();
          // Null or empty name won't give us a file, so skip. But perhaps it's a pseudodir.
          if (!isNullOrEmpty(blobId.getName())) {
            if (isNullOrEmpty(userProject)) {
              blobInfo = storage.get(blobId);
            } else {
              blobInfo = storage.get(blobId, BlobGetOption.userProject(userProject));
            }
          }
        } catch (IllegalArgumentException ex) {
          // the path may be invalid but look like a folder. In that case, return a folder.
          if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories(storage)) {
            @SuppressWarnings("unchecked")
            A result = (A) new CloudStoragePseudoDirectoryAttributes(cloudPath);
            return result;
          }
          // No? Propagate.
          throw ex;
        }
        // null size indicate a file that we haven't closed yet, so GCS treats it as not there yet.
        if (null == blobInfo || blobInfo.getSize() == null) {
          if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories(storage)) {
            @SuppressWarnings("unchecked")
            A result = (A) new CloudStoragePseudoDirectoryAttributes(cloudPath);
            return result;
          }
          throw new NoSuchFileException(
              "gs://" + cloudPath.getBlobId().getBucket() + "/" + cloudPath.getBlobId().getName());
        }
        CloudStorageObjectAttributes ret;
        ret = new CloudStorageObjectAttributes(blobInfo);
        /*
          There exists a file with this name, yes. But should we pretend it's a directory?
          The web UI will allow the user to "create directories" by creating files
          whose name ends in slash (and these files aren't always zero-size).
          If we're set to use pseudo directories and the file name looks like a path,
          then say it's a directory. We pass null to avoid trying to actually list files;
          if the path doesn't end in "/" we'll truthfully say it's a file. Yes it may also be
          a directory but we don't want to do a prefix search every time the user stats a file.
        */
        if (cloudPath.seemsLikeADirectoryAndUsePseudoDirectories(null)) {
          @SuppressWarnings("unchecked")
          A result = (A) new CloudStoragePseudoDirectoryAttributes(cloudPath);
          return result;
        }
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
  public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options)
      throws IOException {
    // TODO(#811): Java 7 NIO defines at least eleven string attributes we'd want to support
    //             (eg. BasicFileAttributeView and PosixFileAttributeView), so rather than a partial
    //             implementation we rely on the other overload for now.

    // Partial implementation for a few commonly used ones: basic, gcs, posix
    String[] split = attributes.split(":", 2);
    if (split.length != 2) {
      throw new UnsupportedOperationException();
    }
    String view = split[0];
    List<String> attributeNames = Arrays.asList(split[1].split(","));
    boolean allAttributes = attributeNames.size() == 1 && attributeNames.get(0).equals("*");

    BasicFileAttributes fileAttributes;

    Map<String, Object> results = new TreeMap<>();
    switch (view) {
      case "gcs":
        fileAttributes = readAttributes(path, CloudStorageFileAttributes.class, options);
        break;
      case "posix":
      // There is no real support for posix.
      // Some systems expect Posix support for everything so these attributes are faked.
      case "basic":
        fileAttributes = readAttributes(path, BasicFileAttributes.class, options);
        break;
      default:
        throw new UnsupportedOperationException();
    }

    if (fileAttributes == null) {
      throw new UnsupportedOperationException();
    }

    // BasicFileAttributes
    if (allAttributes || attributeNames.contains("lastModifiedTime")) {
      results.put("lastModifiedTime", fileAttributes.lastModifiedTime());
    }
    if (allAttributes || attributeNames.contains("lastAccessTime")) {
      results.put("lastAccessTime", fileAttributes.lastAccessTime());
    }
    if (allAttributes || attributeNames.contains("creationTime")) {
      results.put("creationTime", fileAttributes.creationTime());
    }
    if (allAttributes || attributeNames.contains("isRegularFile")) {
      results.put("isRegularFile", fileAttributes.isRegularFile());
    }
    if (allAttributes || attributeNames.contains("isDirectory")) {
      results.put("isDirectory", fileAttributes.isDirectory());
    }
    if (allAttributes || attributeNames.contains("isSymbolicLink")) {
      results.put("isSymbolicLink", fileAttributes.isSymbolicLink());
    }
    if (allAttributes || attributeNames.contains("isOther")) {
      results.put("isOther", fileAttributes.isOther());
    }
    if (allAttributes || attributeNames.contains("size")) {
      results.put("size", fileAttributes.size());
    }

    // There is no real support for posix.
    // Some systems fail if there is no posix support at all.
    // To let these systems use this FileSystem these attributes are faked.
    if (view.equals("posix")) {
      if (allAttributes || attributeNames.contains("owner")) {
        results.put(
            "owner",
            new UserPrincipal() {
              @Override
              public String getName() {
                return "fakeowner";
              }

              @Override
              public String toString() {
                return "fakeowner";
              }
            });
      }
      if (allAttributes || attributeNames.contains("group")) {
        results.put(
            "group",
            new GroupPrincipal() {
              @Override
              public String getName() {
                return "fakegroup";
              }

              @Override
              public String toString() {
                return "fakegroup";
              }
            });
      }
      if (allAttributes || attributeNames.contains("permissions")) {
        if (fileAttributes.isRegularFile()) {
          results.put("permissions", EnumSet.of(OWNER_READ, OWNER_WRITE, GROUP_READ, GROUP_WRITE));
        } else {
          // Directories, Symlinks and Other:
          results.put(
              "permissions",
              EnumSet.of(
                  OWNER_READ, OWNER_WRITE, OWNER_EXECUTE, GROUP_READ, GROUP_WRITE, GROUP_EXECUTE));
        }
      }
    }

    // CloudStorageFileAttributes
    if (fileAttributes instanceof CloudStorageFileAttributes) {
      CloudStorageFileAttributes cloudStorageFileAttributes =
          (CloudStorageFileAttributes) fileAttributes;
      if (allAttributes || attributeNames.contains("etag")) {
        results.put("etag", cloudStorageFileAttributes.etag());
      }
      if (allAttributes || attributeNames.contains("mimeType")) {
        results.put("mimeType", cloudStorageFileAttributes.mimeType());
      }
      if (allAttributes || attributeNames.contains("acl")) {
        results.put("acl", cloudStorageFileAttributes.acl());
      }
      if (allAttributes || attributeNames.contains("cacheControl")) {
        results.put("cacheControl", cloudStorageFileAttributes.cacheControl());
      }
      if (allAttributes || attributeNames.contains("contentEncoding")) {
        results.put("contentEncoding", cloudStorageFileAttributes.contentEncoding());
      }
      if (allAttributes || attributeNames.contains("contentDisposition")) {
        results.put("contentDisposition", cloudStorageFileAttributes.contentDisposition());
      }
      if (allAttributes || attributeNames.contains("userMetadata")) {
        results.put("userMetadata", cloudStorageFileAttributes.userMetadata());
      }
    }

    return results;
  }

  @Override
  public <V extends FileAttributeView> V getFileAttributeView(
      Path path, Class<V> type, LinkOption... options) {
    checkNotNull(path);
    checkNotNull(type);
    CloudStorageUtil.checkNotNullArray(options);
    if (type != CloudStorageFileAttributeView.class && type != BasicFileAttributeView.class) {
      // the javadocs for getFileAttributeView specify the following for @return
      //  a file attribute view of the specified type, or null if the attribute view type is not
      //  available
      // Similar type of issue from the JDK itself https://bugs.openjdk.org/browse/JDK-8273935
      return null;
    }
    CloudStoragePath cloudPath = CloudStorageUtil.checkPath(path);
    @SuppressWarnings("unchecked")
    V result = (V) new CloudStorageFileAttributeView(storage, cloudPath);
    return result;
  }

  /** Does nothing since Google Cloud Storage uses fake directories. */
  @Override
  public void createDirectory(Path dir, FileAttribute<?>... attrs) {
    CloudStorageUtil.checkPath(dir);
    CloudStorageUtil.checkNotNullArray(attrs);
  }

  @Override
  public DirectoryStream<Path> newDirectoryStream(
      final Path dir, final Filter<? super Path> filter) {
    final CloudStoragePath cloudPath = CloudStorageUtil.checkPath(dir);
    checkNotNull(filter);
    initStorage();

    final CloudStorageRetryHandler retryHandler =
        new CloudStorageRetryHandler(cloudPath.getFileSystem().config());
    // Loop will terminate via an exception if all retries are exhausted
    while (true) {
      try {
        String prePrefix = cloudPath.normalize().toRealPath().toString();
        // we can recognize paths without the final "/" as folders,
        // but storage.list doesn't do the right thing with those, we need to append a "/".
        if (!prePrefix.isEmpty() && !prePrefix.endsWith("/")) {
          prePrefix += "/";
        }
        final String prefix = prePrefix;
        Page<Blob> dirList;
        if (isNullOrEmpty(userProject)) {
          dirList =
              storage.list(
                  cloudPath.bucket(),
                  Storage.BlobListOption.prefix(prefix),
                  Storage.BlobListOption.currentDirectory(),
                  Storage.BlobListOption.fields());
        } else {
          dirList =
              storage.list(
                  cloudPath.bucket(),
                  Storage.BlobListOption.prefix(prefix),
                  Storage.BlobListOption.currentDirectory(),
                  Storage.BlobListOption.fields(),
                  Storage.BlobListOption.userProject(userProject));
        }
        final Iterator<Blob> blobIterator = dirList.iterateAll().iterator();
        return new DirectoryStream<Path>() {
          @Override
          public Iterator<Path> iterator() {
            return new LazyPathIterator(
                cloudPath.getFileSystem(), prefix, blobIterator, filter, dir.isAbsolute());
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

  /** Throws {@link UnsupportedOperationException} because Cloud Storage objects are immutable. */
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

  /**
   * @param bucketName the name of the bucket to check
   * @return whether requester pays is enabled for that bucket
   */
  public boolean requesterPays(String bucketName) {
    initStorage();
    try {
      final Bucket bucket = storage.get(bucketName);
      // If the bucket doesn't exist it can't be requester pays.
      if (bucket == null) {
        return false;
      }
      // instead of true/false, this method returns true/null
      Boolean isRP = bucket.requesterPays();
      return isRP != null && isRP.booleanValue();
    } catch (StorageException ex) {
      if ("userProjectMissing".equals(ex.getReason())) {
        return true;
        // fallback to checking the error code and error message.
      } else if (ex.getCode() == 400
          && ex.getMessage() != null
          && ex.getMessage().contains("requester pays")) {
        return true;
      }
      throw ex;
    }
  }

  /**
   * Returns a NEW CloudStorageFileSystemProvider identical to this one, but with userProject
   * removed.
   *
   * <p>Perhaps you want to call this is you realize you'll be working on a bucket that is not
   * requester-pays.
   */
  public CloudStorageFileSystemProvider withNoUserProject() {
    return new CloudStorageFileSystemProvider("", this.storageOptions);
  }

  /** Returns the project that is assigned to this provider. */
  public String getProject() {
    initStorage();
    return storage.getOptions().getProjectId();
  }

  /**
   * Lists the project's buckets. But use the one in CloudStorageFileSystem.
   *
   * <p>Example of listing buckets, specifying the page size and a name prefix.
   *
   * <pre>{@code
   * String prefix = "bucket_";
   * Page<Bucket> buckets = provider.listBuckets(BucketListOption.prefix(prefix));
   * Iterator<Bucket> bucketIterator = buckets.iterateAll();
   * while (bucketIterator.hasNext()) {
   *   Bucket bucket = bucketIterator.next();
   *   // do something with the bucket
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Page<Bucket> listBuckets(Storage.BucketListOption... options) {
    initStorage();
    return storage.list(options);
  }

  private IOException asIoException(StorageException oops, boolean operationWasCopy) {
    // RPC API can only throw StorageException, but CloudStorageFileSystemProvider
    // can only throw IOException. Square peg, round hole.
    // TODO(#810): Research if other codes should be translated similarly.
    if (oops.getCode() == 404) {
      return new NoSuchFileException(oops.getReason());
    } else if (operationWasCopy && oops.getCode() == 412) {
      return new FileAlreadyExistsException(
          String.format(
              "Copy failed for reason '%s'. This most likely means the destination already exists"
                  + " and java.nio.file.StandardCopyOption.REPLACE_EXISTING was not specified.",
              oops.getReason()));
    }

    Throwable cause = oops.getCause();
    try {
      if (cause instanceof FileAlreadyExistsException) {
        throw new FileAlreadyExistsException(((FileAlreadyExistsException) cause).getReason());
      }
      // fallback
      if (cause != null && cause instanceof IOException) {
        return (IOException) cause;
      }
    } catch (IOException okEx) {
      return okEx;
    }
    return new IOException(oops.getMessage(), oops);
  }

  @VisibleForTesting
  void doInitStorage() {
    this.storage =
        storageOptions != null
            ? storageOptions.getService()
            : StorageOptionsUtil.getDefaultInstance().getService();
  }
}

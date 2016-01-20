/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.gcloud.storage.Blob.BlobSourceOption.toGetOptions;
import static com.google.gcloud.storage.Blob.BlobSourceOption.toSourceOptions;

import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.StorageObject.Owner;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gcloud.ReadChannel;
import com.google.gcloud.WriteChannel;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpc.Tuple;
import com.google.gcloud.storage.Storage.BlobTargetOption;
import com.google.gcloud.storage.Storage.BlobWriteOption;
import com.google.gcloud.storage.Storage.CopyRequest;
import com.google.gcloud.storage.Storage.SignUrlOption;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * A Google cloud storage object.
 *
 * <p>Objects of this class are immutable. Operations that modify the blob like {@link #update} and
 * {@link #copyTo} return a new object. To get a {@code Blob} object with the most recent
 * information use {@link #reload}.
 * </p>
 */
public final class Blob implements Serializable {

  private static final long serialVersionUID = -2498298106157261711L;

  private final BlobId blobId;
  private final String id;
  private final String selfLink;
  private final String cacheControl;
  private final List<Acl> acl;
  private final Acl.Entity owner;
  private final Long size;
  private final String etag;
  private final String md5;
  private final String crc32c;
  private final String mediaLink;
  private final Map<String, String> metadata;
  private final Long metageneration;
  private final Long deleteTime;
  private final Long updateTime;
  private final String contentType;
  private final String contentEncoding;
  private final String contentDisposition;
  private final String contentLanguage;
  private final Integer componentCount;
  private final StorageOptions options;
  private transient Storage storage;

  /**
   * Class for specifying blob source options when {@code Blob} methods are used.
   */
  public static class BlobSourceOption extends Option {

    private static final long serialVersionUID = 4157314244790869346L;

    private BlobSourceOption(StorageRpc.Option rpcOption) {
      super(rpcOption, null);
    }

    private Storage.BlobSourceOption toSourceOptions(Blob blob) {
      switch (rpcOption()) {
        case IF_GENERATION_MATCH:
          return Storage.BlobSourceOption.generationMatch(blob.generation());
        case IF_GENERATION_NOT_MATCH:
          return Storage.BlobSourceOption.generationNotMatch(blob.generation());
        case IF_METAGENERATION_MATCH:
          return Storage.BlobSourceOption.metagenerationMatch(blob.metageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BlobSourceOption.metagenerationNotMatch(blob.metageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    private Storage.BlobGetOption toGetOption(Blob blob) {
      switch (rpcOption()) {
        case IF_GENERATION_MATCH:
          return Storage.BlobGetOption.generationMatch(blob.generation());
        case IF_GENERATION_NOT_MATCH:
          return Storage.BlobGetOption.generationNotMatch(blob.generation());
        case IF_METAGENERATION_MATCH:
          return Storage.BlobGetOption.metagenerationMatch(blob.metageneration());
        case IF_METAGENERATION_NOT_MATCH:
          return Storage.BlobGetOption.metagenerationNotMatch(blob.metageneration());
        default:
          throw new AssertionError("Unexpected enum value");
      }
    }

    /**
     * Returns an option for blob's generation match. If this option is used the request will fail
     * if generation does not match.
     */
    public static BlobSourceOption generationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_MATCH);
    }

    /**
     * Returns an option for blob's generation mismatch. If this option is used the request will
     * fail if generation matches.
     */
    public static BlobSourceOption generationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH);
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    public static BlobSourceOption metagenerationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches.
     */
    public static BlobSourceOption metagenerationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    static Storage.BlobSourceOption[] toSourceOptions(Blob blob,
        BlobSourceOption... options) {
      Storage.BlobSourceOption[] convertedOptions = new Storage.BlobSourceOption[options.length];
      int index = 0;
      for (BlobSourceOption option : options) {
        convertedOptions[index++] = option.toSourceOptions(blob);
      }
      return convertedOptions;
    }

    static Storage.BlobGetOption[] toGetOptions(Blob blob, BlobSourceOption... options) {
      Storage.BlobGetOption[] convertedOptions = new Storage.BlobGetOption[options.length];
      int index = 0;
      for (BlobSourceOption option : options) {
        convertedOptions[index++] = option.toGetOption(blob);
      }
      return convertedOptions;
    }
  }

  static final Function<Tuple<Storage, StorageObject>, Blob> FROM_PB_FUNCTION =
      new Function<Tuple<Storage, StorageObject>, Blob>() {
        @Override
        public Blob apply(Tuple<Storage, StorageObject> pb) {
          return Blob.fromPb(pb.x(), pb.y());
        }
      };
  static final Function<Blob, StorageObject> TO_PB_FUNCTION = new Function<Blob, StorageObject>() {
        @Override
    public StorageObject apply(Blob blob) {
      return blob.toPb();
    }
  };

  /**
   * This class is meant for internal use only. Users are discouraged from using this class.
   */
  public static final class ImmutableEmptyMap<K, V> extends AbstractMap<K, V> {

    @Override
    public Set<Entry<K, V>> entrySet() {
      return ImmutableSet.of();
    }
  }

  public static final class Builder {

    private BlobId blobId;
    private String id;
    private String contentType;
    private String contentEncoding;
    private String contentDisposition;
    private String contentLanguage;
    private Integer componentCount;
    private String cacheControl;
    private List<Acl> acl;
    private Acl.Entity owner;
    private Long size;
    private String etag;
    private String selfLink;
    private String md5;
    private String crc32c;
    private String mediaLink;
    private Map<String, String> metadata;
    private Long metageneration;
    private Long deleteTime;
    private Long updateTime;
    private Storage storage;

    private Builder() {}

    private Builder(Blob blob) {
      blobId = blob.blobId;
      id = blob.id;
      cacheControl = blob.cacheControl;
      contentEncoding = blob.contentEncoding;
      contentType = blob.contentType;
      contentDisposition = blob.contentDisposition;
      contentLanguage = blob.contentLanguage;
      componentCount = blob.componentCount;
      acl = blob.acl;
      owner = blob.owner;
      size = blob.size;
      etag = blob.etag;
      selfLink = blob.selfLink;
      md5 = blob.md5;
      crc32c = blob.crc32c;
      mediaLink = blob.mediaLink;
      metadata = blob.metadata;
      metageneration = blob.metageneration;
      deleteTime = blob.deleteTime;
      updateTime = blob.updateTime;
      storage = blob.storage;
    }

    /**
     * Sets the blob identity.
     */
    public Builder blobId(BlobId blobId) {
      this.blobId = checkNotNull(blobId);
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the blob's data content type.
     *
     * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.17">Content-Type</a>
     */
    public Builder contentType(String contentType) {
      this.contentType = firstNonNull(contentType, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content disposition.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6266">Content-Disposition</a>
     */
    public Builder contentDisposition(String contentDisposition) {
      this.contentDisposition = firstNonNull(contentDisposition, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content language.
     *
     * @see <a href="http://tools.ietf.org/html/bcp47">Content-Language</a>
     */
    public Builder contentLanguage(String contentLanguage) {
      this.contentLanguage = firstNonNull(contentLanguage, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's data content encoding.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-3.1.2.2">Content-Encoding</a>
     */
    public Builder contentEncoding(String contentEncoding) {
      this.contentEncoding = firstNonNull(contentEncoding, Data.<String>nullOf(String.class));
      return this;
    }

    Builder componentCount(Integer componentCount) {
      this.componentCount = componentCount;
      return this;
    }

    /**
     * Sets the blob's data cache control.
     *
     * @see <a href="https://tools.ietf.org/html/rfc7234#section-5.2">Cache-Control</a>
     */
    public Builder cacheControl(String cacheControl) {
      this.cacheControl = firstNonNull(cacheControl, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the blob's access control configuration.
     *
     * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
     *     About Access Control Lists</a>
     */
    public Builder acl(List<Acl> acl) {
      this.acl = acl != null ? ImmutableList.copyOf(acl) : null;
      return this;
    }

    Builder owner(Acl.Entity owner) {
      this.owner = owner;
      return this;
    }

    Builder size(Long size) {
      this.size = size;
      return this;
    }

    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * Sets the MD5 hash of blob's data. MD5 value must be encoded in base64.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
     *     Hashes and ETags: Best Practices</a>
     */
    public Builder md5(String md5) {
      this.md5 = firstNonNull(md5, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Sets the CRC32C checksum of blob's data as described in
     * <a href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> encoded in
     * base64 in big-endian order.
     *
     * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
     *     Hashes and ETags: Best Practices</a>
     */
    public Builder crc32c(String crc32c) {
      this.crc32c = firstNonNull(crc32c, Data.<String>nullOf(String.class));
      return this;
    }

    Builder mediaLink(String mediaLink) {
      this.mediaLink = mediaLink;
      return this;
    }

    /**
     * Sets the blob's user provided metadata.
     */
    public Builder metadata(Map<String, String> metadata) {
      this.metadata = metadata != null
          ? new HashMap<>(metadata) : Data.<Map<String, String>>nullOf(ImmutableEmptyMap.class);
      return this;
    }

    Builder metageneration(Long metageneration) {
      this.metageneration = metageneration;
      return this;
    }

    Builder deleteTime(Long deleteTime) {
      this.deleteTime = deleteTime;
      return this;
    }

    Builder updateTime(Long updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    /**
     * Sets the service object associated with this blob. This service object is used to send
     * requests relevant to this blob.
     */
    public Builder storage(Storage storage) {
      this.storage = storage;
      return this;
    }

    /**
     * Creates a {@code Blob} object.
     */
    public Blob build() {
      checkNotNull(blobId);
      checkNotNull(storage);
      return new Blob(this);
    }
  }

  private Blob(Builder builder) {
    blobId = builder.blobId;
    id = builder.id;
    cacheControl = builder.cacheControl;
    contentEncoding = builder.contentEncoding;
    contentType = builder.contentType;
    contentDisposition = builder.contentDisposition;
    contentLanguage = builder.contentLanguage;
    componentCount = builder.componentCount;
    acl = builder.acl;
    owner = builder.owner;
    size = builder.size;
    etag = builder.etag;
    selfLink = builder.selfLink;
    md5 = builder.md5;
    crc32c = builder.crc32c;
    mediaLink = builder.mediaLink;
    metadata = builder.metadata;
    metageneration = builder.metageneration;
    deleteTime = builder.deleteTime;
    updateTime = builder.updateTime;
    options = builder.storage.options();
    storage = builder.storage;
  }

  /**
   * Returns the blob's identity.
   */
  public BlobId blobId() {
    return blobId;
  }

  /**
   * Returns the name of the containing bucket.
   */
  public String bucket() {
    return blobId().bucket();
  }

  /**
   * Returns the blob's id.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the blob's name.
   */
  public String name() {
    return blobId().name();
  }

  /**
   * Returns the blob's data cache control.
   *
   * @see <a href="https://tools.ietf.org/html/rfc7234#section-5.2">Cache-Control</a>
   */
  public String cacheControl() {
    return Data.isNull(cacheControl) ? null : cacheControl;
  }

  /**
   * Returns the blob's access control configuration.
   *
   * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
   *     About Access Control Lists</a>
   */
  public List<Acl> acl() {
    return acl;
  }

  /**
   * Returns the blob's owner. This will always be the uploader of the blob.
   */
  public Acl.Entity owner() {
    return owner;
  }

  /**
   * Returns the content length of the data in bytes.
   *
   * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.13">Content-Length</a>
   */
  public Long size() {
    return size;
  }

  /**
   * Returns the blob's data content type.
   *
   * @see <a href="https://tools.ietf.org/html/rfc2616#section-14.17">Content-Type</a>
   */
  public String contentType() {
    return Data.isNull(contentType) ? null : contentType;
  }

  /**
   * Returns the blob's data content encoding.
   *
   * @see <a href="https://tools.ietf.org/html/rfc7231#section-3.1.2.2">Content-Encoding</a>
   */
  public String contentEncoding() {
    return Data.isNull(contentEncoding) ? null : contentEncoding;
  }

  /**
   * Returns the blob's data content disposition.
   *
   * @see <a href="https://tools.ietf.org/html/rfc6266">Content-Disposition</a>
   */
  public String contentDisposition() {
    return Data.isNull(contentDisposition) ? null : contentDisposition;
  }

  /**
   * Returns the blob's data content language.
   *
   * @see <a href="http://tools.ietf.org/html/bcp47">Content-Language</a>
   */
  public String contentLanguage() {
    return Data.isNull(contentLanguage) ? null : contentLanguage;
  }

  /**
   * Returns the number of components that make up this blob. Components are accumulated through
   * the {@link Storage#compose(Storage.ComposeRequest)} operation and are limited to a count of
   * 1024, counting 1 for each non-composite component blob and componentCount for each composite
   * component blob. This value is set only for composite blobs.
   *
   * @see <a href="https://cloud.google.com/storage/docs/composite-objects#_Count">Component Count
   *     Property</a>
   */
  public Integer componentCount() {
    return componentCount;
  }

  /**
   * Returns HTTP 1.1 Entity tag for the blob.
   *
   * @see <a href="http://tools.ietf.org/html/rfc2616#section-3.11">Entity Tags</a>
   */
  public String etag() {
    return etag;
  }

  /**
   * Returns the URI of this blob as a string.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns the MD5 hash of blob's data encoded in base64.
   *
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
   *     Hashes and ETags: Best Practices</a>
   */
  public String md5() {
    return Data.isNull(md5) ? null : md5;
  }

  /**
   * Returns the CRC32C checksum of blob's data as described in
   * <a href="http://tools.ietf.org/html/rfc4960#appendix-B">RFC 4960, Appendix B;</a> encoded in
   * base64 in big-endian order.
   *
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags#_JSONAPI">
   *     Hashes and ETags: Best Practices</a>
   */
  public String crc32c() {
    return Data.isNull(crc32c) ? null : crc32c;
  }

  /**
   * Returns the blob's media download link.
   */
  public String mediaLink() {
    return mediaLink;
  }

  /**
   * Returns blob's user provided metadata.
   */
  public Map<String, String> metadata() {
    return metadata == null || Data.isNull(metadata) ? null : Collections.unmodifiableMap(metadata);
  }

  /**
   * Returns blob's data generation. Used for blob versioning.
   */
  public Long generation() {
    return blobId().generation();
  }

  /**
   * Returns blob's metageneration. Used for preconditions and for detecting changes in metadata.
   * A metageneration number is only meaningful in the context of a particular generation of a
   * particular blob.
   */
  public Long metageneration() {
    return metageneration;
  }

  /**
   * Returns the deletion time of the blob.
   */
  public Long deleteTime() {
    return deleteTime;
  }

  /**
   * Returns the last modification time of the blob's metadata.
   */
  public Long updateTime() {
    return updateTime;
  }

  /**
   * Returns the service options associated with this blob.
   */
  public StorageOptions options() {
    return options;
  }

  /**
   * Returns the service object associated with this blob.
   */
  public Storage storage() {
    return storage;
  }

  /**
   * Returns a builder for the current blob.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bucket", bucket())
        .add("name", name())
        .add("generation", generation())
        .add("size", size())
        .add("content-type", contentType())
        .add("metadata", metadata())
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(blobId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Blob && Objects.equals(toPb(), ((Blob) obj).toPb())
        && Objects.equals(options, ((Blob) obj).options);
  }

  StorageObject toPb() {
    StorageObject storageObject = blobId.toPb();
    if (acl != null) {
      storageObject.setAcl(Lists.transform(acl, new Function<Acl, ObjectAccessControl>() {
        @Override
        public ObjectAccessControl apply(Acl acl) {
          return acl.toObjectPb();
        }
      }));
    }
    if (deleteTime != null) {
      storageObject.setTimeDeleted(new DateTime(deleteTime));
    }
    if (updateTime != null) {
      storageObject.setUpdated(new DateTime(updateTime));
    }
    if (size != null) {
      storageObject.setSize(BigInteger.valueOf(size));
    }
    if (owner != null) {
      storageObject.setOwner(new Owner().setEntity(owner.toPb()));
    }
    Map<String, String> pbMetadata = metadata;
    if (metadata != null && !Data.isNull(metadata)) {
      pbMetadata = Maps.newHashMapWithExpectedSize(metadata.size());
      for (Map.Entry<String, String> entry : metadata.entrySet()) {
        pbMetadata.put(entry.getKey(),
            firstNonNull(entry.getValue(), Data.<String>nullOf(String.class)));
      }
    }
    storageObject.setMetadata(pbMetadata);
    storageObject.setCacheControl(cacheControl);
    storageObject.setContentEncoding(contentEncoding);
    storageObject.setCrc32c(crc32c);
    storageObject.setContentType(contentType);
    storageObject.setMd5Hash(md5);
    storageObject.setMediaLink(mediaLink);
    storageObject.setMetageneration(metageneration);
    storageObject.setContentDisposition(contentDisposition);
    storageObject.setComponentCount(componentCount);
    storageObject.setContentLanguage(contentLanguage);
    storageObject.setEtag(etag);
    storageObject.setId(id);
    storageObject.setSelfLink(selfLink);
    return storageObject;
  }

  /**
   * Returns a {@code Blob} builder where blob identity is set using the provided values.
   */
  public static Builder builder(Storage storage, Bucket bucket, String name) {
    return builder(storage, bucket.name(), name);
  }

  /**
   * Returns a {@code Blob} builder where blob identity is set using the provided values.
   */
  public static Builder builder(Storage storage, String bucket, String name) {
    return new Builder().blobId(BlobId.of(bucket, name)).storage(storage);
  }

  /**
   * Returns a {@code Blob} builder where blob identity is set using the provided values.
   */
  public static Builder builder(
Storage storage, Bucket bucket, String name, Long generation) {
    return builder(storage, bucket.name(), name, generation);
  }

  /**
   * Returns a {@code Blob} builder where blob identity is set using the provided values.
   */
  public static Builder builder(Storage storage, String bucket, String name, Long generation) {
    return new Builder().blobId(BlobId.of(bucket, name, generation)).storage(storage);
  }

  public static Builder builder(Storage storage, BlobId blobId) {
    return new Builder().blobId(blobId).storage(storage);
  }

  static Blob fromPb(Storage storage, StorageObject storageObject) {
    Builder builder = builder(storage, BlobId.fromPb(storageObject));
    if (storageObject.getCacheControl() != null) {
      builder.cacheControl(storageObject.getCacheControl());
    }
    if (storageObject.getContentEncoding() != null) {
      builder.contentEncoding(storageObject.getContentEncoding());
    }
    if (storageObject.getCrc32c() != null) {
      builder.crc32c(storageObject.getCrc32c());
    }
    if (storageObject.getContentType() != null) {
      builder.contentType(storageObject.getContentType());
    }
    if (storageObject.getMd5Hash() != null) {
      builder.md5(storageObject.getMd5Hash());
    }
    if (storageObject.getMediaLink() != null) {
      builder.mediaLink(storageObject.getMediaLink());
    }
    if (storageObject.getMetageneration() != null) {
      builder.metageneration(storageObject.getMetageneration());
    }
    if (storageObject.getContentDisposition() != null) {
      builder.contentDisposition(storageObject.getContentDisposition());
    }
    if (storageObject.getComponentCount() != null) {
      builder.componentCount(storageObject.getComponentCount());
    }
    if (storageObject.getContentLanguage() != null) {
      builder.contentLanguage(storageObject.getContentLanguage());
    }
    if (storageObject.getEtag() != null) {
      builder.etag(storageObject.getEtag());
    }
    if (storageObject.getId() != null) {
      builder.id(storageObject.getId());
    }
    if (storageObject.getSelfLink() != null) {
      builder.selfLink(storageObject.getSelfLink());
    }
    if (storageObject.getMetadata() != null) {
      builder.metadata(storageObject.getMetadata());
    }
    if (storageObject.getTimeDeleted() != null) {
      builder.deleteTime(storageObject.getTimeDeleted().getValue());
    }
    if (storageObject.getUpdated() != null) {
      builder.updateTime(storageObject.getUpdated().getValue());
    }
    if (storageObject.getSize() != null) {
      builder.size(storageObject.getSize().longValue());
    }
    if (storageObject.getOwner() != null) {
      builder.owner(Acl.Entity.fromPb(storageObject.getOwner().getEntity()));
    }
    if (storageObject.getAcl() != null) {
      builder.acl(Lists.transform(storageObject.getAcl(), new Function<ObjectAccessControl, Acl>() {
        @Override
        public Acl apply(ObjectAccessControl objectAccessControl) {
          return Acl.fromPb(objectAccessControl);
        }
      }));
    }
    return builder.build();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.storage = options.service();
  }

  /**
   * Create a new blob with no content.
   *
   * @return a complete blob
   * @throws StorageException upon failure
   */
  public Blob create(BlobTargetOption... options) {
    return storage.create(this, options);
  }

  /**
   * Create a new blob. Direct upload is used to upload {@code content}. For large content,
   * {@link #writer} is recommended as it uses resumable upload. MD5 and CRC32C hashes of
   * {@code content} are computed and used for validating transferred data.
   *
   * @return a complete blob
   * @throws StorageException upon failure
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags">Hashes and ETags</a>
   */
  public Blob create(byte[] content, BlobTargetOption... options) {
    return storage.create(this, content, options);
  }

  /**
   * Create a new blob. Direct upload is used to upload {@code content}. For large content,
   * {@link #writer} is recommended as it uses resumable upload. By default any md5 and crc32c
   * values in the given {@code blob} are ignored unless requested via the
   * {@code BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * @return a complete blob
   * @throws StorageException upon failure
   */
  public Blob create(InputStream content, BlobWriteOption... options) {
    return storage.create(this, content, options);
  }

  /**
   * Creates a {@code Blob} object for the provided bucket and blob names. Performs an RPC call to
   * get the latest blob information. Returns {@code null} if the blob does not exist.
   *
   * @param storage the storage service used for issuing requests
   * @param bucket bucket's name
   * @param options blob get options
   * @param blob blob's name
   * @return the {@code Blob} object or {@code null} if not found
   * @throws StorageException upon failure
   */
  public static Blob get(Storage storage, String bucket, String blob,
      Storage.BlobGetOption... options) {
    return get(storage, BlobId.of(bucket, blob), options);
  }

  /**
   * Creates a {@code Blob} object for the provided {@code blobId}. Performs an RPC call to get the
   * latest blob information. Returns {@code null} if the blob does not exist.
   *
   * @param storage the storage service used for issuing requests
   * @param blobId blob's identifier
   * @param options blob get options
   * @return the {@code Blob} object or {@code null} if not found
   * @throws StorageException upon failure
   */
  public static Blob get(Storage storage, BlobId blobId, Storage.BlobGetOption... options) {
    return storage.get(blobId, options);
  }

  /**
   * Checks if this blob exists.
   *
   * @param options blob read options
   * @return true if this blob exists, false otherwise
   * @throws StorageException upon failure
   */
  public boolean exists(BlobSourceOption... options) {
    int length = options.length;
    Storage.BlobGetOption[] getOptions = Arrays.copyOf(toGetOptions(this, options), length + 1);
    getOptions[length] = Storage.BlobGetOption.fields();
    return storage.get(blobId, getOptions) != null;
  }

  /**
   * Returns this blob's content.
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  public byte[] content(Storage.BlobSourceOption... options) {
    return storage.readAllBytes(blobId, options);
  }

  /**
   * Fetches current blob's latest information. Returns {@code null} if the blob does not exist.
   *
   * @param options blob read options
   * @return a {@code Blob} object with latest information or {@code null} if not found
   * @throws StorageException upon failure
   */
  public Blob reload(BlobSourceOption... options) {
    return Blob.get(storage, blobId, toGetOptions(this, options));
  }

  /**
   * Updates the blob's information. Bucket or blob's name cannot be changed by this method. If you
   * want to rename the blob or move it to a different bucket use the {@link #copyTo} and
   * {@link #delete} operations. A new {@code Blob} object is returned. By default no checks are
   * made on the metadata generation of the current blob. If you want to update the information only
   * if the current blob metadata are at their latest version use the {@code metagenerationMatch}
   * option: {@code blob.update(newBlob, BlobTargetOption.metagenerationMatch())}.
   *
   * <p>Original metadata are merged with metadata in the provided {@code blob}. To replace
   * metadata instead you first have to unset them. Unsetting metadata can be done by setting the
   * provided {@code blob}'s metadata to {@code null}.
   * </p>
   *
   * <p>Example usage of replacing blob's metadata:
   * <pre>    {@code blob.update(blob.toBuilder().metadata(null).build());}
   *    {@code blob.update(blob.toBuilder().metadata(newMetadata).build());}
   * </pre>
   *
   * @param blob the new blob. Bucket and blob names must match the current ones
   * @param options update options
   * @return a {@code Blob} object with updated information
   * @throws StorageException upon failure
   */
  public Blob update(Blob blob, BlobTargetOption... options) {
    checkArgument(Objects.equals(blob.bucket(), bucket()), "Bucket name must match");
    checkArgument(Objects.equals(blob.name(), name()), "Blob name must match");
    return storage.update(blob, options);
  }

  /**
   * Deletes this blob.
   *
   * @param options blob delete options
   * @return {@code true} if blob was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  public boolean delete(BlobSourceOption... options) {
    return storage.delete(blobId, toSourceOptions(this, options));
  }

  /**
   * Sends a copy request for the current blob to the target blob. Possibly also some of the
   * metadata are copied (e.g. content-type).
   *
   * @param targetBlob target blob's id
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  public CopyWriter copyTo(BlobId targetBlob, BlobSourceOption... options) {
    CopyRequest copyRequest =
        CopyRequest.builder()
            .source(this.bucket(), this.name())
            .sourceOptions(toSourceOptions(this, options))
            .target(storage, targetBlob)
            .build();
    return storage.copy(copyRequest);
  }

  /**
   * Sends a copy request for the current blob to the target bucket, preserving its name. Possibly
   * copying also some of the metadata (e.g. content-type).
   *
   * @param targetBucket target bucket's name
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  public CopyWriter copyTo(String targetBucket, BlobSourceOption... options) {
    return copyTo(targetBucket, name(), options);
  }

  /**
   * Sends a copy request for the current blob to the target blob. Possibly also some of the
   * metadata are copied (e.g. content-type).
   *
   * @param targetBucket target bucket's name
   * @param targetBlob target blob's name
   * @param options source blob options
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   */
  public CopyWriter copyTo(String targetBucket, String targetBlob, BlobSourceOption... options) {
    return copyTo(BlobId.of(targetBucket, targetBlob), options);
  }

  /**
   * Returns a {@code ReadChannel} object for reading this blob's content.
   *
   * @param options blob read options
   * @throws StorageException upon failure
   */
  public ReadChannel reader(BlobSourceOption... options) {
    return storage.reader(blobId, toSourceOptions(this, options));
  }

  /**
   * Returns a {@code WriteChannel} object for writing to this blob. By default any md5 and
   * crc32c values in the current blob are ignored unless requested via the
   * {@code BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * @param options target blob options
   * @throws StorageException upon failure
   */
  public WriteChannel writer(BlobWriteOption... options) {
    return storage.writer(this, options);
  }

  /**
   * Generates a signed URL for this blob. If you want to allow access to for a fixed amount of time
   * for this blob, you can use this method to generate a URL that is only valid within a certain
   * time period. This is particularly useful if you don't want publicly accessible blobs, but don't
   * want to require users to explicitly log in.
   *
   * @param duration time until the signed URL expires, expressed in {@code unit}. The finer
   *     granularity supported is 1 second, finer granularities will be truncated
   * @param unit time unit of the {@code duration} parameter
   * @param options optional URL signing options
   * @return a signed URL for this bucket and the specified options
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  public URL signUrl(long duration, TimeUnit unit, SignUrlOption... options) {
    return storage.signUrl(this, duration, unit, options);
  }

  /**
   * Gets the requested blobs. A batch request is used to fetch blobs.
   *
   * @param storage the storage service used to issue the request
   * @param first the first blob to get
   * @param second the second blob to get
   * @param other other blobs to get
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   *     been denied the corresponding item in the list is {@code null}
   * @throws StorageException upon failure
   */
  public static List<Blob> get(Storage storage, BlobId first, BlobId second, BlobId... other) {
    checkNotNull(storage);
    checkNotNull(first);
    checkNotNull(second);
    checkNotNull(other);
    ImmutableList<BlobId> blobs = ImmutableList.<BlobId>builder()
        .add(first)
        .add(second)
        .addAll(Arrays.asList(other))
        .build();
    return get(storage, blobs);
  }

  /**
   * Gets the requested blobs. A batch request is used to fetch blobs.
   *
   * @param storage the storage service used to issue the request
   * @param blobs list of blobs to get
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   *     been denied the corresponding item in the list is {@code null}
   * @throws StorageException upon failure
   */
  public static List<Blob> get(final Storage storage, List<BlobId> blobs) {
    checkNotNull(storage);
    checkNotNull(blobs);
    BlobId[] blobArray = blobs.toArray(new BlobId[blobs.size()]);
    return Collections.unmodifiableList(storage.get(blobArray));
  }

  /**
   * Updates the requested blobs. A batch request is used to update blobs. Original metadata are
   * merged with metadata in the provided {@code Blob} objects. To replace metadata instead
   * you first have to unset them. Unsetting metadata can be done by setting the provided
   * {@code Blob} objects metadata to {@code null}. See
   * {@link #update(com.google.gcloud.storage.Blob,
   * com.google.gcloud.storage.Storage.BlobTargetOption...) } for a code example.
   *
   * @param storage the storage service used to issue the request
   * @param blobs the blobs to update
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   *     been denied the corresponding item in the list is {@code null}
   * @throws StorageException upon failure
   */
  public static List<Blob> update(final Storage storage, Blob... blobs) {
    checkNotNull(storage);
    checkNotNull(blobs);
    if (blobs.length == 0) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(storage.update(blobs));
  }

  /**
   * Deletes the requested blobs. A batch request is used to delete blobs.
   *
   * @param storage the storage service used to issue the request
   * @param blobs the blobs to delete
   * @return an immutable list of booleans. If a blob has been deleted the corresponding item in the
   *     list is {@code true}. If a blob was not found, deletion failed or access to the resource
   *     was denied the corresponding item is {@code false}
   * @throws StorageException upon failure
   */
  public static List<Boolean> delete(Storage storage, BlobId... blobs) {
    checkNotNull(storage);
    checkNotNull(blobs);
    if (blobs.length == 0) {
      return Collections.emptyList();
    }
    return storage.delete(blobs);
  }
}

/*
 * Copyright 2015 Google LLC
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

import com.google.api.gax.paging.Page;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.ServiceAccountSigner.SigningException;
import com.google.cloud.FieldSelector;
import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.GcpLaunchStage;
import com.google.cloud.Policy;
import com.google.cloud.ReadChannel;
import com.google.cloud.Service;
import com.google.cloud.Tuple;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.security.Key;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * An interface for Google Cloud Storage.
 *
 * @see <a href="https://cloud.google.com/storage/docs">Google Cloud Storage</a>
 */
public interface Storage extends Service<StorageOptions> {

  enum PredefinedAcl {
    AUTHENTICATED_READ("authenticatedRead"),
    ALL_AUTHENTICATED_USERS("allAuthenticatedUsers"),
    PRIVATE("private"),
    PROJECT_PRIVATE("projectPrivate"),
    PUBLIC_READ("publicRead"),
    PUBLIC_READ_WRITE("publicReadWrite"),
    BUCKET_OWNER_READ("bucketOwnerRead"),
    BUCKET_OWNER_FULL_CONTROL("bucketOwnerFullControl");

    private final String entry;

    PredefinedAcl(String entry) {
      this.entry = entry;
    }

    String getEntry() {
      return entry;
    }
  }

  enum BucketField implements FieldSelector {
    ID("id"),
    SELF_LINK("selfLink"),
    NAME("name"),
    TIME_CREATED("timeCreated"),
    METAGENERATION("metageneration"),
    ACL("acl"),
    DEFAULT_OBJECT_ACL("defaultObjectAcl"),
    OWNER("owner"),
    LOCATION("location"),
    WEBSITE("website"),
    VERSIONING("versioning"),
    CORS("cors"),
    STORAGE_CLASS("storageClass"),
    ETAG("etag"),
    ENCRYPTION("encryption"),
    BILLING("billing"),
    DEFAULT_EVENT_BASED_HOLD("defaultEventBasedHold"),
    RETENTION_POLICY("retentionPolicy");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(NAME);

    private final String selector;

    BucketField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }
  }


  enum BlobField implements FieldSelector {
    ACL("acl"),
    BUCKET("bucket"),
    CACHE_CONTROL("cacheControl"),
    COMPONENT_COUNT("componentCount"),
    CONTENT_DISPOSITION("contentDisposition"),
    CONTENT_ENCODING("contentEncoding"),
    CONTENT_LANGUAGE("contentLanguage"),
    CONTENT_TYPE("contentType"),
    CRC32C("crc32c"),
    ETAG("etag"),
    GENERATION("generation"),
    ID("id"),
    KIND("kind"),
    MD5HASH("md5Hash"),
    MEDIA_LINK("mediaLink"),
    METADATA("metadata"),
    METAGENERATION("metageneration"),
    NAME("name"),
    OWNER("owner"),
    SELF_LINK("selfLink"),
    SIZE("size"),
    STORAGE_CLASS("storageClass"),
    TIME_DELETED("timeDeleted"),
    TIME_CREATED("timeCreated"),
    KMS_KEY_NAME("kmsKeyName"),
    EVENT_BASED_HOLD("eventBasedHold"),
    TEMPORARY_HOLD("temporaryHold"),
    RETENTION_EXPIRATION_TIME("retentionExpirationTime"),
    UPDATED("updated");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(BUCKET, NAME);

    private final String selector;

    BlobField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }
  }


  /**
   * Class for specifying bucket target options.
   */
  class BucketTargetOption extends Option {

    private static final long serialVersionUID = -5880204616982900975L;

    private BucketTargetOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    private BucketTargetOption(StorageRpc.Option rpcOption) {
      this(rpcOption, null);
    }

    /**
     * Returns an option for specifying bucket's predefined ACL configuration.
     */
    public static BucketTargetOption predefinedAcl(PredefinedAcl acl) {
      return new BucketTargetOption(StorageRpc.Option.PREDEFINED_ACL, acl.getEntry());
    }

    /**
     * Returns an option for specifying bucket's default ACL configuration for blobs.
     */
    public static BucketTargetOption predefinedDefaultObjectAcl(PredefinedAcl acl) {
      return new BucketTargetOption(StorageRpc.Option.PREDEFINED_DEFAULT_OBJECT_ACL,
          acl.getEntry());
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    public static BucketTargetOption metagenerationMatch() {
      return new BucketTargetOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if metageneration matches.
     */
    public static BucketTargetOption metagenerationNotMatch() {
      return new BucketTargetOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    /**
     * Returns an option to define the billing user project. This option is required by buckets with
     * `requester_pays` flag enabled to assign operation costs.
     */
    public static BucketTargetOption userProject(String userProject) {
      return new BucketTargetOption(StorageRpc.Option.USER_PROJECT, userProject);
    }
  }

  /**
   * Class for specifying bucket source options.
   */
  class BucketSourceOption extends Option {

    private static final long serialVersionUID = 5185657617120212117L;

    private BucketSourceOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if bucket's metageneration does not match the provided value.
     */
    public static BucketSourceOption metagenerationMatch(long metageneration) {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH, metageneration);
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if bucket's metageneration matches the provided value.
     */
    public static BucketSourceOption metagenerationNotMatch(long metageneration) {
      return new BucketSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH, metageneration);
    }

    /**
     * Returns an option for bucket's billing user project. This option is only used by the buckets with
     * 'requester_pays' flag.
     */
    public static BucketSourceOption userProject(String userProject) {
      return new BucketSourceOption(StorageRpc.Option.USER_PROJECT, userProject);
    }
  }

  /**
   * Class for specifying bucket get options.
   */
  class BucketGetOption extends Option {

    private static final long serialVersionUID = 1901844869484087395L;

    private BucketGetOption(StorageRpc.Option rpcOption, long metageneration) {
      super(rpcOption, metageneration);
    }

    private BucketGetOption(StorageRpc.Option rpcOption, String value) {
      super(rpcOption, value);
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if bucket's metageneration does not match the provided value.
     */
    public static BucketGetOption metagenerationMatch(long metageneration) {
      return new BucketGetOption(StorageRpc.Option.IF_METAGENERATION_MATCH, metageneration);
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if bucket's metageneration matches the provided value.
     */
    public static BucketGetOption metagenerationNotMatch(long metageneration) {
      return new BucketGetOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH, metageneration);
    }

    /**
     * Returns an option for bucket's billing user project. This option is only used by the buckets with
     * 'requester_pays' flag.
     */
    public static BucketGetOption userProject(String userProject) {
      return new BucketGetOption(StorageRpc.Option.USER_PROJECT, userProject);
    }

    /**
     * Returns an option to specify the bucket's fields to be returned by the RPC call. If this
     * option is not provided all bucket's fields are returned. {@code BucketGetOption.fields}) can
     * be used to specify only the fields of interest. Bucket name is always returned, even if not
     * specified.
     */
    public static BucketGetOption fields(BucketField... fields) {
      return new BucketGetOption(StorageRpc.Option.FIELDS,
          Helper.selector(BucketField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying blob target options.
   */
  class BlobTargetOption extends Option {

    private static final long serialVersionUID = 214616862061934846L;

    private BlobTargetOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    private BlobTargetOption(StorageRpc.Option rpcOption) {
      this(rpcOption, null);
    }

    /**
     * Returns an option for specifying blob's predefined ACL configuration.
     */
    public static BlobTargetOption predefinedAcl(PredefinedAcl acl) {
      return new BlobTargetOption(StorageRpc.Option.PREDEFINED_ACL, acl.getEntry());
    }

    /**
     * Returns an option that causes an operation to succeed only if the target blob does not exist.
     */
    public static BlobTargetOption doesNotExist() {
      return new BlobTargetOption(StorageRpc.Option.IF_GENERATION_MATCH, 0L);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if generation does not match.
     */
    public static BlobTargetOption generationMatch() {
      return new BlobTargetOption(StorageRpc.Option.IF_GENERATION_MATCH);
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if generation matches.
     */
    public static BlobTargetOption generationNotMatch() {
      return new BlobTargetOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH);
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    public static BlobTargetOption metagenerationMatch() {
      return new BlobTargetOption(StorageRpc.Option.IF_METAGENERATION_MATCH);
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches.
     */
    public static BlobTargetOption metagenerationNotMatch() {
      return new BlobTargetOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH);
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    public static BlobTargetOption encryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new BlobTargetOption(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, base64Key);
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets with
     * 'requester_pays' flag.
     */
    public static BlobTargetOption userProject(String userProject) {
      return new BlobTargetOption(StorageRpc.Option.USER_PROJECT, userProject);
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    public static BlobTargetOption encryptionKey(String key) {
      return new BlobTargetOption(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, key);
    }

    /**
     * Returns an option to set a customer-managed key for server-side encryption of the blob.
     */
    public static BlobTargetOption kmsKeyName(String kmsKeyName) {
      return new BlobTargetOption(StorageRpc.Option.KMS_KEY_NAME, kmsKeyName);
    }

    static Tuple<BlobInfo, BlobTargetOption[]> convert(BlobInfo info, BlobWriteOption... options) {
      BlobInfo.Builder infoBuilder = info.toBuilder().setCrc32c(null).setMd5(null);
      List<BlobTargetOption> targetOptions = Lists.newArrayListWithCapacity(options.length);
      for (BlobWriteOption option : options) {
        switch (option.option) {
          case IF_CRC32C_MATCH:
            infoBuilder.setCrc32c(info.getCrc32c());
            break;
          case IF_MD5_MATCH:
            infoBuilder.setMd5(info.getMd5());
            break;
          default:
            targetOptions.add(option.toTargetOption());
            break;
        }
      }
      return Tuple.of(infoBuilder.build(),
          targetOptions.toArray(new BlobTargetOption[targetOptions.size()]));
    }
  }

  /**
   * Class for specifying blob write options.
   */
  class BlobWriteOption implements Serializable {

    private static final long serialVersionUID = -3880421670966224580L;

    private final Option option;
    private final Object value;

    enum Option {
      PREDEFINED_ACL, IF_GENERATION_MATCH, IF_GENERATION_NOT_MATCH, IF_METAGENERATION_MATCH,
      IF_METAGENERATION_NOT_MATCH, IF_MD5_MATCH, IF_CRC32C_MATCH, CUSTOMER_SUPPLIED_KEY, KMS_KEY_NAME, USER_PROJECT;

      StorageRpc.Option toRpcOption() {
        return StorageRpc.Option.valueOf(this.name());
      }
    }

    BlobTargetOption toTargetOption() {
      return new BlobTargetOption(this.option.toRpcOption(), this.value);
    }

    private BlobWriteOption(Option option, Object value) {
      this.option = option;
      this.value = value;
    }

    private BlobWriteOption(Option option) {
      this(option, null);
    }

    @Override
    public int hashCode() {
      return Objects.hash(option, value);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof BlobWriteOption)) {
        return false;
      }
      final BlobWriteOption other = (BlobWriteOption) obj;
      return this.option == other.option && Objects.equals(this.value, other.value);
    }

    /**
     * Returns an option for specifying blob's predefined ACL configuration.
     */
    public static BlobWriteOption predefinedAcl(PredefinedAcl acl) {
      return new BlobWriteOption(Option.PREDEFINED_ACL, acl.getEntry());
    }

    /**
     * Returns an option that causes an operation to succeed only if the target blob does not exist.
     */
    public static BlobWriteOption doesNotExist() {
      return new BlobWriteOption(Option.IF_GENERATION_MATCH, 0L);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if generation does not match.
     */
    public static BlobWriteOption generationMatch() {
      return new BlobWriteOption(Option.IF_GENERATION_MATCH);
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if generation matches.
     */
    public static BlobWriteOption generationNotMatch() {
      return new BlobWriteOption(Option.IF_GENERATION_NOT_MATCH);
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    public static BlobWriteOption metagenerationMatch() {
      return new BlobWriteOption(Option.IF_METAGENERATION_MATCH);
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches.
     */
    public static BlobWriteOption metagenerationNotMatch() {
      return new BlobWriteOption(Option.IF_METAGENERATION_NOT_MATCH);
    }

    /**
     * Returns an option for blob's data MD5 hash match. If this option is used the request will
     * fail if blobs' data MD5 hash does not match.
     */
    public static BlobWriteOption md5Match() {
      return new BlobWriteOption(Option.IF_MD5_MATCH, true);
    }

    /**
     * Returns an option for blob's data CRC32C checksum match. If this option is used the request
     * will fail if blobs' data CRC32C checksum does not match.
     */
    public static BlobWriteOption crc32cMatch() {
      return new BlobWriteOption(Option.IF_CRC32C_MATCH, true);
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    public static BlobWriteOption encryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new BlobWriteOption(Option.CUSTOMER_SUPPLIED_KEY, base64Key);
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    public static BlobWriteOption encryptionKey(String key) {
      return new BlobWriteOption(Option.CUSTOMER_SUPPLIED_KEY, key);
    }

    /**
     * Returns an option to set a customer-managed KMS key for server-side encryption of the
     * blob.
     *
     * @param kmsKeyName the KMS key resource id
     */
    public static BlobWriteOption kmsKeyName(String kmsKeyName) {
      return new BlobWriteOption(Option.KMS_KEY_NAME, kmsKeyName);
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets with
     * 'requester_pays' flag.
     */
    public static BlobWriteOption userProject(String userProject) {
      return new BlobWriteOption(Option.USER_PROJECT, userProject);
    }
  }

  /**
   * Class for specifying blob source options.
   */
  class BlobSourceOption extends Option {

    private static final long serialVersionUID = -3712768261070182991L;

    private BlobSourceOption(StorageRpc.Option rpcOption, Object value) {
      super(rpcOption, value);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match. The generation value to compare with the actual
     * blob's generation is taken from a source {@link BlobId} object. When this option is passed
     * to a {@link Storage} method and {@link BlobId#getGeneration()} is {@code null} or no
     * {@link BlobId} is provided an exception is thrown.
     */
    public static BlobSourceOption generationMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_MATCH, null);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match the provided value.
     */
    public static BlobSourceOption generationMatch(long generation) {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_MATCH, generation);
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches. The generation value to compare with the actual
     * blob's generation is taken from a source {@link BlobId} object. When this option is passed
     * to a {@link Storage} method and {@link BlobId#getGeneration()} is {@code null} or no
     * {@link BlobId} is provided an exception is thrown.
     */
    public static BlobSourceOption generationNotMatch() {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH, null);
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches the provided value.
     */
    public static BlobSourceOption generationNotMatch(long generation) {
      return new BlobSourceOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH, generation);
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if blob's metageneration does not match the provided value.
     */
    public static BlobSourceOption metagenerationMatch(long metageneration) {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_MATCH, metageneration);
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if blob's metageneration matches the provided value.
     */
    public static BlobSourceOption metagenerationNotMatch(long metageneration) {
      return new BlobSourceOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH, metageneration);
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    public static BlobSourceOption decryptionKey(Key key) {
      String base64Key = BaseEncoding.base64().encode(key.getEncoded());
      return new BlobSourceOption(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, base64Key);
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    public static BlobSourceOption decryptionKey(String key) {
      return new BlobSourceOption(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, key);
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets with
     * 'requester_pays' flag.
     */
    public static BlobSourceOption userProject(String userProject) {
      return new BlobSourceOption(StorageRpc.Option.USER_PROJECT, userProject);
    }
  }

  /**
   * Class for specifying blob get options.
   */
  class BlobGetOption extends Option {

    private static final long serialVersionUID = 803817709703661480L;

    private BlobGetOption(StorageRpc.Option rpcOption, Long value) {
      super(rpcOption, value);
    }

    private BlobGetOption(StorageRpc.Option rpcOption, String value) {
      super(rpcOption, value);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match. The generation value to compare with the actual
     * blob's generation is taken from a source {@link BlobId} object. When this option is passed
     * to a {@link Storage} method and {@link BlobId#getGeneration()} is {@code null} or no
     * {@link BlobId} is provided an exception is thrown.
     */
    public static BlobGetOption generationMatch() {
      return new BlobGetOption(StorageRpc.Option.IF_GENERATION_MATCH, (Long) null);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match the provided value.
     */
    public static BlobGetOption generationMatch(long generation) {
      return new BlobGetOption(StorageRpc.Option.IF_GENERATION_MATCH, generation);
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches. The generation value to compare with the actual
     * blob's generation is taken from a source {@link BlobId} object. When this option is passed
     * to a {@link Storage} method and {@link BlobId#getGeneration()} is {@code null} or no
     * {@link BlobId} is provided an exception is thrown.
     */
    public static BlobGetOption generationNotMatch() {
      return new BlobGetOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH, (Long) null);
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches the provided value.
     */
    public static BlobGetOption generationNotMatch(long generation) {
      return new BlobGetOption(StorageRpc.Option.IF_GENERATION_NOT_MATCH, generation);
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if blob's metageneration does not match the provided value.
     */
    public static BlobGetOption metagenerationMatch(long metageneration) {
      return new BlobGetOption(StorageRpc.Option.IF_METAGENERATION_MATCH, metageneration);
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if blob's metageneration matches the provided value.
     */
    public static BlobGetOption metagenerationNotMatch(long metageneration) {
      return new BlobGetOption(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH, metageneration);
    }

    /**
     * Returns an option to specify the blob's fields to be returned by the RPC call. If this option
     * is not provided all blob's fields are returned. {@code BlobGetOption.fields}) can be used to
     * specify only the fields of interest. Blob name and bucket are always returned, even if not
     * specified.
     */
    public static BlobGetOption fields(BlobField... fields) {
      return new BlobGetOption(StorageRpc.Option.FIELDS,
          Helper.selector(BlobField.REQUIRED_FIELDS, fields));
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets with
     * 'requester_pays' flag.
     */
    public static BlobGetOption userProject(String userProject) {
      return new BlobGetOption(StorageRpc.Option.USER_PROJECT, userProject);
    }
  }

  /**
   * Class for specifying bucket list options.
   */
  class BucketListOption extends Option {

    private static final long serialVersionUID = 8754017079673290353L;

    private BucketListOption(StorageRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of buckets returned per page.
     */
    public static BucketListOption pageSize(long pageSize) {
      return new BucketListOption(StorageRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing buckets.
     */
    public static BucketListOption pageToken(String pageToken) {
      return new BucketListOption(StorageRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to set a prefix to filter results to buckets whose names begin with this
     * prefix.
     */
    public static BucketListOption prefix(String prefix) {
      return new BucketListOption(StorageRpc.Option.PREFIX, prefix);
    }

    /**
     * Returns an option for bucket's billing user project. This option is only used by the buckets with
     * 'requester_pays' flag.
     */
    public static BucketListOption userProject(String userProject) {
      return new BucketListOption(StorageRpc.Option.USER_PROJECT, userProject);
    }

    /**
     * Returns an option to specify the bucket's fields to be returned by the RPC call. If this
     * option is not provided all bucket's fields are returned. {@code BucketListOption.fields}) can
     * be used to specify only the fields of interest. Bucket name is always returned, even if not
     * specified.
     */
    public static BucketListOption fields(BucketField... fields) {
      return new BucketListOption(StorageRpc.Option.FIELDS,
          Helper.listSelector("items", BucketField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying blob list options.
   */
  class BlobListOption extends Option {

    private static final String[] TOP_LEVEL_FIELDS = {"prefixes"};
    private static final long serialVersionUID = 9083383524788661294L;

    private BlobListOption(StorageRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of blobs returned per page.
     */
    public static BlobListOption pageSize(long pageSize) {
      return new BlobListOption(StorageRpc.Option.MAX_RESULTS, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing blobs.
     */
    public static BlobListOption pageToken(String pageToken) {
      return new BlobListOption(StorageRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to set a prefix to filter results to blobs whose names begin with this
     * prefix.
     */
    public static BlobListOption prefix(String prefix) {
      return new BlobListOption(StorageRpc.Option.PREFIX, prefix);
    }

    /**
     * If specified, results are returned in a directory-like mode. Blobs whose names, after a
     * possible {@link #prefix(String)}, do not contain the '/' delimiter are returned as is. Blobs
     * whose names, after a possible {@link #prefix(String)}, contain the '/' delimiter, will have
     * their name truncated after the delimiter and will be returned as {@link Blob} objects where
     * only {@link Blob#getBlobId()}, {@link Blob#getSize()} and {@link Blob#isDirectory()} are set.
     * For such directory blobs, ({@link BlobId#getGeneration()} returns {@code null}),
     * {@link Blob#getSize()} returns {@code 0} while {@link Blob#isDirectory()} returns
     * {@code true}. Duplicate directory blobs are omitted.
     */
    public static BlobListOption currentDirectory() {
      return new BlobListOption(StorageRpc.Option.DELIMITER, true);
    }

    /**
     * Returns an option to define the billing user project. This option is required by buckets with
     * `requester_pays` flag enabled to assign operation costs.
     *
     * @param userProject projectId of the billing user project.
     */
    public static BlobListOption userProject(String userProject) {
      return new BlobListOption(StorageRpc.Option.USER_PROJECT, userProject);
    }

    /**
     * If set to {@code true}, lists all versions of a blob. The default is {@code false}.
     *
     * @see <a href ="https://cloud.google.com/storage/docs/object-versioning">Object Versioning</a>
     */
    public static BlobListOption versions(boolean versions) {
      return new BlobListOption(StorageRpc.Option.VERSIONS, versions);
    }

    /**
     * Returns an option to specify the blob's fields to be returned by the RPC call. If this option
     * is not provided all blob's fields are returned. {@code BlobListOption.fields}) can be used to
     * specify only the fields of interest. Blob name and bucket are always returned, even if not
     * specified.
     */
    public static BlobListOption fields(BlobField... fields) {
      return new BlobListOption(StorageRpc.Option.FIELDS,
          Helper.listSelector(TOP_LEVEL_FIELDS, "items", BlobField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Class for specifying signed URL options.
   */
  class SignUrlOption implements Serializable {

    private static final long serialVersionUID = 7850569877451099267L;

    private final Option option;
    private final Object value;

    enum Option {
      HTTP_METHOD, CONTENT_TYPE, MD5, EXT_HEADERS, SERVICE_ACCOUNT_CRED
    }

    private SignUrlOption(Option option, Object value) {
      this.option = option;
      this.value = value;
    }

    Option getOption() {
      return option;
    }

    Object getValue() {
      return value;
    }

    /**
     * The HTTP method to be used with the signed URL. 
     * If this method is not called, defaults to GET.
     */
    public static SignUrlOption httpMethod(HttpMethod httpMethod) {
      return new SignUrlOption(Option.HTTP_METHOD, httpMethod);
    }

    /**
     * Use it if signature should include the blob's content-type.
     * When used, users of the signed URL should include the blob's content-type with their request.
     * If using this URL from a browser, you must include a content type that matches what the browser will send.
     */
    public static SignUrlOption withContentType() {
      return new SignUrlOption(Option.CONTENT_TYPE, true);
    }

    /**
     * Use it if signature should include the blob's md5.
     * When used, users of the signed URL should include the blob's md5 with their request.
     */
    public static SignUrlOption withMd5() {
      return new SignUrlOption(Option.MD5, true);
    }
    
    /**
     * Use it if signature should include the blob's canonicalized extended headers.
     * When used, users of the signed URL should include the canonicalized extended headers with
     * their request.
     * @see <a href="https://cloud.google.com/storage/docs/xml-api/reference-headers"></a>
     */
    public static SignUrlOption withExtHeaders(Map<String, String> extHeaders) {
      return new SignUrlOption(Option.EXT_HEADERS, extHeaders);
    }

    /**
     * Provides a service account signer to sign the URL. If not provided an attempt will be made to
     * get it from the environment.
     *
     * @see <a href="https://cloud.google.com/storage/docs/authentication#service_accounts">Service
     *     account</a>
     */
    public static SignUrlOption signWith(ServiceAccountSigner signer) {
      return new SignUrlOption(Option.SERVICE_ACCOUNT_CRED, signer);
    }
  }

  /**
   * A class to contain all information needed for a Google Cloud Storage Compose operation.
   *
   * @see <a href="https://cloud.google.com/storage/docs/composite-objects#_Compose">
   *     Compose Operation</a>
   */
  class ComposeRequest implements Serializable {

    private static final long serialVersionUID = -7385681353748590911L;

    private final List<SourceBlob> sourceBlobs;
    private final BlobInfo target;
    private final List<BlobTargetOption> targetOptions;

    /**
     * Class for Compose source blobs.
     */
    public static class SourceBlob implements Serializable {

      private static final long serialVersionUID = 4094962795951990439L;

      final String name;
      final Long generation;

      SourceBlob(String name) {
        this(name, null);
      }

      SourceBlob(String name, Long generation) {
        this.name = name;
        this.generation = generation;
      }

      public String getName() {
        return name;
      }

      public Long getGeneration() {
        return generation;
      }
    }

    public static class Builder {

      private final List<SourceBlob> sourceBlobs = new LinkedList<>();
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();
      private BlobInfo target;

      /**
       * Add source blobs for compose operation.
       */
      public Builder addSource(Iterable<String> blobs) {
        for (String blob : blobs) {
          sourceBlobs.add(new SourceBlob(blob));
        }
        return this;
      }

      /**
       * Add source blobs for compose operation.
       */
      public Builder addSource(String... blobs) {
        return addSource(Arrays.asList(blobs));
      }

      /**
       * Add a source with a specific generation to match.
       */
      public Builder addSource(String blob, long generation) {
        sourceBlobs.add(new SourceBlob(blob, generation));
        return this;
      }

      /**
       * Sets compose operation's target blob.
       */
      public Builder setTarget(BlobInfo target) {
        this.target = target;
        return this;
      }

      /**
       * Sets compose operation's target blob options.
       */
      public Builder setTargetOptions(BlobTargetOption... options) {
        Collections.addAll(targetOptions, options);
        return this;
      }

      /**
       * Sets compose operation's target blob options.
       */
      public Builder setTargetOptions(Iterable<BlobTargetOption> options) {
        Iterables.addAll(targetOptions, options);
        return this;
      }

      /**
       * Creates a {@code ComposeRequest} object.
       */
      public ComposeRequest build() {
        checkArgument(!sourceBlobs.isEmpty());
        checkNotNull(target);
        return new ComposeRequest(this);
      }
    }

    private ComposeRequest(Builder builder) {
      sourceBlobs = ImmutableList.copyOf(builder.sourceBlobs);
      target = builder.target;
      targetOptions = ImmutableList.copyOf(builder.targetOptions);
    }

    /**
     * Returns compose operation's source blobs.
     */
    public List<SourceBlob> getSourceBlobs() {
      return sourceBlobs;
    }

    /**
     * Returns compose operation's target blob.
     */
    public BlobInfo getTarget() {
      return target;
    }

    /**
     * Returns compose operation's target blob's options.
     */
    public List<BlobTargetOption> getTargetOptions() {
      return targetOptions;
    }

    /**
     * Creates a {@code ComposeRequest} object.
     *
     * @param sources source blobs names
     * @param target target blob
     */
    public static ComposeRequest of(Iterable<String> sources, BlobInfo target) {
      return newBuilder().setTarget(target).addSource(sources).build();
    }

    /**
     * Creates a {@code ComposeRequest} object.
     *
     * @param bucket name of the bucket where the compose operation takes place
     * @param sources source blobs names
     * @param target target blob name
     */
    public static ComposeRequest of(String bucket, Iterable<String> sources, String target) {
      return of(sources, BlobInfo.newBuilder(BlobId.of(bucket, target)).build());
    }

    /**
     * Returns a {@code ComposeRequest} builder.
     */
    public static Builder newBuilder() {
      return new Builder();
    }
  }

  /**
   * A class to contain all information needed for a Google Cloud Storage Copy operation.
   */
  class CopyRequest implements Serializable {

    private static final long serialVersionUID = -4498650529476219937L;

    private final BlobId source;
    private final List<BlobSourceOption> sourceOptions;
    private final boolean overrideInfo;
    private final BlobInfo target;
    private final List<BlobTargetOption> targetOptions;
    private final Long megabytesCopiedPerChunk;

    public static class Builder {

      private final Set<BlobSourceOption> sourceOptions = new LinkedHashSet<>();
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();
      private BlobId source;
      private boolean overrideInfo;
      private BlobInfo target;
      private Long megabytesCopiedPerChunk;

      /**
       * Sets the blob to copy given bucket and blob name.
       *
       * @return the builder
       */
      public Builder setSource(String bucket, String blob) {
        this.source = BlobId.of(bucket, blob);
        return this;
      }

      /**
       * Sets the blob to copy given a {@link BlobId}.
       *
       * @return the builder
       */
      public Builder setSource(BlobId source) {
        this.source = source;
        return this;
      }

      /**
       * Sets blob's source options.
       *
       * @return the builder
       */
      public Builder setSourceOptions(BlobSourceOption... options) {
        Collections.addAll(sourceOptions, options);
        return this;
      }

      /**
       * Sets blob's source options.
       *
       * @return the builder
       */
      public Builder setSourceOptions(Iterable<BlobSourceOption> options) {
        Iterables.addAll(sourceOptions, options);
        return this;
      }

      /**
       * Sets the copy target. Target blob information is copied from source.
       *
       * @return the builder
       */
      public Builder setTarget(BlobId targetId) {
        this.overrideInfo = false;
        this.target = BlobInfo.newBuilder(targetId).build();
        return this;
      }

      /**
       * Sets the copy target. Target blob information is copied from source, except for those
       * options specified in {@code options}.
       *
       * @return the builder
       */
      public Builder setTarget(BlobId targetId, BlobTargetOption... options) {
        this.overrideInfo = false;
        this.target = BlobInfo.newBuilder(targetId).build();
        Collections.addAll(targetOptions, options);
        return this;
      }

      /**
       * Sets the copy target and target options. {@code target} parameter is used to override
       * source blob information (e.g. {@code contentType}, {@code contentLanguage}). Target blob
       * information is set exactly to {@code target}, no information is inherited from the source
       * blob.
       *
       * @return the builder
       */
      public Builder setTarget(BlobInfo target, BlobTargetOption... options) {
        this.overrideInfo = true;
        this.target = checkNotNull(target);
        Collections.addAll(targetOptions, options);
        return this;
      }

      /**
       * Sets the copy target and target options. {@code target} parameter is used to override
       * source blob information (e.g. {@code contentType}, {@code contentLanguage}). Target blob
       * information is set exactly to {@code target}, no information is inherited from the source
       * blob.
       *
       * @return the builder
       */
      public Builder setTarget(BlobInfo target, Iterable<BlobTargetOption> options) {
        this.overrideInfo = true;
        this.target = checkNotNull(target);
        Iterables.addAll(targetOptions, options);
        return this;
      }

      /**
       * Sets the copy target and target options. Target blob information is copied from source,
       * except for those options specified in {@code options}.
       *
       * @return the builder
       */
      public Builder setTarget(BlobId targetId, Iterable<BlobTargetOption> options) {
        this.overrideInfo = false;
        this.target = BlobInfo.newBuilder(targetId).build();
        Iterables.addAll(targetOptions, options);
        return this;
      }

      /**
       * Sets the maximum number of megabytes to copy for each RPC call. This parameter is ignored
       * if source and target blob share the same location and storage class as copy is made with
       * one single RPC.
       *
       * @return the builder
       */
      public Builder setMegabytesCopiedPerChunk(Long megabytesCopiedPerChunk) {
        this.megabytesCopiedPerChunk = megabytesCopiedPerChunk;
        return this;
      }

      /**
       * Creates a {@code CopyRequest} object.
       */
      public CopyRequest build() {
        return new CopyRequest(this);
      }
    }

    private CopyRequest(Builder builder) {
      source = checkNotNull(builder.source);
      sourceOptions = ImmutableList.copyOf(builder.sourceOptions);
      overrideInfo = builder.overrideInfo;
      target = checkNotNull(builder.target);
      targetOptions = ImmutableList.copyOf(builder.targetOptions);
      megabytesCopiedPerChunk = builder.megabytesCopiedPerChunk;
    }

    /**
     * Returns the blob to copy, as a {@link BlobId}.
     */
    public BlobId getSource() {
      return source;
    }

    /**
     * Returns blob's source options.
     */
    public List<BlobSourceOption> getSourceOptions() {
      return sourceOptions;
    }

    /**
     * Returns the {@link BlobInfo} for the target blob.
     */
    public BlobInfo getTarget() {
      return target;
    }

    /**
     * Returns whether to override the target blob information with {@link #getTarget()}.
     * If {@code true}, the value of {@link #getTarget()} is used to replace source blob information
     * (e.g. {@code contentType}, {@code contentLanguage}). Target blob information is set exactly
     * to this value, no information is inherited from the source blob. If {@code false}, target
     * blob information is inherited from the source blob.
     */
    public boolean overrideInfo() {
      return overrideInfo;
    }

    /**
     * Returns blob's target options.
     */
    public List<BlobTargetOption> getTargetOptions() {
      return targetOptions;
    }

    /**
     * Returns the maximum number of megabytes to copy for each RPC call. This parameter is ignored
     * if source and target blob share the same location and storage class as copy is made with
     * one single RPC.
     */
    public Long getMegabytesCopiedPerChunk() {
      return megabytesCopiedPerChunk;
    }

    /**
     * Creates a copy request. {@code target} parameter is used to override source blob information
     * (e.g. {@code contentType}, {@code contentLanguage}).
     *
     * @param sourceBucket name of the bucket containing the source blob
     * @param sourceBlob name of the source blob
     * @param target a {@code BlobInfo} object for the target blob
     * @return a copy request
     */
    public static CopyRequest of(String sourceBucket, String sourceBlob, BlobInfo target) {
      return newBuilder().setSource(sourceBucket, sourceBlob).setTarget(target).build();
    }

    /**
     * Creates a copy request. {@code target} parameter is used to replace source blob information
     * (e.g. {@code contentType}, {@code contentLanguage}). Target blob information is set exactly
     * to {@code target}, no information is inherited from the source blob.
     *
     * @param sourceBlobId a {@code BlobId} object for the source blob
     * @param target a {@code BlobInfo} object for the target blob
     * @return a copy request
     */
    public static CopyRequest of(BlobId sourceBlobId, BlobInfo target) {
      return newBuilder().setSource(sourceBlobId).setTarget(target).build();
    }

    /**
     * Creates a copy request. Target blob information is copied from source.
     *
     * @param sourceBucket name of the bucket containing both the source and the target blob
     * @param sourceBlob name of the source blob
     * @param targetBlob name of the target blob
     * @return a copy request
     */
    public static CopyRequest of(String sourceBucket, String sourceBlob, String targetBlob) {
      return CopyRequest.newBuilder()
          .setSource(sourceBucket, sourceBlob)
          .setTarget(BlobId.of(sourceBucket, targetBlob))
          .build();
    }

    /**
     * Creates a copy request. Target blob information is copied from source.
     *
     * @param sourceBucket name of the bucket containing the source blob
     * @param sourceBlob name of the source blob
     * @param target a {@code BlobId} object for the target blob
     * @return a copy request
     */
    public static CopyRequest of(String sourceBucket, String sourceBlob, BlobId target) {
      return newBuilder().setSource(sourceBucket, sourceBlob).setTarget(target).build();
    }

    /**
     * Creates a copy request. Target blob information is copied from source.
     *
     * @param sourceBlobId a {@code BlobId} object for the source blob
     * @param targetBlob name of the target blob, in the same bucket of the source blob
     * @return a copy request
     */
    public static CopyRequest of(BlobId sourceBlobId, String targetBlob) {
      return CopyRequest.newBuilder()
          .setSource(sourceBlobId)
          .setTarget(BlobId.of(sourceBlobId.getBucket(), targetBlob))
          .build();
    }

    /**
     * Creates a copy request. Target blob information is copied from source.
     *
     * @param sourceBlobId a {@code BlobId} object for the source blob
     * @param targetBlobId a {@code BlobId} object for the target blob
     * @return a copy request
     */
    public static CopyRequest of(BlobId sourceBlobId, BlobId targetBlobId) {
      return CopyRequest.newBuilder()
          .setSource(sourceBlobId)
          .setTarget(targetBlobId)
          .build();
    }

    /**
     * Creates a builder for {@code CopyRequest} objects.
     */
    public static Builder newBuilder() {
      return new Builder();
    }
  }

  /**
   * Creates a new bucket.
   *
   * Accepts an optional userProject {@link BucketTargetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of creating a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Bucket bucket = storage.create(BucketInfo.of(bucketName));
   * }</pre>
   *
   * <p>Example of creating a bucket with storage class and location.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Bucket bucket = storage.create(BucketInfo.newBuilder(bucketName)
   *     // See here for possible values: http://g.co/cloud/storage/docs/storage-classes
   *     .setStorageClass(StorageClass.COLDLINE)
   *     // Possible values: http://g.co/cloud/storage/docs/bucket-locations#location-mr
   *     .setLocation("asia")
   *     .build());
   * }</pre>
   *
   * @return a complete bucket
   * @throws StorageException upon failure
   */
  Bucket create(BucketInfo bucketInfo, BucketTargetOption... options);

  /**
   * Creates a new blob with no content.
   *
   * <p>Example of creating a blob with no content.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Blob blob = storage.create(blobInfo);
   * }</pre>
   *
   * @return a [@code Blob} with complete information
   * @throws StorageException upon failure
   */
  Blob create(BlobInfo blobInfo, BlobTargetOption... options);

  /**
   * Creates a new blob. Direct upload is used to upload {@code content}. For large content,
   * {@link #writer} is recommended as it uses resumable upload. MD5 and CRC32C hashes of
   * {@code content} are computed and used for validating transferred data.
   * Accepts an optional userProject {@link BlobGetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of creating a blob from a byte array.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Blob blob = storage.create(blobInfo, "Hello, World!".getBytes(UTF_8));
   * }</pre>
   *
   * @return a [@code Blob} with complete information
   * @throws StorageException upon failure
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags">Hashes and ETags</a>
   */
  Blob create(BlobInfo blobInfo, byte[] content, BlobTargetOption... options);

  /**
   * Creates a new blob. Direct upload is used to upload {@code content}. For large content,
   * {@link #writer} is recommended as it uses resumable upload. By default any md5 and crc32c
   * values in the given {@code blobInfo} are ignored unless requested via the
   * {@code BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options. The given
   * input stream is closed upon success.
   *
   * <p>This method is marked as {@link Deprecated} because it cannot safely retry, given that it
   * accepts an {@link InputStream} which can only be consumed once.
   *
   * <p>Example of creating a blob from an input stream.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Blob blob = storage.create(blobInfo, content);
   * }</pre>
   *
   * <p>Example of uploading an encrypted blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * String encryptionKey = "my_encryption_key";
   * InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
   *
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
   *     .setContentType("text/plain")
   *     .build();
   * Blob blob = storage.create(blobInfo, content, BlobWriteOption.encryptionKey(encryptionKey));
   * }</pre>
   *
   * @return a [@code Blob} with complete information
   * @throws StorageException upon failure
   */
  @Deprecated
  Blob create(BlobInfo blobInfo, InputStream content, BlobWriteOption... options);

  /**
   * Returns the requested bucket or {@code null} if not found.
   *
   * Accepts an optional userProject {@link BucketGetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of getting information on a bucket, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * long bucketMetageneration = 42;
   * Bucket bucket = storage.get(bucketName,
   *     BucketGetOption.metagenerationMatch(bucketMetageneration));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Bucket get(String bucket, BucketGetOption... options);

  /**
   * Locks bucket retention policy. Requires a local metageneration value in the request. Review example below.
   *
   * <p>Accepts an optional userProject {@link BucketTargetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Warning: Once a retention policy is locked, it can't be unlocked, removed, or shortened.
   *
   * <p>Example of locking a retention policy on a bucket, only if its local metageneration value matches the bucket's
   * service metageneration otherwise a {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Bucket bucket = storage.get(bucketName, BucketGetOption.fields(BucketField.METAGENERATION));
   * storage.lockRetentionPolicy(bucket, BucketTargetOption.metagenerationMatch());
   * }</pre>
   *
   * @return a {@code Bucket} object of the locked bucket
   * @throws StorageException upon failure
   */
  Bucket lockRetentionPolicy(BucketInfo bucket, BucketTargetOption... options);

  /**
   * Returns the requested blob or {@code null} if not found.
   *
   * Accepts an optional userProject {@link BlobGetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of getting information on a blob, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobMetageneration = 42;
   * Blob blob = storage.get(bucketName, blobName,
   *     BlobGetOption.metagenerationMatch(blobMetageneration));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Blob get(String bucket, String blob, BlobGetOption... options);

  /**
   * Returns the requested blob or {@code null} if not found.
   *
   * Accepts an optional userProject {@link BlobGetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of getting information on a blob, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobMetageneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Blob blob = storage.get(blobId, BlobGetOption.metagenerationMatch(blobMetageneration));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Blob get(BlobId blob, BlobGetOption... options);

  /**
   * Returns the requested blob or {@code null} if not found.
   *
   * <p>Example of getting information on a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Blob blob = storage.get(blobId);
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Blob get(BlobId blob);

  /**
   * Lists the project's buckets.
   *
   * <p>Example of listing buckets, specifying the page size and a name prefix.
   * <pre> {@code
   * String prefix = "bucket_";
   * Page<Bucket> buckets = storage.list(BucketListOption.pageSize(100),
   *     BucketListOption.prefix(prefix));
   * Iterator<Bucket> bucketIterator = buckets.iterateAll();
   * while (bucketIterator.hasNext()) {
   *   Bucket bucket = bucketIterator.next();
   *   // do something with the bucket
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Page<Bucket> list(BucketListOption... options);

  /**
   * Lists the bucket's blobs. If the {@link BlobListOption#currentDirectory()} option is provided,
   * results are returned in a directory-like mode.
   *
   * <p>Example of listing blobs in a provided directory.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String directory = "my_directory/";
   * Page<Blob> blobs = storage.list(bucketName, BlobListOption.currentDirectory(),
   *     BlobListOption.prefix(directory));
   * Iterator<Blob> blobIterator = blobs.iterateAll();
   * while (blobIterator.hasNext()) {
   *   Blob blob = blobIterator.next();
   *   // do something with the blob
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Page<Blob> list(String bucket, BlobListOption... options);

  /**
   * Updates bucket information.
   *
   * Accepts an optional userProject {@link BucketTargetOption} option which defines the project id
   * to assign operational costs.
   * <p>Example of updating bucket information.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).setVersioningEnabled(true).build();
   * Bucket bucket = storage.update(bucketInfo);
   * }</pre>
   *
   * @return the updated bucket
   * @throws StorageException upon failure
   */
  Bucket update(BucketInfo bucketInfo, BucketTargetOption... options);

  /**
   * Updates blob information. Original metadata are merged with metadata in the provided
   * {@code blobInfo}. To replace metadata instead you first have to unset them. Unsetting metadata
   * can be done by setting the provided {@code blobInfo}'s metadata to {@code null}.
   * Accepts an optional userProject {@link BlobTargetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of udating a blob, only if the blob's metageneration matches a value, otherwise a
   * {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * Blob blob = storage.get(bucketName, blobName);
   * BlobInfo updatedInfo = blob.toBuilder().setContentType("text/plain").build();
   * storage.update(updatedInfo, BlobTargetOption.metagenerationMatch());
   * }</pre>
   *
   * @return the updated blob
   * @throws StorageException upon failure
   */
  Blob update(BlobInfo blobInfo, BlobTargetOption... options);

  /**
   * Updates blob information. Original metadata are merged with metadata in the provided
   * {@code blobInfo}. To replace metadata instead you first have to unset them. Unsetting metadata
   * can be done by setting the provided {@code blobInfo}'s metadata to {@code null}.
   *
   * <p>Example of replacing blob's metadata.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * Map<String, String> newMetadata = new HashMap<>();
   * newMetadata.put("key", "value");
   * storage.update(BlobInfo.newBuilder(bucketName, blobName).setMetadata(null).build());
   * Blob blob = storage.update(BlobInfo.newBuilder(bucketName, blobName)
   *     .setMetadata(newMetadata)
   *     .build());
   * }</pre>
   *
   * @return the updated blob
   * @throws StorageException upon failure
   */
  Blob update(BlobInfo blobInfo);

  /**
   * Deletes the requested bucket.
   *
   * Accepts an optional userProject {@link BucketSourceOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of deleting a bucket, only if its metageneration matches a value, otherwise a
   * {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * long bucketMetageneration = 42;
   * boolean deleted = storage.delete(bucketName,
   *     BucketSourceOption.metagenerationMatch(bucketMetageneration));
   * if (deleted) {
   *   // the bucket was deleted
   * } else {
   *   // the bucket was not found
   * }
   * }</pre>
   *
   * @return {@code true} if bucket was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean delete(String bucket, BucketSourceOption... options);

  /**
   * Deletes the requested blob.
   *
   * <p>Example of deleting a blob, only if its generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * boolean deleted = storage.delete(bucketName, blobName,
   *     BlobSourceOption.generationMatch(blobGeneration));
   * if (deleted) {
   *   // the blob was deleted
   * } else {
   *   // the blob was not found
   * }
   * }</pre>
   *
   * @return {@code true} if blob was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean delete(String bucket, String blob, BlobSourceOption... options);

  /**
   * Deletes the requested blob.
   *
   * Accepts an optional userProject {@link BlobSourceOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of deleting a blob, only if its generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * boolean deleted = storage.delete(blobId, BlobSourceOption.generationMatch(blobGeneration));
   * if (deleted) {
   *   // the blob was deleted
   * } else {
   *   // the blob was not found
   * }
   * }</pre>
   *
   * @return {@code true} if blob was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean delete(BlobId blob, BlobSourceOption... options);

  /**
   * Deletes the requested blob.
   *
   * <p>Example of deleting a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * boolean deleted = storage.delete(blobId);
   * if (deleted) {
   *   // the blob was deleted
   * } else {
   *   // the blob was not found
   * }
   * }</pre>
   *
   * @return {@code true} if blob was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean delete(BlobId blob);

  /**
   * Sends a compose request.
   *
   * Accepts an optional userProject {@link BlobTargetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of composing two blobs.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * String sourceBlob1 = "source_blob_1";
   * String sourceBlob2 = "source_blob_2";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * ComposeRequest request = ComposeRequest.newBuilder()
   *     .setTarget(blobInfo)
   *     .addSource(sourceBlob1)
   *     .addSource(sourceBlob2)
   *     .build();
   * Blob blob = storage.compose(request);
   * }</pre>
   *
   * @return the composed blob
   * @throws StorageException upon failure
   */
  Blob compose(ComposeRequest composeRequest);

  /**
   * Sends a copy request. This method copies both blob's data and information. To override source
   * blob's information supply a {@code BlobInfo} to the
   * {@code CopyRequest} using either
   * {@link Storage.CopyRequest.Builder#setTarget(BlobInfo, Storage.BlobTargetOption...)} or
   * {@link Storage.CopyRequest.Builder#setTarget(BlobInfo, Iterable)}.
   *
   * <p>This method returns a {@link CopyWriter} object for the provided {@code CopyRequest}. If
   * source and destination objects share the same location and storage class the source blob is
   * copied with one request and {@link CopyWriter#getResult()} immediately returns, regardless of
   * the {@link CopyRequest#megabytesCopiedPerChunk} parameter. If source and destination have
   * different location or storage class {@link CopyWriter#getResult()} might issue multiple RPC
   * calls depending on blob's size.
   *
   * <p>Example of copying a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * String copyBlobName = "copy_blob_name";
   * CopyRequest request = CopyRequest.newBuilder()
   *     .setSource(BlobId.of(bucketName, blobName))
   *     .setTarget(BlobId.of(bucketName, copyBlobName))
   *     .build();
   * Blob blob = storage.copy(request).getResult();
   * }</pre>
   *
   * <p>Example of copying a blob in chunks.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * String copyBlobName = "copy_blob_name";
   * CopyRequest request = CopyRequest.newBuilder()
   *     .setSource(BlobId.of(bucketName, blobName))
   *     .setTarget(BlobId.of(bucketName, copyBlobName))
   *     .build();
   * CopyWriter copyWriter = storage.copy(request);
   * while (!copyWriter.isDone()) {
   *   copyWriter.copyChunk();
   * }
   * Blob blob = copyWriter.getResult();
   * }</pre>
   *
   * <p>Example of rotating the encryption key of a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * String oldEncryptionKey = "old_encryption_key";
   * String newEncryptionKey = "new_encryption_key";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * CopyRequest request = CopyRequest.newBuilder()
   *     .setSource(blobId)
   *     .setSourceOptions(BlobSourceOption.decryptionKey(oldEncryptionKey))
   *     .setTarget(blobId, BlobTargetOption.encryptionKey(newEncryptionKey))
   *     .build();
   * Blob blob = storage.copy(request).getResult();
   * }</pre>
   *
   * @return a {@link CopyWriter} object that can be used to get information on the newly created
   *     blob or to complete the copy if more than one RPC request is needed
   * @throws StorageException upon failure
   * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/rewrite">Rewrite</a>
   */
  CopyWriter copy(CopyRequest copyRequest);

  /**
   * Reads all the bytes from a blob.
   *
   * <p>Example of reading all bytes of a blob, if generation matches a value, otherwise a
   * {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42";
   * byte[] content = storage.readAllBytes(bucketName, blobName,
   *     BlobSourceOption.generationMatch(blobGeneration));
   * }</pre>
   *
   * @return the blob's content
   * @throws StorageException upon failure
   */
  byte[] readAllBytes(String bucket, String blob, BlobSourceOption... options);

  /**
   * Reads all the bytes from a blob.
   *
   * <p>Example of reading all bytes of a blob's specific generation, otherwise a
   * {@link StorageException} is thrown.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * byte[] content = storage.readAllBytes(blobId);
   * }</pre>
   *
   * <p>Example of reading all bytes of an encrypted blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * String decryptionKey = "my_encryption_key";
   * byte[] content = storage.readAllBytes(
   *     bucketName, blobName, BlobSourceOption.decryptionKey(decryptionKey));
   * }</pre>
   *
   * @return the blob's content
   * @throws StorageException upon failure
   */
  byte[] readAllBytes(BlobId blob, BlobSourceOption... options);

  /**
   * Creates a new empty batch for grouping multiple service calls in one underlying RPC call.
   *
   * <p>Example of using a batch request to delete, update and get a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * StorageBatch batch = storage.batch();
   * BlobId firstBlob = BlobId.of(bucketName, blobName1);
   * BlobId secondBlob = BlobId.of(bucketName, blobName2);
   * batch.delete(firstBlob).notify(new BatchResult.Callback<Boolean, StorageException>() {
   *   public void success(Boolean result) {
   *     // deleted successfully
   *   }
   *
   *   public void error(StorageException exception) {
   *     // delete failed
   *   }
   * });
   * batch.update(BlobInfo.newBuilder(secondBlob).setContentType("text/plain").build());
   * StorageBatchResult<Blob> result = batch.get(secondBlob);
   * batch.submit();
   * Blob blob = result.get(); // returns get result or throws StorageException
   * }</pre>
   *
   */
  StorageBatch batch();

  /**
   * Returns a channel for reading the blob's content. The blob's latest generation is read. If the
   * blob changes while reading (i.e. {@link BlobInfo#getEtag()} changes), subsequent calls to
   * {@code blobReadChannel.read(ByteBuffer)} may throw {@link StorageException}.
   *
   * <p>Example of reading a blob's content through a reader.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * try (ReadChannel reader = storage.reader(bucketName, blobName)) {
   *   ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
   *   while (reader.read(bytes) > 0) {
   *     bytes.flip();
   *     // do something with bytes
   *     bytes.clear();
   *   }
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  ReadChannel reader(String bucket, String blob, BlobSourceOption... options);

  /**
   * Returns a channel for reading the blob's content. If {@code blob.generation()} is set
   * data corresponding to that generation is read. If {@code blob.generation()} is {@code null}
   * the blob's latest generation is read. If the blob changes while reading (i.e.
   * {@link BlobInfo#getEtag()} changes), subsequent calls to {@code blobReadChannel.read(ByteBuffer)}
   * may throw {@link StorageException}.
   *
   * <p>The {@link BlobSourceOption#generationMatch()} and
   * {@link BlobSourceOption#generationMatch(long)} options can be used to ensure that
   * {@code blobReadChannel.read(ByteBuffer)} calls will throw {@link StorageException} if the
   * blob`s generation differs from the expected one.
   *
   * <p>Example of reading a blob's content through a reader.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * try (ReadChannel reader = storage.reader(blobId)) {
   *   ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
   *   while (reader.read(bytes) > 0) {
   *     bytes.flip();
   *     // do something with bytes
   *     bytes.clear();
   *   }
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  ReadChannel reader(BlobId blob, BlobSourceOption... options);

  /**
   * Creates a blob and return a channel for writing its content. By default any md5 and crc32c
   * values in the given {@code blobInfo} are ignored unless requested via the
   * {@code BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * <p>Example of writing a blob's content through a writer.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * byte[] content = "Hello, World!".getBytes(UTF_8);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * try (WriteChannel writer = storage.writer(blobInfo)) {
   *   try {
   *     writer.write(ByteBuffer.wrap(content, 0, content.length));
   *   } catch (Exception ex) {
   *     // handle exception
   *   }
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  WriteChannel writer(BlobInfo blobInfo, BlobWriteOption... options);

  /**
   * Generates a signed URL for a blob. If you have a blob that you want to allow access to for a
   * fixed amount of time, you can use this method to generate a URL that is only valid within a
   * certain time period. This is particularly useful if you don't want publicly accessible blobs,
   * but also don't want to require users to explicitly log in. Signing a URL requires
   * a service account signer. If an instance of {@link com.google.auth.ServiceAccountSigner} was
   * passed to {@link StorageOptions}' builder via {@code setCredentials(Credentials)} or the
   * default credentials are being used and the environment variable
   * {@code GOOGLE_APPLICATION_CREDENTIALS} is set or your application is running in App Engine,
   * then {@code signUrl} will use that credentials to sign the URL. If the credentials passed to
   * {@link StorageOptions} do not implement {@link ServiceAccountSigner} (this is the case, for
   * instance, for Google Cloud SDK credentials) then {@code signUrl} will throw an
   * {@link IllegalStateException} unless an implementation of {@link ServiceAccountSigner} is
   * passed using the {@link SignUrlOption#signWith(ServiceAccountSigner)} option.
   *
   * <p>A service account signer is looked for in the following order:
   * <ol>
   *   <li>The signer passed with the option {@link SignUrlOption#signWith(ServiceAccountSigner)}
   *   <li>The credentials passed to {@link StorageOptions}
   *   <li>The default credentials, if no credentials were passed to {@link StorageOptions}
   * </ol>
   *
   * <p>Example of creating a signed URL that is valid for 2 weeks, using the default credentials
   * for signing the URL.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * URL signedUrl = storage.signUrl(BlobInfo.newBuilder(bucketName, blobName).build(), 14,
   *     TimeUnit.DAYS);
   * }</pre>
   *
   * <p>Example of creating a signed URL passing the
   * {@link SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used for signing the
   * URL.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * String keyPath = "/path/to/key.json";
   * URL signedUrl = storage.signUrl(BlobInfo.newBuilder(bucketName, blobName).build(),
   *     14, TimeUnit.DAYS, SignUrlOption.signWith(
   *         ServiceAccountCredentials.fromStream(new FileInputStream(keyPath))));
   * }</pre>
   *
   * <p>Note that the {@link ServiceAccountSigner} may require additional configuration to enable
   * URL signing. See the documentation for the implementation for more details.</p>
   *
   * @param blobInfo the blob associated with the signed URL
   * @param duration time until the signed URL expires, expressed in {@code unit}. The finest
   *     granularity supported is 1 second, finer granularities will be truncated
   * @param unit time unit of the {@code duration} parameter
   * @param options optional URL signing options
   * @throws IllegalStateException if {@link SignUrlOption#signWith(ServiceAccountSigner)} was not
   *     used and no implementation of {@link ServiceAccountSigner} was provided to
   *     {@link StorageOptions}
   * @throws IllegalArgumentException if {@code SignUrlOption.withMd5()} option is used and
   *     {@code blobInfo.md5()} is {@code null}
   * @throws IllegalArgumentException if {@code SignUrlOption.withContentType()} option is used and
   *     {@code blobInfo.contentType()} is {@code null}
   * @throws SigningException if the attempt to sign the URL failed
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  URL signUrl(BlobInfo blobInfo, long duration, TimeUnit unit, SignUrlOption... options);

  /**
   * Gets the requested blobs. A batch request is used to perform this call.
   *
   *
   * <p>Example of getting information on several blobs using a single batch request.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * BlobId firstBlob = BlobId.of(bucketName, blobName1);
   * BlobId secondBlob = BlobId.of(bucketName, blobName2);
   * List<Blob> blobs = storage.get(firstBlob, secondBlob);
   * }</pre>
   *
   * @param blobIds blobs to get
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it
   *     has been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  List<Blob> get(BlobId... blobIds);

  /**
   * Gets the requested blobs. A batch request is used to perform this call.
   *
   * <p>Example of getting information on several blobs using a single batch request.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * List<BlobId> blobIds = new LinkedList<>();
   * blobIds.add(BlobId.of(bucketName, blobName1));
   * blobIds.add(BlobId.of(bucketName, blobName2));
   * List<Blob> blobs = storage.get(blobIds);
   * }</pre>
   *
   * @param blobIds blobs to get
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it
   *     has been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  List<Blob> get(Iterable<BlobId> blobIds);

  /**
   * Updates the requested blobs. A batch request is used to perform this call. Original metadata
   * are merged with metadata in the provided {@code BlobInfo} objects. To replace metadata instead
   * you first have to unset them. Unsetting metadata can be done by setting the provided
   * {@code BlobInfo} objects metadata to {@code null}. See
   * {@link #update(BlobInfo)} for a code example.
   *
   * <p>Example of updating information on several blobs using a single batch request.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * Blob firstBlob = storage.get(bucketName, blobName1);
   * Blob secondBlob = storage.get(bucketName, blobName2);
   * List<Blob> updatedBlobs = storage.update(
   *     firstBlob.toBuilder().setContentType("text/plain").build(),
   *     secondBlob.toBuilder().setContentType("text/plain").build());
   * }</pre>
   *
   * @param blobInfos blobs to update
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it
   *     has been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  List<Blob> update(BlobInfo... blobInfos);

  /**
   * Updates the requested blobs. A batch request is used to perform this call. Original metadata
   * are merged with metadata in the provided {@code BlobInfo} objects. To replace metadata instead
   * you first have to unset them. Unsetting metadata can be done by setting the provided
   * {@code BlobInfo} objects metadata to {@code null}. See
   * {@link #update(BlobInfo)} for a code example.
   *
   * <p>Example of updating information on several blobs using a single batch request.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * Blob firstBlob = storage.get(bucketName, blobName1);
   * Blob secondBlob = storage.get(bucketName, blobName2);
   * List<BlobInfo> blobs = new LinkedList<>();
   * blobs.add(firstBlob.toBuilder().setContentType("text/plain").build());
   * blobs.add(secondBlob.toBuilder().setContentType("text/plain").build());
   * List<Blob> updatedBlobs = storage.update(blobs);
   * }</pre>
   *
   * @param blobInfos blobs to update
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it
   *     has been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  List<Blob> update(Iterable<BlobInfo> blobInfos);

  /**
   * Deletes the requested blobs. A batch request is used to perform this call.
   *
   * <p>Example of deleting several blobs using a single batch request.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * BlobId firstBlob = BlobId.of(bucketName, blobName1);
   * BlobId secondBlob = BlobId.of(bucketName, blobName2);
   * List<Boolean> deleted = storage.delete(firstBlob, secondBlob);
   * }</pre>
   *
   * @param blobIds blobs to delete
   * @return an immutable list of booleans. If a blob has been deleted the corresponding item in the
   *     list is {@code true}. If a blob was not found, deletion failed or access to the resource
   *     was denied the corresponding item is {@code false}.
   * @throws StorageException upon failure
   */
  List<Boolean> delete(BlobId... blobIds);

  /**
   * Deletes the requested blobs. A batch request is used to perform this call.
   *
   * <p>Example of deleting several blobs using a single batch request.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName1 = "my_blob_name1";
   * String blobName2 = "my_blob_name2";
   * List<BlobId> blobIds = new LinkedList<>();
   * blobIds.add(BlobId.of(bucketName, blobName1));
   * blobIds.add(BlobId.of(bucketName, blobName2));
   * List<Boolean> deleted = storage.delete(blobIds);
   * }</pre>
   *
   * @param blobIds blobs to delete
   * @return an immutable list of booleans. If a blob has been deleted the corresponding item in the
   *     list is {@code true}. If a blob was not found, deletion failed or access to the resource
   *     was denied the corresponding item is {@code false}.
   * @throws StorageException upon failure
   */
  List<Boolean> delete(Iterable<BlobId> blobIds);

  /**
   * Returns the ACL entry for the specified entity on the specified bucket or {@code null} if not
   * found.
   *
   * <p>Example of getting the ACL entry for an entity on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Acl acl = storage.getAcl(bucketName, User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * <p>Example of getting the ACL entry for a specific user on a requester_pays bucket with a
   * user_project option.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String userEmail = "google-cloud-java-tests@java-docs-samples-tests.iam.gserviceaccount.com";
   * BucketSourceOption userProjectOption = BucketSourceOption.userProject("myProject");
   * Acl acl = storage.getAcl(bucketName, new User(userEmail), userProjectOption);
   * }</pre>
   *
   * @param bucket name of the bucket where the getAcl operation takes place
   * @param entity ACL entity to fetch
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  Acl getAcl(String bucket, Entity entity, BucketSourceOption... options);

  /**
   * @see #getAcl(String, Entity, BucketSourceOption...)
   */
  Acl getAcl(String bucket, Entity entity);

  /**
   * Deletes the ACL entry for the specified entity on the specified bucket.
   *
   * <p>Example of deleting the ACL entry for an entity on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * boolean deleted = storage.deleteAcl(bucketName, User.ofAllAuthenticatedUsers());
   * if (deleted) {
   *   // the acl entry was deleted
   * } else {
   *   // the acl entry was not found
   * }
   * }</pre>
   *
   * <p>Example of deleting the ACL entry for a specific user on a requester_pays bucket with a
   * user_project option.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * BucketSourceOption userProject = BucketSourceOption.userProject("myProject");
   * boolean deleted = storage.deleteAcl(bucketName, User.ofAllAuthenticatedUsers(), userProject);
   * }</pre>
   *
   * @param bucket name of the bucket to delete an ACL from
   * @param entity ACL entity to delete
   * @param options extra parameters to apply to this operation
   * @return {@code true} if the ACL was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean deleteAcl(String bucket, Entity entity, BucketSourceOption... options);

  /**
   * @see #deleteAcl(String, Entity, BucketSourceOption...)
   */
  boolean deleteAcl(String bucket, Entity entity);

  /**
   * Creates a new ACL entry on the specified bucket.
   *
   * <p>Example of creating a new ACL entry on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Acl acl = storage.createAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
   * }</pre>
   *
   * <p>Example of creating a new ACL entry on a requester_pays bucket with a user_project option.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Acl acl = storage.createAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER),
   *     BucketSourceOption.userProject("myProject"));
   * }</pre>
   *
   * @param bucket name of the bucket for which an ACL should be created
   * @param acl ACL to create
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  Acl createAcl(String bucket, Acl acl, BucketSourceOption... options);

  /**
   * @see #createAcl(String, Acl, BucketSourceOption...)
   */
  Acl createAcl(String bucket, Acl acl);

  /**
   * Updates an ACL entry on the specified bucket.
   *
   * <p>Example of updating a new ACL entry on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Acl acl = storage.updateAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
   * }</pre>
   *
   * <p>Example of updating a new ACL entry on a requester_pays bucket with a user_project option.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Acl acl = storage.updateAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER),
   *     BucketSourceOption.userProject("myProject"));
   * }</pre>
   *
   * @param bucket name of the bucket where the updateAcl operation takes place
   * @param acl ACL to update
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  Acl updateAcl(String bucket, Acl acl, BucketSourceOption... options);

  /**
   * @see #updateAcl(String, Acl, BucketSourceOption...)
   */
  Acl updateAcl(String bucket, Acl acl);

  /**
   * Lists the ACL entries for the provided bucket.
   *
   * <p>Example of listing the ACL entries for a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * List<Acl> acls = storage.listAcls(bucketName);
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * <p>Example of listing the ACL entries for a blob in a requester_pays bucket with a user_project
   * option.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * List<Acl> acls = storage.listAcls(bucketName, BucketSourceOption.userProject("myProject"));
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * @param bucket the name of the bucket to list ACLs for
   * @param options any number of BucketSourceOptions to apply to this operation
   * @throws StorageException upon failure
   */
  List<Acl> listAcls(String bucket, BucketSourceOption... options);

  /**
   * @see #listAcls(String, BucketSourceOption...)
   */
  List<Acl> listAcls(String bucket);

  /**
   * Returns the default object ACL entry for the specified entity on the specified bucket or
   * {@code null} if not found.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of getting the default ACL entry for an entity on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Acl acl = storage.getDefaultAcl(bucketName, User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Acl getDefaultAcl(String bucket, Entity entity);

  /**
   * Deletes the default object ACL entry for the specified entity on the specified bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of deleting the default ACL entry for an entity on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * boolean deleted = storage.deleteDefaultAcl(bucketName, User.ofAllAuthenticatedUsers());
   * if (deleted) {
   *   // the acl entry was deleted
   * } else {
   *   // the acl entry was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the ACL was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean deleteDefaultAcl(String bucket, Entity entity);

  /**
   * Creates a new default blob ACL entry on the specified bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of creating a new default ACL entry on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Acl acl =
   *     storage.createDefaultAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Acl createDefaultAcl(String bucket, Acl acl);

  /**
   * Updates a default blob ACL entry on the specified bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of updating a new default ACL entry on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Acl acl =
   *     storage.updateDefaultAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Acl updateDefaultAcl(String bucket, Acl acl);

  /**
   * Lists the default blob ACL entries for the provided bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of listing the default ACL entries for a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * List<Acl> acls = storage.listDefaultAcls(bucketName);
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  List<Acl> listDefaultAcls(String bucket);

  /**
   * Returns the ACL entry for the specified entity on the specified blob or {@code null} if not
   * found.
   *
   * <p>Example of getting the ACL entry for an entity on a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * Acl acl = storage.getAcl(blobId, User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * <p>Example of getting the ACL entry for a specific user on a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * String userEmail = "google-cloud-java-tests@java-docs-samples-tests.iam.gserviceaccount.com";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Acl acl = storage.getAcl(blobId, new User(userEmail));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Acl getAcl(BlobId blob, Entity entity);

  /**
   * Deletes the ACL entry for the specified entity on the specified blob.
   *
   * <p>Example of deleting the ACL entry for an entity on a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * boolean deleted = storage.deleteAcl(blobId, User.ofAllAuthenticatedUsers());
   * if (deleted) {
   *   // the acl entry was deleted
   * } else {
   *   // the acl entry was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the ACL was deleted, {@code false} if it was not found
   * @throws StorageException upon failure
   */
  boolean deleteAcl(BlobId blob, Entity entity);

  /**
   * Creates a new ACL entry on the specified blob.
   *
   * <p>Example of creating a new ACL entry on a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * Acl acl = storage.createAcl(blobId, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
   * }</pre>
   *
   * <p>Example of updating a blob to be public-read.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * Acl acl = storage.createAcl(blobId, Acl.of(User.ofAllUsers(), Role.READER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Acl createAcl(BlobId blob, Acl acl);

  /**
   * Updates an ACL entry on the specified blob.
   *
   * <p>Example of updating a new ACL entry on a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * Acl acl = storage.updateAcl(blobId, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  Acl updateAcl(BlobId blob, Acl acl);

  /**
   * Lists the ACL entries for the provided blob.
   *
   * <p>Example of listing the ACL entries for a blob.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * String blobName = "my_blob_name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * List<Acl> acls = storage.listAcls(blobId);
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  List<Acl> listAcls(BlobId blob);

  /**
   * Gets the IAM policy for the provided bucket.
   *
   * <p>Example of getting the IAM policy for a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * Policy policy = storage.getIamPolicy(bucketName);
   * }</pre>
   *
   * @param bucket name of the bucket where the getIamPolicy operation takes place
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  Policy getIamPolicy(String bucket, BucketSourceOption... options);

  /**
   * Updates the IAM policy on the specified bucket.
   *
   * <p>Example of updating the IAM policy on a bucket.
   * <pre>{@code
   * // We want to make all objects in our bucket publicly readable.
   * String bucketName = "my_unique_bucket";
   * Policy currentPolicy = storage.getIamPolicy(bucketName);
   * Policy updatedPolicy =
   *     storage.setIamPolicy(
   *         bucketName,
   *         currentPolicy.toBuilder()
   *             .addIdentity(StorageRoles.objectViewer(), Identity.allUsers())
   *             .build());
   * }</pre>
   *
   * @param bucket name of the bucket where the setIamPolicy operation takes place
   * @param policy policy to be set on the specified bucket
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  Policy setIamPolicy(String bucket, Policy policy, BucketSourceOption... options);

  /**
   * Tests whether the caller holds the permissions on the specified bucket. Returns a list of
   * booleans in the same placement and order in which the permissions were specified.
   *
   * <p>Example of testing permissions on a bucket.
   * <pre> {@code
   * String bucketName = "my_unique_bucket";
   * List<Boolean> response =
   *     storage.testIamPermissions(
   *         bucket,
   *         ImmutableList.of("storage.buckets.get", "storage.buckets.getIamPolicy"));
   * for (boolean hasPermission : response) {
   *   // Do something with permission test response
   * }
   * }</pre>
   *
   * @param bucket name of the bucket where the testIamPermissions operation takes place
   * @param permissions list of permissions to test on the bucket
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  List<Boolean> testIamPermissions(String bucket, List<String> permissions, BucketSourceOption... options);

  /**
   * Returns the service account associated with the given project.
   *
   * <p>Example of getting a service account.
   * <pre> {@code
   * String projectId = "test@gmail.com";
   * ServiceAccount account = storage.getServiceAccount(projectId);
   * }</pre>
   *
   * @param projectId the ID of the project for which the service account should be fetched.
   * @return the service account associated with this project
   * @throws StorageException upon failure
   */
  ServiceAccount getServiceAccount(String projectId);
}

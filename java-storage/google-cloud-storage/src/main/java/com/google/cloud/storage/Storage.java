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

import static com.google.cloud.storage.CrossTransportUtils.fmtMethodName;
import static com.google.cloud.storage.CrossTransportUtils.throwGrpcOnly;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.gax.paging.Page;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.ServiceAccountSigner.SigningException;
import com.google.cloud.FieldSelector;
import com.google.cloud.Policy;
import com.google.cloud.ReadChannel;
import com.google.cloud.Service;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.PostPolicyV4.PostConditionsV4;
import com.google.cloud.storage.PostPolicyV4.PostFieldsV4;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.BucketListOpt;
import com.google.cloud.storage.UnifiedOpts.BucketSourceOpt;
import com.google.cloud.storage.UnifiedOpts.BucketTargetOpt;
import com.google.cloud.storage.UnifiedOpts.HmacKeyListOpt;
import com.google.cloud.storage.UnifiedOpts.HmacKeySourceOpt;
import com.google.cloud.storage.UnifiedOpts.HmacKeyTargetOpt;
import com.google.cloud.storage.UnifiedOpts.NamedField;
import com.google.cloud.storage.UnifiedOpts.NestedNamedField;
import com.google.cloud.storage.UnifiedOpts.ObjectListOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectSourceOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An interface for Google Cloud Storage.
 *
 * @see <a href="https://cloud.google.com/storage/docs">Google Cloud Storage</a>
 */
@InternalExtensionOnly
public interface Storage extends Service<StorageOptions>, AutoCloseable {

  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  enum PredefinedAcl {
    AUTHENTICATED_READ("authenticatedRead", "authenticated-read"),
    ALL_AUTHENTICATED_USERS("allAuthenticatedUsers", "all-authenticated-users"),
    PRIVATE("private", "private"),
    PROJECT_PRIVATE("projectPrivate", "project-private"),
    PUBLIC_READ("publicRead", "public-read"),
    PUBLIC_READ_WRITE("publicReadWrite", "public-read-write"),
    BUCKET_OWNER_READ("bucketOwnerRead", "bucket-owner-read"),
    BUCKET_OWNER_FULL_CONTROL("bucketOwnerFullControl", "bucket-owner-full-control");

    private final String entry;
    private final String xmlEntry;

    PredefinedAcl(String entry, String xmlEntry) {
      this.entry = entry;
      this.xmlEntry = xmlEntry;
    }

    String getEntry() {
      return entry;
    }

    String getXmlEntry() {
      return xmlEntry;
    }
  }

  enum BucketField implements FieldSelector, NamedField {
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    ID("id", "bucket_id", String.class),
    @TransportCompatibility(Transport.HTTP)
    SELF_LINK("selfLink", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    NAME("name", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    TIME_CREATED("timeCreated", "create_time", com.google.api.client.util.DateTime.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    METAGENERATION("metageneration", Long.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    ACL("acl", ArrayList.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    DEFAULT_OBJECT_ACL("defaultObjectAcl", "default_object_acl", ArrayList.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    OWNER("owner", com.google.api.services.storage.model.Bucket.Owner.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    LABELS("labels", HashMap.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    LOCATION("location", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    LOCATION_TYPE("locationType", "location_type", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    WEBSITE("website", com.google.api.services.storage.model.Bucket.Website.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    VERSIONING("versioning", com.google.api.services.storage.model.Bucket.Versioning.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CORS("cors", ArrayList.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    LIFECYCLE("lifecycle", com.google.api.services.storage.model.Bucket.Lifecycle.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    STORAGE_CLASS("storageClass", "storage_class", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    ETAG("etag", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    ENCRYPTION("encryption", com.google.api.services.storage.model.Bucket.Encryption.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    BILLING("billing", com.google.api.services.storage.model.Bucket.Billing.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    DEFAULT_EVENT_BASED_HOLD("defaultEventBasedHold", "default_event_based_hold", Boolean.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    RETENTION_POLICY(
        "retentionPolicy",
        "retention_policy",
        com.google.api.services.storage.model.Bucket.RetentionPolicy.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    IAMCONFIGURATION(
        "iamConfiguration",
        "iam_config",
        com.google.api.services.storage.model.Bucket.IamConfiguration.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    LOGGING("logging", com.google.api.services.storage.model.Bucket.Logging.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    UPDATED("updated", "update_time", com.google.api.client.util.DateTime.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    RPO("rpo", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CUSTOM_PLACEMENT_CONFIG(
        "customPlacementConfig",
        "custom_placement_config",
        com.google.api.services.storage.model.Bucket.CustomPlacementConfig.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    AUTOCLASS("autoclass", com.google.api.services.storage.model.Bucket.Autoclass.class),

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    HIERARCHICAL_NAMESPACE(
        "hierarchicalNamespace",
        "hierarchical_namespace",
        com.google.api.services.storage.model.Bucket.HierarchicalNamespace.class),
    @TransportCompatibility({Transport.HTTP})
    OBJECT_RETENTION(
        "objectRetention", com.google.api.services.storage.model.Bucket.ObjectRetention.class),

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    SOFT_DELETE_POLICY(
        "softDeletePolicy",
        "soft_delete_policy",
        com.google.api.services.storage.model.Bucket.SoftDeletePolicy.class),

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    PROJECT("projectNumber", "project", BigInteger.class),
    /**
     * @since 2.54.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    IP_FILTER("ipFilter", "ip_filter", com.google.api.services.storage.model.Bucket.IpFilter.class),
    ;

    static final List<BucketField> REQUIRED_FIELDS = ImmutableList.of(NAME);
    private static final Map<String, BucketField> JSON_FIELD_NAME_INDEX;

    static {
      ImmutableMap.Builder<String, BucketField> tmp = ImmutableMap.builder();
      for (BucketField field : values()) {
        tmp.put(field.selector, field);
      }
      JSON_FIELD_NAME_INDEX = Utils.mapBuild(tmp);
    }

    private final String selector;
    private final String grpcFieldName;
    private final Class<?> jsonClass;

    BucketField(String selector, Class<?> jsonClass) {
      this(selector, selector, jsonClass);
    }

    BucketField(String selector, String grpcFieldName, Class<?> jsonClass) {
      this.selector = selector;
      this.grpcFieldName = grpcFieldName;
      this.jsonClass = jsonClass;
    }

    @Override
    public String getSelector() {
      return selector;
    }

    @Override
    public String getApiaryName() {
      return selector;
    }

    @Override
    public String getGrpcName() {
      return grpcFieldName;
    }

    Class<?> getJsonClass() {
      return jsonClass;
    }

    @Nullable
    static BucketField lookup(NamedField nf) {
      NamedField lookup = nf;
      if (nf instanceof NestedNamedField) {
        NestedNamedField nested = (NestedNamedField) nf;
        lookup = nested.getParent();
      }
      return JSON_FIELD_NAME_INDEX.get(lookup.getApiaryName());
    }
  }

  enum BlobField implements FieldSelector, NamedField {
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    ACL("acl", com.google.api.services.storage.model.ObjectAccessControl.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    BUCKET("bucket", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CACHE_CONTROL("cacheControl", "cache_control", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    COMPONENT_COUNT("componentCount", "component_count", Integer.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CONTENT_DISPOSITION("contentDisposition", "content_disposition", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CONTENT_ENCODING("contentEncoding", "content_encoding", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CONTENT_LANGUAGE("contentLanguage", "content_language", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CONTENT_TYPE("contentType", "content_type", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CRC32C("crc32c", "checksums.crc32c", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    ETAG("etag", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    GENERATION("generation", Long.class),
    @TransportCompatibility(Transport.HTTP)
    ID("id", String.class),
    /** {@code kind} is not exposed in {@link BlobInfo} or {@link Blob} no need to select it */
    @Deprecated
    @TransportCompatibility(Transport.HTTP)
    KIND("kind", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    MD5HASH("md5Hash", "checksums.md5_hash", String.class),
    @TransportCompatibility(Transport.HTTP)
    MEDIA_LINK("mediaLink", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    METADATA("metadata", HashMap.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    METAGENERATION("metageneration", Long.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    NAME("name", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    OWNER("owner", com.google.api.services.storage.model.StorageObject.Owner.class),
    @TransportCompatibility(Transport.HTTP)
    SELF_LINK("selfLink", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    SIZE("size", java.math.BigInteger.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    STORAGE_CLASS("storageClass", "storage_class", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    TIME_DELETED("timeDeleted", "delete_time", com.google.api.client.util.DateTime.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    TIME_CREATED("timeCreated", "create_time", com.google.api.client.util.DateTime.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    KMS_KEY_NAME("kmsKeyName", "kms_key", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    EVENT_BASED_HOLD("eventBasedHold", "event_based_hold", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    TEMPORARY_HOLD("temporaryHold", "temporary_hold", String.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    RETENTION_EXPIRATION_TIME(
        "retentionExpirationTime",
        "retention_expire_time",
        com.google.api.client.util.DateTime.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    UPDATED("updated", "update_time", com.google.api.client.util.DateTime.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CUSTOM_TIME("customTime", "custom_time", com.google.api.client.util.DateTime.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    TIME_STORAGE_CLASS_UPDATED(
        "timeStorageClassUpdated",
        "update_storage_class_time",
        com.google.api.client.util.DateTime.class),
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    CUSTOMER_ENCRYPTION("customerEncryption", "customer_encryption", String.class),
    @TransportCompatibility({Transport.HTTP})
    RETENTION("retention", com.google.api.services.storage.model.StorageObject.Retention.class),

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    SOFT_DELETE_TIME(
        "softDeleteTime", "soft_delete_time", com.google.api.client.util.DateTime.class),

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    HARD_DELETE_TIME(
        "hardDeleteTime", "hard_delete_time", com.google.api.client.util.DateTime.class),

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    OBJECT_CONTEXTS(
        "contexts", "contexts", com.google.api.services.storage.model.StorageObject.Contexts.class);

    static final List<NamedField> REQUIRED_FIELDS = ImmutableList.of(BUCKET, NAME);
    private static final Map<String, BlobField> JSON_FIELD_NAME_INDEX;

    static {
      ImmutableMap.Builder<String, BlobField> tmp = ImmutableMap.builder();
      for (BlobField field : values()) {
        tmp.put(field.selector, field);
      }
      JSON_FIELD_NAME_INDEX = Utils.mapBuild(tmp);
    }

    private final String selector;
    private final String grpcFieldName;
    private final Class<?> jsonClass;

    BlobField(String selector, Class<?> jsonClass) {
      this(selector, selector, jsonClass);
    }

    BlobField(String selector, String grpcFieldName, Class<?> jsonClass) {
      this.selector = selector;
      this.grpcFieldName = grpcFieldName;
      this.jsonClass = jsonClass;
    }

    @Override
    public String getSelector() {
      return selector;
    }

    @Override
    public String getApiaryName() {
      return selector;
    }

    @Override
    public String getGrpcName() {
      return grpcFieldName;
    }

    Class<?> getJsonClass() {
      return jsonClass;
    }

    @Nullable
    static BlobField lookup(NamedField nf) {
      NamedField lookup = nf;
      if (nf instanceof NestedNamedField) {
        NestedNamedField nested = (NestedNamedField) nf;
        lookup = nested.getParent();
      }
      return JSON_FIELD_NAME_INDEX.get(lookup.getApiaryName());
    }
  }

  enum UriScheme {
    HTTP("http"),
    HTTPS("https");

    private final String scheme;

    UriScheme(String scheme) {
      this.scheme = scheme;
    }

    public String getScheme() {
      return scheme;
    }
  }

  /** Class for specifying bucket target options. */
  class BucketTargetOption extends Option<BucketTargetOpt> {

    private static final long serialVersionUID = 6699243191830059404L;

    private BucketTargetOption(BucketTargetOpt opt) {
      super(opt);
    }

    /** Returns an option for specifying bucket's predefined ACL configuration. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketTargetOption predefinedAcl(@NonNull PredefinedAcl acl) {
      return new BucketTargetOption(UnifiedOpts.predefinedAcl(acl));
    }

    /** Returns an option for specifying bucket's default ACL configuration for blobs. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketTargetOption predefinedDefaultObjectAcl(@NonNull PredefinedAcl acl) {
      return new BucketTargetOption(UnifiedOpts.predefinedDefaultObjectAcl(acl));
    }

    /**
     * Returns an option for enabling Object Retention on this bucket. Enabling this will create an
     * ObjectRetention object in the created bucket (You must use this option, creating your own
     * ObjectRetention object in the request won't work).
     */
    @TransportCompatibility({Transport.HTTP})
    public static BucketTargetOption enableObjectRetention(boolean enable) {
      return new BucketTargetOption(UnifiedOpts.enableObjectRetention(enable));
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketTargetOption metagenerationMatch() {
      return new BucketTargetOption(UnifiedOpts.metagenerationMatchExtractor());
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if metageneration matches.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketTargetOption metagenerationNotMatch() {
      return new BucketTargetOption(UnifiedOpts.metagenerationNotMatchExtractor());
    }

    /**
     * Returns an option to define the billing user project. This option is required by buckets with
     * `requester_pays` flag enabled to assign operation costs.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketTargetOption userProject(@NonNull String userProject) {
      return new BucketTargetOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option to define the projection in the API request. In some cases this option may
     * be needed to be set to `noAcl` to omit ACL data from the response. The default value is
     * `full`
     *
     * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/buckets/patch">Buckets:
     *     patch</a>
     */
    @TransportCompatibility({Transport.HTTP})
    public static BucketTargetOption projection(@NonNull String projection) {
      return new BucketTargetOption(UnifiedOpts.projection(projection));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketTargetOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new BucketTargetOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BucketTargetOption[] dedupe(BucketTargetOption... os) {
      return Option.dedupe(BucketTargetOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketTargetOption[] dedupe(
        Collection<BucketTargetOption> collection, BucketTargetOption... os) {
      return Option.dedupe(BucketTargetOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketTargetOption[] dedupe(
        BucketTargetOption[] array, BucketTargetOption... os) {
      return Option.dedupe(BucketTargetOption[]::new, array, os);
    }
  }

  /** Class for specifying bucket source options. */
  class BucketSourceOption extends Option<BucketSourceOpt> {

    private static final long serialVersionUID = 3808812145390746748L;

    BucketSourceOption(BucketSourceOpt opt) {
      super(opt);
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if bucket's metageneration does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketSourceOption metagenerationMatch(long metageneration) {
      return new BucketSourceOption(UnifiedOpts.metagenerationMatch(metageneration));
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if bucket's metageneration matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketSourceOption metagenerationNotMatch(long metageneration) {
      return new BucketSourceOption(UnifiedOpts.metagenerationNotMatch(metageneration));
    }

    /**
     * Returns an option for bucket's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketSourceOption userProject(@NonNull String userProject) {
      return new BucketSourceOption(UnifiedOpts.userProject(userProject));
    }

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketSourceOption requestedPolicyVersion(long version) {
      return new BucketSourceOption(UnifiedOpts.requestedPolicyVersion(version));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketSourceOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new BucketSourceOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BucketSourceOption[] dedupe(BucketSourceOption... os) {
      return Option.dedupe(BucketSourceOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketSourceOption[] dedupe(
        Collection<BucketSourceOption> collection, BucketSourceOption... os) {
      return Option.dedupe(BucketSourceOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketSourceOption[] dedupe(
        BucketSourceOption[] array, BucketSourceOption... os) {
      return Option.dedupe(BucketSourceOption[]::new, array, os);
    }
  }

  /** Class for specifying listHmacKeys options */
  class ListHmacKeysOption extends Option<HmacKeyListOpt> {

    private ListHmacKeysOption(HmacKeyListOpt opt) {
      super(opt);
    }

    /**
     * Returns an option for the Service Account whose keys to list. If this option is not used,
     * keys for all accounts will be listed.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static ListHmacKeysOption serviceAccount(@NonNull ServiceAccount serviceAccount) {
      return new ListHmacKeysOption(UnifiedOpts.serviceAccount(serviceAccount));
    }

    /** Returns an option for the maximum amount of HMAC keys returned per page. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static ListHmacKeysOption maxResults(long pageSize) {
      return new ListHmacKeysOption(UnifiedOpts.pageSize(pageSize));
    }

    /** Returns an option to specify the page token from which to start listing HMAC keys. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static ListHmacKeysOption pageToken(@NonNull String pageToken) {
      return new ListHmacKeysOption(UnifiedOpts.pageToken(pageToken));
    }

    /**
     * Returns an option to specify whether to show deleted keys in the result. This option is false
     * by default.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static ListHmacKeysOption showDeletedKeys(boolean showDeletedKeys) {
      return new ListHmacKeysOption(UnifiedOpts.showDeletedKeys(showDeletedKeys));
    }

    /**
     * Returns an option to specify the project to be billed for this request. Required for
     * Requester Pays buckets.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static ListHmacKeysOption userProject(@NonNull String userProject) {
      return new ListHmacKeysOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option to specify the Project ID for this request. If not specified, defaults to
     * Application Default Credentials.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static ListHmacKeysOption projectId(@NonNull String projectId) {
      return new ListHmacKeysOption(UnifiedOpts.projectId(projectId));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static ListHmacKeysOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new ListHmacKeysOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static ListHmacKeysOption[] dedupe(ListHmacKeysOption... os) {
      return Option.dedupe(ListHmacKeysOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static ListHmacKeysOption[] dedupe(
        Collection<ListHmacKeysOption> collection, ListHmacKeysOption... os) {
      return Option.dedupe(ListHmacKeysOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static ListHmacKeysOption[] dedupe(
        ListHmacKeysOption[] array, ListHmacKeysOption... os) {
      return Option.dedupe(ListHmacKeysOption[]::new, array, os);
    }
  }

  /** Class for specifying createHmacKey options */
  class CreateHmacKeyOption extends Option<HmacKeyTargetOpt> {

    private CreateHmacKeyOption(HmacKeyTargetOpt opt) {
      super(opt);
    }

    /**
     * Returns an option to specify the project to be billed for this request. Required for
     * Requester Pays buckets.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static CreateHmacKeyOption userProject(@NonNull String userProject) {
      return new CreateHmacKeyOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option to specify the Project ID for this request. If not specified, defaults to
     * Application Default Credentials.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static CreateHmacKeyOption projectId(@NonNull String projectId) {
      return new CreateHmacKeyOption(UnifiedOpts.projectId(projectId));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static CreateHmacKeyOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new CreateHmacKeyOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static CreateHmacKeyOption[] dedupe(CreateHmacKeyOption... os) {
      return Option.dedupe(CreateHmacKeyOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static CreateHmacKeyOption[] dedupe(
        Collection<CreateHmacKeyOption> collection, CreateHmacKeyOption... os) {
      return Option.dedupe(CreateHmacKeyOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static CreateHmacKeyOption[] dedupe(
        CreateHmacKeyOption[] array, CreateHmacKeyOption... os) {
      return Option.dedupe(CreateHmacKeyOption[]::new, array, os);
    }
  }

  /** Class for specifying getHmacKey options */
  class GetHmacKeyOption extends Option<HmacKeySourceOpt> {

    private GetHmacKeyOption(HmacKeySourceOpt opt) {
      super(opt);
    }

    /**
     * Returns an option to specify the project to be billed for this request. Required for
     * Requester Pays buckets.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static GetHmacKeyOption userProject(@NonNull String userProject) {
      return new GetHmacKeyOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option to specify the Project ID for this request. If not specified, defaults to
     * Application Default Credentials.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static GetHmacKeyOption projectId(@NonNull String projectId) {
      return new GetHmacKeyOption(UnifiedOpts.projectId(projectId));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static GetHmacKeyOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new GetHmacKeyOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static GetHmacKeyOption[] dedupe(GetHmacKeyOption... os) {
      return Option.dedupe(GetHmacKeyOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static GetHmacKeyOption[] dedupe(
        Collection<GetHmacKeyOption> collection, GetHmacKeyOption... os) {
      return Option.dedupe(GetHmacKeyOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static GetHmacKeyOption[] dedupe(GetHmacKeyOption[] array, GetHmacKeyOption... os) {
      return Option.dedupe(GetHmacKeyOption[]::new, array, os);
    }
  }

  /** Class for specifying deleteHmacKey options */
  class DeleteHmacKeyOption extends Option<HmacKeyTargetOpt> {

    private DeleteHmacKeyOption(HmacKeyTargetOpt opt) {
      super(opt);
    }

    /**
     * Returns an option to specify the project to be billed for this request. Required for
     * Requester Pays buckets.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static DeleteHmacKeyOption userProject(@NonNull String userProject) {
      return new DeleteHmacKeyOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static DeleteHmacKeyOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new DeleteHmacKeyOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static DeleteHmacKeyOption[] dedupe(DeleteHmacKeyOption... os) {
      return Option.dedupe(DeleteHmacKeyOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static DeleteHmacKeyOption[] dedupe(
        Collection<DeleteHmacKeyOption> collection, DeleteHmacKeyOption... os) {
      return Option.dedupe(DeleteHmacKeyOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static DeleteHmacKeyOption[] dedupe(
        DeleteHmacKeyOption[] array, DeleteHmacKeyOption... os) {
      return Option.dedupe(DeleteHmacKeyOption[]::new, array, os);
    }
  }

  /** Class for specifying updateHmacKey options */
  class UpdateHmacKeyOption extends Option<HmacKeyTargetOpt> {

    private UpdateHmacKeyOption(HmacKeyTargetOpt opt) {
      super(opt);
    }

    /**
     * Returns an option to specify the project to be billed for this request. Required for
     * Requester Pays buckets.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static UpdateHmacKeyOption userProject(@NonNull String userProject) {
      return new UpdateHmacKeyOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static UpdateHmacKeyOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new UpdateHmacKeyOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static UpdateHmacKeyOption[] dedupe(UpdateHmacKeyOption... os) {
      return Option.dedupe(UpdateHmacKeyOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static UpdateHmacKeyOption[] dedupe(
        Collection<UpdateHmacKeyOption> collection, UpdateHmacKeyOption... os) {
      return Option.dedupe(UpdateHmacKeyOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static UpdateHmacKeyOption[] dedupe(
        UpdateHmacKeyOption[] array, UpdateHmacKeyOption... os) {
      return Option.dedupe(UpdateHmacKeyOption[]::new, array, os);
    }
  }

  /** Class for specifying bucket get options. */
  class BucketGetOption extends Option<BucketSourceOpt> {

    private static final long serialVersionUID = -669900932880354035L;

    BucketGetOption(BucketSourceOpt opt) {
      super(opt);
    }

    /**
     * Returns an option for bucket's metageneration match. If this option is used the request will
     * fail if bucket's metageneration does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketGetOption metagenerationMatch(long metageneration) {
      return new BucketGetOption(UnifiedOpts.metagenerationMatch(metageneration));
    }

    /**
     * Returns an option for bucket's metageneration mismatch. If this option is used the request
     * will fail if bucket's metageneration matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketGetOption metagenerationNotMatch(long metageneration) {
      return new BucketGetOption(UnifiedOpts.metagenerationNotMatch(metageneration));
    }

    /**
     * Returns an option for bucket's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketGetOption userProject(@NonNull String userProject) {
      return new BucketGetOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option to specify the bucket's fields to be returned by the RPC call. If this
     * option is not provided all bucket's fields are returned. {@code BucketGetOption.fields}) can
     * be used to specify only the fields of interest. Bucket name is always returned, even if not
     * specified.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketGetOption fields(BucketField... fields) {
      requireNonNull(fields, "fields must be non null");
      ImmutableSet<NamedField> set =
          ImmutableSet.<NamedField>builder()
              .addAll(BucketField.REQUIRED_FIELDS)
              .add(fields)
              .build();
      return new BucketGetOption(UnifiedOpts.fields(set));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketGetOption extraHeaders(@NonNull ImmutableMap<String, String> extraHeaders) {
      return new BucketGetOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BucketGetOption[] dedupe(BucketGetOption... os) {
      return Option.dedupe(BucketGetOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketGetOption[] dedupe(
        Collection<BucketGetOption> collection, BucketGetOption... os) {
      return Option.dedupe(BucketGetOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketGetOption[] dedupe(BucketGetOption[] array, BucketGetOption... os) {
      return Option.dedupe(BucketGetOption[]::new, array, os);
    }
  }

  /** Class for specifying blob target options. */
  class BlobTargetOption extends Option<ObjectTargetOpt> {

    private static final long serialVersionUID = -5554842495450599563L;

    BlobTargetOption(ObjectTargetOpt opt) {
      super(opt);
    }

    /** Returns an option for specifying blob's predefined ACL configuration. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption predefinedAcl(@NonNull PredefinedAcl acl) {
      return new BlobTargetOption(UnifiedOpts.predefinedAcl(acl));
    }

    /**
     * Returns an option that causes an operation to succeed only if the target blob does not exist.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption doesNotExist() {
      return new BlobTargetOption(UnifiedOpts.doesNotExist());
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if generation does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption generationMatch() {
      return new BlobTargetOption(UnifiedOpts.generationMatchExtractor());
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption generationMatch(long generation) {
      return new BlobTargetOption(UnifiedOpts.generationMatch(generation));
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if generation matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption generationNotMatch(long generation) {
      return new BlobTargetOption(UnifiedOpts.generationNotMatch(generation));
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if generation matches.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption generationNotMatch() {
      return new BlobTargetOption(UnifiedOpts.generationNotMatchExtractor());
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption metagenerationMatch() {
      return new BlobTargetOption(UnifiedOpts.metagenerationMatchExtractor());
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if blob's metageneration does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption metagenerationMatch(long metageneration) {
      return new BlobTargetOption(UnifiedOpts.metagenerationMatch(metageneration));
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption metagenerationNotMatch(long metageneration) {
      return new BlobTargetOption(UnifiedOpts.metagenerationNotMatch(metageneration));
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption metagenerationNotMatch() {
      return new BlobTargetOption(UnifiedOpts.metagenerationNotMatchExtractor());
    }

    /**
     * Returns an option for blob's data disabledGzipContent. If this option is used, the request
     * will create a blob with disableGzipContent; at present, this is only for upload.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption disableGzipContent() {
      return new BlobTargetOption(UnifiedOpts.disableGzipContent());
    }

    /**
     * Returns an option for detecting content type. If this option is used, the content type is
     * detected from the blob name if not explicitly set. This option is on the client side only, it
     * does not appear in a RPC call.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption detectContentType() {
      return new BlobTargetOption(UnifiedOpts.detectContentType());
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption encryptionKey(@NonNull Key key) {
      return new BlobTargetOption(UnifiedOpts.encryptionKey(key));
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption userProject(@NonNull String userProject) {
      return new BlobTargetOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption encryptionKey(@NonNull String key) {
      return new BlobTargetOption(UnifiedOpts.encryptionKey(key));
    }

    /** Returns an option to set a customer-managed key for server-side encryption of the blob. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption kmsKeyName(@NonNull String kmsKeyName) {
      return new BlobTargetOption(UnifiedOpts.kmsKeyName(kmsKeyName));
    }

    /**
     * Returns an option for overriding an Unlocked Retention policy. This must be set to true in
     * order to change a policy from Unlocked to Locked, to set it to null, or to reduce its
     * retainUntilTime attribute.
     */
    @TransportCompatibility({Transport.HTTP})
    public static BlobTargetOption overrideUnlockedRetention(boolean overrideUnlockedRetention) {
      return new BlobTargetOption(UnifiedOpts.overrideUnlockedRetention(overrideUnlockedRetention));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobTargetOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new BlobTargetOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BlobTargetOption[] dedupe(BlobTargetOption... os) {
      return Option.dedupe(BlobTargetOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobTargetOption[] dedupe(
        Collection<BlobTargetOption> collection, BlobTargetOption... os) {
      return Option.dedupe(BlobTargetOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobTargetOption[] dedupe(BlobTargetOption[] array, BlobTargetOption... os) {
      return Option.dedupe(BlobTargetOption[]::new, array, os);
    }
  }

  /** Class for specifying blob write options. */
  class BlobWriteOption extends Option<ObjectTargetOpt> implements Serializable {

    private static final long serialVersionUID = 5536338021856320475L;

    BlobWriteOption(ObjectTargetOpt opt) {
      super(opt);
    }

    /** Returns an option for specifying blob's predefined ACL configuration. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption predefinedAcl(@NonNull PredefinedAcl acl) {
      return new BlobWriteOption(UnifiedOpts.predefinedAcl(acl));
    }

    /**
     * Returns an option that causes an operation to succeed only if the target blob does not exist.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption doesNotExist() {
      return new BlobWriteOption(UnifiedOpts.doesNotExist());
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if generation does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption generationMatch() {
      return new BlobWriteOption(UnifiedOpts.generationMatchExtractor());
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption generationMatch(long generation) {
      return new BlobWriteOption(UnifiedOpts.generationMatch(generation));
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if generation matches.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption generationNotMatch() {
      return new BlobWriteOption(UnifiedOpts.generationNotMatchExtractor());
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption generationNotMatch(long generation) {
      return new BlobWriteOption(UnifiedOpts.generationNotMatch(generation));
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if metageneration does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption metagenerationMatch() {
      return new BlobWriteOption(UnifiedOpts.metagenerationMatchExtractor());
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if blob's generation does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption metagenerationMatch(long metageneration) {
      return new BlobWriteOption(UnifiedOpts.metagenerationMatch(metageneration));
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if metageneration matches.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption metagenerationNotMatch() {
      return new BlobWriteOption(UnifiedOpts.metagenerationNotMatchExtractor());
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if blob's generation does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption metagenerationNotMatch(long metageneration) {
      return new BlobWriteOption(UnifiedOpts.metagenerationNotMatch(metageneration));
    }

    /**
     * Returns an option for blob's data MD5 hash match. If this option is used the request will
     * fail if blobs' data MD5 hash does not match.
     *
     * @deprecated Please compute and use a crc32c checksum instead. {@link #crc32cMatch()}
     */
    @Deprecated
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption md5Match() {
      return new BlobWriteOption(UnifiedOpts.md5MatchExtractor());
    }

    /**
     * Returns an option for blob's data CRC32C checksum match. If this option is used the request
     * will fail if blobs' data CRC32C checksum does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption crc32cMatch() {
      return new BlobWriteOption(UnifiedOpts.crc32cMatchExtractor());
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption encryptionKey(@NonNull Key key) {
      return new BlobWriteOption(UnifiedOpts.encryptionKey(key));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption encryptionKey(@NonNull String key) {
      return new BlobWriteOption(UnifiedOpts.encryptionKey(key));
    }

    /**
     * Returns an option to set a customer-managed KMS key for server-side encryption of the blob.
     *
     * @param kmsKeyName the KMS key resource id
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption kmsKeyName(@NonNull String kmsKeyName) {
      return new BlobWriteOption(UnifiedOpts.kmsKeyName(kmsKeyName));
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption userProject(@NonNull String userProject) {
      return new BlobWriteOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option that signals automatic gzip compression should not be performed en route to
     * the bucket.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption disableGzipContent() {
      return new BlobWriteOption(UnifiedOpts.disableGzipContent());
    }

    /**
     * Returns an option for detecting content type. If this option is used, the content type is
     * detected from the blob name if not explicitly set. This option is on the client side only, it
     * does not appear in a RPC call.
     *
     * <p>Content type detection is based on the database presented by {@link
     * URLConnection#getFileNameMap()}
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption detectContentType() {
      return new BlobWriteOption(UnifiedOpts.detectContentType());
    }

    /**
     * Set a precondition on the number of bytes that GCS should expect for a resumable upload. See
     * the docs for <a
     * href="https://cloud.google.com/storage/docs/json_api/v1/parameters#xuploadcontentlength">X-Upload-Content-Length</a>
     * for more detail.
     *
     * <p>If the method invoked with this option does not perform a resumable upload, this option
     * will be ignored.
     *
     * @since 2.42.0
     */
    @BetaApi
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption expectedObjectSize(long objectContentSize) {
      return new BlobWriteOption(UnifiedOpts.resumableUploadExpectedObjectSize(objectContentSize));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobWriteOption extraHeaders(@NonNull ImmutableMap<String, String> extraHeaders) {
      return new BlobWriteOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BlobWriteOption[] dedupe(BlobWriteOption... os) {
      return Option.dedupe(BlobWriteOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobWriteOption[] dedupe(
        Collection<BlobWriteOption> collection, BlobWriteOption... os) {
      return Option.dedupe(BlobWriteOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobWriteOption[] dedupe(BlobWriteOption[] array, BlobWriteOption... os) {
      return Option.dedupe(BlobWriteOption[]::new, array, os);
    }
  }

  /** Class for specifying blob source options. */
  class BlobSourceOption extends Option<ObjectSourceOpt> {

    private static final long serialVersionUID = -8626355836092280204L;

    BlobSourceOption(ObjectSourceOpt opt) {
      super(opt);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match. The generation value to compare with the actual
     * blob's generation is taken from a source {@link BlobId} object. When this option is passed to
     * a {@link Storage} method and {@link BlobId#getGeneration()} is {@code null} or no {@link
     * BlobId} is provided an exception is thrown.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption generationMatch() {
      return new BlobSourceOption(UnifiedOpts.generationMatchExtractor());
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption generationMatch(long generation) {
      return new BlobSourceOption(UnifiedOpts.generationMatch(generation));
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches. The generation value to compare with the actual
     * blob's generation is taken from a source {@link BlobId} object. When this option is passed to
     * a {@link Storage} method and {@link BlobId#getGeneration()} is {@code null} or no {@link
     * BlobId} is provided an exception is thrown.
     *
     * @deprecated This option is invalid, and can never result in a valid response from the server.
     *     use {@link #generationNotMatch(long)} instead.
     */
    @Deprecated
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption generationNotMatch() {
      return new BlobSourceOption(UnifiedOpts.generationNotMatchExtractor());
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption generationNotMatch(long generation) {
      return new BlobSourceOption(UnifiedOpts.generationNotMatch(generation));
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if blob's metageneration does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption metagenerationMatch(long metageneration) {
      return new BlobSourceOption(UnifiedOpts.metagenerationMatch(metageneration));
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if blob's metageneration matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption metagenerationNotMatch(long metageneration) {
      return new BlobSourceOption(UnifiedOpts.metagenerationNotMatch(metageneration));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption decryptionKey(@NonNull Key key) {
      return new BlobSourceOption(UnifiedOpts.decryptionKey(key));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side encryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption decryptionKey(@NonNull String key) {
      return new BlobSourceOption(UnifiedOpts.decryptionKey(key));
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption userProject(@NonNull String userProject) {
      return new BlobSourceOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option for whether the request should return the raw input stream, instead of
     * automatically decompressing the content. By default, this is false for Blob.downloadTo(), but
     * true for ReadChannel.read().
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption shouldReturnRawInputStream(boolean shouldReturnRawInputStream) {
      return new BlobSourceOption(UnifiedOpts.returnRawInputStream(shouldReturnRawInputStream));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobSourceOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new BlobSourceOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BlobSourceOption[] dedupe(BlobSourceOption... os) {
      return Option.dedupe(BlobSourceOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobSourceOption[] dedupe(
        Collection<BlobSourceOption> collection, BlobSourceOption... os) {
      return Option.dedupe(BlobSourceOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobSourceOption[] dedupe(BlobSourceOption[] array, BlobSourceOption... os) {
      return Option.dedupe(BlobSourceOption[]::new, array, os);
    }
  }

  /** Class for specifying blob get options. */
  class BlobGetOption extends Option<ObjectSourceOpt> {

    private static final long serialVersionUID = -2857961421224394114L;

    BlobGetOption(ObjectSourceOpt opt) {
      super(opt);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match. The generation value to compare with the actual
     * blob's generation is taken from a source {@link BlobId} object. When this option is passed to
     * a {@link Storage} method and {@link BlobId#getGeneration()} is {@code null} or no {@link
     * BlobId} is provided an exception is thrown.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption generationMatch() {
      return new BlobGetOption(UnifiedOpts.generationMatchExtractor());
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if blob's generation does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption generationMatch(long generation) {
      return new BlobGetOption(UnifiedOpts.generationMatch(generation));
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches. The generation value to compare with the actual
     * blob's generation is taken from a source {@link BlobId} object. When this option is passed to
     * a {@link Storage} method and {@link BlobId#getGeneration()} is {@code null} or no {@link
     * BlobId} is provided an exception is thrown.
     *
     * @deprecated This option is invalid, and can never result in a valid response from the server.
     *     use {@link #generationNotMatch(long)} instead.
     */
    @Deprecated
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption generationNotMatch() {
      return new BlobGetOption(UnifiedOpts.generationNotMatchExtractor());
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption generationNotMatch(long generation) {
      return new BlobGetOption(UnifiedOpts.generationNotMatch(generation));
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if blob's metageneration does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption metagenerationMatch(long metageneration) {
      return new BlobGetOption(UnifiedOpts.metagenerationMatch(metageneration));
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if blob's metageneration matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption metagenerationNotMatch(long metageneration) {
      return new BlobGetOption(UnifiedOpts.metagenerationNotMatch(metageneration));
    }

    /**
     * Returns an option to specify the blob's fields to be returned by the RPC call. If this option
     * is not provided all blob's fields are returned. {@code BlobGetOption.fields}) can be used to
     * specify only the fields of interest. Blob name and bucket are always returned, even if not
     * specified.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption fields(BlobField... fields) {
      requireNonNull(fields, "fields must be non null");
      ImmutableSet<NamedField> set =
          ImmutableSet.<NamedField>builder().addAll(BlobField.REQUIRED_FIELDS).add(fields).build();
      return new BlobGetOption(UnifiedOpts.fields(set));
    }

    /**
     * Returns an option for blob's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption userProject(@NonNull String userProject) {
      return new BlobGetOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side decryption of the
     * blob.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption decryptionKey(@NonNull Key key) {
      return new BlobGetOption(UnifiedOpts.decryptionKey(key));
    }

    /**
     * Returns an option to set a customer-supplied AES256 key for server-side decryption of the
     * blob.
     *
     * @param key the AES256 encoded in base64
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption decryptionKey(@NonNull String key) {
      return new BlobGetOption(UnifiedOpts.decryptionKey(key));
    }

    /**
     * Returns an option for whether the request should return the raw input stream, instead of
     * automatically decompressing the content. By default, this is false for Blob.downloadTo(), but
     * true for ReadChannel.read().
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption shouldReturnRawInputStream(boolean shouldReturnRawInputStream) {
      return new BlobGetOption(UnifiedOpts.returnRawInputStream(shouldReturnRawInputStream));
    }

    /**
     * Returns an option for whether the request should return a soft-deleted object. If an object
     * has been soft-deleted (Deleted while a Soft Delete Policy) is in place, this must be true or
     * the request will return null.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption softDeleted(boolean softDeleted) {
      return new BlobGetOption(UnifiedOpts.softDeleted(softDeleted));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobGetOption extraHeaders(@NonNull ImmutableMap<String, String> extraHeaders) {
      return new BlobGetOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BlobGetOption[] dedupe(BlobGetOption... os) {
      return Option.dedupe(BlobGetOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobGetOption[] dedupe(
        Collection<BlobGetOption> collection, BlobGetOption... os) {
      return Option.dedupe(BlobGetOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobGetOption[] dedupe(BlobGetOption[] array, BlobGetOption... os) {
      return Option.dedupe(BlobGetOption[]::new, array, os);
    }
  }

  /** Class for specifying blob restore options * */
  class BlobRestoreOption extends Option<ObjectSourceOpt> {

    private static final long serialVersionUID = 1922118465380110958L;

    BlobRestoreOption(ObjectSourceOpt opt) {
      super(opt);
    }

    /**
     * Returns an option for blob's data generation match. If this option is used the request will
     * fail if generation does not match.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobRestoreOption generationMatch(long generation) {
      return new BlobRestoreOption(UnifiedOpts.generationMatch(generation));
    }

    /**
     * Returns an option for blob's data generation mismatch. If this option is used the request
     * will fail if blob's generation matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobRestoreOption generationNotMatch(long generation) {
      return new BlobRestoreOption(UnifiedOpts.generationNotMatch(generation));
    }

    /**
     * Returns an option for blob's metageneration match. If this option is used the request will
     * fail if blob's metageneration does not match the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobRestoreOption metagenerationMatch(long generation) {
      return new BlobRestoreOption(UnifiedOpts.metagenerationMatch(generation));
    }

    /**
     * Returns an option for blob's metageneration mismatch. If this option is used the request will
     * fail if blob's metageneration matches the provided value.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobRestoreOption metagenerationNotMatch(long generation) {
      return new BlobRestoreOption(UnifiedOpts.metagenerationNotMatch(generation));
    }

    /**
     * Returns an option for whether the restored object should copy the access controls of the
     * source object.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobRestoreOption copySourceAcl(boolean copySourceAcl) {
      return new BlobRestoreOption(UnifiedOpts.copySourceAcl(copySourceAcl));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobRestoreOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new BlobRestoreOption(UnifiedOpts.extraHeaders(extraHeaders));
    }
  }

  /** Class for specifying bucket list options. */
  class BucketListOption extends Option<BucketListOpt> {

    private static final long serialVersionUID = 6388807550815607557L;

    private BucketListOption(BucketListOpt opt) {
      super(opt);
    }

    /** Returns an option to specify the maximum number of buckets returned per page. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketListOption pageSize(long pageSize) {
      return new BucketListOption(UnifiedOpts.pageSize(pageSize));
    }

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketListOption returnPartialSuccess(boolean returnPartialSuccess) {
      return new BucketListOption(UnifiedOpts.returnPartialSuccess(returnPartialSuccess));
    }

    /** Returns an option to specify the page token from which to start listing buckets. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketListOption pageToken(@NonNull String pageToken) {
      return new BucketListOption(UnifiedOpts.pageToken(pageToken));
    }

    /**
     * Returns an option to set a prefix to filter results to buckets whose names begin with this
     * prefix.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketListOption prefix(@NonNull String prefix) {
      return new BucketListOption(UnifiedOpts.prefix(prefix));
    }

    /**
     * Returns an option for bucket's billing user project. This option is only used by the buckets
     * with 'requester_pays' flag.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketListOption userProject(@NonNull String userProject) {
      return new BucketListOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * Returns an option to specify the bucket's fields to be returned by the RPC call. If this
     * option is not provided all bucket's fields are returned. {@code BucketListOption.fields}) can
     * be used to specify only the fields of interest. Bucket name is always returned, even if not
     * specified.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketListOption fields(BucketField... fields) {
      requireNonNull(fields, "fields must be non null");
      ImmutableSet<NamedField> set =
          Streams.concat(
                  Stream.of(NamedField.literal("nextPageToken")),
                  Streams.concat(BucketField.REQUIRED_FIELDS.stream(), Arrays.stream(fields))
                      .map(f -> NamedField.prefixed("items/", f)))
              .collect(ImmutableSet.toImmutableSet());
      return new BucketListOption(UnifiedOpts.fields(set));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BucketListOption extraHeaders(
        @NonNull ImmutableMap<String, String> extraHeaders) {
      return new BucketListOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BucketListOption[] dedupe(BucketListOption... os) {
      return Option.dedupe(BucketListOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketListOption[] dedupe(
        Collection<BucketListOption> collection, BucketListOption... os) {
      return Option.dedupe(BucketListOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BucketListOption[] dedupe(BucketListOption[] array, BucketListOption... os) {
      return Option.dedupe(BucketListOption[]::new, array, os);
    }
  }

  /** Class for specifying blob list options. */
  class BlobListOption extends Option<ObjectListOpt> {

    private static final long serialVersionUID = 5216908055423927281L;

    private BlobListOption(ObjectListOpt opt) {
      super(opt);
    }

    /** Returns an option to specify the maximum number of blobs returned per page. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption pageSize(long pageSize) {
      return new BlobListOption(UnifiedOpts.pageSize(pageSize));
    }

    /** Returns an option to specify the page token from which to start listing blobs. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption pageToken(@NonNull String pageToken) {
      return new BlobListOption(UnifiedOpts.pageToken(pageToken));
    }

    /**
     * Returns an option to set a prefix to filter results to blobs whose names begin with this
     * prefix.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption prefix(@NonNull String prefix) {
      return new BlobListOption(UnifiedOpts.prefix(prefix));
    }

    /**
     * If specified, results are returned in a directory-like mode. Blobs whose names, after a
     * possible {@link #prefix(String)}, do not contain the '/' delimiter are returned as is. Blobs
     * whose names, after a possible {@link #prefix(String)}, contain the '/' delimiter, will have
     * their name truncated after the delimiter and will be returned as {@link Blob} objects where
     * only {@link Blob#getBlobId()}, {@link Blob#getSize()} and {@link Blob#isDirectory()} are set.
     * For such directory blobs, ({@link BlobId#getGeneration()} returns {@code null}), {@link
     * Blob#getSize()} returns {@code 0} while {@link Blob#isDirectory()} returns {@code true}.
     * Duplicate directory blobs are omitted.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption currentDirectory() {
      return new BlobListOption(UnifiedOpts.currentDirectory());
    }

    /**
     * Returns an option to set a delimiter.
     *
     * @param delimiter generally '/' is the one used most often, but you can used other delimiters
     *     as well.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption delimiter(@NonNull String delimiter) {
      return new BlobListOption(UnifiedOpts.delimiter(delimiter));
    }

    /**
     * Returns an option to set a startOffset to filter results to objects whose names are
     * lexicographically equal to or after startOffset. If endOffset is also set, the objects listed
     * have names between startOffset (inclusive) and endOffset (exclusive).
     *
     * @param startOffset startOffset to filter the results
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption startOffset(@NonNull String startOffset) {
      return new BlobListOption(UnifiedOpts.startOffset(startOffset));
    }

    /**
     * Returns an option to set a endOffset to filter results to objects whose names are
     * lexicographically before endOffset. If startOffset is also set, the objects listed have names
     * between startOffset (inclusive) and endOffset (exclusive).
     *
     * @param endOffset endOffset to filter the results
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption endOffset(@NonNull String endOffset) {
      return new BlobListOption(UnifiedOpts.endOffset(endOffset));
    }

    /**
     * Returns an option to set a glob pattern to filter results to blobs that match the pattern.
     *
     * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/list">List
     *     Objects</a>
     */
    @BetaApi
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption matchGlob(@NonNull String glob) {
      return new BlobListOption(UnifiedOpts.matchGlob(glob));
    }

    /**
     * Returns an option for whether to include all Folders (including empty Folders) in response.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption includeFolders(boolean includeFolders) {
      return new BlobListOption(UnifiedOpts.includeFoldersAsPrefixes(includeFolders));
    }

    /**
     * Returns an option which will cause blobs that end in exactly one instance of `delimiter` will
     * have their metadata included rather than being synthetic objects.
     *
     * @since 2.52.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption includeTrailingDelimiter() {
      return new BlobListOption(UnifiedOpts.includeTrailingDelimiter());
    }

    /**
     * Returns an option to define the billing user project. This option is required by buckets with
     * `requester_pays` flag enabled to assign operation costs.
     *
     * @param userProject projectId of the billing user project.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption userProject(@NonNull String userProject) {
      return new BlobListOption(UnifiedOpts.userProject(userProject));
    }

    /**
     * If set to {@code true}, lists all versions of a blob. The default is {@code false}.
     *
     * @see <a href="https://cloud.google.com/storage/docs/object-versioning">Object Versioning</a>
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption versions(boolean versions) {
      return new BlobListOption(UnifiedOpts.versionsFilter(versions));
    }

    /**
     * Returns an option to specify the blob's fields to be returned by the RPC call. If this option
     * is not provided all blob's fields are returned. {@code BlobListOption.fields}) can be used to
     * specify only the fields of interest. Blob name and bucket are always returned, even if not
     * specified.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption fields(BlobField... fields) {
      requireNonNull(fields, "fields must be non null");
      ImmutableSet<NamedField> set =
          Streams.concat(
                  Stream.of(NamedField.literal("nextPageToken"), NamedField.literal("prefixes")),
                  Streams.concat(BlobField.REQUIRED_FIELDS.stream(), Arrays.stream(fields))
                      .map(f -> NamedField.prefixed("items/", f)))
              .collect(ImmutableSet.toImmutableSet());
      return new BlobListOption(UnifiedOpts.fields(set));
    }

    /** Returns an option for whether the list result should include soft-deleted objects. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption softDeleted(boolean softDeleted) {
      return new BlobListOption(UnifiedOpts.softDeleted(softDeleted));
    }

    /**
     * Returns an option to filter list results based on object attributes, such as object contexts.
     *
     * @param filter The filter string.
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption filter(String filter) {
      return new BlobListOption(UnifiedOpts.objectFilter(filter));
    }

    /**
     * A set of extra headers to be set for all requests performed within the scope of the operation
     * this option is passed to (a get, read, resumable upload etc).
     *
     * <p>If the same header name is specified across multiple options provided to a method, the
     * first occurrence will be the value included in the request(s).
     *
     * <p>The following headers are not allowed to be specified, and will result in an {@link
     * IllegalArgumentException}.
     *
     * <ol>
     *   <li>{@code Accept-Encoding}
     *   <li>{@code Cache-Control}
     *   <li>{@code Connection}
     *   <li>{@code Content-ID}
     *   <li>{@code Content-Length}
     *   <li>{@code Content-Range}
     *   <li>{@code Content-Transfer-Encoding}
     *   <li>{@code Content-Type}
     *   <li>{@code Date}
     *   <li>{@code ETag}
     *   <li>{@code If-Match}
     *   <li>{@code If-None-Match}
     *   <li>{@code Keep-Alive}
     *   <li>{@code Range}
     *   <li>{@code TE}
     *   <li>{@code Trailer}
     *   <li>{@code Transfer-Encoding}
     *   <li>{@code User-Agent}
     *   <li>{@code X-Goog-Api-Client}
     *   <li>{@code X-Goog-Content-Length-Range}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Algorithm}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key}
     *   <li>{@code X-Goog-Copy-Source-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Encryption-Algorithm}
     *   <li>{@code X-Goog-Encryption-Key}
     *   <li>{@code X-Goog-Encryption-Key-Sha256}
     *   <li>{@code X-Goog-Gcs-Idempotency-Token}
     *   <li>{@code X-Goog-Meta-*}
     *   <li>{@code X-Goog-User-Project}
     *   <li>{@code X-HTTP-Method-Override}
     *   <li>{@code X-Upload-Content-Length}
     *   <li>{@code X-Upload-Content-Type}
     * </ol>
     *
     * @since 2.49.0
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static BlobListOption extraHeaders(@NonNull ImmutableMap<String, String> extraHeaders) {
      return new BlobListOption(UnifiedOpts.extraHeaders(extraHeaders));
    }

    /**
     * Deduplicate any options which are the same parameter. The value which comes last in {@code
     * os} will be the value included in the return.
     */
    public static BlobListOption[] dedupe(BlobListOption... os) {
      return Option.dedupe(BlobListOption[]::new, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobListOption[] dedupe(
        Collection<BlobListOption> collection, BlobListOption... os) {
      return Option.dedupe(BlobListOption[]::new, collection, os);
    }

    /**
     * Deduplicate any options which are the same parameter.
     *
     * <p>The value which comes last in {@code collection} and {@code os} will be the value included
     * in the return. All options from {@code os} will override their counterparts in {@code
     * collection}.
     */
    public static BlobListOption[] dedupe(BlobListOption[] array, BlobListOption... os) {
      return Option.dedupe(BlobListOption[]::new, array, os);
    }
  }

  /** Class for specifying Post Policy V4 options. * */
  class PostPolicyV4Option implements Serializable {
    private static final long serialVersionUID = -1592545784993528897L;
    private final PostPolicyV4Option.Option option;
    private final Object value;

    @TransportCompatibility(Transport.HTTP)
    enum Option {
      PATH_STYLE,
      VIRTUAL_HOSTED_STYLE,
      BUCKET_BOUND_HOST_NAME,
      SERVICE_ACCOUNT_CRED
    }

    private PostPolicyV4Option(Option option, Object value) {
      this.option = option;
      this.value = value;
    }

    PostPolicyV4Option.Option getOption() {
      return option;
    }

    Object getValue() {
      return value;
    }

    /**
     * Provides a service account signer to sign the policy. If not provided an attempt is made to
     * get it from the environment.
     *
     * @see <a href="https://cloud.google.com/storage/docs/authentication#service_accounts">Service
     *     Accounts</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static PostPolicyV4Option signWith(ServiceAccountSigner signer) {
      return new PostPolicyV4Option(PostPolicyV4Option.Option.SERVICE_ACCOUNT_CRED, signer);
    }

    /**
     * Use a virtual hosted-style hostname, which adds the bucket into the host portion of the URI
     * rather than the path, e.g. 'https://mybucket.storage.googleapis.com/...'. The bucket name is
     * obtained from the resource passed in.
     *
     * @see <a href="https://cloud.google.com/storage/docs/request-endpoints">Request Endpoints</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static PostPolicyV4Option withVirtualHostedStyle() {
      return new PostPolicyV4Option(PostPolicyV4Option.Option.VIRTUAL_HOSTED_STYLE, "");
    }

    /**
     * Generates a path-style URL, which places the bucket name in the path portion of the URL
     * instead of in the hostname, e.g 'https://storage.googleapis.com/mybucket/...'. Note that this
     * cannot be used alongside {@code withVirtualHostedStyle()}. Virtual hosted-style URLs, which
     * can be used via the {@code withVirtualHostedStyle()} method, should generally be preferred
     * instead of path-style URLs.
     *
     * @see <a href="https://cloud.google.com/storage/docs/request-endpoints">Request Endpoints</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static PostPolicyV4Option withPathStyle() {
      return new PostPolicyV4Option(PostPolicyV4Option.Option.PATH_STYLE, "");
    }

    /**
     * Use a bucket-bound hostname, which replaces the storage.googleapis.com host with the name of
     * a CNAME bucket, e.g. a bucket named 'gcs-subdomain.my.domain.tld', or a Google Cloud Load
     * Balancer which routes to a bucket you own, e.g. 'my-load-balancer-domain.tld'. Note that this
     * cannot be used alongside {@code withVirtualHostedStyle()} or {@code withPathStyle()}. This
     * method signature uses HTTP for the URI scheme, and is equivalent to calling {@code
     * withBucketBoundHostname("...", UriScheme.HTTP).}
     *
     * @see <a href="https://cloud.google.com/storage/docs/request-endpoints#cname">CNAME
     *     Redirects</a>
     * @see <a
     *     href="https://cloud.google.com/load-balancing/docs/https/adding-backend-buckets-to-load-balancers">
     *     GCLB Redirects</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static PostPolicyV4Option withBucketBoundHostname(String bucketBoundHostname) {
      return withBucketBoundHostname(bucketBoundHostname, Storage.UriScheme.HTTP);
    }

    /**
     * Use a bucket-bound hostname, which replaces the storage.googleapis.com host with the name of
     * a CNAME bucket, e.g. a bucket named 'gcs-subdomain.my.domain.tld', or a Google Cloud Load
     * Balancer which routes to a bucket you own, e.g. 'my-load-balancer-domain.tld'. Note that this
     * cannot be used alongside {@code withVirtualHostedStyle()} or {@code withPathStyle()}. The
     * bucket name itself should not include the URI scheme (http or https), so it is specified via
     * a local enum.
     *
     * @see <a href="https://cloud.google.com/storage/docs/request-endpoints#cname">CNAME
     *     Redirects</a>
     * @see <a
     *     href="https://cloud.google.com/load-balancing/docs/https/adding-backend-buckets-to-load-balancers">
     *     GCLB Redirects</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static PostPolicyV4Option withBucketBoundHostname(
        String bucketBoundHostname, Storage.UriScheme uriScheme) {
      return new PostPolicyV4Option(
          PostPolicyV4Option.Option.BUCKET_BOUND_HOST_NAME,
          uriScheme.getScheme() + "://" + bucketBoundHostname);
    }
  }

  /** Class for specifying signed URL options. */
  class SignUrlOption implements Serializable {

    private static final long serialVersionUID = -3165388740755311106L;

    private final Option option;
    private final Object value;

    @TransportCompatibility(Transport.HTTP)
    enum Option {
      HTTP_METHOD,
      CONTENT_TYPE,
      MD5,
      EXT_HEADERS,
      SERVICE_ACCOUNT_CRED,
      SIGNATURE_VERSION,
      HOST_NAME,
      PATH_STYLE,
      VIRTUAL_HOSTED_STYLE,
      BUCKET_BOUND_HOST_NAME,
      QUERY_PARAMS
    }

    @TransportCompatibility(Transport.HTTP)
    enum SignatureVersion {
      V2,
      V4
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
     * The HTTP method to be used with the signed URL. If this method is not called, defaults to
     * GET.
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption httpMethod(HttpMethod httpMethod) {
      return new SignUrlOption(Option.HTTP_METHOD, httpMethod);
    }

    /**
     * Use it if signature should include the blob's content-type. When used, users of the signed
     * URL should include the blob's content-type with their request. If using this URL from a
     * browser, you must include a content type that matches what the browser will send.
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withContentType() {
      return new SignUrlOption(Option.CONTENT_TYPE, true);
    }

    /**
     * Use it if signature should include the blob's md5. When used, users of the signed URL should
     * include the blob's md5 with their request.
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withMd5() {
      return new SignUrlOption(Option.MD5, true);
    }

    /**
     * Use it if signature should include the blob's canonicalized extended headers. When used,
     * users of the signed URL should include the canonicalized extended headers with their request.
     *
     * @see <a href="https://cloud.google.com/storage/docs/xml-api/reference-headers">Request
     *     Headers</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withExtHeaders(Map<String, String> extHeaders) {
      return new SignUrlOption(Option.EXT_HEADERS, extHeaders);
    }

    /**
     * Use if signature version should be V2. This is the default if neither this or {@code
     * withV4Signature()} is called.
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withV2Signature() {
      return new SignUrlOption(Option.SIGNATURE_VERSION, SignatureVersion.V2);
    }

    /**
     * Use if signature version should be V4. Note that V4 Signed URLs can't have an expiration
     * longer than 7 days. V2 will be the default if neither this or {@code withV2Signature()} is
     * called.
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withV4Signature() {
      return new SignUrlOption(Option.SIGNATURE_VERSION, SignatureVersion.V4);
    }

    /**
     * Provides a service account signer to sign the URL. If not provided an attempt is made to get
     * it from the environment.
     *
     * @see <a href="https://cloud.google.com/storage/docs/authentication#service_accounts">Service
     *     Accounts</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption signWith(ServiceAccountSigner signer) {
      return new SignUrlOption(Option.SERVICE_ACCOUNT_CRED, signer);
    }

    /**
     * Use a different host name than the default host name 'storage.googleapis.com'. This option is
     * particularly useful for developers to point requests to an alternate endpoint (e.g. a staging
     * environment or sending requests through VPC). If using this with the {@code
     * withVirtualHostedStyle()} method, you should omit the bucket name from the hostname, as it
     * automatically gets prepended to the hostname for virtual hosted-style URLs.
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withHostName(String hostName) {
      return new SignUrlOption(Option.HOST_NAME, hostName);
    }

    /**
     * Use a virtual hosted-style hostname, which adds the bucket into the host portion of the URI
     * rather than the path, e.g. 'https://mybucket.storage.googleapis.com/...'. The bucket name is
     * obtained from the resource passed in. For V4 signing, this also sets the "host" header in the
     * canonicalized extension headers to the virtual hosted-style host, unless that header is
     * supplied via the {@code withExtHeaders()} method.
     *
     * @see <a href="https://cloud.google.com/storage/docs/request-endpoints">Request Endpoints</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withVirtualHostedStyle() {
      return new SignUrlOption(Option.VIRTUAL_HOSTED_STYLE, "");
    }

    /**
     * Generates a path-style URL, which places the bucket name in the path portion of the URL
     * instead of in the hostname, e.g 'https://storage.googleapis.com/mybucket/...'. This cannot be
     * used alongside {@code withVirtualHostedStyle()}. Virtual hosted-style URLs, which can be used
     * via the {@code withVirtualHostedStyle()} method, should generally be preferred instead of
     * path-style URLs.
     *
     * @see <a href="https://cloud.google.com/storage/docs/request-endpoints">Request Endpoints</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withPathStyle() {
      return new SignUrlOption(Option.PATH_STYLE, "");
    }

    /**
     * Use a bucket-bound hostname, which replaces the storage.googleapis.com host with the name of
     * a CNAME bucket, e.g. a bucket named 'gcs-subdomain.my.domain.tld', or a Google Cloud Load
     * Balancer which routes to a bucket you own, e.g. 'my-load-balancer-domain.tld'. This cannot be
     * used alongside {@code withVirtualHostedStyle()} or {@code withPathStyle()}. This method
     * signature uses HTTP for the URI scheme, and is equivalent to calling {@code
     * withBucketBoundHostname("...", UriScheme.HTTP).}
     *
     * @see <a href="https://cloud.google.com/storage/docs/request-endpoints#cname">CNAME
     *     Redirects</a>
     * @see <a
     *     href="https://cloud.google.com/load-balancing/docs/https/adding-backend-buckets-to-load-balancers">
     *     GCLB Redirects</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withBucketBoundHostname(String bucketBoundHostname) {
      return withBucketBoundHostname(bucketBoundHostname, UriScheme.HTTP);
    }

    /**
     * Use a bucket-bound hostname, which replaces the storage.googleapis.com host with the name of
     * a CNAME bucket, e.g. a bucket named 'gcs-subdomain.my.domain.tld', or a Google Cloud Load
     * Balancer which routes to a bucket you own, e.g. 'my-load-balancer-domain.tld'. Note that this
     * cannot be used alongside {@code withVirtualHostedStyle()} or {@code withPathStyle()}. The
     * bucket name itself should not include the URI scheme (http or https), so it is specified via
     * a local enum.
     *
     * @see <a href="https://cloud.google.com/storage/docs/request-endpoints#cname">CNAME
     *     Redirects</a>
     * @see <a
     *     href="https://cloud.google.com/load-balancing/docs/https/adding-backend-buckets-to-load-balancers">
     *     GCLB Redirects</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withBucketBoundHostname(
        String bucketBoundHostname, UriScheme uriScheme) {
      return new SignUrlOption(
          Option.BUCKET_BOUND_HOST_NAME, uriScheme.getScheme() + "://" + bucketBoundHostname);
    }

    /**
     * Use if the URL should contain additional query parameters.
     *
     * <p>Warning: For V2 Signed URLs, it is possible for query parameters to be altered after the
     * URL has been signed, as the parameters are not used to compute the signature. The V4 signing
     * method should be preferred when supplying additional query parameters, as the parameters
     * cannot be added, removed, or otherwise altered after a V4 signature is generated.
     *
     * @see <a href="https://cloud.google.com/storage/docs/authentication/canonical-requests">
     *     Canonical Requests</a>
     * @see <a href="https://cloud.google.com/storage/docs/access-control/signed-urls-v2">V2 Signing
     *     Process</a>
     */
    @TransportCompatibility(Transport.HTTP)
    public static SignUrlOption withQueryParams(Map<String, String> queryParams) {
      return new SignUrlOption(Option.QUERY_PARAMS, queryParams);
    }
  }

  /**
   * A class to contain all information needed for a Google Cloud Storage Compose operation.
   *
   * @see <a href="https://cloud.google.com/storage/docs/composite-objects#_Compose">Compose
   *     Operation</a>
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  class ComposeRequest implements Serializable {

    private static final long serialVersionUID = 6612204553167273919L;

    private final List<SourceBlob> sourceBlobs;
    private final BlobInfo target;
    private final List<BlobTargetOption> targetOptions;

    private transient Opts<ObjectTargetOpt> targetOpts;

    /** Class for Compose source blobs. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static class SourceBlob implements Serializable {

      private static final long serialVersionUID = -157636474404489874L;

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

    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static class Builder {

      private final List<SourceBlob> sourceBlobs = new LinkedList<>();
      private final Set<BlobTargetOption> targetOptions = new LinkedHashSet<>();
      private BlobInfo target;
      private Opts<ObjectTargetOpt> opts = Opts.empty();

      /** Add source blobs for compose operation. */
      public Builder addSource(Iterable<String> blobs) {
        for (String blob : blobs) {
          sourceBlobs.add(new SourceBlob(blob));
        }
        return this;
      }

      /** Add source blobs for compose operation. */
      public Builder addSource(String... blobs) {
        return addSource(Arrays.asList(blobs));
      }

      /** Add a source with a specific generation to match. */
      public Builder addSource(String blob, long generation) {
        sourceBlobs.add(new SourceBlob(blob, generation));
        return this;
      }

      /** Sets compose operation's target blob. */
      public Builder setTarget(BlobInfo target) {
        this.target = target;
        return this;
      }

      Builder setTargetOpts(Opts<ObjectTargetOpt> opts) {
        this.opts = opts;
        return this;
      }

      /** Sets compose operation's target blob options. */
      public Builder setTargetOptions(BlobTargetOption... options) {
        Collections.addAll(targetOptions, options);
        return this;
      }

      /** Sets compose operation's target blob options. */
      public Builder setTargetOptions(Iterable<BlobTargetOption> options) {
        Iterables.addAll(targetOptions, options);
        return this;
      }

      /** Creates a {@code ComposeRequest} object. */
      public ComposeRequest build() {
        checkArgument(!sourceBlobs.isEmpty());
        checkNotNull(target);
        checkNotNull(opts);
        return new ComposeRequest(this);
      }
    }

    private ComposeRequest(Builder builder) {
      sourceBlobs = ImmutableList.copyOf(builder.sourceBlobs);
      target = builder.target;
      // keep targetOptions for serialization even though we will read targetOpts
      targetOptions = ImmutableList.copyOf(builder.targetOptions);
      targetOpts = builder.opts.prepend(Opts.unwrap(targetOptions).resolveFrom(target));
    }

    /** Returns compose operation's source blobs. */
    public List<SourceBlob> getSourceBlobs() {
      return sourceBlobs;
    }

    /** Returns compose operation's target blob. */
    public BlobInfo getTarget() {
      return target;
    }

    /** Returns compose operation's target blob's options. */
    public List<BlobTargetOption> getTargetOptions() {
      return targetOptions;
    }

    @InternalApi
    Opts<ObjectTargetOpt> getTargetOpts() {
      return targetOpts;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      if (this.targetOptions != null) {
        this.targetOpts = Opts.unwrap(this.targetOptions);
      } else {
        this.targetOpts = Opts.empty();
      }
    }

    /**
     * Creates a {@code ComposeRequest} object.
     *
     * @param sources source blobs names
     * @param target target blob
     */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
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
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static ComposeRequest of(String bucket, Iterable<String> sources, String target) {
      return of(sources, BlobInfo.newBuilder(BlobId.of(bucket, target)).build());
    }

    /** Returns a {@code ComposeRequest} builder. */
    @TransportCompatibility({Transport.HTTP, Transport.GRPC})
    public static Builder newBuilder() {
      return new Builder();
    }
  }

  /** A class to contain all information needed for a Google Cloud Storage Copy operation. */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  class CopyRequest implements Serializable {

    private static final long serialVersionUID = 5670794463350011330L;

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

      /** Creates a {@code CopyRequest} object. */
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

    /** Returns the blob to copy, as a {@link BlobId}. */
    public BlobId getSource() {
      return source;
    }

    /** Returns blob's source options. */
    public List<BlobSourceOption> getSourceOptions() {
      return sourceOptions;
    }

    /** Returns the {@link BlobInfo} for the target blob. */
    public BlobInfo getTarget() {
      return target;
    }

    /**
     * Returns whether to override the target blob information with {@link #getTarget()}. If {@code
     * true}, the value of {@link #getTarget()} is used to replace source blob information (e.g.
     * {@code contentType}, {@code contentLanguage}). Target blob information is set exactly to this
     * value, no information is inherited from the source blob. If {@code false}, target blob
     * information is inherited from the source blob.
     */
    public boolean overrideInfo() {
      return overrideInfo;
    }

    /** Returns blob's target options. */
    public List<BlobTargetOption> getTargetOptions() {
      return targetOptions;
    }

    /**
     * Returns the maximum number of megabytes to copy for each RPC call. This parameter is ignored
     * if source and target blob share the same location and storage class as copy is made with one
     * single RPC.
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
      return CopyRequest.newBuilder().setSource(sourceBlobId).setTarget(targetBlobId).build();
    }

    /** Creates a builder for {@code CopyRequest} objects. */
    public static Builder newBuilder() {
      return new Builder();
    }
  }

  /**
   * A class to contain all information needed for a Google Cloud Storage Object Move.
   *
   * @since 2.48.0
   * @see Storage#moveBlob(MoveBlobRequest)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  final class MoveBlobRequest {
    private final BlobId source;
    private final BlobId target;
    private final ImmutableList<BlobSourceOption> sourceOptions;
    private final ImmutableList<BlobTargetOption> targetOptions;

    MoveBlobRequest(
        BlobId source,
        BlobId target,
        ImmutableList<BlobSourceOption> sourceOptions,
        ImmutableList<BlobTargetOption> targetOptions) {
      this.source = source;
      this.target = target;
      this.sourceOptions = sourceOptions;
      this.targetOptions = targetOptions;
    }

    public BlobId getSource() {
      return source;
    }

    public BlobId getTarget() {
      return target;
    }

    public List<BlobSourceOption> getSourceOptions() {
      return sourceOptions;
    }

    public List<BlobTargetOption> getTargetOptions() {
      return targetOptions;
    }

    public Builder toBuilder() {
      return new Builder(source, target, sourceOptions, targetOptions);
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof MoveBlobRequest)) {
        return false;
      }
      MoveBlobRequest that = (MoveBlobRequest) o;
      return Objects.equals(source, that.source)
          && Objects.equals(target, that.target)
          && Objects.equals(sourceOptions, that.sourceOptions)
          && Objects.equals(targetOptions, that.targetOptions);
    }

    @Override
    public int hashCode() {
      return Objects.hash(source, target, sourceOptions, targetOptions);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("source", source)
          .add("target", target)
          .add("sourceOptions", sourceOptions)
          .add("targetOptions", targetOptions)
          .toString();
    }

    public static final class Builder {

      private BlobId source;
      private BlobId target;
      private ImmutableList<BlobSourceOption> sourceOptions;
      private ImmutableList<BlobTargetOption> targetOptions;

      private Builder() {
        this(null, null, ImmutableList.of(), ImmutableList.of());
      }

      private Builder(
          BlobId source,
          BlobId target,
          ImmutableList<BlobSourceOption> sourceOptions,
          ImmutableList<BlobTargetOption> targetOptions) {
        this.source = source;
        this.target = target;
        this.sourceOptions = sourceOptions;
        this.targetOptions = targetOptions;
      }

      public Builder setSource(BlobId source) {
        this.source = requireNonNull(source, "source must be non null");
        return this;
      }

      public Builder setTarget(BlobId target) {
        this.target = requireNonNull(target, "target must be non null");
        return this;
      }

      public Builder setSourceOptions(Iterable<BlobSourceOption> sourceOptions) {
        this.sourceOptions =
            ImmutableList.copyOf(requireNonNull(sourceOptions, "sourceOptions must be non null"));
        return this;
      }

      public Builder setTargetOptions(Iterable<BlobTargetOption> targetOptions) {
        this.targetOptions =
            ImmutableList.copyOf(requireNonNull(targetOptions, "targetOptions must be non null"));
        return this;
      }

      public Builder setSourceOptions(BlobSourceOption... sourceOptions) {
        this.sourceOptions =
            ImmutableList.copyOf(requireNonNull(sourceOptions, "sourceOptions must be non null"));
        return this;
      }

      public Builder setTargetOptions(BlobTargetOption... targetOptions) {
        this.targetOptions =
            ImmutableList.copyOf(requireNonNull(targetOptions, "targetOptions must be non null"));
        return this;
      }

      public MoveBlobRequest build() {
        return new MoveBlobRequest(
            requireNonNull(source, "source must be non null"),
            requireNonNull(target, "target must be non null"),
            sourceOptions,
            targetOptions);
      }
    }
  }

  /**
   * Creates a new bucket.
   *
   * <p>Accepts an optional userProject {@link BucketTargetOption} option which defines the project
   * id to assign operational costs.
   *
   * <p>Example of creating a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Bucket bucket = storage.create(BucketInfo.of(bucketName));
   * }</pre>
   *
   * <p>Example of creating a bucket with storage class and location.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Bucket create(BucketInfo bucketInfo, BucketTargetOption... options);

  /**
   * Creates a new blob with no content. Note that all <a
   * href="https://cloud.google.com/storage/docs/metadata#fixed">non-editable metadata</a>, such as
   * generation or metageneration, will be ignored even if it's present in the provided BlobInfo
   * object.
   *
   * <p>Example of creating a blob with no content.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Blob blob = storage.create(blobInfo);
   * }</pre>
   *
   * @return a {@code Blob} with complete information
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob create(BlobInfo blobInfo, BlobTargetOption... options);

  /**
   * Creates a new blob. Direct upload is used to upload {@code content}. For large content, {@link
   * #writer} is recommended as it uses resumable upload. MD5 and CRC32C hashes of {@code content}
   * are computed and used for validating transferred data. Accepts an optional userProject {@link
   * BlobGetOption} option which defines the project id to assign operational costs. The content
   * type is detected from the blob name if not explicitly set. Note that all <a
   * href="https://cloud.google.com/storage/docs/metadata#fixed">non-editable metadata</a>, such as
   * generation or metageneration, will be ignored even if it's present in the provided BlobInfo
   * object.
   *
   * <p>Example of creating a blob from a byte array:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Blob blob = storage.create(blobInfo, "Hello, World!".getBytes(UTF_8));
   * }</pre>
   *
   * @return a {@code Blob} with complete information
   * @throws StorageException upon failure
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags">Hashes and ETags</a>
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob create(BlobInfo blobInfo, byte[] content, BlobTargetOption... options);

  /**
   * Creates a new blob with the sub array of the given byte array. Direct upload is used to upload
   * {@code content}. For large content, {@link #writer} is recommended as it uses resumable upload.
   * MD5 and CRC32C hashes of {@code content} are computed and used for validating transferred data.
   * Accepts a userProject {@link BlobGetOption} option, which defines the project id to assign
   * operational costs. Note that all <a
   * href="https://cloud.google.com/storage/docs/metadata#fixed">non-editable metadata</a>, such as
   * generation or metageneration, will be ignored even if it's present in the provided BlobInfo
   * object.
   *
   * <p>Example of creating a blob from a byte array:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Blob blob = storage.create(blobInfo, "Hello, World!".getBytes(UTF_8), 7, 5);
   * }</pre>
   *
   * @return a {@code Blob} with complete information
   * @throws StorageException upon failure
   * @see <a href="https://cloud.google.com/storage/docs/hashes-etags">Hashes and ETags</a>
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob create(
      BlobInfo blobInfo, byte[] content, int offset, int length, BlobTargetOption... options);

  /**
   * Creates a new blob. Direct upload is used to upload {@code content}. For large content, {@link
   * #writer} is recommended as it uses resumable upload. By default any MD5 and CRC32C values in
   * the given {@code blobInfo} are ignored unless requested via the {@code
   * BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options. The given input
   * stream is closed upon success. Note that all <a
   * href="https://cloud.google.com/storage/docs/metadata#fixed">non-editable metadata</a>, such as
   * generation or metageneration, will be ignored even if it's present in the provided BlobInfo
   * object.
   *
   * <p>This method is marked as {@link Deprecated} because it cannot safely retry, given that it
   * accepts an {@link InputStream} which can only be consumed once.
   *
   * <p>Example of creating a blob from an input stream.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Blob blob = storage.create(blobInfo, content);
   * }</pre>
   *
   * <p>Example of uploading an encrypted blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
   * @return a {@code Blob} with complete information
   * @throws StorageException upon failure
   */
  @Deprecated
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob create(BlobInfo blobInfo, InputStream content, BlobWriteOption... options);

  /**
   * Uploads {@code path} to the blob using {@link #writer}. By default any MD5 and CRC32C values in
   * the given {@code blobInfo} are ignored unless requested via the {@link
   * BlobWriteOption#md5Match()} and {@link BlobWriteOption#crc32cMatch()} options. Folder upload is
   * not supported. Note that all <a href="https://cloud.google.com/storage/docs/metadata#fixed">
   * non-editable metadata</a>, such as generation or metageneration, will be ignored even if it's
   * present in the provided BlobInfo object.
   *
   * <p>Example of uploading a file:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String fileName = "readme.txt";
   * BlobId blobId = BlobId.of(bucketName, fileName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * storage.createFrom(blobInfo, Paths.get(fileName));
   * }</pre>
   *
   * @param blobInfo blob to create
   * @param path file to upload
   * @param options blob write options
   * @return a {@code Blob} with complete information
   * @throws IOException on I/O error
   * @throws StorageException on server side error
   * @see #createFrom(BlobInfo, Path, int, BlobWriteOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob createFrom(BlobInfo blobInfo, Path path, BlobWriteOption... options) throws IOException;

  /**
   * Uploads {@code path} to the blob using {@code ResumableSession}. By default any MD5 and CRC32C
   * values in the given {@code blobInfo} are ignored unless requested via the {@link
   * BlobWriteOption#md5Match()} and {@link BlobWriteOption#crc32cMatch()} options. Folder upload is
   * not supported. Note that all <a href="https://cloud.google.com/storage/docs/metadata#fixed">
   * non-editable metadata</a>, such as generation or metageneration, will be ignored even if it's
   * present in the provided BlobInfo object.
   *
   * <p>This method used to preallocate a buffer, but since v2.25.0, it uses a ResumableSession and
   * no longer needs it. The bufferSize parameter is still present for binary compatibility, but is
   * now ignored.
   *
   * <p>Example of uploading a humongous file:
   *
   * <pre>{@code
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("video/webm").build();
   *
   * Path file = Paths.get("humongous.file");
   * storage.createFrom(blobInfo, file, 0);
   * }</pre>
   *
   * @param blobInfo blob to create
   * @param path file to upload
   * @param bufferSize ignored field, still present for compatibility purposes
   * @param options blob write options
   * @return a {@code Blob} with complete information
   * @throws IOException on I/O error
   * @throws StorageException on server side error
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob createFrom(BlobInfo blobInfo, Path path, int bufferSize, BlobWriteOption... options)
      throws IOException;

  /**
   * Reads bytes from an input stream and uploads those bytes to the blob using {@link #writer}. By
   * default any MD5 and CRC32C values in the given {@code blobInfo} are ignored unless requested
   * via the {@link BlobWriteOption#md5Match()} and {@link BlobWriteOption#crc32cMatch()} options.
   * Note that all <a href="https://cloud.google.com/storage/docs/metadata#fixed">non-editable
   * metadata</a>, such as generation or metageneration, will be ignored even if it's present in the
   * provided BlobInfo object.
   *
   * <p>Example of uploading data with CRC32C checksum:
   *
   * <pre>{@code
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * byte[] content = "Hello, world".getBytes(StandardCharsets.UTF_8);
   * Hasher hasher = Hashing.crc32c().newHasher().putBytes(content);
   * String crc32c = BaseEncoding.base64().encode(Ints.toByteArray(hasher.hash().asInt()));
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(crc32c).build();
   * storage.createFrom(blobInfo, new ByteArrayInputStream(content), Storage.BlobWriteOption.crc32cMatch());
   * }</pre>
   *
   * @param blobInfo blob to create
   * @param content input stream to read from
   * @param options blob write options
   * @return a {@code Blob} with complete information
   * @throws IOException on I/O error
   * @throws StorageException on server side error
   * @see #createFrom(BlobInfo, InputStream, int, BlobWriteOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob createFrom(BlobInfo blobInfo, InputStream content, BlobWriteOption... options)
      throws IOException;

  /**
   * Reads bytes from an input stream and uploads those bytes to the blob using {@link #writer} and
   * {@code bufferSize}. By default any MD5 and CRC32C values in the given {@code blobInfo} are
   * ignored unless requested via the {@link BlobWriteOption#md5Match()} and {@link
   * BlobWriteOption#crc32cMatch()} options. Note that all <a
   * href="https://cloud.google.com/storage/docs/metadata#fixed">non-editable metadata</a>, such as
   * generation or metageneration, will be ignored even if it's present in the provided BlobInfo
   * object.
   *
   * <p>{@link #createFrom(BlobInfo, InputStream, BlobWriteOption...)} )} invokes this method with a
   * buffer size of 15 MiB. Users can pass alternative values. Larger buffer sizes might improve the
   * upload performance but require more memory. This can cause an OutOfMemoryError or add
   * significant garbage collection overhead. Smaller buffer sizes reduce memory consumption, that
   * is noticeable when uploading many objects in parallel. Buffer sizes less than 256 KiB are
   * treated as 256 KiB.
   *
   * @param blobInfo blob to create
   * @param content input stream to read from
   * @param bufferSize size of the buffer I/O operations
   * @param options blob write options
   * @return a {@code Blob} with complete information
   * @throws IOException on I/O error
   * @throws StorageException on server side error
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob createFrom(
      BlobInfo blobInfo, InputStream content, int bufferSize, BlobWriteOption... options)
      throws IOException;

  /**
   * Returns the requested bucket or {@code null} if not found.
   *
   * <p>Accepts an optional userProject {@link BucketGetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of getting information on a bucket, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * long bucketMetageneration = 42;
   * Bucket bucket = storage.get(bucketName,
   *     BucketGetOption.metagenerationMatch(bucketMetageneration));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Bucket get(String bucket, BucketGetOption... options);

  /**
   * Locks bucket retention policy. Requires a local metageneration value in the request. Review
   * example below.
   *
   * <p>Accepts an optional userProject {@link BucketTargetOption} option which defines the project
   * id to assign operational costs.
   *
   * <p>Warning: Once a retention policy is locked, it can't be unlocked, removed, or shortened.
   *
   * <p>Example of locking a retention policy on a bucket, only if its local metageneration value
   * matches the bucket's service metageneration otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Bucket bucket = storage.get(bucketName, BucketGetOption.fields(BucketField.METAGENERATION));
   * storage.lockRetentionPolicy(bucket, BucketTargetOption.metagenerationMatch());
   * }</pre>
   *
   * @return a {@code Bucket} object of the locked bucket
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Bucket lockRetentionPolicy(BucketInfo bucket, BucketTargetOption... options);

  /**
   * Returns the requested blob or {@code null} if not found.
   *
   * <p>Accepts an optional userProject {@link BlobGetOption} option which defines the project id to
   * assign operational costs.
   *
   * <p>Example of getting information on a blob, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long blobMetageneration = 42;
   * Blob blob = storage.get(bucketName, blobName,
   *     BlobGetOption.metagenerationMatch(blobMetageneration));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob get(String bucket, String blob, BlobGetOption... options);

  /**
   * Returns the requested blob or {@code null} if not found.
   *
   * <p>Accepts an optional userProject {@link BlobGetOption} option which defines the project id to
   * assign operational costs.
   *
   * <p>Example of getting information on a blob, only if its metageneration matches a value,
   * otherwise a {@link StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long blobMetageneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Blob blob = storage.get(blobId, BlobGetOption.metagenerationMatch(blobMetageneration));
   * }</pre>
   *
   * <p>Example of getting information on a blob encrypted using Customer Supplied Encryption Keys,
   * only if supplied Decrpytion Key decrypts the blob successfully, otherwise a {@link
   * StorageException} is thrown. For more information review
   *
   * @see <a
   *     href="https://cloud.google.com/storage/docs/encryption/customer-supplied-keys#encrypted-elements">Encrypted
   *     Elements</a>
   *     <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * String blobEncryptionKey = "";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Blob blob = storage.get(blobId, BlobGetOption.decryptionKey(blobEncryptionKey));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob get(BlobId blob, BlobGetOption... options);

  /**
   * Returns the requested blob or {@code null} if not found.
   *
   * <p>Example of getting information on a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Blob blob = storage.get(blobId);
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob get(BlobId blob);

  /**
   * Restores a soft-deleted object to full object status and returns the object. Note that you must
   * specify a generation to use this method.
   *
   * <p>Example of restoring an object.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long generation = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, gen);
   * Blob blob = storage.restore(blobId);
   * }</pre>
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob restore(BlobId blob, BlobRestoreOption... options);

  /**
   * Lists the project's buckets.
   *
   * <p>Example of listing buckets, specifying the page size and a name prefix.
   *
   * <pre>{@code
   * String prefix = "bucket_";
   * Page<Bucket> buckets = storage.list(BucketListOption.pageSize(100),
   *     BucketListOption.prefix(prefix));
   * Iterator<Bucket> bucketIterator = buckets.iterateAll().iterator();
   * while (bucketIterator.hasNext()) {
   *   Bucket bucket = bucketIterator.next();
   *   // do something with the bucket
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Page<Bucket> list(BucketListOption... options);

  /**
   * Lists the bucket's blobs. If the {@link BlobListOption#currentDirectory()} option is provided,
   * results are returned in a directory-like mode.
   *
   * <p>Example of listing blobs in a provided directory.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String directory = "my_directory/";
   * Page<Blob> blobs = storage.list(bucketName, BlobListOption.currentDirectory(),
   *     BlobListOption.prefix(directory));
   * Iterator<Blob> blobIterator = blobs.iterateAll().iterator();
   * while (blobIterator.hasNext()) {
   *   Blob blob = blobIterator.next();
   *   // do something with the blob
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Page<Blob> list(String bucket, BlobListOption... options);

  /**
   * Updates bucket information.
   *
   * <p>Accepts an optional userProject {@link BucketTargetOption} option which defines the project
   * id to assign operational costs.
   *
   * <p>Example of updating bucket information.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).setVersioningEnabled(true).build();
   * Bucket bucket = storage.update(bucketInfo);
   * }</pre>
   *
   * @return the updated bucket
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Bucket update(BucketInfo bucketInfo, BucketTargetOption... options);

  /**
   * Updates the blob properties if the preconditions specified by {@code options} are met. The
   * property update works as described in {@link #update(BlobInfo)}.
   *
   * <p>{@code options} parameter can contain the preconditions for applying the update. E.g. update
   * of the blob properties might be required only if the properties have not been updated
   * externally. {@code StorageException} with the code {@code 412} is thrown if preconditions fail.
   *
   * <p>Example of updating the content type only if the properties are not updated externally:
   *
   * <pre>{@code
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Blob blob = storage.create(blobInfo);
   *
   * doSomething();
   *
   * BlobInfo update = blob.toBuilder().setContentType("multipart/form-data").build();
   * Storage.BlobTargetOption option = Storage.BlobTargetOption.metagenerationMatch();
   * try {
   *   storage.update(update, option);
   * } catch (StorageException e) {
   *   if (e.getCode() == 412) {
   *     // the properties were updated externally
   *   } else {
   *     throw e;
   *   }
   * }
   * }</pre>
   *
   * @param blobInfo information to update
   * @param options preconditions to apply the update
   * @return the updated blob
   * @throws StorageException upon failure
   * @see <a
   *     href="https://cloud.google.com/storage/docs/json_api/v1/objects/update">https://cloud.google.com/storage/docs/json_api/v1/objects/update</a>
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob update(BlobInfo blobInfo, BlobTargetOption... options);

  /**
   * Updates the properties of the blob. This method issues an RPC request to merge the current blob
   * properties with the properties in the provided {@code blobInfo}. Properties not defined in
   * {@code blobInfo} will not be updated. To unset a blob property this property in {@code
   * blobInfo} should be explicitly set to {@code null}.
   *
   * <p>Bucket or blob's name cannot be changed by this method. If you want to rename the blob or
   * move it to a different bucket use the {@link Blob#copyTo} and {@link #delete} operations.
   *
   * <p>Property update alters the blob metadata generation and doesn't alter the blob generation.
   *
   * <p>Example of how to update blob's user provided metadata and unset the content type:
   *
   * <pre>{@code
   * Map<String, String> metadataUpdate = new HashMap<>();
   * metadataUpdate.put("keyToAdd", "new value");
   * metadataUpdate.put("keyToRemove", null);
   * BlobInfo blobUpdate = BlobInfo.newBuilder(bucketName, blobName)
   *     .setMetadata(metadataUpdate)
   *     .setContentType(null)
   *     .build();
   * Blob blob = storage.update(blobUpdate);
   * }</pre>
   *
   * @param blobInfo information to update
   * @return the updated blob
   * @throws StorageException upon failure
   * @see <a
   *     href="https://cloud.google.com/storage/docs/json_api/v1/objects/update">https://cloud.google.com/storage/docs/json_api/v1/objects/update</a>
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob update(BlobInfo blobInfo);

  /**
   * Deletes the requested bucket.
   *
   * <p>Accepts an optional userProject {@link BucketSourceOption} option which defines the project
   * id to assign operational costs.
   *
   * <p>Example of deleting a bucket, only if its metageneration matches a value, otherwise a {@link
   * StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  boolean delete(String bucket, BucketSourceOption... options);

  /**
   * Deletes the requested blob.
   *
   * <p>Example of deleting a blob, only if its generation matches a value, otherwise a {@link
   * StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  boolean delete(String bucket, String blob, BlobSourceOption... options);

  /**
   * Deletes the requested blob.
   *
   * <p>Accepts an optional userProject {@link BlobSourceOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of deleting a blob, only if its generation matches a value, otherwise a {@link
   * StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  boolean delete(BlobId blob, BlobSourceOption... options);

  /**
   * Deletes the requested blob.
   *
   * <p>Example of deleting a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  boolean delete(BlobId blob);

  /**
   * Sends a compose request.
   *
   * <p>Accepts an optional userProject {@link BlobTargetOption} option which defines the project id
   * to assign operational costs.
   *
   * <p>Example of composing two blobs.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob compose(ComposeRequest composeRequest);

  /**
   * Sends a copy request. This method copies both blob's data and information. To override source
   * blob's information supply a {@code BlobInfo} to the {@code CopyRequest} using either {@link
   * Storage.CopyRequest.Builder#setTarget(BlobInfo, Storage.BlobTargetOption...)} or {@link
   * Storage.CopyRequest.Builder#setTarget(BlobInfo, Iterable)}.
   *
   * <p>This method returns a {@link CopyWriter} object for the provided {@code CopyRequest}. If
   * source and destination objects share the same location and storage class the source blob is
   * copied with one request and {@link CopyWriter#getResult()} immediately returns, regardless of
   * the {@link CopyRequest#megabytesCopiedPerChunk} parameter. If source and destination have
   * different location or storage class {@link CopyWriter#getResult()} might issue multiple RPC
   * calls depending on blob's size.
   *
   * <p>Example of copying a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * String copyBlobName = "copy_blob_name";
   * CopyRequest request = CopyRequest.newBuilder()
   *     .setSource(BlobId.of(bucketName, blobName))
   *     .setTarget(BlobId.of(bucketName, copyBlobName))
   *     .build();
   * Blob blob = storage.copy(request).getResult();
   * }</pre>
   *
   * <p>Example of copying a blob in chunks.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  CopyWriter copy(CopyRequest copyRequest);

  /**
   * Reads all the bytes from a blob.
   *
   * <p>Example of reading all bytes of a blob, if generation matches a value, otherwise a {@link
   * StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long blobGeneration = 42";
   * byte[] content = storage.readAllBytes(bucketName, blobName,
   *     BlobSourceOption.generationMatch(blobGeneration));
   * }</pre>
   *
   * @return the blob's content
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  byte[] readAllBytes(String bucket, String blob, BlobSourceOption... options);

  /**
   * Reads all the bytes from a blob.
   *
   * <p>Example of reading all bytes of a blob's specific generation, otherwise a {@link
   * StorageException} is thrown.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * byte[] content = storage.readAllBytes(blobId);
   * }</pre>
   *
   * <p>Example of reading all bytes of an encrypted blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * String decryptionKey = "my_encryption_key";
   * byte[] content = storage.readAllBytes(
   *     bucketName, blobName, BlobSourceOption.decryptionKey(decryptionKey));
   * }</pre>
   *
   * @return the blob's content
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  byte[] readAllBytes(BlobId blob, BlobSourceOption... options);

  /**
   * Creates a new empty batch for grouping multiple service calls in one underlying RPC call.
   *
   * <p>Example of using a batch request to delete, update and get a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName1 = "my-blob-name1";
   * String blobName2 = "my-blob-name2";
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
   */
  @TransportCompatibility(Transport.HTTP)
  StorageBatch batch();

  /**
   * Returns a channel for reading the blob's content. The blob's latest generation is read. If the
   * blob changes while reading (i.e. {@link BlobInfo#getEtag()} changes), subsequent calls to
   * {@code blobReadChannel.read(ByteBuffer)} may throw {@link StorageException}.
   *
   * <p>Example of reading a blob's content through a reader.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  ReadChannel reader(String bucket, String blob, BlobSourceOption... options);

  /**
   * Returns a channel for reading the blob's content. If {@code blob.generation()} is set data
   * corresponding to that generation is read. If {@code blob.generation()} is {@code null} the
   * blob's latest generation is read. If the blob changes while reading (i.e. {@link
   * BlobInfo#getEtag()} changes), subsequent calls to {@code blobReadChannel.read(ByteBuffer)} may
   * throw {@link StorageException}.
   *
   * <p>The {@link BlobSourceOption#generationMatch()} and {@link
   * BlobSourceOption#generationMatch(long)} options can be used to ensure that {@code
   * blobReadChannel.read(ByteBuffer)} calls will throw {@link StorageException} if the blob`s
   * generation differs from the expected one.
   *
   * <p>Example of reading a blob's content through a reader.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  ReadChannel reader(BlobId blob, BlobSourceOption... options);

  /**
   * Downloads the given blob to the given path using specified blob read options.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Path destination = Paths.get("my-blob-destination.txt");
   * downloadTo(blobId, destination);
   * // do stuff with destination
   * }</pre>
   *
   * @param blob
   * @param path
   * @param options
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  void downloadTo(BlobId blob, Path path, BlobSourceOption... options);

  /**
   * Downloads the given blob to the given output stream using specified blob read options.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Path destination = Paths.get("my-blob-destination.txt");
   * try (OutputStream outputStream = Files.newOutputStream(path)) {
   *  downloadTo(blob, outputStream);
   *  // do stuff with destination
   * }
   * }</pre>
   *
   * @param blob
   * @param outputStream
   * @param options
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  void downloadTo(BlobId blob, OutputStream outputStream, BlobSourceOption... options);

  /**
   * Creates a blob and returns a channel for writing its content. By default any MD5 and CRC32C
   * values in the given {@code blobInfo} are ignored unless requested via the {@code
   * BlobWriteOption.md5Match} and {@code BlobWriteOption.crc32cMatch} options.
   *
   * <p>Example of writing a blob's content through a writer:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * byte[] content = "Hello, World!".getBytes(UTF_8);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * try (WriteChannel writer = storage.writer(blobInfo)) {
   *     writer.write(ByteBuffer.wrap(content, 0, content.length));
   * } catch (IOException ex) {
   *   // handle exception
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  WriteChannel writer(BlobInfo blobInfo, BlobWriteOption... options);

  /**
   * Accepts signed URL and return a channel for writing content.
   *
   * <p>Example of writing content through a writer using signed URL.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * byte[] content = "Hello, World!".getBytes(UTF_8);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * URL signedURL = storage.signUrl(
   *     blobInfo,
   *     1, TimeUnit.HOURS,
   *     Storage.SignUrlOption.httpMethod(HttpMethod.POST));
   * try (WriteChannel writer = storage.writer(signedURL)) {
   *    writer.write(ByteBuffer.wrap(content, 0, content.length));
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility(Transport.HTTP)
  WriteChannel writer(URL signedURL);

  /**
   * Generates a signed URL for a blob. If you have a blob that you want to allow access to for a
   * fixed amount of time, you can use this method to generate a URL that is only valid within a
   * certain time period. This is particularly useful if you don't want publicly accessible blobs,
   * but also don't want to require users to explicitly log in. Signing a URL requires a service
   * account signer. If an instance of {@link com.google.auth.ServiceAccountSigner} was passed to
   * {@link StorageOptions}' builder via {@code setCredentials(Credentials)} or the default
   * credentials are being used and the environment variable {@code GOOGLE_APPLICATION_CREDENTIALS}
   * is set or your application is running in App Engine, then {@code signUrl} will use that
   * credentials to sign the URL. If the credentials passed to {@link StorageOptions} do not
   * implement {@link ServiceAccountSigner} (this is the case, for instance, for Google Cloud SDK
   * credentials) then {@code signUrl} will throw an {@link IllegalStateException} unless an
   * implementation of {@link ServiceAccountSigner} is passed using the {@link
   * SignUrlOption#signWith(ServiceAccountSigner)} option.
   *
   * <p>A service account signer is looked for in the following order:
   *
   * <ol>
   *   <li>The signer passed with the option {@link SignUrlOption#signWith(ServiceAccountSigner)}
   *   <li>The credentials passed to {@link StorageOptions}
   *   <li>The default credentials, if no credentials were passed to {@link StorageOptions}
   * </ol>
   *
   * <p>Example of creating a signed URL that is valid for 1 week, using the default credentials for
   * signing the URL, the default signing method (V2), and the default URL style (path-style):
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * URL signedUrl = storage.signUrl(
   *     BlobInfo.newBuilder(bucketName, blobName).build(),
   *     7, TimeUnit.DAYS);
   * }</pre>
   *
   * <p>Example of creating a signed URL passing the {@link SignUrlOption#withV4Signature()} option,
   * which enables V4 signing:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * URL signedUrl = storage.signUrl(
   *     BlobInfo.newBuilder(bucketName, blobName).build(),
   *     7, TimeUnit.DAYS,
   *     Storage.SignUrlOption.withV4Signature());
   * }</pre>
   *
   * <p>Example of creating a signed URL passing the {@link SignUrlOption#withVirtualHostedStyle()}
   * option, which specifies the bucket name in the hostname of the URI, rather than in the path:
   *
   * <pre>{@code
   * URL signedUrl = storage.signUrl(
   *     BlobInfo.newBuilder(bucketName, blobName).build(),
   *     1, TimeUnit.DAYS,
   *     Storage.SignUrlOption.withVirtualHostedStyle());
   * }</pre>
   *
   * <p>Example of creating a signed URL passing the {@link SignUrlOption#withPathStyle()} option,
   * which specifies the bucket name in path portion of the URI, rather than in the hostname:
   *
   * <pre>{@code
   * URL signedUrl = storage.signUrl(
   *     BlobInfo.newBuilder(bucketName, blobName).build(),
   *     1, TimeUnit.DAYS,
   *     Storage.SignUrlOption.withPathStyle());
   * }</pre>
   *
   * <p>Example of creating a signed URL passing the {@link
   * SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used for signing the URL:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * String kfPath = "/path/to/keyfile.json";
   * URL signedUrl = storage.signUrl(
   *     BlobInfo.newBuilder(bucketName, blobName).build(),
   *     7, TimeUnit.DAYS,
   *     SignUrlOption.signWith(ServiceAccountCredentials.fromStream(new FileInputStream(kfPath))));
   * }</pre>
   *
   * <p>Note that the {@link ServiceAccountSigner} may require additional configuration to enable
   * URL signing. See the documentation for the implementation for more details.
   *
   * <p>Example of creating a signed URL for a blob with generation:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long generation = 1576656755290328L;
   *
   * URL signedUrl = storage.signUrl(
   *     BlobInfo.newBuilder(bucketName, blobName, generation).build(),
   *     7, TimeUnit.DAYS,
   *     SignUrlOption.withQueryParams(ImmutableMap.of("generation", String.valueOf(generation))));
   * }</pre>
   *
   * @param blobInfo the blob associated with the signed URL
   * @param duration time until the signed URL expires, expressed in {@code unit}. The finest
   *     granularity supported is 1 second, finer granularities will be truncated
   * @param unit time unit of the {@code duration} parameter
   * @param options optional URL signing options
   * @throws IllegalStateException if {@link SignUrlOption#signWith(ServiceAccountSigner)} was not
   *     used and no implementation of {@link ServiceAccountSigner} was provided to {@link
   *     StorageOptions}
   * @throws IllegalArgumentException if {@code SignUrlOption.withMd5()} option is used and {@code
   *     blobInfo.md5()} is {@code null}
   * @throws IllegalArgumentException if {@code SignUrlOption.withContentType()} option is used and
   *     {@code blobInfo.contentType()} is {@code null}
   * @throws SigningException if the attempt to sign the URL failed
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed-URLs</a>
   */
  @TransportCompatibility(Transport.HTTP)
  URL signUrl(BlobInfo blobInfo, long duration, TimeUnit unit, SignUrlOption... options);

  /**
   * Generates a URL and a map of fields that can be specified in an HTML form to submit a POST
   * request. The returned map includes a signature which must be provided with the request.
   * Generating a presigned POST policy requires a service account signer. If an instance of {@link
   * com.google.auth.ServiceAccountSigner} was passed to {@link StorageOptions}' builder via {@code
   * setCredentials(Credentials)} or the default credentials are being used and the environment
   * variable {@code GOOGLE_APPLICATION_CREDENTIALS} is set, generatPresignedPostPolicyV4 will use
   * that credentials to sign the URL. If the credentials passed to {@link StorageOptions} do not
   * implement {@link ServiceAccountSigner} (this is the case, for instance, for Google Cloud SDK
   * credentials) then {@code signUrl} will throw an {@link IllegalStateException} unless an
   * implementation of {@link ServiceAccountSigner} is passed using the {@link
   * PostPolicyV4Option#signWith(ServiceAccountSigner)} option.
   *
   * <p>Example of generating a presigned post policy which has the condition that only jpeg images
   * can be uploaded, and applies the public read acl to each image uploaded, and making the POST
   * request:
   *
   * <pre>{@code
   * PostFieldsV4 fields = PostFieldsV4.newBuilder().setAcl("public-read").build();
   * PostConditionsV4 conditions = PostConditionsV4.newBuilder().addContentTypeCondition(ConditionV4Type.MATCHES, "image/jpeg").build();
   *
   * PostPolicyV4 policy = storage.generateSignedPostPolicyV4(
   *     BlobInfo.newBuilder("my-bucket", "my-object").build(),
   *     7, TimeUnit.DAYS, fields, conditions);
   *
   * HttpClient client = HttpClientBuilder.create().build();
   * HttpPost request = new HttpPost(policy.getUrl());
   * MultipartEntityBuilder builder = MultipartEntityBuilder.create();
   *
   * for (Map.Entry<String, String> entry : policy.getFields().entrySet()) {
   *     builder.addTextBody(entry.getKey(), entry.getValue());
   * }
   * File file = new File("path/to/your/file/to/upload");
   * builder.addBinaryBody("file", new FileInputStream(file), ContentType.APPLICATION_OCTET_STREAM, file.getName());
   * request.setEntity(builder.build());
   * client.execute(request);
   * }</pre>
   *
   * @param blobInfo the blob uploaded in the form
   * @param duration time before expiration
   * @param unit duration time unit
   * @param fields the fields specified in the form
   * @param conditions which conditions every upload must satisfy
   * @param duration how long until the form expires, in milliseconds
   * @param options optional post policy options
   * @see <a
   *     href="https://cloud.google.com/storage/docs/xml-api/post-object#usage_and_examples">POST
   *     Object</a>
   */
  @TransportCompatibility(Transport.HTTP)
  PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostFieldsV4 fields,
      PostConditionsV4 conditions,
      PostPolicyV4Option... options);

  /**
   * Generates a presigned post policy without any conditions. Automatically creates required
   * conditions. See full documentation for {@link #generateSignedPostPolicyV4(BlobInfo, long,
   * TimeUnit, PostPolicyV4.PostFieldsV4, PostPolicyV4.PostConditionsV4, PostPolicyV4Option...)}.
   */
  @TransportCompatibility(Transport.HTTP)
  PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostFieldsV4 fields,
      PostPolicyV4Option... options);

  /**
   * Generates a presigned post policy without any fields. Automatically creates required fields.
   * See full documentation for {@link #generateSignedPostPolicyV4(BlobInfo, long, TimeUnit,
   * PostPolicyV4.PostFieldsV4, PostPolicyV4.PostConditionsV4, PostPolicyV4Option...)}.
   */
  @TransportCompatibility(Transport.HTTP)
  PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostConditionsV4 conditions,
      PostPolicyV4Option... options);

  /**
   * Generates a presigned post policy without any fields or conditions. Automatically creates
   * required fields and conditions. See full documentation for {@link
   * #generateSignedPostPolicyV4(BlobInfo, long, TimeUnit, PostPolicyV4.PostFieldsV4,
   * PostPolicyV4.PostConditionsV4, PostPolicyV4Option...)}.
   */
  @TransportCompatibility(Transport.HTTP)
  PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo, long duration, TimeUnit unit, PostPolicyV4Option... options);

  /**
   * Gets the requested blobs. A batch request is used to perform this call.
   *
   * <p>Example of getting information on several blobs using a single batch request.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName1 = "my-blob-name1";
   * String blobName2 = "my-blob-name2";
   * BlobId firstBlob = BlobId.of(bucketName, blobName1);
   * BlobId secondBlob = BlobId.of(bucketName, blobName2);
   * List<Blob> blobs = storage.get(firstBlob, secondBlob);
   * }</pre>
   *
   * @param blobIds blobs to get
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   *     been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  List<Blob> get(BlobId... blobIds);

  /**
   * Gets the requested blobs. A batch request is used to perform this call.
   *
   * <p>Example of getting information on several blobs using a single batch request.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName1 = "my-blob-name1";
   * String blobName2 = "my-blob-name2";
   * List<BlobId> blobIds = new LinkedList<>();
   * blobIds.add(BlobId.of(bucketName, blobName1));
   * blobIds.add(BlobId.of(bucketName, blobName2));
   * List<Blob> blobs = storage.get(blobIds);
   * }</pre>
   *
   * @param blobIds blobs to get
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   *     been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  List<Blob> get(Iterable<BlobId> blobIds);

  /**
   * Updates the requested blobs. A batch request is used to perform this call. The original
   * properties are merged with the properties in the provided {@code BlobInfo} objects. Unsetting a
   * property can be done by setting the property of the provided {@code BlobInfo} objects to {@code
   * null}. See {@link #update(BlobInfo)} for a code example.
   *
   * <p>Example of updating information on several blobs using a single batch request.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName1 = "my-blob-name1";
   * String blobName2 = "my-blob-name2";
   * Blob firstBlob = storage.get(bucketName, blobName1);
   * Blob secondBlob = storage.get(bucketName, blobName2);
   * List<Blob> updatedBlobs = storage.update(
   *     firstBlob.toBuilder().setContentType("text/plain").build(),
   *     secondBlob.toBuilder().setContentType("text/plain").build());
   * }</pre>
   *
   * @param blobInfos blobs to update
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   *     been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  List<Blob> update(BlobInfo... blobInfos);

  /**
   * Updates the requested blobs. A batch request is used to perform this call. The original
   * properties are merged with the properties in the provided {@code BlobInfo} objects. Unsetting a
   * property can be done by setting the property of the provided {@code BlobInfo} objects to {@code
   * null}. See {@link #update(BlobInfo)} for a code example.
   *
   * <p>Example of updating information on several blobs using a single batch request.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName1 = "my-blob-name1";
   * String blobName2 = "my-blob-name2";
   * Blob firstBlob = storage.get(bucketName, blobName1);
   * Blob secondBlob = storage.get(bucketName, blobName2);
   * List<BlobInfo> blobs = new LinkedList<>();
   * blobs.add(firstBlob.toBuilder().setContentType("text/plain").build());
   * blobs.add(secondBlob.toBuilder().setContentType("text/plain").build());
   * List<Blob> updatedBlobs = storage.update(blobs);
   * }</pre>
   *
   * @param blobInfos blobs to update
   * @return an immutable list of {@code Blob} objects. If a blob does not exist or access to it has
   *     been denied the corresponding item in the list is {@code null}.
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  List<Blob> update(Iterable<BlobInfo> blobInfos);

  /**
   * Deletes the requested blobs. A batch request is used to perform this call.
   *
   * <p>Example of deleting several blobs using a single batch request.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName1 = "my-blob-name1";
   * String blobName2 = "my-blob-name2";
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
  @TransportCompatibility({Transport.HTTP})
  List<Boolean> delete(BlobId... blobIds);

  /**
   * Deletes the requested blobs. A batch request is used to perform this call.
   *
   * <p>Example of deleting several blobs using a single batch request.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName1 = "my-blob-name1";
   * String blobName2 = "my-blob-name2";
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
  @TransportCompatibility({Transport.HTTP})
  List<Boolean> delete(Iterable<BlobId> blobIds);

  /**
   * Returns the ACL entry for the specified entity on the specified bucket or {@code null} if not
   * found.
   *
   * <p>Example of getting the ACL entry for an entity on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Acl acl = storage.getAcl(bucketName, User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * <p>Example of getting the ACL entry for a specific user on a requester_pays bucket with a
   * user_project option.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String userEmail = "google-cloud-java-tests@java-docs-samples-tests.iam.gserviceaccount.com";
   * BucketSourceOption userProjectOption = BucketSourceOption.userProject("myProject");
   * Acl acl = storage.getAcl(bucketName, new User(userEmail), userProjectOption);
   * }</pre>
   *
   * <h4>Behavioral Differences between HTTP and gRPC</h4>
   *
   * <ol>
   *   <li>Calling this method for a Bucket which has <a target="_blank"
   *       href="https://cloud.google.com/storage/docs/uniform-bucket-level-access">Uniform
   *       bucket-level access</a> enabled exhibits different behavior Depending on which {@link
   *       Transport} is used. For JSON, an HTTP 400 Bad Request error will be thrown. Whereas for
   *       gRPC, an empty list will be returned.
   * </ol>
   *
   * @param bucket name of the bucket where the getAcl operation takes place
   * @param entity ACL entity to fetch
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl getAcl(String bucket, Entity entity, BucketSourceOption... options);

  /**
   * @see #getAcl(String, Entity, BucketSourceOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl getAcl(String bucket, Entity entity);

  /**
   * Deletes the ACL entry for the specified entity on the specified bucket.
   *
   * <p>Example of deleting the ACL entry for an entity on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
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
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  boolean deleteAcl(String bucket, Entity entity, BucketSourceOption... options);

  /**
   * @see #deleteAcl(String, Entity, BucketSourceOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  boolean deleteAcl(String bucket, Entity entity);

  /**
   * Creates a new ACL entry on the specified bucket.
   *
   * <p>Example of creating a new ACL entry on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Acl acl = storage.createAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
   * }</pre>
   *
   * <p>Example of creating a new ACL entry on a requester_pays bucket with a user_project option.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Acl acl = storage.createAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER),
   *     BucketSourceOption.userProject("myProject"));
   * }</pre>
   *
   * @param bucket name of the bucket for which an ACL should be created
   * @param acl ACL to create
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl createAcl(String bucket, Acl acl, BucketSourceOption... options);

  /**
   * @see #createAcl(String, Acl, BucketSourceOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl createAcl(String bucket, Acl acl);

  /**
   * Updates an ACL entry on the specified bucket.
   *
   * <p>Example of updating a new ACL entry on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Acl acl = storage.updateAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
   * }</pre>
   *
   * <p>Example of updating a new ACL entry on a requester_pays bucket with a user_project option.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Acl acl = storage.updateAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER),
   *     BucketSourceOption.userProject("myProject"));
   * }</pre>
   *
   * @param bucket name of the bucket where the updateAcl operation takes place
   * @param acl ACL to update
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl updateAcl(String bucket, Acl acl, BucketSourceOption... options);

  /**
   * @see #updateAcl(String, Acl, BucketSourceOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl updateAcl(String bucket, Acl acl);

  /**
   * Lists the ACL entries for the provided bucket.
   *
   * <p>Example of listing the ACL entries for a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * List<Acl> acls = storage.listAcls(bucketName);
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * <p>Example of listing the ACL entries for a blob in a requester_pays bucket with a user_project
   * option.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * List<Acl> acls = storage.listAcls(bucketName, BucketSourceOption.userProject("myProject"));
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * <h4>Behavioral Differences between HTTP and gRPC</h4>
   *
   * <ol>
   *   <li>Calling this method for a Bucket which has <a target="_blank"
   *       href="https://cloud.google.com/storage/docs/uniform-bucket-level-access">Uniform
   *       bucket-level access</a> enabled exhibits different behavior Depending on which {@link
   *       Transport} is used. For JSON, an HTTP 400 Bad Request error will be thrown. Whereas for
   *       gRPC, an empty list will be returned.
   * </ol>
   *
   * @param bucket the name of the bucket to list ACLs for
   * @param options any number of BucketSourceOptions to apply to this operation
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  List<Acl> listAcls(String bucket, BucketSourceOption... options);

  /**
   * @see #listAcls(String, BucketSourceOption...)
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  List<Acl> listAcls(String bucket);

  /**
   * Returns the default object ACL entry for the specified entity on the specified bucket or {@code
   * null} if not found.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of getting the default ACL entry for an entity on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Acl acl = storage.getDefaultAcl(bucketName, User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * <h4>Behavioral Differences between HTTP and gRPC</h4>
   *
   * <ol>
   *   <li>Calling this method for a Bucket which has <a target="_blank"
   *       href="https://cloud.google.com/storage/docs/uniform-bucket-level-access">Uniform
   *       bucket-level access</a> enabled exhibits different behavior Depending on which {@link
   *       Transport} is used. For JSON, an HTTP 400 Bad Request error will be thrown. Whereas for
   *       gRPC, an empty list will be returned.
   * </ol>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl getDefaultAcl(String bucket, Entity entity);

  /**
   * Deletes the default object ACL entry for the specified entity on the specified bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of deleting the default ACL entry for an entity on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  boolean deleteDefaultAcl(String bucket, Entity entity);

  /**
   * Creates a new default blob ACL entry on the specified bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of creating a new default ACL entry on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Acl acl =
   *     storage.createDefaultAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl createDefaultAcl(String bucket, Acl acl);

  /**
   * Updates a default blob ACL entry on the specified bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of updating a new default ACL entry on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Acl acl =
   *     storage.updateDefaultAcl(bucketName, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl updateDefaultAcl(String bucket, Acl acl);

  /**
   * Lists the default blob ACL entries for the provided bucket.
   *
   * <p>Default ACLs are applied to a new blob within the bucket when no ACL was provided for that
   * blob.
   *
   * <p>Example of listing the default ACL entries for a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * List<Acl> acls = storage.listDefaultAcls(bucketName);
   * for (Acl acl : acls) {
   *   // do something with ACL entry
   * }
   * }</pre>
   *
   * <h4>Behavioral Differences between HTTP and gRPC</h4>
   *
   * <ol>
   *   <li>Calling this method for a Bucket which has <a target="_blank"
   *       href="https://cloud.google.com/storage/docs/uniform-bucket-level-access">Uniform
   *       bucket-level access</a> enabled exhibits different behavior Depending on which {@link
   *       Transport} is used. For JSON, an HTTP 400 Bad Request error will be thrown. Whereas for
   *       gRPC, an empty list will be returned.
   * </ol>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  List<Acl> listDefaultAcls(String bucket);

  /**
   * Returns the ACL entry for the specified entity on the specified blob or {@code null} if not
   * found.
   *
   * <p>Example of getting the ACL entry for an entity on a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * Acl acl = storage.getAcl(blobId, User.ofAllAuthenticatedUsers());
   * }</pre>
   *
   * <p>Example of getting the ACL entry for a specific user on a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * String userEmail = "google-cloud-java-tests@java-docs-samples-tests.iam.gserviceaccount.com";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * Acl acl = storage.getAcl(blobId, new User(userEmail));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl getAcl(BlobId blob, Entity entity);

  /**
   * Deletes the ACL entry for the specified entity on the specified blob.
   *
   * <p>Example of deleting the ACL entry for an entity on a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  boolean deleteAcl(BlobId blob, Entity entity);

  /**
   * Creates a new ACL entry on the specified blob.
   *
   * <p>Example of creating a new ACL entry on a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * Acl acl = storage.createAcl(blobId, Acl.of(User.ofAllAuthenticatedUsers(), Role.READER));
   * }</pre>
   *
   * <p>Example of updating a blob to be public-read.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * Acl acl = storage.createAcl(blobId, Acl.of(User.ofAllUsers(), Role.READER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl createAcl(BlobId blob, Acl acl);

  /**
   * Updates an ACL entry on the specified blob.
   *
   * <p>Example of updating a new ACL entry on a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * long blobGeneration = 42;
   * BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
   * Acl acl = storage.updateAcl(blobId, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Acl updateAcl(BlobId blob, Acl acl);

  /**
   * Lists the ACL entries for the provided blob.
   *
   * <p>Example of listing the ACL entries for a blob.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  List<Acl> listAcls(BlobId blob);

  /**
   * Creates a new HMAC Key for the provided service account, including the secret key. Note that
   * the secret key is only returned upon creation via this method.
   *
   * <p>Example of creating a new HMAC Key.
   *
   * <pre>{@code
   * ServiceAccount serviceAccount = ServiceAccount.of("my-service-account@google.com");
   *
   * HmacKey hmacKey = storage.createHmacKey(serviceAccount);
   *
   * String secretKey = hmacKey.getSecretKey();
   * HmacKey.HmacKeyMetadata metadata = hmacKey.getMetadata();
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  HmacKey createHmacKey(ServiceAccount serviceAccount, CreateHmacKeyOption... options);

  /**
   * Lists HMAC keys for a given service account. Note this returns {@code HmacKeyMetadata} objects,
   * which do not contain secret keys.
   *
   * <p>Example of listing HMAC keys, specifying project id.
   *
   * <pre>{@code
   * Page<HmacKey.HmacKeyMetadata> metadataPage = storage.listHmacKeys(
   *     Storage.ListHmacKeysOption.projectId("my-project-id"));
   * for (HmacKey.HmacKeyMetadata hmacKeyMetadata : metadataPage.getValues()) {
   *     //do something with the metadata
   * }
   * }</pre>
   *
   * <p>Example of listing HMAC keys, specifying max results and showDeletedKeys. Since projectId is
   * not specified, the same project ID as the storage client instance will be used
   *
   * <pre>{@code
   * ServiceAccount serviceAccount = ServiceAccount.of("my-service-account@google.com");
   *
   * Page<HmacKey.HmacKeyMetadata> metadataPage = storage.listHmacKeys(
   *     Storage.ListHmacKeysOption.serviceAccount(serviceAccount),
   *     Storage.ListHmacKeysOption.maxResults(10L),
   *     Storage.ListHmacKeysOption.showDeletedKeys(true));
   * for (HmacKey.HmacKeyMetadata hmacKeyMetadata : metadataPage.getValues()) {
   *     //do something with the metadata
   * }
   * }</pre>
   *
   * @param options the options to apply to this operation
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  Page<HmacKeyMetadata> listHmacKeys(ListHmacKeysOption... options);

  /**
   * Gets an HMAC key given its access id. Note that this returns a {@code HmacKeyMetadata} object,
   * which does not contain the secret key.
   *
   * <p>Example of getting an HMAC key. Since projectId isn't specified, the same project ID as the
   * storage client instance will be used.
   *
   * <pre>{@code
   * String hmacKeyAccessId = "my-access-id";
   * HmacKey.HmackeyMetadata hmacKeyMetadata = storage.getHmacKey(hmacKeyAccessId);
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  HmacKeyMetadata getHmacKey(String accessId, GetHmacKeyOption... options);

  /**
   * Deletes an HMAC key. Note that only an {@code INACTIVE} key can be deleted. Attempting to
   * delete a key whose {@code HmacKey.HmacKeyState} is anything other than {@code INACTIVE} will
   * fail.
   *
   * <p>Example of updating an HMAC key's state to INACTIVE and then deleting it.
   *
   * <pre>{@code
   * String hmacKeyAccessId = "my-access-id";
   * HmacKey.HmacKeyMetadata hmacKeyMetadata = storage.getHmacKey(hmacKeyAccessId);
   *
   * storage.updateHmacKeyState(hmacKeyMetadata, HmacKey.HmacKeyState.INACTIVE);
   * storage.deleteHmacKey(hmacKeyMetadata);
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  void deleteHmacKey(HmacKeyMetadata hmacKeyMetadata, DeleteHmacKeyOption... options);

  /**
   * Updates the state of an HMAC key and returns the updated metadata.
   *
   * <p>Example of updating the state of an HMAC key.
   *
   * <pre>{@code
   * String hmacKeyAccessId = "my-access-id";
   * HmacKey.HmacKeyMetadata hmacKeyMetadata = storage.getHmacKey(hmacKeyAccessId);
   *
   * storage.updateHmacKeyState(hmacKeyMetadata, HmacKey.HmacKeyState.INACTIVE);
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  HmacKeyMetadata updateHmacKeyState(
      final HmacKeyMetadata hmacKeyMetadata,
      final HmacKey.HmacKeyState state,
      UpdateHmacKeyOption... options);

  /**
   * Gets the IAM policy for the provided bucket.
   *
   * <p>It's possible for bindings to be empty and instead have permissions inherited through
   * Project or Organization IAM Policies. To prevent corrupting policies when you update an IAM
   * policy with {@code Storage.setIamPolicy}, the ETAG value is used to perform optimistic
   * concurrency.
   *
   * <p>Example of getting the IAM policy for a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Policy policy = storage.getIamPolicy(bucketName);
   * }</pre>
   *
   * @param bucket name of the bucket where the getIamPolicy operation takes place
   * @param options extra parameters to apply to this operation
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Policy getIamPolicy(String bucket, BucketSourceOption... options);

  /**
   * Updates the IAM policy on the specified bucket.
   *
   * <p>To prevent corrupting policies when you update an IAM policy with {@code
   * Storage.setIamPolicy}, the ETAG value is used to perform optimistic concurrency.
   *
   * <p>Example of updating the IAM policy on a bucket.
   *
   * <pre>{@code
   * // We want to make all objects in our bucket publicly readable.
   * String bucketName = "my-unique-bucket";
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Policy setIamPolicy(String bucket, Policy policy, BucketSourceOption... options);

  /**
   * Tests whether the caller holds the permissions on the specified bucket. Returns a list of
   * booleans in the same placement and order in which the permissions were specified.
   *
   * <p>Example of testing permissions on a bucket.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * List<Boolean> response =
   *     storage.testIamPermissions(
   *         bucketName,
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
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  List<Boolean> testIamPermissions(
      String bucket, List<String> permissions, BucketSourceOption... options);

  /**
   * Returns the service account associated with the given project.
   *
   * <p>Example of getting a service account.
   *
   * <pre>{@code
   * String projectId = "test@gmail.com";
   * ServiceAccount account = storage.getServiceAccount(projectId);
   * }</pre>
   *
   * @param projectId the ID of the project for which the service account should be fetched.
   * @return the service account associated with this project
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  ServiceAccount getServiceAccount(String projectId);

  /**
   * Creates the notification for a given bucket.
   *
   * <p>Example of creating a notification:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String topic = "projects/myProject/topics/myTopic"
   * NotificationInfo notificationInfo = NotificationInfo.newBuilder(topic)
   *  .setCustomAttributes(ImmutableMap.of("label1", "value1"))
   *  .setEventTypes(NotificationInfo.EventType.OBJECT_FINALIZE)
   *  .setPayloadFormat(NotificationInfo.PayloadFormat.JSON_API_V1)
   *  .build();
   * Notification notification = storage.createNotification(bucketName, notificationInfo);
   * }</pre>
   *
   * @param bucket name of the bucket
   * @param notificationInfo notification to create
   * @return the created notification
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  Notification createNotification(String bucket, NotificationInfo notificationInfo);

  /**
   * Gets the notification with the specified id.
   *
   * <p>Example of getting the notification:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String notificationId = "my-unique-notification-id";
   * Notification notification = storage.getNotification(bucketName, notificationId);
   * }</pre>
   *
   * @param bucket name of the bucket
   * @param notificationId notification ID
   * @return the {@code Notification} object with the given id or {@code null} if not found
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  Notification getNotification(String bucket, String notificationId);

  /**
   * Retrieves the list of notifications associated with the bucket.
   *
   * <p>Example of listing the bucket notifications:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * List<Notification> notifications = storage.listNotifications(bucketName);
   * }</pre>
   *
   * @param bucket name of the bucket
   * @return a list of {@link Notification} objects added to the bucket.
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  List<Notification> listNotifications(String bucket);

  /**
   * Deletes the notification with the specified id.
   *
   * <p>Example of deleting the notification:
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String notificationId = "my-unique-notification-id";
   * boolean deleted = storage.deleteNotification(bucketName, notificationId);
   * if (deleted) {
   *   // the notification was deleted
   * } else {
   *   // the notification was not found
   * }
   * }</pre>
   *
   * @param bucket name of the bucket
   * @param notificationId ID of the notification to delete
   * @return {@code true} if the notification has been deleted, {@code false} if not found
   * @throws StorageException upon failure
   */
  @TransportCompatibility({Transport.HTTP})
  boolean deleteNotification(String bucket, String notificationId);

  /**
   * @throws InterruptedException thrown if interrupted while awaiting termination of underlying
   *     resources
   */
  @Override
  default void close() throws Exception {}

  /**
   * Create a new {@link BlobWriteSession} for the specified {@code blobInfo} and {@code options}.
   *
   * <p>The returned {@code BlobWriteSession} can be used to write an individual version, a new
   * session must be created each time you want to create a new version.
   *
   * <p>By default, any MD5 value in the provided {@code blobInfo} is ignored unless the option
   * {@link BlobWriteOption#md5Match()} is included in {@code options}.
   *
   * <p>By default, any CRC32c value in the provided {@code blobInfo} is ignored unless the option
   * {@link BlobWriteOption#crc32cMatch()} is included in {@code options}.
   *
   * <h4>Example of creating an object using {@code BlobWriteSession}:</h4>
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
   * ReadableByteChannel readableByteChannel = ...;
   * BlobWriteSession blobWriteSession = storage.blobWriteSession(blobInfo, BlobWriteOption.doesNotExist());
   *
   * // open the channel for writing
   * try (WritableByteChannel writableByteChannel = blobWriteSession.open()) {
   *   // copy all bytes
   *   ByteStreams.copy(readableByteChannel, writableByteChannel);
   * } catch (IOException e) {
   *   // handle IOException
   * }
   *
   * // get the resulting object metadata
   * ApiFuture<BlobInfo> resultFuture = blobWriteSession.getResult();
   * BlobInfo gen1 = resultFuture.get();
   * }</pre>
   *
   * @param blobInfo blob to create
   * @param options blob write options
   * @since 2.26.0 This new api is in preview and is subject to breaking changes.
   * @see BlobWriteSessionConfig
   * @see BlobWriteSessionConfigs
   * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC, Transport.HTTP})
  default BlobWriteSession blobWriteSession(BlobInfo blobInfo, BlobWriteOption... options) {
    return throwGrpcOnly(fmtMethodName("blobWriteSession", BlobInfo.class, BlobWriteOption.class));
  }

  /**
   * Atomically move an object from one name to another.
   *
   * <p>This new method is an atomic equivalent of the existing {@link Storage#copy(CopyRequest)} +
   * {@link Storage#delete(BlobId)}, however without the ability to change metadata fields for the
   * target object.
   *
   * @since 2.48.0
   */
  @TransportCompatibility({Transport.HTTP, Transport.GRPC})
  Blob moveBlob(MoveBlobRequest request);

  /**
   * Asynchronously set up a new {@link BlobReadSession} for the specified {@link BlobId} and {@code
   * options}.
   *
   * <p>The resulting {@code BlobReadSession} can be used to read multiple times from a single
   * object generation. A new session must be created for each object generation.
   *
   * <h4>Example of using {@code BlobReadSession} to read up to 20 bytes from the object:</h4>
   *
   * <pre>{@code
   * ApiFuture<BlobReadSession> futureBlobReadSession = storage.blobReadSession(blobId);
   *
   * try (BlobReadSession blobReadSession = futureBlobReadSession.get(10, TimeUnit.SECONDS)) {
   *
   *   ByteBuffer buf = ByteBuffer.allocate(30);
   *   RangeSpec rangeSpec = RangeSpec.of(
   *     10, // begin
   *     20  // maxLength
   *   );
   *   ReadAsChannel readAsChannelConfig = ReadProjectionConfigs.asChannel()
   *       .withRangeSpec(rangeSpec);
   *   try (ScatteringByteChannel channel = blobReadSession.readAs(readAsChannelConfig)) {
   *     channel.read(buf);
   *   }
   *
   *   buf.flip();
   *   System.out.printf(
   *       Locale.US,
   *       "Read %d bytes from range %s of object %s%n",
   *       buf.remaining(),
   *       rangeSpec,
   *       blobReadSession.getBlobInfo().getBlobId().toGsUtilUriWithGeneration()
   *   );
   * }
   * }</pre>
   *
   * @param id the blob to read from
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC})
  default ApiFuture<BlobReadSession> blobReadSession(BlobId id, BlobSourceOption... options) {
    return throwGrpcOnly(fmtMethodName("blobReadSession", BlobId.class, BlobSourceOption.class));
  }

  /**
   * Create a new {@link BlobAppendableUpload} for the specified {@code blobInfo} and {@code
   * options}.
   *
   * <p>The returned {@code BlobWriteSession} can be used to write an individual version, a new
   * session must be created each time you want to create a new version.
   *
   * <p>If your object exists, but is still in an appendable state ensure you provide the generation
   * of the object in the provided {@code blobInfo} ({@link BlobInfo#getBlobId()
   * blobInfo.getBlobId()}{@link BlobId#getGeneration() .getGeneration()}) to enable takeover.
   *
   * <h4>Example of creating an object using {@code BlobAppendableUpload}:</h4>
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blobInfo-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
   * ReadableByteChannel readableByteChannel = ...;
   *
   * BlobAppendableUpload uploadSession = storage.blobAppendableUpload(
   *     blobInfo,
   *     BlobAppendableUploadConfig.of()
   * );
   * try (AppendableUploadWriteableByteChannel channel = uploadSession.open()) {
   *   // copy all bytes
   *   ByteStreams.copy(readableByteChannel, channel);
   *   channel.finalizeAndClose();
   * } catch (IOException ex) {
   *   // handle IOException
   * }
   *
   * // get the resulting object metadata
   * ApiFuture<BlobInfo> resultFuture = uploadSession.getResult();
   * BlobInfo gen1 = resultFuture.get();
   * }</pre>
   *
   * @param blobInfo blobInfo to create
   * @param uploadConfig the configuration parameters for the channel
   * @param options blobInfo write options
   * @since 2.51.0 This new api is in preview and is subject to breaking changes.
   * @see StorageOptions#grpc()
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC})
  default BlobAppendableUpload blobAppendableUpload(
      BlobInfo blobInfo, BlobAppendableUploadConfig uploadConfig, BlobWriteOption... options) {
    return throwGrpcOnly(
        fmtMethodName("appendableBlobUpload", BlobId.class, BlobWriteOption.class));
  }
}

/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.storage.Utils.projectNameCodec;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Predicates.not;
import static java.util.Objects.requireNonNull;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.CommonObjectRequestParams;
import com.google.storage.v2.ComposeObjectRequest;
import com.google.storage.v2.CreateBucketRequest;
import com.google.storage.v2.DeleteBucketRequest;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.GetBucketRequest;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.ListBucketsRequest;
import com.google.storage.v2.ListObjectsRequest;
import com.google.storage.v2.LockBucketRetentionPolicyRequest;
import com.google.storage.v2.MoveObjectRequest;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.RestoreObjectRequest;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.UpdateBucketRequest;
import com.google.storage.v2.UpdateObjectRequest;
import com.google.storage.v2.WriteObjectRequest;
import java.io.Serializable;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.crypto.spec.SecretKeySpec;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/**
 * The set of all "Options" we currently support for per-call parameters.
 *
 * <p>Most often, each of the respective types correspond to one of the parameters from <a
 * target="_blank" href="https://cloud.google.com/storage/docs/json_api/v1/parameters">HTTP headers
 * and common query string parameters for JSON</a>. In the case of gRPC, sometimes the parameters
 * are in the specific request message or in grpc metadata.
 */
@SuppressWarnings({"deprecation", "DeprecatedIsStillUsed"})
final class UnifiedOpts {

  /** Base interface type for each of the new options we're supporting. */
  interface Opt extends Serializable {}

  /**
   * A specialization of {@link java.util.function.UnaryOperator} which maintains its lower type for
   * {@link #identity()} and {@link #andThen(Mapper)}.
   */
  @FunctionalInterface
  interface Mapper<T> {
    T apply(T t);

    default Mapper<T> andThen(Mapper<T> then) {
      return t -> then.apply(apply(t));
    }

    static <T> Mapper<T> identity() {
      return t -> t;
    }
  }

  /** Base, marker interface of those Opts which represent a get/read/origin type relationship. */
  private interface SourceOpt extends Opt {}

  /**
   * Base, marker interface of those Opts which represent a set/write/destination type relationship.
   */
  private interface TargetOpt extends Opt {}

  /** Base, marker interface of those Opts which apply to listing operations. */
  private interface ListOpt extends Opt {}

  /** Marker interface of those Opts which are applicable to Bucket operations. */
  private interface ApplicableBucket {}

  /** Marker interface of those Opts which are applicable to Object/Blob operations. */
  private interface ApplicableObject {}

  /** Marker interface of those Opts which are applicable to HmacKey operations. */
  private interface ApplicableHmacKey {}

  /** Base interface for those Opts which may expose their values via gRPC Metadata */
  private interface GrpcMetadataMapper extends Opt {
    default Mapper<GrpcCallContext> getGrpcMetadataMapper() {
      return Mapper.identity();
    }
  }

  /** Base interface for those Opts which are applicable to Object List operations */
  interface ObjectListOpt extends GrpcMetadataMapper, ListOpt, ApplicableObject {
    default Mapper<ListObjectsRequest.Builder> listObjects() {
      return Mapper.identity();
    }
  }

  /**
   * Base interface for those Opts which are applicable to Object Source (get/read/origin
   * relationship) operations
   */
  interface ObjectSourceOpt extends GrpcMetadataMapper, SourceOpt, ApplicableObject {
    default Mapper<ReadObjectRequest.Builder> readObject() {
      return Mapper.identity();
    }

    default Mapper<BidiReadObjectRequest.Builder> bidiReadObject() {
      return Mapper.identity();
    }

    default Mapper<GetObjectRequest.Builder> getObject() {
      return Mapper.identity();
    }

    default Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return Mapper.identity();
    }

    default Mapper<MoveObjectRequest.Builder> moveObject() {
      return Mapper.identity();
    }

    default Mapper<RestoreObjectRequest.Builder> restoreObject() {
      return Mapper.identity();
    }
  }

  /**
   * Base interface for those Opts which are applicable to Object Target (set/write/destination
   * relationship) operations
   */
  interface ObjectTargetOpt extends GrpcMetadataMapper, TargetOpt, ApplicableObject {
    default Mapper<BlobInfo.Builder> blobInfo() {
      return Mapper.identity();
    }

    default Mapper<WriteObjectRequest.Builder> writeObject() {
      return Mapper.identity();
    }

    default Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return Mapper.identity();
    }

    default Mapper<UpdateObjectRequest.Builder> updateObject() {
      return Mapper.identity();
    }

    default Mapper<DeleteObjectRequest.Builder> deleteObject() {
      return Mapper.identity();
    }

    default Mapper<ComposeObjectRequest.Builder> composeObject() {
      return Mapper.identity();
    }

    default Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return Mapper.identity();
    }

    default Mapper<MoveObjectRequest.Builder> moveObject() {
      return Mapper.identity();
    }

    default Mapper<StartResumableWriteRequest.Builder> startResumableWrite() {
      return Mapper.identity();
    }
  }

  /** Base interface for those Opts which are applicable to Bucket List operations */
  interface BucketListOpt extends GrpcMetadataMapper, ListOpt, ApplicableBucket {
    default Mapper<ListBucketsRequest.Builder> listBuckets() {
      return Mapper.identity();
    }
  }

  /**
   * Base interface for those Opts which are applicable to Bucket Source (get/read/origin
   * relationship) operations
   */
  interface BucketSourceOpt extends GrpcMetadataMapper, SourceOpt, ApplicableBucket {
    default Mapper<GetBucketRequest.Builder> getBucket() {
      return Mapper.identity();
    }

    default Mapper<GetIamPolicyRequest.Builder> getIamPolicy() {
      return Mapper.identity();
    }
  }

  /**
   * Base interface for those Opts which are applicable to Bucket Target (set/write/destination
   * relationship) operations
   */
  interface BucketTargetOpt extends GrpcMetadataMapper, TargetOpt, ApplicableBucket {
    default Mapper<CreateBucketRequest.Builder> createBucket() {
      return Mapper.identity();
    }

    default Mapper<UpdateBucketRequest.Builder> updateBucket() {
      return Mapper.identity();
    }

    default Mapper<DeleteBucketRequest.Builder> deleteBucket() {
      return Mapper.identity();
    }

    default Mapper<LockBucketRetentionPolicyRequest.Builder> lockBucketRetentionPolicy() {
      return Mapper.identity();
    }
  }

  /** Base interface for those Opts which are applicable to HmacKey List operations */
  interface HmacKeyListOpt extends GrpcMetadataMapper, ListOpt, ApplicableHmacKey {}

  /**
   * Base interface for those Opts which are applicable to HmacKey Source (get/read/origin
   * relationship) operations
   */
  interface HmacKeySourceOpt extends GrpcMetadataMapper, SourceOpt, ApplicableHmacKey {}

  /**
   * Base interface for those Opts which are applicable to HmacKey Target (set/write/destination
   * relationship) operations
   */
  interface HmacKeyTargetOpt extends GrpcMetadataMapper, TargetOpt, ApplicableHmacKey {}

  /**
   * Some Options have a corresponding "SOURCE" version, this interface provide a construct for
   * accessing an projecting those Opts which can be turned into a "SOURCE" version.
   */
  interface ProjectAsSource<O extends Opt> {
    O asSource();
  }

  interface HasherSelector extends BucketObjectHmacKeyAllOpt {
    Hasher getHasher();
  }

  /**
   * This class extends off {@link ObjectSourceOpt} and {@link ObjectTargetOpt} in order to satisfy
   * some the shimming constraints of the subclasses of {@link OptionShim}.
   *
   * <p>All the methods from these parent interfaces will NEVER be called, and are stubbed simply to
   * satisfy the need for them to be declared. They are stubbed to use identity methods so that if
   * they somehow do ever leak through and are called they won't cause issue for customers.
   *
   * <p>If/when we're able to remove all the {@link Option} classes, this interface should be
   * refactored to remove the inheritance, instead providing an explicit pre-processing phase to opt
   * resolution.
   */
  interface ObjectOptExtractor<O extends Opt> extends Opt, ObjectSourceOpt, ObjectTargetOpt {
    O extractFromBlobInfo(BlobInfo info);

    O extractFromBlobId(BlobId id);

    @Override
    default Mapper<GrpcCallContext> getGrpcMetadataMapper() {
      return Mapper.identity();
    }

    @Override
    default Mapper<GetObjectRequest.Builder> getObject() {
      return Mapper.identity();
    }

    @Override
    default Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return Mapper.identity();
    }

    @Override
    default Mapper<MoveObjectRequest.Builder> moveObject() {
      return Mapper.identity();
    }
  }

  /**
   * This class extends off {@link ObjectSourceOpt} and {@link ObjectTargetOpt} in order to satisfy
   * some the shimming constraints of the subclasses of {@link OptionShim}.
   *
   * <p>All the methods from these parent interfaces will NEVER be called, and are stubbed simply to
   * satisfy the need for them to be declared. They are stubbed to use identity methods so that if
   * they somehow do ever leak through and are called they won't cause issue for customers.
   *
   * <p>If/when we're able to remove all the {@link Option} classes, this interface should be
   * refactored to remove the inheritance, instead providing an explicit pre-processing phase to opt
   * resolution.
   */
  interface BucketOptExtractor<O extends Opt> extends Opt, BucketSourceOpt, BucketTargetOpt {
    O extractFromBucketInfo(BucketInfo info);

    @Override
    default Mapper<GrpcCallContext> getGrpcMetadataMapper() {
      return Mapper.identity();
    }
  }

  /* --
  Factory methods for each of the supported Opts, along with some of their requisite
  compatibility overloads
  -- */

  static Crc32cMatch crc32cMatch(int i) {
    return new Crc32cMatch(i);
  }

  static Crc32cMatch crc32cMatch(@NonNull String crc32c) {
    requireNonNull(crc32c, "crc32c must be non null");
    return new Crc32cMatch(Utils.crc32cCodec.decode(crc32c));
  }

  static Delimiter currentDirectory() {
    return new Delimiter("/");
  }

  static DecryptionKey decryptionKey(@NonNull String decryptionKey) {
    requireNonNull(decryptionKey, "decryptionKey must be non null");
    return new DecryptionKey(
        new SecretKeySpec(BaseEncoding.base64().decode(decryptionKey), "AES256"));
  }

  @RequiresNonNull({"decryptionKey", "#1.getEncoded()", "#1.getAlgorithm()"})
  static DecryptionKey decryptionKey(@NonNull Key decryptionKey) {
    requireNonNull(decryptionKey, "decryptionKey must be non null");
    requireNonNull(decryptionKey.getEncoded(), "decryptionKey.getEncoded() must be non null");
    requireNonNull(decryptionKey.getAlgorithm(), "decryptionKey.getAlgorithm() must be non null");
    return new DecryptionKey(decryptionKey);
  }

  static Delimiter delimiter(@NonNull String delimiter) {
    requireNonNull(delimiter, "delimiter must be non null");
    return new Delimiter(delimiter);
  }

  static IncludeFoldersAsPrefixes includeFoldersAsPrefixes(boolean includeFoldersAsPrefixes) {
    return new IncludeFoldersAsPrefixes(includeFoldersAsPrefixes);
  }

  static IncludeTrailingDelimiter includeTrailingDelimiter() {
    return new IncludeTrailingDelimiter(true);
  }

  @Deprecated
  static DetectContentType detectContentType() {
    return DetectContentType.INSTANCE;
  }

  static DisableGzipContent disableGzipContent() {
    return new DisableGzipContent(true);
  }

  static GenerationMatch doesNotExist() {
    return new GenerationMatch(0);
  }

  static EncryptionKey encryptionKey(@NonNull String encryptionKey) {
    requireNonNull(encryptionKey, "encryptionKey must be non null");
    return new EncryptionKey(
        new SecretKeySpec(BaseEncoding.base64().decode(encryptionKey), "AES256"));
  }

  static EncryptionKey encryptionKey(@NonNull Key encryptionKey) {
    requireNonNull(encryptionKey, "encryptionKey must be non null");
    return new EncryptionKey(encryptionKey);
  }

  static EndOffset endOffset(@NonNull String endOffset) {
    requireNonNull(endOffset, "endOffset must be non null");
    return new EndOffset(endOffset);
  }

  static Fields fields(@NonNull ImmutableSet<NamedField> fields) {
    requireNonNull(fields, "fields must be non null");
    return new Fields(fields);
  }

  static GenerationMatch generationMatch(long l) {
    return new GenerationMatch(l);
  }

  static GenerationNotMatch generationNotMatch(long l) {
    return new GenerationNotMatch(l);
  }

  static KmsKeyName kmsKeyName(@NonNull String kmsKeyName) {
    requireNonNull(kmsKeyName, "kmsKeyName must be non null");
    return new KmsKeyName(kmsKeyName);
  }

  static MatchGlob matchGlob(@NonNull String glob) {
    requireNonNull(glob, "glob must be non null");
    return new MatchGlob(glob);
  }

  static Md5Match md5Match(@NonNull String md5) {
    requireNonNull(md5, "md5 must be non null");
    return new Md5Match(md5);
  }

  static MetagenerationMatch metagenerationMatch(long l) {
    return new MetagenerationMatch(l);
  }

  static MetagenerationNotMatch metagenerationNotMatch(long l) {
    return new MetagenerationNotMatch(l);
  }

  static PageSize pageSize(long l) {
    return new PageSize(l);
  }

  static PageToken pageToken(@NonNull String pageToken) {
    requireNonNull(pageToken, "pageToken must be non null");
    return new PageToken(pageToken);
  }

  static ReturnPartialSuccess returnPartialSuccess(boolean returnPartialSuccess) {
    return new ReturnPartialSuccess(returnPartialSuccess);
  }

  static PredefinedAcl predefinedAcl(Storage.@NonNull PredefinedAcl predefinedAcl) {
    requireNonNull(predefinedAcl, "predefinedAcl must be non null");
    return new PredefinedAcl(predefinedAcl.getEntry());
  }

  static PredefinedDefaultObjectAcl predefinedDefaultObjectAcl(
      Storage.@NonNull PredefinedAcl predefinedAcl) {
    requireNonNull(predefinedAcl, "predefinedAcl must be non null");
    return new PredefinedDefaultObjectAcl(predefinedAcl.getEntry());
  }

  static EnableObjectRetention enableObjectRetention(boolean enable) {
    return new EnableObjectRetention(enable);
  }

  static OverrideUnlockedRetention overrideUnlockedRetention(boolean overrideUnlockedRetention) {
    return new OverrideUnlockedRetention(overrideUnlockedRetention);
  }

  static Prefix prefix(@NonNull String prefix) {
    requireNonNull(prefix, "prefix must be non null");
    return new Prefix(prefix);
  }

  static ProjectId projectId(@NonNull String projectId) {
    requireNonNull(projectId, "projectId must be non null");
    return new ProjectId(projectId);
  }

  static Projection projection(@NonNull String projection) {
    requireNonNull(projection, "projection must be non null");
    return new Projection(projection);
  }

  static ResumableUploadExpectedObjectSize resumableUploadExpectedObjectSize(
      long expectedObjectSize) {
    checkArgument(expectedObjectSize >= 0, "expectedObjectSize >= 0 (%s >= 0)", expectedObjectSize);
    return new ResumableUploadExpectedObjectSize(expectedObjectSize);
  }

  static SoftDeleted softDeleted(boolean softDeleted) {
    return new SoftDeleted(softDeleted);
  }

  static CopySourceAcl copySourceAcl(boolean copySourceAcl) {
    return new CopySourceAcl(copySourceAcl);
  }

  static RequestedPolicyVersion requestedPolicyVersion(long l) {
    return new RequestedPolicyVersion(l);
  }

  static ReturnRawInputStream returnRawInputStream(boolean b) {
    return new ReturnRawInputStream(b);
  }

  @RequiresNonNull({"serviceAccount", "#1.getEmail()"})
  static ServiceAccount serviceAccount(
      com.google.cloud.storage.@NonNull ServiceAccount serviceAccount) {
    requireNonNull(serviceAccount, "serviceAccount must be non null");
    requireNonNull(serviceAccount.getEmail(), "serviceAccount.getEmail() must be non null");
    return new ServiceAccount(serviceAccount.getEmail());
  }

  @VisibleForTesting
  static SetContentType setContentType(@NonNull String s) {
    requireNonNull(s, "s must be non null");
    return new SetContentType(s);
  }

  static ShowDeletedKeys showDeletedKeys(boolean b) {
    return new ShowDeletedKeys(b);
  }

  static StartOffset startOffset(@NonNull String startOffset) {
    requireNonNull(startOffset, "startOffset must be non null");
    return new StartOffset(startOffset);
  }

  static UserProject userProject(@NonNull String userProject) {
    requireNonNull(userProject, "userProject must be non null");
    return new UserProject(userProject);
  }

  static VersionsFilter versionsFilter(boolean b) {
    return new VersionsFilter(b);
  }

  @Deprecated
  static GenerationMatchExtractor generationMatchExtractor() {
    return GenerationMatchExtractor.INSTANCE;
  }

  @Deprecated
  static GenerationNotMatchExtractor generationNotMatchExtractor() {
    return GenerationNotMatchExtractor.INSTANCE;
  }

  @Deprecated
  static MetagenerationMatchExtractor metagenerationMatchExtractor() {
    return MetagenerationMatchExtractor.INSTANCE;
  }

  @Deprecated
  static MetagenerationNotMatchExtractor metagenerationNotMatchExtractor() {
    return MetagenerationNotMatchExtractor.INSTANCE;
  }

  @Deprecated
  static Crc32cMatchExtractor crc32cMatchExtractor() {
    return Crc32cMatchExtractor.INSTANCE;
  }

  @Deprecated
  static Md5MatchExtractor md5MatchExtractor() {
    return Md5MatchExtractor.INSTANCE;
  }

  static ObjectFilter objectFilter(String filter) {
    return new ObjectFilter(filter);
  }

  static Headers extraHeaders(ImmutableMap<String, String> extraHeaders) {
    requireNonNull(extraHeaders, "extraHeaders must be non null");
    String blockedHeaders =
        extraHeaders.keySet().stream()
            .map(Utils::headerNameToLowerCase)
            .filter(Headers.BLOCKLIST)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.joining(", ", "[", "]"));
    checkArgument("[]".equals(blockedHeaders), "Disallowed headers: %s", blockedHeaders);
    return new Headers(extraHeaders);
  }

  static DefaultHasherSelector defaultHasherSelector() {
    return DefaultHasherSelector.INSTANCE;
  }

  static final class Crc32cMatch implements ObjectTargetOpt, HasherSelector {
    private static final long serialVersionUID = 8172282701777561769L;
    private final int val;

    private Crc32cMatch(int val) {
      this.val = val;
    }

    @Override
    public Mapper<BlobInfo.Builder> blobInfo() {
      return b -> b.setCrc32c(Utils.crc32cCodec.encode(val));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Crc32cMatch)) {
        return false;
      }
      Crc32cMatch that = (Crc32cMatch) o;
      return Objects.equals(val, that.val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getObjectChecksumsBuilder().setCrc32C(val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getObjectChecksumsBuilder().setCrc32C(val);
        return b;
      };
    }

    @Override
    public Hasher getHasher() {
      return Hasher.noop();
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }

    @Override
    public String toString() {
      return "Crc32cMatch{val='" + val + "'}";
    }
  }

  /**
   * @see EncryptionKey
   */
  static final class DecryptionKey extends RpcOptVal<Key> implements ObjectSourceOpt {
    private static final long serialVersionUID = -2198422155991275316L;

    private DecryptionKey(Key val) {
      super(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, val);
    }

    @Override
    public Mapper<ImmutableMap.Builder<StorageRpc.Option, Object>> mapper() {
      return b ->
          b.put(
              StorageRpc.Option.CUSTOMER_SUPPLIED_KEY,
              BaseEncoding.base64().encode(val.getEncoded()));
    }

    @Override
    public Mapper<ReadObjectRequest.Builder> readObject() {
      return b -> {
        customerSuppliedKey(b.getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }

    @Override
    public Mapper<BidiReadObjectRequest.Builder> bidiReadObject() {
      return b -> {
        customerSuppliedKey(
            b.getReadObjectSpecBuilder().getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }

    @Override
    public Mapper<GetObjectRequest.Builder> getObject() {
      return b -> {
        customerSuppliedKey(b.getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> {
        CommonObjectRequestParams.Builder builder =
            customerSuppliedKey(CommonObjectRequestParams.newBuilder(), val);
        return b.setCopySourceEncryptionAlgorithm(builder.getEncryptionAlgorithm())
            .setCopySourceEncryptionKeyBytes(builder.getEncryptionKeyBytes())
            .setCopySourceEncryptionKeySha256Bytes(builder.getEncryptionKeySha256Bytes());
      };
    }
  }

  static final class IncludeFoldersAsPrefixes extends RpcOptVal<Boolean> implements ObjectListOpt {

    private static final long serialVersionUID = 321916692864878282L;

    private IncludeFoldersAsPrefixes(boolean val) {
      super(StorageRpc.Option.INCLUDE_FOLDERS_AS_PREFIXES, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setIncludeFoldersAsPrefixes(val);
    }
  }

  static final class IncludeTrailingDelimiter extends RpcOptVal<Boolean> implements ObjectListOpt {

    private static final long serialVersionUID = 321916692864878282L;

    private IncludeTrailingDelimiter(boolean val) {
      super(StorageRpc.Option.INCLUDE_TRAILING_DELIMITER, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setIncludeTrailingDelimiter(val);
    }
  }

  static final class Delimiter extends RpcOptVal<String> implements ObjectListOpt {
    private static final long serialVersionUID = -3789556789947615714L;

    private Delimiter(String val) {
      super(StorageRpc.Option.DELIMITER, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setDelimiter(val);
    }
  }

  static final class SoftDeleted extends RpcOptVal<Boolean>
      implements ObjectListOpt, ObjectSourceOpt {

    private static final long serialVersionUID = -8526951678111463350L;

    private SoftDeleted(boolean val) {
      super(StorageRpc.Option.SOFT_DELETED, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setSoftDeleted(val);
    }

    @Override
    public Mapper<GetObjectRequest.Builder> getObject() {
      return b -> b.setSoftDeleted(val);
    }
  }

  static final class CopySourceAcl extends RpcOptVal<Boolean> implements ObjectSourceOpt {

    private static final long serialVersionUID = 2033755749149128119L;

    private CopySourceAcl(boolean val) {
      super(StorageRpc.Option.COPY_SOURCE_ACL, val);
    }

    @Override
    public Mapper<RestoreObjectRequest.Builder> restoreObject() {
      return b -> b.setCopySourceAcl(val);
    }
  }

  static final class DisableGzipContent extends RpcOptVal<@NonNull Boolean>
      implements ObjectTargetOpt {
    private static final long serialVersionUID = 7445066765944965549L;

    private DisableGzipContent(boolean val) {
      super(StorageRpc.Option.IF_DISABLE_GZIP_CONTENT, val);
    }
  }

  /**
   * @see DecryptionKey
   */
  static final class EncryptionKey extends RpcOptVal<Key>
      implements ObjectTargetOpt, ProjectAsSource<DecryptionKey> {
    private static final long serialVersionUID = -7335988656032764620L;

    private EncryptionKey(Key val) {
      super(StorageRpc.Option.CUSTOMER_SUPPLIED_KEY, val);
    }

    @Override
    public DecryptionKey asSource() {
      return new DecryptionKey(val);
    }

    @Override
    public Mapper<ImmutableMap.Builder<StorageRpc.Option, Object>> mapper() {
      return b ->
          b.put(
              StorageRpc.Option.CUSTOMER_SUPPLIED_KEY,
              BaseEncoding.base64().encode(val.getEncoded()));
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        customerSuppliedKey(b.getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        customerSuppliedKey(b.getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return b -> {
        customerSuppliedKey(b.getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }

    @Override
    public Mapper<DeleteObjectRequest.Builder> deleteObject() {
      return b -> {
        customerSuppliedKey(b.getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }

    @Override
    public Mapper<ComposeObjectRequest.Builder> composeObject() {
      return b -> {
        customerSuppliedKey(b.getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> {
        customerSuppliedKey(b.getCommonObjectRequestParamsBuilder(), val);
        return b;
      };
    }
  }

  /**
   * @see StartOffset
   */
  static final class EndOffset extends RpcOptVal<String> implements ObjectListOpt {
    private static final long serialVersionUID = 7446382028145458833L;

    private EndOffset(String val) {
      super(StorageRpc.Option.END_OFF_SET, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setLexicographicEnd(val);
    }
  }

  static final class Fields extends RpcOptVal<ImmutableSet<NamedField>>
      implements ObjectSourceOpt,
          ObjectListOpt,
          ObjectTargetOpt,
          BucketSourceOpt,
          BucketTargetOpt,
          BucketListOpt {

    /**
     * Apiary and gRPC have differing handling of where the field selector is evaluated relative to
     * the request. For Apiary, it's from the root response document; for gRPC it's from the
     * collection of results.
     *
     * <p>In our current case, this means we exclude some fields when we know it is being consumed
     * for a gRPC message. Unfortunately, we don't know if the constructed Fields instance is for
     * use with gRPC when it is instantiated so we must define here.
     */
    private static final ImmutableSet<String> grpcExcludedFields =
        ImmutableSet.of("nextPageToken", "prefixes", "selfLink", "mediaLink", "kind", "id");

    private static final long serialVersionUID = 3286889410148272195L;

    private Fields(ImmutableSet<NamedField> val) {
      super(StorageRpc.Option.FIELDS, val);
    }

    @Override
    public Mapper<ImmutableMap.Builder<StorageRpc.Option, Object>> mapper() {
      return b -> {
        String collect =
            val.stream().map(NamedField::getApiaryName).collect(Collectors.joining(","));
        return b.put(StorageRpc.Option.FIELDS, collect);
      };
    }

    @Override
    public Mapper<GetBucketRequest.Builder> getBucket() {
      return b -> b.setReadMask(FieldMask.newBuilder().addAllPaths(getPaths()).build());
    }

    @Override
    public Mapper<ListBucketsRequest.Builder> listBuckets() {
      return b -> b.setReadMask(FieldMask.newBuilder().addAllPaths(getPaths()).build());
    }

    @Override
    public Mapper<UpdateBucketRequest.Builder> updateBucket() {
      return b -> b.setUpdateMask(FieldMask.newBuilder().addAllPaths(getPaths()).build());
    }

    @Override
    public Mapper<GetObjectRequest.Builder> getObject() {
      return b -> b.setReadMask(FieldMask.newBuilder().addAllPaths(getPaths()).build());
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setReadMask(FieldMask.newBuilder().addAllPaths(getPaths()).build());
    }

    @Override
    public Mapper<ReadObjectRequest.Builder> readObject() {
      return b -> b.setReadMask(FieldMask.newBuilder().addAllPaths(getPaths()).build());
    }

    @Override
    public Mapper<BidiReadObjectRequest.Builder> bidiReadObject() {
      return b -> {
        b.getReadObjectSpecBuilder()
            .setReadMask(FieldMask.newBuilder().addAllPaths(getPaths()).build());
        return b;
      };
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return b -> b.setUpdateMask(FieldMask.newBuilder().addAllPaths(getPaths()).build());
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return Mapper.identity();
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return Mapper.identity();
    }

    /**
     * Define a decoder which can clear out any fields which may have not been selected.
     *
     * <p>This approach, isn't ideal at the backside after decoding has already taken place.
     * However, refactoring the whole model pipeline for both json and grpc is going to be a large
     * change.
     */
    Decoder<BlobInfo, BlobInfo> clearUnselectedBlobFields() {
      return b -> {
        if (val.isEmpty()) {
          return b;
        } else {
          Set<String> names = getPaths();
          BlobInfo.Builder bldr = b.toBuilder();
          blobInfoFieldClearers.entrySet().stream()
              .filter(e -> !names.contains(e.getKey()))
              .map(Entry::getValue)
              .forEach(m -> m.apply(bldr));
          return bldr.build();
        }
      };
    }

    /**
     * Define a decoder which can clear out any fields which may have not been selected.
     *
     * <p>This approach, isn't ideal at the backside after decoding has already taken place.
     * However, refactoring the whole model pipeline for both json and grpc is going to be a large
     * change.
     */
    Decoder<Bucket, Bucket> clearUnselectedBucketFields() {
      return b -> {
        if (val.isEmpty()) {
          return b;
        } else {
          Set<String> names = getPaths();
          Bucket.Builder bldr = b.toBuilder();
          bucketInfoFieldClearers.entrySet().stream()
              .filter(e -> !names.contains(e.getKey()))
              .map(Entry::getValue)
              .forEach(m -> m.apply(bldr));
          return bldr.build();
        }
      };
    }

    private Set<String> getPaths() {
      //noinspection Guava
      return val.stream()
          .map(NamedField::stripPrefix)
          .map(NamedField::getGrpcName)
          .filter(not(grpcExcludedFields::contains))
          .collect(Collectors.toSet());
    }

    // It'd be preferable to define these clearing mappers in the fields themselves, however today
    // the fields are enums and require interfaces in order to extend anything which in turn makes
    // things public.
    //
    // To avoid putting more things on the public api that will hopefully take a different form
    // in the medium term, we define them here.
    private static final ImmutableMap<String, Mapper<BlobInfo.Builder>> blobInfoFieldClearers =
        ImmutableMap.<String, Mapper<BlobInfo.Builder>>builder()
            .put(BlobField.ACL.getGrpcName(), BlobInfo.Builder::clearAcl)
            .put(BlobField.CACHE_CONTROL.getGrpcName(), BlobInfo.Builder::clearCacheControl)
            .put(BlobField.COMPONENT_COUNT.getGrpcName(), BlobInfo.Builder::clearComponentCount)
            .put(
                BlobField.CONTENT_DISPOSITION.getGrpcName(),
                BlobInfo.Builder::clearContentDisposition)
            .put(BlobField.CONTENT_ENCODING.getGrpcName(), BlobInfo.Builder::clearContentEncoding)
            .put(BlobField.CONTENT_LANGUAGE.getGrpcName(), BlobInfo.Builder::clearContentLanguage)
            .put(BlobField.CONTENT_TYPE.getGrpcName(), BlobInfo.Builder::clearContentType)
            .put(BlobField.CRC32C.getGrpcName(), BlobInfo.Builder::clearCrc32c)
            .put(
                BlobField.CUSTOMER_ENCRYPTION.getGrpcName(),
                BlobInfo.Builder::clearCustomerEncryption)
            .put(BlobField.CUSTOM_TIME.getGrpcName(), BlobInfo.Builder::clearCustomTime)
            .put(BlobField.ETAG.getGrpcName(), BlobInfo.Builder::clearEtag)
            .put(BlobField.EVENT_BASED_HOLD.getGrpcName(), BlobInfo.Builder::clearEventBasedHold)
            .put(
                BlobField.GENERATION.getGrpcName(),
                b -> {
                  BlobId current = b.getBlobId();
                  return b.setBlobId(BlobId.of(current.getBucket(), current.getName()));
                })
            .put(BlobField.ID.getGrpcName(), BlobInfo.Builder::clearGeneratedId)
            .put(BlobField.KMS_KEY_NAME.getGrpcName(), BlobInfo.Builder::clearKmsKeyName)
            .put(BlobField.MD5HASH.getGrpcName(), BlobInfo.Builder::clearMd5)
            .put(BlobField.MEDIA_LINK.getGrpcName(), BlobInfo.Builder::clearMediaLink)
            .put(BlobField.METADATA.getGrpcName(), BlobInfo.Builder::clearMetadata)
            .put(BlobField.METAGENERATION.getGrpcName(), BlobInfo.Builder::clearMetageneration)
            .put(BlobField.OWNER.getGrpcName(), BlobInfo.Builder::clearOwner)
            .put(
                BlobField.RETENTION_EXPIRATION_TIME.getGrpcName(),
                BlobInfo.Builder::clearRetentionExpirationTime)
            .put(BlobField.SELF_LINK.getGrpcName(), BlobInfo.Builder::clearSelfLink)
            .put(BlobField.SIZE.getGrpcName(), BlobInfo.Builder::clearSize)
            .put(BlobField.STORAGE_CLASS.getGrpcName(), BlobInfo.Builder::clearStorageClass)
            .put(BlobField.TEMPORARY_HOLD.getGrpcName(), BlobInfo.Builder::clearTemporaryHold)
            .put(BlobField.TIME_CREATED.getGrpcName(), BlobInfo.Builder::clearCreateTime)
            .put(BlobField.TIME_DELETED.getGrpcName(), BlobInfo.Builder::clearDeleteTime)
            .put(
                BlobField.TIME_STORAGE_CLASS_UPDATED.getGrpcName(),
                BlobInfo.Builder::clearTimeStorageClassUpdated)
            .put(BlobField.UPDATED.getGrpcName(), BlobInfo.Builder::clearUpdateTime)
            .build();

    private static final ImmutableMap<String, Mapper<BucketInfo.Builder>> bucketInfoFieldClearers =
        ImmutableMap.<String, Mapper<BucketInfo.Builder>>builder()
            .put(BucketField.ACL.getGrpcName(), BucketInfo.Builder::clearAcl)
            // .put(BucketField.AUTOCLASS.getGrpcName(), b -> b.clearAutoclass())
            .put(BucketField.BILLING.getGrpcName(), BucketInfo.Builder::clearRequesterPays)
            .put(BucketField.CORS.getGrpcName(), BucketInfo.Builder::clearCors)
            .put(
                BucketField.CUSTOM_PLACEMENT_CONFIG.getGrpcName(),
                BucketInfo.Builder::clearCustomPlacementConfig)
            .put(
                BucketField.DEFAULT_EVENT_BASED_HOLD.getGrpcName(),
                BucketInfo.Builder::clearDefaultEventBasedHold)
            .put(BucketField.DEFAULT_OBJECT_ACL.getGrpcName(), BucketInfo.Builder::clearDefaultAcl)
            .put(
                BucketField.ENCRYPTION.getGrpcName(),
                builder ->
                    builder
                        .clearDefaultKmsKeyName()
                        .clearGoogleManagedEncryptionEnforcementConfig()
                        .clearCustomerManagedEncryptionEnforcementConfig()
                        .clearCustomerSuppliedEncryptionEnforcementConfig())
            .put(BucketField.ETAG.getGrpcName(), BucketInfo.Builder::clearEtag)
            .put(
                BucketField.IAMCONFIGURATION.getGrpcName(),
                BucketInfo.Builder::clearIamConfiguration)
            .put(BucketField.ID.getGrpcName(), BucketInfo.Builder::clearGeneratedId)
            .put(BucketField.IP_FILTER.getGrpcName(), BucketInfo.Builder::clearIpFilter)
            .put(BucketField.LABELS.getGrpcName(), BucketInfo.Builder::clearLabels)
            .put(BucketField.LIFECYCLE.getGrpcName(), BucketInfo.Builder::clearLifecycleRules)
            .put(BucketField.LOCATION.getGrpcName(), BucketInfo.Builder::clearLocation)
            .put(BucketField.LOCATION_TYPE.getGrpcName(), BucketInfo.Builder::clearLocationType)
            .put(BucketField.LOGGING.getGrpcName(), BucketInfo.Builder::clearLogging)
            .put(BucketField.METAGENERATION.getGrpcName(), BucketInfo.Builder::clearMetageneration)
            .put(BucketField.NAME.getGrpcName(), BucketInfo.Builder::clearName)
            .put(BucketField.OWNER.getGrpcName(), BucketInfo.Builder::clearOwner)
            .put(
                BucketField.RETENTION_POLICY.getGrpcName(),
                b ->
                    b.clearRetentionEffectiveTime()
                        .clearRetentionPolicyIsLocked()
                        .clearRetentionPeriod())
            .put(BucketField.RPO.getGrpcName(), BucketInfo.Builder::clearRpo)
            .put(BucketField.STORAGE_CLASS.getGrpcName(), BucketInfo.Builder::clearStorageClass)
            .put(BucketField.TIME_CREATED.getGrpcName(), BucketInfo.Builder::clearCreateTime)
            .put(BucketField.UPDATED.getGrpcName(), BucketInfo.Builder::clearUpdateTime)
            .put(BucketField.VERSIONING.getGrpcName(), BucketInfo.Builder::clearVersioningEnabled)
            .put(BucketField.WEBSITE.getGrpcName(), b -> b.clearIndexPage().clearNotFoundPage())
            .put("project", BucketInfo.Builder::clearProject)
            .build();
  }

  /**
   * @see GenerationNotMatch
   * @see SourceGenerationMatch
   */
  static final class GenerationMatch extends RpcOptVal<@NonNull Long>
      implements ObjectSourceOpt, ObjectTargetOpt, ProjectAsSource<SourceGenerationMatch> {
    private static final long serialVersionUID = 2645517179434741007L;

    private GenerationMatch(long val) {
      super(StorageRpc.Option.IF_GENERATION_MATCH, val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setIfGenerationMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setIfGenerationMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<ReadObjectRequest.Builder> readObject() {
      return b -> b.setIfGenerationMatch(val);
    }

    @Override
    public Mapper<BidiReadObjectRequest.Builder> bidiReadObject() {
      return b -> {
        b.getReadObjectSpecBuilder().setIfGenerationMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<GetObjectRequest.Builder> getObject() {
      return b -> b.setIfGenerationMatch(val);
    }

    @Override
    public Mapper<RestoreObjectRequest.Builder> restoreObject() {
      return b -> b.setIfGenerationMatch(val);
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return b -> b.setIfGenerationMatch(val);
    }

    @Override
    public Mapper<DeleteObjectRequest.Builder> deleteObject() {
      return b -> b.setIfGenerationMatch(val);
    }

    @Override
    public Mapper<ComposeObjectRequest.Builder> composeObject() {
      return b -> b.setIfGenerationMatch(val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setIfGenerationMatch(val);
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return b -> b.setIfGenerationMatch(val);
    }

    @Override
    public SourceGenerationMatch asSource() {
      return new SourceGenerationMatch(val);
    }
  }

  /**
   * @see GenerationMatch
   * @see SourceGenerationNotMatch
   */
  static final class GenerationNotMatch extends RpcOptVal<@NonNull Long>
      implements ObjectSourceOpt, ObjectTargetOpt, ProjectAsSource<SourceGenerationNotMatch> {
    private static final long serialVersionUID = 156505623580743531L;

    private GenerationNotMatch(long val) {
      super(StorageRpc.Option.IF_GENERATION_NOT_MATCH, val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setIfGenerationNotMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setIfGenerationNotMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<ReadObjectRequest.Builder> readObject() {
      return b -> b.setIfGenerationNotMatch(val);
    }

    @Override
    public Mapper<BidiReadObjectRequest.Builder> bidiReadObject() {
      return b -> {
        b.getReadObjectSpecBuilder().setIfGenerationNotMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<GetObjectRequest.Builder> getObject() {
      return b -> b.setIfGenerationNotMatch(val);
    }

    @Override
    public Mapper<RestoreObjectRequest.Builder> restoreObject() {
      return b -> b.setIfGenerationNotMatch(val);
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return b -> b.setIfGenerationNotMatch(val);
    }

    @Override
    public Mapper<DeleteObjectRequest.Builder> deleteObject() {
      return b -> b.setIfGenerationNotMatch(val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setIfGenerationNotMatch(val);
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return b -> b.setIfGenerationNotMatch(val);
    }

    @Override
    public SourceGenerationNotMatch asSource() {
      return new SourceGenerationNotMatch(val);
    }
  }

  static final class KmsKeyName extends RpcOptVal<String> implements ObjectTargetOpt {
    private static final long serialVersionUID = -3053839109272566113L;

    private KmsKeyName(String val) {
      super(StorageRpc.Option.KMS_KEY_NAME, val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().getResourceBuilder().setKmsKey(val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().getResourceBuilder().setKmsKey(val);
        return b;
      };
    }

    @Override
    public Mapper<ComposeObjectRequest.Builder> composeObject() {
      return b -> b.setKmsKey(val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setDestinationKmsKey(val);
    }
  }

  static final class MatchGlob extends RpcOptVal<String> implements ObjectListOpt {
    private static final long serialVersionUID = 8819855597395473178L;

    private MatchGlob(String val) {
      super(StorageRpc.Option.MATCH_GLOB, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setMatchGlobBytes(ByteString.copyFromUtf8(val));
    }
  }

  @Deprecated
  static final class Md5Match implements ObjectTargetOpt, HasherSelector {
    private static final long serialVersionUID = 5237207911268363887L;
    private final String val;

    private Md5Match(String val) {
      this.val = val;
    }

    @Override
    public Mapper<BlobInfo.Builder> blobInfo() {
      return b -> b.setMd5(val);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Md5Match)) {
        return false;
      }
      Md5Match md5Match = (Md5Match) o;
      return Objects.equals(val, md5Match.val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getObjectChecksumsBuilder()
            .setMd5Hash(ByteString.copyFrom(BaseEncoding.base64().decode(val)));
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getObjectChecksumsBuilder()
            .setMd5Hash(ByteString.copyFrom(BaseEncoding.base64().decode(val)));
        return b;
      };
    }

    @Override
    public Hasher getHasher() {
      return Hasher.noop();
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }

    @Override
    public String toString() {
      return "Md5Match{val='" + val + "'}";
    }
  }

  /**
   * @see MetagenerationNotMatch
   * @see SourceMetagenerationMatch
   */
  static final class MetagenerationMatch extends RpcOptVal<@NonNull Long>
      implements BucketSourceOpt,
          BucketTargetOpt,
          ObjectSourceOpt,
          ObjectTargetOpt,
          ProjectAsSource<SourceMetagenerationMatch> {
    private static final long serialVersionUID = 49086960234390739L;

    private MetagenerationMatch(long val) {
      super(StorageRpc.Option.IF_METAGENERATION_MATCH, val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setIfMetagenerationMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setIfMetagenerationMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<ReadObjectRequest.Builder> readObject() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<BidiReadObjectRequest.Builder> bidiReadObject() {
      return b -> {
        b.getReadObjectSpecBuilder().setIfMetagenerationMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<GetObjectRequest.Builder> getObject() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<RestoreObjectRequest.Builder> restoreObject() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<DeleteObjectRequest.Builder> deleteObject() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<ComposeObjectRequest.Builder> composeObject() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<UpdateBucketRequest.Builder> updateBucket() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<DeleteBucketRequest.Builder> deleteBucket() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<GetBucketRequest.Builder> getBucket() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public Mapper<LockBucketRetentionPolicyRequest.Builder> lockBucketRetentionPolicy() {
      return b -> b.setIfMetagenerationMatch(val);
    }

    @Override
    public SourceMetagenerationMatch asSource() {
      return new SourceMetagenerationMatch(val);
    }
  }

  /**
   * @see MetagenerationMatch
   * @see SourceMetagenerationNotMatch
   */
  static final class MetagenerationNotMatch extends RpcOptVal<@NonNull Long>
      implements BucketSourceOpt,
          BucketTargetOpt,
          ObjectSourceOpt,
          ObjectTargetOpt,
          ProjectAsSource<SourceMetagenerationNotMatch> {
    private static final long serialVersionUID = -1795350187419586248L;

    private MetagenerationNotMatch(long val) {
      super(StorageRpc.Option.IF_METAGENERATION_NOT_MATCH, val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setIfMetagenerationNotMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setIfMetagenerationNotMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<ReadObjectRequest.Builder> readObject() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<BidiReadObjectRequest.Builder> bidiReadObject() {
      return b -> {
        b.getReadObjectSpecBuilder().setIfMetagenerationNotMatch(val);
        return b;
      };
    }

    @Override
    public Mapper<GetObjectRequest.Builder> getObject() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<RestoreObjectRequest.Builder> restoreObject() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<DeleteObjectRequest.Builder> deleteObject() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<UpdateBucketRequest.Builder> updateBucket() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<DeleteBucketRequest.Builder> deleteBucket() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<GetBucketRequest.Builder> getBucket() {
      return b -> b.setIfMetagenerationNotMatch(val);
    }

    @Override
    public SourceMetagenerationNotMatch asSource() {
      return new SourceMetagenerationNotMatch(val);
    }
  }

  static final class PageSize extends RpcOptVal<@NonNull Long>
      implements BucketListOpt, ObjectListOpt, HmacKeyListOpt {
    private static final long serialVersionUID = -8184518840397826601L;

    private PageSize(long val) {
      super(StorageRpc.Option.MAX_RESULTS, val);
    }

    @Override
    public Mapper<ListBucketsRequest.Builder> listBuckets() {
      return b -> b.setPageSize(Math.toIntExact(val));
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setPageSize(Math.toIntExact(val));
    }
  }

  static final class PageToken extends RpcOptVal<String>
      implements BucketListOpt, ObjectListOpt, HmacKeyListOpt {
    private static final long serialVersionUID = -1370658416509499177L;

    private PageToken(String val) {
      super(StorageRpc.Option.PAGE_TOKEN, val);
    }

    @Override
    public Mapper<ListBucketsRequest.Builder> listBuckets() {
      return b -> b.setPageToken(val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setPageToken(val);
    }
  }

  static final class ReturnPartialSuccess extends RpcOptVal<Boolean> implements BucketListOpt {
    private static final long serialVersionUID = -1370658416509499277L;

    private ReturnPartialSuccess(boolean val) {
      super(StorageRpc.Option.RETURN_PARTIAL_SUCCESS, val);
    }

    @Override
    public Mapper<ListBucketsRequest.Builder> listBuckets() {
      return b -> b.setReturnPartialSuccess(val);
    }
  }

  static final class PredefinedAcl extends RpcOptVal<String>
      implements BucketTargetOpt, ObjectTargetOpt {
    private static final long serialVersionUID = -1743736785228368741L;

    private PredefinedAcl(String val) {
      super(StorageRpc.Option.PREDEFINED_ACL, val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setPredefinedAcl(val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().setPredefinedAcl(val);
        return b;
      };
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return b -> b.setPredefinedAcl(val);
    }

    @Override
    public Mapper<ComposeObjectRequest.Builder> composeObject() {
      return b -> b.setDestinationPredefinedAcl(val);
    }

    @Override
    public Mapper<UpdateBucketRequest.Builder> updateBucket() {
      return b -> b.setPredefinedAcl(val);
    }

    @Override
    public Mapper<CreateBucketRequest.Builder> createBucket() {
      return b -> b.setPredefinedAcl(val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setDestinationPredefinedAcl(val);
    }
  }

  static final class PredefinedDefaultObjectAcl extends RpcOptVal<String>
      implements BucketTargetOpt {
    private static final long serialVersionUID = -1771832790114963130L;

    private PredefinedDefaultObjectAcl(String val) {
      super(StorageRpc.Option.PREDEFINED_DEFAULT_OBJECT_ACL, val);
    }

    @Override
    public Mapper<CreateBucketRequest.Builder> createBucket() {
      return b -> b.setPredefinedDefaultObjectAcl(val);
    }

    @Override
    public Mapper<UpdateBucketRequest.Builder> updateBucket() {
      return b -> b.setPredefinedDefaultObjectAcl(val);
    }
  }

  static final class EnableObjectRetention extends RpcOptVal<Boolean> implements BucketTargetOpt {
    private static final long serialVersionUID = -2581147719605551578L;

    private EnableObjectRetention(boolean val) {
      super(StorageRpc.Option.ENABLE_OBJECT_RETENTION, val);
    }

    @Override
    public Mapper<UpdateBucketRequest.Builder> updateBucket() {
      return CrossTransportUtils.throwHttpJsonOnly(
          Storage.BucketTargetOption.class, "enableObjectRetention(boolean)");
    }
  }

  static final class Prefix extends RpcOptVal<String> implements BucketListOpt, ObjectListOpt {
    private static final long serialVersionUID = -3973478772547687371L;

    private Prefix(String val) {
      super(StorageRpc.Option.PREFIX, val);
    }

    @Override
    public Mapper<ListBucketsRequest.Builder> listBuckets() {
      return b -> b.setPrefix(val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setPrefix(val);
    }
  }

  /**
   * This is a required property of hmac related operations. Preferably, we'd be able to push the
   * defaulting to the creation of a new instance of one of the model objects
   */
  @Deprecated
  static final class ProjectId extends RpcOptVal<String>
      implements HmacKeySourceOpt, HmacKeyTargetOpt, HmacKeyListOpt, BucketListOpt {
    private static final long serialVersionUID = 6273807286378420321L;

    private ProjectId(String val) {
      super(StorageRpc.Option.PROJECT_ID, val);
    }

    @Override
    public Mapper<ListBucketsRequest.Builder> listBuckets() {
      return b -> b.setParent(projectNameCodec.encode(val));
    }
  }

  static final class Projection extends RpcOptVal<String> implements BucketTargetOpt {
    private static final long serialVersionUID = -7394684784418942133L;

    private Projection(String val) {
      super(StorageRpc.Option.PROJECTION, val);
    }
  }

  /**
   * @see GenerationMatch
   * @see SourceGenerationNotMatch
   */
  static final class SourceGenerationMatch extends RpcOptVal<@NonNull Long>
      implements ObjectSourceOpt, ObjectTargetOpt {
    private static final long serialVersionUID = -4074703368515265616L;

    private SourceGenerationMatch(@NonNull Long val) {
      super(StorageRpc.Option.IF_SOURCE_GENERATION_MATCH, val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setIfSourceGenerationMatch(val);
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return b -> b.setIfSourceGenerationMatch(val);
    }
  }

  /**
   * @see GenerationNotMatch
   * @see SourceGenerationMatch
   */
  static final class SourceGenerationNotMatch extends RpcOptVal<@NonNull Long>
      implements ObjectSourceOpt, ObjectTargetOpt {
    private static final long serialVersionUID = -5232032184462880657L;

    private SourceGenerationNotMatch(@NonNull Long val) {
      super(StorageRpc.Option.IF_SOURCE_GENERATION_NOT_MATCH, val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setIfSourceGenerationNotMatch(val);
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return b -> b.setIfSourceGenerationNotMatch(val);
    }
  }

  /**
   * @see MetagenerationMatch
   * @see SourceMetagenerationNotMatch
   */
  static final class SourceMetagenerationMatch extends RpcOptVal<@NonNull Long>
      implements BucketSourceOpt, BucketTargetOpt, ObjectSourceOpt, ObjectTargetOpt {
    private static final long serialVersionUID = 5223360761780436495L;

    private SourceMetagenerationMatch(@NonNull Long val) {
      super(StorageRpc.Option.IF_SOURCE_METAGENERATION_MATCH, val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setIfSourceMetagenerationMatch(val);
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return b -> b.setIfSourceMetagenerationMatch(val);
    }
  }

  /**
   * @see MetagenerationNotMatch
   * @see SourceMetagenerationMatch
   */
  static final class SourceMetagenerationNotMatch extends RpcOptVal<@NonNull Long>
      implements BucketSourceOpt, BucketTargetOpt, ObjectSourceOpt, ObjectTargetOpt {
    private static final long serialVersionUID = 2679308305890468285L;

    private SourceMetagenerationNotMatch(@NonNull Long val) {
      super(StorageRpc.Option.IF_SOURCE_METAGENERATION_NOT_MATCH, val);
    }

    @Override
    public Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return b -> b.setIfSourceMetagenerationNotMatch(val);
    }

    @Override
    public Mapper<MoveObjectRequest.Builder> moveObject() {
      return b -> b.setIfSourceMetagenerationNotMatch(val);
    }
  }

  static final class RequestedPolicyVersion extends RpcOptVal<@NonNull Long>
      implements BucketSourceOpt {
    private static final long serialVersionUID = -3606062322328656218L;

    private RequestedPolicyVersion(Long val) {
      super(StorageRpc.Option.REQUESTED_POLICY_VERSION, val);
    }

    @Override
    public Mapper<GetIamPolicyRequest.Builder> getIamPolicy() {
      return b -> {
        b.getOptionsBuilder().setRequestedPolicyVersion(Math.toIntExact(val));
        return b;
      };
    }
  }

  @Deprecated
  static final class ReturnRawInputStream extends RpcOptVal<@NonNull Boolean>
      implements ObjectSourceOpt {
    private static final long serialVersionUID = -5741791424843430584L;

    private ReturnRawInputStream(boolean val) {
      super(StorageRpc.Option.RETURN_RAW_INPUT_STREAM, val);
    }
  }

  static final class ServiceAccount extends RpcOptVal<String> implements HmacKeyListOpt {
    private static final long serialVersionUID = 5617709092359745482L;

    private ServiceAccount(String val) {
      super(StorageRpc.Option.SERVICE_ACCOUNT_EMAIL, val);
    }
  }

  static final class SetContentType implements ObjectTargetOpt {
    private static final long serialVersionUID = -5715260463246857009L;
    private final String val;

    private SetContentType(String val) {
      this.val = val;
    }

    @Override
    public Mapper<BlobInfo.Builder> blobInfo() {
      return b -> b.setContentType(val);
    }

    @Override
    public Mapper<WriteObjectRequest.Builder> writeObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().getResourceBuilder().setContentType(val);
        return b;
      };
    }

    @Override
    public Mapper<BidiWriteObjectRequest.Builder> bidiWriteObject() {
      return b -> {
        b.getWriteObjectSpecBuilder().getResourceBuilder().setContentType(val);
        return b;
      };
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return b -> {
        b.getObjectBuilder().setContentType(val);
        return b;
      };
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof SetContentType)) {
        return false;
      }
      SetContentType that = (SetContentType) o;
      return Objects.equals(val, that.val);
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }

    @Override
    public String toString() {
      return "SetContentType{val='" + val + "'}";
    }
  }

  static final class OverrideUnlockedRetention extends RpcOptVal<Boolean>
      implements ObjectTargetOpt {

    private static final long serialVersionUID = -7764590745622588287L;

    private OverrideUnlockedRetention(boolean val) {
      super(StorageRpc.Option.OVERRIDE_UNLOCKED_RETENTION, val);
    }

    @Override
    public Mapper<UpdateObjectRequest.Builder> updateObject() {
      return CrossTransportUtils.throwHttpJsonOnly(
          Storage.BlobTargetOption.class, "overrideUnlockedRetention(boolean)");
    }
  }

  static final class ResumableUploadExpectedObjectSize extends RpcOptVal<@NonNull Long>
      implements ObjectTargetOpt {
    private static final long serialVersionUID = 3640126281492196357L;

    private ResumableUploadExpectedObjectSize(@NonNull Long val) {
      super(StorageRpc.Option.X_UPLOAD_CONTENT_LENGTH, val);
    }

    @Override
    public Mapper<StartResumableWriteRequest.Builder> startResumableWrite() {
      return b -> {
        if (val > 0) {
          b.getWriteObjectSpecBuilder().setObjectSize(val);
        }
        return b;
      };
    }
  }

  static final class ShowDeletedKeys extends RpcOptVal<@NonNull Boolean> implements HmacKeyListOpt {
    private static final long serialVersionUID = -6604176744362903487L;

    private ShowDeletedKeys(boolean val) {
      super(StorageRpc.Option.SHOW_DELETED_KEYS, val);
    }
  }

  /**
   * @see EndOffset
   */
  static final class StartOffset extends RpcOptVal<String> implements ObjectListOpt {
    private static final long serialVersionUID = -1459727336598737833L;

    private StartOffset(String val) {
      super(StorageRpc.Option.START_OFF_SET, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setLexicographicStart(val);
    }
  }

  interface BucketObjectHmacKeyAllOpt
      extends BucketSourceOpt,
          BucketTargetOpt,
          BucketListOpt,
          ObjectSourceOpt,
          ObjectTargetOpt,
          ObjectListOpt,
          HmacKeySourceOpt,
          HmacKeyTargetOpt,
          HmacKeyListOpt {
    @Override
    default Mapper<RewriteObjectRequest.Builder> rewriteObject() {
      return Mapper.identity();
    }

    @Override
    default Mapper<MoveObjectRequest.Builder> moveObject() {
      return Mapper.identity();
    }
  }

  static final class UserProject extends RpcOptVal<String> implements BucketObjectHmacKeyAllOpt {
    private static final long serialVersionUID = 3962499996741180460L;

    private UserProject(String val) {
      super(StorageRpc.Option.USER_PROJECT, val);
    }

    @Override
    public Mapper<GrpcCallContext> getGrpcMetadataMapper() {
      return ctx ->
          ctx.withExtraHeaders(ImmutableMap.of("X-Goog-User-Project", ImmutableList.of(val)));
    }
  }

  static final class Headers extends RpcOptVal<ImmutableMap<String, String>>
      implements BucketObjectHmacKeyAllOpt {

    /**
     * The set of header names which are blocked from being able to be provided for an instance of
     * this class.
     *
     * <p>Most values here are from <a
     * href="https://cloud.google.com/storage/docs/json_api/v1/parameters">the json api
     * parameters</a> list or general http headers our client otherwise sets during the course of
     * normal operation.
     */
    private static final Predicate<String> BLOCKLIST;

    static {
      ImmutableSet<String> fullHeaderNames =
          Stream.of(
                  "Accept-Encoding",
                  "Cache-Control",
                  "Connection",
                  "Content-ID",
                  "Content-Length",
                  "Content-Range",
                  "Content-Transfer-Encoding",
                  "Content-Type",
                  "Date",
                  "ETag",
                  "If-Match",
                  "If-None-Match",
                  "Keep-Alive",
                  "Range",
                  "TE",
                  "Trailer",
                  "Transfer-Encoding",
                  "User-Agent",
                  "X-Goog-Api-Client",
                  "X-Goog-Content-Length-Range",
                  "X-Goog-Copy-Source-Encryption-Algorithm",
                  "X-Goog-Copy-Source-Encryption-Key",
                  "X-Goog-Copy-Source-Encryption-Key-Sha256",
                  "X-Goog-Encryption-Algorithm",
                  "X-Goog-Encryption-Key",
                  "X-Goog-Encryption-Key-Sha256",
                  "X-Goog-Gcs-Idempotency-Token",
                  "X-Goog-Request-Params",
                  "X-Goog-User-Project",
                  "X-HTTP-Method-Override",
                  "X-Upload-Content-Length",
                  "X-Upload-Content-Type")
              .map(Utils::headerNameToLowerCase)
              .collect(ImmutableSet.toImmutableSet());

      ImmutableSet<String> prefixes =
          Stream.of("X-Goog-Meta-")
              .map(Utils::headerNameToLowerCase)
              .collect(ImmutableSet.toImmutableSet());

      BLOCKLIST =
          name -> {
            if (fullHeaderNames.contains(name)) {
              return true;
            }

            for (String prefix : prefixes) {
              if (name.startsWith(prefix)) {
                return true;
              }
            }
            return false;
          };
    }

    private Headers(ImmutableMap<String, String> val) {
      super(StorageRpc.Option.EXTRA_HEADERS, val);
    }

    @Override
    public Mapper<GrpcCallContext> getGrpcMetadataMapper() {
      return ctx -> {
        if (val.isEmpty()) {
          return ctx;
        }
        Set<String> existingHeaderNames =
            ctx.getExtraHeaders().keySet().stream()
                .map(Utils::headerNameToLowerCase)
                .collect(Collectors.toSet());
        Map<String, List<String>> wrapped = new HashMap<>();
        for (Entry<String, String> e : val.entrySet()) {
          String key = Utils.headerNameToLowerCase(e.getKey());
          if (existingHeaderNames.contains(key)) {
            continue;
          }
          wrapped.put(key, ImmutableList.of(e.getValue()));
        }
        return ctx.withExtraHeaders(wrapped);
      };
    }

    @SuppressWarnings("unchecked")
    @Override
    public Mapper<ImmutableMap.Builder<StorageRpc.Option, Object>> mapper() {
      return optionBuilder -> {
        if (val.isEmpty()) {
          return optionBuilder;
        }
        // not ideal, but ImmutableMap.Builder doesn't have any read methods so we can detect
        // collision before build time.
        ImmutableMap<StorageRpc.Option, Object> builtOptions = Utils.mapBuild(optionBuilder);
        ImmutableMap<String, String> tmp =
            (ImmutableMap<String, String>) builtOptions.get(StorageRpc.Option.EXTRA_HEADERS);
        if (tmp == null) {
          ImmutableMap.Builder<String, String> b = ImmutableMap.builder();
          for (Entry<String, String> e : val.entrySet()) {
            String key = Utils.headerNameToLowerCase(e.getKey());
            b.put(key, e.getValue());
          }
          optionBuilder.put(key, Utils.mapBuild(b));
          return optionBuilder;
        } else {
          ImmutableMap.Builder<StorageRpc.Option, Object> newOptionBuilder = ImmutableMap.builder();
          for (Entry<StorageRpc.Option, Object> e : builtOptions.entrySet()) {
            if (e.getKey() != key) {
              newOptionBuilder.put(e.getKey(), e.getValue());
            }
          }

          ImmutableMap.Builder<String, String> extraHeadersBuilder = ImmutableMap.builder();
          copyEntries(tmp, extraHeadersBuilder);
          newOptionBuilder.put(key, Utils.mapBuild(extraHeadersBuilder));
          return newOptionBuilder;
        }
      };
    }

    public Mapper<ImmutableMap<String, String>> extraHeadersMapper() {
      return map -> {
        if (val.isEmpty()) {
          return map;
        }
        ImmutableMap.Builder<String, String> b = ImmutableMap.builder();
        copyEntries(map, b);
        return Utils.mapBuild(b);
      };
    }

    private void copyEntries(
        ImmutableMap<String, String> map, ImmutableMap.Builder<String, String> b) {
      Set<String> existingHeaderNames =
          map.keySet().stream().map(Utils::headerNameToLowerCase).collect(Collectors.toSet());
      b.putAll(map);
      for (Entry<String, String> e : val.entrySet()) {
        String key = Utils.headerNameToLowerCase(e.getKey());
        if (!existingHeaderNames.contains(key)) {
          b.put(key, e.getValue());
        }
      }
    }
  }

  static final class VersionsFilter extends RpcOptVal<@NonNull Boolean> implements ObjectListOpt {
    private VersionsFilter(boolean val) {
      super(StorageRpc.Option.VERSIONS, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setVersions(val);
    }
  }

  /**
   * Attempt to extract a crc32c value from an Object. If no crc32c value is extracted the produced
   * Opt will be an effective no-op.
   *
   * @see Crc32cMatch
   * @deprecated Use {@link BlobInfo.Builder#setCrc32c(String)}
   */
  @Deprecated
  static final class Crc32cMatchExtractor implements ObjectOptExtractor<ObjectTargetOpt> {
    private static final Crc32cMatchExtractor INSTANCE = new Crc32cMatchExtractor();
    private static final long serialVersionUID = 7045998436157555676L;

    @Deprecated
    private Crc32cMatchExtractor() {}

    @Override
    public ObjectTargetOpt extractFromBlobInfo(BlobInfo info) {
      String crc32c = info.getCrc32c();
      if (crc32c != null) {
        return crc32cMatch(crc32c);
      } else {
        return NoOpObjectTargetOpt.INSTANCE;
      }
    }

    @Override
    public ObjectTargetOpt extractFromBlobId(BlobId id) {
      return NoOpObjectTargetOpt.INSTANCE;
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  /**
   * Attempt to determine the content type of an Object based on it's {@link BlobInfo#getName()}. If
   * no name value is extracted, or the value is not a known extension the content type will be
   * {@code application/octet-stream}
   *
   * @see SetContentType
   * @see URLConnection#getFileNameMap()
   * @see FileNameMap
   * @deprecated Use {@link BlobInfo.Builder#setContentType(String)}
   */
  @Deprecated
  static final class DetectContentType implements ObjectOptExtractor<ObjectTargetOpt> {
    @Deprecated private static final DetectContentType INSTANCE = new DetectContentType();
    private static final FileNameMap FILE_NAME_MAP = URLConnection.getFileNameMap();
    private static final long serialVersionUID = -1089120180148634090L;

    @Deprecated
    private DetectContentType() {}

    @Override
    public ObjectTargetOpt extractFromBlobInfo(BlobInfo info) {
      String contentType = info.getContentType();
      if (contentType != null && !contentType.isEmpty()) {
        return NoOpObjectTargetOpt.INSTANCE;
      }

      return detectForName(info.getName());
    }

    @Override
    public ObjectTargetOpt extractFromBlobId(BlobId id) {
      return detectForName(id.getName());
    }

    private ObjectTargetOpt detectForName(String name) {
      if (name != null) {
        String nameLower = Utils.headerNameToLowerCase(name);
        String contentTypeFor = FILE_NAME_MAP.getContentTypeFor(nameLower);
        if (contentTypeFor != null) {
          return new SetContentType(contentTypeFor);
        }
      }
      return new SetContentType("application/octet-stream");
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  /**
   * Attempt to extract a generation value from an Object. If no generation value is extracted an
   * {@link IllegalArgumentException} will be thrown.
   *
   * @see GenerationMatch
   * @deprecated Use {@link #generationMatch(long)}
   */
  @Deprecated
  static final class GenerationMatchExtractor implements ObjectOptExtractor<GenerationMatch> {
    private static final GenerationMatchExtractor INSTANCE = new GenerationMatchExtractor();
    private static final long serialVersionUID = -7211192249703566097L;

    @Deprecated
    private GenerationMatchExtractor() {}

    @Override
    public GenerationMatch extractFromBlobInfo(BlobInfo info) {
      Long generation = info.getGeneration();
      checkArgument(generation != null, "Option ifGenerationMatch is missing a value");
      return generationMatch(generation);
    }

    @Override
    public GenerationMatch extractFromBlobId(BlobId id) {
      Long generation = id.getGeneration();
      checkArgument(generation != null, "Option ifGenerationMatch is missing a value");
      return generationMatch(generation);
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  /**
   * Attempt to extract a generation value from an Object. If no generation value is extracted an
   * {@link IllegalArgumentException} will be thrown.
   *
   * @see GenerationNotMatch
   * @deprecated Use {@link #generationNotMatch(long)}
   */
  @Deprecated
  static final class GenerationNotMatchExtractor implements ObjectOptExtractor<GenerationNotMatch> {
    private static final GenerationNotMatchExtractor INSTANCE = new GenerationNotMatchExtractor();
    private static final long serialVersionUID = -107520114846569713L;

    @Deprecated
    private GenerationNotMatchExtractor() {}

    @Override
    public GenerationNotMatch extractFromBlobInfo(BlobInfo info) {
      Long generation = info.getGeneration();
      checkArgument(generation != null, "Option ifGenerationNotMatch is missing a value");
      return generationNotMatch(generation);
    }

    @Override
    public GenerationNotMatch extractFromBlobId(BlobId id) {
      Long generation = id.getGeneration();
      checkArgument(generation != null, "Option ifGenerationNotMatch is missing a value");
      return generationNotMatch(generation);
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  /**
   * Attempt to extract an md5 value from an Object. If no md5 value is extracted the produced Opt
   * will be an effective no-op.
   *
   * @see Md5Match
   * @deprecated Use {@link BlobInfo.Builder#setMd5(String)}
   */
  @Deprecated
  static final class Md5MatchExtractor implements ObjectOptExtractor<ObjectTargetOpt> {
    private static final Md5MatchExtractor INSTANCE = new Md5MatchExtractor();
    private static final long serialVersionUID = 8375506989224962531L;

    @Deprecated
    private Md5MatchExtractor() {}

    @Override
    public ObjectTargetOpt extractFromBlobInfo(BlobInfo info) {
      String md5 = info.getMd5();
      if (md5 != null) {
        return md5Match(md5);
      } else {
        return NoOpObjectTargetOpt.INSTANCE;
      }
    }

    @Override
    public ObjectTargetOpt extractFromBlobId(BlobId id) {
      return NoOpObjectTargetOpt.INSTANCE;
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  /**
   * Attempt to extract a metageneration value from a Bucket or Object. If no metageneration value
   * is extracted an {@link IllegalArgumentException} will be thrown.
   *
   * @see MetagenerationMatch
   * @deprecated Use {@link #metagenerationMatch(long)}
   */
  @Deprecated
  static final class MetagenerationMatchExtractor
      implements ObjectOptExtractor<ObjectTargetOpt>, BucketOptExtractor<MetagenerationMatch> {
    private static final MetagenerationMatchExtractor INSTANCE = new MetagenerationMatchExtractor();
    private static final long serialVersionUID = -4165372534008844973L;

    @Deprecated
    private MetagenerationMatchExtractor() {}

    @Override
    public MetagenerationMatch extractFromBlobInfo(BlobInfo info) {
      Long metageneration = info.getMetageneration();
      checkArgument(metageneration != null, "Option ifMetagenerationMatch is missing a value");
      return metagenerationMatch(metageneration);
    }

    @Override
    public ObjectTargetOpt extractFromBlobId(BlobId id) {
      return NoOpObjectTargetOpt.INSTANCE;
    }

    @Override
    public MetagenerationMatch extractFromBucketInfo(BucketInfo info) {
      Long metageneration = info.getMetageneration();
      checkArgument(metageneration != null, "Option ifMetagenerationMatch is missing a value");
      return metagenerationMatch(metageneration);
    }

    // Both parent interfaces define this method, we need to declare a dis-ambiguous one
    @Override
    public Mapper<GrpcCallContext> getGrpcMetadataMapper() {
      return Mapper.identity();
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  /**
   * Attempt to extract a metageneration value from a Bucket or Object. If no metageneration value
   * is extracted an {@link IllegalArgumentException} will be thrown.
   *
   * @see MetagenerationNotMatch
   * @deprecated Use {@link #metagenerationNotMatch(long)}
   */
  @Deprecated
  static final class MetagenerationNotMatchExtractor
      implements ObjectOptExtractor<ObjectTargetOpt>, BucketOptExtractor<MetagenerationNotMatch> {
    private static final MetagenerationNotMatchExtractor INSTANCE =
        new MetagenerationNotMatchExtractor();
    private static final long serialVersionUID = 6544628474151482319L;

    @Deprecated
    private MetagenerationNotMatchExtractor() {}

    @Override
    public MetagenerationNotMatch extractFromBlobInfo(BlobInfo info) {
      Long metageneration = info.getMetageneration();
      checkArgument(metageneration != null, "Option ifMetagenerationNotMatch is missing a value");
      return metagenerationNotMatch(metageneration);
    }

    @Override
    public ObjectTargetOpt extractFromBlobId(BlobId id) {
      return NoOpObjectTargetOpt.INSTANCE;
    }

    @Override
    public MetagenerationNotMatch extractFromBucketInfo(BucketInfo info) {
      Long metageneration = info.getMetageneration();
      checkArgument(metageneration != null, "Option ifMetagenerationNotMatch is missing a value");
      return metagenerationNotMatch(metageneration);
    }

    // Both parent interfaces define this method, we need to declare a dis-ambiguous one
    @Override
    public Mapper<GrpcCallContext> getGrpcMetadataMapper() {
      return Mapper.identity();
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  static final class ObjectFilter extends RpcOptVal<String> implements ObjectListOpt {
    private static final long serialVersionUID = -892748218491324843L;

    private ObjectFilter(String val) {
      super(StorageRpc.Option.OBJECT_FILTER, val);
    }

    @Override
    public Mapper<ListObjectsRequest.Builder> listObjects() {
      return b -> b.setFilter(val);
    }
  }

  /**
   * Internal only implementation of {@link ObjectTargetOpt} which is a No-op.
   *
   * <p>The instance of this class can be returned when a no-op is necessary.
   */
  @VisibleForTesting
  static final class NoOpObjectTargetOpt implements ObjectTargetOpt {
    @VisibleForTesting static final NoOpObjectTargetOpt INSTANCE = new NoOpObjectTargetOpt();
    private static final long serialVersionUID = -5356245440686012545L;

    private NoOpObjectTargetOpt() {}

    @Override
    public Mapper<GrpcCallContext> getGrpcMetadataMapper() {
      return Mapper.identity();
    }

    @Override
    public Mapper<BlobInfo.Builder> blobInfo() {
      return Mapper.identity();
    }

    /** prevent java serialization from using a new instance */
    private Object readResolve() {
      return INSTANCE;
    }
  }

  /**
   * A shim class used by {@link Option} to allow a common parent which isn't part of the public
   * api.
   *
   * <p>{@link Option} itself and all it's subclasses are now obsolete, and should be removed when
   * we're able to remove them from the public api.
   */
  @Deprecated
  abstract static class OptionShim<O extends Opt> implements Serializable {
    private static final long serialVersionUID = 3410752214075057852L;
    private final O opt;

    OptionShim(O opt) {
      this.opt = opt;
    }

    O getOpt() {
      return opt;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof OptionShim)) {
        return false;
      }
      OptionShim<?> that = (OptionShim<?>) o;
      return Objects.equals(opt, that.opt);
    }

    @Override
    public int hashCode() {
      return Objects.hash(opt);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + "{opt=" + opt + '}';
    }
  }

  /**
   * Base class for those {@link Opt}s which correspond to one or more {@link StorageRpc.Option}
   * keys.
   *
   * @param <T>
   */
  private abstract static class RpcOptVal<T> implements Opt {
    private static final long serialVersionUID = 9170283346051824148L;
    protected final StorageRpc.Option key;
    protected final T val;

    private RpcOptVal(StorageRpc.Option key, T val) {
      this.key = requireNonNull(key, "key must be non null");
      this.val = requireNonNull(val, "val must be non null");
    }

    public Mapper<ImmutableMap.Builder<StorageRpc.Option, Object>> mapper() {
      return b -> b.put(key, val);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof RpcOptVal)) {
        return false;
      }
      RpcOptVal<?> rpcOptVal = (RpcOptVal<?>) o;
      return Objects.equals(key, rpcOptVal.key) && Objects.equals(val, rpcOptVal.val);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, val);
    }

    @Override
    public String toString() {
      return this.getClass().getSimpleName() + "{key=" + key + ", val=" + val + '}';
    }
  }

  static final class DefaultHasherSelector implements HasherSelector, Opt {
    private static final DefaultHasherSelector INSTANCE = new DefaultHasherSelector();

    private DefaultHasherSelector() {}

    @Override
    public Hasher getHasher() {
      return Hasher.defaultHasher();
    }
  }

  /**
   * Internal "collection" class to represent a set of {@link Opt}s, and to provide useful
   * transformations to individual mappers or to resolve any extractors providing a new instance
   * without extractors.
   */
  @SuppressWarnings("unchecked")
  static final class Opts<T extends Opt> {

    private final ImmutableList<T> opts;

    private Opts(ImmutableList<T> opts) {
      this.opts = opts;
    }

    /**
     * Resolve any extractors relative to the provided {@link BlobInfo} and return a new instance.
     */
    Opts<T> resolveFrom(BlobInfo info) {
      ImmutableList<T> resolvedOpts =
          opts.stream()
              .map(
                  o -> {
                    if (o instanceof ObjectOptExtractor) {
                      ObjectOptExtractor<T> ex = (ObjectOptExtractor<T>) o;
                      return ex.extractFromBlobInfo(info);
                    } else {
                      return o;
                    }
                  })
              .collect(ImmutableList.toImmutableList());
      return new Opts<>(resolvedOpts);
    }

    /** Resolve any extractors relative to the provided {@link BlobId} and return a new instance. */
    Opts<T> resolveFrom(BlobId id) {
      ImmutableList<T> resolvedOpts =
          opts.stream()
              .map(
                  o -> {
                    if (o instanceof ObjectOptExtractor) {
                      ObjectOptExtractor<T> ex = (ObjectOptExtractor<T>) o;
                      return ex.extractFromBlobId(id);
                    } else {
                      return o;
                    }
                  })
              .collect(ImmutableList.toImmutableList());
      return new Opts<>(resolvedOpts);
    }

    /**
     * Resolve any extractors relative to the provided {@link BucketInfo} and return a new instance.
     */
    Opts<T> resolveFrom(BucketInfo info) {
      ImmutableList<T> resolvedOpts =
          opts.stream()
              .map(
                  o -> {
                    if (o instanceof BucketOptExtractor) {
                      BucketOptExtractor<T> ex = (BucketOptExtractor<T>) o;
                      return ex.extractFromBucketInfo(info);
                    } else {
                      return o;
                    }
                  })
              .collect(ImmutableList.toImmutableList());
      return new Opts<>(resolvedOpts);
    }

    Opts<T> projectAsSource() {
      ImmutableList<T> projectedOpts =
          opts.stream()
              .map(
                  o -> {
                    if (o instanceof ProjectAsSource) {
                      ProjectAsSource<T> p = (ProjectAsSource<T>) o;
                      return p.asSource();
                    } else {
                      return o;
                    }
                  })
              .collect(ImmutableList.toImmutableList());
      return new Opts<>(projectedOpts);
    }

    /**
     * Attempt to construct a {@link StorageRpc} compatible map of {@link StorageRpc.Option}.
     *
     * <p>Validation ensures an absence of duplicate keys, and mutually exclusive keys.
     */
    ImmutableMap<StorageRpc.Option, ?> getRpcOptions() {
      ImmutableMap.Builder<StorageRpc.Option, Object> builder =
          rpcOptionMapper().apply(ImmutableMap.builder());
      return Utils.mapBuild(builder);
    }

    @VisibleForTesting
    HasherSelector getHasherSelector() {
      HasherSelector search = defaultHasherSelector();
      Predicate<Opt> p = isInstanceOf(HasherSelector.class);
      for (T opt : opts) {
        if (p.test(opt)) {
          search = (HasherSelector) opt;
        }
      }
      return search;
    }

    Hasher getHasher() {
      return getHasherSelector().getHasher();
    }

    Mapper<GrpcCallContext> grpcMetadataMapper() {
      return fuseMappers(GrpcMetadataMapper.class, GrpcMetadataMapper::getGrpcMetadataMapper);
    }

    Mapper<CreateBucketRequest.Builder> createBucketsRequest() {
      return fuseMappers(BucketTargetOpt.class, BucketTargetOpt::createBucket);
    }

    Mapper<GetBucketRequest.Builder> getBucketsRequest() {
      return fuseMappers(BucketSourceOpt.class, BucketSourceOpt::getBucket);
    }

    Mapper<ListBucketsRequest.Builder> listBucketsRequest() {
      return fuseMappers(BucketListOpt.class, BucketListOpt::listBuckets);
    }

    Mapper<UpdateBucketRequest.Builder> updateBucketsRequest() {
      return fuseMappers(BucketTargetOpt.class, BucketTargetOpt::updateBucket);
    }

    Mapper<DeleteBucketRequest.Builder> deleteBucketsRequest() {
      return fuseMappers(BucketTargetOpt.class, BucketTargetOpt::deleteBucket);
    }

    Mapper<LockBucketRetentionPolicyRequest.Builder> lockBucketRetentionPolicyRequest() {
      return fuseMappers(BucketTargetOpt.class, BucketTargetOpt::lockBucketRetentionPolicy);
    }

    Mapper<WriteObjectRequest.Builder> writeObjectRequest() {
      return fuseMappers(ObjectTargetOpt.class, ObjectTargetOpt::writeObject);
    }

    Mapper<BidiWriteObjectRequest.Builder> bidiWriteObjectRequest() {
      return fuseMappers(ObjectTargetOpt.class, ObjectTargetOpt::bidiWriteObject);
    }

    Mapper<StartResumableWriteRequest.Builder> startResumableWriteRequest() {
      return fuseMappers(ObjectTargetOpt.class, ObjectTargetOpt::startResumableWrite);
    }

    Mapper<GetObjectRequest.Builder> getObjectsRequest() {
      return fuseMappers(ObjectSourceOpt.class, ObjectSourceOpt::getObject);
    }

    Mapper<RestoreObjectRequest.Builder> restoreObjectRequest() {
      return fuseMappers(ObjectSourceOpt.class, ObjectSourceOpt::restoreObject);
    }

    Mapper<ReadObjectRequest.Builder> readObjectRequest() {
      return fuseMappers(ObjectSourceOpt.class, ObjectSourceOpt::readObject);
    }

    Mapper<BidiReadObjectRequest.Builder> bidiReadObjectRequest() {
      return fuseMappers(ObjectSourceOpt.class, ObjectSourceOpt::bidiReadObject);
    }

    Mapper<ListObjectsRequest.Builder> listObjectsRequest() {
      return fuseMappers(ObjectListOpt.class, ObjectListOpt::listObjects);
    }

    Mapper<UpdateObjectRequest.Builder> updateObjectsRequest() {
      return fuseMappers(ObjectTargetOpt.class, ObjectTargetOpt::updateObject);
    }

    Mapper<DeleteObjectRequest.Builder> deleteObjectsRequest() {
      return fuseMappers(ObjectTargetOpt.class, ObjectTargetOpt::deleteObject);
    }

    Mapper<ComposeObjectRequest.Builder> composeObjectsRequest() {
      return fuseMappers(ObjectTargetOpt.class, ObjectTargetOpt::composeObject);
    }

    Mapper<RewriteObjectRequest.Builder> rewriteObjectsRequest() {
      return opts.stream()
          .filter(isInstanceOf(ObjectTargetOpt.class).or(isInstanceOf(ObjectSourceOpt.class)))
          .map(
              o -> {
                // TODO: Do we need to formalize this type of dual relationship with it's own
                // interface?
                if (o instanceof ObjectTargetOpt) {
                  ObjectTargetOpt oto = (ObjectTargetOpt) o;
                  return oto.rewriteObject();
                } else if (o instanceof ObjectSourceOpt) {
                  ObjectSourceOpt oso = (ObjectSourceOpt) o;
                  return oso.rewriteObject();
                } else {
                  // in practice this shouldn't happen because of the filter guard upstream
                  throw new IllegalStateException("Unexpected type: %s" + o.getClass());
                }
              })
          .reduce(Mapper.identity(), Mapper::andThen);
    }

    Mapper<MoveObjectRequest.Builder> moveObjectsRequest() {
      return opts.stream()
          .filter(isInstanceOf(ObjectTargetOpt.class).or(isInstanceOf(ObjectSourceOpt.class)))
          .map(
              o -> {
                // TODO: Do we need to formalize this type of dual relationship with it's own
                // interface?
                if (o instanceof ObjectTargetOpt) {
                  ObjectTargetOpt oto = (ObjectTargetOpt) o;
                  return oto.moveObject();
                } else if (o instanceof ObjectSourceOpt) {
                  ObjectSourceOpt oso = (ObjectSourceOpt) o;
                  return oso.moveObject();
                } else {
                  // in practice this shouldn't happen because of the filter guard upstream
                  throw new IllegalStateException("Unexpected type: %s" + o.getClass());
                }
              })
          .reduce(Mapper.identity(), Mapper::andThen);
    }

    Mapper<GetIamPolicyRequest.Builder> getIamPolicyRequest() {
      return fuseMappers(BucketSourceOpt.class, BucketSourceOpt::getIamPolicy);
    }

    Mapper<BlobInfo.Builder> blobInfoMapper() {
      return fuseMappers(ObjectTargetOpt.class, ObjectTargetOpt::blobInfo);
    }

    /**
     * Here for compatibility. This should NOT be an "Opt" instead an attribute of the channel
     * builder. When {@link ReturnRawInputStream} is removed, this method should be removed as well.
     *
     * @see
     *     GapicDownloadSessionBuilder.ReadableByteChannelSessionBuilder#setAutoGzipDecompression(boolean)
     */
    @Deprecated
    boolean autoGzipDecompression() {
      return filterTo(ReturnRawInputStream.class).findFirst().map(r -> r.val).orElse(true);
    }

    Decoder<BlobInfo, BlobInfo> clearBlobFields() {
      return filterTo(Fields.class)
          .findFirst()
          .map(Fields::clearUnselectedBlobFields)
          .orElse(Decoder.identity());
    }

    Decoder<Bucket, Bucket> clearBucketFields() {
      return filterTo(Fields.class)
          .findFirst()
          .map(Fields::clearUnselectedBucketFields)
          .orElse(Decoder.identity());
    }

    /**
     * Create a new instance of Opts<T> where {@code toPrepend} and {@code this}. If an {@link Opt}
     * type ({@code Class<T>}) is present in both {@code toPrepend} and {@code this}, the {@link
     * Opt} from {@code this} will take priority when applied via one of the produced mappers.
     */
    Opts<T> prepend(Opts<? extends T> toPrepend) {
      // inventory the Opt types already present in this
      Set<? extends Class<? extends Opt>> existingOptTypes =
          this.opts.stream().map(Opt::getClass).collect(Collectors.toSet());

      ImmutableList<T> list =
          Stream.of(
                  toPrepend.opts.stream()
                      // exclude those opt types which are already present in this
                      .filter(o -> !existingOptTypes.contains(o.getClass())),
                  this.opts.stream())
              .flatMap(x -> x)
              .collect(ImmutableList.toImmutableList());
      return new Opts<>(list);
    }

    /**
     * Create a new instance of {@code Opts<R>} consisting of those {@code Opt}s which are also an
     * {@code R}.
     *
     * <p>i.e. Given {@code Opts<ObjectTargetOpt>} produce {@code Opts<ObjectSourceOpt>}
     */
    <R extends Opt> Opts<R> constrainTo(Class<R> c) {
      return new Opts<>(filterTo(c).collect(ImmutableList.toImmutableList()));
    }

    Opts<T> filter(Predicate<T> p) {
      return new Opts<>(opts.stream().filter(p).collect(ImmutableList.toImmutableList()));
    }

    <R extends Opt> Opts<R> transformTo(Class<R> c) {
      return new Opts<>(
          opts.stream()
              .map(
                  o -> {
                    if (o instanceof ProjectAsSource) {
                      ProjectAsSource<?> projectAsSource = (ProjectAsSource<?>) o;
                      Opt asSource = projectAsSource.asSource();
                      if (c.isAssignableFrom(asSource.getClass())) {
                        return c.cast(asSource);
                      }
                    }
                    if (c.isAssignableFrom(o.getClass())) {
                      return c.cast(o);
                    } else {
                      return null;
                    }
                  })
              .filter(Objects::nonNull)
              .collect(ImmutableList.toImmutableList()));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Opts)) {
        return false;
      }
      Opts<?> opts1 = (Opts<?>) o;
      return Objects.equals(opts, opts1.opts);
    }

    @Override
    public int hashCode() {
      return Objects.hash(opts);
    }

    private Mapper<ImmutableMap.Builder<StorageRpc.Option, Object>> rpcOptionMapper() {
      return fuseMappers(RpcOptVal.class, RpcOptVal::mapper);
    }

    private <R extends Opt, O> Mapper<O> fuseMappers(Class<R> c, Function<R, Mapper<O>> f) {
      return filterTo(c).map(f).reduce(Mapper.identity(), Mapper::andThen);
    }

    @SuppressWarnings("unchecked")
    private <R extends Opt> Stream<R> filterTo(Class<R> c) {
      // TODO: figure out if there is need for an "isApplicableTo" predicate
      return opts.stream().filter(isInstanceOf(c)).map(x -> (R) x);
    }

    static <T extends Opt> Opts<T> from(T t) {
      return new Opts<>(ImmutableList.of(t));
    }

    static <T extends Opt> Opts<T> from(T... ts) {
      return new Opts<>(ImmutableList.copyOf(ts));
    }

    static <O extends Opt> Opts<O> empty() {
      return new Opts<>(ImmutableList.of());
    }

    /**
     * Given an array of OptionShim, extract the opt from each of them to construct a new instance
     * of {@link Opts}
     */
    static <O extends Opt, T extends OptionShim<O>> Opts<O> unwrap(T[] ts) {
      ImmutableList<O> collect =
          Arrays.stream(ts).map(OptionShim::getOpt).collect(ImmutableList.toImmutableList());
      return new Opts<>(collect);
    }

    /**
     * Given a collection of OptionShim, extract the opt from each of them to construct a new
     * instance of {@link Opts}
     */
    static <O extends Opt, T extends OptionShim<O>> Opts<O> unwrap(Collection<T> ts) {
      ImmutableList<O> collect =
          ts.stream().map(OptionShim::getOpt).collect(ImmutableList.toImmutableList());
      return new Opts<>(collect);
    }

    /** Create a predicate which is able to effectively perform an {@code instanceof} check */
    private static <T extends Opt, O extends Opt> Predicate<T> isInstanceOf(Class<O> c) {
      return t -> c.isAssignableFrom(t.getClass());
    }
  }

  /**
   * Interface which represents a field of some resource which is present in the storage api, and
   * which can be used for a {@link com.google.cloud.FieldSelector read_mask}.
   */
  interface NamedField extends Serializable {
    String getApiaryName();

    String getGrpcName();

    default NamedField stripPrefix() {
      if (this instanceof PrefixedNamedField) {
        PrefixedNamedField pnf = (PrefixedNamedField) this;
        return pnf.delegate;
      } else {
        return this;
      }
    }

    static NamedField prefixed(String prefix, NamedField delegate) {
      return new PrefixedNamedField(prefix, delegate);
    }

    static NamedField literal(String name) {
      return new LiteralNamedField(name);
    }

    static NamedField nested(NamedField parent, NamedField child) {
      return new NestedNamedField(parent, child);
    }

    static NamedField root(NamedField f) {
      if (f instanceof NestedNamedField) {
        NestedNamedField nested = (NestedNamedField) f;
        return root(nested.getParent());
      } else {
        return f;
      }
    }
  }

  private static CommonObjectRequestParams.Builder customerSuppliedKey(
      CommonObjectRequestParams.Builder b, Key key) {
    HashCode keySha256 = Hashing.sha256().hashBytes(key.getEncoded());
    return b.setEncryptionAlgorithm(key.getAlgorithm())
        .setEncryptionKeyBytes(ByteString.copyFrom(key.getEncoded()))
        .setEncryptionKeySha256Bytes(ByteString.copyFrom(keySha256.asBytes()));
  }

  private static final class PrefixedNamedField implements NamedField {
    private static long serialVersionUID = -4899304145424680141L;

    private final String prefix;
    private final NamedField delegate;

    private PrefixedNamedField(String prefix, NamedField delegate) {
      this.prefix = prefix;
      this.delegate = delegate;
    }

    @Override
    public String getApiaryName() {
      return prefix + delegate.getApiaryName();
    }

    @Override
    public String getGrpcName() {
      return prefix + delegate.getGrpcName();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof PrefixedNamedField)) {
        return false;
      }
      PrefixedNamedField that = (PrefixedNamedField) o;
      return Objects.equals(prefix, that.prefix) && Objects.equals(delegate, that.delegate);
    }

    @Override
    public int hashCode() {
      return Objects.hash(prefix, delegate);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("prefix", prefix)
          .add("delegate", delegate)
          .toString();
    }
  }

  private static final class LiteralNamedField implements NamedField {
    private static long serialVersionUID = 1422947423774466409L;

    private final String name;

    private LiteralNamedField(String name) {
      this.name = name;
    }

    @Override
    public String getApiaryName() {
      return name;
    }

    @Override
    public String getGrpcName() {
      return name;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof LiteralNamedField)) {
        return false;
      }
      LiteralNamedField that = (LiteralNamedField) o;
      return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("name", name).toString();
    }
  }

  static final class NestedNamedField implements NamedField {
    private static long serialVersionUID = -7623005572810688221L;
    private final NamedField parent;
    private final NamedField child;

    private NestedNamedField(NamedField parent, NamedField child) {
      this.parent = parent;
      this.child = child;
    }

    @Override
    public String getApiaryName() {
      return parent.getApiaryName() + "." + child.getApiaryName();
    }

    @Override
    public String getGrpcName() {
      return parent.getGrpcName() + "." + child.getGrpcName();
    }

    NamedField getParent() {
      return parent;
    }

    NamedField getChild() {
      return child;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof NestedNamedField)) {
        return false;
      }
      NestedNamedField that = (NestedNamedField) o;
      return Objects.equals(parent, that.parent) && Objects.equals(child, that.child);
    }

    @Override
    public int hashCode() {
      return Objects.hash(parent, child);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("parent", parent).add("child", child).toString();
    }
  }
}

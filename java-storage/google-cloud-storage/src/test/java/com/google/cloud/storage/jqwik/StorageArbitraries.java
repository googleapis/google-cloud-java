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

package com.google.cloud.storage.jqwik;

import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.ifNonNull;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.storage.v2.Bucket;
import com.google.storage.v2.Bucket.Billing;
import com.google.storage.v2.Bucket.Encryption;
import com.google.storage.v2.Bucket.Encryption.CustomerManagedEncryptionEnforcementConfig;
import com.google.storage.v2.Bucket.Encryption.CustomerSuppliedEncryptionEnforcementConfig;
import com.google.storage.v2.Bucket.Encryption.GoogleManagedEncryptionEnforcementConfig;
import com.google.storage.v2.Bucket.IpFilter;
import com.google.storage.v2.Bucket.IpFilter.PublicNetworkSource;
import com.google.storage.v2.Bucket.IpFilter.VpcNetworkSource;
import com.google.storage.v2.Bucket.Lifecycle.Rule.Condition;
import com.google.storage.v2.Bucket.Logging;
import com.google.storage.v2.Bucket.RetentionPolicy;
import com.google.storage.v2.Bucket.Versioning;
import com.google.storage.v2.Bucket.Website;
import com.google.storage.v2.BucketAccessControl;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.CustomerEncryption;
import com.google.storage.v2.ObjectAccessControl;
import com.google.storage.v2.ObjectChecksums;
import com.google.storage.v2.ObjectContexts;
import com.google.storage.v2.ObjectCustomContextPayload;
import com.google.storage.v2.Owner;
import com.google.storage.v2.ProjectName;
import com.google.storage.v2.ProjectTeam;
import com.google.type.Date;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Tuple;
import net.jqwik.api.arbitraries.CharacterArbitrary;
import net.jqwik.api.arbitraries.IntegerArbitrary;
import net.jqwik.api.arbitraries.ListArbitrary;
import net.jqwik.api.arbitraries.LongArbitrary;
import net.jqwik.api.arbitraries.StringArbitrary;
import net.jqwik.api.providers.TypeUsage;
import net.jqwik.time.api.DateTimes;
import net.jqwik.web.api.Web;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class StorageArbitraries {

  // Predefine some values for 128-bit integers.
  // These are used in generation of md5 values.
  private static final String hex_128_min = "80000000" + "00000000" + "00000000" + "00000000";
  private static final String hex_128_max = "7fffffff" + "ffffffff" + "ffffffff" + "ffffffff";
  // BigIntegers don't inherently have the sign-bit, so simulate it by calling .negate()
  private static final BigInteger _128_bit_min = new BigInteger(hex_128_min, 16).negate();
  private static final BigInteger _128_bit_max = new BigInteger(hex_128_max, 16);

  private StorageArbitraries() {}

  public static Arbitrary<Timestamp> timestamp() {
    return Combinators.combine(
            DateTimes.offsetDateTimes().offsetBetween(ZoneOffset.UTC, ZoneOffset.UTC),
            millisecondsAsNanos())
        .as(
            (odt, nanos) ->
                Timestamp.newBuilder().setSeconds(odt.toEpochSecond()).setNanos(nanos).build());
  }

  public static Arbitrary<com.google.protobuf.Duration> duration() {
    return Arbitraries.longs()
        .between(0, 315_576_000_000L)
        .map(seconds -> com.google.protobuf.Duration.newBuilder().setSeconds(seconds).build());
  }

  public static Arbitrary<Date> date() {
    return DateTimes.offsetDateTimes()
        .offsetBetween(ZoneOffset.UTC, ZoneOffset.UTC)
        .map(
            odt ->
                Date.newBuilder()
                    .setYear(odt.getYear())
                    .setMonth(odt.getMonthValue())
                    .setDay(odt.getDayOfMonth())
                    .build());
  }

  public static Arbitrary<Boolean> bool() {
    return Arbitraries.defaultFor(TypeUsage.of(Boolean.class));
  }

  public static LongArbitrary metageneration() {
    return Arbitraries.longs().greaterOrEqual(0);
  }

  public static LongArbitrary generation() {
    return Arbitraries.longs().greaterOrEqual(0);
  }

  public static StringArbitrary randomString() {
    return Arbitraries.strings().all().ofMinLength(1).ofMaxLength(1024);
  }

  public static CharacterArbitrary alnum() {
    return Arbitraries.chars().alpha().numeric();
  }

  public static StringArbitrary alphaString() {
    return Arbitraries.strings().alpha();
  }

  public static Arbitrary<ProjectID> projectID() {
    return Combinators.combine(
            // must start with a letter
            Arbitraries.chars().range('a', 'z'),
            // can only contain numbers, lowercase letters, and hyphens, and must be 6-30 chars
            Arbitraries.strings()
                .withCharRange('a', 'z')
                .numeric()
                .withChars('-')
                .ofMinLength(4)
                .ofMaxLength(28),
            // must not end with a hyphen
            Arbitraries.chars().range('a', 'z').numeric())
        .as((first, mid, last) -> new ProjectID(first + mid + last));
  }

  public static Arbitrary<ProjectNumber> projectNumber() {
    return Arbitraries.bigIntegers().greaterOrEqual(BigInteger.ONE).map(ProjectNumber::new);
  }

  public static Arbitrary<String> kmsKey() {
    return Arbitraries.of("kms-key1", "kms-key2").injectNull(0.75);
  }

  public static Buckets buckets() {
    return Buckets.INSTANCE;
  }

  public static AccessControl accessControl() {
    return AccessControl.INSTANCE;
  }

  public static Arbitrary<String> storageClass() {
    return Arbitraries.oneOf(storageClassWithoutEdgeCases(), Arbitraries.just(""))
        .edgeCases(config -> config.add(""));
  }

  public static Arbitrary<Owner> owner() {
    Arbitrary<String> entity = alphaString().ofMinLength(1).ofMaxLength(1024);
    return entity.map(e -> Owner.newBuilder().setEntity(e).build());
  }

  public static Arbitrary<String> etag() {
    return Arbitraries.strings()
        .ascii()
        .ofMinLength(0)
        .ofMaxLength(8)
        .edgeCases(config -> config.add(""));
  }

  /** Arbitrary of ipv4 and ipv6 cidr ranges */
  public static Arbitrary<String> cidr() {
    return Arbitraries.oneOf(cidrIpv4(), cidrIpv6());
  }

  public static Arbitrary<String> cidrIpv4() {
    return Arbitraries.of("182.0.2.0/24");
  }

  public static Arbitrary<String> cidrIpv6() {
    return Arbitraries.of("2001:db8::/32");
  }

  public static final class Buckets {
    private static final Buckets INSTANCE = new Buckets();

    private Buckets() {}

    /**
     * Generated bucket name based on the rules outlined in <a target="_blank"
     * href="https://cloud.google.com/storage/docs/naming-buckets#requirements">https://cloud.google.com/storage/docs/naming-buckets#requirements</a>
     */
    public Arbitrary<BucketName> name() {
      return Combinators.combine(
              Arbitraries.oneOf(
                  // projectID(), TODO: reinclude this once we support non-global scoped buckets
                  // Global buckets have prefix of projects/_
                  Arbitraries.of(new ProjectID("_"))),
              alnum(),
              alnum().with('-', '_').list().ofMinSize(1).ofMaxSize(61),
              alnum())
          .as(
              (p, first, mid, last) -> {
                final StringBuilder sb = new StringBuilder();
                sb.append(first);
                mid.forEach(sb::append);
                sb.append(last);
                return BucketName.of(p.get(), sb.toString());
              });
    }

    public Arbitrary<Bucket.Lifecycle.Rule.Action> action() {
      return Arbitraries.oneOf(
          Arbitraries.just(Bucket.Lifecycle.Rule.Action.newBuilder().setType("Delete").build()),
          storageClassWithoutEdgeCases()
              .map(
                  c ->
                      Bucket.Lifecycle.Rule.Action.newBuilder()
                          .setType("SetStorageClass")
                          .setStorageClass(c)
                          .build()));
    }

    public Arbitrary<Bucket.Lifecycle.Rule> rule() {
      IntegerArbitrary zeroThroughTen = Arbitraries.integers().between(0, 10);

      Arbitrary<Boolean> conditionIsLive = bool().injectNull(0.25);
      Arbitrary<Integer> conditionAgeDays = Arbitraries.integers().between(0, 100).injectNull(0.25);
      Arbitrary<Integer> conditionNumberOfNewVersions = zeroThroughTen.injectNull(0.25);
      Arbitrary<Date> conditionCreatedBeforeTime = date().injectNull(0.25);
      Arbitrary<Integer> conditionDaysSinceNoncurrentTime = zeroThroughTen.injectNull(0.25);
      Arbitrary<Date> conditionNoncurrentTime = date().injectNull(0.25);
      Arbitrary<Integer> conditionDaysSinceCustomTime = zeroThroughTen.injectNull(0.25);
      Arbitrary<Date> conditionCustomTime = date().injectNull(0.25);
      ListArbitrary<String> storageClassMatches =
          storageClassWithoutEdgeCases().list().uniqueElements();

      return Combinators.combine(
              action(),
              Combinators.combine(
                      conditionIsLive,
                      conditionAgeDays,
                      conditionNumberOfNewVersions,
                      conditionCreatedBeforeTime,
                      conditionDaysSinceNoncurrentTime,
                      conditionNoncurrentTime,
                      conditionDaysSinceCustomTime,
                      conditionCustomTime)
                  .as(Tuple::of),
              storageClassMatches)
          .as(
              (a, ct, s) -> {
                Condition.Builder b = Condition.newBuilder();
                ifNonNull(ct.get1(), b::setIsLive);
                ifNonNull(ct.get2(), b::setAgeDays);
                ifNonNull(ct.get3(), b::setNumNewerVersions);
                ifNonNull(ct.get4(), b::setCreatedBefore);
                ifNonNull(ct.get5(), b::setDaysSinceNoncurrentTime);
                ifNonNull(ct.get6(), b::setNoncurrentTimeBefore);
                ifNonNull(ct.get7(), b::setDaysSinceCustomTime);
                ifNonNull(ct.get8(), b::setCustomTimeBefore);
                b.addAllMatchesStorageClass(s);
                return Bucket.Lifecycle.Rule.newBuilder().setAction(a).setCondition(b).build();
              });
    }

    public Arbitrary<Bucket.Lifecycle> lifecycle() {
      return rule()
          .list()
          .ofMinSize(0)
          .ofMaxSize(1)
          .uniqueElements()
          .map((r) -> Bucket.Lifecycle.newBuilder().addAllRule(r).build());
    }

    public Arbitrary<Website> website() {
      // TODO: create a "URLEncodedString we can use here
      Arbitrary<String> indexPage =
          Arbitraries.strings().all().ofMinLength(1).ofMaxLength(25).injectNull(0.75);
      Arbitrary<String> notFoundPage =
          Arbitraries.strings().all().ofMinLength(1).ofMaxLength(25).injectNull(0.75);
      return Combinators.combine(indexPage, notFoundPage)
          .as(
              (i, n) -> {
                //noinspection ConstantConditions
                if (i == null && n == null) {
                  return null;
                } else {
                  Website.Builder b = Website.newBuilder();
                  ifNonNull(i, b::setMainPageSuffix);
                  ifNonNull(n, b::setNotFoundPage);
                  return b.build();
                }
              });
    }

    public Arbitrary<Bucket.Logging> logging() {
      Arbitrary<BucketName> loggingBucketName = name();
      Arbitrary<String> loggingPrefix =
          Arbitraries.strings()
              .all()
              .ofMinLength(0)
              .ofMaxLength(10)
              .injectNull(0.25)
              .edgeCases(config -> config.add(""));
      return Combinators.combine(loggingBucketName, loggingPrefix)
          .as(
              (b, p) -> {
                Logging.Builder bld = Logging.newBuilder();
                ifNonNull(p, bld::setLogObjectPrefix);
                ifNonNull(b, BucketName::toString, bld::setLogBucket);
                return bld.build();
              });
    }

    public ListArbitrary<Bucket.Cors> cors() {
      Arbitrary<Integer> maxAgeSeconds =
          Arbitraries.integers().between(0, OffsetDateTime.MAX.getSecond());
      ListArbitrary<String> methods =
          Arbitraries.of("GET", "DELETE", "UPDATE", "PATCH").list().uniqueElements();
      ListArbitrary<String> responseHeaders =
          Arbitraries.of("Content-Type", "Origin").list().uniqueElements();
      ListArbitrary<String> origins = Arbitraries.of("*", "google.com").list().uniqueElements();
      return Combinators.combine(methods, responseHeaders, origins, maxAgeSeconds)
          .as(
              (m, r, o, a) ->
                  Bucket.Cors.newBuilder()
                      .addAllMethod(m)
                      .addAllResponseHeader(r)
                      .addAllOrigin(o)
                      .setMaxAgeSeconds(a)
                      .build())
          .list()
          .ofMinSize(0)
          .ofMaxSize(10);
    }

    public Arbitrary<Bucket.Billing> billing() {
      return bool().map(b -> Billing.newBuilder().setRequesterPays(b).build());
    }

    public ListArbitrary<ObjectAccessControl> objectAccessControl() {
      return Combinators.combine(accessControl().entity(), accessControl().role(), etag())
          .as(
              (entity, role, etag) -> {
                ObjectAccessControl.Builder b = entity.newObjectBuilder();
                ifNonNull(role, b::setRole);
                ifNonNull(etag, b::setEtag);
                return b.build();
              })
          .list()
          .ofMinSize(0)
          .ofMaxSize(10);
    }

    public ListArbitrary<BucketAccessControl> bucketAccessControl() {
      return Combinators.combine(accessControl().entity(), accessControl().role(), etag())
          .as(
              (entity, role, etag) -> {
                BucketAccessControl.Builder b = entity.newBucketBuilder();
                ifNonNull(role, b::setRole);
                ifNonNull(etag, b::setEtag);
                return b.build();
              })
          .list()
          .ofMinSize(0)
          .ofMaxSize(10);
    }

    public Arbitrary<Bucket.IamConfig.UniformBucketLevelAccess> uniformBucketLevelAccess() {
      return Combinators.combine(bool(), timestamp())
          .as(
              (e, l) -> {
                Bucket.IamConfig.UniformBucketLevelAccess.Builder ublaBuilder =
                    Bucket.IamConfig.UniformBucketLevelAccess.newBuilder();
                ublaBuilder.setEnabled(e);
                if (e) {
                  ublaBuilder.setLockTime(l);
                }
                return ublaBuilder.build();
              });
    }

    public Arbitrary<Bucket.IamConfig> iamConfig() {
      Arbitrary<String> pap = Arbitraries.of("enforced", "inherited");
      return Combinators.combine(pap, uniformBucketLevelAccess())
          .as(
              (p, u) -> {
                Bucket.IamConfig.Builder iamConfigBuilder = Bucket.IamConfig.newBuilder();
                iamConfigBuilder.setUniformBucketLevelAccess(u);
                if (u.getEnabled()) {
                  iamConfigBuilder.setPublicAccessPrevention(p);
                }
                return iamConfigBuilder.build();
              });
    }

    public Arbitrary<Bucket.Encryption> encryption() {
      return Combinators.combine(
              Arbitraries.strings().all().ofMinLength(1).ofMaxLength(1024).injectNull(0.9),
              googleManagedEncryptionEnforcementConfig(),
              customerManagedEncryptionEnforcementConfig(),
              customerSuppliedEncryptionEnforcementConfig())
          .flatAs(
              (kmsKey, gmek, cmek, csek) -> {
                if (Stream.of(kmsKey, gmek, cmek, csek).allMatch(java.util.Objects::isNull)) {
                  return Arbitraries.just(null);
                }
                Encryption.Builder b = Encryption.newBuilder();
                ifNonNull(kmsKey, b::setDefaultKmsKey);
                ifNonNull(gmek, b::setGoogleManagedEncryptionEnforcementConfig);
                ifNonNull(cmek, b::setCustomerManagedEncryptionEnforcementConfig);
                ifNonNull(csek, b::setCustomerSuppliedEncryptionEnforcementConfig);
                return Arbitraries.just(b.build());
              });
    }

    public Arbitrary<Bucket.RetentionPolicy> retentionPolicy() {
      return Combinators.combine(bool(), duration().injectNull(0.25), timestamp())
          .as(
              (locked, duration, effectiveTime) -> {
                RetentionPolicy.Builder retentionBuilder = RetentionPolicy.newBuilder();
                ifNonNull(duration, retentionBuilder::setRetentionDuration);
                retentionBuilder.setIsLocked(locked);
                if (locked) {
                  retentionBuilder.setEffectiveTime(effectiveTime);
                }
                return retentionBuilder.build();
              });
    }

    public Arbitrary<Bucket.Versioning> versioning() {
      return bool().map(b -> Versioning.newBuilder().setEnabled(b).build());
    }

    public Arbitrary<String> rpo() {
      return Arbitraries.of("DEFAULT", "ASYNC_TURBO", "")
          .edgeCases(config -> config.add("")); // denote "" as an edge case
    }

    public Arbitrary<String> location() {
      return Arbitraries.of(
          "US", "US-CENTRAL1", "US-EAST1", "EUROPE-CENTRAL2", "SOUTHAMERICA-EAST1");
    }

    public Arbitrary<String> locationType() {
      return Arbitraries.of("region", "dual-region", "multi-region");
    }

    public Arbitrary<Map<String, String>> labels() {
      return objects().customMetadata();
    }

    public Arbitrary<IpFilter> ipFilter() {
      return Combinators.combine(
              Arbitraries.of("Enabled", "Disabled").injectNull(0.33), // mode
              publicNetworkSource(),
              vpcNetworkSource().list().ofMinSize(1).ofMaxSize(3).injectNull(0.5),
              bool().injectNull(0.5), // allow_cross_org_vpcs
              bool().injectNull(0.5) // allow_all_service_agent_access
              )
          .as(
              (mode, pns, vnss, allowCrossOrgVpcs, allowAllServiceAgentAccess) -> {
                IpFilter.Builder b = IpFilter.newBuilder();
                ifNonNull(mode, b::setMode);
                ifNonNull(pns, b::setPublicNetworkSource);
                ifNonNull(vnss, b::addAllVpcNetworkSources);
                ifNonNull(allowCrossOrgVpcs, b::setAllowCrossOrgVpcs);
                ifNonNull(allowAllServiceAgentAccess, b::setAllowAllServiceAgentAccess);
                return b.build();
              });
    }

    public Arbitrary<IpFilter.PublicNetworkSource> publicNetworkSource() {
      return Arbitraries.oneOf(cidr().list().ofMinSize(1).ofMaxSize(3).injectNull(0.5))
          .map(
              ranges -> {
                PublicNetworkSource.Builder b = PublicNetworkSource.newBuilder();
                ifNonNull(ranges, b::addAllAllowedIpCidrRanges);
                return b.build();
              });
    }

    public Arbitrary<IpFilter.VpcNetworkSource> vpcNetworkSource() {
      return Combinators.combine(
              networkResource().injectNull(0.25),
              cidr().list().ofMinSize(1).ofMaxSize(3).injectNull(0.5))
          .as(
              (network, ranges) -> {
                VpcNetworkSource.Builder b = VpcNetworkSource.newBuilder();
                ifNonNull(network, b::setNetwork);
                ifNonNull(ranges, b::addAllAllowedIpCidrRanges);
                return b.build();
              });
    }

    Arbitrary<String> networkResource() {
      return Combinators.combine(projectID(), networkName())
          .as(
              (projectId, networkName) ->
                  String.format(
                      Locale.US, "projects/%s/global/networks/%s", projectId, networkName));
    }

    Arbitrary<@Nullable String> networkName() {
      return Arbitraries.strings()
          .withCharRange('a', 'z')
          .numeric()
          .withChars('-')
          .ofMinLength(1)
          .ofMaxLength(10);
    }

    public Arbitrary<String> encryptionEnforcementRestrictionMode() {
      return Arbitraries.of("NotRestricted", "FullyRestricted", "NOT_YET_DEFINED");
    }

    public Arbitrary<String> encryptionEnforcementRestrictionModeWithoutEdgeCases() {
      return Arbitraries.of("NotRestricted", "FullyRestricted");
    }

    public Arbitrary<GoogleManagedEncryptionEnforcementConfig>
        googleManagedEncryptionEnforcementConfig() {
      return encryptionEnforcementRestrictionMode()
          .injectNull(0.9)
          .flatMap(
              mode -> {
                if (mode == null) {
                  return Arbitraries.just(null);
                }
                return StorageArbitraries.timestamp()
                    .injectNull(0.5)
                    .map(
                        time -> {
                          GoogleManagedEncryptionEnforcementConfig.Builder b =
                              GoogleManagedEncryptionEnforcementConfig.newBuilder();
                          ifNonNull(time, b::setEffectiveTime);
                          b.setRestrictionMode(mode);
                          return b.build();
                        });
              });
    }

    public Arbitrary<CustomerManagedEncryptionEnforcementConfig>
        customerManagedEncryptionEnforcementConfig() {
      return encryptionEnforcementRestrictionMode()
          .injectNull(0.9)
          .flatMap(
              mode -> {
                if (mode == null) {
                  return Arbitraries.just(null);
                }
                return StorageArbitraries.timestamp()
                    .injectNull(0.5)
                    .map(
                        time -> {
                          CustomerManagedEncryptionEnforcementConfig.Builder b =
                              CustomerManagedEncryptionEnforcementConfig.newBuilder();
                          ifNonNull(time, b::setEffectiveTime);
                          b.setRestrictionMode(mode);
                          return b.build();
                        });
              });
    }

    public Arbitrary<CustomerSuppliedEncryptionEnforcementConfig>
        customerSuppliedEncryptionEnforcementConfig() {
      return encryptionEnforcementRestrictionMode()
          .injectNull(0.9)
          .flatMap(
              mode -> {
                if (mode == null) {
                  return Arbitraries.just(null);
                }
                return StorageArbitraries.timestamp()
                    .injectNull(0.5)
                    .map(
                        time -> {
                          CustomerSuppliedEncryptionEnforcementConfig.Builder b =
                              CustomerSuppliedEncryptionEnforcementConfig.newBuilder();
                          ifNonNull(time, b::setEffectiveTime);
                          b.setRestrictionMode(mode);
                          return b.build();
                        });
              });
    }
  }

  public static final class ProjectID {

    private final String value;

    private ProjectID(String value) {
      this.value = value;
    }

    public String get() {
      return value;
    }

    public ProjectName toProjectName() {
      return ProjectName.of(value);
    }
  }

  public static final class ProjectNumber {

    private final BigInteger value;

    private ProjectNumber(BigInteger value) {
      this.value = value;
    }

    public BigInteger get() {
      return value;
    }

    public ProjectName toProjectName() {
      return ProjectName.of(value.toString());
    }
  }

  public static Objects objects() {
    return Objects.INSTANCE;
  }

  public static final class Objects {
    private static final Objects INSTANCE = new Objects();

    private Objects() {}

    /**
     * Generated object name based on the rules outlined in <a target="_blank"
     * href="https://cloud.google.com/storage/docs/naming-objects#objectnames">https://cloud.google.com/storage/docs/naming-objects#objectnames</a>
     */
    public Arbitrary<String> name() {
      return Arbitraries.strings()
          .all()
          .excludeChars('#', '[', ']', '*', '?')
          .excludeChars(enumerate(0x7f, 0x84))
          .excludeChars(enumerate(0x86, 0x9f))
          .ofMinLength(1)
          .ofMaxLength(1024)
          .filter(s -> !s.equals("."))
          .filter(s -> !s.equals(".."))
          .filter(s -> !s.startsWith(".well-known/acme-challenge/"));
    }

    public Arbitrary<ObjectChecksums> objectChecksums() {
      return Combinators.combine(
              Arbitraries.integers().greaterOrEqual(0).injectNull(0.25), // crc32c
              // md5s can be absent for composed objects, increase the nullness factor
              Arbitraries.bigIntegers().between(_128_bit_min, _128_bit_max).injectNull(0.55) // md5
              )
          .as(
              (crc32c, md5) -> {
                ObjectChecksums.Builder b = ObjectChecksums.newBuilder();
                ifNonNull(crc32c, b::setCrc32C);
                ifNonNull(md5, StorageArbitraries::md5ToByteString, b::setMd5Hash);
                return b.build();
              })
          // make sure we don't yield an empty value, while theoretically possible, it isn't
          // interesting from the standpoint of our tests, we explicitly need to test our handling
          // of no checksum value being specified
          .filter(oc -> oc.hasCrc32C() || !oc.getMd5Hash().isEmpty());
    }

    public Arbitrary<CustomerEncryption> customerEncryption() {
      return Combinators.combine(
              Arbitraries.strings().ofMinLength(1).ofMaxLength(1024),
              Arbitraries.strings()
                  .map(s -> Hashing.sha256().hashString(s, StandardCharsets.UTF_8).asBytes())
                  .map(ByteString::copyFrom))
          .as(
              (algorithm, key) ->
                  CustomerEncryption.newBuilder()
                      .setEncryptionAlgorithm(algorithm)
                      .setKeySha256Bytes(key)
                      .build());
    }

    /**
     * Custom metadata from <a target="_blank"
     * href="https://cloud.google.com/storage/docs/metadata">https://cloud.google.com/storage/docs/metadata</a>
     */
    public Arbitrary<Map<String, String>> customMetadata() {
      // TODO: are we going to need to care about non-url encoded characters?
      //   Not for grpc itself, but possibly for compatibility tests.
      return Arbitraries.maps(
              alphaString().ofMinLength(1).ofMaxLength(32),
              alphaString().ofMinLength(1).ofMaxLength(128))
          .ofMinSize(0)
          .ofMaxSize(15)
          .injectNull(0.5);
    }

    public ListArbitrary<ObjectAccessControl> objectAccessControl() {
      return buckets().objectAccessControl();
    }

    public Arbitrary<ObjectCustomContextPayload> objectCustomContextPayload() {
      return Combinators.combine(
              randomString().ofMinLength(1).ofMaxLength(128),
              timestamp().injectNull(0.5),
              timestamp().injectNull(0.5))
          .as(
              (value, createTime, updateTime) -> {
                ObjectCustomContextPayload.Builder builder =
                    ObjectCustomContextPayload.newBuilder().setValue(value);
                if (createTime != null) {
                  builder.setCreateTime(createTime);
                }
                if (updateTime != null) {
                  builder.setUpdateTime(updateTime);
                }
                return builder.build();
              });
    }

    public Arbitrary<ObjectContexts> objectContexts() {
      Arbitrary<String> key = alphaString().ofMinLength(1).ofMaxLength(32);
      Arbitrary<Map<String, ObjectCustomContextPayload>> customMap =
          Arbitraries.maps(key, objectCustomContextPayload()).ofMinSize(0).ofMaxSize(5);

      return customMap
          .map(c -> ObjectContexts.newBuilder().putAllCustom(c).build())
          .injectNull(0.5);
    }
  }

  public static HttpHeaders httpHeaders() {
    return HttpHeaders.INSTANCE;
  }

  /**
   * Fixed-key metadata from <a target="_blank"
   * href="https://cloud.google.com/storage/docs/metadata">https://cloud.google.com/storage/docs/metadata</a>
   */
  public static final class HttpHeaders {
    private static final HttpHeaders INSTANCE = new HttpHeaders();

    private HttpHeaders() {}

    public Arbitrary<String> cacheControl() {
      return Combinators.combine(
              Arbitraries.of("public", "private", "no-cache", "no-store"),
              // bound to 10K to ease exhaustion processing
              Arbitraries.integers().between(0, 10_000).injectNull(0.5),
              Arbitraries.of("no-transform").injectNull(0.5))
          .as(
              (visibility, maxAge, transform) -> {
                //noinspection ConstantConditions
                if (maxAge == null && transform == null) {
                  return visibility;
                } else {
                  //noinspection ConstantConditions
                  if (maxAge != null) {
                    return String.format(Locale.US, "%s, max-age=%d", visibility, maxAge);
                  } else if (transform != null) {
                    return String.format(Locale.US, "%s, %s", visibility, transform);
                  } else {
                    return String.format(
                        Locale.US, "%s, max-age=%d, %s", visibility, maxAge, transform);
                  }
                }
              });
    }

    public Arbitrary<String> contentDisposition() {
      return Arbitraries.of("inline", "attachment;filename=blob.bin").injectNull(0.75);
    }

    public Arbitrary<String> contentEncoding() {
      return Arbitraries.of("gzip").injectNull(0.5);
    }

    public Arbitrary<String> contentLanguage() {
      return Arbitraries.of("en", "es", "zh").injectNull(0.75);
    }

    public Arbitrary<String> contentType() {
      return Arbitraries.of(
              "text/plain",
              "application/json",
              "application/octet-stream",
              "application/x-www-form-urlencoded")
          .injectNull(0.33);
    }

    public Arbitrary<Timestamp> customTime() {
      return timestamp().injectNull(0.75);
    }
  }

  public static final class AccessControl {
    private static final AccessControl INSTANCE = new AccessControl();

    private AccessControl() {}

    public Arbitrary<String> id() {
      return Arbitraries.shorts().greaterOrEqual((short) 1).map(s -> Short.toString(s));
    }

    /**
     * <a target="_blank"
     * href="https://cloud.google.com/storage/docs/json_api/v1/objectAccessControls#resource">https://cloud.google.com/storage/docs/json_api/v1/objectAccessControls#resource</a>
     */
    public Arbitrary<String> role() {
      return Arbitraries.of("OWNER", "READER");
    }

    /**
     * <a target="_blank"
     * href="https://cloud.google.com/storage/docs/json_api/v1/objectAccessControls#resource">https://cloud.google.com/storage/docs/json_api/v1/objectAccessControls#resource</a>
     */
    public Arbitrary<String> team() {
      return Arbitraries.of("owner", "editors", "viewers");
    }

    public Arbitrary<AclEntity> entity() {
      return Arbitraries.oneOf(
          id().map(AclEntity::userId),
          Web.emails().map(AclEntity::user),
          id().map(AclEntity::groupId),
          Web.emails().map(AclEntity::group),
          Web.webDomains().map(AclEntity::domain),
          projectTeam().map(AclEntity::project),
          Arbitraries.just(new PredefinedEntity("allUsers")),
          Arbitraries.just(new PredefinedEntity("allAuthenticatedUsers")));
    }

    public Arbitrary<ProjectTeam> projectTeam() {
      return Combinators.combine(id(), team())
          .as(
              (projectNumber, team) ->
                  ProjectTeam.newBuilder().setProjectNumber(projectNumber).setTeam(team).build());
    }

    public abstract static class AclEntity {

      private AclEntity() {}

      abstract ObjectAccessControl.Builder newObjectBuilder();

      abstract BucketAccessControl.Builder newBucketBuilder();

      static EntityWithId userId(String id) {
        return new EntityWithId(id);
      }

      static EntityWithoutId user(String email) {
        return new EntityWithoutId(String.format(Locale.US, "user-%s", email));
      }

      static EntityWithId groupId(String id) {
        return new EntityWithId(id);
      }

      static EntityWithoutId group(String email) {
        return new EntityWithoutId(String.format(Locale.US, "group-%s", email));
      }

      static EntityWithoutId domain(String email) {
        return new EntityWithoutId(String.format(Locale.US, "domain-%s", email));
      }

      static EntityWithoutId project(ProjectTeam projectTeam) {
        return new EntityWithoutId(
            String.format(
                Locale.US, "project-%s-%s", projectTeam.getTeam(), projectTeam.getProjectNumber()));
      }
    }

    public static final class PredefinedEntity extends AclEntity {
      private final String name;

      private PredefinedEntity(String name) {
        this.name = name;
      }

      @Override
      ObjectAccessControl.Builder newObjectBuilder() {
        return ObjectAccessControl.newBuilder().setEntity(name);
      }

      @Override
      BucketAccessControl.Builder newBucketBuilder() {
        return BucketAccessControl.newBuilder().setEntity(name);
      }
    }

    public static final class EntityWithId extends AclEntity {
      private final String id;

      private EntityWithId(String id) {
        this.id = id;
      }

      @Override
      ObjectAccessControl.Builder newObjectBuilder() {
        return ObjectAccessControl.newBuilder().setId(id);
      }

      @Override
      BucketAccessControl.Builder newBucketBuilder() {
        return BucketAccessControl.newBuilder().setId(id);
      }
    }

    public static final class EntityWithoutId extends AclEntity {
      private final String entity;

      private EntityWithoutId(String entity) {
        this.entity = entity;
      }

      @Override
      ObjectAccessControl.Builder newObjectBuilder() {
        return ObjectAccessControl.newBuilder().setEntity(entity);
      }

      @Override
      BucketAccessControl.Builder newBucketBuilder() {
        return BucketAccessControl.newBuilder().setEntity(entity);
      }
    }
  }

  private static char[] enumerate(int lower, int upperInclusive) {
    checkArgument(lower <= upperInclusive, "lower <= upperInclusive");
    int length = upperInclusive - lower + 1;
    char[] chars = new char[length];
    for (int i = 0; i < length; i++) {
      chars[i] = (char) (i + lower);
    }
    return chars;
  }

  /**
   * gRPC has nanosecond level precision for timestamps, whereas JSON is limited to millisecond
   * precision due to limitations in {@link com.google.api.client.util.DateTime}.
   *
   * <p>Define an arbitrary, which will always produce a nanosecond value that is in the range of
   * milliseconds.
   */
  private static Arbitrary<Integer> millisecondsAsNanos() {
    return Arbitraries.integers().between(0, 999).map(i -> i * 1_000_000);
  }

  private static Arbitrary<String> storageClassWithoutEdgeCases() {
    return Arbitraries.of(
        "STANDARD",
        "NEARLINE",
        "COLDLINE",
        "ARCHIVE",
        "MULTI_REGIONAL",
        "REGIONAL",
        "DURABLE_REDUCED_AVAILABILITY");
  }

  private static ByteString md5ToByteString(BigInteger md5) {
    HashCode hashCode = Hashing.md5().hashBytes(md5.toByteArray());
    byte[] bytes = hashCode.asBytes();
    return ByteString.copyFrom(bytes);
  }
}

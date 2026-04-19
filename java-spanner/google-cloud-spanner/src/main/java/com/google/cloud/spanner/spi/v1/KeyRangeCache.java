/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.Range;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.Tablet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/** Cache for routing information used by location-aware routing. */
@InternalApi
public final class KeyRangeCache {
  private static final Predicate<String> NO_EXCLUDED_ENDPOINTS = address -> false;

  private static final Logger logger = Logger.getLogger(KeyRangeCache.class.getName());

  private static final int MAX_LOCAL_REPLICA_DISTANCE = 5;
  private static final int DEFAULT_MIN_ENTRIES_FOR_RANDOM_PICK = 1000;

  /** Determines how to handle ranges that span multiple splits. */
  public enum RangeMode {
    /** Consider it a cache miss if the whole range is not in a single split. */
    COVERING_SPLIT,
    /** If the range spans multiple splits, pick a random split when possible. */
    PICK_RANDOM
  }

  enum RouteFailureReason {
    NONE,
    MISSING_ROUTING_KEY,
    CACHE_MISS,
    ALL_EXCLUDED_OR_COOLDOWN,
    NO_READY_REPLICA,
    NO_MATCHING_REPLICA,
    NO_ROUTABLE_REPLICA
  }

  static final class RouteLookupResult {
    @javax.annotation.Nullable final ChannelEndpoint endpoint;
    @javax.annotation.Nullable final String targetEndpointLabel;
    final List<SkippedTabletDetail> skippedTabletDetails;
    final RouteFailureReason failureReason;
    @javax.annotation.Nullable final SelectionDetail selectionDetail;

    private RouteLookupResult(
        @javax.annotation.Nullable ChannelEndpoint endpoint,
        @javax.annotation.Nullable String targetEndpointLabel,
        List<SkippedTabletDetail> skippedTabletDetails,
        RouteFailureReason failureReason,
        @javax.annotation.Nullable SelectionDetail selectionDetail) {
      this.endpoint = endpoint;
      this.targetEndpointLabel = targetEndpointLabel;
      this.skippedTabletDetails = skippedTabletDetails;
      this.failureReason = failureReason;
      this.selectionDetail = selectionDetail;
    }

    static RouteLookupResult routed(
        ChannelEndpoint endpoint,
        String targetEndpointLabel,
        List<SkippedTabletDetail> skippedTabletDetails,
        @javax.annotation.Nullable SelectionDetail selectionDetail) {
      return new RouteLookupResult(
          endpoint,
          targetEndpointLabel,
          Collections.unmodifiableList(new ArrayList<>(skippedTabletDetails)),
          RouteFailureReason.NONE,
          selectionDetail);
    }

    static RouteLookupResult failed(
        RouteFailureReason failureReason, List<SkippedTabletDetail> skippedTabletDetails) {
      return new RouteLookupResult(
          null,
          null,
          Collections.unmodifiableList(new ArrayList<>(skippedTabletDetails)),
          failureReason,
          null);
    }
  }

  static final class SkippedTabletDetail {
    @javax.annotation.Nullable final String targetEndpointLabel;
    final String reason;

    private SkippedTabletDetail(
        @javax.annotation.Nullable String targetEndpointLabel, String reason) {
      this.targetEndpointLabel = targetEndpointLabel;
      this.reason = reason;
    }
  }

  static final class SelectionDetail {
    final String selectionReason;
    final long operationUid;
    final int eligibleCandidateCount;
    final int scoredCandidateCount;
    final double selectedScore;
    final double bestEligibleScore;
    final String alternativesSummary;

    private SelectionDetail(
        String selectionReason,
        long operationUid,
        int eligibleCandidateCount,
        int scoredCandidateCount,
        double selectedScore,
        double bestEligibleScore,
        String alternativesSummary) {
      this.selectionReason = selectionReason;
      this.operationUid = operationUid;
      this.eligibleCandidateCount = eligibleCandidateCount;
      this.scoredCandidateCount = scoredCandidateCount;
      this.selectedScore = selectedScore;
      this.bestEligibleScore = bestEligibleScore;
      this.alternativesSummary = alternativesSummary;
    }

    double scoreGap() {
      if (!Double.isFinite(selectedScore)
          || !Double.isFinite(bestEligibleScore)
          || selectedScore == Double.MAX_VALUE
          || bestEligibleScore == Double.MAX_VALUE) {
        return Double.NaN;
      }
      return selectedScore - bestEligibleScore;
    }
  }

  static String formatTargetEndpointLabel(String address, boolean isLeader) {
    if (address == null || address.isEmpty() || !isLeader) {
      return address;
    }
    return address + "-LEADER";
  }

  private final ChannelEndpointCache endpointCache;
  @javax.annotation.Nullable private final EndpointLifecycleManager lifecycleManager;
  private final NavigableMap<ByteString, CachedRange> ranges =
      new TreeMap<>(ByteString.unsignedLexicographicalComparator());
  private final Map<Long, CachedGroup> groups = new HashMap<>();
  private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
  private final Lock readLock = cacheLock.readLock();
  private final Lock writeLock = cacheLock.writeLock();
  private final AtomicLong accessCounter = new AtomicLong();
  private final ReplicaSelector replicaSelector = new PowerOfTwoReplicaSelector();

  private volatile boolean deterministicRandom = false;
  private volatile int minCacheEntriesForRandomPick = DEFAULT_MIN_ENTRIES_FOR_RANDOM_PICK;

  public KeyRangeCache(ChannelEndpointCache endpointCache) {
    this(endpointCache, null);
  }

  public KeyRangeCache(
      ChannelEndpointCache endpointCache,
      @javax.annotation.Nullable EndpointLifecycleManager lifecycleManager) {
    this.endpointCache = Objects.requireNonNull(endpointCache);
    this.lifecycleManager = lifecycleManager;
  }

  @VisibleForTesting
  void useDeterministicRandom() {
    deterministicRandom = true;
  }

  @VisibleForTesting
  void setMinCacheEntriesForRandomPick(int value) {
    minCacheEntriesForRandomPick = value;
  }

  @VisibleForTesting
  void recordReplicaLatency(long operationUid, String address, Duration latency) {
    EndpointLatencyRegistry.recordLatency(operationUid, address, latency);
  }

  @VisibleForTesting
  void recordReplicaError(long operationUid, String address) {
    EndpointLatencyRegistry.recordError(operationUid, address);
  }

  /** Applies cache updates. Tablets are processed inside group updates. */
  public void addRanges(CacheUpdate cacheUpdate) {
    List<CachedGroup> touchedGroups = new ArrayList<>();
    writeLock.lock();
    try {
      for (Group groupIn : cacheUpdate.getGroupList()) {
        touchedGroups.add(findOrInsertGroup(groupIn.getGroupUid()));
      }
    } finally {
      writeLock.unlock();
    }

    for (int i = 0; i < cacheUpdate.getGroupCount(); i++) {
      touchedGroups.get(i).update(cacheUpdate.getGroup(i));
    }

    try {
      writeLock.lock();
      try {
        for (Range rangeIn : cacheUpdate.getRangeList()) {
          replaceRangeIfNewer(rangeIn);
        }
      } finally {
        writeLock.unlock();
      }
    } finally {
      writeLock.lock();
      try {
        for (int i = touchedGroups.size() - 1; i >= 0; i--) {
          unref(touchedGroups.get(i));
        }
      } finally {
        writeLock.unlock();
      }
    }
  }

  /**
   * Fills routing hint and returns the server to use, or null if no routing decision can be made.
   */
  public ChannelEndpoint fillRoutingHint(
      boolean preferLeader,
      RangeMode rangeMode,
      DirectedReadOptions directedReadOptions,
      RoutingHint.Builder hintBuilder) {
    return fillRoutingHint(
        preferLeader, rangeMode, directedReadOptions, hintBuilder, NO_EXCLUDED_ENDPOINTS);
  }

  public ChannelEndpoint fillRoutingHint(
      boolean preferLeader,
      RangeMode rangeMode,
      DirectedReadOptions directedReadOptions,
      RoutingHint.Builder hintBuilder,
      Predicate<String> excludedEndpoints) {
    return lookupRoutingHint(
            preferLeader, rangeMode, directedReadOptions, hintBuilder, excludedEndpoints)
        .endpoint;
  }

  RouteLookupResult lookupRoutingHint(
      boolean preferLeader,
      RangeMode rangeMode,
      DirectedReadOptions directedReadOptions,
      RoutingHint.Builder hintBuilder,
      Predicate<String> excludedEndpoints) {
    List<SkippedTabletDetail> skippedTabletDetails = new ArrayList<>();
    ByteString key = hintBuilder.getKey();
    if (key.isEmpty()) {
      return RouteLookupResult.failed(RouteFailureReason.MISSING_ROUTING_KEY, skippedTabletDetails);
    }

    CachedRange targetRange;
    readLock.lock();
    try {
      targetRange = findRangeLocked(key, hintBuilder.getLimitKey(), rangeMode);
    } finally {
      readLock.unlock();
    }

    if (targetRange == null || targetRange.group == null) {
      return RouteLookupResult.failed(RouteFailureReason.CACHE_MISS, skippedTabletDetails);
    }

    hintBuilder.setGroupUid(targetRange.group.groupUid);
    hintBuilder.setSplitId(targetRange.splitId);
    hintBuilder.setKey(targetRange.startKey);
    hintBuilder.setLimitKey(targetRange.limitKey);

    return targetRange.group.lookupRoutingHint(
        preferLeader, directedReadOptions, hintBuilder, excludedEndpoints, skippedTabletDetails);
  }

  /** Returns all server addresses currently referenced by cached tablets. */
  Set<String> getActiveAddresses() {
    Set<String> addresses = new HashSet<>();
    readLock.lock();
    try {
      for (CachedGroup group : groups.values()) {
        GroupSnapshot snapshot = group.snapshot;
        for (TabletSnapshot tablet : snapshot.tablets) {
          if (!tablet.serverAddress.isEmpty()) {
            addresses.add(tablet.serverAddress);
          }
        }
      }
    } finally {
      readLock.unlock();
    }
    return addresses;
  }

  public void clear() {
    writeLock.lock();
    try {
      for (CachedRange range : ranges.values()) {
        unref(range.group);
      }
      ranges.clear();
      groups.clear();
    } finally {
      writeLock.unlock();
    }
  }

  public int size() {
    readLock.lock();
    try {
      return ranges.size();
    } finally {
      readLock.unlock();
    }
  }

  public void shrinkTo(int newSize) {
    writeLock.lock();
    try {
      if (newSize <= 0) {
        clear();
        return;
      }
      if (newSize >= ranges.size()) {
        return;
      }

      int numToShrink = ranges.size() - newSize;
      int numToSample = Math.min(numToShrink * 2, ranges.size());
      List<CachedRange> allRanges = new ArrayList<>(ranges.values());
      int[] sampleIndexes = sampleWithoutReplacement(allRanges.size(), numToSample);
      Arrays.sort(sampleIndexes);

      List<CachedRange> sampled = new ArrayList<>(numToSample);
      for (int index : sampleIndexes) {
        sampled.add(allRanges.get(index));
      }
      sampled.sort(Comparator.comparingLong(range -> range.lastAccess));

      for (int i = 0; i < numToShrink; i++) {
        CachedRange range = sampled.get(i);
        ranges.remove(range.limitKey);
        unref(range.group);
      }
    } finally {
      writeLock.unlock();
    }
  }

  public String debugString() {
    StringBuilder sb = new StringBuilder();
    readLock.lock();
    try {
      for (Map.Entry<ByteString, CachedRange> entry : ranges.entrySet()) {
        CachedRange cachedRange = entry.getValue();
        sb.append("Range[")
            .append(cachedRange.startKey.toStringUtf8())
            .append("-")
            .append(entry.getKey().toStringUtf8())
            .append("]: ")
            .append(cachedRange.debugString())
            .append("\n");
      }
      for (CachedGroup g : groups.values()) {
        sb.append(g.debugString()).append("\n");
      }
    } finally {
      readLock.unlock();
    }
    return sb.toString();
  }

  private long accessTimeNow() {
    return accessCounter.incrementAndGet();
  }

  private CachedRange findRangeLocked(ByteString key, ByteString limit, RangeMode mode) {
    Map.Entry<ByteString, CachedRange> entry = ranges.higherEntry(key);
    if (entry == null) {
      return null;
    }

    CachedRange firstRange = entry.getValue();
    boolean startInRange = compare(key, firstRange.startKey) >= 0;
    if (limit.isEmpty()) {
      if (startInRange) {
        firstRange.lastAccess = accessTimeNow();
        return firstRange;
      }
      return null;
    }

    boolean limitInRange = compare(limit, entry.getKey()) <= 0;
    if (startInRange && limitInRange) {
      firstRange.lastAccess = accessTimeNow();
      return firstRange;
    }
    if (mode == RangeMode.COVERING_SPLIT) {
      return null;
    }

    int total = 0;
    boolean foundGap = !startInRange;
    boolean hitEnd = false;
    Map.Entry<ByteString, CachedRange> sampled = entry;
    ByteString lastLimit = firstRange.startKey;

    Map.Entry<ByteString, CachedRange> current = entry;
    while (current != null) {
      CachedRange range = current.getValue();
      if (!lastLimit.equals(range.startKey)) {
        foundGap = true;
        if (compare(range.startKey, limit) >= 0) {
          break;
        }
      }
      total++;
      if (uniformRandom(total, key, limit, range.startKey) == 0) {
        sampled = current;
      }
      lastLimit = range.limitKey;
      if (compare(lastLimit, limit) >= 0 || total >= minCacheEntriesForRandomPick) {
        break;
      }
      Map.Entry<ByteString, CachedRange> next = ranges.higherEntry(current.getKey());
      if (next == null) {
        hitEnd = true;
        break;
      }
      current = next;
    }

    if (hitEnd) {
      foundGap = true;
    }

    if (!foundGap || total >= minCacheEntriesForRandomPick) {
      CachedRange selected = sampled.getValue();
      selected.lastAccess = accessTimeNow();
      return selected;
    }
    return null;
  }

  private int uniformRandom(int n, ByteString seed1, ByteString seed2, ByteString seed3) {
    if (deterministicRandom) {
      ByteString combined = seed1.concat(seed2).concat(seed3);
      int hash = Hashing.crc32c().hashBytes(combined.toByteArray()).asInt();
      long unsigned = Integer.toUnsignedLong(hash);
      return (int) (unsigned % n);
    }
    return ThreadLocalRandom.current().nextInt(n);
  }

  private int[] sampleWithoutReplacement(int populationSize, int sampleSize) {
    int[] indexes = IntStream.range(0, populationSize).toArray();
    for (int i = 0; i < sampleSize; i++) {
      int j = i + ThreadLocalRandom.current().nextInt(populationSize - i);
      int tmp = indexes[i];
      indexes[i] = indexes[j];
      indexes[j] = tmp;
    }
    return Arrays.copyOf(indexes, sampleSize);
  }

  private void replaceRangeIfNewer(Range rangeIn) {
    ByteString startKey = rangeIn.getStartKey();
    ByteString limitKey = rangeIn.getLimitKey();

    Map.Entry<ByteString, CachedRange> startEntry = ranges.higherEntry(startKey);
    if (startEntry == null || compare(startEntry.getValue().startKey, limitKey) >= 0) {
      CachedRange newRange =
          new CachedRange(
              startKey,
              limitKey,
              findAndRefGroup(rangeIn.getGroupUid()),
              rangeIn.getSplitId(),
              rangeIn.getGeneration(),
              accessTimeNow());
      ranges.put(limitKey, newRange);
      return;
    }

    List<CachedRange> overlapping = new ArrayList<>();
    for (Map.Entry<ByteString, CachedRange> entry = startEntry;
        entry != null && compare(entry.getValue().startKey, limitKey) < 0;
        entry = ranges.higherEntry(entry.getKey())) {
      CachedRange existing = entry.getValue();
      int genCompare = compare(rangeIn.getGeneration(), existing.generation);
      if (genCompare < 0
          || (genCompare == 0
              && startKey.equals(existing.startKey)
              && limitKey.equals(existing.limitKey))) {
        return;
      }
      overlapping.add(existing);
    }

    for (CachedRange range : overlapping) {
      ranges.remove(range.limitKey);
    }

    CachedRange first = overlapping.get(0);
    if (compare(first.startKey, startKey) < 0) {
      CachedRange head =
          new CachedRange(
              first.startKey,
              startKey,
              refGroup(first.group),
              first.splitId,
              first.generation,
              first.lastAccess);
      ranges.put(head.limitKey, head);
    }

    CachedRange newRange =
        new CachedRange(
            startKey,
            limitKey,
            findAndRefGroup(rangeIn.getGroupUid()),
            rangeIn.getSplitId(),
            rangeIn.getGeneration(),
            accessTimeNow());
    ranges.put(limitKey, newRange);

    CachedRange last = overlapping.get(overlapping.size() - 1);
    if (compare(last.limitKey, limitKey) > 0) {
      CachedRange tail =
          new CachedRange(
              limitKey,
              last.limitKey,
              refGroup(last.group),
              last.splitId,
              last.generation,
              last.lastAccess);
      ranges.put(tail.limitKey, tail);
    }

    for (CachedRange range : overlapping) {
      unref(range.group);
    }
  }

  private CachedGroup findAndRefGroup(long groupUid) {
    CachedGroup group = groups.get(groupUid);
    if (group != null) {
      group.refs++;
    }
    return group;
  }

  private CachedGroup findOrInsertGroup(long groupUid) {
    CachedGroup group = groups.get(groupUid);
    if (group == null) {
      group = new CachedGroup(groupUid);
      groups.put(groupUid, group);
    } else {
      group.refs++;
    }
    return group;
  }

  private CachedGroup refGroup(CachedGroup group) {
    if (group != null) {
      group.refs++;
    }
    return group;
  }

  private void unref(CachedGroup group) {
    if (group == null) {
      return;
    }
    if (--group.refs == 0) {
      groups.remove(group.groupUid);
    }
  }

  private int compare(ByteString left, ByteString right) {
    return ByteString.unsignedLexicographicalComparator().compare(left, right);
  }

  private static final GroupSnapshot EMPTY_GROUP_SNAPSHOT =
      new GroupSnapshot(ByteString.EMPTY, -1, Collections.<TabletSnapshot>emptyList());

  /** Immutable tablet metadata used by the read path without per-group locking. */
  private static final class TabletSnapshot {
    final long tabletUid;
    final ByteString incarnation;
    final String serverAddress;
    final int distance;
    final boolean skip;
    final Tablet.Role role;
    final String location;

    private TabletSnapshot(Tablet tabletIn) {
      this.tabletUid = tabletIn.getTabletUid();
      this.incarnation = tabletIn.getIncarnation();
      this.serverAddress = tabletIn.getServerAddress();
      this.distance = tabletIn.getDistance();
      this.skip = tabletIn.getSkip();
      this.role = tabletIn.getRole();
      this.location = tabletIn.getLocation();
    }

    boolean matches(DirectedReadOptions directedReadOptions) {
      switch (directedReadOptions.getReplicasCase()) {
        case INCLUDE_REPLICAS:
          for (DirectedReadOptions.ReplicaSelection rs :
              directedReadOptions.getIncludeReplicas().getReplicaSelectionsList()) {
            if (matches(rs)) {
              return true;
            }
          }
          return false;
        case EXCLUDE_REPLICAS:
          for (DirectedReadOptions.ReplicaSelection rs :
              directedReadOptions.getExcludeReplicas().getReplicaSelectionsList()) {
            if (matches(rs)) {
              return false;
            }
          }
          return true;
        case REPLICAS_NOT_SET:
        default:
          return distance <= MAX_LOCAL_REPLICA_DISTANCE;
      }
    }

    private boolean matches(DirectedReadOptions.ReplicaSelection selection) {
      if (!selection.getLocation().isEmpty() && !selection.getLocation().equals(location)) {
        return false;
      }
      switch (selection.getType()) {
        case READ_WRITE:
          return role == Tablet.Role.READ_WRITE || role == Tablet.Role.ROLE_UNSPECIFIED;
        case READ_ONLY:
          return role == Tablet.Role.READ_ONLY;
        default:
          return true;
      }
    }

    String debugString() {
      return tabletUid
          + ":"
          + serverAddress
          + "@"
          + incarnation
          + "(location="
          + location
          + ",role="
          + role
          + ",distance="
          + distance
          + (skip ? ",skip" : "")
          + ")";
    }
  }

  private static final class GroupSnapshot {
    final ByteString generation;
    final int leaderIndex;
    final List<TabletSnapshot> tablets;

    private GroupSnapshot(ByteString generation, int leaderIndex, List<TabletSnapshot> tablets) {
      this.generation = generation;
      this.leaderIndex = leaderIndex;
      this.tablets = Collections.unmodifiableList(new ArrayList<>(tablets));
    }

    boolean hasLeader() {
      return leaderIndex >= 0 && leaderIndex < tablets.size();
    }

    TabletSnapshot leader() {
      return tablets.get(leaderIndex);
    }
  }

  /** Represents a paxos group with its tablets. */
  private class CachedGroup {
    final long groupUid;
    volatile GroupSnapshot snapshot = EMPTY_GROUP_SNAPSHOT;
    int refs = 1;

    CachedGroup(long groupUid) {
      this.groupUid = groupUid;
    }

    void update(Group groupIn) {
      GroupSnapshot current = snapshot;
      ByteString generation = current.generation;
      int leaderIndex = current.leaderIndex;
      if (compare(groupIn.getGeneration(), generation) > 0) {
        generation = groupIn.getGeneration();
        if (groupIn.getLeaderIndex() >= 0 && groupIn.getLeaderIndex() < groupIn.getTabletsCount()) {
          leaderIndex = groupIn.getLeaderIndex();
        } else {
          leaderIndex = -1;
        }
      }

      List<TabletSnapshot> tablets = new ArrayList<>(groupIn.getTabletsCount());
      for (int t = 0; t < groupIn.getTabletsCount(); t++) {
        tablets.add(new TabletSnapshot(groupIn.getTablets(t)));
      }
      snapshot = new GroupSnapshot(generation, leaderIndex, tablets);
    }

    RouteLookupResult lookupRoutingHint(
        boolean preferLeader,
        DirectedReadOptions directedReadOptions,
        RoutingHint.Builder hintBuilder,
        Predicate<String> excludedEndpoints,
        List<SkippedTabletDetail> skippedTabletDetails) {
      GroupSnapshot snapshot = this.snapshot;
      Set<Long> skippedTabletUids = skippedTabletUids(hintBuilder);
      boolean hasDirectedReadOptions =
          directedReadOptions.getReplicasCase()
              != DirectedReadOptions.ReplicasCase.REPLICAS_NOT_SET;
      Map<String, ChannelEndpoint> resolvedEndpoints = new HashMap<>();
      SelectionStats selectionStats = new SelectionStats();

      TabletSnapshot selected =
          selectTablet(
              snapshot,
              preferLeader,
              hasDirectedReadOptions,
              hintBuilder,
              directedReadOptions,
              excludedEndpoints,
              skippedTabletUids,
              skippedTabletDetails,
              resolvedEndpoints,
              selectionStats);
      if (selected == null) {
        RouteFailureReason failureReason = selectionStats.toFailureReason();
        if (failureReason == RouteFailureReason.ALL_EXCLUDED_OR_COOLDOWN) {
          selected =
              selectRandomExcludedOrCoolingDownTablet(
                  snapshot, directedReadOptions, hintBuilder, resolvedEndpoints);
          if (selected != null) {
            recordKnownTransientFailures(
                snapshot,
                selected,
                directedReadOptions,
                hintBuilder,
                excludedEndpoints,
                skippedTabletUids,
                skippedTabletDetails,
                resolvedEndpoints);
            hintBuilder.setTabletUid(selected.tabletUid);
            return RouteLookupResult.routed(
                resolveEndpoint(selected, resolvedEndpoints),
                endpointLabel(snapshot, selected),
                skippedTabletDetails,
                selectionStats.selectionDetail);
          }
        }
        return RouteLookupResult.failed(failureReason, skippedTabletDetails);
      }
      recordKnownTransientFailures(
          snapshot,
          selected,
          directedReadOptions,
          hintBuilder,
          excludedEndpoints,
          skippedTabletUids,
          skippedTabletDetails,
          resolvedEndpoints);
      hintBuilder.setTabletUid(selected.tabletUid);
      return RouteLookupResult.routed(
          resolveEndpoint(selected, resolvedEndpoints),
          endpointLabel(snapshot, selected),
          skippedTabletDetails,
          selectionStats.selectionDetail);
    }

    private TabletSnapshot selectTablet(
        GroupSnapshot snapshot,
        boolean preferLeader,
        boolean hasDirectedReadOptions,
        RoutingHint.Builder hintBuilder,
        DirectedReadOptions directedReadOptions,
        Predicate<String> excludedEndpoints,
        Set<Long> skippedTabletUids,
        List<SkippedTabletDetail> skippedTabletDetails,
        Map<String, ChannelEndpoint> resolvedEndpoints,
        SelectionStats selectionStats) {
      if (!preferLeader) {
        return selectLatencyAwareTablet(
            snapshot,
            directedReadOptions,
            hintBuilder,
            excludedEndpoints,
            skippedTabletUids,
            skippedTabletDetails,
            resolvedEndpoints,
            selectionStats);
      }

      boolean checkedLeader = false;
      if (preferLeader
          && !hasDirectedReadOptions
          && snapshot.hasLeader()
          && snapshot.leader().distance <= MAX_LOCAL_REPLICA_DISTANCE) {
        checkedLeader = true;
        selectionStats.matchingReplicas++;
        if (!shouldSkip(
            snapshot,
            snapshot.leader(),
            hintBuilder,
            excludedEndpoints,
            skippedTabletUids,
            skippedTabletDetails,
            resolvedEndpoints,
            selectionStats)) {
          return snapshot.leader();
        }
      }
      for (int index = 0; index < snapshot.tablets.size(); index++) {
        if (checkedLeader && index == snapshot.leaderIndex) {
          continue;
        }
        TabletSnapshot tablet = snapshot.tablets.get(index);
        if (!tablet.matches(directedReadOptions)) {
          continue;
        }
        selectionStats.matchingReplicas++;
        if (shouldSkip(
            snapshot,
            tablet,
            hintBuilder,
            excludedEndpoints,
            skippedTabletUids,
            skippedTabletDetails,
            resolvedEndpoints,
            selectionStats)) {
          continue;
        }
        return tablet;
      }
      return null;
    }

    private TabletSnapshot selectLatencyAwareTablet(
        GroupSnapshot snapshot,
        DirectedReadOptions directedReadOptions,
        RoutingHint.Builder hintBuilder,
        Predicate<String> excludedEndpoints,
        Set<Long> skippedTabletUids,
        List<SkippedTabletDetail> skippedTabletDetails,
        Map<String, ChannelEndpoint> resolvedEndpoints,
        SelectionStats selectionStats) {
      long operationUid = hintBuilder.getOperationUid();
      List<TabletSnapshot> eligibleTablets = new ArrayList<>();
      List<ChannelEndpoint> eligibleEndpoints = new ArrayList<>();
      int scoredCandidates = 0;

      for (TabletSnapshot tablet : snapshot.tablets) {
        if (!tablet.matches(directedReadOptions)) {
          continue;
        }
        selectionStats.matchingReplicas++;
        if (shouldSkip(
            snapshot,
            tablet,
            hintBuilder,
            excludedEndpoints,
            skippedTabletUids,
            skippedTabletDetails,
            resolvedEndpoints,
            selectionStats)) {
          continue;
        }

        ChannelEndpoint endpoint = resolveEndpoint(tablet, resolvedEndpoints);
        if (endpoint == null) {
          continue;
        }
        eligibleTablets.add(tablet);
        eligibleEndpoints.add(endpoint);
        if (EndpointLatencyRegistry.hasScore(operationUid, tablet.serverAddress)) {
          scoredCandidates++;
        }
      }

      if (eligibleTablets.isEmpty()) {
        return null;
      }
      if (eligibleTablets.size() == 1) {
        TabletSnapshot selected = eligibleTablets.get(0);
        selectionStats.selectionDetail =
            buildSelectionDetail(
                snapshot,
                eligibleTablets,
                operationUid,
                "single_candidate",
                selected,
                scoredCandidates);
        return selected;
      }
      if (deterministicRandom) {
        TabletSnapshot selected =
            eligibleTablets.stream()
                .min(
                    Comparator.comparingDouble(
                        tablet ->
                            EndpointLatencyRegistry.getSelectionCost(
                                operationUid, tablet.serverAddress)))
                .orElse(eligibleTablets.get(0));
        selectionStats.selectionDetail =
            buildSelectionDetail(
                snapshot,
                eligibleTablets,
                operationUid,
                "latency_score",
                selected,
                scoredCandidates);
        return selected;
      }

      ChannelEndpoint selectedEndpoint =
          replicaSelector.select(
              eligibleEndpoints,
              endpoint ->
                  EndpointLatencyRegistry.getSelectionCost(operationUid, endpoint.getAddress()));
      if (selectedEndpoint == null) {
        TabletSnapshot selected = eligibleTablets.get(0);
        selectionStats.selectionDetail =
            buildSelectionDetail(
                snapshot,
                eligibleTablets,
                operationUid,
                "latency_score",
                selected,
                scoredCandidates);
        return selected;
      }
      for (int i = 0; i < eligibleTablets.size(); i++) {
        if (eligibleEndpoints.get(i) == selectedEndpoint) {
          TabletSnapshot selected = eligibleTablets.get(i);
          selectionStats.selectionDetail =
              buildSelectionDetail(
                  snapshot,
                  eligibleTablets,
                  operationUid,
                  "latency_score",
                  selected,
                  scoredCandidates);
          return selected;
        }
      }
      TabletSnapshot selected = eligibleTablets.get(0);
      selectionStats.selectionDetail =
          buildSelectionDetail(
              snapshot, eligibleTablets, operationUid, "latency_score", selected, scoredCandidates);
      return selected;
    }

    @javax.annotation.Nullable
    private TabletSnapshot selectRandomExcludedOrCoolingDownTablet(
        GroupSnapshot snapshot,
        DirectedReadOptions directedReadOptions,
        RoutingHint.Builder hintBuilder,
        Map<String, ChannelEndpoint> resolvedEndpoints) {
      List<TabletSnapshot> candidates = new ArrayList<>();
      for (TabletSnapshot tablet : snapshot.tablets) {
        if (!tablet.matches(directedReadOptions) || tablet.skip || tablet.serverAddress.isEmpty()) {
          continue;
        }
        ChannelEndpoint endpoint = resolveEndpoint(tablet, resolvedEndpoints);
        if (endpoint == null || !endpoint.isHealthy()) {
          continue;
        }
        candidates.add(tablet);
      }
      if (candidates.isEmpty()) {
        return null;
      }
      int index =
          uniformRandom(
              candidates.size(),
              hintBuilder.getKey(),
              hintBuilder.getLimitKey(),
              snapshot.generation);
      return candidates.get(index);
    }

    private void recordKnownTransientFailures(
        GroupSnapshot snapshot,
        TabletSnapshot selected,
        DirectedReadOptions directedReadOptions,
        RoutingHint.Builder hintBuilder,
        Predicate<String> excludedEndpoints,
        Set<Long> skippedTabletUids,
        List<SkippedTabletDetail> skippedTabletDetails,
        Map<String, ChannelEndpoint> resolvedEndpoints) {
      for (TabletSnapshot tablet : snapshot.tablets) {
        if (tablet == selected || !tablet.matches(directedReadOptions)) {
          continue;
        }
        recordKnownTransientFailure(
            snapshot,
            tablet,
            hintBuilder,
            excludedEndpoints,
            skippedTabletUids,
            skippedTabletDetails,
            resolvedEndpoints);
      }
    }

    private Set<Long> skippedTabletUids(RoutingHint.Builder hintBuilder) {
      Set<Long> skippedTabletUids = new HashSet<>();
      for (RoutingHint.SkippedTablet skippedTablet : hintBuilder.getSkippedTabletUidList()) {
        skippedTabletUids.add(skippedTablet.getTabletUid());
      }
      return skippedTabletUids;
    }

    private boolean shouldSkip(
        GroupSnapshot snapshot,
        TabletSnapshot tablet,
        RoutingHint.Builder hintBuilder,
        Predicate<String> excludedEndpoints,
        Set<Long> skippedTabletUids,
        List<SkippedTabletDetail> skippedTabletDetails,
        Map<String, ChannelEndpoint> resolvedEndpoints,
        SelectionStats selectionStats) {
      String targetEndpointLabel = endpointLabel(snapshot, tablet);
      if (tablet.skip) {
        selectionStats.tabletMarkedSkipCount++;
        addSkippedTablet(
            tablet,
            hintBuilder,
            skippedTabletUids,
            skippedTabletDetails,
            targetEndpointLabel,
            "tablet_marked_skip");
        return true;
      }
      if (tablet.serverAddress.isEmpty()) {
        selectionStats.missingAddressCount++;
        addSkippedTablet(
            tablet, hintBuilder, skippedTabletUids, skippedTabletDetails, null, "missing_address");
        return true;
      }
      if (excludedEndpoints.test(tablet.serverAddress)) {
        selectionStats.excludedCount++;
        return true;
      }

      ChannelEndpoint endpoint = resolveEndpoint(tablet, resolvedEndpoints);
      if (endpoint == null) {
        selectionStats.missingEndpointCount++;
        logger.log(
            Level.FINE,
            "Tablet {0} at {1}: no endpoint present, skipping silently",
            new Object[] {tablet.tabletUid, tablet.serverAddress});
        maybeAddRecentTransientFailureSkip(
            tablet, targetEndpointLabel, hintBuilder, skippedTabletUids, skippedTabletDetails);
        if (lifecycleManager != null) {
          lifecycleManager.requestEndpointRecreation(tablet.serverAddress);
        }
        return true;
      }
      if (endpoint.isHealthy()) {
        return false;
      }
      if (endpoint.isTransientFailure()) {
        selectionStats.transientFailureCount++;
        logger.log(
            Level.FINE,
            "Tablet {0} at {1}: endpoint in TRANSIENT_FAILURE, adding to skipped_tablets",
            new Object[] {tablet.tabletUid, tablet.serverAddress});
        addSkippedTablet(
            tablet,
            hintBuilder,
            skippedTabletUids,
            skippedTabletDetails,
            targetEndpointLabel,
            "transient_failure");
        return true;
      }

      selectionStats.notReadyCount++;
      logger.log(
          Level.FINE,
          "Tablet {0} at {1}: endpoint not ready, skipping silently",
          new Object[] {tablet.tabletUid, tablet.serverAddress});
      maybeAddRecentTransientFailureSkip(
          tablet, targetEndpointLabel, hintBuilder, skippedTabletUids, skippedTabletDetails);
      return true;
    }

    private final class SelectionStats {
      private int matchingReplicas;
      private int excludedCount;
      private int transientFailureCount;
      private int notReadyCount;
      private int missingEndpointCount;
      private int tabletMarkedSkipCount;
      private int missingAddressCount;
      @javax.annotation.Nullable private SelectionDetail selectionDetail;

      private RouteFailureReason toFailureReason() {
        if (matchingReplicas == 0) {
          return RouteFailureReason.NO_MATCHING_REPLICA;
        }
        if (excludedCount == matchingReplicas) {
          return RouteFailureReason.ALL_EXCLUDED_OR_COOLDOWN;
        }
        if (transientFailureCount > 0 || notReadyCount > 0 || missingEndpointCount > 0) {
          return RouteFailureReason.NO_READY_REPLICA;
        }
        if (tabletMarkedSkipCount > 0 || missingAddressCount > 0) {
          return RouteFailureReason.NO_ROUTABLE_REPLICA;
        }
        return RouteFailureReason.NO_ROUTABLE_REPLICA;
      }
    }

    private SelectionDetail buildSelectionDetail(
        GroupSnapshot snapshot,
        List<TabletSnapshot> eligibleTablets,
        long operationUid,
        String selectionReason,
        TabletSnapshot selected,
        int scoredCandidates) {
      double bestScore = Double.MAX_VALUE;
      for (TabletSnapshot tablet : eligibleTablets) {
        bestScore =
            Math.min(
                bestScore,
                EndpointLatencyRegistry.getSelectionCost(operationUid, tablet.serverAddress));
      }

      StringBuilder alternatives = new StringBuilder();
      int appended = 0;
      double selectedScore =
          EndpointLatencyRegistry.getSelectionCost(operationUid, selected.serverAddress);
      for (TabletSnapshot tablet : eligibleTablets) {
        if (tablet == selected || appended >= 4) {
          continue;
        }
        if (alternatives.length() > 0) {
          alternatives.append(", ");
        }
        double candidateScore =
            EndpointLatencyRegistry.getSelectionCost(operationUid, tablet.serverAddress);
        alternatives
            .append(endpointLabel(snapshot, tablet))
            .append("=")
            .append(formatScore(candidateScore))
            .append(":")
            .append(alternativeReason(candidateScore, selectedScore));
        appended++;
      }

      return new SelectionDetail(
          selectionReason,
          operationUid,
          eligibleTablets.size(),
          scoredCandidates,
          selectedScore,
          bestScore,
          alternatives.toString());
    }

    private String alternativeReason(double candidateScore, double selectedScore) {
      if (!Double.isFinite(candidateScore) || candidateScore == Double.MAX_VALUE) {
        return "unscored";
      }
      if (candidateScore < selectedScore) {
        return "not_sampled_by_policy";
      }
      if (candidateScore > selectedScore) {
        return "higher_score";
      }
      return "tie_not_selected";
    }

    private String formatScore(double score) {
      if (!Double.isFinite(score) || score == Double.MAX_VALUE) {
        return "unknown";
      }
      return Long.toString(Math.round(score));
    }

    private void recordKnownTransientFailure(
        GroupSnapshot snapshot,
        TabletSnapshot tablet,
        RoutingHint.Builder hintBuilder,
        Predicate<String> excludedEndpoints,
        Set<Long> skippedTabletUids,
        List<SkippedTabletDetail> skippedTabletDetails,
        Map<String, ChannelEndpoint> resolvedEndpoints) {
      if (tablet.skip
          || tablet.serverAddress.isEmpty()
          || excludedEndpoints.test(tablet.serverAddress)) {
        return;
      }

      ChannelEndpoint endpoint = resolveEndpoint(tablet, resolvedEndpoints);
      if (endpoint != null && endpoint.isTransientFailure()) {
        addSkippedTablet(
            tablet,
            hintBuilder,
            skippedTabletUids,
            skippedTabletDetails,
            endpointLabel(snapshot, tablet),
            "known_transient_failure");
        return;
      }

      maybeAddRecentTransientFailureSkip(
          tablet,
          endpointLabel(snapshot, tablet),
          hintBuilder,
          skippedTabletUids,
          skippedTabletDetails);
    }

    private String endpointLabel(GroupSnapshot snapshot, TabletSnapshot tablet) {
      return formatTargetEndpointLabel(
          tablet.serverAddress, snapshot.hasLeader() && snapshot.leader() == tablet);
    }

    private ChannelEndpoint resolveEndpoint(
        TabletSnapshot tablet, Map<String, ChannelEndpoint> resolvedEndpoints) {
      if (tablet.serverAddress.isEmpty()) {
        return null;
      }
      if (resolvedEndpoints.containsKey(tablet.serverAddress)) {
        return resolvedEndpoints.get(tablet.serverAddress);
      }
      ChannelEndpoint endpoint = endpointCache.getIfPresent(tablet.serverAddress);
      if (endpoint != null && endpoint.getChannel().isShutdown()) {
        logger.log(
            Level.FINE,
            "Tablet {0} at {1}: cached endpoint is shutdown, clearing stale reference",
            new Object[] {tablet.tabletUid, tablet.serverAddress});
        endpoint = null;
      }
      resolvedEndpoints.put(tablet.serverAddress, endpoint);
      return endpoint;
    }

    private void maybeAddRecentTransientFailureSkip(
        TabletSnapshot tablet,
        @javax.annotation.Nullable String targetEndpointLabel,
        RoutingHint.Builder hintBuilder,
        Set<Long> skippedTabletUids,
        List<SkippedTabletDetail> skippedTabletDetails) {
      if (lifecycleManager != null
          && lifecycleManager.wasRecentlyEvictedTransientFailure(tablet.serverAddress)) {
        addSkippedTablet(
            tablet,
            hintBuilder,
            skippedTabletUids,
            skippedTabletDetails,
            targetEndpointLabel,
            "recent_transient_failure_eviction");
      }
    }

    private void addSkippedTablet(
        TabletSnapshot tablet,
        RoutingHint.Builder hintBuilder,
        Set<Long> skippedTabletUids,
        List<SkippedTabletDetail> skippedTabletDetails,
        @javax.annotation.Nullable String targetEndpointLabel,
        String reason) {
      if (!skippedTabletUids.add(tablet.tabletUid)) {
        return;
      }
      RoutingHint.SkippedTablet.Builder skipped = hintBuilder.addSkippedTabletUidBuilder();
      skipped.setTabletUid(tablet.tabletUid);
      skipped.setIncarnation(tablet.incarnation);
      skippedTabletDetails.add(new SkippedTabletDetail(targetEndpointLabel, reason));
    }

    String debugString() {
      GroupSnapshot snapshot = this.snapshot;
      StringBuilder sb = new StringBuilder();
      sb.append(groupUid).append(":[");
      for (int i = 0; i < snapshot.tablets.size(); i++) {
        sb.append(snapshot.tablets.get(i).debugString());
        if (snapshot.hasLeader() && i == snapshot.leaderIndex) {
          sb.append(" (leader)");
        }
        if (i < snapshot.tablets.size() - 1) {
          sb.append(", ");
        }
      }
      sb.append("]@").append(snapshot.generation.toStringUtf8());
      sb.append("#").append(refs);
      return sb.toString();
    }
  }

  /** Represents a cached range with its group and split information. */
  private static class CachedRange {
    final ByteString startKey;
    final ByteString limitKey;
    final CachedGroup group;
    final long splitId;
    final ByteString generation;
    volatile long lastAccess;

    CachedRange(
        ByteString startKey,
        ByteString limitKey,
        CachedGroup group,
        long splitId,
        ByteString generation,
        long lastAccess) {
      this.startKey = startKey;
      this.limitKey = limitKey;
      this.group = group;
      this.splitId = splitId;
      this.generation = generation;
      this.lastAccess = lastAccess;
    }

    String debugString() {
      return (group != null ? group.groupUid : "null_group")
          + ","
          + splitId
          + "@"
          + (generation.isEmpty() ? "" : generation.toStringUtf8())
          + ",last_access="
          + lastAccess;
    }
  }
}

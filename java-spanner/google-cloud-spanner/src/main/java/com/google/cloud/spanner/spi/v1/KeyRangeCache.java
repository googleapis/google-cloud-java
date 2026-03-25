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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/** Cache for routing information used by location-aware routing. */
@InternalApi
public final class KeyRangeCache {

  private static final int MAX_LOCAL_REPLICA_DISTANCE = 5;
  private static final int DEFAULT_MIN_ENTRIES_FOR_RANDOM_PICK = 1000;

  /** Determines how to handle ranges that span multiple splits. */
  public enum RangeMode {
    /** Consider it a cache miss if the whole range is not in a single split. */
    COVERING_SPLIT,
    /** If the range spans multiple splits, pick a random split when possible. */
    PICK_RANDOM
  }

  private final ChannelEndpointCache endpointCache;
  private final NavigableMap<ByteString, CachedRange> ranges =
      new TreeMap<>(ByteString.unsignedLexicographicalComparator());
  private final Map<Long, CachedGroup> groups = new HashMap<>();
  private final Object lock = new Object();
  private final AtomicLong accessCounter = new AtomicLong();

  private volatile boolean deterministicRandom = false;
  private volatile int minCacheEntriesForRandomPick = DEFAULT_MIN_ENTRIES_FOR_RANDOM_PICK;

  public KeyRangeCache(ChannelEndpointCache endpointCache) {
    this.endpointCache = Objects.requireNonNull(endpointCache);
  }

  @VisibleForTesting
  void useDeterministicRandom() {
    deterministicRandom = true;
  }

  @VisibleForTesting
  void setMinCacheEntriesForRandomPick(int value) {
    minCacheEntriesForRandomPick = value;
  }

  /** Applies cache updates. Tablets are processed inside group updates. */
  public void addRanges(CacheUpdate cacheUpdate) {
    List<CachedGroup> newGroups = new ArrayList<>();
    synchronized (lock) {
      for (Group groupIn : cacheUpdate.getGroupList()) {
        newGroups.add(findOrInsertGroup(groupIn));
      }
      for (Range rangeIn : cacheUpdate.getRangeList()) {
        replaceRangeIfNewer(rangeIn);
      }
      for (CachedGroup group : newGroups) {
        unref(group);
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
    ByteString key = hintBuilder.getKey();
    if (key.isEmpty()) {
      return null;
    }

    CachedRange targetRange;
    synchronized (lock) {
      targetRange = findRangeLocked(key, hintBuilder.getLimitKey(), rangeMode);
    }

    if (targetRange == null || targetRange.group == null) {
      return null;
    }

    hintBuilder.setGroupUid(targetRange.group.groupUid);
    hintBuilder.setSplitId(targetRange.splitId);
    hintBuilder.setKey(targetRange.startKey);
    hintBuilder.setLimitKey(targetRange.limitKey);

    return targetRange.group.fillRoutingHint(preferLeader, directedReadOptions, hintBuilder);
  }

  public void clear() {
    synchronized (lock) {
      for (CachedRange range : ranges.values()) {
        unref(range.group);
      }
      ranges.clear();
      groups.clear();
    }
  }

  public int size() {
    synchronized (lock) {
      return ranges.size();
    }
  }

  public void shrinkTo(int newSize) {
    synchronized (lock) {
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
    }
  }

  public String debugString() {
    StringBuilder sb = new StringBuilder();
    synchronized (lock) {
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

  private CachedGroup findOrInsertGroup(Group groupIn) {
    CachedGroup group = groups.get(groupIn.getGroupUid());
    if (group == null) {
      group = new CachedGroup(groupIn.getGroupUid());
      groups.put(groupIn.getGroupUid(), group);
    } else {
      group.refs++;
    }
    group.update(groupIn);
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

  /** Represents a single tablet within a group. */
  private class CachedTablet {
    long tabletUid = 0;
    ByteString incarnation = ByteString.EMPTY;
    String serverAddress = "";
    int distance = 0;
    boolean skip = false;
    Tablet.Role role = Tablet.Role.ROLE_UNSPECIFIED;
    String location = "";

    ChannelEndpoint endpoint = null;

    void update(Tablet tabletIn) {
      if (tabletUid > 0 && compare(incarnation, tabletIn.getIncarnation()) > 0) {
        return;
      }

      tabletUid = tabletIn.getTabletUid();
      incarnation = tabletIn.getIncarnation();
      distance = tabletIn.getDistance();
      skip = tabletIn.getSkip();
      role = tabletIn.getRole();
      location = tabletIn.getLocation();

      if (!serverAddress.equals(tabletIn.getServerAddress())) {
        serverAddress = tabletIn.getServerAddress();
        endpoint = null;
      }
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

    boolean shouldSkip(RoutingHint.Builder hintBuilder) {
      if (skip || serverAddress.isEmpty() || (endpoint != null && !endpoint.isHealthy())) {
        RoutingHint.SkippedTablet.Builder skipped = hintBuilder.addSkippedTabletUidBuilder();
        skipped.setTabletUid(tabletUid);
        skipped.setIncarnation(incarnation);
        return true;
      }
      return false;
    }

    ChannelEndpoint pick(RoutingHint.Builder hintBuilder) {
      hintBuilder.setTabletUid(tabletUid);
      if (endpoint == null && !serverAddress.isEmpty()) {
        endpoint = endpointCache.get(serverAddress);
      }
      return endpoint;
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

  /** Represents a paxos group with its tablets. */
  private class CachedGroup {
    final long groupUid;
    ByteString generation = ByteString.EMPTY;
    List<CachedTablet> tablets = new ArrayList<>();
    int leaderIndex = -1;
    int refs = 1;

    CachedGroup(long groupUid) {
      this.groupUid = groupUid;
    }

    synchronized void update(Group groupIn) {
      if (compare(groupIn.getGeneration(), generation) > 0) {
        generation = groupIn.getGeneration();
        if (groupIn.getLeaderIndex() >= 0 && groupIn.getLeaderIndex() < groupIn.getTabletsCount()) {
          leaderIndex = groupIn.getLeaderIndex();
        } else {
          leaderIndex = -1;
        }
      }

      if (tablets.size() == groupIn.getTabletsCount()) {
        boolean mismatch = false;
        for (int t = 0; t < groupIn.getTabletsCount(); t++) {
          if (tablets.get(t).tabletUid != groupIn.getTablets(t).getTabletUid()) {
            mismatch = true;
            break;
          }
        }
        if (!mismatch) {
          for (int t = 0; t < groupIn.getTabletsCount(); t++) {
            tablets.get(t).update(groupIn.getTablets(t));
          }
          return;
        }
      }

      Map<Long, CachedTablet> tabletsByUid = new HashMap<>(tablets.size());
      for (CachedTablet tablet : tablets) {
        tabletsByUid.put(tablet.tabletUid, tablet);
      }
      List<CachedTablet> newTablets = new ArrayList<>(groupIn.getTabletsCount());
      for (int t = 0; t < groupIn.getTabletsCount(); t++) {
        Tablet tabletIn = groupIn.getTablets(t);
        CachedTablet tablet = tabletsByUid.get(tabletIn.getTabletUid());
        if (tablet == null) {
          tablet = new CachedTablet();
        }
        tablet.update(tabletIn);
        newTablets.add(tablet);
      }
      tablets = newTablets;
    }

    ChannelEndpoint fillRoutingHint(
        boolean preferLeader,
        DirectedReadOptions directedReadOptions,
        RoutingHint.Builder hintBuilder) {
      boolean hasDirectedReadOptions =
          directedReadOptions.getReplicasCase()
              != DirectedReadOptions.ReplicasCase.REPLICAS_NOT_SET;

      // Fast path: pick a tablet while holding the lock. If the endpoint is already
      // cached on the tablet, return it immediately without releasing the lock.
      // If the endpoint needs to be created (blocking network dial), release the
      // lock first so other threads are not blocked during channel creation.
      CachedTablet selected;
      synchronized (this) {
        selected =
            selectTabletLocked(
                preferLeader, hasDirectedReadOptions, hintBuilder, directedReadOptions);
        if (selected == null) {
          return null;
        }
        if (selected.endpoint != null || selected.serverAddress.isEmpty()) {
          return selected.pick(hintBuilder);
        }
        // Slow path: endpoint not yet created. Capture the address and release the
        // lock before calling endpointCache.get(), which may block on network dial.
        hintBuilder.setTabletUid(selected.tabletUid);
      }

      String serverAddress = selected.serverAddress;
      ChannelEndpoint endpoint = endpointCache.get(serverAddress);

      synchronized (this) {
        // Only update if the tablet's address hasn't changed since we released the lock.
        if (selected.endpoint == null && selected.serverAddress.equals(serverAddress)) {
          selected.endpoint = endpoint;
        }
        // Re-set tabletUid with the latest value in case update() ran concurrently.
        hintBuilder.setTabletUid(selected.tabletUid);
        return selected.endpoint;
      }
    }

    private CachedTablet selectTabletLocked(
        boolean preferLeader,
        boolean hasDirectedReadOptions,
        RoutingHint.Builder hintBuilder,
        DirectedReadOptions directedReadOptions) {
      if (preferLeader
          && !hasDirectedReadOptions
          && hasLeader()
          && leader().distance <= MAX_LOCAL_REPLICA_DISTANCE
          && !leader().shouldSkip(hintBuilder)) {
        return leader();
      }
      for (CachedTablet tablet : tablets) {
        if (!tablet.matches(directedReadOptions)) {
          continue;
        }
        if (tablet.shouldSkip(hintBuilder)) {
          continue;
        }
        return tablet;
      }
      return null;
    }

    boolean hasLeader() {
      return leaderIndex >= 0 && leaderIndex < tablets.size();
    }

    CachedTablet leader() {
      return tablets.get(leaderIndex);
    }

    String debugString() {
      StringBuilder sb = new StringBuilder();
      sb.append(groupUid).append(":[");
      for (int i = 0; i < tablets.size(); i++) {
        sb.append(tablets.get(i).debugString());
        if (hasLeader() && i == leaderIndex) {
          sb.append(" (leader)");
        }
        if (i < tablets.size() - 1) {
          sb.append(", ");
        }
      }
      sb.append("]@").append(generation.toStringUtf8());
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
    long lastAccess;

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

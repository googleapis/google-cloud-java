/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.storage.ByteSizeConstants._5TiB;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.time.Instant.EPOCH;
import static java.time.Instant.ofEpochSecond;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Tuple;
import net.jqwik.api.Tuple.Tuple1;
import net.jqwik.time.api.DateTimes;
import net.jqwik.time.api.Times;

final class ThroughputMovingWindowPropertyTest {

  private static final double TOLERANCE = 0.001;

  @Example
  void canned() {
    test(CANNED_SCENARIO);
  }

  @Example
  void twoEntriesSameTimeDifferentThroughput() {
    Duration ms = Duration.ofMillis(1);
    ScenarioTimeline scenario =
        new ScenarioTimeline(
            ms,
            ImmutableList.of(
                new TimelineEntry(EPOCH, Throughput.of(1, ms), 1000.0),
                new TimelineEntry(EPOCH, Throughput.of(0, ms), 1000.0)));
    test(scenario);
  }

  @Property
  void test(@ForAll("Scenarios") ScenarioTimeline scenario) {
    ThroughputMovingWindow window = ThroughputMovingWindow.of(scenario.d);
    for (TimelineEntry timelineEntry : scenario.timelineEntries) {
      window.add(timelineEntry.i, timelineEntry.t);
      Throughput throughput = window.avg(timelineEntry.i);
      assertWithMessage(timelineEntry.toString())
          .that(throughput.toBps())
          .isWithin(TOLERANCE)
          .of(timelineEntry.expectedMovingAvgBytesPerSecond);
    }
  }

  @Provide("Scenarios")
  static Arbitrary<ScenarioTimeline> scenarioTimeline() {
    return Times.durations()
        .ofPrecision(ChronoUnit.MILLIS)
        .between(Duration.ofMillis(1), Duration.ofMinutes(10))
        .flatMap(
            d ->
                Combinators.combine(
                        Arbitraries.just(d),
                        // pick an instant, then generate 1 to 100 values between it and d * 3
                        DateTimes.instants()
                            .ofPrecision(ChronoUnit.MILLIS)
                            .flatMap(
                                i ->
                                    DateTimes.instants()
                                        .ofPrecision(ChronoUnit.MILLIS)
                                        .between(i, i.plus(d.multipliedBy(3)))
                                        .flatMap(
                                            ii ->
                                                Combinators.combine(
                                                        Arbitraries.just(ii), throughput())
                                                    .as(Tuple::of))
                                        .list()
                                        .ofMinSize(1)
                                        .ofMaxSize(100)))
                    .as(Tuple::of))
        .map(ScenarioTimeline::create);
  }

  static Arbitrary<Throughput> throughput() {
    return Times.durations()
        .ofPrecision(ChronoUnit.MILLIS)
        .between(Duration.ofMillis(1), Duration.ofMinutes(10))
        .flatMap(d -> Arbitraries.longs().between(0, _5TiB).map(n -> Throughput.of(n, d)));
  }

  private static final class ScenarioTimeline {

    private static final Comparator<Tuple.Tuple2<Instant, ?>> COMP =
        Comparator.comparing(Tuple1::get1);
    private final Duration d;
    private final List<TimelineEntry> timelineEntries;

    private ScenarioTimeline(Duration d, List<TimelineEntry> timelineEntries) {
      this.d = d;
      this.timelineEntries = timelineEntries;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("d", d)
          .add("timelineEntries", timelineEntries)
          .toString();
    }

    static ScenarioTimeline create(
        Tuple.Tuple2<Duration, List<Tuple.Tuple2<Instant, Throughput>>> tuples) {

      Duration d = tuples.get1();
      List<Tuple.Tuple2<Instant, Throughput>> pairs = tuples.get2();

      List<Tuple.Tuple2<Instant, Throughput>> tmp =
          pairs.stream().sorted(COMP).collect(Collectors.toList());

      List<List<Tuple.Tuple2<Instant, Throughput>>> windows = new ArrayList<>();
      int last = tmp.size() - 1;
      for (int i = last; i >= 0; i--) {
        List<Tuple.Tuple2<Instant, Throughput>> window = new ArrayList<>();
        Tuple.Tuple2<Instant, Throughput> t = tmp.get(i);
        window.add(t);
        Instant min = t.get1().minus(d);
        for (int j = i - 1; j >= 0; j--) {
          Tuple.Tuple2<Instant, Throughput> r = tmp.get(j);
          if (r.get1().isAfter(min)) {
            window.add(r);
          }
        }
        windows.add(ImmutableList.copyOf(window));
      }

      ImmutableList<TimelineEntry> timelineEntries =
          windows.stream()
              .map(
                  w -> {
                    Tuple.Tuple2<Instant, Throughput> max = w.get(0);
                    Throughput reduce =
                        w.stream()
                            .map(Tuple.Tuple2::get2)
                            .reduce(Throughput.zero(), Throughput::plus);
                    return new TimelineEntry(
                        max.get1(), max.get2(), Throughput.of(reduce.getNumBytes(), d).toBps());
                  })
              .collect(ImmutableList.toImmutableList());
      return new ScenarioTimeline(d, timelineEntries.reverse());
    }
  }

  private static final class TimelineEntry {
    private final Instant i;
    private final Throughput t;
    private final double expectedMovingAvgBytesPerSecond;

    private TimelineEntry(Instant i, Throughput t, double expectedMovingAvgBytesPerSecond) {
      this.i = i;
      this.t = t;
      this.expectedMovingAvgBytesPerSecond = expectedMovingAvgBytesPerSecond;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("i", i)
          .add("t", t)
          .add(
              "tenSecMovingAvg",
              String.format(Locale.US, "%,.03f", expectedMovingAvgBytesPerSecond))
          .toString();
    }
  }

  private static final ScenarioTimeline CANNED_SCENARIO =
      new ScenarioTimeline(
          Duration.ofSeconds(10),
          ImmutableList.<TimelineEntry>builder()
              .add(new TimelineEntry(ofEpochSecond(1), Throughput.bytesPerSecond(192), 19.2))
              .add(new TimelineEntry(ofEpochSecond(2), Throughput.bytesPerSecond(1185), 137.7))
              .add(new TimelineEntry(ofEpochSecond(3), Throughput.bytesPerSecond(1363), 274.))
              .add(new TimelineEntry(ofEpochSecond(4), Throughput.bytesPerSecond(234), 297.4))
              .add(new TimelineEntry(ofEpochSecond(5), Throughput.bytesPerSecond(1439), 441.3))
              .add(new TimelineEntry(ofEpochSecond(6), Throughput.bytesPerSecond(1269), 568.2))
              .add(new TimelineEntry(ofEpochSecond(7), Throughput.bytesPerSecond(692), 637.4))
              .add(new TimelineEntry(ofEpochSecond(8), Throughput.bytesPerSecond(667), 704.1))
              .add(new TimelineEntry(ofEpochSecond(9), Throughput.bytesPerSecond(1318), 835.9))
              .add(new TimelineEntry(ofEpochSecond(10), Throughput.bytesPerSecond(1125), 948.4))
              .add(new TimelineEntry(ofEpochSecond(11), Throughput.bytesPerSecond(1124), 1041.6))
              .add(new TimelineEntry(ofEpochSecond(12), Throughput.bytesPerSecond(3), 923.4))
              .add(new TimelineEntry(ofEpochSecond(13), Throughput.bytesPerSecond(185), 805.6))
              .add(new TimelineEntry(ofEpochSecond(14), Throughput.bytesPerSecond(726), 854.8))
              .add(new TimelineEntry(ofEpochSecond(15), Throughput.bytesPerSecond(630), 773.9))
              .add(new TimelineEntry(ofEpochSecond(16), Throughput.bytesPerSecond(874), 734.4))
              .add(new TimelineEntry(ofEpochSecond(17), Throughput.bytesPerSecond(1401), 805.3))
              .add(new TimelineEntry(ofEpochSecond(18), Throughput.bytesPerSecond(533), 791.9))
              .add(new TimelineEntry(ofEpochSecond(19), Throughput.bytesPerSecond(446), 704.7))
              .add(new TimelineEntry(ofEpochSecond(20), Throughput.bytesPerSecond(801), 672.3))
              .add(new TimelineEntry(ofEpochSecond(21), Throughput.bytesPerSecond(61), 566.))
              .add(new TimelineEntry(ofEpochSecond(22), Throughput.bytesPerSecond(1104), 676.1))
              .add(new TimelineEntry(ofEpochSecond(23), Throughput.bytesPerSecond(972), 754.8))
              .add(new TimelineEntry(ofEpochSecond(24), Throughput.bytesPerSecond(1310), 813.2))
              .add(new TimelineEntry(ofEpochSecond(25), Throughput.bytesPerSecond(408), 791.))
              .add(new TimelineEntry(ofEpochSecond(26), Throughput.bytesPerSecond(759), 779.5))
              .add(new TimelineEntry(ofEpochSecond(27), Throughput.bytesPerSecond(674), 706.8))
              .add(new TimelineEntry(ofEpochSecond(28), Throughput.bytesPerSecond(314), 684.9))
              .add(new TimelineEntry(ofEpochSecond(29), Throughput.bytesPerSecond(1311), 771.4))
              .add(new TimelineEntry(ofEpochSecond(30), Throughput.bytesPerSecond(449), 736.2))
              .add(new TimelineEntry(ofEpochSecond(31), Throughput.bytesPerSecond(1273), 857.4))
              .add(new TimelineEntry(ofEpochSecond(32), Throughput.bytesPerSecond(228), 769.8))
              .add(new TimelineEntry(ofEpochSecond(33), Throughput.bytesPerSecond(605), 733.1))
              .add(new TimelineEntry(ofEpochSecond(34), Throughput.bytesPerSecond(537), 655.8))
              .add(new TimelineEntry(ofEpochSecond(35), Throughput.bytesPerSecond(1498), 764.8))
              .add(new TimelineEntry(ofEpochSecond(36), Throughput.bytesPerSecond(694), 758.3))
              .add(new TimelineEntry(ofEpochSecond(37), Throughput.bytesPerSecond(155), 706.4))
              .add(new TimelineEntry(ofEpochSecond(38), Throughput.bytesPerSecond(983), 773.3))
              .add(new TimelineEntry(ofEpochSecond(39), Throughput.bytesPerSecond(1359), 778.1))
              .add(new TimelineEntry(ofEpochSecond(40), Throughput.bytesPerSecond(832), 816.4))
              .add(new TimelineEntry(ofEpochSecond(41), Throughput.bytesPerSecond(1041), 793.2))
              .add(new TimelineEntry(ofEpochSecond(42), Throughput.bytesPerSecond(1459), 916.3))
              .add(new TimelineEntry(ofEpochSecond(43), Throughput.bytesPerSecond(1128), 968.6))
              .add(new TimelineEntry(ofEpochSecond(44), Throughput.bytesPerSecond(1318), 1046.7))
              .add(new TimelineEntry(ofEpochSecond(45), Throughput.bytesPerSecond(620), 958.9))
              .add(new TimelineEntry(ofEpochSecond(46), Throughput.bytesPerSecond(1133), 1002.8))
              .add(new TimelineEntry(ofEpochSecond(47), Throughput.bytesPerSecond(568), 1044.1))
              .add(new TimelineEntry(ofEpochSecond(48), Throughput.bytesPerSecond(561), 1001.9))
              .add(new TimelineEntry(ofEpochSecond(49), Throughput.bytesPerSecond(1483), 1014.3))
              .add(new TimelineEntry(ofEpochSecond(50), Throughput.bytesPerSecond(1405), 1071.6))
              .add(new TimelineEntry(ofEpochSecond(51), Throughput.bytesPerSecond(435), 1011.))
              .add(new TimelineEntry(ofEpochSecond(52), Throughput.bytesPerSecond(664), 931.5))
              .add(new TimelineEntry(ofEpochSecond(53), Throughput.bytesPerSecond(1330), 951.7))
              .add(new TimelineEntry(ofEpochSecond(54), Throughput.bytesPerSecond(540), 873.9))
              .add(new TimelineEntry(ofEpochSecond(55), Throughput.bytesPerSecond(847), 896.6))
              .add(new TimelineEntry(ofEpochSecond(56), Throughput.bytesPerSecond(1231), 906.4))
              .add(new TimelineEntry(ofEpochSecond(57), Throughput.bytesPerSecond(1331), 982.7))
              .add(new TimelineEntry(ofEpochSecond(58), Throughput.bytesPerSecond(154), 942.))
              .add(new TimelineEntry(ofEpochSecond(59), Throughput.bytesPerSecond(801), 873.8))
              .add(new TimelineEntry(ofEpochSecond(60), Throughput.bytesPerSecond(499), 783.2))
              .add(new TimelineEntry(ofEpochSecond(61), Throughput.bytesPerSecond(766), 816.3))
              .add(new TimelineEntry(ofEpochSecond(62), Throughput.bytesPerSecond(1166), 866.5))
              .add(new TimelineEntry(ofEpochSecond(63), Throughput.bytesPerSecond(1408), 874.3))
              .add(new TimelineEntry(ofEpochSecond(64), Throughput.bytesPerSecond(1145), 934.8))
              .add(new TimelineEntry(ofEpochSecond(65), Throughput.bytesPerSecond(433), 893.4))
              .add(new TimelineEntry(ofEpochSecond(66), Throughput.bytesPerSecond(1256), 895.9))
              .add(new TimelineEntry(ofEpochSecond(67), Throughput.bytesPerSecond(847), 847.5))
              .add(new TimelineEntry(ofEpochSecond(68), Throughput.bytesPerSecond(1421), 974.2))
              .add(new TimelineEntry(ofEpochSecond(69), Throughput.bytesPerSecond(347), 928.8))
              .add(new TimelineEntry(ofEpochSecond(70), Throughput.bytesPerSecond(52), 884.1))
              .add(new TimelineEntry(ofEpochSecond(71), Throughput.bytesPerSecond(19), 809.4))
              .add(new TimelineEntry(ofEpochSecond(72), Throughput.bytesPerSecond(1191), 811.9))
              .add(new TimelineEntry(ofEpochSecond(73), Throughput.bytesPerSecond(104), 681.5))
              .add(new TimelineEntry(ofEpochSecond(74), Throughput.bytesPerSecond(640), 631.))
              .add(new TimelineEntry(ofEpochSecond(75), Throughput.bytesPerSecond(535), 641.2))
              .add(new TimelineEntry(ofEpochSecond(76), Throughput.bytesPerSecond(203), 535.9))
              .add(new TimelineEntry(ofEpochSecond(77), Throughput.bytesPerSecond(51), 456.3))
              .add(new TimelineEntry(ofEpochSecond(78), Throughput.bytesPerSecond(1117), 425.9))
              .add(new TimelineEntry(ofEpochSecond(79), Throughput.bytesPerSecond(1390), 530.2))
              .add(new TimelineEntry(ofEpochSecond(80), Throughput.bytesPerSecond(262), 551.2))
              .add(new TimelineEntry(ofEpochSecond(81), Throughput.bytesPerSecond(5), 549.8))
              .add(new TimelineEntry(ofEpochSecond(82), Throughput.bytesPerSecond(802), 510.9))
              .add(new TimelineEntry(ofEpochSecond(83), Throughput.bytesPerSecond(529), 553.4))
              .add(new TimelineEntry(ofEpochSecond(84), Throughput.bytesPerSecond(1261), 615.5))
              .add(new TimelineEntry(ofEpochSecond(85), Throughput.bytesPerSecond(1192), 681.2))
              .add(new TimelineEntry(ofEpochSecond(86), Throughput.bytesPerSecond(276), 688.5))
              .add(new TimelineEntry(ofEpochSecond(87), Throughput.bytesPerSecond(457), 729.1))
              .add(new TimelineEntry(ofEpochSecond(88), Throughput.bytesPerSecond(799), 697.3))
              .add(new TimelineEntry(ofEpochSecond(89), Throughput.bytesPerSecond(443), 602.6))
              .add(new TimelineEntry(ofEpochSecond(90), Throughput.bytesPerSecond(1281), 704.5))
              .add(new TimelineEntry(ofEpochSecond(91), Throughput.bytesPerSecond(97), 713.7))
              .add(new TimelineEntry(ofEpochSecond(92), Throughput.bytesPerSecond(895), 723.))
              .add(new TimelineEntry(ofEpochSecond(93), Throughput.bytesPerSecond(1338), 803.9))
              .add(new TimelineEntry(ofEpochSecond(94), Throughput.bytesPerSecond(554), 733.2))
              .add(new TimelineEntry(ofEpochSecond(95), Throughput.bytesPerSecond(302), 644.2))
              .add(new TimelineEntry(ofEpochSecond(96), Throughput.bytesPerSecond(518), 668.4))
              .add(new TimelineEntry(ofEpochSecond(97), Throughput.bytesPerSecond(502), 672.9))
              .add(new TimelineEntry(ofEpochSecond(98), Throughput.bytesPerSecond(517), 644.7))
              .add(new TimelineEntry(ofEpochSecond(99), Throughput.bytesPerSecond(172), 617.6))
              .add(new TimelineEntry(ofEpochSecond(100), Throughput.bytesPerSecond(909), 580.4))
              .add(new TimelineEntry(ofEpochSecond(101), Throughput.bytesPerSecond(1233), 694.))
              .add(new TimelineEntry(ofEpochSecond(102), Throughput.bytesPerSecond(189), 623.4))
              .add(new TimelineEntry(ofEpochSecond(103), Throughput.bytesPerSecond(244), 514.))
              .add(new TimelineEntry(ofEpochSecond(104), Throughput.bytesPerSecond(886), 547.2))
              .add(new TimelineEntry(ofEpochSecond(105), Throughput.bytesPerSecond(796), 596.6))
              .add(new TimelineEntry(ofEpochSecond(106), Throughput.bytesPerSecond(1072), 652.))
              .add(new TimelineEntry(ofEpochSecond(107), Throughput.bytesPerSecond(602), 662.))
              .add(new TimelineEntry(ofEpochSecond(108), Throughput.bytesPerSecond(507), 661.))
              .add(new TimelineEntry(ofEpochSecond(109), Throughput.bytesPerSecond(432), 687.))
              .add(new TimelineEntry(ofEpochSecond(110), Throughput.bytesPerSecond(661), 662.2))
              .add(new TimelineEntry(ofEpochSecond(111), Throughput.bytesPerSecond(1085), 647.4))
              .add(new TimelineEntry(ofEpochSecond(112), Throughput.bytesPerSecond(157), 644.2))
              .add(new TimelineEntry(ofEpochSecond(113), Throughput.bytesPerSecond(529), 672.7))
              .add(new TimelineEntry(ofEpochSecond(114), Throughput.bytesPerSecond(31), 587.2))
              .add(new TimelineEntry(ofEpochSecond(115), Throughput.bytesPerSecond(464), 554.))
              .add(new TimelineEntry(ofEpochSecond(116), Throughput.bytesPerSecond(1301), 576.9))
              .add(new TimelineEntry(ofEpochSecond(117), Throughput.bytesPerSecond(787), 595.4))
              .add(new TimelineEntry(ofEpochSecond(118), Throughput.bytesPerSecond(908), 635.5))
              .add(new TimelineEntry(ofEpochSecond(119), Throughput.bytesPerSecond(1316), 723.9))
              .add(new TimelineEntry(ofEpochSecond(120), Throughput.bytesPerSecond(764), 734.2))
              .add(new TimelineEntry(ofEpochSecond(121), Throughput.bytesPerSecond(1391), 764.8))
              .add(new TimelineEntry(ofEpochSecond(122), Throughput.bytesPerSecond(819), 831.))
              .add(new TimelineEntry(ofEpochSecond(123), Throughput.bytesPerSecond(219), 800.))
              .add(new TimelineEntry(ofEpochSecond(124), Throughput.bytesPerSecond(601), 857.))
              .add(new TimelineEntry(ofEpochSecond(125), Throughput.bytesPerSecond(1238), 934.4))
              .add(new TimelineEntry(ofEpochSecond(126), Throughput.bytesPerSecond(1392), 943.5))
              .add(new TimelineEntry(ofEpochSecond(127), Throughput.bytesPerSecond(499), 914.7))
              .add(new TimelineEntry(ofEpochSecond(128), Throughput.bytesPerSecond(1153), 939.2))
              .add(new TimelineEntry(ofEpochSecond(129), Throughput.bytesPerSecond(1219), 929.5))
              .add(new TimelineEntry(ofEpochSecond(130), Throughput.bytesPerSecond(519), 905.))
              .add(new TimelineEntry(ofEpochSecond(131), Throughput.bytesPerSecond(337), 799.6))
              .add(new TimelineEntry(ofEpochSecond(132), Throughput.bytesPerSecond(1065), 824.2))
              .add(new TimelineEntry(ofEpochSecond(133), Throughput.bytesPerSecond(789), 881.2))
              .add(new TimelineEntry(ofEpochSecond(134), Throughput.bytesPerSecond(32), 824.3))
              .add(new TimelineEntry(ofEpochSecond(135), Throughput.bytesPerSecond(893), 789.8))
              .add(new TimelineEntry(ofEpochSecond(136), Throughput.bytesPerSecond(1093), 759.9))
              .add(new TimelineEntry(ofEpochSecond(137), Throughput.bytesPerSecond(1218), 831.8))
              .add(new TimelineEntry(ofEpochSecond(138), Throughput.bytesPerSecond(159), 732.4))
              .add(new TimelineEntry(ofEpochSecond(139), Throughput.bytesPerSecond(407), 651.2))
              .add(new TimelineEntry(ofEpochSecond(140), Throughput.bytesPerSecond(615), 660.8))
              .add(new TimelineEntry(ofEpochSecond(141), Throughput.bytesPerSecond(1392), 766.3))
              .add(new TimelineEntry(ofEpochSecond(142), Throughput.bytesPerSecond(1431), 802.9))
              .add(new TimelineEntry(ofEpochSecond(143), Throughput.bytesPerSecond(270), 751.))
              .add(new TimelineEntry(ofEpochSecond(144), Throughput.bytesPerSecond(300), 777.8))
              .add(new TimelineEntry(ofEpochSecond(145), Throughput.bytesPerSecond(1402), 828.7))
              .add(new TimelineEntry(ofEpochSecond(146), Throughput.bytesPerSecond(308), 750.2))
              .add(new TimelineEntry(ofEpochSecond(147), Throughput.bytesPerSecond(125), 640.9))
              .add(new TimelineEntry(ofEpochSecond(148), Throughput.bytesPerSecond(467), 671.7))
              .add(new TimelineEntry(ofEpochSecond(149), Throughput.bytesPerSecond(1339), 764.9))
              .add(new TimelineEntry(ofEpochSecond(150), Throughput.bytesPerSecond(1146), 818.))
              .add(new TimelineEntry(ofEpochSecond(151), Throughput.bytesPerSecond(765), 755.3))
              .add(new TimelineEntry(ofEpochSecond(152), Throughput.bytesPerSecond(649), 677.1))
              .add(new TimelineEntry(ofEpochSecond(153), Throughput.bytesPerSecond(1318), 781.9))
              .add(new TimelineEntry(ofEpochSecond(154), Throughput.bytesPerSecond(199), 771.8))
              .add(new TimelineEntry(ofEpochSecond(155), Throughput.bytesPerSecond(923), 723.9))
              .add(new TimelineEntry(ofEpochSecond(156), Throughput.bytesPerSecond(430), 736.1))
              .add(new TimelineEntry(ofEpochSecond(157), Throughput.bytesPerSecond(158), 739.4))
              .add(new TimelineEntry(ofEpochSecond(158), Throughput.bytesPerSecond(187), 711.4))
              .add(new TimelineEntry(ofEpochSecond(159), Throughput.bytesPerSecond(442), 621.7))
              .add(new TimelineEntry(ofEpochSecond(160), Throughput.bytesPerSecond(82), 515.3))
              .add(new TimelineEntry(ofEpochSecond(161), Throughput.bytesPerSecond(951), 533.9))
              .add(new TimelineEntry(ofEpochSecond(162), Throughput.bytesPerSecond(976), 566.6))
              .add(new TimelineEntry(ofEpochSecond(163), Throughput.bytesPerSecond(1371), 571.9))
              .add(new TimelineEntry(ofEpochSecond(164), Throughput.bytesPerSecond(547), 606.7))
              .add(new TimelineEntry(ofEpochSecond(165), Throughput.bytesPerSecond(370), 551.4))
              .add(new TimelineEntry(ofEpochSecond(166), Throughput.bytesPerSecond(247), 533.1))
              .add(new TimelineEntry(ofEpochSecond(167), Throughput.bytesPerSecond(660), 583.3))
              .add(new TimelineEntry(ofEpochSecond(168), Throughput.bytesPerSecond(1222), 686.8))
              .add(new TimelineEntry(ofEpochSecond(169), Throughput.bytesPerSecond(130), 655.6))
              .add(new TimelineEntry(ofEpochSecond(170), Throughput.bytesPerSecond(512), 698.6))
              .add(new TimelineEntry(ofEpochSecond(171), Throughput.bytesPerSecond(873), 690.8))
              .add(new TimelineEntry(ofEpochSecond(172), Throughput.bytesPerSecond(18), 595.))
              .add(new TimelineEntry(ofEpochSecond(173), Throughput.bytesPerSecond(817), 539.6))
              .add(new TimelineEntry(ofEpochSecond(174), Throughput.bytesPerSecond(1090), 593.9))
              .add(new TimelineEntry(ofEpochSecond(175), Throughput.bytesPerSecond(1201), 677.))
              .add(new TimelineEntry(ofEpochSecond(176), Throughput.bytesPerSecond(1046), 756.9))
              .add(new TimelineEntry(ofEpochSecond(177), Throughput.bytesPerSecond(1075), 798.4))
              .add(new TimelineEntry(ofEpochSecond(178), Throughput.bytesPerSecond(679), 744.1))
              .add(new TimelineEntry(ofEpochSecond(179), Throughput.bytesPerSecond(1043), 835.4))
              .add(new TimelineEntry(ofEpochSecond(180), Throughput.bytesPerSecond(1206), 904.8))
              .add(new TimelineEntry(ofEpochSecond(181), Throughput.bytesPerSecond(701), 887.6))
              .add(new TimelineEntry(ofEpochSecond(182), Throughput.bytesPerSecond(849), 970.7))
              .add(new TimelineEntry(ofEpochSecond(183), Throughput.bytesPerSecond(457), 934.7))
              .add(new TimelineEntry(ofEpochSecond(184), Throughput.bytesPerSecond(400), 865.7))
              .add(new TimelineEntry(ofEpochSecond(185), Throughput.bytesPerSecond(1157), 861.3))
              .add(new TimelineEntry(ofEpochSecond(186), Throughput.bytesPerSecond(235), 780.2))
              .add(new TimelineEntry(ofEpochSecond(187), Throughput.bytesPerSecond(525), 725.2))
              .add(new TimelineEntry(ofEpochSecond(188), Throughput.bytesPerSecond(1415), 798.8))
              .add(new TimelineEntry(ofEpochSecond(189), Throughput.bytesPerSecond(796), 774.1))
              .add(new TimelineEntry(ofEpochSecond(190), Throughput.bytesPerSecond(428), 696.3))
              .add(new TimelineEntry(ofEpochSecond(191), Throughput.bytesPerSecond(417), 667.9))
              .add(new TimelineEntry(ofEpochSecond(192), Throughput.bytesPerSecond(436), 626.6))
              .add(new TimelineEntry(ofEpochSecond(193), Throughput.bytesPerSecond(781), 659.))
              .add(new TimelineEntry(ofEpochSecond(194), Throughput.bytesPerSecond(967), 715.7))
              .add(new TimelineEntry(ofEpochSecond(195), Throughput.bytesPerSecond(398), 639.8))
              .add(new TimelineEntry(ofEpochSecond(196), Throughput.bytesPerSecond(501), 666.4))
              .add(new TimelineEntry(ofEpochSecond(197), Throughput.bytesPerSecond(691), 683.))
              .add(new TimelineEntry(ofEpochSecond(198), Throughput.bytesPerSecond(1492), 690.7))
              .add(new TimelineEntry(ofEpochSecond(199), Throughput.bytesPerSecond(1493), 760.4))
              .add(new TimelineEntry(ofEpochSecond(200), Throughput.bytesPerSecond(5), 718.1))
              .add(new TimelineEntry(ofEpochSecond(201), Throughput.bytesPerSecond(679), 744.3))
              .add(new TimelineEntry(ofEpochSecond(202), Throughput.bytesPerSecond(1027), 803.4))
              .add(new TimelineEntry(ofEpochSecond(203), Throughput.bytesPerSecond(170), 742.3))
              .add(new TimelineEntry(ofEpochSecond(204), Throughput.bytesPerSecond(261), 671.7))
              .add(new TimelineEntry(ofEpochSecond(205), Throughput.bytesPerSecond(309), 662.8))
              .add(new TimelineEntry(ofEpochSecond(206), Throughput.bytesPerSecond(1483), 761.))
              .add(new TimelineEntry(ofEpochSecond(207), Throughput.bytesPerSecond(1154), 807.3))
              .add(new TimelineEntry(ofEpochSecond(208), Throughput.bytesPerSecond(857), 743.8))
              .add(new TimelineEntry(ofEpochSecond(209), Throughput.bytesPerSecond(792), 673.7))
              .add(new TimelineEntry(ofEpochSecond(210), Throughput.bytesPerSecond(819), 755.1))
              .add(new TimelineEntry(ofEpochSecond(211), Throughput.bytesPerSecond(763), 763.5))
              .add(new TimelineEntry(ofEpochSecond(212), Throughput.bytesPerSecond(386), 699.4))
              .add(new TimelineEntry(ofEpochSecond(213), Throughput.bytesPerSecond(789), 761.3))
              .add(new TimelineEntry(ofEpochSecond(214), Throughput.bytesPerSecond(1432), 878.4))
              .add(new TimelineEntry(ofEpochSecond(215), Throughput.bytesPerSecond(205), 868.))
              .add(new TimelineEntry(ofEpochSecond(216), Throughput.bytesPerSecond(905), 810.2))
              .add(new TimelineEntry(ofEpochSecond(217), Throughput.bytesPerSecond(1290), 823.8))
              .add(new TimelineEntry(ofEpochSecond(218), Throughput.bytesPerSecond(639), 802.))
              .add(new TimelineEntry(ofEpochSecond(219), Throughput.bytesPerSecond(1246), 847.4))
              .build());
}

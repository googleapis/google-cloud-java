/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage.conformance.retry;

import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.blobCopyWithStorage;
import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.bucketCopyWithStorage;
import static com.google.cloud.storage.conformance.retry.Ctx.ctx;
import static com.google.cloud.storage.conformance.retry.State.empty;
import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.conformance.storage.v1.InstructionList;
import com.google.cloud.conformance.storage.v1.Method;
import com.google.cloud.conformance.storage.v1.RetryTest;
import com.google.cloud.conformance.storage.v1.RetryTests;
import com.google.cloud.storage.CIUtils;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.conformance.retry.Functions.CtxFunction;
import com.google.cloud.storage.conformance.retry.ITRetryConformanceTest.RetryConformanceParameterProvider;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.registry.TestBench;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Load and dynamically generate a series of test cases to verify if the {@link Storage} and
 * associated high level classes adhere to expected retry behavior.
 *
 * <p>This class dynamically generates test cases based on resources from the
 * google-cloud-conformance-tests artifact and a set of defined mappings from {@link
 * RpcMethodMappings}.
 */
@RunWith(StorageITRunner.class)
// @CrossRun(transports = Transport.HTTP, backends = Backend.TEST_BENCH)
@SingleBackend(Backend.TEST_BENCH)
@Parameterized(RetryConformanceParameterProvider.class)
@ParallelFriendly
public class ITRetryConformanceTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(ITRetryConformanceTest.class);

  private RetryTestFixture retryTestFixture;

  @Parameter public RetryParameter retryParameter;

  private TestRetryConformance testRetryConformance;
  private RpcMethodMapping mapping;
  private Storage nonTestStorage;
  private Storage testStorage;
  @Nullable private Ctx ctx;

  @Before
  public void setUp() throws Throwable {
    LOGGER.trace("Running setup...");
    retryTestFixture = retryParameter.retryTestFixture;
    testRetryConformance = retryParameter.testRetryConformance;
    mapping = retryParameter.rpcMethodMapping;
    retryTestFixture.starting(null);
    nonTestStorage = retryTestFixture.getNonTestStorage();
    testStorage = retryTestFixture.getTestStorage();
    // it's important to keep these two ctx assignments separate to allow for teardown to work in
    // the case setup fails for some reason
    ctx = ctx(nonTestStorage, empty());
    ctx = mapping.getSetup().apply(ctx, testRetryConformance).leftMap(s -> testStorage);
    LOGGER.trace("Running setup complete");
  }

  @After
  public void tearDown() throws Throwable {
    LOGGER.trace("Running teardown...");
    if (ctx != null) {
      ctx = ctx.leftMap(s -> nonTestStorage);
      getReplaceStorageInObjectsFromCtx()
          .andThen(mapping.getTearDown())
          .apply(ctx, testRetryConformance);
    }
    retryTestFixture.finished(null);
    LOGGER.trace("Running teardown complete");
  }

  /**
   * Run an individual test case. 1. Create two storage clients, one for setup/teardown and one for
   * test execution 2. Run setup 3. Run test 4. Run teardown
   */
  @Test
  public void test() throws Throwable {
    LOGGER.trace("Running test...");
    assertThat(ctx).isNotNull();
    try {
      ctx =
          getReplaceStorageInObjectsFromCtx()
              .andThen(mapping.getTest())
              .apply(ctx, testRetryConformance)
              .leftMap(s -> nonTestStorage);
      retryTestFixture.succeeded(null);
    } catch (Throwable e) {
      retryTestFixture.failed(e, null);
      throw e;
    }
    LOGGER.trace("Running test complete");
  }

  /**
   * Load all of the tests and return a {@code Collection<Object[]>} representing the set of tests.
   * Each entry in the returned collection is the set of parameters to the constructor of this test
   * class.
   *
   * <p>The results of this method will then be run by JUnit's Parameterized test runner
   */
  public static final class RetryConformanceParameterProvider implements ParametersProvider {
    @Inject public TestBench testBench;

    @Override
    public ImmutableList<?> parameters() {
      RetryTestCaseResolver resolver =
          RetryTestCaseResolver.newBuilder()
              .setRetryTestsJsonResourcePath(
                  "com/google/cloud/conformance/storage/v1/retry_tests.json")
              .setMappings(new RpcMethodMappings())
              .setProjectId("conformance-tests")
              .setHost(testBench.getBaseUri().replaceAll("https?://", ""))
              .setTestAllowFilter(RetryTestCaseResolver.includeAll())
              .build();

      List<RetryTestCase> retryTestCases;
      try {
        retryTestCases = resolver.getRetryTestCases();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      assertThat(retryTestCases).isNotEmpty();
      return retryTestCases.stream()
          .map(
              rtc ->
                  RetryParameter.of(
                      rtc,
                      new RetryTestFixture(
                          CleanupStrategy.ALWAYS, testBench, rtc.testRetryConformance)))
          .collect(ImmutableList.toImmutableList());
    }
  }

  /**
   * When a "higher level object" ({@link com.google.cloud.storage.Bucket}, {@link
   * com.google.cloud.storage.Blob}, etc.) is created as part of setup it keeps a reference to the
   * instance of {@link Storage} used to create it. When we run our tests we need the instance of
   * {@link Storage} to be the instance with the headers to signal the retry test.
   *
   * <p>The function returned will inspect the {@link State} and create copies of any "higher level
   * objects" which are present replacing the instance of {@link Storage} from the provided ctx.
   */
  private static CtxFunction getReplaceStorageInObjectsFromCtx() {
    return (ctx, c) -> {
      State s = ctx.getState();
      if (s.hasBucket()) {
        s = s.with(bucketCopyWithStorage(s.getBucket(), ctx.getStorage()));
      }
      if (s.hasBlob()) {
        s = s.with(blobCopyWithStorage(s.getBlob(), ctx.getStorage()));
      }
      final State state = s;
      return ctx.map(x -> state);
    };
  }

  /**
   * Helper class which encapsulates all the logic necessary to resolve and crete a test case for
   * each defined scenario from google-cloud-conformance-tests and our defined {@link
   * RpcMethodMappings}.
   */
  static final class RetryTestCaseResolver {
    private static final String HEX_SHUFFLE_SEED_OVERRIDE =
        System.getProperty("HEX_SHUFFLE_SEED_OVERRIDE");

    private final String retryTestsJsonResourcePath;
    private final RpcMethodMappings mappings;
    private final BiPredicate<RpcMethod, TestRetryConformance> testAllowFilter;
    private final Random rand;
    private final String host;
    private final String projectId;

    private RetryTestCaseResolver(
        String retryTestsJsonResourcePath,
        RpcMethodMappings mappings,
        BiPredicate<RpcMethod, TestRetryConformance> testAllowFilter,
        Random rand,
        String host,
        String projectId) {
      this.retryTestsJsonResourcePath = retryTestsJsonResourcePath;
      this.mappings = mappings;
      this.testAllowFilter = testAllowFilter;
      this.rand = rand;
      this.host = host;
      this.projectId = projectId;
    }

    /** Load, permute and generate all RetryTestCases which are to be run in this suite */
    List<RetryTestCase> getRetryTestCases() throws IOException {
      RetryTests retryTests = loadRetryTestsDefinition();

      // sort the defined RetryTest by id, so we have a stable ordering while generating cases.
      List<RetryTest> retryTestCases =
          retryTests.getRetryTestsList().stream()
              .sorted(Comparator.comparingInt(RetryTest::getId))
              .collect(Collectors.toList());

      List<RetryTestCase> testCases = generateTestCases(mappings, retryTestCases);

      // Shuffle our test cases to ensure we don't have any between case ordering weirdness
      Collections.shuffle(testCases, rand);

      validateGeneratedTestCases(mappings, testCases);

      return testCases;
    }

    /** Load the defined scenarios from google-cloud-conformance-tests */
    private RetryTests loadRetryTestsDefinition() throws IOException {
      ClassLoader cl = Thread.currentThread().getContextClassLoader();

      InputStream dataJson = cl.getResourceAsStream(retryTestsJsonResourcePath);
      assertNotNull(
          String.format(
              Locale.US, "Unable to load test definition: %s", retryTestsJsonResourcePath),
          dataJson);

      InputStreamReader reader = new InputStreamReader(dataJson, Charsets.UTF_8);
      RetryTests.Builder testBuilder = RetryTests.newBuilder();
      JsonFormat.parser().merge(reader, testBuilder);
      return testBuilder.build();
    }

    /** Permute the RetryTest, Instructions and methods with our mappings */
    private List<RetryTestCase> generateTestCases(
        RpcMethodMappings rpcMethodMappings, List<RetryTest> retryTests) {

      List<RetryTestCase> testCases = new ArrayList<>();
      Transport[] values = Transport.values();
      for (Transport transport : values) {
        for (RetryTest testCase : retryTests) {
          for (InstructionList instructionList : testCase.getCasesList()) {
            for (Method method : testCase.getMethodsList()) {
              String methodName = method.getName();
              RpcMethod key = RpcMethod.storage.lookup.get(methodName);
              assertNotNull(
                  String.format(
                      Locale.US, "Unable to resolve RpcMethod for value '%s'", methodName),
                  key);
              // get all RpcMethodMappings which are defined for key
              List<RpcMethodMapping> mappings =
                  rpcMethodMappings.get(key).stream()
                      .sorted(Comparator.comparingInt(RpcMethodMapping::getMappingId))
                      .collect(Collectors.toList());
              // if we don't have any mappings defined for the provide key, generate a case that
              // when
              // run reports an ignored test. This is done for the sake of completeness and to be
              // aware of a lack of mapping.
              if (mappings.isEmpty() && CIUtils.verbose()) {
                TestRetryConformance testRetryConformance =
                    new TestRetryConformance(
                        transport,
                        projectId,
                        host,
                        testCase.getId(),
                        method,
                        instructionList,
                        testCase.getPreconditionProvided(),
                        false);
                if (testAllowFilter.test(key, testRetryConformance)) {
                  testCases.add(
                      new RetryTestCase(
                          testRetryConformance, RpcMethodMapping.notImplemented(key)));
                }
              } else {
                for (RpcMethodMapping mapping : mappings) {
                  TestRetryConformance testRetryConformance =
                      new TestRetryConformance(
                          transport,
                          projectId,
                          host,
                          testCase.getId(),
                          method,
                          instructionList,
                          testCase.getPreconditionProvided(),
                          testCase.getExpectSuccess(),
                          mapping.getMappingId());
                  // check that this case is allowed based on the provided filter
                  if (testAllowFilter.test(key, testRetryConformance)) {
                    // check that the defined mapping is applicable to the case we've resolved.
                    // Many mappings are conditionally valid and depend on the defined case.
                    if (mapping.getApplicable().test(testRetryConformance)) {
                      testCases.add(new RetryTestCase(testRetryConformance, mapping));
                    } else if (CIUtils.verbose()) {
                      // when the mapping is determined to not be applicable to this case, generate
                      // a synthetic mapping which  will report as an ignored test. This is done for
                      // the sake of completeness.
                      RpcMethodMapping build =
                          mapping.toBuilder()
                              .withSetup(CtxFunction.identity())
                              .withTest(
                                  (s, c) -> {
                                    throw new AssumptionViolatedException(
                                        "applicability predicate evaluated to false");
                                  })
                              .withTearDown(CtxFunction.identity())
                              .build();
                      testCases.add(new RetryTestCase(testRetryConformance, build));
                    }
                  }
                }
              }
            }
          }
        }
      }
      return testCases;
    }

    private void validateGeneratedTestCases(
        RpcMethodMappings rpcMethodMappings, List<RetryTestCase> data) {
      Set<Integer> unusedMappings =
          rpcMethodMappings.differenceMappingIds(
              data.stream()
                  .map(rtc -> rtc.testRetryConformance.getMappingId())
                  .collect(Collectors.toSet()));

      if (!unusedMappings.isEmpty()) {
        LOGGER.warn(
            String.format(
                Locale.US,
                "Declared but unused mappings with ids: [%s]",
                Joiner.on(", ").join(unusedMappings)));
      }
    }

    static Builder newBuilder() {
      return new Builder();
    }

    /** Filtering predicate in which all test cases will be included and run. */
    static BiPredicate<RpcMethod, TestRetryConformance> includeAll() {
      return (m, c) -> true;
    }

    /**
     * Filtering predicate in which only those test cases which match up to the specified {@code
     * mappingIds} will be included and run.
     */
    static BiPredicate<RpcMethod, TestRetryConformance> specificMappings(int... mappingIds) {
      ImmutableSet<Integer> set =
          Arrays.stream(mappingIds).boxed().collect(ImmutableSet.toImmutableSet());
      return (m, c) -> set.contains(c.getMappingId());
    }

    static BiPredicate<RpcMethod, TestRetryConformance> lift(Predicate<TestRetryConformance> p) {
      return (m, trc) -> p.test(trc);
    }

    static Predicate<TestRetryConformance> instructionsAre(String... instructions) {
      return trc ->
          trc.getInstruction().getInstructionsList().equals(ImmutableList.copyOf(instructions));
    }

    static BiPredicate<RpcMethod, TestRetryConformance> scenarioIdIs(int scenarioId) {
      return (m, trc) -> trc.getScenarioId() == scenarioId;
    }

    static BiPredicate<RpcMethod, TestRetryConformance> mappingIdIn(Integer... mappingIds) {
      ImmutableSet<Integer> ids = ImmutableSet.copyOf(mappingIds);
      return (m, trc) -> ids.contains(trc.getMappingId());
    }

    static final class Builder {
      private String retryTestsJsonResourcePath;
      private RpcMethodMappings mappings;
      private String host;
      private BiPredicate<RpcMethod, TestRetryConformance> testAllowFilter;
      private final Random rand;
      private String projectId;

      public Builder() {
        this.rand = resolveRand();
      }

      /**
       * Set the resource path of where to resolve the retry_tests.json from
       * google-cloud-conformance-tests
       */
      public Builder setRetryTestsJsonResourcePath(String retryTestsJsonResourcePath) {
        this.retryTestsJsonResourcePath = retryTestsJsonResourcePath;
        return this;
      }

      /** Set the defined mappings which are to be used in test generation */
      public Builder setMappings(RpcMethodMappings mappings) {
        this.mappings = requireNonNull(mappings, "mappings must be non null");
        return this;
      }

      /** Set the host string of where the testbench will be available during a test run */
      public Builder setHost(String host) {
        this.host = host;
        return this;
      }

      public Builder setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
      }

      /**
       * Set the allow filter for determining if a particular {@link RpcMethod} and {@link
       * TestRetryConformance} should be included in the generated test suite.
       */
      public Builder setTestAllowFilter(
          BiPredicate<RpcMethod, TestRetryConformance> testAllowFilter) {
        this.testAllowFilter = requireNonNull(testAllowFilter, "testAllowFilter must be non null");
        return this;
      }

      public RetryTestCaseResolver build() {
        return new RetryTestCaseResolver(
            requireNonNull(
                retryTestsJsonResourcePath, "retryTestsJsonResourcePath must be non null"),
            requireNonNull(mappings, "mappings must be non null"),
            requireNonNull(testAllowFilter, "testAllowList must be non null"),
            rand,
            requireNonNull(host, "host must be non null"),
            requireNonNull(projectId, "projectId must be non null"));
      }

      /**
       * As part of test generation and execution we are shuffling the order to ensure there is no
       * ordering dependency between individual cases. Given this fact, we report the seed used for
       * performing the shuffle. If an explicit seed is provided via environment variable that will
       * take precedence.
       */
      private static Random resolveRand() {
        try {
          long seed;
          if (HEX_SHUFFLE_SEED_OVERRIDE != null) {
            LOGGER.info(
                "Shuffling test order using Random with override seed: "
                    + HEX_SHUFFLE_SEED_OVERRIDE);
            seed = new BigInteger(HEX_SHUFFLE_SEED_OVERRIDE.replace("0x", ""), 16).longValue();
          } else {
            seed =
                SecureRandom.getInstanceStrong()
                    .longs(100)
                    .reduce((first, second) -> second)
                    .orElseThrow(
                        () -> {
                          throw new IllegalStateException("Unable to generate seed");
                        });
            String msg =
                String.format(
                    Locale.US, "Shuffling test order using Random with seed: 0x%016X", seed);
            LOGGER.info(msg);
          }
          return new Random(seed);
        } catch (NoSuchAlgorithmException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  /**
   * Simple typed tuple class to bind together a {@link TestRetryConformance} and {@link
   * RpcMethodMapping} during resolution.
   */
  private static final class RetryTestCase {
    private final TestRetryConformance testRetryConformance;
    private final RpcMethodMapping rpcMethodMapping;

    RetryTestCase(TestRetryConformance testRetryConformance, RpcMethodMapping rpcMethodMapping) {
      this.testRetryConformance = testRetryConformance;
      this.rpcMethodMapping = rpcMethodMapping;
    }
  }

  private static final class RetryParameter {
    private final TestRetryConformance testRetryConformance;
    private final RpcMethodMapping rpcMethodMapping;
    private final RetryTestFixture retryTestFixture;

    private RetryParameter(
        TestRetryConformance testRetryConformance,
        RpcMethodMapping rpcMethodMapping,
        RetryTestFixture retryTestFixture) {
      this.testRetryConformance = testRetryConformance;
      this.rpcMethodMapping = rpcMethodMapping;
      this.retryTestFixture = retryTestFixture;
    }

    public static RetryParameter of(RetryTestCase rtc, RetryTestFixture retryTestFixture) {
      return new RetryParameter(rtc.testRetryConformance, rtc.rpcMethodMapping, retryTestFixture);
    }

    @Override
    public String toString() {
      return testRetryConformance.toString();
    }
  }
}

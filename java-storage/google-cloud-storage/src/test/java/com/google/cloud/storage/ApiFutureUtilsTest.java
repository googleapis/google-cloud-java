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

import static com.google.cloud.storage.ApiFutureUtils.await;
import static com.google.cloud.storage.ApiFutureUtils.just;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.testing.junit4.StdErrCaptureRule;
import com.google.cloud.testing.junit4.StdOutCaptureRule;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;

public final class ApiFutureUtilsTest {

  @Rule public final StdOutCaptureRule stdOut = new StdOutCaptureRule();
  @Rule public final StdErrCaptureRule stdErr = new StdErrCaptureRule();

  @Test
  public void quietAllAsList_returnsFirstFailureAndDoesNotLogLaterExceptions() throws Exception {

    // define a couple futures that will fail later
    SettableApiFuture<String> b = SettableApiFuture.create();
    SettableApiFuture<String> c = SettableApiFuture.create();

    ImmutableList<ApiFuture<String>> futures = ImmutableList.of(just("a"), b, c, just("d"));

    ApiFuture<List<String>> all = ApiFutureUtils.quietAllAsList(futures);

    b.setException(new Kaboom());
    c.setException(new RuntimeException());

    assertAll(
        () -> assertThrows(Kaboom.class, () -> await(all)),
        () -> assertWithMessage("stdout").that(stdOut.getCapturedOutputAsUtf8String()).isEmpty(),
        () -> assertWithMessage("stderr").that(stdErr.getCapturedOutputAsUtf8String()).isEmpty());
  }

  private static final class Kaboom extends RuntimeException {
    private Kaboom() {
      super("Kaboom!!!");
    }
  }
}

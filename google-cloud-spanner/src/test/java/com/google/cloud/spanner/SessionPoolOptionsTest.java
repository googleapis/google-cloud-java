/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
package com.google.cloud.spanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

/**
 * Unit tests for {@link com.google.cloud.spanner.SessionPoolOptions}
 */
@RunWith(Parameterized.class)
public class SessionPoolOptionsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Parameter
    public int minSessions;
    @Parameter(1)
    public int maxSessions;

    @Parameters(name = "min sessions = {0}, max sessions = {1}")
    public static Collection<Object[]> data() {
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{1, 1});
        params.add(new Object[]{500, 600});
        params.add(new Object[]{600, 500});

        return params;
    }

    @Test
    public void setMinMaxSessions() {
        if (minSessions > maxSessions) {
            expectedException.expect(IllegalArgumentException.class);
        }
        SessionPoolOptions options = SessionPoolOptions.newBuilder()
                .setMinSessions(minSessions)
                .setMaxSessions(maxSessions)
                .build();

        assertEquals(minSessions, options.getMinSessions());
        assertEquals(maxSessions, options.getMaxSessions());
    }
}

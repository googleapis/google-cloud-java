/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static com.google.common.truth.Truth.assertThat;

import com.example.jobs.JobSearchCreateCompany;
import com.example.jobs.JobSearchDeleteCompany;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JobSearchDeleteCompanyTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String TENANT_ID = System.getenv("CTS_TENANT_ID");

  private static final String COMPANY_EXT_ID =
      String.format("COMP_EXT_ID_%s", UUID.randomUUID().toString().substring(0, 20));
  private static final String COMPANY_DISPLAY_NAME = "DO_NOT_DELETE_COMPANY";

  private String companyId;
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = System.out;
    System.setOut(new PrintStream(bout));

    // create a company
    JobSearchCreateCompany.createCompany(
        PROJECT_ID, TENANT_ID, COMPANY_DISPLAY_NAME, COMPANY_EXT_ID);
    String got = bout.toString();
    assertThat(got).contains("Created Company");

    companyId = JobSearchGetJobTest.extractLastId(got.split("\n")[1]);
  }

  @Test
  public void testDeleteCompany() throws IOException {
    // retrieve a tenant.
    JobSearchDeleteCompany.deleteCompany(PROJECT_ID, TENANT_ID, companyId);
    String got = bout.toString();
    assertThat(got).contains("Deleted company");
  }

  @After
  public void tearDown() {
    System.setOut(out);
  }
}

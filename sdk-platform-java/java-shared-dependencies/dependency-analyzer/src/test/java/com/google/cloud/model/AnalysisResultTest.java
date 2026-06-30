package com.google.cloud.model;


import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class AnalysisResultTest {

  @Test
  public void testGenerateReportWithAdvisoriesReturnsFailure()
      throws IllegalArgumentException {
    VersionKey root = VersionKey.from("maven", "com.example:artifact", "1.2.3");
    List<PackageInfo> results = List.of(
        new PackageInfo(
            root,
            List.of(),
            List.of(new Advisory(
                new AdvisoryKey("GHSA-2qrg-x229-3v8q"),
                "https://osv.dev/vulnerability/GHSA-2qrg-x229-3v8q",
                "Deserialization of Untrusted Data in Log4j",
                new String[]{"CVE-2019-17571"},
                9.8,
                "CVSS:3.1/AV:N/AC:L/PR:N/UI:N/S:U/C:H/I:H/A:H"
            ))
        )
    );
    ReportResult result = AnalysisResult.of(results).getAnalysisResult();
    assertEquals(ReportResult.FAIL, result);
  }

  @Test
  public void testGenerateReportWithNonCompliantLicenseReturnsFailure()
      throws IllegalArgumentException {
    VersionKey root = VersionKey.from("maven", "com.example:artifact", "1.2.3");
    List<PackageInfo> results = List.of(
        new PackageInfo(
            root,
            List.of(License.toLicense("BCL")),
            List.of()
        )
    );
    ReportResult result = AnalysisResult.of(results).getAnalysisResult();
    assertEquals(ReportResult.FAIL, result);
  }

  @Test
  public void testGenerateReportWithoutRiskSucceeds()
      throws IllegalArgumentException {
    VersionKey root = VersionKey.from("maven", "com.example:artifact", "1.2.3");
    List<PackageInfo> results = List.of(
        new PackageInfo(
            root,
            List.of(License.toLicense("Apache-2.0")),
            List.of()
        )
    );
    ReportResult result = AnalysisResult.of(results).getAnalysisResult();
    assertEquals(ReportResult.PASS, result);
  }

  @Test
  public void testToStringReturnsNoRiskInformation() {
    VersionKey root = VersionKey.from("maven", "com.example:artifact", "1.2.3");
    List<PackageInfo> results = List.of(
        new PackageInfo(
            root,
            List.of(License.toLicense("Apache-2.0")),
            List.of()
        ),
        new PackageInfo(
            VersionKey.from("maven", "com.example:dependency", "4.5.6"),
            List.of(License.toLicense("Apache-2.0"), License.toLicense("MIT")),
            List.of()
        ),
        new PackageInfo(
            VersionKey.from("maven", "com.example:nested-dependency", "2.3.1"),
            List.of(License.toLicense("Apache-2.0"), License.toLicense("MIT")),
            List.of()
        )
    );
    assertEquals("""
        ## Package information of com.example:artifact:1.2.3
        Licenses: [Apache-2.0 (Google-compliant)]
        Vulnerabilities: [].
        Checked in [com.example:artifact (1.2.3)](https://api.deps.dev/v3/query?versionKey.system=MAVEN&versionKey.name=com.example:artifact&versionKey.version=1.2.3)
                
        ## Dependencies
        ### Package information of com.example:dependency:4.5.6
        Licenses: [Apache-2.0 (Google-compliant), MIT (Google-compliant)]
        Vulnerabilities: [].
        Checked in [com.example:dependency (4.5.6)](https://api.deps.dev/v3/query?versionKey.system=MAVEN&versionKey.name=com.example:dependency&versionKey.version=4.5.6)
                
        ### Package information of com.example:nested-dependency:2.3.1
        Licenses: [Apache-2.0 (Google-compliant), MIT (Google-compliant)]
        Vulnerabilities: [].
        Checked in [com.example:nested-dependency (2.3.1)](https://api.deps.dev/v3/query?versionKey.system=MAVEN&versionKey.name=com.example:nested-dependency&versionKey.version=2.3.1)
                
                
        """, AnalysisResult.of(results).toString());
  }

  @Test
  public void testToStringReturnsRiskInformation() {
    VersionKey root = VersionKey.from("maven", "com.example:artifact", "1.2.3");
    List<PackageInfo> results = List.of(
        new PackageInfo(
            root,
            List.of(License.APACHE_2_0, License.BCL),
            List.of()
        ),
        new PackageInfo(
            VersionKey.from("maven", "com.example:dependency", "4.5.6"),
            List.of(License.MIT),
            List.of(new Advisory(
                new AdvisoryKey("GHSA-2qrg-x229-3v8q"),
                "https://osv.dev/vulnerability/GHSA-2qrg-x229-3v8q",
                "Deserialization of Untrusted Data in Log4j",
                new String[]{"CVE-2019-17571"},
                9.8,
                "CVSS:3.1/AV:N/AC:L/PR:N/UI:N/S:U/C:H/I:H/A:H"
            ))
        ),
        new PackageInfo(
            VersionKey.from("maven", "com.example:nested-dependency", "2.3.1"),
            List.of(License.MIT, License.GL2PS),
            List.of()
        )
    );
    assertEquals("""
        ## Package information of com.example:artifact:1.2.3
        Licenses: [Apache-2.0 (Google-compliant), BCL (Not Google-compliant!)]
        Vulnerabilities: [].
        Checked in [com.example:artifact (1.2.3)](https://api.deps.dev/v3/query?versionKey.system=MAVEN&versionKey.name=com.example:artifact&versionKey.version=1.2.3)
                
        ## Dependencies
        ### Package information of com.example:dependency:4.5.6
        Licenses: [MIT (Google-compliant)]
        Vulnerabilities: [Advisory (id: GHSA-2qrg-x229-3v8q, more info: [Deserialization of Untrusted Data in Log4j](https://osv.dev/vulnerability/GHSA-2qrg-x229-3v8q))].
        Checked in [com.example:dependency (4.5.6)](https://api.deps.dev/v3/query?versionKey.system=MAVEN&versionKey.name=com.example:dependency&versionKey.version=4.5.6)
                
        ### Package information of com.example:nested-dependency:2.3.1
        Licenses: [MIT (Google-compliant), GL2PS (Not Google-compliant!)]
        Vulnerabilities: [].
        Checked in [com.example:nested-dependency (2.3.1)](https://api.deps.dev/v3/query?versionKey.system=MAVEN&versionKey.name=com.example:nested-dependency&versionKey.version=2.3.1)
                
                
        """, AnalysisResult.of(results).toString());
  }
}

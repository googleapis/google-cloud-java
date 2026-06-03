---
name: Bug report
about: Create a report to help us improve

---

Thanks for stopping by to let us know something could be better!

**PLEASE READ**: If you have a support contract with Google, please create an issue in the [support console](https://cloud.google.com/support/) instead of filing on GitHub. This will ensure a timely response. We try to review GitHub issues on a regular basis, however we cannot guarantee an SLO.

Before creating this issue, please run down the following list and make sure you've tried the usual "quick fixes":

  - Search the issues already opened: https://github.com/googleapis/google-cloud-java/issues
  - Check for answers on StackOverflow: http://stackoverflow.com/questions/tagged/google-cloud-platform
  - Refer to the [Google Cloud Java Getting Started guides](https://docs.cloud.google.com/java/getting-started) for common usage patterns and troubleshooting.
  - Verify you are using the latest versions of the Java SDK. If not, is it possible to upgrade? We recommend using the [Libraries-Bom](https://cloud.google.com/java/docs/bom) to manage dependency versions.

To help expedite the resolution of the issue, please fill out as much information as possible. If unable to provide information, please note down why the information is unable to be provided.

## Issue Details

Required: Provide a detailed description of the issue. Any additional information helps with figuring out the issue.

### Example
I am seeing {ISSUE} when running X, Y... after doing Z. This behavior started after the X library upgrade a few weeks ago ...

## Environment

Required: Provide details about your environment. If relevant, please also provide details about your GCP environment. The environment details MUST be filled out.

Provide the relevant details about your environment:

  - OS Type and Version:
  - Java Version and JDK Vendor:
  - (If using GraalVM) GraalVM Version:

(Optional) If deployed on GCP, provide the relevant details about your GCP deployment environment:

  - Project ID:
  - Cloud Services:
  - Deployment Environment (Compute, GKE, Run, etc):

## Dependencies

Required: Provide a list of the dependencies that are being used. If unable to provide the list, please list the relevant libraries shown below. One of the two sections below MUST be filled out.

1. List your application’s dependency versions. Please provide the output of `mvn dependency:tree`, `gradle dependencies`, or your build system.

### Example `mvn dependency:tree` output
```
maven-dependency-plugin:tree

- com.google.cloud:{X}:{Y}

- com.google.auth:{X}:{Y}

...
```

2. Provide the versions of the relevant libraries:
    - Libraries-Bom ([com.google.cloud:libraries-bom](https://central.sonatype.com/artifact/com.google.cloud/libraries-bom)):
      - (If not using Libraries-Bom) Client Libraries:
    - Gax (gax / gax-grpc / gax-httpjson):
    - Auth (google-auth-library-oauth2-http / google-auth-library-credentials):
    - Any other relevant Java SDK dependencies:
      - Google-Http-Java-Client ([com.google.http-client:google-http-client](https://central.sonatype.com/artifact/com.google.http-client/google-http-client)):

## Reproducer

Required: Provide a reproducer and the steps needed to reproduce this issue locally. If unable to provide a reproducer, please provide code snippets to help reproduce the issue. One of the two sections below MUST be filled out.

1. A reproducer is the quickest method to resolve this issue. It could be a test case or a sample application. It is easier for us to troubleshoot the problem and to verify the solution.

Steps to reproduce:

### Example
1. Enable Speech API
2. Upload a .mp4 file to GCS
3. ...
4. See {ERROR}

If unable to provide a reproducer, please provide a reason: ...

2. Provide as many code snippets as possible:

### Example
```java
try (InstancesClient instancesClient = InstancesClient.create()) {
  ...
}
```

## Logs and Stack Trace

Required: Provide logs that showcase the error. This will help show the flow of the application and help narrow down the cause. Additionally, provide a stack trace of the error if possible.

The Java SDK has a troubleshooting [guide](https://github.com/googleapis/google-cloud-java/blob/main/TROUBLESHOOTING.md) for enabling logs. This contains information regarding client-server communication, request and response details, and logging in dependency libraries. If using this guide, please obfuscate any private information (bearer tokens, request and response params, etc).

Additionally, please provide a stack trace of the error seen:

### Example
```
TransportContext.java:347|Fatal (CERTIFICATE_UNKNOWN): PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target (

"throwable" : {

sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target

	at sun.security.validator.PKIXValidator.doBuild(PKIXValidator.java:456)

	at sun.security.validator.PKIXValidator.engineValidate(PKIXValidator.java:323)

...
```

## Behavior

Optional: Any additional information about the behavior of the error is helpful to debug.

Behavioral Questions:

  - When did the issue begin? Is this behavior related to any dependency version upgrade?
  - Is this behavior flaky? Or is this consistently seen in production?
  - Is this behavior related to the volume of data?

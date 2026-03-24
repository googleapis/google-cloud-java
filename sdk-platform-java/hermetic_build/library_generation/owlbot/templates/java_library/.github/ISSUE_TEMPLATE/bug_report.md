---
name: Bug report
about: Create a report to help us improve

---
{% if migrated_split_repo %}
:bus: This library has moved to
[google-cloud-java/{{ metadata['repo']['repo_short'] }}](
https://github.com/googleapis/google-cloud-java/tree/main/{{ metadata['repo']['repo_short'] }}).
This repository will be archived in the future.
{% endif %}
Thanks for stopping by to let us know something could be better!

**PLEASE READ**: If you have a support contract with Google, please create an issue in the [support console](https://cloud.google.com/support/) instead of filing on GitHub. This will ensure a timely response.

Please run down the following list and make sure you've tried the usual "quick fixes":

  - Search the issues already opened: https://github.com/googleapis/{{metadata['repo']['repo_short']}}/issues
  - Check for answers on StackOverflow: http://stackoverflow.com/questions/tagged/google-cloud-platform

If you are still having issues, please include as much information as possible:

#### Environment details

1. Specify the API at the beginning of the title. For example, "BigQuery: ...").
   General, Core, and Other are also allowed as types
2. OS type and version:
3. Java version:
4. {{metadata['repo']['name']}} version(s):

#### Steps to reproduce

  1. ?
  2. ?

#### Code example

```java
// example
```

#### Stack trace
```
Any relevant stacktrace here.
```

#### External references such as API reference guides

- ?

#### Any additional information below


Following these steps guarantees the quickest resolution possible.

Thanks!

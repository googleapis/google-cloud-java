To generate the dashboard from the root directory, run:

```bash
$ cd dashboard
$ mvn clean install
$ mvn exec:java -Dexec.args="-f ../pom.xml"
```

To generate all dashboards (version 0.124.0 and onwards), including the All Versions page, run:

```bash
$ cd dashboard
$ mvn clean install
$ mvn exec:java -Dexec.args="-a com.google.cloud:google-cloud-bom"
```

To run a report, run:

```bash
$ cd dashboard
$ mvn clean install
$ mvn exec:java -Dexec.args="-f ../pom.xml --report"
```
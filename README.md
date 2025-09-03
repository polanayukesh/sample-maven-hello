# Hello Maven (Beginner-Friendly)

A minimal Java 17 + Maven project with JUnit 5 and a Jenkins Pipeline.

## Structure
```
sample-maven-hello/
├─ pom.xml
├─ Jenkinsfile
└─ src
   ├─ main
   │  └─ java
   │     └─ com/example/App.java
   └─ test
      └─ java
         └─ com/example/AppTest.java
```

## Build locally
```bash
# Check Maven & Java
mvn -v
java -version

# Run tests & package
mvn -B clean test package

# Run the app (no external deps)
java -cp target/hello-maven-1.0.0.jar com.example.App

# Or via exec plugin
mvn -q -DskipTests exec:java
```

Expected output:
```
Hello, yukesh!
```

## Common issues
- **Missing POM**: Ensure you run Maven in the folder that contains `pom.xml`.
- **Java version mismatch**: Use JDK 17 or update `<maven.compiler.release>` to your installed JDK.
- **Tests fail**: Read `target/surefire-reports/*.txt` for details.

## Jenkins (Pipeline)
1. In **Manage Jenkins → Global Tool Configuration**, add:
   - Maven installation named `maven-3.9.5` (Install automatically)
   - JDK installation named `jdk-17`
2. Create a **Pipeline job** and point SCM to this repo (so Jenkins finds `Jenkinsfile`),
   or copy the Jenkinsfile content into "Pipeline script".
3. Build. Jenkins will:
   - Check out code
   - Run `mvn clean test package`
   - Publish JUnit results
   - Archive the JAR from `target/`

## Jenkins (Freestyle)
- Configure SCM → Git → your repo URL.
- Add build step: **Invoke top-level Maven targets**
  - Goals: `clean test package`
  - POM: `pom.xml`
- Post-build action: **Archive the artifacts** → `target/*.jar`
- Optional: **Publish JUnit test result report** → `target/surefire-reports/*.xml`

Happy building!

pipeline {
  agent any
  tools {
    maven 'maven-3.9.5'   // Must match name in Global Tool Config
    jdk 'jdk-17'
  }
  options {
    timestamps()
  }
  stages {
    stage('Checkout') {
      steps {
        // If SCM is configured, Jenkins will checkout automatically.
        echo "Workspace: ${env.WORKSPACE}"
        sh 'ls -la'
      }
    }
    stage('Build & Test') {
      steps {
          sh 'mvn -v'
          sh 'mvn -B clean test package'
        }
      post {
        always {
          // Debug: list target directory in Jenkins
          sh 'echo "=== Listing target directory ===" && ls -R target || true'
          
          // Collect test reports (don’t fail if missing)
          junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
      }
    }
    stage('Package Info') {
      steps {
        sh 'echo "Artifacts in target/:" && ls -la target || true'
      }
    }
  }
  post {
    success {
      archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
  }
}

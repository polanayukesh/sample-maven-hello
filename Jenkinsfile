pipeline {
  agent any
  tools {
    maven 'maven-3.9.5'   // Configure this name in Manage Jenkins -> Global Tool Configuration
    jdk 'jdk-17'          // Configure JDK 17 similarly
  }
  options {
    timestamps()
  }
  stages {
    stage('Checkout') {
      steps {
        // If your job is a Pipeline with SCM configured, Jenkins will checkout automatically.
        // If you created a plain Pipeline job without SCM, uncomment the next line and add your repo URL:
        // git url: 'https://github.com/your-user/your-repo.git', branch: 'main'
        echo "Workspace: ${env.WORKSPACE}"
        sh 'ls -la'
      }
    }
    stage('Build & Test') {
      steps {
      ansiColor('xterm'){
        sh 'mvn -v'
        sh 'mvn -B clean test package'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
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

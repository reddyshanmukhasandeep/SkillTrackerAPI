import groovy.json.JsonSlurper;

node {
    stage('checkout') {
        checkout scm
    }

    stage('clean') {
      sh "./mvnw clean"
    }

    stage('packaging') {
        sh "./mvnw verify -Pprod -DskipTests"
        archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
    }
}


pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Code Inspection') {
            steps {
                withCredentials([string(credentialsId: 'sonarqube-token', variable: 'SONAR_TOKEN')]) {
                    sh '''
                        mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922:sonar \
                        -Dsonar.projectKey=leave-service \
                        -Dsonar.projectName=leave-service \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.token="$SONAR_TOKEN" \
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                    '''
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh '''
                    docker build -t leave-service-2024sl70028:latest .
                '''
            }
        }

        stage('Staging Deployment') {
            steps {
                sh '''
                    docker rm -f leave-service-staging || true

                    docker run -d \
                    --name leave-service-staging \
                    -p 8085:8080 \
                    -e APP_ENV=staging \
                    leave-service-2024sl70028:latest

                    sleep 5

                    curl --fail http://localhost:8085/
                '''
            }
        }
    }
}


pipeline {
    agent any

    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$env.PATH"
    }

    stages {
        stage('Info') {
            steps {
                echo "🔧 Environment Info"
                sh 'mvn --version || echo "Maven not available on host"'
                sh 'docker version || echo "Docker not available on host"'
                sh 'java -version || echo "Java not available on host"'

                echo "📦 PATH: $PATH"
                echo "📌 BUILD_NUMBER: $BUILD_NUMBER"
                echo "🆔 BUILD_ID: $BUILD_ID"
                echo "🏷️  BUILD_TAG: $BUILD_TAG"
                echo "🔗 BUILD_URL: $BUILD_URL"
            }
        }

        stage('Build & Test in Docker') {
            steps {
                script {
                    docker.image('maven:3.8.8-eclipse-temurin-17-alpine').inside('-v /root/.m2:/root/.m2') {
                        echo "📦 Building the project..."
                        sh 'mvn clean compile'

                        echo "✅ Running unit tests..."
                        sh 'mvn test'

                        echo "🔁 Running integration tests..."
                        sh 'mvn failsafe:integration-test failsafe:verify'

                        echo "📦 Packaging application..."
                        sh 'mvn package -DskipTests=true'
                    }
                }
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Please check logs."
        }
        always {
            echo "🔁 Pipeline execution finished."
        }
    }
}

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
                echo '🔧 Environment Info'
                sh 'mvn --version'
                sh 'docker version'
                sh 'java -version'
                echo "📦 PATH: $PATH"
                echo "📌 BUILD_NUMBER: $env.BUILD_NUMBER"
                echo "🆔 BUILD_ID: $env.BUILD_ID"
                echo "🏷️  BUILD_TAG: $env.BUILD_TAG"
                echo "🔗 BUILD_URL: $env.BUILD_URL"
            }
        }

        stage('Build & Test in Docker') {
            steps {
                script {
                    docker.image('maven:3.8.7-eclipse-temurin-17').inside('-v $HOME/.m2:/root/.m2') {
                        sh 'mvn clean compile'
                        sh 'mvn test'
                        sh 'mvn verify'
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

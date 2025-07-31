pipeline {
    agent any

    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
        // Do NOT expand variables here in environment PATH, keep it simple or omit PATH here
        // PATH = "$dockerHome/bin:$mavenHome/bin:$env.PATH"  <-- avoid this here
    }

    stages {
        stage('Environment Debug') {
            steps {
                // Construct PATH inside withEnv to access dockerHome and mavenHome properly
                withEnv(["PATH=${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"]) {
                    echo "=== Debug Information ==="
                    echo "dockerHome: ${dockerHome}"
                    echo "mavenHome: ${mavenHome}"
                    sh 'echo "Current PATH: $PATH"'
                    sh 'which mvn || echo "mvn not found in PATH"'
                    sh 'which docker || echo "docker not found in PATH"'
                }
            }
        }

        stage('Checkout') {
            steps {
                withEnv(["PATH=${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"]) {
                    echo "=== Version Checks ==="
                    sh 'mvn --version'
                    sh 'docker version'
                    echo "build"
                    echo "PATH - $PATH"
                    echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                    echo "BUILD_ID - $env.BUILD_ID"
                    echo "BUILD_TAG - $env.BUILD_TAG"
                    echo "BUILD_URL - $env.BUILD_URL"
                }
            }
        }

        stage('Compile') {
            steps {
                withEnv(["PATH=${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"]) {
                    echo "=== Compilation Stage ==="
                    sh "mvn clean compile"
                }
            }
        }

        stage('Test') {
            steps {
                withEnv(["PATH=${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"]) {
                    echo "=== Unit Testing Stage ==="
                    sh "mvn test"
                }
            }
        }

        stage('Integration Test') {
            steps {
                withEnv(["PATH=${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"]) {
                    echo "=== Integration Testing Stage ==="
                    sh "mvn failsafe:integration-test failsafe:verify"
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
            echo "🔁 Pipeline finished."
        }
    }
}

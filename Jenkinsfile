pipeline {
    agent {
        docker {
            image 'maven:3.6.3'
            label '' // Optional: specify if it should run only on agents with a certain label
            args '-v /root/.m2:/root/.m2' // Optional: cache Maven dependencies across builds
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                echo 'Build'
            }
        }
        stage('Test') {
            steps {
                echo 'Test'
            }
        }
        stage('Integration Test') {
            steps {
                echo 'Integration Test'
            }
        }
    }

    post {
        always {
            echo 'I am awesome. I run always.'
        }
        success {
            echo 'I run when you are successful.'
        }
        failure {
            echo 'I run when you fail.'
        }
    }
}

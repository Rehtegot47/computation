pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Rehtegot47/computation.git', branch: 'main'
            }
        }
        stage("Compile") {
                steps {
                    sh "chmod +x gradlew"
                    sh "java -version"
                    sh "./gradlew --version"
                    sh "./gradlew clean"
                    sh "./gradlew compileJava"
            }
        }
        stage("Test") {
                steps {
                    sh "./gradlew test"
            }
        }
    }
}
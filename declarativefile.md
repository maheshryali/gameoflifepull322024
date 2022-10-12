pipeline {
    agent any 
    stages {
        stage ('gitprocess') {
            steps {
            git branch : 'master',
                url : 'https://github.com/maheshryali/game-of-life.git'
                sh 'mvn package'
        }    
        }
    }
}
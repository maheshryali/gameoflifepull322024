pipeline {
    agent any
    stages {
        stage('gameoflife') {
            git branch: 'master',
            url: 'https://github.com/maheshryali/game-of-life.git'
        }
    }
}
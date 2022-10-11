pipeline {
    agent any
    stages {
        stage {
            git branch: 'master',
            url: 'https://github.com/maheshryali/game-of-life.git'
        }
    }
}
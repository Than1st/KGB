class Game{
    fun newGame(nama: String){
        val choice = listOf("Paper", "Rock", "Scissor")
        val cpuChoice = choice.random()
        println("""
            
            ==========================
            GAME SUIT TERMINAL VERSION
            ==========================
        """.trimIndent())
        println("Welcome $nama!")
        println("[Paper, Rock, Scissor]")
        print("$nama choice : ")
        //pilihan user
        var userChoice = readLine()!!
        if (userChoice.isEmpty()){
            println("Pilihan Tidak Boleh Kosong!")
            newGame(nama)
        } else {
            userChoice = userChoice.capitalize()
            var checker = false
            for (u in choice){
                if (userChoice == u){
                    checker = true
                    break
                }
            }
            if (!checker){
                println("Jawaban tidak sesuai dengan peraturan permainan!")
                newGame(nama)
            }
        }
        println("CPU choice : $cpuChoice")
        println("Result :")
        winnerChecker(userChoice, cpuChoice, nama)
        print("Bermain Lagi? y/n : ")
        val playAgain = readLine()!!
        if (playAgain == "y"){
            newGame(nama)
        } else {
            MainMenu().pilihMenu()
        }
    }
    private fun winnerChecker(userChoice: String, cpuChoice: String, nama: String) {
        when (userChoice) {
            "Rock" -> {
                when (cpuChoice) {
                    "Rock" -> {
                        println("DRAW!")
                    }
                    "Paper" -> {
                        println("CPU Win!")
                    }
                    else -> {
                        println("$nama Win!")
                    }
                }
            }
            "Paper" -> {
                when (cpuChoice) {
                    "Paper" -> {
                        println("DRAW!")
                    }
                    "Scissor" -> {
                        println("CPU Win!")
                    }
                    else -> {
                        println("$nama Win!")
                    }
                }
            }
            "Scissor" -> {
                when (cpuChoice) {
                    "Scissor" -> {
                        println("DRAW!")
                    }
                    "Rock" -> {
                        println("CPU Win!")
                    }
                    else -> {
                        println("$nama Win!")
                    }
                }
            }
        }
    }
}
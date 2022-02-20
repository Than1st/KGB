import kotlin.system.exitProcess

var user = mutableListOf<String>()
var pass = mutableListOf<String>()
fun main() {
    MainMenu().pilihMenu()
}
class MainMenu {
    fun pilihMenu(){
        print("""
            Welcome to KGB Game!
            ==========================
            GAME SUIT TERMINAL VERSION
            ==========================
            1. Registration
            2. Login
            3. Registered Account
            4. Exit Game
            
            Pilih Menu (1/2/3/4) : 
        """.trimIndent())
        when (readLine()!!) {
            "1" -> {
                registration()
            }
            "2" -> {
                login()
            }
            "3" -> {
                cekAkun()
            }
            "4" -> {
                exitProcess(0)
            }
            else -> {
                pilihMenu()
            }
        }
    }

    private fun cekAkun() {
        println("\nAkun yang terdaftar")
        if (user.size == 0 && pass.size == 0){
            println("Belum ada akun yang terdaftar!\n")
        } else {
            for ((index, user) in user.withIndex()){
                print("Username : $user\t | Password : ${pass[index]}\n")
            }
            print("\n")

        }
        pilihMenu()
    }

    private fun registration(){
        println("""
            
            ==========================
            GAME SUIT TERMINAL VERSION
            ==========================
        """.trimIndent())
        inputRegistration()
    }

    private fun inputRegistration() {
        println("Registration")
        print("Input Username : ")
        val inputUsername = readLine()!!
        print("Input Password : ")
        val inputPassword = readLine()!!
        print("Re-Input Password : ")
        val checkPassword = readLine()!!
        registValidation(inputUsername, inputPassword, checkPassword)
    }

    private fun registValidation(inputUsername: String, inputPassword: String, checkPassword: String) {
        var userPass = inputPassword
        //memastikan variable tidak kosong
        if (inputUsername.isNotEmpty() && inputPassword.isNotEmpty() && checkPassword.isNotEmpty()){
            //mengecek password dan konfirmasi password sama
            if (inputPassword != checkPassword){
                println("Password tidak sama, Mohon Input Password kembali")
                var isSame = false
                while (!isSame){
                    print("Input Password : ")
                    val inputUserPassword = readLine()!!
                    print("Re-Input Password : ")
                    val checkUserPassword = readLine()!!
                    if (inputUserPassword.isNotEmpty() && checkUserPassword.isNotEmpty()){
                        if (inputUserPassword == checkUserPassword){
                            userPass = inputUserPassword
                            isSame = true
                        } else {
                            println("Password tidak sama, Mohon Input Password kembali")
                        }
                    } else {
                        println("Mohon Lengkapi Form!")
                    }
                }
                println("Berhasil Tambah Akun!\n")
                user.add(inputUsername)
                pass.add(userPass)
                pilihMenu()
            } else {
                user.add(inputUsername)
                pass.add(inputPassword)
                pilihMenu()
            }
        } else {
            println("Registrasi gagal!\nMohon lengkapi semua form")
            inputRegistration()
        }
    }

    private fun login(){
        println("""
            
            ==========================
            GAME SUIT TERMINAL VERSION
            ==========================
        """.trimIndent())
        println("Login")
        inputLogin()
    }

    private fun inputLogin() {
        print("Input Username : ")
        val inputUsername = readLine()!!
        print("Input Password : ")
        val inputPassword = readLine()!!
        cekLogin(inputUsername, inputPassword)
    }

    private fun cekLogin(inputUsername: String, inputPassword: String) {
        var found = false
        if (inputUsername.isNotEmpty() && inputPassword.isNotEmpty()){
            for ((index, user) in user.withIndex()){
                if (inputUsername == user && inputPassword == pass[index]){
                    found = true
                    Game().newGame(user)
                }
            }
            if (!found){
                println("Username/Password tidak ditemukan!")
                inputLogin()
            }
        } else {
            println("Username atau Password tidak boleh kosong")
            inputLogin()
        }
    }

}
package designPatterns.command


fun main() {
    val openCommand = OpenCommand(Application())
    openCommand.execute()

}

interface Command {
    fun execute()
}

class OpenCommand(private val application: Application) : Command {
    override fun execute() {
        val documentName = askUser()
        application.openDocument(documentName)
    }

    private fun askUser(): String {
        return "Head First Design pattern"
    }
}

class Application() {
    fun openDocument(documentName: String) {
        // opening document
    }
}
package designPatterns.visitor


interface Visitor {
    fun visit(node: View)
}

interface Node {
    fun accept(visitor: Visitor)
}

class View : Node {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class DrawingVisitor : Visitor {

    override fun visit(node: View) {
        renderNode(node)
    }

    private fun renderNode(node: View) {
        Skia.renderView(node)
    }
}
object Skia {
    fun renderView(view: View) {
        //use magic stuff to draw view on screen
    }
}

fun main() {
    val visitor = DrawingVisitor()
    val node = View()
    node.accept(visitor)
}


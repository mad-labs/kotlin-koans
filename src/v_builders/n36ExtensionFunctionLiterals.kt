package v_builders

import util.TODO
import util.doc36

fun todoTask36(): Nothing = TODO(
    """
        Task 36.
        Read about extension function literals.
        You can declare `isEven` and `isOdd` as values, that can be called as extension functions.
        Complete the declarations below.
    """,
    documentation = doc36()
)

fun task36(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this % 2 == 0 }
    val isOdd: Int.() -> Boolean = { this % 2 != 0 }

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}

interface Element {
    fun render(builder: StringBuilder, indent: String)
}

class Prop (val name: String = "undefined", val value: String = "undefined") : Element{
    override fun render(builder: StringBuilder, indent: String) {
        builder.append(indent + "\"$name\": \"${value}\"")
    }
}

class Arr (val elements: Array<out String>) : Element{
    override fun render(builder: StringBuilder, indent: String) {
        builder.append(indent + "[\n")
        elements.forEach {
            builder.append(indent + indent + "\"$it\",\n")
        }
        builder.append(indent + "]")

    }
}

class OBJ : Element {
    val properties = arrayListOf<Element>()

    fun prop(name: String, value: String): Prop {
        val prop = Prop(name, value)
        this.properties.add(prop)
        return prop
    }

    fun arr(vararg args: String): Arr{
        val arr = Arr(args)
        this.properties.add(arr)
        return arr
    }

    fun obj(init: OBJ.() -> Unit): OBJ{
        val anObj = OBJ()
        anObj.init()
        this.properties.add(anObj)
        return anObj
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.append(indent + "{\n")
        properties.forEach({
            it.render(builder, indent + "    ")
            builder.append(",\n")
        })
        builder.append(indent + "}")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

fun root(init: OBJ.() -> Unit): OBJ {
    val anObj = OBJ()
    anObj.init()
    return anObj
}

fun main(args: Array<String>) {
    val test =
    root {
        prop("pippo", "1")
        prop("pluto", "2")
        obj {
            prop("paperino", "3")
            prop("topolino", "4")
            arr("1",
                "2",
                "3"
            )
        }
    }
    println(test)
}




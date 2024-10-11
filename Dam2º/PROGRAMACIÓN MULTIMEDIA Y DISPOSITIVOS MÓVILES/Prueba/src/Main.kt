//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val school = listOf("mackerel", "trout", "halibut")
    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.add("sardina")

    /*   school.forEach { println(it) }
       myList.forEach(::println)*/

    println("Los elementos de la lista son:")

    for ((index, element) in myList.withIndex()) {
        if (index == myList.size - 1) {
            print("y $element. ")
        } else if (index != myList.size - 1) {
            print("$element, ")
        }

    }

}